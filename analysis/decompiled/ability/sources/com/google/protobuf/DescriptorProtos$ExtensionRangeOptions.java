package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.GeneratedMessageV3;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos$ExtensionRangeOptions extends GeneratedMessageV3.ExtendableMessage<DescriptorProtos$ExtensionRangeOptions> {

    /* renamed from: j, reason: collision with root package name */
    public static final DescriptorProtos$ExtensionRangeOptions f2771j = new DescriptorProtos$ExtensionRangeOptions();
    public int d;
    public List e;
    public List f;
    public DescriptorProtos$FeatureSet g;
    public int h;
    public byte i = -1;

    public static final class Declaration extends GeneratedMessageV3 {

        /* renamed from: j, reason: collision with root package name */
        public static final Declaration f2772j = new Declaration();
        public static final K k = new K();
        public int c;
        public volatile Serializable e;
        public volatile Serializable f;
        public int d = 0;
        public boolean g = false;
        public boolean h = false;
        public byte i = -1;

        private Declaration() {
            this.e = "";
            this.f = "";
            this.e = "";
            this.f = "";
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public final AbstractC0916a B(F1 f12) {
            L l = new L(f12);
            l.g = "";
            l.h = "";
            return l;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public final Object C() {
            return new Declaration();
        }

        public final String E() {
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

        public final String F() {
            Serializable serializable = this.f;
            if (serializable instanceof String) {
                return (String) serializable;
            }
            ByteString byteString = (ByteString) serializable;
            String strQ = byteString.q();
            if (byteString.i()) {
                this.f = strQ;
            }
            return strQ;
        }

        public final boolean G() {
            return (this.c & 2) != 0;
        }

        public final boolean H() {
            return (this.c & 16) != 0;
        }

        public final boolean I() {
            return (this.c & 8) != 0;
        }

        public final boolean J() {
            return (this.c & 4) != 0;
        }

        @Override // com.google.protobuf.X1
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public final L toBuilder() {
            if (this == f2772j) {
                return new L();
            }
            L l = new L();
            l.O(this);
            return l;
        }

        @Override // com.google.protobuf.X1
        public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
            if ((this.c & 1) != 0) {
                c0980q.d0(1, this.d);
            }
            if ((this.c & 2) != 0) {
                GeneratedMessageV3.D(c0980q, 2, this.e);
            }
            if ((this.c & 4) != 0) {
                GeneratedMessageV3.D(c0980q, 3, this.f);
            }
            if ((this.c & 8) != 0) {
                c0980q.W(5, this.g);
            }
            if ((this.c & 16) != 0) {
                c0980q.W(6, this.h);
            }
            this.b.c(c0980q);
        }

        @Override // com.google.protobuf.AbstractC0924c
        public final boolean equals(Object obj) {
            if (obj != this) {
                if (!(obj instanceof Declaration)) {
                    return super.equals(obj);
                }
                Declaration declaration = (Declaration) obj;
                int i = this.c;
                if (((i & 1) != 0) != ((declaration.c & 1) != 0) || (((i & 1) != 0 && this.d != declaration.d) || G() != declaration.G() || ((G() && !E().equals(declaration.E())) || J() != declaration.J() || ((J() && !F().equals(declaration.F())) || I() != declaration.I() || ((I() && this.g != declaration.g) || H() != declaration.H() || ((H() && this.h != declaration.h) || !this.b.equals(declaration.b))))))) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.protobuf.Y1
        public final AbstractC0924c getDefaultInstanceForType() {
            return f2772j;
        }

        @Override // com.google.protobuf.X1
        public final int getSerializedSize() {
            int i = this.f2909a;
            if (i != -1) {
                return i;
            }
            int iN = (this.c & 1) != 0 ? C0980q.N(1, this.d) : 0;
            if ((this.c & 2) != 0) {
                iN += GeneratedMessageV3.v(2, this.e);
            }
            if ((this.c & 4) != 0) {
                iN += GeneratedMessageV3.v(3, this.f);
            }
            if ((this.c & 8) != 0) {
                iN += C0980q.J(5);
            }
            if ((this.c & 16) != 0) {
                iN += C0980q.J(6);
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
            int iHashCode = AbstractC1000v0.k.hashCode() + 779;
            if ((this.c & 1) != 0) {
                iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + this.d;
            }
            if (G()) {
                iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53) + E().hashCode();
            }
            if (J()) {
                iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 3, 53) + F().hashCode();
            }
            if (I()) {
                iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 5, 53) + AbstractC0989s1.b(this.g);
            }
            if (H()) {
                iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 6, 53) + AbstractC0989s1.b(this.h);
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
            this.i = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.X1
        /* renamed from: newBuilderForType */
        public final W1 q() {
            return f2772j.toBuilder();
        }

        @Override // com.google.protobuf.AbstractC0924c
        public final AbstractC0916a q() {
            return f2772j.toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public final C0868b y() {
            C0868b c0868b = AbstractC1000v0.l;
            c0868b.g(Declaration.class, L.class);
            return c0868b;
        }

        @Override // com.google.protobuf.Y1
        public final X1 getDefaultInstanceForType() {
            return f2772j;
        }
    }

    public enum VerificationState implements InterfaceC0974o1 {
        DECLARATION(0),
        UNVERIFIED(1);


        /* renamed from: a, reason: collision with root package name */
        public final int f2773a;

        static {
            values();
        }

        VerificationState(int i) {
            this.f2773a = i;
        }

        @Override // com.google.protobuf.InterfaceC0974o1
        public final int getNumber() {
            return this.f2773a;
        }
    }

    private DescriptorProtos$ExtensionRangeOptions() {
        this.h = 1;
        List list = Collections.EMPTY_LIST;
        this.e = list;
        this.f = list;
        this.h = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        J j5 = new J(f12);
        List list = Collections.EMPTY_LIST;
        j5.g = list;
        j5.h = list;
        j5.k = 1;
        return j5;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new DescriptorProtos$ExtensionRangeOptions();
    }

    public final DescriptorProtos$FeatureSet E() {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet = this.g;
        return descriptorProtos$FeatureSet == null ? DescriptorProtos$FeatureSet.l : descriptorProtos$FeatureSet;
    }

    public final boolean F() {
        return (this.d & 1) != 0;
    }

    public final boolean G() {
        return (this.d & 2) != 0;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public final J toBuilder() {
        if (this == f2771j) {
            return new J();
        }
        J j5 = new J();
        j5.V(this);
        return j5;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        C0934e1 c0934e1 = new C0934e1(this);
        for (int i = 0; i < this.f.size(); i++) {
            c0980q.f0(2, (X1) this.f.get(i));
        }
        if ((this.d & 2) != 0) {
            c0980q.d0(3, this.h);
        }
        if ((this.d & 1) != 0) {
            c0980q.f0(50, E());
        }
        for (int i6 = 0; i6 < this.e.size(); i6++) {
            c0980q.f0(999, (X1) this.e.get(i6));
        }
        c0934e1.a(536870912, c0980q);
        this.b.c(c0980q);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DescriptorProtos$ExtensionRangeOptions)) {
            return super.equals(obj);
        }
        DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions = (DescriptorProtos$ExtensionRangeOptions) obj;
        if (!this.e.equals(descriptorProtos$ExtensionRangeOptions.e) || !this.f.equals(descriptorProtos$ExtensionRangeOptions.f) || F() != descriptorProtos$ExtensionRangeOptions.F()) {
            return false;
        }
        if ((!F() || E().equals(descriptorProtos$ExtensionRangeOptions.E())) && G() == descriptorProtos$ExtensionRangeOptions.G()) {
            return (!G() || this.h == descriptorProtos$ExtensionRangeOptions.h) && this.b.equals(descriptorProtos$ExtensionRangeOptions.b) && this.c.h().equals(descriptorProtos$ExtensionRangeOptions.c.h());
        }
        return false;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return f2771j;
    }

    @Override // com.google.protobuf.X1
    public final int getSerializedSize() {
        int i = this.f2909a;
        if (i != -1) {
            return i;
        }
        int iP = 0;
        for (int i6 = 0; i6 < this.f.size(); i6++) {
            iP += C0980q.P(2, (X1) this.f.get(i6));
        }
        if ((this.d & 2) != 0) {
            iP += C0980q.M(3, this.h);
        }
        if ((this.d & 1) != 0) {
            iP += C0980q.P(50, E());
        }
        for (int i10 = 0; i10 < this.e.size(); i10++) {
            iP += C0980q.P(999, (X1) this.e.get(i10));
        }
        int serializedSize = this.b.getSerializedSize() + this.c.k() + iP;
        this.f2909a = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = AbstractC1000v0.i.hashCode() + 779;
        if (this.e.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 999, 53) + this.e.hashCode();
        }
        if (this.f.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53) + this.f.hashCode();
        }
        if (F()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 50, 53) + E().hashCode();
        }
        if (G()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 3, 53) + this.h;
        }
        int iHashCode2 = this.b.hashCode() + (AbstractC0924c.p(iHashCode, this.c.h()) * 29);
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
            if (!((DescriptorProtos$UninterpretedOption) this.e.get(i)).isInitialized()) {
                this.i = (byte) 0;
                return false;
            }
        }
        if (F() && !E().isInitialized()) {
            this.i = (byte) 0;
            return false;
        }
        if (this.c.m()) {
            this.i = (byte) 1;
            return true;
        }
        this.i = (byte) 0;
        return false;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: newBuilderForType */
    public final W1 q() {
        return f2771j.toBuilder();
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a q() {
        return f2771j.toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final C0868b y() {
        C0868b c0868b = AbstractC1000v0.f2972j;
        c0868b.g(DescriptorProtos$ExtensionRangeOptions.class, J.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return f2771j;
    }
}
