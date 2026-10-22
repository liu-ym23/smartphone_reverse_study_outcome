package com.bytedance.android.shopping.ligo.strategy.decision.scheduler;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.QueryWithMsgCacheCardShowStrategy;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f176468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f176469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f176470c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f176471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f176472b;

        public a(c r100, Function0 r101) {
            this.f176471a = r100;
            this.f176472b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f176471a.f176470c;     // Catch: Throwable -> L10
            if (r100 == null) goto L5;
            r100.b();     // Catch: Throwable -> L10
        L5:
            this.f176472b.invoke();     // Catch: Throwable -> L10
            b r101 = this.f176471a.f176470c;     // Catch: Throwable -> L10
            if (r101 == null) goto L8;
            r101.a();     // Catch: Throwable -> L10
        L8:
            this.f176471a.f176468a = true;     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a
    public final void cancel() {
    }

    @Override // com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a
    public final boolean isCompleted() {
        return this.f176468a;
    }

    public c(QueryWithMsgCacheCardShowStrategy.c r100) {
        this.f176470c = r100;
        this.f176469b = LazyKt.lazy(LigoDecisionSchedulerDefault$mainHandler$2.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a
    public final void schedule(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L14;
        b r102 = this.f176470c;
        if (r102 == null) goto L10;
        r102.b();
    L10:
        r100.invoke();
        b r103 = this.f176470c;
        if (r103 == null) goto L13;
        r103.a();
    L13:
        this.f176468a = true;
        return;
    L14:
        ((Handler) this.f176469b.getValue()).post(new a(this, r100));
        return;
    L5:
        r101 = false;
        goto L6
    }
}
