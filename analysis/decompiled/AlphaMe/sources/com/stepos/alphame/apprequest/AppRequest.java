package com.stepos.alphame.apprequest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import com.stepos.alphame.utils.SystemProperty;
import h3.C0611u;
import h3.M;
import h3.S;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class AppRequest {
    public static final String ACTION_FILE_SAVED_SUCCESS = "com.stepos.alphame.ACTION_FILE_SAVED_SUCCESS";
    private static final String BASE_URL = "https://picker.zyql.com/android/unauth/atomic/meituan/info";
    private static final String DIRECTORY_PATH = "/data/misc/scene_config";
    private static final String FILE_PATH = "/data/misc/scene_config/stepos-scene-recognition-config.json";
    private static final String HMAC_SHA256 = "HmacSHA256";
    public static final M JSON;
    public static final long MAX_DELAY_MS = 600000;
    private static final String PROP_KEY_DEVICE_IDENTIFY = "ro.stepos.version.id";
    private static final String TAG = "AlphamePushMsgReceiver";

    @SuppressLint({"StaticFieldLeak"})
    private static AppRequest sInstance;
    private final S client = new S();
    private final ExecutorService mNetworkExecutor = Executors.newCachedThreadPool();

    static {
        Pattern pattern = M.f12732d;
        JSON = C0611u.o("application/json; charset=utf-8");
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public static synchronized AppRequest getInstance(Context context) {
        try {
            if (sInstance == null) {
                sInstance = new AppRequest();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    public static String getProperty(String str, String str2) {
        try {
            String str3 = SystemProperty.get(str, str2);
            return str3 != null ? str3 : str2;
        } catch (Exception e4) {
            e4.printStackTrace();
            return str2;
        }
    }

    private void sendBroadcast() {
        Log.d(TAG, "sendBroadcast com.stepos.alphame.ACTION_FILE_SAVED_SUCCESS");
        Intent intent = new Intent(ACTION_FILE_SAVED_SUCCESS);
        intent.addFlags(32);
        ApplicationImpl.getApplication().sendBroadcast(intent);
    }

    public void executeStaggeredRequest(final Executor executor, final Runnable runnable, long j4) {
        Handler handler = new Handler(Looper.getMainLooper());
        long jNextDouble = (long) (new Random().nextDouble() * j4);
        Log.d(TAG, "将在10分钟内随机发起http错峰请求");
        handler.postDelayed(new Runnable() { // from class: com.stepos.alphame.apprequest.AppRequest.2
            @Override // java.lang.Runnable
            public void run() {
                executor.execute(runnable);
            }
        }, jNextDouble);
    }

    public void fetchAtomicInfo(Context context) {
        Log.d(TAG, "fetchAtomicInfo disabled");
    }

    public void fetchMeiTuanConfig() {
        executeStaggeredRequest(this.mNetworkExecutor, new Runnable() { // from class: com.stepos.alphame.apprequest.AppRequest.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppRequest.this.fetchAtomicInfo(ApplicationImpl.getApplication().getBaseContext());
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }, 600000L);
    }

    public boolean writeSystemConfigFile(String str) {
        if (str == null) {
            return false;
        }
        try {
            return PerfBinderHelper.writeSceneConfigFile(str, FILE_PATH);
        } catch (Exception e4) {
            Log.e("SystemConfigWriter", "Failed to write system config file via AppPlatform.", e4);
            return false;
        }
    }
}
