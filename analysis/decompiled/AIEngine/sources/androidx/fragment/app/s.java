package androidx.fragment.app;

import androidx.fragment.app.Fragment;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public static final p.o<ClassLoader, p.o<String, Class<?>>> f2179a = new p.o<>();

    public static Class<?> b(ClassLoader classLoader, String str) throws ClassNotFoundException {
        p.o<ClassLoader, p.o<String, Class<?>>> oVar = f2179a;
        p.o<String, Class<?>> oVar2 = oVar.get(classLoader);
        if (oVar2 == null) {
            oVar2 = new p.o<>();
            oVar.put(classLoader, oVar2);
        }
        Class<?> cls = oVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        oVar2.put(str, cls2);
        return cls2;
    }

    public static Class<? extends Fragment> c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassCastException e10) {
            throw new Fragment.InstantiationException(a0.a.k("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e10);
        } catch (ClassNotFoundException e11) {
            throw new Fragment.InstantiationException(a0.a.k("Unable to instantiate fragment ", str, ": make sure class name exists"), e11);
        }
    }

    public Fragment a(String str) {
        throw null;
    }
}
