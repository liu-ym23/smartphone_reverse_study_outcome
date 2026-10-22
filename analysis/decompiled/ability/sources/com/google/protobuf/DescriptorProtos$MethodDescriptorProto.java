package com.google.protobuf;

import c0.C0868b;
import java.io.Serializable;

/* loaded from: classes3.dex */
public final class DescriptorProtos$MethodDescriptorProto extends GeneratedMessageV3 {
    public static final DescriptorProtos$MethodDescriptorProto k = new DescriptorProtos$MethodDescriptorProto();
    public static final C0921b0 l = new C0921b0();
    public int c;
    public volatile Serializable d;
    public volatile Serializable e;
    public volatile Serializable f;
    public DescriptorProtos$MethodOptions g;
    public boolean h = false;
    public boolean i = false;

    /* renamed from: j, reason: collision with root package name */
    public byte f2816j = -1;

    private DescriptorProtos$MethodDescriptorProto() {
        this.d = "";
        this.e = "";
        this.f = "";
        this.d = "";
        this.e = "";
        this.f = "";
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        C0925c0 c0925c0 = new C0925c0(f12);
        c0925c0.f = "";
        c0925c0.g = "";
        c0925c0.h = "";
        return c0925c0;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new DescriptorProtos$MethodDescriptorProto();
    }

    public final String E() {
        Serializable serializable = this.e;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        ByteString byteString = (ByteString) serializable;
        String strQ = byteString.q();
        if (byteString.i()) {
            this.e = strQ;
        }
        return strQ;
    }

    public final String F() {
        Serializable serializable = this.d;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        ByteString byteString = (ByteString) serializable;
        String strQ = byteString.q();
        if (byteString.i()) {
            this.d = strQ;
        }
        return strQ;
    }

    public final DescriptorProtos$MethodOptions G() {
        DescriptorProtos$MethodOptions descriptorProtos$MethodOptions = this.g;
        return descriptorProtos$MethodOptions == null ? DescriptorProtos$MethodOptions.f2817j : descriptorProtos$MethodOptions;
    }

    public final String H() {
        Serializable serializable = this.f;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        ByteString byteString = (ByteString) serializable;
        String strQ = byteString.q();
        if (byteString.i()) {
            this.f = strQ;
        }
        return strQ;
    }

    public final boolean I() {
        return (this.c & 16) != 0;
    }

    public final boolean J() {
        return (this.c & 2) != 0;
    }

    public final boolean K() {
        return (this.c & 8) != 0;
    }

    public final boolean L() {
        return (this.c & 4) != 0;
    }

    public final boolean M() {
        return (this.c & 32) != 0;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public final C0925c0 toBuilder() {
        if (this == k) {
            return new C0925c0();
        }
        C0925c0 c0925c0 = new C0925c0();
        c0925c0.O(this);
        return c0925c0;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        if ((this.c & 1) != 0) {
            GeneratedMessageV3.D(c0980q, 1, this.d);
        }
        if ((this.c & 2) != 0) {
            GeneratedMessageV3.D(c0980q, 2, this.e);
        }
        if ((this.c & 4) != 0) {
            GeneratedMessageV3.D(c0980q, 3, this.f);
        }
        if ((this.c & 8) != 0) {
            c0980q.f0(4, G());
        }
        if ((this.c & 16) != 0) {
            c0980q.W(5, this.h);
        }
        if ((this.c & 32) != 0) {
            c0980q.W(6, this.i);
        }
        this.b.c(c0980q);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof DescriptorProtos$MethodDescriptorProto)) {
                return super.equals(obj);
            }
            DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto = (DescriptorProtos$MethodDescriptorProto) obj;
            int i = this.c;
            if (((i & 1) != 0) != ((descriptorProtos$MethodDescriptorProto.c & 1) != 0) || (((i & 1) != 0 && !F().equals(descriptorProtos$MethodDescriptorProto.F())) || J() != descriptorProtos$MethodDescriptorProto.J() || ((J() && !E().equals(descriptorProtos$MethodDescriptorProto.E())) || L() != descriptorProtos$MethodDescriptorProto.L() || ((L() && !H().equals(descriptorProtos$MethodDescriptorProto.H())) || K() != descriptorProtos$MethodDescriptorProto.K() || ((K() && !G().equals(descriptorProtos$MethodDescriptorProto.G())) || I() != descriptorProtos$MethodDescriptorProto.I() || ((I() && this.h != descriptorProtos$MethodDescriptorProto.h) || M() != descriptorProtos$MethodDescriptorProto.M() || ((M() && this.i != descriptorProtos$MethodDescriptorProto.i) || !this.b.equals(descriptorProtos$MethodDescriptorProto.b)))))))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return k;
    }

    @Override // com.google.protobuf.X1
    public final int getSerializedSize() {
        int i = this.f2909a;
        if (i != -1) {
            return i;
        }
        int iV = (this.c & 1) != 0 ? GeneratedMessageV3.v(1, this.d) : 0;
        if ((this.c & 2) != 0) {
            iV += GeneratedMessageV3.v(2, this.e);
        }
        if ((this.c & 4) != 0) {
            iV += GeneratedMessageV3.v(3, this.f);
        }
        if ((this.c & 8) != 0) {
            iV += C0980q.P(4, G());
        }
        if ((this.c & 16) != 0) {
            iV += C0980q.J(5);
        }
        if ((this.c & 32) != 0) {
            iV += C0980q.J(6);
        }
        int serializedSize = this.b.getSerializedSize() + iV;
        this.f2909a = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = AbstractC1000v0.y.hashCode() + 779;
        if ((this.c & 1) != 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + F().hashCode();
        }
        if (J()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53) + E().hashCode();
        }
        if (L()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 3, 53) + H().hashCode();
        }
        if (K()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 4, 53) + G().hashCode();
        }
        if (I()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 5, 53) + AbstractC0989s1.b(this.h);
        }
        if (M()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 6, 53) + AbstractC0989s1.b(this.i);
        }
        int iHashCode2 = this.b.hashCode() + (iHashCode * 29);
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        byte b = this.f2816j;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (!K() || G().isInitialized()) {
            this.f2816j = (byte) 1;
            return true;
        }
        this.f2816j = (byte) 0;
        return false;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: newBuilderForType */
    public final W1 q() {
        return k.toBuilder();
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a q() {
        return k.toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final C0868b y() {
        C0868b c0868b = AbstractC1000v0.f2980z;
        c0868b.g(DescriptorProtos$MethodDescriptorProto.class, C0925c0.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return k;
    }
}
