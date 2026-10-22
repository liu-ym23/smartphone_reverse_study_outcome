package org.apache.commons.math.exception;

import org.apache.commons.math.exception.util.Localizable;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class NumberIsTooLargeException extends MathIllegalNumberException {
    private static final long serialVersionUID = 4330003017885151975L;
    private final boolean boundIsAllowed;
    private final Number max;

    public NumberIsTooLargeException(Number wrong, Number max, boolean boundIsAllowed) {
        this(null, wrong, max, boundIsAllowed);
    }

    public NumberIsTooLargeException(Localizable specific, Number wrong, Number max, boolean boundIsAllowed) {
        if (boundIsAllowed == false) goto L4;
        LocalizedFormats r0 = LocalizedFormats.NUMBER_TOO_LARGE;
    L5:
        super(specific, r0, wrong, new Object[]{max});
        this.max = max;
        this.boundIsAllowed = boundIsAllowed;
        return;
    L4:
        r0 = LocalizedFormats.NUMBER_TOO_LARGE_BOUND_EXCLUDED;
        goto L5
    }

    public boolean getBoundIsAllowed() {
        return this.boundIsAllowed;
    }

    public Number getMax() {
        return this.max;
    }
}
