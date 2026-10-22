package z2;

import com.stepos.digitalwellbeing.server.data.NotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PickupTimesStats;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.digitalwellbeing.server.data.UsingTimeStats;
import f2.C0711p;

/* renamed from: z2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1345b implements f {

    /* renamed from: a, reason: collision with root package name */
    protected Object[] f24053a;

    /* renamed from: b, reason: collision with root package name */
    private double f24054b;

    /* renamed from: c, reason: collision with root package name */
    private double f24055c;

    /* renamed from: d, reason: collision with root package name */
    private int f24056d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f24057e;

    public AbstractC1345b(Object[] objArr) {
        this.f24053a = objArr;
        m(objArr.length);
    }

    @Override // z2.f
    public double a() {
        return this.f24054b;
    }

    @Override // z2.f
    public int b() {
        return this.f24056d;
    }

    @Override // z2.f
    public int c() {
        return this.f24057e;
    }

    @Override // z2.f
    public double d() {
        double d6;
        int iB;
        long jK = k(0);
        if (j() == 24) {
            return l() / (jK >= C0711p.y() ? C0711p.s() : 24);
        }
        int i5 = 7;
        if (j() != 7) {
            return 0.0d;
        }
        double dL = l();
        if ((this instanceof n) || (this instanceof i) || (this instanceof k)) {
            d6 = 7.0d;
        } else {
            if (jK > C0711p.y() - 604800000 && (iB = C0711p.B(System.currentTimeMillis())) != 0) {
                i5 = iB;
            }
            d6 = i5;
        }
        return dL / d6;
    }

    @Override // z2.f
    public Object[] f() {
        return this.f24053a;
    }

    public double g() {
        return this.f24055c;
    }

    public int h() {
        int iJ = j();
        double d6 = 0.0d;
        int i5 = 0;
        for (int i6 = 0; i6 < iJ; i6++) {
            double dE = e(i6);
            if (d6 < dE) {
                i5 = i6;
                d6 = dE;
            }
        }
        return i5;
    }

    public double i() {
        return e(h());
    }

    public int j() {
        Object[] objArr = this.f24053a;
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    public long k(int i5) {
        Object[] objArr = this.f24053a;
        if (objArr != null && i5 < objArr.length) {
            Object obj = objArr[i5];
            if (obj instanceof StatsDataSet) {
                return ((StatsDataSet) obj).getStartTime();
            }
            if (obj instanceof NotificationTimesStats) {
                return ((NotificationTimesStats) obj).getStartTime();
            }
            if (obj instanceof UsingTimeStats) {
                return ((UsingTimeStats) obj).getStartTime();
            }
            if (obj instanceof PickupTimesStats) {
                return ((PickupTimesStats) obj).getStartTime();
            }
        }
        return 0L;
    }

    public double l() {
        int iJ = j();
        double dE = 0.0d;
        for (int i5 = 0; i5 < iJ; i5++) {
            dE += e(i5);
        }
        return dE;
    }

    public void m(int i5) {
        this.f24057e = i5;
    }

    public void n(double d6) {
        this.f24055c = d6;
    }

    public void o(double d6) {
        this.f24054b = d6;
    }
}
