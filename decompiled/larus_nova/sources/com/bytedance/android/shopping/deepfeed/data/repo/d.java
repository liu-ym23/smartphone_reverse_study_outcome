package com.bytedance.android.shopping.deepfeed.data.repo;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f173191a;

    public d(Function1 r100) {
        this.f173191a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Function1 r101 = this.f173191a;
        r101.invoke((InFeedProductResponse) r100);
    }
}
