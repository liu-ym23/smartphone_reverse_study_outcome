package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class q0 extends s9.d {

    /* renamed from: i, reason: collision with root package name */
    public static q0 f1026i;

    /* renamed from: j, reason: collision with root package name */
    public static final s9.d f1027j = new s9.d(5);

    /* renamed from: h, reason: collision with root package name */
    public final Application f1028h;

    public q0(Application application) {
        super(6);
        this.f1028h = application;
    }

    @Override // s9.d, androidx.lifecycle.r0
    public final p0 b(Class cls) {
        Application application = this.f1028h;
        if (application == null) {
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }
        if (!a.class.isAssignableFrom(cls)) {
            return w7.e0.p(cls);
        }
        try {
            p0 p0Var = (p0) cls.getConstructor(Application.class).newInstance(application);
            q7.k.b(p0Var);
            return p0Var;
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(a1.a.g(cls, "Cannot create an instance of "), e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException(a1.a.g(cls, "Cannot create an instance of "), e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException(a1.a.g(cls, "Cannot create an instance of "), e12);
        } catch (InvocationTargetException e13) {
            throw new RuntimeException(a1.a.g(cls, "Cannot create an instance of "), e13);
        }
    }
}
