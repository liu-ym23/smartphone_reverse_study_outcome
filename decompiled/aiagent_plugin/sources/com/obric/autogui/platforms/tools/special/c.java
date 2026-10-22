package com.obric.autogui.platforms.tools.special;

import android.app.TaskInfo;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.platform.api.app.ObricBackNavigationListener;
import com.obric.aiagent.product.platform.api.notification.ObricToastShowListener;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.special.ActionSystemAnimationMonitor;
import com.obric.autogui.common.api.platform.special.ActionSystemAnimationMonitorKt;
import com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi;
import com.obric.autogui.common.api.platform.special.VDBackNavListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.h;
import d.h.b.o;
import d.n;
import java.util.List;

/* JADX INFO: compiled from: StandardSpecialAPIImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements IAutoActionSpecialApi {
    private static final String TAG = "Std/SpecialApis";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f30581a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.platforms.tools.special.b f30582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private VDBackNavListener f30583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f30584d;

    /* JADX INFO: compiled from: StandardSpecialAPIImpl.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: StandardSpecialAPIImpl.kt */
    public static final class b extends ObricBackNavigationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f30585a;

        b(c r1) {
            this.f30585a = r1;
        }

        @Override // com.obric.aiagent.product.platform.api.app.ObricBackNavigationListener
        public void onBackNavigationStarted() {
            VDBackNavListener r0 = c.a(this.f30585a);
            if (r0 == null) goto L6;
            r0.onVDBackNavigationStarted();
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.app.ObricBackNavigationListener
        public void onBackNavigationDone() {
            VDBackNavListener r0 = c.a(this.f30585a);
            if (r0 == null) goto L6;
            r0.onVDBackNavigationDone();
            return;
        }
    }

    static {
        f30581a = new a(null);
    }

    public c() {
        this.f30582b = new com.obric.autogui.platforms.tools.special.b();
        this.f30584d = new b(this);
    }

    public static final /* synthetic */ VDBackNavListener a(c r0) {
        return r0.f30583c;
    }

    @Override // com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi
    public boolean configureHandUsing(boolean r3) {
        com.obric.autogui.platforms.tools.internal.a.C0812a.f30315a.a(r3);     // Catch: Throwable -> L4
        com.obric.autogui.platforms.tools.internal.a.g.f30334a.a();     // Catch: Throwable -> L4
        return true;
    L4:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to enableCallUser: " + th, th);
        return false;
    }

    @Override // com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi
    public void configureVDBackNavigationListener(VDBackNavListener r6) {
        VDBackNavListener r7 = (VDBackNavListener) ZeusTransformUtils.wrapperContextForParams(r6, VDBackNavListener.class, "com.obric.aiagent.plugin");
        VDBackNavListener r0 = this.f30583c;
        if (r0 != null) goto L6;
        if (r7 == null) goto L12;
        Loog.INSTANCE.d(TAG, "[VDBackNav] Registering listener: " + r7);
        this.f30583c = r7;
        com.obric.autogui.platforms.tools.internal.a.C0812a.f30315a.a((ObricBackNavigationListener) ZeusTransformUtils.preCheckCast(this.f30584d, ObricBackNavigationListener.class, "com.obric.aiagent.plugin"));
        return;
    L12:
        return;
    L6:
        if (r7 != null) goto L9;
        Loog.INSTANCE.d(TAG, "[VDBackNav] Unregister listener.");
        this.f30583c = null;
        com.obric.autogui.platforms.tools.internal.a.C0812a.f30315a.b((ObricBackNavigationListener) ZeusTransformUtils.preCheckCast(this.f30584d, ObricBackNavigationListener.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        if (o.a(r7, r0) == true) goto L15;
        Loog.INSTANCE.d(TAG, "[VDBackNav] Switching listener from " + r0 + " to " + r7);
        this.f30583c = r7;
        return;
    }

    @Override // com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi
    public boolean isAutoImeReady() {
        return com.obric.autogui.platforms.tools.internal.a.h.f30335a.a();
    }

    @Override // com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi
    public Boolean isAutoActionTopActivityInSystemAnimation() {
        return com.obric.autogui.platforms.tools.internal.a.C0812a.f30315a.a();
    }

    @Override // com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi
    public void tryToMuteVD(boolean r1) {
        com.obric.autogui.platforms.tools.internal.a.C0812a.f30315a.b(r1);
    }

    @Override // com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi
    public void reportOAutoEventToCM(int r1, int r2, int r3, String r4) {
        com.obric.autogui.platforms.tools.internal.a.f.f30329a.a(r1, r2, r3, r4);
    }

    @Override // com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi
    public Object awaitScreenShotTick(IAutoActionSpecialApi.ScreenShotTickToken r3, long r4, d<? super IAutoActionSpecialApi.ScreenShotTickResult> r6) {
        d<? super IAutoActionSpecialApi.ScreenShotTickResult> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
        return this.f30582b.a(r3, r4, r7);
    }

    @Override // com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi
    public IAutoActionSpecialApi.ScreenShotTickToken registerScreenShotTick(String r2, int r3, String r4) {
        o.e(r2, "pkg");
        return this.f30582b.a(r2, r3, r4);
    }

    @Override // com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi
    public ActionSystemAnimationMonitor registerActionSystemAnimationMonitor(String r5) {
        o.e(r5, "stepId");
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        c r4 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r6 = n.f(com.obric.autogui.platforms.tools.special.a.f30546a.a(r5));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = n.c(r6);
        if (r2 == null) goto L12;
        Loog.INSTANCE.e(ActionSystemAnimationMonitorKt.RULE_STABILITY_LOG_TAG, "[RuleStability] create monitor failed, stepId=" + r5, r2);
        r6 = null;
    L12:
        return (ActionSystemAnimationMonitor) ZeusTransformUtils.preCheckCast(r6, ActionSystemAnimationMonitor.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        n.a r3 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L7
    }

    @Override // com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi
    public void setOAutoClipdataToUser(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        com.obric.autogui.platforms.tools.internal.a.c.f30318a.a(r1);
    }

    @Override // com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi
    public void clearOAutoPrimaryClip(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        com.obric.autogui.platforms.tools.internal.a.c.f30318a.b(r1);
    }

    @Override // com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi
    public void addOAutoPrimaryClipChangedListener(Context r2, ClipboardManager.OnPrimaryClipChangedListener r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        ClipboardManager.OnPrimaryClipChangedListener r4 = (ClipboardManager.OnPrimaryClipChangedListener) ZeusTransformUtils.wrapperContextForParams(r3, ClipboardManager.OnPrimaryClipChangedListener.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r4, "listener");
        com.obric.autogui.platforms.tools.internal.a.c.f30318a.a(r1, r4);
    }

    @Override // com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi
    public void removeOAutoPrimaryClipChangedListener(Context r2, ClipboardManager.OnPrimaryClipChangedListener r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        ClipboardManager.OnPrimaryClipChangedListener r4 = (ClipboardManager.OnPrimaryClipChangedListener) ZeusTransformUtils.wrapperContextForParams(r3, ClipboardManager.OnPrimaryClipChangedListener.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r4, "listener");
        com.obric.autogui.platforms.tools.internal.a.c.f30318a.b(r1, r4);
    }

    @Override // com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi
    public ClipData getOAutoPrimaryClip(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        return com.obric.autogui.platforms.tools.internal.a.c.f30318a.c(r1);
    }

    @Override // com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi
    public boolean addToastShowListener(ObricToastShowListener r3) {
        o.e(r3, "listener");
        boolean r2 = ObricProductSdk.INSTANCE.platformService().notificationManager().registerToastShowListener(r3);
        if (r2 == true) goto L5;
        Loog.INSTANCE.e(TAG, "[ToastHint] register Toast listener failed");
    L5:
        return r2;
    }

    @Override // com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi
    public boolean removeToastShowListener(ObricToastShowListener r3) {
        o.e(r3, "listener");
        boolean r2 = ObricProductSdk.INSTANCE.platformService().notificationManager().unregisterToastShowListener(r3);
        if (r2 == true) goto L5;
        Loog.INSTANCE.e(TAG, "[ToastHint] unregister Toast listener failed");
    L5:
        return r2;
    }

    @Override // com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi
    public List<TaskInfo> getTasks(int r1, boolean r2, boolean r3, int r4) {
        return com.obric.autogui.platforms.tools.internal.a.b.f30316a.a(r1, r2, r3, r4);
    }

    @Override // com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi
    public boolean removeTask(int r1) {
        return com.obric.autogui.platforms.tools.internal.a.b.f30316a.a(r1);
    }
}
