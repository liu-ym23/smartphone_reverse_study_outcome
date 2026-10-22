package G1;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class q extends s {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f629b;

    public q(Method method) {
        this.f629b = method;
    }

    @Override // G1.s
    public final boolean a(Object obj, AccessibleObject accessibleObject) {
        try {
            return ((Boolean) this.f629b.invoke(accessibleObject, obj)).booleanValue();
        } catch (Exception e4) {
            throw new RuntimeException("Failed invoking canAccess", e4);
        }
    }
}
