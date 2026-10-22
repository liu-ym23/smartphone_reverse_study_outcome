package com.bytedanceos.common.model;

import android.text.TextUtils;
import com.smt.obric.appstore.domain.app.entity.AppInstallMode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class AppInfo implements Model, AppInfoFilterInterface, Cloneable, IAppInfo {
    public static final int APP_CHECKED = 1;
    public static final int APP_UNCHECKED = 0;
    public static final String NO_MD5_KEY = "no_key";
    public static final String SEARCH_LIST_SHOW_APPS = "apps";
    public static final String SEARCH_LIST_SHOW_RESERVATION_APPS = "subscribe_apps";
    public static final String SEARCH_LIST_SHOW_WORDS = "words";
    public static final String SEARCH_SOURCE_EXTENAL = "other";
    public static final String SEARCH_SOURCE_LOCAL = "local";
    public static final String SEARCH_SOURCE_SPLIT = "split";
    private static final Comparator<AppInfo> mComparator = null;
    private static final long serialVersionUID = 9105288279467365023L;
    public String agreement;
    public String appAliasName;
    public String appBrief;
    public long appBytes;
    public String appCategoryName;
    public int appCommentCnt;
    public String appDeveloper;
    public String appDeveloperId;
    public String appDownloadUrl;
    public List<String> appDownloadUrlBackups;
    private IAppExtra appExtraInfo;
    public long appFirstInstallTime;
    public From appFrom;
    public String appIcon;
    public String appId;
    public long appLastUpdateTime;
    public String appName;
    public String appNewFeature;
    public String appOpTime;
    public String appPackageName;
    public String appScalable;
    public float appScores;
    public Map<String, List<String>> appScreenShotsBySize;
    public List<String> appScreenSnaps;
    public String appShareUrl;
    public String appShowLastUpdateTime;
    private String appSize;
    public String appSource;
    public volatile int appState;
    public int appVersionCode;
    public String appVersionName;
    public int debugODownloadState;
    public volatile int default_check;
    public long downloadCurrentBytes;
    public String downloadFilePath;
    public volatile long downloadId;
    public double downloadProgress;
    public int downloadStatus;
    public long downloadTime;
    public long downloadTotalBytes;
    public String fileMd5;
    public int hideVersionCode;
    public String icp;

    @Deprecated
    public int installMode;
    public boolean isAppReport;
    public boolean isAppSync;
    public boolean isAppUpdate;
    public boolean isAutoDownload;
    public boolean isBanner;
    public boolean isCollected;
    public boolean isNeededAdd;
    public boolean isNeededDelete;
    public boolean isNeededSync;
    public String itemPosition;
    public String listShowType;
    public String mAdDsp;
    public String mAdExtra;
    public boolean mAllowMobile;
    public String mApiUrl;
    public int mAppType;
    public volatile int mAppUpdateType;
    public String mAppVideoImage;
    public int mAppVideoType;
    public String mAppVideoUrl;
    public String mBaseApkMd5;
    public String mCategoryId;
    public String mDiffDownloadUrl;
    public String mDiffMD5;
    public String mDmFilePath;
    public String mDmUrl;
    public String mDownloadFailReason;
    public String mDsp;
    public List<GameModel> mGameMode;
    public String mGiftPackCode;
    public boolean mHasSourceView;
    public int mInstallFlag;
    public boolean mIsDownloadApk;
    public boolean mIsNeedGms;
    public boolean mIsPushReservation;
    public int mItemShowType;
    public String mJsonData;
    public ArrayList<Integer> mLabels;
    public String mLocation;
    public String mMemFilePath;
    public String mMemUrl;
    public int mNumber;
    public String mOnlineTime;
    public String mPageTitle;
    public int mRetryNum;
    public String mSSTJ;
    public volatile boolean mShowRetryBtn;
    public String mSourcePkgName;
    public int mStatus;
    public String mSubtitle;
    public int mSysAppAutoUpdateComplianceMode;
    public long mSysAppAutoUpdateTaskId;
    public int mTaskOwner;
    public String mTitle;
    public int mUpdateModel;
    public String mWebUril;
    public String notifyPkgName;
    public String obricPreloadApkFilePath;
    public long pauseCode;
    public String privacyAgreementUrl;
    public String recmd_brief;
    public String secondCategoryId;
    public String sha256;
    public String tabSource;
    public long timeDownloadEnqueue;
    public String traceId;
    public String trackerInfo;

    public static class From implements Serializable {
        public static final String DEFAULT_NAME = "local";
        public String logo;
        public String mark;
        public String name;
        public String operative_type;
        public String url;

        public From() {
        }

        public From setLogo(String r10) {
            this.logo = r10;
            return this;
        }

        public From setName(String r10) {
            this.name = r10;
            return this;
        }

        public From setOperative(String r10) {
            this.operative_type = r10;
            return this;
        }

        public From setUrl(String r10) {
            this.url = r10;
            return this;
        }
    }

    static {
        mComparator = Comparator.comparingLong(new a()).thenComparing(new b()).thenComparing(new c()).thenComparing(new d());
    }

    public AppInfo() {
        this.appPackageName = "";
        this.mIsDownloadApk = true;
        this.appVersionName = "";
        this.fileMd5 = "";
        this.traceId = "";
        this.appState = 32;
        this.downloadTime = -1;
        this.default_check = 0;
        this.itemPosition = "";
        this.recmd_brief = "";
        this.trackerInfo = "undefined";
        this.mLabels = new ArrayList();
        this.mAllowMobile = false;
        this.mDiffMD5 = "";
        this.mDiffDownloadUrl = "";
        this.mDownloadFailReason = "";
        this.mIsPushReservation = false;
        this.mAdExtra = "";
        this.mAdDsp = "";
        this.mRetryNum = 0;
        this.mUpdateModel = 0;
        this.installMode = AppInstallMode.c.f17964a.getOrdinal();
        this.mSysAppAutoUpdateTaskId = 0;
        this.mSysAppAutoUpdateComplianceMode = 0;
        this.appSize = "";
        this.privacyAgreementUrl = null;
        this.debugODownloadState = -99999;
    }

    public static Comparator<AppInfo> getComparator() {
        return mComparator;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m9clone() throws CloneNotSupportedException {
        return clone();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L31:
        return false;
    L8:
        if (getClass() != r10.getClass()) goto L31;
        AppInfo r11 = (AppInfo) r10;
        if (this.timeDownloadEnqueue != r11.timeDownloadEnqueue) goto L30;
        if (Objects.equals(this.appName, r11.appName) == false) goto L30;
        if (Objects.equals(this.appPackageName, r11.appPackageName) == false) goto L30;
        if (Integer.valueOf(this.appVersionCode).equals(Integer.valueOf(r11.appVersionCode)) == false) goto L30;
        if (Objects.equals(this.appVersionName, r11.appVersionName) == false) goto L30;
        if (Integer.valueOf(this.mUpdateModel).equals(Integer.valueOf(r11.mUpdateModel)) == false) goto L30;
        if (Objects.equals(this.downloadFilePath, r11.downloadFilePath) == false) goto L30;
        if (Objects.equals(this.obricPreloadApkFilePath, r11.obricPreloadApkFilePath) == false) goto L30;
        if (Objects.equals(this.appIcon, r11.appIcon) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public IAppExtra getAppExtraInfo() {
        return this.appExtraInfo;
    }

    @Override // com.bytedanceos.common.model.IAppInfo
    public AppInfo getAppInfo() {
        return this;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppPackageName() {
        return this.appPackageName;
    }

    public String getAppSize() {
        return this.appSize;
    }

    public String getAppVersionName() {
        return this.appVersionName;
    }

    @Override // com.bytedanceos.common.model.Model
    public String getId() {
        return this.appId;
    }

    @Override // com.bytedanceos.common.model.Model
    public String getName() {
        return this.appPackageName;
    }

    @Override // com.bytedanceos.common.model.AppInfoFilterInterface
    public String getPackageNameForFilter() {
        String r10 = this.appPackageName;
        if (r10 != null) goto L6;
        return "";
    L6:
        return r10;
    }

    public int getSoftType() {
        if (isSystemApp() == false) goto L7;
        return 3;
    L7:
        return this.mAppType;
    }

    public long getTimeDownloadEnqueue() {
        return this.timeDownloadEnqueue;
    }

    public boolean hasGift() {
        List<GameModel> r10 = this.mGameMode;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.size() <= 0) goto L7;
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.appName, this.appPackageName, Long.valueOf(this.timeDownloadEnqueue), Integer.valueOf(this.appVersionCode), this.appVersionName, Integer.valueOf(this.mUpdateModel), this.downloadFilePath, this.obricPreloadApkFilePath, this.appIcon});
    }

    public boolean isAD() {
        int r10 = this.mAppType;
        if (r10 != 4) goto L5;
    L8:
        return true;
    L5:
        if (r10 == 5) goto L8;
        return false;
    }

    public boolean isFromAutoUpdate() {
        if ("sys_app_default".equals(this.appSource) == false) goto L5;
    L12:
        return true;
    L5:
        if ("sys_app_force".equals(this.appSource) == true) goto L12;
        if ("sys_app_silence_mobile".equals(this.appSource) == true) goto L12;
        if ("sys_app_silence".equals(this.appSource) == true) goto L12;
        return false;
    }

    public boolean isGame() {
        int r10 = this.mAppType;
        if (r10 != 1) goto L5;
        return true;
    L5:
        if (r10 == 5) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean isSplit() {
        return TextUtils.equals(SEARCH_SOURCE_SPLIT, this.appSource);
    }

    public boolean isSysAppAutoUpdate() {
        if (this.mUpdateModel != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mSysAppAutoUpdateTaskId == 0) goto L7;
        return true;
    }

    public boolean isSystemApp() {
        if (this.appState != 64) goto L6;
        return false;
    L6:
        if (this.mAppType != 3) goto L8;
        return true;
    L8:
        if (TextUtils.equals(this.appSource, "system") == false) goto L10;
        return true;
    L10:
        if (TextUtils.equals(this.appSource, "obric_sys_app") == true) goto L16;
        return false;
    L16:
        return true;
    }

    public void setAppExtraInfo(IAppExtra r10) {
        this.appExtraInfo = r10;
    }

    public void setAppSize(String r10) {
        this.appSize = r10;
    }

    public From setFrom(String r10) {
        if (this.appFrom != null) goto L5;
        this.appFrom = new From();
    L5:
        From r11 = this.appFrom;
        r11.mark = r10;
        return r11;
    }

    public From setOperative(String r10) {
        if (this.appFrom != null) goto L5;
        this.appFrom = new From();
    L5:
        this.appFrom.setOperative(r10);
        return this.appFrom;
    }

    public boolean showRetry() {
        boolean r10 = this.isAutoDownload;
        if (r10 == true) goto L5;
    L6:
        if (r10 == true) goto L10;
        if (this.mRetryNum != 2) goto L10;
    L11:
        return true;
    L10:
        if (this.mShowRetryBtn == true) goto L11;
        return false;
    L5:
        if (this.mRetryNum == 5) goto L11;
        goto L6
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("\n >>>>>>>>>>>>>>>>>> AppInfo");
        r10.append("\n >>>>>>>>>>>>>>>>>> AppName:\t\t\t" + this.appName);
        r10.append("\n >>>>>>>>>>>>>>>>>> PackageName:\t\t\t" + this.appPackageName);
        r10.append("\n >>>>>>>>>>>>>>>>>> DownloadId:\t\t\t" + this.downloadId);
        r10.append("\n >>>>>>>>>>>>>>>>>> AppState:\t\t\t" + this.appState);
        r10.append("\n >>>>>>>>>>>>>>>>>> Status:\t\t\t" + this.downloadStatus);
        r10.append("\n >>>>>>>>>>>>>>>>>> OStatus:\t\t\t" + this.debugODownloadState);
        r10.append("\n >>>>>>>>>>>>>>>>>> TotalBytes:\t\t\t" + this.downloadTotalBytes);
        r10.append("\n >>>>>>>>>>>>>>>>>> CurrentBytes:\t\t\t" + this.downloadCurrentBytes);
        r10.append("\n >>>>>>>>>>>>>>>>>> Progress:\t\t\t" + this.downloadProgress);
        r10.append("\n >>>>>>>>>>>>>>>>>> recmd_brief:\t\t\t" + this.recmd_brief);
        r10.append("\n >>>>>>>>>>>>>>>>>> DownloadUrl:\t\t\t" + this.appDownloadUrl);
        r10.append("\n >>>>>>>>>>>>>>>>>> notifyPkgName:\t\t\t" + this.notifyPkgName);
        r10.append("\n >>>>>>>>>>>>>>>>>> versionCode:\t\t\t" + this.appVersionCode);
        r10.append("\n >>>>>>>>>>>>>>>>>> fileMd5:\t\t\t" + this.fileMd5);
        r10.append("\n >>>>>>>>>>>>>>>>>> mRetryNum:\t\t\t" + this.mRetryNum);
        r10.append("\n >>>>>>>>>>>>>>>>>> isAutoDownload:\t\t\t" + this.isAutoDownload);
        r10.append("\n >>>>>>>>>>>>>>>>>> mShowRetryBtn:\t\t\t" + this.mShowRetryBtn);
        r10.append("\n >>>>>>>>>>>>>>>>>> pauseCode:\t\t\t" + this.pauseCode);
        r10.append("\n >>>>>>>>>>>>>>>>>> appSource:\t\t\t" + this.appSource);
        return r10.toString();
    }

    public AppInfo clone() {
        return (AppInfo) super.clone();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
