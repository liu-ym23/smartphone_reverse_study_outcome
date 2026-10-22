package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes39.dex */
public final class PreFillType {
    static final Bitmap.Config DEFAULT_CONFIG = null;
    private final Bitmap.Config config;
    private final int height;
    private final int weight;
    private final int width;

    public static class Builder {
        private Bitmap.Config config;
        private final int height;
        private int weight;
        private final int width;

        public PreFillType build() {
            return new PreFillType(this.width, this.height, this.config, this.weight);
        }

        public Bitmap.Config getConfig() {
            return this.config;
        }

        public Builder(int r100) {
            this(r100, r100);
        }

        public Builder setConfig(Bitmap.Config r100) {
            this.config = r100;
            return this;
        }

        public Builder setWeight(int r100) {
            if (r100 <= 0) goto L6;
            this.weight = r100;
            return this;
        L6:
            throw new IllegalArgumentException("Weight must be > 0");
        }

        public Builder(int r100, int r101) {
            this.weight = 1;
            if (r100 <= 0) goto L10;
            if (r101 <= 0) goto L8;
            this.width = r100;
            this.height = r101;
            return;
        L8:
            throw new IllegalArgumentException("Height must be > 0");
        L10:
            throw new IllegalArgumentException("Width must be > 0");
        }
    }

    static {
        DEFAULT_CONFIG = Bitmap.Config.RGB_565;
    }

    public int hashCode() {
        return (((((this.width * 31) + this.height) * 31) + this.config.hashCode()) * 31) + this.weight;
    }

    public String toString() {
        return "PreFillSize{width=" + this.width + ", height=" + this.height + ", config=" + this.config + ", weight=" + this.weight + '}';
    }

    public Bitmap.Config getConfig() {
        return this.config;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof PreFillType) == false) goto L14;
        PreFillType r101 = (PreFillType) r100;
        if (this.height == r101.height) goto L7;
        return false;
    L7:
        if (this.width == r101.width) goto L9;
        return false;
    L9:
        if (this.weight == r101.weight) goto L11;
        return false;
    L11:
        if (this.config != r101.config) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    public PreFillType(int r100, int r101, Bitmap.Config r102, int r103) {
        this.config = (Bitmap.Config) Preconditions.checkNotNull(r102, "Config must not be null");
        this.width = r100;
        this.height = r101;
        this.weight = r103;
    }
}
