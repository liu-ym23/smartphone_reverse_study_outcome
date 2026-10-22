package org.apache.commons.math.random;

import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public interface RandomData {
    double nextExponential(double r1);

    double nextGaussian(double r1, double r3);

    String nextHexString(int r1);

    int nextInt(int r1, int r2);

    long nextLong(long r1, long r3);

    int[] nextPermutation(int r1, int r2);

    long nextPoisson(double r1);

    Object[] nextSample(Collection<?> r1, int r2);

    String nextSecureHexString(int r1);

    int nextSecureInt(int r1, int r2);

    long nextSecureLong(long r1, long r3);

    double nextUniform(double r1, double r3);
}
