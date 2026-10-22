package a9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2215e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f2211a, r101.f2211a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f2212b, r101.f2212b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f2213c, r101.f2213c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f2214d, r101.f2214d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f2215e, r101.f2215e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f2211a.hashCode() * 31) + this.f2212b.hashCode()) * 31) + this.f2213c.hashCode()) * 31) + this.f2214d.hashCode()) * 31) + this.f2215e.hashCode();
    }

    public final String toString() {
        return "AsrInitSettings(domain=" + this.f2211a + ", path=" + this.f2212b + ", appId=" + this.f2213c + ", appToken=" + this.f2214d + ", resourceId=" + this.f2215e + ')';
    }

    public a(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r102, "appId");
        Intrinsics.checkNotNullParameter(r103, "appToken");
        Intrinsics.checkNotNullParameter(r104, "resourceId");
        this.f2211a = r100;
        this.f2212b = r101;
        this.f2213c = r102;
        this.f2214d = r103;
        this.f2215e = r104;
    }
}
