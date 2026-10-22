package com.bytedance.android.live.core.utils;

import android.graphics.Bitmap;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class o2<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o2 f66252a = null;

    static {
        f66252a = new o2();
    }

    public o2() {
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Bitmap> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
    }
}
