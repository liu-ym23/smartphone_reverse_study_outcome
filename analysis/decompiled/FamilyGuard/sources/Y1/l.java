package Y1;

import F2.A;
import W1.c;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.usage.UsageStatsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import c2.C0582c;
import com.stepos.digitalwellbeing.DigitalWellbeingDataBase;
import com.stepos.digitalwellbeing.server.DigitalWellbeingService;
import com.stepos.digitalwellbeing.server.data.Category;
import com.stepos.digitalwellbeing.server.data.DataToken;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.digitalwellbeing.server.e;
import com.stepos.digitalwellbeing.server.limit.LimitApproachedReceiver;
import com.stepos.digitalwellbeing.server.limit.NextDayAlarmReceiver;
import com.stepos.digitalwellbeing.server.limit.data.room.CategoryLimit;
import com.stepos.digitalwellbeing.server.limit.data.room.GlobalLimit;
import com.stepos.digitalwellbeing.server.limit.data.room.PackageLimit;
import com.stepos.digitalwellbeing.server.limit.data.room.PeriodLimit;
import com.stepos.digitalwellbeing.server.limit.data.room.RawPeriod;
import com.stepos.digitalwellbeing.server.limit.data.room.RipePeriod;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import com.stepos.familyguard.R;
import com.stepos.familyguard.db.FamilyGuardDatabase;
import com.stepos.minor.Minor;
import com.stepos.minor.MinorDataBase;
import com.stepos.minor.WhitelistApp;
import e2.C0684b;
import e2.C0685c;
import f2.C0696a;
import f2.C0697b;
import f2.C0702g;
import f2.C0709n;
import f2.C0711p;
import f2.C0718w;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import k2.InterfaceC0801e;
import x3.AbstractC1286b;
import z3.C1347a;

/* loaded from: classes.dex */
public class l implements c.a {

    /* renamed from: E, reason: collision with root package name */
    public static final boolean f6423E = R1.a.f("LimitManager", R1.a.f4966b);

    /* renamed from: a, reason: collision with root package name */
    private final com.stepos.digitalwellbeing.server.limit.data.room.e f6428a;

    /* renamed from: b, reason: collision with root package name */
    private final com.stepos.digitalwellbeing.server.limit.data.room.a f6429b;

    /* renamed from: c, reason: collision with root package name */
    private final com.stepos.digitalwellbeing.server.limit.data.room.c f6430c;

    /* renamed from: d, reason: collision with root package name */
    private final com.stepos.digitalwellbeing.server.limit.data.room.g f6431d;

    /* renamed from: e, reason: collision with root package name */
    private final com.stepos.digitalwellbeing.server.limit.data.room.i f6432e;

    /* renamed from: f, reason: collision with root package name */
    private final com.stepos.digitalwellbeing.server.limit.data.room.k f6433f;

    /* renamed from: g, reason: collision with root package name */
    private final A f6434g;

    /* renamed from: h, reason: collision with root package name */
    private final PendingIntent f6435h;

    /* renamed from: i, reason: collision with root package name */
    private C0582c f6436i;

    /* renamed from: j, reason: collision with root package name */
    private Context f6437j;

    /* renamed from: k, reason: collision with root package name */
    private UsageStatsManager f6438k;

    /* renamed from: l, reason: collision with root package name */
    private C0684b f6439l;

    /* renamed from: m, reason: collision with root package name */
    private NotificationManager f6440m;

    /* renamed from: n, reason: collision with root package name */
    private PackageManager f6441n;

    /* renamed from: o, reason: collision with root package name */
    private AlarmManager f6442o;

    /* renamed from: p, reason: collision with root package name */
    private W1.c f6443p;

    /* renamed from: s, reason: collision with root package name */
    private MinorDataBase f6446s;

    /* renamed from: t, reason: collision with root package name */
    private DigitalWellbeingDataBase f6447t;

    /* renamed from: u, reason: collision with root package name */
    private C0685c f6448u;

    /* renamed from: x, reason: collision with root package name */
    private GlobalLimit f6451x;

    /* renamed from: y, reason: collision with root package name */
    public com.stepos.digitalwellbeing.server.e f6452y;

    /* renamed from: z, reason: collision with root package name */
    private stepos.support.v7.app.c f6453z;

    /* renamed from: q, reason: collision with root package name */
    private long f6444q = -1;

    /* renamed from: r, reason: collision with root package name */
    private boolean f6445r = false;

    /* renamed from: v, reason: collision with root package name */
    private boolean f6449v = true;

    /* renamed from: w, reason: collision with root package name */
    private final Map<Long, List<String>> f6450w = new ConcurrentHashMap();

    /* renamed from: A, reason: collision with root package name */
    private final AtomicBoolean f6424A = new AtomicBoolean(false);

    /* renamed from: B, reason: collision with root package name */
    private final ConcurrentHashMap<Long, A3.c> f6425B = new ConcurrentHashMap<>();

    /* renamed from: C, reason: collision with root package name */
    private final ConcurrentHashMap<String, Long> f6426C = new ConcurrentHashMap<>();

    /* renamed from: D, reason: collision with root package name */
    private final ConcurrentHashMap<String, Long> f6427D = new ConcurrentHashMap<>();

    public l(Context context, C0684b c0684b, W1.c cVar) {
        this.f6437j = context;
        this.f6439l = c0684b;
        this.f6441n = context.getPackageManager();
        this.f6438k = (UsageStatsManager) context.getSystemService("usagestats");
        this.f6447t = U1.a.c(this.f6437j).b();
        this.f6446s = F2.g.a(this.f6437j).b();
        this.f6428a = this.f6447t.B();
        this.f6429b = this.f6447t.t();
        this.f6430c = this.f6447t.u();
        this.f6431d = this.f6447t.w();
        this.f6432e = this.f6447t.x();
        this.f6433f = this.f6447t.y();
        this.f6434g = this.f6446s.u();
        this.f6442o = (AlarmManager) this.f6437j.getSystemService("alarm");
        this.f6440m = (NotificationManager) this.f6437j.getSystemService("notification");
        Intent intent = new Intent("com.stepos.digitalwellbeing.action.next_day", null, context, NextDayAlarmReceiver.class);
        intent.setPackage(this.f6437j.getApplicationContext().getPackageName());
        this.f6435h = PendingIntent.getBroadcast(context, 0, intent, 167772160);
        this.f6443p = cVar;
        cVar.D(this);
        this.f6448u = new C0685c(context.getApplicationContext());
        com.stepos.digitalwellbeing.server.e eVar = new com.stepos.digitalwellbeing.server.e();
        this.f6452y = eVar;
        eVar.z(new e.b() { // from class: Y1.d
            @Override // com.stepos.digitalwellbeing.server.e.b
            public final void a(String str) {
                this.f6401a.t1(str);
            }
        });
    }

    private void A(Bundle bundle) {
        long j5 = bundle.getLong("ripe_period_id", -1L);
        if (j5 >= 0) {
            B(j5);
        }
    }

    private long A0(PackageLimit packageLimit) {
        return B0(packageLimit, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A2, reason: merged with bridge method [inline-methods] */
    public void a1(Context context, int i5, boolean z5, boolean z6) {
        context.getString(C0718w.g().i() ? R.string.us_work_day : R.string.us_off_day);
        String string = context.getString(W1.c.m(i5));
        D2(new C2.b(N1.i.g(context), R.style.FamilyGuard_DigitalWellbeing_PreferenceActivity_AlertTheme_Blue).y(context.getString(R.string.us_app_cant_use)).n(z5 ? context.getString(R.string.us_category_total_limit_dialog_message, string) : z6 ? context.getString(R.string.us_category_overtime_period_limit_dialog_message, string) : context.getString(R.string.us_category_overtime_limit_dialog_message, string)).u(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: Y1.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                dialogInterface.dismiss();
            }
        }).c(), "categorySuspended:" + i5);
    }

    private void B(long j5) {
        A3.c cVarRemove = this.f6425B.remove(Long.valueOf(j5));
        if (cVarRemove == null || cVarRemove.g()) {
            return;
        }
        cVarRemove.dispose();
    }

