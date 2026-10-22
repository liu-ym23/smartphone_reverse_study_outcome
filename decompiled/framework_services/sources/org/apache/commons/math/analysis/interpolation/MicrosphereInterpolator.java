package org.apache.commons.math.analysis.interpolation;

import org.apache.commons.math.MathException;
import org.apache.commons.math.analysis.MultivariateRealFunction;
import org.apache.commons.math.exception.NotPositiveException;
import org.apache.commons.math.exception.NotStrictlyPositiveException;
import org.apache.commons.math.random.UnitSphereRandomVectorGenerator;

/* JADX INFO: loaded from: classes3.dex */
public class MicrosphereInterpolator implements MultivariateRealInterpolator {
    public static final int DEFAULT_BRIGHTNESS_EXPONENT = 2;
    public static final int DEFAULT_MICROSPHERE_ELEMENTS = 2000;
    private int brightnessExponent;
    private int microsphereElements;

    public MicrosphereInterpolator() {
        this(2000, 2);
    }

    public MicrosphereInterpolator(int microsphereElements, int brightnessExponent) {
        setMicropshereElements(microsphereElements);
        setBrightnessExponent(brightnessExponent);
    }

    @Override // org.apache.commons.math.analysis.interpolation.MultivariateRealInterpolator
    public MultivariateRealFunction interpolate(double[][] xval, double[] yval) throws MathException, IllegalArgumentException {
        UnitSphereRandomVectorGenerator rand = new UnitSphereRandomVectorGenerator(xval[0].length);
        return new MicrosphereInterpolatingFunction(xval, yval, this.brightnessExponent, this.microsphereElements, rand);
    }

    public void setBrightnessExponent(int exponent) {
        if (exponent < 0) goto L6;
        this.brightnessExponent = exponent;
        return;
    L6:
        throw new NotPositiveException(Integer.valueOf(exponent));
    }

    public void setMicropshereElements(int elements) {
        if (elements <= 0) goto L6;
        this.microsphereElements = elements;
        return;
    L6:
        throw new NotStrictlyPositiveException(Integer.valueOf(elements));
    }
}
