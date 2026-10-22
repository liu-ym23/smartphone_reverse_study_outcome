package com.google.protobuf;

import c0.C0868b;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos$DescriptorProto extends GeneratedMessageV3 {
    public static final DescriptorProtos$DescriptorProto o = new DescriptorProtos$DescriptorProto();
    public static final C0987s p = new C0987s();
    public int c;
    public volatile Serializable d;
    public List e;
    public List f;
    public List g;
    public List h;
    public List i;

    /* renamed from: j, reason: collision with root package name */
    public List f2765j;
    public DescriptorProtos$MessageOptions k;
    public List l;
    public C1005w1 m;
    public byte n;

    public static final class ExtensionRange extends GeneratedMessageV3 {
        public static final ExtensionRange h = new ExtensionRange();
        public static final C0995u i = new C0995u();
        public int c;
        public DescriptorProtos$ExtensionRangeOptions f;
        public int d = 0;
        public int e = 0;
        public byte g = -1;

        private ExtensionRange() {
        }

        public static C0999v H() {
            return h.toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public final AbstractC0916a B(F1 f12) {
            return new C0999v(f12);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public final Object C() {
            return new ExtensionRange();
        }

        public final DescriptorProtos$ExtensionRangeOptions E() {
            DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions = this.f;
            return descriptorProtos$ExtensionRangeOptions == null ? DescriptorProtos$ExtensionRangeOptions.f2771j : descriptorProtos$ExtensionRangeOptions;
        }

        public final boolean F() {
            return (this.c & 2) != 0;
        }

        public final boolean G() {
            return (this.c & 4) != 0;
        }

        @Override // com.google.protobuf.X1
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public final C0999v toBuilder() {
            if (this == h) {
                return new C0999v(null);
            }
            C0999v c0999v = new C0999v(null);
            c0999v.P(this);
            return c0999v;
        }

        @Override // com.google.protobuf.X1
        public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
            if ((this.c & 1) != 0) {
                c0980q.d0(1, this.d);
            }
            if ((this.c & 2) != 0) {
                c0980q.d0(2, this.e);
            }
            if ((this.c & 4) != 0) {
                c0980q.f0(3, E());
            }
            this.b.c(c0980q);
        }

        @Override // com.google.protobuf.AbstractC0924c
        public final boolean equals(Object obj) {
            if (obj != this) {
                if (!(obj instanceof ExtensionRange)) {
                    return super.equals(obj);
                }
                ExtensionRange extensionRange = (ExtensionRange) obj;
                int i6 = this.c;
                if (((i6 & 1) != 0) != ((extensionRange.c & 1) != 0) || (((i6 & 1) != 0 && this.d != extensionRange.d) || F() != extensionRange.F() || ((F() && this.e != extensionRange.e) || G() != extensionRange.G() || ((G() && !E().equals(extensionRange.E())) || !this.b.equals(extensionRange.b))))) {
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
            int iN = (this.c & 1) != 0 ? C0980q.N(1, this.d) : 0;
            if ((this.c & 2) != 0) {
                iN += C0980q.N(2, this.e);
            }
            if ((this.c & 4) != 0) {
                iN += C0980q.P(3, E());
            }
            int serializedSize = this.b.getSerializedSize() + iN;
            this.f2909a = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractC0924c
        public final int hashCode() {
            int i6 = this.memoizedHashCode;
            if (i6 != 0) {
                return i6;
            }
            int iHashCode = AbstractC1000v0.e.hashCode() + 779;
            if ((this.c & 1) != 0) {
                iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + this.d;
            }
            if (F()) {
                iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53) + this.e;
            }
            if (G()) {
                iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 3, 53) + E().hashCode();
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
            if (!G() || E().isInitialized()) {
                this.g = (byte) 1;
                return true;
            }
            this.g = (byte) 0;
            return false;
        }

        @Override // com.google.protobuf.X1
        /* renamed from: newBuilderForType */
        public final W1 q() {
            return H();
        }

        @Override // com.google.protobuf.AbstractC0924c
        public final AbstractC0916a q() {
            return H();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public final C0868b y() {
            C0868b c0868b = AbstractC1000v0.f;
            c0868b.g(ExtensionRange.class, C0999v.class);
            return c0868b;
        }

        @Override // com.google.protobuf.Y1
        public final X1 getDefaultInstanceForType() {
            return h;
        }
    }

    public static final class ReservedRange extends GeneratedMessageV3 {
        public static final ReservedRange g = new ReservedRange();
        public static final C1003w h = new C1003w();
        public int c;
        public int d = 0;
        public int e = 0;
        public byte f = -1;

        private ReservedRange() {
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public final AbstractC0916a B(F1 f12) {
            return new C1007x(f12);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public final Object C() {
            return new ReservedRange();
        }

        public final boolean E() {
            return (this.c & 2) != 0;
        }

        @Override // com.google.protobuf.X1
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public final C1007x toBuilder() {
            if (this == g) {
                return new C1007x(null);
            }
            C1007x c1007x = new C1007x(null);
            c1007x.P(this);
            return c1007x;
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
                if (!(obj instanceof ReservedRange)) {
                    return super.equals(obj);
                }
                ReservedRange reservedRange = (ReservedRange) obj;
                int i = this.c;
                if (((i & 1) != 0) != ((reservedRange.c & 1) != 0) || (((i & 1) != 0 && this.d != reservedRange.d) || E() != reservedRange.E() || ((E() && this.e != reservedRange.e) || !this.b.equals(reservedRange.b)))) {
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
            int iHashCode = AbstractC1000v0.g.hashCode() + 779;
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
            return g.toBuilder();
        }

        @Override // com.google.protobuf.AbstractC0924c
        public final AbstractC0916a q() {
            return g.toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public final C0868b y() {
            C0868b c0868b = AbstractC1000v0.h;
            c0868b.g(ReservedRange.class, C1007x.class);
            return c0868b;
        }

        @Override // com.google.protobuf.Y1
        public final X1 getDefaultInstanceForType() {
            return g;
        }
    }

    private DescriptorProtos$DescriptorProto() {
        this.d = "";
        C1005w1 c1005w1 = C1005w1.c;
        this.m = c1005w1;
        this.n = (byte) -1;
        this.d = "";
        List list = Collections.EMPTY_LIST;
        this.e = list;
        this.f = list;
        this.g = list;
        this.h = list;
        this.i = list;
        this.f2765j = list;
        this.l = list;
        this.m = c1005w1;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        C0991t c0991t = new C0991t(f12);
        c0991t.f = "";
        List list = Collections.EMPTY_LIST;
        c0991t.g = list;
        c0991t.h = list;
        c0991t.i = list;
        c0991t.f2942j = list;
        c0991t.k = list;
        c0991t.l = list;
        c0991t.o = list;
        c0991t.p = C1005w1.c;
        return c0991t;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new DescriptorProtos$DescriptorProto();
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

    public final DescriptorProtos$MessageOptions F() {
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions = this.k;
        return descriptorProtos$MessageOptions == null ? DescriptorProtos$MessageOptions.m : descriptorProtos$MessageOptions;
    }

    public final boolean G() {
        return (this.c & 2) != 0;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public final C0991t toBuilder() {
        if (this == o) {
            return new C0991t();
        }
        C0991t c0991t = new C0991t();
        c0991t.R(this);
        return c0991t;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        if ((this.c & 1) != 0) {
            GeneratedMessageV3.D(c0980q, 1, this.d);
        }
        for (int i = 0; i < this.e.size(); i++) {
            c0980q.f0(2, (X1) this.e.get(i));
        }
        for (int i6 = 0; i6 < this.g.size(); i6++) {
            c0980q.f0(3, (X1) this.g.get(i6));
        }
        for (int i10 = 0; i10 < this.h.size(); i10++) {
            c0980q.f0(4, (X1) this.h.get(i10));
        }
        for (int i11 = 0; i11 < this.i.size(); i11++) {
            c0980q.f0(5, (X1) this.i.get(i11));
        }
        for (int i12 = 0; i12 < this.f.size(); i12++) {
            c0980q.f0(6, (X1) this.f.get(i12));
        }
        if ((this.c & 2) != 0) {
            c0980q.f0(7, F());
        }
        for (int i13 = 0; i13 < this.f2765j.size(); i13++) {
            c0980q.f0(8, (X1) this.f2765j.get(i13));
        }
        for (int i14 = 0; i14 < this.l.size(); i14++) {
            c0980q.f0(9, (X1) this.l.get(i14));
        }
        for (int i15 = 0; i15 < this.m.b.size(); i15++) {
            GeneratedMessageV3.D(c0980q, 10, this.m.b.get(i15));
        }
        this.b.c(c0980q);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof DescriptorProtos$DescriptorProto)) {
                return super.equals(obj);
            }
            DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto = (DescriptorProtos$DescriptorProto) obj;
            int i = this.c;
            if (((i & 1) != 0) != ((descriptorProtos$DescriptorProto.c & 1) != 0) || (((i & 1) != 0 && !E().equals(descriptorProtos$DescriptorProto.E())) || !this.e.equals(descriptorProtos$DescriptorProto.e) || !this.f.equals(descriptorProtos$DescriptorProto.f) || !this.g.equals(descriptorProtos$DescriptorProto.g) || !this.h.equals(descriptorProtos$DescriptorProto.h) || !this.i.equals(descriptorProtos$DescriptorProto.i) || !this.f2765j.equals(descriptorProtos$DescriptorProto.f2765j) || G() != descriptorProtos$DescriptorProto.G() || ((G() && !F().equals(descriptorProtos$DescriptorProto.F())) || !this.l.equals(descriptorProtos$DescriptorProto.l) || !this.m.equals(descriptorProtos$DescriptorProto.m) || !this.b.equals(descriptorProtos$DescriptorProto.b)))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return o;
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
        for (int i10 = 0; i10 < this.g.size(); i10++) {
            iV += C0980q.P(3, (X1) this.g.get(i10));
        }
        for (int i11 = 0; i11 < this.h.size(); i11++) {
            iV += C0980q.P(4, (X1) this.h.get(i11));
        }
        for (int i12 = 0; i12 < this.i.size(); i12++) {
            iV += C0980q.P(5, (X1) this.i.get(i12));
        }
        for (int i13 = 0; i13 < this.f.size(); i13++) {
            iV += C0980q.P(6, (X1) this.f.get(i13));
        }
        if ((this.c & 2) != 0) {
            iV += C0980q.P(7, F());
        }
        for (int i14 = 0; i14 < this.f2765j.size(); i14++) {
            iV += C0980q.P(8, (X1) this.f2765j.get(i14));
        }
        for (int i15 = 0; i15 < this.l.size(); i15++) {
            iV += C0980q.P(9, (X1) this.l.get(i15));
        }
        int iW = 0;
        for (int i16 = 0; i16 < this.m.b.size(); i16++) {
            iW += GeneratedMessageV3.w(this.m.b.get(i16));
        }
        int serializedSize = this.b.getSerializedSize() + this.m.b.size() + iV + iW;
        this.f2909a = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = AbstractC1000v0.c.hashCode() + 779;
        if ((this.c & 1) != 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + E().hashCode();
        }
        if (this.e.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53) + this.e.hashCode();
        }
        if (this.f.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 6, 53) + this.f.hashCode();
        }
        if (this.g.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 3, 53) + this.g.hashCode();
        }
        if (this.h.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 4, 53) + this.h.hashCode();
        }
        if (this.i.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 5, 53) + this.i.hashCode();
        }
        if (this.f2765j.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 8, 53) + this.f2765j.hashCode();
        }
        if (G()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 7, 53) + F().hashCode();
        }
        if (this.l.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 9, 53) + this.l.hashCode();
        }
        if (this.m.b.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 10, 53) + this.m.hashCode();
        }
        int iHashCode2 = this.b.hashCode() + (iHashCode * 29);
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        byte b = this.n;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        for (int i = 0; i < this.e.size(); i++) {
            if (!((DescriptorProtos$FieldDescriptorProto) this.e.get(i)).isInitialized()) {
                this.n = (byte) 0;
                return false;
            }
        }
        for (int i6 = 0; i6 < this.f.size(); i6++) {
            if (!((DescriptorProtos$FieldDescriptorProto) this.f.get(i6)).isInitialized()) {
                this.n = (byte) 0;
                return false;
            }
        }
        for (int i10 = 0; i10 < this.g.size(); i10++) {
            if (!((DescriptorProtos$DescriptorProto) this.g.get(i10)).isInitialized()) {
                this.n = (byte) 0;
                return false;
            }
        }
        for (int i11 = 0; i11 < this.h.size(); i11++) {
            if (!((DescriptorProtos$EnumDescriptorProto) this.h.get(i11)).isInitialized()) {
                this.n = (byte) 0;
                return false;
            }
        }
        for (int i12 = 0; i12 < this.i.size(); i12++) {
            if (!((ExtensionRange) this.i.get(i12)).isInitialized()) {
                this.n = (byte) 0;
                return false;
            }
        }
        for (int i13 = 0; i13 < this.f2765j.size(); i13++) {
            if (!((DescriptorProtos$OneofDescriptorProto) this.f2765j.get(i13)).isInitialized()) {
                this.n = (byte) 0;
                return false;
            }
        }
        if (!G() || F().isInitialized()) {
            this.n = (byte) 1;
            return true;
        }
        this.n = (byte) 0;
        return false;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: newBuilderForType */
    public final W1 q() {
        return o.toBuilder();
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a q() {
        return o.toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final C0868b y() {
        C0868b c0868b = AbstractC1000v0.d;
        c0868b.g(DescriptorProtos$DescriptorProto.class, C0991t.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return o;
    }
}
