package k3;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class b {
    public static Object a(JsonParser jsonParser, JavaType javaType) {
        Class<?> cls = javaType.f3690a;
        JsonToken jsonTokenK = jsonParser.K();
        if (jsonTokenK == null) {
            return null;
        }
        switch (jsonTokenK.ordinal()) {
            case 7:
                if (cls.isAssignableFrom(String.class)) {
                    return jsonParser.V0();
                }
                return null;
            case 8:
                if (cls.isAssignableFrom(Integer.class)) {
                    return Integer.valueOf(jsonParser.M0());
                }
                return null;
            case 9:
                if (cls.isAssignableFrom(Double.class)) {
                    return Double.valueOf(jsonParser.J0());
                }
                return null;
            case 10:
                if (cls.isAssignableFrom(Boolean.class)) {
                    return Boolean.TRUE;
                }
                return null;
            case 11:
                if (cls.isAssignableFrom(Boolean.class)) {
                    return Boolean.FALSE;
                }
                return null;
            default:
                return null;
        }
    }

    public abstract Object b(JsonParser jsonParser, DeserializationContext deserializationContext);

    public abstract Object c(JsonParser jsonParser, DeserializationContext deserializationContext);

    public abstract Object d(JsonParser jsonParser, DeserializationContext deserializationContext);

    public abstract Object e(JsonParser jsonParser, DeserializationContext deserializationContext);

    public abstract b f(BeanProperty beanProperty);

    public abstract Class<?> g();

    public abstract String h();

    public abstract c i();

    public abstract JsonTypeInfo.As j();

    public boolean k() {
        return g() != null;
    }
}
