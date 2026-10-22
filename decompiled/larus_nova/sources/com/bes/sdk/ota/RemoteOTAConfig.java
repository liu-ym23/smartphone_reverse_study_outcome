package com.bes.sdk.ota;

import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class RemoteOTAConfig implements Serializable {
    private String checkSum;
    private String downloadUrl;
    private String localPath;
    private String pid;
    private String version;
    private String whatsNewContent;
    private String whatsNewTitle;

    public RemoteOTAConfig() {
    }

    public String toString() {
        return "RemoteOTAConfig{pid='" + this.pid + "', version='" + this.version + "', downloadUrl='" + this.downloadUrl + "', localPath='" + this.localPath + "', checkSum='" + this.checkSum + "', whatsNewTitle='" + this.whatsNewTitle + "', whatsNewContent='" + this.whatsNewContent + "'}";
    }

    public String getCheckSum() {
        return this.checkSum;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public String getPid() {
        return this.pid;
    }

    public String getVersion() {
        return this.version;
    }

    public String getWhatsNewContent(String r100) {
        return this.whatsNewContent;
    }

    public String getWhatsNewTitle(String r100) {
        return this.whatsNewTitle;
    }

    public void setCheckSum(String r100) {
        this.checkSum = r100;
    }

    public void setDownloadUrl(String r100) {
        this.downloadUrl = r100;
    }

    public void setLocalPath(String r100) {
        this.localPath = r100;
    }

    public void setPid(String r100) {
        this.pid = r100;
    }

    public void setVersion(String r100) {
        this.version = r100;
    }

    public void setWhatsNewContent(String r100) {
        this.whatsNewContent = r100;
    }

    public void setWhatsNewTitle(String r100) {
        this.whatsNewTitle = r100;
    }
}
