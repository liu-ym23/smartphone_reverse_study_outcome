package T8;

import h8.InterfaceC1494B;
import h8.InterfaceC1503K;
import h8.InterfaceC1519b;
import h8.InterfaceC1522e;
import h8.InterfaceC1527j;
import i8.C1559e;
import i8.C1560f;
import i8.InterfaceC1561g;
import java.util.ArrayList;
import java.util.List;
import k8.AbstractC1629B;
import k8.Q;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;

/* loaded from: classes4.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final m f1235a;
    public final C0252d b;

    public v(m mVar) {
        this.f1235a = mVar;
        k kVar = mVar.f1228a;
        this.b = new C0252d(kVar.b, kVar.l);
    }

    public final J5.b a(InterfaceC1527j interfaceC1527j) {
        if (interfaceC1527j instanceof InterfaceC1494B) {
            G8.c cVar = ((AbstractC1629B) ((InterfaceC1494B) interfaceC1527j)).e;
            m mVar = this.f1235a;
            return new x(cVar, mVar.b, mVar.d, mVar.g);
        }
        if (interfaceC1527j instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b) {
            return ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b) interfaceC1527j).f5135v;
        }
        return null;
    }

    public final InterfaceC1561g b(GeneratedMessageLite.ExtendableMessage extendableMessage, int i, AnnotatedCallableKind annotatedCallableKind) {
        return !D8.e.c.c(i).booleanValue() ? C1560f.f4611a : new V8.v(this.f1235a.f1228a.f1222a, new s(this, extendableMessage, annotatedCallableKind, 0));
    }

    public final InterfaceC1561g c(ProtoBuf$Property protoBuf$Property, boolean z10) {
        return !D8.e.c.c(protoBuf$Property.d).booleanValue() ? C1560f.f4611a : new V8.v(this.f1235a.f1228a.f1222a, new t(this, z10, protoBuf$Property));
    }

    public final V8.c d(ProtoBuf$Constructor protoBuf$Constructor, boolean z10) {
        m mVar = this.f1235a;
        InterfaceC1527j interfaceC1527j = mVar.c;
        kotlin.jvm.internal.k.d(interfaceC1527j, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        InterfaceC1522e interfaceC1522e = (InterfaceC1522e) interfaceC1527j;
        int i = protoBuf$Constructor.d;
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.f5125a;
        V8.c cVar = new V8.c(interfaceC1522e, null, b(protoBuf$Constructor, i, annotatedCallableKind), z10, CallableMemberDescriptor$Kind.f4950a, protoBuf$Constructor, mVar.b, mVar.d, mVar.e, mVar.g, null);
        v vVar = mVar.a(cVar, EmptyList.f4893a, mVar.b, mVar.d, mVar.e, mVar.f).i;
        List list = protoBuf$Constructor.e;
        kotlin.jvm.internal.k.e(list, "getValueParameterList(...)");
        cVar.f1(vVar.g(list, protoBuf$Constructor, annotatedCallableKind), S0.b.O0((ProtoBuf$Visibility) D8.e.d.c(protoBuf$Constructor.d)));
        cVar.b1(interfaceC1522e.g());
        cVar.f4866r = interfaceC1522e.g0();
        cVar.f4869v = !D8.e.o.c(protoBuf$Constructor.d).booleanValue();
        return cVar;
    }

    public final V8.s e(ProtoBuf$Function proto) {
        int i;
        X8.w wVarG;
        m mVar = this.f1235a;
        D8.f fVar = mVar.b;
        D8.j jVar = mVar.d;
        kotlin.jvm.internal.k.f(proto, "proto");
        if ((proto.c & 1) == 1) {
            i = proto.d;
        } else {
            int i6 = proto.e;
            i = ((i6 >> 8) << 6) + (i6 & 63);
        }
        int i10 = i;
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.f5125a;
        InterfaceC1561g interfaceC1561gB = b(proto, i10, annotatedCallableKind);
        int i11 = proto.c;
        int i12 = i11 & 32;
        C1559e c1559e = C1560f.f4611a;
        InterfaceC1561g aVar = (i12 == 32 || (i11 & 64) == 64) ? new V8.a(mVar.f1228a.f1222a, new s(this, proto, annotatedCallableKind, 1)) : c1559e;
        V8.s sVar = new V8.s(mVar.c, null, interfaceC1561gB, N9.j.x(fVar, proto.f), S0.b.l1((ProtoBuf$MemberKind) D8.e.p.c(i10)), proto, mVar.b, jVar, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(mVar.c).c(N9.j.x(fVar, proto.f)).equals(B.f1212a) ? D8.k.b : mVar.e, mVar.g, null);
        List list = proto.i;
        kotlin.jvm.internal.k.e(list, "getTypeParameterList(...)");
        m mVarA = mVar.a(sVar, list, mVar.b, mVar.d, mVar.e, mVar.f);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.a aVar2 = mVarA.h;
        ProtoBuf$Type protoBuf$TypeB = D8.i.b(proto, jVar);
        k8.u uVarK = (protoBuf$TypeB == null || (wVarG = aVar2.g(protoBuf$TypeB)) == null) ? null : J8.m.k(sVar, wVarG, aVar);
        InterfaceC1527j interfaceC1527j = mVar.c;
        InterfaceC1522e interfaceC1522e = interfaceC1527j instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1527j : null;
        k8.u uVarB0 = interfaceC1522e != null ? interfaceC1522e.B0() : null;
        List list2 = proto.l;
        if (list2.isEmpty()) {
            list2 = null;
        }
        if (list2 == null) {
            List list3 = proto.m;
            kotlin.jvm.internal.k.e(list3, "getContextReceiverTypeIdList(...)");
            List<Integer> list4 = list3;
            ArrayList arrayList = new ArrayList(D7.w.c0(list4, 10));
            for (Integer num : list4) {
                kotlin.jvm.internal.k.c(num);
                arrayList.add(jVar.b(num.intValue()));
            }
            list2 = arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        int i13 = 0;
        for (Object obj : list2) {
            int i14 = i13 + 1;
            if (i13 < 0) {
                H4.o.X();
                throw null;
            }
            k8.u uVarE = J8.m.e(sVar, aVar2.g((ProtoBuf$Type) obj), null, c1559e, i13);
            if (uVarE != null) {
                arrayList2.add(uVarE);
            }
            i13 = i14;
        }
        List listB = aVar2.b();
        v vVar = mVarA.i;
        List list5 = proto.o;
        kotlin.jvm.internal.k.e(list5, "getValueParameterList(...)");
        sVar.f1(uVarK, uVarB0, arrayList2, listB, vVar.g(list5, proto, annotatedCallableKind), aVar2.g(D8.i.c(proto, jVar)), z.a((ProtoBuf$Modality) D8.e.e.c(i10)), S0.b.O0((ProtoBuf$Visibility) D8.e.d.c(i10)), kotlin.collections.a.M());
        sVar.m = D8.e.f424q.c(i10).booleanValue();
        sVar.n = D8.e.f425r.c(i10).booleanValue();
        sVar.o = D8.e.u.c(i10).booleanValue();
        sVar.p = D8.e.f426s.c(i10).booleanValue();
        sVar.f4865q = D8.e.f427t.c(i10).booleanValue();
        sVar.u = D8.e.f428v.c(i10).booleanValue();
        sVar.f4866r = D8.e.f429w.c(i10).booleanValue();
        sVar.f4869v = !D8.e.f430x.c(i10).booleanValue();
        mVar.f1228a.m.getClass();
        return sVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final V8.r f(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r28) {
        /*
            Method dump skipped, instructions count: 965
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: T8.v.f(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property):V8.r");
    }

    public final List g(List list, GeneratedMessageLite.ExtendableMessage extendableMessage, AnnotatedCallableKind annotatedCallableKind) {
        int i;
        InterfaceC1561g vVar;
        v vVar2 = this;
        m mVar = vVar2.f1235a;
        D8.j jVar = mVar.d;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.a aVar = mVar.h;
        InterfaceC1527j interfaceC1527j = mVar.c;
        kotlin.jvm.internal.k.d(interfaceC1527j, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        InterfaceC1519b interfaceC1519b = (InterfaceC1519b) interfaceC1527j;
        InterfaceC1527j interfaceC1527jD = interfaceC1519b.d();
        kotlin.jvm.internal.k.e(interfaceC1527jD, "getContainingDeclaration(...)");
        J5.b bVarA = vVar2.a(interfaceC1527jD);
        List list2 = list;
        ArrayList arrayList = new ArrayList(D7.w.c0(list2, 10));
        int i6 = 0;
        for (Object obj : list2) {
            int i10 = i6 + 1;
            X8.w wVarG = null;
            if (i6 < 0) {
                H4.o.X();
                throw null;
            }
            ProtoBuf$ValueParameter protoBuf$ValueParameter = (ProtoBuf$ValueParameter) obj;
            int i11 = (protoBuf$ValueParameter.c & 1) == 1 ? protoBuf$ValueParameter.d : 0;
            if (bVarA == null || !D8.e.c.c(i11).booleanValue()) {
                i = i6;
                vVar = C1560f.f4611a;
            } else {
                i = i6;
                vVar = new V8.v(mVar.f1228a.f1222a, new u(vVar2, bVarA, extendableMessage, annotatedCallableKind, i, protoBuf$ValueParameter));
            }
            G8.f fVarX = N9.j.x(mVar.b, protoBuf$ValueParameter.e);
            X8.w wVarG2 = aVar.g(D8.i.e(protoBuf$ValueParameter, jVar));
            boolean zBooleanValue = D8.e.f415H.c(i11).booleanValue();
            boolean zBooleanValue2 = D8.e.f416I.c(i11).booleanValue();
            boolean zBooleanValue3 = D8.e.f417J.c(i11).booleanValue();
            int i12 = protoBuf$ValueParameter.c;
            ProtoBuf$Type protoBuf$TypeB = (i12 & 16) == 16 ? protoBuf$ValueParameter.h : (i12 & 32) == 32 ? jVar.b(protoBuf$ValueParameter.i) : null;
            if (protoBuf$TypeB != null) {
                wVarG = aVar.g(protoBuf$TypeB);
            }
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new Q(interfaceC1519b, null, i, vVar, fVarX, wVarG2, zBooleanValue, zBooleanValue2, zBooleanValue3, wVarG, InterfaceC1503K.f4577I));
            arrayList = arrayList2;
            i6 = i10;
            vVar2 = this;
        }
        return D7.v.f1(arrayList);
    }
}
