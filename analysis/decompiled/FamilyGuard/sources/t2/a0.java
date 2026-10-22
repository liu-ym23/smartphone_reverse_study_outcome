package t2;

import android.os.IBinder;
import android.os.RemoteException;
import androidx.lifecycle.AbstractC0545z;
import com.stepos.digitalwellbeing.server.DigitalWellbeingService;
import com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface;
import com.stepos.digitalwellbeing.server.data.PackageLimitInfo;
import com.stepos.digitalwellbeing.server.data.PeriodLimitInfo;
import com.stepos.digitalwellbeing.server.data.RawPeriodInfo;
import com.stepos.familyguard.R;
import com.stepos.familyguard.db.FamilyGuardDatabase;
import f2.C0702g;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import s2.C1050b;

/* loaded from: classes.dex */
public class a0 extends b0 {

    /* renamed from: r, reason: collision with root package name */
    private static final boolean f22553r = R1.a.f("PackageLimitLocalProxy", R1.a.f4966b);

    public a0(String str, v2.e eVar, long j5) {
        super(str, eVar, j5);
    }

    private IDigitalWellbeingInterface M() {
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

    private boolean N(long j5) {
        boolean z5 = false;
        if (j5 != J()) {
            if (DigitalWellbeingService.A(j5)) {
                k().k(P1.a.a().getString(R.string.mm_admin_info_category_label_in_minor_mode));
                o().k(Boolean.TRUE);
            } else if (DigitalWellbeingService.B(j5)) {
                l2.m mVarA = FamilyGuardDatabase.x().D().a(j5);
                if (mVarA == null) {
                    R1.a.l("PackageLimitLocalProxy", "relationUser is null");
                    try {
                        IDigitalWellbeingInterface iDigitalWellbeingInterfaceM = M();
                        Objects.requireNonNull(iDigitalWellbeingInterfaceM);
                        iDigitalWellbeingInterfaceM.setCurrentAdmin(-1L);
                        return true;
                    } catch (RemoteException e6) {
                        e6.printStackTrace();
                        return true;
                    }
                }
                k().k(P1.a.b(R.string.us_admin_info, C1050b.a(mVarA), P1.a.b(q2.l.a(mVarA.f18260r).f19927c[1], new Object[0])));
                o().k(Boolean.valueOf(q2.l.b(mVarA.f18256n)));
            }
            z5 = true;
        } else if (DigitalWellbeingService.A(j5)) {
            o().k(Boolean.TRUE);
        }
        u().k(Boolean.valueOf(z5));
        return !z5;
    }

    @Override // t2.Y
    public void A(RawPeriodInfo rawPeriodInfo) {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceM = M();
        if (iDigitalWellbeingInterfaceM != null) {
            try {
                iDigitalWellbeingInterfaceM.addPackagePeriod(K(), rawPeriodInfo);
                List<RawPeriodInfo> listAsList = Arrays.asList(iDigitalWellbeingInterfaceM.getPackageRawPeriod(K()));
                Collections.sort(listAsList, new RawPeriodInfo.b());
                F().k(listAsList);
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
        }
    }

    @Override // t2.Y
    public void B(RawPeriodInfo rawPeriodInfo) {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceM = M();
        if (iDigitalWellbeingInterfaceM != null) {
            try {
                iDigitalWellbeingInterfaceM.updatePackagePeriod(K(), rawPeriodInfo);
                List<RawPeriodInfo> listAsList = Arrays.asList(iDigitalWellbeingInterfaceM.getPackageRawPeriod(K()));
                Collections.sort(listAsList, new RawPeriodInfo.b());
                F().k(listAsList);
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
        }
    }

    @Override // t2.Y
    public void e(long j5) {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceM = M();
        if (iDigitalWellbeingInterfaceM != null) {
            try {
                iDigitalWellbeingInterfaceM.removePackagePeriod(K(), j5);
                List<RawPeriodInfo> listAsList = Arrays.asList(iDigitalWellbeingInterfaceM.getPackageRawPeriod(K()));
                Collections.sort(listAsList, new RawPeriodInfo.b());
                F().k(listAsList);
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
        }
    }

    @Override // t2.b0, t2.Y
    public void i() {
        String strK = K();
        long jLongValue = s().e().longValue();
        long jLongValue2 = v().e().longValue();
        boolean zBooleanValue = D().e().booleanValue();
        boolean zBooleanValue2 = p().e().booleanValue();
        boolean zBooleanValue3 = E().e().booleanValue();
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceM = M();
        if (iDigitalWellbeingInterfaceM == null) {
            return;
        }
        try {
            iDigitalWellbeingInterfaceM.setPackageLimitTime(com.stepos.digitalwellbeing.server.data.a.DAY.ordinal(), strK, jLongValue, jLongValue2, zBooleanValue, zBooleanValue3);
            B2.b.i(zBooleanValue2, jLongValue, jLongValue2, strK, zBooleanValue3);
            iDigitalWellbeingInterfaceM.setPackagePeriodLimit(strK, zBooleanValue2, zBooleanValue3);
        } catch (RemoteException e6) {
            e6.printStackTrace();
        }
    }

    @Override // t2.b0, t2.Y
    public void m() {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceM = M();
        if (iDigitalWellbeingInterfaceM == null) {
            return;
        }
        try {
            boolean z5 = true;
            PackageLimitInfo limitedPackageInfo = iDigitalWellbeingInterfaceM.getLimitedPackageInfo(true, K());
            long currentAdmin = iDigitalWellbeingInterfaceM.getCurrentAdmin();
            boolean zN = N(currentAdmin);
            C0702g.b("PackageLimitLocalProxy", "queryLimit() admin = " + currentAdmin);
            PeriodLimitInfo packagePeriodLimitInfo = iDigitalWellbeingInterfaceM.getPackagePeriodLimitInfo(K(), currentAdmin);
            if (f22553r) {
                R1.a.a("PackageLimitLocalProxy", "queryLimit packageLimitInfo = " + limitedPackageInfo);
            }
            if (limitedPackageInfo != null) {
                long workdayLimit = limitedPackageInfo.getWorkdayLimit();
                long offDayLimit = limitedPackageInfo.getOffDayLimit();
                boolean zIsEnable = limitedPackageInfo.isEnable();
                boolean zIsNotifyOnly = limitedPackageInfo.isNotifyOnly();
                if (!limitedPackageInfo.isLimitable() || !zN) {
                    z5 = false;
                }
                s().k(Long.valueOf(workdayLimit));
                v().k(Long.valueOf(offDayLimit));
                D().k(Boolean.valueOf(zIsEnable));
                E().k(Boolean.valueOf(zIsNotifyOnly));
                j().k(Boolean.valueOf(z5));
            } else {
                IDigitalWellbeingInterface iDigitalWellbeingInterfaceM2 = M();
                if (iDigitalWellbeingInterfaceM2 == null || !iDigitalWellbeingInterfaceM2.isPackageLimitable(K()) || !zN) {
                    z5 = false;
                }
                j().k(Boolean.valueOf(z5));
            }
            if (packagePeriodLimitInfo != null) {
                boolean zIsEnable2 = packagePeriodLimitInfo.isEnable();
                RawPeriodInfo[] rawPeriod = iDigitalWellbeingInterfaceM.getRawPeriod(packagePeriodLimitInfo.getId());
                p().k(Boolean.valueOf(zIsEnable2));
                F().k(Arrays.asList(rawPeriod));
                return;
            }
            if (!zN) {
                F().k(null);
                return;
            }
            PeriodLimitInfo periodLimitInfoInitPackagePeriodLimitInfo = iDigitalWellbeingInterfaceM.initPackagePeriodLimitInfo(K(), currentAdmin, false);
            p().k(Boolean.valueOf(periodLimitInfoInitPackagePeriodLimitInfo.isEnable()));
            RawPeriodInfo rawPeriodInfo = RawPeriodInfo.getDefault();
            rawPeriodInfo.setLimitId(periodLimitInfoInitPackagePeriodLimitInfo.getId());
            A(rawPeriodInfo);
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
