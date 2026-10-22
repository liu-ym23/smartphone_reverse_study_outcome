package ch.qos.logback.core.rolling.helper;

import ch.qos.logback.core.pattern.DynamicConverter;

/* loaded from: classes.dex */
public class IntegerTokenConverter extends DynamicConverter implements MonoTypedConverter {
    public static final String CONVERTER_KEY = "i";

    public String convert(int i4) {
        return Integer.toString(i4);
    }

    @Override // ch.qos.logback.core.rolling.helper.MonoTypedConverter
    public boolean isApplicable(Object obj) {
        return obj instanceof Integer;
    }

    @Override // ch.qos.logback.core.pattern.Converter
    public String convert(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Null argument forbidden");
        }
        if (obj instanceof Integer) {
            return convert(((Integer) obj).intValue());
        }
        throw new IllegalArgumentException("Cannot convert " + obj + " of type" + obj.getClass().getName());
    }
}