    private synchronized long B0(PackageLimit packageLimit, boolean z5) throws Throwable {
        try {
            if (packageLimit == null) {
                return Long.MAX_VALUE;
            }
            try {
                long currentLimit = packageLimit.getCurrentLimit(this.f6437j);
                if (currentLimit == -1) {
                    return currentLimit;
                }
                return v0(packageLimit.getInterval(), packageLimit.getPackageName(), currentLimit, z5);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private synchronized boolean B1(CategoryLimit categoryLimit, CategoryLimit categoryLimit2) throws Throwable {
        l lVar;
        Throwable th;
        l lVar2;
        try {
            try {
                C0702g.b("LimitManager", "onUpdateCategoryLimit old = " + categoryLimit + " neww = " + categoryLimit2);
                if (categoryLimit.getCategoryId() != categoryLimit2.getCategoryId() || categoryLimit.getInterval() != categoryLimit2.getInterval() || categoryLimit.getId() != categoryLimit2.getId()) {
                    throw new IllegalArgumentException();
                }
                try {
                    if (!categoryLimit.equals(categoryLimit2)) {
                        if (categoryLimit.getWorkdayLimit() == categoryLimit2.getWorkdayLimit() && categoryLimit.getOffDayLimit() == categoryLimit2.getOffDayLimit()) {
                            lVar2 = this;
                        } else {
                            lVar2 = this;
                            lVar2.H(1, null, categoryLimit2.getCategoryId(), categoryLimit2.getAdminId());
                            lVar2.S2(lVar2.T(categoryLimit2.getCategoryId()));
                        }
                        lVar2.H1(categoryLimit.getId(), categoryLimit);
                        return true;
                    }
                    H1(categoryLimit.getId(), categoryLimit);
                } catch (Throwable th2) {
                    th = th2;
                    lVar = this;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            lVar = this;
            th = th;
            throw th;
        }
        return false;
    }

    private void B2(final Context context, final boolean z5, final boolean z6, final long j5, final boolean z7) {
        AbstractC1286b.b().e(C1347a.a()).h(new D3.a() { // from class: Y1.f
            @Override // D3.a
            public final void run() {
                this.f6407a.b1(context, z5, z6, j5, z7);
            }
        }, S1.a.b());
    }

    private void C(PeriodLimit periodLimit) {
        C0702g.b("LimitManager", "cancelRipePeriods periodLimit = " + periodLimit);
        for (RipePeriod ripePeriod : this.f6433f.b(periodLimit.getId())) {
            B(ripePeriod.getId());
            C0696a.q(ripePeriod);
            if (ripePeriod.getVersion() < periodLimit.getVersion()) {
                this.f6433f.a(ripePeriod.getId());
            }
        }
    }

    private static PendingIntent C0(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(P1.a.a().getPackageName(), "com.stepos.familyguard.ui.usage.UsageDirectActivity"));
        intent.putExtra("proxy", 0);
        intent.putExtra("operator_id", -1L);
        return PendingIntent.getActivity(context, 0, intent, 33554432);
    }

    private synchronized boolean C1(GlobalLimit globalLimit, GlobalLimit globalLimit2) throws Throwable {
        l lVar;
        Throwable th;
        l lVar2;
        try {
            try {
                C0702g.b("LimitManager", "onUpdateGlobalLimit old = " + globalLimit + " neww = " + globalLimit2);
                if (globalLimit.getInterval() != globalLimit2.getInterval() || globalLimit.getId() != globalLimit2.getId()) {
                    throw new IllegalArgumentException();
                }
                try {
                    if (!globalLimit.equals(globalLimit2)) {
                        if (globalLimit.getWorkdayLimit() == globalLimit2.getWorkdayLimit() && globalLimit.getOffDayLimit() == globalLimit2.getOffDayLimit()) {
                            lVar2 = this;
                        } else {
                            lVar2 = this;
                            lVar2.H(2, null, -1, globalLimit2.getAdminId());
                            lVar2.S2("g");
                        }
                        lVar2.J1(globalLimit);
                        return true;
                    }
                    J1(globalLimit);
                } catch (Throwable th2) {
                    th = th2;
                    lVar = this;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            lVar = this;
            th = th;
            throw th;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C2, reason: merged with bridge method [inline-methods] */
    public void b1(Context context, boolean z5, boolean z6, long j5, boolean z7) {
        stepos.support.v7.app.c cVar = this.f6453z;
        if (cVar != null && cVar.isShowing()) {
            this.f6453z.cancel();
        }
        String string = (!z7 || z6) ? (!z5 && z6) ? context.getString(R.string.mm_global_overtime_limit_dialog_message) : context.getString(R.string.mm_global_overtime_limit_dialog_message) : context.getString(R.string.mm_take_a_break, C0711p.m(this.f6437j, j5));
        stepos.support.v7.app.c cVarC = new C2.b(N1.i.g(context), R.style.FamilyGuard_DigitalWellbeing_PreferenceActivity_AlertTheme_Blue).y(string).u(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: Y1.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                dialogInterface.dismiss();
            }
        }).c();
        this.f6453z = cVarC;
        D2(cVarC, "globalSuspended");
    }

    private synchronized boolean D1(PackageLimit packageLimit, PackageLimit packageLimit2) throws Throwable {
        l lVar;
        Throwable th;
        l lVar2;
        try {
            try {
                if (!TextUtils.equals(packageLimit.getPackageName(), packageLimit2.getPackageName()) || packageLimit.getInterval() != packageLimit2.getInterval() || packageLimit.getId() != packageLimit2.getId()) {
                    throw new IllegalArgumentException();
                }
                try {
                    if (!packageLimit.equals(packageLimit2)) {
                        C0702g.b("LimitManager", "onUpdatePackageLimit old = " + packageLimit + " neww = " + packageLimit2);
                        if (packageLimit.getWorkdayLimit() == packageLimit2.getWorkdayLimit() && packageLimit.getOffDayLimit() == packageLimit2.getOffDayLimit()) {
                            lVar2 = this;
                        } else {
                            lVar2 = this;
                            lVar2.H(0, packageLimit2.getPackageName(), -1, packageLimit2.getAdminId());
                            lVar2.S2(lVar2.U(packageLimit2.getPackageName()));
                        }
                        lVar2.K1(packageLimit.getPackageName(), packageLimit, !packageLimit.isSuspended());
                        return true;
                    }
                    K1(packageLimit.getPackageName(), packageLimit, false);
                } catch (Throwable th2) {
                    th = th2;
                    lVar = this;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            lVar = this;
            th = th;
            throw th;
        }
        return false;
    }

    private void D2(stepos.support.v7.app.c cVar, String str) {
        if (cVar == null) {
            return;
        }
        if (!z(this.f6437j)) {
            C0702g.O("LimitManager", "showSystemOverlayDialog skipped, SYSTEM_ALERT_WINDOW not granted, reason=" + str);
            return;
        }
        try {
            r(cVar.getWindow());
            cVar.show();
        } catch (WindowManager.BadTokenException e6) {
            C0702g.p("LimitManager", "showSystemOverlayDialog BadTokenException, reason=" + str);
            C0702g.r("LimitManager", e6);
        } catch (RuntimeException e7) {
            C0702g.p("LimitManager", "showSystemOverlayDialog failed, reason=" + str);
            C0702g.r("LimitManager", e7);
        }
    }

    private void E0(PeriodLimit periodLimit) {
        if (periodLimit == null) {
            R1.a.b("LimitManager", "handleRipePeriods periodLimit = null");
            return;
        }
        long jC = this.f6433f.c(this.f6444q, periodLimit.getId());
        List<RawPeriod> listF = this.f6432e.f(periodLimit.getId(), 1);
        List<RawPeriod> listF2 = this.f6432e.f(periodLimit.getId(), 2);
        List<RawPeriod> listF3 = this.f6432e.f(periodLimit.getId(), 0);
        List<Z1.a> listP = C0709n.p(listF, listF3, 0);
        List<Z1.a> listP2 = C0709n.p(listF2, listF3, 1);
        List<Z1.a> listQ = C0709n.q(listF, listF2, 2);
        List<Z1.a> listQ2 = C0709n.q(listF2, listF, 3);
        List<Z1.a> listO = C0709n.o(listF3, -2);
        List<Z1.a> listM = C0709n.m(listQ, listO, 2);
        List<Z1.a> listM2 = C0709n.m(listQ2, listO, 3);
        if (listP != null) {
            S1(periodLimit, listP, jC);
        }
        if (listP2 != null) {
            S1(periodLimit, listP2, jC);
        }
        if (listM != null && listM.size() > 0 && listM.get(0).f6631c == 2) {
            S1(periodLimit, listM, jC);
        }
        if (listM2 == null || listM2.size() <= 0 || listM2.get(0).f6631c != 3) {
            return;
        }
        S1(periodLimit, listM2, jC);
    }

    private synchronized void E2(CategoryLimit categoryLimit) {
        int i5;
        long j5;
        long j6;
        long jMax;
        try {
            C0702g.b("LimitManager", "startWatchCategoryLimit categoryLimit = " + categoryLimit);
            if (categoryLimit == null) {
                return;
            }
            int categoryId = categoryLimit.getCategoryId();
            categoryLimit.setLastHandleTime(System.currentTimeMillis());
            long currentLimit = categoryLimit.getCurrentLimit(this.f6437j);
            long jX0 = currentLimit == 0 ? 0L : x0(categoryLimit, false);
            if (jX0 >= 0) {
                if (jX0 == 0 && categoryLimit.isEnable() && (!categoryLimit.isNotifyOnly() || categoryLimit.getCurrentLimit(this.f6437j) == 0)) {
                    boolean zIsSuspended = categoryLimit.isSuspended();
                    boolean z5 = currentLimit == 0;
                    categoryLimit.setSuspended(true);
                    this.f6429b.e(categoryLimit);
                    this.f6436i.f(categoryId, z5);
                    R1.a.a("LimitManager", "categoryLimit = " + categoryLimit + " setSuspended true");
                    if (zIsSuspended || categoryLimit.isNotifyOnly()) {
                        j5 = jX0;
                        i5 = 1;
                    } else {
                        Category categoryK = this.f6443p.k(categoryId);
                        i5 = 1;
                        j5 = jX0;
                        F1(1, categoryK == null ? null : this.f6437j.getString(categoryK.getNameResourceId()), null, currentLimit, 0, categoryLimit.getAdminId(), null, categoryId);
                    }
                } else {
                    i5 = 1;
                    j5 = jX0;
                    if (jX0 > 0) {
                        if (R0(T(categoryId))) {
                            C0702g.b("LimitManager", "startWatchCategoryLimit keep observer-expired suspend categoryId=" + categoryId + " remainingTime=" + j5);
                        } else {
                            if (categoryLimit.isSuspended()) {
                                categoryLimit.setSuspended(false);
                                this.f6429b.e(categoryLimit);
                            }
                            this.f6436i.K(categoryId);
                        }
                    }
                }
                if (categoryLimit.isWatched()) {
                    boolean zIsNotifyOnly = categoryLimit.isNotifyOnly();
                    if (zIsNotifyOnly) {
                        jMax = j5;
                        j6 = 0;
                    } else {
                        j6 = 0;
                        jMax = Math.max(0L, j5 - 60000);
                    }
                    if (zIsNotifyOnly && jMax == j6 && currentLimit > 0) {
                        Category categoryK2 = this.f6443p.k(categoryLimit.getCategoryId());
                        F1(1, categoryK2 != null ? this.f6437j.getString(categoryK2.getNameResourceId()) : null, null, currentLimit, 2, categoryLimit.getAdminId(), null, categoryLimit.getCategoryId());
                    } else if (zIsNotifyOnly || jMax != 0 || jX0 <= 0) {
                        Q(categoryLimit.getId(), categoryLimit.getCategoryId(), currentLimit, jMax, zIsNotifyOnly ? 2 : i5, true);
                    } else {
                        boolean zU2 = u2(1, null, categoryLimit.getCategoryId(), j5, currentLimit);
                        currentLimit = currentLimit;
                        if (zU2) {
                            Category categoryK3 = this.f6443p.k(categoryLimit.getCategoryId());
                            F1(1, categoryK3 != null ? this.f6437j.getString(categoryK3.getNameResourceId()) : null, null, currentLimit, 1, categoryLimit.getAdminId(), null, categoryLimit.getCategoryId());
                        } else {
                            C0702g.b("LimitManager", "startWatchCategoryLimit skip unused TYPE_NOTIFY categoryId=" + categoryLimit.getCategoryId() + " remainingTime=" + j5);
                        }
                    }
                    if (!zIsNotifyOnly) {
                        Q(categoryLimit.getId() + 1000, categoryLimit.getCategoryId(), currentLimit, j5, 0, true);
                    }
                }
            }
        } finally {
        }
    }

    private void F() {
        i0().edit().putLong("duration_expired_day", C0711p.y()).remove("duration_expired_keys").apply();
        C0702g.b("LimitManager", "clearDurationExpiredMarks");
    }

    private boolean F0() {
        List<PackageLimit> listA = this.f6428a.a(this.f6444q);
        if (listA != null) {
            Iterator<PackageLimit> it = listA.iterator();
            while (it.hasNext()) {
                if (W0(it.next())) {
                    return true;
                }
            }
        }
        List<CategoryLimit> listA2 = this.f6429b.a(this.f6444q);
        if (listA2 != null) {
            Iterator<CategoryLimit> it2 = listA2.iterator();
            while (it2.hasNext()) {
                if (U0(it2.next())) {
                    return true;
                }
            }
        }
        return V0(this.f6430c.c(this.f6444q));
    }

    private void F1(int i5, String str, String str2, long j5, int i6, long j6, String str3, int i7) {
        if (Q2(i5, str3, i7, j6, i6) || !(i6 == 2 || i6 == 1 || i6 == 0)) {
            Context context = this.f6437j;
            n.d(context, i5, str, str2, j5, i6, j6, C0(context));
            return;
        }
        C0702g.b("LimitManager", "postUsageLimitNotification skip duplicate reason=" + i5 + " packageName=" + str3 + " categoryId=" + i7 + " type=" + i6);
    }

    private synchronized void F2(GlobalLimit globalLimit) {
        G2(globalLimit, true);
    }

    private void G() {
        this.f6426C.clear();
        SharedPreferences sharedPreferencesL0 = l0();
        SharedPreferences.Editor editorEdit = sharedPreferencesL0.edit();
        for (String str : sharedPreferencesL0.getAll().keySet()) {
            if (str != null && str.startsWith("notify_only_sent_") && !str.startsWith("period_notify_only_sent_")) {
                editorEdit.remove(str);
            }
        }
        editorEdit.commit();
    }

    private static boolean G0(List<Z1.a> list, long j5) {
        if (list == null) {
            return false;
        }
        Iterator<Z1.a> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().b(j5)) {
                return true;
            }
        }
        return false;
    }

    private boolean G1(String str) {
        return false;
    }

    private synchronized void G2(GlobalLimit globalLimit, boolean z5) {
        long j5;
        int i5;
        long j6;
        long jMax;
        int i6;
        l lVar;
        boolean z6;
        try {
            C0702g.b("LimitManager", "startWatchGlobalLimit globalLimit = " + globalLimit);
            if (globalLimit == null) {
                return;
            }
            globalLimit.setLastHandleTime(System.currentTimeMillis());
            long currentLimit = globalLimit.getCurrentLimit(this.f6437j);
            long jZ0 = currentLimit == 0 ? 0L : z0(globalLimit, false);
            if (jZ0 >= 0) {
                if (jZ0 == 0 && globalLimit.isEnable() && (!globalLimit.isNotifyOnly() || globalLimit.getCurrentLimit(this.f6437j) == 0)) {
                    boolean zIsSuspended = globalLimit.isSuspended();
                    globalLimit.setSuspended(true);
                    this.f6430c.b(globalLimit);
                    this.f6436i.i(currentLimit == 0);
                    R1.a.a("LimitManager", "globalLimit = " + globalLimit + " setSuspended true");
                    if (zIsSuspended || globalLimit.isNotifyOnly()) {
                        j5 = jZ0;
                        i5 = 1;
                    } else {
                        i5 = 1;
                        j5 = jZ0;
                        F1(2, null, null, currentLimit, 0, this.f6444q, null, -1);
                    }
                } else {
                    j5 = jZ0;
                    i5 = 1;
                    if (jZ0 > 0) {
                        if (R0("g")) {
                            C0702g.b("LimitManager", "startWatchGlobalLimit keep observer-expired suspend remainingTime=" + j5);
                        } else {
                            if (globalLimit.isSuspended()) {
                                globalLimit.setSuspended(false);
                                this.f6430c.b(globalLimit);
                            }
                            if (!X0(globalLimit)) {
                                this.f6436i.N();
                            }
                        }
                    }
                }
                if (globalLimit.isWatched()) {
                    boolean zIsNotifyOnly = globalLimit.isNotifyOnly();
                    if (zIsNotifyOnly) {
                        jMax = j5;
                        j6 = 0;
                    } else {
                        j6 = 0;
                        jMax = Math.max(0L, j5 - 60000);
                    }
                    if (zIsNotifyOnly && jMax == j6 && currentLimit > 0) {
                        C0702g.b("LimitManager", "startWatchGlobalLimit notifyOnly already overtime, notify immediately, remainingTime=" + j5);
                        F1(2, null, null, currentLimit, 2, this.f6444q, null, -1);
                    } else if (zIsNotifyOnly || jMax != 0 || jZ0 <= 0) {
                        long j7 = jMax;
                        long id = globalLimit.getId();
                        if (zIsNotifyOnly) {
                            i6 = 2;
                            z6 = z5;
                            lVar = this;
                        } else {
                            i6 = i5;
                            lVar = this;
                            z6 = z5;
                        }
                        lVar.R(id, currentLimit, j7, i6, z6);
                        currentLimit = currentLimit;
                    } else {
                        boolean zU2 = u2(2, null, -1, j5, currentLimit);
                        currentLimit = currentLimit;
                        if (zU2) {
                            C0702g.b("LimitManager", "startWatchGlobalLimit already in notify window, notify immediately, remainingTime=" + j5);
                            F1(2, null, null, currentLimit, 1, this.f6444q, null, -1);
                        } else {
                            C0702g.b("LimitManager", "startWatchGlobalLimit skip unused TYPE_NOTIFY remainingTime=" + j5);
                        }
                    }
                    if (!zIsNotifyOnly) {
                        R(1000 + globalLimit.getId(), currentLimit, j5, 0, z5);
                    }
                }
            }
        } finally {
        }
    }

    private synchronized void H(int i5, String str, int i6, long j5) {
        I(i5, str, i6, j5, 1);
        I(i5, str, i6, j5, 0);
    }

    private boolean H0(long j5, long j6) {
        long jY = j5 - C0711p.y();
        C0702g.G("LimitManager", R1.a.f4965a);
        C0702g.M("LimitManager", "time=" + C0711p.F(jY) + ";  adminId=" + j6);
        PeriodLimit periodLimitE = this.f6431d.e(j6);
        C0702g.M("LimitManager", "periodLimit = " + periodLimitE + " time = " + C0711p.F(jY));
        if (periodLimitE == null || !periodLimitE.isEnable() || periodLimitE.isNotifyOnly()) {
            C0702g.M("LimitManager", "result=false");
            C0702g.G("LimitManager", R1.a.f4965a);
            return false;
        }
        List<RipePeriod> listE = this.f6433f.e(periodLimitE.getId(), periodLimitE.getVersion(), y());
        C0702g.M("LimitManager", "ripePeriodList=" + C0702g.k(listE));
        boolean zG0 = G0(e2(listE), jY);
        C0702g.M("LimitManager", "result=" + zG0);
        C0702g.G("LimitManager", R1.a.f4965a);
        return zG0;
    }

    private void H1(long j5, CategoryLimit categoryLimit) {
        CategoryLimit categoryLimitF = this.f6429b.f(j5);
        if (categoryLimitF == null) {
            return;
        }
        K2(categoryLimitF, categoryLimit);
        if (categoryLimitF.isEnable()) {
            E2(categoryLimitF);
        }
    }

    private synchronized void H2(PackageLimit packageLimit) {
        I2(packageLimit, false);
    }

    private synchronized void I(int i5, String str, int i6, long j5, int i7) {
        String strW = w(i5, str, i6, j5, i7);
        this.f6426C.remove(strW);
        Y1("notify_only_sent_" + f2(strW));
    }

    private boolean I0(long j5, long j6) {
        return J0(j5, j6, this.f6444q);
    }

    private synchronized void I1() {
        try {
            GlobalLimit globalLimitC = this.f6430c.c(this.f6444q);
            if (globalLimitC != null && globalLimitC.isEnable()) {
                F2(globalLimitC);
            }
            List<PackageLimit> listA = this.f6428a.a(this.f6444q);
            if (listA != null) {
                for (PackageLimit packageLimit : listA) {
                    if (packageLimit != null && packageLimit.isEnable()) {
                        H2(packageLimit);
                    }
                }
            }
            List<CategoryLimit> listA2 = this.f6429b.a(this.f6444q);
            if (listA2 != null) {
                for (CategoryLimit categoryLimit : listA2) {
                    if (categoryLimit != null && categoryLimit.isEnable()) {
                        E2(categoryLimit);
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void I2(PackageLimit packageLimit, boolean z5) {
        long j5;
        int i5;
        long j6;
        long jMax;
        if (packageLimit == null) {
            return;
        }
        try {
            String packageName = packageLimit.getPackageName();
            packageLimit.setLastHandleTime(System.currentTimeMillis());
            this.f6428a.d(packageLimit);
            long currentLimit = packageLimit.getCurrentLimit(this.f6437j);
            long jB0 = currentLimit == 0 ? 0L : B0(packageLimit, false);
            C0702g.b("LimitManager", "startWatchPackageLimit packageLimit = " + packageLimit + " remainingTime = " + jB0);
            if (jB0 >= 0) {
                if (jB0 == 0 && packageLimit.isEnable() && (!packageLimit.isNotifyOnly() || packageLimit.getCurrentLimit(this.f6437j) == 0)) {
                    boolean zIsSuspended = packageLimit.isSuspended();
                    boolean z6 = currentLimit == 0;
                    this.f6436i.d(packageName, z6);
                    packageLimit.setSuspended(true);
                    this.f6428a.d(packageLimit);
                    if (zIsSuspended || !z5 || packageLimit.isNotifyOnly()) {
                        j5 = jB0;
                        i5 = 1;
                    } else {
                        if (TextUtils.equals(b0(this.f6437j.getApplicationContext()), packageName)) {
                            x2(this.f6437j, packageName, z6, false);
                        }
                        i5 = 1;
                        j5 = jB0;
                        F1(0, null, PackageUtils.h(this.f6437j).m(packageName).label, currentLimit, 0, packageLimit.getAdminId(), packageName, -1);
                    }
                } else {
                    j5 = jB0;
                    i5 = 1;
                    if (jB0 > 0) {
                        if (R0(U(packageName))) {
                            C0702g.b("LimitManager", "startWatchPackageLimit keep observer-expired suspend package=" + packageName + " remainingTime=" + j5);
                        } else {
                            if (packageLimit.isSuspended()) {
                                packageLimit.setSuspended(false);
                                this.f6428a.d(packageLimit);
                            }
                            this.f6436i.I(packageName);
                        }
                    }
                }
                if (packageLimit.isWatched()) {
                    boolean zIsNotifyOnly = packageLimit.isNotifyOnly();
                    if (zIsNotifyOnly) {
                        jMax = j5;
                        j6 = 0;
                    } else {
                        j6 = 0;
                        jMax = Math.max(0L, j5 - 60000);
                    }
                    if (zIsNotifyOnly && jMax == j6 && currentLimit > 0) {
                        F1(0, null, PackageUtils.h(this.f6437j).m(packageLimit.getPackageName()).label, currentLimit, 2, packageLimit.getAdminId(), packageLimit.getPackageName(), -1);
                    } else if (zIsNotifyOnly || jMax != 0 || jB0 <= 0) {
                        S(packageLimit.getId(), packageLimit.getPackageName(), currentLimit, jMax, zIsNotifyOnly ? 2 : i5, true);
                    } else {
                        boolean zU2 = u2(0, packageLimit.getPackageName(), -1, j5, currentLimit);
                        currentLimit = currentLimit;
                        if (zU2) {
                            F1(0, null, PackageUtils.h(this.f6437j).m(packageLimit.getPackageName()).label, currentLimit, 1, packageLimit.getAdminId(), packageLimit.getPackageName(), -1);
                        } else {
                            C0702g.b("LimitManager", "startWatchPackageLimit skip unused TYPE_NOTIFY package=" + packageLimit.getPackageName() + " remainingTime=" + j5);
                        }
                    }
                    if (!zIsNotifyOnly) {
                        S(packageLimit.getId() + 1000, packageLimit.getPackageName(), currentLimit, j5, 0, true);
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private CategoryLimit J(int i5, int i6, long j5, long j6, boolean z5, boolean z6, long j7, boolean z7) {
        CategoryLimit categoryLimit = new CategoryLimit(i5, i6, j5, j6, 0, z5, z6, j7, z7);
        categoryLimit.setEnable(z5);
        categoryLimit.setSuspended(false);
        return categoryLimit;
    }

    private boolean J0(long j5, long j6, long j7) {
        long jY = j6 - C0711p.y();
        C0702g.G("LimitManager", R1.a.f4965a);
        C0702g.M("LimitManager", "categoryId = " + j5 + ";  time=" + C0711p.F(jY) + ";  adminId=" + j7);
        PeriodLimit periodLimitA = this.f6431d.a(j5, j7);
        StringBuilder sb = new StringBuilder();
        sb.append("periodLimit = ");
        sb.append(periodLimitA);
        sb.append(" time = ");
        sb.append(C0711p.F(jY));
        C0702g.M("LimitManager", sb.toString());
        if (periodLimitA == null || !periodLimitA.isEnable() || periodLimitA.isNotifyOnly()) {
            C0702g.M("LimitManager", "result=false");
            C0702g.G("LimitManager", R1.a.f4965a);
            return false;
        }
        List<RipePeriod> listD = this.f6433f.d(j7, j5, periodLimitA.getVersion(), y());
        C0702g.M("LimitManager", "ripePeriodList=" + C0702g.k(listD));
        boolean zG0 = G0(e2(listD), jY);
        C0702g.M("LimitManager", "result=" + zG0);
        C0702g.G("LimitManager", R1.a.f4965a);
        return zG0;
    }

    private void J1(GlobalLimit globalLimit) {
        GlobalLimit globalLimitC = this.f6430c.c(this.f6444q);
        if (globalLimitC == null) {
            return;
        }
        M2(globalLimitC, globalLimit);
        if (globalLimitC.isEnable()) {
            F2(globalLimitC);
        }
    }

    private synchronized void J2(CategoryLimit categoryLimit) {
        K2(categoryLimit, null);
    }

    private GlobalLimit K(int i5, long j5, long j6, boolean z5, boolean z6, long j7, boolean z7) {
        GlobalLimit globalLimit = new GlobalLimit(i5, j5, j6, 0, z5, z6, j7, z7);
        globalLimit.setEnable(z5);
        globalLimit.setSuspended(false);
        return globalLimit;
    }

    private boolean K0(String str, long j5) {
        return L0(str, j5, this.f6444q);
    }

    private void K1(String str, PackageLimit packageLimit, boolean z5) {
        PackageLimit packageLimitE = this.f6428a.e(str, this.f6444q);
        if (packageLimitE == null) {
            return;
        }
        O2(packageLimitE, packageLimit);
        if (packageLimitE.isEnable()) {
            I2(packageLimitE, z5);
        }
    }

    private synchronized void K2(CategoryLimit categoryLimit, CategoryLimit categoryLimit2) {
        try {
            C0702g.b("LimitManager", "stopWatchCategoryLimit categoryLimit = " + categoryLimit + " old = " + categoryLimit2);
            if (categoryLimit == null) {
                return;
            }
            int categoryId = categoryLimit.getCategoryId();
            boolean zIsWatched = categoryLimit2 == null ? categoryLimit.isWatched() : categoryLimit2.isWatched();
            if (categoryLimit.isSuspended()) {
                categoryLimit.setSuspended(false);
                this.f6429b.e(categoryLimit);
            }
            this.f6436i.K(categoryId);
            if (zIsWatched) {
                N(categoryLimit.getId());
                if (!(categoryLimit2 == null ? categoryLimit.isNotifyOnly() : categoryLimit2.isNotifyOnly())) {
                    N(categoryLimit.getId() + 1000);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private PackageLimit L(int i5, String str, long j5, long j6, boolean z5, boolean z6, long j7, boolean z7) {
        PackageLimit packageLimit = new PackageLimit(i5, str, j5, j6, 0, z5, z6, j7, z7);
        boolean zG1 = G1(str);
        boolean zP = PackageUtils.h(this.f6437j.getApplicationContext()).p(str);
        packageLimit.setEnable(z5);
        packageLimit.setSuspended(zG1);
        packageLimit.setInstalled(zP);
        return packageLimit;
    }

    private boolean L0(String str, long j5, long j6) {
        long jY = j5 - C0711p.y();
        C0702g.G("LimitManager", R1.a.f4965a);
        C0702g.M("LimitManager", "packageName = " + str + ";  time=" + C0711p.F(jY) + ";  adminId=" + j6);
        PeriodLimit periodLimitD = this.f6431d.d(str, j6);
        StringBuilder sb = new StringBuilder();
        sb.append("periodLimit = ");
        sb.append(periodLimitD);
        sb.append(" time = ");
        sb.append(C0711p.F(jY));
        C0702g.M("LimitManager", sb.toString());
        if (periodLimitD == null || !periodLimitD.isEnable() || periodLimitD.isNotifyOnly()) {
            C0702g.M("LimitManager", "result=false");
            C0702g.G("LimitManager", R1.a.f4965a);
            return false;
        }
        List<RipePeriod> listH = this.f6433f.h(j6, str, periodLimitD.getVersion(), y());
        C0702g.M("LimitManager", "ripePeriodList = " + C0702g.k(listH));
        boolean zG0 = G0(e2(listH), jY);
        C0702g.M("LimitManager", "result=" + zG0);
        C0702g.G("LimitManager", R1.a.f4965a);
        return zG0;
    }

    private synchronized void L1() throws Throwable {
        DataToken dataTokenG;
        l lVar;
        try {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                List<PackageLimit> listA = this.f6428a.a(this.f6444q);
                List<CategoryLimit> listA2 = this.f6429b.a(this.f6444q);
                GlobalLimit globalLimitC = this.f6430c.c(this.f6444q);
                boolean z5 = true;
                List<PeriodLimit> listH = this.f6431d.h(1, this.f6444q);
                List<PeriodLimit> listH2 = this.f6431d.h(0, this.f6444q);
                PeriodLimit periodLimitE = this.f6431d.e(this.f6444q);
                if (com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.c.t()) {
                    C0684b c0684b = this.f6439l;
                    com.stepos.digitalwellbeing.server.data.a aVar = com.stepos.digitalwellbeing.server.data.a.DAY;
                    dataTokenG = c0684b.H(aVar.ordinal(), U1(aVar.ordinal()));
                } else {
                    C0684b c0684b2 = this.f6439l;
                    com.stepos.digitalwellbeing.server.data.a aVar2 = com.stepos.digitalwellbeing.server.data.a.DAY;
                    dataTokenG = c0684b2.G(aVar2.ordinal(), U1(aVar2.ordinal()));
                }
                if (dataTokenG == null) {
                    R1.a.b("LimitManager", "onemind data not prepared");
                    return;
                }
                C0702g.E("LimitManager", R1.a.f4966b);
                C0702g.b("LimitManager", "reHandleLimit");
                if (globalLimitC == null && ((listA == null || listA.isEmpty()) && ((listA2 == null || listA2.isEmpty()) && periodLimitE == null && ((listH2 == null || listH2.isEmpty()) && (listH == null || listH.isEmpty()))))) {
                    C0702g.b("LimitManager", "No limits need to be handle");
                    p2(System.currentTimeMillis());
                    C0702g.D("LimitManager", R1.a.f4966b);
                    return;
                }
                boolean zW2 = w2();
                C0702g.b("LimitManager", "shouldReset=" + zW2);
                if (zW2 || !C0697b.n()) {
                    z5 = zW2;
                } else {
                    C0702g.b("LimitManager", "clock jump sanitize: force reset suspend for current calendar day");
                }
                if (z5) {
                    F();
                }
                if (z5) {
                    G();
                }
                C0702g.K("LimitManager", R1.a.f4966b);
                if (globalLimitC != null) {
                    C0702g.b("LimitManager", "处理整机时长限用");
                    if (z5 && (globalLimitC.isSuspended() || globalLimitC.getLastHandleTime() < C0711p.y())) {
                        C0702g.b("LimitManager", "需要停止来重置");
                        L2(globalLimitC);
                    }
                    if (globalLimitC.isEnable()) {
                        C0702g.b("LimitManager", "重新监控");
                        F2(globalLimitC);
                    }
                }
                if (listA2 != null) {
                    C0702g.K("LimitManager", R1.a.f4966b);
                    C0702g.b("LimitManager", "处理类型时长限用");
                    for (CategoryLimit categoryLimit : listA2) {
                        if (categoryLimit != null) {
                            C0702g.b("LimitManager", "处理: categoryLimit=" + categoryLimit);
                            if (z5 && (categoryLimit.isSuspended() || categoryLimit.getLastHandleTime() < C0711p.y())) {
                                C0702g.b("LimitManager", "需要停止来重置");
                                J2(categoryLimit);
                            }
                            if (categoryLimit.isEnable()) {
                                C0702g.b("LimitManager", "重新监控");
                                E2(categoryLimit);
                            }
                            C0702g.G("LimitManager", R1.a.f4966b);
                        }
                    }
                }
                C0702g.G("LimitManager", R1.a.f4966b);
                C0702g.b("LimitManager", "处理应用时长限用");
                if (listA != null) {
                    for (PackageLimit packageLimit : listA) {
                        if (packageLimit != null) {
                            C0702g.b("LimitManager", "处理: packageLimit=" + packageLimit);
                            if (z5 && (packageLimit.isSuspended() || packageLimit.getLastHandleTime() < C0711p.y())) {
                                C0702g.b("LimitManager", "需要停止来重置");
                                N2(packageLimit);
                            }
                            if (packageLimit.isEnable()) {
                                C0702g.b("LimitManager", "重新监控");
                                H2(packageLimit);
                            }
                            C0702g.G("LimitManager", R1.a.f4966b);
                        }
                    }
                }
                C0702g.K("LimitManager", R1.a.f4966b);
                if (periodLimitE != null) {
                    C0702g.b("LimitManager", "处理整机时段限用");
                    C0702g.b("LimitManager", "处理: periodLimit=" + periodLimitE);
                    s(periodLimitE);
                    lVar = this;
                    lVar.M1(periodLimitE, jCurrentTimeMillis, this.f6444q);
                    C0702g.G("LimitManager", R1.a.f4966b);
                } else {
                    lVar = this;
                }
                if (listH != null) {
                    C0702g.K("LimitManager", R1.a.f4966b);
                    C0702g.b("LimitManager", "处理类型时段限用");
                    for (PeriodLimit periodLimit : listH) {
                        C0702g.b("LimitManager", "处理: periodLimit=" + periodLimit);
                        lVar.s(periodLimit);
                        lVar.M1(periodLimit, jCurrentTimeMillis, lVar.f6444q);
                        C0702g.G("LimitManager", R1.a.f4966b);
                    }
                }
                if (listH2 != null) {
                    C0702g.K("LimitManager", R1.a.f4966b);
                    C0702g.b("LimitManager", "处理应用时段限用");
                    for (PeriodLimit periodLimit2 : listH2) {
                        C0702g.b("LimitManager", "处理: periodLimit=" + periodLimit2);
                        lVar.s(periodLimit2);
                        lVar.M1(periodLimit2, jCurrentTimeMillis, lVar.f6444q);
                        C0702g.G("LimitManager", R1.a.f4966b);
                    }
                }
                lVar.p2(System.currentTimeMillis());
                C0702g.D("LimitManager", R1.a.f4966b);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private synchronized void L2(GlobalLimit globalLimit) {
        M2(globalLimit, null);
    }

    private void M(PeriodLimit periodLimit, RipePeriod ripePeriod) throws Throwable {
        Bundle bundleU = u(periodLimit, ripePeriod);
        int type = ripePeriod.getType();
        if (type == 0) {
            x1(bundleU);
            y1(bundleU, 0);
            return;
        }
        if (type == 1) {
            z1(bundleU);
            return;
        }
        if (type == 2) {
            y1(bundleU, 1);
            return;
        }
        if (type == 3) {
            y1(bundleU, 2);
            return;
        }
        C0702g.O("LimitManager", "unsupported in-process period type=" + ripePeriod.getType());
    }

    private boolean M0(PeriodLimit periodLimit, long j5, long j6) {
        List<RawPeriod> listB;
        int weekDayType;
        if (periodLimit != null && (listB = this.f6432e.b(periodLimit.getId())) != null && !listB.isEmpty()) {
            long jY = j6 - C0711p.y();
            boolean zI = C0718w.g().i();
            for (RawPeriod rawPeriod : listB) {
                if (rawPeriod.getStart() == j5 && ((weekDayType = rawPeriod.getWeekDayType()) == 0 || ((zI && weekDayType == 1) || (!zI && weekDayType == 2)))) {
                    long start = rawPeriod.getStart();
                    long end = rawPeriod.getEnd();
                    if (end <= start) {
                        end += 86400000;
                    }
                    if (new Z1.a(start, end, -2).b(jY)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private synchronized void M1(PeriodLimit periodLimit, long j5, long j6) throws Throwable {
        l lVar;
        Throwable th;
        l lVar2;
        try {
            try {
                C0702g.b("LimitManager", "reSuspendPeriod() called with: periodLimit = [" + periodLimit + "]");
            } catch (Throwable th2) {
                th = th2;
                th = th;
                throw th;
            }
            try {
                if (periodLimit != null) {
                    if (periodLimit.getType() == 0) {
                        String packageName = periodLimit.getPackageName();
                        if (periodLimit.isEnable() && L0(packageName, j5, j6)) {
                            this.f6436i.c(packageName, false);
                        } else {
                            this.f6436i.H(packageName);
                        }
                        lVar2 = this;
                    } else if (periodLimit.getType() == 1) {
                        long categoryId = periodLimit.getCategoryId();
                        if (periodLimit.isEnable()) {
                            lVar2 = this;
                            if (lVar2.J0(categoryId, j5, j6)) {
                                lVar2.f6436i.e(categoryId, false);
                            }
                        } else {
                            lVar2 = this;
                        }
                        lVar2.f6436i.J(categoryId);
                    } else {
                        lVar2 = this;
                        if (periodLimit.getType() == 2) {
                            if (periodLimit.isEnable() && lVar2.H0(j5, j6)) {
                                lVar2.f6436i.h(false);
                            } else {
                                lVar2.f6436i.M();
                            }
                        }
                    }
                    return;
                }
                C0702g.O("LimitManager", "periodLimit = null");
            } catch (Throwable th3) {
                th = th3;
                lVar = this;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            lVar = this;
            th = th;
            throw th;
        }
    }

    private synchronized void M2(GlobalLimit globalLimit, GlobalLimit globalLimit2) {
        try {
            C0702g.b("LimitManager", "stopWatchGlobalLimit globalLimit = " + globalLimit + " old = " + globalLimit2);
            if (globalLimit == null) {
                return;
            }
            boolean zIsWatched = globalLimit2 == null ? globalLimit.isWatched() : globalLimit2.isWatched();
            if (globalLimit.isSuspended()) {
                globalLimit.setSuspended(false);
                this.f6430c.b(globalLimit);
            }
            if (!X0(globalLimit)) {
                this.f6436i.N();
            }
            if (zIsWatched) {
                O(globalLimit.getId());
                if (!(globalLimit2 == null ? globalLimit.isNotifyOnly() : globalLimit2.isNotifyOnly())) {
                    O(globalLimit.getId() + 1000);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void N(long j5) {
        long j6 = j5 + 2000;
        C0702g.b("LimitManager", "doStopWatchCategoryLimit id = " + j6);
        T2(this.f6438k, (int) j6);
    }

    private boolean N0(PeriodLimit periodLimit, long j5) {
        List<RawPeriod> listB;
        if (periodLimit != null && (listB = this.f6432e.b(periodLimit.getId())) != null && !listB.isEmpty()) {
            long jY = j5 - C0711p.y();
            boolean zI = C0718w.g().i();
            for (RawPeriod rawPeriod : listB) {
                int weekDayType = rawPeriod.getWeekDayType();
                if (weekDayType == 0 || ((zI && weekDayType == 1) || (!zI && weekDayType == 2))) {
                    long start = rawPeriod.getStart();
                    long end = rawPeriod.getEnd();
                    if (end <= start) {
                        end += 86400000;
                    }
                    if (new Z1.a(start, end, -2).b(jY)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void N1(long j5) {
        C0702g.b("LimitManager", "reWatchGlobalNotify() called admin = " + j5);
        try {
            O(999L);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        if (!com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.c.t()) {
            C0702g.O("LimitManager", "reWatchGlobalNotify skip: alphame version not support this operation");
            return;
        }
        C0684b c0684b = this.f6439l;
        com.stepos.digitalwellbeing.server.data.a aVar = com.stepos.digitalwellbeing.server.data.a.DAY;
        DataToken dataTokenH = c0684b.H(aVar.ordinal(), U1(aVar.ordinal()));
        if (dataTokenH == null) {
            C0702g.p("LimitManager", "getRemainingTime token == null");
            return;
        }
        long jM = this.f6439l.m(aVar.ordinal(), dataTokenH);
        C0702g.b("LimitManager", "reWatchGlobalNotify() called usingTime = " + C0711p.t(jM));
        if (!DigitalWellbeingService.A(j5)) {
            L2(this.f6451x);
            this.f6451x = null;
            return;
        }
        GlobalLimit globalLimit = this.f6451x;
        if (globalLimit == null) {
            long j6 = jM + 1800000;
            GlobalLimit globalLimit2 = new GlobalLimit(aVar.ordinal(), j6, j6, 0, true, true, j5, true);
            this.f6451x = globalLimit2;
            globalLimit2.setId(999L);
            G2(this.f6451x, false);
            return;
        }
        if (globalLimit.getAdminId() != j5) {
            L2(this.f6451x);
            long j7 = jM + 1800000;
            GlobalLimit globalLimit3 = new GlobalLimit(aVar.ordinal(), j7, j7, 0, true, true, j5, true);
            this.f6451x = globalLimit3;
            globalLimit3.setId(999L);
            G2(this.f6451x, false);
        }
    }

    private synchronized void N2(PackageLimit packageLimit) {
        O2(packageLimit, null);
    }

    private synchronized void O(long j5) {
        long j6 = j5 + 4000;
        C0702g.b("LimitManager", "doStopWatchGlobalLimit id = " + j6);
        T2(this.f6438k, (int) j6);
    }

    private void O1(int i5, long j5, String str, int i6, long j6, long j7) {
        if (j7 <= 60000) {
            C0702g.b("LimitManager", "reWatchUnusedNotifyApproach skip in-window unused reason=" + i5 + " remainingTime=" + j7);
            return;
        }
        long j8 = j7 - 60000;
        if (j8 <= 0) {
            return;
        }
        if (i5 == 0) {
            S(j5, str, j6, j8, 1, true);
        } else if (i5 == 1) {
            Q(j5, i6, j6, j8, 1, true);
        } else {
            R(j5, j6, j8, 1, true);
        }
    }

    private synchronized void O2(PackageLimit packageLimit, PackageLimit packageLimit2) {
        try {
            C0702g.b("LimitManager", "stopWatchPackageLimit PackageLimit = " + packageLimit + " old = " + packageLimit2);
            if (packageLimit == null) {
                return;
            }
            String packageName = packageLimit.getPackageName();
            boolean zIsWatched = packageLimit2 == null ? packageLimit.isWatched() : packageLimit2.isWatched();
            if (packageLimit.isSuspended()) {
                packageLimit.setSuspended(false);
                this.f6428a.d(packageLimit);
            }
            this.f6436i.I(packageName);
            if (zIsWatched) {
                P(packageLimit.getId());
                if (!(packageLimit2 == null ? packageLimit.isNotifyOnly() : packageLimit2.isNotifyOnly())) {
                    P(packageLimit.getId() + 1000);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void P(long j5) {
        C0702g.b("LimitManager", "doStopWatchPackageLimit id = " + j5);
        T2(this.f6438k, (int) j5);
    }

    private long P1(String str) throws IOException {
        File file = new File(k0(), str);
        if (!file.isFile()) {
            return 0L;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                String line = bufferedReader.readLine();
                if (line != null && !line.isEmpty()) {
                    long j5 = Long.parseLong(line.trim());
                    bufferedReader.close();
                    return j5;
                }
                bufferedReader.close();
                return 0L;
            } finally {
            }
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2 */
    private synchronized boolean P2(int i5, String str, long j5, long j6, long j7, int i6) throws Throwable {
        Throwable th;
        l lVar;
        l lVar2;
        try {
            try {
                String strV = v(i5, str, j5, j6, j7, i6);
                long jY = C0711p.y();
                Long l5 = this.f6427D.get(strV);
                if (l5 != null) {
                    try {
                        if (l5.longValue() >= jY) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        lVar = this;
                        throw th;
                    }
                }
                String str2 = "period_notify_only_sent_" + f2(strV);
                long jQ1 = Q1(str2);
                if (jQ1 < jY) {
                    lVar2 = this;
                    jQ1 = lVar2.W(str, j5, j7, jY);
                    if (jQ1 >= jY) {
                        lVar2.Z2(str2, jQ1);
                    }
                } else {
                    lVar2 = this;
                }
                if (jQ1 >= jY) {
                    lVar2.f6427D.put(strV, Long.valueOf(jQ1));
                    return false;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                lVar2.f6427D.put(strV, Long.valueOf(jCurrentTimeMillis));
                if (!lVar2.Z2(str2, jCurrentTimeMillis)) {
                    Log.e("LimitManager", "tryAcquirePeriodNotifyOnlySlot persist failed key=" + strV);
                }
                return true;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                lVar = str;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            str = this;
            th = th;
            lVar = str;
            throw th;
        }
        return false;
    }

    private synchronized void Q(long j5, int i5, long j6, long j7, int i6, boolean z5) {
        C0702g.b("LimitManager", "startWatchCategoryLimit id = " + j5 + " limitTime = " + C0711p.m(this.f6437j, j6) + " categoryId = " + i5 + " remainingTime = " + C0711p.m(this.f6437j, j7) + " type = " + i6);
        Category categoryK = this.f6443p.k(i5);
        if (categoryK == null) {
            return;
        }
        if (j7 == 0) {
            C0702g.b("LimitManager", "remainingTime = 0 return, type = " + i6);
            return;
        }
        long j8 = j5 + 2000;
        List<String> packages = categoryK.getPackages();
        String[] strArr = new String[packages.size()];
        packages.toArray(strArr);
        Intent intent = new Intent("com.stepos.digitalwellbeing.action.limit_approached", null, this.f6437j, LimitApproachedReceiver.class);
        intent.setPackage(this.f6437j.getPackageName());
        intent.putExtra("packages", strArr);
        intent.putExtra("reason", 1);
        intent.putExtra("type", i6);
        int i7 = (int) j8;
        intent.putExtra(Minor.COLUMN_ID, i7);
        intent.putExtra("category_id", i5);
        intent.putExtra("limit_time", j6);
        intent.putExtra("start_watch_time", System.currentTimeMillis());
        V1(this.f6438k, i7, strArr, 3, j7, TimeUnit.MILLISECONDS, PendingIntent.getBroadcast(this.f6437j, i7, intent, 167772160), z5);
    }

    private long Q1(String str) {
        long j5 = l0().getLong(str, 0L);
        if (j5 > 0) {
            return j5;
        }
        long j6 = this.f6437j.getApplicationContext().getSharedPreferences("limit_notify_dedup", 0).getLong(str, 0L);
        if (j6 <= 0) {
            return P1(str);
        }
        Z2(str, j6);
        return j6;
    }

    private synchronized boolean Q2(int i5, String str, int i6, long j5, int i7) {
        String strW = w(i5, str, i6, j5, i7);
        long jY = C0711p.y();
        Long l5 = this.f6426C.get(strW);
        if (l5 != null && l5.longValue() >= jY) {
            return false;
        }
        String str2 = "notify_only_sent_" + f2(strW);
        long jQ1 = Q1(str2);
        if (jQ1 >= jY) {
            this.f6426C.put(strW, Long.valueOf(jQ1));
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f6426C.put(strW, Long.valueOf(jCurrentTimeMillis));
        if (!Z2(str2, jCurrentTimeMillis)) {
            Log.e("LimitManager", "tryAcquireUsageNotifyOnlySlot persist failed key=" + strW);
        }
        return true;
    }

    private synchronized void R(long j5, long j6, long j7, int i5, boolean z5) {
        C0702g.b("LimitManager", "doWatchGlobalLimit id = " + j5 + " limitTime = " + C0711p.m(this.f6437j, j6) + " remainingTime = " + C0711p.m(this.f6437j, j7) + " type = " + i5);
        if (j7 == 0) {
            C0702g.b("LimitManager", "remainingTime = 0 return, type = " + i5);
            return;
        }
        long j8 = j5 + 4000;
        List<String> listF = PackageUtils.h(this.f6437j).f();
        String[] strArr = new String[listF.size()];
        listF.toArray(strArr);
        Intent intent = new Intent("com.stepos.digitalwellbeing.action.limit_approached", null, this.f6437j, LimitApproachedReceiver.class);
        intent.setPackage(this.f6437j.getPackageName());
        intent.putExtra("packages", strArr);
        intent.putExtra("reason", 2);
        intent.putExtra("type", i5);
        int i6 = (int) j8;
        intent.putExtra(Minor.COLUMN_ID, i6);
        intent.putExtra("limit_time", j6);
        intent.putExtra("start_watch_time", System.currentTimeMillis());
        V1(this.f6438k, i6, strArr, 2, j7, TimeUnit.MILLISECONDS, PendingIntent.getBroadcast(this.f6437j, i6, intent, 167772160), z5);
    }

    private boolean R0(String str) {
        V();
        Set<String> stringSet = i0().getStringSet("duration_expired_keys", Collections.EMPTY_SET);
        return stringSet != null && stringSet.contains(str);
    }

    public static void R1(boolean z5) {
        androidx.preference.j.b(P1.a.a()).edit().putBoolean("digital_wellbeing_enable", z5).apply();
    }

    private void R2(PeriodLimit periodLimit, RipePeriod ripePeriod) throws Throwable {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long time = ripePeriod.getTime() + C0711p.y();
        if (time > C0711p.x()) {
            time -= 86400000;
        }
        if (jCurrentTimeMillis < time) {
            return;
        }
        if (!periodLimit.isNotifyOnly() && ripePeriod.getType() == 0) {
            if (N0(periodLimit, jCurrentTimeMillis)) {
                C0702g.b("LimitManager", "tryHandleMissedPeriodLock periodLimit=" + periodLimit + " ripePeriod=" + ripePeriod);
                M(periodLimit, ripePeriod);
                return;
            }
            return;
        }
        if (periodLimit.isNotifyOnly() && ripePeriod.getType() == 3) {
            if (!M0(periodLimit, ripePeriod.getTime(), jCurrentTimeMillis)) {
                P2(periodLimit.getType(), periodLimit.getPackageName(), periodLimit.getCategoryId(), periodLimit.getAdminId(), ripePeriod.getTime(), 2);
                C0702g.b("LimitManager", "tryNotifyMissedPeriodApproach mark-only outside own window ripePeriod=" + ripePeriod);
                return;
            }
            C0702g.b("LimitManager", "tryNotifyMissedPeriodApproach periodLimit=" + periodLimit + " ripePeriod=" + ripePeriod);
            M(periodLimit, ripePeriod);
        }
    }

    private synchronized void S(long j5, String str, long j6, long j7, int i5, boolean z5) {
        C0702g.b("LimitManager", "doWatchPackageLimit id = " + j5 + " packageName = " + str + " limitTime = " + C0711p.m(this.f6437j, j6) + " remainingTime = " + C0711p.m(this.f6437j, j7) + " type = " + i5);
        if (j7 == 0) {
            C0702g.b("LimitManager", "remainingTime = 0 return, type = " + i5);
            return;
        }
        Intent intent = new Intent("com.stepos.digitalwellbeing.action.limit_approached", null, this.f6437j, LimitApproachedReceiver.class);
        intent.setPackage(this.f6437j.getPackageName());
        intent.putExtra("packages", new String[]{str});
        intent.putExtra("reason", 0);
        intent.putExtra("type", i5);
        int i6 = (int) j5;
        intent.putExtra(Minor.COLUMN_ID, i6);
        intent.putExtra("limit_time", j6);
        intent.addFlags(32);
        intent.putExtra("start_watch_time", System.currentTimeMillis());
        V1(this.f6438k, i6, new String[]{str}, 1, j7, TimeUnit.MILLISECONDS, PendingIntent.getBroadcast(this.f6437j, i6, intent, 167772160), z5);
    }

    private void S1(PeriodLimit periodLimit, List<Z1.a> list, long j5) {
        for (Z1.a aVar : list) {
            if (periodLimit.isNotifyOnly()) {
                this.f6433f.f(C0709n.i(periodLimit, aVar, 3, j5));
            } else {
                this.f6433f.f(C0709n.i(periodLimit, aVar, 0, j5));
                if (!aVar.g()) {
                    RipePeriod ripePeriodI = C0709n.i(periodLimit, aVar, 1, j5);
                    RipePeriod ripePeriodI2 = C0709n.i(periodLimit, aVar, 2, j5);
                    this.f6433f.f(ripePeriodI);
                    this.f6433f.f(ripePeriodI2);
                }
            }
        }
    }

    private void S2(String str) {
        SharedPreferences sharedPreferencesI0 = i0();
        HashSet hashSet = new HashSet(sharedPreferencesI0.getStringSet("duration_expired_keys", Collections.EMPTY_SET));
        if (hashSet.remove(str)) {
            sharedPreferencesI0.edit().putStringSet("duration_expired_keys", hashSet).apply();
            C0702g.b("LimitManager", "unmarkDurationExpired key=" + str);
        }
    }

    private String T(int i5) {
        return "c:" + i5;
    }

    public static boolean T0(String str) {
        return !Arrays.asList(PackageUtils.f14710i).contains(str);
    }

    private void T2(UsageStatsManager usageStatsManager, int i5) {
        C0702g.b("LimitManager", "unregisterAppUsageObserver observerId = " + i5);
        this.f6452y.C(i5);
    }

    private String U(String str) {
        return "p:" + str;
    }

    private boolean U0(CategoryLimit categoryLimit) throws Throwable {
        if (categoryLimit == null || !categoryLimit.isEnable() || categoryLimit.isNotifyOnly() || !categoryLimit.isSuspended() || categoryLimit.getCurrentLimit(this.f6437j) <= 0) {
            return false;
        }
        long jX0 = x0(categoryLimit, false);
        if (jX0 <= 0 || R0(T(categoryLimit.getCategoryId()))) {
            return false;
        }
        C0702g.O("LimitManager", "stale duration suspend category=" + categoryLimit.getCategoryId() + " remainingTime=" + jX0);
        return true;
    }

    private boolean U1(int i5) {
        boolean andSet = this.f6424A.getAndSet(false);
        DataToken dataTokenY = this.f6439l.y(i5);
        if (dataTokenY == null) {
            C0702g.b("LimitManager", "refreshUsageStats: token = null return false");
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long updateTime = dataTokenY.getUpdateTime();
        boolean z5 = jCurrentTimeMillis - updateTime >= 1000 || andSet;
        C0702g.b("LimitManager", "refreshUsageStats: updateTime = " + C0711p.j(updateTime) + " now = " + C0711p.j(jCurrentTimeMillis) + " result = " + z5);
        return z5;
    }

    private void V() {
        SharedPreferences sharedPreferencesI0 = i0();
        long jY = C0711p.y();
        if (sharedPreferencesI0.getLong("duration_expired_day", 0L) != jY) {
            sharedPreferencesI0.edit().putLong("duration_expired_day", jY).remove("duration_expired_keys").apply();
        }
    }

    private boolean V0(GlobalLimit globalLimit) {
        if (globalLimit == null || !globalLimit.isEnable() || globalLimit.isNotifyOnly() || !globalLimit.isSuspended() || globalLimit.getCurrentLimit(this.f6437j) <= 0) {
            return false;
        }
        long jZ0 = z0(globalLimit, false);
        if (jZ0 <= 0 || R0("g")) {
            return false;
        }
        C0702g.O("LimitManager", "stale duration suspend global remainingTime=" + jZ0);
        return true;
    }

    private void V1(UsageStatsManager usageStatsManager, int i5, String[] strArr, int i6, long j5, TimeUnit timeUnit, PendingIntent pendingIntent, boolean z5) {
        C0702g.b("LimitManager", "registerAppUsageObserver observerId = " + i5 + " packages = " + C0702g.h(strArr) + " timeLimit = " + j5 + " timeUnit = " + timeUnit);
        this.f6452y.w(i5, strArr, i6, j5, pendingIntent, z5);
    }

    private long W(String str, long j5, long j6, long j7) {
        String str2;
        if (str != null) {
            str2 = "." + str + ".";
        } else {
            str2 = null;
        }
        String str3 = "." + j5 + ".";
        String str4 = "." + j6 + ".";
        String str5 = str2;
        return Math.max(Math.max(0L, g2(l0(), str5, str3, str4, j7)), g2(this.f6437j.getApplicationContext().getSharedPreferences("limit_notify_dedup", 0), str5, str3, str4, j7));
    }

    private boolean W0(PackageLimit packageLimit) throws Throwable {
        if (packageLimit == null || !packageLimit.isEnable() || packageLimit.isNotifyOnly() || !packageLimit.isSuspended() || packageLimit.getCurrentLimit(this.f6437j) <= 0) {
            return false;
        }
        long jB0 = B0(packageLimit, false);
        if (jB0 <= 0 || R0(U(packageLimit.getPackageName()))) {
            return false;
        }
        C0702g.O("LimitManager", "stale duration suspend package=" + packageLimit.getPackageName() + " remainingTime=" + jB0);
        return true;
    }

    private int X(z2.f fVar) {
        Object[] objArrF = fVar.f();
        if (objArrF instanceof com.stepos.digitalwellbeing.server.data.i[]) {
            com.stepos.digitalwellbeing.server.data.i[] iVarArr = (com.stepos.digitalwellbeing.server.data.i[]) objArrF;
            int length = iVarArr.length;
            for (int i5 = 0; i5 < length; i5++) {
                if (iVarArr[i5].getTime() == C0711p.y()) {
                    return i5;
                }
            }
        }
        return -1;
    }

    private static boolean X0(GlobalLimit globalLimit) {
        return globalLimit != null && globalLimit.getId() == 999 && globalLimit.isNotifyOnly();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y0(long j5, PeriodLimit periodLimit, RipePeriod ripePeriod, boolean z5) throws Throwable {
        this.f6425B.remove(Long.valueOf(j5));
        PeriodLimit periodLimitI = this.f6431d.i(periodLimit.getId());
        if (periodLimitI != null && periodLimitI.isEnable() && periodLimitI.getVersion() == ripePeriod.getVersion() && periodLimitI.isNotifyOnly() == z5) {
            C0696a.q(ripePeriod);
            C0702g.b("LimitManager", "in-process period approach timer fired ripePeriod=" + ripePeriod);
            M(periodLimitI, ripePeriod);
        }
    }

    private void Y1(String str) {
        l0().edit().remove(str).commit();
        File file = new File(k0(), str);
        if (!file.exists() || file.delete()) {
            return;
        }
        Log.w("LimitManager", "removeNotifyDedupKey delete failed " + str);
    }

    private boolean Y2(String str, long j5) throws IOException {
        try {
            FileWriter fileWriter = new FileWriter(new File(k0(), str), false);
            try {
                fileWriter.write(Long.toString(j5));
                fileWriter.flush();
                fileWriter.close();
                return true;
            } finally {
            }
        } catch (Exception e6) {
            Log.e("LimitManager", "writeNotifyDedupFile failed key=" + str + " err=" + e6.getMessage());
            return false;
        }
    }

    private boolean Z2(String str, long j5) {
        SharedPreferences sharedPreferencesL0 = l0();
        return (sharedPreferencesL0.edit().putLong(str, j5).commit() && (sharedPreferencesL0.getLong(str, 0L) > j5 ? 1 : (sharedPreferencesL0.getLong(str, 0L) == j5 ? 0 : -1)) == 0) || Y2(str, j5);
    }

    private long c0() {
        long j5 = this.f6437j.getSharedPreferences("limit", 0).getLong("current_admin_id", -1L);
        C0702g.b("LimitManager", "getCurrentAdminId result = " + j5);
        return j5;
    }

    public static boolean c1() {
        return androidx.preference.j.b(P1.a.a()).getBoolean("digital_wellbeing_enable", true);
    }

    private void c2() {
        C0702g.b("LimitManager", "reportUsage");
        if (v2()) {
            StatsDataSet[] statsDataSetArrX = this.f6439l.x(this.f6439l.H(com.stepos.digitalwellbeing.server.data.a.LAST_TWO_WEEK.ordinal(), true));
            if (statsDataSetArrX == null || statsDataSetArrX.length < 2) {
                C0702g.p("LimitManager", "reportUsage: error statsDataSets = " + C0702g.h(statsDataSetArrX));
                return;
            }
            StatsDataSet[] children = statsDataSetArrX[1].getChildren();
            if (children != null && children.length >= 7) {
                int iX = X(new z2.d(statsDataSetArrX[1]));
                B2.b.h(iX == 0 ? statsDataSetArrX[0].getChildren()[6] : statsDataSetArrX[1].getChildren()[iX - 1]);
                q2(System.currentTimeMillis());
            } else {
                C0702g.p("LimitManager", "reportUsage: error weekArray = " + C0702g.h(children));
            }
        }
    }

    private List<String> d1(long j5) {
        ArrayList arrayList = new ArrayList();
        if (j5 <= 0 || j5 >= 255) {
            return new ArrayList(Arrays.asList(PackageUtils.f14710i));
        }
        List<WhitelistApp> listE = this.f6434g.e(j5);
        if (listE != null && !listE.isEmpty()) {
            Iterator<WhitelistApp> it = listE.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getPackageName());
            }
        }
        return arrayList;
    }

    private void e1(String str) {
        V();
        SharedPreferences sharedPreferencesI0 = i0();
        HashSet hashSet = new HashSet(sharedPreferencesI0.getStringSet("duration_expired_keys", Collections.EMPTY_SET));
        if (hashSet.add(str)) {
            sharedPreferencesI0.edit().putStringSet("duration_expired_keys", hashSet).apply();
            C0702g.b("LimitManager", "markDurationExpiredToday key=" + str);
        }
    }

    private static List<Z1.a> e2(List<RipePeriod> list) {
        if (list == null) {
            return null;
        }
        Collections.sort(list, new Comparator() { // from class: Y1.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return l.k((RipePeriod) obj, (RipePeriod) obj2);
            }
        });
        Stack stack = new Stack();
        ArrayList arrayList = new ArrayList();
        for (RipePeriod ripePeriod : list) {
            if (ripePeriod.getType() == 0) {
                stack.push(Long.valueOf(ripePeriod.getTime()));
            } else if (ripePeriod.getType() == 1) {
                arrayList.add(new Z1.a(((Long) stack.pop()).longValue(), ripePeriod.getTime(), ripePeriod.getMergedWeekDayType()));
            }
        }
        return arrayList;
    }

    private void f1(PeriodLimit periodLimit, RipePeriod ripePeriod) throws Throwable {
        if (periodLimit == null || ripePeriod == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long time = ripePeriod.getTime() + C0711p.y();
        if (time > C0711p.x()) {
            time -= 86400000;
        }
        if (jCurrentTimeMillis >= time && periodLimit.isNotifyOnly() && ripePeriod.getType() == 3) {
            P2(periodLimit.getType(), periodLimit.getPackageName(), periodLimit.getCategoryId(), periodLimit.getAdminId(), ripePeriod.getTime(), 2);
        }
    }

    private static String f2(String str) {
        return str == null ? "null" : str.replace('|', '.').replace('/', '_');
    }

    private long g0() {
        return this.f6437j.getSharedPreferences("limit", 0).getLong("last_handle_time", 0L);
    }

    private void g1(int i5, String str, int i6, long j5, long j6, long j7) {
        if (j5 <= 0 || j6 <= 0 || j6 > 60000) {
            return;
        }
        C0702g.b("LimitManager", "maybePostDeferredApproachNotify reason=" + i5 + " packageName=" + str + " categoryId=" + i6 + " remainingTime=" + j6);
        if (i5 == 0) {
            F1(0, null, PackageUtils.h(this.f6437j).m(str).label, j5, 1, j7, str, -1);
        } else if (i5 == 1) {
            Category categoryK = this.f6443p.k(i6);
            F1(1, categoryK == null ? null : this.f6437j.getString(categoryK.getNameResourceId()), null, j5, 1, j7, null, i6);
        }
    }

    private static long g2(SharedPreferences sharedPreferences, String str, String str2, String str3, long j5) {
        long j6;
        long j7 = 0;
        for (String str4 : sharedPreferences.getAll().keySet()) {
            if (str4 != null && str4.startsWith("period_notify_only_sent_") && str4.contains(str3)) {
                if (str != null) {
                    if (str4.contains(str)) {
                        j6 = sharedPreferences.getLong(str4, 0L);
                        if (j6 < j5 && j6 > j7) {
                            j7 = j6;
                        }
                    }
                } else if (str4.contains(str2)) {
                    j6 = sharedPreferences.getLong(str4, 0L);
                    if (j6 < j5) {
                    }
                }
            }
        }
        return j7;
    }

    private long h0() {
        return this.f6437j.getSharedPreferences("limit", 0).getLong("last_report_time", 0L);
    }

    private void h1(long j5, long j6) throws Throwable {
        this.f6424A.set(true);
        C0702g.b("LimitManager", "onAdminIdChanged old = " + j5 + " neww = " + j6);
        List<PackageLimit> listA = this.f6428a.a(j5);
        List<CategoryLimit> listA2 = this.f6429b.a(j5);
        GlobalLimit globalLimitC = this.f6430c.c(j5);
        List<String> listD1 = d1(j6);
        Iterator<PackageLimit> it = listA.iterator();
        while (it.hasNext()) {
            N2(it.next());
        }
        Iterator<CategoryLimit> it2 = listA2.iterator();
        while (it2.hasNext()) {
            J2(it2.next());
        }
        if (globalLimitC != null) {
            L2(globalLimitC);
        }
        this.f6436i.Q(listD1);
        List<PeriodLimit> listH = this.f6431d.h(0, j5);
        List<PeriodLimit> listH2 = this.f6431d.h(1, j5);
        PeriodLimit periodLimitE = this.f6431d.e(j5);
        for (PeriodLimit periodLimit : listH) {
            C(periodLimit);
            this.f6436i.H(periodLimit.getPackageName());
        }
        for (PeriodLimit periodLimit2 : listH2) {
            C(periodLimit2);
            this.f6436i.J(periodLimit2.getCategoryId());
        }
        if (periodLimitE != null) {
            C(periodLimitE);
            this.f6436i.M();
        }
        List<PackageLimit> listA3 = this.f6428a.a(j6);
        List<CategoryLimit> listA4 = this.f6429b.a(j6);
        GlobalLimit globalLimitC2 = this.f6430c.c(j6);
        Iterator<PackageLimit> it3 = listA3.iterator();
        while (it3.hasNext()) {
            H2(it3.next());
        }
        Iterator<CategoryLimit> it4 = listA4.iterator();
        while (it4.hasNext()) {
            E2(it4.next());
        }
        if (globalLimitC2 != null) {
            F2(globalLimitC2);
        }
        List<PeriodLimit> listH3 = this.f6431d.h(0, j6);
        List<PeriodLimit> listH4 = this.f6431d.h(1, j6);
        PeriodLimit periodLimitE2 = this.f6431d.e(j6);
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (PeriodLimit periodLimit3 : listH3) {
            s(periodLimit3);
            M1(periodLimit3, jCurrentTimeMillis, j6);
        }
        l lVar = this;
        for (PeriodLimit periodLimit4 : listH4) {
            lVar.s(periodLimit4);
            lVar.M1(periodLimit4, jCurrentTimeMillis, j6);
        }
        if (periodLimitE2 != null) {
            lVar.s(periodLimitE2);
            lVar.M1(periodLimitE2, jCurrentTimeMillis, j6);
            lVar = lVar;
        }
        if (DigitalWellbeingService.B(j5)) {
            lVar.f6429b.c(j5);
            lVar.f6428a.c(j5);
            lVar.f6430c.d(j5);
            lVar.f6431d.c(j5);
        }
        lVar.N1(j6);
    }

    private void h2(final PeriodLimit periodLimit, final RipePeriod ripePeriod) {
        if (periodLimit.isEnable()) {
            final boolean z5 = ripePeriod.getType() == 3;
            if (periodLimit.isNotifyOnly() != z5) {
                return;
            }
            long time = ripePeriod.getTime() + C0711p.y();
            if (time > C0711p.x()) {
                time -= 86400000;
            }
            long jCurrentTimeMillis = (time - System.currentTimeMillis()) + 1000;
            if (jCurrentTimeMillis <= 0) {
                return;
            }
            final long id = ripePeriod.getId();
            B(id);
            this.f6425B.put(Long.valueOf(id), AbstractC1286b.k(jCurrentTimeMillis, TimeUnit.MILLISECONDS).j(T3.a.a()).h(new D3.a() { // from class: Y1.e
                @Override // D3.a
                public final void run() throws Throwable {
                    this.f6402a.Y0(id, periodLimit, ripePeriod, z5);
                }
            }, S1.a.b()));
        }
    }

    private SharedPreferences i0() {
        return this.f6437j.getSharedPreferences("limit", 0);
    }

    private Context j0() {
        Context applicationContext = this.f6437j.getApplicationContext();
        try {
            return applicationContext.createDeviceProtectedStorageContext();
        } catch (RuntimeException unused) {
            return applicationContext;
        }
    }

    public static /* synthetic */ int k(RipePeriod ripePeriod, RipePeriod ripePeriod2) {
        return (int) (ripePeriod.getTime() - ripePeriod2.getTime());
    }

    private File k0() {
        File file = new File(j0().getFilesDir(), "notify_dedup");
        if (!file.exists() && !file.mkdirs()) {
            Log.w("LimitManager", "getNotifyDedupDir mkdirs failed");
        }
        return file;
    }

    private SharedPreferences l0() {
        return j0().getSharedPreferences("limit_notify_dedup", 0);
    }

    private synchronized void l2(long j5) {
        C0702g.b("LimitManager", "setCurrentAdminId adminId = " + j5);
        this.f6437j.getSharedPreferences("limit", 0).edit().putLong("current_admin_id", j5).apply();
    }

    private void p1(CategoryLimit categoryLimit) {
        C0702g.b("LimitManager", "onInsertCategoryLimit categoryLimit = " + categoryLimit);
        E2(categoryLimit);
    }

    private void p2(long j5) {
        C0702g.b("LimitManager", "setLastHandleTime handleTime = " + j5);
        this.f6437j.getSharedPreferences("limit", 0).edit().putLong("last_handle_time", j5).apply();
    }

    private void q1(GlobalLimit globalLimit) {
        C0702g.b("LimitManager", "onInsertGlobalLimit globalLimit = " + globalLimit);
        F2(globalLimit);
    }

    private void q2(long j5) {
        C0702g.b("LimitManager", "setLastReportTime reportTime = " + j5);
        this.f6437j.getSharedPreferences("limit", 0).edit().putLong("last_report_time", j5).apply();
    }

    private void r(Window window) {
        if (window == null) {
            return;
        }
        window.setType(2038);
    }

    private void r1(PackageLimit packageLimit) {
        C0702g.b("LimitManager", "onInsertPackageLimit PackageLimit = " + packageLimit);
        I2(packageLimit, true);
    }

    private void s(PeriodLimit periodLimit) throws Throwable {
        t(periodLimit, true);
    }

    private void t(PeriodLimit periodLimit, boolean z5) throws Throwable {
        C0702g.b("LimitManager", "applyRipePeriods periodLimit = " + periodLimit + " notifyMissedApproach=" + z5);
        if (periodLimit != null && periodLimit.isEnable()) {
            long id = periodLimit.getId();
            long jC = this.f6433f.c(this.f6444q, id);
            List<RipePeriod> listE = this.f6433f.e(id, jC, y());
            if (periodLimit.getVersion() < jC) {
                periodLimit.setVersion(jC);
            }
            this.f6431d.f(periodLimit);
            for (RipePeriod ripePeriod : listE) {
                if (C0696a.l(ripePeriod) == -1) {
                    if (z5) {
                        R2(periodLimit, ripePeriod);
                    } else {
                        f1(periodLimit, ripePeriod);
                        C0702g.b("LimitManager", "applyRipePeriods skip missed approach after notify-mode switch ripePeriod=" + ripePeriod);
                    }
                }
                h2(periodLimit, ripePeriod);
            }
        }
    }

    private synchronized long t0(int i5, int i6, long j5, boolean z5) {
        try {
            DataToken dataTokenH = com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.c.t() ? this.f6439l.H(i5, U1(i5)) : this.f6439l.G(i5, U1(i5));
            if (dataTokenH == null) {
                C0702g.p("LimitManager", "getRemainingTime token == null");
                return -1L;
            }
            long jK = this.f6439l.k(i5, i6, dataTokenH);
            long jX = x(j5, jK, z5);
            C0702g.b("LimitManager", "remainingTime=" + C0711p.m(this.f6437j, jX) + " usingTime=" + C0711p.m(this.f6437j, jK) + " limitTime=" + C0711p.m(this.f6437j, j5));
            return jX;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void t1(String str) {
        Category categoryZ;
        CategoryLimit categoryLimitG;
        try {
            if (this.f6445r && !TextUtils.isEmpty(str)) {
                PackageLimit packageLimitE = this.f6428a.e(str, this.f6444q);
                if (packageLimitE != null && packageLimitE.isEnable() && !packageLimitE.isNotifyOnly()) {
                    g1(0, str, -1, packageLimitE.getCurrentLimit(this.f6437j), B0(packageLimitE, false), packageLimitE.getAdminId());
                }
                W1.c cVar = this.f6443p;
                if (cVar != null && (categoryZ = cVar.z(str)) != null && (categoryLimitG = this.f6429b.g(categoryZ.getId(), this.f6444q)) != null && categoryLimitG.isEnable() && !categoryLimitG.isNotifyOnly()) {
                    g1(1, null, categoryZ.getId(), categoryLimitG.getCurrentLimit(this.f6437j), x0(categoryLimitG, false), categoryLimitG.getAdminId());
                }
            }
        } finally {
        }
    }

    private synchronized void t2() {
        this.f6442o.cancel(this.f6435h);
        try {
            this.f6442o.setExactAndAllowWhileIdle(0, C0711p.x() + 120000, this.f6435h);
        } catch (SecurityException e6) {
            e6.printStackTrace();
        }
    }

    private Bundle u(PeriodLimit periodLimit, RipePeriod ripePeriod) {
        Bundle bundle = new Bundle();
        bundle.putInt("limit_type", periodLimit.getType());
        bundle.putLong("admin_id", periodLimit.getAdminId());
        bundle.putLong("time", ripePeriod.getTime());
        bundle.putLong("ripe_period_id", ripePeriod.getId());
        if (periodLimit.getType() == 0) {
            bundle.putString("packageName", periodLimit.getPackageName());
            return bundle;
        }
        if (periodLimit.getType() == 1) {
            bundle.putLong("category_id", periodLimit.getCategoryId());
        }
        return bundle;
    }

    private synchronized long u0(int i5, long j5, boolean z5) throws Throwable {
        l lVar;
        Throwable th;
        try {
            try {
                if (!com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.c.t()) {
                    throw new IllegalStateException("error alphameVersion not support get global using time");
                }
                DataToken dataTokenH = this.f6439l.H(i5, U1(i5));
                if (dataTokenH == null) {
                    try {
                        C0702g.p("LimitManager", "getRemainingTime token == null");
                        return -1L;
                    } catch (Throwable th2) {
                        th = th2;
                        lVar = this;
                        throw th;
                    }
                }
                long jM = this.f6439l.m(i5, dataTokenH);
                long jX = x(j5, jM, z5);
                C0702g.b("LimitManager", "remainingTime=" + C0711p.m(this.f6437j, jX) + " usingTime=" + C0711p.m(this.f6437j, jM) + " limitTime=" + C0711p.m(this.f6437j, j5));
                return jX;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            lVar = this;
            th = th;
            throw th;
        }
    }

    private boolean u2(int i5, String str, int i6, long j5, long j6) throws Throwable {
        boolean zEquals;
        String strB0 = b0(this.f6437j.getApplicationContext());
        boolean z5 = false;
        if (TextUtils.isEmpty(strB0)) {
            C0702g.b("LimitManager", "shouldPostImmediateApproachNotify skip empty foreground reason=" + i5);
            return false;
        }
        if (i5 == 0) {
            zEquals = TextUtils.equals(strB0, str);
        } else if (i5 == 1) {
            Category categoryZ = this.f6443p.z(strB0);
            if (categoryZ != null && categoryZ.getId() == i6) {
                z5 = true;
            }
            zEquals = z5;
        } else {
            zEquals = !TextUtils.equals(strB0, this.f6437j.getPackageName());
        }
        if (!zEquals) {
            C0702g.b("LimitManager", "shouldPostImmediateApproachNotify skip not in use reason=" + i5 + " foreground=" + strB0 + " remainingTime=" + j5 + " limit=" + j6);
        }
        return zEquals;
    }

    private static String v(int i5, String str, long j5, long j6, long j7, int i6) {
        return i5 + "|" + str + "|" + j5 + "|" + j6 + "|" + j7 + "|" + i6;
    }

    private synchronized long v0(int i5, String str, long j5, boolean z5) {
        try {
            C0702g.b("LimitManager", "getRemainingTime() called with: interval = [" + i5 + "], packageName = [" + str + "], limitTime = [" + j5 + "], exact = [" + z5 + "]");
            DataToken dataTokenH = com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.c.t() ? this.f6439l.H(i5, U1(i5)) : this.f6439l.G(i5, U1(i5));
            if (dataTokenH == null) {
                R1.a.b("LimitManager", "getRemainingTime token = null");
                return -1L;
            }
            long jP = this.f6439l.p(i5, str, dataTokenH);
            long jX = x(j5, jP, z5);
            C0702g.b("LimitManager", "remainingTime=" + C0711p.m(this.f6437j, jX) + " usingTime=" + C0711p.m(this.f6437j, jP) + "limitTime=" + C0711p.m(this.f6437j, j5));
            return jX;
        } catch (Throwable th) {
            throw th;
        }
    }

    private boolean v2() {
        long jH0 = h0();
        boolean z5 = System.currentTimeMillis() - jH0 > 86400000;
        boolean z6 = C0711p.y() > C0711p.k(jH0);
        C0702g.G("LimitManager", R1.a.f4965a);
        C0702g.M("LimitManager", "shouldReportUsage lastReportTime = " + C0711p.j(jH0));
        boolean z7 = z5 || z6;
        C0702g.M("LimitManager", "overReportInterval = " + z5 + " overDay = " + z6 + " result = " + z7);
        C0702g.G("LimitManager", R1.a.f4965a);
        return z7;
    }

    private static String w(int i5, String str, int i6, long j5, int i7) {
        String str2;
        if (i5 == 0) {
            str2 = "pkg|" + str + "|" + j5;
        } else if (i5 == 1) {
            str2 = "cat|" + i6 + "|" + j5;
        } else {
            str2 = "global|" + j5;
        }
        if (i7 != 0) {
            return str2;
        }
        return "suspend|" + str2;
    }

    private synchronized long w0(CategoryLimit categoryLimit) {
        return x0(categoryLimit, true);
    }

    private boolean w2() {
        long jG0 = g0();
        boolean z5 = jG0 < C0711p.y();
        C0702g.G("LimitManager", R1.a.f4965a);
        C0702g.M("LimitManager", "shouldResetLimits lastHandleTime = " + C0711p.j(jG0));
        C0702g.G("LimitManager", R1.a.f4965a);
        return z5;
    }

    private long x(long j5, long j6, boolean z5) {
        long j7 = j5 > j6 ? j5 - j6 : 0L;
        if (z5 || j7 <= 0) {
            return j7;
        }
        long j8 = j7 >= 20000 ? j7 : 0L;
        C0702g.b("LimitManager", "remainingTime " + C0711p.m(this.f6437j, j7) + " fixed = " + C0711p.m(this.f6437j, j8));
        return j8;
    }

    private synchronized long x0(CategoryLimit categoryLimit, boolean z5) throws Throwable {
        try {
            if (categoryLimit == null) {
                return Long.MAX_VALUE;
            }
            try {
                long currentLimit = categoryLimit.getCurrentLimit(this.f6437j);
                if (currentLimit == -1) {
                    return currentLimit;
                }
                return t0(categoryLimit.getInterval(), categoryLimit.getCategoryId(), currentLimit, z5);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void x2(final Context context, final String str, final boolean z5, final boolean z6) {
        AbstractC1286b.b().e(C1347a.a()).h(new D3.a() { // from class: Y1.h
            @Override // D3.a
            public final void run() {
                this.f6418a.Z0(context, str, z5, z6);
            }
        }, S1.a.b());
    }

    private int y() {
        boolean zI = C0718w.g().i();
        boolean zJ = C0718w.g().j(C0711p.y() + 86400000);
        return zI ? !zJ ? 2 : 0 : zJ ? 3 : 1;
    }

    private synchronized long y0(GlobalLimit globalLimit) {
        return z0(globalLimit, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y2, reason: merged with bridge method [inline-methods] */
    public void Z0(Context context, String str, boolean z5, boolean z6) {
        PackageUtils.AppInfo appInfoM = PackageUtils.h(this.f6437j).m(str);
        String str2 = appInfoM == null ? null : appInfoM.label;
        D2(new C2.b(N1.i.g(context), R.style.FamilyGuard_DigitalWellbeing_PreferenceActivity_AlertTheme_Blue).y(context.getString(R.string.us_app_cant_use)).n(z5 ? context.getString(R.string.us_app_total_limit_dialog_message, str2) : z6 ? context.getString(R.string.us_app_overtime_period_limit_dialog_message, str2) : context.getString(R.string.us_app_overtime_limit_dialog_message, str2)).u(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: Y1.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                dialogInterface.dismiss();
            }
        }).c(), "appSuspended:" + str);
    }

    private boolean z(Context context) {
        return Settings.canDrawOverlays(context);
    }

    private synchronized long z0(GlobalLimit globalLimit, boolean z5) {
        return u0(globalLimit.getInterval(), globalLimit.getCurrentLimit(this.f6437j), z5);
    }

    private void z2(final Context context, final int i5, final boolean z5, final boolean z6) {
        AbstractC1286b.b().e(C1347a.a()).h(new D3.a() { // from class: Y1.g
            @Override // D3.a
            public final void run() {
                this.f6413a.a1(context, i5, z5, z6);
            }
        }, S1.a.b());
    }

    public synchronized void A1(boolean z5) {
        C0702g.b("LimitManager", "onSelfReplaced");
        L1();
    }

    public synchronized void D(long j5) {
        try {
            List<PackageLimit> listA = this.f6428a.a(j5);
            List<CategoryLimit> listA2 = this.f6429b.a(j5);
            GlobalLimit globalLimitC = this.f6430c.c(j5);
            List<PeriodLimit> listH = this.f6431d.h(1, j5);
            List<PeriodLimit> listH2 = this.f6431d.h(0, j5);
            List<PeriodLimit> listH3 = this.f6431d.h(2, j5);
            if (listA != null) {
                Iterator<PackageLimit> it = listA.iterator();
                while (it.hasNext()) {
                    N2(it.next());
                }
            }
            if (listA2 != null) {
                Iterator<CategoryLimit> it2 = listA2.iterator();
                while (it2.hasNext()) {
                    J2(it2.next());
                }
            }
            if (globalLimitC != null) {
                L2(globalLimitC);
            }
            if (listH3 != null) {
                for (PeriodLimit periodLimit : listH3) {
                    this.f6436i.M();
                    this.f6432e.c(periodLimit.getId());
                    this.f6433f.g(periodLimit.getId());
                }
            }
            if (listH != null) {
                for (PeriodLimit periodLimit2 : listH) {
                    this.f6436i.J(periodLimit2.getCategoryId());
                    this.f6432e.c(periodLimit2.getId());
                    this.f6433f.g(periodLimit2.getId());
                }
            }
            if (listH2 != null) {
                for (PeriodLimit periodLimit3 : listH2) {
                    this.f6436i.H(periodLimit3.getPackageName());
                    this.f6432e.c(periodLimit3.getId());
                    this.f6433f.g(periodLimit3.getId());
                }
            }
            this.f6434g.a(j5);
            this.f6428a.c(j5);
            this.f6429b.c(j5);
            this.f6430c.d(j5);
            this.f6431d.c(j5);
        } catch (Throwable th) {
            throw th;
        }
    }

    public List<WhitelistApp> D0(long j5) {
        return this.f6434g.e(j5);
    }

    public synchronized void E() {
        D(-1L);
    }

    public synchronized void E1() {
        C0702g.b("LimitManager", "onUserPresent");
        L1();
        c2();
    }

    public synchronized PeriodLimit O0(long j5) {
        if (j5 != this.f6444q) {
            R1.a.b("LimitManager", "initGlobalPeriodLimit adminId = " + j5 + " mCurrentAdminId = " + this.f6444q + " illegal adminId");
            return null;
        }
        PeriodLimit periodLimit = new PeriodLimit(2, null, -1L, j5, false, false, false, 1L);
        R1.a.a("LimitManager", "initGlobalPeriodLimit adminId = " + j5 + " periodLimit = " + periodLimit);
        periodLimit.setId(this.f6431d.g(periodLimit));
        return periodLimit;
    }

    public synchronized PeriodLimit P0(long j5, long j6) {
        if (j6 != this.f6444q) {
            R1.a.b("LimitManager", "initPeriodLimit adminId = " + j6 + " mCurrentAdminId = " + this.f6444q + " illegal adminId");
            return null;
        }
        PeriodLimit periodLimit = new PeriodLimit(1, null, j5, j6, false, false, false, 1L);
        R1.a.a("LimitManager", "initPeriodLimit categoryId = " + j5 + " adminId = " + j6 + " periodLimit = " + periodLimit);
        periodLimit.setId(this.f6431d.g(periodLimit));
        return periodLimit;
    }

    public synchronized PeriodLimit Q0(String str, long j5) {
        if (j5 != this.f6444q) {
            R1.a.b("LimitManager", "initPeriodLimit adminId = " + j5 + " mCurrentAdminId = " + this.f6444q + " illegal adminId");
            return null;
        }
        PeriodLimit periodLimit = new PeriodLimit(0, str, -1L, j5, false, false, false, 1L);
        R1.a.a("LimitManager", "initPeriodLimit packageName = " + str + " adminId = " + j5 + " periodLimit = " + periodLimit);
        periodLimit.setId(this.f6431d.g(periodLimit));
        return periodLimit;
    }

    public boolean S0() {
        return this.f6449v;
    }

    public void T1() {
        C0582c c0582c = this.f6436i;
        if (c0582c == null) {
            return;
        }
        c0582c.G();
    }

    public synchronized long U2(long j5, long j6, RawPeriod rawPeriod) {
        C0702g.b("LimitManager", "updateCategoryPeriod categoryId = " + j5 + " rawPeriod = " + rawPeriod + " rawPeriod = " + rawPeriod + " adminId = " + j6);
        PeriodLimit periodLimitA = this.f6431d.a(j5, j6);
        if (periodLimitA != null) {
            return X2(periodLimitA.getId(), rawPeriod);
        }
        C0702g.O("LimitManager", "updateCategoryPeriod can not find PeriodLimit categoryId = " + j5);
        return -1L;
    }

    public synchronized long V2(long j5, RawPeriod rawPeriod) {
        C0702g.b("LimitManager", "updateGlobalPeriod adminId = " + j5 + " rawPeriod = " + rawPeriod);
        PeriodLimit periodLimitE = this.f6431d.e(j5);
        if (periodLimitE != null) {
            return X2(periodLimitE.getId(), rawPeriod);
        }
        R1.a.b("LimitManager", "updateGlobalPeriod can not find PeriodLimit adminId = " + j5);
        return -1L;
    }

    public synchronized long W1(long j5, long j6, long j7) {
        PeriodLimit periodLimitA = this.f6431d.a(j5, j6);
        if (periodLimitA != null) {
            return a2(periodLimitA.getId(), j7);
        }
        R1.a.l("LimitManager", "removeCategoryPeriod can not find PeriodLimit categoryId = " + j5);
        return -1L;
    }

    public synchronized long W2(String str, long j5, RawPeriod rawPeriod) {
        C0702g.b("LimitManager", "updatePackagePeriod packageName = " + str + " rawPeriod = " + rawPeriod + " rawPeriod = " + rawPeriod + " adminId = " + j5);
        PeriodLimit periodLimitD = this.f6431d.d(str, j5);
        if (periodLimitD != null) {
            return X2(periodLimitD.getId(), rawPeriod);
        }
        R1.a.l("LimitManager", "updatePackagePeriod can not find PeriodLimit packageName = " + str);
        return -1L;
    }

    public synchronized long X1(long j5, long j6) {
        PeriodLimit periodLimitE = this.f6431d.e(j5);
        if (periodLimitE != null) {
            return a2(periodLimitE.getId(), j6);
        }
        R1.a.l("LimitManager", "removeGlobalPeriod can not find PeriodLimit adminId = " + j5);
        return -1L;
    }

    public synchronized long X2(long j5, RawPeriod rawPeriod) throws Throwable {
        try {
            C0702g.b("LimitManager", "updatePeriod limitId = " + j5 + " rawPeriod = " + rawPeriod);
            PeriodLimit periodLimitI = this.f6431d.i(j5);
            if (periodLimitI == null) {
                R1.a.b("LimitManager", "updatePeriod can not find PeriodLimit limitId = " + j5);
                return -1L;
            }
            rawPeriod.setLimitId(periodLimitI.getId());
            this.f6447t.b();
            try {
                try {
                    C(periodLimitI);
                    this.f6432e.e(rawPeriod);
                    E0(periodLimitI);
                    if (periodLimitI.isEnable()) {
                        s(periodLimitI);
                    }
                    this.f6447t.s();
                    this.f6447t.f();
                    try {
                        M1(periodLimitI, System.currentTimeMillis(), this.f6444q);
                        return rawPeriod.getId();
                    } catch (Throwable th) {
                        th = th;
                        this = this;
                        Throwable th2 = th;
                        throw th2;
                    }
                } catch (Exception unused) {
                    this.f6447t.f();
                    return -1L;
                }
            } catch (Throwable th3) {
                this.f6447t.f();
                throw th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public long Y() {
        if (!this.f6445r) {
            this.f6444q = c0();
        }
        return this.f6444q;
    }

    public List<PeriodLimit> Z(long j5) {
        return this.f6431d.h(1, j5);
    }

    public synchronized long Z1(String str, long j5, long j6) {
        C0702g.b("LimitManager", "removePackagePeriod packageName = " + str + " adminId = " + j5 + " periodId = " + j6);
        PeriodLimit periodLimitD = this.f6431d.d(str, j5);
        if (periodLimitD != null) {
            return a2(periodLimitD.getId(), j6);
        }
        R1.a.l("LimitManager", "removePackagePeriod can not find PeriodLimit packageName = " + str);
        return -1L;
    }

    @Override // W1.c.a
    public synchronized void a(List<Category> list) {
        try {
            C0702g.b("LimitManager", "onAfterCategoryChanged changedCategories = " + C0702g.k(list));
            com.stepos.digitalwellbeing.server.limit.data.room.a aVarT = U1.a.c(this.f6437j).b().t();
            Iterator<Category> it = list.iterator();
            while (it.hasNext()) {
                CategoryLimit categoryLimitG = aVarT.g(it.next().getId(), this.f6444q);
                if (categoryLimitG != null) {
                    E2(categoryLimitG);
                }
            }
            Iterator<Category> it2 = list.iterator();
            while (it2.hasNext()) {
                PeriodLimit periodLimitA = this.f6431d.a(it2.next().getId(), this.f6444q);
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (periodLimitA != null) {
                    long categoryId = periodLimitA.getCategoryId();
                    if (I0(categoryId, jCurrentTimeMillis)) {
                        this.f6436i.e(categoryId, false);
                    } else {
                        this.f6436i.J(categoryId);
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized List<CategoryLimit> a0() {
        return this.f6429b.a(this.f6444q);
    }

    public synchronized long a2(long j5, long j6) throws Throwable {
        try {
            C0702g.b("LimitManager", "removePeriod limitId = " + j5 + " periodId = " + j6);
            PeriodLimit periodLimitI = this.f6431d.i(j5);
            if (periodLimitI == null) {
                R1.a.b("LimitManager", "removePeriod can not find PeriodLimit limitId = " + j5);
                return -1L;
            }
            this.f6447t.b();
            try {
                try {
                    C(periodLimitI);
                    this.f6432e.a(j6);
                    E0(periodLimitI);
                    if (periodLimitI.isEnable()) {
                        s(periodLimitI);
                    }
                    this.f6447t.s();
                    this.f6447t.f();
                    try {
                        M1(periodLimitI, System.currentTimeMillis(), this.f6444q);
                        return j6;
                    } catch (Throwable th) {
                        th = th;
                        this = this;
                        Throwable th2 = th;
                        throw th2;
                    }
                } catch (Throwable th3) {
                    this.f6447t.f();
                    throw th3;
                }
            } catch (Exception unused) {
                this.f6447t.f();
                return -1L;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:? -> B:26:0x008d). Please report as a decompilation issue!!! */
    @Override // W1.c.a
    public synchronized void b(List<Category> list) throws Throwable {
        l lVar;
        Throwable th;
        try {
            C0702g.b("LimitManager", "onBeforeCategoryChanged changedCategories = " + C0702g.k(list));
            com.stepos.digitalwellbeing.server.limit.data.room.a aVarT = U1.a.c(this.f6437j).b().t();
            Iterator<Category> it = list.iterator();
            while (it.hasNext()) {
                try {
                    CategoryLimit categoryLimitG = aVarT.g(it.next().getId(), this.f6444q);
                    if (categoryLimitG != null) {
                        J2(categoryLimitG);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    lVar = this;
                    throw th;
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            Iterator<Category> it2 = list.iterator();
            while (it2.hasNext()) {
                PeriodLimit periodLimitA = this.f6431d.a(it2.next().getId(), this.f6444q);
                if (periodLimitA != null) {
                    long categoryId = periodLimitA.getCategoryId();
                    if (this.I0(categoryId, jCurrentTimeMillis)) {
                        this.f6436i.e(categoryId, false);
                    } else {
                        this.f6436i.J(categoryId);
                    }
                    lVar = this;
                    try {
                        lVar.M1(periodLimitA, jCurrentTimeMillis, this.f6444q);
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        throw th;
                    }
                } else {
                    lVar = this;
                }
                this = lVar;
            }
        } catch (Throwable th4) {
            th = th4;
            lVar = this;
            th = th;
            throw th;
        }
    }

    public String b0(Context context) {
        return this.f6448u.g();
    }

    public synchronized int b2(String str, long j5) {
        int i5;
        C0582c c0582c;
        try {
            C0702g.b("LimitManager", "removeWhitelistApp packageName = " + str + " adminId = " + j5);
            i5 = this.f6434g.i(j5, str);
            List<String> list = this.f6450w.get(Long.valueOf(j5));
            if (list != null) {
                list.remove(str);
            }
            if (this.f6444q == j5 && (c0582c = this.f6436i) != null) {
                c0582c.Q(list);
            }
        } catch (Throwable th) {
            throw th;
        }
        return i5;
    }

    public synchronized GlobalLimit d0() {
        return this.f6430c.c(this.f6444q);
    }

    public synchronized void d2() {
        try {
            R1.a.a("LimitManager", "resetSuspendApp");
            if (w2() || F0()) {
                L1();
            }
            c2();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized PeriodLimit e0(long j5) {
        return this.f6431d.e(j5);
    }

    public List<RawPeriod> f0(long j5) {
        PeriodLimit periodLimitE = this.f6431d.e(j5);
        if (periodLimitE != null) {
            return this.f6432e.b(periodLimitE.getId());
        }
        C0702g.O("LimitManager", "getGlobalRawPeriodFor periodLimit = null");
        return null;
    }

    public synchronized void i1() {
        C0702g.b("LimitManager", "onBootComplete");
        L1();
        c2();
    }

    public synchronized void i2(long j5) {
        try {
            C0702g.b("LimitManager", "setAdminId adminId = " + j5);
            if (!this.f6445r) {
                this.f6444q = c0();
            }
            long j6 = this.f6444q;
            try {
                if (j5 != j6) {
                    try {
                        if (this.f6445r && this.f6436i != null) {
                            h1(j6, j5);
                        }
                        this.f6444q = j5;
                    } catch (Exception e6) {
                        R1.a.c("LimitManager", "setAdminId adminId = " + j5 + " onAdminIdChanged throw exception", e6);
                        this.f6444q = j5;
                    }
                    l2(j5);
                }
            } catch (Throwable th) {
                this.f6444q = j5;
                l2(j5);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void j1(int i5, String[] strArr, int i6, long j5, int i7) {
        C0702g.b("LimitManager", "onCategoryApproached packageNames = " + C0702g.h(strArr) + " observerId = " + i5 + " categoryId = " + i6 + " type = " + i7 + " reason = 1");
        boolean zS = this.f6452y.s(i5);
        if (!zS && i7 != 2) {
            C0702g.b("LimitManager", "onCategoryApproached ignore duplicate observerId=" + i5);
            return;
        }
        if (!zS) {
            C0702g.b("LimitManager", "onCategoryApproached group missing, fallback by usage remaining, observerId=" + i5);
        }
        CategoryLimit categoryLimitG = this.f6429b.g(i6, this.f6444q);
        long jW0 = w0(categoryLimitG);
        if (categoryLimitG == null) {
            C0702g.p("LimitManager", "categoryLimit = null");
            return;
        }
        if (i7 == 0) {
            if (jW0 > 30000 && this.f6452y.A(strArr)) {
                C0702g.b("LimitManager", "onCategoryApproached TYPE_SUSPEND premature, reWatch remainingTime=" + jW0);
                Q(categoryLimitG.getId() + 1000, categoryLimitG.getCategoryId(), categoryLimitG.getCurrentLimit(this.f6437j), jW0, 0, true);
                return;
            }
            C0702g.b("LimitManager", "onCategoryApproached type = TYPE_SUSPEND, remainingTime = " + jW0);
        } else if (i7 == 2) {
            if (jW0 > 30000) {
                C0702g.b("LimitManager", "onCategoryApproached TYPE_NOTIFY_ONLY premature, reWatch remainingTime=" + jW0);
                Q(categoryLimitG.getId(), categoryLimitG.getCategoryId(), categoryLimitG.getCurrentLimit(this.f6437j), jW0, 2, true);
                return;
            }
            C0702g.b("LimitManager", "onCategoryApproached type = TYPE_NOTIFY_ONLY, notify, remainingTime = " + jW0);
        } else {
            if (jW0 - 30000 > 60000) {
                C0702g.b("LimitManager", "onCategoryApproached remainingTime = " + jW0 + " reWatch");
                Q(categoryLimitG.getId(), categoryLimitG.getCategoryId(), categoryLimitG.getCurrentLimit(this.f6437j), jW0 - 60000, i7, true);
                return;
            }
            boolean zU2 = u2(1, null, categoryLimitG.getCategoryId(), jW0, categoryLimitG.getCurrentLimit(this.f6437j));
            jW0 = jW0;
            if (!zU2) {
                C0702g.b("LimitManager", "onCategoryApproached TYPE_NOTIFY skip unused/background categoryId=" + categoryLimitG.getCategoryId() + " remainingTime=" + jW0);
                O1(1, categoryLimitG.getId(), null, categoryLimitG.getCategoryId(), categoryLimitG.getCurrentLimit(this.f6437j), jW0);
                return;
            }
        }
        boolean z5 = i7 == 0 || (i7 == 1 && jW0 <= 0 && !categoryLimitG.isNotifyOnly());
        if (z5) {
            if (i7 == 1) {
                N(categoryLimitG.getId() + 1000);
            } else if (i7 == 0) {
                N(categoryLimitG.getId());
            }
            if (i7 == 0 && categoryLimitG.isSuspended()) {
                C0702g.b("LimitManager", "onCategoryApproached ignore duplicate suspend categoryId=" + categoryLimitG.getCategoryId());
                return;
            }
            categoryLimitG.setSuspended(true);
            this.f6429b.e(categoryLimitG);
            e1(T(categoryLimitG.getCategoryId()));
            R1.a.a("LimitManager", "categoryLimit = " + categoryLimitG + " setSuspended true");
            this.f6436i.f((long) categoryLimitG.getCategoryId(), false);
            z2(this.f6437j, categoryLimitG.getCategoryId(), false, false);
        } else if (i7 == 2) {
            T2(this.f6438k, i5);
        }
        F1(1, this.f6437j.getString(this.f6443p.k(i6).getNameResourceId()), null, j5, z5 ? 0 : i7, categoryLimitG.getAdminId(), null, i6);
    }

    public synchronized boolean j2(int i5, int i6, long j5, long j6, boolean z5, boolean z6, long j7, boolean z7) {
        try {
            C0702g.b("LimitManager", "setCategoryLimit interval = " + i5 + " categoryId = " + i6 + " workdayLimit = " + C0711p.m(this.f6437j, j5) + " offDayLimit = " + C0711p.m(this.f6437j, j6) + " enable = " + z5 + " notifyOnly = " + z6);
            if (!this.f6445r) {
                C0702g.b("LimitManager", "not inited");
                o1();
            }
            long j8 = this.f6444q;
            if (j8 != j7) {
                C0702g.b("LimitManager", "mCurrentAdminId = " + this.f6444q + " adminId = " + j7);
                return false;
            }
            if (j5 < -1 || j6 < -1) {
                return false;
            }
            CategoryLimit categoryLimitG = this.f6429b.g(i6, j8);
            if (categoryLimitG == null) {
                CategoryLimit categoryLimitJ = J(i5, i6, j5, j6, z5, z6, j7, z7);
                categoryLimitJ.setId(this.f6429b.d(categoryLimitJ));
                p1(categoryLimitJ);
                return z5;
            }
            CategoryLimit categoryLimitM2clone = categoryLimitG.m2clone();
            categoryLimitG.setWorkdayLimit(j5);
            categoryLimitG.setOffDayLimit(j6);
            categoryLimitG.setEnable(z5);
            categoryLimitG.setNotifyOnly(z6);
            categoryLimitG.setChild(z7);
            this.f6429b.e(categoryLimitG);
            return B1(categoryLimitM2clone, categoryLimitG);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void k1(int i5, int i6) {
        C0702g.b("LimitManager", "onCategoryChanged oldVersion = " + i5);
        if (i5 == 0 && i6 == 1) {
            List<CategoryLimit> listA0 = a0();
            com.stepos.digitalwellbeing.server.limit.data.room.a aVarT = U1.a.c(this.f6437j).b().t();
            InterfaceC0801e interfaceC0801eV = FamilyGuardDatabase.x().v();
            if (listA0 != null) {
                Iterator<CategoryLimit> it = listA0.iterator();
                while (it.hasNext()) {
                    J2(it.next());
                }
            }
            aVarT.b();
            interfaceC0801eV.b();
        }
    }

    public synchronized PeriodLimit k2(long j5, long j6, boolean z5, boolean z6, boolean z7) {
        boolean z8;
        C0702g.b("LimitManager", "setCategoryPeriodLimit categoryId = " + j5 + " adminId = " + j6 + " enable = " + z5 + " notifyOnly = " + z6 + " isChild = " + z7);
        if (j6 != this.f6444q) {
            R1.a.a("LimitManager", "setCategoryPeriodLimit adminId = " + j6 + " mCurrentAdminId = " + this.f6444q + " illegal adminId");
            return null;
        }
        PeriodLimit periodLimitO0 = o0(j5, j6);
        boolean z9 = (periodLimitO0 == null || periodLimitO0.isEnable() != z5 || periodLimitO0.isNotifyOnly() == z6) ? false : true;
        if (periodLimitO0 != null) {
            z8 = z9;
            long jC = this.f6433f.c(this.f6444q, periodLimitO0.getId());
            if (periodLimitO0.isEnable() == z5 && periodLimitO0.isNotifyOnly() == z6 && periodLimitO0.getVersion() >= jC) {
                R1.a.a("LimitManager", "setCategoryPeriodLimit no change");
                return null;
            }
        } else {
            z8 = z9;
        }
        if (periodLimitO0 == null) {
            periodLimitO0 = P0(j5, j6);
        }
        C(periodLimitO0);
        periodLimitO0.setEnable(z5);
        periodLimitO0.setNotifyOnly(z6);
        periodLimitO0.setChild(z7);
        if (z5) {
            E0(periodLimitO0);
            t(periodLimitO0, !z8);
        }
        this.f6431d.f(periodLimitO0);
        if (I0(j5, System.currentTimeMillis())) {
            this.f6436i.e(j5, false);
        } else {
            this.f6436i.J(j5);
        }
        return periodLimitO0;
    }

    public synchronized long l(long j5, long j6, RawPeriod rawPeriod) {
        C0702g.b("LimitManager", "addPackagePeriod categoryId = " + j5 + " adminId = " + j6 + " rawPeriod = " + rawPeriod);
        PeriodLimit periodLimitA = this.f6431d.a(j5, j6);
        if (periodLimitA != null) {
            return o(periodLimitA.getId(), rawPeriod);
        }
        R1.a.l("LimitManager", "addCategoryPeriod can not find PeriodLimit categoryId = " + j5);
        return -1L;
    }

    public synchronized void l1() {
        C0702g.O("LimitManager", "onClockJumpReschedule");
        t2();
        L1();
    }

    public synchronized long m(long j5, RawPeriod rawPeriod) {
        C0702g.b("LimitManager", "addGlobalPeriod adminId = " + j5 + " rawPeriod = " + rawPeriod);
        PeriodLimit periodLimitE = this.f6431d.e(j5);
        if (periodLimitE != null) {
            return o(periodLimitE.getId(), rawPeriod);
        }
        R1.a.l("LimitManager", "addGlobalPeriod can not find PeriodLimit adminId = " + j5);
        return -1L;
    }

    public synchronized List<PackageLimit> m0() {
        return this.f6428a.a(this.f6444q);
    }

    public synchronized void m1(String str) {
        try {
            C0702g.b("LimitManager", "onClonePackageAdd packageName = " + str);
            PackageLimit packageLimitE = this.f6428a.e(str, this.f6444q);
            if (packageLimitE != null) {
                packageLimitE.setInstalled(true);
            }
            Category categoryZ = this.f6443p.z(str);
            int id = categoryZ == null ? 0 : categoryZ.getId();
            C0702g.b("LimitManager", "onClonePackageAdd packageName = " + str + " categoryId = " + id);
            CategoryLimit categoryLimitG = this.f6429b.g(id, this.f6444q);
            if (categoryLimitG != null && categoryLimitG.isEnable()) {
                if (categoryLimitG.getCurrentLimit(this.f6437j) == 0) {
                    E2(categoryLimitG);
                } else {
                    J2(categoryLimitG);
                    E2(categoryLimitG);
                }
            }
            if (packageLimitE != null) {
                H2(packageLimitE);
            }
            GlobalLimit globalLimitC = this.f6430c.c(this.f6444q);
            if (globalLimitC != null) {
                L2(globalLimitC);
                F2(globalLimitC);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void m2(boolean z5) {
        if (this.f6449v == z5) {
            return;
        }
        this.f6449v = z5;
        R1(z5);
        if (!this.f6449v) {
            E();
        }
        this.f6439l.P();
    }

    public synchronized long n(String str, long j5, RawPeriod rawPeriod) {
        C0702g.b("LimitManager", "addPackagePeriod packageName = " + str + " adminId = " + j5 + " rawPeriod = " + rawPeriod);
        PeriodLimit periodLimitD = this.f6431d.d(str, j5);
        if (periodLimitD != null) {
            return o(periodLimitD.getId(), rawPeriod);
        }
        R1.a.l("LimitManager", "addPackagePeriod can not find PeriodLimit packageName = " + str);
        return -1L;
    }

    public List<PeriodLimit> n0(long j5) {
        return this.f6431d.h(0, j5);
    }

    public synchronized void n1(int i5, String[] strArr, long j5, int i6) {
        int i7;
        StringBuilder sb = new StringBuilder();
        sb.append("onGlobalApproached packageNames = ");
        sb.append(C0702g.h(strArr));
        sb.append(" observerId = ");
        sb.append(i5);
        sb.append(" limitTime = ");
        long jM = j5;
        sb.append(jM);
        sb.append(" type = ");
        sb.append(i6);
        sb.append(" reason = ");
        sb.append(2);
        C0702g.b("LimitManager", sb.toString());
        boolean zS = this.f6452y.s(i5);
        if (!zS && i6 != 2) {
            C0702g.b("LimitManager", "onGlobalApproached ignore duplicate observerId=" + i5);
            return;
        }
        if (!zS) {
            C0702g.b("LimitManager", "onGlobalApproached group missing, fallback by usage remaining, observerId=" + i5);
        }
        if (i5 == 4999 && i6 == 2) {
            this.f6451x = null;
            if (com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.c.t()) {
                C0684b c0684b = this.f6439l;
                com.stepos.digitalwellbeing.server.data.a aVar = com.stepos.digitalwellbeing.server.data.a.DAY;
                jM = this.f6439l.m(aVar.ordinal(), c0684b.H(aVar.ordinal(), U1(aVar.ordinal())));
            } else {
                C0702g.O("LimitManager", "onGlobalApproached skip loading global usage time: alphame version not support this operation");
            }
            F1(2, null, null, jM, i6, this.f6444q, null, -1);
            N1(this.f6444q);
            return;
        }
        GlobalLimit globalLimitC = this.f6430c.c(this.f6444q);
        long jY0 = y0(globalLimitC);
        if (globalLimitC == null) {
            C0702g.p("LimitManager", "globalLimit = null");
            return;
        }
        if (i6 == 0) {
            if (jY0 > 30000 && this.f6452y.A(strArr)) {
                C0702g.b("LimitManager", "onGlobalApproached TYPE_SUSPEND premature, reWatch remainingTime=" + jY0);
                R(globalLimitC.getId() + 1000, globalLimitC.getCurrentLimit(this.f6437j), jY0, 0, true);
                return;
            }
            C0702g.b("LimitManager", "onGlobalApproached type = TYPE_SUSPEND, remainingTime = " + jY0);
            i7 = i6;
            F1(2, null, null, jM, i7, this.f6444q, null, -1);
        } else if (i6 == 2) {
            if (jY0 > 30000) {
                C0702g.b("LimitManager", "onGlobalApproached TYPE_NOTIFY_ONLY premature, reWatch remainingTime=" + jY0);
                R(globalLimitC.getId(), globalLimitC.getCurrentLimit(this.f6437j), jY0, 2, true);
                return;
            }
            C0702g.b("LimitManager", "onGlobalApproached type = TYPE_NOTIFY_ONLY, notify, remainingTime = " + jY0);
            F1(2, null, null, j5, i6, this.f6444q, null, -1);
            i7 = i6;
        } else {
            if (jY0 - 30000 > 60000) {
                C0702g.b("LimitManager", "onGlobalApproached remainingTime = " + jY0 + " reWatch");
                R(globalLimitC.getId(), globalLimitC.getCurrentLimit(this.f6437j), jY0 - 60000, i6, true);
                return;
            }
            if (!u2(2, null, -1, jY0, globalLimitC.getCurrentLimit(this.f6437j))) {
                C0702g.b("LimitManager", "onGlobalApproached TYPE_NOTIFY skip unused/background remainingTime=" + jY0);
                O1(2, globalLimitC.getId(), null, -1, globalLimitC.getCurrentLimit(this.f6437j), jY0);
                return;
            }
            i7 = i6;
            F1(2, null, null, j5, i7, this.f6444q, null, -1);
        }
        if (i7 == 0) {
            O(globalLimitC.getId());
            globalLimitC.setSuspended(true);
            this.f6430c.b(globalLimitC);
            R1.a.a("LimitManager", "globalLimit = " + globalLimitC + " setSuspended true");
            e1("g");
            this.f6436i.i(false);
            B2(this.f6437j, false, false, j5, false);
        } else if (i7 == 2) {
            T2(this.f6438k, i5);
        }
        globalLimitC.getAdminId();
    }

    public synchronized boolean n2(int i5, long j5, long j6, boolean z5, boolean z6, long j7, boolean z7) {
        try {
            C0702g.b("LimitManager", "setGlobalLimit interval = " + i5 + " workdayLimit = " + C0711p.m(this.f6437j, j5) + " offDayLimit = " + C0711p.m(this.f6437j, j6) + " enable = " + z5 + " notifyOnly = " + z6);
            if (!this.f6445r) {
                C0702g.b("LimitManager", "not inited");
                o1();
            }
            long j8 = this.f6444q;
            if (j8 != j7) {
                C0702g.O("LimitManager", "mCurrentAdminId = " + this.f6444q + " adminId = " + j7);
                return false;
            }
            if (j5 < -1 || j6 < -1) {
                C0702g.O("LimitManager", "Illegal workdayLimit = " + j5 + " offDayLimit = " + j6);
                return false;
            }
            GlobalLimit globalLimitC = this.f6430c.c(j8);
            if (globalLimitC == null) {
                if (z5) {
                    GlobalLimit globalLimitK = K(i5, j5, j6, z5, z6, j7, z7);
                    globalLimitK.setId(this.f6430c.a(globalLimitK));
                    q1(globalLimitK);
                }
                return z5;
            }
            GlobalLimit globalLimitM3clone = globalLimitC.m3clone();
            globalLimitC.setWorkdayLimit(j5);
            globalLimitC.setOffDayLimit(j6);
            globalLimitC.setEnable(z5);
            globalLimitC.setNotifyOnly(z6);
            globalLimitC.setChild(z7);
            this.f6430c.b(globalLimitC);
            return C1(globalLimitM3clone, globalLimitC);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized long o(long j5, RawPeriod rawPeriod) throws Throwable {
        try {
            C0702g.b("LimitManager", "addPeriod limitId = " + j5 + " rawPeriod = " + rawPeriod);
            PeriodLimit periodLimitI = this.f6431d.i(j5);
            if (periodLimitI == null) {
                C0702g.p("LimitManager", "addPeriod can not find PeriodLimit limitId = " + j5);
                return -1L;
            }
            rawPeriod.setLimitId(periodLimitI.getId());
            this.f6447t.b();
            try {
                try {
                    C(periodLimitI);
                    long jD = this.f6432e.d(rawPeriod);
                    E0(periodLimitI);
                    if (periodLimitI.isEnable()) {
                        s(periodLimitI);
                    }
                    this.f6447t.s();
                    this.f6447t.f();
                    try {
                        M1(periodLimitI, System.currentTimeMillis(), this.f6444q);
                        return jD;
                    } catch (Throwable th) {
                        th = th;
                        this = this;
                        Throwable th2 = th;
                        throw th2;
                    }
                } catch (Throwable th3) {
                    this.f6447t.f();
                    throw th3;
                }
            } catch (Exception unused) {
                this.f6447t.f();
                return -1L;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public PeriodLimit o0(long j5, long j6) {
        PeriodLimit periodLimitA = this.f6431d.a(j5, j6);
        C0702g.b("LimitManager", "getPeriodLimit categoryId = " + j5 + " result = " + periodLimitA);
        return periodLimitA;
    }

    public synchronized void o1() {
        try {
            C0702g.b("LimitManager", "onInit START");
            C0718w.g().h();
            this.f6444q = c0();
            C0702g.b("LimitManager", "onInit() mCurrentAdminId = " + this.f6444q);
            List<String> listD1 = d1(this.f6444q);
            this.f6450w.put(Long.valueOf(this.f6444q), listD1);
            C0582c c0582c = new C0582c(this.f6437j);
            this.f6436i = c0582c;
            c0582c.r(this.f6447t.z(), this.f6443p, listD1);
            List<PackageLimit> listA = this.f6428a.a(this.f6444q);
            if (listA != null) {
                for (PackageLimit packageLimit : listA) {
                    packageLimit.setInstalled(PackageUtils.h(this.f6437j.getApplicationContext()).p(packageLimit.getPackageName()));
                    this.f6428a.d(packageLimit);
                }
            }
            t2();
            this.f6449v = c1();
            this.f6445r = true;
            I1();
            N1(this.f6444q);
            C0702g.b("LimitManager", "onInit END mEnable = " + this.f6449v);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized PeriodLimit o2(long j5, boolean z5, boolean z6, boolean z7) throws Throwable {
        l lVar;
        Throwable th;
        try {
            try {
                C0702g.b("LimitManager", "setGlobalPeriodLimit adminId = " + j5 + " enable = " + z5 + " notifyOnly = " + z6 + " isChild = " + z7);
            } catch (Throwable th2) {
                th = th2;
                th = th;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            lVar = this;
            th = th;
            throw th;
        }
        try {
            if (j5 != this.f6444q) {
                R1.a.a("LimitManager", "setGlobalPeriodLimit adminId = " + j5 + " mCurrentAdminId = " + this.f6444q + " illegal adminId");
                return null;
            }
            PeriodLimit periodLimitE0 = e0(j5);
            boolean z8 = (periodLimitE0 == null || periodLimitE0.isEnable() != z5 || periodLimitE0.isNotifyOnly() == z6) ? false : true;
            if (periodLimitE0 != null) {
                long jC = this.f6433f.c(this.f6444q, periodLimitE0.getId());
                if (periodLimitE0.isEnable() == z5 && periodLimitE0.isNotifyOnly() == z6 && periodLimitE0.getVersion() >= jC) {
                    R1.a.a("LimitManager", "setGlobalPeriodLimit no change");
                    return null;
                }
            }
            if (periodLimitE0 == null) {
                periodLimitE0 = O0(j5);
            }
            C(periodLimitE0);
            periodLimitE0.setEnable(z5);
            periodLimitE0.setNotifyOnly(z6);
            periodLimitE0.setChild(z7);
            if (z5) {
                E0(periodLimitE0);
                t(periodLimitE0, !z8);
            }
            this.f6431d.f(periodLimitE0);
            PeriodLimit periodLimit = periodLimitE0;
            M1(periodLimit, System.currentTimeMillis(), this.f6444q);
            return periodLimit;
        } catch (Throwable th4) {
            th = th4;
            lVar = this;
            throw th;
        }
    }

    public synchronized void p(String str) {
        q(str, true, this.f6444q);
    }

    public PeriodLimit p0(String str, long j5) {
        PeriodLimit periodLimitD = this.f6431d.d(str, j5);
        C0702g.b("LimitManager", "getPeriodLimit packageName = " + str + " result = " + periodLimitD);
        return periodLimitD;
    }

    public synchronized void q(String str, boolean z5, long j5) {
        C0582c c0582c;
        try {
            C0702g.b("LimitManager", "addWhitelistApp packageName = " + str + " adminId = " + j5);
            this.f6434g.h(new WhitelistApp(j5, str, z5));
            List<String> arrayList = this.f6450w.get(Long.valueOf(j5));
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f6450w.put(Long.valueOf(j5), arrayList);
            }
            arrayList.add(str);
            if (this.f6444q == j5 && (c0582c = this.f6436i) != null) {
                c0582c.Q(arrayList);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public List<RawPeriod> q0(long j5) {
        List<RawPeriod> listB = this.f6432e.b(j5);
        C0702g.b("LimitManager", "getRawPeriod periodLimitId = " + j5 + "periodLimits = " + C0702g.k(listB));
        return listB;
    }

    public List<RawPeriod> r0(long j5, long j6) {
        PeriodLimit periodLimitA = this.f6431d.a(j5, j6);
        if (periodLimitA == null) {
            C0702g.O("LimitManager", "getRawPeriodByPackageName periodLimit = null");
            return null;
        }
        List<RawPeriod> listB = this.f6432e.b(periodLimitA.getId());
        C0702g.b("LimitManager", "getRawPeriod categoryId = " + j5 + " periodLimits = " + C0702g.k(listB));
        return listB;
    }

    public synchronized boolean r2(int i5, String str, long j5, long j6, boolean z5, boolean z6, long j7, boolean z7) {
        try {
            C0702g.b("LimitManager", "setPackageLimit interval = " + i5 + " packageName = " + str + " workdayLimit = " + C0711p.m(this.f6437j, j5) + " offDayLimit = " + C0711p.m(this.f6437j, j6) + " enable = " + z5 + " notifyOnly = " + z6 + " adminId = " + j7);
            if (!this.f6445r) {
                C0702g.b("LimitManager", "not inited");
                o1();
            }
            if (this.f6444q != j7) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (j5 < -1 || j6 < -1) {
                return false;
            }
            com.stepos.digitalwellbeing.server.limit.data.room.e eVar = this.f6428a;
            PackageLimit packageLimitE = eVar.e(str, this.f6444q);
            if (packageLimitE == null) {
                PackageLimit packageLimitL = L(i5, str, j5, j6, z5, z6, j7, z7);
                packageLimitL.setId(eVar.b(packageLimitL));
                r1(packageLimitL);
                return z5;
            }
            PackageLimit packageLimitM4clone = packageLimitE.m4clone();
            packageLimitE.setWorkdayLimit(j5);
            packageLimitE.setOffDayLimit(j6);
            packageLimitE.setEnable(z5);
            packageLimitE.setInstalled(PackageUtils.h(this.f6437j.getApplicationContext()).o(str));
            packageLimitE.setNotifyOnly(z6);
            packageLimitE.setChild(z7);
            eVar.d(packageLimitE);
            return D1(packageLimitM4clone, packageLimitE);
        } catch (Throwable th) {
            throw th;
        }
    }

    public List<RawPeriod> s0(String str, long j5) {
        PeriodLimit periodLimitD = this.f6431d.d(str, j5);
        if (periodLimitD == null) {
            C0702g.O("LimitManager", "getRawPeriodByPackageName periodLimit = null");
            return null;
        }
        List<RawPeriod> listB = this.f6432e.b(periodLimitD.getId());
        C0702g.b("LimitManager", "getRawPeriod packageName = " + str + " periodLimits = " + C0702g.k(listB));
        return listB;
    }

    public synchronized void s1() {
        C0702g.b("LimitManager", "onNextDay time = " + System.currentTimeMillis());
        t2();
        L1();
        c2();
    }

    public synchronized PeriodLimit s2(String str, long j5, boolean z5, boolean z6, boolean z7) {
        boolean z8;
        C0702g.b("LimitManager", "setPackagePeriodLimit packageName = " + str + " adminId = " + j5 + " enable = " + z5 + " notifyOnly = " + z6 + " isChild = " + z7);
        if (j5 != this.f6444q) {
            R1.a.a("LimitManager", "setPackagePeriodLimit adminId = " + j5 + " mCurrentAdminId = " + this.f6444q + " illegal adminId");
            return null;
        }
        PeriodLimit periodLimitP0 = p0(str, j5);
        boolean z9 = (periodLimitP0 == null || periodLimitP0.isEnable() != z5 || periodLimitP0.isNotifyOnly() == z6) ? false : true;
        if (periodLimitP0 != null) {
            z8 = z9;
            long jC = this.f6433f.c(this.f6444q, periodLimitP0.getId());
            if (periodLimitP0.isEnable() == z5 && periodLimitP0.isNotifyOnly() == z6 && periodLimitP0.getVersion() >= jC) {
                R1.a.a("LimitManager", "setPackagePeriodLimit no change");
                return null;
            }
        } else {
            z8 = z9;
        }
        if (periodLimitP0 == null) {
            periodLimitP0 = Q0(str, j5);
        }
        C(periodLimitP0);
        periodLimitP0.setEnable(z5);
        periodLimitP0.setNotifyOnly(z6);
        periodLimitP0.setChild(z7);
        if (z5) {
            E0(periodLimitP0);
            t(periodLimitP0, !z8);
        }
        this.f6431d.f(periodLimitP0);
        if (K0(str, System.currentTimeMillis()) && z5) {
            this.f6436i.c(str, false);
        } else {
            this.f6436i.H(str);
        }
        return periodLimitP0;
    }

    public synchronized void u1(String str) {
        try {
            C0702g.b("LimitManager", "onPackageAdded packageName = " + str);
            PackageLimit packageLimitE = this.f6428a.e(str, this.f6444q);
            if (packageLimitE != null) {
                packageLimitE.setInstalled(true);
            }
            Category categoryZ = this.f6443p.z(str);
            int id = categoryZ == null ? 0 : categoryZ.getId();
            C0702g.b("LimitManager", "onPackageAdded packageName = " + str + " categoryId = " + id);
            CategoryLimit categoryLimitG = this.f6429b.g(id, this.f6444q);
            GlobalLimit globalLimitC = this.f6430c.c(this.f6444q);
            if (categoryLimitG != null && categoryLimitG.isEnable()) {
                if (categoryLimitG.getCurrentLimit(this.f6437j) == 0) {
                    E2(categoryLimitG);
                } else {
                    J2(categoryLimitG);
                    E2(categoryLimitG);
                }
            }
            if (packageLimitE != null) {
                H2(packageLimitE);
            }
            if (globalLimitC != null) {
                L2(globalLimitC);
                F2(globalLimitC);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x025e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void v1(int r19, java.lang.String[] r20, long r21, int r23) {
        /*
            Method dump skipped, instructions count: 623
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Y1.l.v1(int, java.lang.String[], long, int):void");
    }

    public synchronized void w1(String str) {
        C0702g.b("LimitManager", "onPackageRemoved packageName = " + str);
        PackageLimit packageLimitE = this.f6428a.e(str, this.f6444q);
        Category categoryI = this.f6443p.i(str);
        if (categoryI != null) {
            categoryI.remove(str);
        }
        if (packageLimitE == null) {
            return;
        }
        packageLimitE.setInstalled(false);
        this.f6428a.d(packageLimitE);
    }

    public synchronized void x1(Bundle bundle) {
        String strB0 = b0(this.f6437j.getApplicationContext());
        C0702g.b("LimitManager", "onPeriodLockApproached() called with: bundle = " + C0702g.i(bundle));
        if (bundle == null) {
            R1.a.b("LimitManager", "onPeriodLockApproach bundle = null");
            return;
        }
        A(bundle);
        int i5 = bundle.getInt("limit_type");
        long j5 = bundle.getLong("admin_id", this.f6444q);
        if (i5 == 1) {
            long j6 = bundle.getLong("category_id");
            if (!J0(j6, System.currentTimeMillis(), j5)) {
                C0702g.b("LimitManager", "onPeriodLockApproached skip stale category period lock, categoryId=" + j6 + " adminId=" + j5);
                return;
            }
            this.f6436i.e(j6, false);
            R1.a.a("LimitManager", "onPeriodNotifyApproached type = TYPE_CATEGORY categoryId = " + j6 + " foregroundPackage = " + strB0);
            int i6 = (int) j6;
            Category categoryK = this.f6443p.k(i6);
            if (categoryK == null) {
                return;
            }
            if (categoryK.getPackages().contains(strB0)) {
                z2(this.f6437j, i6, false, true);
            }
        } else if (i5 == 0) {
            String string = bundle.getString("packageName");
            if (!L0(string, System.currentTimeMillis(), j5)) {
                C0702g.b("LimitManager", "onPeriodLockApproached skip stale package period lock, packageName=" + string + " adminId=" + j5);
                return;
            }
            this.f6436i.c(string, false);
            if (TextUtils.equals(strB0, string)) {
                x2(this.f6437j, string, false, true);
            }
        } else if (i5 == 2) {
            if (!H0(System.currentTimeMillis(), j5)) {
                C0702g.b("LimitManager", "onPeriodLockApproached skip stale global period lock, adminId=" + j5);
                return;
            }
            this.f6436i.h(false);
            B2(this.f6437j, false, true, 0L, false);
        }
    }

    public synchronized void y1(Bundle bundle, int i5) throws Throwable {
        l lVar;
        try {
            if (bundle == null) {
                return;
            }
            try {
                A(bundle);
                int i6 = bundle.getInt("limit_type", 0);
                long j5 = bundle.getLong("admin_id");
                long j6 = bundle.getLong("time", -1L);
                PendingIntent pendingIntentC0 = C0(this.f6437j);
                if (i6 == 0) {
                    String string = bundle.getString("packageName");
                    PackageUtils.AppInfo appInfoM = PackageUtils.h(this.f6437j).m(string);
                    if (appInfoM == null) {
                        return;
                    }
                    lVar = this;
                    if (!lVar.P2(i6, string, -1L, j5, j6, 2) && (i5 == 2 || i5 == 1)) {
                        C0702g.b("LimitManager", "onPeriodNotifyApproached skip duplicate packageName=" + string + " periodTime=" + j6 + " type=" + i5);
                        return;
                    }
                    n.e(lVar.f6437j, false, null, appInfoM.label, i5, j5, pendingIntentC0);
                } else {
                    lVar = this;
                    if (i6 == 1) {
                        long j7 = bundle.getLong("category_id");
                        Category categoryK = lVar.f6443p.k((int) j7);
                        if (categoryK == null) {
                            return;
                        }
                        String string2 = lVar.f6437j.getString(categoryK.getNameResourceId());
                        if (!lVar.P2(i6, null, j7, j5, j6, 2) && (i5 == 2 || i5 == 1)) {
                            C0702g.b("LimitManager", "onPeriodNotifyApproached skip duplicate categoryId=" + j7 + " periodTime=" + j6 + " type=" + i5);
                            return;
                        }
                        n.e(lVar.f6437j, true, string2, null, i5, j5, pendingIntentC0);
                    } else {
                        if (!lVar.P2(i6, null, -1L, j5, j6, 2) && (i5 == 2 || i5 == 1)) {
                            C0702g.b("LimitManager", "onPeriodNotifyApproached skip duplicate global periodTime=" + j6 + " type=" + i5);
                            return;
                        }
                        n.c(lVar.f6437j, j5, pendingIntentC0, i5);
                    }
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public synchronized void z1(Bundle bundle) {
        if (bundle == null) {
            R1.a.b("LimitManager", "onPeriodLockApproach bundle = null");
            return;
        }
        A(bundle);
        C0702g.b("LimitManager", "onPeriodUnlockApproached() called with: bundle = " + C0702g.i(bundle));
        int i5 = bundle.getInt("limit_type");
        if (i5 == 1) {
            long j5 = bundle.getLong("category_id");
            R1.a.a("LimitManager", "onPeriodUnlockApproached type = TYPE_CATEGORY categoryId = " + j5);
            this.f6436i.J(j5);
        } else if (i5 == 0) {
            String string = bundle.getString("packageName");
            R1.a.a("LimitManager", "onPeriodUnlockApproached type = TYPE_PACKAGE packageName = " + string);
            this.f6436i.H(string);
        } else {
            R1.a.a("LimitManager", "onPeriodUnlockApproached type = TYPE_GLOBAL");
            this.f6436i.M();
        }
    }
}
