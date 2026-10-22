package com.bytedance.android.shopping.collect.function.base;

import com.bytedance.android.shopping.collect.util.CollectCommonLog;
import io.reactivex.functions.Action;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f172221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f172222b;

    public b(long r100, Function1 r101) {
        this.f172221a = r100;
        this.f172222b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        Lazy r100 = CollectCommonLog.f172289a;
        CollectCommonLog.c("CollectSelfFun-selfDelay", "delay " + this.f172221a + " success");
        Function1 r101 = this.f172222b;
        int r102 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r101.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }
}
