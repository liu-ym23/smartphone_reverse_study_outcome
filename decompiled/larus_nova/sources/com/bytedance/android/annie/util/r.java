package com.bytedance.android.annie.util;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes43.dex */
public final class r<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f40074a;

    public r(Ref.IntRef r100) {
        this.f40074a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Long r101 = (Long) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return Integer.valueOf(this.f40074a.element - ((int) r101.longValue()));
    }
}
