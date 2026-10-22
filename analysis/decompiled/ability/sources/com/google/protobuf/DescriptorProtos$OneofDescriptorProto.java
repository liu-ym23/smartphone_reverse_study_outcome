package com.google.protobuf;

import c0.C0868b;
import java.io.Serializable;

/* loaded from: classes3.dex */
public final class DescriptorProtos$OneofDescriptorProto extends GeneratedMessageV3 {
    public static final DescriptorProtos$OneofDescriptorProto g = new DescriptorProtos$OneofDescriptorProto();
    public static final C0937f0 h = new C0937f0();
    public int c;
    public volatile Serializable d;
    public DescriptorProtos$OneofOptions e;
    public byte f = -1;

    private DescriptorProtos$OneofDescriptorProto() {
        this.d = "";
        this.d = "";
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        C0941g0 c0941g0 = new C0941g0(f12);
        c0941g0.f = "";
        return c0941g0;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new DescriptorProtos$OneofDescriptorProto();
    }

    public final String E() {
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

    public final DescriptorProtos$OneofOptions F() {
        DescriptorProtos$OneofOptions descriptorProtos$OneofOptions = this.e;
        return descriptorProtos$OneofOptions == null ? DescriptorProtos$OneofOptions.h : descriptorProtos$OneofOptions;
    }

    public final boolean G() {
        return (this.c & 2) != 0;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public final C0941g0 toBuilder() {
        if (this == g) {
            return new C0941g0();
        }
        C0941g0 c0941g0 = new C0941g0();
        c0941g0.O(this);
        return c0941g0;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        if ((this.c & 1) != 0) {
            GeneratedMessageV3.D(c0980q, 1, this.d);
        }
        if ((this.c & 2) != 0) {
            c0980q.f0(2, F());
        }
        this.b.c(c0980q);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof DescriptorProtos$OneofDescriptorProto)) {
                return super.equals(obj);
            }
            DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto = (DescriptorProtos$OneofDescriptorProto) obj;
            int i = this.c;
            if (((i & 1) != 0) != ((descriptorProtos$OneofDescriptorProto.c & 1) != 0) || (((i & 1) != 0 && !E().equals(descriptorProtos$OneofDescriptorProto.E())) || G() != descriptorProtos$OneofDescriptorProto.G() || ((G() && !F().equals(descriptorProtos$OneofDescriptorProto.F())) || !this.b.equals(descriptorProtos$OneofDescriptorProto.b)))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return g;
    }

    @Override // com.google.protobuf.X1
    public final int getSerializedSize() {
        int i = this.f2909a;
        if (i != -1) {
            return i;
        }
        int iV = (this.c & 1) != 0 ? GeneratedMessageV3.v(1, this.d) : 0;
        if ((this.c & 2) != 0) {
            iV += C0980q.P(2, F());
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
        int iHashCode = AbstractC1000v0.o.hashCode() + 779;
        if ((this.c & 1) != 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + E().hashCode();
        }
        if (G()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53) + F().hashCode();
        }
        int iHashCode2 = this.b.hashCode() + (iHashCode * 29);
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        byte b = this.f;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (!G() || F().isInitialized()) {
            this.f = (byte) 1;
            return true;
        }
        this.f = (byte) 0;
        return false;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: newBuilderForType */
    public final W1 q() {
        return g.toBuilder();
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a q() {
        return g.toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final C0868b y() {
        C0868b c0868b = AbstractC1000v0.p;
        c0868b.g(DescriptorProtos$OneofDescriptorProto.class, C0941g0.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return g;
    }
}
