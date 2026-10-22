package androidx.camera.core;

/* JADX INFO: loaded from: classes2.dex */
public class LayoutSettings {
    public static final LayoutSettings DEFAULT = null;
    private final float mAlpha;
    private final float mHeight;
    private final float mOffsetX;
    private final float mOffsetY;
    private final float mWidth;

    /* JADX INFO: renamed from: androidx.camera.core.LayoutSettings$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private float mAlpha;
        private float mHeight;
        private float mOffsetX;
        private float mOffsetY;
        private float mWidth;

        public LayoutSettings build() {
            return new LayoutSettings(this.mAlpha, this.mOffsetX, this.mOffsetY, this.mWidth, this.mHeight, null);
        }

        public Builder() {
            this.mAlpha = 1.0f;
            this.mOffsetX = 0.0f;
            this.mOffsetY = 0.0f;
            this.mWidth = 0.0f;
            this.mHeight = 0.0f;
        }

        public Builder setAlpha(float r100) {
            this.mAlpha = r100;
            return this;
        }

        public Builder setHeight(float r100) {
            this.mHeight = r100;
            return this;
        }

        public Builder setOffsetX(float r100) {
            this.mOffsetX = r100;
            return this;
        }

        public Builder setOffsetY(float r100) {
            this.mOffsetY = r100;
            return this;
        }

        public Builder setWidth(float r100) {
            this.mWidth = r100;
            return this;
        }
    }

    static {
        DEFAULT = new Builder().setAlpha(1.0f).setOffsetX(0.0f).setOffsetY(0.0f).setWidth(1.0f).setHeight(1.0f).build();
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public float getOffsetX() {
        return this.mOffsetX;
    }

    public float getOffsetY() {
        return this.mOffsetY;
    }

    public float getWidth() {
        return this.mWidth;
    }

    private LayoutSettings(float r100, float r101, float r102, float r103, float r104) {
        this.mAlpha = r100;
        this.mOffsetX = r101;
        this.mOffsetY = r102;
        this.mWidth = r103;
        this.mHeight = r104;
    }

    public /* synthetic */ LayoutSettings(float r100, float r101, float r102, float r103, float r104, AnonymousClass1 r105) {
        this(r100, r101, r102, r103, r104);
    }
}
