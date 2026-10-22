package J8;

import D7.v;
import X8.K;
import h8.InterfaceC1494B;
import h8.InterfaceC1503K;
import h8.InterfaceC1507O;
import h8.InterfaceC1519b;
import h8.InterfaceC1520c;
import h8.InterfaceC1522e;
import h8.InterfaceC1527j;
import h8.InterfaceC1539v;
import java.util.Collection;
import k8.AbstractC1629B;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo$Result;

/* loaded from: classes4.dex */
public final class c implements Y8.c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f882a = new c();

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i != 1) {
            objArr[0] = "a";
        } else {
            objArr[0] = "b";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
        objArr[2] = "equals";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static InterfaceC1503K d(InterfaceC1519b interfaceC1519b) {
        while (interfaceC1519b instanceof InterfaceC1520c) {
            InterfaceC1520c interfaceC1520c = (InterfaceC1520c) interfaceC1519b;
            if (interfaceC1520c.getKind() != CallableMemberDescriptor$Kind.b) {
                break;
            }
            Collection collectionE = interfaceC1520c.e();
            kotlin.jvm.internal.k.e(collectionE, "getOverriddenDescriptors(...)");
            interfaceC1519b = (InterfaceC1520c) v.V0(collectionE);
            if (interfaceC1519b == null) {
                return null;
            }
        }
        return interfaceC1519b.getSource();
    }

    public boolean b(InterfaceC1527j interfaceC1527j, InterfaceC1527j interfaceC1527j2, boolean z10) {
        if ((interfaceC1527j instanceof InterfaceC1522e) && (interfaceC1527j2 instanceof InterfaceC1522e)) {
            return kotlin.jvm.internal.k.b(((InterfaceC1522e) interfaceC1527j).m(), ((InterfaceC1522e) interfaceC1527j2).m());
        }
        if ((interfaceC1527j instanceof InterfaceC1507O) && (interfaceC1527j2 instanceof InterfaceC1507O)) {
            return c((InterfaceC1507O) interfaceC1527j, (InterfaceC1507O) interfaceC1527j2, z10, a.f880a);
        }
        if (!(interfaceC1527j instanceof InterfaceC1519b) || !(interfaceC1527j2 instanceof InterfaceC1519b)) {
            return ((interfaceC1527j instanceof InterfaceC1494B) && (interfaceC1527j2 instanceof InterfaceC1494B)) ? kotlin.jvm.internal.k.b(((AbstractC1629B) ((InterfaceC1494B) interfaceC1527j)).e, ((AbstractC1629B) ((InterfaceC1494B) interfaceC1527j2)).e) : kotlin.jvm.internal.k.b(interfaceC1527j, interfaceC1527j2);
        }
        InterfaceC1519b a3 = (InterfaceC1519b) interfaceC1527j;
        InterfaceC1519b b = (InterfaceC1519b) interfaceC1527j2;
        kotlin.jvm.internal.k.f(a3, "a");
        kotlin.jvm.internal.k.f(b, "b");
        if (!a3.equals(b)) {
            if (kotlin.jvm.internal.k.b(a3.getName(), b.getName()) && ((!(a3 instanceof InterfaceC1539v) || !(b instanceof InterfaceC1539v) || ((InterfaceC1539v) a3).g0() == ((InterfaceC1539v) b).g0()) && ((!kotlin.jvm.internal.k.b(a3.d(), b.d()) || (z10 && kotlin.jvm.internal.k.b(d(a3), d(b)))) && !e.o(a3) && !e.o(b)))) {
                InterfaceC1527j interfaceC1527jD = a3.d();
                InterfaceC1527j interfaceC1527jD2 = b.d();
                if (((interfaceC1527jD instanceof InterfaceC1520c) || (interfaceC1527jD2 instanceof InterfaceC1520c)) ? false : b(interfaceC1527jD, interfaceC1527jD2, z10)) {
                    B0.f fVar = new B0.f();
                    fVar.b = z10;
                    fVar.f177a = a3;
                    fVar.c = b;
                    k kVar = new k(fVar);
                    OverridingUtil$OverrideCompatibilityInfo$Result overridingUtil$OverrideCompatibilityInfo$ResultB = kVar.m(a3, b, null, true).b();
                    OverridingUtil$OverrideCompatibilityInfo$Result overridingUtil$OverrideCompatibilityInfo$Result = OverridingUtil$OverrideCompatibilityInfo$Result.f5116a;
                    if (overridingUtil$OverrideCompatibilityInfo$ResultB != overridingUtil$OverrideCompatibilityInfo$Result || kVar.m(b, a3, null, true).b() != overridingUtil$OverrideCompatibilityInfo$Result) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public boolean c(InterfaceC1507O a3, InterfaceC1507O b, boolean z10, S7.n nVar) {
        kotlin.jvm.internal.k.f(a3, "a");
        kotlin.jvm.internal.k.f(b, "b");
        if (a3.equals(b)) {
            return true;
        }
        if (kotlin.jvm.internal.k.b(a3.d(), b.d())) {
            return false;
        }
        InterfaceC1527j interfaceC1527jD = a3.d();
        InterfaceC1527j interfaceC1527jD2 = b.d();
        return (((interfaceC1527jD instanceof InterfaceC1520c) || (interfaceC1527jD2 instanceof InterfaceC1520c)) ? ((Boolean) nVar.invoke(interfaceC1527jD, interfaceC1527jD2)).booleanValue() : b(interfaceC1527jD, interfaceC1527jD2, z10)) && a3.getIndex() == b.getIndex();
    }

    @Override // Y8.c
    public boolean e(K k, K k5) {
        if (k == null) {
            a(0);
            throw null;
        }
        if (k5 != null) {
            return k.equals(k5);
        }
        a(1);
        throw null;
    }
}
