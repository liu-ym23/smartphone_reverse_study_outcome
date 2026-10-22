package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;
import androidx.annotation.DoNotInline;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f2555e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2559d;

    public static class a {
        @DoNotInline
        public static Insets a(int r10, int r11, int r12, int r13) {
            return Insets.of(r10, r11, r12, r13);
        }
    }

    static {
        f2555e = new e(0, 0, 0, 0);
    }

    public e(int r10, int r11, int r12, int r13) {
        this.f2556a = r10;
        this.f2557b = r11;
        this.f2558c = r12;
        this.f2559d = r13;
    }

    public static e a(e r10, e r11) {
        return b(Math.max(r10.f2556a, r11.f2556a), Math.max(r10.f2557b, r11.f2557b), Math.max(r10.f2558c, r11.f2558c), Math.max(r10.f2559d, r11.f2559d));
    }

    public static e b(int r10, int r11, int r12, int r13) {
        if (r10 != 0) goto L9;
        if (r11 != 0) goto L9;
        if (r12 != 0) goto L9;
        if (r13 != 0) goto L9;
        return f2555e;
    L9:
        return new e(r10, r11, r12, r13);
    }

    public static e c(Rect r10) {
        return b(r10.left, r10.top, r10.right, r10.bottom);
    }

    public static e d(Insets r10) {
        return b(r10.left, r10.top, r10.right, r10.bottom);
    }

    public Insets e() {
        return a.a(this.f2556a, this.f2557b, this.f2558c, this.f2559d);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L23:
        return false;
    L8:
        if (e.class != r10.getClass()) goto L23;
        e r11 = (e) r10;
        if (this.f2559d == r11.f2559d) goto L14;
        return false;
    L14:
        if (this.f2556a == r11.f2556a) goto L17;
        return false;
    L17:
        if (this.f2558c == r11.f2558c) goto L20;
        return false;
    L20:
        if (this.f2557b == r11.f2557b) goto L22;
        return false;
    L22:
        return true;
    }

    public int hashCode() {
        return (((((this.f2556a * 31) + this.f2557b) * 31) + this.f2558c) * 31) + this.f2559d;
    }

    public String toString() {
        return "Insets{left=" + this.f2556a + ", top=" + this.f2557b + ", right=" + this.f2558c + ", bottom=" + this.f2559d + '}';
    }
}
