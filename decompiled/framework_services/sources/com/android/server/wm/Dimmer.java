package com.android.server.wm;

import android.graphics.Rect;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceControl;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;

/* JADX INFO: loaded from: classes3.dex */
class Dimmer {
    private static final String TAG = "WindowManagerDimmer";
    final DimmerAnimationHelper.AnimationAdapterFactory mAnimationAdapterFactory;
    DimState mDimState;
    final WindowContainer<?> mHost;

    protected class DimState {
        boolean mAnimateExit;
        private final DimmerAnimationHelper mAnimationHelper;
        final Rect mDimBounds;
        SurfaceControl mDimSurface;
        final WindowContainer<?> mHostContainer;
        private boolean mIsVisible;
        private WindowState mLastDimmingWindow;
        boolean mSkipAnimation;
        final /* synthetic */ Dimmer this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmIsVisible, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9856$$Nest$fgetmIsVisible(DimState r0) {
            return r0.mIsVisible;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLastDimmingWindow, reason: not valid java name */
        static /* bridge */ /* synthetic */ WindowState m9857$$Nest$fgetmLastDimmingWindow(DimState r0) {
            return r0.mLastDimmingWindow;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmLastDimmingWindow, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9858$$Nest$fputmLastDimmingWindow(DimState r0, WindowState r1) {
            r0.mLastDimmingWindow = r1;
        }

        DimState(Dimmer this$0) {
            this.this$0 = this$0;
            this.mSkipAnimation = false;
            this.mAnimateExit = true;
            this.mIsVisible = false;
            this.mDimBounds = new Rect();
            this.mHostContainer = this$0.mHost;
            this.mAnimationHelper = new DimmerAnimationHelper(this$0.mHost, this$0.mAnimationAdapterFactory);
            this.mDimSurface = makeDimLayer();     // Catch: Surface.OutOfResourcesException -> L5
            EventLogTags.writeWmDimCreated(this$0.mHost.getName(), this.mDimSurface.getLayerId());     // Catch: Surface.OutOfResourcesException -> L5
            return;
        L6:
            Log.w(Dimmer.TAG, "OutOfResourcesException creating dim surface");
        }

        void ensureVisible(SurfaceControl.Transaction t) {
            if (this.mIsVisible == true) goto L6;
            t.show(this.mDimSurface);
            t.setAlpha(this.mDimSurface, 0.0f);
            this.mIsVisible = true;
            return;
        }

        void adjustSurfaceLayout(SurfaceControl.Transaction t) {
            t.setPosition(this.mDimSurface, this.mDimBounds.left, this.mDimBounds.top);
            t.setWindowCrop(this.mDimSurface, this.mDimBounds.width(), this.mDimBounds.height());
        }

        void prepareLookChange(float alpha, int blurRadius) {
            this.mAnimationHelper.setRequestedAppearance(alpha, blurRadius);
        }

        void exit(SurfaceControl.Transaction r5) {
            int r0 = this.this$0.mDimState.mDimSurface.getLayerId();
            if (this.this$0.mDimState.mLastDimmingWindow == null) goto L5;
            String r1 = this.this$0.mDimState.mLastDimmingWindow.getName();
        L6:
            boolean r2 = this.this$0.mDimState.mHostContainer.isVisible();
            int r3 = !this.mAnimateExit ? 1 : 0;
            EventLogTags.writeWmDimExit(r0, r1, r2 ? 1 : 0, r3);
            if (this.mAnimateExit == true) goto L9;
            remove(r5);
            return;
        L9:
            this.mAnimationHelper.setExitParameters();
            setReady(r5);
            return;
        L5:
            r1 = "-";
            goto L6
        }

        void remove(SurfaceControl.Transaction t) {
            EventLogTags.writeWmDimCancelAnim(this.mDimSurface.getLayerId(), "ready to remove");
            this.mAnimationHelper.stopCurrentAnimation(this.mDimSurface);
            if (this.mDimSurface.isValid() == false) goto L7;
            EventLogTags.writeWmDimRemoved(this.mDimSurface.getLayerId());
            t.remove(this.mDimSurface);
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_DIMMER_enabled[0] == false) goto L9;
            String protoLogParam0 = String.valueOf(this);
            String protoLogParam1 = String.valueOf(t);
            ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_DIMMER, 7945918822134922801L, 0, new Object[]{protoLogParam0, protoLogParam1});
            return;
        L9:
            return;
        L7:
            Log.w(Dimmer.TAG, "Tried to remove " + this.mDimSurface + " multiple times\n");
        }

