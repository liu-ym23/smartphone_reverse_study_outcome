package com.bytedance.bdturing.verify.a;

import android.text.TextUtils;
import com.bytedance.bdturing.BdTuringConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EmailRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6646a;

    /* JADX WARN: Multi-variable type inference failed */
    public d() {
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
        return 11;
    }

    public d(String r2) {
        d.h.b.o.d(r2, "verifyTicket");
        this.f6646a = r2;
    }

    public /* synthetic */ d(String r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "";
    L5:
        this(r1);
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public void a(StringBuilder r4) {
        d.h.b.o.d(r4, "queryBuilder");
        com.bytedance.bdturing.utils.d.a(r4, "decision_config", "email_verify");
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(this.f6646a, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L5;
        com.bytedance.bdturing.utils.d.a(r4, "verify_ticket", this.f6646a);
    L5:
        com.bytedance.bdturing.utils.d.a(r4, "is_turing", 1);
        com.bytedance.bdturing.utils.d.a(r4, "use_turing_bridge", 1);
        com.bytedance.bdturing.b r3 = com.bytedance.bdturing.b.a();
        d.h.b.o.b(r3, "BdTuring.getInstance()");
        BdTuringConfig r5 = r3.b();
        if (r5 == null) goto L8;
        int r6 = r5.getEmailDigits();
    L9:
        com.bytedance.bdturing.utils.d.a(r4, "use_email_mode", r6);
        return;
    L8:
        r6 = 0;
        goto L9
    }
}
