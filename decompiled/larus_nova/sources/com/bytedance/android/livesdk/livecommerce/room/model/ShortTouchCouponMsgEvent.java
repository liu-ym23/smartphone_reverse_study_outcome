package com.bytedance.android.livesdk.livecommerce.room.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/model/ShortTouchCouponMsgEvent;", "Ljava/io/Serializable;", "roomId", "", "hasCoupon", "", "infos", "", "Lcom/bytedance/android/livesdk/livecommerce/room/model/ShortTouchCouponInfo;", "(Ljava/lang/String;ZLjava/util/List;)V", "getHasCoupon", "()Z", "getInfos", "()Ljava/util/List;", "getRoomId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShortTouchCouponMsgEvent implements Serializable {

    @SerializedName("has_coupon")
    private final boolean hasCoupon;

    @SerializedName("short_touch_coupon_infos")
    private final List<ShortTouchCouponInfo> infos;

    @SerializedName("room_id")
    private final String roomId;

    public ShortTouchCouponMsgEvent() {
        this(null, false, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShortTouchCouponMsgEvent copy$default(ShortTouchCouponMsgEvent r100, String r101, boolean r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.roomId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.hasCoupon;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.infos;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.roomId;
    }

    public final boolean component2() {
        return this.hasCoupon;
    }

    public final List<ShortTouchCouponInfo> component3() {
        return this.infos;
    }

    public final ShortTouchCouponMsgEvent copy(String r100, boolean r101, List<ShortTouchCouponInfo> r102) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        return new ShortTouchCouponMsgEvent(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ShortTouchCouponMsgEvent) == false) goto L12;
        ShortTouchCouponMsgEvent r101 = (ShortTouchCouponMsgEvent) r100;
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L8;
        return false;
    L8:
        if (this.hasCoupon == r101.hasCoupon) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.infos, r101.infos) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        String r100 = this.roomId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.hasCoupon;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        List<ShortTouchCouponInfo> r107 = this.infos;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        return r106 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ShortTouchCouponMsgEvent(roomId=" + this.roomId + ", hasCoupon=" + this.hasCoupon + ", infos=" + this.infos + ")";
    }

    public final boolean getHasCoupon() {
        return this.hasCoupon;
    }

    public final List<ShortTouchCouponInfo> getInfos() {
        return this.infos;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public ShortTouchCouponMsgEvent(String r100, boolean r101, List<ShortTouchCouponInfo> r102) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        this.roomId = r100;
        this.hasCoupon = r101;
        this.infos = r102;
    }

    public /* synthetic */ ShortTouchCouponMsgEvent(String r100, boolean r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
