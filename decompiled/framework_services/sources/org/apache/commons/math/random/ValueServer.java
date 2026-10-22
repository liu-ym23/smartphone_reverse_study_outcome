package org.apache.commons.math.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class ValueServer {
    public static final int CONSTANT_MODE = 5;
    public static final int DIGEST_MODE = 0;
    public static final int EXPONENTIAL_MODE = 3;
    public static final int GAUSSIAN_MODE = 4;
    public static final int REPLAY_MODE = 1;
    public static final int UNIFORM_MODE = 2;
    private EmpiricalDistribution empiricalDistribution;
    private BufferedReader filePointer;
    private int mode;
    private double mu;
    private final RandomData randomData;
    private double sigma;
    private URL valuesFileURL;

    public ValueServer() {
        this.mode = 5;
        this.valuesFileURL = null;
        this.mu = 0.0d;
        this.sigma = 0.0d;
        this.empiricalDistribution = null;
        this.filePointer = null;
        this.randomData = new RandomDataImpl();
    }

    public ValueServer(RandomData randomData) {
        this.mode = 5;
        this.valuesFileURL = null;
        this.mu = 0.0d;
        this.sigma = 0.0d;
        this.empiricalDistribution = null;
        this.filePointer = null;
        this.randomData = randomData;
    }

    public double getNext() throws IOException {
        switch(this.mode) {
            case 0: goto L17;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            default: goto L5;
        };
    L5:
        throw MathRuntimeException.createIllegalStateException(LocalizedFormats.UNKNOWN_MODE, new Object[]{Integer.valueOf(this.mode), "DIGEST_MODE", 0, "REPLAY_MODE", 1, "UNIFORM_MODE", 2, "EXPONENTIAL_MODE", 3, "GAUSSIAN_MODE", 4, "CONSTANT_MODE", 5});
    L7:
        return this.mu;
    L9:
        return getNextGaussian();
    L11:
        return getNextExponential();
    L13:
        return getNextUniform();
    L15:
        return getNextReplay();
    L17:
        return getNextDigest();
    }

    public void fill(double[] values) throws IOException {
        int i = 0;
    L4:
        if (i >= values.length) goto L7;
        values[i] = getNext();
        i = i + 1;
        goto L4
    }

    public double[] fill(int length) throws IOException {
        double[] out = new double[length];
        int i = 0;
    L3:
        if (i >= length) goto L6;
        out[i] = getNext();
        i = i + 1;
        goto L3
    L6:
        return out;
    }

    public void computeDistribution() throws IOException {
        this.empiricalDistribution = new EmpiricalDistributionImpl();
        this.empiricalDistribution.load(this.valuesFileURL);
    }

    public void computeDistribution(int binCount) throws IOException {
        this.empiricalDistribution = new EmpiricalDistributionImpl(binCount);
        this.empiricalDistribution.load(this.valuesFileURL);
        this.mu = this.empiricalDistribution.getSampleStats().getMean();
        this.sigma = this.empiricalDistribution.getSampleStats().getStandardDeviation();
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public URL getValuesFileURL() {
        return this.valuesFileURL;
    }

    public void setValuesFileURL(String url) throws MalformedURLException {
        this.valuesFileURL = new URL(url);
    }

    public void setValuesFileURL(URL url) {
        this.valuesFileURL = url;
    }

    public EmpiricalDistribution getEmpiricalDistribution() {
        return this.empiricalDistribution;
    }

    public void resetReplayFile() throws IOException {
        if (this.filePointer != null) goto L9;
    L7:
        this.filePointer = new BufferedReader(new InputStreamReader(this.valuesFileURL.openStream()));
        return;
    L9:
        this.filePointer.close();     // Catch: IOException -> L6
        this.filePointer = null;     // Catch: IOException -> L6
        goto L7
    }

    public void closeReplayFile() throws IOException {
        if (this.filePointer == null) goto L6;
        this.filePointer.close();
        this.filePointer = null;
        return;
    }

    public double getMu() {
        return this.mu;
    }

    public void setMu(double mu) {
        this.mu = mu;
    }

    public double getSigma() {
        return this.sigma;
    }

    public void setSigma(double sigma) {
        this.sigma = sigma;
    }

    private double getNextDigest() {
        if (this.empiricalDistribution == null) goto L9;
        if (this.empiricalDistribution.getBinStats().size() == 0) goto L9;
        return this.empiricalDistribution.getNextValue();
    L9:
        throw MathRuntimeException.createIllegalStateException(LocalizedFormats.DIGEST_NOT_INITIALIZED, new Object[0]);
    }

    private double getNextReplay() throws IOException {
        if (this.filePointer != null) goto L5;
        resetReplayFile();
    L5:
        String r1 = this.filePointer.readLine();
        String str = r1;
        if (r1 != null) goto L13;
        closeReplayFile();
        resetReplayFile();
        String r2 = this.filePointer.readLine();
        str = r2;
        if (r2 != null) goto L13;
        throw MathRuntimeException.createEOFException(LocalizedFormats.URL_CONTAINS_NO_DATA, new Object[]{this.valuesFileURL});
    L13:
        return Double.valueOf(str).doubleValue();
    }

    private double getNextUniform() {
        return this.randomData.nextUniform(0.0d, this.mu * 2.0d);
    }

    private double getNextExponential() {
        return this.randomData.nextExponential(this.mu);
    }

    private double getNextGaussian() {
        return this.randomData.nextGaussian(this.mu, this.sigma);
    }
}
