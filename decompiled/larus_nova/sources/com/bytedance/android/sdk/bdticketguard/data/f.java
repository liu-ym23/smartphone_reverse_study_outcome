package com.bytedance.android.sdk.bdticketguard.data;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f163615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f163616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f163617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f163618d;

    public f() {
        this(-1, -1, -1, -1);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L28:
        return true;
    L5:
        if ((r100 instanceof f) == false) goto L27;
        f r101 = (f) r100;
        if (this.f163615a != r101.f163615a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L27;
        if (this.f163616b != r101.f163616b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L27;
        if (this.f163617c != r101.f163617c) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L27;
        if (this.f163618d != r101.f163618d) goto L24;
        boolean r105 = true;
    L25:
        if (r105 == false) goto L27;
    L24:
        r105 = false;
        goto L25
    L19:
        r104 = false;
        goto L20
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L27:
        return false;
    }

    public final int hashCode() {
        return (((((this.f163615a * 31) + this.f163616b) * 31) + this.f163617c) * 31) + this.f163618d;
    }

    public final String toString() {
        return "TeeKeyGenData(genWithCert=" + this.f163615a + ", genWithP256=" + this.f163616b + ", genWithSp=" + this.f163617c + ", genWithNotRequireAuth=" + this.f163618d + ")";
    }

    public f(int r100, int r101, int r102, int r103) {
        this.f163615a = r100;
        this.f163616b = r101;
        this.f163617c = r102;
        this.f163618d = r103;
    }
}
