package com.bytedance.android.anniex.base.monitor;

import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class d<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MonitorCenter f40305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f40306b;

    public d(MonitorCenter r100, String r101) {
        this.f40305a = r100;
        this.f40306b = r101;
    }

    @Override // java.util.concurrent.Callable
    public final Unit call() {
        if (this.f40305a.f40291b.get(this.f40306b) == null) goto L5;
        MonitorCenter r100 = this.f40305a;
        MapsKt.mapOf(new Pair[]{TuplesKt.to("event_type", "event_type_container"), TuplesKt.to("container_event", "container_event_navigate_success")});
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
