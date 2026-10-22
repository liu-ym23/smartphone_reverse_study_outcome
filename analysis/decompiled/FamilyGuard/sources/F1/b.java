package F1;

import C1.e;
import java.lang.reflect.AccessibleObject;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final b f1630a;

    static {
        f1630a = e.c() < 9 ? new a() : new c();
    }

    public static b a() {
        return f1630a;
    }

    public abstract void b(AccessibleObject accessibleObject);
}
