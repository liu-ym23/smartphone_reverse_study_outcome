package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes.dex */
public class DrawableCrossFadeFactory implements TransitionFactory<Drawable> {
    private final int duration;
    private final boolean isCrossFadeEnabled;
    private DrawableCrossFadeTransition resourceTransition;

    public static class Builder {
        private static final int DEFAULT_DURATION_MS = 300;
        private final int durationMillis;
        private boolean isCrossFadeEnabled;

        public Builder() {
            this(300);
        }

        public DrawableCrossFadeFactory build() {
            return new DrawableCrossFadeFactory(this.durationMillis, this.isCrossFadeEnabled);
        }

        public Builder setCrossFadeEnabled(boolean r10) {
            this.isCrossFadeEnabled = r10;
            return this;
        }

        public Builder(int r10) {
            this.durationMillis = r10;
        }
    }

    public DrawableCrossFadeFactory(int r10, boolean r11) {
        this.duration = r10;
        this.isCrossFadeEnabled = r11;
    }

    private Transition<Drawable> getResourceTransition() {
        if (this.resourceTransition != null) goto L6;
        this.resourceTransition = new DrawableCrossFadeTransition(this.duration, this.isCrossFadeEnabled);
    L6:
        return this.resourceTransition;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<Drawable> build(DataSource r10, boolean r11) {
        if (r10 != DataSource.MEMORY_CACHE) goto L6;
        return NoTransition.get();
    L6:
        return getResourceTransition();
    }
}
