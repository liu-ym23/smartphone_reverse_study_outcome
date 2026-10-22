package androidx.fragment.app;

import java.lang.reflect.InvocationTargetException;
import p.p0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: b, reason: collision with root package name */
    public static final p0 f1298b = new p0(0);

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ v f1299a;

    public static Class b(ClassLoader classLoader, String str) throws ClassNotFoundException {
        p0 p0Var = f1298b;
        p0 p0Var2 = (p0) p0Var.get(classLoader);
        if (p0Var2 == null) {
            p0Var2 = new p0(0);
            p0Var.put(classLoader, p0Var2);
        }
        Class cls = (Class) p0Var2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        p0Var2.put(str, cls2);
        return cls2;
    }

    public static Class c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassCastException e10) {
            throw new d(k0.a.C("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e10);
        } catch (ClassNotFoundException e11) {
            throw new d(k0.a.C("Unable to instantiate fragment ", str, ": make sure class name exists"), e11);
        }
    }

    public final void a(String str) {
        try {
            if (c(this.f1299a.f1321r.f1283c.getClassLoader(), str).getConstructor(null).newInstance(null) == null) {
            } else {
                throw new ClassCastException();
            }
        } catch (IllegalAccessException e10) {
            throw new d(k0.a.C("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e10);
        } catch (InstantiationException e11) {
            throw new d(k0.a.C("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e11);
        } catch (NoSuchMethodException e12) {
            throw new d(k0.a.C("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e12);
        } catch (InvocationTargetException e13) {
            throw new d(k0.a.C("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e13);
        }
    }
}
