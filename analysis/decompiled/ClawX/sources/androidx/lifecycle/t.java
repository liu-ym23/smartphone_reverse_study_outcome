package androidx.lifecycle;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f722a;

    /* renamed from: b, reason: collision with root package name */
    public i.a f723b;

    /* renamed from: c, reason: collision with root package name */
    public m f724c;
    public final WeakReference d;

    /* renamed from: e, reason: collision with root package name */
    public int f725e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f726f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f727g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f728h;

    public t(r rVar) {
        new AtomicReference();
        this.f722a = true;
        this.f723b = new i.a();
        this.f724c = m.f715b;
        this.f728h = new ArrayList();
        this.d = new WeakReference(rVar);
    }

    public final void a(q qVar) {
        p reflectiveGenericLifecycleObserver;
        Object obj;
        r rVar;
        c("addObserver");
        m mVar = this.f724c;
        m mVar2 = m.f714a;
        if (mVar != mVar2) {
            mVar2 = m.f715b;
        }
        s sVar = new s();
        HashMap map = u.f729a;
        boolean z = qVar instanceof p;
        boolean z2 = qVar instanceof d;
        if (z && z2) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((d) qVar, (p) qVar);
        } else if (z2) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((d) qVar, null);
        } else if (z) {
            reflectiveGenericLifecycleObserver = (p) qVar;
        } else {
            Class<?> cls = qVar.getClass();
            if (u.b(cls) == 2) {
                Object obj2 = u.f730b.get(cls);
                kotlin.jvm.internal.p.b(obj2);
                List list = (List) obj2;
                if (list.size() == 1) {
                    u.a((Constructor) list.get(0), qVar);
                    throw null;
                }
                int size = list.size();
                g[] gVarArr = new g[size];
                if (size > 0) {
                    u.a((Constructor) list.get(0), qVar);
                    throw null;
                }
                reflectiveGenericLifecycleObserver = new CompositeGeneratedAdaptersObserver(gVarArr);
            } else {
                reflectiveGenericLifecycleObserver = new ReflectiveGenericLifecycleObserver(qVar);
            }
        }
        sVar.f721b = reflectiveGenericLifecycleObserver;
        sVar.f720a = mVar2;
        i.a aVar = this.f723b;
        i.c cVarF = aVar.f(qVar);
        if (cVarF != null) {
            obj = cVarF.f3081b;
        } else {
            HashMap map2 = aVar.f3076e;
            i.c cVar = new i.c(qVar, sVar);
            aVar.d++;
            i.c cVar2 = aVar.f3087b;
            if (cVar2 == null) {
                aVar.f3086a = cVar;
                aVar.f3087b = cVar;
            } else {
                cVar2.f3082c = cVar;
                cVar.d = cVar2;
                aVar.f3087b = cVar;
            }
            map2.put(qVar, cVar);
            obj = null;
        }
        if (((s) obj) == null && (rVar = (r) this.d.get()) != null) {
            boolean z8 = this.f725e != 0 || this.f726f;
            m mVarB = b(qVar);
            this.f725e++;
            while (sVar.f720a.compareTo(mVarB) < 0 && this.f723b.f3076e.containsKey(qVar)) {
                m mVar3 = sVar.f720a;
                ArrayList arrayList = this.f728h;
                arrayList.add(mVar3);
                j jVar = l.Companion;
                m state = sVar.f720a;
                jVar.getClass();
                kotlin.jvm.internal.p.e(state, "state");
                int iOrdinal = state.ordinal();
                l lVar = iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? null : l.ON_RESUME : l.ON_START : l.ON_CREATE;
                if (lVar == null) {
                    throw new IllegalStateException("no event up from " + sVar.f720a);
                }
                sVar.a(rVar, lVar);
                arrayList.remove(arrayList.size() - 1);
                mVarB = b(qVar);
            }
            if (!z8) {
                f();
            }
            this.f725e--;
        }
    }

    public final m b(q qVar) {
        HashMap map = this.f723b.f3076e;
        i.c cVar = map.containsKey(qVar) ? ((i.c) map.get(qVar)).d : null;
        m mVar = cVar != null ? ((s) cVar.f3081b).f720a : null;
        ArrayList arrayList = this.f728h;
        m mVar2 = arrayList.isEmpty() ? null : (m) arrayList.get(arrayList.size() - 1);
        m state1 = this.f724c;
        kotlin.jvm.internal.p.e(state1, "state1");
        if (mVar == null || mVar.compareTo(state1) >= 0) {
            mVar = state1;
        }
        return (mVar2 == null || mVar2.compareTo(mVar) >= 0) ? mVar : mVar2;
    }

    public final void c(String str) {
        h.a aVar;
        if (this.f722a) {
            if (h.a.d != null) {
                aVar = h.a.d;
            } else {
                synchronized (h.a.class) {
                    try {
                        if (h.a.d == null) {
                            h.a.d = new h.a(0);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                aVar = h.a.d;
            }
            ((h.a) aVar.f2997c).getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(m0.f.d("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void d(l event) {
        kotlin.jvm.internal.p.e(event, "event");
        c("handleLifecycleEvent");
        m mVarA = event.a();
        m mVar = this.f724c;
        if (mVar == mVarA) {
            return;
        }
        m mVar2 = m.f715b;
        m mVar3 = m.f714a;
        if (mVar == mVar2 && mVarA == mVar3) {
            throw new IllegalStateException(("no event down from " + this.f724c + " in component " + this.d.get()).toString());
        }
        this.f724c = mVarA;
        if (this.f726f || this.f725e != 0) {
            this.f727g = true;
            return;
        }
        this.f726f = true;
        f();
        this.f726f = false;
        if (this.f724c == mVar3) {
            this.f723b = new i.a();
        }
    }

    public final void e(q qVar) {
        c("removeObserver");
        this.f723b.g(qVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
    
        r12.f727g = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.t.f():void");
    }
}
