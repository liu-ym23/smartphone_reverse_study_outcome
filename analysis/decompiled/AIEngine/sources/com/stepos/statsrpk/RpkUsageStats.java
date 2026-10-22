package com.stepos.statsrpk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import com.stepos.statsrpk.c;
import com.stepos.statsrpk.c.a;
import com.stepos.statsrpk.f;
import com.stepos.statsrpk.f.a;
import com.stepos.statsrpk.service.RpkUsageStatsService;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class RpkUsageStats {
    private static String TAG = "RpkUsageStats";
    private static RpkUsageStats sInstance;
    private static final Object sLock = new Object();
    private Context mContext;
    private RpkInfo mRpkInfo;
    private e mRpkInstance;
    private sa.a sharedPreferencesHelper;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8055a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f8056b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f8057c;

        public a(String str, String str2, Map map) {
            this.f8055a = str;
            this.f8056b = str2;
            this.f8057c = map;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RpkUsageStats rpkUsageStats = RpkUsageStats.this;
            if (rpkUsageStats.mRpkInstance != null) {
                e eVar = rpkUsageStats.mRpkInstance;
                eVar.getClass();
                StringBuilder sb2 = new StringBuilder("onEvent eventName: ");
                String str = this.f8055a;
                sb2.append(str);
                sb2.append(", pageName: ");
                String str2 = this.f8056b;
                sb2.append(str2);
                sb2.append(", properties: ");
                Map map = this.f8057c;
                sb2.append(map);
                ta.c.a("RpkInstanceImpl", sb2.toString());
                g gVar = eVar.f8076b;
                if (gVar == null || TextUtils.isEmpty(str) || !((sa.a) gVar.f8089c).f11898a.getBoolean(ModelFlowMeta.KEY_ACTIVE, true) || gVar.u(str) == 0) {
                    return;
                }
                RpkEvent rpkEvent = new RpkEvent();
                rpkEvent.f8045a = "action_x";
                rpkEvent.f8046b = str;
                rpkEvent.f8047c = str2;
                rpkEvent.f8048d = map;
                rpkEvent.f8049e = ((e) gVar.f8090d).f8077c.a();
                ((com.stepos.statsrpk.c) gVar.f8087a).a(rpkEvent, (RpkInfo) gVar.f8088b);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8059a;

        public b(String str) {
            this.f8059a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (RpkUsageStats.this.mRpkInstance != null) {
                e eVar = RpkUsageStats.this.mRpkInstance;
                String str = this.f8059a;
                eVar.getClass();
                ta.c.a("RpkInstanceImpl", "onPageStart pageName: " + str);
                f fVar = eVar.f8077c;
                if (fVar == null) {
                    return;
                }
                synchronized (fVar) {
                    ta.c.a("RpkPageController", "startPage: " + str);
                    new Handler(Looper.getMainLooper()).removeCallbacks(fVar.f8082d);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    f.b bVar = new f.b();
                    bVar.f8084a = str;
                    bVar.f8085b = jCurrentTimeMillis;
                    bVar.f8086c = jElapsedRealtime;
                    fVar.f8079a.addFirst(bVar);
                    int size = fVar.f8079a.size() - 100;
                    if (size > 0) {
                        ta.c.a("RpkPageController", "ON_PAGE_STOP, too many pages in stack, delete pages " + size);
                        for (int i10 = 0; i10 < size; i10++) {
                            fVar.f8079a.removeLast();
                        }
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8061a;

        public c(String str) {
            this.f8061a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (RpkUsageStats.this.mRpkInstance != null) {
                e eVar = RpkUsageStats.this.mRpkInstance;
                String str = this.f8061a;
                eVar.getClass();
                ta.c.a("RpkInstanceImpl", "onPageStop pageName: " + str);
                f fVar = eVar.f8077c;
                if (fVar == null) {
                    return;
                }
                synchronized (fVar) {
                    try {
                        ta.c.a("RpkPageController", "stopPage: " + str);
                        Iterator<f.b> it = fVar.f8079a.iterator();
                        while (it.hasNext()) {
                            System.currentTimeMillis();
                            long jElapsedRealtime = SystemClock.elapsedRealtime();
                            f.b next = it.next();
                            if (Math.abs(jElapsedRealtime - next.f8086c) > 43200000) {
                                it.remove();
                                ta.c.a("RpkPageController", "remove invalid page who's duration > 12 hours:" + next);
                            }
                        }
                        Iterator<f.b> it2 = fVar.f8079a.iterator();
                        boolean z = false;
                        while (it2.hasNext()) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                            f.b next2 = it2.next();
                            if (str.equals(next2.f8084a)) {
                                if (z) {
                                    ta.c.a("RpkPageController", "found repeated page: " + next2);
                                } else {
                                    fVar.f8080b.f8076b.v(str, next2.f8085b, jCurrentTimeMillis, jElapsedRealtime2 - next2.f8086c);
                                    ta.c.a("RpkPageController", "create a page event: " + next2);
                                    z = true;
                                }
                                it2.remove();
                            }
                        }
                        if (fVar.f8079a.size() <= 0) {
                            new Handler(Looper.getMainLooper()).postDelayed(fVar.f8082d, AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8063a;

        public d(String str) {
            this.f8063a = str;
        }

        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            String responseBody;
            RpkUsageStats rpkUsageStats = RpkUsageStats.this;
            rpkUsageStats.sharedPreferencesHelper = new sa.a(rpkUsageStats.mContext, "statsrpk_config_" + this.f8063a);
            RpkUsageStats.this.mRpkInfo.f8054e = RpkUsageStats.this.sharedPreferencesHelper.f11898a.getString("appKey", "");
            RpkUsageStats.this.mRpkInfo.f8053d = RpkUsageStats.this.sharedPreferencesHelper.f11898a.getString("apkPkgName", "");
            if (TextUtils.isEmpty(RpkUsageStats.this.mRpkInfo.f8054e) || TextUtils.isEmpty(RpkUsageStats.this.mRpkInfo.f8053d)) {
                String string = Uri.parse(b1.f1790m + RpkUsageStats.this.mRpkInfo.f8050a).buildUpon().toString();
                ta.c.a(RpkUsageStats.TAG, "RpkUsageStats try cdn url: " + string);
                NetResponse netResponseA = null;
                try {
                    netResponseA = ia.b.b(RpkUsageStats.this.mContext).a(string, null);
                } catch (IOException e10) {
                    ta.c.b(RpkUsageStats.TAG, e10.getMessage());
                } catch (RuntimeException e11) {
                    ta.c.b(RpkUsageStats.TAG, e11.getMessage());
                }
                ta.c.a(RpkUsageStats.TAG, "RpkUsageStats getConfigFromServer response: " + netResponseA);
                if (netResponseA != null && netResponseA.getResponseCode() == 200 && (responseBody = netResponseA.getResponseBody()) != null) {
                    ta.c.a(RpkUsageStats.TAG, "RpkUsageStats successfully posted to " + string);
                    try {
                        h.a(RpkUsageStats.this.mContext, responseBody, RpkUsageStats.this.mRpkInfo);
                        h.b(RpkUsageStats.this.mContext, responseBody, RpkUsageStats.this.mRpkInfo);
                    } catch (JSONException e12) {
                        ta.c.b(RpkUsageStats.TAG, e12.getMessage());
                    }
                }
            }
            if (TextUtils.isEmpty(RpkUsageStats.this.mRpkInfo.f8054e) || TextUtils.isEmpty(RpkUsageStats.this.mRpkInfo.f8053d)) {
                ta.c.a(RpkUsageStats.TAG, "rpkInfo.appKey or rpkInfo.apkPkgName is empty，unable to initialize.");
                return;
            }
            RpkUsageStats rpkUsageStats2 = RpkUsageStats.this;
            Context context = rpkUsageStats2.mContext;
            RpkInfo rpkInfo = RpkUsageStats.this.mRpkInfo;
            e eVar = new e();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (context == null) {
                throw new IllegalArgumentException("The applicationContext is null!");
            }
            Context applicationContext = context.getApplicationContext();
            eVar.f8075a = rpkInfo;
            com.stepos.statsrpk.b bVar = new com.stepos.statsrpk.b();
            bVar.f8067a = applicationContext;
            bVar.f8068b = rpkInfo;
            bVar.f8070d = new sa.a(applicationContext, "statsrpk_config_" + rpkInfo.f8050a);
            HandlerThread handlerThread = new HandlerThread("rpk.ConfigControllerWorker", 5);
            handlerThread.start();
            bVar.f8069c = new com.stepos.statsrpk.a(bVar, handlerThread.getLooper(), 0);
            eVar.f8078d = bVar;
            ta.c.a("RpkInstanceImpl", "##### RpkInstanceImpl 1, " + (System.currentTimeMillis() - jCurrentTimeMillis));
            ta.c.a("RpkInstanceImpl", "##### RpkInstanceImpl 2, " + (System.currentTimeMillis() - jCurrentTimeMillis));
            ta.c.a("RpkInstanceImpl", "##### RpkInstanceImpl 3, " + (System.currentTimeMillis() - jCurrentTimeMillis));
            com.stepos.statsrpk.c cVar = new com.stepos.statsrpk.c();
            cVar.f8071a = applicationContext;
            Intent intent = new Intent(applicationContext, (Class<?>) RpkUsageStatsService.class);
            c.a aVar = cVar.new a();
            boolean zBindService = applicationContext.bindService(intent, aVar, 1);
            ta.c.a("RpkEmitter", "bindService, " + aVar + " result: " + zBindService);
            if (zBindService) {
                synchronized (aVar) {
                    try {
                        aVar.wait();
                    } catch (InterruptedException e13) {
                        ta.c.f("RpkEmitter", "Exception:" + e13.toString() + " -Cause:" + e13.getCause());
                    }
                }
            }
            RpkInfo rpkInfo2 = eVar.f8075a;
            g gVar = new g();
            gVar.f8087a = cVar;
            gVar.f8088b = rpkInfo2;
            gVar.f8089c = new sa.a(applicationContext, "statsrpk_config_" + rpkInfo2.f8050a);
            ta.c.e("RpkTracker", "RpkTracker created successfully.");
            eVar.f8076b = gVar;
            ta.c.a("RpkInstanceImpl", "##### RpkInstanceImpl 4, " + (System.currentTimeMillis() - jCurrentTimeMillis));
            f fVar = new f();
            fVar.f8079a = new LinkedList<>();
            fVar.f8082d = fVar.new a();
            eVar.f8077c = fVar;
            ta.c.a("RpkInstanceImpl", "##### RpkInstanceImpl 5, " + (System.currentTimeMillis() - jCurrentTimeMillis));
            com.stepos.statsrpk.a aVar2 = eVar.f8078d.f8069c;
            if (aVar2.hasMessages(1)) {
                aVar2.removeMessages(1);
            }
            aVar2.sendEmptyMessageDelayed(1, 1000);
            fVar.f8080b = eVar;
            gVar.f8090d = eVar;
            ta.c.a("RpkInstanceImpl", "##### RpkInstanceImpl 6, " + (System.currentTimeMillis() - jCurrentTimeMillis));
            rpkUsageStats2.mRpkInstance = eVar;
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
        rpkInfo.f8050a = str;
        rpkInfo.f8051b = str2;
        rpkInfo.f8052c = i10;
        b1.f1791n = "6KAIUyh8oTuWsB0JiE9";
        b1.f1787j = "http://uxip.zyql.com/api/v3/event/";
        b1.f1788k = "http://uxip-config.zyql.com/api/v3/umid/privacy";
        b1.f1789l = "http://uxip-res.zyql.com/resource/v3/config/";
        b1.f1790m = "http://uxip-res.zyql.com/resource/v3/config/rpk/";
        findRelativeApp(str);
        ta.c.a(TAG, "##### RpkUsageStats init complete, " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    private void findRelativeApp(String str) {
        ta.c.a(TAG, "##### RpkUsageStats findRelativeApp: " + str);
        com.stepos.statsrpk.d.a(new d(str));
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
        ta.c.a(TAG, "##### RpkUsageStats onEvent: " + str);
        com.stepos.statsrpk.d.a(new a(str, str2, map));
    }

    public void onPageHide(String str) {
        ta.c.a(TAG, "##### RpkUsageStats onPageHide: " + str);
        com.stepos.statsrpk.d.a(new c(str));
    }

    public void onPageShow(String str) {
        ta.c.a(TAG, "##### RpkUsageStats onPageShow: " + str);
        com.stepos.statsrpk.d.a(new b(str));
    }
}
