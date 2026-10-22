package com.bytedanceos.common.model;

import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CommentParams implements Serializable {
    private static final long serialVersionUID = 4819996669903168274L;
    public int mAppId;
    public String mAppName;
    public String mAppPackage;
    public int mCommentId;
    public String mContent;
    public Object mCookie;
    public int mPageNo;
    public JSONObject mParams;
    public int mScore;
    public String mUser;
    public int mVersionCode;
    public String mVersionName;

    public CommentParams() {
    }

    public static CommentParams convertParams(AppInfo r10) {
        CommentParams r11 = new CommentParams();
        r11.mAppPackage = r10.appPackageName;
        r11.mAppName = r10.appName;
        return r11;
    }

    public static CommentParams convertParams(CommentInfo r10) {
        CommentParams r11 = new CommentParams();
        r11.mUser = r10.user;
        r11.mVersionName = r10.version;
        r11.mScore = r10.score;
        r11.mContent = r10.content;
        r11.mCommentId = r10.comment_id;
        return r11;
    }
}
