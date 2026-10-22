package com.bytedance.android.gamecp.business.gamedetail.component.officialaccount;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/officialaccount/f;", "", "", "userId", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "userOpenId", RXScreenCaptureService.KEY_INDEX, "name", "e", "avatarUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "fansNumber", "c", "", "isFollow", "Ljava/lang/Boolean;", ce.f26395j, "()Ljava/lang/Boolean;", "hasCert", "d", "backgroundColor", "b", "textColor", ce.f26391f, "text", "f", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("avatar_uri")
    private final String avatarUrl;

    @SerializedName("background_color")
    private final String backgroundColor;

    @SerializedName("fans_num")
    private final String fansNumber;

    @SerializedName("has_cert")
    private final Boolean hasCert;

    @SerializedName("is_follow")
    private final Boolean isFollow;

    @SerializedName("nick_name")
    private final String name;

    @SerializedName("text_content")
    private final String text;

    @SerializedName("text_color")
    private final String textColor;

    @SerializedName("user_id")
    private final String userId;

    @SerializedName("user_open_id")
    private final String userOpenId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L26;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.userOpenId, r101.userOpenId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.avatarUrl, r101.avatarUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.fansNumber, r101.fansNumber) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.isFollow, r101.isFollow) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.hasCert, r101.hasCert) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        String r100 = this.userId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.userOpenId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.name;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.avatarUrl;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.fansNumber;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.isFollow;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.hasCert;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.backgroundColor;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.textColor;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.text;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        return r127 + r101;
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
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
        return "GameOfficialAccountData(userId=" + this.userId + ", userOpenId=" + this.userOpenId + ", name=" + this.name + ", avatarUrl=" + this.avatarUrl + ", fansNumber=" + this.fansNumber + ", isFollow=" + this.isFollow + ", hasCert=" + this.hasCert + ", backgroundColor=" + this.backgroundColor + ", textColor=" + this.textColor + ", text=" + this.text + ")";
    }

    public f() {
        this.userId = null;
        this.userOpenId = null;
        this.name = null;
        this.avatarUrl = null;
        this.fansNumber = null;
        this.isFollow = null;
        this.hasCert = null;
        this.backgroundColor = null;
        this.textColor = null;
        this.text = null;
    }

    public final String a() {
        return this.avatarUrl;
    }

    public final String b() {
        return this.backgroundColor;
    }

    public final String c() {
        return this.fansNumber;
    }

    public final Boolean d() {
        return this.hasCert;
    }

    public final String e() {
        return this.name;
    }

    public final String f() {
        return this.text;
    }

    public final String g() {
        return this.textColor;
    }

    public final String h() {
        return this.userId;
    }

    public final String i() {
        return this.userOpenId;
    }

    public final Boolean j() {
        return this.isFollow;
    }
}
