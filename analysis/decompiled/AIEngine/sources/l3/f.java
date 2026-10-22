package l3;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.type.TypeParser;
import com.fasterxml.jackson.databind.util.a;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.EnumSet;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class f extends j {

    /* renamed from: c, reason: collision with root package name */
    public final PolymorphicTypeValidator f10201c;

    public f(JavaType javaType, TypeFactory typeFactory, PolymorphicTypeValidator polymorphicTypeValidator) {
        super(javaType, typeFactory);
        this.f10201c = polymorphicTypeValidator;
    }

    @Override // k3.c
    public String a(Object obj) {
        return f(obj, obj.getClass(), this.f10212a);
    }

    @Override // k3.c
    public final String b() {
        return "class name used as type id";
    }

    @Override // k3.c
    public final JavaType c(DeserializationContext deserializationContext, String str) {
        return g(str, deserializationContext);
    }

    @Override // k3.c
    public final String e(Class cls, Object obj) {
        return f(obj, cls, this.f10212a);
    }

    public final String f(Object obj, Class<?> cls, TypeFactory typeFactory) {
        Class<?> declaringClass;
        Class<?> declaringClass2;
        Annotation[] annotationArr = com.fasterxml.jackson.databind.util.a.f4529a;
        if (Enum.class.isAssignableFrom(cls) && !cls.isEnum()) {
            cls = cls.getSuperclass();
        }
        String name = cls.getName();
        if (name.startsWith("java.util.")) {
            if (obj instanceof EnumSet) {
                EnumSet enumSet = (EnumSet) obj;
                if (enumSet.isEmpty()) {
                    Field field = a.b.f4536c.f4537a;
                    if (field == null) {
                        throw new IllegalStateException("Cannot figure out type for EnumSet (odd JDK platform?)");
                    }
                    try {
                        declaringClass2 = (Class) field.get(enumSet);
                    } catch (Exception e10) {
                        throw new IllegalArgumentException(e10);
                    }
                } else {
                    declaringClass2 = ((Enum) enumSet.iterator().next()).getDeclaringClass();
                }
                return typeFactory.f(typeFactory.c(null, declaringClass2, TypeFactory.f4469e), EnumSet.class).O();
            }
            if (obj instanceof EnumMap) {
                EnumMap enumMap = (EnumMap) obj;
                if (enumMap.isEmpty()) {
                    Field field2 = a.b.f4536c.f4538b;
                    if (field2 == null) {
                        throw new IllegalStateException("Cannot figure out type for EnumMap (odd JDK platform?)");
                    }
                    try {
                        declaringClass = (Class) field2.get(enumMap);
                    } catch (Exception e11) {
                        throw new IllegalArgumentException(e11);
                    }
                } else {
                    declaringClass = ((Enum) enumMap.keySet().iterator().next()).getDeclaringClass();
                }
                TypeBindings typeBindings = TypeFactory.f4469e;
                return typeFactory.h(EnumMap.class, typeFactory.c(null, declaringClass, typeBindings), typeFactory.c(null, Object.class, typeBindings)).O();
            }
        } else if (name.indexOf(36) >= 0 && com.fasterxml.jackson.databind.util.a.p(cls) != null) {
            JavaType javaType = this.f10213b;
            if (com.fasterxml.jackson.databind.util.a.p(javaType.f3690a) == null) {
                return javaType.f3690a.getName();
            }
        }
        return name;
    }

    public JavaType g(String str, b3.b bVar) throws InvalidTypeIdException {
        JavaType javaTypeI;
        bVar.getClass();
        int iIndexOf = str.indexOf(60);
        JavaType javaType = this.f10213b;
        PolymorphicTypeValidator polymorphicTypeValidator = this.f10201c;
        PolymorphicTypeValidator.Validity validity = PolymorphicTypeValidator.Validity.f4239b;
        if (iIndexOf > 0) {
            str.substring(0, iIndexOf);
            if (polymorphicTypeValidator.b() == validity) {
                throw bVar.f(javaType, str, "Configured `PolymorphicTypeValidator` (of type " + com.fasterxml.jackson.databind.util.a.f(polymorphicTypeValidator) + ") denied resolution");
            }
            TypeParser typeParser = bVar.e().f4486b;
            typeParser.getClass();
            TypeParser.a aVar = new TypeParser.a(str.trim());
            javaTypeI = typeParser.b(aVar);
            if (aVar.hasMoreTokens()) {
                throw TypeParser.a(aVar, "Unexpected tokens after complete type");
            }
            if (!javaTypeI.D(javaType.f3690a)) {
                throw bVar.f(javaType, str, "Not a subtype");
            }
        } else {
            MapperConfig<?> mapperConfigD = bVar.d();
            if (polymorphicTypeValidator.b() == validity) {
                throw bVar.f(javaType, str, "Configured `PolymorphicTypeValidator` (of type " + com.fasterxml.jackson.databind.util.a.f(polymorphicTypeValidator) + ") denied resolution");
            }
            try {
                bVar.e().getClass();
                Class<?> clsK = TypeFactory.k(str);
                if (!javaType.E(clsK)) {
                    throw bVar.f(javaType, str, "Not a subtype");
                }
                javaTypeI = mapperConfigD.f3828b.f3789a.i(javaType, clsK, false);
            } catch (ClassNotFoundException unused) {
                javaTypeI = null;
            } catch (Exception e10) {
                throw bVar.f(javaType, str, ai.onnxruntime.a.l("problem: (", e10.getClass().getName(), ") ", com.fasterxml.jackson.databind.util.a.i(e10)));
            }
        }
        if (javaTypeI != null || !(bVar instanceof DeserializationContext)) {
            return javaTypeI;
        }
        ((DeserializationContext) bVar).D(javaType, str, "no such class found");
        return null;
    }
}
