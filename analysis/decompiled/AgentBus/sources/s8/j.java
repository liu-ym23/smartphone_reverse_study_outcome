package s8;

import f8.e1;
import f8.m0;
import f8.r0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class j extends i8.j implements q8.c {
    public final u9.i A;

    /* renamed from: l, reason: collision with root package name */
    public final a3.b f9559l;

    /* renamed from: m, reason: collision with root package name */
    public final l8.o f9560m;

    /* renamed from: n, reason: collision with root package name */
    public final f8.e f9561n;

    /* renamed from: o, reason: collision with root package name */
    public final a3.b f9562o;

    /* renamed from: p, reason: collision with root package name */
    public final c7.o f9563p;

    /* renamed from: q, reason: collision with root package name */
    public final int f9564q;

    /* renamed from: r, reason: collision with root package name */
    public final int f9565r;

    /* renamed from: s, reason: collision with root package name */
    public final e1 f9566s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f9567t;

    /* renamed from: u, reason: collision with root package name */
    public final h f9568u;

    /* renamed from: v, reason: collision with root package name */
    public final p f9569v;

    /* renamed from: w, reason: collision with root package name */
    public final m0 f9570w;

    /* renamed from: x, reason: collision with root package name */
    public final o9.i f9571x;

    /* renamed from: y, reason: collision with root package name */
    public final d0 f9572y;

    /* renamed from: z, reason: collision with root package name */
    public final r8.d f9573z;

    static {
        d7.n.x0(new String[]{"equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString"});
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public j(a3.b r11, f8.j r12, l8.o r13, f8.e r14) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.j.<init>(a3.b, f8.j, l8.o, f8.e):void");
    }

    @Override // f8.e
    public final boolean A0() {
        return false;
    }

    @Override // f8.e
    public final int B() {
        return this.f9564q;
    }

    @Override // f8.e
    public final boolean C() {
        return false;
    }

    public final p C0() {
        return (p) super.p0();
    }

    @Override // f8.e
    public final Collection E() {
        return (List) this.f9569v.f9591q.c();
    }

    @Override // f8.e
    public final boolean J() {
        return false;
    }

    @Override // i8.z
    public final o9.n T(w9.g gVar) {
        m0 m0Var = this.f9570w;
        l9.d.j(m0Var.f3482a);
        return (p) ((o9.n) n7.b.q(m0Var.f3484c, m0.f3481e[0]));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [d7.z, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.ArrayList] */
    @Override // f8.e
    public final Collection U() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class[] clsArr;
        ?? arrayList = d7.z.f2978f;
        if (this.f9565r != 2) {
            return arrayList;
        }
        Object obj = null;
        t8.a aVarX = n7.b.x(2, false, null, 7);
        Class cls = this.f9560m.f5878a;
        q7.k.e(cls, "clazz");
        i5.f fVar = w7.e0.f10865b;
        if (fVar == null) {
            try {
                fVar = new i5.f(Class.class.getMethod("isSealed", null), Class.class.getMethod("getPermittedSubclasses", null), Class.class.getMethod("isRecord", null), Class.class.getMethod("getRecordComponents", null), 11);
            } catch (NoSuchMethodException unused) {
                fVar = new i5.f(obj, obj, obj, obj, 11);
            }
            w7.e0.f10865b = fVar;
        }
        Method method = (Method) fVar.f4654h;
        if (method == null) {
            clsArr = null;
        } else {
            Object objInvoke = method.invoke(cls, null);
            q7.k.c(objInvoke, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
            clsArr = (Class[]) objInvoke;
        }
        if (clsArr != null) {
            arrayList = new ArrayList(clsArr.length);
            for (Class cls2 : clsArr) {
                arrayList.add(new l8.q(cls2));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f8.g gVarC = ((i5.l) this.f9562o.f166j).R((l8.q) it.next(), aVarX).E0().c();
            f8.e eVar = gVarC instanceof f8.e ? (f8.e) gVarC : null;
            if (eVar != null) {
                arrayList2.add(eVar);
            }
        }
        return d7.r.j1(arrayList2, new i());
    }

    @Override // f8.w
    public final boolean Z() {
        return false;
    }

    @Override // f8.e, f8.m, f8.w
    public final f8.n c() {
        f8.n nVar = f8.o.f3488a;
        e1 e1Var = this.f9566s;
        if (q7.k.a(e1Var, nVar)) {
            Class<?> declaringClass = this.f9560m.f5878a.getDeclaringClass();
            if ((declaringClass != null ? new l8.o(declaringClass) : null) == null) {
                f8.n nVar2 = o8.o.f7835a;
                q7.k.d(nVar2, "{\n            JavaDescri…KAGE_VISIBILITY\n        }");
                return nVar2;
            }
        }
        return n7.a.B(e1Var);
    }

    @Override // f8.e
    public final boolean e() {
        return false;
    }

    @Override // g8.a
    public final g8.j getAnnotations() {
        return this.f9573z;
    }

    @Override // f8.g
    public final v9.m0 h() {
        return this.f9568u;
    }

    @Override // i8.b, f8.e
    public final o9.n h0() {
        return this.f9571x;
    }

    @Override // f8.e, f8.w
    public final int i() {
        return this.f9565r;
    }

    @Override // f8.e
    public final r0 i0() {
        return null;
    }

    @Override // f8.e
    public final i8.i k0() {
        return null;
    }

    @Override // f8.e
    public final boolean l() {
        return false;
    }

    @Override // f8.e
    public final o9.n l0() {
        return this.f9572y;
    }

    @Override // f8.h
    public final boolean m() {
        return this.f9567t;
    }

    @Override // i8.b, f8.e
    public final o9.n p0() {
        return (p) super.p0();
    }

    @Override // f8.w
    public final boolean r0() {
        return false;
    }

    @Override // f8.e, f8.h
    public final List s() {
        return (List) this.A.c();
    }

    public final String toString() {
        return "Lazy Java class " + l9.d.h(this);
    }
}
