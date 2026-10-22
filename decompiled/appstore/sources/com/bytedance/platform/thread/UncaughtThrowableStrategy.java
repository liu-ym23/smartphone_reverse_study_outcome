package com.bytedance.platform.thread;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public interface UncaughtThrowableStrategy {
    public static final UncaughtThrowableStrategy DEFAULT = null;
    public static final UncaughtThrowableStrategy IGNORE = null;
    public static final UncaughtThrowableStrategy LOG = null;
    public static final String TAG = "PlatformExecutor";
    public static final UncaughtThrowableStrategy THROW = null;

    public static class a implements UncaughtThrowableStrategy {
        public a() {
        }

        @Override // com.bytedance.platform.thread.UncaughtThrowableStrategy
        public void handle(Throwable r10) {
        }
    }

    public static class b implements UncaughtThrowableStrategy {
        public b() {
        }

        @Override // com.bytedance.platform.thread.UncaughtThrowableStrategy
        public void handle(Throwable r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (Log.isLoggable(UncaughtThrowableStrategy.TAG, 6) == false) goto L8;
            Log.e(UncaughtThrowableStrategy.TAG, "Request threw uncaught throwable", r10);
            return;
        }
    }

    public static class c implements UncaughtThrowableStrategy {
        public c() {
        }

        @Override // com.bytedance.platform.thread.UncaughtThrowableStrategy
        public void handle(Throwable r10) {
            if (r10 != null) goto L5;
            return;
        L5:
            throw new RuntimeException("Request threw uncaught throwable", r10);
        }
    }

    static {
        IGNORE = new a();
        b r10 = new b();
        LOG = r10;
        THROW = new c();
        DEFAULT = r10;
    }

    void handle(Throwable r10);
}
