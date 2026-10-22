package org.apache.commons.math.random;

import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public class JDKRandomGenerator extends Random implements RandomGenerator {
    private static final long serialVersionUID = -7745277476784028798L;

    public JDKRandomGenerator() {
    }

    @Override // org.apache.commons.math.random.RandomGenerator
    public void setSeed(int seed) {
        setSeed(seed);
    }

    @Override // org.apache.commons.math.random.RandomGenerator
    public void setSeed(int[] seed) {
        long combined = 0;
        int r4 = seed.length;
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L5;
        int s = seed[r5];
        combined = (4294967291L * combined) + ((long) s);
        r5 = r5 + 1;
        goto L3
    L5:
        setSeed(combined);
    }
}
