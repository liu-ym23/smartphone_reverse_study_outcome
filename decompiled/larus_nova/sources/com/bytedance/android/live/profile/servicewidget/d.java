package com.bytedance.android.live.profile.servicewidget;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T, R> f86191a = null;

    static {
        f86191a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Function
    public final T apply(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return (T) ((ic6.a) r100);
    }
}
