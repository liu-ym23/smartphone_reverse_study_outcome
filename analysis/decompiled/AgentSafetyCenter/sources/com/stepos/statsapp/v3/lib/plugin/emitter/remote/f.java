package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import a4.l;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.fragment.app.r;
import com.stepos.agentsafetycenter.AgentSafetyApplication;
import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface;
import com.stepos.statsapp.v3.lib.plugin.emitter.EmitterConfig;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.lang.invoke.VarHandle;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p5.i;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public Context f2830a;

    /* renamed from: b, reason: collision with root package name */
    public EmitterConfig f2831b;

    /* renamed from: c, reason: collision with root package name */
    public ta.a f2832c;

    /* renamed from: d, reason: collision with root package name */
    public V3OfflineEmitter$VccOfflineStatsCallback f2833d;

    /* renamed from: e, reason: collision with root package name */
    public ThreadPoolExecutor f2834e;

    /* renamed from: f, reason: collision with root package name */
    public ta.a f2835f;

    /* renamed from: g, reason: collision with root package name */
    public long f2836g;

    /* renamed from: h, reason: collision with root package name */
    public String f2837h;

    public static f c(AgentSafetyApplication agentSafetyApplication, String str, String str2) throws Throwable {
        f fVar = new f();
        fVar.f2830a = agentSafetyApplication;
        fVar.f2832c = new ta.a(agentSafetyApplication, "com.stepos.statsapp.v3.emitterconfig");
        EmitterConfig emitterConfig = new EmitterConfig();
        emitterConfig.f2810c = true;
        emitterConfig.f2812g = true;
        emitterConfig.f2813h = true;
        emitterConfig.i = true;
        emitterConfig.f2814j = 1800000L;
        emitterConfig.f2815k = 50;
        emitterConfig.f2816l = 2097152L;
        emitterConfig.f2817m = 10;
        emitterConfig.f2818n = str;
        emitterConfig.f2819o = str2;
        fVar.f2831b = emitterConfig;
        fVar.d();
        fVar.f2836g = 0L;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        e eVar = new e();
        eVar.f2829c = new AtomicInteger(0);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, linkedBlockingQueue, eVar, new b(0));
        fVar.f2834e = threadPoolExecutor;
        fVar.f2837h = agentSafetyApplication.getPackageName();
        try {
            String strA = ra.b.a(agentSafetyApplication);
            if (strA == null || strA.equals(agentSafetyApplication.getPackageName())) {
                fVar.f2835f = new ta.a(agentSafetyApplication, "com.stepos.statsapp.v3.events_cache");
            } else {
                fVar.f2835f = new ta.a(agentSafetyApplication, "com.stepos.statsapp.v3.events_cache_".concat(strA));
            }
            r rVar = new r(3);
            rVar.f1301f = fVar;
            VarHandle.storeStoreFence();
            threadPoolExecutor.execute(rVar);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        fVar.f2833d = new V3OfflineEmitter$VccOfflineStatsCallback(fVar, null);
        g.f2838a.e(agentSafetyApplication, fVar);
        VarHandle.storeStoreFence();
        ua.c.d("Emitter", "buildEmitter emitter is V3OfflineEmitter");
        return fVar;
    }

    public final void a() {
        i iVar = g.f2838a;
        Context context = this.f2830a;
        String str = this.f2837h;
        V3OfflineEmitter$VccOfflineStatsCallback v3OfflineEmitter$VccOfflineStatsCallback = this.f2833d;
        if (iVar.j(context)) {
            try {
                ((IVccOfflineStatsInterface) iVar.f9731f).setCallback(str, v3OfflineEmitter$VccOfflineStatsCallback);
            } catch (Throwable th) {
                ua.c.b("V3RemoteServiceReq", "setCallback error, " + th.getMessage());
            }
        }
        ThreadPoolExecutor threadPoolExecutor = this.f2834e;
        a aVar = new a(0);
        aVar.f2822g = this;
        aVar.f2821f = false;
        VarHandle.storeStoreFence();
        threadPoolExecutor.execute(aVar);
    }

    public final void b(TrackerPayload trackerPayload) {
        if (this.f2831b.f2810c) {
            String string = trackerPayload.toString();
            ThreadPoolExecutor threadPoolExecutor = this.f2834e;
            l lVar = new l(1);
            lVar.f185f = this;
            lVar.f186g = trackerPayload;
            lVar.f187h = string;
            VarHandle.storeStoreFence();
            threadPoolExecutor.execute(lVar);
        }
    }

    public final void d() {
        EmitterConfig emitterConfig = this.f2831b;
        ta.a aVar = this.f2832c;
        emitterConfig.f2810c = aVar.f13291a.getBoolean("active", true);
        emitterConfig.f2812g = aVar.f13291a.getBoolean("flushOnStart", true);
        emitterConfig.i = aVar.f13291a.getBoolean("flushOnReconnect", true);
        emitterConfig.f2813h = aVar.f13291a.getBoolean("flushOnCharge", true);
        emitterConfig.f2814j = aVar.f13291a.getLong("flushDelayInterval", 1800000L);
        emitterConfig.f2815k = aVar.f13291a.getInt("flushCacheLimit", 50);
        emitterConfig.f2816l = aVar.f13291a.getLong("flushMobileTrafficLimit", 2097152L);
        emitterConfig.f2817m = aVar.f13291a.getInt("neartimeInterval", 5);
    }

    public final void e(boolean z10, boolean z11, boolean z12, boolean z13, long j10, int i, long j11, int i3) {
        SharedPreferences.Editor editorEdit = this.f2832c.f13291a.edit();
        editorEdit.putBoolean("active", z10);
        editorEdit.putBoolean("flushOnStart", z11);
        editorEdit.putBoolean("flushOnReconnect", z12);
        editorEdit.putBoolean("flushOnCharge", z13);
        editorEdit.putLong("flushDelayInterval", j10);
        editorEdit.putLong("flushMobileTrafficLimit", j11);
        editorEdit.putInt("flushCacheLimit", i);
        editorEdit.putInt("neartimeInterval", i3);
        editorEdit.apply();
        d();
    }
}
