package org.apache.commons.math.random;

import com.android.internal.util.FrameworkStatsLog;
import java.io.Serializable;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class MersenneTwister extends BitsStreamGenerator implements Serializable {
    private static final int M = 397;
    private static final int[] MAG01 = null;
    private static final int N = 624;
    private static final long serialVersionUID = 8661194735290153518L;
    private int[] mt;
    private int mti;

    static {
        MAG01 = new int[]{0, -1727483681};
    }

    public MersenneTwister() {
        this.mt = new int[N];
        setSeed(System.currentTimeMillis());
    }

    public MersenneTwister(int seed) {
        this.mt = new int[N];
        setSeed(seed);
    }

    public MersenneTwister(int[] seed) {
        this.mt = new int[N];
        setSeed(seed);
    }

    public MersenneTwister(long seed) {
        this.mt = new int[N];
        setSeed(seed);
    }

    @Override // org.apache.commons.math.random.BitsStreamGenerator, org.apache.commons.math.random.RandomGenerator
    public void setSeed(int seed) {
        long longMT = seed;
        this.mt[0] = (int) longMT;
        this.mti = 1;
    L4:
        if (this.mti >= N) goto L6;
        longMT = ((((longMT >> 30) ^ longMT) * 1812433253) + ((long) this.mti)) & 4294967295L;
        this.mt[this.mti] = (int) longMT;
        this.mti++;
        goto L4
    }

    @Override // org.apache.commons.math.random.BitsStreamGenerator, org.apache.commons.math.random.RandomGenerator
    public void setSeed(int[] seed) {
        if (seed != null) goto L6;
        setSeed(System.currentTimeMillis());
        return;
    L6:
        setSeed(19650218);
        int i = 1;
        int j = 0;
        int k = FastMath.max(N, seed.length);
    L8:
        if (k == 0) goto L24;
        long r6 = ((long) this.mt[i]) & 2147483647L;
        if (this.mt[i] >= 0) goto L12;
        long r20 = 2147483648L;
    L13:
        long l0 = r6 | r20;
        long r8 = ((long) this.mt[i - 1]) & 2147483647L;
        if (this.mt[i - 1] >= 0) goto L16;
        long r11 = 2147483648L;
    L17:
        long l1 = r8 | r11;
        long l = (((((l1 >> 30) ^ l1) * 1664525) ^ l0) + ((long) seed[j])) + ((long) j);
        this.mt[i] = (int) (l & 4294967295L);
        i = i + 1;
        j = j + 1;
        if (i < N) goto L21;
        this.mt[0] = this.mt[623(0x26f, float:8.73E-43)];
        i = 1;
    L21:
        if (j < seed.length) goto L23;
        j = 0;
    L23:
        k = k - 1;
        goto L8
    L16:
        r11 = 0;
        goto L17
    L12:
        r20 = 0;
        goto L13
    L24:
        int k2 = 623;
    L25:
        if (k2 == 0) goto L38;
        long r7 = ((long) this.mt[i]) & 2147483647L;
        if (this.mt[i] >= 0) goto L29;
        long r9 = 2147483648L;
    L30:
        long l2 = r7 | r9;
        long r10 = ((long) this.mt[i - 1]) & 2147483647L;
        if (this.mt[i - 1] >= 0) goto L33;
        long r22 = 2147483648L;
    L34:
        long l3 = r10 | r22;
        long l4 = (l2 ^ ((l3 ^ (l3 >> 30)) * 1566083941)) - ((long) i);
        this.mt[i] = (int) (l4 & 4294967295L);
        i = i + 1;
        if (i < N) goto L37;
        this.mt[0] = this.mt[623(0x26f, float:8.73E-43)];
        i = 1;
    L37:
        k2 = k2 - 1;
        goto L25
    L33:
        r22 = 0;
        goto L34
    L29:
        r9 = 0;
        goto L30
    L38:
        this.mt[0] = Integer.MIN_VALUE;
    }

    @Override // org.apache.commons.math.random.BitsStreamGenerator, org.apache.commons.math.random.RandomGenerator
    public void setSeed(long seed) {
        setSeed(new int[]{(int) (seed >>> 32), (int) (4294967295L & seed)});
    }

    @Override // org.apache.commons.math.random.BitsStreamGenerator
    protected int next(int bits) {
        if (this.mti < N) goto L13;
        int mtNext = this.mt[0];
        int k = 0;
    L6:
        if (k >= 227) goto L8;
        int mtCurr = mtNext;
        mtNext = this.mt[k + 1];
        int y = (Integer.MAX_VALUE & mtNext) | (Integer.MIN_VALUE & mtCurr);
        this.mt[k] = (this.mt[k + M] ^ (y >>> 1)) ^ MAG01[y & 1];
        k = k + 1;
        goto L6
    L8:
        int k2 = FrameworkStatsLog.CAMERA_ACTION_EVENT;
    L10:
        if (k2 >= 623) goto L12;
        int mtCurr2 = mtNext;
        mtNext = this.mt[k2 + 1];
        int y2 = (mtCurr2 & Integer.MIN_VALUE) | (mtNext & Integer.MAX_VALUE);
        this.mt[k2] = (this.mt[k2 - 227] ^ (y2 >>> 1)) ^ MAG01[y2 & 1];
        k2 = k2 + 1;
        goto L10
    L12:
        int k3 = mtNext & Integer.MIN_VALUE;
        int y3 = k3 | (Integer.MAX_VALUE & this.mt[0]);
        this.mt[623(0x26f, float:8.73E-43)] = (this.mt[396(0x18c, float:5.55E-43)] ^ (y3 >>> 1)) ^ MAG01[y3 & 1];
        this.mti = 0;
    L13:
        int[] r0 = this.mt;
        int r1 = this.mti;
        this.mti = r1 + 1;
        int y4 = r0[r1];
        int y5 = y4 ^ (y4 >>> 11);
        int y6 = y5 ^ ((y5 << 7) & (-1658038656));
        int y7 = y6 ^ ((y6 << 15) & (-272236544));
        return (y7 ^ (y7 >>> 18)) >>> (32 - bits);
    }
}
