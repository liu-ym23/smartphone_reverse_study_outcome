package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes39.dex */
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

        public Builder(int r100) {
            this.durationMillis = r100;
        }

        public Builder setCrossFadeEnabled(boolean r100) {
            this.isCrossFadeEnabled = r100;
            return this;
        }
    }

    private Transition<Drawable> getResourceTransition() {
        if (this.resourceTransition != null) goto L6;
        this.resourceTransition = new DrawableCrossFadeTransition(this.duration, this.isCrossFadeEnabled);
    L6:
        return this.resourceTransition;
    }

    public DrawableCrossFadeFactory(int r100, boolean r101) {
        this.duration = r100;
        this.isCrossFadeEnabled = r101;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<Drawable> build(DataSource r100, boolean r101) {
        if (r100 != DataSource.MEMORY_CACHE) goto L6;
        return NoTransition.get();
    L6:
        return getResourceTransition();
    }
}
