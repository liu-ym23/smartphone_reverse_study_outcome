package t2;

import android.os.IBinder;
import android.os.RemoteException;
import androidx.lifecycle.AbstractC0545z;
import com.stepos.digitalwellbeing.server.DigitalWellbeingService;
import com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface;
import com.stepos.digitalwellbeing.server.data.GlobalLimitInfo;
import com.stepos.digitalwellbeing.server.data.PeriodLimitInfo;
import com.stepos.digitalwellbeing.server.data.RawPeriodInfo;
import f2.C0702g;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class P extends Q {

    /* renamed from: u, reason: collision with root package name */
    private static final boolean f22520u = R1.a.f("GlobalLimitLocalProxy", R1.a.f4966b);

    public P(v2.e eVar, int i5, long j5) {
        super(eVar, i5, j5);
    }

    private IDigitalWellbeingInterface J() {
        AbstractC0545z<Object> abstractC0545zG;
        Boolean boolE = b().e();
        if (boolE == null || !boolE.booleanValue() || (abstractC0545zG = G()) == null) {
            return null;
        }
        Object objE = abstractC0545zG.e();
        if (objE instanceof IBinder) {
            return IDigitalWellbeingInterface.Stub.asInterface((IBinder) objE);
        }
        return null;
    }

    private void K(long j5) {
        if (DigitalWellbeingService.A(j5)) {
            o().k(Boolean.TRUE);
        }
        if (DigitalWellbeingService.A(j5)) {
            return;
        }
        C0702g.p("GlobalLimitLocalProxy", "error admin = " + j5);
    }

    @Override // t2.Y
    public void A(RawPeriodInfo rawPeriodInfo) {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceJ = J();
        if (iDigitalWellbeingInterfaceJ != null) {
            try {
                iDigitalWellbeingInterfaceJ.addGlobalPeriod(rawPeriodInfo);
                List<RawPeriodInfo> listAsList = Arrays.asList(iDigitalWellbeingInterfaceJ.getGlobalRawPeriod());
                Collections.sort(listAsList, new RawPeriodInfo.b());
                F().k(listAsList);
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
        }
    }

    @Override // t2.Y
    public void B(RawPeriodInfo rawPeriodInfo) {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceJ = J();
        if (iDigitalWellbeingInterfaceJ != null) {
            try {
                iDigitalWellbeingInterfaceJ.updateGlobalPeriod(rawPeriodInfo);
                List<RawPeriodInfo> listAsList = Arrays.asList(iDigitalWellbeingInterfaceJ.getGlobalRawPeriod());
                Collections.sort(listAsList, new RawPeriodInfo.b());
                F().k(listAsList);
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
        }
    }

    @Override // t2.Y
    public void e(long j5) {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceJ = J();
        if (iDigitalWellbeingInterfaceJ != null) {
            try {
                iDigitalWellbeingInterfaceJ.removeGlobalPeriod(j5);
                List<RawPeriodInfo> listAsList = Arrays.asList(iDigitalWellbeingInterfaceJ.getGlobalRawPeriod());
                Collections.sort(listAsList, new RawPeriodInfo.b());
                F().k(listAsList);
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
        }
    }

    @Override // t2.Q, t2.Y
    public void i() {
        long jLongValue = s().e().longValue();
        long jLongValue2 = v().e().longValue();
        boolean zBooleanValue = D().e().booleanValue();
        boolean zBooleanValue2 = p().e().booleanValue();
        boolean zBooleanValue3 = E().e().booleanValue();
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceJ = J();
        if (iDigitalWellbeingInterfaceJ == null) {
            return;
        }
        try {
            iDigitalWellbeingInterfaceJ.setGlobalLimitTime(com.stepos.digitalwellbeing.server.data.a.DAY.ordinal(), jLongValue, jLongValue2, zBooleanValue, zBooleanValue3);
            iDigitalWellbeingInterfaceJ.setGlobalPeriodLimit(zBooleanValue2, zBooleanValue3);
        } catch (RemoteException e6) {
            e6.printStackTrace();
        }
    }

    @Override // t2.Q, t2.Y
    public void m() {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceJ = J();
        if (iDigitalWellbeingInterfaceJ == null) {
            return;
        }
        boolean z5 = true;
        try {
            GlobalLimitInfo limitedGlobalInfo = iDigitalWellbeingInterfaceJ.getLimitedGlobalInfo(true);
            long currentAdmin = iDigitalWellbeingInterfaceJ.getCurrentAdmin();
            C0702g.b("GlobalLimitLocalProxy", "queryLimit() admin = " + currentAdmin);
            K(currentAdmin);
            PeriodLimitInfo globalPeriodLimitInfo = iDigitalWellbeingInterfaceJ.getGlobalPeriodLimitInfo(currentAdmin);
            if (f22520u) {
                R1.a.a("GlobalLimitLocalProxy", "queryLimit globalLimitInfo = " + limitedGlobalInfo);
            }
            if (limitedGlobalInfo != null) {
                long workdayLimit = limitedGlobalInfo.getWorkdayLimit();
                long offDayLimit = limitedGlobalInfo.getOffDayLimit();
                boolean zIsEnable = limitedGlobalInfo.isEnable();
                boolean zIsNotifyOnly = limitedGlobalInfo.isNotifyOnly();
                boolean zIsLimitable = limitedGlobalInfo.isLimitable();
                s().k(Long.valueOf(workdayLimit));
                v().k(Long.valueOf(offDayLimit));
                D().k(Boolean.valueOf(zIsEnable));
                E().k(Boolean.valueOf(zIsNotifyOnly));
                j().k(Boolean.valueOf(zIsLimitable));
            } else {
                if (J() == null || !DigitalWellbeingService.A(currentAdmin)) {
                    z5 = false;
                }
                j().k(Boolean.valueOf(z5));
            }
            if (globalPeriodLimitInfo != null) {
                boolean zIsEnable2 = globalPeriodLimitInfo.isEnable();
                RawPeriodInfo[] rawPeriod = iDigitalWellbeingInterfaceJ.getRawPeriod(globalPeriodLimitInfo.getId());
                p().k(Boolean.valueOf(zIsEnable2));
                F().k(Arrays.asList(rawPeriod));
                return;
            }
            if (!DigitalWellbeingService.A(currentAdmin)) {
                F().k(null);
                return;
            }
            PeriodLimitInfo periodLimitInfoInitGlobalPeriodLimitInfo = iDigitalWellbeingInterfaceJ.initGlobalPeriodLimitInfo();
            p().k(Boolean.valueOf(periodLimitInfoInitGlobalPeriodLimitInfo.isEnable()));
            RawPeriodInfo minorDefault = RawPeriodInfo.getMinorDefault();
            minorDefault.setLimitId(periodLimitInfoInitGlobalPeriodLimitInfo.getId());
            A(minorDefault);
            F().k(Collections.singletonList(minorDefault));
        } catch (RemoteException e6) {
            e6.printStackTrace();
        }
    }

    @Override // t2.Y
    public boolean t() {
        return true;
    }

    @Override // t2.Y
    public String w() {
        return null;
    }
}
