package u8;

import X8.K;
import a.AbstractC0291a;
import h8.AbstractC1508P;
import h8.AbstractC1532o;
import h8.C1502J;
import h8.C1504L;
import h8.C1515X;
import h8.C1531n;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1527j;
import h8.a0;
import h8.d0;
import i8.InterfaceC1561g;
import i9.C1569d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import k8.AbstractC1641j;
import k8.C1640i;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import l8.C1664a;
import l8.C1665b;
import l8.C1666c;
import q8.AbstractC1841n;
import t8.C2024a;
import t8.C2026c;
import v8.C2065a;

/* loaded from: classes4.dex */
public final class j extends AbstractC1641j implements s8.c {

    /* renamed from: w, reason: collision with root package name */
    public static final Set f6720w = D7.q.K0(new String[]{"equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString"});
    public final K1.a g;
    public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a h;
    public final InterfaceC1522e i;

    /* renamed from: j, reason: collision with root package name */
    public final K1.a f6721j;
    public final C7.f k;
    public final ClassKind l;
    public final Modality m;
    public final d0 n;
    public final boolean o;
    public final V8.i p;

    /* renamed from: q, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a f6722q;

    /* renamed from: r, reason: collision with root package name */
    public final C1502J f6723r;

    /* renamed from: s, reason: collision with root package name */
    public final Q8.i f6724s;

    /* renamed from: t, reason: collision with root package name */
    public final C2045C f6725t;
    public final C2026c u;

    /* renamed from: v, reason: collision with root package name */
    public final W8.h f6726v;

