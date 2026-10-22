package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.GeneratedMessageV3;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos$FileOptions extends GeneratedMessageV3.ExtendableMessage<DescriptorProtos$FileOptions> {

    /* renamed from: B, reason: collision with root package name */
    public static final DescriptorProtos$FileOptions f2803B = new DescriptorProtos$FileOptions();
    public int d;
    public volatile Serializable e;
    public volatile Serializable f;

    /* renamed from: j, reason: collision with root package name */
    public int f2805j;
    public volatile Serializable k;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2806q;

    /* renamed from: r, reason: collision with root package name */
    public volatile Serializable f2807r;

    /* renamed from: s, reason: collision with root package name */
    public volatile Serializable f2808s;

    /* renamed from: t, reason: collision with root package name */
    public volatile Serializable f2809t;
    public volatile Serializable u;

    /* renamed from: v, reason: collision with root package name */
    public volatile Serializable f2810v;

    /* renamed from: w, reason: collision with root package name */
    public volatile Serializable f2811w;

    /* renamed from: x, reason: collision with root package name */
    public volatile Serializable f2812x;
    public DescriptorProtos$FeatureSet y;
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;

    /* renamed from: A, reason: collision with root package name */
    public byte f2804A = -1;

    /* renamed from: z, reason: collision with root package name */
    public List f2813z = Collections.EMPTY_LIST;

    public enum OptimizeMode implements InterfaceC0974o1 {
        SPEED(1),
        CODE_SIZE(2),
        LITE_RUNTIME(3);


        /* renamed from: a, reason: collision with root package name */
        public final int f2814a;

        static {
            values();
        }

        OptimizeMode(int i) {
            this.f2814a = i;
        }

        public static OptimizeMode a(int i) {
            if (i == 1) {
                return SPEED;
            }
            if (i == 2) {
                return CODE_SIZE;
            }
            if (i != 3) {
                return null;
            }
            return LITE_RUNTIME;
        }

        @Override // com.google.protobuf.InterfaceC0974o1
        public final int getNumber() {
            return this.f2814a;
        }
    }

    private DescriptorProtos$FileOptions() {
        this.e = "";
        this.f = "";
        this.f2805j = 1;
        this.k = "";
        this.f2806q = true;
        this.f2807r = "";
        this.f2808s = "";
        this.f2809t = "";
        this.u = "";
        this.f2810v = "";
        this.f2811w = "";
        this.f2812x = "";
        this.e = "";
        this.f = "";
        this.f2805j = 1;
        this.k = "";
        this.f2806q = true;
        this.f2807r = "";
        this.f2808s = "";
        this.f2809t = "";
        this.u = "";
        this.f2810v = "";
        this.f2811w = "";
        this.f2812x = "";
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        Y y = new Y(f12);
        y.g = "";
        y.h = "";
        y.l = 1;
        y.m = "";
        y.f2897s = true;
        y.f2898t = "";
        y.u = "";
        y.f2899v = "";
        y.f2900w = "";
        y.f2901x = "";
        y.y = "";
        y.f2902z = "";
        y.f2893C = Collections.EMPTY_LIST;
        return y;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new DescriptorProtos$FileOptions();
    }

    public final String E() {
        Serializable serializable = this.f2808s;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        ByteString byteString = (ByteString) serializable;
        String strQ = byteString.q();
        if (byteString.i()) {
            this.f2808s = strQ;
        }
        return strQ;
    }

    public final DescriptorProtos$FeatureSet F() {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet = this.y;
        return descriptorProtos$FeatureSet == null ? DescriptorProtos$FeatureSet.l : descriptorProtos$FeatureSet;
    }

    public final String G() {
        Serializable serializable = this.k;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        ByteString byteString = (ByteString) serializable;
        String strQ = byteString.q();
        if (byteString.i()) {
            this.k = strQ;
        }
        return strQ;
    }

    public final String H() {
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

    public final String I() {
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

    public final String J() {
        Serializable serializable = this.f2807r;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        ByteString byteString = (ByteString) serializable;
        String strQ = byteString.q();
        if (byteString.i()) {
            this.f2807r = strQ;
        }
        return strQ;
    }

    public final String K() {
        Serializable serializable = this.u;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        ByteString byteString = (ByteString) serializable;
        String strQ = byteString.q();
        if (byteString.i()) {
            this.u = strQ;
        }
        return strQ;
    }

    public final String L() {
        Serializable serializable = this.f2811w;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        ByteString byteString = (ByteString) serializable;
        String strQ = byteString.q();
        if (byteString.i()) {
            this.f2811w = strQ;
        }
        return strQ;
    }

    public final String M() {
        Serializable serializable = this.f2810v;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        ByteString byteString = (ByteString) serializable;
        String strQ = byteString.q();
        if (byteString.i()) {
            this.f2810v = strQ;
        }
        return strQ;
    }

    public final String N() {
        Serializable serializable = this.f2812x;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        ByteString byteString = (ByteString) serializable;
        String strQ = byteString.q();
        if (byteString.i()) {
            this.f2812x = strQ;
        }
        return strQ;
    }

    public final String O() {
        Serializable serializable = this.f2809t;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        ByteString byteString = (ByteString) serializable;
        String strQ = byteString.q();
        if (byteString.i()) {
            this.f2809t = strQ;
        }
        return strQ;
    }

    public final boolean P() {
        return (this.d & 4096) != 0;
    }

    public final boolean Q() {
        return (this.d & 128) != 0;
    }

    public final boolean R() {
        return (this.d & 16384) != 0;
    }

    public final boolean S() {
        return (this.d & 2048) != 0;
    }

    public final boolean T() {
        return (this.d & 1048576) != 0;
    }

    public final boolean U() {
        return (this.d & 64) != 0;
    }

    public final boolean V() {
        return (this.d & 8) != 0;
    }

    public final boolean W() {
        return (this.d & 256) != 0;
    }

    public final boolean X() {
        return (this.d & 4) != 0;
    }

    public final boolean Y() {
        return (this.d & 2) != 0;
    }

    public final boolean Z() {
        return (this.d & 16) != 0;
    }

    public final boolean a0() {
        return (this.d & 8192) != 0;
    }

    public final boolean b0() {
        return (this.d & 32) != 0;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        C0934e1 c0934e1 = new C0934e1(this);
        if ((this.d & 1) != 0) {
            GeneratedMessageV3.D(c0980q, 1, this.e);
        }
        if ((this.d & 2) != 0) {
            GeneratedMessageV3.D(c0980q, 8, this.f);
        }
        if ((this.d & 32) != 0) {
            c0980q.d0(9, this.f2805j);
        }
        if ((this.d & 4) != 0) {
            c0980q.W(10, this.g);
        }
        if ((this.d & 64) != 0) {
            GeneratedMessageV3.D(c0980q, 11, this.k);
        }
        if ((this.d & 128) != 0) {
            c0980q.W(16, this.l);
        }
        if ((this.d & 256) != 0) {
            c0980q.W(17, this.m);
        }
        if ((this.d & 512) != 0) {
            c0980q.W(18, this.n);
        }
        if ((this.d & 8) != 0) {
            c0980q.W(20, this.h);
        }
        if ((this.d & 2048) != 0) {
            c0980q.W(23, this.p);
        }
        if ((this.d & 16) != 0) {
            c0980q.W(27, this.i);
        }
        if ((this.d & 4096) != 0) {
            c0980q.W(31, this.f2806q);
        }
        if ((this.d & 8192) != 0) {
            GeneratedMessageV3.D(c0980q, 36, this.f2807r);
        }
        if ((this.d & 16384) != 0) {
            GeneratedMessageV3.D(c0980q, 37, this.f2808s);
        }
        if ((this.d & 32768) != 0) {
            GeneratedMessageV3.D(c0980q, 39, this.f2809t);
        }
        if ((this.d & 65536) != 0) {
            GeneratedMessageV3.D(c0980q, 40, this.u);
        }
        if ((this.d & 131072) != 0) {
            GeneratedMessageV3.D(c0980q, 41, this.f2810v);
        }
        if ((this.d & 1024) != 0) {
            c0980q.W(42, this.o);
        }
        if ((this.d & 262144) != 0) {
            GeneratedMessageV3.D(c0980q, 44, this.f2811w);
        }
        if ((this.d & 524288) != 0) {
            GeneratedMessageV3.D(c0980q, 45, this.f2812x);
        }
        if ((this.d & 1048576) != 0) {
            c0980q.f0(50, F());
        }
        for (int i = 0; i < this.f2813z.size(); i++) {
            c0980q.f0(999, (X1) this.f2813z.get(i));
        }
        c0934e1.a(536870912, c0980q);
        this.b.c(c0980q);
    }

    public final boolean c0() {
        return (this.d & 65536) != 0;
    }

    public final boolean d0() {
        return (this.d & 1024) != 0;
    }

    public final boolean e0() {
        return (this.d & 262144) != 0;
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof DescriptorProtos$FileOptions)) {
                return super.equals(obj);
            }
            DescriptorProtos$FileOptions descriptorProtos$FileOptions = (DescriptorProtos$FileOptions) obj;
            int i = this.d;
            if (((i & 1) != 0) != ((descriptorProtos$FileOptions.d & 1) != 0) || (((i & 1) != 0 && !I().equals(descriptorProtos$FileOptions.I())) || Y() != descriptorProtos$FileOptions.Y() || ((Y() && !H().equals(descriptorProtos$FileOptions.H())) || X() != descriptorProtos$FileOptions.X() || ((X() && this.g != descriptorProtos$FileOptions.g) || V() != descriptorProtos$FileOptions.V() || ((V() && this.h != descriptorProtos$FileOptions.h) || Z() != descriptorProtos$FileOptions.Z() || ((Z() && this.i != descriptorProtos$FileOptions.i) || b0() != descriptorProtos$FileOptions.b0() || ((b0() && this.f2805j != descriptorProtos$FileOptions.f2805j) || U() != descriptorProtos$FileOptions.U() || ((U() && !G().equals(descriptorProtos$FileOptions.G())) || Q() != descriptorProtos$FileOptions.Q() || ((Q() && this.l != descriptorProtos$FileOptions.l) || W() != descriptorProtos$FileOptions.W() || ((W() && this.m != descriptorProtos$FileOptions.m) || g0() != descriptorProtos$FileOptions.g0() || ((g0() && this.n != descriptorProtos$FileOptions.n) || d0() != descriptorProtos$FileOptions.d0() || ((d0() && this.o != descriptorProtos$FileOptions.o) || S() != descriptorProtos$FileOptions.S() || ((S() && this.p != descriptorProtos$FileOptions.p) || P() != descriptorProtos$FileOptions.P() || ((P() && this.f2806q != descriptorProtos$FileOptions.f2806q) || a0() != descriptorProtos$FileOptions.a0() || ((a0() && !J().equals(descriptorProtos$FileOptions.J())) || R() != descriptorProtos$FileOptions.R() || ((R() && !E().equals(descriptorProtos$FileOptions.E())) || i0() != descriptorProtos$FileOptions.i0() || ((i0() && !O().equals(descriptorProtos$FileOptions.O())) || c0() != descriptorProtos$FileOptions.c0() || ((c0() && !K().equals(descriptorProtos$FileOptions.K())) || f0() != descriptorProtos$FileOptions.f0() || ((f0() && !M().equals(descriptorProtos$FileOptions.M())) || e0() != descriptorProtos$FileOptions.e0() || ((e0() && !L().equals(descriptorProtos$FileOptions.L())) || h0() != descriptorProtos$FileOptions.h0() || ((h0() && !N().equals(descriptorProtos$FileOptions.N())) || T() != descriptorProtos$FileOptions.T() || ((T() && !F().equals(descriptorProtos$FileOptions.F())) || !this.f2813z.equals(descriptorProtos$FileOptions.f2813z) || !this.b.equals(descriptorProtos$FileOptions.b) || !this.c.h().equals(descriptorProtos$FileOptions.c.h()))))))))))))))))))))))) {
                return false;
            }
        }
        return true;
    }

    public final boolean f0() {
        return (this.d & 131072) != 0;
    }

    public final boolean g0() {
        return (this.d & 512) != 0;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return f2803B;
    }

    @Override // com.google.protobuf.X1
    public final int getSerializedSize() {
        int i = this.f2909a;
        if (i != -1) {
            return i;
        }
        int iV = (this.d & 1) != 0 ? GeneratedMessageV3.v(1, this.e) : 0;
        if ((this.d & 2) != 0) {
            iV += GeneratedMessageV3.v(8, this.f);
        }
        if ((this.d & 32) != 0) {
            iV += C0980q.M(9, this.f2805j);
        }
        if ((this.d & 4) != 0) {
            iV += C0980q.J(10);
        }
        if ((this.d & 64) != 0) {
            iV += GeneratedMessageV3.v(11, this.k);
        }
        if ((this.d & 128) != 0) {
            iV += C0980q.J(16);
        }
        if ((this.d & 256) != 0) {
            iV += C0980q.J(17);
        }
        if ((this.d & 512) != 0) {
            iV += C0980q.J(18);
        }
        if ((this.d & 8) != 0) {
            iV += C0980q.J(20);
        }
        if ((this.d & 2048) != 0) {
            iV += C0980q.J(23);
        }
        if ((this.d & 16) != 0) {
            iV += C0980q.J(27);
        }
        if ((this.d & 4096) != 0) {
            iV += C0980q.J(31);
        }
        if ((this.d & 8192) != 0) {
            iV += GeneratedMessageV3.v(36, this.f2807r);
        }
        if ((this.d & 16384) != 0) {
            iV += GeneratedMessageV3.v(37, this.f2808s);
        }
        if ((this.d & 32768) != 0) {
            iV += GeneratedMessageV3.v(39, this.f2809t);
        }
        if ((this.d & 65536) != 0) {
            iV += GeneratedMessageV3.v(40, this.u);
        }
        if ((this.d & 131072) != 0) {
            iV += GeneratedMessageV3.v(41, this.f2810v);
        }
        if ((this.d & 1024) != 0) {
            iV += C0980q.J(42);
        }
        if ((this.d & 262144) != 0) {
            iV += GeneratedMessageV3.v(44, this.f2811w);
        }
        if ((this.d & 524288) != 0) {
            iV += GeneratedMessageV3.v(45, this.f2812x);
        }
        if ((this.d & 1048576) != 0) {
            iV += C0980q.P(50, F());
        }
        for (int i6 = 0; i6 < this.f2813z.size(); i6++) {
            iV += C0980q.P(999, (X1) this.f2813z.get(i6));
        }
        int serializedSize = this.b.getSerializedSize() + this.c.k() + iV;
        this.f2909a = serializedSize;
        return serializedSize;
    }

    public final boolean h0() {
        return (this.d & 524288) != 0;
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = AbstractC1000v0.f2945A.hashCode() + 779;
        if ((this.d & 1) != 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + I().hashCode();
        }
        if (Y()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 8, 53) + H().hashCode();
        }
        if (X()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 10, 53) + AbstractC0989s1.b(this.g);
        }
        if (V()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 20, 53) + AbstractC0989s1.b(this.h);
        }
        if (Z()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 27, 53) + AbstractC0989s1.b(this.i);
        }
        if (b0()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 9, 53) + this.f2805j;
        }
        if (U()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 11, 53) + G().hashCode();
        }
        if (Q()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 16, 53) + AbstractC0989s1.b(this.l);
        }
        if (W()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 17, 53) + AbstractC0989s1.b(this.m);
        }
        if (g0()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 18, 53) + AbstractC0989s1.b(this.n);
        }
        if (d0()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 42, 53) + AbstractC0989s1.b(this.o);
        }
        if (S()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 23, 53) + AbstractC0989s1.b(this.p);
        }
        if (P()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 31, 53) + AbstractC0989s1.b(this.f2806q);
        }
        if (a0()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 36, 53) + J().hashCode();
        }
        if (R()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 37, 53) + E().hashCode();
        }
        if (i0()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 39, 53) + O().hashCode();
        }
        if (c0()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 40, 53) + K().hashCode();
        }
        if (f0()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 41, 53) + M().hashCode();
        }
        if (e0()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 44, 53) + L().hashCode();
        }
        if (h0()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 45, 53) + N().hashCode();
        }
        if (T()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 50, 53) + F().hashCode();
        }
        if (this.f2813z.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 999, 53) + this.f2813z.hashCode();
        }
        int iHashCode2 = this.b.hashCode() + (AbstractC0924c.p(iHashCode, this.c.h()) * 29);
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    public final boolean i0() {
        return (this.d & 32768) != 0;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        byte b = this.f2804A;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (T() && !F().isInitialized()) {
            this.f2804A = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.f2813z.size(); i++) {
            if (!((DescriptorProtos$UninterpretedOption) this.f2813z.get(i)).isInitialized()) {
                this.f2804A = (byte) 0;
                return false;
            }
        }
        if (this.c.m()) {
            this.f2804A = (byte) 1;
            return true;
        }
        this.f2804A = (byte) 0;
        return false;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public final Y toBuilder() {
        if (this == f2803B) {
            return new Y();
        }
        Y y = new Y();
        y.U(this);
        return y;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: newBuilderForType */
    public final W1 q() {
        return f2803B.toBuilder();
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a q() {
        return f2803B.toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final C0868b y() {
        C0868b c0868b = AbstractC1000v0.f2946B;
        c0868b.g(DescriptorProtos$FileOptions.class, Y.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return f2803B;
    }
}
