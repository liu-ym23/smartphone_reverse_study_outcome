package org.apache.commons.math.stat.inference;

import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.math.MathException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.distribution.FDistribution;
import org.apache.commons.math.distribution.FDistributionImpl;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.stat.descriptive.summary.Sum;
import org.apache.commons.math.stat.descriptive.summary.SumOfSquares;

/* JADX INFO: loaded from: classes3.dex */
public class OneWayAnovaImpl implements OneWayAnova {

    /* JADX INFO: renamed from: org.apache.commons.math.stat.inference.OneWayAnovaImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class AnovaStats {
        private double F;
        private int dfbg;
        private int dfwg;

        /* synthetic */ AnovaStats(int x0, int x1, double x2, AnonymousClass1 x3) {
            this(x0, x1, x2);
        }

        static /* synthetic */ double access$000(AnovaStats x0) {
            return x0.F;
        }

        static /* synthetic */ int access$100(AnovaStats x0) {
            return x0.dfbg;
        }

        static /* synthetic */ int access$200(AnovaStats x0) {
            return x0.dfwg;
        }

        private AnovaStats(int dfbg, int dfwg, double F) {
            this.dfbg = dfbg;
            this.dfwg = dfwg;
            this.F = F;
        }
    }

    public OneWayAnovaImpl() {
    }

    @Override // org.apache.commons.math.stat.inference.OneWayAnova
    public double anovaFValue(Collection<double[]> categoryData) throws IllegalArgumentException, MathException {
        AnovaStats a = anovaStats(categoryData);
        return AnovaStats.access$000(a);
    }

    @Override // org.apache.commons.math.stat.inference.OneWayAnova
    public double anovaPValue(Collection<double[]> categoryData) throws IllegalArgumentException, MathException {
        AnovaStats a = anovaStats(categoryData);
        FDistribution fdist = new FDistributionImpl(AnovaStats.access$100(a), AnovaStats.access$200(a));
        return 1.0d - fdist.cumulativeProbability(AnovaStats.access$000(a));
    }

    @Override // org.apache.commons.math.stat.inference.OneWayAnova
    public boolean anovaTest(Collection<double[]> categoryData, double alpha) throws IllegalArgumentException, MathException {
        if (alpha <= 0.0d) goto L11;
        if (alpha > 0.5d) goto L11;
        if (anovaPValue(categoryData) >= alpha) goto L12;
        return true;
    L12:
        return false;
    L11:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, new Object[]{Double.valueOf(alpha), 0, Double.valueOf(0.5d)});
    }

    private AnovaStats anovaStats(Collection<double[]> categoryData) throws IllegalArgumentException, MathException {
        if (categoryData.size() < 2) goto L23;
        Iterator<double[]> r0 = categoryData.iterator();
    L5:
        boolean r2 = true;
        if (r0.hasNext() == false) goto L12;
        double[] array = r0.next();
        if (array.length > 1) goto L5;
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.TWO_OR_MORE_VALUES_IN_CATEGORY_REQUIRED, new Object[]{Integer.valueOf(array.length)});
    L12:
        double sswg = 0.0d;
        Sum totsum = new Sum();
        SumOfSquares totsumsq = new SumOfSquares();
        int totnum = 0;
        Iterator<double[]> r7 = categoryData.iterator();
        int dfwg = 0;
    L14:
        if (r7.hasNext() == false) goto L20;
        double[] data = r7.next();
        Sum sum = new Sum();
        SumOfSquares sumsq = new SumOfSquares();
        int num = 0;
        int i = 0;
    L17:
        if (i >= data.length) goto L19;
        double val = data[i];
        num = num + 1;
        sum.increment(val);
        sumsq.increment(val);
        totnum = totnum + 1;
        totsum.increment(val);
        totsumsq.increment(val);
        i = i + 1;
        goto L17
    L19:
        int i2 = num - 1;
        dfwg = dfwg + i2;
        double ss = sumsq.getResult() - ((sum.getResult() * sum.getResult()) / ((double) num));
        sswg = sswg + ss;
        r2 = r2;
        goto L14
    L20:
        double sswg2 = sswg;
        double sst = totsumsq.getResult() - ((totsum.getResult() * totsum.getResult()) / ((double) totnum));
        double ssbg = sst - sswg2;
        int dfbg = categoryData.size() - 1;
        double msbg = ssbg / ((double) dfbg);
        double mswg = sswg2 / ((double) dfwg);
        double F = msbg / mswg;
        return new AnovaStats(dfbg, dfwg, F, null);
    L23:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.TWO_OR_MORE_CATEGORIES_REQUIRED, new Object[]{Integer.valueOf(categoryData.size())});
    }
}
