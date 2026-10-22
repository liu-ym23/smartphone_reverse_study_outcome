package a8;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a0 implements h {

    /* renamed from: a, reason: collision with root package name */
    public final Method f432a;

    /* renamed from: b, reason: collision with root package name */
    public final List f433b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f434c;

    public a0(Method method, List list) {
        this.f432a = method;
        this.f433b = list;
        Class<?> returnType = method.getReturnType();
        q7.k.d(returnType, "unboxMethod.returnType");
        this.f434c = returnType;
    }

    @Override // a8.h
    public final Type f() {
        return this.f434c;
    }

    @Override // a8.h
    public final List i() {
        return this.f433b;
    }

    @Override // a8.h
    public final /* bridge */ /* synthetic */ Member j() {
        return null;
    }
}
