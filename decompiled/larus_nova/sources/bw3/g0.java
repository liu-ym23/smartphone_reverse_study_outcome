package bw3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21073c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r101 = (g0) r100;
        if (Intrinsics.areEqual(this.f21071a, r101.f21071a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f21072b, r101.f21072b) == true) goto L15;
        return false;
    L15:
        if (this.f21073c == r101.f21073c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f21071a.hashCode() * 31) + this.f21072b.hashCode()) * 31) + this.f21073c;
    }

    public final String toString() {
        return "InnerAudioResolvedSource(originalSrc=" + this.f21071a + ", playSource=" + this.f21072b + ", sourceType=" + this.f21073c + ')';
    }

    public g0(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "originalSrc");
        Intrinsics.checkNotNullParameter(r101, "playSource");
        this.f21071a = r100;
        this.f21072b = r101;
        this.f21073c = r102;
    }
}
