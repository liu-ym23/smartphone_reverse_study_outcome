package androidx.fragment.app;

/* loaded from: classes.dex */
public final class T {

    /* renamed from: b, reason: collision with root package name */
    public static final q.l f3642b = new q.l();

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Y f3643a;

    public T(Y y4) {
        this.f3643a = y4;
    }

    public static Class b(ClassLoader classLoader, String str) throws ClassNotFoundException {
        q.l lVar = f3642b;
        q.l lVar2 = (q.l) lVar.get(classLoader);
        if (lVar2 == null) {
            lVar2 = new q.l();
            lVar.put(classLoader, lVar2);
        }
        Class cls = (Class) lVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        lVar2.put(str, cls2);
        return cls2;
    }

    public static Class c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassCastException e4) {
            throw new A(B0.g.n("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), 0, e4);
        } catch (ClassNotFoundException e5) {
            throw new A(B0.g.n("Unable to instantiate fragment ", str, ": make sure class name exists"), 0, e5);
        }
    }

    public final D a(String str) {
        return D.instantiate(this.f3643a.f3682u.f3626b, str, null);
    }
}
