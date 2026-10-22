package s4;

import Z3.f;
import Z3.i;
import i4.InterfaceC0772l;
import x4.C1310j;
import x4.C1313m;
import x4.C1314n;

/* renamed from: s4.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1056E extends Z3.a implements Z3.f {

    /* renamed from: b, reason: collision with root package name */
    public static final a f20298b = new a(null);

    /* renamed from: s4.E$a */
    public static final class a extends Z3.b<Z3.f, AbstractC1056E> {

        /* renamed from: s4.E$a$a, reason: collision with other inner class name */
        static final class C0237a extends j4.l implements InterfaceC0772l<i.b, AbstractC1056E> {

            /* renamed from: a, reason: collision with root package name */
            public static final C0237a f20299a = new C0237a();

            C0237a() {
                super(1);
            }

            @Override // i4.InterfaceC0772l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final AbstractC1056E invoke(i.b bVar) {
                if (bVar instanceof AbstractC1056E) {
                    return (AbstractC1056E) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        private a() {
            super(Z3.f.f6654N, C0237a.f20299a);
        }
    }

    public AbstractC1056E() {
        super(Z3.f.f6654N);
    }

    @Override // Z3.f
    public final void D(Z3.e<?> eVar) {
        j4.k.e(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((C1310j) eVar).s();
    }

    @Override // Z3.f
    public final <T> Z3.e<T> S(Z3.e<? super T> eVar) {
        return new C1310j(this, eVar);
    }

    @Override // Z3.a, Z3.i
    public Z3.i W(i.c<?> cVar) {
        return f.a.b(this, cVar);
    }

    public abstract void Y(Z3.i iVar, Runnable runnable);

    @Override // Z3.a, Z3.i.b, Z3.i
    public <E extends i.b> E a(i.c<E> cVar) {
        return (E) f.a.a(this, cVar);
    }

    public boolean c0(Z3.i iVar) {
        return true;
    }

    public AbstractC1056E d0(int i5) {
        C1314n.a(i5);
        return new C1313m(this, i5);
    }

    public String toString() {
        return M.a(this) + '@' + M.b(this);
    }
}
