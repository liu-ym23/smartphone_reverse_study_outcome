package com.bytedance.reparo.model;

import android.text.TextUtils;
import com.bytedance.reparo.core.g.h;
import com.bytedance.reparo.core.n;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class PatchFetchInfo {

    @SerializedName("update_version_code")
    private String hostAppVersion;

    @SerializedName("async_load")
    private boolean isAsyncLoad;

    @SerializedName("support_sub_process")
    private boolean isSupportSubProcess;

    @SerializedName("hotfix_id")
    private String issueId;
    private String md5;
    private String name;
    private boolean offline;

    @SerializedName("patch_id")
    private int patchId;

    @SerializedName("patch_name")
    private String patchName;
    private String url;

    @SerializedName("versioncode")
    private int versionCode;
    private boolean wifiOnly;

    public PatchFetchInfo() {
        this.isAsyncLoad = true;
    }

    public String getMd5() {
        String r0 = this.md5;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0.toLowerCase();
    }

    public void setMd5(String r1) {
        this.md5 = r1;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }

    public int getPatchId() {
        return this.patchId;
    }

    public void setPatchId(int r1) {
        this.patchId = r1;
    }

    public String getPatchName() {
        return this.patchName;
    }

    public void setPatchName(String r1) {
        this.patchName = r1;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public void setVersionCode(int r1) {
        this.versionCode = r1;
    }

    public boolean isOffline() {
        return this.offline;
    }

    public void setOffline(boolean r1) {
        this.offline = r1;
    }

    public boolean isWifiOnly() {
        return this.wifiOnly;
    }

    public void setWifiOnly(boolean r1) {
        this.wifiOnly = r1;
    }

    public String getHostAppVersion() {
        return this.hostAppVersion;
    }

    public void setHostAppVersion(String r1) {
        this.hostAppVersion = r1;
    }

    public void setAsyncLoad(boolean r1) {
        this.isAsyncLoad = r1;
    }

    public void setSupportSubProcess(boolean r1) {
        this.isSupportSubProcess = r1;
    }

    public String getIssueId() {
        return this.issueId;
    }

    public void setIssueId(String r1) {
        this.issueId = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return 527 + getMd5().hashCode();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L29:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L29;
        PatchFetchInfo r6 = (PatchFetchInfo) ZeusTransformUtils.preCheckCast(r5, PatchFetchInfo.class, "com.obric.aiagent.plugin");
        if (TextUtils.equals(this.md5, r6.md5) == false) goto L28;
        if (TextUtils.equals(this.issueId, r6.issueId) == false) goto L28;
        if (TextUtils.equals(this.hostAppVersion, r6.hostAppVersion) == false) goto L28;
        if (TextUtils.equals(this.url, r6.url) == false) goto L28;
        if (this.versionCode != r6.versionCode) goto L28;
        if (this.patchId != r6.patchId) goto L28;
        if (this.isAsyncLoad != r6.isAsyncLoad) goto L28;
        if (this.isSupportSubProcess != r6.isSupportSubProcess) goto L28;
        return true;
    L28:
        return false;
    }

    public boolean equals(h r1) {
        return TextUtils.equals(String.valueOf(this.patchId), r1.n());
    }

    public boolean isSupportSubProcess() {
        return this.isSupportSubProcess;
    }

    public boolean isAsyncLoad() {
        return this.isAsyncLoad;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("{").append("patchName = ").append(this.patchName).append(", ").append("patchId = ").append(this.patchId).append(", ").append("issueId = ").append(this.issueId).append(", ").append("md5 = ").append(this.md5).append(", ").append("hostAppVersion = ").append(this.hostAppVersion).append(", ").append("isAsyncLoad = ").append(this.isAsyncLoad).append(", ").append("isSupportSubProcess = ").append(this.isSupportSubProcess).append("}");
        return r0.toString();
    }

    public n convertToUpdateRequest(File r2) {
        return new n.a().a(r2).a(getMd5()).b(String.valueOf(this.versionCode)).c(String.valueOf(this.patchId)).d(this.issueId).e(this.hostAppVersion).a(this.isAsyncLoad).b(isSupportSubProcess()).a();
    }
}
