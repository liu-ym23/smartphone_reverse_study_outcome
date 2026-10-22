package androidx.work.impl;

import android.content.Context;
import androidx.room.a;
import androidx.room.f;
import androidx.room.w;
import h5.q;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p5.b;
import p5.c;
import p5.e;
import p5.h;
import p5.i;
import p5.l;
import p5.m;
import p5.s;
import p5.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {

    /* renamed from: l, reason: collision with root package name */
    public volatile s f1662l;

    /* renamed from: m, reason: collision with root package name */
    public volatile c f1663m;

    /* renamed from: n, reason: collision with root package name */
    public volatile u f1664n;

    /* renamed from: o, reason: collision with root package name */
    public volatile i f1665o;

    /* renamed from: p, reason: collision with root package name */
    public volatile l f1666p;

    /* renamed from: q, reason: collision with root package name */
    public volatile m f1667q;

    /* renamed from: r, reason: collision with root package name */
    public volatile e f1668r;

    @Override // androidx.work.impl.WorkDatabase
    public final l A() {
        l lVar;
        if (this.f1666p != null) {
            return this.f1666p;
        }
        synchronized (this) {
            try {
                if (this.f1666p == null) {
                    l lVar2 = new l();
                    lVar2.f9738c = this;
                    lVar2.f9739f = new b(this, 3);
                    VarHandle.storeStoreFence();
                    this.f1666p = lVar2;
                }
                lVar = this.f1666p;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final m B() {
        m mVar;
        if (this.f1667q != null) {
            return this.f1667q;
        }
        synchronized (this) {
            try {
                if (this.f1667q == null) {
                    m mVar2 = new m(0);
                    mVar2.f9741f = this;
                    new b(this, 4);
                    mVar2.f9742g = new h(this, 2);
                    mVar2.f9743h = new h(this, 3);
                    VarHandle.storeStoreFence();
                    this.f1667q = mVar2;
                }
                mVar = this.f1667q;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final s C() {
        s sVar;
        if (this.f1662l != null) {
            return this.f1662l;
        }
        synchronized (this) {
            try {
                if (this.f1662l == null) {
                    this.f1662l = new s(this);
                }
                sVar = this.f1662l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final u D() {
        u uVar;
        if (this.f1664n != null) {
            return this.f1664n;
        }
        synchronized (this) {
            try {
                if (this.f1664n == null) {
                    u uVar2 = new u(0);
                    uVar2.f9807f = this;
                    uVar2.f9808g = new b(this, 6);
                    new h(this, 20);
                    VarHandle.storeStoreFence();
                    this.f1664n = uVar2;
                }
                uVar = this.f1664n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return uVar;
    }

    @Override // androidx.room.u
    public final f e() {
        return new f(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // androidx.room.u
    public final y4.c g(a aVar) {
        a2.i iVar = new a2.i(11);
        iVar.f49f = this;
        VarHandle.storeStoreFence();
        aVar.getClass();
        w wVar = new w(23);
        wVar.f1641g = aVar.f1488e;
        wVar.f1640f = aVar;
        wVar.f1642h = iVar;
        wVar.i = "86254750241babac4b8d52996a675549";
        wVar.f1643j = "1cbd3130fa23b59692c061c594c16cc0";
        VarHandle.storeStoreFence();
        Context context = aVar.f1484a;
        context.getClass();
        String str = aVar.f1485b;
        y4.a aVar2 = new y4.a();
        aVar2.f15893a = context;
        aVar2.f15894b = str;
        aVar2.f15895c = wVar;
        aVar2.f15896d = false;
        aVar2.f15897e = false;
        VarHandle.storeStoreFence();
        return aVar.f1486c.a(aVar2);
    }

    @Override // androidx.room.u
    public final List h(LinkedHashMap linkedHashMap) {
        ArrayList arrayList = new ArrayList();
        int i = 13;
        int i3 = 14;
        arrayList.add(new h5.b(i, i3, 10));
        int i10 = 15;
        q qVar = new q(i3, i10, 0);
        qVar.f5366d = new f8.b(4);
        VarHandle.storeStoreFence();
        arrayList.add(qVar);
        int i11 = 17;
        arrayList.add(new h5.b(16, i11, 11));
        int i12 = 18;
        arrayList.add(new h5.b(i11, i12, 12));
        int i13 = 19;
        arrayList.add(new h5.b(i12, i13, i));
        int i14 = 20;
        q qVar2 = new q(i13, i14, 1);
        qVar2.f5366d = new f8.b(5);
        VarHandle.storeStoreFence();
        arrayList.add(qVar2);
        arrayList.add(new h5.b(i14, 21, i3));
        arrayList.add(new h5.b(22, 23, i10));
        return arrayList;
    }

    @Override // androidx.room.u
    public final Set l() {
        return new HashSet();
    }

    @Override // androidx.room.u
    public final Map n() {
        HashMap map = new HashMap();
        List list = Collections.EMPTY_LIST;
        map.put(s.class, list);
        map.put(c.class, list);
        map.put(u.class, list);
        map.put(i.class, list);
        map.put(l.class, list);
        map.put(m.class, list);
        map.put(e.class, list);
        map.put(p5.f.class, list);
        return map;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final c x() {
        c cVar;
        if (this.f1663m != null) {
            return this.f1663m;
        }
        synchronized (this) {
            try {
                if (this.f1663m == null) {
                    int i = 0;
                    c cVar2 = new c(i);
                    cVar2.f9717f = this;
                    cVar2.f9718g = new b(this, i);
                    VarHandle.storeStoreFence();
                    this.f1663m = cVar2;
                }
                cVar = this.f1663m;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final e y() {
        e eVar;
        if (this.f1668r != null) {
            return this.f1668r;
        }
        synchronized (this) {
            try {
                if (this.f1668r == null) {
                    e eVar2 = new e(0);
                    eVar2.f9722f = this;
                    eVar2.f9723g = new b(this, 1);
                    VarHandle.storeStoreFence();
                    this.f1668r = eVar2;
                }
                eVar = this.f1668r;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final i z() {
        i iVar;
        if (this.f1665o != null) {
            return this.f1665o;
        }
        synchronized (this) {
            try {
                if (this.f1665o == null) {
                    i iVar2 = new i();
                    iVar2.f9730c = this;
                    iVar2.f9731f = new b(this, 2);
                    iVar2.f9732g = new h(this, 0);
                    iVar2.f9733h = new h(this, 1);
                    VarHandle.storeStoreFence();
                    this.f1665o = iVar2;
                }
                iVar = this.f1665o;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }
}
