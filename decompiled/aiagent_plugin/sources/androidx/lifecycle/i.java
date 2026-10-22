package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: Lifecycle.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicReference<Object> f2051a;

    /* JADX INFO: compiled from: Lifecycle.kt */
    public static final enum a extends Enum<a> {
        private static final /* synthetic */ a[] $VALUES = null;
        public static final C0062a Companion = null;
        public static final a ON_ANY = null;
        public static final a ON_CREATE = null;
        public static final a ON_DESTROY = null;
        public static final a ON_PAUSE = null;
        public static final a ON_RESUME = null;
        public static final a ON_START = null;
        public static final a ON_STOP = null;

        /* JADX INFO: renamed from: androidx.lifecycle.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Lifecycle.kt */
        public static final class C0062a {

            /* JADX INFO: renamed from: androidx.lifecycle.i$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: Lifecycle.kt */
            public /* synthetic */ class C0063a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f2052a = null;

                static {
                    int[] r0 = new int[b.values().length];
                    r0[b.f2056c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
                L15:
                    r0[b.f2057d.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
                L23:
                    r0[b.f2058e.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
                L17:
                    r0[b.f2054a.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
                L19:
                    r0[b.f2055b.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
                L8:
                    f2052a = r0;
                }
            }

            public /* synthetic */ C0062a(d.h.b.h r1) {
                this();
            }

            private C0062a() {
            }

            public final a a(b r1) {
                d.h.b.o.e(r1, "state");
                int r0 = C0063a.f2052a[r1.ordinal()];
                if (r0 == 1) goto L12;
                if (r0 == 2) goto L15;
                if (r0 == 3) goto L14;
                return null;
            L14:
                return a.ON_PAUSE;
            L15:
                return a.ON_STOP;
            L12:
                return a.ON_DESTROY;
            }

            public final a b(b r1) {
                d.h.b.o.e(r1, "state");
                int r0 = C0063a.f2052a[r1.ordinal()];
                if (r0 == 1) goto L12;
                if (r0 == 2) goto L15;
                if (r0 == 5) goto L14;
                return null;
            L14:
                return a.ON_CREATE;
            L15:
                return a.ON_RESUME;
            L12:
                return a.ON_START;
            }

            public final a c(b r1) {
                d.h.b.o.e(r1, "state");
                int r0 = C0063a.f2052a[r1.ordinal()];
                if (r0 == 1) goto L12;
                if (r0 == 2) goto L15;
                if (r0 == 3) goto L14;
                return null;
            L14:
                return a.ON_RESUME;
            L15:
                return a.ON_START;
            L12:
                return a.ON_CREATE;
            }
        }

        /* JADX INFO: compiled from: Lifecycle.kt */
        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f2053a = null;

            static {
                int[] r0 = new int[a.values().length];
                r0[a.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
            L21:
                r0[a.ON_STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            L31:
                r0[a.ON_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
            L23:
                r0[a.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
            L25:
                r0[a.ON_RESUME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
            L19:
                r0[a.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
            L27:
                r0[a.ON_ANY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
            L10:
                f2053a = r0;
            }
        }

        public static final a a(b r1) {
            return Companion.a(r1);
        }

        public static final a b(b r1) {
            return Companion.c(r1);
        }

        private static final /* synthetic */ a[] b() {
            return new a[]{ON_CREATE, ON_START, ON_RESUME, ON_PAUSE, ON_STOP, ON_DESTROY, ON_ANY};
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            ON_CREATE = new a("ON_CREATE", 0);
            ON_START = new a("ON_START", 1);
            ON_RESUME = new a("ON_RESUME", 2);
            ON_PAUSE = new a("ON_PAUSE", 3);
            ON_STOP = new a("ON_STOP", 4);
            ON_DESTROY = new a("ON_DESTROY", 5);
            ON_ANY = new a("ON_ANY", 6);
            $VALUES = b();
            Companion = new C0062a(null);
        }

        public final b a() {
            switch(b.f2053a[ordinal()]) {
                case 1: goto L13;
                case 2: goto L13;
                case 3: goto L11;
                case 4: goto L11;
                case 5: goto L9;
                case 6: goto L7;
                default: goto L5;
            };
        L5:
            throw new IllegalArgumentException(this + " has no target state");
        L7:
            return b.f2054a;
        L9:
            return b.f2058e;
        L11:
            return b.f2057d;
        L13:
            return b.f2056c;
        }
    }

    /* JADX INFO: compiled from: Lifecycle.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f2054a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f2055b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f2056c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f2057d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f2058e = null;
        private static final /* synthetic */ b[] f = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f2054a, f2055b, f2056c, f2057d, f2058e};
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f2054a = new b("DESTROYED", 0);
            f2055b = new b("INITIALIZED", 1);
            f2056c = new b("CREATED", 2);
            f2057d = new b("STARTED", 3);
            f2058e = new b("RESUMED", 4);
            f = a();
        }

        public final boolean a(b r3) {
            d.h.b.o.e(r3, "state");
            if (compareTo((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.aiagent.plugin")) < 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public abstract void a(o r1);

    public abstract b b();

    public abstract void b(o r1);

    public i() {
        this.f2051a = new AtomicReference();
    }

    public final AtomicReference<Object> a() {
        return this.f2051a;
    }
}
