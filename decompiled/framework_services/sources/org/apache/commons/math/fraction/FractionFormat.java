package org.apache.commons.math.fraction;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Locale;
import org.apache.commons.math.ConvergenceException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class FractionFormat extends AbstractFormat {
    private static final long serialVersionUID = 3008655719530972611L;

    @Override // java.text.NumberFormat
    public /* bridge */ /* synthetic */ Number parse(String r1) throws ParseException {
        return parse(r1);
    }

    @Override // java.text.NumberFormat
    public /* bridge */ /* synthetic */ Number parse(String r1, ParsePosition r2) {
        return parse(r1, r2);
    }

    public FractionFormat() {
    }

    public FractionFormat(NumberFormat format) {
        super(format);
    }

    public FractionFormat(NumberFormat numeratorFormat, NumberFormat denominatorFormat) {
        super(numeratorFormat, denominatorFormat);
    }

    public static Locale[] getAvailableLocales() {
        return NumberFormat.getAvailableLocales();
    }

    public static String formatFraction(Fraction f) {
        return getImproperInstance().format(f);
    }

    public static FractionFormat getImproperInstance() {
        return getImproperInstance(Locale.getDefault());
    }

    public static FractionFormat getImproperInstance(Locale locale) {
        return new FractionFormat(AbstractFormat.getDefaultNumberFormat(locale));
    }

    public static FractionFormat getProperInstance() {
        return getProperInstance(Locale.getDefault());
    }

    public static FractionFormat getProperInstance(Locale locale) {
        return new ProperFractionFormat(AbstractFormat.getDefaultNumberFormat(locale));
    }

    protected static NumberFormat getDefaultNumberFormat() {
        return AbstractFormat.getDefaultNumberFormat(Locale.getDefault());
    }

    public StringBuffer format(Fraction fraction, StringBuffer toAppendTo, FieldPosition pos) {
        pos.setBeginIndex(0);
        pos.setEndIndex(0);
        getNumeratorFormat().format(fraction.getNumerator(), toAppendTo, pos);
        toAppendTo.append(" / ");
        getDenominatorFormat().format(fraction.getDenominator(), toAppendTo, pos);
        return toAppendTo;
    }

    @Override // java.text.NumberFormat, java.text.Format
    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        if ((obj instanceof Fraction) == false) goto L6;
        StringBuffer ret = format((Fraction) obj, toAppendTo, pos);
        return ret;
    L6:
        if ((obj instanceof Number) == false) goto L14;
        StringBuffer ret2 = format(new Fraction(((Number) obj).doubleValue()), toAppendTo, pos);     // Catch: ConvergenceException -> L10
        return ret2;
    L10:
        ex = move-exception;
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.CANNOT_CONVERT_OBJECT_TO_FRACTION, new Object[]{ex.getLocalizedMessage()});
    L14:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.CANNOT_FORMAT_OBJECT_TO_FRACTION, new Object[0]);
    }

    @Override // java.text.NumberFormat
    public Fraction parse(String source) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Fraction result = parse(source, parsePosition);
        if (parsePosition.getIndex() == 0) goto L6;
        return result;
    L6:
        throw MathRuntimeException.createParseException(parsePosition.getErrorIndex(), LocalizedFormats.UNPARSEABLE_FRACTION_NUMBER, new Object[]{source});
    }

    @Override // java.text.NumberFormat
    public Fraction parse(String source, ParsePosition pos) {
        int initialIndex = pos.getIndex();
        AbstractFormat.parseAndIgnoreWhitespace(source, pos);
        Number num = getNumeratorFormat().parse(source, pos);
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
        Number den = getDenominatorFormat().parse(source, pos);
        if (den != null) goto L15;
        pos.setIndex(initialIndex);
        return null;
    L15:
        return new Fraction(num.intValue(), den.intValue());
    L17:
        return new Fraction(num.intValue(), 1);
    }
}
