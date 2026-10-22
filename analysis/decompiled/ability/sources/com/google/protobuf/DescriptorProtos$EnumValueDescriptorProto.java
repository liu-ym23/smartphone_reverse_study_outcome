package com.google.protobuf;

import c0.C0868b;
import java.io.Serializable;

/* loaded from: classes3.dex */
public final class DescriptorProtos$EnumValueDescriptorProto extends GeneratedMessageV3 {
    public static final DescriptorProtos$EnumValueDescriptorProto h = new DescriptorProtos$EnumValueDescriptorProto();
    public static final E i = new E();
    public int c;
    public volatile Serializable d;
    public DescriptorProtos$EnumValueOptions f;
    public int e = 0;
    public byte g = -1;

    private DescriptorProtos$EnumValueDescriptorProto() {
        this.d = "";
        this.d = "";
    }

    public static F I() {
        return h.toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        F f = new F(f12);
        f.f = "";
        return f;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new DescriptorProtos$EnumValueDescriptorProto();
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

    public final DescriptorProtos$EnumValueOptions F() {
        DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions = this.f;
        return descriptorProtos$EnumValueOptions == null ? DescriptorProtos$EnumValueOptions.f2770j : descriptorProtos$EnumValueOptions;
    }

    public final boolean G() {
        return (this.c & 2) != 0;
    }

    public final boolean H() {
        return (this.c & 4) != 0;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public final F toBuilder() {
        if (this == h) {
            return new F();
        }
        F f = new F();
        f.P(this);
        return f;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        if ((this.c & 1) != 0) {
            GeneratedMessageV3.D(c0980q, 1, this.d);
        }
        if ((this.c & 2) != 0) {
            c0980q.d0(2, this.e);
        }
        if ((this.c & 4) != 0) {
            c0980q.f0(3, F());
        }
        this.b.c(c0980q);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof DescriptorProtos$EnumValueDescriptorProto)) {
                return super.equals(obj);
            }
            DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto = (DescriptorProtos$EnumValueDescriptorProto) obj;
            int i6 = this.c;
            if (((i6 & 1) != 0) != ((descriptorProtos$EnumValueDescriptorProto.c & 1) != 0) || (((i6 & 1) != 0 && !E().equals(descriptorProtos$EnumValueDescriptorProto.E())) || G() != descriptorProtos$EnumValueDescriptorProto.G() || ((G() && this.e != descriptorProtos$EnumValueDescriptorProto.e) || H() != descriptorProtos$EnumValueDescriptorProto.H() || ((H() && !F().equals(descriptorProtos$EnumValueDescriptorProto.F())) || !this.b.equals(descriptorProtos$EnumValueDescriptorProto.b))))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return h;
    }

    @Override // com.google.protobuf.X1
    public final int getSerializedSize() {
        int i6 = this.f2909a;
        if (i6 != -1) {
            return i6;
        }
        int iV = (this.c & 1) != 0 ? GeneratedMessageV3.v(1, this.d) : 0;
        if ((this.c & 2) != 0) {
            iV += C0980q.N(2, this.e);
        }
        if ((this.c & 4) != 0) {
            iV += C0980q.P(3, F());
        }
        int serializedSize = this.b.getSerializedSize() + iV;
        this.f2909a = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final int hashCode() {
        int i6 = this.memoizedHashCode;
        if (i6 != 0) {
            return i6;
        }
        int iHashCode = AbstractC1000v0.u.hashCode() + 779;
        if ((this.c & 1) != 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + E().hashCode();
        }
        if (G()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53) + this.e;
        }
        if (H()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 3, 53) + F().hashCode();
        }
        int iHashCode2 = this.b.hashCode() + (iHashCode * 29);
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        byte b = this.g;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (!H() || F().isInitialized()) {
            this.g = (byte) 1;
            return true;
        }
        this.g = (byte) 0;
        return false;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: newBuilderForType */
    public final W1 q() {
        return I();
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a q() {
        return I();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final C0868b y() {
        C0868b c0868b = AbstractC1000v0.f2977v;
        c0868b.g(DescriptorProtos$EnumValueDescriptorProto.class, F.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return h;
    }
}
