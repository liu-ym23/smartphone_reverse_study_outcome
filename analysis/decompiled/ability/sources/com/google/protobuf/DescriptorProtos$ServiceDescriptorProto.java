package com.google.protobuf;

import c0.C0868b;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos$ServiceDescriptorProto extends GeneratedMessageV3 {
    public static final DescriptorProtos$ServiceDescriptorProto h = new DescriptorProtos$ServiceDescriptorProto();
    public static final C0953j0 i = new C0953j0();
    public int c;
    public volatile Serializable d;
    public DescriptorProtos$ServiceOptions f;
    public byte g = -1;
    public List e = Collections.EMPTY_LIST;

    private DescriptorProtos$ServiceDescriptorProto() {
        this.d = "";
        this.d = "";
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        C0957k0 c0957k0 = new C0957k0(f12);
        c0957k0.f = "";
        c0957k0.g = Collections.EMPTY_LIST;
        return c0957k0;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new DescriptorProtos$ServiceDescriptorProto();
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

    public final DescriptorProtos$ServiceOptions F() {
        DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions = this.f;
        return descriptorProtos$ServiceOptions == null ? DescriptorProtos$ServiceOptions.i : descriptorProtos$ServiceOptions;
    }

    public final boolean G() {
        return (this.c & 2) != 0;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public final C0957k0 toBuilder() {
        if (this == h) {
            return new C0957k0();
        }
        C0957k0 c0957k0 = new C0957k0();
        c0957k0.O(this);
        return c0957k0;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        if ((this.c & 1) != 0) {
            GeneratedMessageV3.D(c0980q, 1, this.d);
        }
        for (int i6 = 0; i6 < this.e.size(); i6++) {
            c0980q.f0(2, (X1) this.e.get(i6));
        }
        if ((this.c & 2) != 0) {
            c0980q.f0(3, F());
        }
        this.b.c(c0980q);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof DescriptorProtos$ServiceDescriptorProto)) {
                return super.equals(obj);
            }
            DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto = (DescriptorProtos$ServiceDescriptorProto) obj;
            int i6 = this.c;
            if (((i6 & 1) != 0) != ((descriptorProtos$ServiceDescriptorProto.c & 1) != 0) || (((i6 & 1) != 0 && !E().equals(descriptorProtos$ServiceDescriptorProto.E())) || !this.e.equals(descriptorProtos$ServiceDescriptorProto.e) || G() != descriptorProtos$ServiceDescriptorProto.G() || ((G() && !F().equals(descriptorProtos$ServiceDescriptorProto.F())) || !this.b.equals(descriptorProtos$ServiceDescriptorProto.b)))) {
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
        for (int i10 = 0; i10 < this.e.size(); i10++) {
            iV += C0980q.P(2, (X1) this.e.get(i10));
        }
        if ((this.c & 2) != 0) {
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
        int iHashCode = AbstractC1000v0.f2978w.hashCode() + 779;
        if ((this.c & 1) != 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + E().hashCode();
        }
        if (this.e.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53) + this.e.hashCode();
        }
        if (G()) {
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
        for (int i6 = 0; i6 < this.e.size(); i6++) {
            if (!((DescriptorProtos$MethodDescriptorProto) this.e.get(i6)).isInitialized()) {
                this.g = (byte) 0;
                return false;
            }
        }
        if (!G() || F().isInitialized()) {
            this.g = (byte) 1;
            return true;
        }
        this.g = (byte) 0;
        return false;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: newBuilderForType */
    public final W1 q() {
        return h.toBuilder();
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a q() {
        return h.toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final C0868b y() {
        C0868b c0868b = AbstractC1000v0.f2979x;
        c0868b.g(DescriptorProtos$ServiceDescriptorProto.class, C0957k0.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return h;
    }
}
