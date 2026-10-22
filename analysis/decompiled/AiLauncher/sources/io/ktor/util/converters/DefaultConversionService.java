package io.ktor.util.converters;

import La.K;
import Z8.A;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.util.reflect.TypeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import w9.C5757p;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\u0004\u0018\u00010\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0015\u001a\u0004\u0018\u00010\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/util/converters/DefaultConversionService;", "Lio/ktor/util/converters/ConversionService;", "<init>", "()V", "Lw9/d;", "klass", "", UxipConstants.f30680s, "", "convertPrimitives", "(Lw9/d;Ljava/lang/String;)Ljava/lang/Object;", "typeName", "", "throwConversionException", "(Ljava/lang/String;)Ljava/lang/Void;", "", "toValues", "(Ljava/lang/Object;)Ljava/util/List;", "values", "Lio/ktor/util/reflect/TypeInfo;", "type", "fromValues", "(Ljava/util/List;Lio/ktor/util/reflect/TypeInfo;)Ljava/lang/Object;", "fromValue", "(Ljava/lang/String;Lw9/d;)Ljava/lang/Object;", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultConversionService implements ConversionService {
    public static final DefaultConversionService INSTANCE = new DefaultConversionService();

    private DefaultConversionService() {
    }

    private final Object convertPrimitives(InterfaceC5745d<?> klass, String value) {
        if (p.d(klass, t.b(Integer.TYPE))) {
            return Integer.valueOf(Integer.parseInt(value));
        }
        if (p.d(klass, t.b(Float.TYPE))) {
            return Float.valueOf(Float.parseFloat(value));
        }
        if (p.d(klass, t.b(Double.TYPE))) {
            return Double.valueOf(Double.parseDouble(value));
        }
        if (p.d(klass, t.b(Long.TYPE))) {
            return Long.valueOf(Long.parseLong(value));
        }
        if (p.d(klass, t.b(Short.TYPE))) {
            return Short.valueOf(Short.parseShort(value));
        }
        if (p.d(klass, t.b(Character.TYPE))) {
            return Character.valueOf(K.Q1(value));
        }
        if (p.d(klass, t.b(Boolean.TYPE))) {
            return Boolean.valueOf(Boolean.parseBoolean(value));
        }
        if (p.d(klass, t.b(String.class))) {
            return value;
        }
        return null;
    }

    private final Void throwConversionException(String typeName) throws DataConversionException {
        throw new DataConversionException("Type " + typeName + " is not supported in default data conversion service");
    }

    public final Object fromValue(String value, InterfaceC5745d<?> klass) throws DataConversionException {
        p.i(value, "value");
        p.i(klass, "klass");
        Object objConvertPrimitives = convertPrimitives(klass, value);
        if (objConvertPrimitives != null) {
            return objConvertPrimitives;
        }
        Object objPlatformDefaultFromValues = ConversionServiceJvmKt.platformDefaultFromValues(value, klass);
        if (objPlatformDefaultFromValues != null) {
            return objPlatformDefaultFromValues;
        }
        throwConversionException(klass.toString());
        throw new KotlinNothingValueException();
    }

    @Override // io.ktor.util.converters.ConversionService
    public Object fromValues(List<String> values, TypeInfo type) throws DataConversionException {
        List<C5757p> listG;
        C5757p c5757p;
        InterfaceC5755n interfaceC5755nC;
        p.i(values, "values");
        p.i(type, "type");
        if (values.isEmpty()) {
            return null;
        }
        if (p.d(type.getType(), t.b(List.class)) || p.d(type.getType(), t.b(List.class))) {
            InterfaceC5755n kotlinType = type.getKotlinType();
            Object classifier = (kotlinType == null || (listG = kotlinType.g()) == null || (c5757p = (C5757p) F.X0(listG)) == null || (interfaceC5755nC = c5757p.c()) == null) ? null : interfaceC5755nC.getClassifier();
            InterfaceC5745d<?> interfaceC5745d = classifier instanceof InterfaceC5745d ? (InterfaceC5745d) classifier : null;
            if (interfaceC5745d != null) {
                List<String> list = values;
                ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(INSTANCE.fromValue((String) it.next(), interfaceC5745d));
                }
                return arrayList;
            }
        }
        if (values.isEmpty()) {
            throw new DataConversionException("There are no values when trying to construct single value " + type);
        }
        if (values.size() <= 1) {
            return fromValue((String) F.X0(values), type.getType());
        }
        throw new DataConversionException("There are multiple values when trying to construct single value " + type);
    }

    @Override // io.ktor.util.converters.ConversionService
    public List<String> toValues(Object value) throws DataConversionException {
        if (value == null) {
            return C1173v.m();
        }
        List<String> listPlatformDefaultToValues = ConversionServiceJvmKt.platformDefaultToValues(value);
        if (listPlatformDefaultToValues != null) {
            return listPlatformDefaultToValues;
        }
        if (value instanceof Iterable) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((Iterable) value).iterator();
            while (it.hasNext()) {
                A.E(arrayList, INSTANCE.toValues(it.next()));
            }
            return arrayList;
        }
        InterfaceC5745d interfaceC5745dB = t.b(value.getClass());
        if (p.d(interfaceC5745dB, t.b(Integer.TYPE)) || p.d(interfaceC5745dB, t.b(Float.TYPE)) || p.d(interfaceC5745dB, t.b(Double.TYPE)) || p.d(interfaceC5745dB, t.b(Long.TYPE)) || p.d(interfaceC5745dB, t.b(Short.TYPE)) || p.d(interfaceC5745dB, t.b(Character.TYPE)) || p.d(interfaceC5745dB, t.b(Boolean.TYPE)) || p.d(interfaceC5745dB, t.b(String.class))) {
            return C1172u.e(value.toString());
        }
        throw new DataConversionException("Class " + interfaceC5745dB + " is not supported in default data conversion service");
    }
}
