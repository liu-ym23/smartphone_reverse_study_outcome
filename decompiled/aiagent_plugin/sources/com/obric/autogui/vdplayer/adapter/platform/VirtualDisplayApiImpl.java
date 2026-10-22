package com.obric.autogui.vdplayer.adapter.platform;

import android.content.Context;
import android.view.MotionEvent;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.space.handusing.HandUsingEventsCallback;
import com.obric.autogui.common.api.space.monitor.DisplayHost;
import com.obric.autogui.common.api.space.monitor.OperatingSpaceMonitor;
import com.obric.autogui.common.api.space.status.SpaceStatus;
import com.obric.autogui.common.api.space.status.SpaceStatusCallback;
import com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: VirtualDisplayApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class VirtualDisplayApiImpl implements IVirtualDisplayApi {
    public static final a Companion = null;
    private static final String TAG = "VirtualDisplayApiImpl";
    private final c displayCallback;
    private d.h.a.b<? super Boolean, x> secureListener;
    private d.h.a.b<? super Integer, x> statusBarListener;

    /* JADX INFO: compiled from: VirtualDisplayApiImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayApiImpl.kt */
    public static final class b implements OperatingSpaceMonitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DisplayHost f31672a;

        b(DisplayHost r1) {
            this.f31672a = r1;
        }

        @Override // com.obric.autogui.common.api.space.monitor.OperatingSpaceMonitor
        public DisplayHost getHost() {
            return this.f31672a;
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayApiImpl.kt */
    public static final class c implements SpaceStatusCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VirtualDisplayApiImpl f31673a;

        c(VirtualDisplayApiImpl r1) {
            this.f31673a = r1;
        }

        @Override // com.obric.autogui.common.api.space.status.SpaceStatusCallback
        public void onSecureChanged(boolean r4) {
            Loog.INSTANCE.i(VirtualDisplayApiImpl.TAG, "[SecureState] Notify listener; secure=" + r4);
            d.h.a.b r3 = VirtualDisplayApiImpl.access$getSecureListener$p(this.f31673a);
            if (r3 == null) goto L6;
            r3.invoke(Boolean.valueOf(r4));
            return;
        }

        @Override // com.obric.autogui.common.api.space.status.SpaceStatusCallback
        public void onStatusBarAppearanceChanged(int r1) {
            d.h.a.b r0 = VirtualDisplayApiImpl.access$getStatusBarListener$p(this.f31673a);
            if (r0 == null) goto L6;
            r0.invoke(Integer.valueOf(r1));
            return;
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayApiImpl.kt */
    public static final class d implements HandUsingEventsCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IVirtualDisplayApi.b f31674a;

        d(IVirtualDisplayApi.b r3) {
            this.f31674a = (IVirtualDisplayApi.b) ZeusTransformUtils.wrapperContextForParams(r3, IVirtualDisplayApi.b.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.autogui.common.api.space.handusing.HandUsingEventsCallback
        public void onSurfaceViewTouched() {
            this.f31674a.a();
        }

        @Override // com.obric.autogui.common.api.space.handusing.HandUsingEventsCallback
        public void onSurfaceViewTouchEnded() {
            this.f31674a.b();
        }

        @Override // com.obric.autogui.common.api.space.handusing.HandUsingEventsCallback
        public void onSurfaceViewTouchCanceled() {
            this.f31674a.c();
        }

        @Override // com.obric.autogui.common.api.space.handusing.HandUsingEventsCallback
        public void onSurfaceViewOriginTouchEvent(MotionEvent r2) {
            o.e(r2, "e");
            this.f31674a.a(r2);
        }

        @Override // com.obric.autogui.common.api.platform.special.VDBackNavListener
        public void onVDBackNavigationStarted() {
            this.f31674a.e();
        }

        @Override // com.obric.autogui.common.api.platform.special.VDBackNavListener
        public void onVDBackNavigationDone() {
            this.f31674a.d();
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayApiImpl.kt */
    public static final class e implements OperatingSpaceMonitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DisplayHost f31675a;

        e(DisplayHost r1) {
            this.f31675a = r1;
        }

        @Override // com.obric.autogui.common.api.space.monitor.OperatingSpaceMonitor
        public DisplayHost getHost() {
            return this.f31675a;
        }
    }

    static {
        Companion = new a(null);
    }

    public VirtualDisplayApiImpl() {
        this.displayCallback = new c(this);
    }

    public static final /* synthetic */ d.h.a.b access$getSecureListener$p(VirtualDisplayApiImpl r0) {
        return r0.secureListener;
    }

    public static final /* synthetic */ d.h.a.b access$getStatusBarListener$p(VirtualDisplayApiImpl r0) {
        return r0.statusBarListener;
    }

    @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi
    public void bind(DisplayHost r3) {
        o.e(r3, "host");
        OperatingSpaceManager.INSTANCE.attachMonitor((OperatingSpaceMonitor) ZeusTransformUtils.preCheckCast(new b(r3), OperatingSpaceMonitor.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi
    public void unbind(DisplayHost r3) {
        o.e(r3, "host");
        OperatingSpaceManager.INSTANCE.detachMonitor((OperatingSpaceMonitor) ZeusTransformUtils.preCheckCast(new e(r3), OperatingSpaceMonitor.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi
    public void mute(boolean r1) {
        OperatingSpaceManager.INSTANCE.setMuted(r1);
    }

    @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi
    public void registerSecureChangedListener(d.h.a.b<? super Boolean, x> r3) {
        this.secureListener = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        ensureCallbackRegistered();
    }

    @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi
    public void registerStatusBarAppearanceListener(d.h.a.b<? super Integer, x> r3) {
        this.statusBarListener = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        ensureCallbackRegistered();
    }

    private final void ensureCallbackRegistered() {
        OperatingSpaceManager.INSTANCE.configureStatusListening((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (SpaceStatusCallback) ZeusTransformUtils.preCheckCast(this.displayCallback, SpaceStatusCallback.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi
    public int getStatusBarAppearance() {
        AOOperatingSpace r0 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r0 == null) goto L7;
        SpaceStatus r1 = r0.getSpaceStatus();
        if (r1 == null) goto L7;
        return r1.getStatusBarAppearance();
    L7:
        return 8;
    }

    @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi
    public void unregisterListeners() {
        this.secureListener = null;
        this.statusBarListener = null;
        OperatingSpaceManager.INSTANCE.configureStatusListening((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), null);
    }

    @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi
    public int getCurrentRotation() {
        AOOperatingSpace r0 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r0 == null) goto L9;
        SpaceStatus r1 = r0.getSpaceStatus();
        if (r1 == null) goto L9;
        DisplayAccessor.Rotation r2 = r1.getRotation();
        if (r2 == null) goto L9;
    L11:
        return r2.getEnumValue();
    L9:
        r2 = DisplayAccessor.Rotation.Rotation0;
        goto L11
    }

    @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi
    public boolean getIsSecureLayer() {
        AOOperatingSpace r2 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r2 == null) goto L10;
        SpaceStatus r3 = r2.getSpaceStatus();
        if (r3 == null) goto L10;
        if (r3.isSecure() != true) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi
    public IVirtualDisplayApi.a getSecureCoverHint() {
        return IVirtualDisplayApi.a.f31710a;
    }

    @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi
    public boolean enableCallUser(boolean r4, DisplayHost r5, IVirtualDisplayApi.b r6) {
        IVirtualDisplayApi.b r3 = (IVirtualDisplayApi.b) ZeusTransformUtils.wrapperContextForParams(r6, IVirtualDisplayApi.b.class, "com.obric.aiagent.plugin");
        o.e(r5, "host");
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContextOrNull(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L6;
        Loog.INSTANCE.e(TAG, "enableCallUser: appContext is null, skip configureHandUsing; enable=" + r4);
        return false;
    L6:
        if (r3 == null) goto L8;
        d r1 = new d(r3);
    L10:
        return OperatingSpaceManager.INSTANCE.configureHandUsing(r7, r4, r5, (HandUsingEventsCallback) ZeusTransformUtils.preCheckCast(r1, HandUsingEventsCallback.class, "com.obric.aiagent.plugin")).isSuccess();
    L8:
        r1 = null;
        goto L10
    }
}
