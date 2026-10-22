package f9;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final a f3580a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3581b;

    /* renamed from: c, reason: collision with root package name */
    public final a f3582c;

    /* renamed from: d, reason: collision with root package name */
    public final m f3583d;

    /* renamed from: e, reason: collision with root package name */
    public final Method f3584e;

    public n(a aVar, Object obj, a aVar2, m mVar, Class cls) {
        if (aVar == null) {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
        if (mVar.f3570g == m0.f3575k && aVar2 == null) {
            throw new IllegalArgumentException("Null messageDefaultInstance");
        }
        this.f3580a = aVar;
        this.f3581b = obj;
        this.f3582c = aVar2;
        this.f3583d = mVar;
        if (!p.class.isAssignableFrom(cls)) {
            this.f3584e = null;
            return;
        }
        try {
            this.f3584e = cls.getMethod("valueOf", Integer.TYPE);
        } catch (NoSuchMethodException e10) {
            String name = cls.getName();
            throw new RuntimeException(m.x.n(new StringBuilder(name.length() + 52), "Generated message class \"", name, "\" missing method \"valueOf\"."), e10);
        }
    }

    public final Object a(Object obj) {
        if (this.f3583d.f3570g.f3578f != n0.f3592n) {
            return obj;
        }
        try {
            return this.f3584e.invoke(null, (Integer) obj);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public final Object b(Object obj) {
        return this.f3583d.f3570g.f3578f == n0.f3592n ? Integer.valueOf(((p) obj).getNumber()) : obj;
    }
}
