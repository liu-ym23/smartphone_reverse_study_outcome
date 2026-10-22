package com.bytedance.android.shopping.store.hybridproduct.module;

import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes14.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f185143a;

    public k(Function1 r100) {
        this.f185143a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        dm.a.a("ECShopMemberCardPresenter").a("applyCoupon：" + r101);
        Function1 r102 = this.f185143a;
        if (r102 == null) goto L5;
        Unit r103 = (Unit) r102.invoke(r101);
    L5:
        EnsureManager.ensureNotReachHere(r101);
    }
}
