package com.bytedance.android.livesdk.interactivity.like;

import android.graphics.Bitmap;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class z0<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z0 f137979a = null;

    static {
        f137979a = new z0();
    }

    public z0() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return !r101.isRecycled();
    }
}
