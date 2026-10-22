package com.bytedance.android.shopping.collect.yata.ability;

import com.bytedance.android.shopping.collect.util.CollectCommonLog;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements v96.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f172313a;

    public b() {
        this.f172313a = "CollectYataErrorHandler";
    }

    @Override // v96.c
    public final void a(com.bytedance.kmp.ec.yata.common.error.d r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        Lazy r101 = CollectCommonLog.f172289a;
        CollectCommonLog.b(this.f172313a, "onError   code:" + r100.f251398a + "  msg:" + r100.f251399b);
    }
}
