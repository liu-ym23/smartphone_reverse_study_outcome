package com.bytedance.android.livesdk.chatroom.broadcast;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.concurrent.Callable;
import jc1.k;
import kotlin.Unit;

/* JADX INFO: loaded from: classes7.dex */
public final class g<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f105287a = null;

    static {
        f105287a = new g();
    }

    public g() {
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        ((IPerformanceManager) k.n(IPerformanceManager.class)).startOpenLiveMonitor("game");
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
