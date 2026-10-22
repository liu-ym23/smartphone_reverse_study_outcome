package org.apache.commons.math.random;

import org.apache.commons.math.exception.NotStrictlyPositiveException;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractRandomGenerator implements RandomGenerator {
    private double cachedNormalDeviate;

    @Override // org.apache.commons.math.random.RandomGenerator
    public abstract double nextDouble();

    @Override // org.apache.commons.math.random.RandomGenerator
    public abstract void setSeed(long r1);

    public AbstractRandomGenerator() {
        this.cachedNormalDeviate = Double.NaN;
    }

    public void clear() {
        this.cachedNormalDeviate = Double.NaN;
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

    @Override // org.apache.commons.math.random.RandomGenerator
    public void nextBytes(byte[] bytes) {
        int bytesOut = 0;
    L4:
        if (bytesOut >= bytes.length) goto L15;
        int randInt = nextInt();
        int i = 0;
    L7:
        if (i >= 3) goto L4;
        if (i <= 0) goto L10;
        randInt = randInt >> 8;
    L10:
        int bytesOut2 = bytesOut + 1;
        bytes[bytesOut] = (byte) randInt;
        if (bytesOut2 == bytes.length) goto L12;
        i = i + 1;
        bytesOut = bytesOut2;
        goto L7
    L12:
        return;
    }

    @Override // org.apache.commons.math.random.RandomGenerator
    public int nextInt() {
        return (int) (nextDouble() * 2.147483647E9d);
    }

    @Override // org.apache.commons.math.random.RandomGenerator
    public int nextInt(int n) {
        if (n <= 0) goto L9;
        int result = (int) (nextDouble() * ((double) n));
        if (result >= n) goto L7;
        return result;
    L7:
        return n - 1;
    L9:
        throw new NotStrictlyPositiveException(Integer.valueOf(n));
    }

    @Override // org.apache.commons.math.random.RandomGenerator
    public long nextLong() {
        return (long) (nextDouble() * 9.223372036854776E18d);
    }

    @Override // org.apache.commons.math.random.RandomGenerator
    public boolean nextBoolean() {
        if (nextDouble() > 0.5d) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.math.random.RandomGenerator
    public float nextFloat() {
        return (float) nextDouble();
    }

    @Override // org.apache.commons.math.random.RandomGenerator
    public double nextGaussian() {
        if (Double.isNaN(this.cachedNormalDeviate) == true) goto L6;
        double dev = this.cachedNormalDeviate;
        this.cachedNormalDeviate = Double.NaN;
        return dev;
    L6:
        double v1 = 0.0d;
        double v2 = 0.0d;
        double s = 1.0d;
    L8:
        if (s < 1.0d) goto L11;
        v1 = (nextDouble() * 2.0d) - 1.0d;
        v2 = (nextDouble() * 2.0d) - 1.0d;
        s = (v1 * v1) + (v2 * v2);
        goto L8
    L11:
        if (s == 0.0d) goto L13;
        s = FastMath.sqrt((FastMath.log(s) * (-2.0d)) / s);
    L13:
        this.cachedNormalDeviate = v2 * s;
        return v1 * s;
    }
}
