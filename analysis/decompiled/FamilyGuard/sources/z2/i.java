package z2;

import com.stepos.digitalwellbeing.server.data.NotificationTimesStats;

/* loaded from: classes.dex */
public class i extends AbstractC1345b {
    public i(Object[] objArr) {
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
        return ((NotificationTimesStats) f()[i5]).getNotificationTimes();
    }
}
