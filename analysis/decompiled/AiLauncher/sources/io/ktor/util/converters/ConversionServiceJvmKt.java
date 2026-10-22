package io.ktor.util.converters;

import Z8.C1172u;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import o9.C5013a;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u001a%\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006\u001a\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\b2\u0006\u0010\u0001\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", UxipConstants.f30680s, "Lw9/d;", "klass", "", "platformDefaultFromValues", "(Ljava/lang/String;Lw9/d;)Ljava/lang/Object;", "convertSimpleTypes", "", "platformDefaultToValues", "(Ljava/lang/Object;)Ljava/util/List;", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConversionServiceJvmKt {
    private static final Object convertSimpleTypes(String str, InterfaceC5745d<?> interfaceC5745d) {
        if (p.d(interfaceC5745d, t.b(Integer.class))) {
            return Integer.valueOf(Integer.parseInt(str));
        }
        if (p.d(interfaceC5745d, t.b(Float.class))) {
            return Float.valueOf(Float.parseFloat(str));
        }
        if (p.d(interfaceC5745d, t.b(Double.class))) {
            return Double.valueOf(Double.parseDouble(str));
        }
        if (p.d(interfaceC5745d, t.b(Long.class))) {
            return Long.valueOf(Long.parseLong(str));
        }
        if (p.d(interfaceC5745d, t.b(Short.class))) {
            return Short.valueOf(Short.parseShort(str));
        }
        if (p.d(interfaceC5745d, t.b(Boolean.class))) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
        if (p.d(interfaceC5745d, t.b(String.class))) {
            return str;
        }
        if (p.d(interfaceC5745d, t.b(Character.class))) {
            return Character.valueOf(str.charAt(0));
        }
        if (p.d(interfaceC5745d, t.b(BigDecimal.class))) {
            return new BigDecimal(str);
        }
        if (p.d(interfaceC5745d, t.b(BigInteger.class))) {
            return new BigInteger(str);
        }
        if (p.d(interfaceC5745d, t.b(UUID.class))) {
            return UUID.fromString(str);
        }
        return null;
    }

    public static final Object platformDefaultFromValues(String value, InterfaceC5745d<?> klass) throws DataConversionException {
        p.i(value, "value");
        p.i(klass, "klass");
        Object objConvertSimpleTypes = convertSimpleTypes(value, klass);
        if (objConvertSimpleTypes != null) {
            return objConvertSimpleTypes;
        }
        Object obj = null;
        if (!C5013a.b(klass).isEnum()) {
            return null;
        }
        Object[] enumConstants = C5013a.b(klass).getEnumConstants();
        if (enumConstants != null) {
            int length = enumConstants.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                Object obj2 = enumConstants[i10];
                p.g(obj2, "null cannot be cast to non-null type kotlin.Enum<*>");
                if (p.d(((Enum) obj2).name(), value)) {
                    obj = obj2;
                    break;
                }
                i10++;
            }
            if (obj != null) {
                return obj;
            }
        }
        throw new DataConversionException("Value " + value + " is not a enum member name of " + klass);
    }

    public static final List<String> platformDefaultToValues(Object value) {
        p.i(value, "value");
        if (value instanceof Enum) {
            return C1172u.e(((Enum) value).name());
        }
        if (value instanceof Integer) {
            return C1172u.e(((Integer) value).toString());
        }
        if (value instanceof Float) {
            return C1172u.e(((Float) value).toString());
        }
        if (value instanceof Double) {
            return C1172u.e(((Double) value).toString());
        }
        if (value instanceof Long) {
            return C1172u.e(((Long) value).toString());
        }
        if (value instanceof Boolean) {
            return C1172u.e(((Boolean) value).toString());
        }
        if (value instanceof Short) {
            return C1172u.e(((Short) value).toString());
        }
        if (value instanceof String) {
            return C1172u.e(((String) value).toString());
        }
        if (value instanceof Character) {
            return C1172u.e(((Character) value).toString());
        }
        if (value instanceof BigDecimal) {
            return C1172u.e(((BigDecimal) value).toString());
        }
        if (value instanceof BigInteger) {
            return C1172u.e(((BigInteger) value).toString());
        }
        if (value instanceof UUID) {
            return C1172u.e(((UUID) value).toString());
        }
        return null;
    }
}
