package com.bytedance.android.live.schema.api.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.crash.dumper.Scraps;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class OptimizeMainThreadScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f100500a = null;

    public static final class a extends Scheduler.Worker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile boolean f100501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f100502b;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f100501a = true;
            this.f100502b.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f100501a;
        }

        public a(Handler r100) {
            Intrinsics.checkNotNullParameter(r100, "handler");
            this.f100502b = r100;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable r100, long r101, TimeUnit r102) {
            Intrinsics.checkNotNullParameter(r100, "run");
            Intrinsics.checkNotNullParameter(r102, Scraps.INNER_UNIT);
            if (this.f100501a == true) goto L5;
            Runnable r103 = RxJavaPlugins.onSchedule(r100);
            Lazy r104 = OptimizeMainThreadScheduler.f100500a;
            if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
            boolean r105 = true;
        L10:
            if (r105 == true) goto L12;
        L15:
            c r106 = new c(this.f100502b, r103);
            Message r107 = Message.obtain(this.f100502b, r106);
            r107.obj = this;
            this.f100502b.sendMessageDelayed(r107, r102.toMillis(r101));
            if (this.f100501a == false) goto L19;
            this.f100502b.removeCallbacks(r106);
            return Disposables.disposed();
        L19:
            return r106;
        L12:
            if (r101 != 0) goto L15;
            r103.run();
            return Disposables.disposed();
        L9:
            r105 = false;
            goto L10
        L5:
            return Disposables.disposed();
        }
    }

    public static final class b extends Scheduler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f100503a;

        public b() {
            Handler r100 = new Handler(Looper.getMainLooper());
            Intrinsics.checkNotNullParameter(r100, "handler");
            this.f100503a = r100;
        }

        @Override // io.reactivex.Scheduler
        public final Scheduler.Worker createWorker() {
            return new a(this.f100503a);
        }

        @Override // io.reactivex.Scheduler
        public final Disposable scheduleDirect(Runnable r100, long r101, TimeUnit r102) {
            Intrinsics.checkNotNullParameter(r100, "run");
            Intrinsics.checkNotNullParameter(r102, Scraps.INNER_UNIT);
            Runnable r103 = RxJavaPlugins.onSchedule(r100);
            Lazy r104 = OptimizeMainThreadScheduler.f100500a;
            if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
            boolean r105 = true;
        L6:
            if (r105 == true) goto L8;
        L11:
            c r106 = new c(this.f100503a, r103);
            Message r107 = Message.obtain(this.f100503a, r106);
            this.f100503a.sendMessageDelayed(r107, r102.toMillis(r101));
            return r106;
        L8:
            if (r101 != 0) goto L11;
            r103.run();
            return Disposables.disposed();
        L5:
            r105 = false;
            goto L6
        }
    }

    public static final class c implements Runnable, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile boolean f100504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f100505b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f100506c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f100505b.removeCallbacks(this);
            this.f100504a = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f100506c.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            RxJavaPlugins.onError(th);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f100504a;
        }

        public c(Handler r100, Runnable r101) {
            Intrinsics.checkNotNullParameter(r100, "handler");
            Intrinsics.checkNotNullParameter(r101, "delegate");
            this.f100505b = r100;
            this.f100506c = r101;
        }
    }

    public OptimizeMainThreadScheduler() {
    }

    static {
        f100500a = LazyKt.lazy(OptimizeMainThreadScheduler$mainThread$2.INSTANCE);
    }
}
