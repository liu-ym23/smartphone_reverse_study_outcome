package com.bytedance.android.anniex.base.monitor;

import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes43.dex */
public final class b<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MonitorCenter f40299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f40300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f40301c;

    public b(MonitorCenter r100, String r101, long r102) {
        this.f40299a = r100;
        this.f40300b = r101;
        this.f40301c = r102;
    }

    @Override // java.util.concurrent.Callable
    public final Unit call() {
        MonitorCenter.b r100 = this.f40299a.f40291b.get(this.f40300b);
        if (r100 == null) goto L5;
        r100.getClass();
        throw null;
    L5:
        return Unit.INSTANCE;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
