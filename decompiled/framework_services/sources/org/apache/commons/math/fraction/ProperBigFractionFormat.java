package org.apache.commons.math.fraction;

import java.math.BigInteger;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import org.apache.commons.math.exception.NullArgumentException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class ProperBigFractionFormat extends BigFractionFormat {
    private static final long serialVersionUID = -6337346779577272307L;
    private NumberFormat wholeFormat;

    @Override // org.apache.commons.math.fraction.BigFractionFormat, java.text.NumberFormat
    public /* bridge */ /* synthetic */ Number parse(String r1, ParsePosition r2) {
        return parse(r1, r2);
    }

    public ProperBigFractionFormat() {
        this(AbstractFormat.getDefaultNumberFormat());
    }

    public ProperBigFractionFormat(NumberFormat format) {
        this(format, (NumberFormat) format.clone(), (NumberFormat) format.clone());
    }

    public ProperBigFractionFormat(NumberFormat wholeFormat, NumberFormat numeratorFormat, NumberFormat denominatorFormat) {
        super(numeratorFormat, denominatorFormat);
        setWholeFormat(wholeFormat);
    }

    @Override // org.apache.commons.math.fraction.BigFractionFormat
    public StringBuffer format(BigFraction fraction, StringBuffer toAppendTo, FieldPosition pos) {
        pos.setBeginIndex(0);
        pos.setEndIndex(0);
        BigInteger num = fraction.getNumerator();
        BigInteger den = fraction.getDenominator();
        BigInteger whole = num.divide(den);
        BigInteger num2 = num.remainder(den);
        if (BigInteger.ZERO.equals(whole) == true) goto L7;
        getWholeFormat().format(whole, toAppendTo, pos);
        toAppendTo.append(' ');
        if (num2.compareTo(BigInteger.ZERO) >= 0) goto L7;
        num2 = num2.negate();
    L7:
        getNumeratorFormat().format(num2, toAppendTo, pos);
        toAppendTo.append(" / ");
        getDenominatorFormat().format(den, toAppendTo, pos);
        return toAppendTo;
    }

    public NumberFormat getWholeFormat() {
        return this.wholeFormat;
    }

    @Override // org.apache.commons.math.fraction.BigFractionFormat, java.text.NumberFormat
    public BigFraction parse(String source, ParsePosition pos) {
        BigFraction ret = super.parse(source, pos);
        if (ret == null) goto L5;
        return ret;
    L5:
        int initialIndex = pos.getIndex();
        AbstractFormat.parseAndIgnoreWhitespace(source, pos);
        BigInteger whole = parseNextBigInteger(source, pos);
        if (whole != null) goto L9;
        pos.setIndex(initialIndex);
        return null;
    L9:
        AbstractFormat.parseAndIgnoreWhitespace(source, pos);
        BigInteger num = parseNextBigInteger(source, pos);
        if (num != null) goto L14;
        pos.setIndex(initialIndex);
        return null;
    L14:
        if (num.compareTo(BigInteger.ZERO) >= 0) goto L17;
        pos.setIndex(initialIndex);
        return null;
    L17:
        int startIndex = pos.getIndex();
        char c = AbstractFormat.parseNextCharacter(source, pos);
        switch(c) {
            case 0: goto L41;
            case 47: goto L21;
            default: goto L19;
        };
    L19:
        pos.setIndex(initialIndex);
        pos.setErrorIndex(startIndex);
        return null;
    L21:
        AbstractFormat.parseAndIgnoreWhitespace(source, pos);
        BigInteger den = parseNextBigInteger(source, pos);
        if (den != null) goto L26;
        pos.setIndex(initialIndex);
        return null;
    L26:
        if (den.compareTo(BigInteger.ZERO) >= 0) goto L30;
        pos.setIndex(initialIndex);
        return null;
    L30:
        if (whole.compareTo(BigInteger.ZERO) >= 0) goto L32;
        boolean wholeIsNeg = true;
    L33:
        if (wholeIsNeg == false) goto L35;
        whole = whole.negate();
    L35:
        BigInteger num2 = whole.multiply(den).add(num);
        if (wholeIsNeg == false) goto L39;
        num2 = num2.negate();
    L39:
        return new BigFraction(num2, den);
    L32:
        wholeIsNeg = false;
        goto L33
    L41:
        return new BigFraction(num);
    }

    public void setWholeFormat(NumberFormat format) {
        if (format == null) goto L6;
        this.wholeFormat = format;
        return;
    L6:
        throw new NullArgumentException(LocalizedFormats.WHOLE_FORMAT);
    }
}
