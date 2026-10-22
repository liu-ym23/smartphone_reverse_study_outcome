package ar5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f16016d;

    /* JADX INFO: renamed from: ar5.a$a, reason: collision with other inner class name */
    public static final class C0211a {
    }

    static {
    }

    public /* synthetic */ a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f16013a, r101.f16013a) == true) goto L12;
        return false;
    L12:
        if (this.f16014b == r101.f16014b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f16015c, r101.f16015c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f16016d, r101.f16016d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f16013a.hashCode() * 31) + this.f16014b) * 31) + this.f16015c.hashCode()) * 31) + this.f16016d.hashCode();
    }

    public final String toString() {
        return "WikiPathResolveContext(visibleSpaceId=" + this.f16013a + ", scene=" + this.f16014b + ", targetWikiToken=" + this.f16015c + ", loadIdentity=" + this.f16016d + ')';
    }

    public a(String r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "visibleSpaceId");
        Intrinsics.checkNotNullParameter(r102, "targetWikiToken");
        Intrinsics.checkNotNullParameter(r103, "loadIdentity");
        this.f16013a = r100;
        this.f16014b = r101;
        this.f16015c = r102;
        this.f16016d = r103;
    }
}
