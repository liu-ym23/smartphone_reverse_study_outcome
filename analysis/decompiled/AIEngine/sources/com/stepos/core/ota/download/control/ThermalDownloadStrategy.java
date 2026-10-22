package com.stepos.core.ota.download.control;

import com.stepos.core.ota.domain.TriggerSource;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import zb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ThermalDownloadStrategy extends HysteresisStrategy {
    public static final Companion Companion = new Companion(null);
    public static final String ID = "thermal";
    private final a<ThermalRateConfig> config;

    /* renamed from: id, reason: collision with root package name */
    private final String f7573id;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThermalDownloadStrategy(a<Long> clockMs, a<ThermalRateConfig> config) {
        super(clockMs, 0L, 2, null);
        g.f(clockMs, "clockMs");
        g.f(config, "config");
        this.config = config;
        this.f7573id = ID;
    }

    @Override // com.stepos.core.ota.download.control.DownloadStrategy
    public String getId() {
        return this.f7573id;
    }

    @Override // com.stepos.core.ota.download.control.HysteresisStrategy
    public StrategyOutcome rawEvaluate(DeviceConditions conditions, TriggerSource source) {
        g.f(conditions, "conditions");
        g.f(source, "source");
        Float f8 = (Float) conditions.get(DeviceConditions.Companion.getTEMPERATURE_C());
        if (f8 == null) {
            return StrategyOutcome.Companion.full(getId());
        }
        return this.config.invoke().outcomeFor(f8.floatValue(), getId());
    }
}
