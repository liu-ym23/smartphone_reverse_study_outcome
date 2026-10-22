package kotlin.jvm.internal;

import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static final a0 f3687a;

    static {
        a0 a0Var = null;
        try {
            a0Var = (a0) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (a0Var == null) {
            a0Var = new a0();
        }
        f3687a = a0Var;
    }

    public static h a(Class cls) {
        f3687a.getClass();
        return new h(cls);
    }

    public static void b(e0 e0Var, f0 f0Var) {
        a0 a0Var = f3687a;
        List upperBounds = Collections.singletonList(f0Var);
        a0Var.getClass();
        p.e(upperBounds, "upperBounds");
        if (e0Var.f3668b == null) {
            e0Var.f3668b = upperBounds;
            return;
        }
        throw new IllegalStateException(("Upper bounds of type parameter '" + e0Var + "' have already been initialized.").toString());
    }

    public static f0 c(Class cls) {
        h hVarA = a(cls);
        List list = Collections.EMPTY_LIST;
        f3687a.getClass();
        return a0.b(hVarA, list);
    }

    public static f0 d(Class cls, v5.k kVar) {
        h hVarA = a(cls);
        List listSingletonList = Collections.singletonList(kVar);
        f3687a.getClass();
        return a0.b(hVarA, listSingletonList);
    }
}
