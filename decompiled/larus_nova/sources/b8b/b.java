package b8b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f18225d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f18222a, r101.f18222a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f18223b, r101.f18223b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f18224c, r101.f18224c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f18225d, r101.f18225d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f18222a.hashCode() * 31) + this.f18223b.hashCode()) * 31) + this.f18224c.hashCode()) * 31) + this.f18225d.hashCode();
    }

    public final String toString() {
        return "ReleaseInfo(packageDeployMode=" + this.f18222a + ", packageBrand=" + this.f18223b + ", releaseAction=" + this.f18224c + ", packageJobId=" + this.f18225d + ')';
    }

    public b() {
        this("", "", "", "");
    }

    public b(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "packageDeployMode");
        Intrinsics.checkNotNullParameter(r101, "packageBrand");
        Intrinsics.checkNotNullParameter(r102, "releaseAction");
        Intrinsics.checkNotNullParameter(r103, "packageJobId");
        this.f18222a = r100;
        this.f18223b = r101;
        this.f18224c = r102;
        this.f18225d = r103;
    }
}
