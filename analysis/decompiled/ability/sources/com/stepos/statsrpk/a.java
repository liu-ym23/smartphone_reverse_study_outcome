package com.stepos.statsrpk;

import A6.l;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import com.stepos.statsrpk.service.RpkUsageStatsService;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import k2.C1621a;
import org.json.JSONException;

/* loaded from: classes3.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3977a;
    public final /* synthetic */ String b;
    public final /* synthetic */ RpkUsageStats c;

    public /* synthetic */ a(RpkUsageStats rpkUsageStats, String str, int i) {
        this.f3977a = i;
        this.c = rpkUsageStats;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String responseBody;
        switch (this.f3977a) {
            case 0:
                if (this.c.mRpkInstance != null) {
                    e eVar = this.c.mRpkInstance;
                    String str = this.b;
                    eVar.getClass();
                    W5.c.a("RpkInstanceImpl", "onPageStart pageName: " + str);
                    u1.d dVar = eVar.c;
                    if (dVar == null) {
                        return;
                    }
                    synchronized (dVar) {
                        W5.c.a("RpkPageController", "startPage: " + str);
                        new Handler(Looper.getMainLooper()).removeCallbacks((l) dVar.d);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        f fVar = new f();
                        fVar.f3982a = str;
                        fVar.b = jCurrentTimeMillis;
                        fVar.c = jElapsedRealtime;
                        ((LinkedList) dVar.e).addFirst(fVar);
                        int size = ((LinkedList) dVar.e).size() - 100;
                        if (size > 0) {
                            W5.c.a("RpkPageController", "ON_PAGE_STOP, too many pages in stack, delete pages " + size);
                            for (int i = 0; i < size; i++) {
                                ((LinkedList) dVar.e).removeLast();
                            }
                        }
                    }
                    return;
                }
                return;
            case 1:
                if (this.c.mRpkInstance != null) {
                    e eVar2 = this.c.mRpkInstance;
                    String str2 = this.b;
                    eVar2.getClass();
                    W5.c.a("RpkInstanceImpl", "onPageStop pageName: " + str2);
                    u1.d dVar2 = eVar2.c;
                    if (dVar2 == null) {
                        return;
                    }
                    synchronized (dVar2) {
                        try {
                            W5.c.a("RpkPageController", "stopPage: " + str2);
                            Iterator it = ((LinkedList) dVar2.e).iterator();
                            while (it.hasNext()) {
                                System.currentTimeMillis();
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                f fVar2 = (f) it.next();
                                if (Math.abs(jElapsedRealtime2 - fVar2.c) > 43200000) {
                                    it.remove();
                                    W5.c.a("RpkPageController", "remove invalid page who's duration > 12 hours:" + fVar2);
                                }
                            }
                            Iterator it2 = ((LinkedList) dVar2.e).iterator();
                            boolean z10 = false;
                            while (it2.hasNext()) {
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                                f fVar3 = (f) it2.next();
                                if (str2.equals(fVar3.f3982a)) {
                                    if (z10) {
                                        W5.c.a("RpkPageController", "found repeated page: " + fVar3);
                                    } else {
                                        ((e) dVar2.b).b.z(str2, fVar3.b, jCurrentTimeMillis2, jElapsedRealtime3 - fVar3.c);
                                        W5.c.a("RpkPageController", "create a page event: " + fVar3);
                                        z10 = true;
                                    }
                                    it2.remove();
                                }
                            }
                            if (((LinkedList) dVar2.e).size() <= 0) {
                                new Handler(Looper.getMainLooper()).postDelayed((l) dVar2.d, 30000L);
                            }
                        } finally {
                        }
                    }
                    return;
                }
                return;
            default:
                RpkUsageStats rpkUsageStats = this.c;
                rpkUsageStats.sharedPreferencesHelper = new V5.a(rpkUsageStats.mContext, "statsrpk_config_" + this.b);
                this.c.mRpkInfo.e = this.c.sharedPreferencesHelper.f1385a.getString("appKey", "");
                this.c.mRpkInfo.d = this.c.sharedPreferencesHelper.f1385a.getString("apkPkgName", "");
                if (TextUtils.isEmpty(this.c.mRpkInfo.e) || TextUtils.isEmpty(this.c.mRpkInfo.d)) {
                    String string = Uri.parse(S0.b.m + this.c.mRpkInfo.f3976a).buildUpon().toString();
                    W5.c.a(RpkUsageStats.TAG, "RpkUsageStats try cdn url: " + string);
                    NetResponse netResponseB = null;
                    try {
                        netResponseB = K5.c.a(this.c.mContext).b(null, string);
                    } catch (IOException e) {
                        W5.c.b(RpkUsageStats.TAG, e.getMessage());
                    } catch (RuntimeException e6) {
                        W5.c.b(RpkUsageStats.TAG, e6.getMessage());
                    }
                    W5.c.a(RpkUsageStats.TAG, "RpkUsageStats getConfigFromServer response: " + netResponseB);
                    if (netResponseB != null && netResponseB.getResponseCode() == 200 && (responseBody = netResponseB.getResponseBody()) != null) {
                        W5.c.a(RpkUsageStats.TAG, "RpkUsageStats successfully posted to " + string);
                        try {
                            M.a.j(this.c.mContext, responseBody, this.c.mRpkInfo);
                            M.a.D(this.c.mContext, responseBody, this.c.mRpkInfo);
                        } catch (JSONException e9) {
                            W5.c.b(RpkUsageStats.TAG, e9.getMessage());
                        }
                    }
                }
                if (TextUtils.isEmpty(this.c.mRpkInfo.e) || TextUtils.isEmpty(this.c.mRpkInfo.d)) {
                    W5.c.a(RpkUsageStats.TAG, "rpkInfo.appKey or rpkInfo.apkPkgName is empty，unable to initialize.");
                    return;
                }
                RpkUsageStats rpkUsageStats2 = this.c;
                Context context = rpkUsageStats2.mContext;
                RpkInfo rpkInfo = this.c.mRpkInfo;
                e eVar3 = new e();
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                if (context == null) {
                    throw new IllegalArgumentException("The applicationContext is null!");
                }
                Context applicationContext = context.getApplicationContext();
                eVar3.f3981a = rpkInfo;
                u1.d dVar3 = new u1.d(12, false);
                dVar3.b = applicationContext;
                dVar3.c = rpkInfo;
                dVar3.e = new V5.a(applicationContext, "statsrpk_config_" + rpkInfo.f3976a);
                HandlerThread handlerThread = new HandlerThread("rpk.ConfigControllerWorker", 5);
                handlerThread.start();
                dVar3.d = new Q5.a(dVar3, handlerThread.getLooper(), 4);
                eVar3.d = dVar3;
                W5.c.a("RpkInstanceImpl", "##### RpkInstanceImpl 1, " + (System.currentTimeMillis() - jCurrentTimeMillis3));
                W5.c.a("RpkInstanceImpl", "##### RpkInstanceImpl 2, " + (System.currentTimeMillis() - jCurrentTimeMillis3));
                W5.c.a("RpkInstanceImpl", "##### RpkInstanceImpl 3, " + (System.currentTimeMillis() - jCurrentTimeMillis3));
                C1621a c1621a = new C1621a();
                c1621a.f4793a = applicationContext;
                Intent intent = new Intent(applicationContext, (Class<?>) RpkUsageStatsService.class);
                b bVar = new b(c1621a);
                boolean zBindService = applicationContext.bindService(intent, bVar, 1);
                W5.c.a("RpkEmitter", "bindService, " + bVar + " result: " + zBindService);
                if (zBindService) {
                    synchronized (bVar) {
                        try {
                            bVar.wait();
                        } catch (InterruptedException e10) {
                            W5.c.f("RpkEmitter", "Exception:" + e10.toString() + " -Cause:" + e10.getCause());
                        }
                    }
                }
                RpkInfo rpkInfo2 = eVar3.f3981a;
                u1.d dVar4 = new u1.d(14, false);
                dVar4.b = c1621a;
                dVar4.c = rpkInfo2;
                dVar4.d = new V5.a(applicationContext, "statsrpk_config_" + rpkInfo2.f3976a);
                W5.c.e("RpkTracker", "RpkTracker created successfully.");
                eVar3.b = dVar4;
                W5.c.a("RpkInstanceImpl", "##### RpkInstanceImpl 4, " + (System.currentTimeMillis() - jCurrentTimeMillis3));
                u1.d dVar5 = new u1.d(13, false);
                dVar5.e = new LinkedList();
                dVar5.d = new l(dVar5, 26);
                eVar3.c = dVar5;
                W5.c.a("RpkInstanceImpl", "##### RpkInstanceImpl 5, " + (System.currentTimeMillis() - jCurrentTimeMillis3));
                Q5.a aVar = (Q5.a) eVar3.d.d;
                if (aVar.hasMessages(1)) {
                    aVar.removeMessages(1);
                }
                aVar.sendEmptyMessageDelayed(1, 1000);
                dVar5.b = eVar3;
                dVar4.e = eVar3;
                W5.c.a("RpkInstanceImpl", "##### RpkInstanceImpl 6, " + (System.currentTimeMillis() - jCurrentTimeMillis3));
                rpkUsageStats2.mRpkInstance = eVar3;
                return;
        }
    }
}
