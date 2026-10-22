package com.bytedance.android.shopping.orderlist.common.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f179977a = null;

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
        L5:
            e = move-exception;
            OrderCommonErrorMonitorKt.b(null, "SERIOUS_BUSINESS_ERROR", "OrderCommonThreadUtils-safeHandler: " + e.getMessage());
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f179978a;

        public b(Function0 r100) {
            this.f179978a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            this.f179978a.invoke();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f179979a = null;

        static {
            f179979a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f179980a;

        public d(Function0 r100) {
            this.f179980a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f179980a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f179981a;

        public e(Function0 r100) {
            this.f179981a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f179981a.invoke();     // Catch: Throwable -> L4
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
        f179977a = new a(Looper.getMainLooper());
    }

    public static void b(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        com.bytedance.android.ec.hybrid.card.util.a.a(new d(r100));
    }

    public static void c(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        r100.invoke();
        return;
    L8:
        f179977a.post(new e(r100));
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static void a(c53.d r100, long r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$delayInUI");
        Intrinsics.checkNotNullParameter(r102, "task");
        c53.c.a(Observable.timer(r101, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new b(r102), c.f179979a), r100);
    }
}
