package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003JW\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\nHÖ\u0001R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006%"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/ExchangeCoupons;", "Ljava/io/Serializable;", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "mainMainDescription", "Lcom/bytedance/android/ec/model/response/anchorv3/Description;", "subDescription", "button", "backgroundColor", "", "", "schema", "(Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/response/anchorv3/Description;Lcom/bytedance/android/ec/model/response/anchorv3/Description;Lcom/bytedance/android/ec/model/response/anchorv3/Description;Ljava/util/List;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/util/List;", "getButton", "()Lcom/bytedance/android/ec/model/response/anchorv3/Description;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getMainMainDescription", "getSchema", "()Ljava/lang/String;", "getSubDescription", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ExchangeCoupons implements Serializable {

    @SerializedName("background_color")
    private final List<String> backgroundColor;

    @SerializedName("button")
    private final Description button;

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName("main_description")
    private final Description mainMainDescription;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("sub_description")
    private final Description subDescription;

    public ExchangeCoupons() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExchangeCoupons copy$default(ExchangeCoupons r100, ECUrlModel r101, Description r102, Description r103, Description r104, List r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.icon;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.mainMainDescription;
    L8:
        Description r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.subDescription;
    L11:
        Description r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.button;
    L14:
        Description r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.backgroundColor;
    L17:
        List r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.schema;
    L20:
        ECUrlModel r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final ECUrlModel component1() {
        return this.icon;
    }

    public final Description component2() {
        return this.mainMainDescription;
    }

    public final Description component3() {
        return this.subDescription;
    }

    public final Description component4() {
        return this.button;
    }

    public final List<String> component5() {
        return this.backgroundColor;
    }

    public final String component6() {
        return this.schema;
    }

    public final ExchangeCoupons copy(ECUrlModel r100, Description r110, Description r111, Description r112, List<String> r113, String r114) {
        return new ExchangeCoupons(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ExchangeCoupons) == false) goto L18;
        ExchangeCoupons r101 = (ExchangeCoupons) r100;
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.mainMainDescription, r101.mainMainDescription) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.subDescription, r101.subDescription) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.button, r101.button) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        ECUrlModel r100 = this.icon;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Description r104 = this.mainMainDescription;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Description r107 = this.subDescription;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Description r110 = this.button;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.backgroundColor;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.schema;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
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
        return "ExchangeCoupons(icon=" + this.icon + ", mainMainDescription=" + this.mainMainDescription + ", subDescription=" + this.subDescription + ", button=" + this.button + ", backgroundColor=" + this.backgroundColor + ", schema=" + this.schema + ")";
    }

    public final List<String> getBackgroundColor() {
        return this.backgroundColor;
    }

    public final Description getButton() {
        return this.button;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final Description getMainMainDescription() {
        return this.mainMainDescription;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final Description getSubDescription() {
        return this.subDescription;
    }

    public ExchangeCoupons(ECUrlModel r100, Description r101, Description r102, Description r103, List<String> r104, String r105) {
        this.icon = r100;
        this.mainMainDescription = r101;
        this.subDescription = r102;
        this.button = r103;
        this.backgroundColor = r104;
        this.schema = r105;
    }

    public /* synthetic */ ExchangeCoupons(ECUrlModel r100, Description r101, Description r102, Description r103, List r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        ECUrlModel r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Description r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        Description r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        Description r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        List r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        String r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
