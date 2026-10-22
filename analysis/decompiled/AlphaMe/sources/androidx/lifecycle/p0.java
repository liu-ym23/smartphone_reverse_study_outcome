package androidx.lifecycle;

import android.app.Application;
import d0.C0534d;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class p0 extends r0 {

    /* renamed from: c, reason: collision with root package name */
    public static p0 f3976c;

    /* renamed from: b, reason: collision with root package name */
    public final Application f3977b;

    public p0(Application application) {
        this.f3977b = application;
    }

    @Override // androidx.lifecycle.r0, androidx.lifecycle.q0
    public final n0 a(Class modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Application application = this.f3977b;
        if (application != null) {
            return b(modelClass, application);
        }
        throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
    }

    public final n0 b(Class cls, Application application) {
        if (!AbstractC0304a.class.isAssignableFrom(cls)) {
            return super.a(cls);
        }
        try {
            n0 n0Var = (n0) cls.getConstructor(Application.class).newInstance(application);
            Intrinsics.checkNotNullExpressionValue(n0Var, "{\n                try {\n…          }\n            }");
            return n0Var;
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("Cannot create an instance of " + cls, e4);
        } catch (InstantiationException e5) {
            throw new RuntimeException("Cannot create an instance of " + cls, e5);
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException("Cannot create an instance of " + cls, e6);
        } catch (InvocationTargetException e7) {
            throw new RuntimeException("Cannot create an instance of " + cls, e7);
        }
    }

    @Override // androidx.lifecycle.q0
    public final n0 c(Class modelClass, C0534d extras) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        if (this.f3977b != null) {
            return a(modelClass);
        }
        Application application = (Application) extras.a(o0.f3973a);
        if (application != null) {
            return b(modelClass, application);
        }
        if (AbstractC0304a.class.isAssignableFrom(modelClass)) {
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }
        return super.a(modelClass);
    }
}
