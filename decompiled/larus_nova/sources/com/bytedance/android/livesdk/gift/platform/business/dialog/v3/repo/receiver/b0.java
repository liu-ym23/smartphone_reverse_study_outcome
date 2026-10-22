package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observable<T> f128454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f128455b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b0) == false) goto L10;
        b0 r101 = (b0) r100;
        if (Intrinsics.areEqual(this.f128454a, r101.f128454a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f128455b, r101.f128455b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Observable<T> r100 = this.f128454a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function0<Unit> r104 = this.f128455b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ObservableWidthDispose(observable=" + this.f128454a + ", onDispose=" + this.f128455b + ")";
    }

    public b0(BehaviorSubject r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r101, "onDispose");
        this.f128454a = r100;
        this.f128455b = r101;
    }
}
