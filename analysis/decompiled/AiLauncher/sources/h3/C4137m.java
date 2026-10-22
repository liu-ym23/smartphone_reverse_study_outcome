package h3;

import android.util.Log;
import com.google.firebase.components.InvalidRegistrarException;
import com.google.firebase.components.MissingDependencyException;
import i3.InterfaceC4166a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import m3.InterfaceC4896c;
import m3.InterfaceC4897d;
import n3.InterfaceC4938b;

/* renamed from: h3.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C4137m extends AbstractC4125a implements InterfaceC4166a {

    /* renamed from: g, reason: collision with root package name */
    public static final InterfaceC4938b<Set<Object>> f32917g = C4136l.a();

    /* renamed from: a, reason: collision with root package name */
    public final Map<C4127c<?>, InterfaceC4938b<?>> f32918a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, InterfaceC4938b<?>> f32919b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<Class<?>, s<?>> f32920c;

    /* renamed from: d, reason: collision with root package name */
    public final List<InterfaceC4938b<InterfaceC4132h>> f32921d;

    /* renamed from: e, reason: collision with root package name */
    public final C4141q f32922e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReference<Boolean> f32923f;

    /* renamed from: h3.m$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Executor f32924a;

        /* renamed from: b, reason: collision with root package name */
        public final List<InterfaceC4938b<InterfaceC4132h>> f32925b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public final List<C4127c<?>> f32926c = new ArrayList();

        public b(Executor executor) {
            this.f32924a = executor;
        }

        public b a(C4127c<?> c4127c) {
            this.f32926c.add(c4127c);
            return this;
        }

        public b b(Collection<InterfaceC4938b<InterfaceC4132h>> collection) {
            this.f32925b.addAll(collection);
            return this;
        }

        public C4137m c() {
            return new C4137m(this.f32924a, this.f32925b, this.f32926c);
        }
    }

    public static b d(Executor executor) {
        return new b(executor);
    }

    public static <T> List<T> h(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // h3.InterfaceC4128d
    public synchronized <T> InterfaceC4938b<Set<T>> a(Class<T> cls) {
        s<?> sVar = this.f32920c.get(cls);
        if (sVar != null) {
            return sVar;
        }
        return (InterfaceC4938b<Set<T>>) f32917g;
    }

    @Override // h3.AbstractC4125a, h3.InterfaceC4128d
    public /* bridge */ /* synthetic */ Set b(Class cls) {
        return super.b(cls);
    }

    @Override // h3.InterfaceC4128d
    public synchronized <T> InterfaceC4938b<T> c(Class<T> cls) {
        w.c(cls, "Null interface requested.");
        return (InterfaceC4938b) this.f32919b.get(cls);
    }

    public final void e(List<C4127c<?>> list) {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<InterfaceC4938b<InterfaceC4132h>> it = this.f32921d.iterator();
            while (it.hasNext()) {
                try {
                    InterfaceC4132h interfaceC4132h = it.next().get();
                    if (interfaceC4132h != null) {
                        list.addAll(interfaceC4132h.a());
                        it.remove();
                    }
                } catch (InvalidRegistrarException e10) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e10);
                }
            }
            if (this.f32918a.isEmpty()) {
                C4138n.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f32918a.keySet());
                arrayList2.addAll(list);
                C4138n.a(arrayList2);
            }
            for (C4127c<?> c4127c : list) {
                this.f32918a.put(c4127c, new C4142r(C4133i.a(this, c4127c)));
            }
            arrayList.addAll(n(list));
            arrayList.addAll(o());
            m();
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((Runnable) it2.next()).run();
        }
        l();
    }

    public final void f(Map<C4127c<?>, InterfaceC4938b<?>> map, boolean z10) {
        for (Map.Entry<C4127c<?>, InterfaceC4938b<?>> entry : map.entrySet()) {
            C4127c<?> key = entry.getKey();
            InterfaceC4938b<?> value = entry.getValue();
            if (key.h() || (key.i() && z10)) {
                value.get();
            }
        }
        this.f32922e.a();
    }

    public void g(boolean z10) {
        HashMap map;
        if (this.f32923f.compareAndSet(null, Boolean.valueOf(z10))) {
            synchronized (this) {
                map = new HashMap(this.f32918a);
            }
            f(map, z10);
        }
    }

    @Override // h3.AbstractC4125a, h3.InterfaceC4128d
    public /* bridge */ /* synthetic */ Object get(Class cls) {
        return super.get(cls);
    }

    public final void l() {
        Boolean bool = this.f32923f.get();
        if (bool != null) {
            f(this.f32918a, bool.booleanValue());
        }
    }

    public final void m() {
        for (C4127c<?> c4127c : this.f32918a.keySet()) {
            for (C4139o c4139o : c4127c.c()) {
                if (c4139o.f() && !this.f32920c.containsKey(c4139o.b())) {
                    this.f32920c.put(c4139o.b(), s.b(Collections.EMPTY_SET));
                } else if (this.f32919b.containsKey(c4139o.b())) {
                    continue;
                } else {
                    if (c4139o.e()) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", c4127c, c4139o.b()));
                    }
                    if (!c4139o.f()) {
                        this.f32919b.put(c4139o.b(), v.a());
                    }
                }
            }
        }
    }

    public final List<Runnable> n(List<C4127c<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (C4127c<?> c4127c : list) {
            if (c4127c.j()) {
                InterfaceC4938b<?> interfaceC4938b = this.f32918a.get(c4127c);
                for (Class<? super Object> cls : c4127c.e()) {
                    if (this.f32919b.containsKey(cls)) {
                        arrayList.add(RunnableC4134j.a((v) this.f32919b.get(cls), interfaceC4938b));
                    } else {
                        this.f32919b.put(cls, interfaceC4938b);
                    }
                }
            }
        }
        return arrayList;
    }

    public final List<Runnable> o() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry<C4127c<?>, InterfaceC4938b<?>> entry : this.f32918a.entrySet()) {
            C4127c<?> key = entry.getKey();
            if (!key.j()) {
                InterfaceC4938b<?> value = entry.getValue();
                for (Class<? super Object> cls : key.e()) {
                    if (!map.containsKey(cls)) {
                        map.put(cls, new HashSet());
                    }
                    ((Set) map.get(cls)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            if (this.f32920c.containsKey(entry2.getKey())) {
                s<?> sVar = this.f32920c.get(entry2.getKey());
                Iterator it = ((Set) entry2.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(RunnableC4135k.a(sVar, (InterfaceC4938b) it.next()));
                }
            } else {
                this.f32920c.put((Class) entry2.getKey(), s.b((Collection) entry2.getValue()));
            }
        }
        return arrayList;
    }

    public C4137m(Executor executor, Iterable<InterfaceC4938b<InterfaceC4132h>> iterable, Collection<C4127c<?>> collection) {
        this.f32918a = new HashMap();
        this.f32919b = new HashMap();
        this.f32920c = new HashMap();
        this.f32923f = new AtomicReference<>();
        C4141q c4141q = new C4141q(executor);
        this.f32922e = c4141q;
        ArrayList arrayList = new ArrayList();
        arrayList.add(C4127c.l(c4141q, C4141q.class, InterfaceC4897d.class, InterfaceC4896c.class));
        arrayList.add(C4127c.l(this, InterfaceC4166a.class, new Class[0]));
        for (C4127c<?> c4127c : collection) {
            if (c4127c != null) {
                arrayList.add(c4127c);
            }
        }
        this.f32921d = h(iterable);
        e(arrayList);
    }
}
