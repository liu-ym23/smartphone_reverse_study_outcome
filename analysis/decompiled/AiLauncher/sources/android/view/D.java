package android.view;

import android.view.C1385c;
import android.view.Lifecycle;
import java.lang.reflect.InvocationTargetException;

@Deprecated
/* loaded from: classes.dex */
public class D implements InterfaceC1395m {

    /* renamed from: a, reason: collision with root package name */
    public final Object f14171a;

    /* renamed from: b, reason: collision with root package name */
    public final C1385c.a f14172b;

    public D(Object obj) {
        this.f14171a = obj;
        this.f14172b = C1385c.f14264c.c(obj.getClass());
    }

    @Override // android.view.InterfaceC1395m
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f14172b.a(lifecycleOwner, event, this.f14171a);
    }
}
