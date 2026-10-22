package com.obric.autogui.operator.a.b.a.b.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.EventsUtils;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.operator.a.b.a.b.e;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.d;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.s;

/* JADX INFO: compiled from: DeepLinkOpener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.autogui.operator.a.b.a.b.a.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0759a f29450b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Uri f29451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f29452e;
    private final m<String, d<? super com.obric.autogui.operator.a.b.a.c>, Object> f;

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.b.a.b.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DeepLinkOpener.kt */
    public static final class C0759a {
        public /* synthetic */ C0759a(h r1) {
            this();
        }

        private C0759a() {
        }
    }

    /* JADX INFO: compiled from: DeepLinkOpener.kt */
    @f(b = "DeepLinkOpener.kt", c = {46, 55, EventsUtils.FEAT_TYPE_NFC_EVENT, 94}, d = "doOpenAfterPreCheck", e = "com.obric.autogui.operator.impl.op.openapp.opener.intent.DeepLinkOpener")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29454b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29455c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f29456d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f29457e;
        int f;

        b(a r3, d<? super b> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f29457e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29456d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f29457e.c(null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: DeepLinkOpener.kt */
    @f(b = "DeepLinkOpener.kt", c = {ApWakeEvent.ACCELERATING_END}, d = "maybeKillApp", e = "com.obric.autogui.operator.impl.op.openapp.opener.intent.DeepLinkOpener")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f29459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f29460c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f29461d;

        c(a r3, d<? super c> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f29460c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29459b = r3;
            this.f29461d |= Integer.MIN_VALUE;
            return this.f29460c.b(null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f29450b = new C0759a(null);
    }

    public a(Uri r4, String r5, String r6, m<? super String, ? super d<? super com.obric.autogui.operator.a.b.a.c>, ? extends Object> r7) {
        m<String, d<? super com.obric.autogui.operator.a.b.a.c>, Object> r8 = (m) ZeusTransformUtils.wrapperContextForParams(r7, m.class, "com.obric.aiagent.plugin");
        o.e(r4, "link");
        o.e(r8, "fallbackPackageInterceptor");
        Intent r0 = new Intent("android.intent.action.VIEW", r4);
        if (r5 != null) goto L5;
    L10:
        super(r0, r6);
        this.f29451d = r4;
        this.f29452e = r5;
        this.f = r8;
        return;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L7;
        String r1 = r5;
    L8:
        if (r1 == null) goto L10;
        r0.setPackage(r1);
        goto L10
    L7:
        r1 = null;
        goto L8
    }

    @Override // com.obric.autogui.operator.a.b.a.b.d, com.obric.autogui.operator.a.b.a.b.b
    public Object c(Context r27, d<? super com.obric.autogui.operator.a.b.a.c> r28) {
        a r0 = this;
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r27, Context.class, "com.obric.aiagent.plugin");
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r28, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, b.class) == false) goto L7;
        b r5 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin");
        if ((r5.f & Integer.MIN_VALUE) == 0) goto L7;
        r5.f -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.f29456d;
        Object r7 = d.c.a.b.a();
        int r8 = r5.f;
        if (r8 == 0) goto L20;
        if (r8 == 1) goto L19;
        if (r8 == 2) goto L18;
        if (r8 == 3) goto L17;
        if (r8 != 4) goto L16;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r5.f29454b, String.class, "com.obric.aiagent.plugin");
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(r5.f29453a, Context.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
    L47:
        com.obric.autogui.operator.a.b.a.c r9 = (com.obric.autogui.operator.a.b.a.c) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.operator.a.b.a.c.class, "com.obric.aiagent.plugin");
        if (r9.a().c() == false) goto L51;
        Loog.INSTANCE.d("Op-OpenApp/DeepLink", "[DL/3c] successfully opened the desired DL package: " + r1);
        com.obric.autogui.operator.a.b.a.b r16 = com.obric.autogui.operator.a.b.a.b.n;
        String r10 = r3.getString(ZeusTransformUtils.mapRes(R.string.agent_task_open_app_failed_opened_deeplink_desired_package, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_open_app_failed_opened_deeplink_desired_package"));
        o.c(r10, "getString(...)");
        return new com.obric.autogui.operator.a.b.a.c(r16, r10, "opened deeplink desired package", null, r1, false, null, 104, null);
    L51:
        Loog.INSTANCE.d("Op-OpenApp/DeepLink", "[DL/3d] the desired DL package: " + r1 + " cannot be opened");
        return new com.obric.autogui.operator.a.b.a.c(r9.a(), r9.b(), r9.c(), null, null, false, null, 88, null);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        e r11 = (e) ZeusTransformUtils.preCheckCast(r5.f29455c, e.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r5.f29454b, String.class, "com.obric.aiagent.plugin");
        r2 = (Context) ZeusTransformUtils.preCheckCast(r5.f29453a, Context.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
    L39:
        com.obric.autogui.operator.a.b.a.c r13 = (com.obric.autogui.operator.a.b.a.c) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.operator.a.b.a.c.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L43;
        Loog.INSTANCE.w("Op-OpenApp/DeepLink", "[DL/3c] desired package intercepted before open: " + r12);
        return r13;
    L43:
        r5.f29453a = r2;
        r5.f29454b = r12;
        r5.f29455c = null;
        r5.f = 4;
        r6 = r11.a(r2, r5);
        if (r6 != r7) goto L46;
        return r7;
    L46:
        r1 = r12;
        r3 = r2;
        goto L47
    L18:
        com.obric.autogui.operator.a.b.a.c r14 = (com.obric.autogui.operator.a.b.a.c) ZeusTransformUtils.preCheckCast(r5.f29455c, com.obric.autogui.operator.a.b.a.c.class, "com.obric.aiagent.plugin");
        r2 = (Context) ZeusTransformUtils.preCheckCast(r5.f29454b, Context.class, "com.obric.aiagent.plugin");
        a r15 = (a) ZeusTransformUtils.preCheckCast(r5.f29453a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
    L29:
        com.obric.autogui.operator.a.b.a.b r17 = com.obric.autogui.operator.a.b.a.b.o;
        String r18 = r2.getString(ZeusTransformUtils.mapRes(R.string.espe_execute_op_openapp_deeplink, WsChannelMultiProcessSharedProvider.STRING_TYPE, "espe_execute_op_openapp_deeplink"));
        o.c(r18, "getString(...)");
        return new com.obric.autogui.operator.a.b.a.c(r17, r18, "dlOpened=" + r15.f29451d, null, r14.d(), false, null, 72, null);
    L19:
        r2 = (Context) ZeusTransformUtils.preCheckCast(r5.f29454b, Context.class, "com.obric.aiagent.plugin");
        r0 = (a) ZeusTransformUtils.preCheckCast(r5.f29453a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
    L23:
        com.obric.autogui.operator.a.b.a.c r19 = (com.obric.autogui.operator.a.b.a.c) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.operator.a.b.a.c.class, "com.obric.aiagent.plugin");
        if (r19.a().c() == false) goto L31;
        long r20 = AutoActionConfigs.INSTANCE.getLongCfg("operator.openapp.dlnk_opened_delay", 2000);
        Loog.INSTANCE.d("Op-OpenApp/DeepLink", "[DL/3a] opened an DL and delay " + r20 + "ms");
        AOThreadingTools r21 = AOThreadingTools.INSTANCE;
        r5.f29453a = r0;
        r5.f29454b = r2;
        r5.f29455c = r19;
        r5.f = 2;
        if (r21.delayForMillis(r20, r5) != r7) goto L28;
        return r7;
    L28:
        r15 = r0;
        r14 = r19;
        goto L29
    L31:
        r12 = r0.f29452e;
        if (r12 != null) goto L35;
        Loog.INSTANCE.d("Op-OpenApp/DeepLink", "[DL/3b] failed because the DL cannot resolve and no desiredPackageName provided.");
        com.obric.autogui.operator.a.b.a.b r110 = com.obric.autogui.operator.a.b.a.b.m;
        String r22 = r2.getString(ZeusTransformUtils.mapRes(R.string.agent_task_open_app_failed_not_resolved_deeplink, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_open_app_failed_not_resolved_deeplink"));
        o.c(r22, "getString(...)");
        return new com.obric.autogui.operator.a.b.a.c(r110, r22, "unresolved deeplink", null, null, false, null, 88, null);
    L35:
        Loog.INSTANCE.d("Op-OpenApp/DeepLink", "[DL/3] trying to open the desired DL package: " + r12);
        e r23 = new e(r2, r12);
        m<String, d<? super com.obric.autogui.operator.a.b.a.c>, Object> r24 = r0.f;
        r5.f29453a = r2;
        r5.f29454b = r12;
        r5.f29455c = r23;
        r5.f = 3;
        Object r25 = r24.invoke(r12, r5);
        if (r25 != r7) goto L38;
        return r7;
    L38:
        r6 = r25;
        r11 = r23;
        goto L39
    L20:
        d.o.a(r6);
        r5.f29453a = r0;
        r5.f29454b = r2;
        r5.f = 1;
        r6 = super.c(r2, r5);
        if (r6 != r7) goto L23;
        return r7;
    L7:
        r5 = new b(r0, r4);
        goto L8
    }

    @Override // com.obric.autogui.operator.a.b.a.b.b
    public boolean a(com.obric.autogui.operator.a.b.a.b.b.b r3) {
        com.obric.autogui.operator.a.b.a.b.b.b r4 = (com.obric.autogui.operator.a.b.a.b.b.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.operator.a.b.a.b.b.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "preCheck");
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autogui.operator.a.b.a.b.b.c.class) == false) goto L5;
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autogui.operator.a.b.a.b.b.a.class) == false) goto L8;
        return false;
    L8:
        return super.a(r4);
    }

    @Override // com.obric.autogui.operator.a.b.a.b.d, com.obric.autogui.operator.a.b.a.b.a
    public Object b(Context r11, d<? super d.m<Boolean, String>> r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        d r14 = (d) ZeusTransformUtils.wrapperContextForParams(r12, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, c.class) == false) goto L7;
        c r15 = (c) ZeusTransformUtils.preCheckCast(r14, c.class, "com.obric.aiagent.plugin");
        if ((r15.f29461d & Integer.MIN_VALUE) == 0) goto L7;
        r15.f29461d -= Integer.MIN_VALUE;
    L8:
        c r7 = r15;
        Object r16 = r7.f29459b;
        Object r17 = d.c.a.b.a();
        int r0 = r7.f29461d;
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L13;
        a this = (a) ZeusTransformUtils.preCheckCast(r7.f29458a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r16);
    L18:
        return s.a(d.c.b.a.b.a(((Boolean) ZeusTransformUtils.preCheckCast(r16, Boolean.class, "com.obric.aiagent.plugin")).booleanValue()), this.b());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r16);
        IAutoActionPackagesApi r18 = AOPlatformTools.INSTANCE.packages();
        String r3 = b();
        r7.f29458a = this;
        r7.f29461d = 1;
        r16 = IAutoActionPackagesApi.DefaultImpls.killAppAndDelay$default(r18, r3, true, 0, r7, 4, null);
        if (r16 != r17) goto L18;
        return r17;
    L7:
        r15 = new c(this, r14);
        goto L8
    }
}
