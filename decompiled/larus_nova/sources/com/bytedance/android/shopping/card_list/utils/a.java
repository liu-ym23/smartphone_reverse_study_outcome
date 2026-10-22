package com.bytedance.android.shopping.card_list.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HandlerC2575a f171911a = null;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.card_list.utils.a$a, reason: collision with other inner class name */
    public static final class HandlerC2575a extends Handler {
        public HandlerC2575a(Looper r100) {
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
        public final /* synthetic */ Function0 f171912a;

        public b(Function0 r100) {
            this.f171912a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f171912a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a() {
    }

    static {
        f171911a = new HandlerC2575a(Looper.getMainLooper());
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
        f171911a.post(new b(r100));
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static void a(CardListObjectContainer r100, long r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "disposableScope");
        Intrinsics.checkNotNullParameter(r102, "task");
        com.bytedance.android.ec.core.async.a.a(Completable.timer(r101, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.shopping.card_list.utils.b(r102), new c(null)), r100);
    }
}
