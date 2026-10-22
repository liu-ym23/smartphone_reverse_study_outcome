package com.bytedance.android.window.shop.innerflow.holder.element.presenter;

import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerViewExtKt;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes14.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowInnerFlowBarrageElementPresenter f189141a;

    public a(ECWindowInnerFlowBarrageElementPresenter r100) {
        this.f189141a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        RecyclerViewExtKt.smoothScrollBy(this.f189141a.F(), com.bytedance.android.shopping.extensions.b.b(120), 0, new LinearInterpolator(), 2000, false);
    }
}
