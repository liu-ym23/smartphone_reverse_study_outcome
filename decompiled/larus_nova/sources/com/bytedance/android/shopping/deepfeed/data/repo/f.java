package com.bytedance.android.shopping.deepfeed.data.repo;

import he3.y0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f173193a;

    public f(Function1 r100) {
        this.f173193a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Function1 r101 = this.f173193a;
        r101.invoke((y0) r100);
    }
}
