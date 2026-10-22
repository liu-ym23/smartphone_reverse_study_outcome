package com.google.protobuf;

import c0.C0868b;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos$EnumDescriptorProto extends GeneratedMessageV3 {

    /* renamed from: j, reason: collision with root package name */
    public static final DescriptorProtos$EnumDescriptorProto f2768j = new DescriptorProtos$EnumDescriptorProto();
    public static final C1011y k = new C1011y();
    public int c;
    public volatile Serializable d;
    public List e;
    public DescriptorProtos$EnumOptions f;
    public List g;
    public C1005w1 h;
    public byte i;

    public static final class EnumReservedRange extends GeneratedMessageV3 {
        public static final EnumReservedRange g = new EnumReservedRange();
        public static final A h = new A();
        public int c;
        public int d = 0;
        public int e = 0;
        public byte f = -1;

        private EnumReservedRange() {
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public final AbstractC0916a B(F1 f12) {
            return new B(f12);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public final Object C() {
            return new EnumReservedRange();
        }

        public final boolean E() {
            return (this.c & 2) != 0;
        }

        @Override // com.google.protobuf.X1
        /* renamed from: F, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public final B toBuilder() {
            if (this == g) {
                return new B(null);
            }
            B b = new B(null);
            b.P(this);
            return b;
        }

        @Override // com.google.protobuf.X1
        public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
            if ((this.c & 1) != 0) {
                c0980q.d0(1, this.d);
            }
            if ((this.c & 2) != 0) {
                c0980q.d0(2, this.e);
            }
            this.b.c(c0980q);
        }

        @Override // com.google.protobuf.AbstractC0924c
        public final boolean equals(Object obj) {
            if (obj != this) {
                if (!(obj instanceof EnumReservedRange)) {
                    return super.equals(obj);
                }
                EnumReservedRange enumReservedRange = (EnumReservedRange) obj;
                int i = this.c;
                if (((i & 1) != 0) != ((enumReservedRange.c & 1) != 0) || (((i & 1) != 0 && this.d != enumReservedRange.d) || E() != enumReservedRange.E() || ((E() && this.e != enumReservedRange.e) || !this.b.equals(enumReservedRange.b)))) {
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
            int iN = (this.c & 1) != 0 ? C0980q.N(1, this.d) : 0;
            if ((this.c & 2) != 0) {
                iN += C0980q.N(2, this.e);
            }
            int serializedSize = this.b.getSerializedSize() + iN;
            this.f2909a = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractC0924c
        public final int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int iHashCode = AbstractC1000v0.f2975s.hashCode() + 779;
            if ((this.c & 1) != 0) {
                iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + this.d;
            }
            if (E()) {
                iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53) + this.e;
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
            this.f = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.X1
        /* renamed from: newBuilderForType */
        public final W1 q() {
            return g.s();
        }

        @Override // com.google.protobuf.AbstractC0924c
        public final AbstractC0916a q() {
            return g.s();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public final C0868b y() {
            C0868b c0868b = AbstractC1000v0.f2976t;
            c0868b.g(EnumReservedRange.class, B.class);
            return c0868b;
        }

        @Override // com.google.protobuf.Y1
        public final X1 getDefaultInstanceForType() {
            return g;
        }
    }

    private DescriptorProtos$EnumDescriptorProto() {
        this.d = "";
        C1005w1 c1005w1 = C1005w1.c;
        this.h = c1005w1;
        this.i = (byte) -1;
        this.d = "";
        List list = Collections.EMPTY_LIST;
        this.e = list;
        this.g = list;
        this.h = c1005w1;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        C1015z c1015z = new C1015z(f12);
        c1015z.f = "";
        List list = Collections.EMPTY_LIST;
        c1015z.g = list;
        c1015z.f2987j = list;
        c1015z.k = C1005w1.c;
        return c1015z;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new DescriptorProtos$EnumDescriptorProto();
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

    public final DescriptorProtos$EnumOptions F() {
        DescriptorProtos$EnumOptions descriptorProtos$EnumOptions = this.f;
        return descriptorProtos$EnumOptions == null ? DescriptorProtos$EnumOptions.k : descriptorProtos$EnumOptions;
    }

    public final boolean G() {
        return (this.c & 2) != 0;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public final C1015z toBuilder() {
        if (this == f2768j) {
            return new C1015z();
        }
        C1015z c1015z = new C1015z();
        c1015z.Q(this);
        return c1015z;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        if ((this.c & 1) != 0) {
            GeneratedMessageV3.D(c0980q, 1, this.d);
        }
        for (int i = 0; i < this.e.size(); i++) {
            c0980q.f0(2, (X1) this.e.get(i));
        }
        if ((this.c & 2) != 0) {
            c0980q.f0(3, F());
        }
        for (int i6 = 0; i6 < this.g.size(); i6++) {
            c0980q.f0(4, (X1) this.g.get(i6));
        }
        for (int i10 = 0; i10 < this.h.b.size(); i10++) {
            GeneratedMessageV3.D(c0980q, 5, this.h.b.get(i10));
        }
        this.b.c(c0980q);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof DescriptorProtos$EnumDescriptorProto)) {
                return super.equals(obj);
            }
            DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto = (DescriptorProtos$EnumDescriptorProto) obj;
            int i = this.c;
            if (((i & 1) != 0) != ((descriptorProtos$EnumDescriptorProto.c & 1) != 0) || (((i & 1) != 0 && !E().equals(descriptorProtos$EnumDescriptorProto.E())) || !this.e.equals(descriptorProtos$EnumDescriptorProto.e) || G() != descriptorProtos$EnumDescriptorProto.G() || ((G() && !F().equals(descriptorProtos$EnumDescriptorProto.F())) || !this.g.equals(descriptorProtos$EnumDescriptorProto.g) || !this.h.equals(descriptorProtos$EnumDescriptorProto.h) || !this.b.equals(descriptorProtos$EnumDescriptorProto.b)))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return f2768j;
    }

    @Override // com.google.protobuf.X1
    public final int getSerializedSize() {
        int i = this.f2909a;
        if (i != -1) {
            return i;
        }
        int iV = (this.c & 1) != 0 ? GeneratedMessageV3.v(1, this.d) : 0;
        for (int i6 = 0; i6 < this.e.size(); i6++) {
            iV += C0980q.P(2, (X1) this.e.get(i6));
        }
        if ((this.c & 2) != 0) {
            iV += C0980q.P(3, F());
        }
        for (int i10 = 0; i10 < this.g.size(); i10++) {
            iV += C0980q.P(4, (X1) this.g.get(i10));
        }
        int iW = 0;
        for (int i11 = 0; i11 < this.h.b.size(); i11++) {
            iW += GeneratedMessageV3.w(this.h.b.get(i11));
        }
        int serializedSize = this.b.getSerializedSize() + this.h.b.size() + iV + iW;
        this.f2909a = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = AbstractC1000v0.f2973q.hashCode() + 779;
        if ((this.c & 1) != 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + E().hashCode();
        }
        if (this.e.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53) + this.e.hashCode();
        }
        if (G()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 3, 53) + F().hashCode();
        }
        if (this.g.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 4, 53) + this.g.hashCode();
        }
        if (this.h.b.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 5, 53) + this.h.hashCode();
        }
        int iHashCode2 = this.b.hashCode() + (iHashCode * 29);
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        byte b = this.i;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        for (int i = 0; i < this.e.size(); i++) {
            if (!((DescriptorProtos$EnumValueDescriptorProto) this.e.get(i)).isInitialized()) {
                this.i = (byte) 0;
                return false;
            }
        }
        if (!G() || F().isInitialized()) {
            this.i = (byte) 1;
            return true;
        }
        this.i = (byte) 0;
        return false;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: newBuilderForType */
    public final W1 q() {
        return f2768j.toBuilder();
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a q() {
        return f2768j.toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final C0868b y() {
        C0868b c0868b = AbstractC1000v0.f2974r;
        c0868b.g(DescriptorProtos$EnumDescriptorProto.class, C1015z.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return f2768j;
    }
}
