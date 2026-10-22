package com.android.server.wm;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.IBinder;
import android.os.InputConstants;
import android.view.GestureDetector;
import android.view.InputChannel;
import android.view.InputEvent;
import android.view.InputEventReceiver;
import android.view.InputWindowHandle;
import android.view.MotionEvent;
import android.view.SurfaceControl;
import com.android.server.UiThread;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public class Letterbox {
    static final Rect EMPTY_RECT = null;
    private static final Point ZERO_POINT = null;
    private final AppCompatLetterboxOverrides mAppCompatLetterboxOverrides;
    private final AppCompatReachabilityPolicy mAppCompatReachabilityPolicy;
    private final LetterboxSurface mBottom;
    private final LetterboxSurface mFullWindowSurface;
    private final Rect mInner;
    private final LetterboxSurface mLeft;
    private final Rect mOuter;
    private final LetterboxSurface mRight;
    private final Supplier<SurfaceControl.Builder> mSurfaceControlFactory;
    private final LetterboxSurface[] mSurfaces;
    private final LetterboxSurface mTop;
    private final Supplier<SurfaceControl.Transaction> mTransactionFactory;

    private class DoubleTapListener extends GestureDetector.SimpleOnGestureListener {
        private final WindowManagerService mWmService;
        final /* synthetic */ Letterbox this$0;

        /* synthetic */ DoubleTapListener(Letterbox r1, WindowManagerService r2, LetterboxIA r3) {
            this(r1, r2);
        }

        private DoubleTapListener(Letterbox r1, WindowManagerService wmService) {
            this.this$0 = r1;
            this.mWmService = wmService;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent e) {
            WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L12:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (Letterbox.m10056$$Nest$fgetmOuter(this.this$0).isEmpty() == false) goto L7;
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L12
            WindowManagerService.resetPriorityAfterLockedSection();
            return false;
        L7:
            if (e.getAction() != 1) goto L14;
            Letterbox.m10055$$Nest$fgetmAppCompatReachabilityPolicy(this.this$0).handleDoubleTap((int) e.getRawX(), (int) e.getRawY());     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            WindowManagerService.resetPriorityAfterLockedSection();
            return true;
        }
    }

    private final class InputInterceptor implements Runnable {
        private final InputChannel mClientChannel;
        private final Handler mHandler;
        private final InputEventReceiver mInputEventReceiver;
        private final IBinder mToken;
        private final InputWindowHandle mWindowHandle;
        private final WindowManagerService mWmService;

        /* JADX INFO: renamed from: -$$Nest$fgetmWindowHandle, reason: not valid java name */
        static /* bridge */ /* synthetic */ InputWindowHandle m10058$$Nest$fgetmWindowHandle(InputInterceptor r0) {
            return r0.mWindowHandle;
        }

        InputInterceptor(Letterbox r6, String namePrefix, WindowState win) {
            this.mWmService = win.mWmService;
            this.mHandler = UiThread.getHandler();
            StringBuilder r0 = new StringBuilder();
            r0.append(namePrefix);
            if (win.mActivityRecord == null) goto L5;
            Object r1 = win.mActivityRecord;
        L6:
            r0.append(r1);
            String name = r0.toString();
            this.mClientChannel = this.mWmService.mInputManager.createInputChannel(name);
            this.mInputEventReceiver = new TapEventReceiver(r6, this.mClientChannel, this.mWmService, this.mHandler);
            this.mToken = this.mClientChannel.getToken();
            this.mWindowHandle = new InputWindowHandle(null, win.getDisplayId());
            this.mWindowHandle.name = name;
            this.mWindowHandle.token = this.mToken;
            this.mWindowHandle.layoutParamsType = 2022;
            this.mWindowHandle.dispatchingTimeoutMillis = InputConstants.DEFAULT_DISPATCHING_TIMEOUT_MILLIS;
            this.mWindowHandle.ownerPid = win.mSession.mPid;
            this.mWindowHandle.ownerUid = win.mSession.mUid;
            this.mWindowHandle.scaleFactor = 1.0f;
            this.mWindowHandle.inputConfig = 1028;
            return;
        L5:
            r1 = win;
            goto L6
        }

        void updateTouchableRegion(Rect frame) {
            if (frame.isEmpty() == false) goto L6;
            this.mWindowHandle.token = null;
            return;
        L6:
            InputWindowHandle r0 = this.mWindowHandle;
            r0.token = this.mToken;
            this.mWindowHandle.touchableRegion.set(frame);
            this.mWindowHandle.touchableRegion.translate(-frame.left, -frame.top);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mInputEventReceiver.dispose();
            this.mClientChannel.dispose();
        }

        void dispose() {
            this.mWmService.mInputManager.removeInputChannel(this.mToken);
            this.mHandler.post(this);
        }
    }

    private class LetterboxSurface {
        private Color mColor;
        private boolean mHasWallpaperBackground;
        private InputInterceptor mInputInterceptor;
        private SurfaceControl mInputSurface;
        private final Rect mLayoutFrameGlobal;
        private final Rect mLayoutFrameRelative;
        private SurfaceControl mSurface;
        private final Rect mSurfaceFrameRelative;
        private final String mType;
        final /* synthetic */ Letterbox this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmInputInterceptor, reason: not valid java name */
        static /* bridge */ /* synthetic */ InputInterceptor m10059$$Nest$fgetmInputInterceptor(LetterboxSurface r0) {
            return r0.mInputInterceptor;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLayoutFrameGlobal, reason: not valid java name */
        static /* bridge */ /* synthetic */ Rect m10060$$Nest$fgetmLayoutFrameGlobal(LetterboxSurface r0) {
            return r0.mLayoutFrameGlobal;
        }

        LetterboxSurface(Letterbox r1, String type) {
            this.this$0 = r1;
            this.mSurfaceFrameRelative = new Rect();
            this.mLayoutFrameGlobal = new Rect();
            this.mLayoutFrameRelative = new Rect();
            this.mType = type;
        }

        public void layout(int left, int top, int right, int bottom, Point surfaceOrigin) {
            this.mLayoutFrameGlobal.set(left, top, right, bottom);
            this.mLayoutFrameRelative.set(this.mLayoutFrameGlobal);
            this.mLayoutFrameRelative.offset(-surfaceOrigin.x, -surfaceOrigin.y);
        }

        private void createSurface(SurfaceControl.Transaction t) {
            this.mSurface = ((SurfaceControl.Builder) Letterbox.m10057$$Nest$fgetmSurfaceControlFactory(this.this$0).get()).setName("Letterbox - " + this.mType).setFlags(4).setColorLayer().setCallsite("LetterboxSurface.createSurface").build();
            t.setLayer(this.mSurface, -20000).setColorSpaceAgnostic(this.mSurface, true);
        }

        private void createInputSurface(SurfaceControl.Transaction t) {
            this.mInputSurface = ((SurfaceControl.Builder) Letterbox.m10057$$Nest$fgetmSurfaceControlFactory(this.this$0).get()).setName("LetterboxInput - " + this.mType).setFlags(4).setContainerLayer().setOpaque(true).setCallsite("LetterboxSurface.createInputSurface").build();
            t.setLayer(this.mInputSurface, 50000);
        }

        void attachInput(WindowState windowState) {
            if (this.mInputInterceptor == null) goto L5;
            return;
        L5:
            if (windowState.mDisplayContent == null) goto L10;
            this.mInputInterceptor = new InputInterceptor(this.this$0, "Letterbox_" + this.mType + "_", windowState);
            return;
        }

        void remove(SurfaceControl.Transaction t) {
            if (this.mInputInterceptor == null) goto L6;
            this.mInputInterceptor.dispose();
            this.mInputInterceptor = null;
        L6:
            if (this.mSurface == null) goto L9;
            t.remove(this.mSurface);
        L9:
            if (this.mInputSurface == null) goto L11;
            t.remove(this.mInputSurface);
        L11:
            this.mInputSurface = null;
            this.mSurface = null;
        }

        public int getWidth() {
            return Math.max(0, this.mLayoutFrameGlobal.width());
        }

        public int getHeight() {
            return Math.max(0, this.mLayoutFrameGlobal.height());
        }

        public void applySurfaceChanges(SurfaceControl.Transaction t, SurfaceControl.Transaction inputT) {
            if (needsApplySurfaceChanges() == true) goto L5;
            return;
        L5:
            this.mSurfaceFrameRelative.set(this.mLayoutFrameRelative);
            if (this.mSurfaceFrameRelative.isEmpty() == true) goto L14;
            if (this.mSurface != null) goto L10;
            createSurface(t);
        L10:
            this.mColor = Letterbox.m10054$$Nest$fgetmAppCompatLetterboxOverrides(this.this$0).getLetterboxBackgroundColor();
            t.setColor(this.mSurface, getRgbColorArray());
            setPositionAndCrop(t, this.mSurface);
            this.mHasWallpaperBackground = Letterbox.m10054$$Nest$fgetmAppCompatLetterboxOverrides(this.this$0).hasWallpaperBackgroundForLetterbox();
            updateAlphaAndBlur(t);
            t.show(this.mSurface);
            if (this.mInputSurface == null) goto L19;
            setPositionAndCrop(inputT, this.mInputSurface);
            inputT.setTrustedOverlay(this.mInputSurface, true);
            inputT.show(this.mInputSurface);
        L19:
            SurfaceControl surfaceWithInput = this.mSurface;
            if (surfaceWithInput != null) goto L22;
            return;
        L22:
            if (this.mInputInterceptor == null) goto L26;
            this.mInputInterceptor.updateTouchableRegion(this.mSurfaceFrameRelative);
            inputT.setInputWindowInfo(surfaceWithInput, InputInterceptor.m10058$$Nest$fgetmWindowHandle(this.mInputInterceptor));
            return;
        L26:
            return;
        L14:
            if (this.mSurface == null) goto L17;
            t.hide(this.mSurface);
        L17:
            if (this.mInputSurface == null) goto L19;
            inputT.hide(this.mInputSurface);
            goto L19
        }

        private void setPositionAndCrop(SurfaceControl.Transaction t, SurfaceControl surface) {
            t.setPosition(surface, this.mSurfaceFrameRelative.left, this.mSurfaceFrameRelative.top);
            t.setWindowCrop(surface, this.mSurfaceFrameRelative.width(), this.mSurfaceFrameRelative.height());
        }

        private void updateAlphaAndBlur(SurfaceControl.Transaction t) {
            if (this.mHasWallpaperBackground == true) goto L6;
            t.setAlpha(this.mSurface, 1.0f);
            t.setBackgroundBlurRadius(this.mSurface, 0);
            return;
        L6:
            float alpha = Letterbox.m10054$$Nest$fgetmAppCompatLetterboxOverrides(this.this$0).getLetterboxWallpaperDarkScrimAlpha();
            t.setAlpha(this.mSurface, alpha);
            int blurRadiusPx = Letterbox.m10054$$Nest$fgetmAppCompatLetterboxOverrides(this.this$0).getLetterboxWallpaperBlurRadiusPx();
            if (blurRadiusPx > 0) goto L10;
            t.setBackgroundBlurRadius(this.mSurface, 0);
            return;
        L10:
            t.setBackgroundBlurRadius(this.mSurface, blurRadiusPx);
        }

        private float[] getRgbColorArray() {
            float[] rgbTmpFloat = {this.mColor.red(), this.mColor.green(), this.mColor.blue()};
            return rgbTmpFloat;
        }

        public boolean needsApplySurfaceChanges() {
            if (this.mSurfaceFrameRelative.equals(this.mLayoutFrameRelative) == true) goto L5;
        L12:
            return true;
        L5:
            if (this.mSurfaceFrameRelative.isEmpty() == false) goto L7;
        L11:
            return false;
        L7:
            if (Letterbox.m10054$$Nest$fgetmAppCompatLetterboxOverrides(this.this$0).hasWallpaperBackgroundForLetterbox() != this.mHasWallpaperBackground) goto L12;
            if (Letterbox.m10054$$Nest$fgetmAppCompatLetterboxOverrides(this.this$0).getLetterboxBackgroundColor().equals(this.mColor) == true) goto L11;
            goto L11
        }
    }

    private final class TapEventReceiver extends InputEventReceiver {
        private final GestureDetector mDoubleTapDetector;

        TapEventReceiver(Letterbox r3, InputChannel inputChannel, WindowManagerService wmService, Handler uiHandler) {
            super(inputChannel, uiHandler.getLooper());
            DoubleTapListener doubleTapListener = new DoubleTapListener(r3, wmService, null);
            this.mDoubleTapDetector = new GestureDetector(wmService.mContext, doubleTapListener, uiHandler);
        }

        public void onInputEvent(InputEvent event) {
            MotionEvent motionEvent = (MotionEvent) event;
            finishInputEvent(event, this.mDoubleTapDetector.onTouchEvent(motionEvent));
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppCompatLetterboxOverrides, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppCompatLetterboxOverrides m10054$$Nest$fgetmAppCompatLetterboxOverrides(Letterbox r0) {
        return r0.mAppCompatLetterboxOverrides;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppCompatReachabilityPolicy, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppCompatReachabilityPolicy m10055$$Nest$fgetmAppCompatReachabilityPolicy(Letterbox r0) {
        return r0.mAppCompatReachabilityPolicy;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOuter, reason: not valid java name */
    static /* bridge */ /* synthetic */ Rect m10056$$Nest$fgetmOuter(Letterbox r0) {
        return r0.mOuter;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSurfaceControlFactory, reason: not valid java name */
    static /* bridge */ /* synthetic */ Supplier m10057$$Nest$fgetmSurfaceControlFactory(Letterbox r0) {
        return r0.mSurfaceControlFactory;
    }

    static {
        EMPTY_RECT = new Rect();
        ZERO_POINT = new Point(0, 0);
    }

    public Letterbox(Supplier<SurfaceControl.Builder> surfaceControlFactory, Supplier<SurfaceControl.Transaction> transactionFactory, AppCompatReachabilityPolicy appCompatReachabilityPolicy, AppCompatLetterboxOverrides appCompatLetterboxOverrides) {
        this.mOuter = new Rect();
        this.mInner = new Rect();
        this.mTop = new LetterboxSurface(this, "top");
        this.mLeft = new LetterboxSurface(this, "left");
        this.mBottom = new LetterboxSurface(this, "bottom");
        this.mRight = new LetterboxSurface(this, "right");
        this.mFullWindowSurface = new LetterboxSurface(this, "fullWindow");
        this.mSurfaces = new LetterboxSurface[]{this.mLeft, this.mTop, this.mRight, this.mBottom};
        this.mSurfaceControlFactory = surfaceControlFactory;
        this.mTransactionFactory = transactionFactory;
        this.mAppCompatReachabilityPolicy = appCompatReachabilityPolicy;
        this.mAppCompatLetterboxOverrides = appCompatLetterboxOverrides;
    }

    public void layout(Rect outer, Rect inner, Point surfaceOrigin) {
        this.mOuter.set(outer);
        this.mInner.set(inner);
        this.mTop.layout(outer.left, outer.top, outer.right, inner.top, surfaceOrigin);
        this.mLeft.layout(outer.left, outer.top, inner.left, outer.bottom, surfaceOrigin);
        this.mBottom.layout(outer.left, inner.bottom, outer.right, outer.bottom, surfaceOrigin);
        this.mRight.layout(inner.right, outer.top, outer.right, outer.bottom, surfaceOrigin);
        this.mFullWindowSurface.layout(outer.left, outer.top, outer.right, outer.bottom, surfaceOrigin);
    }

    public Rect getInsets() {
        return new Rect(this.mLeft.getWidth(), this.mTop.getHeight(), this.mRight.getWidth(), this.mBottom.getHeight());
    }

    Rect getInnerFrame() {
        return this.mInner;
    }

    Rect getOuterFrame() {
        return this.mOuter;
    }

    boolean notIntersectsOrFullyContains(Rect rect) {
        int emptyCount = 0;
        int noOverlappingCount = 0;
        LetterboxSurface[] r2 = this.mSurfaces;
        int r3 = r2.length;
        int r5 = 0;
    L4:
        if (r5 >= r3) goto L16;
        LetterboxSurface surface = r2[r5];
        Rect surfaceRect = LetterboxSurface.m10060$$Nest$fgetmLayoutFrameGlobal(surface);
        if (surfaceRect.isEmpty() == false) goto L9;
        emptyCount = emptyCount + 1;
    L14:
        r5 = r5 + 1;
        goto L4
    L9:
        if (Rect.intersects(surfaceRect, rect) == true) goto L12;
        noOverlappingCount = noOverlappingCount + 1;
        goto L14
    L12:
        if (surfaceRect.contains(rect) == false) goto L14;
        return true;
    L16:
        if ((emptyCount + noOverlappingCount) == this.mSurfaces.length) goto L18;
        return false;
    L18:
        return true;
    }

    public void hide() {
        layout(EMPTY_RECT, EMPTY_RECT, ZERO_POINT);
    }

    public void destroy() {
        this.mOuter.setEmpty();
        this.mInner.setEmpty();
        SurfaceControl.Transaction tx = this.mTransactionFactory.get();
        LetterboxSurface[] r1 = this.mSurfaces;
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        LetterboxSurface surface = r1[r3];
        surface.remove(tx);
        r3 = r3 + 1;
        goto L3
    L5:
        this.mFullWindowSurface.remove(tx);
        tx.apply();
    }

    public boolean needsApplySurfaceChanges() {
        if (useFullWindowSurface() == true) goto L5;
        LetterboxSurface[] r0 = this.mSurfaces;
        int r1 = r0.length;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L13;
        LetterboxSurface surface = r0[r3];
        if (surface.needsApplySurfaceChanges() == true) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        return true;
    L13:
        return false;
    L5:
        return this.mFullWindowSurface.needsApplySurfaceChanges();
    }

    public void applySurfaceChanges(SurfaceControl.Transaction t, SurfaceControl.Transaction inputT, WindowState windowState) {
        int r1 = 0;
        if (useFullWindowSurface() == false) goto L8;
        LetterboxSurface[] r0 = this.mSurfaces;
        int r2 = r0.length;
    L5:
        if (r1 >= r2) goto L7;
        r0[r1].remove(t);
        r1 = r1 + 1;
        goto L5
    L7:
        this.mFullWindowSurface.attachInput(windowState);
        this.mFullWindowSurface.applySurfaceChanges(t, inputT);
        return;
    L8:
        this.mFullWindowSurface.remove(t);
        LetterboxSurface[] r3 = this.mSurfaces;
        int r4 = r3.length;
    L10:
        if (r1 >= r4) goto L15;
        LetterboxSurface surface = r3[r1];
        surface.attachInput(windowState);
        surface.applySurfaceChanges(t, inputT);
        r1 = r1 + 1;
        goto L10
    }

    void onMovedToDisplay(int displayId) {
        LetterboxSurface[] r0 = this.mSurfaces;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        LetterboxSurface surface = r0[r2];
        setSurfaceDisplayID(surface, displayId);
        r2 = r2 + 1;
        goto L3
    L5:
        setSurfaceDisplayID(this.mFullWindowSurface, displayId);
    }

    private void setSurfaceDisplayID(LetterboxSurface surface, int displayId) {
        if (LetterboxSurface.m10059$$Nest$fgetmInputInterceptor(surface) == null) goto L6;
        InputInterceptor.m10058$$Nest$fgetmWindowHandle(LetterboxSurface.m10059$$Nest$fgetmInputInterceptor(surface)).displayId = displayId;
        return;
    }

    private boolean useFullWindowSurface() {
        if (this.mAppCompatLetterboxOverrides.shouldLetterboxHaveRoundedCorners() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mAppCompatLetterboxOverrides.hasWallpaperBackgroundForLetterbox() == true) goto L8;
        return false;
    }
}
