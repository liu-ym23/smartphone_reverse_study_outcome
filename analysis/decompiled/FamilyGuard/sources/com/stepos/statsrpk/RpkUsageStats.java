package com.stepos.statsrpk;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import f3.C0720b;
import g3.C0742e;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class RpkUsageStats {
    private static String TAG = "RpkUsageStats";
    private static RpkUsageStats sInstance;
    private static final Object sLock = new Object();
    private Context mContext;
    private com.stepos.statsrpk.b mRpkInfo;
    private f mRpkInstance;
    private C0720b sharedPreferencesHelper;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f15923a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15924b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f15925c;

        a(String str, String str2, Map map) {
            this.f15923a = str;
            this.f15924b = str2;
            this.f15925c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RpkUsageStats.this.mRpkInstance != null) {
                RpkUsageStats.this.mRpkInstance.e(this.f15923a, this.f15924b, this.f15925c);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f15927a;

        b(String str) {
            this.f15927a = str;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            if (RpkUsageStats.this.mRpkInstance != null) {
                RpkUsageStats.this.mRpkInstance.d(this.f15927a);
            }
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f15929a;

        c(String str) {
            this.f15929a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RpkUsageStats.this.mRpkInstance != null) {
                RpkUsageStats.this.mRpkInstance.g(this.f15929a);
            }
        }
    }

    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f15931a;

        d(String str) {
            this.f15931a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strA;
            RpkUsageStats rpkUsageStats = RpkUsageStats.this;
            rpkUsageStats.sharedPreferencesHelper = new C0720b(rpkUsageStats.mContext, "statsrpk_config_" + this.f15931a);
            RpkUsageStats.this.mRpkInfo.f15942e = RpkUsageStats.this.sharedPreferencesHelper.m("appKey", BuildConfig.FLAVOR);
            RpkUsageStats.this.mRpkInfo.f15941d = RpkUsageStats.this.sharedPreferencesHelper.m("apkPkgName", BuildConfig.FLAVOR);
            if (TextUtils.isEmpty(RpkUsageStats.this.mRpkInfo.f15942e) || TextUtils.isEmpty(RpkUsageStats.this.mRpkInfo.f15941d)) {
                String string = Uri.parse(S2.a.f5234d + RpkUsageStats.this.mRpkInfo.f15938a).buildUpon().toString();
                C0742e.c(RpkUsageStats.TAG, "RpkUsageStats try cdn url: " + string);
                NetResponse netResponseC = null;
                try {
                    netResponseC = V2.b.a(RpkUsageStats.this.mContext).c(string, null);
                } catch (IOException e6) {
                    C0742e.d(RpkUsageStats.TAG, e6.getMessage());
                } catch (RuntimeException e7) {
                    C0742e.d(RpkUsageStats.TAG, e7.getMessage());
                }
                C0742e.c(RpkUsageStats.TAG, "RpkUsageStats getConfigFromServer response: " + netResponseC);
                if (netResponseC != null && netResponseC.c() == 200 && (strA = netResponseC.a()) != null) {
                    C0742e.c(RpkUsageStats.TAG, "RpkUsageStats successfully posted to " + string);
                    try {
                        i.a(RpkUsageStats.this.mContext, strA, RpkUsageStats.this.mRpkInfo);
                        i.b(RpkUsageStats.this.mContext, strA, RpkUsageStats.this.mRpkInfo);
                    } catch (JSONException e8) {
                        C0742e.d(RpkUsageStats.TAG, e8.getMessage());
                    }
                }
            }
            if (TextUtils.isEmpty(RpkUsageStats.this.mRpkInfo.f15942e) || TextUtils.isEmpty(RpkUsageStats.this.mRpkInfo.f15941d)) {
                C0742e.c(RpkUsageStats.TAG, "rpkInfo.appKey or rpkInfo.apkPkgName is empty，unable to initialize.");
            } else {
                RpkUsageStats rpkUsageStats2 = RpkUsageStats.this;
                rpkUsageStats2.mRpkInstance = new f(rpkUsageStats2.mContext, RpkUsageStats.this.mRpkInfo);
            }
        }
    }

    private RpkUsageStats(Context context, String str, String str2, int i5) {
        if (context == null) {
            throw new IllegalArgumentException("The context is null!");
        }
        this.mContext = context.getApplicationContext();
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.stepos.statsrpk.b bVar = new com.stepos.statsrpk.b();
        this.mRpkInfo = bVar;
        bVar.f15938a = str;
        bVar.f15939b = str2;
        bVar.f15940c = i5;
        S2.a.a();
        findRelativeApp(str);
        C0742e.c(TAG, "##### RpkUsageStats init complete, " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    private void findRelativeApp(String str) {
        C0742e.c(TAG, "##### RpkUsageStats findRelativeApp: " + str);
        e.d(new d(str));
    }

    public static RpkUsageStats getInstance() {
        return sInstance;
    }

    public static void init(Context context, String str, String str2, int i5) {
        if (sInstance == null) {
            synchronized (sLock) {
                try {
                    if (sInstance == null) {
                        sInstance = new RpkUsageStats(context, str, str2, i5);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void onEvent(String str, String str2, Map<String, String> map) {
        C0742e.c(TAG, "##### RpkUsageStats onEvent: " + str);
        e.d(new a(str, str2, map));
    }

    public void onPageHide(String str) {
        C0742e.c(TAG, "##### RpkUsageStats onPageHide: " + str);
        e.d(new c(str));
    }

    public void onPageShow(String str) {
        C0742e.c(TAG, "##### RpkUsageStats onPageShow: " + str);
        e.d(new b(str));
    }
}
