package com.bytedance.android.anya;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.anya.internal.b f41609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<m, Map<Object, ? extends j<?>>, Unit> f41610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f41611c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f0) == false) goto L12;
        f0 r101 = (f0) r100;
        if (Intrinsics.areEqual(this.f41609a, r101.f41609a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f41610b, r101.f41610b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f41611c, r101.f41611c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.anya.internal.b r100 = this.f41609a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function2<m, Map<Object, ? extends j<?>>, Unit> r104 = this.f41610b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Function0<Unit> r107 = this.f41611c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MutateExternalCallback(executor=" + this.f41609a + ", callback=" + this.f41610b + ", batchDiffCallback=" + this.f41611c + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f0(com.bytedance.android.anya.internal.b r100, Function2<? super m, ? super Map<Object, ? extends j<?>>, Unit> r101, Function0<Unit> r102) {
        this.f41609a = r100;
        this.f41610b = r101;
        this.f41611c = r102;
    }
}
