package b3;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.fasterxml.jackson.databind.type.TypeFactory;
import q3.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class b {
    public static String a(String str, String str2) {
        return str2 == null ? str : com.stepos.core.ota.d.i(str, ": ", str2);
    }

    public static String b(String str) {
        if (str == null) {
            return "[N/A]";
        }
        if (str.length() > 500) {
            str = str.substring(0, 500) + "]...[" + str.substring(str.length() - 500);
        }
        return a0.a.k("\"", str, "\"");
    }

    public final q3.g c(Object obj) {
        if (obj instanceof q3.g) {
            return (q3.g) obj;
        }
        if (!(obj instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + obj.getClass().getName() + "; expected type Converter or Class<Converter> instead");
        }
        Class cls = (Class) obj;
        if (cls == g.a.class || com.fasterxml.jackson.databind.util.a.t(cls)) {
            return null;
        }
        if (q3.g.class.isAssignableFrom(cls)) {
            MapperConfig<?> mapperConfigD = d();
            mapperConfigD.h();
            return (q3.g) com.fasterxml.jackson.databind.util.a.h(cls, mapperConfigD.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS));
        }
        throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<Converter>");
    }

    public abstract MapperConfig<?> d();

    public abstract TypeFactory e();

    public abstract InvalidTypeIdException f(JavaType javaType, String str, String str2);

    public final ObjectIdGenerator g(i3.h hVar) {
        Class<? extends ObjectIdGenerator<?>> cls = hVar.f9512b;
        MapperConfig<?> mapperConfigD = d();
        mapperConfigD.h();
        return ((ObjectIdGenerator) com.fasterxml.jackson.databind.util.a.h(cls, mapperConfigD.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS))).b(hVar.f9514d);
    }

    public final com.fasterxml.jackson.annotation.a h(i3.h hVar) {
        Class<? extends com.fasterxml.jackson.annotation.a> cls = hVar.f9513c;
        MapperConfig<?> mapperConfigD = d();
        mapperConfigD.h();
        return (com.fasterxml.jackson.annotation.a) com.fasterxml.jackson.databind.util.a.h(cls, mapperConfigD.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS));
    }

    public final <T> T i(Class<?> cls, String str) {
        if (cls != null) {
            e().j(cls);
        }
        j(str);
        throw null;
    }

    public abstract Object j(String str);
}
