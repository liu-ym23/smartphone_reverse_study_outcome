package J9;

import K9.C0925f;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f3805a = new m();

    public final String a(Constructor<?> constructor) {
        p.i(constructor, "constructor");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        p.h(parameterTypes, "getParameterTypes(...)");
        for (Class<?> cls : parameterTypes) {
            p.f(cls);
            sb2.append(C0925f.f(cls));
        }
        sb2.append(")V");
        String string = sb2.toString();
        p.h(string, "toString(...)");
        return string;
    }

    public final String b(Field field) {
        p.i(field, "field");
        Class<?> type = field.getType();
        p.h(type, "getType(...)");
        return C0925f.f(type);
    }

    public final String c(Method method) {
        p.i(method, "method");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        Class<?>[] parameterTypes = method.getParameterTypes();
        p.h(parameterTypes, "getParameterTypes(...)");
        for (Class<?> cls : parameterTypes) {
            p.f(cls);
            sb2.append(C0925f.f(cls));
        }
        sb2.append(")");
        Class<?> returnType = method.getReturnType();
        p.h(returnType, "getReturnType(...)");
        sb2.append(C0925f.f(returnType));
        String string = sb2.toString();
        p.h(string, "toString(...)");
        return string;
    }
}
