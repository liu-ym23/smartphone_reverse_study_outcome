package androidx.core.graphics;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes17.dex */
public final class Insets {
    public static final Insets NONE = null;
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static android.graphics.Insets of(int r100, int r101, int r102, int r103) {
            return android.graphics.Insets.of(r100, r101, r102, r103);
        }
    }

    static {
        NONE = new Insets(0, 0, 0, 0);
    }

    public int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    public android.graphics.Insets toPlatformInsets() {
        return Api29Impl.of(this.left, this.top, this.right, this.bottom);
    }

    public String toString() {
        return "Insets{left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
    }

    public static Insets of(Rect r100) {
        return of(r100.left, r100.top, r100.right, r100.bottom);
    }

    public static Insets toCompatInsets(android.graphics.Insets r100) {
        return of(r100.left, r100.top, r100.right, r100.bottom);
    }

    public static Insets wrap(android.graphics.Insets r100) {
        return toCompatInsets(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L23:
        return false;
    L8:
        if (Insets.class != r100.getClass()) goto L23;
        Insets r101 = (Insets) r100;
        if (this.bottom == r101.bottom) goto L14;
        return false;
    L14:
        if (this.left == r101.left) goto L17;
        return false;
    L17:
        if (this.right == r101.right) goto L20;
        return false;
    L20:
        if (this.top == r101.top) goto L22;
        return false;
    L22:
        return true;
    }

    public static Insets add(Insets r100, Insets r101) {
        return of(r100.left + r101.left, r100.top + r101.top, r100.right + r101.right, r100.bottom + r101.bottom);
    }

    public static Insets max(Insets r100, Insets r101) {
        return of(Math.max(r100.left, r101.left), Math.max(r100.top, r101.top), Math.max(r100.right, r101.right), Math.max(r100.bottom, r101.bottom));
    }

    public static Insets min(Insets r100, Insets r101) {
        return of(Math.min(r100.left, r101.left), Math.min(r100.top, r101.top), Math.min(r100.right, r101.right), Math.min(r100.bottom, r101.bottom));
    }

    public static Insets subtract(Insets r100, Insets r101) {
        return of(r100.left - r101.left, r100.top - r101.top, r100.right - r101.right, r100.bottom - r101.bottom);
    }

    private Insets(int r100, int r101, int r102, int r103) {
        this.left = r100;
        this.top = r101;
        this.right = r102;
        this.bottom = r103;
    }

    public static Insets of(int r100, int r101, int r102, int r103) {
        if (r100 != 0) goto L9;
        if (r101 != 0) goto L9;
        if (r102 != 0) goto L9;
        if (r103 != 0) goto L9;
        return NONE;
    L9:
        return new Insets(r100, r101, r102, r103);
    }
}
