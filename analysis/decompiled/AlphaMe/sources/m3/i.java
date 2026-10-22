package m3;

import F1.q;
import G1.p;
import com.google.android.gms.common.api.Status;
import java.util.HashMap;
import java.util.Map;
import l1.C0758c;

/* loaded from: classes2.dex */
public final class i implements K0.d, com.google.android.gms.maps.model.b, p, x3.e {

    /* renamed from: a, reason: collision with root package name */
    public Object f13620a;

    /* renamed from: b, reason: collision with root package name */
    public Object f13621b;

    public /* synthetic */ i(Object obj, Object obj2) {
        this.f13620a = obj;
        this.f13621b = obj2;
    }

    public final synchronized void a(j jVar) {
        try {
            Object obj = this.f13621b;
            if (((j) obj) != null) {
                ((j) obj).f13625c = jVar;
                this.f13621b = jVar;
            } else {
                if (((j) this.f13620a) != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.f13621b = jVar;
                this.f13620a = jVar;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized j b() {
        j jVar;
        Object obj = this.f13620a;
        jVar = (j) obj;
        if (((j) obj) != null) {
            j jVar2 = ((j) obj).f13625c;
            this.f13620a = jVar2;
            if (jVar2 == null) {
                this.f13621b = null;
            }
        }
        return jVar;
    }

    @Override // K0.d
    public final H0.b c() {
        return new H0.i((H0.c) ((K0.b) this.f13620a).c(), (H0.c) ((K0.b) this.f13621b).c());
    }

    @Override // x3.e
    public final Object call(Object obj) {
        t3.e eVarB = ((t3.f) this.f13620a).b();
        eVarB.b(new y3.m(this, (x3.a) obj, eVarB, 1));
        return eVarB;
    }

    public final synchronized j d() {
        try {
            if (((j) this.f13620a) == null) {
                wait(1000);
            }
        } catch (Throwable th) {
            throw th;
        }
        return b();
    }

    public final void e(boolean z4, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (((Map) this.f13620a)) {
            map = new HashMap((Map) this.f13620a);
        }
        synchronized (((Map) this.f13621b)) {
            map2 = new HashMap((Map) this.f13621b);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z4 || ((Boolean) entry.getValue()).booleanValue()) {
                B0.g.y(entry.getKey());
                throw null;
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z4 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((C0758c) entry2.getKey()).b(new Z0.d(status));
            }
        }
    }

    @Override // G1.p
    public final Object i() {
        throw new q((String) this.f13620a, 5);
    }

    public /* synthetic */ i(Object obj, Object obj2, int i4) {
        this.f13621b = obj;
        this.f13620a = obj2;
    }
}
