package com.bytedance.android.live.soloktv.record;

import java.util.function.Predicate;

/* JADX INFO: loaded from: classes7.dex */
public final class e<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f101454a;

    public e(long r100) {
        this.f101454a = r100;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object r100) {
        if (((eb1.d) r100).a() < this.f101454a) goto L5;
        return true;
    L5:
        return false;
    }
}
