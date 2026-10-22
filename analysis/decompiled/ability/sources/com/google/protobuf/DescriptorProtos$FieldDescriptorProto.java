package com.google.protobuf;

import c0.C0868b;
import java.io.Serializable;

/* loaded from: classes3.dex */
public final class DescriptorProtos$FieldDescriptorProto extends GeneratedMessageV3 {
    public static final DescriptorProtos$FieldDescriptorProto p = new DescriptorProtos$FieldDescriptorProto();

    /* renamed from: q, reason: collision with root package name */
    public static final O f2781q = new O();
    public int c;
    public volatile Serializable d;
    public int f;
    public int g;
    public volatile Serializable h;
    public volatile Serializable i;

    /* renamed from: j, reason: collision with root package name */
    public volatile Serializable f2782j;
    public volatile Serializable l;
    public DescriptorProtos$FieldOptions m;
    public int e = 0;
    public int k = 0;
    public boolean n = false;
    public byte o = -1;

    public enum Label implements InterfaceC0974o1 {
        LABEL_OPTIONAL(1),
        LABEL_REPEATED(3),
        LABEL_REQUIRED(2);


        /* renamed from: a, reason: collision with root package name */
        public final int f2783a;

        static {
            values();
        }

        Label(int i) {
            this.f2783a = i;
        }

        public static Label a(int i) {
            if (i == 1) {
                return LABEL_OPTIONAL;
            }
            if (i == 2) {
                return LABEL_REQUIRED;
            }
            if (i != 3) {
                return null;
            }
            return LABEL_REPEATED;
        }

        @Override // com.google.protobuf.InterfaceC0974o1
        public final int getNumber() {
            return this.f2783a;
        }
    }

    public enum Type implements InterfaceC0974o1 {
        TYPE_DOUBLE(1),
        TYPE_FLOAT(2),
        TYPE_INT64(3),
        TYPE_UINT64(4),
        TYPE_INT32(5),
        TYPE_FIXED64(6),
        TYPE_FIXED32(7),
        TYPE_BOOL(8),
        TYPE_STRING(9),
        TYPE_GROUP(10),
        TYPE_MESSAGE(11),
        TYPE_BYTES(12),
        TYPE_UINT32(13),
        TYPE_ENUM(14),
        TYPE_SFIXED32(15),
        TYPE_SFIXED64(16),
        TYPE_SINT32(17),
        TYPE_SINT64(18);


        /* renamed from: a, reason: collision with root package name */
        public final int f2789a;

        static {
            values();
        }

        Type(int i) {
            this.f2789a = i;
        }

        public static Type a(int i) {
            switch (i) {
                case 1:
                    return TYPE_DOUBLE;
                case 2:
                    return TYPE_FLOAT;
                case 3:
                    return TYPE_INT64;
                case 4:
                    return TYPE_UINT64;
                case 5:
                    return TYPE_INT32;
                case 6:
                    return TYPE_FIXED64;
                case 7:
                    return TYPE_FIXED32;
                case 8:
                    return TYPE_BOOL;
                case 9:
                    return TYPE_STRING;
                case 10:
                    return TYPE_GROUP;
                case 11:
                    return TYPE_MESSAGE;
                case 12:
                    return TYPE_BYTES;
                case 13:
                    return TYPE_UINT32;
                case 14:
                    return TYPE_ENUM;
                case 15:
                    return TYPE_SFIXED32;
                case 16:
                    return TYPE_SFIXED64;
                case 17:
                    return TYPE_SINT32;
                case 18:
                    return TYPE_SINT64;
                default:
                    return null;
            }
        }

        @Override // com.google.protobuf.InterfaceC0974o1
        public final int getNumber() {
            return this.f2789a;
        }
    }

