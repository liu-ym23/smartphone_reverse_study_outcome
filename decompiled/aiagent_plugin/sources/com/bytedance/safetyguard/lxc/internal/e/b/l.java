package com.bytedance.safetyguard.lxc.internal.e.b;

import com.bytedance.safetyguard.lxc.api.sidecar.SidecarResult;
import com.obric.capabilitykit.entity.app.EntityType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SidecarOAuthErrorMapper.kt */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f10704a = null;

    static {
        f10704a = new l();
    }

    private l() {
    }

    public static /* synthetic */ SidecarResult a(l r0, String r1, String r2, com.bytedance.safetyguard.lxc.internal.e.c.g r3, String r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = null;
    L6:
        return r0.a(r1, r2, r3, r4);
    }

    public final SidecarResult a(String r16, String r17, com.bytedance.safetyguard.lxc.internal.e.c.g r18, String r19) {
        o.e(r16, "type");
        o.e(r17, "operation");
        o.e(r18, "failure");
        int r7 = a(r18);
        m r4 = m.f10705a;
        String r3 = r18.c();
        if (r3 != null) goto L5;
        r3 = a(r17);
    L5:
        String r6 = r3;
        String r5 = r18.d();
        if (r5 != null) goto L9;
        r5 = "OAuth request failed";
    L9:
        return m.a(r4, r16, r6, r7, r5, a(r17, r18, r7), r19, null, r18.b(), 64, null);
    }

    private final int a(com.bytedance.safetyguard.lxc.internal.e.c.g r4) {
        Integer r3 = r4.a();
        if (r3 != null) goto L5;
    L8:
        String r5 = r4.c();
        if (r5 != null) goto L11;
        return EntityType.AUDITORY_RECORDING;
    L11:
        switch(r5.hashCode()) {
            case -1313911455: goto L49;
            case -1046606779: goto L47;
            case -847806252: goto L44;
            case -837157364: goto L41;
            case -632018157: goto L38;
            case -617237321: goto L34;
            case -444618026: goto L30;
            case -294502320: goto L26;
            case 1330404726: goto L23;
            case 1612125279: goto L20;
            case 1747012507: goto L17;
            case 2117379143: goto L14;
            default: goto L59;
        };
    L47:
        r5.equals("malformed_response");
        return EntityType.AUDITORY_RECORDING;
    L59:
        return EntityType.AUDITORY_RECORDING;
    L14:
        if (r5.equals("invalid_request") == false) goto L60;
    L46:
        return 400;
    L60:
        return EntityType.AUDITORY_RECORDING;
    L17:
        if (r5.equals("authorization_timeout") == false) goto L61;
    L51:
        return 408;
    L61:
        return EntityType.AUDITORY_RECORDING;
    L20:
        if (r5.equals("expired_token") == true) goto L46;
        return EntityType.AUDITORY_RECORDING;
    L23:
        if (r5.equals("unauthorized_client") == true) goto L46;
        return EntityType.AUDITORY_RECORDING;
    L26:
        if (r5.equals("network_timeout") == false) goto L64;
        return 504;
    L64:
        return EntityType.AUDITORY_RECORDING;
    L30:
        if (r5.equals("access_denied") == false) goto L65;
        return 403;
    L65:
        return EntityType.AUDITORY_RECORDING;
    L34:
        if (r5.equals("network_error") == false) goto L66;
        return 503;
    L66:
        return EntityType.AUDITORY_RECORDING;
    L38:
        if (r5.equals("invalid_client") == true) goto L46;
        return EntityType.AUDITORY_RECORDING;
    L41:
        if (r5.equals("invalid_scope") == true) goto L46;
        return EntityType.AUDITORY_RECORDING;
    L44:
        if (r5.equals("invalid_grant") == true) goto L46;
        return EntityType.AUDITORY_RECORDING;
    L49:
        if (r5.equals("timeout") == true) goto L51;
        return EntityType.AUDITORY_RECORDING;
    L5:
        if (new d.l.j(200, 299).a(r3.intValue()) == true) goto L8;
        return r3.intValue();
    }

    private final String a(String r6, com.bytedance.safetyguard.lxc.internal.e.c.g r7, int r8) {
        Integer r5 = r7.b();
        if (r5 != null) goto L6;
    L8:
        boolean r2 = false;
        if (r5 == null) goto L15;
        if (r5.intValue() != 20001) goto L15;
    L13:
        boolean r1 = true;
    L21:
        if (r1 == false) goto L24;
    L22:
        boolean r3 = true;
    L30:
        if (r3 == false) goto L33;
    L31:
        boolean r4 = true;
    L39:
        if (r4 == false) goto L42;
    L40:
        boolean r9 = true;
    L48:
        if (r9 == false) goto L51;
        return "check OAuth request construction and SDK version";
    L51:
        if (r5 == null) goto L57;
        if (r5.intValue() != 20002) goto L57;
    L55:
        boolean r10 = true;
    L63:
        if (r10 == false) goto L66;
        return "check or re-import App ID/App Secret and app existence";
    L66:
        if (r5 == null) goto L72;
        if (r5.intValue() != 20008) goto L72;
    L70:
        boolean r11 = true;
    L78:
        if (r11 == false) goto L81;
        return "check user state and log in again";
    L81:
        if (r5 == null) goto L87;
        if (r5.intValue() != 20009) goto L87;
    L85:
        boolean r12 = true;
    L93:
        if (r12 == false) goto L96;
        return "install/enable the app and publish configuration";
    L96:
        if (r5 == null) goto L102;
        if (r5.intValue() != 20010) goto L102;
        return "confirm the user is in the app availability range";
    L102:
        if (r5 == null) goto L108;
        if (r5.intValue() != 20024) goto L108;
        return "clear mismatched credentials and authorize with the current app";
    L108:
        if (r5 == null) goto L114;
        if (r5.intValue() != 20026) goto L114;
    L112:
        boolean r13 = true;
    L120:
        if (r13 == false) goto L123;
    L121:
        boolean r14 = true;
    L129:
        if (r14 == false) goto L132;
        return "restart authorization to obtain a new refresh token";
    L132:
        if (r5 == null) goto L138;
        if (r5.intValue() != 20050) goto L138;
    L136:
        boolean r15 = true;
    L144:
        if (r15 == false) goto L147;
        return "retry with backoff and use logId from logs if persistent";
    L147:
        if (r5 == null) goto L153;
        if (r5.intValue() != 20068) goto L153;
        return "make refresh scope a subset of the original grant";
    L153:
        if (r5 == null) goto L159;
        if (r5.intValue() != 20073) goto L159;
        return "reload a newly saved token, then reauthorize if unavailable";
    L159:
        if (r5 == null) goto L165;
        if (r5.intValue() != 20074) goto L165;
        return "enable refresh user_access_token and publish the app";
    L165:
        if (o.a(r7.c(), "access_denied") == false) goto L168;
        return "ask the user to approve authorization and retry";
    L168:
        if (o.a(r7.c(), "network_error") == false) goto L171;
        return "check network connectivity and retry";
    L171:
        if (o.a(r7.c(), "network_timeout") == false) goto L176;
        if (d.o.o.b(r6, "app-registration", false, 2, null) == false) goto L214;
        return "check network connectivity and retry app creation";
    L214:
        return "check network connectivity and retry";
    L176:
        if (o.a(r7.c(), "authorization_timeout") == false) goto L178;
    L199:
        return "restart authorization and complete it before the timeout";
    L178:
        if (o.a(r7.c(), "timeout") == true) goto L199;
        if (o.a(r7.c(), "malformed_response") == false) goto L184;
        return "retry the operation and update the SDK if the problem persists";
    L184:
        if (r8 != 429) goto L186;
    L198:
        return "retry with backoff";
    L186:
        if (r8 >= 500) goto L198;
        if (400 > r8) goto L192;
        if (r8 >= 500) goto L192;
        r2 = true;
    L192:
        if (r2 == false) goto L195;
        return "check request/app configuration and correlate SDK logs";
    L195:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("authorization", CharSequence.class, "com.obric.aiagent.plugin"), true) == false) goto L197;
        return "retry authorization and correlate SDK logs if the failure persists";
    L197:
        return "retry the OAuth operation and correlate SDK logs if the failure persists";
    L138:
        if (r5 != null) goto L141;
    L143:
        r15 = false;
        goto L144
    L141:
        if (r5.intValue() != 20072) goto L143;
    L123:
        if (r5 != null) goto L126;
    L128:
        r14 = false;
        goto L129
    L126:
        if (r5.intValue() != 20064) goto L128;
    L114:
        if (r5 != null) goto L117;
    L119:
        r13 = false;
        goto L120
    L117:
        if (r5.intValue() != 20037) goto L119;
    L87:
        if (r5 != null) goto L90;
    L92:
        r12 = false;
        goto L93
    L90:
        if (r5.intValue() != 20069) goto L92;
    L72:
        if (r5 != null) goto L75;
    L77:
        r11 = false;
        goto L78
    L75:
        if (r5.intValue() != 20066) goto L77;
    L57:
        if (r5 != null) goto L60;
    L62:
        r10 = false;
        goto L63
    L60:
        if (r5.intValue() != 20048) goto L62;
    L42:
        if (r5 != null) goto L45;
    L47:
        r9 = false;
        goto L48
    L45:
        if (r5.intValue() != 20070) goto L47;
    L33:
        if (r5 != null) goto L36;
    L38:
        r4 = false;
        goto L39
    L36:
        if (r5.intValue() != 20067) goto L38;
    L24:
        if (r5 != null) goto L27;
    L29:
        r3 = false;
        goto L30
    L27:
        if (r5.intValue() != 20063) goto L29;
    L15:
        if (r5 != null) goto L18;
    L20:
        r1 = false;
        goto L21
    L18:
        if (r5.intValue() != 20036) goto L20;
    L6:
        if (r5.intValue() != 20043) goto L8;
        return "check requested scope names and enable the required permissions for the app";
    }

    private final String a(String r3) {
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("timeout", CharSequence.class, "com.obric.aiagent.plugin"), true) == false) goto L5;
        return "authorization_timeout";
    L5:
        return "oauth_request_failed";
    }
}
