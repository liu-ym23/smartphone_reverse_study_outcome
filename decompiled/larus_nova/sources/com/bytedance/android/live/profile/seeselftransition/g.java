package com.bytedance.android.live.profile.seeselftransition;

import android.graphics.BitmapFactory;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f86169a = null;

    static {
        f86169a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        sh6.b r101 = (sh6.b) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return sh6.c.a(BitmapFactory.decodeFile((String) sh6.c.b(r101)));
    }
}
