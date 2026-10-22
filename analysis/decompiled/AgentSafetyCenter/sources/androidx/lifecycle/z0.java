package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z0 extends f7.f {
    public static z0 i;

    /* renamed from: j, reason: collision with root package name */
    public static final f7.f f1463j = new f7.f(13);

    /* renamed from: h, reason: collision with root package name */
    public final Application f1464h;

    public z0(Application application) {
        super(15);
        this.f1464h = application;
    }

    @Override // f7.f, androidx.lifecycle.a1
    public final y0 a(Class cls) {
        Application application = this.f1464h;
        if (application != null) {
            return r(cls, application);
        }
        g5.f.o("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        return null;
    }

    @Override // f7.f, androidx.lifecycle.a1
    public final y0 c(Class cls, h4.c cVar) {
        if (this.f1464h != null) {
            return a(cls);
        }
        Application application = (Application) cVar.f5290a.get(f1463j);
        if (application != null) {
            return r(cls, application);
        }
        if (!a.class.isAssignableFrom(cls)) {
            return id.c.m(cls);
        }
        g5.f.s("CreationExtras must have an application by `APPLICATION_KEY`");
        return null;
    }

    public final y0 r(Class cls, Application application) {
        if (!a.class.isAssignableFrom(cls)) {
            return id.c.m(cls);
        }
        try {
            y0 y0Var = (y0) cls.getConstructor(Application.class).newInstance(application);
            y0Var.getClass();
            return y0Var;
        } catch (IllegalAccessException e10) {
            b8.z.v(e10, cls, "Cannot create an instance of ");
            return null;
        } catch (InstantiationException e11) {
            b8.z.v(e11, cls, "Cannot create an instance of ");
            return null;
        } catch (NoSuchMethodException e12) {
            b8.z.v(e12, cls, "Cannot create an instance of ");
            return null;
        } catch (InvocationTargetException e13) {
            b8.z.v(e13, cls, "Cannot create an instance of ");
            return null;
        }
    }
}
