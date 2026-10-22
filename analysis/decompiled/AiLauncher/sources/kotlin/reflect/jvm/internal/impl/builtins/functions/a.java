package kotlin.reflect.jvm.internal.impl.builtins.functions;

import C9.h;
import E9.E;
import E9.InterfaceC0797b;
import E9.InterfaceC0819y;
import La.D;
import La.H;
import Z8.F;
import Z8.Y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.builtins.functions.f;
import xa.InterfaceC5869l;

/* loaded from: classes5.dex */
public final class a implements G9.b {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC5869l f34948a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0819y f34949b;

    public a(InterfaceC5869l storageManager, InterfaceC0819y module) {
        p.i(storageManager, "storageManager");
        p.i(module, "module");
        this.f34948a = storageManager;
        this.f34949b = module;
    }

    @Override // G9.b
    public InterfaceC0797b a(ga.b classId) {
        ga.c cVarF;
        f.b bVarC;
        p.i(classId, "classId");
        if (classId.i() || classId.j()) {
            return null;
        }
        String strA = classId.g().a();
        if (!H.g0(strA, "Function", false, 2, null) || (bVarC = f.f34972c.a().c((cVarF = classId.f()), strA)) == null) {
            return null;
        }
        e eVarA = bVarC.a();
        int iB = bVarC.b();
        List<E> listD0 = this.f34949b.f0(cVarF).d0();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listD0) {
            if (obj instanceof C9.c) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (obj2 instanceof h) {
                arrayList2.add(obj2);
            }
        }
        E e10 = (h) F.s0(arrayList2);
        if (e10 == null) {
            e10 = (C9.c) F.q0(arrayList);
        }
        return new b(this.f34948a, e10, eVarA, iB);
    }

    @Override // G9.b
    public Collection<InterfaceC0797b> b(ga.c packageFqName) {
        p.i(packageFqName, "packageFqName");
        return Y.e();
    }

    @Override // G9.b
    public boolean c(ga.c packageFqName, ga.e name) {
        p.i(packageFqName, "packageFqName");
        p.i(name, "name");
        String strB = name.b();
        p.h(strB, "asString(...)");
        return (D.X(strB, "Function", false, 2, null) || D.X(strB, "KFunction", false, 2, null) || D.X(strB, "SuspendFunction", false, 2, null) || D.X(strB, "KSuspendFunction", false, 2, null)) && f.f34972c.a().c(packageFqName, strB) != null;
    }
}
