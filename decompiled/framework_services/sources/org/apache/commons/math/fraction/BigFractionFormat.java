package org.apache.commons.math.fraction;

import java.io.Serializable;
import java.math.BigInteger;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Locale;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class BigFractionFormat extends AbstractFormat implements Serializable {
    private static final long serialVersionUID = -2932167925527338976L;

    @Override // java.text.NumberFormat
    public /* bridge */ /* synthetic */ Number parse(String r1) throws ParseException {
        return parse(r1);
    }

    @Override // java.text.NumberFormat
    public /* bridge */ /* synthetic */ Number parse(String r1, ParsePosition r2) {
        return parse(r1, r2);
    }

    public BigFractionFormat() {
    }

    public BigFractionFormat(NumberFormat format) {
        super(format);
    }

    public BigFractionFormat(NumberFormat numeratorFormat, NumberFormat denominatorFormat) {
        super(numeratorFormat, denominatorFormat);
    }

    public static Locale[] getAvailableLocales() {
        return NumberFormat.getAvailableLocales();
    }

    public static String formatBigFraction(BigFraction f) {
        return getImproperInstance().format(f);
    }

    public static BigFractionFormat getImproperInstance() {
        return getImproperInstance(Locale.getDefault());
    }

    public static BigFractionFormat getImproperInstance(Locale locale) {
        return new BigFractionFormat(AbstractFormat.getDefaultNumberFormat(locale));
    }

    public static BigFractionFormat getProperInstance() {
        return getProperInstance(Locale.getDefault());
    }

    public static BigFractionFormat getProperInstance(Locale locale) {
        return new ProperBigFractionFormat(AbstractFormat.getDefaultNumberFormat(locale));
    }

    public StringBuffer format(BigFraction BigFraction, StringBuffer toAppendTo, FieldPosition pos) {
        pos.setBeginIndex(0);
        pos.setEndIndex(0);
        getNumeratorFormat().format(BigFraction.getNumerator(), toAppendTo, pos);
        toAppendTo.append(" / ");
        getDenominatorFormat().format(BigFraction.getDenominator(), toAppendTo, pos);
        return toAppendTo;
    }

    @Override // java.text.NumberFormat, java.text.Format
    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        if ((obj instanceof BigFraction) == false) goto L6;
        StringBuffer ret = format((BigFraction) obj, toAppendTo, pos);
        return ret;
    L6:
        if ((obj instanceof BigInteger) == false) goto L9;
        StringBuffer ret2 = format(new BigFraction((BigInteger) obj), toAppendTo, pos);
        return ret2;
    L9:
        if ((obj instanceof Number) == false) goto L13;
        StringBuffer ret3 = format(new BigFraction(((Number) obj).doubleValue()), toAppendTo, pos);
        return ret3;
    L13:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.CANNOT_FORMAT_OBJECT_TO_FRACTION, new Object[0]);
    }

    @Override // java.text.NumberFormat
    public BigFraction parse(String source) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        BigFraction result = parse(source, parsePosition);
        if (parsePosition.getIndex() == 0) goto L6;
        return result;
    L6:
        throw MathRuntimeException.createParseException(parsePosition.getErrorIndex(), LocalizedFormats.UNPARSEABLE_FRACTION_NUMBER, new Object[]{source});
    }

    @Override // java.text.NumberFormat
    public BigFraction parse(String source, ParsePosition pos) {
        int initialIndex = pos.getIndex();
        AbstractFormat.parseAndIgnoreWhitespace(source, pos);
        BigInteger num = parseNextBigInteger(source, pos);
        if (num != null) goto L6;
        pos.setIndex(initialIndex);
        return null;
    L6:
        int startIndex = pos.getIndex();
        char c = AbstractFormat.parseNextCharacter(source, pos);
        switch(c) {
            case 0: goto L17;
            case 47: goto L10;
            default: goto L8;
        };
    L8:
        pos.setIndex(initialIndex);
        pos.setErrorIndex(startIndex);
        return null;
    L10:
        AbstractFormat.parseAndIgnoreWhitespace(source, pos);
        BigInteger den = parseNextBigInteger(source, pos);
        if (den != null) goto L15;
        pos.setIndex(initialIndex);
        return null;
    L15:
        return new BigFraction(num, den);
    L17:
        return new BigFraction(num);
    }

    protected BigInteger parseNextBigInteger(String source, ParsePosition pos) {
        int start = pos.getIndex();
        if (source.charAt(start) != '-') goto L5;
        int end = start + 1;
    L7:
        if (end < source.length()) goto L9;
    L16:
        BigInteger n = new BigInteger(source.substring(start, end));     // Catch: NumberFormatException -> L13
        pos.setIndex(end);     // Catch: NumberFormatException -> L13
        return n;
    L14:
        pos.setErrorIndex(start);
        return null;
    L9:
        if (Character.isDigit(source.charAt(end)) == false) goto L16;
        end = end + 1;
        goto L7
    L5:
        end = start;
        goto L7
    }
}
