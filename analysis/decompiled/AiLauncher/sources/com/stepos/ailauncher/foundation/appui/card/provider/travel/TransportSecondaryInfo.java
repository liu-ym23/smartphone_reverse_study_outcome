package com.stepos.ailauncher.foundation.appui.card.provider.travel;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\nR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0017\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/v;", "", "", "", "tags", "stopType", "trainType", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "c", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.travel.v, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class TransportSecondaryInfo {
    private final String stopType;
    private final List<String> tags;

    @SerializedName(alternate = {"train_type", "vehicleType", "trainModel"}, value = "trainType")
    private final String trainType;

    public TransportSecondaryInfo() {
        this(null, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getStopType() {
        return this.stopType;
    }

    public final List<String> b() {
        return this.tags;
    }

    /* renamed from: c, reason: from getter */
    public final String getTrainType() {
        return this.trainType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransportSecondaryInfo)) {
            return false;
        }
        TransportSecondaryInfo transportSecondaryInfo = (TransportSecondaryInfo) other;
        return kotlin.jvm.internal.p.d(this.tags, transportSecondaryInfo.tags) && kotlin.jvm.internal.p.d(this.stopType, transportSecondaryInfo.stopType) && kotlin.jvm.internal.p.d(this.trainType, transportSecondaryInfo.trainType);
    }

    public int hashCode() {
        List<String> list = this.tags;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.stopType;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.trainType;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "TransportSecondaryInfo(tags=" + this.tags + ", stopType=" + this.stopType + ", trainType=" + this.trainType + ")";
    }

    public TransportSecondaryInfo(List<String> list, String str, String str2) {
        this.tags = list;
        this.stopType = str;
        this.trainType = str2;
    }

    public /* synthetic */ TransportSecondaryInfo(List list, String str, String str2, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : list, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2);
    }
}
