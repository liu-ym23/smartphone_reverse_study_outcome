package com.bytedance.android.live.room.share.summersinging;

import android.graphics.Bitmap;
import io.reactivex.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T1, T2, T3, R> implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f100346a = null;

    static {
        f100346a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Function3
    public final Object apply(Object r100, Object r101, Object r102) {
        sh6.b r103 = (sh6.b) r100;
        sh6.b r104 = (sh6.b) r101;
        sh6.b r105 = (sh6.b) r102;
        Intrinsics.checkNotNullParameter(r103, "t1");
        Intrinsics.checkNotNullParameter(r104, "t2");
        Intrinsics.checkNotNullParameter(r105, "t3");
        return new p((Bitmap) sh6.c.b(r103), (Bitmap) sh6.c.b(r104), (Bitmap) sh6.c.b(r105));
    }
}
