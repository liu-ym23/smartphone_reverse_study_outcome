package com.stepos.core.ota.download.control;

import f.a;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.b;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class ThermalRateConfig {
    public static final Companion Companion = new Companion(null);
    private static final ThermalRateConfig DEFAULT;
    private final String active;
    private final Map<String, List<ThermalBand>> schemes;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final ThermalRateConfig getDEFAULT() {
            return ThermalRateConfig.DEFAULT;
        }

        private Companion() {
        }
    }

    static {
        Float fValueOf = Float.valueOf(32.0f);
        ThermalBand thermalBand = new ThermalBand(fValueOf, "throttle", 5);
        Float fValueOf2 = Float.valueOf(34.0f);
        ThermalBand thermalBand2 = new ThermalBand(fValueOf2, "throttle", 5);
        Float fValueOf3 = Float.valueOf(36.0f);
        ThermalBand thermalBand3 = new ThermalBand(fValueOf3, "throttle", 5);
        Float fValueOf4 = Float.valueOf(38.0f);
        DEFAULT = new ThermalRateConfig("scheme_1", b.g0(new Pair("scheme_1", m.b0(thermalBand, thermalBand2, thermalBand3, new ThermalBand(fValueOf4, "throttle", 5), new ThermalBand(null, "throttle", 5))), new Pair("scheme_2", m.b0(new ThermalBand(fValueOf, "throttle", 5), new ThermalBand(fValueOf2, "throttle", 5), new ThermalBand(fValueOf3, "throttle", 5), new ThermalBand(fValueOf4, "throttle", 5), new ThermalBand(Float.valueOf(40.0f), "throttle", 5), new ThermalBand(null, "throttle", 5)))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ThermalRateConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ThermalRateConfig copy$default(ThermalRateConfig thermalRateConfig, String str, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = thermalRateConfig.active;
        }
        if ((i10 & 2) != 0) {
            map = thermalRateConfig.schemes;
        }
        return thermalRateConfig.copy(str, map);
    }

    public final String component1() {
        return this.active;
    }

    public final Map<String, List<ThermalBand>> component2() {
        return this.schemes;
    }

    public final ThermalRateConfig copy(String active, Map<String, ? extends List<ThermalBand>> schemes) {
        g.f(active, "active");
        g.f(schemes, "schemes");
        return new ThermalRateConfig(active, schemes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThermalRateConfig)) {
            return false;
        }
        ThermalRateConfig thermalRateConfig = (ThermalRateConfig) obj;
        return g.b(this.active, thermalRateConfig.active) && g.b(this.schemes, thermalRateConfig.schemes);
    }

    public final String getActive() {
        return this.active;
    }

    public final Map<String, List<ThermalBand>> getSchemes() {
        return this.schemes;
    }

    public int hashCode() {
        return this.schemes.hashCode() + (this.active.hashCode() * 31);
    }

    public final StrategyOutcome outcomeFor(float f8, String by) {
        ThermalBand thermalBand;
        Object next;
        g.f(by, "by");
        List<ThermalBand> list = this.schemes.get(this.active);
        if (list == null && (list = (List) kotlin.collections.a.u0(this.schemes.values())) == null) {
            return StrategyOutcome.Companion.full(by);
        }
        Iterator<T> it = list.iterator();
        while (true) {
            thermalBand = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            ThermalBand thermalBand2 = (ThermalBand) next;
            if (thermalBand2.getBelow() != null && f8 < thermalBand2.getBelow().floatValue()) {
                break;
            }
        }
        ThermalBand thermalBand3 = (ThermalBand) next;
        if (thermalBand3 == null) {
            ListIterator<ThermalBand> listIterator = list.listIterator(list.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    break;
                }
                ThermalBand thermalBandPrevious = listIterator.previous();
                if (thermalBandPrevious.getBelow() == null) {
                    thermalBand = thermalBandPrevious;
                    break;
                }
            }
            thermalBand3 = thermalBand;
            if (thermalBand3 == null) {
                return StrategyOutcome.Companion.full(by);
            }
        }
        return thermalBand3.toOutcome(by);
    }

    public String toString() {
        return "ThermalRateConfig(active=" + this.active + ", schemes=" + this.schemes + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ThermalRateConfig(String active, Map<String, ? extends List<ThermalBand>> schemes) {
        g.f(active, "active");
        g.f(schemes, "schemes");
        this.active = active;
        this.schemes = schemes;
    }

    public /* synthetic */ ThermalRateConfig(String str, Map map, int i10, e eVar) {
        this((i10 & 1) != 0 ? "scheme_1" : str, (i10 & 2) != 0 ? b.d0() : map);
    }
}
