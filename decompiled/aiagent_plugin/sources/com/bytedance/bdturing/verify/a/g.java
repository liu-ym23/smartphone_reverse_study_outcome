package com.bytedance.bdturing.verify.a;

import com.bytedance.bdturing.BdTuringConfig;

/* JADX INFO: compiled from: ImageRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6654a;

    public g() {
        this(0, 1, null);
    }

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
        return 2;
    }

    public g(int r1) {
        this.f6654a = r1;
    }

    public /* synthetic */ g(int r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        this(r1);
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public void a(StringBuilder r2) {
        d.h.b.o.d(r2, "queryBuilder");
        int r1 = this.f6654a;
        if (r1 == 0) goto L5;
        com.bytedance.bdturing.utils.d.a(r2, "challenge_code", r1);
    L5:
        com.bytedance.bdturing.utils.d.a(r2, "use_dialog_size_v2", com.bytedance.bdturing.setting.h.f6610a.c());
    }
}
