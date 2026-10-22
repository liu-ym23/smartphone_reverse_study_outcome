package org.apache.commons.math.analysis.interpolation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.math.DimensionMismatchException;
import org.apache.commons.math.analysis.MultivariateRealFunction;
import org.apache.commons.math.exception.NoDataException;
import org.apache.commons.math.linear.ArrayRealVector;
import org.apache.commons.math.linear.RealVector;
import org.apache.commons.math.random.UnitSphereRandomVectorGenerator;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class MicrosphereInterpolatingFunction implements MultivariateRealFunction {
    private final double brightnessExponent;
    private final int dimension;
    private final List<MicrosphereSurfaceElement> microsphere;
    private final Map<RealVector, Double> samples;

    private static class MicrosphereSurfaceElement {
        private double brightestIllumination;
        private Map.Entry<RealVector, Double> brightestSample;
        private final RealVector normal;

        MicrosphereSurfaceElement(double[] n) {
            this.normal = new ArrayRealVector(n);
        }

        RealVector normal() {
            return this.normal;
        }

        void reset() {
            this.brightestIllumination = 0.0d;
            this.brightestSample = null;
        }

        void store(double illuminationFromSample, Map.Entry<RealVector, Double> sample) {
            if (illuminationFromSample <= this.brightestIllumination) goto L6;
            this.brightestIllumination = illuminationFromSample;
            this.brightestSample = sample;
            return;
        }

        double illumination() {
            return this.brightestIllumination;
        }

        Map.Entry<RealVector, Double> sample() {
            return this.brightestSample;
        }
    }

    public MicrosphereInterpolatingFunction(double[][] xval, double[] yval, int brightnessExponent, int microsphereElements, UnitSphereRandomVectorGenerator rand) throws DimensionMismatchException, NoDataException {
        if (xval.length == 0) goto L24;
        if (xval[0] == null) goto L24;
        if (xval.length != yval.length) goto L22;
        this.dimension = xval[0].length;
        this.brightnessExponent = brightnessExponent;
        this.samples = new HashMap(yval.length);
        int i = 0;
    L10:
        if (i >= xval.length) goto L16;
        double[] xvalI = xval[i];
        if (xvalI.length != this.dimension) goto L15;
        this.samples.put(new ArrayRealVector(xvalI), Double.valueOf(yval[i]));
        i = i + 1;
        goto L10
    L15:
        throw new DimensionMismatchException(xvalI.length, this.dimension);
    L16:
        this.microsphere = new ArrayList(microsphereElements);
        int i2 = 0;
    L17:
        if (i2 >= microsphereElements) goto L20;
        this.microsphere.add(new MicrosphereSurfaceElement(rand.nextVector()));
        i2 = i2 + 1;
        goto L17
    L20:
        return;
    L22:
        throw new DimensionMismatchException(xval.length, yval.length);
    L24:
        throw new NoDataException();
    }

    @Override // org.apache.commons.math.analysis.MultivariateRealFunction
    public double value(double[] point) {
        RealVector p = new ArrayRealVector(point);
        Iterator<MicrosphereSurfaceElement> r1 = this.microsphere.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().reset();
        goto L4
    L6:
        Iterator<Map.Entry<RealVector, Double>> r2 = this.samples.entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L18;
        Map.Entry<RealVector, Double> sd = r2.next();
        RealVector diff = sd.getKey().subtract(p);
        double diffNorm = diff.getNorm();
        if (FastMath.abs(diffNorm) < FastMath.ulp(1.0d)) goto L12;
        Iterator<MicrosphereSurfaceElement> r6 = this.microsphere.iterator();
    L15:
        if (r6.hasNext() == false) goto L8;
        MicrosphereSurfaceElement md = r6.next();
        double w = FastMath.pow(diffNorm, -this.brightnessExponent);
        md.store(cosAngle(diff, md.normal()) * w, sd);
        goto L15
    L12:
        return sd.getValue().doubleValue();
    L18:
        double value = 0.0d;
        double totalWeight = 0.0d;
        Iterator<MicrosphereSurfaceElement> r5 = this.microsphere.iterator();
    L20:
        if (r5.hasNext() == false) goto L26;
        MicrosphereSurfaceElement md2 = r5.next();
        double iV = md2.illumination();
        Map.Entry<RealVector, Double> sd2 = md2.sample();
        if (sd2 == null) goto L20;
        value = value + (sd2.getValue().doubleValue() * iV);
        totalWeight = totalWeight + iV;
        goto L20
    L26:
        return value / totalWeight;
    }

    private double cosAngle(RealVector v, RealVector w) {
        return v.dotProduct(w) / (v.getNorm() * w.getNorm());
    }
}
