package com.stepos.digitalwellbeing.server;

import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.stepos.digitalwellbeing.appwidget.AppWidgetManagerService;
import com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface;
import com.stepos.digitalwellbeing.server.data.Category;
import com.stepos.digitalwellbeing.server.data.CategoryLimitInfo;
import com.stepos.digitalwellbeing.server.data.CategoryUsingTimeStats;
import com.stepos.digitalwellbeing.server.data.DataToken;
import com.stepos.digitalwellbeing.server.data.GlobalLimitInfo;
import com.stepos.digitalwellbeing.server.data.NotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PackageLimitInfo;
import com.stepos.digitalwellbeing.server.data.PackageNotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PackageUsingTimeStats;
import com.stepos.digitalwellbeing.server.data.PeriodLimitInfo;
import com.stepos.digitalwellbeing.server.data.PickupTimesStats;
import com.stepos.digitalwellbeing.server.data.RawPeriodInfo;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.digitalwellbeing.server.data.UsingTimeStats;
import com.stepos.digitalwellbeing.server.data.WhitelistAppInfo;
import com.stepos.digitalwellbeing.server.limit.data.room.CategoryLimit;
import com.stepos.digitalwellbeing.server.limit.data.room.GlobalLimit;
import com.stepos.digitalwellbeing.server.limit.data.room.PackageLimit;
import com.stepos.digitalwellbeing.server.limit.data.room.PeriodLimit;
import com.stepos.digitalwellbeing.server.limit.data.room.RawPeriod;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import com.stepos.minor.Minor;
import com.stepos.minor.WhitelistApp;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import e2.C0684b;
import f2.C0697b;
import f2.C0698c;
import f2.C0702g;
import f2.C0711p;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public class DigitalWellbeingService extends Service implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    private HandlerThread f14503a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f14504b;

    /* renamed from: c, reason: collision with root package name */
    private ExecutorService f14505c;

    /* renamed from: d, reason: collision with root package name */
    private volatile long f14506d;

    /* renamed from: g, reason: collision with root package name */
    private C0684b f14509g;

    /* renamed from: h, reason: collision with root package name */
    private Y1.l f14510h;

    /* renamed from: i, reason: collision with root package name */
    private W1.c f14511i;

    /* renamed from: n, reason: collision with root package name */
    private long f14516n;

    /* renamed from: o, reason: collision with root package name */
    private a f14517o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f14518p;

    /* renamed from: q, reason: collision with root package name */
    private Configuration f14519q;

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f14507e = new Runnable() { // from class: com.stepos.digitalwellbeing.server.j
        @Override // java.lang.Runnable
        public final void run() {
            this.f14562a.N();
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f14508f = new Runnable() { // from class: com.stepos.digitalwellbeing.server.k
        @Override // java.lang.Runnable
        public final void run() {
            this.f14563a.C();
        }
    };

    /* renamed from: j, reason: collision with root package name */
    private boolean f14512j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f14513k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f14514l = false;

    /* renamed from: m, reason: collision with root package name */
    private final Object f14515m = new Object();

    /* renamed from: r, reason: collision with root package name */
    private final IDigitalWellbeingInterface.Stub f14520r = new IDigitalWellbeingInterface.Stub() { // from class: com.stepos.digitalwellbeing.server.DigitalWellbeingService.1
        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long addCategoryPeriod(long j5, RawPeriodInfo rawPeriodInfo) {
            return addCategoryPeriodWithAdmin(j5, rawPeriodInfo, DigitalWellbeingService.this.f14510h.Y());
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long addCategoryPeriodWithAdmin(long j5, RawPeriodInfo rawPeriodInfo, long j6) {
            if (j6 != DigitalWellbeingService.this.f14510h.Y()) {
                R1.a.b("DigitalWellbeingService", "addPeriod not currentAdmin");
                return -1L;
            }
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "addCategoryPeriod");
            C0702g.y("DigitalWellbeingService", "categoryId=" + DigitalWellbeingService.this.getString(W1.c.m((int) j5)) + " period=" + rawPeriodInfo + " adminId=" + j6);
            long jL = DigitalWellbeingService.this.f14510h.l(j5, j6, new RawPeriod(rawPeriodInfo));
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, Long.valueOf(jL));
            return jL;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long addGlobalPeriod(RawPeriodInfo rawPeriodInfo) {
            return addGlobalPeriodWithAdmin(rawPeriodInfo, DigitalWellbeingService.this.f14510h.Y());
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long addGlobalPeriodWithAdmin(RawPeriodInfo rawPeriodInfo, long j5) {
            if (j5 != DigitalWellbeingService.this.f14510h.Y()) {
                R1.a.b("DigitalWellbeingService", "addPeriod not currentAdmin");
                return -1L;
            }
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "addGlobalPeriod");
            C0702g.y("DigitalWellbeingService", "period=" + rawPeriodInfo + " adminId=" + j5);
            long jM = DigitalWellbeingService.this.f14510h.m(j5, new RawPeriod(rawPeriodInfo));
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, Long.valueOf(jM));
            return jM;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long addPackagePeriod(String str, RawPeriodInfo rawPeriodInfo) {
            return addPackagePeriodWithAdmin(str, rawPeriodInfo, DigitalWellbeingService.this.f14510h.Y());
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long addPackagePeriodWithAdmin(String str, RawPeriodInfo rawPeriodInfo, long j5) {
            if (j5 != DigitalWellbeingService.this.f14510h.Y()) {
                R1.a.b("DigitalWellbeingService", "addPeriod not currentAdmin");
                return -1L;
            }
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "addPeriod");
            C0702g.y("DigitalWellbeingService", "packageName=" + str + " period=" + rawPeriodInfo + " adminId=" + j5);
            long jN = DigitalWellbeingService.this.f14510h.n(str, j5, new RawPeriod(rawPeriodInfo));
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, Long.valueOf(jN));
            return jN;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long addPeriod(long j5, RawPeriodInfo rawPeriodInfo) {
            return addPeriodWithAdmin(j5, rawPeriodInfo, DigitalWellbeingService.this.f14510h.Y());
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long addPeriodWithAdmin(long j5, RawPeriodInfo rawPeriodInfo, long j6) throws Throwable {
            if (j6 != DigitalWellbeingService.this.f14510h.Y()) {
                R1.a.b("DigitalWellbeingService", "addPeriod not currentAdmin");
                return -1L;
            }
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "addPeriod");
            C0702g.y("DigitalWellbeingService", "periodLimitId=" + j5 + " period=" + rawPeriodInfo + " adminId=" + j6);
            long jO = DigitalWellbeingService.this.f14510h.o(j5, new RawPeriod(rawPeriodInfo));
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, Long.valueOf(jO));
            return jO;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public void addWhitelistApp(WhitelistAppInfo whitelistAppInfo) {
            DigitalWellbeingService.this.f14510h.p(whitelistAppInfo.getPackageName());
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public void clearAdminLimit(long j5) {
            DigitalWellbeingService.this.f14510h.D(j5);
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public Category[] getCategories(boolean z5) {
            List<Category> listX = z5 ? DigitalWellbeingService.this.f14511i.x(z5) : DigitalWellbeingService.this.f14511i.j();
            Category[] categoryArr = new Category[listX.size()];
            listX.toArray(categoryArr);
            return categoryArr;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo[] getCategoriesPeriodLimitInfo(long j5) {
            List<PeriodLimit> listZ = DigitalWellbeingService.this.f14510h.Z(j5);
            if (listZ == null) {
                return new PeriodLimitInfo[0];
            }
            int size = listZ.size();
            PeriodLimitInfo[] periodLimitInfoArr = new PeriodLimitInfo[size];
            for (int i5 = 0; i5 < size; i5++) {
                PeriodLimit periodLimit = listZ.get(i5);
                if (periodLimit != null) {
                    periodLimitInfoArr[i5] = new PeriodLimitInfo(periodLimit);
                }
            }
            return periodLimitInfoArr;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public Category getCategory(boolean z5, int i5) {
            if (z5) {
                DigitalWellbeingService.this.f14511i.x(z5);
            }
            return DigitalWellbeingService.this.f14511i.k(i5);
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo getCategoryPeriodLimitInfo(long j5, long j6) {
            PeriodLimit periodLimitO0 = DigitalWellbeingService.this.f14510h.o0(j5, j6);
            if (periodLimitO0 == null) {
                return null;
            }
            return new PeriodLimitInfo(periodLimitO0);
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public RawPeriodInfo[] getCategoryRawPeriod(long j5) {
            return getCategoryRawPeriodWithAdmin(j5, DigitalWellbeingService.this.f14510h.Y());
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public RawPeriodInfo[] getCategoryRawPeriodWithAdmin(long j5, long j6) {
            List<RawPeriod> listR0 = DigitalWellbeingService.this.f14510h.r0(j5, j6);
            if (listR0 == null) {
                return new RawPeriodInfo[0];
            }
            int size = listR0.size();
            RawPeriodInfo[] rawPeriodInfoArr = new RawPeriodInfo[size];
            for (int i5 = 0; i5 < size; i5++) {
                RawPeriod rawPeriod = listR0.get(i5);
                if (rawPeriod != null) {
                    rawPeriodInfoArr[i5] = new RawPeriodInfo(rawPeriod);
                }
            }
            return rawPeriodInfoArr;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public CategoryUsingTimeStats[] getCategoryUsingTimeStats(int i5, DataToken dataToken) {
            return DigitalWellbeingService.this.f14509g.j(i5, dataToken);
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long getCurrentAdmin() {
            return DigitalWellbeingService.this.f14510h.Y();
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo getGlobalPeriodLimitInfo(long j5) {
            PeriodLimit periodLimitE0 = DigitalWellbeingService.this.f14510h.e0(j5);
            if (periodLimitE0 == null) {
                return null;
            }
            return new PeriodLimitInfo(periodLimitE0);
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public RawPeriodInfo[] getGlobalRawPeriod() {
            return getGlobalRawPeriodWithAdmin(DigitalWellbeingService.this.f14510h.Y());
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public RawPeriodInfo[] getGlobalRawPeriodWithAdmin(long j5) {
            List<RawPeriod> listF0 = DigitalWellbeingService.this.f14510h.f0(j5);
            if (listF0 == null) {
                return new RawPeriodInfo[0];
            }
            int size = listF0.size();
            RawPeriodInfo[] rawPeriodInfoArr = new RawPeriodInfo[size];
            for (int i5 = 0; i5 < size; i5++) {
                RawPeriod rawPeriod = listF0.get(i5);
                if (rawPeriod != null) {
                    rawPeriodInfoArr[i5] = new RawPeriodInfo(rawPeriod);
                }
            }
            return rawPeriodInfoArr;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public CategoryLimitInfo[] getLimitedCategoriesInfo(boolean z5) {
            List<CategoryLimit> listA0 = DigitalWellbeingService.this.f14510h.a0();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (listA0 == null) {
                return null;
            }
            int size = listA0.size();
            CategoryLimitInfo[] categoryLimitInfoArr = new CategoryLimitInfo[size];
            int i5 = 0;
            while (i5 < size) {
                CategoryLimit categoryLimit = listA0.get(i5);
                int i6 = i5;
                categoryLimitInfoArr[i6] = new CategoryLimitInfo(categoryLimit.getInterval(), jCurrentTimeMillis, 0L, categoryLimit.getWorkdayLimit(), categoryLimit.getOffDayLimit(), categoryLimit.isEnable(), categoryLimit.isNotifyOnly(), categoryLimit.getCategoryId());
                i5 = i6 + 1;
            }
            return categoryLimitInfoArr;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public CategoryLimitInfo getLimitedCategoryInfo(boolean z5, int i5) {
            CategoryLimitInfo[] limitedCategoriesInfo = getLimitedCategoriesInfo(z5);
            if (limitedCategoriesInfo == null) {
                return null;
            }
            for (CategoryLimitInfo categoryLimitInfo : limitedCategoriesInfo) {
                if (categoryLimitInfo.getCategoryId() == i5) {
                    return categoryLimitInfo;
                }
            }
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public GlobalLimitInfo getLimitedGlobalInfo(boolean z5) {
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            GlobalLimit globalLimitD0 = DigitalWellbeingService.this.f14510h.d0();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (globalLimitD0 == null) {
                return null;
            }
            return new GlobalLimitInfo(globalLimitD0, jCurrentTimeMillis);
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PackageLimitInfo getLimitedPackageInfo(boolean z5, String str) {
            PackageLimitInfo[] limitedPackagesInfo = getLimitedPackagesInfo(z5);
            if (limitedPackagesInfo == null) {
                return null;
            }
            for (PackageLimitInfo packageLimitInfo : limitedPackagesInfo) {
                if (packageLimitInfo.getPackageName().equals(str)) {
                    return packageLimitInfo;
                }
            }
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PackageLimitInfo[] getLimitedPackagesInfo(boolean z5) {
            List<PackageLimit> listM0 = DigitalWellbeingService.this.f14510h.m0();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (listM0 == null) {
                return null;
            }
            int size = listM0.size();
            PackageLimitInfo[] packageLimitInfoArr = new PackageLimitInfo[size];
            int i5 = 0;
            while (i5 < size) {
                PackageLimit packageLimit = listM0.get(i5);
                PackageLimitInfo[] packageLimitInfoArr2 = packageLimitInfoArr;
                int i6 = i5;
                packageLimitInfoArr2[i6] = new PackageLimitInfo(packageLimit.getInterval(), jCurrentTimeMillis, 0L, packageLimit.getWorkdayLimit(), packageLimit.getOffDayLimit(), packageLimit.isEnable(), packageLimit.isNotifyOnly(), Y1.l.T0(packageLimit.getPackageName()), packageLimit.getPackageName());
                i5 = i6 + 1;
                packageLimitInfoArr = packageLimitInfoArr2;
            }
            return packageLimitInfoArr;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PackageNotificationTimesStats[] getPackageNotificationTimesStats(int i5, String str, DataToken dataToken) {
            return DigitalWellbeingService.this.f14509g.o(i5, str, dataToken);
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo getPackagePeriodLimitInfo(String str, long j5) {
            PeriodLimit periodLimitP0 = DigitalWellbeingService.this.f14510h.p0(str, j5);
            if (periodLimitP0 == null) {
                return null;
            }
            return new PeriodLimitInfo(periodLimitP0);
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public RawPeriodInfo[] getPackageRawPeriod(String str) {
            return getPackageRawPeriodWithAdmin(str, DigitalWellbeingService.this.f14510h.Y());
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public RawPeriodInfo[] getPackageRawPeriodWithAdmin(String str, long j5) {
            List<RawPeriod> listS0 = DigitalWellbeingService.this.f14510h.s0(str, j5);
            if (listS0 == null) {
                return new RawPeriodInfo[0];
            }
            int size = listS0.size();
            RawPeriodInfo[] rawPeriodInfoArr = new RawPeriodInfo[size];
            for (int i5 = 0; i5 < size; i5++) {
                RawPeriod rawPeriod = listS0.get(i5);
                if (rawPeriod != null) {
                    rawPeriodInfoArr[i5] = new RawPeriodInfo(rawPeriod);
                }
            }
            return rawPeriodInfoArr;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PackageUsingTimeStats[] getPackageUsingTimeStats(int i5, String str, DataToken dataToken) {
            return DigitalWellbeingService.this.f14509g.r(i5, str, dataToken);
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PackageNotificationTimesStats[] getPackagesNotificationTimesStats(int i5, DataToken dataToken) {
            return DigitalWellbeingService.this.f14509g.s(i5, dataToken);
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo[] getPackagesPeriodLimitInfo(long j5) {
            List<PeriodLimit> listN0 = DigitalWellbeingService.this.f14510h.n0(j5);
            if (listN0 == null) {
                return new PeriodLimitInfo[0];
            }
            int size = listN0.size();
            PeriodLimitInfo[] periodLimitInfoArr = new PeriodLimitInfo[size];
            for (int i5 = 0; i5 < size; i5++) {
                PeriodLimit periodLimit = listN0.get(i5);
                if (periodLimit != null) {
                    periodLimitInfoArr[i5] = new PeriodLimitInfo(periodLimit);
                }
            }
            return periodLimitInfoArr;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PackageUsingTimeStats[] getPackagesUsingTimeStats(int i5, DataToken dataToken) {
            return DigitalWellbeingService.this.f14509g.t(i5, dataToken);
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public NotificationTimesStats[] getPhoneNotificationTimesStats(int i5, DataToken dataToken) {
            return DigitalWellbeingService.this.f14509g.u(i5, dataToken);
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public UsingTimeStats[] getPhoneUsingTimeStats(int i5, DataToken dataToken) {
            return DigitalWellbeingService.this.f14509g.v(i5, dataToken);
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PickupTimesStats[] getPickupTimesStats(int i5, DataToken dataToken) {
            return DigitalWellbeingService.this.f14509g.w(i5, dataToken);
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public RawPeriodInfo[] getRawPeriod(long j5) {
            List<RawPeriod> listQ0 = DigitalWellbeingService.this.f14510h.q0(j5);
            if (listQ0 == null) {
                return new RawPeriodInfo[0];
            }
            int size = listQ0.size();
            RawPeriodInfo[] rawPeriodInfoArr = new RawPeriodInfo[size];
            for (int i5 = 0; i5 < size; i5++) {
                RawPeriod rawPeriod = listQ0.get(i5);
                if (rawPeriod != null) {
                    rawPeriodInfoArr[i5] = new RawPeriodInfo(rawPeriod);
                }
            }
            return rawPeriodInfoArr;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public StatsDataSet[] getStatsDataSets(DataToken dataToken) {
            return DigitalWellbeingService.this.f14509g.x(dataToken);
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public List<WhitelistAppInfo> getWhitelistAppList() {
            return getWhitelistAppListWithAdmin(DigitalWellbeingService.this.f14510h.Y());
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public List<WhitelistAppInfo> getWhitelistAppListWithAdmin(long j5) {
            List<WhitelistApp> listD0 = DigitalWellbeingService.this.f14510h.D0(j5);
            if (listD0 == null || listD0.isEmpty()) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            for (WhitelistApp whitelistApp : listD0) {
                if (whitelistApp != null) {
                    arrayList.add(new WhitelistAppInfo(whitelistApp.getPackageName(), whitelistApp.getMinorId(), whitelistApp.isRemovable()));
                }
            }
            return arrayList;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public void init() {
            Message.obtain(DigitalWellbeingService.this.f14504b, 11).sendToTarget();
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo initCategoryPeriodLimitInfo(long j5, long j6, boolean z5) {
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "initCategoryPeriodLimitInfo");
            C0702g.y("DigitalWellbeingService", "categoryId = " + DigitalWellbeingService.this.getString(W1.c.m((int) j5)) + " adminId=" + j6 + " isChild=" + z5);
            PeriodLimitInfo periodLimitInfo = new PeriodLimitInfo(DigitalWellbeingService.this.f14510h.P0(j5, j6));
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, periodLimitInfo);
            return periodLimitInfo;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo initGlobalPeriodLimitInfo() {
            return initGlobalPeriodLimitInfoWithAdmin(getCurrentAdmin());
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo initGlobalPeriodLimitInfoWithAdmin(long j5) {
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "initGlobalPeriodLimitInfo");
            C0702g.y("DigitalWellbeingService", "adminId=" + j5);
            PeriodLimitInfo periodLimitInfo = new PeriodLimitInfo(DigitalWellbeingService.this.f14510h.O0(j5));
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, periodLimitInfo);
            return periodLimitInfo;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo initPackagePeriodLimitInfo(String str, long j5, boolean z5) {
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "initPackagePeriodLimitInfo");
            C0702g.y("DigitalWellbeingService", "packageName = " + str + " adminId=" + j5 + " isChild=" + z5);
            PeriodLimitInfo periodLimitInfo = new PeriodLimitInfo(DigitalWellbeingService.this.f14510h.Q0(str, j5));
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, periodLimitInfo);
            return periodLimitInfo;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public boolean isEnable() {
            C0702g.b("DigitalWellbeingService", "isEnable() called ");
            synchronized (DigitalWellbeingService.this.f14515m) {
                while (!DigitalWellbeingService.this.f14514l) {
                    try {
                        try {
                            C0702g.b("DigitalWellbeingService", "queryUsageData wait ");
                            DigitalWellbeingService.this.f14515m.wait(1000L);
                            if (!DigitalWellbeingService.this.f14514l) {
                                C0702g.b("DigitalWellbeingService", "queryUsageData wait time out");
                                if (p2.g.x(DigitalWellbeingService.this) || p2.g.y(DigitalWellbeingService.this)) {
                                    Message.obtain(DigitalWellbeingService.this.f14504b, 11).sendToTarget();
                                } else {
                                    C0702g.b("DigitalWellbeingService", "no permission");
                                }
                            }
                        } catch (InterruptedException e6) {
                            e6.printStackTrace();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            C0702g.b("DigitalWellbeingService", "isEnable() go on");
            return DigitalWellbeingService.this.f14510h.S0();
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public boolean isPackageLimitable(String str) {
            return Y1.l.T0(str);
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public DataToken queryUsageData(int i5, boolean z5) {
            synchronized (DigitalWellbeingService.this.f14515m) {
                while (!DigitalWellbeingService.this.f14514l) {
                    try {
                        try {
                            C0702g.b("DigitalWellbeingService", "queryUsageData wait ");
                            DigitalWellbeingService.this.f14515m.wait(1000L);
                            if (!DigitalWellbeingService.this.f14514l) {
                                C0702g.b("DigitalWellbeingService", "queryUsageData wait time out");
                                if (p2.g.x(DigitalWellbeingService.this) || p2.g.y(DigitalWellbeingService.this)) {
                                    Message.obtain(DigitalWellbeingService.this.f14504b, 11).sendToTarget();
                                } else {
                                    C0702g.b("DigitalWellbeingService", "no permission");
                                }
                            }
                        } catch (InterruptedException e6) {
                            e6.printStackTrace();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            C0702g.b("DigitalWellbeingService", "queryUsageData go on");
            return DigitalWellbeingService.this.f14509g.G(i5, z5);
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public DataToken queryUsageDataSet(int i5, boolean z5) {
            C0702g.b("DigitalWellbeingService", "queryUsageDataSet() called with: forceRefresh = [" + z5 + "]");
            synchronized (DigitalWellbeingService.this.f14515m) {
                while (!DigitalWellbeingService.this.f14514l) {
                    try {
                        try {
                            C0702g.b("DigitalWellbeingService", "queryUsageData wait ");
                            DigitalWellbeingService.this.f14515m.wait(1000L);
                            if (!DigitalWellbeingService.this.f14514l) {
                                C0702g.b("DigitalWellbeingService", "queryUsageData wait time out");
                                if (p2.g.x(DigitalWellbeingService.this) || p2.g.y(DigitalWellbeingService.this)) {
                                    Message.obtain(DigitalWellbeingService.this.f14504b, 11).sendToTarget();
                                } else {
                                    C0702g.b("DigitalWellbeingService", "no permission");
                                }
                            }
                        } catch (InterruptedException e6) {
                            e6.printStackTrace();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            C0702g.b("DigitalWellbeingService", "queryUsageDataSet go on");
            return DigitalWellbeingService.this.f14509g.H(i5, z5);
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long removeCategoryPeriod(long j5, long j6) {
            return removeCategoryPeriodWithAdmin(j5, j6, DigitalWellbeingService.this.f14510h.Y());
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long removeCategoryPeriodWithAdmin(long j5, long j6, long j7) {
            if (j7 != DigitalWellbeingService.this.f14510h.Y()) {
                R1.a.b("DigitalWellbeingService", "removePeriod not currentAdmin");
                return -1L;
            }
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "removeCategoryPeriod");
            C0702g.y("DigitalWellbeingService", "categoryId=" + DigitalWellbeingService.this.getString(W1.c.m((int) j5)) + " periodId=" + j6 + " adminId=" + j7);
            long jW1 = DigitalWellbeingService.this.f14510h.W1(j5, j7, j6);
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, Long.valueOf(jW1));
            return jW1;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long removeGlobalPeriod(long j5) {
            return removeGlobalPeriodWithAdmin(j5, DigitalWellbeingService.this.f14510h.Y());
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long removeGlobalPeriodWithAdmin(long j5, long j6) {
            if (j6 != DigitalWellbeingService.this.f14510h.Y()) {
                R1.a.b("DigitalWellbeingService", "removePeriod not currentAdmin");
                return -1L;
            }
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "removeGlobalPeriod");
            C0702g.y("DigitalWellbeingService", "adminId=" + j6);
            long jX1 = DigitalWellbeingService.this.f14510h.X1(j6, j5);
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, Long.valueOf(jX1));
            return jX1;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long removePackagePeriod(String str, long j5) {
            return removePackagePeriodWithAdmin(str, j5, DigitalWellbeingService.this.f14510h.Y());
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long removePackagePeriodWithAdmin(String str, long j5, long j6) {
            if (j6 != DigitalWellbeingService.this.f14510h.Y()) {
                R1.a.b("DigitalWellbeingService", "removePeriod not currentAdmin");
                return -1L;
            }
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "removePackagePeriod");
            C0702g.y("DigitalWellbeingService", "packageName=" + str + " periodId=" + j5 + " adminId=" + j6);
            long jZ1 = DigitalWellbeingService.this.f14510h.Z1(str, j6, j5);
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, Long.valueOf(jZ1));
            return jZ1;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long removePeriod(long j5, long j6) {
            return removePeriodWithAdmin(j5, j6, DigitalWellbeingService.this.f14510h.Y());
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long removePeriodWithAdmin(long j5, long j6, long j7) throws Throwable {
            if (j7 != DigitalWellbeingService.this.f14510h.Y()) {
                R1.a.b("DigitalWellbeingService", "removePeriod not currentAdmin");
                return -1L;
            }
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "removePeriod");
            C0702g.y("DigitalWellbeingService", "periodLimitId=" + j5 + " periodId=" + j6 + " adminId=" + j7);
            long jA2 = DigitalWellbeingService.this.f14510h.a2(j5, j6);
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, Long.valueOf(jA2));
            return jA2;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public void removeWhitelistApp(WhitelistAppInfo whitelistAppInfo) {
            DigitalWellbeingService.this.f14510h.b2(whitelistAppInfo.getPackageName(), whitelistAppInfo.getAdminId());
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public boolean setCategoryLimitTime(int i5, int i6, long j5, long j6, boolean z5, boolean z6) {
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "setCategoryLimitTime");
            C0702g.y("DigitalWellbeingService", "interval=" + i5 + " categoryId=" + i6 + " workdayLimit=" + C0711p.m(DigitalWellbeingService.this.getApplicationContext(), j5) + " offDayLimit=" + C0711p.m(DigitalWellbeingService.this.getApplicationContext(), j6) + " enabled=" + z5 + " notifyOnly=" + z6);
            boolean zJ2 = DigitalWellbeingService.this.f14510h.j2(i5, i6, j5, j6, z5, z6, DigitalWellbeingService.this.f14510h.Y(), false);
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, Boolean.valueOf(zJ2));
            return zJ2;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public boolean setCategoryLimitTimeWithAdmin(int i5, int i6, long j5, long j6, boolean z5, boolean z6, long j7, boolean z7) {
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "setCategoryLimitTimeWithAdmin");
            C0702g.y("DigitalWellbeingService", "interval = " + i5 + " categoryId = " + DigitalWellbeingService.this.getString(W1.c.m(i6)) + " workdayLimit = " + C0711p.m(DigitalWellbeingService.this.getApplicationContext(), j5) + " offDayLimit = " + C0711p.m(DigitalWellbeingService.this.getApplicationContext(), j6) + " enabled = " + z5 + " notifyOnly = " + z6 + " isChild = " + z7);
            boolean zJ2 = DigitalWellbeingService.this.f14510h.j2(i5, i6, j5, j6, z5, z6, j7, z7);
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, Boolean.valueOf(zJ2));
            return zJ2;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo setCategoryPeriodLimit(long j5, boolean z5, boolean z6) {
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "setCategoryPeriodLimit");
            C0702g.y("DigitalWellbeingService", "categoryId=" + DigitalWellbeingService.this.getString(W1.c.m((int) j5)) + " enable=" + z5 + " notifyOnly=" + z6);
            PeriodLimit periodLimitK2 = DigitalWellbeingService.this.f14510h.k2(j5, DigitalWellbeingService.this.f14510h.Y(), z5, z6, false);
            PeriodLimitInfo periodLimitInfo = periodLimitK2 == null ? null : new PeriodLimitInfo(periodLimitK2);
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, periodLimitInfo);
            return periodLimitInfo;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo setCategoryPeriodLimitWithAdmin(long j5, boolean z5, boolean z6, long j6, boolean z7) {
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "setCategoryPeriodLimitWithAdmin");
            C0702g.y("DigitalWellbeingService", "categoryId=" + DigitalWellbeingService.this.getString(W1.c.m((int) j5)) + " enable=" + z5 + " notifyOnly=" + z6 + " admin=" + j6 + " isChild=" + z7);
            PeriodLimit periodLimitK2 = DigitalWellbeingService.this.f14510h.k2(j5, j6, z5, z6, z7);
            PeriodLimitInfo periodLimitInfo = periodLimitK2 == null ? null : new PeriodLimitInfo(periodLimitK2);
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, periodLimitInfo);
            return periodLimitInfo;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public void setCurrentAdmin(long j5) {
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "setCurrentAdmin");
            C0702g.y("DigitalWellbeingService", "adminId = " + j5);
            DigitalWellbeingService.this.f14510h.i2(j5);
            C0702g.D("DigitalWellbeingService", R1.a.f4967c);
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public void setEnable(boolean z5) {
            DigitalWellbeingService.this.f14510h.m2(z5);
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public boolean setGlobalLimitTime(int i5, long j5, long j6, boolean z5, boolean z6) {
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "setGlobalLimitTime");
            C0702g.y("DigitalWellbeingService", "interval=" + i5 + " workdayLimit=" + C0711p.m(DigitalWellbeingService.this.getApplicationContext(), j5) + " offDayLimit=" + C0711p.m(DigitalWellbeingService.this.getApplicationContext(), j6) + " enabled=" + z5 + " notifyOnly=" + z6);
            boolean zN2 = DigitalWellbeingService.this.f14510h.n2(i5, j5, j6, z5, z6, DigitalWellbeingService.this.f14510h.Y(), false);
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, Boolean.valueOf(zN2));
            return zN2;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public boolean setGlobalLimitTimeWithAdmin(int i5, long j5, long j6, boolean z5, boolean z6, long j7, boolean z7) {
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "setGlobalLimitTimeWithAdmin");
            C0702g.y("DigitalWellbeingService", "interval = " + i5 + " workdayLimit = " + C0711p.m(DigitalWellbeingService.this.getApplicationContext(), j5) + " offDayLimit = " + C0711p.m(DigitalWellbeingService.this.getApplicationContext(), j6) + " enabled = " + z5 + " notifyOnly = " + z6 + " isChild = " + z7);
            boolean zN2 = DigitalWellbeingService.this.f14510h.n2(i5, j5, j6, z5, z6, j7, z7);
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, Boolean.valueOf(zN2));
            return zN2;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo setGlobalPeriodLimit(boolean z5, boolean z6) {
            return setGlobalPeriodLimitWithAdmin(z5, z6, DigitalWellbeingService.this.f14510h.Y());
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo setGlobalPeriodLimitWithAdmin(boolean z5, boolean z6, long j5) throws Throwable {
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "setGlobalPeriodLimitWithAdmin");
            C0702g.y("DigitalWellbeingService", "enabled=" + z5 + " notifyOnly=" + z6 + " admin=" + j5);
            PeriodLimit periodLimitO2 = DigitalWellbeingService.this.f14510h.o2(j5, z5, z6, false);
            if (periodLimitO2 == null) {
                return null;
            }
            return new PeriodLimitInfo(periodLimitO2);
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public boolean setPackageLimitTime(int i5, String str, long j5, long j6, boolean z5, boolean z6) {
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "setPackageLimitTime");
            C0702g.y("DigitalWellbeingService", "interval=" + i5 + " packageName=" + str + " workdayLimit=" + j5 + " offDayLimit=" + j6 + " enabled=" + z5 + " notifyOnly=" + z6);
            boolean zR2 = DigitalWellbeingService.this.f14510h.r2(i5, str, j5, j6, z5, z6, DigitalWellbeingService.this.f14510h.Y(), false);
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, Boolean.valueOf(zR2));
            return zR2;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public boolean setPackageLimitTimeWithAdmin(int i5, String str, long j5, long j6, boolean z5, boolean z6, long j7, boolean z7) {
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "setPackageLimitTimeWithAdmin");
            C0702g.y("DigitalWellbeingService", "interval = " + i5 + " packageName = " + str + " workdayLimit = " + C0711p.m(DigitalWellbeingService.this.getApplicationContext(), j5) + " offDayLimit = " + C0711p.m(DigitalWellbeingService.this.getApplicationContext(), j6) + " enabled = " + z5 + " notifyOnly = " + z6 + " isChild = " + z7);
            boolean zR2 = DigitalWellbeingService.this.f14510h.r2(i5, str, j5, j6, z5, z6, j7, z7);
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, Boolean.valueOf(zR2));
            return zR2;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo setPackagePeriodLimit(String str, boolean z5, boolean z6) {
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "setPackagePeriodLimit");
            C0702g.y("DigitalWellbeingService", "packageName = " + str + " enable=" + z5 + " notifyOnly=" + z6);
            PeriodLimit periodLimitS2 = DigitalWellbeingService.this.f14510h.s2(str, DigitalWellbeingService.this.f14510h.Y(), z5, z6, false);
            PeriodLimitInfo periodLimitInfo = periodLimitS2 == null ? null : new PeriodLimitInfo(periodLimitS2);
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, periodLimitInfo);
            return periodLimitInfo;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo setPackagePeriodLimitWithAdmin(String str, boolean z5, boolean z6, long j5, boolean z7) {
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "setPackagePeriodLimitWithAdmin");
            C0702g.y("DigitalWellbeingService", "packageName=" + str + " enable=" + z5 + " notifyOnly=" + z6);
            PeriodLimit periodLimitS2 = DigitalWellbeingService.this.f14510h.s2(str, j5, z5, z6, z7);
            PeriodLimitInfo periodLimitInfo = periodLimitS2 == null ? null : new PeriodLimitInfo(periodLimitS2);
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, periodLimitInfo);
            return periodLimitInfo;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long updateCategoryPeriod(long j5, RawPeriodInfo rawPeriodInfo) {
            return updateCategoryPeriodWithAdmin(j5, rawPeriodInfo, DigitalWellbeingService.this.f14510h.Y());
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long updateCategoryPeriodWithAdmin(long j5, RawPeriodInfo rawPeriodInfo, long j6) {
            if (j6 != DigitalWellbeingService.this.f14510h.Y()) {
                R1.a.b("DigitalWellbeingService", "removePeriod not currentAdmin");
                return -1L;
            }
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "updateCategoryPeriod");
            C0702g.y("DigitalWellbeingService", "categoryId=" + DigitalWellbeingService.this.getString(W1.c.m((int) j5)) + " period=" + rawPeriodInfo + " adminId=" + j6);
            long jU2 = DigitalWellbeingService.this.f14510h.U2(j5, j6, new RawPeriod(rawPeriodInfo));
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, Long.valueOf(jU2));
            return jU2;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long updateGlobalPeriod(RawPeriodInfo rawPeriodInfo) {
            return updateGlobalPeriodWithAdmin(rawPeriodInfo, DigitalWellbeingService.this.f14510h.Y());
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long updateGlobalPeriodWithAdmin(RawPeriodInfo rawPeriodInfo, long j5) {
            if (j5 != DigitalWellbeingService.this.f14510h.Y()) {
                R1.a.b("DigitalWellbeingService", "updateGlobalPeriodWithAdmin not currentAdmin");
                return -1L;
            }
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "updateGlobalPeriodWithAdmin");
            long jV2 = DigitalWellbeingService.this.f14510h.V2(j5, new RawPeriod(rawPeriodInfo));
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, Long.valueOf(jV2));
            return jV2;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long updatePackagePeriod(String str, RawPeriodInfo rawPeriodInfo) {
            return updatePackagePeriodWithAdmin(str, rawPeriodInfo, DigitalWellbeingService.this.f14510h.Y());
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long updatePackagePeriodWithAdmin(String str, RawPeriodInfo rawPeriodInfo, long j5) {
            if (j5 != DigitalWellbeingService.this.f14510h.Y()) {
                R1.a.b("DigitalWellbeingService", "removePeriod not currentAdmin");
                return -1L;
            }
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "updatePackagePeriod");
            C0702g.y("DigitalWellbeingService", "packageName=" + str + " period=" + rawPeriodInfo + " adminId=" + j5);
            long jW2 = DigitalWellbeingService.this.f14510h.W2(str, j5, new RawPeriod(rawPeriodInfo));
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, Long.valueOf(jW2));
            return jW2;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long updatePeriod(long j5, RawPeriodInfo rawPeriodInfo) {
            return updatePeriodWithAdmin(j5, rawPeriodInfo, DigitalWellbeingService.this.f14510h.Y());
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long updatePeriodWithAdmin(long j5, RawPeriodInfo rawPeriodInfo, long j6) throws Throwable {
            if (j6 != DigitalWellbeingService.this.f14510h.Y()) {
                R1.a.b("DigitalWellbeingService", "updatePeriod not currentAdmin");
                return -1L;
            }
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "updatePeriod");
            C0702g.y("DigitalWellbeingService", "periodLimitId=" + j5 + " period=" + rawPeriodInfo + " adminId=" + j6);
            long jX2 = DigitalWellbeingService.this.f14510h.X2(j5, new RawPeriod(rawPeriodInfo));
            C0702g.J("DigitalWellbeingService", R1.a.f4967c, Long.valueOf(jX2));
            return jX2;
        }
    };

    private class a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (T1.f.a()) {
                R1.a.a("DigitalWellbeingService", "onReceive");
                DigitalWellbeingService.this.f14504b.sendMessage(Message.obtain(DigitalWellbeingService.this.f14504b, 24));
            }
        }

        private a() {
        }
    }

    public static boolean A(long j5) {
        return j5 < 255 && j5 > 0;
    }

    public static boolean B(long j5) {
        return j5 >= 255;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C() {
        AppWidgetManagerService.n(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        PackageUtils.h(this).A();
        Y1.l lVar = this.f14510h;
        if (lVar != null) {
            lVar.T1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() throws Throwable {
        this.f14511i.y(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() throws Throwable {
        this.f14511i.y(false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() throws Throwable {
        this.f14511i.y(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        if (this.f14505c == null || this.f14511i == null) {
            return;
        }
        v(new Runnable() { // from class: com.stepos.digitalwellbeing.server.o
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f14649a.G();
            }
        });
    }

    private void J(int i5) {
        Handler handler = this.f14504b;
        if (handler == null) {
            return;
        }
        if (i5 == 0) {
            Message.obtain(handler, 6).sendToTarget();
        } else if (i5 == 8) {
            Message.obtain(handler, 17).sendToTarget();
        }
    }

    private void K() {
        if (this.f14517o == null) {
            this.f14517o = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        if (Build.VERSION.SDK_INT > 33) {
            registerReceiver(this.f14517o, intentFilter, 2);
        } else {
            registerReceiver(this.f14517o, intentFilter);
        }
        this.f14518p = true;
    }

    private void L() throws Throwable {
        C0684b c0684b = this.f14509g;
        if (c0684b != null) {
            c0684b.M();
        }
        W1.c cVar = this.f14511i;
        if (cVar != null) {
            cVar.B();
        }
        PackageUtils.h(this).y();
        D2.j.a().e(20);
    }

    private void M() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f14506d;
        if (jElapsedRealtime >= 15000) {
            N();
        } else {
            this.f14504b.removeCallbacks(this.f14507e);
            this.f14504b.postDelayed(this.f14507e, 15000 - jElapsedRealtime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (this.f14505c == null || this.f14511i == null) {
            return;
        }
        v(new Runnable() { // from class: com.stepos.digitalwellbeing.server.l
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f14564a.E();
            }
        });
    }

    private void O() {
        if (this.f14505c == null || this.f14511i == null) {
            return;
        }
        v(new Runnable() { // from class: com.stepos.digitalwellbeing.server.m
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f14647a.F();
            }
        });
        this.f14504b.postDelayed(new Runnable() { // from class: com.stepos.digitalwellbeing.server.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f14648a.H();
            }
        }, 5000L);
    }

    private void P() {
        Intent intent = new Intent("com.stepos.digitalwellbeing.ACTION_USAGE_DATA_INVALIDATED");
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
    }

    public static void Q(Context context) {
        Intent intent = new Intent();
        intent.putExtra("command_id", 15);
        intent.setClass(context, DigitalWellbeingService.class);
        S(context, intent);
    }

    public static void R(Context context, int i5, Bundle bundle) {
        Intent intentR = r();
        intentR.putExtra("command_id", i5);
        intentR.putExtras(bundle);
        S(context, intentR);
    }

    public static void S(Context context, Intent intent) {
        C0702g.y("DigitalWellbeingService", "startService: intent = [" + intent + "]");
        try {
            T(context, intent);
            com.stepos.digitalwellbeing.server.a.d();
        } catch (Exception e6) {
            C0702g.p("DigitalWellbeingService", "startService failed: " + e6.getMessage());
            if (intent != null) {
                com.stepos.digitalwellbeing.server.a.a(intent);
            }
            if (com.stepos.digitalwellbeing.server.a.b()) {
                return;
            }
            com.stepos.digitalwellbeing.server.a.e(context);
        }
    }

    private static void T(Context context, Intent intent) {
        context.startService(intent);
    }

    public static void U(Context context) {
        Intent intentR = r();
        intentR.putExtra("command_id", 0);
        S(context, intentR);
    }

    public static void V(Context context) {
        Intent intentR = r();
        intentR.putExtra("command_id", 20);
        S(context, intentR);
    }

    public static void W(Context context, String str) {
        Intent intentR = r();
        intentR.putExtra("command_id", 6);
        intentR.putExtra("packageName", str);
        S(context, intentR);
    }

    public static void X(Context context, String[] strArr, int i5, int i6, int i7, long j5, int i8) {
        Intent intentR = r();
        intentR.putExtra("command_id", 3);
        intentR.putExtra("packages", strArr);
        intentR.putExtra("reason", i5);
        intentR.putExtra("type", i6);
        intentR.putExtra(Minor.COLUMN_ID, i7);
        intentR.putExtra("limit_time", j5);
        intentR.putExtra("category_id", i8);
        S(context, intentR);
    }

    public static void Y(Context context) {
        Intent intentR = r();
        intentR.putExtra("command_id", 22);
        S(context, intentR);
    }

    public static void Z(Context context) {
        Intent intentR = r();
        intentR.putExtra("command_id", 4);
        S(context, intentR);
    }

    public static void a0(Context context, String str) {
        Intent intentR = r();
        intentR.putExtra("command_id", 1);
        intentR.putExtra("packageName", str);
        S(context, intentR);
    }

    public static void b0(Context context, String str) {
        Intent intentR = r();
        intentR.putExtra("command_id", 2);
        intentR.putExtra("packageName", str);
        S(context, intentR);
    }

    public static void c0(Context context) {
        Intent intentR = r();
        intentR.putExtra("command_id", 21);
        S(context, intentR);
    }

    public static void d0(Context context) {
        Intent intentR = r();
        intentR.putExtra("command_id", 10);
        S(context, intentR);
    }

    public static void e0(Context context, boolean z5) {
        C0702g.b("DigitalWellbeingService", "startServiceBySelfReplace() called with: context = [" + context + "], isUpgradeFromBeforeSuspendRecordVersion = [" + z5 + "]");
        Intent intentR = r();
        intentR.putExtra("command_id", 9);
        intentR.putExtra("packageName", "com.stepos.familyguard");
        intentR.putExtra("upgrade_from_old_version", z5);
        S(context, intentR);
    }

    public static void f0(Context context) {
        Intent intentR = r();
        intentR.putExtra("command_id", 8);
        S(context, intentR);
    }

    public static /* synthetic */ void g(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            R1.a.c("DigitalWellbeingService", "dw-category task failed", th);
        }
    }

    private void g0() {
        a aVar = this.f14517o;
        if (aVar == null || !this.f14518p) {
            return;
        }
        unregisterReceiver(aVar);
        this.f14518p = false;
    }

    public static /* synthetic */ Thread h(Runnable runnable) {
        Thread thread = new Thread(runnable, "dw-category");
        thread.setPriority(4);
        return thread;
    }

    public static void h0(Context context) {
        com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.c.M(context);
    }

    private synchronized void p() {
        try {
            C0702g.E("DigitalWellbeingService", R1.a.f4967c);
            C0702g.y("DigitalWellbeingService", "checkAndStop");
            boolean zIsIdle = this.f14504b.getLooper().getQueue().isIdle();
            C0702g.y("DigitalWellbeingService", "idle = " + zIsIdle + " mBound = " + this.f14512j + " mHandling = " + this.f14513k + " mStartForegroundTime = " + this.f14516n);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.f14512j || this.f14513k || !zIsIdle || jCurrentTimeMillis - this.f14516n <= 10000) {
                C0702g.y("DigitalWellbeingService", "do not stop");
            } else {
                C0702g.y("DigitalWellbeingService", "stop");
                stopSelf();
            }
            C0702g.D("DigitalWellbeingService", R1.a.f4967c);
        } catch (Throwable th) {
            throw th;
        }
    }

    private static String q(int i5) {
        if (i5 == 22) {
            return "COMMAND_REFRESH_SUSPEND_DIALOGS";
        }
        switch (i5) {
            case 0:
                return "COMMAND_BOOT_COMPLETED";
            case 1:
                return "COMMAND_PACKAGE_ADD";
            case 2:
                return "COMMAND_PACKAGE_REMOVED";
            case 3:
                return "COMMAND_LIMIT_APPROACHED";
            case 4:
                return "COMMAND_NEXT_DAY";
            case 5:
                return "COMMAND_CATEGORY_VERSION_CHANGED";
            case 6:
                return "COMMAND_CLONE_PACKAGE_ADD";
            case 7:
                return "COMMAND_CLONE_PACKAGE_REMOVED";
            case 8:
                return "COMMAND_USER_PRESENT";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                return "COMMAND_SELF_REPLACED";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                return "COMMAND_RESET_SUSPEND_APP";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                return "COMMAND_PERIOD_LOCK";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                return "COMMAND_PERIOD_UNLOCK";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                return "COMMAND_PERIOD_NOTIFY";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                return "COMMAND_PERIOD_NOTIFY_ONLY";
            case 15:
                return "COMMAND_REINIT";
            default:
                return "KNOWN_COMMAND";
        }
    }

    private static Intent r() {
        Intent intent = new Intent();
        intent.setPackage("com.stepos.familyguard");
        intent.setAction("com.stepos.digitalwellbeing.dws");
        return intent;
    }

    private void s() {
        if (this.f14510h == null) {
            return;
        }
        while (true) {
            Intent intentC = com.stepos.digitalwellbeing.server.a.c();
            if (intentC == null) {
                com.stepos.digitalwellbeing.server.a.d();
                return;
            }
            if (x(intentC.getAction())) {
                C0702g.b("DigitalWellbeingService", "deliverPendingAlphaMeIntents action=" + intentC.getAction());
                this.f14510h.f6452y.l(intentC);
            } else if (z(intentC)) {
                w(intentC);
            } else {
                J(intentC.getIntExtra("command_id", Integer.MIN_VALUE));
            }
        }
    }

    private void t(int i5, int i6, long j5, long j6, boolean z5, boolean z6, long j7, boolean z7) {
        this.f14510h.j2(i5, i6, j5, j6, z5, z6, j7, z7);
    }

    private void u(int i5, String str, long j5, long j6, boolean z5, boolean z6, long j7, boolean z7) {
        this.f14510h.r2(i5, str, j5, j6, z5, z6, j7, z7);
    }

    private void v(final Runnable runnable) {
        ExecutorService executorService = this.f14505c;
        if (executorService == null || runnable == null) {
            return;
        }
        executorService.execute(new Runnable() { // from class: com.stepos.digitalwellbeing.server.p
            @Override // java.lang.Runnable
            public final void run() {
                DigitalWellbeingService.g(runnable);
            }
        });
    }

    private void w(Intent intent) {
        int intExtra = intent.getIntExtra("type", 0);
        int intExtra2 = intent.getIntExtra("reason", 0);
        int intExtra3 = intent.getIntExtra(Minor.COLUMN_ID, 0);
        long longExtra = intent.getLongExtra("limit_time", 0L);
        Message messageObtain = Message.obtain(this.f14504b, intExtra2 == 2 ? 25 : intExtra2 == 1 ? 10 : 9, intExtra, intExtra2, intent.getStringArrayExtra("packages"));
        Bundle bundle = new Bundle();
        bundle.putInt(Minor.COLUMN_ID, intExtra3);
        if (intExtra2 == 1) {
            bundle.putInt("category_id", intent.getIntExtra("category_id", 0));
        }
        bundle.putLong("limit_time", longExtra);
        messageObtain.setData(bundle);
        messageObtain.sendToTarget();
    }

    public static boolean x(String str) {
        return TextUtils.equals(str, "com.stepos.alphame.intent.action.APP_EVENT") || TextUtils.equals(str, "com.stepos.alphame.intent.action.SCREEN_EVENT");
    }

    public static boolean y(long j5) {
        return j5 == -1;
    }

    private static boolean z(Intent intent) {
        return intent != null && intent.getIntExtra("command_id", Integer.MIN_VALUE) == 3;
    }

    public void I(int i5, int i6) {
        C0702g.E("DigitalWellbeingService", R1.a.f4967c);
        C0702g.y("DigitalWellbeingService", "onCategoryChanged");
        C0702g.y("DigitalWellbeingService", "oldVersion=" + i5 + " newVersion=" + i6);
        R1.a.a("DigitalWellbeingService", "onCategoryChanged oldVersion = " + i5 + " newVersion = " + i6);
        if (i5 != i6) {
            this.f14510h.k1(i5, i6);
            this.f14511i.q(i5, i6);
        }
        C0702g.D("DigitalWellbeingService", R1.a.f4967c);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        DigitalWellbeingService digitalWellbeingService = this;
        digitalWellbeingService.f14513k = true;
        C0702g.b("DigitalWellbeingService", "handleMessage msg=" + message);
        int i5 = message.what;
        if (i5 != 11 && !digitalWellbeingService.f14514l) {
            if (i5 == 7 && message.arg1 < 40) {
                Message messageObtain = Message.obtain(message);
                messageObtain.arg1 = message.arg1 + 1;
                digitalWellbeingService.f14504b.sendMessageDelayed(messageObtain, 50L);
                C0702g.O("DigitalWellbeingService", "defer PACKAGE_ADDED until init, retry=" + messageObtain.arg1 + " pkg=" + message.obj);
                return true;
            }
            if (i5 == 9 || i5 == 10 || i5 == 25) {
                Bundle data = message.getData() != null ? message.getData() : new Bundle();
                int i6 = data.getInt("limit_approach_init_retry", 0);
                if (i6 < 40) {
                    Message messageObtain2 = Message.obtain(message);
                    Bundle bundle = new Bundle(data);
                    int i7 = i6 + 1;
                    bundle.putInt("limit_approach_init_retry", i7);
                    messageObtain2.setData(bundle);
                    digitalWellbeingService.f14504b.sendMessageDelayed(messageObtain2, 50L);
                    C0702g.O("DigitalWellbeingService", "defer LIMIT_APPROACHED until init, retry=" + i7 + " what=" + message.what);
                    return true;
                }
                C0702g.O("DigitalWellbeingService", "drop LIMIT_APPROACHED after init retry exhausted what=" + message.what);
            }
            int i8 = message.what;
            if (i8 == 6 || i8 == 17) {
                if (message.arg1 < 40) {
                    Message messageObtain3 = Message.obtain(message);
                    messageObtain3.arg1 = message.arg1 + 1;
                    digitalWellbeingService.f14504b.sendMessageDelayed(messageObtain3, 50L);
                    C0702g.O("DigitalWellbeingService", "defer START_LIMITS until init, retry=" + messageObtain3.arg1 + " what=" + message.what);
                    return true;
                }
                C0702g.O("DigitalWellbeingService", "drop START_LIMITS after init retry exhausted what=" + message.what);
            }
            return true;
        }
        try {
            switch (i5) {
                case 0:
                    digitalWellbeingService = this;
                    digitalWellbeingService.u(message.arg1, message.getData().getString("packageName"), message.getData().getLong("workdayLimitTime"), message.getData().getLong("offDayLimitTime"), message.arg2 > 0, message.getData().getBoolean("notifyOnly"), message.getData().getLong("admin_id", -1L), false);
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case 1:
                    digitalWellbeingService.t(message.arg1, message.arg2, message.getData().getLong("workdayLimitTime"), message.getData().getLong("offDayLimitTime"), message.getData().getBoolean("enable"), message.getData().getBoolean("notifyOnly"), message.getData().getLong("admin_id", -1L), false);
                    digitalWellbeingService = this;
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case 2:
                    digitalWellbeingService.f14510h.i2(((Long) message.obj).longValue());
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case 3:
                case 4:
                case 5:
                case 16:
                default:
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case 6:
                    digitalWellbeingService.f14510h.i1();
                    AppWidgetManagerService.y(digitalWellbeingService);
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case 7:
                    String str = (String) message.obj;
                    digitalWellbeingService.f14511i.r(str);
                    digitalWellbeingService.f14510h.u1(str);
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case 8:
                    digitalWellbeingService.f14510h.w1((String) message.obj);
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                    digitalWellbeingService.f14510h.v1(message.getData().getInt(Minor.COLUMN_ID), (String[]) message.obj, message.getData().getLong("limit_time"), message.arg1);
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                    int i9 = message.arg1;
                    digitalWellbeingService.f14510h.j1(message.getData().getInt(Minor.COLUMN_ID), (String[]) message.obj, message.getData().getInt("category_id"), message.getData().getLong("limit_time"), i9);
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                    synchronized (digitalWellbeingService.f14515m) {
                        try {
                            if (digitalWellbeingService.f14514l) {
                                R1.a.a("DigitalWellbeingService", "init has finished");
                            } else {
                                C0702g.y("DigitalWellbeingService", "DO_INIT");
                                if (!p2.g.x(digitalWellbeingService)) {
                                    R1.a.l("DigitalWellbeingService", "Do Init Cta not prepared");
                                    return false;
                                }
                                Application application = digitalWellbeingService.getApplication();
                                P1.a.c(digitalWellbeingService.getApplication());
                                digitalWellbeingService.K();
                                if (PackageUtils.h(application).k().isEmpty()) {
                                    PackageUtils.h(application).A();
                                }
                                digitalWellbeingService.f14510h.o1();
                                SharedPreferences sharedPreferences = digitalWellbeingService.getSharedPreferences("DigitalPreferences", 0);
                                int i10 = sharedPreferences.getInt("categoryVersion", 0);
                                if (i10 < 1) {
                                    sharedPreferences.edit().putInt("categoryVersion", 1).apply();
                                    digitalWellbeingService.I(i10, 1);
                                }
                                digitalWellbeingService.f14514l = true;
                                digitalWellbeingService.f14506d = SystemClock.elapsedRealtime();
                                digitalWellbeingService.f14515m.notifyAll();
                                R1.a.a("DigitalWellbeingService", "init finish");
                                digitalWellbeingService.O();
                                C0698c.e(digitalWellbeingService);
                            }
                            digitalWellbeingService.f14513k = false;
                            digitalWellbeingService.p();
                            return true;
                        } finally {
                        }
                    }
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                    C0684b c0684b = digitalWellbeingService.f14509g;
                    if (c0684b != null) {
                        c0684b.M();
                    }
                    digitalWellbeingService.f14510h.s1();
                    digitalWellbeingService.P();
                    AppWidgetManagerService.n(digitalWellbeingService);
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                    digitalWellbeingService.f14511i.r((String) message.obj);
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                    digitalWellbeingService.f14511i.s((String) message.obj);
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case 15:
                    digitalWellbeingService.f14510h.m1((String) message.obj);
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case 17:
                    digitalWellbeingService.f14510h.E1();
                    AppWidgetManagerService.y(digitalWellbeingService);
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE /* 18 */:
                    digitalWellbeingService.f14510h.A1(message.getData().getBoolean("upgrade_from_old_version", false));
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG /* 19 */:
                    digitalWellbeingService.f14510h.d2();
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                    digitalWellbeingService.f14510h.x1(message.getData());
                    digitalWellbeingService.f14510h.y1(message.getData(), 0);
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                    digitalWellbeingService.f14510h.z1(message.getData());
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                    digitalWellbeingService.f14510h.y1(message.getData(), 1);
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                    digitalWellbeingService.f14510h.y1(message.getData(), 2);
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case 24:
                    digitalWellbeingService.M();
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                    digitalWellbeingService.f14510h.n1(message.getData().getInt(Minor.COLUMN_ID), (String[]) message.obj, message.getData().getLong("limit_time"), message.arg1);
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                    C0684b c0684b2 = digitalWellbeingService.f14509g;
                    if (c0684b2 != null) {
                        c0684b2.M();
                    }
                    Y1.l lVar = digitalWellbeingService.f14510h;
                    if (lVar != null) {
                        lVar.l1();
                    }
                    digitalWellbeingService.P();
                    AppWidgetManagerService.n(digitalWellbeingService);
                    digitalWellbeingService.f14504b.removeCallbacks(digitalWellbeingService.f14508f);
                    digitalWellbeingService.f14504b.postDelayed(digitalWellbeingService.f14508f, 800L);
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                    C0684b c0684b3 = digitalWellbeingService.f14509g;
                    if (c0684b3 != null) {
                        c0684b3.M();
                    }
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
                case 28:
                    PackageUtils.h(digitalWellbeingService).A();
                    Y1.l lVar2 = digitalWellbeingService.f14510h;
                    if (lVar2 != null) {
                        lVar2.T1();
                    }
                    digitalWellbeingService.f14513k = false;
                    digitalWellbeingService.p();
                    return true;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        C0702g.E("DigitalWellbeingService", R1.a.f4967c);
        C0702g.y("DigitalWellbeingService", "onBind");
        this.f14512j = true;
        C0702g.D("DigitalWellbeingService", R1.a.f4967c);
        return this.f14520r;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Handler handler;
        super.onConfigurationChanged(configuration);
        C0702g.b("DigitalWellbeingService", "onConfigurationChanged() called with: newConfig = [" + configuration.locale + "]");
        Configuration configuration2 = this.f14519q;
        if (configuration2 == null) {
            this.f14519q = new Configuration(configuration);
            return;
        }
        boolean zEquals = Objects.equals(configuration2.locale, configuration.locale);
        this.f14519q = new Configuration(configuration);
        if (zEquals || (handler = this.f14504b) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.stepos.digitalwellbeing.server.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f14561a.D();
            }
        });
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C0702g.E("DigitalWellbeingService", R1.a.f4967c);
        C0702g.y("DigitalWellbeingService", "onCreate this = " + this);
        this.f14516n = C2.l.c(this, 1024);
        HandlerThread handlerThread = new HandlerThread("DigitalWellbeingServiceThread");
        this.f14503a = handlerThread;
        handlerThread.start();
        this.f14504b = new Handler(this.f14503a.getLooper(), this);
        this.f14505c = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.stepos.digitalwellbeing.server.i
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return DigitalWellbeingService.h(runnable);
            }
        });
        this.f14511i = new W1.c(this);
        this.f14509g = new C0684b(this, this.f14511i);
        C0697b.z();
        this.f14510h = new Y1.l(this, this.f14509g, this.f14511i);
        this.f14504b.sendMessageAtFrontOfQueue(Message.obtain(this.f14504b, 11));
        C0702g.D("DigitalWellbeingService", R1.a.f4967c);
        this.f14519q = new Configuration(getResources().getConfiguration());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C0702g.E("DigitalWellbeingService", R1.a.f4967c);
        C0702g.y("DigitalWellbeingService", "onDestroy");
        stopForeground(true);
        this.f14504b.removeCallbacksAndMessages(null);
        this.f14514l = false;
        g0();
        ExecutorService executorService = this.f14505c;
        if (executorService != null) {
            executorService.shutdownNow();
            this.f14505c = null;
        }
        C0702g.D("DigitalWellbeingService", R1.a.f4967c);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() throws Throwable {
        super.onLowMemory();
        R1.a.a("DigitalWellbeingService", "onLowMemory");
        L();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        C0702g.E("DigitalWellbeingService", R1.a.f4967c);
        C0702g.y("DigitalWellbeingService", "onRebind");
        super.onRebind(intent);
        C0702g.D("DigitalWellbeingService", R1.a.f4967c);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i5, int i6) {
        C0702g.y("DigitalWellbeingService", "onStartCommand: this = " + this);
        this.f14516n = C2.l.c(this, 1024);
        s();
        if (intent == null) {
            return super.onStartCommand(intent, i5, i6);
        }
        if (x(intent.getAction())) {
            this.f14510h.f6452y.l(intent);
            return super.onStartCommand(intent, i5, i6);
        }
        int intExtra = intent.getIntExtra("command_id", 0);
        C0702g.E("DigitalWellbeingService", R1.a.f4967c);
        C0702g.y("DigitalWellbeingService", "onStartCommand");
        C0702g.y("DigitalWellbeingService", "commandId=" + q(intExtra) + " intent=" + C0702g.j(intent));
        if (intExtra == 0) {
            J(intExtra);
        } else if (intExtra == 3) {
            w(intent);
        } else if (intExtra == 1) {
            Message.obtain(this.f14504b, 7, intent.getStringExtra("packageName")).sendToTarget();
        } else if (intExtra == 2) {
            Message.obtain(this.f14504b, 14, intent.getStringExtra("packageName")).sendToTarget();
            Message.obtain(this.f14504b, 8, intent.getStringExtra("packageName")).sendToTarget();
        } else if (intExtra == 9) {
            Message messageObtain = Message.obtain(this.f14504b, 18, intent.getStringExtra("packageName"));
            Bundle bundle = new Bundle();
            bundle.putBoolean("upgrade_from_old_version", false);
            messageObtain.setData(bundle);
            messageObtain.sendToTarget();
        } else if (intExtra == 4) {
            Message.obtain(this.f14504b, 12).sendToTarget();
        } else if (intExtra == 20) {
            Message.obtain(this.f14504b, 26).sendToTarget();
        } else if (intExtra == 21) {
            Message.obtain(this.f14504b, 27).sendToTarget();
        } else if (intExtra == 22) {
            Message.obtain(this.f14504b, 28).sendToTarget();
        } else if (intExtra == 6) {
            Message.obtain(this.f14504b, 15, intent.getStringExtra("packageName")).sendToTarget();
        } else if (intExtra != 7) {
            if (intExtra == 8) {
                J(intExtra);
            } else if (intExtra == 10) {
                Message.obtain(this.f14504b, 19).sendToTarget();
            } else if (intExtra == 11) {
                Message messageObtain2 = Message.obtain(this.f14504b, 20);
                messageObtain2.setData(intent.getExtras());
                messageObtain2.sendToTarget();
            } else if (intExtra == 12) {
                Message messageObtain3 = Message.obtain(this.f14504b, 21);
                messageObtain3.setData(intent.getExtras());
                messageObtain3.sendToTarget();
            } else if (intExtra == 13) {
                Message messageObtain4 = Message.obtain(this.f14504b, 22);
                messageObtain4.setData(intent.getExtras());
                messageObtain4.sendToTarget();
            } else if (intExtra == 14) {
                Message messageObtain5 = Message.obtain(this.f14504b, 23);
                messageObtain5.setData(intent.getExtras());
                messageObtain5.sendToTarget();
            } else if (intExtra == 15) {
                Message.obtain(this.f14504b, 11).sendToTarget();
            }
        }
        C0702g.D("DigitalWellbeingService", R1.a.f4967c);
        return super.onStartCommand(intent, i5, i6);
    }

    public void onTimeout(int i5, int i6) {
        super.onTimeout(i5, i6);
        C0702g.p("DigitalWellbeingService", "startId");
        stopSelf();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i5) throws Throwable {
        super.onTrimMemory(i5);
        if (i5 >= 20) {
            L();
        }
        if (i5 >= 15) {
            p();
        }
        R1.a.a("DigitalWellbeingService", "onTrimMemory level = " + i5);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        C0702g.E("DigitalWellbeingService", R1.a.f4967c);
        C0702g.y("DigitalWellbeingService", "onUnbind");
        this.f14512j = false;
        p();
        C0702g.D("DigitalWellbeingService", R1.a.f4967c);
        return super.onUnbind(intent);
    }
}
