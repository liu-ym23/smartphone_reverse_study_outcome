package x4;

import Z3.i;
import s4.G0;

/* renamed from: x4.J, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1298J {

    /* renamed from: a, reason: collision with root package name */
    public static final C1294F f23835a = new C1294F("NO_THREAD_ELEMENTS");

    /* renamed from: b, reason: collision with root package name */
    private static final i4.p<Object, i.b, Object> f23836b = a.f23839a;

    /* renamed from: c, reason: collision with root package name */
    private static final i4.p<G0<?>, i.b, G0<?>> f23837c = b.f23840a;

    /* renamed from: d, reason: collision with root package name */
    private static final i4.p<N, i.b, N> f23838d = c.f23841a;

    /* renamed from: x4.J$a */
    static final class a extends j4.l implements i4.p<Object, i.b, Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f23839a = new a();

        a() {
            super(2);
        }

        @Override // i4.p
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, i.b bVar) {
            if (!(bVar instanceof G0)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? bVar : Integer.valueOf(iIntValue + 1);
        }
    }

    /* renamed from: x4.J$b */
    static final class b extends j4.l implements i4.p<G0<?>, i.b, G0<?>> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f23840a = new b();

        b() {
            super(2);
        }

        @Override // i4.p
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final G0<?> invoke(G0<?> g02, i.b bVar) {
            if (g02 != null) {
                return g02;
            }
            if (bVar instanceof G0) {
                return (G0) bVar;
            }
            return null;
        }
    }

    /* renamed from: x4.J$c */
    static final class c extends j4.l implements i4.p<N, i.b, N> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f23841a = new c();

        c() {
            super(2);
        }

        @Override // i4.p
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final N invoke(N n5, i.b bVar) {
            if (bVar instanceof G0) {
                G0<?> g02 = (G0) bVar;
                n5.a(g02, g02.N(n5.f23844a));
            }
            return n5;
        }
    }

    public static final void a(Z3.i iVar, Object obj) {
        if (obj == f23835a) {
            return;
        }
        if (obj instanceof N) {
            ((N) obj).b(iVar);
            return;
        }
        Object objO = iVar.o(null, f23837c);
        j4.k.e(objO, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((G0) objO).V(iVar, obj);
    }

    public static final Object b(Z3.i iVar) {
        Object objO = iVar.o(0, f23836b);
        j4.k.d(objO);
        return objO;
    }

    public static final Object c(Z3.i iVar, Object obj) {
        if (obj == null) {
            obj = b(iVar);
        }
        if (obj == 0) {
            return f23835a;
        }
        if (obj instanceof Integer) {
            return iVar.o(new N(iVar, ((Number) obj).intValue()), f23838d);
        }
        j4.k.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((G0) obj).N(iVar);
    }
}
