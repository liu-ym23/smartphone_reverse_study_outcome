package com.bytedance.android.gamecp.business.api.response;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.GamePlatformInfo")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0007R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0007R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0007R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/gamecp/business/api/response/f;", "", "", "platform", "Ljava/lang/Integer;", "", "packagePermissionURL", "Ljava/lang/String;", "privacyPolityURL", "productDescUrl", "Lcom/bytedance/android/gamecp/business/api/response/b;", "downloadInfo", "Lcom/bytedance/android/gamecp/business/api/response/b;", "Lcom/bytedance/android/gamecp/business/api/response/c;", "packageInfo", "Lcom/bytedance/android/gamecp/business/api/response/c;", "developer", "activeLink", "openGameUrl", "gameStageType", "", "isDownloadSupport", "Ljava/lang/Boolean;", "downloadStatus", "publisher", "gameName", "icpRegistration", "icpFilingEntityName", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f implements vh7.h {

    @SerializedName("active_link")
    public String activeLink;

    @SerializedName("developer")
    public String developer;

    @SerializedName("download_info")
    public b downloadInfo;

    @SerializedName("download_status")
    public Integer downloadStatus;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    public String gameName;

    @SerializedName("game_stage_type")
    public Integer gameStageType;

    @SerializedName("icp_filing_entity_name")
    public String icpFilingEntityName;

    @SerializedName("icp_registration")
    public String icpRegistration;

    @SerializedName("is_download_support")
    public Boolean isDownloadSupport;

    @SerializedName("open_game_url")
    public String openGameUrl;

    @SerializedName("package_info")
    public c packageInfo;

    @SerializedName("package_permission_url")
    public String packagePermissionURL;

    @SerializedName("platform")
    public Integer platform;

    @SerializedName("privacy_polity_url")
    public String privacyPolityURL;

    @SerializedName("product_desc_url")
    public String productDescUrl;

    @SerializedName("publisher")
    public String publisher;

    public f() {
    }

    public f(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L30;
        if (r102 != 1) goto L8;
        this.platform = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 62) goto L10;
        this.activeLink = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 63) goto L11;
        this.openGameUrl = am3.h.c(r100);
        goto L3
    L11:
        switch(r102) {
            case 30: goto L26;
            case 31: goto L25;
            case 32: goto L24;
            case 33: goto L23;
            case 34: goto L22;
            case 35: goto L21;
            case 36: goto L20;
            case 37: goto L19;
            case 38: goto L18;
            default: goto L12;
        };
    L18:
        this.icpFilingEntityName = am3.h.c(r100);
        goto L3
    L19:
        this.icpRegistration = am3.h.c(r100);
        goto L3
    L20:
        this.publisher = am3.h.c(r100);
        goto L3
    L21:
        this.productDescUrl = am3.h.c(r100);
        goto L3
    L22:
        this.developer = am3.h.c(r100);
        goto L3
    L23:
        this.packageInfo = new c(r100);
        goto L3
    L24:
        this.downloadInfo = new b(r100);
        goto L3
    L25:
        this.privacyPolityURL = am3.h.c(r100);
        goto L3
    L26:
        this.packagePermissionURL = am3.h.c(r100);
        goto L3
    L12:
        switch(r102) {
            case 90: goto L17;
            case 91: goto L16;
            case 92: goto L15;
            case 93: goto L14;
            default: goto L13;
        };
    L14:
        this.downloadStatus = Integer.valueOf(r100.i());
        goto L3
    L15:
        this.isDownloadSupport = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L16:
        this.gameStageType = Integer.valueOf(r100.i());
        goto L3
    L17:
        this.gameName = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L30:
        r100.d(r101);
    }
}
