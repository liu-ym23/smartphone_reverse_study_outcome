package org.apache.commons.math.random;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Collection;
import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.BetaDistributionImpl;
import org.apache.commons.math.distribution.BinomialDistributionImpl;
import org.apache.commons.math.distribution.CauchyDistributionImpl;
import org.apache.commons.math.distribution.ChiSquaredDistributionImpl;
import org.apache.commons.math.distribution.ContinuousDistribution;
import org.apache.commons.math.distribution.FDistributionImpl;
import org.apache.commons.math.distribution.GammaDistributionImpl;
import org.apache.commons.math.distribution.HypergeometricDistributionImpl;
import org.apache.commons.math.distribution.IntegerDistribution;
import org.apache.commons.math.distribution.PascalDistributionImpl;
import org.apache.commons.math.distribution.TDistributionImpl;
import org.apache.commons.math.distribution.WeibullDistributionImpl;
import org.apache.commons.math.distribution.ZipfDistributionImpl;
import org.apache.commons.math.exception.MathInternalError;
import org.apache.commons.math.exception.NotStrictlyPositiveException;
import org.apache.commons.math.exception.NumberIsTooLargeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class RandomDataImpl implements RandomData, Serializable {
    private static final long serialVersionUID = -626730818244969716L;
    private RandomGenerator rand;
    private SecureRandom secRand;

    public RandomDataImpl() {
        this.rand = null;
        this.secRand = null;
    }

    public RandomDataImpl(RandomGenerator rand) {
        this.rand = null;
        this.secRand = null;
        this.rand = rand;
    }

    @Override // org.apache.commons.math.random.RandomData
    public String nextHexString(int len) {
        if (len <= 0) goto L13;
        RandomGenerator ran = getRan();
        StringBuilder outBuffer = new StringBuilder();
        byte[] randomBytes = new byte[(len / 2) + 1];
        ran.nextBytes(randomBytes);
        int i = 0;
    L5:
        if (i >= randomBytes.length) goto L11;
        Integer c = Integer.valueOf(randomBytes[i]);
        String hex = Integer.toHexString(c.intValue() + 128);
        if (hex.length() != 1) goto L9;
        hex = "0" + hex;
    L9:
        outBuffer.append(hex);
        i = i + 1;
        goto L5
    L11:
        return outBuffer.toString().substring(0, len);
    L13:
        throw new NotStrictlyPositiveException(LocalizedFormats.LENGTH, Integer.valueOf(len));
    }

    @Override // org.apache.commons.math.random.RandomData
    public int nextInt(int lower, int upper) {
        if (lower >= upper) goto L6;
        double r = getRan().nextDouble();
        return (int) (((((double) upper) * r) + ((1.0d - r) * ((double) lower))) + r);
    L6:
        throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, Integer.valueOf(lower), Integer.valueOf(upper), false);
    }

    @Override // org.apache.commons.math.random.RandomData
    public long nextLong(long lower, long upper) {
        if (lower >= upper) goto L7;
        double r = getRan().nextDouble();
        return (long) (((upper * r) + ((1.0d - r) * lower)) + r);
    L7:
        throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, Long.valueOf(lower), Long.valueOf(upper), false);
    }

    @Override // org.apache.commons.math.random.RandomData
    public String nextSecureHexString(int len) {
        if (len <= 0) goto L22;
        SecureRandom secRan = getSecRan();
        MessageDigest alg = MessageDigest.getInstance("SHA-1");     // Catch: NoSuchAlgorithmException -> L18
        alg.reset();
        int numIter = (len / 40) + 1;
        StringBuilder outBuffer = new StringBuilder();
        int iter = 1;
    L7:
        if (iter >= (numIter + 1)) goto L17;
        byte[] randomBytes = new byte[40];
        secRan.nextBytes(randomBytes);
        alg.update(randomBytes);
        byte[] hash = alg.digest();
        int i = 0;
    L10:
        if (i >= hash.length) goto L15;
        Integer c = Integer.valueOf(hash[i]);
        String hex = Integer.toHexString(c.intValue() + 128);
        if (hex.length() != 1) goto L14;
        hex = "0" + hex;
    L14:
        outBuffer.append(hex);
        i = i + 1;
        goto L10
    L15:
        iter = iter + 1;
        goto L7
    L17:
        return outBuffer.toString().substring(0, len);
    L18:
        ex = move-exception;
        throw new MathInternalError(ex);
    L22:
        throw new NotStrictlyPositiveException(LocalizedFormats.LENGTH, Integer.valueOf(len));
    }

    @Override // org.apache.commons.math.random.RandomData
    public int nextSecureInt(int lower, int upper) {
        if (lower >= upper) goto L6;
        SecureRandom sec = getSecRan();
        return ((int) (sec.nextDouble() * ((double) ((upper - lower) + 1)))) + lower;
    L6:
        throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, Integer.valueOf(lower), Integer.valueOf(upper), false);
    }

    @Override // org.apache.commons.math.random.RandomData
    public long nextSecureLong(long lower, long upper) {
        if (lower >= upper) goto L7;
        SecureRandom sec = getSecRan();
        return ((long) (sec.nextDouble() * ((upper - lower) + 1))) + lower;
    L7:
        throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, Long.valueOf(lower), Long.valueOf(upper), false);
    }

    @Override // org.apache.commons.math.random.RandomData
    public long nextPoisson(double mean) {
        if (mean <= 0.0d) goto L58;
        RandomGenerator generator = getRan();
        if (mean >= 40.0d) goto L14;
        double p = FastMath.exp(-mean);
        long n = 0;
        double r = 1.0d;
    L8:
        if (n >= (1000.0d * mean)) goto L13;
        double rnd = generator.nextDouble();
        r = r * rnd;
        if (r < p) goto L12;
        n = n + 1;
        goto L8
    L12:
        return n;
    L13:
        return n;
    L14:
        double lambda = FastMath.floor(mean);
        double lambdaFractional = mean - lambda;
        double logLambda = FastMath.log(lambda);
        double logLambdaFactorial = MathUtils.factorialLog((int) lambda);
        if (lambdaFractional >= Double.MIN_VALUE) goto L17;
        long y2 = 0;
    L18:
        double r22 = 0.0d;
        double r24 = 1.0d;
        double delta = FastMath.sqrt(FastMath.log(((32.0d * lambda) / 3.141592653589793d) + 1.0d) * lambda);
        double halfDelta = delta / 2.0d;
        double twolpd = (lambda * 2.0d) + delta;
        double a1 = FastMath.sqrt(3.141592653589793d * twolpd) * FastMath.exp(lambda * 0.0d);
        double a2 = (twolpd / delta) * FastMath.exp(((-delta) * (delta + 1.0d)) / twolpd);
        double aSum = (a1 + a2) + 1.0d;
        double p1 = a1 / aSum;
        double p2 = a2 / aSum;
        double c1 = 1.0d / (8.0d * lambda);
        int a = 0;
    L19:
        aSum = aSum;
        delta = delta;
        double aSum2 = r22;
        double delta2 = r24;
        double u = nextUniform(aSum2, delta2);
        if (u > p1) goto L33;
        double n2 = nextGaussian(aSum2, delta2);
        double x = (FastMath.sqrt(lambda + halfDelta) * n2) - 0.5d;
        if (x > delta) goto L31;
        if (x < (-lambda)) goto L31;
        if (x >= 0.0d) goto L29;
        double y = FastMath.floor(x);
    L30:
        double y3 = y;
        double e = nextExponential(1.0d);
        double v = ((-e) - ((n2 * n2) / 2.0d)) + c1;
        double v2 = v;
    L36:
        r22 = 0.0d;
        if (x >= 0.0d) goto L39;
        int a3 = 1;
    L40:
        double t = ((y3 + 1.0d) * y3) / (lambda * 2.0d);
        RandomGenerator generator2 = generator;
        if (v2 >= (-t)) goto L44;
        if (a3 != 0) goto L44;
        double y4 = lambda + y3;
    L54:
        return y2 + ((long) y4);
    L44:
        r24 = 1.0d;
        double qr = t * ((((y3 * 2.0d) + 1.0d) / (6.0d * lambda)) - 1.0d);
        double qa = qr - ((t * t) / (((((double) a3) * (y3 + 1.0d)) + lambda) * 3.0d));
        if (v2 < qa) goto L46;
        if (v2 <= qr) goto L51;
    L56:
        generator = generator2;
        a = a3;
        goto L19
    L51:
        if (v2 >= (((y3 * logLambda) - MathUtils.factorialLog((int) (y3 + lambda))) + logLambdaFactorial)) goto L56;
        y4 = lambda + y3;
        goto L54
    L46:
        y4 = lambda + y3;
        goto L54
    L39:
        a3 = 0;
        goto L40
    L29:
        y = FastMath.ceil(x);
    L31:
        r22 = 0.0d;
        r24 = 1.0d;
        goto L19
    L33:
        if (u > (p1 + p2)) goto L34;
        double y5 = twolpd / delta;
        double x2 = delta + (y5 * nextExponential(1.0d));
        double y6 = FastMath.ceil(x2);
        y3 = y6;
        x = x2;
        v2 = (-nextExponential(1.0d)) - ((delta * (x2 + 1.0d)) / twolpd);
        goto L36
    L34:
        y4 = lambda;
        goto L54
    L17:
        y2 = nextPoisson(lambdaFractional);
        goto L18
    L58:
        throw new NotStrictlyPositiveException(LocalizedFormats.MEAN, Double.valueOf(mean));
    }

    @Override // org.apache.commons.math.random.RandomData
    public double nextGaussian(double mu, double sigma) {
        if (sigma <= 0.0d) goto L7;
        return (getRan().nextGaussian() * sigma) + mu;
    L7:
        throw new NotStrictlyPositiveException(LocalizedFormats.STANDARD_DEVIATION, Double.valueOf(sigma));
    }

    @Override // org.apache.commons.math.random.RandomData
    public double nextExponential(double mean) {
        if (mean <= 0.0d) goto L11;
        RandomGenerator generator = getRan();
        double unif = generator.nextDouble();
    L6:
        if (unif != 0.0d) goto L9;
        unif = generator.nextDouble();
        goto L6
    L9:
        return (-mean) * FastMath.log(unif);
    L11:
        throw new NotStrictlyPositiveException(LocalizedFormats.MEAN, Double.valueOf(mean));
    }

    @Override // org.apache.commons.math.random.RandomData
    public double nextUniform(double lower, double upper) {
        if (lower >= upper) goto L11;
        RandomGenerator generator = getRan();
        double u = generator.nextDouble();
    L6:
        if (u > 0.0d) goto L9;
        u = generator.nextDouble();
        goto L6
    L9:
        return ((upper - lower) * u) + lower;
    L11:
        throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, Double.valueOf(lower), Double.valueOf(upper), false);
    }

    public double nextBeta(double alpha, double beta) throws MathException {
        return nextInversionDeviate(new BetaDistributionImpl(alpha, beta));
    }

    public int nextBinomial(int numberOfTrials, double probabilityOfSuccess) throws MathException {
        return nextInversionDeviate(new BinomialDistributionImpl(numberOfTrials, probabilityOfSuccess));
    }

    public double nextCauchy(double median, double scale) throws MathException {
        return nextInversionDeviate(new CauchyDistributionImpl(median, scale));
    }

    public double nextChiSquare(double df) throws MathException {
        return nextInversionDeviate(new ChiSquaredDistributionImpl(df));
    }

    public double nextF(double numeratorDf, double denominatorDf) throws MathException {
        return nextInversionDeviate(new FDistributionImpl(numeratorDf, denominatorDf));
    }

    public double nextGamma(double shape, double scale) throws MathException {
        return nextInversionDeviate(new GammaDistributionImpl(shape, scale));
    }

    public int nextHypergeometric(int populationSize, int numberOfSuccesses, int sampleSize) throws MathException {
        return nextInversionDeviate(new HypergeometricDistributionImpl(populationSize, numberOfSuccesses, sampleSize));
    }

    public int nextPascal(int r, double p) throws MathException {
        return nextInversionDeviate(new PascalDistributionImpl(r, p));
    }

    public double nextT(double df) throws MathException {
        return nextInversionDeviate(new TDistributionImpl(df));
    }

    public double nextWeibull(double shape, double scale) throws MathException {
        return nextInversionDeviate(new WeibullDistributionImpl(shape, scale));
    }

    public int nextZipf(int numberOfElements, double exponent) throws MathException {
        return nextInversionDeviate(new ZipfDistributionImpl(numberOfElements, exponent));
    }

    private RandomGenerator getRan() {
        if (this.rand != null) goto L6;
        this.rand = new JDKRandomGenerator();
        this.rand.setSeed(System.currentTimeMillis());
    L6:
        return this.rand;
    }

    private SecureRandom getSecRan() {
        if (this.secRand != null) goto L6;
        this.secRand = new SecureRandom();
        this.secRand.setSeed(System.currentTimeMillis());
    L6:
        return this.secRand;
    }

    public void reSeed(long seed) {
        if (this.rand != null) goto L5;
        this.rand = new JDKRandomGenerator();
    L5:
        this.rand.setSeed(seed);
    }

    public void reSeedSecure() {
        if (this.secRand != null) goto L5;
        this.secRand = new SecureRandom();
    L5:
        this.secRand.setSeed(System.currentTimeMillis());
    }

    public void reSeedSecure(long seed) {
        if (this.secRand != null) goto L5;
        this.secRand = new SecureRandom();
    L5:
        this.secRand.setSeed(seed);
    }

    public void reSeed() {
        if (this.rand != null) goto L5;
        this.rand = new JDKRandomGenerator();
    L5:
        this.rand.setSeed(System.currentTimeMillis());
    }

    public void setSecureAlgorithm(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        this.secRand = SecureRandom.getInstance(algorithm, provider);
    }

    @Override // org.apache.commons.math.random.RandomData
    public int[] nextPermutation(int n, int k) {
        if (k > n) goto L13;
        if (k == 0) goto L11;
        int[] index = getNatural(n);
        shuffle(index, n - k);
        int[] result = new int[k];
        int i = 0;
    L6:
        if (i >= k) goto L9;
        result[i] = index[(n - i) - 1];
        i = i + 1;
        goto L6
    L9:
        return result;
    L11:
        throw new NotStrictlyPositiveException(LocalizedFormats.PERMUTATION_SIZE, Integer.valueOf(k));
    L13:
        throw new NumberIsTooLargeException(LocalizedFormats.PERMUTATION_EXCEEDS_N, Integer.valueOf(k), Integer.valueOf(n), true);
    }

    @Override // org.apache.commons.math.random.RandomData
    public Object[] nextSample(Collection<?> c, int k) {
        int len = c.size();
        if (k > len) goto L13;
        if (k <= 0) goto L11;
        Object[] objects = c.toArray();
        int[] index = nextPermutation(len, k);
        Object[] result = new Object[k];
        int i = 0;
    L6:
        if (i >= k) goto L9;
        result[i] = objects[index[i]];
        i = i + 1;
        goto L6
    L9:
        return result;
    L11:
        throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, Integer.valueOf(k));
    L13:
        throw new NumberIsTooLargeException(LocalizedFormats.SAMPLE_SIZE_EXCEEDS_COLLECTION_SIZE, Integer.valueOf(k), Integer.valueOf(len), true);
    }

    public double nextInversionDeviate(ContinuousDistribution distribution) throws MathException {
        return distribution.inverseCumulativeProbability(nextUniform(0.0d, 1.0d));
    }

    public int nextInversionDeviate(IntegerDistribution distribution) throws MathException {
        double target = nextUniform(0.0d, 1.0d);
        int glb = distribution.inverseCumulativeProbability(target);
        if (distribution.cumulativeProbability(glb) != 1.0d) goto L6;
        return glb;
    L6:
        return glb + 1;
    }

    private void shuffle(int[] list, int end) {
        int i = list.length - 1;
    L3:
        if (i < end) goto L9;
        if (i != 0) goto L6;
        int target = 0;
    L7:
        int temp = list[target];
        list[target] = list[i];
        list[i] = temp;
        i = i - 1;
        goto L3
    L6:
        target = nextInt(0, i);
        goto L7
    }

    private int[] getNatural(int n) {
        int[] natural = new int[n];
        int i = 0;
    L3:
        if (i >= n) goto L6;
        natural[i] = i;
        i = i + 1;
        goto L3
    L6:
        return natural;
    }
}
