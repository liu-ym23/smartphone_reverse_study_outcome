package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import E9.C0810o;
import E9.InterfaceC0797b;
import E9.W;
import F9.g;
import H9.O;
import Z8.C1172u;
import Z8.C1173v;
import ga.e;
import java.util.List;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import ra.AbstractC5233f;
import xa.InterfaceC5869l;

/* loaded from: classes5.dex */
public final class a extends AbstractC5233f {

    /* renamed from: e, reason: collision with root package name */
    public static final C0436a f34997e = new C0436a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final e f34998f;

    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.a$a, reason: collision with other inner class name */
    public static final class C0436a {
        public /* synthetic */ C0436a(i iVar) {
            this();
        }

        public final e a() {
            return a.f34998f;
        }

        public C0436a() {
        }
    }

    static {
        e eVarJ = e.j("clone");
        p.h(eVarJ, "identifier(...)");
        f34998f = eVarJ;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(InterfaceC5869l storageManager, InterfaceC0797b containingClass) {
        super(storageManager, containingClass);
        p.i(storageManager, "storageManager");
        p.i(containingClass, "containingClass");
    }

    @Override // ra.AbstractC5233f
    public List<kotlin.reflect.jvm.internal.impl.descriptors.e> i() {
        O oF1 = O.f1(l(), g.f2609m0.b(), f34998f, CallableMemberDescriptor.Kind.DECLARATION, W.f2444a);
        oF1.L0(null, l().D0(), C1173v.m(), C1173v.m(), C1173v.m(), DescriptorUtilsKt.m(l()).i(), Modality.OPEN, C0810o.f2471c);
        return C1172u.e(oF1);
    }
}
