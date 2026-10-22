package com.google.protobuf;

import c0.C0868b;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos$UninterpretedOption extends GeneratedMessageV3 {
    public static final DescriptorProtos$UninterpretedOption l = new DescriptorProtos$UninterpretedOption();
    public static final C0984r0 m = new C0984r0();
    public int c;
    public List d;
    public volatile Serializable e;
    public long f = 0;
    public long g = 0;
    public double h = 0.0d;
    public ByteString i;

    /* renamed from: j, reason: collision with root package name */
    public volatile Serializable f2820j;
    public byte k;

    public static final class NamePart extends GeneratedMessageV3 {
        public static final NamePart g = new NamePart();
        public static final C0992t0 h = new C0992t0();
        public int c;
        public volatile Serializable d;
        public boolean e = false;
        public byte f = -1;

        private NamePart() {
            this.d = "";
            this.d = "";
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public final AbstractC0916a B(F1 f12) {
            C0996u0 c0996u0 = new C0996u0(f12);
            c0996u0.f = "";
            return c0996u0;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public final Object C() {
            return new NamePart();
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

        public final boolean F() {
            return (this.c & 2) != 0;
        }

        public final boolean G() {
            return (this.c & 1) != 0;
        }

        @Override // com.google.protobuf.X1
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public final C0996u0 toBuilder() {
            if (this == g) {
                return new C0996u0();
            }
            C0996u0 c0996u0 = new C0996u0();
            c0996u0.O(this);
            return c0996u0;
        }

        @Override // com.google.protobuf.X1
        public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
            if ((this.c & 1) != 0) {
                GeneratedMessageV3.D(c0980q, 1, this.d);
            }
            if ((this.c & 2) != 0) {
                c0980q.W(2, this.e);
            }
            this.b.c(c0980q);
        }

        @Override // com.google.protobuf.AbstractC0924c
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof NamePart)) {
                return super.equals(obj);
            }
            NamePart namePart = (NamePart) obj;
            if (G() != namePart.G()) {
                return false;
            }
            if ((!G() || E().equals(namePart.E())) && F() == namePart.F()) {
                return (!F() || this.e == namePart.e) && this.b.equals(namePart.b);
            }
            return false;
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
                iV += C0980q.J(2);
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
            int iHashCode = AbstractC1000v0.f2964U.hashCode() + 779;
            if (G()) {
                iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + E().hashCode();
            }
            if (F()) {
                iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53) + AbstractC0989s1.b(this.e);
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
            if (!G()) {
                this.f = (byte) 0;
                return false;
            }
            if (F()) {
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
            C0868b c0868b = AbstractC1000v0.f2965V;
            c0868b.g(NamePart.class, C0996u0.class);
            return c0868b;
        }

        @Override // com.google.protobuf.Y1
        public final X1 getDefaultInstanceForType() {
            return g;
        }
    }

    private DescriptorProtos$UninterpretedOption() {
        this.e = "";
        ByteString byteString = ByteString.b;
        this.i = byteString;
        this.f2820j = "";
        this.k = (byte) -1;
        this.d = Collections.EMPTY_LIST;
        this.e = "";
        this.i = byteString;
        this.f2820j = "";
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        C0988s0 c0988s0 = new C0988s0(f12);
        c0988s0.f = Collections.EMPTY_LIST;
        c0988s0.g = "";
        c0988s0.k = ByteString.b;
        c0988s0.l = "";
        return c0988s0;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new DescriptorProtos$UninterpretedOption();
    }

    public final String E() {
        Serializable serializable = this.f2820j;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        ByteString byteString = (ByteString) serializable;
        String strQ = byteString.q();
        if (byteString.i()) {
            this.f2820j = strQ;
        }
        return strQ;
    }

    public final String F() {
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

    public final boolean G() {
        return (this.c & 32) != 0;
    }

    public final boolean H() {
        return (this.c & 8) != 0;
    }

    public final boolean I() {
        return (this.c & 4) != 0;
    }

    public final boolean J() {
        return (this.c & 2) != 0;
    }

    public final boolean K() {
        return (this.c & 16) != 0;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public final C0988s0 toBuilder() {
        if (this == l) {
            return new C0988s0();
        }
        C0988s0 c0988s0 = new C0988s0();
        c0988s0.O(this);
        return c0988s0;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        for (int i = 0; i < this.d.size(); i++) {
            c0980q.f0(2, (X1) this.d.get(i));
        }
        if ((this.c & 1) != 0) {
            GeneratedMessageV3.D(c0980q, 3, this.e);
        }
        if ((this.c & 2) != 0) {
            c0980q.m0(4, this.f);
        }
        if ((this.c & 4) != 0) {
            c0980q.m0(5, this.g);
        }
        if ((this.c & 8) != 0) {
            double d = this.h;
            c0980q.getClass();
            c0980q.a0(6, Double.doubleToRawLongBits(d));
        }
        if ((this.c & 16) != 0) {
            c0980q.X(7, this.i);
        }
        if ((this.c & 32) != 0) {
            GeneratedMessageV3.D(c0980q, 8, this.f2820j);
        }
        this.b.c(c0980q);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof DescriptorProtos$UninterpretedOption)) {
                return super.equals(obj);
            }
            DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption = (DescriptorProtos$UninterpretedOption) obj;
            if (this.d.equals(descriptorProtos$UninterpretedOption.d)) {
                int i = this.c;
                if (((i & 1) != 0) == ((descriptorProtos$UninterpretedOption.c & 1) != 0) && (((i & 1) == 0 || F().equals(descriptorProtos$UninterpretedOption.F())) && J() == descriptorProtos$UninterpretedOption.J() && ((!J() || this.f == descriptorProtos$UninterpretedOption.f) && I() == descriptorProtos$UninterpretedOption.I() && ((!I() || this.g == descriptorProtos$UninterpretedOption.g) && H() == descriptorProtos$UninterpretedOption.H() && ((!H() || Double.doubleToLongBits(this.h) == Double.doubleToLongBits(descriptorProtos$UninterpretedOption.h)) && K() == descriptorProtos$UninterpretedOption.K() && ((!K() || this.i.equals(descriptorProtos$UninterpretedOption.i)) && G() == descriptorProtos$UninterpretedOption.G() && ((!G() || E().equals(descriptorProtos$UninterpretedOption.E())) && this.b.equals(descriptorProtos$UninterpretedOption.b)))))))) {
                }
            }
            return false;
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
        int iV = 0;
        for (int i6 = 0; i6 < this.d.size(); i6++) {
            iV += C0980q.P(2, (X1) this.d.get(i6));
        }
        if ((this.c & 1) != 0) {
            iV += GeneratedMessageV3.v(3, this.e);
        }
        if ((this.c & 2) != 0) {
            iV += C0980q.T(this.f) + C0980q.R(4);
        }
        if ((this.c & 4) != 0) {
            iV += C0980q.T(this.g) + C0980q.R(5);
        }
        if ((this.c & 8) != 0) {
            iV += C0980q.R(6) + 8;
        }
        if ((this.c & 16) != 0) {
            iV += C0980q.K(7, this.i);
        }
        if ((this.c & 32) != 0) {
            iV += GeneratedMessageV3.v(8, this.f2820j);
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
        int iHashCode = AbstractC1000v0.f2962S.hashCode() + 779;
        if (this.d.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53) + this.d.hashCode();
        }
        if ((this.c & 1) != 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 3, 53) + F().hashCode();
        }
        if (J()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 4, 53) + AbstractC0989s1.c(this.f);
        }
        if (I()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 5, 53) + AbstractC0989s1.c(this.g);
        }
        if (H()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 6, 53) + AbstractC0989s1.c(Double.doubleToLongBits(this.h));
        }
        if (K()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 7, 53) + this.i.hashCode();
        }
        if (G()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 8, 53) + E().hashCode();
        }
        int iHashCode2 = this.b.hashCode() + (iHashCode * 29);
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
        for (int i = 0; i < this.d.size(); i++) {
            if (!((NamePart) this.d.get(i)).isInitialized()) {
                this.k = (byte) 0;
                return false;
            }
        }
        this.k = (byte) 1;
        return true;
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
        C0868b c0868b = AbstractC1000v0.f2963T;
        c0868b.g(DescriptorProtos$UninterpretedOption.class, C0988s0.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return l;
    }
}
