package com.bumptech.glide.util.pool;

import com.bumptech.glide.util.GlideLogUtil;

/* JADX INFO: loaded from: classes39.dex */
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
        public void throwIfRecycled() {
            if (this.recycledAtStackTraceException != null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Already released", this.recycledAtStackTraceException);
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void setRecycled(boolean r100) {
            if (r100 == false) goto L4;
            this.recycledAtStackTraceException = new RuntimeException("Released");
            return;
        L4:
            this.recycledAtStackTraceException = null;
        }
    }

    public static class DefaultStateVerifier extends StateVerifier {
        private static final String TAG = "DefaultStateVerifier";
        private volatile boolean isReleased;

        public DefaultStateVerifier() {
            super(null);
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if (this.isReleased == false) goto L6;
            GlideLogUtil.e(TAG, "throwIfRecycled, Already released");
            return;
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void setRecycled(boolean r100) {
            this.isReleased = r100;
        }
    }

    private StateVerifier() {
    }

    public abstract void setRecycled(boolean r100);

    public abstract void throwIfRecycled();

    public static StateVerifier newInstance() {
        return new DefaultStateVerifier();
    }

    public /* synthetic */ StateVerifier(AnonymousClass1 r100) {
        this();
    }
}
