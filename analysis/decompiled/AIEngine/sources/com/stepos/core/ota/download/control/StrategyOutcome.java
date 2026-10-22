package com.stepos.core.ota.download.control;

import ai.onnxruntime.a;
import com.stepos.core.ota.domain.PauseReason;
import dc.h;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class StrategyOutcome {
    public static final Companion Companion = new Companion(null);
    private final String by;
    private final long maxRateBytesPerSec;
    private final PauseReason reason;
    private final DownloadRegime regime;
    private final boolean veto;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final StrategyOutcome full(String by) {
            g.f(by, "by");
            return new StrategyOutcome(DownloadRegime.FULL, 0L, false, null, by, 14, null);
        }

        private Companion() {
        }
    }

    public StrategyOutcome(DownloadRegime regime, long j10, boolean z, PauseReason pauseReason, String by) {
        g.f(regime, "regime");
        g.f(by, "by");
        this.regime = regime;
        this.maxRateBytesPerSec = j10;
        this.veto = z;
        this.reason = pauseReason;
        this.by = by;
    }

    public static /* synthetic */ StrategyOutcome copy$default(StrategyOutcome strategyOutcome, DownloadRegime downloadRegime, long j10, boolean z, PauseReason pauseReason, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            downloadRegime = strategyOutcome.regime;
        }
        if ((i10 & 2) != 0) {
            j10 = strategyOutcome.maxRateBytesPerSec;
        }
        if ((i10 & 4) != 0) {
            z = strategyOutcome.veto;
        }
        if ((i10 & 8) != 0) {
            pauseReason = strategyOutcome.reason;
        }
        if ((i10 & 16) != 0) {
            str = strategyOutcome.by;
        }
        String str2 = str;
        boolean z3 = z;
        return strategyOutcome.copy(downloadRegime, j10, z3, pauseReason, str2);
    }

    public final DownloadRegime component1() {
        return this.regime;
    }

    public final long component2() {
        return this.maxRateBytesPerSec;
    }

    public final boolean component3() {
        return this.veto;
    }

    public final PauseReason component4() {
        return this.reason;
    }

    public final String component5() {
        return this.by;
    }

    public final StrategyOutcome copy(DownloadRegime regime, long j10, boolean z, PauseReason pauseReason, String by) {
        g.f(regime, "regime");
        g.f(by, "by");
        return new StrategyOutcome(regime, j10, z, pauseReason, by);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StrategyOutcome)) {
            return false;
        }
        StrategyOutcome strategyOutcome = (StrategyOutcome) obj;
        return this.regime == strategyOutcome.regime && this.maxRateBytesPerSec == strategyOutcome.maxRateBytesPerSec && this.veto == strategyOutcome.veto && this.reason == strategyOutcome.reason && g.b(this.by, strategyOutcome.by);
    }

    public final String getBy() {
        return this.by;
    }

    public final long getMaxRateBytesPerSec() {
        return this.maxRateBytesPerSec;
    }

    public final PauseReason getReason() {
        return this.reason;
    }

    public final DownloadRegime getRegime() {
        return this.regime;
    }

    public final long getSeverity() {
        return (this.regime.ordinal() * 1000000000) + (this.regime == DownloadRegime.THROTTLED ? 1000000000 - h.b0(this.maxRateBytesPerSec, 0L, 999999999L) : 0L);
    }

    public final boolean getVeto() {
        return this.veto;
    }

    public int hashCode() {
        int iF = a.f(a0.a.c(this.regime.hashCode() * 31, this.maxRateBytesPerSec, 31), 31, this.veto);
        PauseReason pauseReason = this.reason;
        return this.by.hashCode() + ((iF + (pauseReason == null ? 0 : pauseReason.hashCode())) * 31);
    }

    public String toString() {
        DownloadRegime downloadRegime = this.regime;
        long j10 = this.maxRateBytesPerSec;
        boolean z = this.veto;
        PauseReason pauseReason = this.reason;
        String str = this.by;
        StringBuilder sb2 = new StringBuilder("StrategyOutcome(regime=");
        sb2.append(downloadRegime);
        sb2.append(", maxRateBytesPerSec=");
        sb2.append(j10);
        sb2.append(", veto=");
        sb2.append(z);
        sb2.append(", reason=");
        sb2.append(pauseReason);
        return a.p(sb2, ", by=", str, ")");
    }

    public /* synthetic */ StrategyOutcome(DownloadRegime downloadRegime, long j10, boolean z, PauseReason pauseReason, String str, int i10, e eVar) {
        this(downloadRegime, (i10 & 2) != 0 ? 0L : j10, (i10 & 4) != 0 ? false : z, (i10 & 8) != 0 ? null : pauseReason, (i10 & 16) != 0 ? "" : str);
    }
}
