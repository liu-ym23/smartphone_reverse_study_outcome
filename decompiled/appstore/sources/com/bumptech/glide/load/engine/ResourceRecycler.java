package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
class ResourceRecycler {
    private final Handler handler;
    private boolean isRecycling;

    public static final class ResourceRecyclerCallback implements Handler.Callback {
        static final int RECYCLE_RESOURCE = 1;

        public ResourceRecyclerCallback() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r10) {
            if (r10.what != 1) goto L6;
            ((Resource) r10.obj).recycle();
            return true;
        L6:
            return false;
        }
    }

    public ResourceRecycler() {
        this.handler = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());
    }

    public synchronized void recycle(Resource<?> r10) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.isRecycling == false) goto L8;
        this.handler.obtainMessage(1, r10).sendToTarget();     // Catch: Throwable -> L6
    L9:
        monitor-exit(this);
        return;
    L8:
        this.isRecycling = true;     // Catch: Throwable -> L6
        r10.recycle();     // Catch: Throwable -> L6
        this.isRecycling = false;     // Catch: Throwable -> L6
        goto L9
    }
}
