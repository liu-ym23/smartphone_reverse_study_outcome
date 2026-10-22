package org.apache.commons.math.util;

import java.io.Serializable;
import org.apache.commons.math.MathException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultTransformer implements NumberTransformer, Serializable {
    private static final long serialVersionUID = 4019938025047800455L;

    public DefaultTransformer() {
    }

    @Override // org.apache.commons.math.util.NumberTransformer
    public double transform(Object o) throws MathException {
        if (o == null) goto L13;
        if ((o instanceof Number) == true) goto L6;
        return Double.valueOf(o.toString()).doubleValue();
    L9:
        e = move-exception;
        throw new MathException(e, LocalizedFormats.CANNOT_TRANSFORM_TO_DOUBLE, new Object[]{e.getMessage()});
    L6:
        return ((Number) o).doubleValue();
    L13:
        throw new MathException(LocalizedFormats.OBJECT_TRANSFORMATION, new Object[0]);
    }

    public boolean equals(Object other) {
        if (this != other) goto L5;
        return true;
    L5:
        if (other != null) goto L9;
        return false;
    L9:
        return other instanceof DefaultTransformer;
    }

    public int hashCode() {
        return 401993047;
    }
}
