package com.bytedance.android.shopping.pre_purchase.arch.launch;

import com.bytedance.android.shopping.pre_purchase.arch.launch.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class k<I extends j, O extends j> extends g<I, O> {
    public abstract f<O> e(e r100, I r101);

    public k() {
    }

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.i
    public final void a(e r100, I r101) {
        Intrinsics.checkNotNullParameter(r100, "launchContext");
        Intrinsics.checkNotNullParameter(r101, "input");
        c(r100, r101);
        d(r100, e(r100, r101));
    }
}
