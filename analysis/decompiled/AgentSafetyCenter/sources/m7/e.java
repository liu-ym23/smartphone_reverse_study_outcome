package m7;

import java.io.EOFException;
import java.io.IOException;
import java.io.StringReader;
import java.io.Writer;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import p7.b0;
import p7.e0;
import p7.g1;
import p7.s;
import p7.t;
import p7.u;
import p7.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: l, reason: collision with root package name */
    public static final a f8250l = a.f8242d;

    /* renamed from: m, reason: collision with root package name */
    public static final int f8251m = 1;

    /* renamed from: n, reason: collision with root package name */
    public static final int f8252n = 1;

    /* renamed from: o, reason: collision with root package name */
    public static final int f8253o = 2;

    /* renamed from: a, reason: collision with root package name */
    public final ThreadLocal f8254a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f8255b;

    /* renamed from: c, reason: collision with root package name */
    public final p5.c f8256c;

    /* renamed from: d, reason: collision with root package name */
    public final p7.l f8257d;

    /* renamed from: e, reason: collision with root package name */
    public final List f8258e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f8259f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f8260g;

    /* renamed from: h, reason: collision with root package name */
    public final a f8261h;
    public final List i;

    /* renamed from: j, reason: collision with root package name */
    public final List f8262j;

    /* renamed from: k, reason: collision with root package name */
    public final List f8263k;

    public e(o7.d dVar, int i, Map map, boolean z10, boolean z11, a aVar, List list, List list2, List list3, int i3, int i10, List list4) {
        u uVar;
        s sVar;
        this.f8254a = new ThreadLocal();
        this.f8255b = new ConcurrentHashMap();
        p5.c cVar = new p5.c(9);
        cVar.f9717f = map;
        cVar.f9718g = list4;
        VarHandle.storeStoreFence();
        this.f8256c = cVar;
        this.f8259f = z10;
        this.f8260g = z11;
        this.f8261h = aVar;
        this.i = list;
        this.f8262j = list2;
        this.f8263k = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(g1.A);
        int i11 = 1;
        if (i3 == 1) {
            uVar = v.f9901c;
        } else {
            u uVar2 = v.f9901c;
            uVar = new u();
            uVar.f9900c = i3;
            VarHandle.storeStoreFence();
        }
        arrayList.add(uVar);
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(g1.f9859p);
        arrayList.add(g1.f9851g);
        arrayList.add(g1.f9848d);
        arrayList.add(g1.f9849e);
        arrayList.add(g1.f9850f);
        e0 e0Var = g1.f9854k;
        arrayList.add(g1.b(Long.TYPE, Long.class, e0Var));
        int i12 = 0;
        arrayList.add(g1.b(Double.TYPE, Double.class, new b(i12)));
        arrayList.add(g1.b(Float.TYPE, Float.class, new b(i11)));
        if (i10 == 2) {
            sVar = t.f9898b;
        } else {
            t tVar = new t();
            tVar.f9899a = i10;
            VarHandle.storeStoreFence();
            s sVar2 = new s(i12);
            sVar2.f9897f = tVar;
            VarHandle.storeStoreFence();
            sVar = sVar2;
        }
        arrayList.add(sVar);
        arrayList.add(g1.f9852h);
        arrayList.add(g1.i);
        c cVar2 = new c(i12);
        cVar2.f8248b = e0Var;
        VarHandle.storeStoreFence();
        arrayList.add(g1.a(AtomicLong.class, cVar2.nullSafe()));
        c cVar3 = new c(i11);
        cVar3.f8248b = e0Var;
        VarHandle.storeStoreFence();
        arrayList.add(g1.a(AtomicLongArray.class, cVar3.nullSafe()));
        arrayList.add(g1.f9853j);
        arrayList.add(g1.f9855l);
        arrayList.add(g1.f9860q);
        arrayList.add(g1.f9861r);
        arrayList.add(g1.a(BigDecimal.class, g1.f9856m));
        arrayList.add(g1.a(BigInteger.class, g1.f9857n));
        arrayList.add(g1.a(o7.j.class, g1.f9858o));
        arrayList.add(g1.f9862s);
        arrayList.add(g1.f9863t);
        arrayList.add(g1.f9865v);
        arrayList.add(g1.f9866w);
        arrayList.add(g1.f9868y);
        arrayList.add(g1.f9864u);
        arrayList.add(g1.f9846b);
        arrayList.add(p7.h.f9870c);
        arrayList.add(g1.f9867x);
        if (s7.f.f11415a) {
            arrayList.add(s7.f.f11417c);
            arrayList.add(s7.f.f11416b);
            arrayList.add(s7.f.f11418d);
        }
        arrayList.add(p7.b.f9832c);
        arrayList.add(g1.f9845a);
        p7.d dVar2 = new p7.d(i12);
        dVar2.f9843f = cVar;
        VarHandle.storeStoreFence();
        arrayList.add(dVar2);
        p7.d dVar3 = new p7.d(i11);
        dVar3.f9843f = cVar;
        VarHandle.storeStoreFence();
        arrayList.add(dVar3);
        p7.l lVar = new p7.l();
        lVar.f9878c = cVar;
        lVar.f9879f = new ConcurrentHashMap();
        VarHandle.storeStoreFence();
        this.f8257d = lVar;
        arrayList.add(lVar);
        arrayList.add(g1.B);
        b0 b0Var = new b0();
        b0Var.f9835c = cVar;
        b0Var.f9836f = i;
        b0Var.f9837g = dVar;
        b0Var.f9838h = lVar;
        b0Var.i = list4;
        VarHandle.storeStoreFence();
        arrayList.add(b0Var);
        this.f8258e = Collections.unmodifiableList(arrayList);
    }

    public static void a(double d7) {
        if (Double.isNaN(d7) || Double.isInfinite(d7)) {
            throw new IllegalArgumentException(d7 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final Object b(String str, t7.a aVar) {
        Object obj = null;
        if (str == null) {
            return null;
        }
        u7.a aVar2 = new u7.a(new StringReader(str));
        aVar2.f14161s = 2;
        boolean z10 = true;
        aVar2.f14161s = 1;
        try {
            try {
                try {
                    try {
                        aVar2.Y();
                        z10 = false;
                        n nVarC = c(aVar);
                        Object obj2 = nVarC.read(aVar2);
                        Class clsM = o7.h.m(aVar.getRawType());
                        if (obj2 != null && !clsM.isInstance(obj2)) {
                            throw new ClassCastException("Type adapter '" + nVarC + "' returned wrong type; requested " + aVar.getRawType() + " but got instance of " + obj2.getClass() + "\nVerify that the adapter was registered for the correct type.");
                        }
                        aVar2.f14161s = 2;
                        obj = obj2;
                    } catch (IllegalStateException e10) {
                        throw new h(e10);
                    }
                } catch (AssertionError e11) {
                    throw new AssertionError("AssertionError (GSON 2.13.2): " + e11.getMessage(), e11);
                }
            } catch (EOFException e12) {
                if (!z10) {
                    throw new h(e12);
                }
                aVar2.f14161s = 2;
            } catch (IOException e13) {
                throw new h(e13);
            }
            if (obj != null) {
                try {
                    if (aVar2.Y() != u7.b.f14170n) {
                        throw new h("JSON document was not fully consumed.");
                    }
                } catch (u7.d e14) {
                    throw new h(e14);
                } catch (IOException e15) {
                    throw new h(e15);
                }
            }
            return obj;
        } catch (Throwable th) {
            aVar2.f14161s = 2;
            throw th;
        }
    }

    public final n c(t7.a aVar) {
        boolean z10;
        Objects.requireNonNull(aVar, "type must not be null");
        ConcurrentHashMap concurrentHashMap = this.f8255b;
        n nVar = (n) concurrentHashMap.get(aVar);
        if (nVar != null) {
            return nVar;
        }
        ThreadLocal threadLocal = this.f8254a;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
            z10 = true;
        } else {
            n nVar2 = (n) map.get(aVar);
            if (nVar2 != null) {
                return nVar2;
            }
            z10 = false;
        }
        try {
            d dVar = new d();
            map.put(aVar, dVar);
            Iterator it = this.f8258e.iterator();
            n nVarA = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                nVarA = ((o) it.next()).a(this, aVar);
                if (nVarA != null) {
                    if (dVar.f8249a != null) {
                        throw new AssertionError("Delegate is already set");
                    }
                    dVar.f8249a = nVarA;
                    map.put(aVar, nVarA);
                }
            }
            if (z10) {
                threadLocal.remove();
            }
            if (nVarA == null) {
                g5.f.p(aVar, "GSON (2.13.2) cannot handle ");
                return null;
            }
            if (z10) {
                concurrentHashMap.putAll(map);
            }
            return nVarA;
        } catch (Throwable th) {
            if (z10) {
                threadLocal.remove();
            }
            throw th;
        }
    }

    public final u7.c d(Writer writer) {
        u7.c cVar = new u7.c(writer);
        cVar.H(this.f8261h);
        cVar.f14182m = this.f8260g;
        cVar.M(2);
        cVar.f14184o = this.f8259f;
        return cVar;
    }

    public final String e(Object obj) {
        if (obj == null) {
            StringBuilder sb2 = new StringBuilder();
            try {
                g(d(o7.h.n(sb2)));
                return sb2.toString();
            } catch (IOException e10) {
                throw new h(e10);
            }
        }
        Class<?> cls = obj.getClass();
        StringBuilder sb3 = new StringBuilder();
        try {
            f(obj, cls, d(o7.h.n(sb3)));
            return sb3.toString();
        } catch (IOException e11) {
            throw new h(e11);
        }
    }

    public final void f(Object obj, Class cls, u7.c cVar) {
        n nVarC = c(t7.a.get((Type) cls));
        int i = cVar.f14181l;
        if (i == 2) {
            cVar.f14181l = 1;
        }
        boolean z10 = cVar.f14182m;
        boolean z11 = cVar.f14184o;
        cVar.f14182m = this.f8260g;
        cVar.f14184o = this.f8259f;
        try {
            try {
                nVarC.write(cVar, obj);
            } catch (IOException e10) {
                throw new h(e10);
            } catch (AssertionError e11) {
                throw new AssertionError("AssertionError (GSON 2.13.2): " + e11.getMessage(), e11);
            }
        } finally {
            cVar.M(i);
            cVar.f14182m = z10;
            cVar.f14184o = z11;
        }
    }

    public final void g(u7.c cVar) {
        i iVar = i.f8265c;
        int i = cVar.f14181l;
        boolean z10 = cVar.f14182m;
        boolean z11 = cVar.f14184o;
        cVar.f14182m = this.f8260g;
        cVar.f14184o = this.f8259f;
        if (i == 2) {
            cVar.f14181l = 1;
        }
        try {
            try {
                p7.m mVar = g1.f9869z;
                mVar.getClass();
                mVar.write(cVar, (g) iVar);
                cVar.M(i);
                cVar.f14182m = z10;
                cVar.f14184o = z11;
            } catch (IOException e10) {
                throw new h(e10);
            } catch (AssertionError e11) {
                throw new AssertionError("AssertionError (GSON 2.13.2): " + e11.getMessage(), e11);
            }
        } catch (Throwable th) {
            cVar.M(i);
            cVar.f14182m = z10;
            cVar.f14184o = z11;
            throw th;
        }
    }

    public final String toString() {
        return "{serializeNulls:" + this.f8259f + ",factories:" + this.f8258e + ",instanceCreators:" + this.f8256c + "}";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public e() {
        o7.d dVar = o7.d.f9247g;
        Map map = Collections.EMPTY_MAP;
        List list = Collections.EMPTY_LIST;
        this(dVar, f8251m, map, false, true, f8250l, list, list, list, f8252n, f8253o, list);
    }
}
