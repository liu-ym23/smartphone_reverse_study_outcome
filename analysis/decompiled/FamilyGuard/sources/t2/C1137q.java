package t2;

import android.os.IBinder;
import android.os.RemoteException;
import androidx.lifecycle.AbstractC0545z;
import com.stepos.digitalwellbeing.server.DigitalWellbeingService;
import com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface;
import com.stepos.digitalwellbeing.server.data.Category;
import com.stepos.digitalwellbeing.server.data.CategoryLimitInfo;
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

/* renamed from: t2.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1137q extends r {
    public C1137q(int i5, v2.e eVar, long j5) {
        super(i5, eVar, j5);
    }

    private IDigitalWellbeingInterface N() {
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

    private boolean O(long j5) {
        boolean z5 = false;
        if (j5 != L()) {
            if (DigitalWellbeingService.A(j5)) {
                k().k(P1.a.a().getString(R.string.mm_admin_info_category_label_in_minor_mode));
                o().k(Boolean.TRUE);
            } else if (DigitalWellbeingService.B(j5)) {
                l2.m mVarA = FamilyGuardDatabase.x().D().a(j5);
                if (mVarA == null) {
                    R1.a.l("CategoryLimitLocalProxy", "relationUser is null");
                    try {
                        IDigitalWellbeingInterface iDigitalWellbeingInterfaceN = N();
                        Objects.requireNonNull(iDigitalWellbeingInterfaceN);
                        iDigitalWellbeingInterfaceN.setCurrentAdmin(-1L);
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
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceN = N();
        if (iDigitalWellbeingInterfaceN != null) {
            try {
                iDigitalWellbeingInterfaceN.addCategoryPeriod(K(), rawPeriodInfo);
                List<RawPeriodInfo> listAsList = Arrays.asList(iDigitalWellbeingInterfaceN.getCategoryRawPeriod(K()));
                Collections.sort(listAsList, new RawPeriodInfo.b());
                F().k(listAsList);
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
        }
    }

    @Override // t2.Y
    public void B(RawPeriodInfo rawPeriodInfo) {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceN = N();
        if (iDigitalWellbeingInterfaceN != null) {
            try {
                iDigitalWellbeingInterfaceN.updateCategoryPeriod(K(), rawPeriodInfo);
                List<RawPeriodInfo> listAsList = Arrays.asList(iDigitalWellbeingInterfaceN.getCategoryRawPeriod(K()));
                Collections.sort(listAsList, new RawPeriodInfo.b());
                F().k(listAsList);
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
        }
    }

    @Override // t2.Y
    public void e(long j5) {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceN = N();
        if (iDigitalWellbeingInterfaceN != null) {
            try {
                iDigitalWellbeingInterfaceN.removeCategoryPeriod(K(), j5);
                List<RawPeriodInfo> listAsList = Arrays.asList(iDigitalWellbeingInterfaceN.getCategoryRawPeriod(K()));
                Collections.sort(listAsList, new RawPeriodInfo.b());
                F().k(listAsList);
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
        }
    }

    @Override // t2.Y
    public void i() {
        long jK = K();
        long jLongValue = s().e().longValue();
        long jLongValue2 = v().e().longValue();
        boolean zBooleanValue = D().e().booleanValue();
        boolean zBooleanValue2 = p().e().booleanValue();
        boolean zBooleanValue3 = E().e().booleanValue();
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceN = N();
        if (iDigitalWellbeingInterfaceN == null) {
            return;
        }
        try {
            iDigitalWellbeingInterfaceN.setCategoryLimitTime(com.stepos.digitalwellbeing.server.data.a.DAY.ordinal(), K(), jLongValue, jLongValue2, zBooleanValue, zBooleanValue3);
            B2.b.j(D().e().booleanValue(), s().e().longValue(), v().e().longValue(), K(), E().e().booleanValue());
            iDigitalWellbeingInterfaceN.setCategoryPeriodLimit(jK, zBooleanValue2, zBooleanValue3);
        } catch (RemoteException e6) {
            e6.printStackTrace();
        }
    }

    @Override // t2.Y
    public void m() {
        boolean z5;
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceN = N();
        if (iDigitalWellbeingInterfaceN == null) {
            return;
        }
        try {
            long currentAdmin = iDigitalWellbeingInterfaceN.getCurrentAdmin();
            C0702g.b("CategoryLimitLocalProxy", "queryLimit() admin = " + currentAdmin);
            boolean zO = O(currentAdmin);
            boolean z6 = true;
            CategoryLimitInfo limitedCategoryInfo = iDigitalWellbeingInterfaceN.getLimitedCategoryInfo(true, K());
            PeriodLimitInfo categoryPeriodLimitInfo = iDigitalWellbeingInterfaceN.getCategoryPeriodLimitInfo(K(), currentAdmin);
            if (limitedCategoryInfo != null) {
                D().k(Boolean.valueOf(limitedCategoryInfo.isEnable()));
                E().k(Boolean.valueOf(limitedCategoryInfo.isNotifyOnly()));
                s().k(Long.valueOf(limitedCategoryInfo.getWorkdayLimit()));
                v().k(Long.valueOf(limitedCategoryInfo.getOffDayLimit()));
                if (!limitedCategoryInfo.isLimitable() || !zO) {
                    z6 = false;
                }
                z5 = z6;
            } else {
                z5 = zO;
            }
            if (categoryPeriodLimitInfo != null) {
                boolean zIsEnable = categoryPeriodLimitInfo.isEnable();
                RawPeriodInfo[] rawPeriod = iDigitalWellbeingInterfaceN.getRawPeriod(categoryPeriodLimitInfo.getId());
                p().k(Boolean.valueOf(zIsEnable));
                F().k(Arrays.asList(rawPeriod));
            } else if (zO) {
                PeriodLimitInfo periodLimitInfoInitCategoryPeriodLimitInfo = iDigitalWellbeingInterfaceN.initCategoryPeriodLimitInfo(K(), currentAdmin, false);
                p().k(Boolean.valueOf(periodLimitInfoInitCategoryPeriodLimitInfo.isEnable()));
                RawPeriodInfo rawPeriodInfo = RawPeriodInfo.getDefault();
                rawPeriodInfo.setLimitId(periodLimitInfoInitCategoryPeriodLimitInfo.getId());
                A(rawPeriodInfo);
            } else {
                F().k(null);
            }
            j().k(Boolean.valueOf(z5));
        } catch (Exception e6) {
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

    @Override // t2.InterfaceC1136p
    public void y(int i5) {
        IDigitalWellbeingInterface iDigitalWellbeingInterfaceN = N();
        if (iDigitalWellbeingInterfaceN == null) {
            return;
        }
        Category category = iDigitalWellbeingInterfaceN.getCategory(false, i5);
        if (category == null) {
            category = iDigitalWellbeingInterfaceN.getCategory(false, i5);
        }
        if (category != null) {
            J().k(category);
            return;
        }
        R1.a.l("CategoryLimitLocalProxy", "queryCategory category is null, categoryId = " + i5);
    }
}
