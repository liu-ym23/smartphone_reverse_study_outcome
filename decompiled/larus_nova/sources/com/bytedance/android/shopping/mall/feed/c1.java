package com.bytedance.android.shopping.mall.feed;

import android.content.Context;
import com.bytedance.android.ec.hybrid.card.service.ECLynxAnnieXService;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes13.dex */
public final class c1<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f176875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f176876b;

    public c1(Context r100) {
        this.f176875a = r100;
        this.f176876b = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        if (ECLynxAnnieXService.b() == false) goto L5;
        new ECMallFeedPreloadTask4AnnieX(this.f176875a, this.f176876b).run();
        return;
    L5:
        new ECMallFeedPreloadTask4LynxCard(this.f176875a, this.f176876b).run();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
