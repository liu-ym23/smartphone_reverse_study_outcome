package com.bytedance.android.annie.service.prefetch;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.tools.prefetch.ProcessManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes43.dex */
public final class z<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f39999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.tools.prefetch.i.a f40000b;

    public z(String r100, ProcessManager.b r101) {
        this.f39999a = r100;
        this.f40000b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        HybridLogger r101 = HybridLogger.f246343a;
        HybridLogger.m("PrefetchNetwork", "Failed: " + this.f39999a, null, null, 12);
        this.f40000b.a((Throwable) r100);
    }
}
