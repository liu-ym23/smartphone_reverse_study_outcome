package com.stepos.statsrpk;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import f0.HandlerC0555a;
import h.RunnableC0583a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import t0.J;

/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12354a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f12355b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RpkUsageStats f12356c;

    public /* synthetic */ a(RpkUsageStats rpkUsageStats, String str, int i4) {
        this.f12354a = i4;
        this.f12356c = rpkUsageStats;
        this.f12355b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        int i4 = 0;
        switch (this.f12354a) {
            case 0:
                if (this.f12356c.mRpkInstance != null) {
                    d dVar = this.f12356c.mRpkInstance;
                    String str2 = this.f12355b;
                    dVar.getClass();
                    T2.d.a("RpkInstanceImpl", "onPageStart pageName: " + str2);
                    f fVar = dVar.f12366b;
                    if (fVar == null) {
                        return;
                    }
                    synchronized (fVar) {
                        T2.d.a("RpkPageController", "startPage: " + str2);
                        new Handler(Looper.getMainLooper()).removeCallbacks(fVar.f12373d);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        e eVar = new e();
                        eVar.f12367a = str2;
                        eVar.f12368b = jCurrentTimeMillis;
                        eVar.f12369c = jElapsedRealtime;
                        fVar.f12370a.addFirst(eVar);
                        int size = fVar.f12370a.size() - 100;
                        if (size > 0) {
                            T2.d.a("RpkPageController", "ON_PAGE_STOP, too many pages in stack, delete pages " + size);
                            while (i4 < size) {
                                fVar.f12370a.removeLast();
                                i4++;
                            }
                        }
                    }
                    return;
                }
                return;
            case 1:
                if (this.f12356c.mRpkInstance != null) {
                    d dVar2 = this.f12356c.mRpkInstance;
                    String str3 = this.f12355b;
                    dVar2.getClass();
                    T2.d.a("RpkInstanceImpl", "onPageStop pageName: " + str3);
                    f fVar2 = dVar2.f12366b;
                    if (fVar2 == null) {
                        return;
                    }
                    synchronized (fVar2) {
                        try {
                            T2.d.a("RpkPageController", "stopPage: " + str3);
                            Iterator it = fVar2.f12370a.iterator();
                            while (it.hasNext()) {
                                System.currentTimeMillis();
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                e eVar2 = (e) it.next();
                                if (Math.abs(jElapsedRealtime2 - eVar2.f12369c) > 43200000) {
                                    it.remove();
                                    T2.d.a("RpkPageController", "remove invalid page who's duration > 12 hours:" + eVar2);
                                }
                            }
                            Iterator it2 = fVar2.f12370a.iterator();
                            while (it2.hasNext()) {
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                                e eVar3 = (e) it2.next();
                                if (str3.equals(eVar3.f12367a)) {
                                    if (i4 == 0) {
                                        fVar2.f12371b.f12365a.b(str3, eVar3.f12368b, jCurrentTimeMillis2, jElapsedRealtime3 - eVar3.f12369c);
                                        T2.d.a("RpkPageController", "create a page event: " + eVar3);
                                        i4 = 1;
                                    } else {
                                        T2.d.a("RpkPageController", "found repeated page: " + eVar3);
                                    }
                                    it2.remove();
                                }
                            }
                            if (fVar2.f12370a.size() <= 0) {
                                new Handler(Looper.getMainLooper()).postDelayed(fVar2.f12373d, 30000L);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
                }
                return;
            default:
                RpkUsageStats rpkUsageStats = this.f12356c;
                rpkUsageStats.sharedPreferencesHelper = new S2.a(rpkUsageStats.mContext, "statsrpk_config_" + this.f12355b);
                rpkUsageStats.mRpkInfo.f12353e = rpkUsageStats.sharedPreferencesHelper.f1791a.getString("appKey", "");
                rpkUsageStats.mRpkInfo.f12352d = rpkUsageStats.sharedPreferencesHelper.f1791a.getString("apkPkgName", "");
                if (TextUtils.isEmpty(rpkUsageStats.mRpkInfo.f12353e) || TextUtils.isEmpty(rpkUsageStats.mRpkInfo.f12352d)) {
                    String string = Uri.parse(c.f12362e + rpkUsageStats.mRpkInfo.f12349a).buildUpon().toString();
                    T2.d.a(RpkUsageStats.TAG, "RpkUsageStats try cdn url: " + string);
                    NetResponse netResponseB = null;
                    try {
                        netResponseB = I2.b.a(rpkUsageStats.mContext).b(string, null);
                    } catch (IOException e4) {
                        T2.d.b(RpkUsageStats.TAG, e4.getMessage());
                    } catch (RuntimeException e5) {
                        T2.d.b(RpkUsageStats.TAG, e5.getMessage());
                    }
                    T2.d.a(RpkUsageStats.TAG, "RpkUsageStats getConfigFromServer response: " + netResponseB);
                    if (netResponseB != null && netResponseB.f12341a == 200 && (str = netResponseB.f12342b) != null) {
                        T2.d.a(RpkUsageStats.TAG, "RpkUsageStats successfully posted to " + string);
                        try {
                            J.b(rpkUsageStats.mContext, str, rpkUsageStats.mRpkInfo);
                            J.e(rpkUsageStats.mContext, str, rpkUsageStats.mRpkInfo);
                        } catch (JSONException e6) {
                            T2.d.b(RpkUsageStats.TAG, e6.getMessage());
                        }
                    }
                }
                if (TextUtils.isEmpty(rpkUsageStats.mRpkInfo.f12353e) || TextUtils.isEmpty(rpkUsageStats.mRpkInfo.f12352d)) {
                    T2.d.a(RpkUsageStats.TAG, "rpkInfo.appKey or rpkInfo.apkPkgName is empty，unable to initialize.");
                    return;
                }
                Context context = rpkUsageStats.mContext;
                RpkInfo rpkInfo = rpkUsageStats.mRpkInfo;
                d dVar3 = new d();
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                if (context == null) {
                    throw new IllegalArgumentException("The applicationContext is null!");
                }
                Context applicationContext = context.getApplicationContext();
                P2.b bVar = new P2.b();
                bVar.f1577b = 1;
                bVar.f1576a = applicationContext;
                bVar.f1578c = rpkInfo;
                bVar.f1580e = new S2.a(applicationContext, "statsrpk_config_" + rpkInfo.f12349a);
                HandlerThread handlerThread = new HandlerThread("rpk.ConfigControllerWorker", 5);
                handlerThread.start();
                bVar.f1579d = new HandlerC0555a(bVar, handlerThread.getLooper(), 5);
                T2.d.a("RpkInstanceImpl", "##### RpkInstanceImpl 1, " + (System.currentTimeMillis() - jCurrentTimeMillis3));
                T2.d.a("RpkInstanceImpl", "##### RpkInstanceImpl 2, " + (System.currentTimeMillis() - jCurrentTimeMillis3));
                T2.d.a("RpkInstanceImpl", "##### RpkInstanceImpl 3, " + (System.currentTimeMillis() - jCurrentTimeMillis3));
                android.support.v4.media.session.c cVar = new android.support.v4.media.session.c(applicationContext, rpkInfo);
                t.d dVar4 = new t.d();
                dVar4.f15273a = cVar;
                dVar4.f15274b = rpkInfo;
                dVar4.f15275c = new S2.a(applicationContext, "statsrpk_config_" + rpkInfo.f12349a);
                T2.d.e("RpkTracker", "RpkTracker created successfully.");
                dVar3.f12365a = dVar4;
                T2.d.a("RpkInstanceImpl", "##### RpkInstanceImpl 4, " + (System.currentTimeMillis() - jCurrentTimeMillis3));
                f fVar3 = new f();
                fVar3.f12370a = new LinkedList();
                fVar3.f12373d = new RunnableC0583a(25, fVar3);
                dVar3.f12366b = fVar3;
                T2.d.a("RpkInstanceImpl", "##### RpkInstanceImpl 5, " + (System.currentTimeMillis() - jCurrentTimeMillis3));
                if (((Handler) bVar.f1579d).hasMessages(1)) {
                    ((Handler) bVar.f1579d).removeMessages(1);
                }
                ((Handler) bVar.f1579d).sendEmptyMessageDelayed(1, 1000);
                fVar3.f12371b = dVar3;
                dVar4.f15276d = dVar3;
                T2.d.a("RpkInstanceImpl", "##### RpkInstanceImpl 6, " + (System.currentTimeMillis() - jCurrentTimeMillis3));
                rpkUsageStats.mRpkInstance = dVar3;
                return;
        }
    }
}
