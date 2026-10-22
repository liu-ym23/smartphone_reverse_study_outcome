package com.obric.appstore.network.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.database.columns.AdsReportRecordColumns;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003JY\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u000bHÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013¨\u0006("}, d2 = {"Lcom/obric/appstore/network/entity/SysAppAutoUpdateReportReq;", "", "taskId", "", "appId", "", "packageName", "oldVersionCode", "newVersionCode", "reason", "eventTime", "", "status", "(JLjava/lang/String;Ljava/lang/String;JJLjava/lang/String;II)V", "getAppId", "()Ljava/lang/String;", "getEventTime", "()I", "getNewVersionCode", "()J", "getOldVersionCode", "getPackageName", "getReason", "getStatus", "getTaskId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "Companion", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SysAppAutoUpdateReportReq {

    @NotNull
    public static final Companion Companion = null;
    public static final int STATUS_DOWNLOAD_FAIL = 4;
    public static final int STATUS_DOWNLOAD_START = 2;
    public static final int STATUS_DOWNLOAD_SUCCESS = 3;
    public static final int STATUS_GET_UPDATE_INFO = 1;
    public static final int STATUS_INSTALL_FAIL = 7;
    public static final int STATUS_INSTALL_START = 5;
    public static final int STATUS_INSTALL_SUCCESS = 6;

    @SerializedName("app_id")
    @NotNull
    private final String appId;

    @SerializedName(AdsReportRecordColumns.ADS_EVENT_TIME)
    private final int eventTime;

    @SerializedName("new_version_code")
    private final long newVersionCode;

    @SerializedName("old_version_code")
    private final long oldVersionCode;

    @SerializedName("package")
    @NotNull
    private final String packageName;

    @SerializedName("reason")
    @NotNull
    private final String reason;

    @SerializedName("status")
    private final int status;

    @SerializedName("task_id")
    private final long taskId;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/appstore/network/entity/SysAppAutoUpdateReportReq$Companion;", "", "()V", "STATUS_DOWNLOAD_FAIL", "", "STATUS_DOWNLOAD_START", "STATUS_DOWNLOAD_SUCCESS", "STATUS_GET_UPDATE_INFO", "STATUS_INSTALL_FAIL", "STATUS_INSTALL_START", "STATUS_INSTALL_SUCCESS", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SysAppAutoUpdateReportReq(long r10, @NotNull String r11, @NotNull String r12, long r13, long r14, @NotNull String r15, int r16, int r17) {
        q.g(r11, "appId");
        q.g(r12, "packageName");
        q.g(r15, "reason");
        this.taskId = r10;
        this.appId = r11;
        this.packageName = r12;
        this.oldVersionCode = r13;
        this.newVersionCode = r14;
        this.reason = r15;
        this.eventTime = r16;
        this.status = r17;
    }

    public static /* synthetic */ SysAppAutoUpdateReportReq copy$default(SysAppAutoUpdateReportReq r12, long r13, String r15, String r16, long r17, long r19, String r21, int r22, int r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        long r10 = r12.taskId;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r11 = r12.appId;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r14 = r12.packageName;
    L15:
        if ((r24 & 8) == 0) goto L17;
        long r18 = r12.oldVersionCode;
    L19:
        if ((r24 & 16) == 0) goto L21;
        long r20 = r12.newVersionCode;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r110 = r12.reason;
    L27:
        if ((r24 & 64) == 0) goto L29;
        int r111 = r12.eventTime;
    L31:
        if ((r24 & 128) == 0) goto L33;
        int r26 = r12.status;
    L35:
        return r12.copy(r10, r11, r14, r18, r20, r110, r111, r26);
    L33:
        r26 = r23;
        goto L35
    L29:
        r111 = r22;
        goto L31
    L25:
        r110 = r21;
        goto L27
    L21:
        r20 = r19;
        goto L23
    L17:
        r18 = r17;
        goto L19
    L13:
        r14 = r16;
        goto L15
    L9:
        r11 = r15;
        goto L11
    L5:
        r10 = r13;
        goto L7
    }

    public final long component1() {
        return this.taskId;
    }

    @NotNull
    public final String component2() {
        return this.appId;
    }

    @NotNull
    public final String component3() {
        return this.packageName;
    }

    public final long component4() {
        return this.oldVersionCode;
    }

    public final long component5() {
        return this.newVersionCode;
    }

    @NotNull
    public final String component6() {
        return this.reason;
    }

    public final int component7() {
        return this.eventTime;
    }

    public final int component8() {
        return this.status;
    }

    @NotNull
    public final SysAppAutoUpdateReportReq copy(long r14, @NotNull String r16, @NotNull String r17, long r18, long r20, @NotNull String r22, int r23, int r24) {
        q.g(r16, "appId");
        q.g(r17, "packageName");
        q.g(r22, "reason");
        return new SysAppAutoUpdateReportReq(r14, r16, r17, r18, r20, r22, r23, r24);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SysAppAutoUpdateReportReq) == true) goto L8;
        return false;
    L8:
        SysAppAutoUpdateReportReq r11 = (SysAppAutoUpdateReportReq) r10;
        if (this.taskId == r11.taskId) goto L12;
        return false;
    L12:
        if (q.b(this.appId, r11.appId) == true) goto L15;
        return false;
    L15:
        if (q.b(this.packageName, r11.packageName) == true) goto L18;
        return false;
    L18:
        if (this.oldVersionCode == r11.oldVersionCode) goto L21;
        return false;
    L21:
        if (this.newVersionCode == r11.newVersionCode) goto L24;
        return false;
    L24:
        if (q.b(this.reason, r11.reason) == true) goto L27;
        return false;
    L27:
        if (this.eventTime == r11.eventTime) goto L30;
        return false;
    L30:
        if (this.status == r11.status) goto L32;
        return false;
    L32:
        return true;
    }

    @NotNull
    public final String getAppId() {
        return this.appId;
    }

    public final int getEventTime() {
        return this.eventTime;
    }

    public final long getNewVersionCode() {
        return this.newVersionCode;
    }

    public final long getOldVersionCode() {
        return this.oldVersionCode;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final String getReason() {
        return this.reason;
    }

    public final int getStatus() {
        return this.status;
    }

    public final long getTaskId() {
        return this.taskId;
    }

    public int hashCode() {
        return (((((((((((((Long.hashCode(this.taskId) * 31) + this.appId.hashCode()) * 31) + this.packageName.hashCode()) * 31) + Long.hashCode(this.oldVersionCode)) * 31) + Long.hashCode(this.newVersionCode)) * 31) + this.reason.hashCode()) * 31) + Integer.hashCode(this.eventTime)) * 31) + Integer.hashCode(this.status);
    }

    @NotNull
    public String toString() {
        return "SysAppAutoUpdateReportReq(taskId=" + this.taskId + ", appId=" + this.appId + ", packageName=" + this.packageName + ", oldVersionCode=" + this.oldVersionCode + ", newVersionCode=" + this.newVersionCode + ", reason=" + this.reason + ", eventTime=" + this.eventTime + ", status=" + this.status + ')';
    }
}
