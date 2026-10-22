package com.bytedance.apm.insight;

import B0.f;
import F1.c;
import F9.C0234l;
import H.h;
import H4.o;
import J2.d;
import M0.g;
import M0.i;
import M0.k;
import M0.l;
import Y5.b;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import ca.AbstractC0897f;
import com.apm.insight.log.VLog;
import com.apm.insight.log.VLogConfig;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.services.apm.api.IHttpService;
import com.zyql.common.utils.upload.TOSUploader;
import e1.C1403b;
import e3.C1417f;
import f1.C1431a;
import g0.e;
import g1.AbstractC1451a;
import h0.C1479c;
import h1.C1482c;
import i1.C1552a;
import j1.C1593b;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import k1.AbstractC1620b;
import l0.AbstractC1654a;
import o0.RunnableC1754a;
import s2.C1912a;
import x0.C2112a;
import y0.C2126b;

/* loaded from: classes2.dex */
public class ApmInsight {

    /* renamed from: a, reason: collision with root package name */
    public static final ApmInsight f2215a = new ApmInsight();
    public static boolean b = false;
    public static String sPackage = "com.bytedance";
    public boolean c = false;
    public Context d;

    public static ApmInsight getInstance() {
        return f2215a;
    }

    public void init(Application application) {
        if (application == null) {
            throw new NullPointerException("application can not be null!");
        }
        this.d = application;
        ActivityLifeObserver.init(application);
    }

