package com.stepos.core.ota.download.control;

import f.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class ThermalBand {
    private final Float below;
    private final String mode;
    private final int rateMBps;

    public ThermalBand() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ ThermalBand copy$default(ThermalBand thermalBand, Float f8, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f8 = thermalBand.below;
        }
        if ((i11 & 2) != 0) {
            str = thermalBand.mode;
        }
        if ((i11 & 4) != 0) {
            i10 = thermalBand.rateMBps;
        }
        return thermalBand.copy(f8, str, i10);
    }

    public final Float component1() {
        return this.below;
    }

    public final String component2() {
        return this.mode;
    }

    public final int component3() {
        return this.rateMBps;
    }

    public final ThermalBand copy(Float f8, String mode, int i10) {
        g.f(mode, "mode");
        return new ThermalBand(f8, mode, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThermalBand)) {
            return false;
        }
        ThermalBand thermalBand = (ThermalBand) obj;
        return g.b(this.below, thermalBand.below) && g.b(this.mode, thermalBand.mode) && this.rateMBps == thermalBand.rateMBps;
    }

    public final Float getBelow() {
        return this.below;
    }

    public final String getMode() {
        return this.mode;
    }

    public final int getRateMBps() {
        return this.rateMBps;
    }

    public int hashCode() {
        Float f8 = this.below;
        return Integer.hashCode(this.rateMBps) + d.a((f8 == null ? 0 : f8.hashCode()) * 31, 31, this.mode);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004c, code lost:
    
        if (r0.equals("stop") == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0056, code lost:
    
        if (r0.equals("suspend") == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
    
        return new com.stepos.core.ota.download.control.StrategyOutcome(com.stepos.core.ota.download.control.DownloadRegime.SUSPENDED, 0, true, com.stepos.core.ota.domain.PauseReason.THERMAL, r7, 2, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.core.ota.download.control.StrategyOutcome toOutcome(java.lang.String r12) {
        /*
            r11 = this;
            java.lang.String r0 = "by"
            kotlin.jvm.internal.g.f(r12, r0)
            java.lang.String r0 = r11.mode
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r0 = r0.toLowerCase(r1)
            java.lang.String r1 = "toLowerCase(...)"
            kotlin.jvm.internal.g.e(r0, r1)
            int r1 = r0.hashCode()
            r2 = -1852006340(0xffffffff919ca03c, float:-2.4711212E-28)
            if (r1 == r2) goto L4f
            r2 = 3540994(0x360802, float:4.96199E-39)
            if (r1 == r2) goto L45
            r2 = 1483442986(0x586b8b2a, float:1.03593175E15)
            if (r1 == r2) goto L27
        L25:
            r7 = r12
            goto L58
        L27:
            java.lang.String r1 = "throttle"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L30
            goto L25
        L30:
            com.stepos.core.ota.download.control.StrategyOutcome r1 = new com.stepos.core.ota.download.control.StrategyOutcome
            com.stepos.core.ota.download.control.DownloadRegime r2 = com.stepos.core.ota.download.control.DownloadRegime.THROTTLED
            int r11 = r11.rateMBps
            long r3 = (long) r11
            r5 = 1048576(0x100000, double:5.180654E-318)
            long r3 = r3 * r5
            r8 = 8
            r9 = 0
            r5 = 1
            r6 = 0
            r7 = r12
            r1.<init>(r2, r3, r5, r6, r7, r8, r9)
            return r1
        L45:
            r7 = r12
            java.lang.String r11 = "stop"
            boolean r11 = r0.equals(r11)
            if (r11 != 0) goto L5f
            goto L58
        L4f:
            r7 = r12
            java.lang.String r11 = "suspend"
            boolean r11 = r0.equals(r11)
            if (r11 != 0) goto L5f
        L58:
            com.stepos.core.ota.download.control.StrategyOutcome$Companion r11 = com.stepos.core.ota.download.control.StrategyOutcome.Companion
            com.stepos.core.ota.download.control.StrategyOutcome r11 = r11.full(r7)
            return r11
        L5f:
            com.stepos.core.ota.download.control.StrategyOutcome r2 = new com.stepos.core.ota.download.control.StrategyOutcome
            com.stepos.core.ota.download.control.DownloadRegime r3 = com.stepos.core.ota.download.control.DownloadRegime.SUSPENDED
            r8 = r7
            com.stepos.core.ota.domain.PauseReason r7 = com.stepos.core.ota.domain.PauseReason.THERMAL
            r9 = 2
            r10 = 0
            r4 = 0
            r6 = 1
            r2.<init>(r3, r4, r6, r7, r8, r9, r10)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.download.control.ThermalBand.toOutcome(java.lang.String):com.stepos.core.ota.download.control.StrategyOutcome");
    }

    public String toString() {
        Float f8 = this.below;
        String str = this.mode;
        int i10 = this.rateMBps;
        StringBuilder sb2 = new StringBuilder("ThermalBand(below=");
        sb2.append(f8);
        sb2.append(", mode=");
        sb2.append(str);
        sb2.append(", rateMBps=");
        return ai.onnxruntime.a.j(")", i10, sb2);
    }

    public ThermalBand(Float f8, String mode, int i10) {
        g.f(mode, "mode");
        this.below = f8;
        this.mode = mode;
        this.rateMBps = i10;
    }

    public /* synthetic */ ThermalBand(Float f8, String str, int i10, int i11, e eVar) {
        this((i11 & 1) != 0 ? null : f8, (i11 & 2) != 0 ? "full" : str, (i11 & 4) != 0 ? 0 : i10);
    }
}
