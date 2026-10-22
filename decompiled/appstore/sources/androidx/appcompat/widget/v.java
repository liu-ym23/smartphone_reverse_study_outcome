package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1126g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1127h;

    public v() {
        this.f1120a = 0;
        this.f1121b = 0;
        this.f1122c = Integer.MIN_VALUE;
        this.f1123d = Integer.MIN_VALUE;
        this.f1124e = 0;
        this.f1125f = 0;
        this.f1126g = false;
        this.f1127h = false;
    }

    public int a() {
        if (this.f1126g == false) goto L6;
        return this.f1120a;
    L6:
        return this.f1121b;
    }

    public int b() {
        return this.f1120a;
    }

    public int c() {
        return this.f1121b;
    }

    public int d() {
        if (this.f1126g == false) goto L6;
        return this.f1121b;
    L6:
        return this.f1120a;
    }

    public void e(int r10, int r11) {
        this.f1127h = false;
        if (r10 == Integer.MIN_VALUE) goto L5;
        this.f1124e = r10;
        this.f1120a = r10;
    L5:
        if (r11 == Integer.MIN_VALUE) goto L8;
        this.f1125f = r11;
        this.f1121b = r11;
        return;
    }

    public void f(boolean r10) {
        if (r10 != this.f1126g) goto L5;
        return;
    L5:
        this.f1126g = r10;
        if (this.f1127h == true) goto L8;
        this.f1120a = this.f1124e;
        this.f1121b = this.f1125f;
        return;
    L8:
        if (r10 == false) goto L18;
        int r11 = this.f1123d;
        if (r11 != Integer.MIN_VALUE) goto L13;
        r11 = this.f1124e;
    L13:
        this.f1120a = r11;
        int r12 = this.f1122c;
        if (r12 != Integer.MIN_VALUE) goto L17;
        r12 = this.f1125f;
    L17:
        this.f1121b = r12;
        return;
    L18:
        int r13 = this.f1122c;
        if (r13 != Integer.MIN_VALUE) goto L22;
        r13 = this.f1124e;
    L22:
        this.f1120a = r13;
        int r14 = this.f1123d;
        if (r14 != Integer.MIN_VALUE) goto L26;
        r14 = this.f1125f;
    L26:
        this.f1121b = r14;
    }

    public void g(int r10, int r11) {
        this.f1122c = r10;
        this.f1123d = r11;
        this.f1127h = true;
        if (this.f1126g == false) goto L8;
        if (r11 == Integer.MIN_VALUE) goto L6;
        this.f1120a = r11;
    L6:
        if (r10 == Integer.MIN_VALUE) goto L13;
        this.f1121b = r10;
        return;
    L13:
        return;
    L8:
        if (r10 == Integer.MIN_VALUE) goto L10;
        this.f1120a = r10;
    L10:
        if (r11 == Integer.MIN_VALUE) goto L15;
        this.f1121b = r11;
        return;
    }
}