    private DescriptorProtos$FieldDescriptorProto() {
        this.d = "";
        this.f = 1;
        this.g = 1;
        this.h = "";
        this.i = "";
        this.f2782j = "";
        this.l = "";
        this.d = "";
        this.f = 1;
        this.g = 1;
        this.h = "";
        this.i = "";
        this.f2782j = "";
        this.l = "";
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        P p3 = new P(f12);
        p3.f = "";
        p3.h = 1;
        p3.i = 1;
        p3.f2862j = "";
        p3.k = "";
        p3.l = "";
        p3.n = "";
        return p3;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new DescriptorProtos$FieldDescriptorProto();
    }

    public final String E() {
        Serializable serializable = this.f2782j;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        ByteString byteString = (ByteString) serializable;
        String strQ = byteString.q();
        if (byteString.i()) {
            this.f2782j = strQ;
        }
        return strQ;
    }

    public final String F() {
        Serializable serializable = this.i;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        ByteString byteString = (ByteString) serializable;
        String strQ = byteString.q();
        if (byteString.i()) {
            this.i = strQ;
        }
        return strQ;
    }

    public final String G() {
        Serializable serializable = this.l;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        ByteString byteString = (ByteString) serializable;
        String strQ = byteString.q();
        if (byteString.i()) {
            this.l = strQ;
        }
        return strQ;
    }

