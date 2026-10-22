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
public final class f implements com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f176480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f176481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f176482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f176483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f176484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f176485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f176486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.shopping.ligo.strategy.decision.scheduler.b f176487h;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f176488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f176489b;

        public b(f r100, Function0 r101) {
            this.f176488a = r100;
            this.f176489b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f.a(this.f176488a, this.f176489b);     // Catch: Throwable -> L4
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
    }

    @Override // com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a
    public final void cancel() {
        dm.a.a("LigoScheduler").a("scheduler [" + hashCode() + "] is canceled");
        ((Handler) this.f176480a.getValue()).removeCallbacksAndMessages(null);
        this.f176481b = 0;
        this.f176482c = false;
    }

    @Override // com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a
    public final boolean isCompleted() {
        return this.f176482c;
    }

    @Override // com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a
    public final void schedule(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        ((Handler) this.f176480a.getValue()).postDelayed(new b(this, r100), this.f176483d);
    }

    public static final void a(f r100, Function0 r101) {
        if (r100.f176486g == true) goto L10;
        com.bytedance.android.shopping.ligo.strategy.decision.scheduler.b r102 = r100.f176487h;
        if (r102 == null) goto L7;
        r102.b();
    L7:
        r101.invoke();
        dm.a.a("LigoScheduler").a("scheduler [" + r100.hashCode() + "] run " + r100.f176481b + " times.");
        r100.f176481b = r100.f176481b + 1;
        com.bytedance.android.shopping.ligo.strategy.decision.scheduler.b r103 = r100.f176487h;
        if (r103 == null) goto L10;
        r103.a();
    L10:
        r100.f176486g = false;
        int r104 = r100.f176485f;
        if (r104 == 0) goto L17;
        if (r104 > 0) goto L14;
    L16:
        r100.f176482c = true;
        return;
    L14:
        if (r100.f176481b >= r104) goto L16;
    L17:
        ((Handler) r100.f176480a.getValue()).postDelayed(new g(r100, r101), r100.f176484e);
    }

    public f(int r100, int r101, int r102, boolean r103, QueryWithMsgCacheCardShowStrategy.c r104) {
        this.f176483d = r100;
        this.f176484e = r101;
        this.f176485f = r102;
        this.f176486g = r103;
        this.f176487h = r104;
        this.f176480a = LazyKt.lazy(LigoDecisionSchedulerInterval$mainHandler$2.INSTANCE);
    }
}
