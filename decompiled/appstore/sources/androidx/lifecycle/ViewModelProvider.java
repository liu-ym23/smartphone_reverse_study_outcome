package androidx.lifecycle;

import android.app.Application;
import androidx.lifecycle.viewmodel.CreationExtras;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public class ViewModelProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewModelStore f3480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Factory f3481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CreationExtras f3482c;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\fJ'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$Factory;", "", "Landroidx/lifecycle/k0;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/k0;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "extras", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/k0;", "Companion", "a", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Factory {

        @NotNull
        public static final a Companion = null;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f3483a = null;

            static {
                f3483a = new a();
            }

            public a() {
            }

            public final Factory a(y.b... r10) {
                kotlin.jvm.internal.q.g(r10, "initializers");
                return new y.a((y.b[]) Arrays.copyOf(r10, r10.length));
            }
        }

        static {
            Companion = a.f3483a;
        }

        @JvmStatic
        @NotNull
        static Factory from(@NotNull y.b... r10) {
            return Companion.a(r10);
        }

        @NotNull
        default <T extends k0> T create(@NotNull Class<T> r10) {
            kotlin.jvm.internal.q.g(r10, "modelClass");
            throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
        }

        @NotNull
        default <T extends k0> T create(@NotNull Class<T> r10, @NotNull CreationExtras r11) {
            kotlin.jvm.internal.q.g(r10, "modelClass");
            kotlin.jvm.internal.q.g(r11, "extras");
            return (T) create(r10);
        }
    }

    public static class a extends b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final C0031a f3484e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static a f3485f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final CreationExtras.Key f3486g = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Application f3487d;

        /* JADX INFO: renamed from: androidx.lifecycle.ViewModelProvider$a$a, reason: collision with other inner class name */
        public static final class C0031a {

            /* JADX INFO: renamed from: androidx.lifecycle.ViewModelProvider$a$a$a, reason: collision with other inner class name */
            public static final class C0032a implements CreationExtras.Key {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0032a f3488a = null;

                static {
                    f3488a = new C0032a();
                }

                public C0032a() {
                }
            }

            public /* synthetic */ C0031a(DefaultConstructorMarker r10) {
                this();
            }

            public final a a(Application r10) {
                kotlin.jvm.internal.q.g(r10, "application");
                if (a.c() != null) goto L5;
                a.d(new a(r10));
            L5:
                a r11 = a.c();
                kotlin.jvm.internal.q.d(r11);
                return r11;
            }

            public C0031a() {
            }
        }

        static {
            f3484e = new C0031a(null);
            f3486g = C0031a.C0032a.f3488a;
        }

        public a(Application r10, int r11) {
            this.f3487d = r10;
        }

        public static final /* synthetic */ a c() {
            return f3485f;
        }

        public static final /* synthetic */ void d(a r10) {
            f3485f = r10;
        }

        public static final a f(Application r10) {
            return f3484e.a(r10);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public k0 create(Class r10, CreationExtras r11) {
            kotlin.jvm.internal.q.g(r10, "modelClass");
            kotlin.jvm.internal.q.g(r11, "extras");
            if (this.f3487d != null) goto L14;
            Application r12 = (Application) r11.a(f3486g);
            if (r12 == null) goto L9;
            return e(r10, r12);
        L9:
            if (androidx.lifecycle.b.class.isAssignableFrom(r10) == true) goto L13;
            return super.create(r10);
        L13:
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        L14:
            return create(r10);
        }

        public final k0 e(Class r10, Application r11) {
            if (androidx.lifecycle.b.class.isAssignableFrom(r10) == false) goto L23;
            k0 r12 = (k0) r10.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{r11});     // Catch: InvocationTargetException -> L6 InstantiationException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12
            kotlin.jvm.internal.q.f(r12, "{\n                try {\n…          }\n            }");
            return r12;
        L10:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r10, e);
        L8:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r10, e);
        L12:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r10, e);
        L6:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r10, e);
        L23:
            return super.create(r10);
        }

        public a() {
            this(null, 0);
        }

        public a(Application r10) {
            kotlin.jvm.internal.q.g(r10, "application");
            this(r10, 0);
        }

        @Override // androidx.lifecycle.ViewModelProvider.b, androidx.lifecycle.ViewModelProvider.Factory
        public k0 create(Class r10) {
            kotlin.jvm.internal.q.g(r10, "modelClass");
            Application r11 = this.f3487d;
            if (r11 == null) goto L7;
            return e(r10, r11);
        L7:
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }
    }

    public static class b implements Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f3489a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static b f3490b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final CreationExtras.Key f3491c = null;

        public static final class a {

            /* JADX INFO: renamed from: androidx.lifecycle.ViewModelProvider$b$a$a, reason: collision with other inner class name */
            public static final class C0033a implements CreationExtras.Key {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0033a f3492a = null;

                static {
                    f3492a = new C0033a();
                }

                public C0033a() {
                }
            }

            public /* synthetic */ a(DefaultConstructorMarker r10) {
                this();
            }

            public final b a() {
                if (b.a() != null) goto L5;
                b.b(new b());
            L5:
                b r10 = b.a();
                kotlin.jvm.internal.q.d(r10);
                return r10;
            }

            public a() {
            }
        }

        static {
            f3489a = new a(null);
            f3491c = a.C0033a.f3492a;
        }

        public b() {
        }

        public static final /* synthetic */ b a() {
            return f3490b;
        }

        public static final /* synthetic */ void b(b r10) {
            f3490b = r10;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public k0 create(Class r10) {
            kotlin.jvm.internal.q.g(r10, "modelClass");
            Object r11 = r10.getDeclaredConstructor(null).newInstance(null);     // Catch: IllegalAccessException -> L5 InstantiationException -> L7 NoSuchMethodException -> L9
            kotlin.jvm.internal.q.f(r11, "{\n                modelC…wInstance()\n            }");     // Catch: IllegalAccessException -> L5 InstantiationException -> L7 NoSuchMethodException -> L9
            return (k0) r11;
        L5:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r10, e);
        L7:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r10, e);
        L9:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r10, e);
        }
    }

    public static class c {
        public c() {
        }

        public abstract void a(k0 r10);
    }

    public ViewModelProvider(ViewModelStore r10, Factory r11) {
        kotlin.jvm.internal.q.g(r10, "store");
        kotlin.jvm.internal.q.g(r11, "factory");
        CreationExtras r12 = null;
        this(r10, r11, r12, 4, null);
    }

    public k0 a(Class r10) {
        kotlin.jvm.internal.q.g(r10, "modelClass");
        String r11 = r10.getCanonicalName();
        if (r11 == null) goto L7;
        return b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + r11, r10);
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public k0 b(String r10, Class r11) {
        kotlin.jvm.internal.q.g(r10, "key");
        kotlin.jvm.internal.q.g(r11, "modelClass");
        k0 r12 = this.f3480a.b(r10);
        if (r11.isInstance(r12) == false) goto L12;
        Object r13 = this.f3481b;
        if ((r13 instanceof c) == false) goto L7;
        c r14 = (c) r13;
    L8:
        if (r14 == null) goto L10;
        kotlin.jvm.internal.q.d(r12);
        r14.a(r12);
    L10:
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return r12;
    L7:
        r14 = null;
        goto L8
    L12:
        androidx.lifecycle.viewmodel.a r15 = new androidx.lifecycle.viewmodel.a(this.f3482c);
        r15.c(b.f3491c, r10);
        k0 r16 = this.f3481b.create(r11, r15);     // Catch: AbstractMethodError -> L15
    L16:
        this.f3480a.d(r10, r16);
        return r16;
    L15:
        r16 = this.f3481b.create(r11);
        goto L16
    }

    public ViewModelProvider(ViewModelStore r10, Factory r11, CreationExtras r12) {
        kotlin.jvm.internal.q.g(r10, "store");
        kotlin.jvm.internal.q.g(r11, "factory");
        kotlin.jvm.internal.q.g(r12, "defaultCreationExtras");
        this.f3480a = r10;
        this.f3481b = r11;
        this.f3482c = r12;
    }

    public /* synthetic */ ViewModelProvider(ViewModelStore r10, Factory r11, CreationExtras r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = CreationExtras.a.f3577b;
    L5:
        this(r10, r11, r12);
    }

    public ViewModelProvider(ViewModelStoreOwner r10, Factory r11) {
        kotlin.jvm.internal.q.g(r10, "owner");
        kotlin.jvm.internal.q.g(r11, "factory");
        this(r10.getViewModelStore(), r11, n0.a(r10));
    }
}
