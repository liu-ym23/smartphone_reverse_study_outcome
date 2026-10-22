package com.bytedance.android.livesdkapi.service;

/* JADX INFO: loaded from: classes12.dex */
public class PlatformItem {
    public String mAvatar;
    public long mExpire;
    public long mExpireIn;
    public boolean mLogin;
    public final String mName;
    public String mNickname;
    public long mNotTipExpiredTime;
    public String mPlatformUid;
    public boolean mPublishSelected;
    public boolean mRecommendShowed;
    public int mResource;
    public boolean mSelected;
    public final int mVerbose;

    public PlatformItem(String r100, int r101, int r102) {
        this.mNotTipExpiredTime = -1;
        this.mResource = r101;
        this.mName = r100;
        this.mVerbose = r102;
        this.mLogin = false;
        this.mSelected = false;
        this.mPublishSelected = false;
        this.mNickname = "";
        this.mAvatar = null;
        this.mRecommendShowed = false;
        this.mPlatformUid = "";
    }
}
