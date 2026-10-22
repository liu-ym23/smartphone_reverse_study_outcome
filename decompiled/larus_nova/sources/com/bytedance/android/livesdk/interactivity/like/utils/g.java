package com.bytedance.android.livesdk.interactivity.like.utils;

import android.graphics.Bitmap;
import com.bytedance.android.livesdk.message.model.d4;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import io.reactivex.functions.BiFunction;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f137728a = null;

    static {
        f137728a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        d4 r102 = (d4) r100;
        Bitmap r103 = (Bitmap) r101;
        Intrinsics.checkNotNullParameter(r102, "detail");
        Intrinsics.checkNotNullParameter(r103, SimplayerImageStrategy.RESULT_BITMAP);
        return new Pair(r102, r103);
    }
}
