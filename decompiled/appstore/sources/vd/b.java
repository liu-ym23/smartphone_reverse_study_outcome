package vd;

import android.graphics.Insets;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f25226e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f25227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f25228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f25229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f25230d;

    static {
        f25226e = new b(0, 0, 0, 0);
    }

    public b(int r10, int r11, int r12, int r13) {
        this.f25227a = r10;
        this.f25228b = r11;
        this.f25229c = r12;
        this.f25230d = r13;
    }

    public static b a(b r10, b r11) {
        return b(Math.max(r10.f25227a, r11.f25227a), Math.max(r10.f25228b, r11.f25228b), Math.max(r10.f25229c, r11.f25229c), Math.max(r10.f25230d, r11.f25230d));
    }

    public static b b(int r10, int r11, int r12, int r13) {
        if (r10 != 0) goto L9;
        if (r11 != 0) goto L9;
        if (r12 != 0) goto L9;
        if (r13 != 0) goto L9;
        return f25226e;
    L9:
        return new b(r10, r11, r12, r13);
    }

    public static b c(Insets r10) {
        return b(r10.left, r10.top, r10.right, r10.bottom);
    }

    public Insets d() {
        return Insets.of(this.f25227a, this.f25228b, this.f25229c, this.f25230d);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L23:
        return false;
    L8:
        if (b.class != r10.getClass()) goto L23;
        b r11 = (b) r10;
        if (this.f25230d == r11.f25230d) goto L14;
        return false;
    L14:
        if (this.f25227a == r11.f25227a) goto L17;
        return false;
    L17:
        if (this.f25229c == r11.f25229c) goto L20;
        return false;
    L20:
        if (this.f25228b == r11.f25228b) goto L22;
        return false;
    L22:
        return true;
    }

    public int hashCode() {
        return (((((this.f25227a * 31) + this.f25228b) * 31) + this.f25229c) * 31) + this.f25230d;
    }

    public String toString() {
        return "Insets{left=" + this.f25227a + ", top=" + this.f25228b + ", right=" + this.f25229c + ", bottom=" + this.f25230d + '}';
    }
}