        public String toString() {
            return "Dimmer#DimState with host=" + this.mHostContainer + ", surface=" + this.mDimSurface;
        }

        String reasonForRemoving() {
            if (this.mLastDimmingWindow != null) goto L7;
            return " no one is dimming";
        L7:
            return this.mLastDimmingWindow + " is dimming but host " + this.mHostContainer + " is not visibleRequested";
        }

        void prepareReparent(WindowContainer<?> geometryParent, WindowState relativeParent) {
            this.mAnimationHelper.setRequestedRelativeParent(relativeParent);
            this.mAnimationHelper.setRequestedGeometryParent(geometryParent);
        }

        void setReady(SurfaceControl.Transaction t) {
            this.mAnimationHelper.applyChanges(t, this);
        }

        boolean isDimming() {
            if (this.mLastDimmingWindow != null) goto L5;
        L8:
            return false;
        L5:
            if (this.mHostContainer.isVisibleRequested() == false) goto L8;
            return true;
        }

        private SurfaceControl makeDimLayer() {
            return this.this$0.mHost.makeChildSurface(null).setParent(this.this$0.mHost.getSurfaceControl()).setColorLayer().setName("Dim Layer for - " + this.this$0.mHost.getName()).setCallsite("DimLayer.makeDimLayer").build();
        }
    }

    protected Dimmer(WindowContainer<?> host) {
        this(host, new DimmerAnimationHelper.AnimationAdapterFactory());
    }

    Dimmer(WindowContainer host, DimmerAnimationHelper.AnimationAdapterFactory animationFactory) {
        this.mHost = host;
        this.mAnimationAdapterFactory = animationFactory;
    }

    public boolean hostIsTask() {
        if (this.mHost.asTask() == null) goto L5;
        return true;
    L5:
        return false;
    }

    void resetDimStates() {
        if (this.mDimState == null) goto L6;
        DimState.m9858$$Nest$fputmLastDimmingWindow(this.mDimState, null);
        return;
    }

    protected void adjustAppearance(WindowState dimmingContainer, float alpha, int blurRadius) {
        if (this.mHost.isVisibleRequested() == true) goto L6;
        return;
    L6:
        if (this.mDimState == null) goto L8;
    L10:
        DimState d = obtainDimState(dimmingContainer);
        d.prepareLookChange(alpha, blurRadius);
        return;
    L8:
        if (alpha != 0.0f) goto L10;
        if (blurRadius != 0) goto L10;
    }

    public void adjustPosition(WindowContainer<?> geometryParent, WindowState dimmingContainer) {
        if (this.mDimState == null) goto L6;
        this.mDimState.prepareReparent(geometryParent, dimmingContainer);
        return;
    }

    boolean updateDims(SurfaceControl.Transaction t) {
        if (this.mDimState != null) goto L6;
        return false;
    L6:
        if (this.mDimState.isDimming() == true) goto L10;
        this.mDimState.exit(t);
        this.mDimState = null;
        return false;
    L10:
        if (DimState.m9856$$Nest$fgetmIsVisible(this.mDimState) == false) goto L12;
    L18:
        this.mDimState.setReady(t);
        return true;
    L12:
        if (DimState.m9857$$Nest$fgetmLastDimmingWindow(this.mDimState) == null) goto L18;
        if (DimState.m9857$$Nest$fgetmLastDimmingWindow(this.mDimState).mActivityRecord == null) goto L18;
        if (DimState.m9857$$Nest$fgetmLastDimmingWindow(this.mDimState).mActivityRecord.mStartingData == null) goto L18;
        this.mDimState.mSkipAnimation = true;
        goto L18
    }

    boolean hasDimState() {
        if (this.mDimState == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isDimming() {
        if (this.mDimState != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mDimState.isDimming() == false) goto L7;
        return true;
    }

    private DimState obtainDimState(WindowState window) {
        if (this.mDimState != null) goto L5;
        this.mDimState = new DimState(this);
    L5:
        DimState.m9858$$Nest$fputmLastDimmingWindow(this.mDimState, window);
        return this.mDimState;
    }

    SurfaceControl getDimLayer() {
        if (this.mDimState != null) goto L7;
        return null;
    L7:
        return this.mDimState.mDimSurface;
    }

    Rect getDimBounds() {
        if (this.mDimState != null) goto L7;
        return null;
    L7:
        return this.mDimState.mDimBounds;
    }

    void dontAnimateExit() {
        if (this.mDimState == null) goto L6;
        this.mDimState.mAnimateExit = false;
        return;
    }
}
