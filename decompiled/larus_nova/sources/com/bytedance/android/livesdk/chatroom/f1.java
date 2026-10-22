package com.bytedance.android.livesdk.chatroom;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/f1;", "", "", "playShareId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "Lcom/bytedance/android/livesdk/chatroom/j0;", "playInfo", "Lcom/bytedance/android/livesdk/chatroom/j0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/chatroom/j0;", "Lcom/bytedance/android/livesdk/chatroom/b1;", "masterCoupon", "Lcom/bytedance/android/livesdk/chatroom/b1;", "getMasterCoupon", "()Lcom/bytedance/android/livesdk/chatroom/b1;", "guestCoupon", "getGuestCoupon", "Lcom/bytedance/android/livesdk/chatroom/h1;", "fromUserInfo", "Lcom/bytedance/android/livesdk/chatroom/h1;", "getFromUserInfo", "()Lcom/bytedance/android/livesdk/chatroom/h1;", "", "toUserInfo", "Ljava/util/List;", "getToUserInfo", "()Ljava/util/List;", "", "status", "I", "c", "()I", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f1 {

    @SerializedName("from_user")
    private final h1 fromUserInfo;

    @SerializedName("guest_coupon")
    private final b1 guestCoupon;

    @SerializedName("master_coupon")
    private final b1 masterCoupon;

    @SerializedName("play_info")
    private final j0 playInfo;

    @SerializedName("play_share_id")
    private final String playShareId;

    @SerializedName("status")
    private final int status;

    @SerializedName("to_user")
    private final List<h1> toUserInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f1) == false) goto L20;
        f1 r101 = (f1) r100;
        if (Intrinsics.areEqual(this.playShareId, r101.playShareId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.playInfo, r101.playInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.masterCoupon, r101.masterCoupon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.guestCoupon, r101.guestCoupon) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.fromUserInfo, r101.fromUserInfo) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.toUserInfo, r101.toUserInfo) == true) goto L18;
        return false;
    L18:
        if (this.status == r101.status) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.playShareId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        j0 r104 = this.playInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        b1 r107 = this.masterCoupon;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        b1 r110 = this.guestCoupon;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        h1 r113 = this.fromUserInfo;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<h1> r116 = this.toUserInfo;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return ((r115 + r101) * 31) + this.status;
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
        return "SharePlayInfo(playShareId=" + this.playShareId + ", playInfo=" + this.playInfo + ", masterCoupon=" + this.masterCoupon + ", guestCoupon=" + this.guestCoupon + ", fromUserInfo=" + this.fromUserInfo + ", toUserInfo=" + this.toUserInfo + ", status=" + this.status + ")";
    }

    public final j0 a() {
        return this.playInfo;
    }

    public final String b() {
        return this.playShareId;
    }

    public final int c() {
        return this.status;
    }
}
