package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.TimerTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChannelCardViewNew41.a f177679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f177680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f177681c;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.a$a, reason: collision with other inner class name */
    public static final class C2635a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f177682a;

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            this.f177682a.f177680b.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public C2635a(a r100) {
            this.f177682a = r100;
        }
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.f177680b.invoke();     // Catch: Throwable -> L4
        ChannelCardViewNew41.a r100 = this.f177679a;     // Catch: Throwable -> L4
        PthreadTimer r101 = new PthreadTimer("ChannelCardViewNew41$ContentContainer$startDelayedAndPeriodicAction$$inlined$apply$lambda$1");     // Catch: Throwable -> L4
        r101.scheduleAtFixedRate(new C2635a(this), 0, this.f177681c);     // Catch: Throwable -> L4
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L4
        r100.setIntervalHandle(r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(ChannelCardViewNew41.a r100, Function0 r101, long r102) {
        this.f177679a = r100;
        this.f177680b = r101;
        this.f177681c = r102;
    }
}
