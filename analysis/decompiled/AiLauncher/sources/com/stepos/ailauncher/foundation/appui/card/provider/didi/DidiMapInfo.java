package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/N;", "", "", "eta", "distance", "distanceKm", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Double;", "c", "()Ljava/lang/Double;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.N, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class DidiMapInfo {

    @SerializedName("distance")
    private final Double distance;

    @SerializedName("distanceKm")
    private final Double distanceKm;

    @SerializedName("eta")
    private final Double eta;

    public DidiMapInfo() {
        this(null, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final Double getDistance() {
        return this.distance;
    }

    /* renamed from: b, reason: from getter */
    public final Double getDistanceKm() {
        return this.distanceKm;
    }

    /* renamed from: c, reason: from getter */
    public final Double getEta() {
        return this.eta;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DidiMapInfo)) {
            return false;
        }
        DidiMapInfo didiMapInfo = (DidiMapInfo) other;
        return kotlin.jvm.internal.p.d(this.eta, didiMapInfo.eta) && kotlin.jvm.internal.p.d(this.distance, didiMapInfo.distance) && kotlin.jvm.internal.p.d(this.distanceKm, didiMapInfo.distanceKm);
    }

    public int hashCode() {
        Double d10 = this.eta;
        int iHashCode = (d10 == null ? 0 : d10.hashCode()) * 31;
        Double d11 = this.distance;
        int iHashCode2 = (iHashCode + (d11 == null ? 0 : d11.hashCode())) * 31;
        Double d12 = this.distanceKm;
        return iHashCode2 + (d12 != null ? d12.hashCode() : 0);
    }

    public String toString() {
        return "DidiMapInfo(eta=" + this.eta + ", distance=" + this.distance + ", distanceKm=" + this.distanceKm + ")";
    }

    public DidiMapInfo(Double d10, Double d11, Double d12) {
        this.eta = d10;
        this.distance = d11;
        this.distanceKm = d12;
    }

    public /* synthetic */ DidiMapInfo(Double d10, Double d11, Double d12, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : d10, (i10 & 2) != 0 ? null : d11, (i10 & 4) != 0 ? null : d12);
    }
}
