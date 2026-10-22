package com.bytedance.android.gamecp.business.imagechoose;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class p<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f56097a;

    public p(i r100) {
        this.f56097a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        i.b r101 = (i.b) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        i.a(this.f56097a, "upload", r101);
        return r101;
    }
}
