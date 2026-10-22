package org.apache.commons.math.geometry;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Locale;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.CompositeFormat;

/* JADX INFO: loaded from: classes3.dex */
public class Vector3DFormat extends CompositeFormat {
    private static final String DEFAULT_PREFIX = "{";
    private static final String DEFAULT_SEPARATOR = "; ";
    private static final String DEFAULT_SUFFIX = "}";
    private static final long serialVersionUID = -5447606608652576301L;
    private final NumberFormat format;
    private final String prefix;
    private final String separator;
    private final String suffix;
    private final String trimmedPrefix;
    private final String trimmedSeparator;
    private final String trimmedSuffix;

    public Vector3DFormat() {
        this(DEFAULT_PREFIX, DEFAULT_SUFFIX, DEFAULT_SEPARATOR, CompositeFormat.getDefaultNumberFormat());
    }

    public Vector3DFormat(NumberFormat format) {
        this(DEFAULT_PREFIX, DEFAULT_SUFFIX, DEFAULT_SEPARATOR, format);
    }

    public Vector3DFormat(String prefix, String suffix, String separator) {
        this(prefix, suffix, separator, CompositeFormat.getDefaultNumberFormat());
    }

    public Vector3DFormat(String prefix, String suffix, String separator, NumberFormat format) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.separator = separator;
        this.trimmedPrefix = prefix.trim();
        this.trimmedSuffix = suffix.trim();
        this.trimmedSeparator = separator.trim();
        this.format = format;
    }

    public static Locale[] getAvailableLocales() {
        return NumberFormat.getAvailableLocales();
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public String getSeparator() {
        return this.separator;
    }

    public NumberFormat getFormat() {
        return this.format;
    }

    public static Vector3DFormat getInstance() {
        return getInstance(Locale.getDefault());
    }

    public static Vector3DFormat getInstance(Locale locale) {
        return new Vector3DFormat(CompositeFormat.getDefaultNumberFormat(locale));
    }

    public static String formatVector3D(Vector3D v) {
        return getInstance().format(v);
    }

    public StringBuffer format(Vector3D vector, StringBuffer toAppendTo, FieldPosition pos) {
        pos.setBeginIndex(0);
        pos.setEndIndex(0);
        toAppendTo.append(this.prefix);
        formatDouble(vector.getX(), this.format, toAppendTo, pos);
        toAppendTo.append(this.separator);
        formatDouble(vector.getY(), this.format, toAppendTo, pos);
        toAppendTo.append(this.separator);
        formatDouble(vector.getZ(), this.format, toAppendTo, pos);
        toAppendTo.append(this.suffix);
        return toAppendTo;
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        if ((obj instanceof Vector3D) == false) goto L7;
        return format((Vector3D) obj, toAppendTo, pos);
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.CANNOT_FORMAT_INSTANCE_AS_3D_VECTOR, new Object[]{obj.getClass().getName()});
    }

    public Vector3D parse(String source) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Vector3D result = parse(source, parsePosition);
        if (parsePosition.getIndex() == 0) goto L6;
        return result;
    L6:
        throw MathRuntimeException.createParseException(parsePosition.getErrorIndex(), LocalizedFormats.UNPARSEABLE_3D_VECTOR, new Object[]{source});
    }

    public Vector3D parse(String source, ParsePosition pos) {
        int initialIndex = pos.getIndex();
        parseAndIgnoreWhitespace(source, pos);
        if (parseFixedstring(source, this.trimmedPrefix, pos) == true) goto L5;
        return null;
    L5:
        parseAndIgnoreWhitespace(source, pos);
        Number x = parseNumber(source, this.format, pos);
        if (x != null) goto L9;
        pos.setIndex(initialIndex);
        return null;
    L9:
        parseAndIgnoreWhitespace(source, pos);
        if (parseFixedstring(source, this.trimmedSeparator, pos) == true) goto L12;
        return null;
    L12:
        parseAndIgnoreWhitespace(source, pos);
        Number y = parseNumber(source, this.format, pos);
        if (y != null) goto L16;
        pos.setIndex(initialIndex);
        return null;
    L16:
        parseAndIgnoreWhitespace(source, pos);
        if (parseFixedstring(source, this.trimmedSeparator, pos) == true) goto L19;
        return null;
    L19:
        parseAndIgnoreWhitespace(source, pos);
        Number z = parseNumber(source, this.format, pos);
        if (z != null) goto L23;
        pos.setIndex(initialIndex);
        return null;
    L23:
        parseAndIgnoreWhitespace(source, pos);
        if (parseFixedstring(source, this.trimmedSuffix, pos) == true) goto L27;
        return null;
    L27:
        return new Vector3D(x.doubleValue(), y.doubleValue(), z.doubleValue());
    }

    @Override // java.text.Format
    public Object parseObject(String source, ParsePosition pos) {
        return parse(source, pos);
    }
}
