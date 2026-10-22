package org.apache.commons.math.random;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractWell extends BitsStreamGenerator implements Serializable {
    private static final long serialVersionUID = -817701723016583596L;
    protected final int[] i1;
    protected final int[] i2;
    protected final int[] i3;
    protected final int[] iRm1;
    protected final int[] iRm2;
    protected int index;
    protected final int[] v;

    @Override // org.apache.commons.math.random.BitsStreamGenerator
    protected abstract int next(int r1);

    protected AbstractWell(int k, int m1, int m2, int m3) {
        this(k, m1, m2, m3, System.currentTimeMillis());
    }

    protected AbstractWell(int k, int m1, int m2, int m3, int seed) {
        this(k, m1, m2, m3, new int[]{seed});
    }

    protected AbstractWell(int k, int m1, int m2, int m3, int[] seed) {
        int r = ((k + 32) - 1) / 32;
        this.v = new int[r];
        this.index = 0;
        this.iRm1 = new int[r];
        this.iRm2 = new int[r];
        this.i1 = new int[r];
        this.i2 = new int[r];
        this.i3 = new int[r];
        int j = 0;
    L3:
        if (j >= r) goto L5;
        this.iRm1[j] = ((j + r) - 1) % r;
        this.iRm2[j] = ((j + r) - 2) % r;
        this.i1[j] = (j + m1) % r;
        this.i2[j] = (j + m2) % r;
        this.i3[j] = (j + m3) % r;
        j = j + 1;
        goto L3
    L5:
        setSeed(seed);
    }

    protected AbstractWell(int k, int m1, int m2, int m3, long seed) {
        this(k, m1, m2, m3, new int[]{(int) (seed >>> 32), (int) (4294967295L & seed)});
    }

    @Override // org.apache.commons.math.random.BitsStreamGenerator, org.apache.commons.math.random.RandomGenerator
    public void setSeed(int seed) {
        setSeed(new int[]{seed});
    }

    @Override // org.apache.commons.math.random.BitsStreamGenerator, org.apache.commons.math.random.RandomGenerator
    public void setSeed(int[] seed) {
        if (seed != null) goto L5;
        setSeed(System.currentTimeMillis());
        return;
    L5:
        System.arraycopy(seed, 0, this.v, 0, Math.min(seed.length, this.v.length));
        if (seed.length >= this.v.length) goto L11;
        int i = seed.length;
    L9:
        if (i >= this.v.length) goto L11;
        long l = this.v[i - seed.length];
        this.v[i] = (int) (((((l >> 30) ^ l) * 1812433253) + ((long) i)) & 4294967295L);
        i = i + 1;
    L11:
        this.index = 0;
    }

    @Override // org.apache.commons.math.random.BitsStreamGenerator, org.apache.commons.math.random.RandomGenerator
    public void setSeed(long seed) {
        setSeed(new int[]{(int) (seed >>> 32), (int) (4294967295L & seed)});
    }
}
