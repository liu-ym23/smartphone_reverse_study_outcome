package d;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import d.d;
import fc.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f8238a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f8239b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f8240c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f8241d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final transient LinkedHashMap f8242e = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f8243f = new LinkedHashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f8244g = new Bundle();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a<O> {

        /* renamed from: a, reason: collision with root package name */
        public final d.a<O> f8245a;

        /* renamed from: b, reason: collision with root package name */
        public final e.a<?, O> f8246b;

        public a(e.a contract, d.a callback) {
            kotlin.jvm.internal.g.f(callback, "callback");
            kotlin.jvm.internal.g.f(contract, "contract");
            this.f8245a = callback;
            this.f8246b = contract;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Lifecycle f8247a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f8248b = new ArrayList();

        public b(Lifecycle lifecycle) {
            this.f8247a = lifecycle;
        }
    }

    public final boolean a(int i10, int i11, Intent intent) {
        String str = (String) this.f8238a.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        a aVar = (a) this.f8242e.get(str);
        if ((aVar != null ? aVar.f8245a : null) != null) {
            ArrayList arrayList = this.f8241d;
            if (arrayList.contains(str)) {
                aVar.f8245a.a(aVar.f8246b.c(i11, intent));
                arrayList.remove(str);
                return true;
            }
        }
        this.f8243f.remove(str);
        this.f8244g.putParcelable(str, new ActivityResult(i11, intent));
        return true;
    }

    public abstract void b(int i10, e.a aVar, Object obj);

    public final e c(final String key, q qVar, final e.a contract, final d.a callback) {
        kotlin.jvm.internal.g.f(key, "key");
        kotlin.jvm.internal.g.f(contract, "contract");
        kotlin.jvm.internal.g.f(callback, "callback");
        Lifecycle lifecycle = qVar.getLifecycle();
        if (lifecycle.b().compareTo(Lifecycle.State.f2217d) >= 0) {
            throw new IllegalStateException(("LifecycleOwner " + qVar + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.").toString());
        }
        e(key);
        LinkedHashMap linkedHashMap = this.f8240c;
        b bVar = (b) linkedHashMap.get(key);
        if (bVar == null) {
            bVar = new b(lifecycle);
        }
        o oVar = new o() { // from class: d.c
            @Override // androidx.lifecycle.o
            public final void a(q qVar2, Lifecycle.Event event) {
                d dVar = this.f8234a;
                LinkedHashMap linkedHashMap2 = dVar.f8242e;
                Lifecycle.Event event2 = Lifecycle.Event.ON_START;
                String str = key;
                if (event2 != event) {
                    if (Lifecycle.Event.ON_STOP == event) {
                        linkedHashMap2.remove(str);
                        return;
                    } else {
                        if (Lifecycle.Event.ON_DESTROY == event) {
                            dVar.f(str);
                            return;
                        }
                        return;
                    }
                }
                Bundle bundle = dVar.f8244g;
                LinkedHashMap linkedHashMap3 = dVar.f8243f;
                e.a aVar = contract;
                a aVar2 = callback;
                linkedHashMap2.put(str, new d.a(aVar, aVar2));
                if (linkedHashMap3.containsKey(str)) {
                    Object obj = linkedHashMap3.get(str);
                    linkedHashMap3.remove(str);
                    aVar2.a(obj);
                }
                ActivityResult activityResult = (ActivityResult) r0.a.a(bundle, str);
                if (activityResult != null) {
                    bundle.remove(str);
                    aVar2.a(aVar.c(activityResult.getResultCode(), activityResult.getData()));
                }
            }
        };
        bVar.f8247a.a(oVar);
        bVar.f8248b.add(oVar);
        linkedHashMap.put(key, bVar);
        return new e(this, key, contract);
    }

    public final f d(String key, e.a aVar, d.a aVar2) {
        kotlin.jvm.internal.g.f(key, "key");
        e(key);
        this.f8242e.put(key, new a(aVar, aVar2));
        LinkedHashMap linkedHashMap = this.f8243f;
        if (linkedHashMap.containsKey(key)) {
            Object obj = linkedHashMap.get(key);
            linkedHashMap.remove(key);
            aVar2.a(obj);
        }
        Bundle bundle = this.f8244g;
        ActivityResult activityResult = (ActivityResult) r0.a.a(bundle, key);
        if (activityResult != null) {
            bundle.remove(key);
            aVar2.a(aVar.c(activityResult.getResultCode(), activityResult.getData()));
        }
        return new f(this, key, aVar);
    }

    public final void e(String str) {
        LinkedHashMap linkedHashMap = this.f8239b;
        if (((Integer) linkedHashMap.get(str)) != null) {
            return;
        }
        com.stepos.cpuset.b bVar = new com.stepos.cpuset.b(2);
        Iterator it = new fc.a(new h(new androidx.compose.runtime.g(bVar, 16), bVar)).iterator();
        while (it.hasNext()) {
            Number number = (Number) it.next();
            Integer numValueOf = Integer.valueOf(number.intValue());
            LinkedHashMap linkedHashMap2 = this.f8238a;
            if (!linkedHashMap2.containsKey(numValueOf)) {
                int iIntValue = number.intValue();
                linkedHashMap2.put(Integer.valueOf(iIntValue), str);
                linkedHashMap.put(str, Integer.valueOf(iIntValue));
                return;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public final void f(String key) {
        Integer num;
        kotlin.jvm.internal.g.f(key, "key");
        if (!this.f8241d.contains(key) && (num = (Integer) this.f8239b.remove(key)) != null) {
            this.f8238a.remove(num);
        }
        this.f8242e.remove(key);
        LinkedHashMap linkedHashMap = this.f8243f;
        if (linkedHashMap.containsKey(key)) {
            StringBuilder sbQ = a0.a.q("Dropping pending result for request ", key, ": ");
            sbQ.append(linkedHashMap.get(key));
            Log.w("ActivityResultRegistry", sbQ.toString());
            linkedHashMap.remove(key);
        }
        Bundle bundle = this.f8244g;
        if (bundle.containsKey(key)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + key + ": " + ((ActivityResult) r0.a.a(bundle, key)));
            bundle.remove(key);
        }
        LinkedHashMap linkedHashMap2 = this.f8240c;
        b bVar = (b) linkedHashMap2.get(key);
        if (bVar != null) {
            ArrayList arrayList = bVar.f8248b;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                bVar.f8247a.c((o) obj);
            }
            arrayList.clear();
            linkedHashMap2.remove(key);
        }
    }
}
