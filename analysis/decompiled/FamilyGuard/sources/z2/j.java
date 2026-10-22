package z2;

import com.stepos.digitalwellbeing.server.data.PickupTimesStats;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import f2.C0702g;

/* loaded from: classes.dex */
public class j extends l {
    public j(Object[] objArr) {
        super(objArr);
    }

    @Override // z2.l
    public int p(int i5) {
        Object[] objArr = this.f24053a;
        if (objArr instanceof PickupTimesStats[]) {
            return ((PickupTimesStats) objArr[i5]).getPickupTimes();
        }
        if (!(objArr instanceof StatsDataSet[])) {
            C0702g.p("PickupTimesDataSet", "error type");
            return 0;
        }
        StatsDataSet statsDataSet = (StatsDataSet) objArr[i5];
        if (statsDataSet == null) {
            return 0;
        }
        return statsDataSet.getPickupTimes();
    }
}