    public void start(ApmInsightInitConfig apmInsightInitConfig) {
        init(this.d, apmInsightInitConfig);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void init(Context context, ApmInsightInitConfig apmInsightInitConfig) {
        if (context == null) {
            throw new NullPointerException("Please call the init method first!");
        }
        if (apmInsightInitConfig != null) {
            if (TextUtils.isEmpty(apmInsightInitConfig.getToken())) {
                Log.e("ApmInsight", "Token can not be null!!");
            }
            C4.a aVarC = C4.a.c();
            aVarC.c = apmInsightInitConfig;
            int i = 1;
            aVarC.b = true;
            boolean zEnableAPMPlusLocalLog = apmInsightInitConfig.enableAPMPlusLocalLog();
            C2112a c2112a = C2112a.c;
            if (zEnableAPMPlusLocalLog) {
                VLog.createInstance(new VLogConfig.Builder(context).setLogDirPath(context.getFilesDir() + "/Vlog/APMPlus").setMaxDirSize(TOSUploader.MIN_SIZE).setSubProcessMaxDirSizeRatio(0.1f).setLogFileExpDays(14).build(), "APMPlus");
            }
            C2112a.c.f6869a = zEnableAPMPlusLocalLog;
            C0234l c0234l = new C0234l();
            c0234l.f649a = apmInsightInitConfig.isWithFpsMonitor();
            long maxLaunchTime = apmInsightInitConfig.getMaxLaunchTime();
            c cVar = new c();
            cVar.f535a = maxLaunchTime;
            c0234l.d = cVar;
            c0234l.b = apmInsightInitConfig.isDebug();
            int i6 = 3;
            if (apmInsightInitConfig.getActivityLeakListener() != null) {
                Q.a aVar = new Q.a(apmInsightInitConfig, i6);
                Q.a aVar2 = new Q.a(7);
                aVar2.b = aVar;
                c0234l.c = aVar2;
            }
            f fVar = new f(c0234l);
            d dVar = J2.c.f865a;
            int i10 = 5;
            int i11 = 0;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            if (!dVar.f) {
                dVar.f = true;
                int i12 = b.c;
                h.f();
                h.f712j = true;
                dVar.f866a = fVar;
                AtomicInteger atomicInteger = N.a.d;
                Application application = context instanceof Application ? (Application) context : (Application) context.getApplicationContext();
                if (application != null) {
                    h.f711a = application;
                }
                h.p = "1.5.4.cn-rc.1";
                ActivityLifeObserver.init(application);
                dVar.b();
                h.n = null;
                boolean zG = h.g();
                dVar.h = zG;
                if (zG) {
                    Q.a aVar3 = (Q.a) dVar.f866a.f177a;
                    C2126b c2126b = C2126b.g;
                    if (application != null && aVar3 != null && !C2126b.i) {
                        C2126b.i = true;
                        C2126b c2126b2 = C2126b.g;
                        c2126b2.d = aVar3;
                        c2126b2.e = 60000L;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        c2126b2.f6887a = new Handler(Looper.getMainLooper());
                        c2126b2.b = new ReferenceQueue();
                        c2126b2.c = new CopyOnWriteArraySet();
                        application.registerActivityLifecycleCallbacks(new Na.a(i));
                        if (h.b) {
                            Log.i("ApmInsight:ActivityLeakTask", U7.a.e(new String[]{"initActivityLeakCheck done, cost: " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms."}));
                        }
                    }
                    Y.b.c = 20000L;
                    h.l = System.currentTimeMillis();
                    boolean z10 = fVar.b;
                    h0.f fVar2 = h0.f.p;
                    if (!fVar2.o) {
                        fVar2.d = z10;
                        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                            ActivityLifeObserver.getInstance().register(fVar2);
                            e.a();
                            e.d = new h0.d(fVar2);
                            fVar2.o = true;
                        } else {
                            throw new AssertionError("must be init in main thread!");
                        }
                    }
                    C1479c c1479c = new C1479c();
                    c1479c.b = new ArrayList();
                    c1479c.c = new HashMap();
                    fVar2.d(c1479c);
                    synchronized (AbstractC1451a.f4476z) {
                    }
                    AbstractC0897f.f2116B = ((c) fVar.c).f535a;
                }
                if (h.b) {
                    if (dVar.h) {
                        AbstractC1654a.f5271a.a("APM_INIT", null);
                    } else {
                        AbstractC1654a.f5271a.a("APM_INIT_OTHER_PROCESS", null);
                    }
                }
                S0.a.f1163a = "ApmSender";
                AbstractC1451a.f4470r = true;
                C1912a c1912a = new C1912a();
                synchronized (i.class) {
                    try {
                        if (!i.f955a) {
                            i.f955a = true;
                            AbstractC1451a.c = c1912a;
                            AbstractC1451a.b = context instanceof Application ? (Application) context : (Application) context.getApplicationContext();
                            AbstractC1451a.l = System.currentTimeMillis();
                            AbstractC1451a.m = System.currentTimeMillis();
                            o.b = new C1482c();
                            int i13 = 2;
                            M0.a aVar4 = new M0.a(c1912a, i13);
                            ConcurrentHashMap concurrentHashMap = AbstractC1620b.b;
                            concurrentHashMap.put(IHttpService.class, aVar4);
                            concurrentHashMap.put(l.class, new M0.b(c1912a, i));
                            concurrentHashMap.put(M0.d.class, new M0.b(i13));
                            concurrentHashMap.put(M0.e.class, new M0.b(i6));
                            int i14 = 4;
                            concurrentHashMap.put(k.class, new M0.b(c1912a, i14));
                            concurrentHashMap.put(C1552a.class, new M0.b(c1912a, i10));
                            concurrentHashMap.put(C1431a.class, new M0.b(6));
                            concurrentHashMap.put(i0.b.class, new M0.a(c1912a, i6));
                            concurrentHashMap.put(M0.f.class, new M0.a(c1912a, i14));
                            new C1431a();
                            concurrentHashMap.put(M0.h.class, new M0.a(c1912a, i11));
                            concurrentHashMap.put(C1403b.class, new M0.b(objArr2 == true ? 1 : 0));
                            concurrentHashMap.put(g.class, new M0.a(c1912a, i));
                            C1593b.a().c();
                            s1.b.a(cc.dd.ee.kk.ff.c.b).c(new M0.c(0L));
                            Y0.b bVar = Y0.b.f;
                            C1417f c1417f = new C1417f(i6);
                            synchronized (bVar) {
                                bVar.b = c1417f;
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            sPackage = "com.bytedance";
            IDynamicParams dynamicParams = apmInsightInitConfig.getDynamicParams();
            h.f715s = apmInsightInitConfig.getExternalTraceId();
            h.u = apmInsightInitConfig.enableTrace();
            h.f718w = apmInsightInitConfig.getToken();
            h.f717v = apmInsightInitConfig.enableOperateMonitor();
            L0.f fVar3 = L0.d.f925a;
            fVar3.b(new A.a(i10, dynamicParams, objArr == true ? 1 : 0, apmInsightInitConfig));
            fVar3.b(new RunnableC1754a(this, apmInsightInitConfig, context, dynamicParams));
            fVar3.b(new RunnableC1754a(this, context, apmInsightInitConfig, dynamicParams));
            return;
        }
        throw new NullPointerException("ApmInsightInitConfig can not be null!");
    }
}
