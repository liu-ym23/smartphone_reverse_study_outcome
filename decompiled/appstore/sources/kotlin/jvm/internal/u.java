package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;

/* JADX INFO: loaded from: classes4.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f21189a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final KClass[] f21190b = null;

    static {
        v r10 = null;
        r10 = (v) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();     // Catch: Throwable -> L10
    L5:
        if (r10 != null) goto L8;
        r10 = new v();
    L8:
        f21189a = r10;
        f21190b = new KClass[0];
    }

    public static KFunction a(FunctionReference r10) {
        return f21189a.a(r10);
    }

    public static KClass b(Class r10) {
        return f21189a.b(r10);
    }

    public static KDeclarationContainer c(Class r10) {
        return f21189a.c(r10, "");
    }

    public static KMutableProperty0 d(MutablePropertyReference0 r10) {
        return f21189a.d(r10);
    }

    public static KMutableProperty1 e(MutablePropertyReference1 r10) {
        return f21189a.e(r10);
    }

    public static KMutableProperty2 f(MutablePropertyReference2 r10) {
        return f21189a.f(r10);
    }

    public static KProperty0 g(PropertyReference0 r10) {
        return f21189a.g(r10);
    }

    public static KProperty1 h(PropertyReference1 r10) {
        return f21189a.h(r10);
    }

    public static KProperty2 i(PropertyReference2 r10) {
        return f21189a.i(r10);
    }

    public static String j(FunctionBase r10) {
        return f21189a.j(r10);
    }

    public static String k(Lambda r10) {
        return f21189a.k(r10);
    }
}
