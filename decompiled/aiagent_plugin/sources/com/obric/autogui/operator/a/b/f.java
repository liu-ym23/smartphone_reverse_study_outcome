package com.obric.autogui.operator.a.b;

import android.content.Context;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.input.InputTextResult;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: OpTypeText.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends com.obric.autogui.operator.a.a.c {
    private static final String TAG = "Op/TypeText";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f29686b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f29687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.operator.a.c.b f29688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f29689e;

    /* JADX INFO: compiled from: OpTypeText.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OpTypeText.kt */
    public static final class b extends com.obric.autogui.operator.a.a.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f29690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f29691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f29692c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f29690a == r6.f29690a) goto L12;
            return false;
        L12:
            if (o.a(this.f29691b, r6.f29691b) == true) goto L15;
            return false;
        L15:
            if (this.f29692c == r6.f29692c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.f29690a) * 31) + this.f29691b.hashCode()) * 31) + Boolean.hashCode(this.f29692c);
        }

        public String toString() {
            return "Input(abortIfFailed=" + this.f29690a + ", textToType=" + this.f29691b + ", isReplace=" + this.f29692c + ')';
        }

        public /* synthetic */ b(boolean r1, String r2, boolean r3, int r4, d.h.b.h r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = false;
        L6:
            if ((r4 & 4) == 0) goto L8;
            r3 = true;
        L8:
            this(r1, r2, r3);
        }

        @Override // com.obric.autogui.operator.a.a.c.a
        public void a(boolean r1) {
            this.f29690a = r1;
        }

        @Override // com.obric.autogui.operator.a.a.c.a
        public boolean a() {
            return this.f29690a;
        }

        public final String c() {
            return this.f29691b;
        }

        public final boolean d() {
            return this.f29692c;
        }

        public b(boolean r10, String r11, boolean r12) {
            o.e(r11, "textToType");
            super(false, 0, 0, null, 15, null);
            this.f29690a = r10;
            this.f29691b = r11;
            this.f29692c = r12;
        }
    }

    /* JADX INFO: compiled from: OpTypeText.kt */
    @d.c.b.a.f(b = "OpTypeText.kt", c = {98}, d = "setTextViaPlatform", e = "com.obric.autogui.operator.impl.op.OpTypeText")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f29694b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f29695c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f29696d;

        c(f r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29695c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29694b = r3;
            this.f29696d |= Integer.MIN_VALUE;
            return f.a(this.f29695c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f29686b = new a(null);
    }

    public f() {
        this.f29687c = "TypeText";
        this.f29688d = new com.obric.autogui.operator.a.c.b(c(), p.b(new com.obric.autogui.operator.a.c.c[]{new com.obric.autogui.operator.a.c.a.a(AutoActionConfigs.INSTANCE.getBooleanCfg("operator.precheck.type.activity_change.enable", false)), new com.obric.autogui.operator.a.c.a.d.a()}));
        this.f29689e = 3;
    }

    public static final /* synthetic */ Object a(f r2, b r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.operator.a.a.c
    public String c() {
        return this.f29687c;
    }

    @Override // com.obric.autogui.operator.b
    public com.obric.autogui.operator.a.c.b a() {
        return this.f29688d;
    }

    @Override // com.obric.autogui.operator.a.a.c, com.obric.autogui.operator.d
    public boolean b(com.obric.autogui.operator.b.a r3) {
        com.obric.autogui.operator.b.a r4 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "input");
        if (ZeusTransformUtils.instanceOf(r4, b.class) == true) goto L7;
        return false;
    L7:
        return super.b(r4);
    }

    @Override // com.obric.autogui.operator.a.a.c
    public Object a(Context r3, com.obric.autogui.operator.a.a.d r4, d.c.d<? super com.obric.autogui.common.e> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.autogui.common.e> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.a.a.c.a r2 = d();
        if (ZeusTransformUtils.instanceOf(r2, b.class) == false) goto L5;
        b r8 = (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.aiagent.plugin");
    L6:
        if (r8 == null) goto L10;
        return r4.a(r8.c(), r7);
    L10:
        return com.obric.autogui.common.e.f29014b.b("invalid input type");
    L5:
        r8 = null;
        goto L6
    }

    @Override // com.obric.autogui.operator.a.a.c
    public Object d(Context r4, d.c.d<? super com.obric.autogui.common.e> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.autogui.common.e> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.a.a.c.a r8 = d();
        o.a(r8, "null cannot be cast to non-null type com.obric.autogui.operator.impl.op.OpTypeText.Input");
        b r9 = (b) ZeusTransformUtils.preCheckCast(r8, b.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(TAG, " - [OpTypeText] Using PlatformTool. isReplace=" + r9.d());
        return a(r9, r7);
    }

    private final Object a(b r14, d.c.d<? super com.obric.autogui.common.e> r15) {
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r16, c.class, "com.obric.aiagent.plugin");
        if ((r0.f29696d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f29696d -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.f29694b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f29696d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        f this = (f) ZeusTransformUtils.preCheckCast(r0.f29693a, f.class, "com.obric.aiagent.plugin");
        d.o.a(r17);
    L21:
        InputTextResult r18 = (InputTextResult) ZeusTransformUtils.preCheckCast(r17, InputTextResult.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r19 = com.obric.autogui.session.c.f30777a.b();
        if (r18.isOk() == true) goto L33;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - [OpTypeText] - failed to type text via InputConn: " + r18 + '.');
        IAutoActionTrackingApi r5 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r7 = new JSONObject();
        r7.put("typing_success", false);
        r7.put("result", r18.getStatus().name());
        if (r19 == null) goto L26;
        com.obric.autogui.session.c.b.a(r7, r19);
    L26:
        x r1 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r5, "oauto_typing", r7, false, false, null, 28, null);
        if (r19 == null) goto L32;
        r19.c(r19.w() + 1);
        if (r19.w() != this.f29689e) goto L32;
        IAutoActionTrackingApi r4 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r6 = new JSONObject();
        r6.put("exception_type", "input_text_failed");
        r6.put("debug_info", "sessionid =" + r19.b() + ", session_key =" + r19.a());
        x r13 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r4, "technical_bad_case", r6, false, false, null, 28, null);
    L32:
        return com.obric.autogui.common.e.f29014b.b("failed to type text via InputConn: " + r18.getStatus().name());
    L33:
        IAutoActionTrackingApi r8 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r9 = new JSONObject();
        r9.put("typing_success", true);
        if (r19 == null) goto L36;
        com.obric.autogui.session.c.b.a(r9, r19);
    L36:
        x r110 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r8, "oauto_typing", r9, false, false, null, 28, null);
        if (r19 == null) goto L40;
        r19.c(0);
    L40:
        return com.obric.autogui.common.e.f29014b.a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r17);
        AOOperatingSpace r111 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r111 != null) goto L18;
        Loog.INSTANCE.e(TAG, " - [OpTypeText] - no operating space found.");
        return com.obric.autogui.common.e.f29014b.b("no operating space found.");
    L18:
        com.obric.autogui.operator.a.c r10 = com.obric.autogui.operator.a.c.f29713a;
        String r11 = r14.c();
        boolean r112 = r14.d();
        r0.f29693a = this;
        r0.f29696d = 1;
        r17 = r10.a(r111, r11, r112, r0);
        if (r17 != r2) goto L21;
        return r2;
    L7:
        r0 = new c(this, r16);
        goto L8
    }
}
