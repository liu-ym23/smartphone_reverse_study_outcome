package com.bytedance.android.ec.model.sku;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003JJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0002\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;", "Ljava/io/Serializable;", "isAdapted", "", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "carDesc", "", "url", "adaptResult", "(Ljava/lang/Boolean;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdaptResult", "()Ljava/lang/String;", "getCarDesc", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;", "equals", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class CarAdaptComponent implements Serializable {

    @SerializedName("adapt_result")
    private final String adaptResult;

    @SerializedName("car_desc")
    private final String carDesc;

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName("is_adapted")
    private final Boolean isAdapted;

    @SerializedName("url")
    private final String url;

    public CarAdaptComponent() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ CarAdaptComponent copy$default(CarAdaptComponent r100, Boolean r101, ECUrlModel r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.isAdapted;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.icon;
    L8:
        ECUrlModel r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.carDesc;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.url;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.adaptResult;
    L17:
        Boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Boolean component1() {
        return this.isAdapted;
    }

    public final ECUrlModel component2() {
        return this.icon;
    }

    public final String component3() {
        return this.carDesc;
    }

    public final String component4() {
        return this.url;
    }

    public final String component5() {
        return this.adaptResult;
    }

    public final CarAdaptComponent copy(Boolean r100, ECUrlModel r101, String r110, String r111, String r112) {
        return new CarAdaptComponent(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CarAdaptComponent) == false) goto L16;
        CarAdaptComponent r101 = (CarAdaptComponent) r100;
        if (Intrinsics.areEqual(this.isAdapted, r101.isAdapted) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.carDesc, r101.carDesc) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.adaptResult, r101.adaptResult) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        Boolean r100 = this.isAdapted;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.icon;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.carDesc;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.url;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.adaptResult;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "CarAdaptComponent(isAdapted=" + this.isAdapted + ", icon=" + this.icon + ", carDesc=" + this.carDesc + ", url=" + this.url + ", adaptResult=" + this.adaptResult + ")";
    }

    public final String getAdaptResult() {
        return this.adaptResult;
    }

    public final String getCarDesc() {
        return this.carDesc;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Boolean isAdapted() {
        return this.isAdapted;
    }

    public CarAdaptComponent(Boolean r100, ECUrlModel r101, String r102, String r103, String r104) {
        this.isAdapted = r100;
        this.icon = r101;
        this.carDesc = r102;
        this.url = r103;
        this.adaptResult = r104;
    }

    public /* synthetic */ CarAdaptComponent(Boolean r100, ECUrlModel r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        Boolean r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        ECUrlModel r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
