package com.bytedance.android.shopping.sku.common.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f182780a = null;

    public static final class a extends Handler {
        public a(Looper r100) {
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

    public static final class b implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f182781a;

        public b(Function0 r100) {
            this.f182781a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f182781a.invoke();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f182782a;

        public c(Function0 r100) {
            this.f182782a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f182782a.invoke();
        }
    }

    public final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f182783a;

        public d(Function0 r100) {
            this.f182783a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f182783a.invoke();     // Catch: Throwable -> L4
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
        f182780a = new a(Looper.getMainLooper());
    }

    public static void b(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        r100.invoke();
        return;
    L8:
        f182780a.post(new d(r100));
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static Disposable a(com.bytedance.android.ec.core.async.b r100, long r101, Function0 r102, Function0 r103) {
        Intrinsics.checkNotNullParameter(r100, "disposableScope");
        Intrinsics.checkNotNullParameter(r102, "task");
        Intrinsics.checkNotNullParameter(r103, "errorTask");
        return com.bytedance.android.ec.core.async.a.a(Completable.timer(r101, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new b(r102), new c(r103)), r100);
    }
}
