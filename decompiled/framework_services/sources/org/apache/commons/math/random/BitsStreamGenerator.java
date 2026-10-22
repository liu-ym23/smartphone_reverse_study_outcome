package org.apache.commons.math.random;

import org.apache.commons.math.exception.NotStrictlyPositiveException;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BitsStreamGenerator implements RandomGenerator {
    private double nextGaussian;

    protected abstract int next(int r1);

    @Override // org.apache.commons.math.random.RandomGenerator
    public abstract void setSeed(int r1);

    @Override // org.apache.commons.math.random.RandomGenerator
    public abstract void setSeed(long r1);

    @Override // org.apache.commons.math.random.RandomGenerator
    public abstract void setSeed(int[] r1);

    public BitsStreamGenerator() {
        this.nextGaussian = Double.NaN;
    }

    @Override // org.apache.commons.math.random.RandomGenerator
    public boolean nextBoolean() {
        if (next(1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // org.apache.commons.math.random.RandomGenerator
    public void nextBytes(byte[] bytes) {
        int i = 0;
        int iEnd = bytes.length - 3;
    L4:
        if (i >= iEnd) goto L6;
        int random = next(32);
        bytes[i] = (byte) (random & 255);
        bytes[i + 1] = (byte) ((random >> 8) & 255);
        bytes[i + 2] = (byte) ((random >> 16) & 255);
        bytes[i + 3] = (byte) ((random >> 24) & 255);
        i = i + 4;
        goto L4
    L6:
        int random2 = next(32);
    L8:
        if (i >= bytes.length) goto L10;
        bytes[i] = (byte) (random2 & 255);
        random2 = random2 >> 8;
        i = i + 1;
        goto L8
    }

    @Override // org.apache.commons.math.random.RandomGenerator
    public double nextDouble() {
        long high = ((long) next(26)) << 26;
        int low = next(26);
        return (((long) low) | high) * 2.220446049250313E-16d;
    }

    @Override // org.apache.commons.math.random.RandomGenerator
    public float nextFloat() {
        return next(23) * 1.1920929E-7f;
    }

    @Override // org.apache.commons.math.random.RandomGenerator
    public double nextGaussian() {
        if (Double.isNaN(this.nextGaussian) == false) goto L5;
        double x = nextDouble();
        double y = nextDouble();
        double alpha = 6.283185307179586d * x;
        double r = FastMath.sqrt(FastMath.log(y) * (-2.0d));
        double random = FastMath.cos(alpha) * r;
        this.nextGaussian = FastMath.sin(alpha) * r;
        return random;
    L5:
        double random2 = this.nextGaussian;
        this.nextGaussian = Double.NaN;
        return random2;
    }

    @Override // org.apache.commons.math.random.RandomGenerator
    public int nextInt() {
        return next(32);
    }

    @Override // org.apache.commons.math.random.RandomGenerator
    public int nextInt(int n) throws IllegalArgumentException {
        if (n < 1) goto L10;
        int mask = n | (n >> 1);
        int mask2 = mask | (mask >> 2);
        int mask3 = mask2 | (mask2 >> 4);
        int mask4 = mask3 | (mask3 >> 8);
        int mask5 = mask4 | (mask4 >> 16);
    L5:
        int random = next(32) & mask5;
        if (random >= n) goto L5;
        return random;
    L10:
        throw new NotStrictlyPositiveException(Integer.valueOf(n));
    }

    @Override // org.apache.commons.math.random.RandomGenerator
    public long nextLong() {
        long high = ((long) next(32)) << 32;
        long low = ((long) next(32)) & 4294967295L;
        return high | low;
    }
}
