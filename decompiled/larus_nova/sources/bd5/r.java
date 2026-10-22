package bd5;

/* JADX INFO: loaded from: classes18.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f18678d;

    public final float a(int r100) {
        int r101 = this.f18676b;
        if (r100 > r101) goto L15;
        int r102 = this.f18677c;
        if (r102 > 0) goto L17;
        float r103 = (r102 + r101) / r101;
        if (r103 <= 1.0f) goto L11;
        return 1.0f;
    L11:
        if (r103 >= 0.1f) goto L14;
        return 0.0f;
    L14:
        return r103;
    L17:
        return 1.0f;
    L15:
        return 1.0f;
    }

    public r(int r100, int r101) {
        this.f18677c = 0;
        this.f18676b = r100;
        this.f18675a = r101;
    }

    public final int b(int r100, int r101) {
        int r102 = r100 - r101;
        int r103 = this.f18676b;
        if (r102 >= r103) goto L6;
        this.f18677c += r102 - r103;
    L5:
        r102 = r103;
    L12:
        int r104 = this.f18677c;
        if (r104 >= (-r103)) goto L15;
        this.f18677c = -r103;
    L17:
        return r102;
    L15:
        if (r104 <= 0) goto L17;
        this.f18677c = 0;
        goto L17
    L6:
        int r105 = this.f18675a;
        if (r102 <= r105) goto L9;
        this.f18677c = 0;
        r102 = r105;
        goto L12
    L9:
        int r106 = this.f18677c;
        if (r106 >= 0) goto L12;
        this.f18677c = r106 - r101;
        goto L5
    }

    public r(int r100, int r101, int r102) {
        this.f18677c = 0;
        this.f18676b = r100;
        this.f18675a = r101;
        this.f18678d = r102;
    }
}
