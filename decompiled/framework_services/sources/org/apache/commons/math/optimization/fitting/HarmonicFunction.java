package org.apache.commons.math.optimization.fitting;

import org.apache.commons.math.analysis.DifferentiableUnivariateRealFunction;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class HarmonicFunction implements DifferentiableUnivariateRealFunction {
    private final double a;
    private final double omega;
    private final double phi;

    @Override // org.apache.commons.math.analysis.DifferentiableUnivariateRealFunction
    public /* bridge */ /* synthetic */ UnivariateRealFunction derivative() {
        return derivative();
    }

    public HarmonicFunction(double a, double omega, double phi) {
        this.a = a;
        this.omega = omega;
        this.phi = phi;
    }

    @Override // org.apache.commons.math.analysis.UnivariateRealFunction
    public double value(double x) {
        return this.a * FastMath.cos((this.omega * x) + this.phi);
    }

    @Override // org.apache.commons.math.analysis.DifferentiableUnivariateRealFunction
    public HarmonicFunction derivative() {
        return new HarmonicFunction(this.a * this.omega, this.omega, this.phi + 1.5707963267948966d);
    }

    public double getAmplitude() {
        return this.a;
    }

    public double getPulsation() {
        return this.omega;
    }

    public double getPhase() {
        return this.phi;
    }
}
