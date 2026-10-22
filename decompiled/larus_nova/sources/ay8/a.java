package ay8;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f16756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f16757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f16758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f16759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f16760e;

    public a() {
        boolean r100 = false;
        this(r100, r100, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f16756a == r101.f16756a) goto L12;
        return false;
    L12:
        if (this.f16757b == r101.f16757b) goto L15;
        return false;
    L15:
        if (this.f16758c == r101.f16758c) goto L18;
        return false;
    L18:
        if (this.f16759d == r101.f16759d) goto L21;
        return false;
    L21:
        if (this.f16760e == r101.f16760e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f16756a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f16757b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f16758c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f16759d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f16760e == true) goto L23;
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
        return "ResultTitleRightIconState(needCrop=" + this.f16756a + ", needAIBeauty=" + this.f16757b + ", needDownload=" + this.f16758c + ", needRotate=" + this.f16759d + ", needMarkSelect=" + this.f16760e + ')';
    }

    public /* synthetic */ a(boolean r100, boolean r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r111 & 8) == 0) goto L9;
        boolean r102 = false;
    L10:
        this(r101, false, false, r102, false);
        return;
    L9:
        r102 = r110;
        goto L10
    L5:
        r101 = r100;
        goto L7
    }

    public a(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        this.f16756a = r100;
        this.f16757b = r101;
        this.f16758c = r102;
        this.f16759d = r103;
        this.f16760e = r104;
    }
}
