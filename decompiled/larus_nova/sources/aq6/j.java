package aq6;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes21.dex */
public final class j implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<k> f15908a;

    public j(WeakReference<k> r100) {
        this.f15908a = r100;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
    L12:
        e = move-exception;
        e.printStackTrace();
        if (this.f15908a.get() == null) goto L22;
        this.f15908a.get().onPageTranslucentError();
        return null;
    L22:
        return null;
    L4:
        if (((Boolean) r102[0]).booleanValue() == false) goto L9;
        if (this.f15908a.get() == null) goto L9;
        this.f15908a.get().onPageTranslucent();     // Catch: Exception -> L12
    L18:
        return null;
    L9:
        if (this.f15908a.get() == null) goto L18;
        this.f15908a.get().onPageTranslucentError();     // Catch: Exception -> L12
        goto L18
    }
}
