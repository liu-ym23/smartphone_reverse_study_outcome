package androidx.lifecycle;

import android.app.Application;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: ViewModelProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ao f2025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f2026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final androidx.lifecycle.a.a f2027c;

    /* JADX INFO: compiled from: ViewModelProvider.kt */
    public static class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0058a f2028a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final androidx.lifecycle.a.a.b<Application> f2029b = null;
        private static a g;
        private final Application f;

        /* JADX INFO: renamed from: androidx.lifecycle.am$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ViewModelProvider.kt */
        public static final class C0058a {

            /* JADX INFO: renamed from: androidx.lifecycle.am$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: ViewModelProvider.kt */
            private static final class C0059a implements androidx.lifecycle.a.a.b<Application> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0059a f2030a = null;

                static {
                    f2030a = new C0059a();
                }

                private C0059a() {
                }
            }

            public /* synthetic */ C0058a(d.h.b.h r1) {
                this();
            }

            private C0058a() {
            }

            public final b a(ap r2) {
                ap r1 = (ap) ZeusTransformUtils.wrapperContextForParams(r2, ap.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r1, "owner");
                if (ZeusTransformUtils.instanceOf(r1, g.class) == false) goto L6;
                return ((g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.aiagent.plugin")).getDefaultViewModelProviderFactory();
            L6:
                return (b) ZeusTransformUtils.preCheckCast(c.f2034d.a(), b.class, "com.obric.aiagent.plugin");
            }

            public final a a(Application r2) {
                Application r1 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r1, "application");
                if (a.a() != null) goto L5;
                a.a(new a(r1));
            L5:
                a r3 = a.a();
                d.h.b.o.a(r3);
                return r3;
            }
        }

        public static final a a(Application r2) {
            Application r3 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin");
            return f2028a.a(r3);
        }

        public static final /* synthetic */ a a() {
            return g;
        }

        public static final /* synthetic */ void a(a r0) {
            g = r0;
        }

        private a(Application r2, int r3) {
            this.f = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin");
        }

        public a() {
            this(null, 0);
        }

        public a(Application r3) {
            Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "application");
            this(r4, 0);
        }

        @Override // androidx.lifecycle.am.b
        public <T extends aj> T a(Class<T> r3, androidx.lifecycle.a.a r4) {
            d.h.b.o.e(r3, "modelClass");
            d.h.b.o.e(r4, "extras");
            if (this.f != null) goto L14;
            Application r5 = (Application) ZeusTransformUtils.preCheckCast(r4.a(f2029b), Application.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L9;
            return (T) a(r3, r5);
        L9:
            if (androidx.lifecycle.a.class.isAssignableFrom(r3) == true) goto L13;
            return (T) super.a(r3);
        L13:
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        L14:
            return (T) a(r3);
        }

        @Override // androidx.lifecycle.am.c, androidx.lifecycle.am.b
        public <T extends aj> T a(Class<T> r2) {
            d.h.b.o.e(r2, "modelClass");
            Application r0 = this.f;
            if (r0 == null) goto L7;
            return (T) a(r2, r0);
        L7:
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        private final <T extends aj> T a(Class<T> r6, Application r7) {
            Application r8 = (Application) ZeusTransformUtils.wrapperContextForParams(r7, Application.class, "com.obric.aiagent.plugin");
            if (androidx.lifecycle.a.class.isAssignableFrom(r6) == false) goto L20;
            T r5 = (T) ZeusTransformUtils.preCheckCast(r6.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{r8}), aj.class, "com.obric.aiagent.plugin");     // Catch: InvocationTargetException -> L7 InstantiationException -> L10 IllegalAccessException -> L13 NoSuchMethodException -> L16
            d.h.b.o.c(r5, "{\n                try {\n…          }\n            }");
            return r5;
        L13:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r6, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        L10:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r6, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        L16:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r6, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        L7:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r6, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        L20:
            return (T) super.a(r6);
        }

        static {
            f2028a = new C0058a(null);
            f2029b = (androidx.lifecycle.a.a.b) ZeusTransformUtils.preCheckCast(C0058a.C0059a.f2030a, androidx.lifecycle.a.a.b.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: ViewModelProvider.kt */
    public interface b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f2031c = null;

        /* JADX INFO: compiled from: ViewModelProvider.kt */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final /* synthetic */ a f2032a = null;

            static {
                f2032a = new a();
            }

            private a() {
            }
        }

        static {
            f2031c = a.f2032a;
        }

        default <T extends aj> T a(Class<T> r1) {
            d.h.b.o.e(r1, "modelClass");
            throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
        }

        default <T extends aj> T a(Class<T> r2, androidx.lifecycle.a.a r3) {
            d.h.b.o.e(r2, "modelClass");
            d.h.b.o.e(r3, "extras");
            return (T) a(r2);
        }
    }

    /* JADX INFO: compiled from: ViewModelProvider.kt */
    public static class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static c f2033a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f2034d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final androidx.lifecycle.a.a.b<String> f2035e = null;

        /* JADX INFO: compiled from: ViewModelProvider.kt */
        public static final class a {

            /* JADX INFO: renamed from: androidx.lifecycle.am$c$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: ViewModelProvider.kt */
            private static final class C0060a implements androidx.lifecycle.a.a.b<String> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0060a f2036a = null;

                static {
                    f2036a = new C0060a();
                }

                private C0060a() {
                }
            }

            public /* synthetic */ a(d.h.b.h r1) {
                this();
            }

            private a() {
            }

            public final c a() {
                if (c.b() != null) goto L5;
                c.a(new c());
            L5:
                c r0 = c.b();
                d.h.b.o.a(r0);
                return r0;
            }
        }

        public c() {
        }

        public static final /* synthetic */ void a(c r0) {
            f2033a = r0;
        }

        public static final /* synthetic */ c b() {
            return f2033a;
        }

        @Override // androidx.lifecycle.am.b
        public <T extends aj> T a(Class<T> r5) {
            d.h.b.o.e(r5, "modelClass");
            T r1 = r5.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: IllegalAccessException -> L5 InstantiationException -> L8 NoSuchMethodException -> L11
            d.h.b.o.c(r1, "{\n                modelC…wInstance()\n            }");     // Catch: IllegalAccessException -> L5 InstantiationException -> L8 NoSuchMethodException -> L11
            return (T) ZeusTransformUtils.preCheckCast(r1, aj.class, "com.obric.aiagent.plugin");
        L5:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r5, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        L8:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r5, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        L11:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r5, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        }

        static {
            f2034d = new a(null);
            f2035e = (androidx.lifecycle.a.a.b) ZeusTransformUtils.preCheckCast(a.C0060a.f2036a, androidx.lifecycle.a.a.b.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: ViewModelProvider.kt */
    public static class d {
        public void a(aj r1) {
            d.h.b.o.e(r1, "viewModel");
        }

        public d() {
        }
    }

    public am(ao r7, b r8) {
        b r2 = (b) ZeusTransformUtils.wrapperContextForParams(r8, b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "store");
        d.h.b.o.e(r2, "factory");
        this(r7, r2, null, 4, null);
    }

    public am(ao r3, b r4, androidx.lifecycle.a.a r5) {
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "store");
        d.h.b.o.e(r6, "factory");
        d.h.b.o.e(r5, "defaultCreationExtras");
        this.f2025a = r3;
        this.f2026b = r6;
        this.f2027c = r5;
    }

    public /* synthetic */ am(ao r2, b r3, androidx.lifecycle.a.a r4, int r5, d.h.b.h r6) {
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(androidx.lifecycle.a.a.C0057a.f1967a, androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
    L5:
        this(r2, r7, r4);
    }

    public am(ap r3) {
        ap r4 = (ap) ZeusTransformUtils.wrapperContextForParams(r3, ap.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "owner");
        this(r4.getViewModelStore(), a.f2028a.a(r4), an.a(r4));
    }

    public am(ap r3, b r4) {
        ap r5 = (ap) ZeusTransformUtils.wrapperContextForParams(r3, ap.class, "com.obric.aiagent.plugin");
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "owner");
        d.h.b.o.e(r6, "factory");
        this(r5.getViewModelStore(), r6, an.a(r5));
    }

    public <T extends aj> T a(Class<T> r4) {
        d.h.b.o.e(r4, "modelClass");
        String r0 = r4.getCanonicalName();
        if (r0 == null) goto L7;
        return (T) a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + r0, r4);
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public <T extends aj> T a(String r5, Class<T> r6) {
        d.h.b.o.e(r5, "key");
        d.h.b.o.e(r6, "modelClass");
        T r0 = (T) this.f2025a.a(r5);
        if (ZeusTransformUtils.instanceOf(r6, r0) == false) goto L12;
        b r4 = this.f2026b;
        if (ZeusTransformUtils.instanceOf(r4, d.class) == false) goto L7;
        d r7 = (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin");
    L8:
        if (r7 == null) goto L10;
        d.h.b.o.a(r0);
        r7.a(r0);
    L10:
        d.h.b.o.a(r0, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return r0;
    L7:
        r7 = null;
        goto L8
    L12:
        androidx.lifecycle.a.d r1 = new androidx.lifecycle.a.d(this.f2027c);
        r1.a(c.f2035e, r5);
        T r8 = (T) this.f2026b.a(r6, (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r1, androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin"));
    L16:
        this.f2025a.a(r5, r8);
        return r8;
    L15:
        r8 = (T) this.f2026b.a(r6);
        goto L16
    }
}
