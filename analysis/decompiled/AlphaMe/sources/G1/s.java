package G1;

import java.lang.reflect.AccessibleObject;

/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public static final s f630a;

    static {
        s qVar;
        if (h.f602a >= 9) {
            try {
                qVar = new q(AccessibleObject.class.getDeclaredMethod("canAccess", Object.class));
            } catch (NoSuchMethodException unused) {
            }
        } else {
            qVar = null;
        }
        if (qVar == null) {
            qVar = new r();
        }
        f630a = qVar;
    }

    public abstract boolean a(Object obj, AccessibleObject accessibleObject);
}
