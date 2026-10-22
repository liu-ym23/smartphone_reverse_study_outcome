package com.stepos.core.ota.download.control;

import a0.a;
import com.stepos.core.ota.domain.PauseReason;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DownloadVerdict {
    public static final Companion Companion = new Companion(null);
    private static final DownloadVerdict FULL = new DownloadVerdict(DownloadRegime.FULL, 0, null, null, 14, null);
    private final String by;
    private final long maxRateBytesPerSec;
    private final PauseReason reason;
    private final DownloadRegime regime;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final DownloadVerdict getFULL() {
            return DownloadVerdict.FULL;
        }

        private Companion() {
        }
    }

    public DownloadVerdict(DownloadRegime regime, long j10, PauseReason pauseReason, String by) {
        g.f(regime, "regime");
        g.f(by, "by");
        this.regime = regime;
        this.maxRateBytesPerSec = j10;
        this.reason = pauseReason;
        this.by = by;
    }

    public static /* synthetic */ DownloadVerdict copy$default(DownloadVerdict downloadVerdict, DownloadRegime downloadRegime, long j10, PauseReason pauseReason, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            downloadRegime = downloadVerdict.regime;
        }
        if ((i10 & 2) != 0) {
            j10 = downloadVerdict.maxRateBytesPerSec;
        }
        if ((i10 & 4) != 0) {
            pauseReason = downloadVerdict.reason;
        }
        if ((i10 & 8) != 0) {
            str = downloadVerdict.by;
        }
        return downloadVerdict.copy(downloadRegime, j10, pauseReason, str);
    }

    public final DownloadRegime component1() {
        return this.regime;
    }

    public final long component2() {
        return this.maxRateBytesPerSec;
    }

    public final PauseReason component3() {
        return this.reason;
    }

    public final String component4() {
        return this.by;
    }

    public final DownloadVerdict copy(DownloadRegime regime, long j10, PauseReason pauseReason, String by) {
        g.f(regime, "regime");
        g.f(by, "by");
        return new DownloadVerdict(regime, j10, pauseReason, by);
    }

    public final String describe() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.regime);
        if (isThrottled()) {
            sb2.append("(");
            sb2.append(this.maxRateBytesPerSec / 1024);
            sb2.append("KB/s)");
        }
        PauseReason pauseReason = this.reason;
        if (pauseReason != null) {
            sb2.append(" reason=");
            sb2.append(pauseReason);
        }
        if (this.by.length() > 0) {
            sb2.append(" by=");
            sb2.append(this.by);
        }
        return sb2.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadVerdict)) {
            return false;
        }
        DownloadVerdict downloadVerdict = (DownloadVerdict) obj;
        return this.regime == downloadVerdict.regime && this.maxRateBytesPerSec == downloadVerdict.maxRateBytesPerSec && this.reason == downloadVerdict.reason && g.b(this.by, downloadVerdict.by);
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

    public int hashCode() {
        int iC = a.c(this.regime.hashCode() * 31, this.maxRateBytesPerSec, 31);
        PauseReason pauseReason = this.reason;
        return this.by.hashCode() + ((iC + (pauseReason == null ? 0 : pauseReason.hashCode())) * 31);
    }

    public final boolean isStop() {
        DownloadRegime downloadRegime = this.regime;
        return downloadRegime == DownloadRegime.SUSPENDED || downloadRegime == DownloadRegime.ABORTED;
    }

    public final boolean isThrottled() {
        return this.regime == DownloadRegime.THROTTLED;
    }

    public String toString() {
        return "DownloadVerdict(regime=" + this.regime + ", maxRateBytesPerSec=" + this.maxRateBytesPerSec + ", reason=" + this.reason + ", by=" + this.by + ")";
    }

    public /* synthetic */ DownloadVerdict(DownloadRegime downloadRegime, long j10, PauseReason pauseReason, String str, int i10, e eVar) {
        this(downloadRegime, (i10 & 2) != 0 ? 0L : j10, (i10 & 4) != 0 ? null : pauseReason, (i10 & 8) != 0 ? "" : str);
    }
}
