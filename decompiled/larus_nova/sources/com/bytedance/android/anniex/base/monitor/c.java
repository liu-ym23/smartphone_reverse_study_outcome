package com.bytedance.android.anniex.base.monitor;

import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class c<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MonitorCenter f40302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f40303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f40304c;

    public c(MonitorCenter r100, String r101, String r102) {
        this.f40302a = r100;
        this.f40303b = r101;
        this.f40304c = r102;
    }

    @Override // java.util.concurrent.Callable
    public final Unit call() {
        MonitorCenter.b r100 = this.f40302a.f40291b.get(this.f40303b);
        if (r100 == null) goto L11;
        String r101 = this.f40304c;
        MonitorCenter r102 = this.f40302a;
        if (r101 == null) goto L8;
        r100.getClass();
        throw null;
    L8:
        MapsKt.mapOf(new Pair[]{TuplesKt.to("event_type", "event_type_container"), TuplesKt.to("container_event", "container_event_navigate_fail")});
        r102.getClass();
        throw null;
    L11:
        return Unit.INSTANCE;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
