package org.apache.commons.math.exception;

import org.apache.commons.math.exception.util.Localizable;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class NumberIsTooSmallException extends MathIllegalNumberException {
    private static final long serialVersionUID = -6100997100383932834L;
    private final boolean boundIsAllowed;
    private final Number min;

    public NumberIsTooSmallException(Number wrong, Number min, boolean boundIsAllowed) {
        this(null, wrong, min, boundIsAllowed);
    }

    public NumberIsTooSmallException(Localizable specific, Number wrong, Number min, boolean boundIsAllowed) {
        if (boundIsAllowed == false) goto L4;
        LocalizedFormats r0 = LocalizedFormats.NUMBER_TOO_SMALL;
    L5:
        super(specific, r0, wrong, new Object[]{min});
        this.min = min;
        this.boundIsAllowed = boundIsAllowed;
        return;
    L4:
        r0 = LocalizedFormats.NUMBER_TOO_SMALL_BOUND_EXCLUDED;
        goto L5
    }

    public boolean getBoundIsAllowed() {
        return this.boundIsAllowed;
    }

    public Number getMin() {
        return this.min;
    }
}