    /* JADX WARN: Illegal instructions before constructor call */
    public j(K1.a outerContext, InterfaceC1527j containingDeclaration, kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a jClass, InterfaceC1522e interfaceC1522e) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Modality modality;
        kotlin.jvm.internal.k.f(outerContext, "outerContext");
        kotlin.jvm.internal.k.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.k.f(jClass, "jClass");
        C2024a c2024a = (C2024a) outerContext.f903a;
        super(c2024a.f6670a, containingDeclaration, jClass.f(), c2024a.f6671j.b(jClass));
        this.g = outerContext;
        this.h = jClass;
        this.i = interfaceC1522e;
        K1.a aVarO = Z6.k.o(outerContext, this, jClass, 4);
        this.f6721j = aVarO;
        C2024a c2024a2 = (C2024a) aVarO.f903a;
        W8.l storageManager = c2024a2.f6670a;
        c2024a2.g.getClass();
        this.k = kotlin.a.a(new h(this, 0));
        Class cls = jClass.f4985a;
        this.l = cls.isAnnotation() ? ClassKind.e : cls.isInterface() ? ClassKind.b : cls.isEnum() ? ClassKind.c : ClassKind.f4951a;
        if (cls.isAnnotation() || cls.isEnum()) {
            modality = Modality.b;
        } else {
            C1504L c1504l = Modality.f4953a;
            boolean zI = jClass.i();
            boolean z10 = jClass.i() || Modifier.isAbstract(cls.getModifiers()) || cls.isInterface();
            boolean zIsFinal = Modifier.isFinal(cls.getModifiers());
            c1504l.getClass();
            modality = zI ? Modality.c : z10 ? Modality.e : !zIsFinal ? Modality.d : Modality.b;
        }
        this.m = modality;
        int modifiers = cls.getModifiers();
        this.n = Modifier.isPublic(modifiers) ? a0.c : Modifier.isPrivate(modifiers) ? C1515X.c : Modifier.isProtected(modifiers) ? Modifier.isStatic(modifiers) ? C1666c.c : C1665b.c : C1664a.c;
        Class<?> declaringClass = cls.getDeclaringClass();
        this.o = ((declaringClass != null ? new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a(declaringClass) : null) == null || Modifier.isStatic(cls.getModifiers())) ? false : true;
        this.p = new V8.i(this);
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a aVar = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a(aVarO, this, jClass, interfaceC1522e != null, null);
        this.f6722q = aVar;
        C1504L c1504l2 = C1502J.d;
        ((Y8.l) c2024a2.u).getClass();
        J4.b bVar = new J4.b(this, 24);
        c1504l2.getClass();
        kotlin.jvm.internal.k.f(storageManager, "storageManager");
        this.f6723r = new C1502J(this, storageManager, bVar);
        this.f6724s = new Q8.i(aVar);
        this.f6725t = new C2045C(aVarO, jClass, this);
        this.u = AbstractC0291a.G(aVarO, jClass);
        h hVar = new h(this, 1);
        W8.i iVar = (W8.i) storageManager;
        iVar.getClass();
        this.f6726v = new W8.h(iVar, hVar);
    }

    @Override // k8.y
    public final Q8.o A(Y8.f fVar) {
        C1502J c1502j = this.f6723r;
        kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.j(c1502j.f4576a);
        return (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a) ((Q8.o) S0.b.g1(c1502j.c, C1502J.e[0]));
    }

    @Override // h8.InterfaceC1522e
    public final boolean A0() {
        return false;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a L() {
        return (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a) super.R();
    }

    @Override // k8.AbstractC1633b, h8.InterfaceC1522e
    public final Q8.o O() {
        return this.f6724s;
    }

    @Override // h8.InterfaceC1522e
    public final AbstractC1508P P() {
        return null;
    }

    @Override // k8.AbstractC1633b, h8.InterfaceC1522e
    public final Q8.o R() {
        return (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a) super.R();
    }

    @Override // h8.InterfaceC1539v
    public final boolean S() {
        return false;
    }

    @Override // h8.InterfaceC1522e
    public final boolean X() {
        return false;
    }

    @Override // h8.InterfaceC1522e
    public final boolean c0() {
        return false;
    }

    @Override // h8.InterfaceC1539v
    public final boolean g0() {
        return false;
    }

    @Override // i8.InterfaceC1555a
    public final InterfaceC1561g getAnnotations() {
        return this.u;
    }

    @Override // h8.InterfaceC1522e
    public final ClassKind getKind() {
        return this.l;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1539v
    public final C1531n getVisibility() {
        C1531n c1531n = AbstractC1532o.f4583a;
        d0 d0Var = this.n;
        if (kotlin.jvm.internal.k.b(d0Var, c1531n)) {
            Class<?> declaringClass = this.h.f4985a.getDeclaringClass();
            if ((declaringClass != null ? new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a(declaringClass) : null) == null) {
                C1531n c1531n2 = AbstractC1841n.f5605a;
                kotlin.jvm.internal.k.c(c1531n2);
                return c1531n2;
            }
        }
        return U7.a.X(d0Var);
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1525h
    public final List h() {
        return (List) this.f6726v.invoke();
    }

    @Override // h8.InterfaceC1522e
    public final Q8.o h0() {
        return this.f6725t;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1539v
    public final Modality i() {
        return this.m;
    }

    @Override // h8.InterfaceC1522e
    public final boolean isInline() {
        return false;
    }

    @Override // h8.InterfaceC1522e
    public final boolean j() {
        return false;
    }

    @Override // h8.InterfaceC1524g
    public final K m() {
        return this.p;
    }

    @Override // h8.InterfaceC1522e
    public final Collection n() {
        return (List) this.f6722q.f4998q.invoke();
    }

    @Override // h8.InterfaceC1522e
    public final Collection p() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class[] clsArr;
        i9.i iVarS0;
        if (this.m != Modality.c) {
            return EmptyList.f4893a;
        }
        Object obj = null;
        C2065a c2065aO0 = M.a.o0(TypeUsage.b, false, null, 7);
        Class clazz = this.h.f4985a;
        kotlin.jvm.internal.k.f(clazz, "clazz");
        u1.d dVar = z2.l.i;
        if (dVar == null) {
            try {
                dVar = new u1.d(Class.class.getMethod("isSealed", null), Class.class.getMethod("getPermittedSubclasses", null), Class.class.getMethod("isRecord", null), Class.class.getMethod("getRecordComponents", null), 19);
            } catch (NoSuchMethodException unused) {
                dVar = new u1.d(obj, obj, obj, obj, 19);
            }
            z2.l.i = dVar;
        }
        Method method = (Method) dVar.c;
        if (method == null) {
            clsArr = null;
        } else {
            Object objInvoke = method.invoke(clazz, null);
            kotlin.jvm.internal.k.d(objInvoke, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
            clsArr = (Class[]) objInvoke;
        }
        if (clsArr != null) {
            ArrayList arrayList = new ArrayList(clsArr.length);
            for (Class cls : clsArr) {
                arrayList.add(new n8.j(cls));
            }
            iVarS0 = D7.v.s0(arrayList);
        } else {
            iVarS0 = C1569d.f4618a;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = iVarS0.iterator();
        while (it.hasNext()) {
            InterfaceC1524g interfaceC1524gD = ((A5.c) this.f6721j.e).C((n8.j) it.next(), c2065aO0).Q().d();
            InterfaceC1522e interfaceC1522e = interfaceC1524gD instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1524gD : null;
            if (interfaceC1522e != null) {
                arrayList2.add(interfaceC1522e);
            }
        }
        return D7.v.Z0(arrayList2, new i());
    }

    @Override // h8.InterfaceC1525h
    public final boolean q() {
        return this.o;
    }

    public final String toString() {
        return "Lazy Java class " + kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.h(this);
    }

    @Override // h8.InterfaceC1522e
    public final C1640i u() {
        return null;
    }
}
