package com.stepos.alphame;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.alphame.appinfo.ActivityInfoRuleUpdater;
import com.stepos.alphame.appinfo.AppInfoRuleUpdater;
import com.stepos.alphame.appinfo.ExtraListRuleUpdater;
import com.stepos.alphame.appinfo.UnboundedListRuleUpdater;
import com.stepos.alphame.cutout.CutImageRuleUpdater;
import com.stepos.alphame.notification.NotiRuleUpdater;
import com.stepos.alphame.ocr.OcrRuleUpdater;
import com.stepos.alphame.power.PowerEngine;
import com.stepos.alphame.reflect.UserInfoProxy;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.HttpRequestHelper;
import com.stepos.alphame.utils.NamedThreadFactory;
import com.stepos.alphame.utils.NetEnvHelper;
import com.stepos.alphame.utils.NetworkHelper;
import com.stepos.alphame.utils.Property;
import com.stepos.alphame.utils.Utils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class RuleUpdater {
    public static final int MODE_MOBILE_NETWORK = 0;
    public static final int MODE_UPDATE_NEW_INSTALLED_APP = 2;
    public static final int MODE_WIFI = 1;
    private static final long NETWORK_CHECK_DURATION = 1800000;
    private static final long NORMAL_DOWNLOAD_TIMEOUT = 30000;
    private static final String TAG = "RuleUpdater";
    private static final String TAG_ACTIVITY = "activitypermission";
    private static final String TAG_ACTIVITY_STATS_CONFIG = "activity_stats_config";
    private static final String TAG_CUT_IMAGE = "cutImageModel";
    private static final String TAG_DATEINFO = "dateInfo";
    private static final String TAG_EXTRA = "commomWhitelists";
    private static final String TAG_NEWPERMISSION = "newpermission";
    private static final String TAG_NOTI = "notificationModel";
    private static final String TAG_NOTI_WHITELIST = "notificationWhiteList";
    private static final String TAG_OCR = "pickerOcrModel";
    private static final String TAG_PACKS = "packs";
    private static final String TAG_UNBOUNDED_MIX_LIST = "unboundedlist";
    private static final String TAG_URL = "url";
    private static final String TAG_VERSION = "ver";
    private static final long UPDATE_APP_BOOT_DELAY = 60000;
    private static final long UPDATE_DURATION = 36000000;
    private static final long UPDATE_SYSTEM_BOOT_DELAY = 600000;
    private static RuleUpdater sInstance;
    private boolean mShuttingDown;
    private ExecutorService mUpdateThread;
    private ExecutorService mUpdateThreadEx;
    private long mLastScreenOffCheckTime = 0;
    private long mLastUpdateTime = 0;
    private long mWifiUpdateTime = 0;
    private long mLastUpdateTimeEx = 0;
    private final NotiRuleUpdater mNotiRuleUpdater = new NotiRuleUpdater();
    private final AppInfoRuleUpdater mAppInfoRuleUpdater = AppInfoRuleUpdater.getInstance();
    private OcrRuleUpdater mOcrRuleUpdater = new OcrRuleUpdater();
    private final ActivityInfoRuleUpdater mActivityInfoRuleUpdater = new ActivityInfoRuleUpdater();
    private final ExtraListRuleUpdater mExtraListRuleUpdater = new ExtraListRuleUpdater();
    private final UnboundedListRuleUpdater mUnboundedListRuleUpdater = new UnboundedListRuleUpdater();
    private CutImageRuleUpdater mCutImageRuleUpdater = new CutImageRuleUpdater();

    public class UpdaterRunnable implements Runnable {
        private int mode;

        public UpdaterRunnable(int i4) {
            this.mode = i4;
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x01a8  */
        /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 432
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.RuleUpdater.UpdaterRunnable.run():void");
        }
    }

    public class UpdaterRunnableEx implements Runnable {
        private int mode;

        public UpdaterRunnableEx(int i4) {
            this.mode = i4;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            AlphaMeLogger.wLog("RuleUpdaterEx update mode = " + this.mode);
            boolean z4 = this.mode == 1;
            String str = new SimpleDateFormat("yyyyMMdd", Locale.CHINA).format(new Date());
            String txt = HttpRequestHelper.getTxt(NetEnvHelper.mapUrl("https://resm-onemind.zyql.com/pack/conf" + str + ".ini"));
            String txt2 = HttpRequestHelper.getTxt(NetEnvHelper.mapUrl("https://resm-onemind.zyql.com/pack/pack" + str + ".ini"));
            AlphaMeLogger.wLog("RuleUpdaterEx szIndexEmpty: " + TextUtils.isEmpty(txt2) + " configEmpty: " + TextUtils.isEmpty(txt));
            if (TextUtils.isEmpty(txt2) || TextUtils.isEmpty(txt)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(txt2);
                JSONObject jSONObject2 = jSONObject.getJSONObject(RuleUpdater.TAG_UNBOUNDED_MIX_LIST).getJSONArray(RuleUpdater.TAG_PACKS).getJSONObject(0);
                RuleUpdater.this.mUnboundedListRuleUpdater.update(jSONObject2.getString(RuleUpdater.TAG_VERSION), jSONObject2.getString("url"), z4);
                JSONObject jSONObject3 = jSONObject.getJSONObject(RuleUpdater.TAG_CUT_IMAGE).getJSONArray(RuleUpdater.TAG_PACKS).getJSONObject(0);
                RuleUpdater.this.mCutImageRuleUpdater.update(jSONObject3.getString(RuleUpdater.TAG_VERSION), jSONObject3.getString("url"));
                RuleUpdater.this.mLastUpdateTimeEx = System.currentTimeMillis();
                AlphaMeLogger.iLog("RuleUpdaterEx update end");
            } catch (JSONException e4) {
                Log.e(RuleUpdater.TAG, "RuleUpdaterEx JSONException: " + e4);
            }
        }
    }

    private RuleUpdater() {
    }

    public static synchronized RuleUpdater getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new RuleUpdater();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    private boolean isJustBoot(long j4) {
        return SystemClock.elapsedRealtime() <= 600000 && j4 - ApplicationImpl.getAppBootTime() < 60000;
    }

    public String getCdnInfo(String str) throws JSONException {
        String string = null;
        try {
            if (TextUtils.isEmpty(Property.getCdnPack())) {
                AlphaMeLogger.dLog("content is null");
            } else {
                JSONObject jSONObject = new JSONObject(Property.getCdnPack());
                if (jSONObject.has(str)) {
                    string = jSONObject.getString(str);
                } else {
                    AlphaMeLogger.wLog("getCdnInfo tag " + str + " not found");
                }
            }
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("getTagInfo error", e4);
        }
        return string;
    }

    public String[] getDateInfo(String str) throws JSONException {
        Object obj;
        String cdnInfo = getInstance().getCdnInfo(TAG_DATEINFO);
        String[] strArr = null;
        if (TextUtils.isEmpty(cdnInfo)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(cdnInfo);
            if (!jSONObject.has(str) || (obj = jSONObject.get(str)) == null) {
                return null;
            }
            strArr = new String[]{((JSONObject) obj).getString("vacation"), ((JSONObject) obj).getString("holiday")};
            return strArr;
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("get dataInfo error!!", e4);
            return strArr;
        }
    }

    public void setShuttingDown(boolean z4) {
        this.mShuttingDown = z4;
    }

    public void tryUpdate(long j4) {
        ApplicationImpl application = ApplicationImpl.getApplication();
        boolean zIsWifiNetwork = NetworkHelper.isWifiNetwork(application);
        AlphaMeLogger.iLog("RuleUpdater tryUpdate isWifi = " + zIsWifiNetwork);
        if (!PowerEngine.getInstance(application).isCharging() || isJustBoot(j4) || !NetworkHelper.isConnectionAvailable(ApplicationImpl.getApplication()) || !Utils.isPermissionAllowed(application) || this.mShuttingDown || j4 - this.mLastScreenOffCheckTime <= 1800000) {
            return;
        }
        if ((!zIsWifiNetwork || j4 - this.mWifiUpdateTime <= UPDATE_DURATION) && j4 - this.mLastUpdateTime <= UPDATE_DURATION) {
            return;
        }
        this.mLastScreenOffCheckTime = j4;
        update(zIsWifiNetwork ? 1 : 0);
    }

    public void tryUpdateEx(long j4) {
        ApplicationImpl application = ApplicationImpl.getApplication();
        boolean zIsWifiNetwork = NetworkHelper.isWifiNetwork(application);
        AlphaMeLogger.iLog("RuleUpdater tryUpdateEx isWifi = " + zIsWifiNetwork);
        if (isJustBoot(j4) || !NetworkHelper.isConnectionAvailable(ApplicationImpl.getApplication()) || !Utils.isPermissionAllowed(application) || this.mShuttingDown || j4 - this.mLastUpdateTimeEx <= 10800000) {
            return;
        }
        updateEx(zIsWifiNetwork ? 1 : 0);
    }

    public void update(int i4) {
        ExecutorService executorService;
        if (UserInfoProxy.isGuest()) {
            AlphaMeLogger.dLog("RuleUpdater update canceled, isGuest");
            return;
        }
        if (this.mUpdateThread == null) {
            this.mUpdateThread = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("update"));
        }
        Future<?> futureSubmit = this.mUpdateThread.submit(new UpdaterRunnable(i4));
        try {
            try {
                futureSubmit.get(NORMAL_DOWNLOAD_TIMEOUT, TimeUnit.MILLISECONDS);
                executorService = this.mUpdateThread;
            } catch (Exception e4) {
                futureSubmit.cancel(true);
                AlphaMeLogger.exceptionLog("RuleUpdater update error", e4);
                executorService = this.mUpdateThread;
                if (executorService != null) {
                }
            }
            if (executorService != null) {
                executorService.shutdownNow();
                this.mUpdateThread = null;
            }
        } catch (Throwable th) {
            ExecutorService executorService2 = this.mUpdateThread;
            if (executorService2 != null) {
                executorService2.shutdownNow();
                this.mUpdateThread = null;
            }
            throw th;
        }
    }

    public synchronized void updateEx(int i4) {
        ExecutorService executorService;
        try {
            if (UserInfoProxy.isGuest()) {
                AlphaMeLogger.dLog("RuleUpdaterEx update canceled, isGuest");
            } else {
                if (this.mUpdateThreadEx == null) {
                    this.mUpdateThreadEx = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("update"));
                }
                Future<?> futureSubmit = this.mUpdateThreadEx.submit(new UpdaterRunnableEx(i4));
                try {
                    try {
                        futureSubmit.get(1800000L, TimeUnit.MILLISECONDS);
                        executorService = this.mUpdateThreadEx;
                    } catch (Throwable th) {
                        ExecutorService executorService2 = this.mUpdateThreadEx;
                        if (executorService2 != null) {
                            executorService2.shutdownNow();
                            this.mUpdateThreadEx = null;
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    futureSubmit.cancel(true);
                    AlphaMeLogger.exceptionLog("RuleUpdaterEx update error", e4);
                    ExecutorService executorService3 = this.mUpdateThreadEx;
                    if (executorService3 != null) {
                        executorService3.shutdownNow();
                    }
                }
                if (executorService != null) {
                    executorService.shutdownNow();
                    this.mUpdateThreadEx = null;
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
