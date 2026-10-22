package com.bytedance.android.ec.model.response;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/bytedance/android/ec/model/response/PopRoomInfo;", "Ljava/io/Serializable;", "receiveAddressId", "", "addressType", "roomType", "", "virtualRoomId", "", "addressStrategy", "instantRoomType", "(Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;I)V", "getAddressStrategy", "()Ljava/lang/String;", "getAddressType", "getInstantRoomType", "()I", "getReceiveAddressId", "getRoomType", "getVirtualRoomId", "()J", "setVirtualRoomId", "(J)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PopRoomInfo implements Serializable {

    @SerializedName("address_strategy_type")
    private final String addressStrategy;

    @SerializedName("address_type")
    private final String addressType;

    @SerializedName("instant_room_type")
    private final int instantRoomType;

    @SerializedName("receive_address_id")
    private final String receiveAddressId;

    @SerializedName(IPerformanceManager.Params.room_type)
    private final int roomType;

    @SerializedName("virtual_room_id")
    private long virtualRoomId;

    public PopRoomInfo() {
        this(null, null, 0, 0, null, 0, 63, null);
    }

    public static /* synthetic */ PopRoomInfo copy$default(PopRoomInfo r100, String r101, String r102, int r103, long r104, String r110, int r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L6;
        r101 = r100.receiveAddressId;
    L6:
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.addressType;
    L8:
        String r114 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.roomType;
    L11:
        int r105 = r103;
        if ((r112 & 8) == 0) goto L14;
        r104 = r100.virtualRoomId;
    L14:
        long r106 = r104;
        if ((r112 & 16) == 0) goto L17;
        r110 = r100.addressStrategy;
    L17:
        String r107 = r110;
        if ((r112 & 32) == 0) goto L20;
        r111 = r100.instantRoomType;
    L20:
        String r108 = r101;
        return r100.copy(r108, r114, r105, r106, r107, r111);
    }

    public final String component1() {
        return this.receiveAddressId;
    }

    public final String component2() {
        return this.addressType;
    }

    public final int component3() {
        return this.roomType;
    }

    public final long component4() {
        return this.virtualRoomId;
    }

    public final String component5() {
        return this.addressStrategy;
    }

    public final int component6() {
        return this.instantRoomType;
    }

    public final PopRoomInfo copy(String r110, String r111, int r112, long r113, String r114, int r115) {
        return new PopRoomInfo(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PopRoomInfo) == false) goto L18;
        PopRoomInfo r101 = (PopRoomInfo) r100;
        if (Intrinsics.areEqual(this.receiveAddressId, r101.receiveAddressId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.addressType, r101.addressType) == true) goto L10;
        return false;
    L10:
        if (this.roomType == r101.roomType) goto L12;
        return false;
    L12:
        if (this.virtualRoomId == r101.virtualRoomId) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.addressStrategy, r101.addressStrategy) == true) goto L16;
        return false;
    L16:
        if (this.instantRoomType == r101.instantRoomType) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r100 = this.receiveAddressId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.addressType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.roomType) * 31;
        long r107 = this.virtualRoomId;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.addressStrategy;
        if (r109 == null) goto L14;
        r101 = r109.hashCode();
    L14:
        return ((r108 + r101) * 31) + this.instantRoomType;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PopRoomInfo(receiveAddressId=" + this.receiveAddressId + ", addressType=" + this.addressType + ", roomType=" + this.roomType + ", virtualRoomId=" + this.virtualRoomId + ", addressStrategy=" + this.addressStrategy + ", instantRoomType=" + this.instantRoomType + ")";
    }

    public final String getAddressStrategy() {
        return this.addressStrategy;
    }

    public final String getAddressType() {
        return this.addressType;
    }

    public final int getInstantRoomType() {
        return this.instantRoomType;
    }

    public final String getReceiveAddressId() {
        return this.receiveAddressId;
    }

    public final int getRoomType() {
        return this.roomType;
    }

    public final long getVirtualRoomId() {
        return this.virtualRoomId;
    }

    public final void setVirtualRoomId(long r100) {
        this.virtualRoomId = r100;
    }

    public PopRoomInfo(String r100, String r101, int r102, long r103, String r104, int r105) {
        this.receiveAddressId = r100;
        this.addressType = r101;
        this.roomType = r102;
        this.virtualRoomId = r103;
        this.addressStrategy = r104;
        this.instantRoomType = r105;
    }

    public /* synthetic */ PopRoomInfo(String r100, String r101, int r102, long r103, String r110, int r111, int r112, DefaultConstructorMarker r113) {
        String r104 = null;
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        int r106 = 0;
    L15:
        if ((r112 & 8) == 0) goto L17;
        r103 = 0;
    L17:
        long r107 = r103;
        if ((r112 & 16) != 0) goto L22;
        r104 = r110;
    L22:
        if ((r112 & 32) == 0) goto L24;
        int r115 = 0;
    L25:
        this(r114, r105, r106, r107, r104, r115);
        return;
    L24:
        r115 = r111;
        goto L25
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
