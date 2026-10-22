package z7;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class b extends q7.m implements p7.k {

    /* renamed from: h, reason: collision with root package name */
    public static final b f11835h;

    /* renamed from: i, reason: collision with root package name */
    public static final b f11836i;

    /* renamed from: j, reason: collision with root package name */
    public static final b f11837j;

    /* renamed from: k, reason: collision with root package name */
    public static final b f11838k;

    /* renamed from: l, reason: collision with root package name */
    public static final b f11839l;

    /* renamed from: m, reason: collision with root package name */
    public static final b f11840m;

    /* renamed from: n, reason: collision with root package name */
    public static final b f11841n;

    /* renamed from: o, reason: collision with root package name */
    public static final b f11842o;

    /* renamed from: p, reason: collision with root package name */
    public static final b f11843p;

    /* renamed from: q, reason: collision with root package name */
    public static final b f11844q;

    /* renamed from: r, reason: collision with root package name */
    public static final b f11845r;

    /* renamed from: s, reason: collision with root package name */
    public static final b f11846s;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f11847g;

    static {
        int i2 = 1;
        f11835h = new b(i2, 0);
        f11836i = new b(i2, 1);
        f11837j = new b(i2, 2);
        f11838k = new b(i2, 3);
        f11839l = new b(i2, 4);
        f11840m = new b(i2, 5);
        f11841n = new b(i2, 6);
        f11842o = new b(i2, 7);
        f11843p = new b(i2, 8);
        f11844q = new b(i2, 9);
        f11845r = new b(i2, 10);
        f11846s = new b(i2, 11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i2, int i10) {
        super(i2);
        this.f11847g = i10;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        int i2 = this.f11847g;
        d7.z zVar = d7.z.f2978f;
        switch (i2) {
            case 0:
                Class cls = (Class) obj;
                q7.k.e(cls, "it");
                return n7.o.h(c.a(cls), zVar, false, zVar);
            case 1:
                q7.k.e((Class) obj, "it");
                return new ConcurrentHashMap();
            case 2:
                Class cls2 = (Class) obj;
                q7.k.e(cls2, "it");
                return n7.o.h(c.a(cls2), zVar, true, zVar);
            case 3:
                Class cls3 = (Class) obj;
                q7.k.e(cls3, "it");
                return new a0(cls3);
            case 4:
                Class cls4 = (Class) obj;
                q7.k.e(cls4, "it");
                return new s0(cls4);
            case 5:
                Class<?> returnType = ((Method) obj).getReturnType();
                q7.k.d(returnType, "it.returnType");
                return l8.d.b(returnType);
            case 6:
                Class cls5 = (Class) obj;
                q7.k.d(cls5, "it");
                return l8.d.b(cls5);
            case 7:
                f8.t tVar = (f8.t) obj;
                q7.k.e(tVar, "descriptor");
                return g9.g.f3941e.x(tVar) + " | " + v1.c(tVar).f();
            case 8:
                f8.l0 l0Var = (f8.l0) obj;
                q7.k.e(l0Var, "descriptor");
                return g9.g.f3941e.x(l0Var) + " | " + v1.b(l0Var).f();
            case 9:
                g9.g gVar = u1.f11967a;
                v9.v type = ((i8.r0) obj).getType();
                q7.k.d(type, "it.type");
                return u1.d(type);
            case 10:
                g9.g gVar2 = u1.f11967a;
                v9.v type2 = ((i8.r0) obj).getType();
                q7.k.d(type2, "it.type");
                return u1.d(type2);
            default:
                Class cls6 = (Class) obj;
                q7.k.d(cls6, "it");
                return l8.d.b(cls6);
        }
    }
}
