package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: androidx.lifecycle.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0533m {

    /* renamed from: a, reason: collision with root package name */
    private AtomicReference<Object> f10879a = new AtomicReference<>(null);

    /* renamed from: androidx.lifecycle.m$a */
    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static final C0137a Companion = new C0137a(null);

        /* renamed from: androidx.lifecycle.m$a$a, reason: collision with other inner class name */
        public static final class C0137a {

            /* renamed from: androidx.lifecycle.m$a$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0138a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f10880a;

                static {
                    int[] iArr = new int[b.values().length];
                    try {
                        iArr[b.CREATED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[b.STARTED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[b.RESUMED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[b.DESTROYED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[b.INITIALIZED.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    f10880a = iArr;
                }
            }

            public /* synthetic */ C0137a(j4.g gVar) {
                this();
            }

            public final a a(b bVar) {
                j4.k.g(bVar, "state");
                int i5 = C0138a.f10880a[bVar.ordinal()];
                if (i5 == 1) {
                    return a.ON_DESTROY;
                }
                if (i5 == 2) {
                    return a.ON_STOP;
                }
                if (i5 != 3) {
                    return null;
                }
                return a.ON_PAUSE;
            }

            public final a b(b bVar) {
                j4.k.g(bVar, "state");
                int i5 = C0138a.f10880a[bVar.ordinal()];
                if (i5 == 1) {
                    return a.ON_START;
                }
                if (i5 == 2) {
                    return a.ON_RESUME;
                }
                if (i5 != 5) {
                    return null;
                }
                return a.ON_CREATE;
            }

            public final a c(b bVar) {
                j4.k.g(bVar, "state");
                int i5 = C0138a.f10880a[bVar.ordinal()];
                if (i5 == 1) {
                    return a.ON_CREATE;
                }
                if (i5 == 2) {
                    return a.ON_START;
                }
                if (i5 != 3) {
                    return null;
                }
                return a.ON_RESUME;
            }

            private C0137a() {
            }
        }

        /* renamed from: androidx.lifecycle.m$a$b */
        public /* synthetic */ class b {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f10881a;

            static {
                int[] iArr = new int[a.values().length];
                try {
                    iArr[a.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[a.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[a.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[a.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[a.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[a.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[a.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f10881a = iArr;
            }
        }

        public static final a d(b bVar) {
            return Companion.a(bVar);
        }

        public static final a g(b bVar) {
            return Companion.c(bVar);
        }

        public final b e() {
            switch (b.f10881a[ordinal()]) {
                case 1:
                case 2:
                    return b.CREATED;
                case 3:
                case 4:
                    return b.STARTED;
                case 5:
                    return b.RESUMED;
                case 6:
                    return b.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* renamed from: androidx.lifecycle.m$b */
    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public final boolean d(b bVar) {
            j4.k.g(bVar, "state");
            return compareTo(bVar) >= 0;
        }
    }

    public abstract void a(InterfaceC0538s interfaceC0538s);

    public abstract b b();

    public final AtomicReference<Object> c() {
        return this.f10879a;
    }

    public abstract void d(InterfaceC0538s interfaceC0538s);
}
