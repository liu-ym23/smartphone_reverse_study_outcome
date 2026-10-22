package cbb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23119b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f23118a, r101.f23118a) == true) goto L12;
        return false;
    L12:
        if (this.f23119b == r101.f23119b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f23118a.hashCode() * 31) + this.f23119b;
    }

    public final String toString() {
        return "DefaultAutoCleanItem(path=" + this.f23118a + ", agoDays=" + this.f23119b + ')';
    }

    public b() {
        Intrinsics.checkNotNullParameter("", "path");
        this.f23118a = "";
        this.f23119b = 0;
    }
}
