package com.bytedance.android.livesdk.interactivity.like.utils;

import android.graphics.Bitmap;
import com.bytedance.android.livesdk.message.model.d4;
import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f137730a = null;

    static {
        f137730a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Pair r101 = (Pair) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        int r102 = j.f137731a;
        return j.a((Bitmap) r101.getSecond(), ((d4) r101.getFirst()).a());
    }
}
