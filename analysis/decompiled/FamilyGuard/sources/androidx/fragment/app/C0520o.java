package androidx.fragment.app;

import androidx.fragment.app.ComponentCallbacksC0511f;

/* renamed from: androidx.fragment.app.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0520o {

    /* renamed from: a, reason: collision with root package name */
    private static final q.i<ClassLoader, q.i<String, Class<?>>> f10707a = new q.i<>();

    static boolean b(ClassLoader classLoader, String str) {
        try {
            return ComponentCallbacksC0511f.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static Class<?> c(ClassLoader classLoader, String str) throws ClassNotFoundException {
        q.i<ClassLoader, q.i<String, Class<?>>> iVar = f10707a;
        q.i<String, Class<?>> iVar2 = iVar.get(classLoader);
        if (iVar2 == null) {
            iVar2 = new q.i<>();
            iVar.put(classLoader, iVar2);
        }
        Class<?> cls = iVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        iVar2.put(str, cls2);
        return cls2;
    }

    public static Class<? extends ComponentCallbacksC0511f> d(ClassLoader classLoader, String str) {
        try {
            return c(classLoader, str);
        } catch (ClassCastException e6) {
            throw new ComponentCallbacksC0511f.l("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e6);
        } catch (ClassNotFoundException e7) {
            throw new ComponentCallbacksC0511f.l("Unable to instantiate fragment " + str + ": make sure class name exists", e7);
        }
    }

    public ComponentCallbacksC0511f a(ClassLoader classLoader, String str) {
        throw null;
    }
}
