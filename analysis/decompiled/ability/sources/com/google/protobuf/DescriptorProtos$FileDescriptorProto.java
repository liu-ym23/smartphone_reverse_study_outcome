package com.google.protobuf;

import c0.C0868b;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos$FileDescriptorProto extends GeneratedMessageV3 {

    /* renamed from: r, reason: collision with root package name */
    public static final DescriptorProtos$FileDescriptorProto f2799r = new DescriptorProtos$FileDescriptorProto();

    /* renamed from: s, reason: collision with root package name */
    public static final V f2800s = new V();
    public int c;
    public volatile Serializable d;
    public volatile Serializable e;
    public C1005w1 f;
    public InterfaceC0982q1 g;
    public InterfaceC0982q1 h;
    public List i;

    /* renamed from: j, reason: collision with root package name */
    public List f2801j;
    public List k;
    public List l;
    public DescriptorProtos$FileOptions m;
    public DescriptorProtos$SourceCodeInfo n;
    public volatile Serializable o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public byte f2802q;

    private DescriptorProtos$FileDescriptorProto() {
        this.d = "";
        this.e = "";
        C1005w1 c1005w1 = C1005w1.c;
        this.f = c1005w1;
        C0970n1 c0970n1 = C0970n1.d;
        this.g = c0970n1;
        this.h = c0970n1;
        this.o = "";
        this.p = 0;
        this.f2802q = (byte) -1;
        this.d = "";
        this.e = "";
        this.f = c1005w1;
        this.g = c0970n1;
        this.h = c0970n1;
        List list = Collections.EMPTY_LIST;
        this.i = list;
        this.f2801j = list;
        this.k = list;
        this.l = list;
        this.o = "";
        this.p = 0;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        W w8 = new W(f12);
        w8.f = "";
        w8.g = "";
        w8.h = C1005w1.c;
        C0970n1 c0970n1 = C0970n1.d;
        w8.i = c0970n1;
        w8.f2880j = c0970n1;
        List list = Collections.EMPTY_LIST;
        w8.k = list;
        w8.l = list;
        w8.m = list;
        w8.n = list;
        w8.f2883s = "";
        w8.f2884t = 0;
        return w8;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new DescriptorProtos$FileDescriptorProto();
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

    public final DescriptorProtos$FileOptions F() {
        DescriptorProtos$FileOptions descriptorProtos$FileOptions = this.m;
        return descriptorProtos$FileOptions == null ? DescriptorProtos$FileOptions.f2803B : descriptorProtos$FileOptions;
    }

    public final String G() {
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

    public final DescriptorProtos$SourceCodeInfo H() {
        DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo = this.n;
        return descriptorProtos$SourceCodeInfo == null ? DescriptorProtos$SourceCodeInfo.e : descriptorProtos$SourceCodeInfo;
    }

    public final String I() {
        Serializable serializable = this.o;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        ByteString byteString = (ByteString) serializable;
        String strQ = byteString.q();
        if (byteString.i()) {
            this.o = strQ;
        }
        return strQ;
    }

    public final boolean J() {
        return (this.c & 32) != 0;
    }

    public final boolean K() {
        return (this.c & 4) != 0;
    }

    public final boolean L() {
        return (this.c & 2) != 0;
    }

    public final boolean M() {
        return (this.c & 8) != 0;
    }

    public final boolean N() {
        return (this.c & 16) != 0;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public final W toBuilder() {
        if (this == f2799r) {
            return new W();
        }
        W w8 = new W();
        w8.S(this);
        return w8;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        if ((this.c & 1) != 0) {
            GeneratedMessageV3.D(c0980q, 1, this.d);
        }
        if ((this.c & 2) != 0) {
            GeneratedMessageV3.D(c0980q, 2, this.e);
        }
        for (int i = 0; i < this.f.b.size(); i++) {
            GeneratedMessageV3.D(c0980q, 3, this.f.b.get(i));
        }
        for (int i6 = 0; i6 < this.i.size(); i6++) {
            c0980q.f0(4, (X1) this.i.get(i6));
        }
        for (int i10 = 0; i10 < this.f2801j.size(); i10++) {
            c0980q.f0(5, (X1) this.f2801j.get(i10));
        }
        for (int i11 = 0; i11 < this.k.size(); i11++) {
            c0980q.f0(6, (X1) this.k.get(i11));
        }
        for (int i12 = 0; i12 < this.l.size(); i12++) {
            c0980q.f0(7, (X1) this.l.get(i12));
        }
        if ((this.c & 4) != 0) {
            c0980q.f0(8, F());
        }
        if ((this.c & 8) != 0) {
            c0980q.f0(9, H());
        }
        for (int i13 = 0; i13 < this.g.size(); i13++) {
            c0980q.d0(10, ((C0970n1) this.g).getInt(i13));
        }
        for (int i14 = 0; i14 < this.h.size(); i14++) {
            c0980q.d0(11, ((C0970n1) this.h).getInt(i14));
        }
        if ((this.c & 16) != 0) {
            GeneratedMessageV3.D(c0980q, 12, this.o);
        }
        if ((this.c & 32) != 0) {
            c0980q.d0(14, this.p);
        }
        this.b.c(c0980q);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof DescriptorProtos$FileDescriptorProto)) {
                return super.equals(obj);
            }
            DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto = (DescriptorProtos$FileDescriptorProto) obj;
            int i = this.c;
            if (((i & 1) != 0) != ((descriptorProtos$FileDescriptorProto.c & 1) != 0) || (((i & 1) != 0 && !E().equals(descriptorProtos$FileDescriptorProto.E())) || L() != descriptorProtos$FileDescriptorProto.L() || ((L() && !G().equals(descriptorProtos$FileDescriptorProto.G())) || !this.f.equals(descriptorProtos$FileDescriptorProto.f) || !this.g.equals(descriptorProtos$FileDescriptorProto.g) || !this.h.equals(descriptorProtos$FileDescriptorProto.h) || !this.i.equals(descriptorProtos$FileDescriptorProto.i) || !this.f2801j.equals(descriptorProtos$FileDescriptorProto.f2801j) || !this.k.equals(descriptorProtos$FileDescriptorProto.k) || !this.l.equals(descriptorProtos$FileDescriptorProto.l) || K() != descriptorProtos$FileDescriptorProto.K() || ((K() && !F().equals(descriptorProtos$FileDescriptorProto.F())) || M() != descriptorProtos$FileDescriptorProto.M() || ((M() && !H().equals(descriptorProtos$FileDescriptorProto.H())) || N() != descriptorProtos$FileDescriptorProto.N() || ((N() && !I().equals(descriptorProtos$FileDescriptorProto.I())) || J() != descriptorProtos$FileDescriptorProto.J() || ((J() && this.p != descriptorProtos$FileDescriptorProto.p) || !this.b.equals(descriptorProtos$FileDescriptorProto.b)))))))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return f2799r;
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
        int iW = 0;
        for (int i6 = 0; i6 < this.f.b.size(); i6++) {
            iW += GeneratedMessageV3.w(this.f.b.get(i6));
        }
        int size = this.f.b.size() + iV + iW;
        for (int i10 = 0; i10 < this.i.size(); i10++) {
            size += C0980q.P(4, (X1) this.i.get(i10));
        }
        for (int i11 = 0; i11 < this.f2801j.size(); i11++) {
            size += C0980q.P(5, (X1) this.f2801j.get(i11));
        }
        for (int i12 = 0; i12 < this.k.size(); i12++) {
            size += C0980q.P(6, (X1) this.k.get(i12));
        }
        for (int i13 = 0; i13 < this.l.size(); i13++) {
            size += C0980q.P(7, (X1) this.l.get(i13));
        }
        if ((this.c & 4) != 0) {
            size += C0980q.P(8, F());
        }
        if ((this.c & 8) != 0) {
            size += C0980q.P(9, H());
        }
        int iO = 0;
        for (int i14 = 0; i14 < this.g.size(); i14++) {
            iO += C0980q.O(((C0970n1) this.g).getInt(i14));
        }
        int size2 = this.g.size() + size + iO;
        int iO2 = 0;
        for (int i15 = 0; i15 < this.h.size(); i15++) {
            iO2 += C0980q.O(((C0970n1) this.h).getInt(i15));
        }
        int size3 = this.h.size() + size2 + iO2;
        if ((this.c & 16) != 0) {
            size3 += GeneratedMessageV3.v(12, this.o);
        }
        if ((this.c & 32) != 0) {
            size3 += C0980q.M(14, this.p);
        }
        int serializedSize = this.b.getSerializedSize() + size3;
        this.f2909a = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = AbstractC1000v0.f2970a.hashCode() + 779;
        if ((this.c & 1) != 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + E().hashCode();
        }
        if (L()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53) + G().hashCode();
        }
        if (this.f.b.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 3, 53) + this.f.hashCode();
        }
        if (this.g.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 10, 53) + this.g.hashCode();
        }
        if (this.h.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 11, 53) + this.h.hashCode();
        }
        if (this.i.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 4, 53) + this.i.hashCode();
        }
        if (this.f2801j.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 5, 53) + this.f2801j.hashCode();
        }
        if (this.k.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 6, 53) + this.k.hashCode();
        }
        if (this.l.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 7, 53) + this.l.hashCode();
        }
        if (K()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 8, 53) + F().hashCode();
        }
        if (M()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 9, 53) + H().hashCode();
        }
        if (N()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 12, 53) + I().hashCode();
        }
        if (J()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 14, 53) + this.p;
        }
        int iHashCode2 = this.b.hashCode() + (iHashCode * 29);
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        byte b = this.f2802q;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        for (int i = 0; i < this.i.size(); i++) {
            if (!((DescriptorProtos$DescriptorProto) this.i.get(i)).isInitialized()) {
                this.f2802q = (byte) 0;
                return false;
            }
        }
        for (int i6 = 0; i6 < this.f2801j.size(); i6++) {
            if (!((DescriptorProtos$EnumDescriptorProto) this.f2801j.get(i6)).isInitialized()) {
                this.f2802q = (byte) 0;
                return false;
            }
        }
        for (int i10 = 0; i10 < this.k.size(); i10++) {
            if (!((DescriptorProtos$ServiceDescriptorProto) this.k.get(i10)).isInitialized()) {
                this.f2802q = (byte) 0;
                return false;
            }
        }
        for (int i11 = 0; i11 < this.l.size(); i11++) {
            if (!((DescriptorProtos$FieldDescriptorProto) this.l.get(i11)).isInitialized()) {
                this.f2802q = (byte) 0;
                return false;
            }
        }
        if (!K() || F().isInitialized()) {
            this.f2802q = (byte) 1;
            return true;
        }
        this.f2802q = (byte) 0;
        return false;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: newBuilderForType */
    public final W1 q() {
        return f2799r.toBuilder();
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a q() {
        return f2799r.toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final C0868b y() {
        C0868b c0868b = AbstractC1000v0.b;
        c0868b.g(DescriptorProtos$FileDescriptorProto.class, W.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return f2799r;
    }
}
