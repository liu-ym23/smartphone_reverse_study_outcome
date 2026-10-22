package com.bytedance.android.livesdk.chatroom.broadcast.v2.service;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f105501a = null;

    static {
        f105501a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        ((IPerformanceManager) jc1.k.n(IPerformanceManager.class)).onModuleStop(IPerformanceManager.MODULE_LIVE_FIRST_DURATION);
        ((IPerformanceManager) jc1.k.n(IPerformanceManager.class)).onModuleStart(IPerformanceManager.MODULE_LIVE_SECOND_DURATION, null);
    }
}
