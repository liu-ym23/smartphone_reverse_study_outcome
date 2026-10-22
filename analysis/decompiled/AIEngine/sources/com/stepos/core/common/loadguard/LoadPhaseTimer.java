package com.stepos.core.common.loadguard;

import java.util.ArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.g;
import n9.d;
import zb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LoadPhaseTimer {
    private final ArrayList<Pair<String, Long>> breakdown;
    private long lastNanos;
    private final a<Long> nowNanos;
    private final ArrayList<Pair<String, Long>> phases;

    public LoadPhaseTimer(a<Long> nowNanos) {
        g.f(nowNanos, "nowNanos");
        this.nowNanos = nowNanos;
        this.phases = new ArrayList<>();
        this.breakdown = new ArrayList<>();
        this.lastNanos = nowNanos.invoke().longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence summary$lambda$1(Pair it) {
        g.f(it, "it");
        return it.f9985a + "=" + it.f9986b + "ms";
    }

    public final void mark(String phase) {
        g.f(phase, "phase");
        long jLongValue = this.nowNanos.invoke().longValue();
        this.phases.add(new Pair<>(phase, Long.valueOf((jLongValue - this.lastNanos) / 1000000)));
        this.lastNanos = jLongValue;
    }

    public final void record(String phase, long j10) {
        g.f(phase, "phase");
        this.breakdown.add(new Pair<>(phase, Long.valueOf(j10)));
    }

    public final String summary() {
        return kotlin.collections.a.z0(kotlin.collections.a.D0(this.phases, this.breakdown), " ", null, null, new d(2), 30) + " total=" + totalMs() + "ms";
    }

    public final long totalMs() {
        ArrayList<Pair<String, Long>> arrayList = this.phases;
        int size = arrayList.size();
        long jLongValue = 0;
        int i10 = 0;
        while (i10 < size) {
            Pair<String, Long> pair = arrayList.get(i10);
            i10++;
            jLongValue += pair.f9986b.longValue();
        }
        return jLongValue;
    }
}
