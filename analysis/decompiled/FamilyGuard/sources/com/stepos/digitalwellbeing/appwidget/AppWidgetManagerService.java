package com.stepos.digitalwellbeing.appwidget;

import D2.j;
import N1.h;
import N1.i;
import V1.A;
import V1.o;
import Y1.l;
import android.app.ActivityManager;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.AbstractC0545z;
import androidx.lifecycle.C;
import com.stepos.digitalwellbeing.server.data.DataToken;
import com.stepos.digitalwellbeing.server.data.NotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PickupTimesStats;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.digitalwellbeing.server.data.UsingTimeStats;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0600i;
import com.stepos.familyguard.ui.usage.U;
import e2.C0684b;
import f2.C0702g;
import f2.C0711p;
import f2.C0712q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import v2.AbstractC1182a;
import v2.C1183b;
import w2.W0;
import w2.p1;
import x3.EnumC1285a;
import x3.f;
import x3.g;
import z3.C1347a;

/* loaded from: classes.dex */
public class AppWidgetManagerService extends Service {

    /* renamed from: m, reason: collision with root package name */
    private static final long f14475m = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: n, reason: collision with root package name */
    private static long f14476n;

    /* renamed from: a, reason: collision with root package name */
    private AppWidgetManager f14477a;

    /* renamed from: c, reason: collision with root package name */
    private f<Bundle> f14479c;

    /* renamed from: d, reason: collision with root package name */
    private g<Long> f14480d;

    /* renamed from: e, reason: collision with root package name */
    private AbstractC1182a f14481e;

    /* renamed from: f, reason: collision with root package name */
    private Configuration f14482f;

    /* renamed from: g, reason: collision with root package name */
    private Context f14483g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f14484h;

    /* renamed from: b, reason: collision with root package name */
    private final Map<A, com.stepos.digitalwellbeing.appwidget.b> f14478b = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    private final Handler f14485i = new Handler(Looper.getMainLooper());

    /* renamed from: j, reason: collision with root package name */
    private final b f14486j = new b();

    /* renamed from: k, reason: collision with root package name */
    private final C<Boolean> f14487k = new C() { // from class: V1.c
        @Override // androidx.lifecycle.C
        public final void a(Object obj) {
            this.f5481a.t((Boolean) obj);
        }
    };

    /* renamed from: l, reason: collision with root package name */
    private final Runnable f14488l = new Runnable() { // from class: V1.d
        @Override // java.lang.Runnable
        public final void run() {
            this.f5482a.u();
        }
    };

    class a implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f14489a;

