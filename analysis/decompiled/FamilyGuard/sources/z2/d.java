package z2;

import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import f2.C0702g;
import f2.C0711p;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class d extends AbstractC1345b {

    /* renamed from: f, reason: collision with root package name */
    private int[] f24060f;

    /* renamed from: g, reason: collision with root package name */
    private long[] f24061g;

    /* renamed from: h, reason: collision with root package name */
    private Map<String, Long> f24062h;

    public d(Object[] objArr) {
        super(objArr);
        this.f24060f = null;
        this.f24061g = null;
        this.f24062h = null;
        if (j() == 7) {
            o(8.64E7d);
        } else {
            o(3600000.0d);
        }
        n(0.0d);
    }

    private double[] p(Map<String, Long> map) {
        int[] iArrR = r();
        int length = iArrR == null ? 0 : iArrR.length;
        double[] dArr = new double[length];
        if (length != 0 && map != null && !map.isEmpty()) {
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    i5 = -1;
                    break;
                }
                if (iArrR[i5] == 10) {
                    break;
                }
                i5++;
            }
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                double dMax = entry.getValue() == null ? 0.0d : Math.max(0L, r6.longValue());
                if (dMax > 0.0d && entry.getKey() != null) {
                    int iA = W1.a.a(entry.getKey());
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length) {
                            i6 = -1;
                            break;
                        }
                        if (iArrR[i6] == iA) {
                            break;
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        dArr[i6] = dArr[i6] + dMax;
                    } else if (i5 >= 0) {
                        dArr[i5] = dArr[i5] + dMax;
                    }
                }
            }
        }
        return dArr;
    }

    @Override // z2.f
    public double e(int i5) {
        StatsDataSet statsDataSet;
        Object[] objArr = this.f24053a;
        if (!(objArr instanceof StatsDataSet[]) || (statsDataSet = (StatsDataSet) objArr[i5]) == null) {
            return 0.0d;
        }
        return statsDataSet.getUsingTime();
    }

    double[] q(int i5) {
        StatsDataSet statsDataSet;
        Object[] objArrF = f();
        return (!(objArrF instanceof StatsDataSet[]) || (statsDataSet = (StatsDataSet) objArrF[i5]) == null) ? p(null) : p(statsDataSet.getCategoryUsingTimeMap());
    }

    public int[] r() {
        return this.f24060f;
    }

    public long[] s() {
        return this.f24061g;
    }

    public final void t(int[] iArr) {
        this.f24060f = iArr;
    }

    public final void u(long[] jArr) {
        this.f24061g = jArr;
    }

    public d(StatsDataSet statsDataSet) {
        this(statsDataSet.getChildren());
        int[] iArrFindTopCategories = statsDataSet.findTopCategories();
        long[] topCategoriesUsage = statsDataSet.getTopCategoriesUsage();
        t(iArrFindTopCategories);
        u(topCategoriesUsage);
        Map<String, Long> categoryUsingTimeMap = statsDataSet.getCategoryUsingTimeMap();
        this.f24062h = categoryUsingTimeMap == null ? null : new HashMap(categoryUsingTimeMap);
        C0702g.O("CategoricalUsingTimesDataSet", "USAGE_DEBUG histogram_dataset interval=" + statsDataSet.getInterval() + " date=" + C0711p.j(statsDataSet.getStartTime()) + " total=" + C0711p.t(statsDataSet.getUsingTime()) + " topCategories=" + Arrays.toString(iArrFindTopCategories) + " topCategoriesUsage=" + Arrays.toString(topCategoriesUsage) + " categoryMap=" + statsDataSet.getCategoryUsingTimeMap());
    }
}
