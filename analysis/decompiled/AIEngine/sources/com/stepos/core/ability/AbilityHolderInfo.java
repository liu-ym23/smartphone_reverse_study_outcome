package com.stepos.core.ability;

import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AbilityHolderInfo {
    private final String abilityId;
    private final long ageMs;
    private final String callerPackage;
    private final int callerPid;
    private final int callerUid;
    private final String clientState;
    private final long idleTimeoutMs;
    private final int inFlight;
    private final boolean isBusy;
    private final String loadError;
    private final boolean modelHeld;
    private final List<String> modelIds;
    private final String token;

    public AbilityHolderInfo(String token, String abilityId, int i10, int i11, String callerPackage, boolean z, int i12, long j10, String clientState, boolean z3, String str, List<String> modelIds, long j11) {
        kotlin.jvm.internal.g.f(token, "token");
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(callerPackage, "callerPackage");
        kotlin.jvm.internal.g.f(clientState, "clientState");
        kotlin.jvm.internal.g.f(modelIds, "modelIds");
        this.token = token;
        this.abilityId = abilityId;
        this.callerUid = i10;
        this.callerPid = i11;
        this.callerPackage = callerPackage;
        this.isBusy = z;
        this.inFlight = i12;
        this.ageMs = j10;
        this.clientState = clientState;
        this.modelHeld = z3;
        this.loadError = str;
        this.modelIds = modelIds;
        this.idleTimeoutMs = j11;
    }

    public static /* synthetic */ AbilityHolderInfo copy$default(AbilityHolderInfo abilityHolderInfo, String str, String str2, int i10, int i11, String str3, boolean z, int i12, long j10, String str4, boolean z3, String str5, List list, long j11, int i13, Object obj) {
        long j12;
        String str6;
        AbilityHolderInfo abilityHolderInfo2;
        String str7;
        int i14;
        int i15;
        String str8;
        boolean z10;
        int i16;
        long j13;
        String str9;
        boolean z11;
        String str10;
        List list2;
        String str11 = (i13 & 1) != 0 ? abilityHolderInfo.token : str;
        String str12 = (i13 & 2) != 0 ? abilityHolderInfo.abilityId : str2;
        int i17 = (i13 & 4) != 0 ? abilityHolderInfo.callerUid : i10;
        int i18 = (i13 & 8) != 0 ? abilityHolderInfo.callerPid : i11;
        String str13 = (i13 & 16) != 0 ? abilityHolderInfo.callerPackage : str3;
        boolean z12 = (i13 & 32) != 0 ? abilityHolderInfo.isBusy : z;
        int i19 = (i13 & 64) != 0 ? abilityHolderInfo.inFlight : i12;
        long j14 = (i13 & TraceIdKeys.MAX_LENGTH) != 0 ? abilityHolderInfo.ageMs : j10;
        String str14 = (i13 & 256) != 0 ? abilityHolderInfo.clientState : str4;
        boolean z13 = (i13 & VadSessionManager.FRAME_BYTES) != 0 ? abilityHolderInfo.modelHeld : z3;
        String str15 = (i13 & 1024) != 0 ? abilityHolderInfo.loadError : str5;
        List list3 = (i13 & 2048) != 0 ? abilityHolderInfo.modelIds : list;
        if ((i13 & 4096) != 0) {
            str6 = str11;
            j12 = abilityHolderInfo.idleTimeoutMs;
            str7 = str12;
            i14 = i17;
            i15 = i18;
            str8 = str13;
            z10 = z12;
            i16 = i19;
            j13 = j14;
            str9 = str14;
            z11 = z13;
            str10 = str15;
            list2 = list3;
            abilityHolderInfo2 = abilityHolderInfo;
        } else {
            j12 = j11;
            str6 = str11;
            abilityHolderInfo2 = abilityHolderInfo;
            str7 = str12;
            i14 = i17;
            i15 = i18;
            str8 = str13;
            z10 = z12;
            i16 = i19;
            j13 = j14;
            str9 = str14;
            z11 = z13;
            str10 = str15;
            list2 = list3;
        }
        return abilityHolderInfo2.copy(str6, str7, i14, i15, str8, z10, i16, j13, str9, z11, str10, list2, j12);
    }

    public final String component1() {
        return this.token;
    }

    public final boolean component10() {
        return this.modelHeld;
    }

    public final String component11() {
        return this.loadError;
    }

    public final List<String> component12() {
        return this.modelIds;
    }

    public final long component13() {
        return this.idleTimeoutMs;
    }

    public final String component2() {
        return this.abilityId;
    }

    public final int component3() {
        return this.callerUid;
    }

    public final int component4() {
        return this.callerPid;
    }

    public final String component5() {
        return this.callerPackage;
    }

    public final boolean component6() {
        return this.isBusy;
    }

    public final int component7() {
        return this.inFlight;
    }

    public final long component8() {
        return this.ageMs;
    }

    public final String component9() {
        return this.clientState;
    }

    public final AbilityHolderInfo copy(String token, String abilityId, int i10, int i11, String callerPackage, boolean z, int i12, long j10, String clientState, boolean z3, String str, List<String> modelIds, long j11) {
        kotlin.jvm.internal.g.f(token, "token");
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(callerPackage, "callerPackage");
        kotlin.jvm.internal.g.f(clientState, "clientState");
        kotlin.jvm.internal.g.f(modelIds, "modelIds");
        return new AbilityHolderInfo(token, abilityId, i10, i11, callerPackage, z, i12, j10, clientState, z3, str, modelIds, j11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbilityHolderInfo)) {
            return false;
        }
        AbilityHolderInfo abilityHolderInfo = (AbilityHolderInfo) obj;
        return kotlin.jvm.internal.g.b(this.token, abilityHolderInfo.token) && kotlin.jvm.internal.g.b(this.abilityId, abilityHolderInfo.abilityId) && this.callerUid == abilityHolderInfo.callerUid && this.callerPid == abilityHolderInfo.callerPid && kotlin.jvm.internal.g.b(this.callerPackage, abilityHolderInfo.callerPackage) && this.isBusy == abilityHolderInfo.isBusy && this.inFlight == abilityHolderInfo.inFlight && this.ageMs == abilityHolderInfo.ageMs && kotlin.jvm.internal.g.b(this.clientState, abilityHolderInfo.clientState) && this.modelHeld == abilityHolderInfo.modelHeld && kotlin.jvm.internal.g.b(this.loadError, abilityHolderInfo.loadError) && kotlin.jvm.internal.g.b(this.modelIds, abilityHolderInfo.modelIds) && this.idleTimeoutMs == abilityHolderInfo.idleTimeoutMs;
    }

    public final String getAbilityId() {
        return this.abilityId;
    }

    public final long getAgeMs() {
        return this.ageMs;
    }

    public final String getCallerPackage() {
        return this.callerPackage;
    }

    public final int getCallerPid() {
        return this.callerPid;
    }

    public final int getCallerUid() {
        return this.callerUid;
    }

    public final String getClientState() {
        return this.clientState;
    }

    public final long getIdleTimeoutMs() {
        return this.idleTimeoutMs;
    }

    public final int getInFlight() {
        return this.inFlight;
    }

    public final String getLoadError() {
        return this.loadError;
    }

    public final boolean getModelHeld() {
        return this.modelHeld;
    }

    public final List<String> getModelIds() {
        return this.modelIds;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        int iF = ai.onnxruntime.a.f(v1.d.a(a0.a.c(ai.onnxruntime.a.d(this.inFlight, ai.onnxruntime.a.f(v1.d.a(ai.onnxruntime.a.d(this.callerPid, ai.onnxruntime.a.d(this.callerUid, v1.d.a(this.token.hashCode() * 31, 31, this.abilityId), 31), 31), 31, this.callerPackage), 31, this.isBusy), 31), this.ageMs, 31), 31, this.clientState), 31, this.modelHeld);
        String str = this.loadError;
        return Long.hashCode(this.idleTimeoutMs) + h0.e.b(this.modelIds, (iF + (str == null ? 0 : str.hashCode())) * 31, 31);
    }

    public final boolean isBusy() {
        return this.isBusy;
    }

    public String toString() {
        String str = this.token;
        String str2 = this.abilityId;
        int i10 = this.callerUid;
        int i11 = this.callerPid;
        String str3 = this.callerPackage;
        boolean z = this.isBusy;
        int i12 = this.inFlight;
        long j10 = this.ageMs;
        String str4 = this.clientState;
        boolean z3 = this.modelHeld;
        String str5 = this.loadError;
        List<String> list = this.modelIds;
        long j11 = this.idleTimeoutMs;
        StringBuilder sbS = ai.onnxruntime.a.s("AbilityHolderInfo(token=", str, ", abilityId=", str2, ", callerUid=");
        h0.e.l(sbS, i10, ", callerPid=", i11, ", callerPackage=");
        sbS.append(str3);
        sbS.append(", isBusy=");
        sbS.append(z);
        sbS.append(", inFlight=");
        com.stepos.core.ota.d.s(sbS, i12, ", ageMs=", j10);
        sbS.append(", clientState=");
        sbS.append(str4);
        sbS.append(", modelHeld=");
        sbS.append(z3);
        sbS.append(", loadError=");
        sbS.append(str5);
        sbS.append(", modelIds=");
        sbS.append(list);
        return a0.a.d(j11, ", idleTimeoutMs=", ")", sbS);
    }
}
