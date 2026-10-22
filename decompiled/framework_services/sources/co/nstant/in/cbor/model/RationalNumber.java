package co.nstant.in.cbor.model;

import co.nstant.in.cbor.CborException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class RationalNumber extends Array {
    public RationalNumber(Number numerator, Number denominator) throws CborException {
        setTag(30);
        if (numerator == null) goto L14;
        if (denominator == null) goto L12;
        if (denominator.getValue().equals(BigInteger.ZERO) == true) goto L10;
        add(numerator);
        add(denominator);
        return;
    L10:
        throw new CborException("Denominator is zero");
    L12:
        throw new CborException("Denominator is null");
    L14:
        throw new CborException("Numerator is null");
    }

    public Number getNumerator() {
        return (Number) getDataItems().get(0);
    }

    public Number getDenominator() {
        return (Number) getDataItems().get(1);
    }
}
