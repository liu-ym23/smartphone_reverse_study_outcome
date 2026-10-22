package com.bytedance.android.live.revenue.common;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class o0 implements ObservableOnSubscribe<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f90910a;

    public o0(Function1 r100) {
        this.f90910a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        this.f90910a.invoke(r100);
    }
}