    public final String H() {
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

    public final DescriptorProtos$FieldOptions I() {
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions = this.m;
        return descriptorProtos$FieldOptions == null ? DescriptorProtos$FieldOptions.f2790s : descriptorProtos$FieldOptions;
    }

    public final String J() {
        Serializable serializable = this.h;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        ByteString byteString = (ByteString) serializable;
        String strQ = byteString.q();
        if (byteString.i()) {
            this.h = strQ;
        }
        return strQ;
    }

    public final boolean K() {
        return (this.c & 64) != 0;
    }

    public final boolean L() {
        return (this.c & 32) != 0;
    }

    public final boolean M() {
        return (this.c & 256) != 0;
    }

    public final boolean N() {
        return (this.c & 4) != 0;
    }

    public final boolean O() {
        return (this.c & 2) != 0;
    }

    public final boolean P() {
        return (this.c & 128) != 0;
    }

    public final boolean Q() {
        return (this.c & 512) != 0;
    }

    public final boolean R() {
        return (this.c & 1024) != 0;
    }

    public final boolean S() {
        return (this.c & 8) != 0;
    }

    public final boolean T() {
        return (this.c & 16) != 0;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public final P toBuilder() {
        if (this == p) {
            return new P();
        }
        P p3 = new P();
        p3.O(this);
        return p3;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        if ((this.c & 1) != 0) {
            GeneratedMessageV3.D(c0980q, 1, this.d);
        }
        if ((this.c & 32) != 0) {
            GeneratedMessageV3.D(c0980q, 2, this.i);
        }
        if ((this.c & 2) != 0) {
            c0980q.d0(3, this.e);
        }
        if ((this.c & 4) != 0) {
            c0980q.d0(4, this.f);
        }
        if ((this.c & 8) != 0) {
            c0980q.d0(5, this.g);
        }
        if ((this.c & 16) != 0) {
            GeneratedMessageV3.D(c0980q, 6, this.h);
        }
        if ((this.c & 64) != 0) {
            GeneratedMessageV3.D(c0980q, 7, this.f2782j);
        }
        if ((this.c & 512) != 0) {
            c0980q.f0(8, I());
        }
        if ((this.c & 128) != 0) {
            c0980q.d0(9, this.k);
        }
        if ((this.c & 256) != 0) {
            GeneratedMessageV3.D(c0980q, 10, this.l);
        }
        if ((this.c & 1024) != 0) {
            c0980q.W(17, this.n);
        }
        this.b.c(c0980q);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof DescriptorProtos$FieldDescriptorProto)) {
                return super.equals(obj);
            }
            DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = (DescriptorProtos$FieldDescriptorProto) obj;
            int i = this.c;
            if (((i & 1) != 0) != ((descriptorProtos$FieldDescriptorProto.c & 1) != 0) || (((i & 1) != 0 && !H().equals(descriptorProtos$FieldDescriptorProto.H())) || O() != descriptorProtos$FieldDescriptorProto.O() || ((O() && this.e != descriptorProtos$FieldDescriptorProto.e) || N() != descriptorProtos$FieldDescriptorProto.N() || ((N() && this.f != descriptorProtos$FieldDescriptorProto.f) || S() != descriptorProtos$FieldDescriptorProto.S() || ((S() && this.g != descriptorProtos$FieldDescriptorProto.g) || T() != descriptorProtos$FieldDescriptorProto.T() || ((T() && !J().equals(descriptorProtos$FieldDescriptorProto.J())) || L() != descriptorProtos$FieldDescriptorProto.L() || ((L() && !F().equals(descriptorProtos$FieldDescriptorProto.F())) || K() != descriptorProtos$FieldDescriptorProto.K() || ((K() && !E().equals(descriptorProtos$FieldDescriptorProto.E())) || P() != descriptorProtos$FieldDescriptorProto.P() || ((P() && this.k != descriptorProtos$FieldDescriptorProto.k) || M() != descriptorProtos$FieldDescriptorProto.M() || ((M() && !G().equals(descriptorProtos$FieldDescriptorProto.G())) || Q() != descriptorProtos$FieldDescriptorProto.Q() || ((Q() && !I().equals(descriptorProtos$FieldDescriptorProto.I())) || R() != descriptorProtos$FieldDescriptorProto.R() || ((R() && this.n != descriptorProtos$FieldDescriptorProto.n) || !this.b.equals(descriptorProtos$FieldDescriptorProto.b))))))))))))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return p;
    }

    @Override // com.google.protobuf.X1
    public final int getSerializedSize() {
        int i = this.f2909a;
        if (i != -1) {
            return i;
        }
        int iV = (this.c & 1) != 0 ? GeneratedMessageV3.v(1, this.d) : 0;
        if ((this.c & 32) != 0) {
            iV += GeneratedMessageV3.v(2, this.i);
        }
        if ((this.c & 2) != 0) {
            iV += C0980q.N(3, this.e);
        }
        if ((this.c & 4) != 0) {
            iV += C0980q.M(4, this.f);
        }
        if ((this.c & 8) != 0) {
            iV += C0980q.M(5, this.g);
        }
        if ((this.c & 16) != 0) {
            iV += GeneratedMessageV3.v(6, this.h);
        }
        if ((this.c & 64) != 0) {
            iV += GeneratedMessageV3.v(7, this.f2782j);
        }
        if ((this.c & 512) != 0) {
            iV += C0980q.P(8, I());
        }
        if ((this.c & 128) != 0) {
            iV += C0980q.N(9, this.k);
        }
        if ((this.c & 256) != 0) {
            iV += GeneratedMessageV3.v(10, this.l);
        }
        if ((this.c & 1024) != 0) {
            iV += C0980q.J(17);
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
        int iHashCode = AbstractC1000v0.m.hashCode() + 779;
        if ((this.c & 1) != 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + H().hashCode();
        }
        if (O()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 3, 53) + this.e;
        }
        if (N()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 4, 53) + this.f;
        }
        if (S()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 5, 53) + this.g;
        }
        if (T()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 6, 53) + J().hashCode();
        }
        if (L()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53) + F().hashCode();
        }
        if (K()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 7, 53) + E().hashCode();
        }
        if (P()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 9, 53) + this.k;
        }
        if (M()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 10, 53) + G().hashCode();
        }
        if (Q()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 8, 53) + I().hashCode();
        }
        if (R()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 17, 53) + AbstractC0989s1.b(this.n);
        }
        int iHashCode2 = this.b.hashCode() + (iHashCode * 29);
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        byte b = this.o;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (!Q() || I().isInitialized()) {
            this.o = (byte) 1;
            return true;
        }
        this.o = (byte) 0;
        return false;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: newBuilderForType */
    public final W1 q() {
        return p.toBuilder();
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a q() {
        return p.toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final C0868b y() {
        C0868b c0868b = AbstractC1000v0.n;
        c0868b.g(DescriptorProtos$FieldDescriptorProto.class, P.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return p;
    }
}
