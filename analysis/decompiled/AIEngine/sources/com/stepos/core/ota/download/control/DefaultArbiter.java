package com.stepos.core.ota.download.control;

import com.stepos.core.ota.domain.TriggerSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import mb.l;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DefaultArbiter implements DownloadArbiter {
    private final Set<TriggerSource> exemptSources;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultArbiter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final StrategyOutcome relax(StrategyOutcome strategyOutcome) {
        return strategyOutcome.getRegime() == DownloadRegime.THROTTLED ? StrategyOutcome.copy$default(strategyOutcome, DownloadRegime.FULL, 0L, false, null, null, 28, null) : strategyOutcome;
    }

    @Override // com.stepos.core.ota.download.control.DownloadArbiter
    public DownloadVerdict combine(List<StrategyOutcome> outcomes, TriggerSource source) {
        Object next;
        Object next2;
        Object next3;
        long maxRateBytesPerSec;
        g.f(outcomes, "outcomes");
        g.f(source, "source");
        if (outcomes.isEmpty()) {
            return DownloadVerdict.Companion.getFULL();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : outcomes) {
            if (((StrategyOutcome) obj).getVeto()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        Long l10 = null;
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long severity = ((StrategyOutcome) next).getSeverity();
                do {
                    Object next4 = it.next();
                    long severity2 = ((StrategyOutcome) next4).getSeverity();
                    if (severity < severity2) {
                        next = next4;
                        severity = severity2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        StrategyOutcome strategyOutcome = (StrategyOutcome) next;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : outcomes) {
            if (!((StrategyOutcome) obj2).getVeto()) {
                arrayList2.add(obj2);
            }
        }
        Iterator it2 = arrayList2.iterator();
        if (it2.hasNext()) {
            next2 = it2.next();
            if (it2.hasNext()) {
                Long lValueOf = Long.valueOf(((StrategyOutcome) next2).getSeverity());
                do {
                    Object next5 = it2.next();
                    Long lValueOf2 = Long.valueOf(((StrategyOutcome) next5).getSeverity());
                    if (lValueOf.compareTo(lValueOf2) < 0) {
                        next2 = next5;
                        lValueOf = lValueOf2;
                    }
                } while (it2.hasNext());
            }
        } else {
            next2 = null;
        }
        StrategyOutcome strategyOutcomeRelax = (StrategyOutcome) next2;
        if (strategyOutcomeRelax != null && this.exemptSources.contains(source)) {
            strategyOutcomeRelax = relax(strategyOutcomeRelax);
        }
        Iterator it3 = l.d0(new StrategyOutcome[]{strategyOutcome, strategyOutcomeRelax}).iterator();
        if (it3.hasNext()) {
            next3 = it3.next();
            if (it3.hasNext()) {
                Long lValueOf3 = Long.valueOf(((StrategyOutcome) next3).getSeverity());
                do {
                    Object next6 = it3.next();
                    Long lValueOf4 = Long.valueOf(((StrategyOutcome) next6).getSeverity());
                    if (lValueOf3.compareTo(lValueOf4) < 0) {
                        next3 = next6;
                        lValueOf3 = lValueOf4;
                    }
                } while (it3.hasNext());
            }
        } else {
            next3 = null;
        }
        StrategyOutcome strategyOutcome2 = (StrategyOutcome) next3;
        if (strategyOutcome2 == null) {
            return DownloadVerdict.Companion.getFULL();
        }
        if (strategyOutcome2.getRegime() == DownloadRegime.THROTTLED) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : outcomes) {
                if (((StrategyOutcome) obj3).getRegime() == DownloadRegime.THROTTLED) {
                    arrayList3.add(obj3);
                }
            }
            Iterator it4 = arrayList3.iterator();
            if (it4.hasNext()) {
                Long lValueOf5 = Long.valueOf(((StrategyOutcome) it4.next()).getMaxRateBytesPerSec());
                loop3: while (true) {
                    l10 = lValueOf5;
                    while (it4.hasNext()) {
                        lValueOf5 = Long.valueOf(((StrategyOutcome) it4.next()).getMaxRateBytesPerSec());
                        if (l10.compareTo(lValueOf5) > 0) {
                            break;
                        }
                    }
                }
            }
            maxRateBytesPerSec = l10 != null ? l10.longValue() : strategyOutcome2.getMaxRateBytesPerSec();
        } else {
            maxRateBytesPerSec = strategyOutcome2.getMaxRateBytesPerSec();
        }
        return new DownloadVerdict(strategyOutcome2.getRegime(), maxRateBytesPerSec, strategyOutcome2.getReason(), strategyOutcome2.getBy());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultArbiter(Set<? extends TriggerSource> exemptSources) {
        g.f(exemptSources, "exemptSources");
        this.exemptSources = exemptSources;
    }

    public /* synthetic */ DefaultArbiter(Set set, int i10, e eVar) {
        this((i10 & 1) != 0 ? y.M(TriggerSource.USER) : set);
    }
}
