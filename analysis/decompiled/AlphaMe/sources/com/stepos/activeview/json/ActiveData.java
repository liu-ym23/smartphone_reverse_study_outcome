package com.stepos.activeview.json;

/* loaded from: classes.dex */
public class ActiveData {
    private Content content;
    private String miniCompatibleVersion;
    private String version;
    private boolean checkUpgrade = true;
    private boolean debugLog = false;

    public Content getContent() {
        return this.content;
    }

    public String getMiniCompatibleVersion() {
        return this.miniCompatibleVersion;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isCheckUpgrade() {
        return this.checkUpgrade;
    }

    public boolean isDebugLog() {
        return this.debugLog;
    }

    public void setCheckUpgrade(boolean z4) {
        this.checkUpgrade = z4;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public void setDebugLog(boolean z4) {
        this.debugLog = z4;
    }

    public void setMiniCompatibleVersion(String str) {
        this.miniCompatibleVersion = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
