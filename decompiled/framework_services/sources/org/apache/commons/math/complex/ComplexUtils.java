package org.apache.commons.math.complex;

import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class ComplexUtils {
    private ComplexUtils() {
    }

    public static Complex polar2Complex(double r, double theta) {
        if (r < 0.0d) goto L7;
        return new Complex(FastMath.cos(theta) * r, FastMath.sin(theta) * r);
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NEGATIVE_COMPLEX_MODULE, new Object[]{Double.valueOf(r)});
    }
}
