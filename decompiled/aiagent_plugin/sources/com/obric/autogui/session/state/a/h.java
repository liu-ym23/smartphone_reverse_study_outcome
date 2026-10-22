package com.obric.autogui.session.state.a;

import android.os.Bundle;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StateOperating.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends com.obric.autogui.session.state.a implements c {
    private static final String TAG = "S-Operating";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f31239b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DisplayedAppInfo f31240c;

    /* JADX INFO: compiled from: StateOperating.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: StateOperating.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f31241a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f31242b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f31243c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f31244d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f31245e = null;
        public static final b f = null;
        private static final /* synthetic */ b[] h = null;
        private static final /* synthetic */ d.d.a i = null;
        private final int g;

        private static final /* synthetic */ b[] b() {
            return new b[]{f31241a, f31242b, f31243c, f31244d, f31245e, f};
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.g = r3;
        }

        public final int a() {
            return this.g;
        }

        static {
            f31241a = new b("NORMAL", 0, BizStatus.StatusChangedReason.OPERATING_NORMAL);
            f31242b = new b("RESUME_FROM_CLARIFY", 1, 1401);
            f31243c = new b("RESUME_FROM_CALL_USER", 2, BizStatus.StatusChangedReason.OPERATING_RESUME_FROM_CALL_USER);
            f31244d = new b("RESUME_FROM_USER_ADDITION", 3, BizStatus.StatusChangedReason.OPERATING_RESUME_FROM_USER_ADDITION);
            f31245e = new b("RESUME_FROM_MANUAL_OPERATING", 4, BizStatus.StatusChangedReason.OPERATING_RESUME_FROM_MANUAL_OPERATING);
            f = new b("RESUME_FROM_USER_INTERRUPTED", 5, BizStatus.StatusChangedReason.OPERATING_RESUME_FROM_USER_INTERRUPTED);
            b[] r0 = b();
            h = r0;
            i = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(h.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    static {
        f31239b = new a(null);
    }

    public h(com.obric.autogui.session.state.b r9, com.obric.autogui.session.a r10) {
        d.h.b.o.e(r9, "machine");
        d.h.b.o.e(r10, SensitiveType.SESSION);
        super(BizStatus.OPERATING, r10, r9, false, 8, null);
    }

    @Override // com.obric.autogui.session.state.a
    public Object a(com.obric.autogui.session.state.a r8, d.c.d<? super com.obric.autogui.common.e> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r8, this) == true) goto L6;
        a(new BizStatus.StatusChangedReasonStruct(b.f31241a.a(), null, null, null, 14, null));
    L6:
        return com.obric.autogui.common.e.f29014b.a();
    }

    @Override // com.obric.autogui.session.state.a
    public int g() {
        return f().getReason();
    }

    @Override // com.obric.autogui.session.state.a, com.obric.autogui.util.c.a, com.obric.autogui.util.c.b
    public void b(com.obric.autogui.util.c.b r7) {
        com.obric.autogui.util.c.b r8 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "fromState");
        super.b(r8);
        if (ZeusTransformUtils.instanceOf(r8, j.class) == false) goto L6;
        com.obric.autogui.session.c.a.a(d().O(), "ses_prepare", "coldstart", 0, 4, null);
        a(false);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, d.class) == false) goto L10;
        a(true);
        return;
    }

    private final void a(boolean r5) {
        com.obric.autogui.common.e r0 = com.obric.autogui.session.c.f30777a.a(d(), r5);
        if (r0.g() == true) goto L6;
        Loog.INSTANCE.e(TAG, "cannot schedule session; proceed to [Finish]");
        com.obric.autogui.session.state.d.f31396a.a(d(), r0, 3);
        return;
    L6:
        Loog.INSTANCE.i(TAG, "scheduled session (" + d() + ") is about to start (isResumed=" + r5 + ')');
    }

    public final void a(DisplayedAppInfo r4) {
        DisplayedAppInfo r5 = (DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r4, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(TAG, " - [BringTask] task to bring to vd=" + r5);
        this.f31240c = r5;
    }

    public final DisplayedAppInfo a() {
        return this.f31240c;
    }

    @Override // com.obric.autogui.session.state.a
    public Bundle h() {
        Loog.INSTANCE.i(TAG, "getEnteringExtras");
        Bundle r0 = new Bundle();
        boolean r2 = false;
        if ((d().l().getLaunchOrigin() & 240) != 32) goto L5;
        boolean r1 = true;
    L7:
        if (d().l().getLaunchOrigin() != 2) goto L9;
        boolean r4 = true;
    L11:
        if (d().l().isTestRun() == true) goto L13;
    L15:
        boolean r5 = false;
    L16:
        Bundle r6 = d().l().getTaskExtras();
        Boolean r7 = null;
        if (r6 == null) goto L19;
        Object r8 = r6.get("open_player");
    L21:
        if (ZeusTransformUtils.instanceOf(r8, Boolean.class) == false) goto L23;
        r7 = (Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin");
    L23:
        boolean r9 = d.h.b.o.a(r7, true);
        Bundle r10 = d().l().getTaskExtras();
        if (r10 == null) goto L26;
        r10.remove("open_player");
    L26:
        if (r5 == true) goto L30;
        if (r1 == true) goto L29;
        if (r4 == false) goto L30;
    L29:
        if (r9 == true) goto L30;
    L31:
        r0.putBoolean("open_player", r2);
        r0.putString("operating_reason_msg", f().getMsg());
        return r0;
    L30:
        r2 = true;
        goto L31
    L19:
        r8 = null;
        goto L21
    L13:
        if (d().l().m799getTaskType() != null) goto L15;
        r5 = true;
        goto L16
    L9:
        r4 = false;
        goto L11
    L5:
        r1 = false;
        goto L7
    }
}
