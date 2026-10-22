package w2;

import android.content.Context;
import android.os.IBinder;
import androidx.lifecycle.AbstractC0545z;
import com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface;
import com.stepos.digitalwellbeing.server.data.CategoryLimitInfo;
import com.stepos.digitalwellbeing.server.data.CategoryUsingTimeStats;
import com.stepos.digitalwellbeing.server.data.DataToken;
import com.stepos.digitalwellbeing.server.data.NotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PackageLimitInfo;
import com.stepos.digitalwellbeing.server.data.PackageUsingTimeStats;
import com.stepos.digitalwellbeing.server.data.PeriodLimitInfo;
import com.stepos.digitalwellbeing.server.data.PickupTimesStats;
import com.stepos.digitalwellbeing.server.data.UsingTimeStats;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import f2.C0702g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class p1 extends q1 {
    public p1(v2.e eVar) {
        super(eVar);
        C0702g.b("USALLP", "UsageStatsAndLimitLocalProxy() called with: proxyImpl = [" + eVar + "]");
    }

    private IDigitalWellbeingInterface W() {
        Boolean boolE = b().e();
        C0702g.b("USALLP", "getDigitalWellbeing() called init = " + boolE);
        if (boolE == null || !boolE.booleanValue()) {
            return null;
        }
        AbstractC0545z<Object> abstractC0545zG = G();
        if (abstractC0545zG == null) {
            C0702g.p("USALLP", "getDigitalWellbeing: proxyObject == null");
            return null;
        }
        Object objE = abstractC0545zG.e();
        C0702g.b("USALLP", "getDigitalWellbeing: value = " + objE);
        if (objE instanceof IBinder) {
            return IDigitalWellbeingInterface.Stub.asInterface((IBinder) objE);
        }
        return null;
    }

    public List<C1216d> Q(Context context, com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
        C0702g.b("USALLP", "FG_USAGE_TRACE START doQueryAppUsageLimitData interval=" + aVar + ", dataToken=" + dataToken);
        List<PackageUtils.AppInfo> listJ = PackageUtils.h(context.getApplicationContext()).j();
        StringBuilder sb = new StringBuilder();
        sb.append("doQueryAppUsageLimitData list = ");
        sb.append(C0702g.k(listJ));
        C0702g.b("USALLP", sb.toString());
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceW = W();
        if (iDigitalWellbeingInterfaceW == null) {
            C0702g.p("USALLP", "FG_USAGE_TRACE END doQueryAppUsageLimitData digitalWellbeingInterface=null");
            return null;
        }
        PackageLimitInfo[] limitedPackagesInfo = iDigitalWellbeingInterfaceW.getLimitedPackagesInfo(true);
        C0702g.b("USALLP", "doQueryAppUsageLimitData limitList = " + C0702g.h(limitedPackagesInfo));
        PeriodLimitInfo[] packagesPeriodLimitInfo = iDigitalWellbeingInterfaceW.getPackagesPeriodLimitInfo(iDigitalWellbeingInterfaceW.getCurrentAdmin());
        C0702g.b("USALLP", "doQueryAppUsageLimitData periodLimitInfos = " + C0702g.h(packagesPeriodLimitInfo));
        PackageUsingTimeStats[] packagesUsingTimeStats = iDigitalWellbeingInterfaceW.getPackagesUsingTimeStats(aVar.ordinal(), dataToken);
        C0702g.b("USALLP", "doQueryAppUsageLimitData usingTimeStats = " + C0702g.h(packagesUsingTimeStats));
        if (listJ == null) {
            listJ = new ArrayList<>();
        }
        if (packagesUsingTimeStats == null) {
            packagesUsingTimeStats = new PackageUsingTimeStats[0];
        }
        if (limitedPackagesInfo == null) {
            limitedPackagesInfo = new PackageLimitInfo[0];
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FG_USAGE_TRACE MID doQueryAppUsageLimitData summary launcherSize=");
        sb2.append(listJ.size());
        sb2.append(", usingTimeStatsLength=");
        sb2.append(packagesUsingTimeStats.length);
        sb2.append(", limitListLength=");
        sb2.append(limitedPackagesInfo.length);
        sb2.append(", periodLimitInfosLength=");
        sb2.append(packagesPeriodLimitInfo == null ? -1 : packagesPeriodLimitInfo.length);
        C0702g.b("USALLP", sb2.toString());
        ArrayList arrayList = new ArrayList();
        C0702g.b("USALLP", "doQueryAppUsageLimitData appUsageLimitDataList = " + C0702g.k(arrayList));
        int size = listJ.size();
        HashMap map = new HashMap();
        for (int i5 = 0; i5 < size; i5++) {
            PackageUtils.AppInfo appInfo = listJ.get(i5);
            C1216d c1216d = new C1216d(appInfo.packageName, appInfo.label);
            arrayList.add(c1216d);
            map.put(appInfo.packageName, c1216d);
        }
        for (PackageUsingTimeStats packageUsingTimeStats : packagesUsingTimeStats) {
            C1216d c1216d2 = (C1216d) map.get(packageUsingTimeStats.getPackageName());
            if (c1216d2 != null) {
                c1216d2.F(packageUsingTimeStats);
            }
        }
        for (PackageLimitInfo packageLimitInfo : limitedPackagesInfo) {
            C1216d c1216d3 = (C1216d) map.get(packageLimitInfo.getPackageName());
            if (c1216d3 != null) {
                c1216d3.D(packageLimitInfo);
            }
        }
        if (packagesPeriodLimitInfo != null) {
            for (PeriodLimitInfo periodLimitInfo : packagesPeriodLimitInfo) {
                C1216d c1216d4 = (C1216d) map.get(periodLimitInfo.getPackageName());
                if (c1216d4 != null) {
                    c1216d4.G(periodLimitInfo);
                }
            }
        }
        C0702g.b("USALLP", "FG_USAGE_TRACE END doQueryAppUsageLimitData resultSize=" + arrayList.size());
        return arrayList;
    }

    public List<C1257w> R(Context context, com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
        C1257w c1257w;
        C1257w c1257w2;
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceW = W();
        if (iDigitalWellbeingInterfaceW == null) {
            return null;
        }
        iDigitalWellbeingInterfaceW.getCategories(true);
        CategoryLimitInfo[] limitedCategoriesInfo = iDigitalWellbeingInterfaceW.getLimitedCategoriesInfo(true);
        CategoryUsingTimeStats[] categoryUsingTimeStats = iDigitalWellbeingInterfaceW.getCategoryUsingTimeStats(aVar.ordinal(), dataToken);
        PeriodLimitInfo[] categoriesPeriodLimitInfo = iDigitalWellbeingInterfaceW.getCategoriesPeriodLimitInfo(iDigitalWellbeingInterfaceW.getCurrentAdmin());
        if (categoryUsingTimeStats == null) {
            categoryUsingTimeStats = new CategoryUsingTimeStats[0];
        }
        if (limitedCategoriesInfo == null) {
            limitedCategoriesInfo = new CategoryLimitInfo[0];
        }
        HashMap map = new HashMap();
        for (CategoryUsingTimeStats categoryUsingTimeStats2 : categoryUsingTimeStats) {
            if (categoryUsingTimeStats2 != null) {
                int categoryId = categoryUsingTimeStats2.getCategoryId();
                map.put(Integer.valueOf(categoryId), new C1257w(categoryId, categoryUsingTimeStats2));
            }
        }
        for (CategoryLimitInfo categoryLimitInfo : limitedCategoriesInfo) {
            if (categoryLimitInfo != null && (c1257w2 = (C1257w) map.get(Integer.valueOf(categoryLimitInfo.getCategoryId()))) != null) {
                c1257w2.B(categoryLimitInfo);
            }
        }
        if (categoriesPeriodLimitInfo != null) {
            for (PeriodLimitInfo periodLimitInfo : categoriesPeriodLimitInfo) {
                if (periodLimitInfo != null && (c1257w = (C1257w) map.get(Integer.valueOf((int) periodLimitInfo.getCategoryId()))) != null) {
                    c1257w.D(periodLimitInfo);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(map.values());
        return arrayList;
    }

    public NotificationTimesStats[] S(com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceW = W();
        if (iDigitalWellbeingInterfaceW == null) {
            return null;
        }
        return iDigitalWellbeingInterfaceW.getPhoneNotificationTimesStats(aVar.ordinal(), dataToken);
    }

    public PickupTimesStats[] T(com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceW = W();
        if (iDigitalWellbeingInterfaceW == null) {
            return null;
        }
        return iDigitalWellbeingInterfaceW.getPickupTimesStats(aVar.ordinal(), dataToken);
    }

    public DataToken U(com.stepos.digitalwellbeing.server.data.a aVar) {
        C0702g.b("USALLP", "FG_USAGE_TRACE START doQueryUsageStats interval=" + aVar);
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceW = W();
        if (iDigitalWellbeingInterfaceW == null) {
            R1.a.b("USALLP", "FG_USAGE_TRACE END doQueryUsageStats digitalWellbeingInterface=null");
            return null;
        }
        DataToken dataTokenQueryUsageData = iDigitalWellbeingInterfaceW.queryUsageData(aVar.ordinal(), true);
        StringBuilder sb = new StringBuilder();
        sb.append("FG_USAGE_TRACE END doQueryUsageStats interval=");
        sb.append(aVar);
        sb.append(", token=");
        sb.append(dataTokenQueryUsageData);
        sb.append(", tokenInvalidType=");
        sb.append(dataTokenQueryUsageData == null ? "null" : Integer.valueOf(dataTokenQueryUsageData.getInvalidType()));
        C0702g.b("USALLP", sb.toString());
        return dataTokenQueryUsageData;
    }

    public UsingTimeStats[] V(com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
        C0702g.b("USALLP", "FG_USAGE_TRACE START doQueryUsingTimeStats interval=" + aVar + ", dataToken=" + dataToken);
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceW = W();
        if (iDigitalWellbeingInterfaceW == null) {
            C0702g.b("USALLP", "FG_USAGE_TRACE END doQueryUsingTimeStats digitalWellbeingInterface=null");
            return null;
        }
        UsingTimeStats[] phoneUsingTimeStats = iDigitalWellbeingInterfaceW.getPhoneUsingTimeStats(aVar.ordinal(), dataToken);
        StringBuilder sb = new StringBuilder();
        sb.append("FG_USAGE_TRACE END doQueryUsingTimeStats interval=");
        sb.append(aVar);
        sb.append(", dataToken=");
        sb.append(dataToken);
        sb.append(", resultLength=");
        sb.append(phoneUsingTimeStats == null ? -1 : phoneUsingTimeStats.length);
        C0702g.b("USALLP", sb.toString());
        return phoneUsingTimeStats;
    }

    @Override // w2.U0
    public void a() {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceW = W();
        if (iDigitalWellbeingInterfaceW == null) {
            return;
        }
        iDigitalWellbeingInterfaceW.init();
    }

    @Override // w2.U0
    public void c(com.stepos.digitalwellbeing.server.data.a aVar) {
        DataToken dataTokenU = U(aVar);
        if (dataTokenU == null) {
            return;
        }
        this.f23642b.k(dataTokenU);
    }

    @Override // w2.U0
    public void d(com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceW = W();
        if (iDigitalWellbeingInterfaceW == null) {
            return;
        }
        this.f23647g.k(iDigitalWellbeingInterfaceW.getPackagesNotificationTimesStats(aVar.ordinal(), dataToken));
    }

    @Override // w2.U0
    public void f(Context context, com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
        List<C1216d> listQ = Q(context, aVar, dataToken);
        if (listQ != null) {
            this.f23654n.k(listQ);
        }
    }

    @Override // w2.U0
    public void h(Context context, com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
        List<C1257w> listR = R(context, aVar, dataToken);
        if (listR != null) {
            this.f23655o.k(listR);
        }
    }

    @Override // w2.U0
    public void l(com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
        NotificationTimesStats[] notificationTimesStatsArrS = S(aVar, dataToken);
        if (notificationTimesStatsArrS == null) {
            return;
        }
        this.f23644d.k(notificationTimesStatsArrS);
    }

    @Override // w2.U0
    public void n(com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
        this.f23645e.k(T(aVar, dataToken));
    }

    @Override // w2.U0
    public void z(com.stepos.digitalwellbeing.server.data.a aVar, DataToken dataToken) {
        UsingTimeStats[] usingTimeStatsArrV = V(aVar, dataToken);
        if (usingTimeStatsArrV == null) {
            return;
        }
        this.f23643c.k(usingTimeStatsArrV);
    }
}
