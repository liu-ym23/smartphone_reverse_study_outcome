package com.bytedance.android.shopping.ligo.context;

import kotlin.jvm.internal.Intrinsics;
import w83.c;

/* JADX INFO: loaded from: classes13.dex */
public final class a<T extends w83.c> implements w83.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<T> f176450a;

    @Override // w83.b
    public final Object a() {
        Intrinsics.checkNotNullParameter("room_unique_key", "key");
        return this.f176450a.d("room_unique_key");
    }

    public a(b<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "ligoContext");
        Intrinsics.checkNotNullParameter(r101, "ability");
        this.f176450a = r100;
    }
}
