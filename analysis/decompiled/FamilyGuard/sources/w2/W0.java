package w2;

import android.os.IBinder;
import androidx.lifecycle.AbstractC0545z;
import com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface;
import com.stepos.digitalwellbeing.server.data.CategoryLimitInfo;
import com.stepos.digitalwellbeing.server.data.DataToken;
import com.stepos.digitalwellbeing.server.data.PackageLimitInfo;
import com.stepos.digitalwellbeing.server.data.PeriodLimitInfo;
import com.stepos.digitalwellbeing.server.data.WhitelistAppInfo;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import f2.C0702g;
import java.util.List;

/* loaded from: classes.dex */
public class W0 extends X0 {
    public W0(v2.e eVar) {
        super(eVar);
        C0702g.b("USALF11LP", "UsageStatsAndLimitF11LocalProxy() proxyImpl = " + eVar);
    }

    @Override // w2.V0
    public void C() {
        com.stepos.familyguard.ui.usage.x xVarP = P();
        if (xVarP == null) {
            return;
        }
        this.f23594e.k(xVarP);
    }

    public DataToken O() {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceS = S();
        if (iDigitalWellbeingInterfaceS != null) {
            return iDigitalWellbeingInterfaceS.queryUsageDataSet(com.stepos.digitalwellbeing.server.data.a.LAST_TWO_WEEK.ordinal(), true);
        }
        R1.a.b("USALF11LP", "doQueryLastTwoWeekUsageStatsDataSet digitalWellbeingInterface = null");
        return null;
    }

    public com.stepos.familyguard.ui.usage.x P() {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceS = S();
        if (iDigitalWellbeingInterfaceS == null) {
            C0702g.b("USALF11LP", "doQueryLimitDataSet() digitalWellbeingInterface == null");
            return null;
        }
        C0702g.b("USALF11LP", "doQueryLimitDataSet() called");
        long currentAdmin = iDigitalWellbeingInterfaceS.getCurrentAdmin();
        PackageLimitInfo[] limitedPackagesInfo = iDigitalWellbeingInterfaceS.getLimitedPackagesInfo(true);
        CategoryLimitInfo[] limitedCategoriesInfo = iDigitalWellbeingInterfaceS.getLimitedCategoriesInfo(true);
        PeriodLimitInfo[] packagesPeriodLimitInfo = iDigitalWellbeingInterfaceS.getPackagesPeriodLimitInfo(currentAdmin);
        PeriodLimitInfo[] categoriesPeriodLimitInfo = iDigitalWellbeingInterfaceS.getCategoriesPeriodLimitInfo(currentAdmin);
        List<WhitelistAppInfo> whitelistAppListWithAdmin = iDigitalWellbeingInterfaceS.getWhitelistAppListWithAdmin(currentAdmin);
        PackageUtils packageUtilsH = PackageUtils.h(P1.a.a());
        packageUtilsH.A();
        return new com.stepos.familyguard.ui.usage.x(limitedPackagesInfo, limitedCategoriesInfo, packagesPeriodLimitInfo, categoriesPeriodLimitInfo, packageUtilsH.n(), whitelistAppListWithAdmin);
    }

    public DataToken Q() {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceS = S();
        if (iDigitalWellbeingInterfaceS != null) {
            return iDigitalWellbeingInterfaceS.queryUsageDataSet(com.stepos.digitalwellbeing.server.data.a.DAY.ordinal(), true);
        }
        R1.a.b("USALF11LP", "doQueryTodayUsageStatsDataSet digitalWellbeingInterface = null");
        return null;
    }

    public com.stepos.familyguard.ui.usage.U R(DataToken dataToken) {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceS = S();
        if (iDigitalWellbeingInterfaceS == null) {
            C0702g.p("USALF11LP", "doQueryUsageDataSet() called dataToken = [" + dataToken + "] digitalWellbeingInterface = null");
            return null;
        }
        long currentAdmin = iDigitalWellbeingInterfaceS.getCurrentAdmin();
        C0702g.b("USALF11LP", "doQueryUsageDataSet() called with: dataToken = [" + dataToken + "] admin = [" + currentAdmin + "]");
        return new com.stepos.familyguard.ui.usage.U(iDigitalWellbeingInterfaceS.getStatsDataSets(dataToken), iDigitalWellbeingInterfaceS.getLimitedPackagesInfo(true), iDigitalWellbeingInterfaceS.getLimitedCategoriesInfo(true), iDigitalWellbeingInterfaceS.getPackagesPeriodLimitInfo(currentAdmin), iDigitalWellbeingInterfaceS.getCategoriesPeriodLimitInfo(currentAdmin), PackageUtils.h(P1.a.a()).n(), iDigitalWellbeingInterfaceS.getWhitelistAppListWithAdmin(currentAdmin));
    }

    protected IDigitalWellbeingInterface S() {
        Boolean boolE = b().e();
        if (boolE == null) {
            C0702g.O("USALF11LP", "getDigitalWellbeing: init == null");
            return null;
        }
        if (!boolE.booleanValue()) {
            C0702g.O("USALF11LP", "getDigitalWellbeing: init == false");
            return null;
        }
        AbstractC0545z<Object> abstractC0545zG = G();
        if (abstractC0545zG == null) {
            C0702g.O("USALF11LP", "getDigitalWellbeing: proxyObject == null");
            return null;
        }
        Object objE = abstractC0545zG.e();
        if (objE instanceof IBinder) {
            return IDigitalWellbeingInterface.Stub.asInterface((IBinder) objE);
        }
        C0702g.O("USALF11LP", "getDigitalWellbeing: proxyObject == value");
        return null;
    }

    public boolean T() {
        C0702g.b("USALF11LP", "getEnable() called");
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceS = S();
        if (iDigitalWellbeingInterfaceS != null) {
            return iDigitalWellbeingInterfaceS.isEnable();
        }
        C0702g.p("USALF11LP", "getEnable() digitalWellbeingInterface == null");
        return true;
    }

    @Override // w2.V0
    public void a() {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceS = S();
        if (iDigitalWellbeingInterfaceS == null) {
            return;
        }
        iDigitalWellbeingInterfaceS.init();
    }

    @Override // w2.V0
    public void g() {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceS = S();
        if (iDigitalWellbeingInterfaceS == null) {
            C0702g.p("USALF11LP", "queryCurrentAdmin() digitalWellbeingInterface == null");
        } else {
            this.f23595f.k(Long.valueOf(iDigitalWellbeingInterfaceS.getCurrentAdmin()));
        }
    }

    @Override // w2.V0
    public void q(DataToken dataToken) {
        com.stepos.familyguard.ui.usage.U uR = R(dataToken);
        if (uR == null) {
            return;
        }
        this.f23593d.k(uR);
    }

    @Override // w2.V0
    public void r() {
        this.f23592c.k(O());
    }

    @Override // w2.V0
    public void setEnable(boolean z5) {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceS = S();
        if (iDigitalWellbeingInterfaceS == null) {
            return;
        }
        iDigitalWellbeingInterfaceS.setEnable(z5);
    }

    @Override // w2.V0
    public void x() {
        DataToken dataTokenQ = Q();
        if (dataTokenQ == null) {
            return;
        }
        this.f23591b.k(dataTokenQ);
    }
}
