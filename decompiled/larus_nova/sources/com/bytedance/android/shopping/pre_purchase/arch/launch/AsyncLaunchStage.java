package com.bytedance.android.shopping.pre_purchase.arch.launch;

import com.bytedance.android.shopping.pre_purchase.arch.launch.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class AsyncLaunchStage<I extends j, O extends j> extends g<I, O> {
    public abstract void e(e r100, I r101, Function1<? super f<? extends O>, Unit> r102);

    public AsyncLaunchStage() {
    }

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.i
    public final void a(final e r100, I r101) {
        Intrinsics.checkNotNullParameter(r100, "launchContext");
        Intrinsics.checkNotNullParameter(r101, "input");
        c(r100, r101);
        e(r100, r101, new AsyncLaunchStage$execute$1(this, r100));
    }
}
