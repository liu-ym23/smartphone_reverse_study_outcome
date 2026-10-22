package B4;

import V3.v;
import Z3.i;
import a4.C0428b;
import i4.InterfaceC0772l;
import i4.q;
import j4.l;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.h;
import s4.AbstractC1056E;
import s4.C1082l;
import s4.C1086n;
import s4.InterfaceC1080k;
import s4.L0;
import s4.M;
import x4.AbstractC1291C;

/* loaded from: classes.dex */
public class b extends d implements B4.a {

    /* renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f213i = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "owner$volatile");

    /* renamed from: h, reason: collision with root package name */
    private final q<A4.b<?>, Object, Object, InterfaceC0772l<Throwable, v>> f214h;
    private volatile /* synthetic */ Object owner$volatile;

    private final class a implements InterfaceC1080k<v>, L0 {

        /* renamed from: a, reason: collision with root package name */
        public final C1082l<v> f215a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f216b;

        /* renamed from: B4.b$a$a, reason: collision with other inner class name */
        static final class C0004a extends l implements InterfaceC0772l<Throwable, v> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f218a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f219b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0004a(b bVar, a aVar) {
                super(1);
                this.f218a = bVar;
                this.f219b = aVar;
            }

            public final void b(Throwable th) {
                this.f218a.a(this.f219b.f216b);
            }

            @Override // i4.InterfaceC0772l
            public /* bridge */ /* synthetic */ v invoke(Throwable th) {
                b(th);
                return v.f5542a;
            }
        }

        /* renamed from: B4.b$a$b, reason: collision with other inner class name */
        static final class C0005b extends l implements InterfaceC0772l<Throwable, v> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f220a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f221b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0005b(b bVar, a aVar) {
                super(1);
                this.f220a = bVar;
                this.f221b = aVar;
            }

            public final void b(Throwable th) {
                b.r().set(this.f220a, this.f221b.f216b);
                this.f220a.a(this.f221b.f216b);
            }

            @Override // i4.InterfaceC0772l
            public /* bridge */ /* synthetic */ v invoke(Throwable th) {
                b(th);
                return v.f5542a;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(C1082l<? super v> c1082l, Object obj) {
            this.f215a = c1082l;
            this.f216b = obj;
        }

        @Override // s4.InterfaceC1080k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(v vVar, InterfaceC0772l<? super Throwable, v> interfaceC0772l) {
            b.r().set(b.this, this.f216b);
            this.f215a.b(vVar, new C0004a(b.this, this));
        }

        @Override // s4.L0
        public void c(AbstractC1291C<?> abstractC1291C, int i5) {
            this.f215a.c(abstractC1291C, i5);
        }

        @Override // s4.InterfaceC1080k
        public void f(InterfaceC0772l<? super Throwable, v> interfaceC0772l) {
            this.f215a.f(interfaceC0772l);
        }

        @Override // s4.InterfaceC1080k
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void d(AbstractC1056E abstractC1056E, v vVar) {
            this.f215a.d(abstractC1056E, vVar);
        }

        @Override // Z3.e
        public i getContext() {
            return this.f215a.getContext();
        }

        @Override // s4.InterfaceC1080k
        public void h(Object obj) {
            this.f215a.h(obj);
        }

        @Override // s4.InterfaceC1080k
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object e(v vVar, Object obj, InterfaceC0772l<? super Throwable, v> interfaceC0772l) {
            Object objE = this.f215a.e(vVar, obj, new C0005b(b.this, this));
            if (objE != null) {
                b.r().set(b.this, this.f216b);
            }
            return objE;
        }

        @Override // Z3.e
        public void resumeWith(Object obj) {
            this.f215a.resumeWith(obj);
        }
    }

    /* renamed from: B4.b$b, reason: collision with other inner class name */
    static final class C0006b extends l implements q<A4.b<?>, Object, Object, InterfaceC0772l<? super Throwable, ? extends v>> {

        /* renamed from: B4.b$b$a */
        static final class a extends l implements InterfaceC0772l<Throwable, v> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f223a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Object f224b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(b bVar, Object obj) {
                super(1);
                this.f223a = bVar;
                this.f224b = obj;
            }

            public final void b(Throwable th) {
                this.f223a.a(this.f224b);
            }

            @Override // i4.InterfaceC0772l
            public /* bridge */ /* synthetic */ v invoke(Throwable th) {
                b(th);
                return v.f5542a;
            }
        }

        C0006b() {
            super(3);
        }

        @Override // i4.q
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final InterfaceC0772l<Throwable, v> a(A4.b<?> bVar, Object obj, Object obj2) {
            return new a(b.this, obj);
        }
    }

    public b(boolean z5) {
        super(1, z5 ? 1 : 0);
        this.owner$volatile = z5 ? null : c.f225a;
        this.f214h = new C0006b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater r() {
        return f213i;
    }

    private final int s(Object obj) {
        while (t()) {
            Object obj2 = f213i.get(this);
            if (obj2 != c.f225a) {
                return obj2 == obj ? 1 : 2;
            }
        }
        return 0;
    }

    static /* synthetic */ Object u(b bVar, Object obj, Z3.e<? super v> eVar) {
        Object objV;
        return (!bVar.w(obj) && (objV = bVar.v(obj, eVar)) == C0428b.e()) ? objV : v.f5542a;
    }

    private final Object v(Object obj, Z3.e<? super v> eVar) {
        C1082l c1082lB = C1086n.b(C0428b.c(eVar));
        try {
            c(new a(c1082lB, obj));
            Object objX = c1082lB.x();
            if (objX == C0428b.e()) {
                h.c(eVar);
            }
            return objX == C0428b.e() ? objX : v.f5542a;
        } catch (Throwable th) {
            c1082lB.M();
            throw th;
        }
    }

    private final int x(Object obj) {
        while (!n()) {
            if (obj == null) {
                return 1;
            }
            int iS = s(obj);
            if (iS == 1) {
                return 2;
            }
            if (iS == 2) {
                return 1;
            }
        }
        f213i.set(this, obj);
        return 0;
    }

    @Override // B4.a
    public void a(Object obj) {
        while (t()) {
            Object obj2 = f213i.get(this);
            if (obj2 != c.f225a) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                if (f213i.compareAndSet(this, obj2, c.f225a)) {
                    m();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    @Override // B4.a
    public Object b(Object obj, Z3.e<? super v> eVar) {
        return u(this, obj, eVar);
    }

    public boolean t() {
        return g() == 0;
    }

    public String toString() {
        return "Mutex@" + M.b(this) + "[isLocked=" + t() + ",owner=" + f213i.get(this) + ']';
    }

    public boolean w(Object obj) {
        int iX = x(obj);
        if (iX == 0) {
            return true;
        }
        if (iX == 1) {
            return false;
        }
        if (iX != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }
}
