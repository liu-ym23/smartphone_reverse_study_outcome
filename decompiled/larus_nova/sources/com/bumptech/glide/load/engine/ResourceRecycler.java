package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes39.dex */
class ResourceRecycler {
    private final Handler handler;
    private boolean isRecycling;

    public static final class ResourceRecyclerCallback implements Handler.Callback {
        static final int RECYCLE_RESOURCE = 1;

        public ResourceRecyclerCallback() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r100) {
            if (r100.what != 1) goto L6;
            ((Resource) r100.obj).recycle();
            return true;
        L6:
            return false;
        }
    }

    public ResourceRecycler() {
        this.handler = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());
    }

    public synchronized void recycle(Resource<?> r100, boolean r101) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isRecycling == true) goto L8;
        if (r101 == true) goto L8;
        this.isRecycling = true;     // Catch: Throwable -> L11
        r100.recycle();     // Catch: Throwable -> L11
        this.isRecycling = false;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L8:
        this.handler.obtainMessage(1, r100).sendToTarget();     // Catch: Throwable -> L11
        goto L9
    }
}
