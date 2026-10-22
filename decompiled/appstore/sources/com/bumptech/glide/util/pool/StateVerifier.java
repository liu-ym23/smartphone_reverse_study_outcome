package com.bumptech.glide.util.pool;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class StateVerifier {
    private static final boolean DEBUG = false;

    /* JADX INFO: renamed from: com.bumptech.glide.util.pool.StateVerifier$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class DebugStateVerifier extends StateVerifier {
        private volatile RuntimeException recycledAtStackTraceException;

        public DebugStateVerifier() {
            super(null);
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void setRecycled(boolean r10) {
            if (r10 == false) goto L4;
            this.recycledAtStackTraceException = new RuntimeException("Released");
            return;
        L4:
            this.recycledAtStackTraceException = null;
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if (this.recycledAtStackTraceException != null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Already released", this.recycledAtStackTraceException);
        }
    }

    public static class DefaultStateVerifier extends StateVerifier {
        private volatile boolean isReleased;

        public DefaultStateVerifier() {
            super(null);
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void setRecycled(boolean r10) {
            this.isReleased = r10;
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if (this.isReleased == true) goto L6;
            return;
        L6:
            throw new IllegalStateException("Already released");
        }
    }

    public /* synthetic */ StateVerifier(AnonymousClass1 r10) {
        this();
    }

    @NonNull
    public static StateVerifier newInstance() {
        return new DefaultStateVerifier();
    }

    public abstract void setRecycled(boolean r10);

    public abstract void throwIfRecycled();

    private StateVerifier() {
    }
}
