package org.apache.commons.math.random;

import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class UnitSphereRandomVectorGenerator implements RandomVectorGenerator {
    private final int dimension;
    private final RandomGenerator rand;

    public UnitSphereRandomVectorGenerator(int dimension, RandomGenerator rand) {
        this.dimension = dimension;
        this.rand = rand;
    }

    public UnitSphereRandomVectorGenerator(int dimension) {
        this(dimension, new MersenneTwister());
    }

    @Override // org.apache.commons.math.random.RandomVectorGenerator
    public double[] nextVector() {
        double[] v = new double[this.dimension];
    L3:
        double normSq = 0.0d;
        int i = 0;
    L5:
        if (i >= this.dimension) goto L8;
        double comp = (this.rand.nextDouble() * 2.0d) - 1.0d;
        v[i] = comp;
        normSq = normSq + (comp * comp);
        i = i + 1;
        goto L5
    L8:
        if (normSq > 1.0d) goto L3;
        double f = 1.0d / FastMath.sqrt(normSq);
        int i2 = 0;
    L11:
        if (i2 >= this.dimension) goto L14;
        v[i2] = v[i2] * f;
        i2 = i2 + 1;
        goto L11
    L14:
        return v;
    }
}
