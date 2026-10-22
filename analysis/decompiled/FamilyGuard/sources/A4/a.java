package A4;

import V3.v;
import W3.C0403n;
import Z3.i;
import i4.InterfaceC0772l;
import i4.q;
import j4.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s4.InterfaceC1078j;
import s4.InterfaceC1080k;
import s4.L0;
import s4.X;
import x4.AbstractC1291C;

/* loaded from: classes.dex */
public class a<R> implements InterfaceC1078j, b, L0 {

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f166f = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "state$volatile");

    /* renamed from: a, reason: collision with root package name */
    private final i f167a;

    /* renamed from: b, reason: collision with root package name */
    private List<a<R>.C0002a> f168b;

    /* renamed from: c, reason: collision with root package name */
    private Object f169c;

    /* renamed from: d, reason: collision with root package name */
    private int f170d;

    /* renamed from: e, reason: collision with root package name */
    private Object f171e;
    private volatile /* synthetic */ Object state$volatile;

    /* renamed from: A4.a$a, reason: collision with other inner class name */
    public final class C0002a {

        /* renamed from: a, reason: collision with root package name */
        public final Object f172a;

        /* renamed from: b, reason: collision with root package name */
        private final Object f173b;

        /* renamed from: c, reason: collision with root package name */
        public final q<b<?>, Object, Object, InterfaceC0772l<Throwable, v>> f174c;

        /* renamed from: d, reason: collision with root package name */
        public Object f175d;

        /* renamed from: e, reason: collision with root package name */
        public int f176e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ a<R> f177f;

        public final InterfaceC0772l<Throwable, v> a(b<?> bVar, Object obj) {
            q<b<?>, Object, Object, InterfaceC0772l<Throwable, v>> qVar = this.f174c;
            if (qVar != null) {
                return qVar.a(bVar, this.f173b, obj);
            }
            return null;
        }

        public final void b() {
            Object obj = this.f175d;
            a<R> aVar = this.f177f;
            if (obj instanceof AbstractC1291C) {
                ((AbstractC1291C) obj).s(this.f176e, null, aVar.getContext());
                return;
            }
            X x5 = obj instanceof X ? (X) obj : null;
            if (x5 != null) {
                x5.dispose();
            }
        }
    }

    private final a<R>.C0002a e(Object obj) {
        List<a<R>.C0002a> list = this.f168b;
        Object obj2 = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((C0002a) next).f172a == obj) {
                obj2 = next;
                break;
            }
        }
        a<R>.C0002a c0002a = (C0002a) obj2;
        if (c0002a != null) {
            return c0002a;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    private final int h(Object obj, Object obj2) {
        while (true) {
            Object obj3 = f166f.get(this);
            if (obj3 instanceof InterfaceC1080k) {
                a<R>.C0002a c0002aE = e(obj);
                if (c0002aE == null) {
                    continue;
                } else {
                    InterfaceC0772l<Throwable, v> interfaceC0772lA = c0002aE.a(this, obj2);
                    if (f166f.compareAndSet(this, obj3, c0002aE)) {
                        this.f171e = obj2;
                        if (c.h((InterfaceC1080k) obj3, interfaceC0772lA)) {
                            return 0;
                        }
                        this.f171e = c.f182e;
                        return 2;
                    }
                }
            } else {
                if (k.b(obj3, c.f180c) ? true : obj3 instanceof C0002a) {
                    return 3;
                }
                if (k.b(obj3, c.f181d)) {
                    return 2;
                }
                if (k.b(obj3, c.f179b)) {
                    if (f166f.compareAndSet(this, obj3, C0403n.b(obj))) {
                        return 1;
                    }
                } else {
                    if (!(obj3 instanceof List)) {
                        throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                    }
                    if (f166f.compareAndSet(this, obj3, C0403n.N((Collection) obj3, obj))) {
                        return 1;
                    }
                }
            }
        }
    }

    @Override // s4.InterfaceC1078j
    public void a(Throwable th) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f166f;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == c.f180c) {
                return;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c.f181d));
        List<a<R>.C0002a> list = this.f168b;
        if (list == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((C0002a) it.next()).b();
        }
        this.f171e = c.f182e;
        this.f168b = null;
    }

    @Override // A4.b
    public boolean b(Object obj, Object obj2) {
        return h(obj, obj2) == 0;
    }

    @Override // s4.L0
    public void c(AbstractC1291C<?> abstractC1291C, int i5) {
        this.f169c = abstractC1291C;
        this.f170d = i5;
    }

    @Override // A4.b
    public void d(Object obj) {
        this.f171e = obj;
    }

    public final d g(Object obj, Object obj2) {
        return c.a(h(obj, obj2));
    }

    @Override // A4.b
    public i getContext() {
        return this.f167a;
    }
}
