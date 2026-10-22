package com.bytedance.android.shopping.collect.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HandlerC2586a f172290a = null;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.collect.util.a$a, reason: collision with other inner class name */
    public static final class HandlerC2586a extends Handler {
        public HandlerC2586a(Looper r100) {
            Intrinsics.checkNotNullParameter(r100, "looper");
            super(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            super.handleMessage(r100);     // Catch: Exception -> L5
            return;
        }
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f172291a;

        public b(Function0 r100) {
            this.f172291a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f172291a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f172290a = new HandlerC2586a(Looper.getMainLooper());
    }

    public static void a(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        r100.invoke();
        return;
    L8:
        f172290a.post(new b(r100));
        return;
    L5:
        r101 = false;
        goto L6
    }
}
