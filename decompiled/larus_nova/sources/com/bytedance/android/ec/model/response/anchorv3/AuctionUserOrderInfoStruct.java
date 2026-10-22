package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/AuctionUserOrderInfoStruct;", "Ljava/io/Serializable;", "userName", "", "userAvatar", "price", "", "recordTime", "textStatus", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getPrice", "()J", "getRecordTime", "()Ljava/lang/String;", "getTextStatus", "getUserAvatar", "getUserName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class AuctionUserOrderInfoStruct implements Serializable {

    @SerializedName("price")
    private final long price;

    @SerializedName("record_time")
    private final String recordTime;

    @SerializedName("text_status")
    private final String textStatus;

    @SerializedName("user_avatar")
    private final String userAvatar;

    @SerializedName(ITwitterService.ResponseConstants.USER_NAME)
    private final String userName;

    public static /* synthetic */ AuctionUserOrderInfoStruct copy$default(AuctionUserOrderInfoStruct r100, String r101, String r102, long r103, String r104, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.userName;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.userAvatar;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.price;
    L11:
        long r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.recordTime;
    L14:
        String r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.textStatus;
    L17:
        String r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    public final String component1() {
        return this.userName;
    }

    public final String component2() {
        return this.userAvatar;
    }

    public final long component3() {
        return this.price;
    }

    public final String component4() {
        return this.recordTime;
    }

    public final String component5() {
        return this.textStatus;
    }

    public final AuctionUserOrderInfoStruct copy(String r100, String r110, long r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r112, "recordTime");
        Intrinsics.checkNotNullParameter(r113, "textStatus");
        return new AuctionUserOrderInfoStruct(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AuctionUserOrderInfoStruct) == false) goto L16;
        AuctionUserOrderInfoStruct r101 = (AuctionUserOrderInfoStruct) r100;
        if (Intrinsics.areEqual(this.userName, r101.userName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.userAvatar, r101.userAvatar) == true) goto L10;
        return false;
    L10:
        if (this.price == r101.price) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.recordTime, r101.recordTime) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.textStatus, r101.textStatus) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.userName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.userAvatar;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.price;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.recordTime;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.textStatus;
        if (r112 == null) goto L18;
        r101 = r112.hashCode();
    L18:
        return r111 + r101;
    L13:
        r110 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AuctionUserOrderInfoStruct(userName=" + this.userName + ", userAvatar=" + this.userAvatar + ", price=" + this.price + ", recordTime=" + this.recordTime + ", textStatus=" + this.textStatus + ")";
    }

    public final long getPrice() {
        return this.price;
    }

    public final String getRecordTime() {
        return this.recordTime;
    }

    public final String getTextStatus() {
        return this.textStatus;
    }

    public final String getUserAvatar() {
        return this.userAvatar;
    }

    public final String getUserName() {
        return this.userName;
    }

    public AuctionUserOrderInfoStruct(String r100, String r101, long r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r103, "recordTime");
        Intrinsics.checkNotNullParameter(r104, "textStatus");
        this.userName = r100;
        this.userAvatar = r101;
        this.price = r102;
        this.recordTime = r103;
        this.textStatus = r104;
    }

    public /* synthetic */ AuctionUserOrderInfoStruct(String r110, String r111, long r112, String r113, String r114, int r115, DefaultConstructorMarker r116) {
        if ((r115 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r115 & 2) == 0) goto L9;
        String r101 = null;
    L10:
        this(r100, r101, r112, r113, r114);
        return;
    L9:
        r101 = r111;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }
}
