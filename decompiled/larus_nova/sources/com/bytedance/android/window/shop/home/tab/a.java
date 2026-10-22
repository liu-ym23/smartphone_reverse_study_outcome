package com.bytedance.android.window.shop.home.tab;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f188707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f188708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Scheduler f188709c;

    /* JADX INFO: renamed from: com.bytedance.android.window.shop.home.tab.a$a, reason: collision with other inner class name */
    public final class RunnableC2754a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<Unit> f188710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f188711b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f188710a.invoke();     // Catch: Throwable -> L4 Exception -> L6
        L8:
            this.f188711b.f188707a.decrementAndGet();     // Catch: Throwable -> L9
            return;
        L6:
            e = move-exception;
            ECExceptionMonitor.e(e);     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            this.f188711b.f188707a.decrementAndGet();     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        }

        public RunnableC2754a(a r100, Function0<Unit> r101) {
            Intrinsics.checkNotNullParameter(r101, "realRunnable");
            this.f188711b = r100;
            this.f188710a = r101;
            r100.f188707a.incrementAndGet();
        }
    }

    public a() {
        Scheduler r100 = Schedulers.computation();
        Intrinsics.checkNotNullParameter(r100, "scheduler");
        this.f188708b = 10;
        this.f188709c = r100;
        this.f188707a = new AtomicInteger(0);
    }

    public final void a(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        if (this.f188707a.get() <= this.f188708b) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        this.f188709c.scheduleDirect(new RunnableC2754a(this, r100));
        return;
    L8:
        r100.invoke();
        return;
    L5:
        r101 = false;
        goto L6
    }
}
