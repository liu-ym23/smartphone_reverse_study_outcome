package com.bytedance.android.shopping.anchorv3.repository.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/api/d;", "", "", "accordingProductId", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "source", "d", "type", "getType", "roomId", "c", "videoId", "e", "", "imageConstraintsMap", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("according_product_id")
    private final String accordingProductId;

    @SerializedName("image_constraints_map")
    private final Map<String, String> imageConstraintsMap;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("source")
    private final String source;

    @SerializedName("type")
    private final String type;

    @SerializedName("video_id")
    private final String videoId;

    public d() {
        this(null, "", "", "", "", null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L18;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.accordingProductId, r101.accordingProductId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.videoId, r101.videoId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.imageConstraintsMap, r101.imageConstraintsMap) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.accordingProductId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.source;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.type;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.roomId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.videoId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, String> r116 = this.imageConstraintsMap;
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
        return "AnchorV3PromotionRecommendParam(accordingProductId=" + this.accordingProductId + ", source=" + this.source + ", type=" + this.type + ", roomId=" + this.roomId + ", videoId=" + this.videoId + ", imageConstraintsMap=" + this.imageConstraintsMap + ")";
    }

    public final String a() {
        return this.accordingProductId;
    }

    public final Map<String, String> b() {
        return this.imageConstraintsMap;
    }

    public final String c() {
        return this.roomId;
    }

    public final String d() {
        return this.source;
    }

    public final String e() {
        return this.videoId;
    }

    public final String getType() {
        return this.type;
    }

    public d(String r100, String r101, String r102, String r103, String r104, Map<String, String> r105) {
        this.accordingProductId = r100;
        this.source = r101;
        this.type = r102;
        this.roomId = r103;
        this.videoId = r104;
        this.imageConstraintsMap = r105;
    }
}
