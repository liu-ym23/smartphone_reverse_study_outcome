package androidx.lifecycle;

import androidx.lifecycle.AbstractC0533m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import n.C0869a;
import n.C0870b;

/* renamed from: androidx.lifecycle.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0541v extends AbstractC0533m {

    /* renamed from: k, reason: collision with root package name */
    public static final a f10895k = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final boolean f10896b;

    /* renamed from: c, reason: collision with root package name */
    private C0869a<InterfaceC0538s, b> f10897c;

    /* renamed from: d, reason: collision with root package name */
    private AbstractC0533m.b f10898d;

    /* renamed from: e, reason: collision with root package name */
    private final WeakReference<InterfaceC0539t> f10899e;

    /* renamed from: f, reason: collision with root package name */
    private int f10900f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f10901g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f10902h;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<AbstractC0533m.b> f10903i;

    /* renamed from: j, reason: collision with root package name */
    private final v4.j<AbstractC0533m.b> f10904j;

    /* renamed from: androidx.lifecycle.v$a */
    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        public final AbstractC0533m.b a(AbstractC0533m.b bVar, AbstractC0533m.b bVar2) {
            j4.k.g(bVar, "state1");
            return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
        }

        private a() {
        }
    }

    /* renamed from: androidx.lifecycle.v$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private AbstractC0533m.b f10905a;

        /* renamed from: b, reason: collision with root package name */
        private InterfaceC0537q f10906b;

        public b(InterfaceC0538s interfaceC0538s, AbstractC0533m.b bVar) {
            j4.k.g(bVar, "initialState");
            j4.k.d(interfaceC0538s);
            this.f10906b = C0544y.f(interfaceC0538s);
            this.f10905a = bVar;
        }

        public final void a(InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar) {
            j4.k.g(aVar, "event");
            AbstractC0533m.b bVarE = aVar.e();
            this.f10905a = C0541v.f10895k.a(this.f10905a, bVarE);
            InterfaceC0537q interfaceC0537q = this.f10906b;
            j4.k.d(interfaceC0539t);
            interfaceC0537q.f(interfaceC0539t, aVar);
            this.f10905a = bVarE;
        }

        public final AbstractC0533m.b b() {
            return this.f10905a;
        }
    }

    private C0541v(InterfaceC0539t interfaceC0539t, boolean z5) {
        this.f10896b = z5;
        this.f10897c = new C0869a<>();
        AbstractC0533m.b bVar = AbstractC0533m.b.INITIALIZED;
        this.f10898d = bVar;
        this.f10903i = new ArrayList<>();
        this.f10899e = new WeakReference<>(interfaceC0539t);
        this.f10904j = v4.m.a(bVar);
    }

    private final void e(InterfaceC0539t interfaceC0539t) {
        Iterator<Map.Entry<InterfaceC0538s, b>> itDescendingIterator = this.f10897c.descendingIterator();
        j4.k.f(itDescendingIterator, "observerMap.descendingIterator()");
        while (itDescendingIterator.hasNext() && !this.f10902h) {
            Map.Entry<InterfaceC0538s, b> next = itDescendingIterator.next();
            j4.k.f(next, "next()");
            InterfaceC0538s key = next.getKey();
            b value = next.getValue();
            while (value.b().compareTo(this.f10898d) > 0 && !this.f10902h && this.f10897c.contains(key)) {
                AbstractC0533m.a aVarA = AbstractC0533m.a.Companion.a(value.b());
                if (aVarA == null) {
                    throw new IllegalStateException("no event down from " + value.b());
                }
                m(aVarA.e());
                value.a(interfaceC0539t, aVarA);
                l();
            }
        }
    }

    private final AbstractC0533m.b f(InterfaceC0538s interfaceC0538s) {
        b value;
        Map.Entry<InterfaceC0538s, b> entryO = this.f10897c.o(interfaceC0538s);
        AbstractC0533m.b bVar = null;
        AbstractC0533m.b bVarB = (entryO == null || (value = entryO.getValue()) == null) ? null : value.b();
        if (!this.f10903i.isEmpty()) {
            bVar = this.f10903i.get(r0.size() - 1);
        }
        a aVar = f10895k;
        return aVar.a(aVar.a(this.f10898d, bVarB), bVar);
    }

    private final void g(String str) {
        if (!this.f10896b || C0543x.a()) {
            return;
        }
        throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
    }

    private final void h(InterfaceC0539t interfaceC0539t) {
        C0870b<InterfaceC0538s, b>.d dVarF = this.f10897c.f();
        j4.k.f(dVarF, "observerMap.iteratorWithAdditions()");
        while (dVarF.hasNext() && !this.f10902h) {
            Map.Entry next = dVarF.next();
            InterfaceC0538s interfaceC0538s = (InterfaceC0538s) next.getKey();
            b bVar = (b) next.getValue();
            while (bVar.b().compareTo(this.f10898d) < 0 && !this.f10902h && this.f10897c.contains(interfaceC0538s)) {
                m(bVar.b());
                AbstractC0533m.a aVarB = AbstractC0533m.a.Companion.b(bVar.b());
                if (aVarB == null) {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
                bVar.a(interfaceC0539t, aVarB);
                l();
            }
        }
    }

    private final boolean j() {
        if (this.f10897c.size() == 0) {
            return true;
        }
        Map.Entry<InterfaceC0538s, b> entryA = this.f10897c.a();
        j4.k.d(entryA);
        AbstractC0533m.b bVarB = entryA.getValue().b();
        Map.Entry<InterfaceC0538s, b> entryH = this.f10897c.h();
        j4.k.d(entryH);
        AbstractC0533m.b bVarB2 = entryH.getValue().b();
        return bVarB == bVarB2 && this.f10898d == bVarB2;
    }

    private final void k(AbstractC0533m.b bVar) {
        AbstractC0533m.b bVar2 = this.f10898d;
        if (bVar2 == bVar) {
            return;
        }
        if (bVar2 == AbstractC0533m.b.INITIALIZED && bVar == AbstractC0533m.b.DESTROYED) {
            throw new IllegalStateException(("State must be at least CREATED to move to " + bVar + ", but was " + this.f10898d + " in component " + this.f10899e.get()).toString());
        }
        this.f10898d = bVar;
        if (this.f10901g || this.f10900f != 0) {
            this.f10902h = true;
            return;
        }
        this.f10901g = true;
        o();
        this.f10901g = false;
        if (this.f10898d == AbstractC0533m.b.DESTROYED) {
            this.f10897c = new C0869a<>();
        }
    }

    private final void l() {
        this.f10903i.remove(r1.size() - 1);
    }

    private final void m(AbstractC0533m.b bVar) {
        this.f10903i.add(bVar);
    }

    private final void o() {
        InterfaceC0539t interfaceC0539t = this.f10899e.get();
        if (interfaceC0539t == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (!j()) {
            this.f10902h = false;
            AbstractC0533m.b bVar = this.f10898d;
            Map.Entry<InterfaceC0538s, b> entryA = this.f10897c.a();
            j4.k.d(entryA);
            if (bVar.compareTo(entryA.getValue().b()) < 0) {
                e(interfaceC0539t);
            }
            Map.Entry<InterfaceC0538s, b> entryH = this.f10897c.h();
            if (!this.f10902h && entryH != null && this.f10898d.compareTo(entryH.getValue().b()) > 0) {
                h(interfaceC0539t);
            }
        }
        this.f10902h = false;
        this.f10904j.setValue(b());
    }

    @Override // androidx.lifecycle.AbstractC0533m
    public void a(InterfaceC0538s interfaceC0538s) {
        InterfaceC0539t interfaceC0539t;
        j4.k.g(interfaceC0538s, "observer");
        g("addObserver");
        AbstractC0533m.b bVar = this.f10898d;
        AbstractC0533m.b bVar2 = AbstractC0533m.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = AbstractC0533m.b.INITIALIZED;
        }
        b bVar3 = new b(interfaceC0538s, bVar2);
        if (this.f10897c.m(interfaceC0538s, bVar3) == null && (interfaceC0539t = this.f10899e.get()) != null) {
            boolean z5 = this.f10900f != 0 || this.f10901g;
            AbstractC0533m.b bVarF = f(interfaceC0538s);
            this.f10900f++;
            while (bVar3.b().compareTo(bVarF) < 0 && this.f10897c.contains(interfaceC0538s)) {
                m(bVar3.b());
                AbstractC0533m.a aVarB = AbstractC0533m.a.Companion.b(bVar3.b());
                if (aVarB == null) {
                    throw new IllegalStateException("no event up from " + bVar3.b());
                }
                bVar3.a(interfaceC0539t, aVarB);
                l();
                bVarF = f(interfaceC0538s);
            }
            if (!z5) {
                o();
            }
            this.f10900f--;
        }
    }

    @Override // androidx.lifecycle.AbstractC0533m
    public AbstractC0533m.b b() {
        return this.f10898d;
    }

    @Override // androidx.lifecycle.AbstractC0533m
    public void d(InterfaceC0538s interfaceC0538s) {
        j4.k.g(interfaceC0538s, "observer");
        g("removeObserver");
        this.f10897c.n(interfaceC0538s);
    }

    public void i(AbstractC0533m.a aVar) {
        j4.k.g(aVar, "event");
        g("handleLifecycleEvent");
        k(aVar.e());
    }

    public void n(AbstractC0533m.b bVar) {
        j4.k.g(bVar, "state");
        g("setCurrentState");
        k(bVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0541v(InterfaceC0539t interfaceC0539t) {
        this(interfaceC0539t, true);
        j4.k.g(interfaceC0539t, "provider");
    }
}
