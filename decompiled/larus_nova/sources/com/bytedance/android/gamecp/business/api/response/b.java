package com.bytedance.android.gamecp.business.api.response;

import androidx.camera.video.AudioStats;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.gamecp.base.core.service.depend.PlatformSupportPkg;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.constants.DownloadTaskKeyConstants;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.AndroidDownloadInfo")
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0007R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u001e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0007R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010\u0007R\u0018\u0010!\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0007R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u0007R\u0018\u0010#\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0016R\u0018\u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b$\u0010\u0007R\u0018\u0010%\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b%\u0010\u0007R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010\u001bR\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b(\u0010\u001b¨\u0006+"}, d2 = {"Lcom/bytedance/android/gamecp/business/api/response/b;", "", "", "gameId", "Ljava/lang/Long;", "", "gameName", "Ljava/lang/String;", "gameIcon", "downloadUrl", "compressedDownloadUrl", "microPkgDownloadUrl", "Lcom/bytedance/android/gamecp/business/api/response/k;", "incrementPackageInfo", "Lcom/bytedance/android/gamecp/business/api/response/k;", "incrementPackageInfoV2", "packageName", "", "packageSize", "Ljava/lang/Double;", "", RuleConditionBean.VERSION_CODE_KEY, "Ljava/lang/Integer;", "fileLength", "ttmd5", "", "backupUrls", "Ljava/util/List;", "compressedBackupUrls", "microBackupUrls", "notificationJumpUrl", "needWifi", "extra", "taskGroup", "startToast", "token", "complianceData", "traceId", "Lcom/bytedance/android/gamecp/base/core/service/depend/PlatformSupportPkg;", "supportPkg", "potentialSupportPkg", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements vh7.h {

    @SerializedName(AdDownloadModel.JsonKey.BACKUP_URLS)
    public List<String> backupUrls;

    @SerializedName("compliance_data")
    public String complianceData;

    @SerializedName("compressed_backup_urls")
    public List<String> compressedBackupUrls;

    @SerializedName("compressed_download_url")
    public String compressedDownloadUrl;

    @SerializedName("download_url")
    public String downloadUrl;

    @SerializedName("extra")
    public String extra;

    @SerializedName("file_length")
    public Long fileLength;

    @SerializedName("icon")
    public String gameIcon;

    @SerializedName("id")
    public Long gameId;

    @SerializedName("name")
    public String gameName;

    @SerializedName("increment_package_info")
    public k incrementPackageInfo;

    @SerializedName("increment_package_info_v2")
    public k incrementPackageInfoV2;

    @SerializedName("micro_pkg_backup_urls")
    public List<String> microBackupUrls;

    @SerializedName("micro_pkg_download_url")
    public String microPkgDownloadUrl;

    @SerializedName(AdDownloadModel.JsonKey.NEED_WIFI)
    public Integer needWifi;

    @SerializedName("notification_jump_url")
    public String notificationJumpUrl;

    @SerializedName("pkg_name")
    public String packageName;

    @SerializedName(EventConstants.ExtraJson.PACKAGE_SIZE)
    public Double packageSize;

    @SerializedName("potential_support_pkg")
    public List<PlatformSupportPkg> potentialSupportPkg;

    @SerializedName(AdDownloadModel.JsonKey.START_TOAST)
    public String startToast;

    @SerializedName("support_pkg")
    public List<PlatformSupportPkg> supportPkg;

    @SerializedName(DownloadTaskKeyConstants.TaskKeyObjectAttr.TASK_GROUP)
    public String taskGroup;

    @SerializedName("token")
    public Integer token;

    @SerializedName(BindCardPayConfirmConstants.Key.TRACE_ID)
    public String traceId;

    @SerializedName("ttmd5")
    public String ttmd5;

    @SerializedName("version_code")
    public Integer versionCode;

    public b() {
        this.packageSize = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        this.backupUrls = new ArrayList();
        this.compressedBackupUrls = new ArrayList();
        this.microBackupUrls = new ArrayList();
        this.extra = SliceInitService.DEFAULT_SWITCH;
        this.supportPkg = new ArrayList();
        this.potentialSupportPkg = new ArrayList();
    }

    public b(am3.g r100) {
        this.backupUrls = new ArrayList();
        this.compressedBackupUrls = new ArrayList();
        this.microBackupUrls = new ArrayList();
        this.supportPkg = new ArrayList();
        this.potentialSupportPkg = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L35;
        switch(r102) {
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L29;
            case 7: goto L28;
            case 8: goto L27;
            case 9: goto L26;
            case 10: goto L23;
            case 11: goto L22;
            case 12: goto L21;
            case 13: goto L20;
            case 14: goto L19;
            case 15: goto L18;
            case 16: goto L6;
            case 17: goto L6;
            case 18: goto L17;
            case 19: goto L16;
            case 20: goto L15;
            case 21: goto L6;
            case 22: goto L14;
            case 23: goto L13;
            case 24: goto L12;
            case 25: goto L11;
            case 26: goto L10;
            case 27: goto L9;
            case 28: goto L8;
            case 29: goto L7;
            default: goto L6;
        };
    L7:
        this.incrementPackageInfoV2 = new k(r100);
        goto L3
    L8:
        this.incrementPackageInfo = new k(r100);
        goto L3
    L9:
        List r103 = this.microBackupUrls;
    L24:
        Object r104 = am3.h.c(r100);
    L25:
        r103.add(r104);
        goto L3
    L10:
        r103 = this.compressedBackupUrls;
        goto L24
    L11:
        r103 = this.potentialSupportPkg;
        r104 = new PlatformSupportPkg(r100);
        goto L25
    L12:
        r103 = this.supportPkg;
        r104 = new PlatformSupportPkg(r100);
        goto L25
    L13:
        this.microPkgDownloadUrl = am3.h.c(r100);
        goto L3
    L14:
        this.compressedDownloadUrl = am3.h.c(r100);
        goto L3
    L15:
        this.traceId = am3.h.c(r100);
        goto L3
    L16:
        this.complianceData = am3.h.c(r100);
        goto L3
    L17:
        this.token = Integer.valueOf(r100.i());
        goto L3
    L18:
        this.startToast = am3.h.c(r100);
        goto L3
    L19:
        this.taskGroup = am3.h.c(r100);
        goto L3
    L20:
        this.extra = am3.h.c(r100);
        goto L3
    L21:
        this.needWifi = Integer.valueOf(r100.i());
        goto L3
    L22:
        this.notificationJumpUrl = am3.h.c(r100);
        goto L3
    L23:
        r103 = this.backupUrls;
        goto L24
    L26:
        this.ttmd5 = am3.h.c(r100);
        goto L3
    L27:
        this.fileLength = Long.valueOf(r100.j());
        goto L3
    L28:
        this.versionCode = Integer.valueOf(r100.i());
        goto L3
    L29:
        this.packageSize = Double.valueOf(Double.longBitsToDouble(r100.h()));
        goto L3
    L30:
        this.packageName = am3.h.c(r100);
        goto L3
    L31:
        this.downloadUrl = am3.h.c(r100);
        goto L3
    L32:
        this.gameIcon = am3.h.c(r100);
        goto L3
    L33:
        this.gameName = am3.h.c(r100);
        goto L3
    L34:
        this.gameId = Long.valueOf(r100.j());
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L35:
        r100.d(r101);
        if (this.packageSize != null) goto L39;
        this.packageSize = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    L39:
        if (this.backupUrls.isEmpty() == false) goto L42;
        this.backupUrls = new ArrayList();
    L42:
        if (this.compressedBackupUrls.isEmpty() == false) goto L45;
        this.compressedBackupUrls = new ArrayList();
    L45:
        if (this.microBackupUrls.isEmpty() == false) goto L48;
        this.microBackupUrls = new ArrayList();
    L48:
        if (this.extra != null) goto L51;
        this.extra = SliceInitService.DEFAULT_SWITCH;
    L51:
        if (this.supportPkg.isEmpty() == false) goto L54;
        this.supportPkg = new ArrayList();
    L54:
        if (this.potentialSupportPkg.isEmpty() == false) goto L109;
        this.potentialSupportPkg = new ArrayList();
        return;
    }
}
