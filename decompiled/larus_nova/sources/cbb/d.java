package cbb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f23126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f23127b;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f23126a, r101.f23126a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f23127b, r101.f23127b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f23126a.hashCode() * 31) + this.f23127b.hashCode();
    }

    public final String toString() {
        return "RemoteConfig(global=" + this.f23126a + ", cacheConfig=" + this.f23127b + ')';
    }

    public d(int r100) {
        c r101 = new c(0);
        Intrinsics.checkNotNullParameter(r101, "global");
        Intrinsics.checkNotNullParameter("", "cacheConfig");
        this.f23126a = r101;
        this.f23127b = "";
    }
}
