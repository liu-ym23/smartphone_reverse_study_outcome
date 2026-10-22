package com.stepos.statsrpk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.r;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import com.stepos.statsrpk.service.RpkUsageStatsService;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import p5.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2856c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ String f2857f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ RpkUsageStats f2858g;

    public /* synthetic */ d(int i) {
        this.f2856c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        int i = 0;
        switch (this.f2856c) {
            case 0:
                if (this.f2858g.mRpkInstance != null) {
                    i iVar = this.f2858g.mRpkInstance;
                    String str2 = this.f2857f;
                    iVar.getClass();
                    ua.c.a("RpkInstanceImpl", "onPageStart pageName: " + str2);
                    p5.i iVar2 = iVar.f2872c;
                    if (iVar2 == null) {
                        return;
                    }
                    synchronized (iVar2) {
                        ua.c.a("RpkPageController", "startPage: " + str2);
                        new Handler(Looper.getMainLooper()).removeCallbacks((r) iVar2.f9733h);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        j jVar = new j();
                        jVar.f2874a = str2;
                        jVar.f2875b = jCurrentTimeMillis;
                        jVar.f2876c = jElapsedRealtime;
                        ((LinkedList) iVar2.f9730c).addFirst(jVar);
                        int size = ((LinkedList) iVar2.f9730c).size() - 100;
                        if (size > 0) {
                            ua.c.a("RpkPageController", "ON_PAGE_STOP, too many pages in stack, delete pages " + size);
                            while (i < size) {
                                ((LinkedList) iVar2.f9730c).removeLast();
                                i++;
                            }
                        }
                    }
                    return;
                }
                return;
            case 1:
                if (this.f2858g.mRpkInstance != null) {
                    i iVar3 = this.f2858g.mRpkInstance;
                    String str3 = this.f2857f;
                    iVar3.getClass();
                    ua.c.a("RpkInstanceImpl", "onPageStop pageName: " + str3);
                    p5.i iVar4 = iVar3.f2872c;
                    if (iVar4 == null) {
                        return;
                    }
                    synchronized (iVar4) {
                        try {
                            ua.c.a("RpkPageController", "stopPage: " + str3);
                            Iterator it = ((LinkedList) iVar4.f9730c).iterator();
                            while (it.hasNext()) {
                                System.currentTimeMillis();
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                j jVar2 = (j) it.next();
                                if (Math.abs(jElapsedRealtime2 - jVar2.f2876c) > 43200000) {
                                    it.remove();
                                    ua.c.a("RpkPageController", "remove invalid page who's duration > 12 hours:" + jVar2);
                                }
                            }
                            Iterator it2 = ((LinkedList) iVar4.f9730c).iterator();
                            while (it2.hasNext()) {
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                                j jVar3 = (j) it2.next();
                                if (str3.equals(jVar3.f2874a)) {
                                    if (i == 0) {
                                        ((i) iVar4.f9731f).f2871b.g(str3, jVar3.f2875b, jCurrentTimeMillis2, jElapsedRealtime3 - jVar3.f2876c);
                                        ua.c.a("RpkPageController", "create a page event: " + jVar3);
                                        i = 1;
                                    } else {
                                        ua.c.a("RpkPageController", "found repeated page: " + jVar3);
                                    }
                                    it2.remove();
                                }
                            }
                            if (((LinkedList) iVar4.f9730c).size() <= 0) {
                                new Handler(Looper.getMainLooper()).postDelayed((r) iVar4.f9733h, 30000L);
                            }
                        } finally {
                        }
                    }
                    return;
                }
                return;
            default:
                RpkUsageStats rpkUsageStats = this.f2858g;
                rpkUsageStats.sharedPreferencesHelper = new ta.a(rpkUsageStats.mContext, "statsrpk_config_" + this.f2857f);
                this.f2858g.mRpkInfo.i = this.f2858g.sharedPreferencesHelper.f13291a.getString("appKey", "");
                this.f2858g.mRpkInfo.f2851h = this.f2858g.sharedPreferencesHelper.f13291a.getString("apkPkgName", "");
                if (TextUtils.isEmpty(this.f2858g.mRpkInfo.i) || TextUtils.isEmpty(this.f2858g.mRpkInfo.f2851h)) {
                    String string = Uri.parse(h.f2868f + this.f2858g.mRpkInfo.f2848c).buildUpon().toString();
                    ua.c.a(RpkUsageStats.TAG, "RpkUsageStats try cdn url: " + string);
                    NetResponse netResponseA = null;
                    try {
                        netResponseA = ia.c.b(this.f2858g.mContext).a(string, null);
                    } catch (IOException e10) {
                        ua.c.b(RpkUsageStats.TAG, e10.getMessage());
                    } catch (RuntimeException e11) {
                        ua.c.b(RpkUsageStats.TAG, e11.getMessage());
                    }
                    ua.c.a(RpkUsageStats.TAG, "RpkUsageStats getConfigFromServer response: " + netResponseA);
                    if (netResponseA != null && netResponseA.f2840c == 200 && (str = netResponseA.f2841f) != null) {
                        ua.c.a(RpkUsageStats.TAG, "RpkUsageStats successfully posted to " + string);
                        try {
                            td.h.f(this.f2858g.mContext, str, this.f2858g.mRpkInfo);
                            td.h.h(this.f2858g.mContext, str, this.f2858g.mRpkInfo);
                        } catch (JSONException e12) {
                            ua.c.b(RpkUsageStats.TAG, e12.getMessage());
                        }
                    }
                }
                if (TextUtils.isEmpty(this.f2858g.mRpkInfo.i) || TextUtils.isEmpty(this.f2858g.mRpkInfo.f2851h)) {
                    ua.c.a(RpkUsageStats.TAG, "rpkInfo.appKey or rpkInfo.apkPkgName is empty，unable to initialize.");
                    return;
                }
                RpkUsageStats rpkUsageStats2 = this.f2858g;
                Context context = rpkUsageStats2.mContext;
                b bVar = this.f2858g.mRpkInfo;
                i iVar5 = new i();
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                if (context == null) {
                    g5.f.s("The applicationContext is null!");
                    return;
                }
                Context applicationContext = context.getApplicationContext();
                iVar5.f2870a = bVar;
                p5.i iVar6 = new p5.i();
                iVar6.f9730c = applicationContext;
                iVar6.f9731f = bVar;
                iVar6.f9733h = new ta.a(applicationContext, "statsrpk_config_" + bVar.f2848c);
                HandlerThread handlerThread = new HandlerThread("rpk.ConfigControllerWorker", 5);
                handlerThread.start();
                iVar6.f9732g = new e(iVar6, handlerThread.getLooper(), i);
                iVar5.f2873d = iVar6;
                ua.c.a("RpkInstanceImpl", "##### RpkInstanceImpl 1, " + (System.currentTimeMillis() - jCurrentTimeMillis3));
                ua.c.a("RpkInstanceImpl", "##### RpkInstanceImpl 2, " + (System.currentTimeMillis() - jCurrentTimeMillis3));
                ua.c.a("RpkInstanceImpl", "##### RpkInstanceImpl 3, " + (System.currentTimeMillis() - jCurrentTimeMillis3));
                u uVar = new u(3);
                uVar.f9807f = applicationContext;
                Intent intent = new Intent(applicationContext, (Class<?>) RpkUsageStatsService.class);
                f fVar = new f();
                fVar.f2861a = uVar;
                VarHandle.storeStoreFence();
                boolean zBindService = applicationContext.bindService(intent, fVar, 1);
                ua.c.a("RpkEmitter", "bindService, " + fVar + " result: " + zBindService);
                if (zBindService) {
                    synchronized (fVar) {
                        try {
                            fVar.wait();
                        } catch (InterruptedException e13) {
                            ua.c.f("RpkEmitter", "Exception:" + e13.toString() + " -Cause:" + e13.getCause());
                        }
                    }
                }
                b bVar2 = iVar5.f2870a;
                p5.i iVar7 = new p5.i();
                iVar7.f9730c = uVar;
                iVar7.f9731f = bVar2;
                iVar7.f9732g = new ta.a(applicationContext, "statsrpk_config_" + bVar2.f2848c);
                ua.c.e("RpkTracker", "RpkTracker created successfully.");
                iVar5.f2871b = iVar7;
                ua.c.a("RpkInstanceImpl", "##### RpkInstanceImpl 4, " + (System.currentTimeMillis() - jCurrentTimeMillis3));
                p5.i iVar8 = new p5.i();
                iVar8.f9730c = new LinkedList();
                r rVar = new r(4);
                rVar.f1301f = iVar8;
                VarHandle.storeStoreFence();
                iVar8.f9733h = rVar;
                iVar5.f2872c = iVar8;
                ua.c.a("RpkInstanceImpl", "##### RpkInstanceImpl 5, " + (System.currentTimeMillis() - jCurrentTimeMillis3));
                e eVar = (e) iVar5.f2873d.f9732g;
                if (eVar.hasMessages(1)) {
                    eVar.removeMessages(1);
                }
                eVar.sendEmptyMessageDelayed(1, 1000);
                iVar8.f9731f = iVar5;
                iVar7.f9733h = iVar5;
                ua.c.a("RpkInstanceImpl", "##### RpkInstanceImpl 6, " + (System.currentTimeMillis() - jCurrentTimeMillis3));
                rpkUsageStats2.mRpkInstance = iVar5;
                return;
        }
    }
}
