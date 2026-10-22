package com.bytedance.bdturing.verify.a;

import android.text.TextUtils;
import com.bytedance.bdturing.BdTuringConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: UpSmsRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final class n extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6667c;

    public n() {
        this(null, null, null, 7, null);
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public String f() {
        return "twice_verify";
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public int g() {
        return BdTuringConfig.DEFAULT_EVENT_COUNT;
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public int getType() {
        return 6;
    }

    public n(String r2, String r3, String r4) {
        d.h.b.o.d(r2, "verifyTicket");
        d.h.b.o.d(r3, "channelMobile");
        d.h.b.o.d(r4, "smsContent");
        this.f6665a = r2;
        this.f6666b = r3;
        this.f6667c = r4;
    }

    public /* synthetic */ n(String r2, String r3, String r4, int r5, d.h.b.h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = "";
    L11:
        this(r2, r3, r4);
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public void a(StringBuilder r5) {
        d.h.b.o.d(r5, "queryBuilder");
        com.bytedance.bdturing.utils.d.a(r5, "decision_config", "block-upsms");
        com.bytedance.bdturing.utils.d.a(r5, "is_turing", 1);
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(this.f6665a, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L5;
        com.bytedance.bdturing.utils.d.a(r5, "verify_ticket", this.f6665a);
    L5:
        com.bytedance.bdturing.utils.d.a(r5, "channel_mobile", this.f6666b);
        com.bytedance.bdturing.utils.d.a(r5, "sms_content", this.f6667c);
        com.bytedance.bdturing.utils.d.a(r5, "use_turing_bridge", 1);
        com.bytedance.bdturing.b r4 = com.bytedance.bdturing.b.a();
        d.h.b.o.b(r4, "BdTuring.getInstance()");
        BdTuringConfig r6 = r4.b();
        if (r6 == null) goto L8;
        int r7 = r6.getSmsDigits();
    L9:
        com.bytedance.bdturing.utils.d.a(r5, "use_sms_mode", r7);
        return;
    L8:
        r7 = 0;
        goto L9
    }
}
