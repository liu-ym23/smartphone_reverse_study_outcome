package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class ResourceRecycler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f3512b;

    private static final class ResourceRecyclerCallback implements Handler.Callback {
        static final int RECYCLE_RESOURCE = 1;

        ResourceRecyclerCallback() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r3) {
            if (r3.what != 1) goto L6;
            ((v) ZeusTransformUtils.preCheckCast(r3.obj, v.class, "com.obric.aiagent.plugin")).f();
            return true;
        L6:
            return false;
        }
    }

    ResourceRecycler() {
        this.f3512b = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());
    }

    synchronized void a(v<?> r3, boolean r4) {
        monitor-enter(this);
        v r5 = (v) ZeusTransformUtils.wrapperContextForParams(r3, v.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (this.f3511a == true) goto L8;
        if (r4 == true) goto L8;
        this.f3511a = true;     // Catch: Throwable -> L11
        r5.f();     // Catch: Throwable -> L11
        this.f3511a = false;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L8:
        this.f3512b.obtainMessage(1, r5).sendToTarget();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
