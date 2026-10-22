package ae8;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f3118e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f3114a == r101.f3114a) goto L12;
        return false;
    L12:
        if (this.f3115b == r101.f3115b) goto L15;
        return false;
    L15:
        if (this.f3116c == r101.f3116c) goto L18;
        return false;
    L18:
        if (this.f3117d == r101.f3117d) goto L21;
        return false;
    L21:
        if (this.f3118e == r101.f3118e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f3114a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f3115b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f3116c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f3117d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f3118e == true) goto L23;
        r100 = 1237;
    L23:
        return r108 + r100;
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MinorDialogShowState(isMinorChecked=" + this.f3114a + ", isMinorShowed=" + this.f3115b + ", isCommerceShown=" + this.f3116c + ", isAccountReusedShown=" + this.f3117d + ", isAccountReusedChecked=" + this.f3118e + ')';
    }

    public c(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        this.f3114a = r100;
        this.f3115b = r101;
        this.f3116c = r102;
        this.f3117d = r103;
        this.f3118e = r104;
    }
}
