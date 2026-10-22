package kotlin.reflect.jvm.internal;

import D7.v;
import D8.h;
import E8.c;
import G8.f;
import H4.o;
import H8.l;
import T8.m;
import W8.i;
import Z7.d;
import Z7.t;
import b8.AbstractC0830C;
import b8.C0858t;
import b8.C0862x;
import b8.C0864z;
import b8.n0;
import b8.p0;
import b8.t0;
import b8.v0;
import e8.n;
import g8.C1468d;
import h8.InterfaceC1501I;
import h8.InterfaceC1522e;
import java.util.Collection;
import java.util.List;
import k8.C1642k;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import m8.e;
import n8.AbstractC1744c;

/* loaded from: classes4.dex */
public final class a extends AbstractC0830C implements d, n0 {
    public static final /* synthetic */ int d = 0;
    public final Class b;
    public final Object c;

    public a(Class jClass) {
        k.f(jClass, "jClass");
        this.b = jClass;
        this.c = kotlin.a.b(LazyThreadSafetyMode.b, new C0858t(this, 0));
    }

    public static C1642k v(G8.b bVar, e eVar) {
        T8.k kVar = eVar.f5309a;
        g8.k kVar2 = new g8.k(kVar.b, bVar.f687a, 1);
        f fVarF = bVar.f();
        Modality modality = Modality.b;
        ClassKind classKind = ClassKind.f4951a;
        List listM = o.M(kVar.b.c().j("Any").g());
        i iVar = kVar.f1222a;
        C1642k c1642k = new C1642k(kVar2, fVarF, modality, classKind, listM, iVar);
        c1642k.L(new C0864z(iVar, c1642k), EmptySet.f4895a, null);
        return c1642k;
    }

    @Override // kotlin.jvm.internal.c
    public final Class b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && M.a.a0(this).equals(M.a.a0((d) obj));
    }

    @Override // b8.AbstractC0830C
    public final Collection g() {
        InterfaceC1522e interfaceC1522eX = x();
        if (interfaceC1522eX.getKind() == ClassKind.b || interfaceC1522eX.getKind() == ClassKind.f) {
            return EmptyList.f4893a;
        }
        Collection collectionN = interfaceC1522eX.n();
        k.e(collectionN, "getConstructors(...)");
        return collectionN;
    }

    @Override // b8.AbstractC0830C
    public final Collection h(f fVar) {
        Q8.o oVarW = x().g().w();
        NoLookupLocation noLookupLocation = NoLookupLocation.b;
        Collection collectionF = oVarW.f(fVar, noLookupLocation);
        Q8.o oVarH0 = x().h0();
        k.e(oVarH0, "getStaticScope(...)");
        return v.Q0(oVarH0.f(fVar, noLookupLocation), collectionF);
    }

    @Override // Z7.d
    public final int hashCode() {
        return M.a.a0(this).hashCode();
    }

    @Override // b8.AbstractC0830C
    public final InterfaceC1501I i(int i) {
        Class<?> declaringClass;
        Class cls = this.b;
        if (cls.getSimpleName().equals("DefaultImpls") && (declaringClass = cls.getDeclaringClass()) != null && declaringClass.isInterface()) {
            return ((a) M.a.c0(declaringClass)).i(i);
        }
        InterfaceC1522e interfaceC1522eX = x();
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b bVar = interfaceC1522eX instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b ? (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b) interfaceC1522eX : null;
        if (bVar != null) {
            ProtoBuf$Class protoBuf$Class = bVar.e;
            l classLocalVariable = c.f495j;
            k.e(classLocalVariable, "classLocalVariable");
            ProtoBuf$Property protoBuf$Property = (ProtoBuf$Property) h.b(protoBuf$Class, classLocalVariable, i);
            if (protoBuf$Property != null) {
                m mVar = bVar.l;
                return (InterfaceC1501I) v0.f(this.b, protoBuf$Property, mVar.b, mVar.d, bVar.f, KClassImpl$getLocalProperty$2$1$1.f4937a);
            }
        }
        return null;
    }

    @Override // Z7.d
    public final boolean j() {
        return x().j();
    }

    @Override // Z7.d
    public final boolean k(Object obj) {
        List list = AbstractC1744c.f5355a;
        Class cls = this.b;
        k.f(cls, "<this>");
        Integer num = (Integer) AbstractC1744c.d.get(cls);
        if (num != null) {
            return p.g(num.intValue(), obj);
        }
        Class cls2 = (Class) AbstractC1744c.c.get(cls);
        if (cls2 != null) {
            cls = cls2;
        }
        return cls.isInstance(obj);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [C7.f, java.lang.Object] */
    @Override // Z7.d
    public final String l() {
        p0 p0Var = ((C0862x) this.c.getF4884a()).e;
        t tVar = C0862x.l[3];
        return (String) p0Var.invoke();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [C7.f, java.lang.Object] */
    @Override // Z7.d
    public final String m() {
        p0 p0Var = ((C0862x) this.c.getF4884a()).d;
        t tVar = C0862x.l[2];
        return (String) p0Var.invoke();
    }

    @Override // b8.AbstractC0830C
    public final Collection p(f fVar) {
        Q8.o oVarW = x().g().w();
        NoLookupLocation noLookupLocation = NoLookupLocation.b;
        Collection collectionD = oVarW.d(fVar, noLookupLocation);
        Q8.o oVarH0 = x().h0();
        k.e(oVarH0, "getStaticScope(...)");
        return v.Q0(oVarH0.d(fVar, noLookupLocation), collectionD);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("class ");
        G8.b bVarW = w();
        G8.c cVar = bVarW.f687a;
        String strConcat = cVar.d() ? "" : cVar.b().concat(".");
        sb.append(strConcat + j9.t.b0(bVarW.b.b(), '.', '$'));
        return sb.toString();
    }

    public final G8.b w() {
        PrimitiveType primitiveTypeD;
        G8.b bVar = t0.f2056a;
        Class klass = this.b;
        k.f(klass, "klass");
        if (klass.isArray()) {
            Class<?> componentType = klass.getComponentType();
            k.e(componentType, "getComponentType(...)");
            primitiveTypeD = componentType.isPrimitive() ? JvmPrimitiveType.b(componentType.getSimpleName()).d() : null;
            if (primitiveTypeD != null) {
                return new G8.b(e8.o.l, primitiveTypeD.b);
            }
            G8.c cVarG = n.g.g();
            G8.c cVarE = cVarG.e();
            f fVarF = cVarG.f();
            k.e(fVarF, "shortName(...)");
            return new G8.b(cVarE, fVarF);
        }
        if (klass.equals(Void.TYPE)) {
            return t0.f2056a;
        }
        primitiveTypeD = klass.isPrimitive() ? JvmPrimitiveType.b(klass.getSimpleName()).d() : null;
        if (primitiveTypeD != null) {
            return new G8.b(e8.o.l, primitiveTypeD.f4943a);
        }
        G8.b bVarA = AbstractC1744c.a(klass);
        if (!bVarA.c) {
            String str = C1468d.f4490a;
            G8.c fqName = bVarA.a();
            k.f(fqName, "fqName");
            G8.b bVar2 = (G8.b) C1468d.h.get(fqName.i());
            if (bVar2 != null) {
                return bVar2;
            }
        }
        return bVarA;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    public final InterfaceC1522e x() {
        return ((C0862x) this.c.getF4884a()).a();
    }
}
