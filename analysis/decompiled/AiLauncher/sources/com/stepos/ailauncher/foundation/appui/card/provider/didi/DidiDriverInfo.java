package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0016\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0017\u0010\u000bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/I;", "", "", "name", "carColor", "carBrand", "carModel", "carNumber", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "e", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "c", Const.INTENT_KEY_UMID, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.I, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class DidiDriverInfo {

    @SerializedName("carBrand")
    private final String carBrand;

    @SerializedName("carColor")
    private final String carColor;

    @SerializedName("carModel")
    private final String carModel;

    @SerializedName("carNumber")
    private final String carNumber;

    @SerializedName("name")
    private final String name;

    public DidiDriverInfo() {
        this(null, null, null, null, null, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getCarBrand() {
        return this.carBrand;
    }

    /* renamed from: b, reason: from getter */
    public final String getCarColor() {
        return this.carColor;
    }

    /* renamed from: c, reason: from getter */
    public final String getCarModel() {
        return this.carModel;
    }

    /* renamed from: d, reason: from getter */
    public final String getCarNumber() {
        return this.carNumber;
    }

    /* renamed from: e, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DidiDriverInfo)) {
            return false;
        }
        DidiDriverInfo didiDriverInfo = (DidiDriverInfo) other;
        return kotlin.jvm.internal.p.d(this.name, didiDriverInfo.name) && kotlin.jvm.internal.p.d(this.carColor, didiDriverInfo.carColor) && kotlin.jvm.internal.p.d(this.carBrand, didiDriverInfo.carBrand) && kotlin.jvm.internal.p.d(this.carModel, didiDriverInfo.carModel) && kotlin.jvm.internal.p.d(this.carNumber, didiDriverInfo.carNumber);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.carColor;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.carBrand;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.carModel;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.carNumber;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "DidiDriverInfo(name=" + this.name + ", carColor=" + this.carColor + ", carBrand=" + this.carBrand + ", carModel=" + this.carModel + ", carNumber=" + this.carNumber + ")";
    }

    public DidiDriverInfo(String str, String str2, String str3, String str4, String str5) {
        this.name = str;
        this.carColor = str2;
        this.carBrand = str3;
        this.carModel = str4;
        this.carNumber = str5;
    }

    public /* synthetic */ DidiDriverInfo(String str, String str2, String str3, String str4, String str5, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5);
    }
}