        a(Context context) {
            this.f14489a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Context context) {
            AppWidgetManagerService.D(context, this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder instanceof b) {
                ((b) iBinder).b();
            }
            Handler handler = new Handler(Looper.getMainLooper());
            final Context context = this.f14489a;
            handler.postDelayed(new Runnable() { // from class: com.stepos.digitalwellbeing.appwidget.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f14491a.b(context);
                }
            }, 15000L);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            AppWidgetManagerService.D(this.f14489a, this);
        }
    }

    private final class b extends Binder {
        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (!AppWidgetManagerService.this.q()) {
                R1.a.l("AppWidgetManagerService", "skip recoverWidgets: service not initialized");
                return;
            }
            Log.e("AIOSBUG-4839-fix-v3", "recoverUpdate via bound service");
            AppWidgetManagerService.this.x();
            AppWidgetManagerService.this.E();
        }

        private b() {
        }
    }

    private void A() {
        this.f14485i.removeCallbacks(this.f14488l);
        this.f14485i.postDelayed(this.f14488l, 2000L);
    }

    private void B(Configuration configuration) {
        Rect rectO = o(configuration);
        if (rectO == null) {
            return;
        }
        Configuration configuration2 = getResources().getConfiguration();
        if (rectO.height() == 2340 && rectO.width() == 1080) {
            configuration2.screenWidthDp = 393;
            configuration2.screenHeightDp = 791;
            configuration2.smallestScreenWidthDp = 393;
            configuration2.densityDpi = 440;
            return;
        }
        if (rectO.height() == 3192 && rectO.width() == 1368) {
            configuration2.screenWidthDp = 391;
            configuration2.screenHeightDp = 848;
            configuration2.smallestScreenWidthDp = 391;
            configuration2.densityDpi = 560;
            return;
        }
        if (rectO.height() == 1280 && rectO.width() == 576) {
            configuration2.screenWidthDp = 329;
            configuration2.screenHeightDp = 679;
            configuration2.smallestScreenWidthDp = 329;
            configuration2.densityDpi = 280;
        }
    }

    public static boolean C(Context context, Intent intent) {
        if (context != null && intent != null) {
            try {
                context.getApplicationContext().startService(intent);
                return true;
            } catch (Exception e6) {
                R1.a.b("AppWidgetManagerService", "startWidgetService failed: action=" + intent.getAction() + ", error=" + e6.getMessage());
                StringBuilder sb = new StringBuilder();
                sb.append("startWidgetService failed: ");
                sb.append(e6.getMessage());
                Log.e("AIOSBUG-4839-fix-v3", sb.toString());
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void D(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException e6) {
            R1.a.l("AppWidgetManagerService", "unbind recovery service failed: " + e6.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        g<Long> gVar;
        C0702g.b("AppWidgetManagerService", "updateImmediately() called");
        AbstractC1182a abstractC1182a = this.f14481e;
        AbstractC0545z<Boolean> abstractC0545zB = abstractC1182a == null ? null : abstractC1182a.b();
        Boolean boolE = abstractC0545zB == null ? Boolean.FALSE : abstractC0545zB.e();
        if (boolE == null || !boolE.booleanValue() || (gVar = this.f14480d) == null) {
            this.f14484h = true;
        } else {
            gVar.d(-1L);
            this.f14484h = false;
        }
    }

    private static void i(Context context, Intent intent) {
        synchronized (AppWidgetManagerService.class) {
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j5 = f14476n;
                if (j5 > 0 && jElapsedRealtime - j5 < f14475m) {
                    C0702g.b("AppWidgetManagerService", "skip duplicate bound recovery");
                    return;
                }
                f14476n = jElapsedRealtime;
                Context applicationContext = context.getApplicationContext();
                try {
                    if (applicationContext.bindService(intent, new a(applicationContext), 1)) {
                        return;
                    }
                    R1.a.b("AppWidgetManagerService", "bind recovery service failed");
                    z();
                } catch (Exception e6) {
                    R1.a.b("AppWidgetManagerService", "bind recovery service failed: " + e6.getMessage());
                    z();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void j(A a6) {
        C0702g.b("AppWidgetManagerService", "checkAndRegister() called with: widgetType = [" + a6 + "]");
        if (!q()) {
            R1.a.l("AppWidgetManagerService", "skip checkAndRegister: service not initialized, widgetType = " + a6);
            return;
        }
        if (l(o.c(this.f14483g, a6))) {
            if (this.f14478b.containsKey(a6)) {
                if (this.f14478b.get(a6) == null) {
                    com.stepos.digitalwellbeing.appwidget.b bVarA = o.a(this.f14483g, a6);
                    bVarA.w(this.f14479c);
                    this.f14478b.put(a6, bVarA);
                    return;
                }
                return;
            }
            com.stepos.digitalwellbeing.appwidget.b bVarA2 = o.a(this.f14483g, a6);
            if (bVarA2 == null) {
                return;
            }
            bVarA2.w(this.f14479c);
            if (this.f14478b.isEmpty()) {
                this.f14481e.H();
            }
            this.f14478b.put(a6, bVarA2);
        }
    }

    private void k(A a6) {
        if (!l(o.c(this.f14483g, a6)) && this.f14478b.containsKey(a6)) {
            com.stepos.digitalwellbeing.appwidget.b bVar = this.f14478b.get(a6);
            if (bVar != null) {
                bVar.D();
            }
            this.f14478b.remove(a6);
        }
        if (this.f14478b.isEmpty()) {
            this.f14481e.I();
        }
    }

    private boolean l(ComponentName componentName) {
        int[] appWidgetIds = this.f14477a.getAppWidgetIds(componentName);
        boolean z5 = (appWidgetIds == null || appWidgetIds.length == 0) ? false : true;
        C0702g.b("AppWidgetManagerService", "checkWidgetsExist() called with: providerName = [" + componentName + "] result = [" + z5 + "]");
        return z5;
    }

    private Context m(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        this.f14482f = configuration;
        B(configuration);
        Context contextG = i.g(createConfigurationContext(this.f14482f));
        this.f14482f = contextG.getResources().getConfiguration();
        return contextG;
    }

    public static void n(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, AppWidgetManagerService.class);
        intent.setAction("com.stepos.familyguard.force_update");
        C(context, intent);
    }

    private Rect o(Configuration configuration) {
        try {
            Object obj = h.b(configuration).b("windowConfiguration").get(configuration);
            Rect rect = (Rect) h.b(obj).b("mBounds").get(obj);
            C0702g.b("AppWidgetManagerService", "onConfigurationChanged: bounds = " + rect);
            return rect;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    private Bundle p(DataToken dataToken) {
        PickupTimesStats[] pickupTimesStatsArr;
        int i5;
        StatsDataSet statsDataSet;
        int pickupTimes;
        int notifyTimes;
        int i6;
        StatsDataSet statsDataSet2;
        C0702g.b("AppWidgetManagerService", "getUsageData() called with: token = [" + dataToken + "]");
        Bundle bundle = new Bundle();
        int i7 = 0;
        if (dataToken != null && dataToken.getInvalidType() == -1) {
            bundle.putBoolean("HAS_PERMISSIONS", false);
            bundle.putBoolean("DATA_ERROR", false);
            return bundle;
        }
        if (dataToken != null && dataToken.getInvalidType() == -3) {
            bundle.putBoolean("HAS_PERMISSIONS", true);
            bundle.putBoolean("SUPPORT", true);
            bundle.putBoolean("ENABLE", l.c1());
            bundle.putBoolean("DATA_ERROR", true);
            return bundle;
        }
        if (dataToken != null && dataToken.getInvalidType() == -2) {
            int iIntValue = T1.b.c().intValue();
            if (iIntValue > 0 && iIntValue < 7) {
                bundle.putBoolean("SUPPORT", false);
                bundle.putBoolean("DATA_ERROR", false);
                return bundle;
            }
            bundle.putBoolean("SUPPORT", true);
            bundle.putBoolean("HAS_PERMISSIONS", p2.g.x(this));
            bundle.putBoolean("ENABLE", l.c1());
            bundle.putBoolean("DATA_ERROR", true);
            return bundle;
        }
        if (dataToken != null && dataToken.getInvalidType() == -4) {
            bundle.putBoolean("ENABLE", false);
            bundle.putBoolean("DATA_ERROR", false);
            return bundle;
        }
        if (dataToken != null && dataToken.isValid()) {
            bundle.putBoolean("HAS_PERMISSIONS", true);
            bundle.putBoolean("DATA_ERROR", false);
            if (C0684b.A()) {
                W0 w02 = (W0) this.f14481e;
                int iB = C0711p.B(System.currentTimeMillis());
                int i8 = iB != 0 ? iB : 7;
                int i9 = i8 - 1;
                U uR = w02.R(dataToken);
                com.stepos.digitalwellbeing.server.data.a aVar = com.stepos.digitalwellbeing.server.data.a.DAY;
                int i10 = i8 + 6;
                bundle.putParcelableArrayList("APP_USAGE_LIMIT_DATA_LIST", uR.t(aVar.ordinal(), i10));
                bundle.putParcelableArrayList("CATEGORY_USAGE_LIMIT_DATA_LIST", uR.q(aVar.ordinal(), i10));
                StatsDataSet[] statsDataSetArrU = uR.u();
                if (statsDataSetArrU != null && statsDataSetArrU.length >= 2) {
                    StatsDataSet statsDataSet3 = statsDataSetArrU[1];
                    StatsDataSet[] children = statsDataSet3 == null ? null : statsDataSet3.getChildren();
                    StatsDataSet statsDataSet4 = (children == null || i9 < 0 || i9 >= children.length) ? null : children[i9];
                    if (statsDataSet4 != null) {
                        bundle.putParcelable("STATS_DATA_SET", statsDataSet4);
                        long usingTime = 0;
                        if (i9 == 0) {
                            StatsDataSet statsDataSet5 = statsDataSetArrU[0];
                            StatsDataSet[] children2 = statsDataSet5 != null ? statsDataSet5.getChildren() : null;
                            if (children2 != null && children2.length > 0 && (statsDataSet2 = children2[children2.length - 1]) != null) {
                                usingTime = statsDataSet2.getUsingTime();
                                pickupTimes = statsDataSet2.getPickupTimes();
                                notifyTimes = statsDataSet2.getNotifyTimes();
                                int i11 = pickupTimes;
                                i7 = notifyTimes;
                                i6 = i11;
                            }
                            i6 = 0;
                        } else {
                            if (children != null && (i5 = i8 - 2) < children.length && (statsDataSet = children[i5]) != null) {
                                usingTime = statsDataSet.getUsingTime();
                                pickupTimes = statsDataSet.getPickupTimes();
                                notifyTimes = statsDataSet.getNotifyTimes();
                                int i112 = pickupTimes;
                                i7 = notifyTimes;
                                i6 = i112;
                            }
                            i6 = 0;
                        }
                        String strT = C0711p.t(statsDataSet4.getUsingTime());
                        String strT2 = C0711p.t(C0711p.l(statsDataSet4.getUsingTime()));
                        C0702g.b("AppWidgetManagerService", "real = " + strT);
                        C0702g.b("AppWidgetManagerService", "display = " + strT2);
                        bundle.putLong("USAGE_TIME", statsDataSet4.getUsingTime());
                        bundle.putLong("LAST_DAY_USAGE_TIME", usingTime);
                        bundle.putInt("NOTIFICATION_TIMES", statsDataSet4.getNotifyTimes());
                        bundle.putInt("LAST_NOTIFICATION_TIMES", i7);
                        bundle.putInt("PICKUP_TIMES", statsDataSet4.getPickupTimes());
                        bundle.putInt("LAST_PICKUP_TIMES", i6);
                        return bundle;
                    }
                }
            } else {
                p1 p1Var = (p1) this.f14481e;
                com.stepos.digitalwellbeing.server.data.a aVar2 = com.stepos.digitalwellbeing.server.data.a.DAY;
                UsingTimeStats[] usingTimeStatsArrV = p1Var.V(aVar2, dataToken);
                PickupTimesStats[] pickupTimesStatsArrT = p1Var.T(aVar2, dataToken);
                NotificationTimesStats[] notificationTimesStatsArrS = p1Var.S(aVar2, dataToken);
                ArrayList<? extends Parcelable> arrayList = (ArrayList) p1Var.Q(this, aVar2, dataToken);
                if (arrayList != null) {
                    pickupTimesStatsArr = pickupTimesStatsArrT;
                    Collections.sort(arrayList, new AbstractViewOnTouchListenerC0600i.a(P1.a.a()));
                } else {
                    pickupTimesStatsArr = pickupTimesStatsArrT;
                }
                ArrayList<? extends Parcelable> arrayList2 = (ArrayList) p1Var.R(this, aVar2, dataToken);
                if (arrayList2 != null) {
                    Collections.sort(arrayList2, new AbstractViewOnTouchListenerC0600i.b(P1.a.a()));
                }
                bundle.putParcelableArray("USING_TIME_STATS_ARRAY", usingTimeStatsArrV);
                bundle.putInt("PICKUP_TIMES", (int) C0712q.b(pickupTimesStatsArr));
                bundle.putInt("NOTIFICATION_TIMES", (int) C0712q.b(notificationTimesStatsArrS));
                bundle.putParcelableArrayList("APP_USAGE_LIMIT_DATA_LIST", arrayList);
                bundle.putParcelableArrayList("CATEGORY_USAGE_LIMIT_DATA_LIST", arrayList2);
                bundle.putBoolean("HAS_PERMISSIONS", true);
                bundle.putBoolean("DATA_ERROR", false);
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        return (this.f14483g == null || this.f14477a == null) ? false : true;
    }

    private boolean r() {
        return s(this);
    }

    private static boolean s(Context context) {
        UserManager userManager = (UserManager) context.getSystemService("user");
        return userManager == null || userManager.isUserUnlocked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(Boolean bool) {
        if (bool.booleanValue()) {
            C0702g.b("AppWidgetManagerService", "UsageStatsAndLimitLocalProxy init finish");
            if (this.f14484h) {
                x();
            }
            E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        g<Long> gVar = this.f14480d;
        if (gVar != null) {
            gVar.d(Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(g gVar) {
        this.f14480d = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle w(Long l5) {
        DataToken dataTokenU;
        try {
            C0702g.b("AppWidgetManagerService", "request data");
            p2.g.F();
            if (p2.g.x(this)) {
                if (!p2.g.u()) {
                    dataTokenU = new DataToken(0, 0L, 0);
                    dataTokenU.setInvalidType(-3);
                } else if (C0684b.A()) {
                    W0 w02 = (W0) this.f14481e;
                    if (w02.T()) {
                        PackageUtils.h(this).A();
                        dataTokenU = w02.O();
                        if (dataTokenU == null) {
                            dataTokenU = new DataToken(0, 0L, 0);
                            dataTokenU.setInvalidType(-2);
                            A();
                        }
                    } else {
                        dataTokenU = new DataToken(0, 0L, 0);
                        dataTokenU.setInvalidType(-4);
                    }
                } else {
                    PackageUtils.h(this).A();
                    dataTokenU = ((p1) this.f14481e).U(com.stepos.digitalwellbeing.server.data.a.DAY);
                    if (dataTokenU == null) {
                        dataTokenU = new DataToken(0, 0L, 0);
                        dataTokenU.setInvalidType(-2);
                    }
                }
            } else {
                if (!r()) {
                    C0702g.b("AppWidgetManagerService", "defer widget update until user is unlocked");
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("SKIP_UPDATE", true);
                    return bundle;
                }
                dataTokenU = new DataToken(0, 0L, 0);
                dataTokenU.setInvalidType(-1);
            }
            Bundle bundleP = p(dataTokenU);
            if (l5.longValue() == -1) {
                bundleP.putBoolean("FORCE_UPDATE", true);
            }
            return bundleP;
        } catch (Throwable th) {
            R1.a.b("AppWidgetManagerService", "widget request data failed: " + Log.getStackTraceString(th));
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("HAS_PERMISSIONS", true);
            bundle2.putBoolean("SUPPORT", true);
            bundle2.putBoolean("ENABLE", l.c1());
            bundle2.putBoolean("DATA_ERROR", true);
            if (l5.longValue() == -1) {
                bundle2.putBoolean("FORCE_UPDATE", true);
            }
            return bundle2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (!q()) {
            R1.a.l("AppWidgetManagerService", "skip recoverAllWidgets: service not initialized");
            return;
        }
        for (A a6 : A.values()) {
            if (a6 == A.UNKNOWN) {
                break;
            }
            j(a6);
        }
        C0702g.b("AppWidgetManagerService", "recoverAllWidgets: mAppWidgetMap = " + C0702g.m(this.f14478b));
    }

    public static void y(Context context) {
        if (context == null) {
            return;
        }
        if (ActivityManager.isUserAMonkey()) {
            R1.a.e("AppWidgetManagerService", "Monkey return recoverUpdate");
            return;
        }
        Log.e("AIOSBUG-4839-fix-v3", "recoverUpdate requested");
        try {
            Intent intent = new Intent();
            intent.setClass(context, AppWidgetManagerService.class);
            intent.setAction("com.stepos.familyguard.recover_update");
            if (C(context, intent)) {
                return;
            }
            i(context, intent);
        } catch (Exception e6) {
            R1.a.b("AppWidgetManagerService", "recoverUpdate failed: " + e6.getMessage());
        }
    }

    private static synchronized void z() {
        f14476n = 0L;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f14486j;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (T1.b.h()) {
            R1.a.e("AppWidgetManagerService", "Monkey return");
            return;
        }
        this.f14483g = m(this);
        Iterator<com.stepos.digitalwellbeing.appwidget.b> it = this.f14478b.values().iterator();
        while (it.hasNext()) {
            it.next().x(this.f14483g);
        }
        super.onConfigurationChanged(configuration);
        E();
        Iterator<com.stepos.digitalwellbeing.appwidget.b> it2 = this.f14478b.values().iterator();
        while (it2.hasNext()) {
            it2.next().s(this.f14482f);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (ActivityManager.isUserAMonkey()) {
            R1.a.e("AppWidgetManagerService", "Monkey return");
            return;
        }
        Context contextM = m(this);
        this.f14483g = contextM;
        contextM.setTheme(R.style.FamilyGuardAppTheme_AppWidgetContainerParent);
        this.f14477a = (AppWidgetManager) getSystemService("appwidget");
        C0702g.b("AppWidgetManagerService", "onCreate: config = " + getResources().getConfiguration().hashCode() + getResources().getConfiguration());
        if (C0684b.A()) {
            this.f14481e = new W0(new C1183b(this, false));
        } else {
            this.f14481e = new p1(new C1183b(this, true));
        }
        this.f14481e.b().h(this.f14487k);
        this.f14479c = f.F(f.h(new x3.h() { // from class: V1.e
            @Override // x3.h
            public final void a(x3.g gVar) {
                this.f5483a.v(gVar);
            }
        }, EnumC1285a.LATEST), f.A(1L, TimeUnit.MINUTES)).G(T3.a.c()).E(new D3.h() { // from class: V1.f
            @Override // D3.h
            public final Object apply(Object obj) {
                return this.f5484a.w((Long) obj);
            }
        }).G(C1347a.a()).M().f0();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f14485i.removeCallbacks(this.f14488l);
        AbstractC1182a abstractC1182a = this.f14481e;
        if (abstractC1182a != null) {
            abstractC1182a.b().l(this.f14487k);
            for (com.stepos.digitalwellbeing.appwidget.b bVar : this.f14478b.values()) {
                if (bVar != null) {
                    bVar.D();
                }
            }
            this.f14478b.clear();
            this.f14481e.I();
        }
        stopForeground(true);
        super.onDestroy();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        j.a().d();
        PackageUtils.h(this).y();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i5, int i6) {
        C0702g.b("AppWidgetManagerService", "onStartCommand() called with: intent = [" + intent + "], flags = [" + i5 + "], startId = [" + i6 + "]");
        C2.l.c(this, 1024);
        if (intent == null) {
            return 1;
        }
        if (ActivityManager.isUserAMonkey()) {
            R1.a.e("AppWidgetManagerService", "Monkey return");
            return super.onStartCommand(intent, i5, i6);
        }
        String action = intent.getAction();
        A a6 = A.values()[intent.getIntExtra("APP_WIDGET_TYPE", A.UNKNOWN.ordinal())];
        if (TextUtils.equals("android.appwidget.action.APPWIDGET_UPDATE", action)) {
            j(a6);
            E();
        } else if (TextUtils.equals("android.appwidget.action.APPWIDGET_ENABLED", action)) {
            j(a6);
        } else if (TextUtils.equals("android.appwidget.action.APPWIDGET_DISABLED", action) || TextUtils.equals("android.appwidget.action.APPWIDGET_DELETED", action)) {
            k(a6);
        } else if (TextUtils.equals("com.stepos.familyguard.recover_update", action)) {
            x();
            C0702g.b("AppWidgetManagerService", "onStartCommand: recovered mAppWidgetMap = " + C0702g.m(this.f14478b));
            E();
        } else if (TextUtils.equals("com.stepos.familyguard.force_update", action)) {
            x();
            E();
        } else if (TextUtils.equals("android.appwidget.action.APPWIDGET_UPDATE_OPTIONS", action)) {
            j(a6);
            E();
        }
        return 1;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i5) {
        super.onTrimMemory(i5);
        if (i5 >= 20) {
            j.a().e(i5);
            PackageUtils.h(this).y();
        }
    }
}
