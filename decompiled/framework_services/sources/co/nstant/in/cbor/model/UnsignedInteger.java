package co.nstant.in.cbor.model;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class UnsignedInteger extends Number {
    public UnsignedInteger(long value) {
        this(BigInteger.valueOf(value));
        if (value < 0) goto L5;
        boolean r0 = true;
    L6:
        assertTrue(r0, "value " + value + " is not >= 0");
        return;
    L5:
        r0 = false;
        goto L6
    }

    public UnsignedInteger(BigInteger value) {
        super(MajorType.UNSIGNED_INTEGER, value);
    }
}
