package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import D8.e;
import D8.f;
import N9.j;
import Q8.n;
import Q8.o;
import Q8.p;
import Q8.s;
import T8.m;
import T8.w;
import T8.y;
import T8.z;
import V8.i;
import V8.v;
import W8.h;
import X8.A;
import X8.K;
import Y8.l;
import h8.AbstractC1508P;
import h8.C1502J;
import h8.C1504L;
import h8.C1531n;
import h8.InterfaceC1501I;
import h8.InterfaceC1503K;
import h8.InterfaceC1527j;
import i8.C1560f;
import i8.InterfaceC1561g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import k8.AbstractC1633b;
import k8.C1640i;
import k8.u;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import u1.d;

/* loaded from: classes4.dex */
public final class b extends AbstractC1633b implements InterfaceC1527j {
    public final ProtoBuf$Class e;
    public final D8.a f;
    public final InterfaceC1503K g;
    public final G8.b h;
    public final Modality i;

    /* renamed from: j, reason: collision with root package name */
    public final C1531n f5130j;
    public final ClassKind k;
    public final m l;
    public final p m;
    public final i n;
    public final C1502J o;
    public final d p;

    /* renamed from: q, reason: collision with root package name */
    public final InterfaceC1527j f5131q;

    /* renamed from: r, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.storage.a f5132r;

    /* renamed from: s, reason: collision with root package name */
    public final h f5133s;

    /* renamed from: t, reason: collision with root package name */
    public final h f5134t;
    public final kotlin.reflect.jvm.internal.impl.storage.a u;

    /* renamed from: v, reason: collision with root package name */
    public final w f5135v;

    /* renamed from: w, reason: collision with root package name */
    public final InterfaceC1561g f5136w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(m outerContext, ProtoBuf$Class classProto, f nameResolver, D8.a aVar, InterfaceC1503K sourceElement) {
        ClassKind classKind;
        p sVar;
        super(outerContext.f1228a.f1222a, j.s(nameResolver, classProto.e).f());
        k.f(outerContext, "outerContext");
        k.f(classProto, "classProto");
        k.f(nameResolver, "nameResolver");
        k.f(sourceElement, "sourceElement");
        this.e = classProto;
        this.f = aVar;
        this.g = sourceElement;
        this.h = j.s(nameResolver, classProto.e);
        this.i = z.a((ProtoBuf$Modality) e.e.c(classProto.d));
        this.f5130j = S0.b.O0((ProtoBuf$Visibility) e.d.c(classProto.d));
        ProtoBuf$Class.Kind kind = (ProtoBuf$Class.Kind) e.f.c(classProto.d);
        switch (kind == null ? -1 : y.b[kind.ordinal()]) {
            case 1:
                classKind = ClassKind.f4951a;
                break;
            case 2:
                classKind = ClassKind.b;
                break;
            case 3:
                classKind = ClassKind.c;
                break;
            case 4:
                classKind = ClassKind.d;
                break;
            case 5:
                classKind = ClassKind.e;
                break;
            case 6:
            case 7:
                classKind = ClassKind.f;
                break;
            default:
                classKind = ClassKind.f4951a;
                break;
        }
        this.k = classKind;
        List list = classProto.g;
        k.e(list, "getTypeParameterList(...)");
        ProtoBuf$TypeTable protoBuf$TypeTable = classProto.E;
        k.e(protoBuf$TypeTable, "getTypeTable(...)");
        D8.j jVar = new D8.j(protoBuf$TypeTable);
        D8.k kVar = D8.k.b;
        ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable = classProto.f5025G;
        k.e(protoBuf$VersionRequirementTable, "getVersionRequirementTable(...)");
        m mVarA = outerContext.a(this, list, nameResolver, jVar, j.o(protoBuf$VersionRequirementTable), aVar);
        T8.k kVar2 = mVarA.f1228a;
        W8.i storageManager = kVar2.f1222a;
        this.l = mVarA;
        boolean zBooleanValue = e.m.c(classProto.d).booleanValue();
        ClassKind classKind2 = ClassKind.c;
        int i = 0;
        int i6 = 1;
        if (classKind == classKind2) {
            sVar = new s(storageManager, this, zBooleanValue || k.b(kVar2.f1226s.d(), Boolean.TRUE));
        } else {
            sVar = n.b;
        }
        this.m = sVar;
        this.n = new i(this);
        C1504L c1504l = C1502J.d;
        ((l) kVar2.f1224q).getClass();
        DeserializedClassDescriptor$memberScopeHolder$1 deserializedClassDescriptor$memberScopeHolder$1 = new DeserializedClassDescriptor$memberScopeHolder$1(1, this);
        c1504l.getClass();
        k.f(storageManager, "storageManager");
        this.o = new C1502J(this, storageManager, deserializedClassDescriptor$memberScopeHolder$1);
        this.p = classKind == classKind2 ? new d(this) : null;
        InterfaceC1527j interfaceC1527j = outerContext.c;
        this.f5131q = interfaceC1527j;
        V8.d dVar = new V8.d(this, i);
        storageManager.getClass();
        this.f5132r = new kotlin.reflect.jvm.internal.impl.storage.a(storageManager, dVar);
        this.f5133s = new h(storageManager, new V8.d(this, i6));
        new kotlin.reflect.jvm.internal.impl.storage.a(storageManager, new V8.d(this, 2));
        this.f5134t = new h(storageManager, new V8.d(this, 3));
        this.u = new kotlin.reflect.jvm.internal.impl.storage.a(storageManager, new a(this));
        f fVar = mVarA.b;
        D8.j jVar2 = mVarA.d;
        b bVar = interfaceC1527j instanceof b ? (b) interfaceC1527j : null;
        this.f5135v = new w(classProto, fVar, jVar2, sourceElement, bVar != null ? bVar.f5135v : null);
        this.f5136w = !e.c.c(classProto.d).booleanValue() ? C1560f.f4611a : new v(storageManager, new V8.d(this, 4));
    }

