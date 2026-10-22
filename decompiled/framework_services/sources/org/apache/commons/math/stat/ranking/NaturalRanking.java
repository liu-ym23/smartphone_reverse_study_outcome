package org.apache.commons.math.stat.ranking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math.exception.MathInternalError;
import org.apache.commons.math.random.RandomData;
import org.apache.commons.math.random.RandomDataImpl;
import org.apache.commons.math.random.RandomGenerator;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class NaturalRanking implements RankingAlgorithm {
    public static final NaNStrategy DEFAULT_NAN_STRATEGY = null;
    public static final TiesStrategy DEFAULT_TIES_STRATEGY = null;
    private final NaNStrategy nanStrategy;
    private final RandomData randomData;
    private final TiesStrategy tiesStrategy;

    /* JADX INFO: renamed from: org.apache.commons.math.stat.ranking.NaturalRanking$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math$stat$ranking$NaNStrategy = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math$stat$ranking$TiesStrategy = null;

        static {
            $SwitchMap$org$apache$commons$math$stat$ranking$TiesStrategy = new int[TiesStrategy.values().length];
            $SwitchMap$org$apache$commons$math$stat$ranking$TiesStrategy[TiesStrategy.AVERAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L51:
            $SwitchMap$org$apache$commons$math$stat$ranking$TiesStrategy[TiesStrategy.MAXIMUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L39:
            $SwitchMap$org$apache$commons$math$stat$ranking$TiesStrategy[TiesStrategy.MINIMUM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L35:
            $SwitchMap$org$apache$commons$math$stat$ranking$TiesStrategy[TiesStrategy.RANDOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L41:
            $SwitchMap$org$apache$commons$math$stat$ranking$TiesStrategy[TiesStrategy.SEQUENTIAL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L21:
            $SwitchMap$org$apache$commons$math$stat$ranking$NaNStrategy = new int[NaNStrategy.values().length];
            $SwitchMap$org$apache$commons$math$stat$ranking$NaNStrategy[NaNStrategy.MAXIMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L43:
            $SwitchMap$org$apache$commons$math$stat$ranking$NaNStrategy[NaNStrategy.MINIMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L47:
            $SwitchMap$org$apache$commons$math$stat$ranking$NaNStrategy[NaNStrategy.REMOVED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L49:
            $SwitchMap$org$apache$commons$math$stat$ranking$NaNStrategy[NaNStrategy.FIXED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L33
            return;
        }
    }

    private static class IntDoublePair implements Comparable<IntDoublePair> {
        private final int position;
        private final double value;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(IntDoublePair r1) {
            return compareTo2(r1);
        }

        public IntDoublePair(double value, int position) {
            this.value = value;
            this.position = position;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(IntDoublePair other) {
            return Double.compare(this.value, other.value);
        }

        public double getValue() {
            return this.value;
        }

        public int getPosition() {
            return this.position;
        }
    }

    static {
        DEFAULT_NAN_STRATEGY = NaNStrategy.MAXIMAL;
        DEFAULT_TIES_STRATEGY = TiesStrategy.AVERAGE;
    }

    public NaturalRanking() {
        this.tiesStrategy = DEFAULT_TIES_STRATEGY;
        this.nanStrategy = DEFAULT_NAN_STRATEGY;
        this.randomData = null;
    }

    public NaturalRanking(TiesStrategy tiesStrategy) {
        this.tiesStrategy = tiesStrategy;
        this.nanStrategy = DEFAULT_NAN_STRATEGY;
        this.randomData = new RandomDataImpl();
    }

    public NaturalRanking(NaNStrategy nanStrategy) {
        this.nanStrategy = nanStrategy;
        this.tiesStrategy = DEFAULT_TIES_STRATEGY;
        this.randomData = null;
    }

    public NaturalRanking(NaNStrategy nanStrategy, TiesStrategy tiesStrategy) {
        this.nanStrategy = nanStrategy;
        this.tiesStrategy = tiesStrategy;
        this.randomData = new RandomDataImpl();
    }

    public NaturalRanking(RandomGenerator randomGenerator) {
        this.tiesStrategy = TiesStrategy.RANDOM;
        this.nanStrategy = DEFAULT_NAN_STRATEGY;
        this.randomData = new RandomDataImpl(randomGenerator);
    }

    public NaturalRanking(NaNStrategy nanStrategy, RandomGenerator randomGenerator) {
        this.nanStrategy = nanStrategy;
        this.tiesStrategy = TiesStrategy.RANDOM;
        this.randomData = new RandomDataImpl(randomGenerator);
    }

    public NaNStrategy getNanStrategy() {
        return this.nanStrategy;
    }

    public TiesStrategy getTiesStrategy() {
        return this.tiesStrategy;
    }

    @Override // org.apache.commons.math.stat.ranking.RankingAlgorithm
    public double[] rank(double[] data) {
        IntDoublePair[] ranks = new IntDoublePair[data.length];
        int i = 0;
    L4:
        if (i >= data.length) goto L6;
        ranks[i] = new IntDoublePair(data[i], i);
        i = i + 1;
        goto L4
    L6:
        List<Integer> nanPositions = null;
        switch(AnonymousClass1.$SwitchMap$org$apache$commons$math$stat$ranking$NaNStrategy[this.nanStrategy.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            default: goto L9;
        };
    L10:
        nanPositions = getNanPositions(ranks);
    L14:
        Arrays.sort(ranks);
        double[] out = new double[ranks.length];
        int pos = 1;
        out[ranks[0].getPosition()] = 1;
        List<Integer> tiesTrace = new ArrayList();
        tiesTrace.add(Integer.valueOf(ranks[0].getPosition()));
        int i2 = 1;
    L16:
        if (i2 >= ranks.length) goto L25;
        if (Double.compare(ranks[i2].getValue(), ranks[i2 - 1].getValue()) <= 0) goto L23;
        pos = i2 + 1;
        if (tiesTrace.size() <= 1) goto L22;
        resolveTie(out, tiesTrace);
    L22:
        List<Integer> tiesTrace2 = new ArrayList();
        tiesTrace2.add(Integer.valueOf(ranks[i2].getPosition()));
        tiesTrace = tiesTrace2;
    L24:
        out[ranks[i2].getPosition()] = pos;
        i2 = i2 + 1;
        goto L16
    L23:
        tiesTrace.add(Integer.valueOf(ranks[i2].getPosition()));
        goto L24
    L25:
        int i3 = tiesTrace.size();
        if (i3 <= 1) goto L29;
        resolveTie(out, tiesTrace);
    L29:
        if (this.nanStrategy != NaNStrategy.FIXED) goto L31;
        restoreNaNs(out, nanPositions);
    L31:
        return out;
    L11:
        ranks = removeNaNs(ranks);
        goto L14
    L12:
        recodeNaNs(ranks, Double.NEGATIVE_INFINITY);
        goto L14
    L13:
        recodeNaNs(ranks, Double.POSITIVE_INFINITY);
        goto L14
    L9:
        throw new MathInternalError();
    }

    private IntDoublePair[] removeNaNs(IntDoublePair[] ranks) {
        if (containsNaNs(ranks) == true) goto L5;
        return ranks;
    L5:
        IntDoublePair[] outRanks = new IntDoublePair[ranks.length];
        int j = 0;
        int i = 0;
    L7:
        if (i >= ranks.length) goto L17;
        if (Double.isNaN(ranks[i].getValue()) == false) goto L15;
        int k = i + 1;
    L12:
        if (k >= ranks.length) goto L16;
        ranks[k] = new IntDoublePair(ranks[k].getValue(), ranks[k].getPosition() - 1);
        k = k + 1;
    L16:
        i = i + 1;
        goto L7
    L15:
        outRanks[j] = new IntDoublePair(ranks[i].getValue(), ranks[i].getPosition());
        j = j + 1;
        goto L16
    L17:
        IntDoublePair[] returnRanks = new IntDoublePair[j];
        System.arraycopy(outRanks, 0, returnRanks, 0, j);
        return returnRanks;
    }

    private void recodeNaNs(IntDoublePair[] ranks, double value) {
        int i = 0;
    L4:
        if (i >= ranks.length) goto L10;
        if (Double.isNaN(ranks[i].getValue()) == false) goto L8;
        ranks[i] = new IntDoublePair(value, ranks[i].getPosition());
    L8:
        i = i + 1;
        goto L4
    }

    private boolean containsNaNs(IntDoublePair[] ranks) {
        int i = 0;
    L4:
        if (i >= ranks.length) goto L10;
        if (Double.isNaN(ranks[i].getValue()) == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    private void resolveTie(double[] ranks, List<Integer> tiesTrace) {
        double c = ranks[tiesTrace.get(0).intValue()];
        int length = tiesTrace.size();
        switch(AnonymousClass1.$SwitchMap$org$apache$commons$math$stat$ranking$TiesStrategy[this.tiesStrategy.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L10;
            case 5: goto L6;
            default: goto L5;
        };
    L6:
        Iterator<Integer> iterator = tiesTrace.iterator();
        long f = FastMath.round(c);
        int i = 0;
    L8:
        if (iterator.hasNext() == false) goto L22;
        ranks[iterator.next().intValue()] = ((long) i) + f;
        i = i + 1;
        goto L8
    L22:
        return;
    L10:
        Iterator<Integer> iterator2 = tiesTrace.iterator();
        long f2 = FastMath.round(c);
    L12:
        if (iterator2.hasNext() == false) goto L23;
        ranks[iterator2.next().intValue()] = this.randomData.nextLong(f2, (((long) length) + f2) - 1);
        goto L12
    L23:
        return;
    L14:
        fill(ranks, tiesTrace, c);
        return;
    L15:
        fill(ranks, tiesTrace, (((double) length) + c) - 1.0d);
        return;
    L16:
        fill(ranks, tiesTrace, (((c * 2.0d) + ((double) length)) - 1.0d) / 2.0d);
        return;
    L5:
        throw new MathInternalError();
    }

    private void fill(double[] data, List<Integer> tiesTrace, double value) {
        Iterator<Integer> iterator = tiesTrace.iterator();
    L4:
        if (iterator.hasNext() == false) goto L6;
        data[iterator.next().intValue()] = value;
        goto L4
    }

    private void restoreNaNs(double[] ranks, List<Integer> nanPositions) {
        if (nanPositions.size() != 0) goto L5;
        return;
    L5:
        Iterator<Integer> iterator = nanPositions.iterator();
    L7:
        if (iterator.hasNext() == false) goto L9;
        ranks[iterator.next().intValue()] = Double.NaN;
        goto L7
    }

    private List<Integer> getNanPositions(IntDoublePair[] ranks) {
        ArrayList<Integer> out = new ArrayList();
        int i = 0;
    L4:
        if (i >= ranks.length) goto L10;
        if (Double.isNaN(ranks[i].getValue()) == false) goto L8;
        out.add(Integer.valueOf(i));
    L8:
        i = i + 1;
        goto L4
    L10:
        return out;
    }
}
