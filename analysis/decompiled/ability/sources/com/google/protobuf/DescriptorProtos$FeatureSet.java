package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.GeneratedMessageV3;

/* loaded from: classes3.dex */
public final class DescriptorProtos$FeatureSet extends GeneratedMessageV3.ExtendableMessage<DescriptorProtos$FeatureSet> {
    public static final DescriptorProtos$FeatureSet l = new DescriptorProtos$FeatureSet();
    public int d;
    public byte k = -1;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f2774j = 0;

    public enum EnumType implements InterfaceC0974o1 {
        ENUM_TYPE_UNKNOWN(0),
        OPEN(1),
        CLOSED(2);


        /* renamed from: a, reason: collision with root package name */
        public final int f2775a;

        static {
            values();
        }

        EnumType(int i) {
            this.f2775a = i;
        }

        public static EnumType a(int i) {
            if (i == 0) {
                return ENUM_TYPE_UNKNOWN;
            }
            if (i == 1) {
                return OPEN;
            }
            if (i != 2) {
                return null;
            }
            return CLOSED;
        }

        @Override // com.google.protobuf.InterfaceC0974o1
        public final int getNumber() {
            return this.f2775a;
        }
    }

    public enum FieldPresence implements InterfaceC0974o1 {
        FIELD_PRESENCE_UNKNOWN(0),
        EXPLICIT(1),
        IMPLICIT(2),
        LEGACY_REQUIRED(3);


        /* renamed from: a, reason: collision with root package name */
        public final int f2776a;

        static {
            values();
        }

        FieldPresence(int i) {
            this.f2776a = i;
        }

        public static FieldPresence a(int i) {
            if (i == 0) {
                return FIELD_PRESENCE_UNKNOWN;
            }
            if (i == 1) {
                return EXPLICIT;
            }
            if (i == 2) {
                return IMPLICIT;
            }
            if (i != 3) {
                return null;
            }
            return LEGACY_REQUIRED;
        }

        @Override // com.google.protobuf.InterfaceC0974o1
        public final int getNumber() {
            return this.f2776a;
        }
    }

    public enum JsonFormat implements InterfaceC0974o1 {
        JSON_FORMAT_UNKNOWN(0),
        ALLOW(1),
        LEGACY_BEST_EFFORT(2);


        /* renamed from: a, reason: collision with root package name */
        public final int f2777a;

        static {
            values();
        }

        JsonFormat(int i) {
            this.f2777a = i;
        }

        public static JsonFormat a(int i) {
            if (i == 0) {
                return JSON_FORMAT_UNKNOWN;
            }
            if (i == 1) {
                return ALLOW;
            }
            if (i != 2) {
                return null;
            }
            return LEGACY_BEST_EFFORT;
        }

        @Override // com.google.protobuf.InterfaceC0974o1
        public final int getNumber() {
            return this.f2777a;
        }
    }

    public enum MessageEncoding implements InterfaceC0974o1 {
        MESSAGE_ENCODING_UNKNOWN(0),
        LENGTH_PREFIXED(1),
        DELIMITED(2);


        /* renamed from: a, reason: collision with root package name */
        public final int f2778a;

        static {
            values();
        }

        MessageEncoding(int i) {
            this.f2778a = i;
        }

        public static MessageEncoding a(int i) {
            if (i == 0) {
                return MESSAGE_ENCODING_UNKNOWN;
            }
            if (i == 1) {
                return LENGTH_PREFIXED;
            }
            if (i != 2) {
                return null;
            }
            return DELIMITED;
        }

        @Override // com.google.protobuf.InterfaceC0974o1
        public final int getNumber() {
            return this.f2778a;
        }
    }

    public enum RepeatedFieldEncoding implements InterfaceC0974o1 {
        REPEATED_FIELD_ENCODING_UNKNOWN(0),
        PACKED(1),
        EXPANDED(2);


        /* renamed from: a, reason: collision with root package name */
        public final int f2779a;

        static {
            values();
        }

        RepeatedFieldEncoding(int i) {
            this.f2779a = i;
        }

        public static RepeatedFieldEncoding a(int i) {
            if (i == 0) {
                return REPEATED_FIELD_ENCODING_UNKNOWN;
            }
            if (i == 1) {
                return PACKED;
            }
            if (i != 2) {
                return null;
            }
            return EXPANDED;
        }

        @Override // com.google.protobuf.InterfaceC0974o1
        public final int getNumber() {
            return this.f2779a;
        }
    }

    public enum Utf8Validation implements InterfaceC0974o1 {
        UTF8_VALIDATION_UNKNOWN(0),
        NONE(1),
        VERIFY(2);


        /* renamed from: a, reason: collision with root package name */
        public final int f2780a;

        static {
            values();
        }

        Utf8Validation(int i) {
            this.f2780a = i;
        }

