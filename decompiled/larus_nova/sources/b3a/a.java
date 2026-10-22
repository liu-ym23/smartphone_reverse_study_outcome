package b3a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17394c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f17392a, r101.f17392a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f17393b, r101.f17393b) == true) goto L15;
        return false;
    L15:
        if (this.f17394c == r101.f17394c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f17392a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f17393b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.f17394c;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PreConnectConfig(deviceId=" + this.f17392a + ", ppe=" + this.f17393b + ", connectionType=" + this.f17394c + ')';
    }

    public a(String r100, String r101, int r102) {
        this.f17392a = r100;
        this.f17393b = r101;
        this.f17394c = r102;
    }
}
