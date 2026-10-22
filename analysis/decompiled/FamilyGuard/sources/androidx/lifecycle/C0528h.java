package androidx.lifecycle;

import androidx.lifecycle.AbstractC0533m;

/* renamed from: androidx.lifecycle.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0528h implements InterfaceC0537q {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0527g f10873a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0537q f10874b;

    /* renamed from: androidx.lifecycle.h$a */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10875a;

        static {
            int[] iArr = new int[AbstractC0533m.a.values().length];
            try {
                iArr[AbstractC0533m.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AbstractC0533m.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AbstractC0533m.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AbstractC0533m.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AbstractC0533m.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AbstractC0533m.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AbstractC0533m.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f10875a = iArr;
        }
    }

    public C0528h(InterfaceC0527g interfaceC0527g, InterfaceC0537q interfaceC0537q) {
        j4.k.g(interfaceC0527g, "defaultLifecycleObserver");
        this.f10873a = interfaceC0527g;
        this.f10874b = interfaceC0537q;
    }

    @Override // androidx.lifecycle.InterfaceC0537q
    public void f(InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar) {
        j4.k.g(interfaceC0539t, "source");
        j4.k.g(aVar, "event");
        switch (a.f10875a[aVar.ordinal()]) {
            case 1:
                this.f10873a.c(interfaceC0539t);
                break;
            case 2:
                this.f10873a.u(interfaceC0539t);
                break;
            case 3:
                this.f10873a.a(interfaceC0539t);
                break;
            case 4:
                this.f10873a.m(interfaceC0539t);
                break;
            case 5:
                this.f10873a.o(interfaceC0539t);
                break;
            case 6:
                this.f10873a.r(interfaceC0539t);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        InterfaceC0537q interfaceC0537q = this.f10874b;
        if (interfaceC0537q != null) {
            interfaceC0537q.f(interfaceC0539t, aVar);
        }
    }
}
