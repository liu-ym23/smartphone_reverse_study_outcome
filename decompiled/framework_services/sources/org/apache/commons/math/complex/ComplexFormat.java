package org.apache.commons.math.complex;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Locale;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.NullArgumentException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.CompositeFormat;

/* JADX INFO: loaded from: classes3.dex */
public class ComplexFormat extends CompositeFormat {
    private static final String DEFAULT_IMAGINARY_CHARACTER = "i";
    private static final long serialVersionUID = -3343698360149467646L;
    private String imaginaryCharacter;
    private NumberFormat imaginaryFormat;
    private NumberFormat realFormat;

    public ComplexFormat() {
        this(DEFAULT_IMAGINARY_CHARACTER, CompositeFormat.getDefaultNumberFormat());
    }

    public ComplexFormat(NumberFormat format) {
        this(DEFAULT_IMAGINARY_CHARACTER, format);
    }

    public ComplexFormat(NumberFormat realFormat, NumberFormat imaginaryFormat) {
        this(DEFAULT_IMAGINARY_CHARACTER, realFormat, imaginaryFormat);
    }

    public ComplexFormat(String imaginaryCharacter) {
        this(imaginaryCharacter, CompositeFormat.getDefaultNumberFormat());
    }

    public ComplexFormat(String imaginaryCharacter, NumberFormat format) {
        this(imaginaryCharacter, format, (NumberFormat) format.clone());
    }

    public ComplexFormat(String imaginaryCharacter, NumberFormat realFormat, NumberFormat imaginaryFormat) {
        setImaginaryCharacter(imaginaryCharacter);
        setImaginaryFormat(imaginaryFormat);
        setRealFormat(realFormat);
    }

    public static Locale[] getAvailableLocales() {
        return NumberFormat.getAvailableLocales();
    }

    public static String formatComplex(Complex c) {
        return getInstance().format(c);
    }

    public StringBuffer format(Complex complex, StringBuffer toAppendTo, FieldPosition pos) {
        pos.setBeginIndex(0);
        pos.setEndIndex(0);
        double re = complex.getReal();
        formatDouble(re, getRealFormat(), toAppendTo, pos);
        double im = complex.getImaginary();
        if (im >= 0.0d) goto L6;
        toAppendTo.append(" - ");
        formatDouble(-im, getImaginaryFormat(), toAppendTo, pos);
        toAppendTo.append(getImaginaryCharacter());
    L12:
        return toAppendTo;
    L6:
        if (im <= 0.0d) goto L8;
    L11:
        toAppendTo.append(" + ");
        formatDouble(im, getImaginaryFormat(), toAppendTo, pos);
        toAppendTo.append(getImaginaryCharacter());
        goto L12
    L8:
        if (Double.isNaN(im) == false) goto L12;
        goto L11
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        if ((obj instanceof Complex) == false) goto L6;
        StringBuffer ret = format((Complex) obj, toAppendTo, pos);
        return ret;
    L6:
        if ((obj instanceof Number) == false) goto L10;
        StringBuffer ret2 = format(new Complex(((Number) obj).doubleValue(), 0.0d), toAppendTo, pos);
        return ret2;
    L10:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.CANNOT_FORMAT_INSTANCE_AS_COMPLEX, new Object[]{obj.getClass().getName()});
    }

    public String getImaginaryCharacter() {
        return this.imaginaryCharacter;
    }

    public NumberFormat getImaginaryFormat() {
        return this.imaginaryFormat;
    }

    public static ComplexFormat getInstance() {
        return getInstance(Locale.getDefault());
    }

    public static ComplexFormat getInstance(Locale locale) {
        NumberFormat f = CompositeFormat.getDefaultNumberFormat(locale);
        return new ComplexFormat(f);
    }

    public NumberFormat getRealFormat() {
        return this.realFormat;
    }

    public Complex parse(String source) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Complex result = parse(source, parsePosition);
        if (parsePosition.getIndex() == 0) goto L6;
        return result;
    L6:
        throw MathRuntimeException.createParseException(parsePosition.getErrorIndex(), LocalizedFormats.UNPARSEABLE_COMPLEX_NUMBER, new Object[]{source});
    }

    public Complex parse(String source, ParsePosition pos) {
        int initialIndex = pos.getIndex();
        parseAndIgnoreWhitespace(source, pos);
        Number re = parseNumber(source, getRealFormat(), pos);
        if (re != null) goto L6;
        pos.setIndex(initialIndex);
        return null;
    L6:
        int startIndex = pos.getIndex();
        char c = parseNextCharacter(source, pos);
        switch(c) {
            case 0: goto L22;
            case 43: goto L11;
            case 45: goto L10;
            default: goto L8;
        };
    L8:
        pos.setIndex(initialIndex);
        pos.setErrorIndex(startIndex);
        return null;
    L10:
        int sign = -1;
    L12:
        parseAndIgnoreWhitespace(source, pos);
        Number im = parseNumber(source, getRealFormat(), pos);
        if (im != null) goto L17;
        pos.setIndex(initialIndex);
        return null;
    L17:
        if (parseFixedstring(source, getImaginaryCharacter(), pos) == true) goto L20;
        return null;
    L20:
        return new Complex(re.doubleValue(), im.doubleValue() * ((double) sign));
    L11:
        sign = 1;
        goto L12
    L22:
        return new Complex(re.doubleValue(), 0.0d);
    }

    @Override // java.text.Format
    public Object parseObject(String source, ParsePosition pos) {
        return parse(source, pos);
    }

    public void setImaginaryCharacter(String imaginaryCharacter) {
        if (imaginaryCharacter == null) goto L8;
        if (imaginaryCharacter.length() == 0) goto L8;
        this.imaginaryCharacter = imaginaryCharacter;
        return;
    L8:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.EMPTY_STRING_FOR_IMAGINARY_CHARACTER, new Object[0]);
    }

    public void setImaginaryFormat(NumberFormat imaginaryFormat) {
        if (imaginaryFormat == null) goto L6;
        this.imaginaryFormat = imaginaryFormat;
        return;
    L6:
        throw new NullArgumentException(LocalizedFormats.IMAGINARY_FORMAT);
    }

    public void setRealFormat(NumberFormat realFormat) {
        if (realFormat == null) goto L6;
        this.realFormat = realFormat;
        return;
    L6:
        throw new NullArgumentException(LocalizedFormats.REAL_FORMAT);
    }
}
