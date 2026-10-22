package com.bytedance.bdturing.verify.a;

import android.text.TextUtils;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.bytedance.ttnet.TTNetInit;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: RiskInfoRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f6657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f6659c;

    public k(String r26, String r27) {
        this.f6659c = r27;
        this.f6658b = BdTuringConfig.DEFAULT_EVENT_COUNT;
        JSONObject r4 = new JSONObject(r27);     // Catch: Exception -> L112
        String r1 = r4.optString("region");     // Catch: Exception -> L112
        String r5 = r4.optString("subtype");     // Catch: Exception -> L112
        String r6 = r4.optString("verify_ticket");     // Catch: Exception -> L112
        String r7 = r4.optString("channel_mobile");     // Catch: Exception -> L112
        String r8 = r4.optString("sms_content");     // Catch: Exception -> L112
        String r9 = r4.optString(SensitiveType.MOBILE);     // Catch: Exception -> L112
        String r10 = r4.optString("maxEVS");     // Catch: Exception -> L112
        String r11 = r4.optString("log_id");     // Catch: Exception -> L112
        if (r4.optLong(MonitorConstants.CODE) != OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS) goto L13;
        String r12 = r4.optString("identity_scene");     // Catch: Exception -> L112
        String r13 = r4.optString("flow");     // Catch: Exception -> L112
        d.h.b.o.b(r13, "riskJson.optString(\"flow\")");     // Catch: Exception -> L112
        String r3 = r4.optString("identity_action");     // Catch: Exception -> L112
        d.h.b.o.b(r3, "riskJson.optString(\"identity_action\")");     // Catch: Exception -> L112
        String r14 = r4.optString("detail", "");     // Catch: Exception -> L112
        d.h.b.o.b(r14, "riskJson.optString(\"detail\", \"\")");     // Catch: Exception -> L112
        String r2 = r4.optString("identity_ticket", "");     // Catch: Exception -> L112
        d.h.b.o.b(r2, "riskJson.optString(\"identity_ticket\", \"\")");     // Catch: Exception -> L112
        if (r4.optBoolean("identity_no_need_popups", false) == true) goto L9;
        boolean r22 = true;
    L10:
        d.h.b.o.b(r12, "identityScene");     // Catch: Exception -> L112
        this.f6657a = (a) ZeusTransformUtils.preCheckCast(new f(r12, r13, r3, r14, r2, r22), a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L112
        goto L13
    L9:
        r22 = false;
    L13:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L19;
        d.h.b.o.b(r10, "limitStr");     // Catch: Exception -> L16
        this.f6658b = Integer.parseInt(r10);     // Catch: Exception -> L16
    L17:
        this.f6658b = BdTuringConfig.DEFAULT_EVENT_COUNT;     // Catch: Exception -> L112
    L19:
        if (this.f6657a != null) goto L67;
        d.h.b.h r15 = null;
        if (r5 != null) goto L25;
    L66:
        int r16 = 0;
        this.f6657a = (a) ZeusTransformUtils.preCheckCast(new g(r16, 1, r15), a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L112
        goto L67
    L25:
        switch(r5.hashCode()) {
            case -797498437: goto L64;
            case -135762164: goto L61;
            case 1681: goto L58;
            case 3600: goto L55;
            case 114009: goto L52;
            case 3556653: goto L49;
            case 109526449: goto L46;
            case 112386354: goto L43;
            case 113101810: goto L40;
            case 300626556: goto L37;
            case 307350857: goto L34;
            case 312290780: goto L31;
            case 705104230: goto L28;
            default: goto L66;
        };
    L28:
        if (r5.equals("mobile_up_sms_verify") == false) goto L66;
        d.h.b.o.b(r6, "verifyTicket");     // Catch: Exception -> L112
        d.h.b.o.b(r7, "channelMobile");     // Catch: Exception -> L112
        d.h.b.o.b(r8, "smsContent");     // Catch: Exception -> L112
        this.f6657a = (a) ZeusTransformUtils.preCheckCast(new n(r6, r7, r8), a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L112
        goto L67
    L31:
        if (r5.equals("mobile_sms_verify") == false) goto L66;
        this.f6657a = (a) ZeusTransformUtils.preCheckCast(new b(r6, r9), a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L112
        goto L67
    L34:
        if (r5.equals("mobile_voice_sms_verify") == false) goto L66;
        d.h.b.o.b(r6, "verifyTicket");     // Catch: Exception -> L112
        this.f6657a = (a) ZeusTransformUtils.preCheckCast(new p(r6), a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L112
        goto L67
    L37:
        if (r5.equals("email_verify") == false) goto L66;
        d.h.b.o.b(r6, "verifyTicket");     // Catch: Exception -> L112
        this.f6657a = (a) ZeusTransformUtils.preCheckCast(new d(r6), a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L112
        goto L67
    L40:
        if (r5.equals("whirl") == false) goto L66;
    L59:
        int r17 = 0;
        this.f6657a = (a) ZeusTransformUtils.preCheckCast(new g(r17, 1, r15), a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L112
        goto L67
    L43:
        if (r5.equals("voice") == false) goto L66;
        this.f6657a = (a) ZeusTransformUtils.preCheckCast(new o(), a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L112
        goto L67
    L46:
        if (r5.equals("slide") == false) goto L66;
    L49:
        if (r5.equals("text") == false) goto L66;
    L52:
        if (r5.equals("sms") == false) goto L66;
        this.f6657a = (a) ZeusTransformUtils.preCheckCast(new m(null, false, r26, 3, null), a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L112
        goto L67
    L55:
        if (r5.equals("qa") == false) goto L66;
        this.f6657a = (a) ZeusTransformUtils.preCheckCast(new j(r26), a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L112
        goto L67
    L58:
        if (r5.equals("3d") == false) goto L66;
    L61:
        if (r5.equals("identify") == false) goto L66;
        this.f6657a = (a) ZeusTransformUtils.preCheckCast(new e(null, null, 3, null), a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L112
        goto L67
    L64:
        if (r5.equals("pwd_verify") == false) goto L66;
        d.h.b.o.b(r6, "verifyTicket");     // Catch: Exception -> L112
        this.f6657a = (a) ZeusTransformUtils.preCheckCast(new i(r6), a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L112
    L67:
        a r18 = this.f6657a;     // Catch: Exception -> L112
        if (r18 == null) goto L71;
        d.h.b.o.b(r11, "logId");     // Catch: Exception -> L112
        r18.a(r11);     // Catch: Exception -> L112
    L71:
        d.h.b.o.b(r11, "logId");     // Catch: Exception -> L112
        a(r11);     // Catch: Exception -> L112
        if (r1 == 0) goto L118;
        int r0 = r1.hashCode();     // Catch: Exception -> L112
        if (r0 == 3179) goto L107;
        if (r0 == 3365) goto L102;
        if (r0 == 3668) goto L97;
        if (r0 == 3755) goto L92;
        if (r0 == 97720) goto L87;
        return;
    L87:
        if (r1.equals(TTNetInit.DOMAIN_BOE_KEY) == false) goto L119;
        com.bytedance.bdturing.b r19 = com.bytedance.bdturing.b.a();     // Catch: Exception -> L112
        d.h.b.o.b(r19, "BdTuring.getInstance()");     // Catch: Exception -> L112
        BdTuringConfig r20 = r19.b();     // Catch: Exception -> L112
        if (r20 == null) goto L120;
        r20.setRegionType(BdTuringConfig.b.f6466e);     // Catch: Exception -> L112
        return;
    L120:
        return;
    L119:
        return;
    L92:
        if (r1.equals("va") == false) goto L122;
        com.bytedance.bdturing.b r21 = com.bytedance.bdturing.b.a();     // Catch: Exception -> L112
        d.h.b.o.b(r21, "BdTuring.getInstance()");     // Catch: Exception -> L112
        BdTuringConfig r23 = r21.b();     // Catch: Exception -> L112
        if (r23 == null) goto L123;
        r23.setRegionType(BdTuringConfig.b.f6464c);     // Catch: Exception -> L112
        return;
    L123:
        return;
    L122:
        return;
    L97:
        if (r1.equals("sg") == false) goto L125;
        com.bytedance.bdturing.b r24 = com.bytedance.bdturing.b.a();     // Catch: Exception -> L112
        d.h.b.o.b(r24, "BdTuring.getInstance()");     // Catch: Exception -> L112
        BdTuringConfig r25 = r24.b();     // Catch: Exception -> L112
        if (r25 == null) goto L126;
        r25.setRegionType(BdTuringConfig.b.f6463b);     // Catch: Exception -> L112
        return;
    L126:
        return;
    L125:
        return;
    L102:
        if (r1.equals("in") == false) goto L128;
        com.bytedance.bdturing.b r28 = com.bytedance.bdturing.b.a();     // Catch: Exception -> L112
        d.h.b.o.b(r28, "BdTuring.getInstance()");     // Catch: Exception -> L112
        BdTuringConfig r29 = r28.b();     // Catch: Exception -> L112
        if (r29 == null) goto L129;
        r29.setRegionType(BdTuringConfig.b.f6465d);     // Catch: Exception -> L112
        return;
    L129:
        return;
    L128:
        return;
    L107:
        if (r1.equals("cn") == false) goto L131;
        com.bytedance.bdturing.b r30 = com.bytedance.bdturing.b.a();     // Catch: Exception -> L112
        d.h.b.o.b(r30, "BdTuring.getInstance()");     // Catch: Exception -> L112
        BdTuringConfig r31 = r30.b();     // Catch: Exception -> L112
        if (r31 == null) goto L132;
        r31.setRegionType(BdTuringConfig.b.f6462a);     // Catch: Exception -> L112
        return;
    L132:
        return;
    L131:
        return;
    L118:
        return;
    L112:
        e = move-exception;
        com.bytedance.bdturing.g.a(e);
    }

    public k(String r2) {
        d.h.b.o.d(r2, "riskInfo");
        this(null, r2);
    }

    public final a i() {
        return this.f6657a;
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public void a(boolean r1) {
        a r0 = this.f6657a;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public boolean a() {
        a r0 = this.f6657a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public int getType() {
        a r0 = this.f6657a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getType();
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public int g() {
        return this.f6658b;
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public String f() {
        a r0 = this.f6657a;
        if (r0 == null) goto L7;
        String r1 = r0.f();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return "";
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public void a(StringBuilder r2) {
        d.h.b.o.d(r2, "queryBuilder");
        a r0 = this.f6657a;
        if (r0 == null) goto L5;
        r0.a(r2);
    L5:
        com.bytedance.bdturing.utils.d.a(r2, "verify_data", this.f6659c);
    }
}
