package org.apache.commons.math.fraction;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import org.apache.commons.math.exception.NullArgumentException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class ProperFractionFormat extends FractionFormat {
    private static final long serialVersionUID = 760934726031766749L;
    private NumberFormat wholeFormat;

    @Override // org.apache.commons.math.fraction.FractionFormat, java.text.NumberFormat
    public /* bridge */ /* synthetic */ Number parse(String r1, ParsePosition r2) {
        return parse(r1, r2);
    }

    public ProperFractionFormat() {
        this(FractionFormat.getDefaultNumberFormat());
    }

    public ProperFractionFormat(NumberFormat format) {
        this(format, (NumberFormat) format.clone(), (NumberFormat) format.clone());
    }

    public ProperFractionFormat(NumberFormat wholeFormat, NumberFormat numeratorFormat, NumberFormat denominatorFormat) {
        super(numeratorFormat, denominatorFormat);
        setWholeFormat(wholeFormat);
    }

    @Override // org.apache.commons.math.fraction.FractionFormat
    public StringBuffer format(Fraction fraction, StringBuffer toAppendTo, FieldPosition pos) {
        pos.setBeginIndex(0);
        pos.setEndIndex(0);
        int num = fraction.getNumerator();
        int den = fraction.getDenominator();
        int whole = num / den;
        int num2 = num % den;
        if (whole == 0) goto L5;
        getWholeFormat().format(whole, toAppendTo, pos);
        toAppendTo.append(' ');
        num2 = Math.abs(num2);
    L5:
        getNumeratorFormat().format(num2, toAppendTo, pos);
        toAppendTo.append(" / ");
        getDenominatorFormat().format(den, toAppendTo, pos);
        return toAppendTo;
    }

    public NumberFormat getWholeFormat() {
        return this.wholeFormat;
    }

    @Override // org.apache.commons.math.fraction.FractionFormat, java.text.NumberFormat
    public Fraction parse(String source, ParsePosition pos) {
        Fraction ret = super.parse(source, pos);
        if (ret == null) goto L5;
        return ret;
    L5:
        int initialIndex = pos.getIndex();
        AbstractFormat.parseAndIgnoreWhitespace(source, pos);
        Number whole = getWholeFormat().parse(source, pos);
        if (whole != null) goto L9;
        pos.setIndex(initialIndex);
        return null;
    L9:
        AbstractFormat.parseAndIgnoreWhitespace(source, pos);
        Number num = getNumeratorFormat().parse(source, pos);
        if (num != null) goto L14;
        pos.setIndex(initialIndex);
        return null;
    L14:
        if (num.intValue() >= 0) goto L17;
        pos.setIndex(initialIndex);
        return null;
    L17:
        int startIndex = pos.getIndex();
        char c = AbstractFormat.parseNextCharacter(source, pos);
        switch(c) {
            case 0: goto L32;
            case 47: goto L21;
            default: goto L19;
        };
    L19:
        pos.setIndex(initialIndex);
        pos.setErrorIndex(startIndex);
        return null;
    L21:
        AbstractFormat.parseAndIgnoreWhitespace(source, pos);
        Number den = getDenominatorFormat().parse(source, pos);
        if (den != null) goto L26;
        pos.setIndex(initialIndex);
        return null;
    L26:
        if (den.intValue() >= 0) goto L29;
        pos.setIndex(initialIndex);
        return null;
    L29:
        int w = whole.intValue();
        int n = num.intValue();
        int d = den.intValue();
        return new Fraction(((Math.abs(w) * d) + n) * MathUtils.sign(w), d);
    L32:
        return new Fraction(num.intValue(), 1);
    }

    public void setWholeFormat(NumberFormat format) {
        if (format == null) goto L6;
        this.wholeFormat = format;
        return;
    L6:
        throw new NullArgumentException(LocalizedFormats.WHOLE_FORMAT);
    }
}
