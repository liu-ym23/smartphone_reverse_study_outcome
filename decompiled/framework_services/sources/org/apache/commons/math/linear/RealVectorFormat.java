package org.apache.commons.math.linear;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.CompositeFormat;

/* JADX INFO: loaded from: classes3.dex */
public class RealVectorFormat extends CompositeFormat {
    private static final String DEFAULT_PREFIX = "{";
    private static final String DEFAULT_SEPARATOR = "; ";
    private static final String DEFAULT_SUFFIX = "}";
    private static final long serialVersionUID = -708767813036157690L;
    private final NumberFormat format;
    private final String prefix;
    private final String separator;
    private final String suffix;
    private final String trimmedPrefix;
    private final String trimmedSeparator;
    private final String trimmedSuffix;

    public RealVectorFormat() {
        this(DEFAULT_PREFIX, DEFAULT_SUFFIX, DEFAULT_SEPARATOR, CompositeFormat.getDefaultNumberFormat());
    }

    public RealVectorFormat(NumberFormat format) {
        this(DEFAULT_PREFIX, DEFAULT_SUFFIX, DEFAULT_SEPARATOR, format);
    }

    public RealVectorFormat(String prefix, String suffix, String separator) {
        this(prefix, suffix, separator, CompositeFormat.getDefaultNumberFormat());
    }

    public RealVectorFormat(String prefix, String suffix, String separator, NumberFormat format) {
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

    public static RealVectorFormat getInstance() {
        return getInstance(Locale.getDefault());
    }

    public static RealVectorFormat getInstance(Locale locale) {
        return new RealVectorFormat(CompositeFormat.getDefaultNumberFormat(locale));
    }

    public static String formatRealVector(RealVector v) {
        return getInstance().format(v);
    }

    public StringBuffer format(RealVector vector, StringBuffer toAppendTo, FieldPosition pos) {
        pos.setBeginIndex(0);
        pos.setEndIndex(0);
        toAppendTo.append(this.prefix);
        int i = 0;
    L4:
        if (i >= vector.getDimension()) goto L8;
        if (i <= 0) goto L7;
        toAppendTo.append(this.separator);
    L7:
        formatDouble(vector.getEntry(i), this.format, toAppendTo, pos);
        i = i + 1;
        goto L4
    L8:
        toAppendTo.append(this.suffix);
        return toAppendTo;
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        if ((obj instanceof RealVector) == false) goto L7;
        return format((RealVector) obj, toAppendTo, pos);
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.CANNOT_FORMAT_INSTANCE_AS_REAL_VECTOR, new Object[]{obj.getClass().getName()});
    }

    public ArrayRealVector parse(String source) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        ArrayRealVector result = parse(source, parsePosition);
        if (parsePosition.getIndex() == 0) goto L6;
        return result;
    L6:
        throw MathRuntimeException.createParseException(parsePosition.getErrorIndex(), LocalizedFormats.UNPARSEABLE_REAL_VECTOR, new Object[]{source});
    }

    public ArrayRealVector parse(String source, ParsePosition pos) {
        int initialIndex = pos.getIndex();
        parseAndIgnoreWhitespace(source, pos);
        if (parseFixedstring(source, this.trimmedPrefix, pos) == true) goto L5;
        return null;
    L5:
        List<Number> components = new ArrayList();
        boolean loop = true;
    L6:
        if (loop == false) goto L18;
        if (components.isEmpty() == true) goto L12;
        parseAndIgnoreWhitespace(source, pos);
        if (parseFixedstring(source, this.trimmedSeparator, pos) == true) goto L12;
        loop = false;
    L12:
        if (loop == false) goto L6;
        parseAndIgnoreWhitespace(source, pos);
        Number component = parseNumber(source, this.format, pos);
        if (component == null) goto L16;
        components.add(component);
        goto L6
    L16:
        pos.setIndex(initialIndex);
        return null;
    L18:
        parseAndIgnoreWhitespace(source, pos);
        if (parseFixedstring(source, this.trimmedSuffix, pos) == true) goto L21;
        return null;
    L21:
        double[] data = new double[components.size()];
        int i = 0;
    L23:
        if (i >= data.length) goto L26;
        data[i] = components.get(i).doubleValue();
        i = i + 1;
        goto L23
    L26:
        return new ArrayRealVector(data, false);
    }

    @Override // java.text.Format
    public Object parseObject(String source, ParsePosition pos) {
        return parse(source, pos);
    }
}
