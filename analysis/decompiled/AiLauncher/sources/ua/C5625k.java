package ua;

import C9.o;
import E9.InterfaceC0797b;
import ea.AbstractC4017a;
import ea.InterfaceC4020d;
import ea.j;
import java.util.Iterator;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import p9.InterfaceC5074l;

/* renamed from: ua.k, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5625k {

    /* renamed from: c, reason: collision with root package name */
    public static final b f42602c = new b(null);

    /* renamed from: d, reason: collision with root package name */
    public static final Set<ga.b> f42603d = Z8.X.d(ga.b.f32721d.c(o.a.f1900d.m()));

    /* renamed from: a, reason: collision with root package name */
    public final C5627m f42604a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5074l<a, InterfaceC0797b> f42605b;

    /* renamed from: ua.k$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final ga.b f42606a;

        /* renamed from: b, reason: collision with root package name */
        public final C5622h f42607b;

        public a(ga.b classId, C5622h c5622h) {
            kotlin.jvm.internal.p.i(classId, "classId");
            this.f42606a = classId;
            this.f42607b = c5622h;
        }

        public final C5622h a() {
            return this.f42607b;
        }

        public final ga.b b() {
            return this.f42606a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.p.d(this.f42606a, ((a) obj).f42606a);
        }

        public int hashCode() {
            return this.f42606a.hashCode();
        }
    }

    /* renamed from: ua.k$b */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Set<ga.b> a() {
            return C5625k.f42603d;
        }

        public b() {
        }
    }

    public C5625k(C5627m components) {
        kotlin.jvm.internal.p.i(components, "components");
        this.f42604a = components;
        this.f42605b = components.u().f(new C5624j(this));
    }

    public static final InterfaceC0797b c(C5625k c5625k, a key) {
        kotlin.jvm.internal.p.i(key, "key");
        return c5625k.d(key);
    }

    public static /* synthetic */ InterfaceC0797b f(C5625k c5625k, ga.b bVar, C5622h c5622h, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            c5622h = null;
        }
        return c5625k.e(bVar, c5622h);
    }

    public final InterfaceC0797b d(a aVar) {
        Object next;
        C5629o c5629oA;
        ga.b bVarB = aVar.b();
        Iterator<G9.b> it = this.f42604a.l().iterator();
        while (it.hasNext()) {
            InterfaceC0797b interfaceC0797bA = it.next().a(bVarB);
            if (interfaceC0797bA != null) {
                return interfaceC0797bA;
            }
        }
        if (f42603d.contains(bVarB)) {
            return null;
        }
        C5622h c5622hA = aVar.a();
        if (c5622hA == null && (c5622hA = this.f42604a.e().a(bVarB)) == null) {
            return null;
        }
        InterfaceC4020d interfaceC4020dA = c5622hA.a();
        ProtoBuf$Class protoBuf$ClassB = c5622hA.b();
        AbstractC4017a abstractC4017aC = c5622hA.c();
        E9.W wD = c5622hA.d();
        ga.b bVarE = bVarB.e();
        if (bVarE != null) {
            InterfaceC0797b interfaceC0797bF = f(this, bVarE, null, 2, null);
            DeserializedClassDescriptor deserializedClassDescriptor = interfaceC0797bF instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) interfaceC0797bF : null;
            if (deserializedClassDescriptor == null || !deserializedClassDescriptor.e1(bVarB.h())) {
                return null;
            }
            c5629oA = deserializedClassDescriptor.X0();
        } else {
            Iterator<T> it2 = E9.J.c(this.f42604a.s(), bVarB.f()).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                E9.E e10 = (E9.E) next;
                if (!(e10 instanceof AbstractC5631q) || ((AbstractC5631q) e10).E0(bVarB.h())) {
                    break;
                }
            }
            E9.E e11 = (E9.E) next;
            if (e11 == null) {
                return null;
            }
            C5627m c5627m = this.f42604a;
            ProtoBuf$TypeTable protoBuf$TypeTableD1 = protoBuf$ClassB.d1();
            kotlin.jvm.internal.p.h(protoBuf$TypeTableD1, "getTypeTable(...)");
            ea.h hVar = new ea.h(protoBuf$TypeTableD1);
            j.a aVar2 = ea.j.f32424b;
            ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTableF1 = protoBuf$ClassB.f1();
            kotlin.jvm.internal.p.h(protoBuf$VersionRequirementTableF1, "getVersionRequirementTable(...)");
            c5629oA = c5627m.a(e11, interfaceC4020dA, hVar, aVar2.a(protoBuf$VersionRequirementTableF1), abstractC4017aC, null);
            abstractC4017aC = abstractC4017aC;
        }
        return new DeserializedClassDescriptor(c5629oA, protoBuf$ClassB, interfaceC4020dA, abstractC4017aC, wD);
    }

    public final InterfaceC0797b e(ga.b classId, C5622h c5622h) {
        kotlin.jvm.internal.p.i(classId, "classId");
        return this.f42605b.invoke(new a(classId, c5622h));
    }
}
