package kotlin.reflect.jvm.internal.impl.load.kotlin;

import E9.E;
import E9.InterfaceC0797b;
import Z8.C1173v;
import Z8.X;
import Z8.Y;
import ba.h;
import ba.l;
import ba.s;
import ea.C4019c;
import fa.C4068e;
import fa.C4071h;
import java.util.Collection;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import ra.InterfaceC5238k;
import ua.C5622h;
import ua.C5627m;
import ua.C5638x;
import wa.C5769K;
import wa.C5776S;

/* loaded from: classes5.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final a f35194b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final Set<KotlinClassHeader.Kind> f35195c = X.d(KotlinClassHeader.Kind.CLASS);

    /* renamed from: d, reason: collision with root package name */
    public static final Set<KotlinClassHeader.Kind> f35196d = Y.j(KotlinClassHeader.Kind.FILE_FACADE, KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);

    /* renamed from: e, reason: collision with root package name */
    public static final C4019c f35197e = new C4019c(1, 1, 2);

    /* renamed from: f, reason: collision with root package name */
    public static final C4019c f35198f = new C4019c(1, 1, 11);

    /* renamed from: g, reason: collision with root package name */
    public static final C4019c f35199g = new C4019c(1, 1, 13);

    /* renamed from: a, reason: collision with root package name */
    public C5627m f35200a;

    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public final C4019c a() {
            return e.f35199g;
        }

        public a() {
        }
    }

    public static final Collection d() {
        return C1173v.m();
    }

    public final InterfaceC5238k c(E descriptor, f kotlinClass) {
        String[] strArrG;
        Pair<C4068e, ProtoBuf$Package> pairM;
        p.i(descriptor, "descriptor");
        p.i(kotlinClass, "kotlinClass");
        String[] strArrM = m(kotlinClass, f35196d);
        if (strArrM == null || (strArrG = kotlinClass.b().g()) == null) {
            return null;
        }
        try {
            try {
                pairM = C4071h.m(strArrM, strArrG);
            } catch (InvalidProtocolBufferException e10) {
                throw new IllegalStateException("Could not read data from " + kotlinClass.getLocation(), e10);
            }
        } catch (Throwable th) {
            if (i() || kotlinClass.b().d().h(h())) {
                throw th;
            }
            pairM = null;
        }
        if (pairM == null) {
            return null;
        }
        C4068e c4068eA = pairM.a();
        ProtoBuf$Package protoBuf$PackageB = pairM.b();
        l lVar = new l(kotlinClass, protoBuf$PackageB, c4068eA, g(kotlinClass), k(kotlinClass), e(kotlinClass));
        return new C5769K(descriptor, protoBuf$PackageB, c4068eA, kotlinClass.b().d(), lVar, f(), "scope for " + lVar + " in " + descriptor, h.f15332a);
    }

    public final DeserializedContainerAbiStability e(f fVar) {
        if (!f().g().e() && fVar.b().j()) {
            return DeserializedContainerAbiStability.UNSTABLE;
        }
        return DeserializedContainerAbiStability.STABLE;
    }

    public final C5627m f() {
        C5627m c5627m = this.f35200a;
        if (c5627m != null) {
            return c5627m;
        }
        p.A("components");
        return null;
    }

    public final C5638x<C4019c> g(f fVar) {
        if (i() || fVar.b().d().h(h())) {
            return null;
        }
        return new C5638x<>(fVar.b().d(), C4019c.f32404i, h(), h().k(fVar.b().d().j()), fVar.getLocation());
    }

    public final C4019c h() {
        return f().g().d();
    }

    public final boolean i() {
        return f().g().f();
    }

    public final boolean j(f fVar) {
        return !f().g().b() && fVar.b().i() && p.d(fVar.b().d(), f35198f);
    }

    public final boolean k(f fVar) {
        return (f().g().g() && (fVar.b().i() || p.d(fVar.b().d(), f35197e))) || j(fVar);
    }

    public final C5622h l(f kotlinClass) {
        String[] strArrG;
        Pair<C4068e, ProtoBuf$Class> pairI;
        p.i(kotlinClass, "kotlinClass");
        String[] strArrM = m(kotlinClass, f35195c);
        if (strArrM == null || (strArrG = kotlinClass.b().g()) == null) {
            return null;
        }
        try {
            try {
                pairI = C4071h.i(strArrM, strArrG);
            } catch (InvalidProtocolBufferException e10) {
                throw new IllegalStateException("Could not read data from " + kotlinClass.getLocation(), e10);
            }
        } catch (Throwable th) {
            if (i() || kotlinClass.b().d().h(h())) {
                throw th;
            }
            pairI = null;
        }
        if (pairI == null) {
            return null;
        }
        return new C5622h(pairI.a(), pairI.b(), kotlinClass.b().d(), new s(kotlinClass, g(kotlinClass), new C5776S(k(kotlinClass), null, 2, null), e(kotlinClass)));
    }

    public final String[] m(f fVar, Set<? extends KotlinClassHeader.Kind> set) {
        KotlinClassHeader kotlinClassHeaderB = fVar.b();
        String[] strArrA = kotlinClassHeaderB.a();
        if (strArrA == null) {
            strArrA = kotlinClassHeaderB.b();
        }
        if (strArrA == null || !set.contains(kotlinClassHeaderB.c())) {
            return null;
        }
        return strArrA;
    }

    public final InterfaceC0797b n(f kotlinClass) {
        p.i(kotlinClass, "kotlinClass");
        C5622h c5622hL = l(kotlinClass);
        if (c5622hL == null) {
            return null;
        }
        return f().f().e(kotlinClass.j(), c5622hL);
    }

    public final void o(ba.f components) {
        p.i(components, "components");
        p(components.a());
    }

    public final void p(C5627m c5627m) {
        p.i(c5627m, "<set-?>");
        this.f35200a = c5627m;
    }
}
