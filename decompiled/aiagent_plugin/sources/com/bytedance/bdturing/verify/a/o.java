package com.bytedance.bdturing.verify.a;

import com.bytedance.bdturing.BdTuringConfig;

/* JADX INFO: compiled from: VoiceRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final class o extends a {
    @Override // com.bytedance.bdturing.verify.a.a
    public String f() {
        return "verify";
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public int g() {
        return BdTuringConfig.DEFAULT_EVENT_COUNT;
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public int getType() {
        return 12;
    }

    public o() {
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public void a(StringBuilder r2) {
        d.h.b.o.d(r2, "queryBuilder");
        com.bytedance.bdturing.utils.d.a(r2, "use_dialog_size_v2", com.bytedance.bdturing.setting.h.f6610a.c());
    }
}
