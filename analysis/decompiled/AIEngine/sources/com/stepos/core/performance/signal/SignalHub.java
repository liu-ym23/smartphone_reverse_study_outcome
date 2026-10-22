package com.stepos.core.performance.signal;

import android.content.Context;
import com.stepos.base.health.EngineMetrics;
import com.stepos.core.performance.data.AicGroupPressureLevel;
import com.stepos.core.performance.data.SignalSnapshot;
import dc.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;
import zb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SignalHub {
    private volatile int aicgroupAvailKb;
    private volatile boolean aicgroupAvailable;
    private volatile AicGroupPressureLevel aicgroupOverride;
    private volatile AicGroupPressureLevel aicgroupPressureLevel;
    private volatile long aicgroupSnapshotMonoNs;
    private volatile long avgInitMemoryMb;
    private volatile long avgInitTimeMs;
    private volatile long avgInvokeTimeMs;
    private volatile long avgTtftMs;
    private volatile long backgroundEntryTimeMs;
    private final SystemStateCollector collector;
    private final Context context;
    private volatile String currentModelId;
    private volatile int healthScore;
    private final List<a<n>> invalidators;
    private volatile boolean isForeground;
    private volatile Integer trimMemoryLevel;

    public SignalHub(Context context, SystemStateCollector collector) {
        g.f(context, "context");
        g.f(collector, "collector");
        this.context = context;
        this.collector = collector;
        this.isForeground = true;
        this.healthScore = 100;
        this.aicgroupPressureLevel = AicGroupPressureLevel.NORMAL;
        this.invalidators = new ArrayList();
    }

    private final int computeHealthScore() {
        AtomicLong atomicLong = EngineMetrics.f6226a;
        long j10 = EngineMetrics.f6226a.get();
        if (j10 == 0) {
            return 100;
        }
        return h.a0((int) ((1.0f - (EngineMetrics.f6227b.get() / j10)) * 100.0f), 0, 100);
    }

    private final void notifyInvalidators() {
        this.collector.invalidate();
        synchronized (this.invalidators) {
            try {
                Iterator<T> it = this.invalidators.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).invoke();
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final SignalSnapshot collect() {
        long jCurrentTimeMillis = 0;
        if (!this.isForeground && this.backgroundEntryTimeMs > 0) {
            jCurrentTimeMillis = System.currentTimeMillis() - this.backgroundEntryTimeMs;
        }
        long j10 = jCurrentTimeMillis;
        updateHealthScore(computeHealthScore());
        AicGroupPressureLevel aicGroupPressureLevel = this.aicgroupOverride;
        AicGroupPressureLevel aicGroupPressureLevel2 = aicGroupPressureLevel == null ? this.aicgroupPressureLevel : aicGroupPressureLevel;
        boolean z = aicGroupPressureLevel != null || this.aicgroupAvailable;
        SystemStateCollector systemStateCollector = this.collector;
        boolean z3 = this.isForeground;
        Integer num = this.trimMemoryLevel;
        AtomicLong atomicLong = EngineMetrics.f6226a;
        return systemStateCollector.collect(z3, j10, num, EngineMetrics.f6228c.get(), EngineMetrics.f6226a.get(), EngineMetrics.f6227b.get(), this.healthScore, this.currentModelId, this.avgInitTimeMs, this.avgInitMemoryMb, this.avgInvokeTimeMs, this.avgTtftMs, aicGroupPressureLevel2, this.aicgroupAvailKb, this.aicgroupSnapshotMonoNs, z);
    }

    public final Integer getTrimMemoryLevel() {
        return this.trimMemoryLevel;
    }

    public final void invalidate() {
        notifyInvalidators();
    }

    public final boolean isForeground() {
        return this.isForeground;
    }

    public final SignalSnapshot lastSnapshot() {
        return collect();
    }

    public final void refreshCpuTopology() {
        this.collector.refreshCpuTopology();
    }

    public final void registerInvalidator(a<n> onInvalidate) {
        g.f(onInvalidate, "onInvalidate");
        synchronized (this.invalidators) {
            this.invalidators.add(onInvalidate);
        }
    }

    public final void reportAicgroupPressure(AicGroupPressureLevel level, int i10, long j10) {
        g.f(level, "level");
        this.aicgroupPressureLevel = level;
        this.aicgroupAvailKb = i10;
        this.aicgroupSnapshotMonoNs = j10;
        this.aicgroupAvailable = true;
        notifyInvalidators();
    }

    public final void reportAicgroupUnavailable() {
        this.aicgroupPressureLevel = AicGroupPressureLevel.NORMAL;
        this.aicgroupAvailKb = 0;
        this.aicgroupSnapshotMonoNs = 0L;
        this.aicgroupAvailable = false;
    }

    public final void reportForegroundChange(boolean z) {
        if (this.isForeground != z) {
            this.isForeground = z;
            this.backgroundEntryTimeMs = !z ? System.currentTimeMillis() : 0L;
            notifyInvalidators();
        }
    }

    public final void reportTrimMemory(int i10) {
        this.trimMemoryLevel = Integer.valueOf(i10);
        notifyInvalidators();
    }

    public final void setAicgroupOverride(AicGroupPressureLevel aicGroupPressureLevel) {
        this.aicgroupOverride = aicGroupPressureLevel;
        notifyInvalidators();
    }

    public final void updateHealthScore(int i10) {
        this.healthScore = h.a0(i10, 0, 100);
    }

    public final void updateModelHistory(String str, long j10, long j11, long j12, long j13) {
        this.currentModelId = str;
        this.avgInitTimeMs = j10;
        this.avgInitMemoryMb = j11;
        this.avgInvokeTimeMs = j12;
        this.avgTtftMs = j13;
    }

    public /* synthetic */ SignalHub(Context context, SystemStateCollector systemStateCollector, int i10, e eVar) {
        if ((i10 & 2) != 0) {
            IPerformanceDataProvider iPerformanceDataProviderTryLoadAicpuset = SignalHubKt.tryLoadAicpuset();
            systemStateCollector = new SystemStateCollector(context, iPerformanceDataProviderTryLoadAicpuset == null ? new FallbackDataProvider() : iPerformanceDataProviderTryLoadAicpuset);
        }
        this(context, systemStateCollector);
    }
}
