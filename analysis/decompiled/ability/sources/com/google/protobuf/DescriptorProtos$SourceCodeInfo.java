package com.google.protobuf;

import c0.C0868b;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos$SourceCodeInfo extends GeneratedMessageV3 {
    public static final DescriptorProtos$SourceCodeInfo e = new DescriptorProtos$SourceCodeInfo();
    public byte d = -1;
    public List c = Collections.EMPTY_LIST;

    public static final class Location extends GeneratedMessageV3 {
        public static final Location l = new Location();
        public static final C0977p0 m = new C0977p0();
        public int c;
        public InterfaceC0982q1 d;
        public int e;
        public InterfaceC0982q1 f;
        public int g;
        public volatile Serializable h;
        public volatile Serializable i;

        /* renamed from: j, reason: collision with root package name */
        public C1005w1 f2819j;
        public byte k;

        private Location() {
            C0970n1 c0970n1 = C0970n1.d;
            this.d = c0970n1;
            this.e = -1;
            this.f = c0970n1;
            this.g = -1;
            this.h = "";
            this.i = "";
            C1005w1 c1005w1 = C1005w1.c;
            this.f2819j = c1005w1;
            this.k = (byte) -1;
            this.d = c0970n1;
            this.f = c0970n1;
            this.h = "";
            this.i = "";
            this.f2819j = c1005w1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public final AbstractC0916a B(F1 f12) {
            C0981q0 c0981q0 = new C0981q0(f12);
            C0970n1 c0970n1 = C0970n1.d;
            c0981q0.f = c0970n1;
            c0981q0.g = c0970n1;
            c0981q0.h = "";
            c0981q0.i = "";
            c0981q0.f2935j = C1005w1.c;
            return c0981q0;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public final Object C() {
            return new Location();
        }

        public final String E() {
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

        public final boolean G() {
            return (this.c & 2) != 0;
        }

        @Override // com.google.protobuf.X1
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public final C0981q0 toBuilder() {
            if (this == l) {
                return new C0981q0();
            }
            C0981q0 c0981q0 = new C0981q0();
            c0981q0.Q(this);
            return c0981q0;
        }

        @Override // com.google.protobuf.X1
        public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
            getSerializedSize();
            if (this.d.size() > 0) {
                c0980q.l0(10);
                c0980q.l0(this.e);
            }
            for (int i = 0; i < this.d.size(); i++) {
                c0980q.e0(((C0970n1) this.d).getInt(i));
            }
            if (this.f.size() > 0) {
                c0980q.l0(18);
                c0980q.l0(this.g);
            }
            for (int i6 = 0; i6 < this.f.size(); i6++) {
                c0980q.e0(((C0970n1) this.f).getInt(i6));
            }
            if ((this.c & 1) != 0) {
                GeneratedMessageV3.D(c0980q, 3, this.h);
            }
            if ((this.c & 2) != 0) {
                GeneratedMessageV3.D(c0980q, 4, this.i);
            }
            for (int i10 = 0; i10 < this.f2819j.b.size(); i10++) {
                GeneratedMessageV3.D(c0980q, 6, this.f2819j.b.get(i10));
            }
            this.b.c(c0980q);
        }

        @Override // com.google.protobuf.AbstractC0924c
        public final boolean equals(Object obj) {
            if (obj != this) {
                if (!(obj instanceof Location)) {
                    return super.equals(obj);
                }
                Location location = (Location) obj;
                if (this.d.equals(location.d) && this.f.equals(location.f)) {
                    int i = this.c;
                    if (((i & 1) != 0) == ((location.c & 1) != 0) && (((i & 1) == 0 || E().equals(location.E())) && G() == location.G() && ((!G() || F().equals(location.F())) && this.f2819j.equals(location.f2819j) && this.b.equals(location.b)))) {
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
            int iO = 0;
            for (int i6 = 0; i6 < this.d.size(); i6++) {
                iO += C0980q.O(((C0970n1) this.d).getInt(i6));
            }
            int iO2 = this.d.isEmpty() ? iO : C0980q.O(iO) + iO + 1;
            this.e = iO;
            int iO3 = 0;
            for (int i10 = 0; i10 < this.f.size(); i10++) {
                iO3 += C0980q.O(((C0970n1) this.f).getInt(i10));
            }
            int iV = iO2 + iO3;
            if (!this.f.isEmpty()) {
                iV = iV + 1 + C0980q.O(iO3);
            }
            this.g = iO3;
            if ((this.c & 1) != 0) {
                iV += GeneratedMessageV3.v(3, this.h);
            }
            if ((this.c & 2) != 0) {
                iV += GeneratedMessageV3.v(4, this.i);
            }
            int iW = 0;
            for (int i11 = 0; i11 < this.f2819j.b.size(); i11++) {
                iW += GeneratedMessageV3.w(this.f2819j.b.get(i11));
            }
            int serializedSize = this.b.getSerializedSize() + this.f2819j.b.size() + iV + iW;
            this.f2909a = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractC0924c
        public final int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int iHashCode = AbstractC1000v0.f2971a0.hashCode() + 779;
            if (this.d.size() > 0) {
                iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + this.d.hashCode();
            }
            if (this.f.size() > 0) {
                iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53) + this.f.hashCode();
            }
            if ((this.c & 1) != 0) {
                iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 3, 53) + E().hashCode();
            }
            if (G()) {
                iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 4, 53) + F().hashCode();
            }
            if (this.f2819j.b.size() > 0) {
                iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 6, 53) + this.f2819j.hashCode();
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
            C0868b c0868b = AbstractC1000v0.b0;
            c0868b.g(Location.class, C0981q0.class);
            return c0868b;
        }

        @Override // com.google.protobuf.Y1
        public final X1 getDefaultInstanceForType() {
            return l;
        }
    }

    private DescriptorProtos$SourceCodeInfo() {
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        C0973o0 c0973o0 = new C0973o0(f12);
        c0973o0.f = Collections.EMPTY_LIST;
        return c0973o0;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new DescriptorProtos$SourceCodeInfo();
    }

    @Override // com.google.protobuf.X1
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public final C0973o0 toBuilder() {
        if (this == e) {
            return new C0973o0();
        }
        C0973o0 c0973o0 = new C0973o0();
        c0973o0.O(this);
        return c0973o0;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        for (int i = 0; i < this.c.size(); i++) {
            c0980q.f0(1, (X1) this.c.get(i));
        }
        this.b.c(c0980q);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DescriptorProtos$SourceCodeInfo)) {
            return super.equals(obj);
        }
        DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo = (DescriptorProtos$SourceCodeInfo) obj;
        return this.c.equals(descriptorProtos$SourceCodeInfo.c) && this.b.equals(descriptorProtos$SourceCodeInfo.b);
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return e;
    }

    @Override // com.google.protobuf.X1
    public final int getSerializedSize() {
        int i = this.f2909a;
        if (i != -1) {
            return i;
        }
        int iP = 0;
        for (int i6 = 0; i6 < this.c.size(); i6++) {
            iP += C0980q.P(1, (X1) this.c.get(i6));
        }
        int serializedSize = this.b.getSerializedSize() + iP;
        this.f2909a = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = AbstractC1000v0.f2968Y.hashCode() + 779;
        if (this.c.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + this.c.hashCode();
        }
        int iHashCode2 = this.b.hashCode() + (iHashCode * 29);
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        byte b = this.d;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.d = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: newBuilderForType */
    public final W1 q() {
        return e.toBuilder();
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a q() {
        return e.toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final C0868b y() {
        C0868b c0868b = AbstractC1000v0.f2969Z;
        c0868b.g(DescriptorProtos$SourceCodeInfo.class, C0973o0.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return e;
    }
}
