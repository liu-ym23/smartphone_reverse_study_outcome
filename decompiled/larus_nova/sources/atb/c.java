package atb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16296b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f16295a, r101.f16295a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f16296b, r101.f16296b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f16295a.hashCode() * 31) + this.f16296b.hashCode();
    }

    public final String toString() {
        return "CustomSpeechInfo(fileKey=" + this.f16295a + ", fsUnit=" + this.f16296b + ')';
    }

    public c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "fileKey");
        Intrinsics.checkNotNullParameter(r101, "fsUnit");
        this.f16295a = r100;
        this.f16296b = r101;
    }
}
