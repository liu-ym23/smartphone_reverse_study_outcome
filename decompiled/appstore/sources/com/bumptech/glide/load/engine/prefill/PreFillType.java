package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class PreFillType {

    @VisibleForTesting
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

        public Builder(int r10) {
            this(r10, r10);
        }

        public PreFillType build() {
            return new PreFillType(this.width, this.height, this.config, this.weight);
        }

        public Bitmap.Config getConfig() {
            return this.config;
        }

        public Builder setConfig(@Nullable Bitmap.Config r10) {
            this.config = r10;
            return this;
        }

        public Builder setWeight(int r10) {
            if (r10 <= 0) goto L6;
            this.weight = r10;
            return this;
        L6:
            throw new IllegalArgumentException("Weight must be > 0");
        }

        public Builder(int r10, int r11) {
            this.weight = 1;
            if (r10 <= 0) goto L10;
            if (r11 <= 0) goto L8;
            this.width = r10;
            this.height = r11;
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

    public PreFillType(int r10, int r11, Bitmap.Config r12, int r13) {
        this.config = (Bitmap.Config) Preconditions.checkNotNull(r12, "Config must not be null");
        this.width = r10;
        this.height = r11;
        this.weight = r13;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof PreFillType) == false) goto L14;
        PreFillType r11 = (PreFillType) r10;
        if (this.height == r11.height) goto L7;
        return false;
    L7:
        if (this.width == r11.width) goto L9;
        return false;
    L9:
        if (this.weight == r11.weight) goto L11;
        return false;
    L11:
        if (this.config != r11.config) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
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

    public int hashCode() {
        return (((((this.width * 31) + this.height) * 31) + this.config.hashCode()) * 31) + this.weight;
    }

    public String toString() {
        return "PreFillSize{width=" + this.width + ", height=" + this.height + ", config=" + this.config + ", weight=" + this.weight + '}';
    }
}
