package com.bytedance.android.gamecp.business.imagechoose;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class q<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f56098a = null;

    static {
        f56098a = new q();
    }

    public q() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        i.b r101 = (i.b) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.f56086a;
    }
}
