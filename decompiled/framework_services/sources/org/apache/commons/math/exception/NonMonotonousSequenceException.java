package org.apache.commons.math.exception;

import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class NonMonotonousSequenceException extends MathIllegalNumberException {
    private static final long serialVersionUID = 3596849179428944575L;
    private final MathUtils.OrderDirection direction;
    private final int index;
    private final Number previous;
    private final boolean strict;

    public NonMonotonousSequenceException(Number wrong, Number previous, int index) {
        this(wrong, previous, index, MathUtils.OrderDirection.INCREASING, true);
    }

    public NonMonotonousSequenceException(Number wrong, Number previous, int index, MathUtils.OrderDirection direction, boolean strict) {
        if (direction != MathUtils.OrderDirection.INCREASING) goto L7;
        if (strict == false) goto L6;
        LocalizedFormats r0 = LocalizedFormats.NOT_STRICTLY_INCREASING_SEQUENCE;
    L10:
        super(r0, wrong, new Object[]{previous, Integer.valueOf(index), Integer.valueOf(index - 1)});
        this.direction = direction;
        this.strict = strict;
        this.index = index;
        this.previous = previous;
        return;
    L6:
        r0 = LocalizedFormats.NOT_INCREASING_SEQUENCE;
        goto L10
    L7:
        if (strict == false) goto L9;
        r0 = LocalizedFormats.NOT_STRICTLY_DECREASING_SEQUENCE;
        goto L10
    L9:
        r0 = LocalizedFormats.NOT_DECREASING_SEQUENCE;
        goto L10
    }

    public MathUtils.OrderDirection getDirection() {
        return this.direction;
    }

    public boolean getStrict() {
        return this.strict;
    }

    public int getIndex() {
        return this.index;
    }

    public Number getPrevious() {
        return this.previous;
    }
}
