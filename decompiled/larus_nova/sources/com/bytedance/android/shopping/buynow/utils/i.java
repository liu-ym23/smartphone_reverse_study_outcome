package com.bytedance.android.shopping.buynow.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f171212a = null;

    public static final class a extends Handler {
        public a(Looper r100) {
            Intrinsics.checkNotNullParameter(r100, "looper");
            super(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
            super.handleMessage(r100);     // Catch: Throwable -> L5
            Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L7:
            Result.m9452exceptionOrNullimpl(r102);
            return;
        L5:
            th = move-exception;
            Result.Companion r103 = Result.Companion;
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L7
        }
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f171213a;

        public b(Function0 r100) {
            this.f171213a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f171213a.invoke();     // Catch: Throwable -> L4
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
        f171212a = new a(Looper.getMainLooper());
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
        f171212a.post(new b(r100));
        return;
    L5:
        r101 = false;
        goto L6
    }
}
