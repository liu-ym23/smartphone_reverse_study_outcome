package com.stepos.core.ota.domain;

import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import h0.e;
import java.util.Set;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaStateSnapshot {
    private final boolean cellularAllowed;
    private final int installedVersion;
    private final String otaId;
    private final TriggerSource primarySource;
    private final int progress;
    private final boolean recoveredAfterInterruption;
    private final Set<TriggerSource> sources;
    private final OtaState state;
    private final long updatedAtMonotonicMs;
    private final boolean wantsDownload;

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public OtaStateSnapshot(java.lang.String r15, com.stepos.core.ota.domain.OtaState r16, int r17, int r18, long r19, java.util.Set r21, com.stepos.core.ota.domain.TriggerSource r22, boolean r23, boolean r24, boolean r25, int r26, kotlin.jvm.internal.e r27) {
        /*
            r14 = this;
            r0 = r26
            r1 = r0 & 32
            if (r1 == 0) goto La
            kotlin.collections.EmptySet r1 = kotlin.collections.EmptySet.f10003a
            r9 = r1
            goto Lc
        La:
            r9 = r21
        Lc:
            r1 = r0 & 64
            if (r1 == 0) goto L13
            r1 = 0
            r10 = r1
            goto L15
        L13:
            r10 = r22
        L15:
            r1 = r0 & 128(0x80, float:1.8E-43)
            r2 = 0
            if (r1 == 0) goto L1c
            r11 = r2
            goto L1e
        L1c:
            r11 = r23
        L1e:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L24
            r12 = r2
            goto L26
        L24:
            r12 = r24
        L26:
            r0 = r0 & 512(0x200, float:7.17E-43)
            if (r0 == 0) goto L36
            r13 = r2
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r2 = r14
            goto L42
        L36:
            r13 = r25
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
        L42:
            r2.<init>(r3, r4, r5, r6, r7, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.domain.OtaStateSnapshot.<init>(java.lang.String, com.stepos.core.ota.domain.OtaState, int, int, long, java.util.Set, com.stepos.core.ota.domain.TriggerSource, boolean, boolean, boolean, int, kotlin.jvm.internal.e):void");
    }

    public static /* synthetic */ OtaStateSnapshot copy$default(OtaStateSnapshot otaStateSnapshot, String str, OtaState otaState, int i10, int i11, long j10, Set set, TriggerSource triggerSource, boolean z, boolean z3, boolean z10, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = otaStateSnapshot.otaId;
        }
        if ((i12 & 2) != 0) {
            otaState = otaStateSnapshot.state;
        }
        if ((i12 & 4) != 0) {
            i10 = otaStateSnapshot.progress;
        }
        if ((i12 & 8) != 0) {
            i11 = otaStateSnapshot.installedVersion;
        }
        if ((i12 & 16) != 0) {
            j10 = otaStateSnapshot.updatedAtMonotonicMs;
        }
        if ((i12 & 32) != 0) {
            set = otaStateSnapshot.sources;
        }
        if ((i12 & 64) != 0) {
            triggerSource = otaStateSnapshot.primarySource;
        }
        if ((i12 & TraceIdKeys.MAX_LENGTH) != 0) {
            z = otaStateSnapshot.cellularAllowed;
        }
        if ((i12 & 256) != 0) {
            z3 = otaStateSnapshot.recoveredAfterInterruption;
        }
        if ((i12 & VadSessionManager.FRAME_BYTES) != 0) {
            z10 = otaStateSnapshot.wantsDownload;
        }
        boolean z11 = z10;
        boolean z12 = z;
        Set set2 = set;
        long j11 = j10;
        int i13 = i10;
        int i14 = i11;
        return otaStateSnapshot.copy(str, otaState, i13, i14, j11, set2, triggerSource, z12, z3, z11);
    }

    public final String component1() {
        return this.otaId;
    }

    public final boolean component10() {
        return this.wantsDownload;
    }

    public final OtaState component2() {
        return this.state;
    }

    public final int component3() {
        return this.progress;
    }

    public final int component4() {
        return this.installedVersion;
    }

    public final long component5() {
        return this.updatedAtMonotonicMs;
    }

    public final Set<TriggerSource> component6() {
        return this.sources;
    }

    public final TriggerSource component7() {
        return this.primarySource;
    }

    public final boolean component8() {
        return this.cellularAllowed;
    }

    public final boolean component9() {
        return this.recoveredAfterInterruption;
    }

    public final OtaStateSnapshot copy(String otaId, OtaState state, int i10, int i11, long j10, Set<? extends TriggerSource> sources, TriggerSource triggerSource, boolean z, boolean z3, boolean z10) {
        g.f(otaId, "otaId");
        g.f(state, "state");
        g.f(sources, "sources");
        return new OtaStateSnapshot(otaId, state, i10, i11, j10, sources, triggerSource, z, z3, z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OtaStateSnapshot)) {
            return false;
        }
        OtaStateSnapshot otaStateSnapshot = (OtaStateSnapshot) obj;
        return g.b(this.otaId, otaStateSnapshot.otaId) && g.b(this.state, otaStateSnapshot.state) && this.progress == otaStateSnapshot.progress && this.installedVersion == otaStateSnapshot.installedVersion && this.updatedAtMonotonicMs == otaStateSnapshot.updatedAtMonotonicMs && g.b(this.sources, otaStateSnapshot.sources) && this.primarySource == otaStateSnapshot.primarySource && this.cellularAllowed == otaStateSnapshot.cellularAllowed && this.recoveredAfterInterruption == otaStateSnapshot.recoveredAfterInterruption && this.wantsDownload == otaStateSnapshot.wantsDownload;
    }

    public final boolean getCellularAllowed() {
        return this.cellularAllowed;
    }

    public final int getInstalledVersion() {
        return this.installedVersion;
    }

    public final String getOtaId() {
        return this.otaId;
    }

    public final TriggerSource getPrimarySource() {
        return this.primarySource;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final boolean getRecoveredAfterInterruption() {
        return this.recoveredAfterInterruption;
    }

    public final boolean getShowNotification() {
        return TriggerSourcePolicy.INSTANCE.shouldShowNotification(this.sources);
    }

    public final Set<TriggerSource> getSources() {
        return this.sources;
    }

    public final OtaState getState() {
        return this.state;
    }

    public final long getUpdatedAtMonotonicMs() {
        return this.updatedAtMonotonicMs;
    }

    public final boolean getWantsDownload() {
        return this.wantsDownload;
    }

    public int hashCode() {
        int iHashCode = (this.sources.hashCode() + a0.a.c(ai.onnxruntime.a.d(this.installedVersion, ai.onnxruntime.a.d(this.progress, (this.state.hashCode() + (this.otaId.hashCode() * 31)) * 31, 31), 31), this.updatedAtMonotonicMs, 31)) * 31;
        TriggerSource triggerSource = this.primarySource;
        return Boolean.hashCode(this.wantsDownload) + ai.onnxruntime.a.f(ai.onnxruntime.a.f((iHashCode + (triggerSource == null ? 0 : triggerSource.hashCode())) * 31, 31, this.cellularAllowed), 31, this.recoveredAfterInterruption);
    }

    public final boolean isForeground() {
        return this.sources.contains(TriggerSource.USER);
    }

    public String toString() {
        String str = this.otaId;
        OtaState otaState = this.state;
        int i10 = this.progress;
        int i11 = this.installedVersion;
        long j10 = this.updatedAtMonotonicMs;
        Set<TriggerSource> set = this.sources;
        TriggerSource triggerSource = this.primarySource;
        boolean z = this.cellularAllowed;
        boolean z3 = this.recoveredAfterInterruption;
        boolean z10 = this.wantsDownload;
        StringBuilder sb2 = new StringBuilder("OtaStateSnapshot(otaId=");
        sb2.append(str);
        sb2.append(", state=");
        sb2.append(otaState);
        sb2.append(", progress=");
        e.l(sb2, i10, ", installedVersion=", i11, ", updatedAtMonotonicMs=");
        sb2.append(j10);
        sb2.append(", sources=");
        sb2.append(set);
        sb2.append(", primarySource=");
        sb2.append(triggerSource);
        sb2.append(", cellularAllowed=");
        sb2.append(z);
        sb2.append(", recoveredAfterInterruption=");
        sb2.append(z3);
        sb2.append(", wantsDownload=");
        sb2.append(z10);
        sb2.append(")");
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OtaStateSnapshot(String otaId, OtaState state, int i10, int i11, long j10, Set<? extends TriggerSource> sources, TriggerSource triggerSource, boolean z, boolean z3, boolean z10) {
        g.f(otaId, "otaId");
        g.f(state, "state");
        g.f(sources, "sources");
        this.otaId = otaId;
        this.state = state;
        this.progress = i10;
        this.installedVersion = i11;
        this.updatedAtMonotonicMs = j10;
        this.sources = sources;
        this.primarySource = triggerSource;
        this.cellularAllowed = z;
        this.recoveredAfterInterruption = z3;
        this.wantsDownload = z10;
    }
}
