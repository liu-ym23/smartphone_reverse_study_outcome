package com.bytedance.android.live.room.share.summersinging;

import android.graphics.Bitmap;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f100352a = null;

    static {
        f100352a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return sh6.c.a(r101);
    }
}
