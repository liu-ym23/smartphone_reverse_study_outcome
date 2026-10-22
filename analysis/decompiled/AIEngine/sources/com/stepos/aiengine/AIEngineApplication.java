package com.stepos.aiengine;

import android.app.Activity;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import androidx.work.a;
import b6.e;
import b6.j;
import b7.t;
import com.stepos.aicgroup.memory.PressureLevel;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.model.manager.ModelCacheImpl;
import com.stepos.core.ota.monitor.ActiveDownloadConditionMonitor;
import com.stepos.core.performance.orchestrator.PerformanceOrchestratorImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AIEngineApplication extends Application implements a.b {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f5748d = 0;

    /* renamed from: a, reason: collision with root package name */
    public boolean f5749a;

    /* renamed from: b, reason: collision with root package name */
    public final com.stepos.aiengine.memory.a f5750b = new com.stepos.aiengine.memory.a(new e(0));

    /* renamed from: c, reason: collision with root package name */
    public volatile com.stepos.aiengine.preheat.a f5751c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5752a;

        static {
            int[] iArr = new int[PressureLevel.values().length];
            try {
                iArr[PressureLevel.ULTRA_LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PressureLevel.LOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PressureLevel.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f5752a = iArr;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b implements a7.a {
        @Override // a7.a
        public final void i(String tag, String message) {
            LogModule next;
            g.f(tag, "tag");
            g.f(message, "message");
            Iterator<LogModule> it = LogModule.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (g.b(next.getModuleTag(), "Inference")) {
                        break;
                    }
                }
            }
            LogModule logModule = next;
            if (logModule == null) {
                logModule = LogModule.ABILITY;
            }
            AIEngineLogger.i(logModule, tag, message);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String str;
            if (g.b(intent != null ? intent.getAction() : null, "android.intent.action.LOCALE_CHANGED")) {
                k6.a aVar = k6.a.f9946a;
                Context applicationContext = AIEngineApplication.this.getApplicationContext();
                g.e(applicationContext, "getApplicationContext(...)");
                aVar.getClass();
                Context applicationContext2 = applicationContext.getApplicationContext();
                NotificationManager notificationManager = (NotificationManager) applicationContext2.getSystemService(NotificationManager.class);
                if (notificationManager == null) {
                    return;
                }
                notificationManager.createNotificationChannel(new NotificationChannel("aiengine_condition_break", applicationContext2.getString(R.string.mm_cond_channel), 4));
                for (ActiveDownloadConditionMonitor.ConditionKind conditionKind : ActiveDownloadConditionMonitor.ConditionKind.getEntries()) {
                    k6.a.f9946a.getClass();
                    int iOrdinal = conditionKind.ordinal() + 92000;
                    if (k6.a.a(notificationManager, iOrdinal) && (str = k6.a.f9947b.get(conditionKind)) != null) {
                        k6.a.b(applicationContext2, notificationManager, str, conditionKind, iOrdinal);
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a, reason: collision with root package name */
        public int f5754a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PerformanceOrchestratorImpl f5755b;

        public d(PerformanceOrchestratorImpl performanceOrchestratorImpl) {
            this.f5755b = performanceOrchestratorImpl;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            g.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            g.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            g.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            g.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            g.f(activity, "activity");
            g.f(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            g.f(activity, "activity");
            int i10 = this.f5754a;
            this.f5754a = i10 + 1;
            if (i10 == 0) {
                this.f5755b.signalHub().reportForegroundChange(true);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            g.f(activity, "activity");
            int i10 = this.f5754a - 1;
            this.f5754a = i10;
            if (i10 == 0) {
                this.f5755b.signalHub().reportForegroundChange(false);
            }
        }
    }

    @Override // androidx.work.a.b
    public final androidx.work.a a() {
        a.C0021a c0021a = new a.C0021a();
        c0021a.f2826a = 5;
        return new androidx.work.a(c0021a);
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context base) {
        g.f(base, "base");
        super.attachBaseContext(base);
        Context applicationContext = getApplicationContext();
        if (applicationContext != null) {
            this = applicationContext;
        }
        l7.a.f10344a = this;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:174:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x041a A[LOOP:1: B:204:0x0414->B:206:0x041a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x057f  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0591 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01b2 A[Catch: all -> 0x018b, TryCatch #17 {all -> 0x018b, blocks: (B:66:0x0182, B:68:0x0188, B:71:0x018d, B:73:0x0192, B:75:0x0198, B:77:0x01a0, B:79:0x01a7, B:83:0x01d4, B:82:0x01b2), top: B:385:0x0182 }] */
    /* JADX WARN: Type inference failed for: r0v171, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r0v66, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r0v67, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v12 */
    /* JADX WARN: Type inference failed for: r18v13 */
    /* JADX WARN: Type inference failed for: r18v14 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            Method dump skipped, instructions count: 2202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.AIEngineApplication.b():void");
    }

    @Override // android.app.Application
    public final void onCreate() {
        super.onCreate();
        Object systemService = getSystemService("user");
        UserManager userManager = systemService instanceof UserManager ? (UserManager) systemService : null;
        if (userManager != null ? userManager.isUserUnlocked() : true) {
            b();
        } else {
            Log.w("AIEngineApplication", "Device in Direct Boot mode, deferring initialization until USER_UNLOCKED");
            registerReceiver(new j(this, 0), new IntentFilter("android.intent.action.USER_UNLOCKED"));
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public final void onLowMemory() {
        super.onLowMemory();
        ModelCacheImpl modelCacheImpl = b7.j.f3087b;
        if (modelCacheImpl == null) {
            return;
        }
        Log.e("AIEngineApplication", "[Memory] onLowMemory: evicting idle models (active refCount>0 retained)");
        List<t.a> listSnapshot = modelCacheImpl.snapshot();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSnapshot) {
            t.a aVar = (t.a) obj;
            if (!aVar.f3123c && aVar.f3124d == 0) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            Log.w("AIEngineApplication", "[Memory][Sandbox] " + arrayList.size() + " stale version(s) eligible for unload:");
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj2 = arrayList.get(i10);
                i10++;
                t.a aVar2 = (t.a) obj2;
                String str = aVar2.f3121a;
                int i11 = aVar2.f3122b;
                long j10 = aVar2.f3126f / 1024;
                String str2 = aVar2.f3127g;
                StringBuilder sbF = h0.e.f("[Memory][Sandbox]   ", str, " v", i11, " size=");
                sbF.append(j10);
                sbF.append("KB backend=");
                sbF.append(str2);
                Log.w("AIEngineApplication", sbF.toString());
            }
        }
        modelCacheImpl.evictAllIdle();
        modelCacheImpl.evictByRetainBudget(256);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        PerformanceOrchestratorImpl.Companion.getInstance(this).signalHub().reportTrimMemory(i10);
    }
}
