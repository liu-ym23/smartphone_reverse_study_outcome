package x4;

import i4.InterfaceC0772l;
import s4.C1058G;

/* loaded from: classes.dex */
public final class x {

    static final class a extends j4.l implements InterfaceC0772l<Throwable, V3.v> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0772l<E, V3.v> f23889a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ E f23890b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Z3.i f23891c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(InterfaceC0772l<? super E, V3.v> interfaceC0772l, E e6, Z3.i iVar) {
            super(1);
            this.f23889a = interfaceC0772l;
            this.f23890b = e6;
            this.f23891c = iVar;
        }

        public final void b(Throwable th) {
            x.b(this.f23889a, this.f23890b, this.f23891c);
        }

        @Override // i4.InterfaceC0772l
        public /* bridge */ /* synthetic */ V3.v invoke(Throwable th) {
            b(th);
            return V3.v.f5542a;
        }
    }

    public static final <E> InterfaceC0772l<Throwable, V3.v> a(InterfaceC0772l<? super E, V3.v> interfaceC0772l, E e6, Z3.i iVar) {
        return new a(interfaceC0772l, e6, iVar);
    }

    public static final <E> void b(InterfaceC0772l<? super E, V3.v> interfaceC0772l, E e6, Z3.i iVar) {
        O oC = c(interfaceC0772l, e6, null);
        if (oC != null) {
            C1058G.a(iVar, oC);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> O c(InterfaceC0772l<? super E, V3.v> interfaceC0772l, E e6, O o5) {
        try {
            interfaceC0772l.invoke(e6);
            return o5;
        } catch (Throwable th) {
            if (o5 != null && o5.getCause() != th) {
                V3.a.a(o5, th);
                return o5;
            }
            return new O("Exception in undelivered element handler for " + e6, th);
        }
    }

    public static /* synthetic */ O d(InterfaceC0772l interfaceC0772l, Object obj, O o5, int i5, Object obj2) {
        if ((i5 & 2) != 0) {
            o5 = null;
        }
        return c(interfaceC0772l, obj, o5);
    }
}
