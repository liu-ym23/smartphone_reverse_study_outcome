package com.bytedance.android.gamecp.business.api.response;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.IncrementPackageInfo")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/gamecp/business/api/response/k;", "", "", "downloadUrl", "Ljava/lang/String;", "", "packageSize", "Ljava/lang/Double;", "", "backupUrls", "Ljava/util/List;", "", com.heytap.mcssdk.constant.b.C, "I", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k implements vh7.h {

    @SerializedName(AdDownloadModel.JsonKey.BACKUP_URLS)
    public List<String> backupUrls;

    @SerializedName("download_url")
    public String downloadUrl;

    @SerializedName(EventConstants.ExtraJson.PACKAGE_SIZE)
    public Double packageSize;

    @SerializedName("sdk_version")
    public int sdkVersion;

    public k() {
        this.backupUrls = new ArrayList();
    }

    public k(am3.g r100) {
        this.backupUrls = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.downloadUrl = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.packageSize = Double.valueOf(Double.longBitsToDouble(r100.h()));
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.backupUrls.add(am3.h.c(r100));
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.sdkVersion = r100.i();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.backupUrls.isEmpty() == false) goto L37;
        this.backupUrls = new ArrayList();
        return;
    }
}
