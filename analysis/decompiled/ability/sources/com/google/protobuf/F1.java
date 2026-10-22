package com.google.protobuf;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: classes3.dex */
public final class F1 implements InterfaceC0927c2, InterfaceC0942g1, InterfaceC0920b {
    public static final C0918a1 c = new C0918a1(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2829a;
    public final Object b;

    public /* synthetic */ F1(Object obj, int i) {
        this.f2829a = i;
        this.b = obj;
    }

    @Override // com.google.protobuf.InterfaceC0942g1
    public D0 a(GeneratedMessageV3 generatedMessageV3) {
        D0 d02 = (D0) this.b;
        if (generatedMessageV3.d(d02)) {
            return d02;
        }
        return null;
    }

    @Override // com.google.protobuf.InterfaceC0942g1
    public boolean b(GeneratedMessageV3 generatedMessageV3) {
        return generatedMessageV3.d((D0) this.b);
    }

    @Override // com.google.protobuf.InterfaceC0942g1
    public D0 c(AbstractC0926c1 abstractC0926c1) {
        D0 d02 = (D0) this.b;
        if (abstractC0926c1.d(d02)) {
            return d02;
        }
        return null;
    }

    @Override // com.google.protobuf.InterfaceC0942g1
    public boolean d(AbstractC0926c1 abstractC0926c1) {
        return abstractC0926c1.d((D0) this.b);
    }

    @Override // com.google.protobuf.InterfaceC0927c2
    public InterfaceC0927c2 e(D0 d02, Object obj) {
        ((W0) this.b).m(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.InterfaceC0927c2
    public void f(AbstractC0972o abstractC0972o, R0 r02, D0 d02) {
        W1 builder;
        W0 w02 = (W0) this.b;
        if (d02.isRepeated() || !w02.g(d02)) {
            throw null;
        }
        Object objF = w02.f(d02);
        if (objF instanceof W1) {
            builder = (W1) objF;
        } else {
            builder = ((X1) objF).toBuilder();
            w02.m(d02, builder);
        }
        abstractC0972o.v(builder, r02);
    }

    @Override // com.google.protobuf.InterfaceC0927c2
    public void g(O0 o02, C1004w0 c1004w0, int i) {
        if (o02.f.get(new N0(c1004w0, i)) != null) {
            throw new ClassCastException();
        }
    }

    @Override // com.google.protobuf.InterfaceC0920b
    public void h() {
        switch (this.f2829a) {
            case 3:
                ((C0986r2) this.b).e();
                break;
            default:
                ((AbstractC0926c1) this.b).L();
                break;
        }
    }

    @Override // com.google.protobuf.InterfaceC0927c2
    public WireFormat$Utf8Validation i(D0 d02) {
        return d02.p() ? WireFormat$Utf8Validation.b : WireFormat$Utf8Validation.f2890a;
    }

    @Override // com.google.protobuf.InterfaceC0927c2
    public void j(AbstractC0972o abstractC0972o, R0 r02, D0 d02) {
        W1 builder;
        W0 w02 = (W0) this.b;
        boolean zIsRepeated = d02.isRepeated();
        DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = d02.b;
        if (zIsRepeated || !w02.g(d02)) {
            throw null;
        }
        Object objF = w02.f(d02);
        if (objF instanceof W1) {
            builder = (W1) objF;
        } else {
            builder = ((X1) objF).toBuilder();
            w02.m(d02, builder);
        }
        abstractC0972o.r(descriptorProtos$FieldDescriptorProto.e, builder, r02);
    }

    @Override // com.google.protobuf.InterfaceC0927c2
    public MessageReflection$MergeTarget$ContainerType k() {
        return MessageReflection$MergeTarget$ContainerType.b;
    }

    @Override // com.google.protobuf.InterfaceC0927c2
    public InterfaceC0927c2 l(D0 d02, Object obj) {
        ((W0) this.b).a(d02, obj);
        return this;
    }

    public int m() {
        switch (this.f2829a) {
            case 7:
                return ((ByteString) this.b).size();
            default:
                return ((byte[]) this.b).length;
        }
    }

    public void n(int i, Object obj, InterfaceC0979p2 interfaceC0979p2) throws CodedOutputStream$OutOfSpaceException {
        C0980q c0980q = (C0980q) this.b;
        c0980q.k0(i, 3);
        interfaceC0979p2.a((X1) obj, c0980q.c);
        c0980q.k0(i, 4);
    }

    public void o(int i, Object obj, InterfaceC0979p2 interfaceC0979p2) throws CodedOutputStream$OutOfSpaceException {
        C0980q c0980q = (C0980q) this.b;
        X1 x12 = (X1) obj;
        c0980q.k0(i, 2);
        c0980q.l0(((AbstractC0932e) x12).i(interfaceC0979p2));
        interfaceC0979p2.a(x12, c0980q.c);
    }

    public void p(int i, Object obj) throws CodedOutputStream$OutOfSpaceException {
        C0980q c0980q = (C0980q) this.b;
        if (obj instanceof ByteString) {
            c0980q.i0(i, (ByteString) obj);
        } else {
            c0980q.h0(i, (X1) obj);
        }
    }

    public F1(C0980q c0980q) {
        this.f2829a = 2;
        AbstractC0989s1.a(c0980q, "output");
        this.b = c0980q;
        c0980q.c = this;
    }

    public F1() {
        V1 v12;
        this.f2829a = 0;
        try {
            int i = r.f2937a;
            v12 = (V1) r.class.getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            v12 = c;
        }
        V1[] v1Arr = {C0918a1.b, v12};
        E1 e12 = new E1();
        e12.f2827a = v1Arr;
        Charset charset = AbstractC0989s1.f2940a;
        this.b = e12;
    }

    public F1(C1004w0 c1004w0, int i) {
        this.f2829a = 5;
        this.b = (D0) Collections.unmodifiableList(Arrays.asList(((H0) c1004w0.j().get(i)).g)).get(0);
    }
}
