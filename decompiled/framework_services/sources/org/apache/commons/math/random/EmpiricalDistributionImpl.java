package org.apache.commons.math.random;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.stat.descriptive.StatisticalSummary;
import org.apache.commons.math.stat.descriptive.SummaryStatistics;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class EmpiricalDistributionImpl implements Serializable, EmpiricalDistribution {
    private static final long serialVersionUID = 5729073523949762654L;
    private final int binCount;
    private final List<SummaryStatistics> binStats;
    private double delta;
    private boolean loaded;
    private double max;
    private double min;
    private final RandomData randomData;
    private SummaryStatistics sampleStats;
    private double[] upperBounds;

    /* JADX INFO: renamed from: org.apache.commons.math.random.EmpiricalDistributionImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class ArrayDataAdapter extends DataAdapter {
        private double[] inputArray;
        final /* synthetic */ EmpiricalDistributionImpl this$0;

        public ArrayDataAdapter(EmpiricalDistributionImpl r2, double[] in) {
            this.this$0 = r2;
            super(r2, null);
            this.inputArray = in;
        }

        @Override // org.apache.commons.math.random.EmpiricalDistributionImpl.DataAdapter
        public void computeStats() throws IOException {
            EmpiricalDistributionImpl.access$302(this.this$0, new SummaryStatistics());
            int i = 0;
        L4:
            if (i >= this.inputArray.length) goto L7;
            EmpiricalDistributionImpl.access$300(this.this$0).addValue(this.inputArray[i]);
            i = i + 1;
            goto L4
        }

        @Override // org.apache.commons.math.random.EmpiricalDistributionImpl.DataAdapter
        public void computeBinStats() throws IOException {
            int i = 0;
        L4:
            if (i >= this.inputArray.length) goto L7;
            SummaryStatistics stats = (SummaryStatistics) EmpiricalDistributionImpl.access$200(this.this$0).get(EmpiricalDistributionImpl.access$100(this.this$0, this.inputArray[i]));
            stats.addValue(this.inputArray[i]);
            i = i + 1;
            goto L4
        }
    }

    private abstract class DataAdapter {
        final /* synthetic */ EmpiricalDistributionImpl this$0;

        public abstract void computeBinStats() throws IOException;

        public abstract void computeStats() throws IOException;

        private DataAdapter(EmpiricalDistributionImpl r1) {
            this.this$0 = r1;
        }

        /* synthetic */ DataAdapter(EmpiricalDistributionImpl x0, AnonymousClass1 x1) {
            this(x0);
        }
    }

    private class DataAdapterFactory {
        final /* synthetic */ EmpiricalDistributionImpl this$0;

        private DataAdapterFactory(EmpiricalDistributionImpl r1) {
            this.this$0 = r1;
        }

        /* synthetic */ DataAdapterFactory(EmpiricalDistributionImpl x0, AnonymousClass1 x1) {
            this(x0);
        }

        public DataAdapter getAdapter(Object in) {
            if ((in instanceof BufferedReader) == false) goto L7;
            BufferedReader inputStream = (BufferedReader) in;
            return new StreamDataAdapter(this.this$0, inputStream);
        L7:
            if ((in instanceof double[]) == false) goto L11;
            double[] inputArray = (double[]) in;
            return new ArrayDataAdapter(this.this$0, inputArray);
        L11:
            throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INPUT_DATA_FROM_UNSUPPORTED_DATASOURCE, new Object[]{in.getClass().getName(), BufferedReader.class.getName(), double[].class.getName()});
        }
    }

    private class StreamDataAdapter extends DataAdapter {
        private BufferedReader inputStream;
        final /* synthetic */ EmpiricalDistributionImpl this$0;

        public StreamDataAdapter(EmpiricalDistributionImpl r2, BufferedReader in) {
            this.this$0 = r2;
            super(r2, null);
            this.inputStream = in;
        }

        @Override // org.apache.commons.math.random.EmpiricalDistributionImpl.DataAdapter
        public void computeBinStats() throws IOException {
        L3:
            String str = this.inputStream.readLine();
            if (str == null) goto L6;
            double val = Double.parseDouble(str);
            SummaryStatistics stats = (SummaryStatistics) EmpiricalDistributionImpl.access$200(this.this$0).get(EmpiricalDistributionImpl.access$100(this.this$0, val));
            stats.addValue(val);
            goto L3
        L6:
            this.inputStream.close();
            this.inputStream = null;
        }

        @Override // org.apache.commons.math.random.EmpiricalDistributionImpl.DataAdapter
        public void computeStats() throws IOException {
            EmpiricalDistributionImpl.access$302(this.this$0, new SummaryStatistics());
        L3:
            String str = this.inputStream.readLine();
            if (str == null) goto L6;
            double val = Double.valueOf(str).doubleValue();
            EmpiricalDistributionImpl.access$300(this.this$0).addValue(val);
            goto L3
        L6:
            this.inputStream.close();
            this.inputStream = null;
        }
    }

    static /* synthetic */ int access$100(EmpiricalDistributionImpl x0, double x1) {
        return x0.findBin(x1);
    }

    static /* synthetic */ List access$200(EmpiricalDistributionImpl x0) {
        return x0.binStats;
    }

    static /* synthetic */ SummaryStatistics access$300(EmpiricalDistributionImpl x0) {
        return x0.sampleStats;
    }

    static /* synthetic */ SummaryStatistics access$302(EmpiricalDistributionImpl x0, SummaryStatistics x1) {
        x0.sampleStats = x1;
        return x1;
    }

    public EmpiricalDistributionImpl() {
        this.sampleStats = null;
        this.max = Double.NEGATIVE_INFINITY;
        this.min = Double.POSITIVE_INFINITY;
        this.delta = 0.0d;
        this.loaded = false;
        this.upperBounds = null;
        this.randomData = new RandomDataImpl();
        this.binCount = 1000;
        this.binStats = new ArrayList();
    }

    public EmpiricalDistributionImpl(int binCount) {
        this.sampleStats = null;
        this.max = Double.NEGATIVE_INFINITY;
        this.min = Double.POSITIVE_INFINITY;
        this.delta = 0.0d;
        this.loaded = false;
        this.upperBounds = null;
        this.randomData = new RandomDataImpl();
        this.binCount = binCount;
        this.binStats = new ArrayList();
    }

    @Override // org.apache.commons.math.random.EmpiricalDistribution
    public void load(double[] in) {
        DataAdapter da = new ArrayDataAdapter(this, in);
        da.computeStats();     // Catch: IOException -> L6
        fillBinStats(in);     // Catch: IOException -> L6
        this.loaded = true;
        return;
    L6:
        e = move-exception;
        throw new MathRuntimeException(e);
    }

    @Override // org.apache.commons.math.random.EmpiricalDistribution
    public void load(URL url) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        DataAdapter da = new StreamDataAdapter(this, in);     // Catch: Throwable -> L10
        da.computeStats();     // Catch: Throwable -> L10
        if (this.sampleStats.getN() == 0) goto L13;
        BufferedReader in2 = new BufferedReader(new InputStreamReader(url.openStream()));     // Catch: Throwable -> L10
        fillBinStats(in2);     // Catch: Throwable -> L10
        this.loaded = true;     // Catch: Throwable -> L10
        in2.close();     // Catch: IOException -> L8
        return;
    L9:
        return;
    L13:
        throw MathRuntimeException.createEOFException(LocalizedFormats.URL_CONTAINS_NO_DATA, new Object[]{url});     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        in.close();     // Catch: IOException -> L16
    L17:
        throw th;
    }

    @Override // org.apache.commons.math.random.EmpiricalDistribution
    public void load(File file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        DataAdapter da = new StreamDataAdapter(this, in);     // Catch: Throwable -> L8
        da.computeStats();     // Catch: Throwable -> L8
        in = new BufferedReader(new FileReader(file));     // Catch: Throwable -> L8
        fillBinStats(in);     // Catch: Throwable -> L8
        this.loaded = true;     // Catch: Throwable -> L8
        in.close();     // Catch: IOException -> L6
        return;
    L7:
        return;
    L8:
        th = move-exception;
        in.close();     // Catch: IOException -> L11
    L12:
        throw th;
    }

    private void fillBinStats(Object in) throws IOException {
        this.min = this.sampleStats.getMin();
        this.max = this.sampleStats.getMax();
        this.delta = (this.max - this.min) / Double.valueOf(this.binCount).doubleValue();
        if (this.binStats.isEmpty() == true) goto L5;
        this.binStats.clear();
    L5:
        int i = 0;
    L7:
        if (i >= this.binCount) goto L9;
        SummaryStatistics stats = new SummaryStatistics();
        this.binStats.add(i, stats);
        i = i + 1;
        goto L7
    L9:
        DataAdapterFactory aFactory = new DataAdapterFactory(this, null);
        DataAdapter da = aFactory.getAdapter(in);
        da.computeBinStats();
        this.upperBounds = new double[this.binCount];
        this.upperBounds[0] = this.binStats.get(0).getN() / this.sampleStats.getN();
        int i2 = 1;
    L11:
        if (i2 >= (this.binCount - 1)) goto L13;
        this.upperBounds[i2] = this.upperBounds[i2 - 1] + (this.binStats.get(i2).getN() / this.sampleStats.getN());
        i2 = i2 + 1;
        goto L11
    L13:
        this.upperBounds[this.binCount - 1] = 1.0d;
    }

    private int findBin(double value) {
        return FastMath.min(FastMath.max(((int) FastMath.ceil((value - this.min) / this.delta)) - 1, 0), this.binCount - 1);
    }

    @Override // org.apache.commons.math.random.EmpiricalDistribution
    public double getNextValue() throws IllegalStateException {
        if (this.loaded == false) goto L21;
        double x = FastMath.random();
        int i = 0;
    L6:
        if (i >= this.binCount) goto L19;
        if (x > this.upperBounds[i]) goto L17;
        SummaryStatistics stats = this.binStats.get(i);
        if (stats.getN() <= 0) goto L17;
        if (stats.getStandardDeviation() <= 0.0d) goto L16;
        return this.randomData.nextGaussian(stats.getMean(), stats.getStandardDeviation());
    L16:
        return stats.getMean();
    L17:
        i = i + 1;
        goto L6
    L19:
        throw new MathRuntimeException(LocalizedFormats.NO_BIN_SELECTED, new Object[0]);
    L21:
        throw MathRuntimeException.createIllegalStateException(LocalizedFormats.DISTRIBUTION_NOT_LOADED, new Object[0]);
    }

    @Override // org.apache.commons.math.random.EmpiricalDistribution
    public StatisticalSummary getSampleStats() {
        return this.sampleStats;
    }

    @Override // org.apache.commons.math.random.EmpiricalDistribution
    public int getBinCount() {
        return this.binCount;
    }

    @Override // org.apache.commons.math.random.EmpiricalDistribution
    public List<SummaryStatistics> getBinStats() {
        return this.binStats;
    }

    @Override // org.apache.commons.math.random.EmpiricalDistribution
    public double[] getUpperBounds() {
        double[] binUpperBounds = new double[this.binCount];
        binUpperBounds[0] = this.min + this.delta;
        int i = 1;
    L4:
        if (i >= (this.binCount - 1)) goto L6;
        binUpperBounds[i] = binUpperBounds[i - 1] + this.delta;
        i = i + 1;
        goto L4
    L6:
        int i2 = this.binCount;
        binUpperBounds[i2 - 1] = this.max;
        return binUpperBounds;
    }

    public double[] getGeneratorUpperBounds() {
        int len = this.upperBounds.length;
        double[] out = new double[len];
        System.arraycopy(this.upperBounds, 0, out, 0, len);
        return out;
    }

    @Override // org.apache.commons.math.random.EmpiricalDistribution
    public boolean isLoaded() {
        return this.loaded;
    }
}
