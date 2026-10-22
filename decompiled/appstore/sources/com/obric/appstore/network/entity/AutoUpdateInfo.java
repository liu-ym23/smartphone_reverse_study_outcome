package com.obric.appstore.network.entity;

import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00128\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0016\u0010\u001d\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\nR\u0016\u0010\u001f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006¨\u0006!"}, d2 = {"Lcom/obric/appstore/network/entity/AutoUpdateInfo;", "", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "complianceMode", "", "getComplianceMode", "()I", "log", "getLog", ServerElements.MD5, "getMd5", "packageName", "getPackageName", "size", "", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "taskId", "getTaskId", "()J", "updateModel", "getUpdateModel", "url", "getUrl", "versionCode", "getVersionCode", "versionName", "getVersionName", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AutoUpdateInfo {

    @SerializedName("app_id")
    @NotNull
    private final String appId;

    @SerializedName("compliance_mode")
    private final int complianceMode;

    @SerializedName("log")
    @NotNull
    private final String log;

    @SerializedName(ServerElements.MD5)
    @Nullable
    private final String md5;

    @SerializedName("package")
    @NotNull
    private final String packageName;

    @SerializedName("size")
    @Nullable
    private final Long size;

    @SerializedName("task_id")
    private final long taskId;

    @SerializedName("update_model")
    private final int updateModel;

    @SerializedName("url")
    @Nullable
    private final String url;

    @SerializedName("version_code")
    private final int versionCode;

    @SerializedName(CommonKey.KEY_VERSION_NAME)
    @NotNull
    private final String versionName;

    public AutoUpdateInfo() {
        this.versionName = "";
        this.packageName = "";
        this.log = "";
        this.appId = "";
    }

    @NotNull
    public final String getAppId() {
        return this.appId;
    }

    public final int getComplianceMode() {
        return this.complianceMode;
    }

    @NotNull
    public final String getLog() {
        return this.log;
    }

    @Nullable
    public final String getMd5() {
        return this.md5;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @Nullable
    public final Long getSize() {
        return this.size;
    }

    public final long getTaskId() {
        return this.taskId;
    }

    public final int getUpdateModel() {
        return this.updateModel;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    @NotNull
    public final String getVersionName() {
        return this.versionName;
    }
}
