package bs;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements InvocationHandler {
    public d() {
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
        return r101.invoke(this, r102);
    }
}