        public static Utf8Validation a(int i) {
            if (i == 0) {
                return UTF8_VALIDATION_UNKNOWN;
            }
            if (i == 1) {
                return NONE;
            }
            if (i != 2) {
                return null;
            }
            return VERIFY;
        }

        @Override // com.google.protobuf.InterfaceC0974o1
        public final int getNumber() {
            return this.f2780a;
        }
    }

    private DescriptorProtos$FeatureSet() {
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        N n = new N(f12);
        n.g = 0;
        n.h = 0;
        n.i = 0;
        n.f2858j = 0;
        n.k = 0;
        n.l = 0;
        return n;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new DescriptorProtos$FeatureSet();
    }

    public final boolean E() {
        return (this.d & 2) != 0;
    }

    public final boolean F() {
        return (this.d & 32) != 0;
    }

    public final boolean G() {
        return (this.d & 16) != 0;
    }

    public final boolean H() {
        return (this.d & 4) != 0;
    }

    public final boolean I() {
        return (this.d & 8) != 0;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public final N toBuilder() {
        if (this == l) {
            return new N();
        }
        N n = new N();
        n.U(this);
        return n;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        C0934e1 c0934e1 = new C0934e1(this);
        if ((this.d & 1) != 0) {
            c0980q.d0(1, this.e);
        }
        if ((this.d & 2) != 0) {
            c0980q.d0(2, this.f);
        }
        if ((this.d & 4) != 0) {
            c0980q.d0(3, this.g);
        }
        if ((this.d & 8) != 0) {
            c0980q.d0(4, this.h);
        }
        if ((this.d & 16) != 0) {
            c0980q.d0(5, this.i);
        }
        if ((this.d & 32) != 0) {
            c0980q.d0(6, this.f2774j);
        }
        c0934e1.a(10000, c0980q);
        this.b.c(c0980q);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof DescriptorProtos$FeatureSet)) {
                return super.equals(obj);
            }
            DescriptorProtos$FeatureSet descriptorProtos$FeatureSet = (DescriptorProtos$FeatureSet) obj;
            int i = this.d;
            if (((i & 1) != 0) != ((descriptorProtos$FeatureSet.d & 1) != 0) || (((i & 1) != 0 && this.e != descriptorProtos$FeatureSet.e) || E() != descriptorProtos$FeatureSet.E() || ((E() && this.f != descriptorProtos$FeatureSet.f) || H() != descriptorProtos$FeatureSet.H() || ((H() && this.g != descriptorProtos$FeatureSet.g) || I() != descriptorProtos$FeatureSet.I() || ((I() && this.h != descriptorProtos$FeatureSet.h) || G() != descriptorProtos$FeatureSet.G() || ((G() && this.i != descriptorProtos$FeatureSet.i) || F() != descriptorProtos$FeatureSet.F() || ((F() && this.f2774j != descriptorProtos$FeatureSet.f2774j) || !this.b.equals(descriptorProtos$FeatureSet.b) || !this.c.h().equals(descriptorProtos$FeatureSet.c.h())))))))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return l;
    }

    @Override // com.google.protobuf.X1
    public final int getSerializedSize() {
        int i = this.f2909a;
        if (i != -1) {
            return i;
        }
        int iM = (this.d & 1) != 0 ? C0980q.M(1, this.e) : 0;
        if ((this.d & 2) != 0) {
            iM += C0980q.M(2, this.f);
        }
        if ((this.d & 4) != 0) {
            iM += C0980q.M(3, this.g);
        }
        if ((this.d & 8) != 0) {
            iM += C0980q.M(4, this.h);
        }
        if ((this.d & 16) != 0) {
            iM += C0980q.M(5, this.i);
        }
        if ((this.d & 32) != 0) {
            iM += C0980q.M(6, this.f2774j);
        }
        int serializedSize = this.b.getSerializedSize() + this.c.k() + iM;
        this.f2909a = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = AbstractC1000v0.f2966W.hashCode() + 779;
        if ((this.d & 1) != 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + this.e;
        }
        if (E()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53) + this.f;
        }
        if (H()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 3, 53) + this.g;
        }
        if (I()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 4, 53) + this.h;
        }
        if (G()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 5, 53) + this.i;
        }
        if (F()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 6, 53) + this.f2774j;
        }
        int iHashCode2 = this.b.hashCode() + (AbstractC0924c.p(iHashCode, this.c.h()) * 29);
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        byte b = this.k;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (this.c.m()) {
            this.k = (byte) 1;
            return true;
        }
        this.k = (byte) 0;
        return false;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: newBuilderForType */
    public final W1 q() {
        return l.toBuilder();
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a q() {
        return l.toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final C0868b y() {
        C0868b c0868b = AbstractC1000v0.f2967X;
        c0868b.g(DescriptorProtos$FeatureSet.class, N.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return l;
    }
}
