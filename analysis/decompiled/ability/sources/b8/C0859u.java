package b8;

import h8.InterfaceC1522e;
import h8.InterfaceC1527j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: b8.u, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0859u implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2057a;
    public final C0862x b;

    public /* synthetic */ C0859u(C0862x c0862x, int i) {
        this.f2057a = i;
        this.b = c0862x;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f2057a) {
            case 0:
                C0862x c0862x = this.b;
                p0 p0Var = c0862x.f;
                Z7.t[] tVarArr = C0862x.l;
                Z7.t tVar = tVarArr[9];
                Object objInvoke = p0Var.invoke();
                kotlin.jvm.internal.k.e(objInvoke, "getValue(...)");
                p0 p0Var2 = c0862x.h;
                Z7.t tVar2 = tVarArr[11];
                Object objInvoke2 = p0Var2.invoke();
                kotlin.jvm.internal.k.e(objInvoke2, "getValue(...)");
                return D7.v.Q0((Collection) objInvoke2, (Collection) objInvoke);
            case 1:
                C0862x c0862x2 = this.b;
                p0 p0Var3 = c0862x2.g;
                Z7.t[] tVarArr2 = C0862x.l;
                Z7.t tVar3 = tVarArr2[10];
                Object objInvoke3 = p0Var3.invoke();
                kotlin.jvm.internal.k.e(objInvoke3, "getValue(...)");
                p0 p0Var4 = c0862x2.i;
                Z7.t tVar4 = tVarArr2[12];
                Object objInvoke4 = p0Var4.invoke();
                kotlin.jvm.internal.k.e(objInvoke4, "getValue(...)");
                return D7.v.Q0((Collection) objInvoke4, (Collection) objInvoke3);
            case 2:
                C0862x c0862x3 = this.b;
                p0 p0Var5 = c0862x3.f;
                Z7.t[] tVarArr3 = C0862x.l;
                Z7.t tVar5 = tVarArr3[9];
                Object objInvoke5 = p0Var5.invoke();
                kotlin.jvm.internal.k.e(objInvoke5, "getValue(...)");
                p0 p0Var6 = c0862x3.g;
                Z7.t tVar6 = tVarArr3[10];
                Object objInvoke6 = p0Var6.invoke();
                kotlin.jvm.internal.k.e(objInvoke6, "getValue(...)");
                return D7.v.Q0((Collection) objInvoke6, (Collection) objInvoke5);
            case 3:
                C0862x c0862x4 = this.b;
                p0 p0Var7 = c0862x4.f2063j;
                Z7.t[] tVarArr4 = C0862x.l;
                Z7.t tVar7 = tVarArr4[13];
                Object objInvoke7 = p0Var7.invoke();
                kotlin.jvm.internal.k.e(objInvoke7, "getValue(...)");
                p0 p0Var8 = c0862x4.k;
                Z7.t tVar8 = tVarArr4[14];
                Object objInvoke8 = p0Var8.invoke();
                kotlin.jvm.internal.k.e(objInvoke8, "getValue(...)");
                return D7.v.Q0((Collection) objInvoke8, (Collection) objInvoke7);
            case 4:
                return v0.d(this.b.a());
            case 5:
                Collection collectionZ = z2.l.z(this.b.a().O(), null, 3);
                ArrayList arrayList = new ArrayList();
                for (Object obj : collectionZ) {
                    if (!J8.e.m((InterfaceC1527j) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    InterfaceC1527j interfaceC1527j = (InterfaceC1527j) it.next();
                    InterfaceC1522e interfaceC1522e = interfaceC1527j instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1527j : null;
                    Class clsK = interfaceC1522e != null ? v0.k(interfaceC1522e) : null;
                    kotlin.reflect.jvm.internal.a aVar = clsK != null ? new kotlin.reflect.jvm.internal.a(clsK) : null;
                    if (aVar != null) {
                        arrayList2.add(aVar);
                    }
                }
                return arrayList2;
            default:
                Collection<InterfaceC1522e> collectionP = this.b.a().p();
                kotlin.jvm.internal.k.e(collectionP, "getSealedSubclasses(...)");
                ArrayList arrayList3 = new ArrayList();
                for (InterfaceC1522e interfaceC1522e2 : collectionP) {
                    kotlin.jvm.internal.k.d(interfaceC1522e2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    Class clsK2 = v0.k(interfaceC1522e2);
                    kotlin.reflect.jvm.internal.a aVar2 = clsK2 != null ? new kotlin.reflect.jvm.internal.a(clsK2) : null;
                    if (aVar2 != null) {
                        arrayList3.add(aVar2);
                    }
                }
                return arrayList3;
        }
    }
}
