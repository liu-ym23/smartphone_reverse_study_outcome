package com.bytedance.android.livesdkapi.depend.plugin;

import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class PluginInfo {
    private List<String> backupUrls;
    private String downloadFilenamePrefix;
    private boolean isPreload;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    private String f162628md5;
    private int order;
    private String packageName;
    private int patchBaseVersion;
    private String patchMd5;
    private String patchUrl;
    private int priority;
    private String url;
    private int versionCode;
    private boolean wifiOnly;

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.depend.plugin.PluginInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private List<String> backupUrls;
        private String downloadFilenamePrefix;
        private boolean isPreload;

        /* JADX INFO: renamed from: md5, reason: collision with root package name */
        private String f162629md5;
        private int order;
        private String packageName;
        private int patchBaseVersion;
        private String patchMd5;
        private String patchUrl;
        private int priority;
        private String url;
        private int versionCode;
        private boolean wifiOnly;

        public PluginInfo create() {
            return new PluginInfo(this, null);
        }

        public Builder() {
            this.isPreload = false;
        }

        public List<String> getBackupUrls() {
            return this.backupUrls;
        }

        public String getDownloadFilenamePrefix() {
            return this.downloadFilenamePrefix;
        }

        public String getMd5() {
            return this.f162629md5;
        }

        public int getOrder() {
            return this.order;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public int getPatchBaseVersion() {
            return this.patchBaseVersion;
        }

        public String getPatchMd5() {
            return this.patchMd5;
        }

        public String getPatchUrl() {
            return this.patchUrl;
        }

        public int getPriority() {
            return this.priority;
        }

        public String getUrl() {
            return this.url;
        }

        public int getVersionCode() {
            return this.versionCode;
        }

        public boolean isPreload() {
            return this.isPreload;
        }

        public boolean isWifiOnly() {
            return this.wifiOnly;
        }

        public static /* synthetic */ boolean access$000(Builder r100) {
            return r100.isPreload;
        }

        public static /* synthetic */ String access$100(Builder r100) {
            return r100.patchUrl;
        }

        public static /* synthetic */ String access$200(Builder r100) {
            return r100.patchMd5;
        }

        public static /* synthetic */ int access$300(Builder r100) {
            return r100.patchBaseVersion;
        }

        public Builder setBackupUrls(List<String> r100) {
            this.backupUrls = r100;
            return this;
        }

        public Builder setDownloadFilenamePrefix(String r100) {
            this.downloadFilenamePrefix = r100;
            return this;
        }

        public Builder setMd5(String r100) {
            this.f162629md5 = r100;
            return this;
        }

        public Builder setOrder(int r100) {
            this.order = r100;
            return this;
        }

        public Builder setPackageName(String r100) {
            this.packageName = r100;
            return this;
        }

        public Builder setPatchBaseVersion(int r100) {
            this.patchBaseVersion = r100;
            return this;
        }

        public Builder setPatchMd5(String r100) {
            this.patchMd5 = r100;
            return this;
        }

        public Builder setPatchUrl(String r100) {
            this.patchUrl = r100;
            return this;
        }

        public Builder setPreload(boolean r100) {
            this.isPreload = r100;
            return this;
        }

        public Builder setPriority(int r100) {
            this.priority = r100;
            return this;
        }

        public Builder setUrl(String r100) {
            this.url = r100;
            return this;
        }

        public Builder setVersionCode(int r100) {
            this.versionCode = r100;
            return this;
        }

        public Builder setWifiOnly(boolean r100) {
            this.wifiOnly = r100;
            return this;
        }
    }

    public List<String> getBackupUrls() {
        return this.backupUrls;
    }

    public String getDownloadFilenamePrefix() {
        return this.downloadFilenamePrefix;
    }

    public String getMd5() {
        return this.f162628md5;
    }

    public int getOrder() {
        return this.order;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getPatchBaseVersion() {
        return this.patchBaseVersion;
    }

    public String getPatchMd5() {
        return this.patchMd5;
    }

    public String getPatchUrl() {
        return this.patchUrl;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getUrl() {
        return this.url;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public boolean isPreload() {
        return this.isPreload;
    }

    public boolean isWifiOnly() {
        return this.wifiOnly;
    }

    private PluginInfo(Builder r100) {
        this.isPreload = false;
        this.packageName = r100.getPackageName();
        this.versionCode = r100.getVersionCode();
        this.url = r100.getUrl();
        this.backupUrls = r100.getBackupUrls();
        this.f162628md5 = r100.getMd5();
        this.wifiOnly = r100.isWifiOnly();
        this.order = r100.getOrder();
        this.priority = r100.getPriority();
        this.downloadFilenamePrefix = r100.getDownloadFilenamePrefix();
        this.isPreload = Builder.access$000(r100);
        this.patchUrl = Builder.access$100(r100);
        this.patchMd5 = Builder.access$200(r100);
        this.patchBaseVersion = Builder.access$300(r100);
    }

    public void setBackupUrls(List<String> r100) {
        this.backupUrls = r100;
    }

    public void setDownloadFilenamePrefix(String r100) {
        this.downloadFilenamePrefix = r100;
    }

    public void setMd5(String r100) {
        this.f162628md5 = r100;
    }

    public void setOrder(int r100) {
        this.order = r100;
    }

    public void setPackageName(String r100) {
        this.packageName = r100;
    }

    public void setPatchBaseVersion(int r100) {
        this.patchBaseVersion = r100;
    }

    public void setPatchMd5(String r100) {
        this.patchMd5 = r100;
    }

    public void setPatchUrl(String r100) {
        this.patchUrl = r100;
    }

    public void setPriority(int r100) {
        this.priority = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    public void setVersionCode(int r100) {
        this.versionCode = r100;
    }

    public void setWifiOnly(boolean r100) {
        this.wifiOnly = r100;
    }

    public /* synthetic */ PluginInfo(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
