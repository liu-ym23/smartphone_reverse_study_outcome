package com.bytedance.safetyguard.lxc.internal.e.b;

import com.bytedance.safetyguard.lxc.api.sidecar.SidecarAppInfo;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarBrand;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarResult;
import com.bytedance.safetyguard.lxc.internal.e.a.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    private static final String TAG = "DefaultSafetyGuardSidecar";

    public static final /* synthetic */ SidecarAppInfo a(com.bytedance.safetyguard.lxc.internal.e.i.c r0) {
        return b(r0);
    }

    public static final /* synthetic */ SidecarResult a(String r2, com.bytedance.safetyguard.lxc.internal.e.a.m r3, String r4, d.h.a.a r5) {
        return b(r2, r3, r4, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ SidecarResult a(String r0, String r1, com.bytedance.safetyguard.lxc.internal.e.a.m r2, String r3) {
        return b(r0, r1, r2, r3);
    }

    public static final /* synthetic */ e a(Throwable r0) {
        return b(r0);
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.i.d a(v r0, String r1) {
        return b(r0, r1);
    }

    private static final SidecarAppInfo b(com.bytedance.safetyguard.lxc.internal.e.i.c r8) {
        String r1 = r8.a();
        SidecarBrand r2 = r8.c();
        String r3 = r8.d();
        String r4 = r8.e();
        if (r8.d() == null) goto L5;
        boolean r9 = true;
    L7:
        return new SidecarAppInfo(r1, r2, r3, r4, r9, true);
    L5:
        r9 = false;
        goto L7
    }

    static /* synthetic */ SidecarResult a(String r0, String r1, com.bytedance.safetyguard.lxc.internal.e.a.m r2, String r3, int r4, Object r5) {
        if ((r4 & 8) == 0) goto L6;
        r3 = null;
    L6:
        return b(r0, r1, r2, r3);
    }

    private static final SidecarResult b(String r2, String r3, com.bytedance.safetyguard.lxc.internal.e.a.m r4, String r5) {
        com.bytedance.safetyguard.lxc.internal.e.c.g r0 = r4.c();
        if (r0 != null) goto L6;
        return null;
    L6:
        l r1 = l.f10704a;
        String r6 = r4.b();
        if (r6 == null) goto L11;
        r3 = r6;
    L11:
        return r1.a(r2, r3, r0, r5);
    }

    private static final SidecarResult b(String r11, com.bytedance.safetyguard.lxc.internal.e.a.m r12, String r13, d.h.a.a<SidecarResult> r14) {
        d.h.a.a r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.a.class, "com.obric.aiagent.plugin");
        String r0 = null;
        if (r12 == null) goto L5;
        String r2 = r12.a();
    L7:
        if (o.a(r2, "timeout") == true) goto L15;
        if (r12 == null) goto L11;
        r0 = r12.a();
    L11:
        if (o.a(r0, "authorization_timeout") == true) goto L15;
        return (SidecarResult) ZeusTransformUtils.preCheckCast(r15.invoke(), SidecarResult.class, "com.obric.aiagent.plugin");
    L15:
        return m.a(m.f10705a, r11, "authorization_timeout", 408, "OAuth request failed", "restart authorization and complete it before the timeout", r13, null, null, 192, null);
    L5:
        r2 = null;
        goto L7
    }

    private static final e b(Throwable r11) {
        String r1 = null;
        if (ZeusTransformUtils.instanceOf(r11, com.bytedance.safetyguard.lxc.internal.e.a.m.class) == false) goto L5;
        com.bytedance.safetyguard.lxc.internal.e.a.m r0 = (com.bytedance.safetyguard.lxc.internal.e.a.m) ZeusTransformUtils.preCheckCast(r11, com.bytedance.safetyguard.lxc.internal.e.a.m.class, "com.obric.aiagent.plugin");
    L6:
        if (r0 == null) goto L9;
        r1 = r0.a();
    L9:
        if (r1 != null) goto L11;
    L39:
        String r2 = r11.getMessage();
        boolean r7 = false;
        if (r2 != null) goto L42;
    L44:
        boolean r3 = false;
    L45:
        if (r3 == true) goto L30;
        String r4 = r11.getMessage();
        if (r4 != null) goto L50;
    L52:
        boolean r5 = false;
    L53:
        if (r5 == true) goto L38;
        String r6 = r11.getMessage();
        if (r6 != null) goto L58;
    L60:
        boolean r8 = false;
    L61:
        if (r8 == true) goto L34;
        String r12 = r11.getMessage();
        if (r12 != null) goto L66;
    L68:
        if (r7 == true) goto L22;
        String r13 = "authorization_failed";
    L72:
        switch(r13.hashCode()) {
            case -1938273386: goto L91;
            case -1929392607: goto L87;
            case -1454799332: goto L83;
            case -846158145: goto L79;
            case 1747012507: goto L75;
            default: goto L94;
        };
    L94:
        String r9 = "retry login; if app credentials are invalid, re-run configImportApp/configCreateApp";
    L96:
        return new e(r13, r9);
    L75:
        if (r13.equals("authorization_timeout") == false) goto L94;
        r9 = "restart device flow and complete approval before it expires";
        goto L96
    L79:
        if (r13.equals("principal_mismatch") == false) goto L94;
        r9 = "login with the requested principal or call requestGrant for the returned user";
        goto L96
    L83:
        if (r13.equals("device_code_expired") == false) goto L94;
        r9 = "restart device flow to get a new verification URL";
        goto L96
    L87:
        if (r13.equals("authorization_denied") == false) goto L94;
        r9 = "ask the user to approve the requested scopes and retry login";
        goto L96
    L91:
        if (r13.equals("invalid_app_credentials") == false) goto L94;
        r9 = "re-run configImportApp/configCreateApp with valid app credentials";
    L22:
        r13 = "authorization_denied";
        goto L72
    L66:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("denied", CharSequence.class, "com.obric.aiagent.plugin"), true) != true) goto L68;
        r7 = true;
    L34:
        r13 = "device_code_expired";
        goto L72
    L58:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("expired", CharSequence.class, "com.obric.aiagent.plugin"), true) != true) goto L60;
        r8 = true;
    L38:
        r13 = "authorization_timeout";
        goto L72
    L50:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("timed out", CharSequence.class, "com.obric.aiagent.plugin"), true) != true) goto L52;
        r5 = true;
    L30:
        r13 = "principal_mismatch";
        goto L72
    L42:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("principal mismatch", CharSequence.class, "com.obric.aiagent.plugin"), true) != true) goto L44;
        r3 = true;
        goto L45
    L11:
        switch(r1.hashCode()) {
            case -1313911455: goto L36;
            case -847806252: goto L32;
            case -846158145: goto L28;
            case -632018157: goto L24;
            case -444618026: goto L20;
            case 1330404726: goto L17;
            case 1612125279: goto L14;
            default: goto L39;
        };
    L14:
        if (r1.equals("expired_token") == true) goto L34;
    L17:
        if (r1.equals("unauthorized_client") == false) goto L39;
    L26:
        r13 = "invalid_app_credentials";
        goto L72
    L20:
        if (r1.equals("access_denied") == true) goto L22;
    L24:
        if (r1.equals("invalid_client") == true) goto L26;
    L28:
        if (r1.equals("principal_mismatch") == true) goto L30;
    L32:
        if (r1.equals("invalid_grant") == true) goto L34;
    L36:
        if (r1.equals("timeout") == true) goto L38;
    L5:
        r0 = null;
        goto L6
    }

    private static final com.bytedance.safetyguard.lxc.internal.e.i.d b(v r12, String r13) {
        return new com.bytedance.safetyguard.lxc.internal.e.i.d(r13, r12.a(), r12.b(), r12.c(), r12.d(), r12.e(), r12.f(), r12.g());
    }
}
