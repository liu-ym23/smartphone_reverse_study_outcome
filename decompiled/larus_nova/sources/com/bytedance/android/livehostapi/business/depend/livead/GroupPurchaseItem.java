package com.bytedance.android.livehostapi.business.depend.livead;

import com.bytedance.android.live.base.model.UrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006#"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/GroupPurchaseItem;", "", "id", "", "logExtra", "dynamicIconUrl", "Lcom/bytedance/android/live/base/model/UrlModel;", RuleConditionBean.OPEN_URL_KEY, NativeDownloadModel.JsonKey.WEB_URL, "webTitle", "poiRoomInfo", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/live/base/model/UrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDynamicIconUrl", "()Lcom/bytedance/android/live/base/model/UrlModel;", "getId", "()Ljava/lang/String;", "getLogExtra", "getOpenUrl", "getPoiRoomInfo", "getWebTitle", "getWebUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupPurchaseItem {

    @SerializedName("dynamic_icon_url")
    private final UrlModel dynamicIconUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f102927id;

    @SerializedName("log_extra")
    private final String logExtra;

    @SerializedName("open_url")
    private final String openUrl;

    @SerializedName("poi_room_info")
    private final String poiRoomInfo;

    @SerializedName(BytedCertConstant.WebInfo.WEB_TITLE)
    private final String webTitle;

    @SerializedName("web_url")
    private final String webUrl;

    public GroupPurchaseItem() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ GroupPurchaseItem copy$default(GroupPurchaseItem r100, String r101, String r102, UrlModel r103, String r104, String r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.f102927id;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.logExtra;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.dynamicIconUrl;
    L11:
        UrlModel r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.openUrl;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.webUrl;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.webTitle;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.poiRoomInfo;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.f102927id;
    }

    public final String component2() {
        return this.logExtra;
    }

    public final UrlModel component3() {
        return this.dynamicIconUrl;
    }

    public final String component4() {
        return this.openUrl;
    }

    public final String component5() {
        return this.webUrl;
    }

    public final String component6() {
        return this.webTitle;
    }

    public final String component7() {
        return this.poiRoomInfo;
    }

    public final GroupPurchaseItem copy(String r110, String r111, UrlModel r112, String r113, String r114, String r115, String r116) {
        return new GroupPurchaseItem(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GroupPurchaseItem) == false) goto L20;
        GroupPurchaseItem r101 = (GroupPurchaseItem) r100;
        if (Intrinsics.areEqual(this.f102927id, r101.f102927id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.logExtra, r101.logExtra) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.dynamicIconUrl, r101.dynamicIconUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.openUrl, r101.openUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.webUrl, r101.webUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.webTitle, r101.webTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.poiRoomInfo, r101.poiRoomInfo) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r100 = this.f102927id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.logExtra;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        UrlModel r107 = this.dynamicIconUrl;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.openUrl;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.webUrl;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.webTitle;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.poiRoomInfo;
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
        return "GroupPurchaseItem(id=" + this.f102927id + ", logExtra=" + this.logExtra + ", dynamicIconUrl=" + this.dynamicIconUrl + ", openUrl=" + this.openUrl + ", webUrl=" + this.webUrl + ", webTitle=" + this.webTitle + ", poiRoomInfo=" + this.poiRoomInfo + ")";
    }

    public final UrlModel getDynamicIconUrl() {
        return this.dynamicIconUrl;
    }

    public final String getId() {
        return this.f102927id;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public final String getOpenUrl() {
        return this.openUrl;
    }

    public final String getPoiRoomInfo() {
        return this.poiRoomInfo;
    }

    public final String getWebTitle() {
        return this.webTitle;
    }

    public final String getWebUrl() {
        return this.webUrl;
    }

    public GroupPurchaseItem(String r100, String r101, UrlModel r102, String r103, String r104, String r105, String r106) {
        this.f102927id = r100;
        this.logExtra = r101;
        this.dynamicIconUrl = r102;
        this.openUrl = r103;
        this.webUrl = r104;
        this.webTitle = r105;
        this.poiRoomInfo = r106;
    }

    public /* synthetic */ GroupPurchaseItem(String r100, String r101, UrlModel r102, String r110, String r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        UrlModel r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        String r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
