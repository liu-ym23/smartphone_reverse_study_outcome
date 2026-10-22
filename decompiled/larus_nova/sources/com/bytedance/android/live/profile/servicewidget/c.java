package com.bytedance.android.live.profile.servicewidget;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f86190a = null;

    static {
        f86190a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return r100 instanceof ic6.a;
    }
}
