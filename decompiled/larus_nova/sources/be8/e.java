package be8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18772b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f18771a, r101.f18771a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f18772b, r101.f18772b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f18771a.hashCode() * 31) + this.f18772b.hashCode();
    }

    public final String toString() {
        return "TaskFolder(folderName=" + this.f18771a + ", workSpace=" + this.f18772b + ')';
    }

    public e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "folderName");
        Intrinsics.checkNotNullParameter(r101, "workSpace");
        this.f18771a = r100;
        this.f18772b = r101;
    }
}
