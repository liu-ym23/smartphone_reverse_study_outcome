package androidx.appcompat.widget;

/* JADX INFO: compiled from: RtlSpacingHelper.java */
/* JADX INFO: loaded from: classes.dex */
class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f487e;
    private int f;
    private boolean g;
    private boolean h;

    v() {
        this.f483a = 0;
        this.f484b = 0;
        this.f485c = Integer.MIN_VALUE;
        this.f486d = Integer.MIN_VALUE;
        this.f487e = 0;
        this.f = 0;
        this.g = false;
        this.h = false;
    }

    public int a() {
        return this.f483a;
    }

    public int b() {
        return this.f484b;
    }

    public int c() {
        if (this.g == false) goto L6;
        return this.f484b;
    L6:
        return this.f483a;
    }

    public int d() {
        if (this.g == false) goto L6;
        return this.f483a;
    L6:
        return this.f484b;
    }

    public void a(int r3, int r4) {
        this.f485c = r3;
        this.f486d = r4;
        this.h = true;
        if (this.g == false) goto L8;
        if (r4 == Integer.MIN_VALUE) goto L6;
        this.f483a = r4;
    L6:
        if (r3 == Integer.MIN_VALUE) goto L13;
        this.f484b = r3;
        return;
    L13:
        return;
    L8:
        if (r3 == Integer.MIN_VALUE) goto L10;
        this.f483a = r3;
    L10:
        if (r4 == Integer.MIN_VALUE) goto L15;
        this.f484b = r4;
        return;
    }

    public void b(int r2, int r3) {
        this.h = false;
        if (r2 == Integer.MIN_VALUE) goto L5;
        this.f487e = r2;
        this.f483a = r2;
    L5:
        if (r3 == Integer.MIN_VALUE) goto L8;
        this.f = r3;
        this.f484b = r3;
        return;
    }

    public void a(boolean r2) {
        if (r2 != this.g) goto L5;
        return;
    L5:
        this.g = r2;
        if (this.h == true) goto L8;
        this.f483a = this.f487e;
        this.f484b = this.f;
        return;
    L8:
        if (r2 == false) goto L18;
        int r3 = this.f486d;
        if (r3 != Integer.MIN_VALUE) goto L13;
        r3 = this.f487e;
    L13:
        this.f483a = r3;
        int r4 = this.f485c;
        if (r4 != Integer.MIN_VALUE) goto L17;
        r4 = this.f;
    L17:
        this.f484b = r4;
        return;
    L18:
        int r5 = this.f485c;
        if (r5 != Integer.MIN_VALUE) goto L22;
        r5 = this.f487e;
    L22:
        this.f483a = r5;
        int r6 = this.f486d;
        if (r6 != Integer.MIN_VALUE) goto L26;
        r6 = this.f;
    L26:
        this.f484b = r6;
    }
}
