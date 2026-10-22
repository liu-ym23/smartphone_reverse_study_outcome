package com.stepos.architecture.domain.dispatch;

import N1.b;
import androidx.annotation.NonNull;
import androidx.core.app.f;
import androidx.fragment.app.D;
import androidx.lifecycle.G;
import androidx.lifecycle.InterfaceC0315l;
import androidx.lifecycle.V;
import androidx.lifecycle.n0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import stepos.support.v7.app.AbstractActivityC0866k;

/* loaded from: classes.dex */
public class a extends n0 implements InterfaceC0315l {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int DEFAULT_QUEUE_LENGTH = 10;
    private final HashMap<Integer, G> mOwner = new HashMap<>();
    private final HashMap<Integer, G> mFragmentOwner = new HashMap<>();
    private final HashMap<Integer, V> mObservers = new HashMap<>();
    private final M1.a mResults = new M1.a();

    public static /* synthetic */ void c(a aVar, b bVar) {
        Iterator<Map.Entry<Integer, V>> it = aVar.mObservers.entrySet().iterator();
        while (it.hasNext()) {
            bVar.d(it.next().getValue());
        }
    }

    public final void d(Integer num, G g4, V v4) {
        this.mOwner.put(num, g4);
        this.mObservers.put(num, v4);
        Iterator<E> it = this.mResults.iterator();
        while (it.hasNext()) {
            ((b) it.next()).c(g4, v4);
        }
    }

    public int initQueueMaxLength() {
        return 10;
    }

    public final void input(Object obj) {
        onHandle(obj);
    }

    @Override // androidx.lifecycle.InterfaceC0315l
    public void onDestroy(@NonNull G g4) {
        super.onDestroy(g4);
        boolean z4 = g4 instanceof D;
        Iterator<Map.Entry<Integer, G>> it = (z4 ? this.mFragmentOwner : this.mOwner).entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Integer, G> next = it.next();
            if (next.getValue().equals(g4)) {
                Integer key = next.getKey();
                this.mOwner.remove(key);
                if (z4) {
                    this.mFragmentOwner.remove(key);
                }
                Iterator<E> it2 = this.mResults.iterator();
                while (it2.hasNext()) {
                    b bVar = (b) it2.next();
                    V v4 = this.mObservers.get(key);
                    Objects.requireNonNull(v4);
                    bVar.d(v4);
                }
                this.mObservers.remove(key);
            }
        }
        if (this.mObservers.size() == 0) {
            this.mResults.clear();
        }
    }

    public void onHandle(Object obj) {
    }

    public final void output(@NonNull AbstractActivityC0866k abstractActivityC0866k, @NonNull V v4) {
        abstractActivityC0866k.getLifecycle().a(this);
        d(Integer.valueOf(System.identityHashCode(abstractActivityC0866k)), abstractActivityC0866k, v4);
    }

    public final void sendResult(@NonNull Object obj) {
        b bVar;
        M1.a aVar = this.mResults;
        int iInitQueueMaxLength = initQueueMaxLength();
        f fVar = new f(this);
        if (!aVar.f1435b) {
            aVar.f1434a = iInitQueueMaxLength;
            aVar.f1436c = fVar;
            aVar.f1435b = true;
        }
        Iterator<E> it = this.mResults.iterator();
        while (true) {
            if (it.hasNext()) {
                Object obj2 = ((b) it.next()).f1462d;
                if (obj2 == b.f1458i) {
                    obj2 = null;
                }
                if (System.identityHashCode(obj2) == System.identityHashCode(obj)) {
                    break;
                }
            } else {
                b bVar2 = new b(obj);
                for (Map.Entry<Integer, V> entry : this.mObservers.entrySet()) {
                    bVar2.c(this.mOwner.get(entry.getKey()), entry.getValue());
                }
                this.mResults.add(bVar2);
            }
        }
        Iterator<E> it2 = this.mResults.iterator();
        while (true) {
            if (!it2.hasNext()) {
                bVar = null;
                break;
            }
            bVar = (b) it2.next();
            Object obj3 = bVar.f1462d;
            if (obj3 == b.f1458i) {
                obj3 = null;
            }
            if (System.identityHashCode(obj3) == System.identityHashCode(obj)) {
                break;
            }
        }
        if (bVar != null) {
            bVar.f1463e++;
            bVar.f1462d = obj;
            bVar.b(null);
        }
    }

    public final void output(@NonNull D d4, @NonNull V v4) {
        d4.getLifecycle().a(this);
        Integer numValueOf = Integer.valueOf(System.identityHashCode(d4));
        this.mFragmentOwner.put(numValueOf, d4);
        d(numValueOf, d4.getViewLifecycleOwner(), v4);
    }
}
