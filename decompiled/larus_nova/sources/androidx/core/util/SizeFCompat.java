package androidx.core.util;

import android.util.SizeF;

/* JADX INFO: loaded from: classes17.dex */
public final class SizeFCompat {
    private final float mHeight;
    private final float mWidth;

    public static final class Api21Impl {
        private Api21Impl() {
        }

        public static SizeF toSizeF(SizeFCompat r100) {
            Preconditions.checkNotNull(r100);
            return new SizeF(r100.getWidth(), r100.getHeight());
        }

        public static SizeFCompat toSizeFCompat(SizeF r100) {
            Preconditions.checkNotNull(r100);
            return new SizeFCompat(r100.getWidth(), r100.getHeight());
        }
    }

    public int hashCode() {
        return Float.floatToIntBits(this.mWidth) ^ Float.floatToIntBits(this.mHeight);
    }

    public String toString() {
        return this.mWidth + "x" + this.mHeight;
    }

    public SizeF toSizeF() {
        return Api21Impl.toSizeF(this);
    }

    public float getHeight() {
        return this.mHeight;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public static SizeFCompat toSizeFCompat(SizeF r100) {
        return Api21Impl.toSizeFCompat(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SizeFCompat) == true) goto L8;
        return false;
    L8:
        SizeFCompat r101 = (SizeFCompat) r100;
        if (r101.mWidth == this.mWidth) goto L11;
    L13:
        return false;
    L11:
        if (r101.mHeight != this.mHeight) goto L13;
        return true;
    }

    public SizeFCompat(float r100, float r101) {
        this.mWidth = Preconditions.checkArgumentFinite(r100, "width");
        this.mHeight = Preconditions.checkArgumentFinite(r101, "height");
    }
}
