package com.stepos.aiengine.memory;

import a9.b;
import android.util.Log;
import b6.i;
import com.stepos.base.health.EngineMetrics;
import com.stepos.cpuset.c;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.coroutines.d;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import mb.k;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CameraLaunchReleaseHandler {

    /* renamed from: a, reason: collision with root package name */
    public final l<String, Integer> f5815a;

    /* renamed from: b, reason: collision with root package name */
    public final i f5816b;

    /* renamed from: c, reason: collision with root package name */
    public final zb.a<Long> f5817c;

    /* renamed from: d, reason: collision with root package name */
    public final zb.a<Long> f5818d;

    /* renamed from: e, reason: collision with root package name */
    public final zb.a<Long> f5819e;

    /* renamed from: f, reason: collision with root package name */
    public final zb.a<Integer> f5820f;

    /* renamed from: g, reason: collision with root package name */
    public final CoroutineScope f5821g;
    public final ConcurrentHashMap<Integer, Long> h;

    /* renamed from: i, reason: collision with root package name */
    public Job f5822i;

    /* renamed from: j, reason: collision with root package name */
    public final k<Integer> f5823j;

    public CameraLaunchReleaseHandler(l lVar, i iVar, b bVar) {
        c cVar = new c(2);
        com.stepos.cpuset.b bVar2 = new com.stepos.cpuset.b(4);
        c cVar2 = new c(3);
        d coroutineContext = CoroutineDispatcher.limitedParallelism$default(Dispatchers.getDefault(), 1, null, 2, null).plus(SupervisorKt.SupervisorJob$default(null, 1, null));
        g.f(coroutineContext, "coroutineContext");
        this.f5815a = lVar;
        this.f5816b = iVar;
        this.f5817c = cVar;
        this.f5818d = bVar2;
        this.f5819e = cVar2;
        this.f5820f = bVar;
        this.f5821g = CoroutineScopeKt.CoroutineScope(coroutineContext);
        this.h = new ConcurrentHashMap<>();
        this.f5823j = new k<>();
    }

    public final void a(int i10, int i11) {
        if (i10 == 30056) {
            BuildersKt__Builders_commonKt.launch$default(this.f5821g, null, null, new CameraLaunchReleaseHandler$onCameraScene$1(this, null), 3, null);
            return;
        }
        if (i10 != 30055) {
            return;
        }
        long jLongValue = this.f5817c.invoke().longValue();
        Integer numValueOf = Integer.valueOf(i11);
        ConcurrentHashMap<Integer, Long> concurrentHashMap = this.h;
        Long l10 = concurrentHashMap.get(numValueOf);
        if (l10 == null || jLongValue - l10.longValue() >= this.f5818d.invoke().longValue()) {
            concurrentHashMap.put(Integer.valueOf(i11), Long.valueOf(jLongValue));
            BuildersKt__Builders_commonKt.launch$default(this.f5821g, null, null, new CameraLaunchReleaseHandler$onCameraScene$2(this, i10, i11, null), 3, null);
            return;
        }
        AtomicLong atomicLong = EngineMetrics.f6226a;
        EngineMetrics.A.incrementAndGet();
        Log.d("CameraLaunchRelease", "camera scene=" + i10 + " uid=" + i11 + " in cooldown, skip");
    }
}