    @Override // k8.y
    public final o A(Y8.f fVar) {
        C1502J c1502j = this.o;
        kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.j(c1502j.f4576a);
        return (o) S0.b.g1(c1502j.c, C1502J.e[0]);
    }

    @Override // h8.InterfaceC1522e
    public final boolean A0() {
        return e.h.c(this.e.d).booleanValue();
    }

    public final V8.h L() {
        ((l) this.l.f1228a.f1224q).getClass();
        C1502J c1502j = this.o;
        kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.j(c1502j.f4576a);
        return (V8.h) ((o) S0.b.g1(c1502j.c, C1502J.e[0]));
    }

    public final A M(G8.f fVar) {
        Iterator it = L().d(fVar, NoLookupLocation.g).iterator();
        boolean z10 = false;
        Object obj = null;
        while (true) {
            if (!it.hasNext()) {
                if (!z10) {
                    break;
                }
            } else {
                Object next = it.next();
                if (((InterfaceC1501I) next).I() == null) {
                    if (z10) {
                        break;
                    }
                    z10 = true;
                    obj = next;
                }
            }
        }
        obj = null;
        InterfaceC1501I interfaceC1501I = (InterfaceC1501I) obj;
        return (A) (interfaceC1501I != null ? interfaceC1501I.getType() : null);
    }

    @Override // h8.InterfaceC1522e
    public final AbstractC1508P P() {
        return (AbstractC1508P) this.u.invoke();
    }

    @Override // h8.InterfaceC1539v
    public final boolean S() {
        return false;
    }

    @Override // k8.AbstractC1633b, h8.InterfaceC1522e
    public final List T() {
        m mVar = this.l;
        D8.j jVar = mVar.d;
        ProtoBuf$Class protoBuf$Class = this.e;
        k.f(protoBuf$Class, "<this>");
        List list = protoBuf$Class.m;
        if (list.isEmpty()) {
            list = null;
        }
        if (list == null) {
            List list2 = protoBuf$Class.n;
            k.e(list2, "getContextReceiverTypeIdList(...)");
            List<Integer> list3 = list2;
            ArrayList arrayList = new ArrayList(D7.w.c0(list3, 10));
            for (Integer num : list3) {
                k.c(num);
                arrayList.add(jVar.b(num.intValue()));
            }
            list = arrayList;
        }
        List list4 = list;
        ArrayList arrayList2 = new ArrayList(D7.w.c0(list4, 10));
        Iterator it = list4.iterator();
        while (it.hasNext()) {
            arrayList2.add(new u(B0(), new R8.a(this, mVar.h.g((ProtoBuf$Type) it.next()), (G8.f) null), C1560f.f4611a));
        }
        return arrayList2;
    }

    @Override // h8.InterfaceC1522e
    public final boolean X() {
        return e.f.c(this.e.d) == ProtoBuf$Class.Kind.COMPANION_OBJECT;
    }

    @Override // h8.InterfaceC1522e
    public final boolean c0() {
        return e.l.c(this.e.d).booleanValue();
    }

    @Override // h8.InterfaceC1527j
    public final InterfaceC1527j d() {
        return this.f5131q;
    }

    @Override // h8.InterfaceC1539v
    public final boolean g0() {
        return e.f423j.c(this.e.d).booleanValue();
    }

    @Override // i8.InterfaceC1555a
    public final InterfaceC1561g getAnnotations() {
        return this.f5136w;
    }

    @Override // h8.InterfaceC1522e
    public final ClassKind getKind() {
        return this.k;
    }

    @Override // h8.InterfaceC1528k
    public final InterfaceC1503K getSource() {
        return this.g;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1539v
    public final C1531n getVisibility() {
        return this.f5130j;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1525h
    public final List h() {
        return this.l.h.b();
    }

    @Override // h8.InterfaceC1522e
    public final o h0() {
        return this.m;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1539v
    public final Modality i() {
        return this.i;
    }

    @Override // h8.InterfaceC1539v
    public final boolean isExternal() {
        return e.i.c(this.e.d).booleanValue();
    }

    @Override // h8.InterfaceC1522e
    public final boolean isInline() {
        if (!e.k.c(this.e.d).booleanValue()) {
            return false;
        }
        D8.a aVar = this.f;
        int i = aVar.b;
        if (i >= 1) {
            if (i > 1) {
                return false;
            }
            int i6 = aVar.c;
            if (i6 >= 4 && (i6 > 4 || aVar.d > 1)) {
                return false;
            }
        }
        return true;
    }

    @Override // h8.InterfaceC1522e
    public final boolean j() {
        return e.k.c(this.e.d).booleanValue() && this.f.a(1, 4, 2);
    }

    @Override // h8.InterfaceC1524g
    public final K m() {
        return this.n;
    }

    @Override // h8.InterfaceC1522e
    public final Collection n() {
        return (Collection) this.f5133s.invoke();
    }

    @Override // h8.InterfaceC1522e
    public final Collection p() {
        return (Collection) this.f5134t.invoke();
    }

    @Override // h8.InterfaceC1525h
    public final boolean q() {
        return e.g.c(this.e.d).booleanValue();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("deserialized ");
        sb.append(g0() ? "expect " : "");
        sb.append("class ");
        sb.append(getName());
        return sb.toString();
    }

    @Override // h8.InterfaceC1522e
    public final C1640i u() {
        return (C1640i) this.f5132r.invoke();
    }
}
