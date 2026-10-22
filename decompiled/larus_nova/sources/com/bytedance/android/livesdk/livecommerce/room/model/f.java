package com.bytedance.android.livesdk.livecommerce.room.model;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/model/f;", "", "", "roomId", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "roomUniqueKey", "f", "ecomEntranceForm", "b", "", "sourcePage", "Ljava/lang/Integer;", ce.f26391f, "()Ljava/lang/Integer;", "", "entranceInfo", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "addToCartEntranceInfo", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/livesdk/livecommerce/room/model/c;", "promotion", "Lcom/bytedance/android/livesdk/livecommerce/room/model/c;", "d", "()Lcom/bytedance/android/livesdk/livecommerce/room/model/c;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("add_to_cart_entrance_info")
    private final Map<String, Object> addToCartEntranceInfo;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM)
    private final String ecomEntranceForm;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO)
    private final Map<String, Object> entranceInfo;

    @SerializedName("promotion")
    private final c promotion;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("room_unique_key")
    private final String roomUniqueKey;

    @SerializedName("source_page")
    private final Integer sourcePage;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L20;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.roomUniqueKey, r101.roomUniqueKey) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.ecomEntranceForm, r101.ecomEntranceForm) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sourcePage, r101.sourcePage) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.entranceInfo, r101.entranceInfo) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.addToCartEntranceInfo, r101.addToCartEntranceInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.promotion, r101.promotion) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.roomId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.roomUniqueKey;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.ecomEntranceForm;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.sourcePage;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, Object> r113 = this.entranceInfo;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, Object> r116 = this.addToCartEntranceInfo;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        c r119 = this.promotion;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
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
        return "IParams(roomId=" + this.roomId + ", roomUniqueKey=" + this.roomUniqueKey + ", ecomEntranceForm=" + this.ecomEntranceForm + ", sourcePage=" + this.sourcePage + ", entranceInfo=" + this.entranceInfo + ", addToCartEntranceInfo=" + this.addToCartEntranceInfo + ", promotion=" + this.promotion + ")";
    }

    public f() {
        this.roomId = null;
        this.roomUniqueKey = null;
        this.ecomEntranceForm = null;
        this.sourcePage = null;
        this.entranceInfo = null;
        this.addToCartEntranceInfo = null;
        this.promotion = null;
    }

    public final Map<String, Object> a() {
        return this.addToCartEntranceInfo;
    }

    public final String b() {
        return this.ecomEntranceForm;
    }

    public final Map<String, Object> c() {
        return this.entranceInfo;
    }

    public final c d() {
        return this.promotion;
    }

    public final String e() {
        return this.roomId;
    }

    public final String f() {
        return this.roomUniqueKey;
    }

    public final Integer g() {
        return this.sourcePage;
    }
}
