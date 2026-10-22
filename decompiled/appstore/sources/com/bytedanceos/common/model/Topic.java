package com.bytedanceos.common.model;

import android.text.TextUtils;
import com.android.internal.util.ArrayUtils;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class Topic implements Serializable {
    public static final String[] COMPAT_IDS = null;
    public static final String ID_GAME_GIFTS = "2";
    public static final String ID_HISTORY = "3";
    public static final String ID_ONE_STEP = "373";
    public static final String PAGE_ID_ENTER_GAME_STORE = "8";
    public static final String PAGE_ID_GAME_SUBCRIBE_LIST = "6";
    public static final String PAGE_ID_ONE_STEP = "4";
    public static final String PAGE_ID_VENDOR_ZONE = "13";
    public static final String TYPE_APP = "1";
    public static final String TYPE_DEVELOPER = "4";
    public static final String TYPE_SECEND_BAR = "5";
    public static final String TYPE_TOPIC = "2";
    public static final String TYPE_WEBVIEW = "3";
    private static final long serialVersionUID = 3108834786417291662L;
    private String apiurl;
    private int bannerId;
    private String description;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f9838id;
    private String imageResUrl;
    private boolean isBigPicture;
    private int location;
    private String mAppCategoryName;
    private String mAppName;
    private float mAppScores;
    private int mAppSize;
    private String mDownloadUrl;
    private String mIntroduce;
    private ArrayList<Integer> mLabels;
    private String mLogo;
    private String mPageId;
    private String mSSTJ;
    private String mShareUrl;
    private String mTabSource;
    private int mVersionCode;
    private String mWebUrl;
    private String packageName;
    private String subTitle;
    private String title;
    private String type;

    static {
        COMPAT_IDS = new String[]{"6"};
    }

    public Topic() {
        this.f9838id = "";
        this.type = "2";
        this.mPageId = "";
        this.mLabels = new ArrayList();
    }

    public AppInfo convertToAppInfo() {
        AppInfo r10 = new AppInfo();
        r10.appName = this.mAppName;
        r10.appAliasName = this.title;
        r10.appPackageName = this.packageName;
        r10.appIcon = this.mLogo;
        r10.mSSTJ = this.mSSTJ;
        r10.appDownloadUrl = this.mDownloadUrl;
        r10.mWebUril = this.mWebUrl;
        r10.appBytes = this.mAppSize;
        r10.appCategoryName = this.mAppCategoryName;
        r10.mLabels = this.mLabels;
        r10.appScores = this.mAppScores;
        r10.appVersionCode = this.mVersionCode;
        r10.appSource = "local";
        r10.appShareUrl = this.mShareUrl;
        r10.tabSource = this.mTabSource;
        return r10;
    }

    public String getApiUrl() {
        return this.apiurl;
    }

    public String getAppCategoryName() {
        return this.mAppCategoryName;
    }

    public int getBannerId() {
        return this.bannerId;
    }

    public String getDescription() {
        return this.description;
    }

    public String getId() {
        return this.f9838id;
    }

    public String getImageResUrl() {
        return this.imageResUrl;
    }

    public String getIntroduce() {
        return this.mIntroduce;
    }

    public ArrayList<Integer> getLabels() {
        return this.mLabels;
    }

    public int getLocation() {
        return this.location;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPageId() {
        return this.mPageId;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTabSource() {
        return this.mTabSource;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTopicId() {
        if (TextUtils.isEmpty(getPageId()) == false) goto L6;
        return getId();
    L6:
        return getPageId();
    }

    public String getType() {
        return this.type;
    }

    public String getWebUrl() {
        return this.mWebUrl;
    }

    public boolean isAvaliable() {
        return !TextUtils.isEmpty(getTopicId());
    }

    public boolean isBigPicture() {
        return this.isBigPicture;
    }

    public boolean isTopicCompat() {
        String[] r10 = COMPAT_IDS;
        if (ArrayUtils.contains(r10, getPageId()) == false) goto L7;
        return true;
    L7:
        return ArrayUtils.contains(r10, getId());
    }

    public void setApiUrl(String r10) {
        this.apiurl = r10;
    }

    public void setAppCategoryName(String r10) {
        this.mAppCategoryName = r10;
    }

    public void setAppName(String r10) {
        this.mAppName = r10;
    }

    public void setAppScores(float r10) {
        this.mAppScores = r10;
    }

    public void setAppSize(int r10) {
        this.mAppSize = r10;
    }

    public void setBannerId(int r10) {
        this.bannerId = r10;
    }

    public void setBigPicture(boolean r10) {
        this.isBigPicture = r10;
    }

    public void setDescription(String r10) {
        this.description = r10;
    }

    public void setDownloadUrl(String r10) {
        this.mDownloadUrl = r10;
    }

    public void setId(String r10) {
        this.f9838id = r10;
    }

    public void setImageResUrl(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L8:
        this.imageResUrl = r10;
        return;
    L5:
        if (r10.startsWith("http://") == true) goto L8;
        if (r10.startsWith("https://") == true) goto L8;
    }

    public void setIntroduce(String r10) {
        this.mIntroduce = r10;
    }

    public void setLocation(int r10) {
        this.location = r10;
    }

    public void setLogo(String r10) {
        this.mLogo = r10;
    }

    public void setPackageName(String r10) {
        this.packageName = r10;
    }

    public void setPageId(String r10) {
        this.mPageId = r10;
    }

    public void setSSTJ(String r10) {
        this.mSSTJ = r10;
    }

    public void setShareUrl(String r10) {
        this.mShareUrl = r10;
    }

    public void setSubTitle(String r10) {
        this.subTitle = r10;
    }

    public void setTabSource(String r10) {
        this.mTabSource = r10;
    }

    public void setTitle(String r10) {
        this.title = r10;
    }

    public void setType(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L6;
        this.type = r10;
        return;
    }

    public void setVersionCode(int r10) {
        this.mVersionCode = r10;
    }

    public void setWebUrl(String r10) {
        this.mWebUrl = r10;
    }
}
