package c8;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class y implements e {

    /* renamed from: a, reason: collision with root package name */
    public final Method f2101a;
    public final List b;
    public final Class c;

    public y(Method method, List list) {
        this.f2101a = method;
        this.b = list;
        Class<?> returnType = method.getReturnType();
        kotlin.jvm.internal.k.e(returnType, "getReturnType(...)");
        this.c = returnType;
    }

    @Override // c8.e
    public final List a() {
        return this.b;
    }

    @Override // c8.e
    public final /* bridge */ /* synthetic */ Member getMember() {
        return null;
    }

    @Override // c8.e
    public final Type getReturnType() {
        return this.c;
    }
}
