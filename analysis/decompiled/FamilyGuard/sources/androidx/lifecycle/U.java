package androidx.lifecycle;

import W.a;
import X.j;
import android.app.Application;
import h4.C0753a;
import java.lang.reflect.InvocationTargetException;
import p4.InterfaceC0929b;

/* loaded from: classes.dex */
public class U {

    /* renamed from: b, reason: collision with root package name */
    public static final b f10841b = new b(null);

    /* renamed from: c, reason: collision with root package name */
    public static final a.b<String> f10842c = j.a.f5774a;

    /* renamed from: a, reason: collision with root package name */
    private final W.d f10843a;

    public static final class b {
        public /* synthetic */ b(j4.g gVar) {
            this();
        }

        private b() {
        }
    }

    public interface c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f10848a = a.f10849a;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ a f10849a = new a();

            private a() {
            }
        }

        default <T extends T> T a(Class<T> cls) {
            j4.k.g(cls, "modelClass");
            return (T) X.j.f5773a.d();
        }

        default <T extends T> T b(InterfaceC0929b<T> interfaceC0929b, W.a aVar) {
            j4.k.g(interfaceC0929b, "modelClass");
            j4.k.g(aVar, "extras");
            return (T) c(C0753a.a(interfaceC0929b), aVar);
        }

        default <T extends T> T c(Class<T> cls, W.a aVar) {
            j4.k.g(cls, "modelClass");
            j4.k.g(aVar, "extras");
            return (T) a(cls);
        }
    }

    public static class d implements c {

        /* renamed from: c, reason: collision with root package name */
        private static d f10851c;

        /* renamed from: b, reason: collision with root package name */
        public static final a f10850b = new a(null);

        /* renamed from: d, reason: collision with root package name */
        public static final a.b<String> f10852d = j.a.f5774a;

        public static final class a {
            public /* synthetic */ a(j4.g gVar) {
                this();
            }

            public final d a() {
                if (d.f10851c == null) {
                    d.f10851c = new d();
                }
                d dVar = d.f10851c;
                j4.k.d(dVar);
                return dVar;
            }

            private a() {
            }
        }

        @Override // androidx.lifecycle.U.c
        public <T extends T> T a(Class<T> cls) {
            j4.k.g(cls, "modelClass");
            return (T) X.d.f5768a.a(cls);
        }

        @Override // androidx.lifecycle.U.c
        public <T extends T> T b(InterfaceC0929b<T> interfaceC0929b, W.a aVar) {
            j4.k.g(interfaceC0929b, "modelClass");
            j4.k.g(aVar, "extras");
            return (T) c(C0753a.a(interfaceC0929b), aVar);
        }

        @Override // androidx.lifecycle.U.c
        public <T extends T> T c(Class<T> cls, W.a aVar) {
            j4.k.g(cls, "modelClass");
            j4.k.g(aVar, "extras");
            return (T) a(cls);
        }
    }

    public static class e {
        public void d(T t5) {
            j4.k.g(t5, "viewModel");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public U(W w5, c cVar) {
        this(w5, cVar, null, 4, null);
        j4.k.g(w5, "store");
        j4.k.g(cVar, "factory");
    }

    public <T extends T> T a(Class<T> cls) {
        j4.k.g(cls, "modelClass");
        return (T) c(C0753a.c(cls));
    }

    public <T extends T> T b(String str, Class<T> cls) {
        j4.k.g(str, "key");
        j4.k.g(cls, "modelClass");
        return (T) this.f10843a.a(C0753a.c(cls), str);
    }

    public final <T extends T> T c(InterfaceC0929b<T> interfaceC0929b) {
        j4.k.g(interfaceC0929b, "modelClass");
        return (T) W.d.b(this.f10843a, interfaceC0929b, null, 2, null);
    }

    public static class a extends d {

        /* renamed from: g, reason: collision with root package name */
        private static a f10845g;

        /* renamed from: e, reason: collision with root package name */
        private final Application f10847e;

        /* renamed from: f, reason: collision with root package name */
        public static final b f10844f = new b(null);

        /* renamed from: h, reason: collision with root package name */
        public static final a.b<Application> f10846h = new C0135a();

        /* renamed from: androidx.lifecycle.U$a$a, reason: collision with other inner class name */
        public static final class C0135a implements a.b<Application> {
            C0135a() {
            }
        }

        public static final class b {
            public /* synthetic */ b(j4.g gVar) {
                this();
            }

            public final a a(Application application) {
                j4.k.g(application, "application");
                if (a.f10845g == null) {
                    a.f10845g = new a(application);
                }
                a aVar = a.f10845g;
                j4.k.d(aVar);
                return aVar;
            }

            private b() {
            }
        }

        private a(Application application, int i5) {
            this.f10847e = application;
        }

        private final <T extends T> T h(Class<T> cls, Application application) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            if (!C0521a.class.isAssignableFrom(cls)) {
                return (T) super.a(cls);
            }
            try {
                T tNewInstance = cls.getConstructor(Application.class).newInstance(application);
                j4.k.f(tNewInstance, "{\n                try {\n…          }\n            }");
                return tNewInstance;
            } catch (IllegalAccessException e6) {
                throw new RuntimeException("Cannot create an instance of " + cls, e6);
            } catch (InstantiationException e7) {
                throw new RuntimeException("Cannot create an instance of " + cls, e7);
            } catch (NoSuchMethodException e8) {
                throw new RuntimeException("Cannot create an instance of " + cls, e8);
            } catch (InvocationTargetException e9) {
                throw new RuntimeException("Cannot create an instance of " + cls, e9);
            }
        }

        @Override // androidx.lifecycle.U.d, androidx.lifecycle.U.c
        public <T extends T> T a(Class<T> cls) {
            j4.k.g(cls, "modelClass");
            Application application = this.f10847e;
            if (application != null) {
                return (T) h(cls, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.U.d, androidx.lifecycle.U.c
        public <T extends T> T c(Class<T> cls, W.a aVar) {
            j4.k.g(cls, "modelClass");
            j4.k.g(aVar, "extras");
            if (this.f10847e != null) {
                return (T) a(cls);
            }
            Application application = (Application) aVar.a(f10846h);
            if (application != null) {
                return (T) h(cls, application);
            }
            if (C0521a.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return (T) super.a(cls);
        }

        public a() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            this(application, 0);
            j4.k.g(application, "application");
        }
    }

    private U(W.d dVar) {
        this.f10843a = dVar;
    }

    public /* synthetic */ U(W w5, c cVar, W.a aVar, int i5, j4.g gVar) {
        this(w5, cVar, (i5 & 4) != 0 ? a.C0085a.f5713b : aVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public U(W w5, c cVar, W.a aVar) {
        this(new W.d(w5, cVar, aVar));
        j4.k.g(w5, "store");
        j4.k.g(cVar, "factory");
        j4.k.g(aVar, "defaultCreationExtras");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public U(X x5) {
        j4.k.g(x5, "owner");
        W viewModelStore = x5.getViewModelStore();
        X.j jVar = X.j.f5773a;
        this(viewModelStore, jVar.b(x5), jVar.a(x5));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public U(X x5, c cVar) {
        this(x5.getViewModelStore(), cVar, X.j.f5773a.a(x5));
        j4.k.g(x5, "owner");
        j4.k.g(cVar, "factory");
    }
}
