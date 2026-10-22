package androidx.window.layout;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.EmptyList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j implements k {

    /* renamed from: c, reason: collision with root package name */
    public static volatile j f2746c;

    /* renamed from: d, reason: collision with root package name */
    public static final ReentrantLock f2747d = new ReentrantLock();

    /* renamed from: a, reason: collision with root package name */
    public final c f2748a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f2749b = new CopyOnWriteArrayList<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class a {
        public a() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Activity f2751a;

        /* renamed from: b, reason: collision with root package name */
        public final androidx.fragment.app.m f2752b;

        /* renamed from: c, reason: collision with root package name */
        public m f2753c;

        public b(Activity activity, t1.b bVar, androidx.fragment.app.m mVar) {
            this.f2751a = activity;
            this.f2752b = mVar;
        }
    }

    public j(SidecarCompat sidecarCompat) {
        this.f2748a = sidecarCompat;
        if (sidecarCompat == null) {
            return;
        }
        sidecarCompat.e(new a());
    }

    @Override // androidx.window.layout.k
    public final void a(u0.a<m> callback) {
        kotlin.jvm.internal.g.f(callback, "callback");
        synchronized (f2747d) {
            try {
                if (this.f2748a == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<b> it = this.f2749b.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next.f2752b == callback) {
                        arrayList.add(next);
                    }
                }
                this.f2749b.removeAll(arrayList);
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    Activity activity = ((b) obj).f2751a;
                    CopyOnWriteArrayList<b> copyOnWriteArrayList = this.f2749b;
                    if (copyOnWriteArrayList == null || !copyOnWriteArrayList.isEmpty()) {
                        Iterator<b> it2 = copyOnWriteArrayList.iterator();
                        while (it2.hasNext()) {
                            if (it2.next().f2751a.equals(activity)) {
                                break;
                            }
                        }
                    }
                    c cVar = this.f2748a;
                    if (cVar != null) {
                        cVar.b(activity);
                    }
                }
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.window.layout.k
    public final void b(Activity activity, t1.b bVar, androidx.fragment.app.m mVar) {
        m mVar2;
        b next;
        ReentrantLock reentrantLock = f2747d;
        reentrantLock.lock();
        try {
            c cVar = this.f2748a;
            if (cVar == null) {
                mVar.accept(new m(EmptyList.f10001a));
                return;
            }
            CopyOnWriteArrayList<b> copyOnWriteArrayList = this.f2749b;
            boolean z = false;
            if (copyOnWriteArrayList == null || !copyOnWriteArrayList.isEmpty()) {
                Iterator<b> it = copyOnWriteArrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next().f2751a.equals(activity)) {
                        z = true;
                        break;
                    }
                }
            }
            b bVar2 = new b(activity, bVar, mVar);
            copyOnWriteArrayList.add(bVar2);
            if (z) {
                Iterator<b> it2 = copyOnWriteArrayList.iterator();
                while (true) {
                    mVar2 = null;
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it2.next();
                        if (activity.equals(next.f2751a)) {
                            break;
                        }
                    }
                }
                b bVar3 = next;
                if (bVar3 != null) {
                    mVar2 = bVar3.f2753c;
                }
                if (mVar2 != null) {
                    bVar2.f2753c = mVar2;
                    bVar2.f2752b.accept(mVar2);
                }
            } else {
                cVar.a(activity);
            }
            lb.n nVar = lb.n.f10413a;
        } finally {
            reentrantLock.unlock();
        }
    }
}
