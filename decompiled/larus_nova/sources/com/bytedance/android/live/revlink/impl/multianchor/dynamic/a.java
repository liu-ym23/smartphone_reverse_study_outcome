package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DynamicUtilsKt$packagePlayStatus$$inlined$also$lambda$1 f93895a;

    public a(DynamicUtilsKt$packagePlayStatus$$inlined$also$lambda$1 r100) {
        this.f93895a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Integer r101 = (Integer) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return e.a(r101.intValue(), this.f93895a.f93849b);
    }
}
