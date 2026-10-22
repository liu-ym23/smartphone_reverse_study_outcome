package com.stepos.alphame.utils;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import java.io.Closeable;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class Utils {
    public static final boolean DEBUG_ACTIVITY_CLICK = false;
    public static final String DEBUG_FOR_ACTIVITY = "alphame_debug_for_activityclick";
    public static final int MS_ONE_DAY = 86400000;
    private static PowerManager sPowerManager;
    private final Handler mHandler;
    private final UserLicenseObserver mLicenseObserver;
    private boolean sIsUserLicenseAllowed = false;
    public static final AtomicBoolean DEBUG = new AtomicBoolean(false);
    private static ArrayList<String> CHINA_MOBILE_PERM_WHITE_LIST = null;
    private static boolean sIsPermissionAllowed = false;
    private static Boolean mIsShopVersion = null;
    public static boolean sCollectAuthority = false;

    public static class ClickUtils {
        public static int getDayOffset(long j4, long j5) {
            return ((int) (j4 / 86400000)) - ((int) (j5 / 86400000));
        }

        public static int getTotalClicks(String[] strArr) {
            if (strArr == null || strArr.length == 0) {
                return 0;
            }
            int i4 = 0;
            for (String str : strArr) {
                i4 += Integer.parseInt(str);
            }
            return i4;
        }

        public static String joinText(String[] strArr) {
            if (strArr == null || strArr.length == 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder(strArr.length * 5);
            for (String str : strArr) {
                sb.append(str);
                sb.append(',');
            }
            return sb.toString();
        }

        public static String[] splitText(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str.split(",");
        }
    }

    public static class Instance {
        private static Utils INSTANCE = new Utils();

        private Instance() {
        }
    }

    public class UserLicenseObserver extends ContentObserver {
        public UserLicenseObserver(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z4, Uri uri) {
            super.onChange(z4, uri);
            try {
                Log.w("AlphaMe", "wzd> observe setup_wizard " + uri);
                if (Settings.Global.getUriFor("device_provisioning_mobile_data").equals(uri)) {
                    boolean zIsUserLicenseAllowed = Utils.this.isUserLicenseAllowed(ApplicationImpl.getApplication());
                    Log.w("AlphaMe", "wzd> observe setup_wizard, hasAllowLicense:" + zIsUserLicenseAllowed);
                    if (zIsUserLicenseAllowed) {
                        ApplicationImpl.getApplication().initSensitiveJob();
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public Utils() {
        Handler handler = new Handler();
        this.mHandler = handler;
        this.mLicenseObserver = new UserLicenseObserver(handler);
    }

    public static void assertTrue(boolean z4) {
        if (!z4) {
            throw new AssertionError();
        }
    }

    public static void closeSilently(Closeable closeable) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e4) {
            Log.w("AlphaMe", "failed to close", e4);
        }
    }

    public static void collectAuthority() {
        sCollectAuthority = !sCollectAuthority;
    }

    public static int currentDay() {
        return (int) (System.currentTimeMillis() / 86400000);
    }

    public static synchronized ArrayList<String> getChinaMobilePermWhiteList() {
        try {
            if (BuildExt.isCustomizeChinaMobile() && CHINA_MOBILE_PERM_WHITE_LIST == null) {
                ArrayList<String> arrayList = new ArrayList<>(1);
                CHINA_MOBILE_PERM_WHITE_LIST = arrayList;
                arrayList.add("com.greenpoint.android.mc10086.activity");
            }
        } catch (Throwable th) {
            throw th;
        }
        return CHINA_MOBILE_PERM_WHITE_LIST;
    }

    public static Utils getInstance() {
        return Instance.INSTANCE;
    }

    public static boolean isCollectAuthority() {
        return sCollectAuthority;
    }

    public static boolean isInMdm() {
        return "cell1".equals(SystemProperty.get("persist.sys.vm.name", "cell0"));
    }

    public static boolean isPermissionAllowed(Context context) {
        if (!sIsPermissionAllowed) {
            sIsPermissionAllowed = Settings.Global.getInt(context.getContentResolver(), "device_provisioned", 0) != 0;
        }
        AlphaMeLogger.dLog("isPermissionAllowed = " + sIsPermissionAllowed);
        return sIsPermissionAllowed;
    }

    public static boolean isS2020() {
        String str = SystemProperty.get("ro.stepos.mdm.version", null);
        return str != null && str.length() > 0;
    }

    public static boolean isScreenOn() {
        if (sPowerManager == null) {
            sPowerManager = (PowerManager) ApplicationImpl.getApplication().getSystemService("power");
        }
        return sPowerManager.isInteractive();
    }

    private static boolean isShopVersion() {
        try {
            if (mIsShopVersion == null) {
                mIsShopVersion = Boolean.valueOf(PerfBinderHelper.getBuildExtBoolean("IS_SHOPDEMO", false));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        Boolean bool = mIsShopVersion;
        return bool != null && bool.booleanValue();
    }

    public static String printDay(long j4) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(j4));
    }

    public boolean isUserLicenseAllowed(Context context) {
        if (isShopVersion()) {
            Log.w("AlphaMe", "wzd> shop version");
            return true;
        }
        if (!this.sIsUserLicenseAllowed) {
            this.sIsUserLicenseAllowed = Settings.Global.getInt(context.getContentResolver(), "device_provisioning_mobile_data", -1) == 1;
        }
        Log.w("AlphaMe", "wzd> sIsUserLicenseAllowed " + this.sIsUserLicenseAllowed);
        return this.sIsUserLicenseAllowed;
    }

    public boolean registerUserLicenseObserver(Context context) {
        context.getContentResolver().registerContentObserver(Settings.Global.getUriFor("device_provisioning_mobile_data"), true, this.mLicenseObserver);
        Log.w("AlphaMe", "wzd> registerUserLicenseObserver success");
        return true;
    }
}
