package com.bytedance.android.livesdk.gamesticker.hok;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f125586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f125587b;

    public b(long r100, long r101) {
        this.f125586a = r100;
        this.f125587b = r101;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        Long r101 = (Long) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        long r102 = r101.longValue();
        long r103 = this.f125586a;
        if (r102 == r103) goto L8;
        long r104 = this.f125587b + r103;
        if (r101.longValue() == r104) goto L8;
        return false;
    L8:
        return true;
    }
}
