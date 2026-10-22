package com.bytedance.android.anniex.base.monitor;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes43.dex */
public final class e<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MonitorCenter f40307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f40308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List<String> f40309c;

    public e(MonitorCenter r100, String r101, List<String> r102) {
        this.f40307a = r100;
        this.f40308b = r101;
        this.f40309c = r102;
    }

    @Override // java.util.concurrent.Callable
    public final String call() {
        MonitorCenter.b r100 = this.f40307a.f40291b.get(this.f40308b);
        if (r100 == null) goto L7;
        r100.getClass();
        return null;
    L7:
        return null;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
