package com.bytedance.android.shopping.widget.ecvideoplayer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f extends j {
    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.j
    public final void a() {
        int r100 = a.f187394a;
        StringBuilder r101 = new StringBuilder("PlayerTaskExecutor");
        k r102 = this.f187407a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("playerTaskExecutor");
    L5:
        r101.append(r102.hashCode());
        r101.append(" run ");
        r101.append(b());
        a.a(r101.toString());
    }

    public f(int r100) {
        super(r100);
    }
}
