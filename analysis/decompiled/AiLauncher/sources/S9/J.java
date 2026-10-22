package S9;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import xa.InterfaceC5864g;

/* loaded from: classes5.dex */
public final class J<T> implements H<T> {

    /* renamed from: b, reason: collision with root package name */
    public final Map<ga.c, T> f5735b;

    /* renamed from: c, reason: collision with root package name */
    public final LockBasedStorageManager f5736c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC5864g<ga.c, T> f5737d;

    /* JADX WARN: Multi-variable type inference failed */
    public J(Map<ga.c, ? extends T> states) {
        kotlin.jvm.internal.p.i(states, "states");
        this.f5735b = states;
        LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("Java nullability annotation states");
        this.f5736c = lockBasedStorageManager;
        InterfaceC5864g<ga.c, T> interfaceC5864gF = lockBasedStorageManager.f(new I(this));
        kotlin.jvm.internal.p.h(interfaceC5864gF, "createMemoizedFunctionWithNullableValues(...)");
        this.f5737d = interfaceC5864gF;
    }

    public static final Object c(J j10, ga.c cVar) {
        kotlin.jvm.internal.p.f(cVar);
        return kotlin.reflect.jvm.internal.impl.name.a.a(cVar, j10.f5735b);
    }

    @Override // S9.H
    public T a(ga.c fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        return this.f5737d.invoke(fqName);
    }
}
