package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f implements o {

    /* renamed from: a, reason: collision with root package name */
    public final e f2265a;

    /* renamed from: b, reason: collision with root package name */
    public final o f2266b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2267a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f2267a = iArr;
        }
    }

    public f(e defaultLifecycleObserver, o oVar) {
        kotlin.jvm.internal.g.f(defaultLifecycleObserver, "defaultLifecycleObserver");
        this.f2265a = defaultLifecycleObserver;
        this.f2266b = oVar;
    }

    @Override // androidx.lifecycle.o
    public final void a(q qVar, Lifecycle.Event event) {
        int i10 = a.f2267a[event.ordinal()];
        e eVar = this.f2265a;
        switch (i10) {
            case 1:
                eVar.getClass();
                break;
            case 2:
                eVar.C(qVar);
                break;
            case 3:
                eVar.o(qVar);
                break;
            case 4:
                eVar.getClass();
                break;
            case 5:
                eVar.w(qVar);
                break;
            case 6:
                eVar.getClass();
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                throw new NoWhenBranchMatchedException();
        }
        o oVar = this.f2266b;
        if (oVar != null) {
            oVar.a(qVar, event);
        }
    }
}
