package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    public static final e f2303a = new e();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends c {

        /* renamed from: c, reason: collision with root package name */
        public static a f2304c;

        /* renamed from: d, reason: collision with root package name */
        public static final C0015a f2305d = new C0015a();

        /* renamed from: b, reason: collision with root package name */
        public final Application f2306b;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: androidx.lifecycle.r0$a$a, reason: collision with other inner class name */
        public static final class C0015a {
        }

        public a(Application application) {
            this.f2306b = application;
        }

        @Override // androidx.lifecycle.r0.c, androidx.lifecycle.r0.b
        public final <T extends q0> T a(Class<T> cls) {
            Application application = this.f2306b;
            if (application != null) {
                return (T) d(cls, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.r0.c, androidx.lifecycle.r0.b
        public final q0 c(Class cls, q1.b bVar) {
            if (this.f2306b != null) {
                return a(cls);
            }
            Application application = (Application) bVar.f11486a.get(f2305d);
            if (application != null) {
                return d(cls, application);
            }
            if (androidx.lifecycle.a.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return jd.b.p(cls);
        }

        public final <T extends q0> T d(Class<T> cls, Application application) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            if (!androidx.lifecycle.a.class.isAssignableFrom(cls)) {
                return (T) jd.b.p(cls);
            }
            try {
                T tNewInstance = cls.getConstructor(Application.class).newInstance(application);
                kotlin.jvm.internal.g.c(tNewInstance);
                return tNewInstance;
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("Cannot create an instance of " + cls, e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            } catch (NoSuchMethodException e12) {
                throw new RuntimeException("Cannot create an instance of " + cls, e12);
            } catch (InvocationTargetException e13) {
                throw new RuntimeException("Cannot create an instance of " + cls, e13);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
        default <T extends q0> T a(Class<T> cls) {
            throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
        }

        default q0 b(kotlin.jvm.internal.c cVar, q1.b bVar) {
            return c(xb.a.e(cVar), bVar);
        }

        default q0 c(Class cls, q1.b bVar) {
            return a(cls);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c implements b {

        /* renamed from: a, reason: collision with root package name */
        public static c f2307a;

        @Override // androidx.lifecycle.r0.b
        public <T extends q0> T a(Class<T> cls) {
            return (T) jd.b.p(cls);
        }

        @Override // androidx.lifecycle.r0.b
        public final q0 b(kotlin.jvm.internal.c cVar, q1.b bVar) {
            return c(xb.a.e(cVar), bVar);
        }

        @Override // androidx.lifecycle.r0.b
        public q0 c(Class cls, q1.b bVar) {
            return a(cls);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class e {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class d {
        public void d(q0 q0Var) {
        }
    }
}
