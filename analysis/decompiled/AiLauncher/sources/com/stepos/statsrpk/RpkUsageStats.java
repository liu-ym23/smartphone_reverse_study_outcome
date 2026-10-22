package com.stepos.statsrpk;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import com.stepos.statsapp.v3.utils.SharedPreferencesHelper;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class RpkUsageStats {
    private static String TAG = "RpkUsageStats";
    private static RpkUsageStats sInstance;
    private static final Object sLock = new Object();
    private Context mContext;
    private RpkInfo mRpkInfo;
    private com.stepos.statsrpk.d mRpkInstance;
    private SharedPreferencesHelper sharedPreferencesHelper;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f31016a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f31017b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f31018c;

        public a(String str, String str2, Map map) {
            this.f31016a = str;
            this.f31017b = str2;
            this.f31018c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RpkUsageStats.this.mRpkInstance != null) {
                RpkUsageStats.this.mRpkInstance.e(this.f31016a, this.f31017b, this.f31018c);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f31020a;

        public b(String str) {
            this.f31020a = str;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            if (RpkUsageStats.this.mRpkInstance != null) {
                RpkUsageStats.this.mRpkInstance.d(this.f31020a);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f31022a;

        public c(String str) {
            this.f31022a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RpkUsageStats.this.mRpkInstance != null) {
                RpkUsageStats.this.mRpkInstance.g(this.f31022a);
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f31024a;

        public d(String str) {
            this.f31024a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String responseBody;
            RpkUsageStats rpkUsageStats = RpkUsageStats.this;
            rpkUsageStats.sharedPreferencesHelper = new SharedPreferencesHelper(rpkUsageStats.mContext, "statsrpk_config_" + this.f31024a);
            RpkUsageStats.this.mRpkInfo.f31015e = RpkUsageStats.this.sharedPreferencesHelper.getConfig("appKey", "");
            RpkUsageStats.this.mRpkInfo.f31014d = RpkUsageStats.this.sharedPreferencesHelper.getConfig("apkPkgName", "");
            if (TextUtils.isEmpty(RpkUsageStats.this.mRpkInfo.f31015e) || TextUtils.isEmpty(RpkUsageStats.this.mRpkInfo.f31014d)) {
                String string = Uri.parse(UxipConstants.f30678q + RpkUsageStats.this.mRpkInfo.f31011a).buildUpon().toString();
                Logger.d(RpkUsageStats.TAG, "RpkUsageStats try cdn url: " + string);
                NetResponse netResponseA = null;
                try {
                    netResponseA = com.stepos.statsapp.v3.lib.plugin.net.a.a(RpkUsageStats.this.mContext).a(string, null);
                } catch (IOException e10) {
                    Logger.e(RpkUsageStats.TAG, e10.getMessage());
                } catch (RuntimeException e11) {
                    Logger.e(RpkUsageStats.TAG, e11.getMessage());
                }
                Logger.d(RpkUsageStats.TAG, "RpkUsageStats getConfigFromServer response: " + netResponseA);
                if (netResponseA != null && netResponseA.getResponseCode() == 200 && (responseBody = netResponseA.getResponseBody()) != null) {
                    Logger.d(RpkUsageStats.TAG, "RpkUsageStats successfully posted to " + string);
                    try {
                        g.a(RpkUsageStats.this.mContext, responseBody, RpkUsageStats.this.mRpkInfo);
                        g.b(RpkUsageStats.this.mContext, responseBody, RpkUsageStats.this.mRpkInfo);
                    } catch (JSONException e12) {
                        Logger.e(RpkUsageStats.TAG, e12.getMessage());
                    }
                }
            }
            if (TextUtils.isEmpty(RpkUsageStats.this.mRpkInfo.f31015e) || TextUtils.isEmpty(RpkUsageStats.this.mRpkInfo.f31014d)) {
                Logger.d(RpkUsageStats.TAG, "rpkInfo.appKey or rpkInfo.apkPkgName is empty，unable to initialize.");
            } else {
                RpkUsageStats rpkUsageStats2 = RpkUsageStats.this;
                rpkUsageStats2.mRpkInstance = new com.stepos.statsrpk.d(rpkUsageStats2.mContext, RpkUsageStats.this.mRpkInfo);
            }
        }
    }

    private RpkUsageStats(Context context, String str, String str2, int i10) {
        if (context == null) {
            throw new IllegalArgumentException("The context is null!");
        }
        this.mContext = context.getApplicationContext();
        long jCurrentTimeMillis = System.currentTimeMillis();
        RpkInfo rpkInfo = new RpkInfo();
        this.mRpkInfo = rpkInfo;
        rpkInfo.f31011a = str;
        rpkInfo.f31012b = str2;
        rpkInfo.f31013c = i10;
        UxipConstants.a();
        findRelativeApp(str);
        Logger.d(TAG, "##### RpkUsageStats init complete, " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    private void findRelativeApp(String str) {
        Logger.d(TAG, "##### RpkUsageStats findRelativeApp: " + str);
        com.stepos.statsrpk.c.d(new d(str));
    }

    public static RpkUsageStats getInstance() {
        return sInstance;
    }

    public static void init(Context context, String str, String str2, int i10) {
        if (sInstance == null) {
            synchronized (sLock) {
                try {
                    if (sInstance == null) {
                        sInstance = new RpkUsageStats(context, str, str2, i10);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void onEvent(String str, String str2, Map<String, String> map) {
        Logger.d(TAG, "##### RpkUsageStats onEvent: " + str);
        com.stepos.statsrpk.c.d(new a(str, str2, map));
    }

    public void onPageHide(String str) {
        Logger.d(TAG, "##### RpkUsageStats onPageHide: " + str);
        com.stepos.statsrpk.c.d(new c(str));
    }

    public void onPageShow(String str) {
        Logger.d(TAG, "##### RpkUsageStats onPageShow: " + str);
        com.stepos.statsrpk.c.d(new b(str));
    }
}
