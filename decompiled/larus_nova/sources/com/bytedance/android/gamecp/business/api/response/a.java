package com.bytedance.android.gamecp.business.api.response;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.GetRoomPromoteDataForLiveScreenResponse.Data")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/gamecp/business/api/response/a;", "", "", "todayDownloadCount", "Ljava/lang/Integer;", "notInstallCount", "", "hasDownloadPermission", "Ljava/lang/Boolean;", "hasInstallPermission", "showInstallTips", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements vh7.h {

    @SerializedName("has_download_count_permission")
    public Boolean hasDownloadPermission;

    @SerializedName("has_install_count_permission")
    public Boolean hasInstallPermission;

    @SerializedName("not_install_count_of_online_user")
    public Integer notInstallCount;

    @SerializedName("is_show_diagnose_tips")
    public Boolean showInstallTips;

    @SerializedName("today_download_count")
    public Integer todayDownloadCount;

    public a() {
        this.todayDownloadCount = 0;
        this.notInstallCount = 0;
        Boolean r100 = Boolean.FALSE;
        this.hasDownloadPermission = r100;
        this.hasInstallPermission = r100;
        this.showInstallTips = r100;
    }

    public a(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.todayDownloadCount = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 3) goto L10;
        this.notInstallCount = Integer.valueOf(r100.i());
        goto L3
    L10:
        if (r102 != 5) goto L12;
        this.showInstallTips = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L12:
        if (r102 != 6) goto L14;
        this.hasInstallPermission = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L14:
        if (r102 != 7) goto L15;
        this.hasDownloadPermission = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if (this.todayDownloadCount != null) goto L25;
        this.todayDownloadCount = 0;
    L25:
        if (this.notInstallCount != null) goto L28;
        this.notInstallCount = 0;
    L28:
        if (this.hasDownloadPermission != null) goto L31;
        this.hasDownloadPermission = Boolean.FALSE;
    L31:
        if (this.hasInstallPermission != null) goto L34;
        this.hasInstallPermission = Boolean.FALSE;
    L34:
        if (this.showInstallTips != null) goto L55;
        this.showInstallTips = Boolean.FALSE;
        return;
    }
}
