package org.apache.commons.math.fraction;

import java.io.Serializable;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.apache.commons.math.exception.NullArgumentException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractFormat extends NumberFormat implements Serializable {
    private static final long serialVersionUID = -6981118387974191891L;
    protected NumberFormat denominatorFormat;
    protected NumberFormat numeratorFormat;

    protected AbstractFormat() {
        this(getDefaultNumberFormat());
    }

    protected AbstractFormat(NumberFormat format) {
        this(format, (NumberFormat) format.clone());
    }

    protected AbstractFormat(NumberFormat numeratorFormat, NumberFormat denominatorFormat) {
        this.numeratorFormat = numeratorFormat;
        this.denominatorFormat = denominatorFormat;
    }

    protected static NumberFormat getDefaultNumberFormat() {
        return getDefaultNumberFormat(Locale.getDefault());
    }

    protected static NumberFormat getDefaultNumberFormat(Locale locale) {
        NumberFormat nf = NumberFormat.getNumberInstance(locale);
        nf.setMaximumFractionDigits(0);
        nf.setParseIntegerOnly(true);
        return nf;
    }

    public NumberFormat getDenominatorFormat() {
        return this.denominatorFormat;
    }

    public NumberFormat getNumeratorFormat() {
        return this.numeratorFormat;
    }

    public void setDenominatorFormat(NumberFormat format) {
        if (format == null) goto L6;
        this.denominatorFormat = format;
        return;
    L6:
        throw new NullArgumentException(LocalizedFormats.DENOMINATOR_FORMAT);
    }

    public void setNumeratorFormat(NumberFormat format) {
        if (format == null) goto L6;
        this.numeratorFormat = format;
        return;
    L6:
        throw new NullArgumentException(LocalizedFormats.NUMERATOR_FORMAT);
    }

    protected static void parseAndIgnoreWhitespace(String source, ParsePosition pos) {
        parseNextCharacter(source, pos);
        pos.setIndex(pos.getIndex() - 1);
    }

    protected static char parseNextCharacter(String source, ParsePosition pos) {
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

    @Override // java.text.NumberFormat
    public StringBuffer format(double value, StringBuffer buffer, FieldPosition position) {
        return format(Double.valueOf(value), buffer, position);
    }

    @Override // java.text.NumberFormat
    public StringBuffer format(long value, StringBuffer buffer, FieldPosition position) {
        return format(Long.valueOf(value), buffer, position);
    }
}
