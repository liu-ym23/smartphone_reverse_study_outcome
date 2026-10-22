package androidx.lifecycle;

import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import n.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class s extends Lifecycle {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f2308b = true;

    /* renamed from: c, reason: collision with root package name */
    public n.a<p, a> f2309c = new n.a<>();

    /* renamed from: d, reason: collision with root package name */
    public Lifecycle.State f2310d;

    /* renamed from: e, reason: collision with root package name */
    public final WeakReference<q> f2311e;

    /* renamed from: f, reason: collision with root package name */
    public int f2312f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2313g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList<Lifecycle.State> f2314i;

    /* renamed from: j, reason: collision with root package name */
    public final MutableStateFlow<Lifecycle.State> f2315j;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public Lifecycle.State f2316a;

        /* renamed from: b, reason: collision with root package name */
        public o f2317b;

        public final void a(q qVar, Lifecycle.Event event) {
            Lifecycle.State stateA = event.a();
            Lifecycle.State state1 = this.f2316a;
            kotlin.jvm.internal.g.f(state1, "state1");
            if (stateA.compareTo(state1) < 0) {
                state1 = stateA;
            }
            this.f2316a = state1;
            this.f2317b.a(qVar, event);
            this.f2316a = stateA;
        }
    }

    public s(q qVar) {
        Lifecycle.State state = Lifecycle.State.f2215b;
        this.f2310d = state;
        this.f2314i = new ArrayList<>();
        this.f2311e = new WeakReference<>(qVar);
        this.f2315j = StateFlowKt.MutableStateFlow(state);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.lifecycle.Lifecycle
    public final void a(p observer) {
        o c0Var;
        a aVar;
        q qVar;
        kotlin.jvm.internal.g.f(observer, "observer");
        e("addObserver");
        Lifecycle.State state = this.f2310d;
        Lifecycle.State state2 = Lifecycle.State.f2214a;
        if (state != state2) {
            state2 = Lifecycle.State.f2215b;
        }
        a aVar2 = new a();
        HashMap map = v.f2320a;
        boolean z = observer instanceof o;
        boolean z3 = observer instanceof e;
        if (z && z3) {
            c0Var = new f((e) observer, (o) observer);
        } else if (z3) {
            c0Var = new f((e) observer, null);
        } else if (z) {
            c0Var = (o) observer;
        } else {
            Class<?> cls = observer.getClass();
            if (v.b(cls) == 2) {
                Object obj = v.f2321b.get(cls);
                kotlin.jvm.internal.g.c(obj);
                List list = (List) obj;
                if (list.size() == 1) {
                    c0Var = new p0(v.a((Constructor) list.get(0), observer));
                } else {
                    int size = list.size();
                    h[] hVarArr = new h[size];
                    for (int i10 = 0; i10 < size; i10++) {
                        hVarArr[i10] = v.a((Constructor) list.get(i10), observer);
                    }
                    c0Var = new d(hVarArr);
                }
            } else {
                c0Var = new c0(observer);
            }
        }
        aVar2.f2317b = c0Var;
        aVar2.f2316a = state2;
        n.a<p, a> aVar3 = this.f2309c;
        b.c<p, a> cVarA = aVar3.a(observer);
        if (cVarA != null) {
            aVar = cVarA.f10578b;
        } else {
            HashMap<p, b.c<p, a>> map2 = aVar3.f10572e;
            b.c<K, V> cVar = new b.c<>(observer, aVar2);
            aVar3.f10576d++;
            b.c cVar2 = aVar3.f10574b;
            if (cVar2 == null) {
                aVar3.f10573a = cVar;
                aVar3.f10574b = cVar;
            } else {
                cVar2.f10579c = cVar;
                cVar.f10580d = cVar2;
                aVar3.f10574b = cVar;
            }
            map2.put(observer, cVar);
            aVar = null;
        }
        if (aVar == null && (qVar = this.f2311e.get()) != null) {
            boolean z10 = this.f2312f != 0 || this.f2313g;
            Lifecycle.State stateD = d(observer);
            this.f2312f++;
            while (aVar2.f2316a.compareTo(stateD) < 0 && this.f2309c.f10572e.containsKey(observer)) {
                Lifecycle.State state3 = aVar2.f2316a;
                ArrayList<Lifecycle.State> arrayList = this.f2314i;
                arrayList.add(state3);
                Lifecycle.Event.a aVar4 = Lifecycle.Event.Companion;
                Lifecycle.State state4 = aVar2.f2316a;
                aVar4.getClass();
                kotlin.jvm.internal.g.f(state4, "state");
                int iOrdinal = state4.ordinal();
                Lifecycle.Event event = iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? null : Lifecycle.Event.ON_RESUME : Lifecycle.Event.ON_START : Lifecycle.Event.ON_CREATE;
                if (event == null) {
                    throw new IllegalStateException("no event up from " + aVar2.f2316a);
                }
                aVar2.a(qVar, event);
                arrayList.remove(arrayList.size() - 1);
                stateD = d(observer);
            }
            if (!z10) {
                i();
            }
            this.f2312f--;
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public final Lifecycle.State b() {
        return this.f2310d;
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void c(p observer) {
        kotlin.jvm.internal.g.f(observer, "observer");
        e("removeObserver");
        this.f2309c.b(observer);
    }

    public final Lifecycle.State d(p pVar) {
        HashMap<p, b.c<p, a>> map = this.f2309c.f10572e;
        b.c<p, a> cVar = map.containsKey(pVar) ? map.get(pVar).f10580d : null;
        Lifecycle.State state = cVar != null ? cVar.f10578b.f2316a : null;
        ArrayList<Lifecycle.State> arrayList = this.f2314i;
        Lifecycle.State state2 = arrayList.isEmpty() ? null : arrayList.get(arrayList.size() - 1);
        Lifecycle.State state1 = this.f2310d;
        kotlin.jvm.internal.g.f(state1, "state1");
        if (state == null || state.compareTo(state1) >= 0) {
            state = state1;
        }
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    public final void e(String str) {
        if (this.f2308b) {
            m.b.k().f10433b.getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(a0.a.k("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void f(Lifecycle.Event event) {
        kotlin.jvm.internal.g.f(event, "event");
        e("handleLifecycleEvent");
        g(event.a());
    }

    public final void g(Lifecycle.State next) {
        if (this.f2310d == next) {
            return;
        }
        q qVar = this.f2311e.get();
        Lifecycle.State current = this.f2310d;
        kotlin.jvm.internal.g.f(current, "current");
        kotlin.jvm.internal.g.f(next, "next");
        if (current == Lifecycle.State.f2215b && next == Lifecycle.State.f2214a) {
            throw new IllegalStateException(("State must be at least '" + Lifecycle.State.f2216c + "' to be moved to '" + next + "' in component " + qVar).toString());
        }
        Lifecycle.State state = Lifecycle.State.f2214a;
        if (current == state && current != next) {
            throw new IllegalStateException(("State is '" + state + "' and cannot be moved to `" + next + "` in component " + qVar).toString());
        }
        this.f2310d = next;
        if (this.f2313g || this.f2312f != 0) {
            this.h = true;
            return;
        }
        this.f2313g = true;
        i();
        this.f2313g = false;
        if (this.f2310d == state) {
            this.f2309c = new n.a<>();
        }
    }

    public final void h(Lifecycle.State state) {
        kotlin.jvm.internal.g.f(state, "state");
        e("setCurrentState");
        g(state);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
    
        r8.h = false;
        r8.f2315j.setValue(r8.f2310d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i() {
        /*
            Method dump skipped, instructions count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.s.i():void");
    }
}
