package com.stepos.activeview.json;

import B0.g;

/* loaded from: classes.dex */
public class UpgradeActiveBean {
    private int customId;
    private String digest;
    private boolean existsUpdate;
    private String latestVersion;
    private String needUpdate;
    private String pluginName;
    private int pluginType;
    private String releaseDate;
    private String releaseNote;
    private String serviceName;
    private long size;
    private String targetAppName;
    private String updateUrl;
    private String updateUrl2;
    private int verifyMode;

    public int getCustomId() {
        return this.customId;
    }

    public String getDigest() {
        return this.digest;
    }

    public String getLatestVersion() {
        return this.latestVersion;
    }

    public String getNeedUpdate() {
        return this.needUpdate;
    }

    public String getPluginName() {
        return this.pluginName;
    }

    public int getPluginType() {
        return this.pluginType;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public String getReleaseNote() {
        return this.releaseNote;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public long getSize() {
        return this.size;
    }

    public String getTargetAppName() {
        return this.targetAppName;
    }

    public String getUpdateUrl() {
        return this.updateUrl;
    }

    public String getUpdateUrl2() {
        return this.updateUrl2;
    }

    public int getVerifyMode() {
        return this.verifyMode;
    }

    public boolean isExistsUpdate() {
        return this.existsUpdate;
    }

    public void setCustomId(int i4) {
        this.customId = i4;
    }

    public void setDigest(String str) {
        this.digest = str;
    }

    public void setExistsUpdate(boolean z4) {
        this.existsUpdate = z4;
    }

    public void setLatestVersion(String str) {
        this.latestVersion = str;
    }

    public void setNeedUpdate(String str) {
        this.needUpdate = str;
    }

    public void setPluginName(String str) {
        this.pluginName = str;
    }

    public void setPluginType(int i4) {
        this.pluginType = i4;
    }

    public void setReleaseDate(String str) {
        this.releaseDate = str;
    }

    public void setReleaseNote(String str) {
        this.releaseNote = str;
    }

    public void setServiceName(String str) {
        this.serviceName = str;
    }

    public void setSize(long j4) {
        this.size = j4;
    }

    public void setTargetAppName(String str) {
        this.targetAppName = str;
    }

    public void setUpdateUrl(String str) {
        this.updateUrl = str;
    }

    public void setUpdateUrl2(String str) {
        this.updateUrl2 = str;
    }

    public void setVerifyMode(int i4) {
        this.verifyMode = i4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UpgradeActiveBean{existsUpdate=");
        sb.append(this.existsUpdate);
        sb.append(", pluginName='");
        sb.append(this.pluginName);
        sb.append("', digest='");
        sb.append(this.digest);
        sb.append("', latestVersion='");
        sb.append(this.latestVersion);
        sb.append("', needUpdate='");
        sb.append(this.needUpdate);
        sb.append("', releaseDate='");
        sb.append(this.releaseDate);
        sb.append("', releaseNote='");
        sb.append(this.releaseNote);
        sb.append("', serviceName='");
        sb.append(this.serviceName);
        sb.append("', size=");
        sb.append(this.size);
        sb.append(", pluginType=");
        sb.append(this.pluginType);
        sb.append(", updateUrl='");
        sb.append(this.updateUrl);
        sb.append("', updateUrl2='");
        sb.append(this.updateUrl2);
        sb.append("', verifyMode=");
        sb.append(this.verifyMode);
        sb.append(", targetAppName='");
        sb.append(this.targetAppName);
        sb.append("', customId=");
        return g.o(sb, this.customId, '}');
    }
}
