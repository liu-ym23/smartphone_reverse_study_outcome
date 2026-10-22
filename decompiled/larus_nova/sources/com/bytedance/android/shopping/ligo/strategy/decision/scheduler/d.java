package com.bytedance.android.shopping.ligo.strategy.decision.scheduler;

import android.os.Handler;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.QueryWithMsgCacheCardShowStrategy;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f176473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f176474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f176475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f176476d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f176477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f176478b;

        public a(d r100, Function0 r101) {
            this.f176477a = r100;
            this.f176478b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f176477a.f176476d;     // Catch: Throwable -> L10
            if (r100 == null) goto L5;
            r100.b();     // Catch: Throwable -> L10
        L5:
            this.f176478b.invoke();     // Catch: Throwable -> L10
            b r101 = this.f176477a.f176476d;     // Catch: Throwable -> L10
            if (r101 == null) goto L8;
            r101.a();     // Catch: Throwable -> L10
        L8:
            this.f176477a.f176473a = true;     // Catch: Throwable -> L10
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
        ((Handler) this.f176474b.getValue()).removeCallbacksAndMessages(null);
        this.f176473a = false;
    }

    @Override // com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a
    public final boolean isCompleted() {
        return this.f176473a;
    }

    @Override // com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a
    public final void schedule(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        ((Handler) this.f176474b.getValue()).postDelayed(new a(this, r100), this.f176475c);
    }

    public d(int r100, QueryWithMsgCacheCardShowStrategy.c r101) {
        this.f176475c = r100;
        this.f176476d = r101;
        this.f176474b = LazyKt.lazy(LigoDecisionSchedulerDelayRun$mainHandler$2.INSTANCE);
    }
}
