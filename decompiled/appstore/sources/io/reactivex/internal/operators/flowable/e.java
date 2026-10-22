package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f20639a = null;

    static {
        int[] r10 = new int[BackpressureOverflowStrategy.values().length];
        f20639a = r10;
        r10[BackpressureOverflowStrategy.DROP_LATEST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
    L8:
        f20639a[BackpressureOverflowStrategy.DROP_OLDEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
        return;
    }
}
