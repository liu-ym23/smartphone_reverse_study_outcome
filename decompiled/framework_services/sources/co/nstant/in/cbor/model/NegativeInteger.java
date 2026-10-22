package co.nstant.in.cbor.model;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class NegativeInteger extends Number {
    public NegativeInteger(long value) {
        this(BigInteger.valueOf(value));
        if (value >= 0) goto L5;
        boolean r0 = true;
    L6:
        assertTrue(r0, "value " + value + " is not < 0");
        return;
    L5:
        r0 = false;
        goto L6
    }

    public NegativeInteger(BigInteger value) {
        super(MajorType.NEGATIVE_INTEGER, value);
    }
}
