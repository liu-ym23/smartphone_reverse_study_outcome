package com.bytedance.android.shopping.prepurchase.arch.exposure;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f180884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f180885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<d> f180886c;

    public b() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f180884a, r101.f180884a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f180885b, r101.f180885b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f180886c, r101.f180886c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<d> r100 = this.f180884a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<d> r104 = this.f180885b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<d> r107 = this.f180886c;
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
        return "DiffResult(addedRules=" + this.f180884a + ", deletedRules=" + this.f180885b + ", updateRules=" + this.f180886c + ")";
    }

    public /* synthetic */ b(List r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, null, null);
    }

    public b(List<d> r100, List<d> r101, List<d> r102) {
        this.f180884a = r100;
        this.f180885b = r101;
        this.f180886c = r102;
    }
}
