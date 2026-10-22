package org.greenrobot.eventbus;

import android.os.Looper;

/* JADX INFO: loaded from: classes4.dex */
public interface MainThreadSupport {

    public static class AndroidHandlerMainThreadSupport implements MainThreadSupport {
        private final Looper looper;

        public AndroidHandlerMainThreadSupport(Looper r10) {
            this.looper = r10;
        }

        @Override // org.greenrobot.eventbus.MainThreadSupport
        public Poster createPoster(EventBus r10) {
            return new HandlerPoster(r10, this.looper, 10);
        }

        @Override // org.greenrobot.eventbus.MainThreadSupport
        public boolean isMainThread() {
            if (this.looper != Looper.myLooper()) goto L5;
            return true;
        L5:
            return false;
        }
    }

    Poster createPoster(EventBus r10);

    boolean isMainThread();
}
