package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0019\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\fHÆ\u0003J|\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R&\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/BffBizInfo;", "", "offset", "", "requestId", "", "filters", "", "followTabShopFilters", "ecSceneId", "loginStatus", "bizIdentity", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)V", "getBizIdentity", "()Ljava/util/Map;", "getEcSceneId", "()Ljava/lang/String;", "getFilters", "()Ljava/util/List;", "getFollowTabShopFilters", "getLoginStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOffset", "getRequestId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)Lcom/bytedance/android/shopping/api/mall/model/BffBizInfo;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BffBizInfo {

    @SerializedName("biz_identity")
    private final Map<String, Object> bizIdentity;

    @SerializedName("ecom_scene_id")
    private final String ecSceneId;

    @SerializedName("filters")
    private final List<String> filters;

    @SerializedName("follow_tab_shop_filters")
    private final List<String> followTabShopFilters;

    @SerializedName("login_status")
    private final Integer loginStatus;

    @SerializedName("recommend_back_up_offset")
    private final Integer offset;

    @SerializedName("request_id")
    private final String requestId;

    public BffBizInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BffBizInfo copy$default(BffBizInfo r100, Integer r101, String r102, List r103, List r104, String r110, Integer r111, Map r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.offset;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.requestId;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.filters;
    L11:
        List r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.followTabShopFilters;
    L14:
        List r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.ecSceneId;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.loginStatus;
    L20:
        Integer r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.bizIdentity;
    L23:
        Integer r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final Integer component1() {
        return this.offset;
    }

    public final String component2() {
        return this.requestId;
    }

    public final List<String> component3() {
        return this.filters;
    }

    public final List<String> component4() {
        return this.followTabShopFilters;
    }

    public final String component5() {
        return this.ecSceneId;
    }

    public final Integer component6() {
        return this.loginStatus;
    }

    public final Map<String, Object> component7() {
        return this.bizIdentity;
    }

    public final BffBizInfo copy(Integer r110, String r111, List<String> r112, List<String> r113, String r114, Integer r115, Map<String, ? extends Object> r116) {
        return new BffBizInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BffBizInfo) == false) goto L20;
        BffBizInfo r101 = (BffBizInfo) r100;
        if (Intrinsics.areEqual(this.offset, r101.offset) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.filters, r101.filters) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.followTabShopFilters, r101.followTabShopFilters) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.ecSceneId, r101.ecSceneId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.loginStatus, r101.loginStatus) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bizIdentity, r101.bizIdentity) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.offset;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.requestId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.filters;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.followTabShopFilters;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.ecSceneId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.loginStatus;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Map<String, Object> r119 = this.bizIdentity;
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

    public String toString() {
        return "BffBizInfo(offset=" + this.offset + ", requestId=" + this.requestId + ", filters=" + this.filters + ", followTabShopFilters=" + this.followTabShopFilters + ", ecSceneId=" + this.ecSceneId + ", loginStatus=" + this.loginStatus + ", bizIdentity=" + this.bizIdentity + ")";
    }

    public final Map<String, Object> getBizIdentity() {
        return this.bizIdentity;
    }

    public final String getEcSceneId() {
        return this.ecSceneId;
    }

    public final List<String> getFilters() {
        return this.filters;
    }

    public final List<String> getFollowTabShopFilters() {
        return this.followTabShopFilters;
    }

    public final Integer getLoginStatus() {
        return this.loginStatus;
    }

    public final Integer getOffset() {
        return this.offset;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public BffBizInfo(Integer r100, String r101, List<String> r102, List<String> r103, String r104, Integer r105, Map<String, ? extends Object> r106) {
        this.offset = r100;
        this.requestId = r101;
        this.filters = r102;
        this.followTabShopFilters = r103;
        this.ecSceneId = r104;
        this.loginStatus = r105;
        this.bizIdentity = r106;
    }

    public /* synthetic */ BffBizInfo(Integer r100, String r101, List r102, List r103, String r110, Integer r111, Map r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        Map r104 = null;
        if ((r113 & 2) == 0) goto L8;
        String r115 = null;
    L10:
        if ((r113 & 4) == 0) goto L12;
        List r105 = null;
    L14:
        if ((r113 & 8) == 0) goto L16;
        List r106 = null;
    L18:
        if ((r113 & 16) == 0) goto L20;
        String r107 = null;
    L22:
        if ((r113 & 32) == 0) goto L24;
        Integer r108 = null;
    L26:
        if ((r113 & 64) != 0) goto L29;
        r104 = r112;
    L29:
        this(r100, r115, r105, r106, r107, r108, r104);
        return;
    L24:
        r108 = r111;
        goto L26
    L20:
        r107 = r110;
        goto L22
    L16:
        r106 = r103;
        goto L18
    L12:
        r105 = r102;
        goto L14
    L8:
        r115 = r101;
        goto L10
    }
}
