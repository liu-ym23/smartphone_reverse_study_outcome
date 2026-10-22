package wa;

import E9.InterfaceC0803h;
import E9.W;
import E9.Z;
import H9.AbstractC0823b;
import Z8.C1172u;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import ua.C5602L;
import ua.C5605O;
import ua.C5629o;
import xa.InterfaceC5869l;

/* renamed from: wa.P, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5774P extends AbstractC0823b {

    /* renamed from: k, reason: collision with root package name */
    public final C5629o f43171k;

    /* renamed from: l, reason: collision with root package name */
    public final ProtoBuf$TypeParameter f43172l;

    /* renamed from: m, reason: collision with root package name */
    public final C5777a f43173m;

    /* JADX WARN: Illegal instructions before constructor call */
    public C5774P(C5629o c10, ProtoBuf$TypeParameter proto, int i10) {
        kotlin.jvm.internal.p.i(c10, "c");
        kotlin.jvm.internal.p.i(proto, "proto");
        InterfaceC5869l interfaceC5869lH = c10.h();
        InterfaceC0803h interfaceC0803hE = c10.e();
        F9.g gVarB = F9.g.f2609m0.b();
        ga.e eVarB = C5602L.b(c10.g(), proto.N());
        C5605O c5605o = C5605O.f42564a;
        ProtoBuf$TypeParameter.Variance varianceT = proto.T();
        kotlin.jvm.internal.p.h(varianceT, "getVariance(...)");
        super(interfaceC5869lH, interfaceC0803hE, gVarB, eVarB, c5605o.d(varianceT), proto.O(), i10, W.f2444a, Z.a.f2446a);
        this.f43171k = c10;
        this.f43172l = proto;
        this.f43173m = new C5777a(c10.h(), new C5773O(this));
    }

    public static final List H0(C5774P c5774p) {
        return Z8.F.m1(c5774p.f43171k.c().d().c(c5774p.f43172l, c5774p.f43171k.g()));
    }

    @Override // H9.AbstractC0829h
    public List<ya.S> F0() {
        List<ProtoBuf$Type> listT = ea.g.t(this.f43172l, this.f43171k.j());
        if (listT.isEmpty()) {
            return C1172u.e(DescriptorUtilsKt.m(this).z());
        }
        List<ProtoBuf$Type> list = listT;
        TypeDeserializer typeDeserializerI = this.f43171k.i();
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(typeDeserializerI.u((ProtoBuf$Type) it.next()));
        }
        return arrayList;
    }

    @Override // F9.b, F9.a
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public C5777a getAnnotations() {
        return this.f43173m;
    }

    @Override // H9.AbstractC0829h
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public Void E0(ya.S type) {
        kotlin.jvm.internal.p.i(type, "type");
        throw new IllegalStateException("There should be no cycles for deserialized type parameters, but found for: " + this);
    }
}
