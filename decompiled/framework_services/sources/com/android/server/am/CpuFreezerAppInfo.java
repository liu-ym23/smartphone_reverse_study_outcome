package com.android.server.am;

/* JADX INFO: loaded from: classes.dex */
public final class CpuFreezerAppInfo {
    public static final int BANK = 11;
    public static final int BROWSER = 5;
    public static final int CALENDAR_SNOOZE = 12;
    public static final int CAMERA_SHOOTING = 7;
    public static final int CHAT_COMMUNICATION = 1;
    public static final int COMIC_EBOOK = 18;
    public static final int CONSULT_CALCULATION = 21;
    public static final int EDITING_RECORD_EXAMINATION = 28;
    public static final int EMAIL = 32;
    public static final int FLASHLIGHT = 27;
    public static final int FORUM_COMMUNITY = 25;
    public static final int FREEZE_NONE = -1;
    public static final int GAME = 22;
    public static final int GRAB_RED_ENVELOPE = 29;
    public static final int HIDE_KEY_APP = 2;
    public static final int HIGH_POWER = 3;
    public static final int HIGH_POWER_INTERVAL_FREEZE = 9;
    public static final int INDUSTRY_CUSTOMIZATION = 30;
    public static final int IN_TIME_UFZ = 2;
    public static final int IS_KEY_APP = 1;
    public static final int JOURNALISM = 17;
    public static final int MAP_NAVIGATION = 19;
    public static final int MEDICAL_HEALTH = 14;
    public static final int MUSIC = 2;
    public static final int NEED_FREEZE_CYCLE = 4;
    public static final int NETWORK_PAYMENT = 26;
    public static final int NETWORK_TRANSMISSION = 24;
    public static final int NEVER_FREEZE_FOREVER = 1;
    public static final int NEVER_FREEZE_SCREENON = 2;
    public static final int NON_CYCLE_FREEZE = 3;
    public static final int NORMAL = 0;
    public static final int NOT_KEY_APP = 0;
    public static final int ONLINE_LOTTERY_FUND = 9;
    public static final int OTHER = 255;
    public static final int PHOTO_BEAUTIFICATION = 8;
    public static final int RADIO = 33;
    public static final int SAFE_SAVING = 4;
    public static final int SCR_ON_UFZ = 1;
    public static final int SPECIAL_PROTECTION = 0;
    public static final int SPORTS_FITNESS = 15;
    public static final int STOCK_KANPAN = 23;
    public static final int TEST_TOOL = 31;
    public static final int TOOL = 10;
    public static final int TRAVEL_TICKET_HOTEL = 20;
    public static final int TYPEWRITING = 6;
    public static final int VIDEO_PLAYBACK = 3;
    public static final int WALLPAPER_THEME = 16;
    public static final int WEATHER = 13;
    int freezeReason;
    boolean isBackUnfreeze;
    String mAppName;
    int mAppType;
    int mFlags;
    int mFreezeType;
    long mFreezingStartTime;
    boolean mIsAllowKilled;
    boolean mIsAppStarting;
    int mIsKeyApp;
    boolean mIsReceivingBroadcast;
    boolean mIsServiceExecuting;
    long mLastNetChkTime;
    long mLastNetRxBytes;
    long mLastNetTxBytes;
    int mOriginalFreezeType;
    long mProcStartTime;
    int mSelfStart;
    long mStartWorkingTime;
    int mUid;
    int mUidState;
    int preFreezeType;

    public CpuFreezerAppInfo(int uid, String pkgName) {
        this.mUid = uid;
        this.mAppName = pkgName;
        this.mAppType = 255;
        this.preFreezeType = -1;
        this.mOriginalFreezeType = -1;
        this.mFreezeType = 3;
        this.mIsKeyApp = 0;
        this.mFlags = Integer.MIN_VALUE;
        this.mFreezingStartTime = 0;
        this.mIsAllowKilled = false;
        this.mLastNetRxBytes = 0;
        this.mLastNetTxBytes = 0;
        this.mLastNetChkTime = 0;
        this.mSelfStart = 0;
        this.isBackUnfreeze = false;
        this.freezeReason = 0;
        this.mUidState = 20;
    }

    public CpuFreezerAppInfo(CpuFreezerAppInfo mInfo) {
        this.mUid = mInfo.mUid;
        this.mAppName = mInfo.mAppName;
        this.mAppType = mInfo.mAppType;
        this.preFreezeType = mInfo.preFreezeType;
        this.mFreezeType = mInfo.mFreezeType;
        this.mIsKeyApp = mInfo.mIsKeyApp;
        this.mFlags = mInfo.mFlags;
        this.mFreezingStartTime = mInfo.mFreezingStartTime;
        this.mIsAllowKilled = mInfo.mIsAllowKilled;
        this.mLastNetRxBytes = mInfo.mLastNetRxBytes;
        this.mLastNetTxBytes = mInfo.mLastNetTxBytes;
        this.mLastNetChkTime = mInfo.mLastNetChkTime;
        this.mSelfStart = mInfo.mSelfStart;
        this.isBackUnfreeze = mInfo.isBackUnfreeze;
        this.freezeReason = mInfo.freezeReason;
        this.mUidState = 20;
    }

    public CpuFreezerAppInfo(CpuFreezerAppInfo mInfo, int uid, String pkgName) {
        this.mUid = uid;
        this.mAppName = pkgName;
        this.mAppType = mInfo.mAppType;
        this.preFreezeType = mInfo.preFreezeType;
        this.mFreezeType = mInfo.mFreezeType;
        this.mIsKeyApp = mInfo.mIsKeyApp;
        this.mFlags = Integer.MIN_VALUE;
        this.mFreezingStartTime = 0;
        this.mIsAllowKilled = mInfo.mIsAllowKilled;
        this.mLastNetRxBytes = 0;
        this.mLastNetTxBytes = 0;
        this.mLastNetChkTime = 0;
        this.mSelfStart = mInfo.mSelfStart;
        this.isBackUnfreeze = false;
        this.freezeReason = 0;
        this.mUidState = 20;
    }

    public String toString() {
        return this.mUid + "{name=" + this.mAppName + ", freezeType=" + this.mFreezeType + ", preFreezeType=" + this.preFreezeType + ", flags=0x" + Integer.toHexString(this.mFlags) + ", isUnfrzBG=" + this.isBackUnfreeze + ", freezeReason=" + this.freezeReason + ", mUidState=" + this.mUidState + "}";
    }
}
