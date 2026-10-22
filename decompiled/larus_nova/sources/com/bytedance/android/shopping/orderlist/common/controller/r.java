package com.bytedance.android.shopping.orderlist.common.controller;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class r<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f179749a;

    public r(v r100) {
        this.f179749a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        this.f179749a.a();
        r100.onComplete();
    }
}
