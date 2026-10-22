package com.bytedance.android.live.core.utils.rxutils;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class t extends w<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f66378a;

    public t(Function1 r100) {
        this.f66378a = r100;
    }

    @Override // io.reactivex.Observer
    public final void onNext(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
        this.f66378a.invoke(r100);
    }
}
