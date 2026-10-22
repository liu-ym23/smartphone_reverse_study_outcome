package com.byted.mgl.merge.service.api.share;

import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public class BdpShareBaseInfo {
    public static final String CHANNEL_ARTICLE = "article";
    public static final String CHANNEL_PICTURE = "picture";
    public static final String CHANNEL_TOKEN = "token";
    public static final String CHANNEL_VIDEO = "video";
    private static final String TAG = "BdpShareBaseInfo";
    public String desc;
    public String entryPath;
    public String from;
    public String imMsgContent;
    public int imMsgType;
    public int imShareType;
    public String imageUrl;
    public String innerChannel;
    public boolean isPictureShare;
    public boolean isPictureToken;
    public boolean isShieldSelf;
    public boolean isVideoShare;
    public String linkTitle;
    public String miniImageUrl;
    public String outerShareUrl;
    public String path;
    public String query;
    public String queryString;
    public ShareAppInfo shareAppInfo;
    public ShareExtraInfo shareExtra;
    public String shareToken;
    public String shareType;
    public String templateId;
    public String title;

    public static class ShareAppInfo {
        public String anchorExtra;
        public String appIcon;
        public String appId;
        public String appName;
        public String homePath;
        public int orientation;
        public String schema;
        public String snapshotUrl;
        public String token;
        public String ttId;
        public int type;

        public String toString() {
            return "ShareAppInfo{appId='" + this.appId + "', ttId='" + this.ttId + "', appName='" + this.appName + "', appIcon='" + this.appIcon + "', type=" + this.type + ", schema='" + this.schema + "', anchorExtra='" + this.anchorExtra + "', snapshotUrl='" + this.snapshotUrl + "', orientation=" + this.orientation + ", token='" + this.token + "', homePath='" + this.homePath + "'}";
        }

        public ShareAppInfo() {
        }

        public ShareAppInfo(JSONObject r100) {
            this.appId = r100.optString("appId");
            this.ttId = r100.optString(AppbrandHostConstants.Schema_BDP_LOG.FIELD_TTID);
            this.appName = r100.optString("appName");
            this.appIcon = r100.optString("appIcon");
            this.type = r100.optInt("appType");
            this.schema = r100.optString("schema");
            this.anchorExtra = r100.optString("anchorExtra");
            this.snapshotUrl = r100.optString("snapshotUrl");
            this.orientation = r100.optInt("orientation");
        }
    }

    public static class ShareExtraInfo {
        protected JSONObject extraJson;

        public String toJsonString() {
            return this.extraJson.toString();
        }

        public ShareExtraInfo(JSONObject r100) {
            if (r100 != null) goto L5;
            r100 = new JSONObject();
        L5:
            this.extraJson = r100;
        }

        public <T> T getData(String r100) {
            return (T) this.extraJson.opt(r100);
        }

        public void replace(JSONObject r100) {
            this.extraJson = r100;
        }

        public void updateData(String r100, Object r101) {
            this.extraJson.put(r100, r101);     // Catch: JSONException -> L4
            return;
        }
    }

    public String getExtraString() {
        return this.shareExtra.toJsonString();
    }

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        if (this.shareAppInfo != null) goto L8;
        return r100;
    L8:
        r100.put("channel", this.innerChannel);     // Catch: JSONException -> L7
        r100.put("title", this.title);     // Catch: JSONException -> L7
        r100.put(SocialConstants.PARAM_APP_DESC, this.desc);     // Catch: JSONException -> L7
        r100.put("imageUrl", this.imageUrl);     // Catch: JSONException -> L7
        r100.put("miniImageUrl", this.miniImageUrl);     // Catch: JSONException -> L7
        r100.put(GXTemplateKey.GAIAX_TEMPLATE_ID, this.templateId);     // Catch: JSONException -> L7
        r100.put("path", this.path);     // Catch: JSONException -> L7
        r100.put("query", this.query);     // Catch: JSONException -> L7
        r100.put("queryString", this.queryString);     // Catch: JSONException -> L7
        r100.put("entryPath", this.entryPath);     // Catch: JSONException -> L7
        r100.put("token", this.shareToken);     // Catch: JSONException -> L7
        r100.put("ugUrl", this.outerShareUrl);     // Catch: JSONException -> L7
        r100.put("linkTitle", this.linkTitle);     // Catch: JSONException -> L7
        r100.put("appId", this.shareAppInfo.appId);     // Catch: JSONException -> L7
        r100.put(AppbrandHostConstants.Schema_BDP_LOG.FIELD_TTID, this.shareAppInfo.ttId);     // Catch: JSONException -> L7
        r100.put("appName", this.shareAppInfo.appName);     // Catch: JSONException -> L7
        r100.put("appIcon", this.shareAppInfo.appIcon);     // Catch: JSONException -> L7
        r100.put("appType", this.shareAppInfo.type);     // Catch: JSONException -> L7
        r100.put("schema", this.shareAppInfo.schema);     // Catch: JSONException -> L7
        r100.put("anchorExtra", this.shareAppInfo.anchorExtra);     // Catch: JSONException -> L7
        r100.put("snapshotUrl", this.shareAppInfo.snapshotUrl);     // Catch: JSONException -> L7
        r100.put("orientation", this.shareAppInfo.orientation);     // Catch: JSONException -> L7
        r100.put("extra", getExtraString());     // Catch: JSONException -> L7
        r100.put("homePath", this.shareAppInfo.homePath);     // Catch: JSONException -> L7
    L6:
        return r100;
    }

    public String toString() {
        return "BdpShareBaseInfo{innerChannel='" + this.innerChannel + "', from='" + this.from + "', shareType='" + this.shareType + "', title='" + this.title + "', desc='" + this.desc + "', imageUrl='" + this.imageUrl + "', miniImageUrl='" + this.miniImageUrl + "', outerShareUrl='" + this.outerShareUrl + "', templateId='" + this.templateId + "', path='" + this.path + "', query='" + this.query + "', queryString='" + this.queryString + "', entryPath='" + this.entryPath + "', linkTitle='" + this.linkTitle + "', shareExtra=" + this.shareExtra + ", shareAppInfo=" + this.shareAppInfo + ", shareToken='" + this.shareToken + "', isPictureToken=" + this.isPictureToken + ", isVideoShare=" + this.isVideoShare + ", isShieldSelf=" + this.isShieldSelf + '}';
    }

    public BdpShareBaseInfo() {
    }

    public BdpShareBaseInfo(JSONObject r100) {
        this.innerChannel = r100.optString("channel");
        this.title = r100.optString("title");
        this.desc = r100.optString(SocialConstants.PARAM_APP_DESC);
        this.imageUrl = r100.optString("imageUrl");
        this.miniImageUrl = r100.optString("miniImageUrl");
        this.templateId = r100.optString(GXTemplateKey.GAIAX_TEMPLATE_ID);
        this.path = r100.optString("path");
        this.query = r100.optString("query");
        this.queryString = r100.optString("queryString");
        this.entryPath = r100.optString("entryPath");
        this.shareToken = r100.optString("token");
        this.outerShareUrl = r100.optString("ugUrl");
        this.linkTitle = r100.optString("linkTitle");
        if (TextUtils.isEmpty(r100.optString("appId")) == true) goto L5;
        this.shareAppInfo = new ShareAppInfo(r100);
    L5:
        this.shareExtra = new ShareExtraInfo(r100.optJSONObject("extra"));
    }

    public static BdpShareBaseInfo fromJson(JSONObject r100) {
        return new BdpShareBaseInfo(r100);
    }

    public <T> T getExtraData(String r100) {
        return (T) this.shareExtra.getData(r100);
    }

    public void updateExtraData(String r100, Object r101) {
        this.shareExtra.updateData(r100, r101);
    }
}
