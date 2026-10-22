package com.byted.cast.common.bean;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class XiguaBdLinkUriInfo {

    @SerializedName("play_info")
    private XiguaPlayInfo playInfo;

    public static class XiguaPlayInfo {

        @SerializedName("resolution_info_list")
        private List<XiguaResolutionInfo> resolutionInfoList;

        @SerializedName("target_resolution")
        private String targetResolution;

        public XiguaPlayInfo() {
        }

        public String getTargetResolutionUrl() {
            List<XiguaResolutionInfo> r100 = this.resolutionInfoList;
            if (r100 != null) goto L5;
            return "";
        L5:
            if (r100.isEmpty() == false) goto L8;
            return "";
        L8:
            if (TextUtils.isEmpty(this.targetResolution) == true) goto L10;
            Iterator<XiguaResolutionInfo> r101 = this.resolutionInfoList.iterator();
        L13:
            if (r101.hasNext() == false) goto L19;
            XiguaResolutionInfo r102 = r101.next();
            if (this.targetResolution.equals(r102.getResolution()) == false) goto L13;
            return r102.getUrl();
        L19:
            return ((XiguaResolutionInfo) ListProtector.get(this.resolutionInfoList, 0)).getUrl();
        L10:
            return ((XiguaResolutionInfo) ListProtector.get(this.resolutionInfoList, 0)).getUrl();
        }

        public List<XiguaResolutionInfo> getResolutionInfoList() {
            return this.resolutionInfoList;
        }

        public String getTargetResolution() {
            return this.targetResolution;
        }

        public void setResolutionInfoList(List<XiguaResolutionInfo> r100) {
            this.resolutionInfoList = r100;
        }

        public void setTargetResolution(String r100) {
            this.targetResolution = r100;
        }
    }

    public static class XiguaResolutionInfo {
        private String resolution;
        private String url;

        public XiguaResolutionInfo() {
        }

        public String getResolution() {
            return this.resolution;
        }

        public String getUrl() {
            return this.url;
        }

        public void setResolution(String r100) {
            this.resolution = r100;
        }

        public void setUrl(String r100) {
            this.url = r100;
        }
    }

    public XiguaBdLinkUriInfo() {
    }

    public String getTargetResolutionUrl() {
        XiguaPlayInfo r100 = this.playInfo;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getTargetResolutionUrl();
    }

    public XiguaPlayInfo getPlayInfo() {
        return this.playInfo;
    }

    public void setPlayInfo(XiguaPlayInfo r100) {
        this.playInfo = r100;
    }
}
