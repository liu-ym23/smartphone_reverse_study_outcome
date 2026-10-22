package com.bytedance.bdturing.verify.a;

import android.text.TextUtils;
import com.bytedance.bdturing.BdTuringConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DownSmsRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6645b;

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
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
        return 7;
    }

    public b(String r1, String r2) {
        this.f6644a = r1;
        this.f6645b = r2;
    }

    public /* synthetic */ b(String r3, String r4, int r5, d.h.b.h r6) {
        if ((r5 & 1) == 0) goto L6;
        r3 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.aiagent.plugin");
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.aiagent.plugin");
    L8:
        this(r3, r4);
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public void a(StringBuilder r5) {
        d.h.b.o.d(r5, "queryBuilder");
        com.bytedance.bdturing.utils.d.a(r5, "decision_config", "block-sms");
        com.bytedance.bdturing.utils.d.a(r5, "is_turing", 1);
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(this.f6644a, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L6;
        com.bytedance.bdturing.utils.d.a(r5, "verify_ticket", this.f6644a);
    L6:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(this.f6645b, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L8;
        com.bytedance.bdturing.utils.d.a(r5, "show_mobile", this.f6645b);
    L8:
        com.bytedance.bdturing.utils.d.a(r5, "use_turing_bridge", 1);
        com.bytedance.bdturing.b r4 = com.bytedance.bdturing.b.a();
        d.h.b.o.b(r4, "BdTuring.getInstance()");
        BdTuringConfig r6 = r4.b();
        if (r6 == null) goto L11;
        int r7 = r6.getSmsDigits();
    L12:
        com.bytedance.bdturing.utils.d.a(r5, "use_sms_mode", r7);
        return;
    L11:
        r7 = 0;
        goto L12
    }
}
