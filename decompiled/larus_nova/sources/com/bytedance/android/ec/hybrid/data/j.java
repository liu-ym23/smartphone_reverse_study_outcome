package com.bytedance.android.ec.hybrid.data;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f46728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f46729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f46730c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L12;
        j r101 = (j) r100;
        if (this.f46728a == r101.f46728a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f46729b, r101.f46729b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f46730c, r101.f46730c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f46728a * 31;
        List<String> r101 = this.f46729b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f46730c;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "RemoveUnExposeItemRes(count=" + this.f46728a + ", filters=" + this.f46729b + ", cursor=" + this.f46730c + ")";
    }

    public j(int r100, List<String> r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r101, "filters");
        this.f46728a = r100;
        this.f46729b = r101;
        this.f46730c = r102;
    }
}
