package com.obric.autogui.common.b;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: ServerSideErrorType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29004a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f29005b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f29006c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f29007d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f29008e = null;
    public static final c f = null;
    public static final c g = null;
    public static final c h = null;
    public static final c i = null;
    public static final c j = null;
    public static final c k = null;
    public static final c l = null;
    public static final c m = null;
    public static final c n = null;
    public static final c o = null;
    public static final c p = null;
    public static final c q = null;
    public static final c r = null;
    public static final c s = null;
    public static final c t = null;
    public static final c u = null;
    public static final c v = null;
    private static final /* synthetic */ c[] y = null;
    private static final /* synthetic */ d.d.a z = null;
    private final int w;
    private final String x;

    /* JADX INFO: compiled from: ServerSideErrorType.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final c a(int r6) {
            c[] r5 = c.values();
            int r0 = r5.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L11;
            c r3 = r5[r2];
            if (r3.a() != r6) goto L7;
            boolean r4 = true;
        L8:
            if (r4 == true) goto L12;
            r2 = r2 + 1;
        L12:
            if (r3 == null) goto L14;
            return r3;
        L14:
            return c.f29005b;
        L7:
            r4 = false;
            goto L8
        L11:
            r3 = null;
            goto L12
        }
    }

    private static final /* synthetic */ c[] b() {
        return new c[]{f29005b, f29006c, f29007d, f29008e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v};
    }

    private c(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.w = r3;
        this.x = r4;
    }

    public final int a() {
        return this.w;
    }

    static {
        f29005b = new c("NotDefined", 0, -1, "DefaultServerError");
        f29006c = new c("CommonSuccess", 1, 0, "success");
        f29007d = new c("CommonUnknown", 2, 999, SensitiveType.UNKNOWN);
        f29008e = new c("CommonInternalError", 3, 1, "internalError");
        f = new c("CommonVersionNotSupported", 4, 2, "VersionNotSupported");
        g = new c("CommonUserNoLogin", 5, 3, "noLogin");
        h = new c("CommonUserNotExist", 6, 4, "UserNotExist");
        i = new c("CommonUserAuthorityDeny", 7, 5, "UserAuthorityDeny");
        j = new c("CommonUserPunished", 8, 6, "Punished");
        k = new c("CommonLackRequiredParams", 9, 7, "LackRequiredParams");
        l = new c("CommonInvalidParams", 10, 8, "InvalidParams");
        m = new c("CommonInvalidResult", 11, 10, "InvalidResult");
        n = new c("CommonInvalidSign", 12, 9, "InvalidSign");
        o = new c("CommonVerifyFailed", 13, 11, "VerifyFailed");
        p = new c("ErrorQueueFull", 14, 51, "QueueFull");
        q = new c("ErrorSessionInvalid", 15, 52, "SessionInvalid");
        r = new c("ErrorTestEnvOnly", 16, 53, "TestEnvOnly");
        s = new c("ErrorModelNameEmpty", 17, 54, "ModelNameEmpty");
        t = new c("ErrorSessionIDEmpty", 18, 55, "SessionIDEmpty");
        u = new c("ErrorModelNameInvalid", 19, 56, "ModelNameInvalid");
        v = new c("ErrorChangePaidQuestionStatus", 20, 57, "ChangePaidQuestionStatus");
        c[] r0 = b();
        y = r0;
        z = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f29004a = new a(null);
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(y.clone(), c[].class, "com.obric.aiagent.plugin");
    }
}
