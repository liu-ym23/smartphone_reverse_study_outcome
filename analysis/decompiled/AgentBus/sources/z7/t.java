package z7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class t extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f11955g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ x f11956h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(x xVar, int i2) {
        super(0);
        this.f11955g = i2;
        this.f11956h = xVar;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f11955g) {
            case 0:
                x xVar = this.f11956h;
                q1 q1Var = xVar.f11986l;
                w7.t[] tVarArr = x.f11976n;
                w7.t tVar = tVarArr[14];
                Object objC = q1Var.c();
                q7.k.d(objC, "<get-allNonStaticMembers>(...)");
                q1 q1Var2 = xVar.f11987m;
                w7.t tVar2 = tVarArr[15];
                Object objC2 = q1Var2.c();
                q7.k.d(objC2, "<get-allStaticMembers>(...)");
                return d7.r.c1((Collection) objC, (Collection) objC2);
            case 1:
                x xVar2 = this.f11956h;
                q1 q1Var3 = xVar2.f11982h;
                w7.t[] tVarArr2 = x.f11976n;
                w7.t tVar3 = tVarArr2[10];
                Object objC3 = q1Var3.c();
                q7.k.d(objC3, "<get-declaredNonStaticMembers>(...)");
                q1 q1Var4 = xVar2.f11984j;
                w7.t tVar4 = tVarArr2[12];
                Object objC4 = q1Var4.c();
                q7.k.d(objC4, "<get-inheritedNonStaticMembers>(...)");
                return d7.r.c1((Collection) objC3, (Collection) objC4);
            case 2:
                x xVar3 = this.f11956h;
                q1 q1Var5 = xVar3.f11983i;
                w7.t[] tVarArr3 = x.f11976n;
                w7.t tVar5 = tVarArr3[11];
                Object objC5 = q1Var5.c();
                q7.k.d(objC5, "<get-declaredStaticMembers>(...)");
                q1 q1Var6 = xVar3.f11985k;
                w7.t tVar6 = tVarArr3[13];
                Object objC6 = q1Var6.c();
                q7.k.d(objC6, "<get-inheritedStaticMembers>(...)");
                return d7.r.c1((Collection) objC5, (Collection) objC6);
            case 3:
                return x1.d(this.f11956h.a());
            case 4:
                x xVar4 = this.f11956h;
                q1 q1Var7 = xVar4.f11982h;
                w7.t[] tVarArr4 = x.f11976n;
                w7.t tVar7 = tVarArr4[10];
                Object objC7 = q1Var7.c();
                q7.k.d(objC7, "<get-declaredNonStaticMembers>(...)");
                q1 q1Var8 = xVar4.f11983i;
                w7.t tVar8 = tVarArr4[11];
                Object objC8 = q1Var8.c();
                q7.k.d(objC8, "<get-declaredStaticMembers>(...)");
                return d7.r.c1((Collection) objC7, (Collection) objC8);
            case 5:
                o9.n nVarH0 = this.f11956h.a().h0();
                q7.k.d(nVarH0, "descriptor.unsubstitutedInnerClassesScope");
                Collection contributedDescriptors$default = o9.p.getContributedDescriptors$default(nVarH0, null, null, 3, null);
                ArrayList arrayList = new ArrayList();
                for (Object obj : contributedDescriptors$default) {
                    if (!h9.f.m((f8.j) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    f8.j jVar = (f8.j) it.next();
                    f8.e eVar = jVar instanceof f8.e ? (f8.e) jVar : null;
                    Class clsJ = eVar != null ? x1.j(eVar) : null;
                    a0 a0Var = clsJ != null ? new a0(clsJ) : null;
                    if (a0Var != null) {
                        arrayList2.add(a0Var);
                    }
                }
                return arrayList2;
            default:
                Collection<f8.e> collectionU = this.f11956h.a().U();
                q7.k.d(collectionU, "descriptor.sealedSubclasses");
                ArrayList arrayList3 = new ArrayList();
                for (f8.e eVar2 : collectionU) {
                    q7.k.c(eVar2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    Class clsJ2 = x1.j(eVar2);
                    a0 a0Var2 = clsJ2 != null ? new a0(clsJ2) : null;
                    if (a0Var2 != null) {
                        arrayList3.add(a0Var2);
                    }
                }
                return arrayList3;
        }
    }
}
