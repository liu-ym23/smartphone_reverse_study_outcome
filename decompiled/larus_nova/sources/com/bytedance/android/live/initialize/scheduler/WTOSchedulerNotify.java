package com.bytedance.android.live.initialize.scheduler;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import wa0.b;
import wa0.c;

/* JADX INFO: loaded from: classes45.dex */
public final class WTOSchedulerNotify {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f69416d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f69417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f69418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f69419c;

    public static final class a {
    }

    static {
    }

    public final CopyOnWriteArrayList<c> a() {
        return (CopyOnWriteArrayList) this.f69417a.getValue();
    }

    public WTOSchedulerNotify() {
        this.f69417a = LazyKt.lazy(WTOSchedulerNotify$taskListenerList$2.INSTANCE);
        this.f69418b = LazyKt.lazy(WTOSchedulerNotify$scheduleListenerList$2.INSTANCE);
        this.f69419c = LazyKt.lazy(new WTOSchedulerNotify$msgDispatcher$2(this));
    }

    public final com.bytedance.android.live.initialize.model.a b(final b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((CopyOnWriteArrayList) this.f69418b.getValue()).add(r100);
        return new com.bytedance.android.live.initialize.model.a(this, new WTOSchedulerNotify$registerScheduleListener$1(r100));
    }

    public final com.bytedance.android.live.initialize.model.a c(final c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        a().add(r100);
        return new com.bytedance.android.live.initialize.model.a(this, new WTOSchedulerNotify$registerTaskListener$1(r100));
    }

    public final void d(int r100, Object r101) {
        ((Handler) this.f69419c.getValue()).sendMessage(((Handler) this.f69419c.getValue()).obtainMessage(r100, r101));
    }
}
