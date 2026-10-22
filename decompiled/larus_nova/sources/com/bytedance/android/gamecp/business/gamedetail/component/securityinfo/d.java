package com.bytedance.android.gamecp.business.gamedetail.component.securityinfo;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/securityinfo/d;", "", "", "gameId", "Ljava/lang/String;", "getGameId", "()Ljava/lang/String;", "gameName", "getGameName", "feedbackUrl", "getFeedbackUrl", "privacySettingUrl", "getPrivacySettingUrl", "feedbackSchema", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "feedbackTitle", "b", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("feedback_schema")
    private final String feedbackSchema;

    @SerializedName("feedback_title")
    private final String feedbackTitle;

    @SerializedName("feedback_url")
    private final String feedbackUrl;

    @SerializedName("id")
    private final String gameId;

    @SerializedName("name")
    private final String gameName;

    @SerializedName("privacy_setting_url")
    private final String privacySettingUrl;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L18;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.gameId, r101.gameId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.gameName, r101.gameName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.feedbackUrl, r101.feedbackUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.privacySettingUrl, r101.privacySettingUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.feedbackSchema, r101.feedbackSchema) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.feedbackTitle, r101.feedbackTitle) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.gameId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.gameName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.feedbackUrl;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.privacySettingUrl;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.feedbackSchema;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.feedbackTitle;
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
        return "GameSecurityInfoData(gameId=" + this.gameId + ", gameName=" + this.gameName + ", feedbackUrl=" + this.feedbackUrl + ", privacySettingUrl=" + this.privacySettingUrl + ", feedbackSchema=" + this.feedbackSchema + ", feedbackTitle=" + this.feedbackTitle + ")";
    }

    public d() {
        this.gameId = null;
        this.gameName = null;
        this.feedbackUrl = null;
        this.privacySettingUrl = null;
        this.feedbackSchema = null;
        this.feedbackTitle = null;
    }

    public final String a() {
        return this.feedbackSchema;
    }

    public final String b() {
        return this.feedbackTitle;
    }
}
