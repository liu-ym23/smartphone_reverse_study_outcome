package com.bytedance.android.livesdk.livecommerce.promotionlist.repository;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f151107a;

    public a(Function1 r100) {
        this.f151107a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Function1 r101 = this.f151107a;
        r101.invoke((vj2.b) r100);
    }
}
