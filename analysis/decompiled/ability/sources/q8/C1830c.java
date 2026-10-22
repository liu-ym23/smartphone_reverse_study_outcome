package q8;

import h8.InterfaceC1520c;
import h8.InterfaceC1536s;
import k8.K;
import k8.Q;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures$SpecialSignatureInfo;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures$TypeSafeBarrierDescription;

/* renamed from: q8.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1830c implements S7.k {
    public static final C1830c b = new C1830c(0);
    public static final C1830c c = new C1830c(1);
    public static final C1830c d = new C1830c(2);
    public static final C1830c e = new C1830c(3);
    public static final C1830c f = new C1830c(4);
    public static final C1830c g = new C1830c(5);
    public static final C1830c h = new C1830c(6);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5598a;

    public /* synthetic */ C1830c(int i) {
        this.f5598a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        InterfaceC1520c interfaceC1520cB;
        String strU;
        boolean z10 = false;
        switch (this.f5598a) {
            case 0:
                InterfaceC1520c it = (InterfaceC1520c) obj;
                int i = AbstractC1831d.l;
                kotlin.jvm.internal.k.f(it, "it");
                return Boolean.valueOf(D7.v.u0(z.f, com.stepos.ability.task.executor.e.u(it)));
            case 1:
                InterfaceC1520c it2 = (InterfaceC1520c) obj;
                int i6 = AbstractC1831d.l;
                kotlin.jvm.internal.k.f(it2, "it");
                if ((it2 instanceof InterfaceC1536s) && D7.v.u0(z.f, com.stepos.ability.task.executor.e.u(it2))) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            case 2:
                InterfaceC1520c it3 = (InterfaceC1520c) obj;
                kotlin.jvm.internal.k.f(it3, "it");
                return Boolean.valueOf(M.a.g0(it3));
            case 3:
                return ((Q) obj).getType();
            case 4:
                InterfaceC1520c it4 = (InterfaceC1520c) obj;
                kotlin.jvm.internal.k.f(it4, "it");
                return Boolean.valueOf(M.a.g0(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.k(it4)));
            case 5:
                InterfaceC1520c it5 = (InterfaceC1520c) obj;
                kotlin.jvm.internal.k.f(it5, "it");
                int i10 = AbstractC1829b.l;
                K k = (K) it5;
                if (e8.i.z(k) && kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.b(k, new J4.b(k, 17)) != null) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            default:
                InterfaceC1520c it6 = (InterfaceC1520c) obj;
                kotlin.jvm.internal.k.f(it6, "it");
                if (e8.i.z(it6)) {
                    int i11 = AbstractC1831d.l;
                    SpecialGenericSignatures$SpecialSignatureInfo specialGenericSignatures$SpecialSignatureInfo = null;
                    if (z.e.contains(it6.getName()) && (interfaceC1520cB = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.b(it6, c)) != null && (strU = com.stepos.ability.task.executor.e.u(interfaceC1520cB)) != null) {
                        specialGenericSignatures$SpecialSignatureInfo = z.b.contains(strU) ? SpecialGenericSignatures$SpecialSignatureInfo.f4990a : ((SpecialGenericSignatures$TypeSafeBarrierDescription) kotlin.collections.a.N(strU, z.d)) == SpecialGenericSignatures$TypeSafeBarrierDescription.b ? SpecialGenericSignatures$SpecialSignatureInfo.c : SpecialGenericSignatures$SpecialSignatureInfo.b;
                    }
                    if (specialGenericSignatures$SpecialSignatureInfo != null) {
                        z10 = true;
                    }
                }
                return Boolean.valueOf(z10);
        }
    }
}
