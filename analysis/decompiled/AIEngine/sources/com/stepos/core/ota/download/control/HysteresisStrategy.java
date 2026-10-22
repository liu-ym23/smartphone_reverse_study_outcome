package com.stepos.core.ota.download.control;

import com.stepos.core.ota.domain.TriggerSource;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import zb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class HysteresisStrategy implements DownloadStrategy {
    public static final Companion Companion = new Companion(null);
    public static final long DEFAULT_DWELL_MS = 60000;
    private final a<Long> clockMs;
    private final long dwellMs;
    private StrategyOutcome last;
    private long lastChangeMs;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public HysteresisStrategy(a<Long> clockMs, long j10) {
        g.f(clockMs, "clockMs");
        this.clockMs = clockMs;
        this.dwellMs = j10;
    }

    @Override // com.stepos.core.ota.download.control.DownloadStrategy
    public final StrategyOutcome evaluate(DeviceConditions conditions, TriggerSource source) {
        g.f(conditions, "conditions");
        g.f(source, "source");
        StrategyOutcome strategyOutcomeRawEvaluate = rawEvaluate(conditions, source);
        StrategyOutcome strategyOutcome = this.last;
        if (strategyOutcome == null) {
            this.last = strategyOutcomeRawEvaluate;
            this.lastChangeMs = this.clockMs.invoke().longValue();
            return strategyOutcomeRawEvaluate;
        }
        long jLongValue = this.clockMs.invoke().longValue();
        int iH = g.h(strategyOutcomeRawEvaluate.getSeverity(), strategyOutcome.getSeverity());
        if (iH > 0) {
            this.last = strategyOutcomeRawEvaluate;
            this.lastChangeMs = jLongValue;
            return strategyOutcomeRawEvaluate;
        }
        if (iH >= 0) {
            this.last = strategyOutcomeRawEvaluate;
            return strategyOutcomeRawEvaluate;
        }
        if (jLongValue - this.lastChangeMs < this.dwellMs) {
            return strategyOutcome;
        }
        this.last = strategyOutcomeRawEvaluate;
        this.lastChangeMs = jLongValue;
        return strategyOutcomeRawEvaluate;
    }

    public abstract StrategyOutcome rawEvaluate(DeviceConditions deviceConditions, TriggerSource triggerSource);

    public /* synthetic */ HysteresisStrategy(a aVar, long j10, int i10, e eVar) {
        this(aVar, (i10 & 2) != 0 ? DEFAULT_DWELL_MS : j10);
    }
}
