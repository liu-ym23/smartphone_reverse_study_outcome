package com.bytedance.android.gamecp.common.utils.rx.autodispose;

/* JADX INFO: loaded from: classes44.dex */
public final class ExceptionHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Throwable f57283a = null;

    public static final class Termination extends Throwable {
        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            monitor-enter(this);
            monitor-exit(this);
            return this;
        }

        public Termination() {
            super("No further exceptions");
        }
    }

    static {
        f57283a = new Termination();
    }
}
