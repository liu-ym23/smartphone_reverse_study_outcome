package com.bytedance.android.gamecp.business.gamedetail.component.cloudplaybutton;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/cloudplaybutton/b;", "", "", "cloudGameId", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "cloudGameName", "e", "openSchema", "h", "mapId", "f", "mapName", ce.f26391f, "cgGameId", "c", "buttonTitle", "b", "buttonSubtitle", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("button_subtitle")
    private final String buttonSubtitle;

    @SerializedName("button_title")
    private final String buttonTitle;

    @SerializedName("cg_gameid")
    private final String cgGameId;

    @SerializedName("id")
    private final String cloudGameId;

    @SerializedName("name")
    private final String cloudGameName;

    @SerializedName("map_id")
    private final String mapId;

    @SerializedName("map_name")
    private final String mapName;

    @SerializedName("open_schema")
    private final String openSchema;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L22;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.cloudGameId, r101.cloudGameId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cloudGameName, r101.cloudGameName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.openSchema, r101.openSchema) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mapId, r101.mapId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.mapName, r101.mapName) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.cgGameId, r101.cgGameId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.buttonTitle, r101.buttonTitle) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.buttonSubtitle, r101.buttonSubtitle) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r100 = this.cloudGameId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.cloudGameName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.openSchema;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.mapId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.mapName;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.cgGameId;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.buttonTitle;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.buttonSubtitle;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
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
        return "CloudPlayButtonData(cloudGameId=" + this.cloudGameId + ", cloudGameName=" + this.cloudGameName + ", openSchema=" + this.openSchema + ", mapId=" + this.mapId + ", mapName=" + this.mapName + ", cgGameId=" + this.cgGameId + ", buttonTitle=" + this.buttonTitle + ", buttonSubtitle=" + this.buttonSubtitle + ")";
    }

    public b() {
        this.cloudGameId = "";
        this.cloudGameName = "";
        this.openSchema = "";
        this.mapId = "";
        this.mapName = "";
        this.cgGameId = "";
        this.buttonTitle = "";
        this.buttonSubtitle = "";
    }

    public final String a() {
        return this.buttonSubtitle;
    }

    public final String b() {
        return this.buttonTitle;
    }

    public final String c() {
        return this.cgGameId;
    }

    public final String d() {
        return this.cloudGameId;
    }

    public final String e() {
        return this.cloudGameName;
    }

    public final String f() {
        return this.mapId;
    }

    public final String g() {
        return this.mapName;
    }

    public final String h() {
        return this.openSchema;
    }
}
