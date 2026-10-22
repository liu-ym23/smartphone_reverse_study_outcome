package com.bytedance.bdturing.verify.a;

import android.text.TextUtils;
import com.bytedance.bdturing.BdTuringConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VoiceSmsRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final class p extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6668a;

    /* JADX WARN: Multi-variable type inference failed */
    public p() {
        this(null, 1, 0 == true ? 1 : 0);
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
        return 13;
    }

    public p(String r2) {
        d.h.b.o.d(r2, "verifyTicket");
        this.f6668a = r2;
    }

    public /* synthetic */ p(String r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "";
    L5:
        this(r1);
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public void a(StringBuilder r4) {
        d.h.b.o.d(r4, "queryBuilder");
        com.bytedance.bdturing.utils.d.a(r4, "decision_config", "mobile_voice_sms_verify");
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(this.f6668a, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L5;
        com.bytedance.bdturing.utils.d.a(r4, "verify_ticket", this.f6668a);
    L5:
        com.bytedance.bdturing.utils.d.a(r4, "use_turing_bridge", 1);
    }
}
