package org.apache.commons.math.exception;

import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class OutOfRangeException extends MathIllegalNumberException {
    private static final long serialVersionUID = 111601815794403609L;
    private final Number hi;
    private final Number lo;

    public OutOfRangeException(Number wrong, Number lo, Number hi) {
        super(LocalizedFormats.OUT_OF_RANGE_SIMPLE, wrong, new Object[]{lo, hi});
        this.lo = lo;
        this.hi = hi;
    }

    public Number getLo() {
        return this.lo;
    }

    public Number getHi() {
        return this.hi;
    }
}
