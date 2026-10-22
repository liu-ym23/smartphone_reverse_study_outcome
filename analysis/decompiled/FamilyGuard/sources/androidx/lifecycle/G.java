package androidx.lifecycle;

import androidx.lifecycle.AbstractC0533m;
import androidx.lifecycle.C0522b;
import java.lang.reflect.InvocationTargetException;

@Deprecated
/* loaded from: classes.dex */
class G implements InterfaceC0537q {

    /* renamed from: a, reason: collision with root package name */
    private final Object f10807a;

    /* renamed from: b, reason: collision with root package name */
    private final C0522b.a f10808b;

    G(Object obj) {
        this.f10807a = obj;
        this.f10808b = C0522b.f10855c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.InterfaceC0537q
    public void f(InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f10808b.a(interfaceC0539t, aVar, this.f10807a);
    }
}
