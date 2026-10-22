package com.bytedance.android.livesdkapi.depend.plugin;

import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class DownloadRequest {
    private int currentRequestUrlIndex;
    private String currentUrl;
    private PluginInfo info;
    private String mDownloadDir;
    private String mDownloadFilename;
    private boolean mOnlyWifi;
    private String mUrl;
    private List<String> mUrls;

    public static class Builder {
        private PluginInfo info;
        private String mDownloadDir;
        private String mDownloadFilename;
        private boolean mOnlyWifi;
        private String mUrl;

        public Builder() {
        }

        public DownloadRequest create() {
            return new DownloadRequest(this);
        }

        public PluginInfo getInfo() {
            return this.info;
        }

        public static /* synthetic */ String access$000(Builder r100) {
            return r100.mUrl;
        }

        public static /* synthetic */ String access$100(Builder r100) {
            return r100.mDownloadFilename;
        }

        public static /* synthetic */ String access$200(Builder r100) {
            return r100.mDownloadDir;
        }

        public static /* synthetic */ boolean access$300(Builder r100) {
            return r100.mOnlyWifi;
        }

        public Builder setDownloadDir(String r100) {
            this.mDownloadDir = r100;
            return this;
        }

        public Builder setDownloadFilename(String r100) {
            this.mDownloadFilename = r100;
            return this;
        }

        public Builder setInfo(PluginInfo r100) {
            this.info = r100;
            return this;
        }

        public Builder setOnlyWifi(boolean r100) {
            this.mOnlyWifi = r100;
            return this;
        }

        public Builder setUrl(String r100) {
            this.mUrl = r100;
            return this;
        }
    }

    public String getUrl() {
        if (Lists.isEmpty(this.mUrls) == true) goto L5;
        String r100 = (String) ListProtector.get(this.mUrls, this.currentRequestUrlIndex);
        this.currentRequestUrlIndex = (this.currentRequestUrlIndex + 1) % this.mUrls.size();
        this.currentUrl = r100;
        return r100;
    L5:
        return this.mUrl;
    }

    public int hashCode() {
        String r100 = this.mUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.mDownloadDir;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String getCurrentUrl() {
        return this.currentUrl;
    }

    public String getDownloadDir() {
        return this.mDownloadDir;
    }

    public String getDownloadFilename() {
        return this.mDownloadFilename;
    }

    public PluginInfo getInfo() {
        return this.info;
    }

    public boolean isOnlyWifi() {
        return this.mOnlyWifi;
    }

    public DownloadRequest(Builder r100) {
        this.currentRequestUrlIndex = 0;
        this.mUrls = new ArrayList();
        this.mUrl = Builder.access$000(r100);
        this.mDownloadFilename = Builder.access$100(r100);
        this.mDownloadDir = Builder.access$200(r100);
        this.mOnlyWifi = Builder.access$300(r100);
        this.currentUrl = Builder.access$000(r100);
        this.info = r100.getInfo();
        this.mUrls.add(this.mUrl);
        PluginInfo r101 = this.info;
        if (r101 != null) goto L5;
        return;
    L5:
        if (Lists.isEmpty(r101.getBackupUrls()) == true) goto L9;
        this.mUrls.addAll(this.info.getBackupUrls());
        return;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L25;
        DownloadRequest r101 = (DownloadRequest) r100;
        String r102 = this.mUrl;
        if (r102 == null) goto L16;
        if (r102.equals(r101.mUrl) == false) goto L17;
    L18:
        String r103 = this.mDownloadDir;
        String r104 = r101.mDownloadDir;
        if (r103 != null) goto L26;
        if (r104 == null) goto L27;
        return false;
    L27:
        return true;
    L26:
        return r103.equals(r104);
    L17:
        return false;
    L16:
        if (r101.mUrl == null) goto L18;
        goto L17
    }

    public void setInfo(PluginInfo r100) {
        this.info = r100;
    }
}
