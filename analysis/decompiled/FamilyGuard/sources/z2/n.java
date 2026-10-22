package z2;

import com.stepos.digitalwellbeing.server.data.UsingTimeStats;

/* loaded from: classes.dex */
public class n extends AbstractC1345b {
    public n(Object[] objArr) {
        super(objArr);
        if (objArr == null || objArr.length == 0) {
            return;
        }
        if (objArr.length == 24 || objArr.length == 12 || objArr.length == 8) {
            o(3600000.0d);
        } else if (objArr.length == 7) {
            o(8.64E7d);
        }
    }

    @Override // z2.f
    public double e(int i5) {
        return ((UsingTimeStats) f()[i5]).getUsingTime();
    }
}
