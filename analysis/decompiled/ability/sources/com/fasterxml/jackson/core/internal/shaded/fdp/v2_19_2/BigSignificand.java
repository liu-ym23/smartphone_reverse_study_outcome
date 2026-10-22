package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import androidx.collection.SieveCacheKt;
import androidx.compose.foundation.b;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/* loaded from: classes2.dex */
class BigSignificand {
    private static final long LONG_MASK = 4294967295L;
    private int firstNonZeroInt;
    private final int numInts;

    /* renamed from: x, reason: collision with root package name */
    private final int[] f2251x;

    public BigSignificand(long j5) {
        if (j5 <= 0 || j5 >= SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException(b.p(j5, "numBits="));
        }
        int i = (((int) ((j5 + 63) >>> 6)) + 1) << 1;
        this.numInts = i;
        this.f2251x = new int[i];
        this.firstNonZeroInt = i;
    }

    private void x(int i, int i6) {
        this.f2251x[i] = i6;
    }

    public void add(int i) {
        if (i == 0) {
            return;
        }
        long j5 = i & LONG_MASK;
        int i6 = this.numInts;
        while (true) {
            i6--;
            if (j5 == 0) {
                this.firstNonZeroInt = Math.min(this.firstNonZeroInt, i6 + 1);
                return;
            } else {
                long jX = (x(i6) & LONG_MASK) + j5;
                x(i6, (int) jX);
                j5 = jX >>> 32;
            }
        }
    }

    public void fma(int i, int i6) {
        long j5 = i & LONG_MASK;
        long j6 = i6;
        int i10 = this.numInts;
        while (true) {
            i10--;
            if (i10 < this.firstNonZeroInt) {
                break;
            }
            long jX = ((x(i10) & LONG_MASK) * j5) + j6;
            x(i10, (int) jX);
            j6 = jX >>> 32;
        }
        if (j6 != 0) {
            x(i10, (int) j6);
            this.firstNonZeroInt = i10;
        }
    }

    public BigInteger toBigInteger() {
        byte[] bArr = new byte[this.f2251x.length << 2];
        IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(bArr).asIntBuffer();
        int i = 0;
        while (true) {
            int[] iArr = this.f2251x;
            if (i >= iArr.length) {
                return new BigInteger(bArr);
            }
            intBufferAsIntBuffer.put(i, iArr[i]);
            i++;
        }
    }

    private int x(int i) {
        return this.f2251x[i];
    }
}
