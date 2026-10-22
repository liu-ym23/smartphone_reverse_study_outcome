package org.apache.commons.math.util;

import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CompositeFormat extends Format {
    private static final long serialVersionUID = 5358685519349262494L;

    public CompositeFormat() {
    }

    protected static NumberFormat getDefaultNumberFormat() {
        return getDefaultNumberFormat(Locale.getDefault());
    }

    protected static NumberFormat getDefaultNumberFormat(Locale locale) {
        NumberFormat nf = NumberFormat.getInstance(locale);
        nf.setMaximumFractionDigits(2);
        return nf;
    }

    protected void parseAndIgnoreWhitespace(String source, ParsePosition pos) {
        parseNextCharacter(source, pos);
        pos.setIndex(pos.getIndex() - 1);
    }

    protected char parseNextCharacter(String source, ParsePosition pos) {
        int index = pos.getIndex();
        int n = source.length();
        if (index >= n) goto L16;
    L4:
        int index2 = index + 1;
        char c = source.charAt(index);
        if (Character.isWhitespace(c) == false) goto L9;
        if (index2 >= n) goto L9;
        index = index2;
    L9:
        pos.setIndex(index2);
        if (index2 >= n) goto L13;
        return c;
    L13:
        return 0;
    L16:
        return 0;
    }

    private Number parseNumber(String source, double value, ParsePosition pos) {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(value);
        sb.append(')');
        int n = sb.length();
        int startIndex = pos.getIndex();
        int endIndex = startIndex + n;
        if (endIndex < source.length()) goto L5;
        return null;
    L5:
        if (source.substring(startIndex, endIndex).compareTo(sb.toString()) != 0) goto L9;
        Number ret = Double.valueOf(value);
        pos.setIndex(endIndex);
        return ret;
    L9:
        return null;
    }

    protected Number parseNumber(String source, NumberFormat format, ParsePosition pos) {
        int startIndex = pos.getIndex();
        Number number = format.parse(source, pos);
        int endIndex = pos.getIndex();
        if (startIndex != endIndex) goto L11;
        double[] special = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
        int i = 0;
    L6:
        if (i >= special.length) goto L11;
        number = parseNumber(source, special[i], pos);
        if (number != null) goto L11;
        i = i + 1;
    L11:
        return number;
    }

    protected boolean parseFixedstring(String source, String expected, ParsePosition pos) {
        int startIndex = pos.getIndex();
        int endIndex = expected.length() + startIndex;
        if (startIndex < source.length()) goto L5;
    L11:
        pos.setIndex(startIndex);
        pos.setErrorIndex(startIndex);
        return false;
    L5:
        if (endIndex > source.length()) goto L11;
        if (source.substring(startIndex, endIndex).compareTo(expected) != 0) goto L11;
        pos.setIndex(endIndex);
        return true;
    }

    protected StringBuffer formatDouble(double value, NumberFormat format, StringBuffer toAppendTo, FieldPosition pos) {
        if (Double.isNaN(value) == false) goto L5;
    L8:
        toAppendTo.append('(');
        toAppendTo.append(value);
        toAppendTo.append(')');
    L9:
        return toAppendTo;
    L5:
        if (Double.isInfinite(value) == true) goto L8;
        format.format(value, toAppendTo, pos);
        goto L9
    }
}
