package d9;

import X8.A;
import X8.AbstractC0272c;
import X8.F;
import X8.H;
import X8.S;
import h8.InterfaceC1507O;
import h8.InterfaceC1522e;
import h8.InterfaceC1540w;
import java.util.Collection;
import java.util.List;
import k8.Q;

/* renamed from: d9.l, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1391l implements InterfaceC1384e {
    public static final C1391l b = new C1391l(0);
    public static final C1391l c = new C1391l(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4311a;

    public /* synthetic */ C1391l(int i) {
        this.f4311a = i;
    }

    @Override // d9.InterfaceC1384e
    public final boolean a(kotlin.reflect.jvm.internal.impl.load.java.descriptors.a aVar) {
        A aT;
        switch (this.f4311a) {
            case 0:
                Q q5 = (Q) aVar.x().get(1);
                e8.l lVar = e8.m.d;
                kotlin.jvm.internal.k.c(q5);
                InterfaceC1540w interfaceC1540wJ = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.j(q5);
                lVar.getClass();
                InterfaceC1522e interfaceC1522eA = kotlin.reflect.jvm.internal.impl.descriptors.a.a(interfaceC1540wJ, e8.n.f4404R);
                if (interfaceC1522eA == null) {
                    aT = null;
                } else {
                    H.b.getClass();
                    H h = H.c;
                    List parameters = interfaceC1522eA.m().getParameters();
                    kotlin.jvm.internal.k.e(parameters, "getParameters(...)");
                    Object objU0 = D7.v.U0(parameters);
                    kotlin.jvm.internal.k.e(objU0, "single(...)");
                    aT = AbstractC0272c.t(h, interfaceC1522eA, H4.o.M(new F((InterfaceC1507O) objU0)));
                }
                if (aT == null) {
                    return false;
                }
                X8.w type = q5.getType();
                kotlin.jvm.internal.k.e(type, "getType(...)");
                return Y8.d.f1572a.b(aT, S.g(type, false));
            default:
                List listX = aVar.x();
                kotlin.jvm.internal.k.e(listX, "getValueParameters(...)");
                List<Q> list = listX;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    for (Q q10 : list) {
                        kotlin.jvm.internal.k.c(q10);
                        if (kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.a(q10) || q10.f4842j != null) {
                            return false;
                        }
                    }
                }
                return true;
        }
    }

    @Override // d9.InterfaceC1384e
    public final String b(kotlin.reflect.jvm.internal.impl.load.java.descriptors.a aVar) {
        switch (this.f4311a) {
        }
        return com.stepos.ability.task.executor.e.F(this, aVar);
    }

    @Override // d9.InterfaceC1384e
    public final String getDescription() {
        switch (this.f4311a) {
            case 0:
                return "second parameter must be of type KProperty<*> or its supertype";
            default:
                return "should not have varargs or parameters with default values";
        }
    }
}
