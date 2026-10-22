package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0018\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR$\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR$\u0010\u001e\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016¨\u0006!"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/h;", "", "", "itemType", "Ljava/lang/Integer;", "getItemType", "()Ljava/lang/Integer;", "setItemType", "(Ljava/lang/Integer;)V", "", "appointmentText", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setAppointmentText", "(Ljava/lang/String;)V", "", "appointmentId", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "setAppointmentId", "(Ljava/lang/Long;)V", "Lcom/bytedance/android/window/shop/repository/dto/AppointmentStatus;", "appointmentStatus", "c", "setAppointmentStatus", "appointmentSchema", "b", "setAppointmentSchema", "productNum", "getProductNum", "setProductNum", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("appointment_id")
    private Long appointmentId;

    @SerializedName("appointment_shcema")
    private String appointmentSchema;

    @SerializedName("appointment_status")
    private Integer appointmentStatus;

    @SerializedName("appointment_text")
    private String appointmentText;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private Integer itemType;

    @SerializedName("product_num")
    private Long productNum;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L18;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.itemType, r101.itemType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.appointmentText, r101.appointmentText) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.appointmentId, r101.appointmentId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appointmentStatus, r101.appointmentStatus) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.appointmentSchema, r101.appointmentSchema) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.productNum, r101.productNum) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.itemType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.appointmentText;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.appointmentId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.appointmentStatus;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.appointmentSchema;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.productNum;
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

    public final String toString() {
        return "ShopHotLiveAppointmentDTO(itemType=" + this.itemType + ", appointmentText=" + this.appointmentText + ", appointmentId=" + this.appointmentId + ", appointmentStatus=" + this.appointmentStatus + ", appointmentSchema=" + this.appointmentSchema + ", productNum=" + this.productNum + ")";
    }

    public h() {
        this.itemType = null;
        this.appointmentText = null;
        this.appointmentId = null;
        this.appointmentStatus = null;
        this.appointmentSchema = null;
        this.productNum = null;
    }

    public final Long a() {
        return this.appointmentId;
    }

    public final String b() {
        return this.appointmentSchema;
    }

    public final Integer c() {
        return this.appointmentStatus;
    }

    public final String d() {
        return this.appointmentText;
    }
}
