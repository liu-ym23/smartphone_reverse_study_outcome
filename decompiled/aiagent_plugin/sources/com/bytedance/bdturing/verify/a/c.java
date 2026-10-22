package com.bytedance.bdturing.verify.a;

import com.bytedance.bdturing.BdTuringConfig;

/* JADX INFO: compiled from: EcafRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c extends a {
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
        return 9;
    }

    public c() {
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public void a(StringBuilder r2) {
        d.h.b.o.d(r2, "queryBuilder");
        com.bytedance.bdturing.utils.d.a(r2, "decision_config", "block-face");
        com.bytedance.bdturing.utils.d.a(r2, "use_turing_bridge", 1);
    }
}
