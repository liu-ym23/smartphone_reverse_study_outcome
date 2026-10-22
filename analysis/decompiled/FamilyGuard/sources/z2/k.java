package z2;

import com.stepos.digitalwellbeing.server.data.PickupTimesStats;

/* loaded from: classes.dex */
public class k extends AbstractC1345b {
    public k(Object[] objArr) {
        super(objArr);
        int i5 = (int) i();
        if (i5 % 2 == 0) {
            o(i5);
        } else {
            o(i5 + 1);
        }
        n(0.0d);
    }

    @Override // z2.f
    public double e(int i5) {
        return ((PickupTimesStats) f()[i5]).getPickupTimes();
    }
}
