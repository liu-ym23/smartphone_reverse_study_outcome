package p0;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import o0.C0888a;

/* renamed from: p0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0920g implements t {

    /* renamed from: a, reason: collision with root package name */
    private final Method f19297a;

    /* renamed from: b, reason: collision with root package name */
    private final Class f19298b;

    public C0920g(Method method) {
        this.f19297a = method;
        this.f19298b = method.getParameterTypes()[0];
    }

    @Override // p0.t
    public int d() {
        return 0;
    }

    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        try {
            return (T) this.f19297a.invoke(null, c0888a.h0(this.f19298b));
        } catch (IllegalAccessException e6) {
            throw new l0.d("parse enum error", e6);
        } catch (InvocationTargetException e7) {
            throw new l0.d("parse enum error", e7);
        }
    }
}
