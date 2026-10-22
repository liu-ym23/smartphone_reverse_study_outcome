package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.GeneratedMessageV3;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos$MessageOptions extends GeneratedMessageV3.ExtendableMessage<DescriptorProtos$MessageOptions> {
    public static final DescriptorProtos$MessageOptions m = new DescriptorProtos$MessageOptions();
    public int d;

    /* renamed from: j, reason: collision with root package name */
    public DescriptorProtos$FeatureSet f2815j;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;
    public byte l = -1;
    public List k = Collections.EMPTY_LIST;

    private DescriptorProtos$MessageOptions() {
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        C0917a0 c0917a0 = new C0917a0(f12);
        c0917a0.n = Collections.EMPTY_LIST;
        return c0917a0;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new DescriptorProtos$MessageOptions();
    }

    public final DescriptorProtos$FeatureSet E() {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet = this.f2815j;
        return descriptorProtos$FeatureSet == null ? DescriptorProtos$FeatureSet.l : descriptorProtos$FeatureSet;
    }

    public final boolean F() {
        return (this.d & 4) != 0;
    }

    public final boolean G() {
        return (this.d & 16) != 0;
    }

    public final boolean H() {
        return (this.d & 32) != 0;
    }

    public final boolean I() {
        return (this.d & 8) != 0;
    }

    public final boolean J() {
        return (this.d & 2) != 0;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public final C0917a0 toBuilder() {
        if (this == m) {
            return new C0917a0();
        }
        C0917a0 c0917a0 = new C0917a0();
        c0917a0.U(this);
        return c0917a0;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        C0934e1 c0934e1 = new C0934e1(this);
        if ((this.d & 1) != 0) {
            c0980q.W(1, this.e);
        }
        if ((this.d & 2) != 0) {
            c0980q.W(2, this.f);
        }
        if ((this.d & 4) != 0) {
            c0980q.W(3, this.g);
        }
        if ((this.d & 8) != 0) {
            c0980q.W(7, this.h);
        }
        if ((this.d & 16) != 0) {
            c0980q.W(11, this.i);
        }
        if ((this.d & 32) != 0) {
            c0980q.f0(12, E());
        }
        for (int i = 0; i < this.k.size(); i++) {
            c0980q.f0(999, (X1) this.k.get(i));
        }
        c0934e1.a(536870912, c0980q);
        this.b.c(c0980q);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof DescriptorProtos$MessageOptions)) {
                return super.equals(obj);
            }
            DescriptorProtos$MessageOptions descriptorProtos$MessageOptions = (DescriptorProtos$MessageOptions) obj;
            int i = this.d;
            if (((i & 1) != 0) != ((descriptorProtos$MessageOptions.d & 1) != 0) || (((i & 1) != 0 && this.e != descriptorProtos$MessageOptions.e) || J() != descriptorProtos$MessageOptions.J() || ((J() && this.f != descriptorProtos$MessageOptions.f) || F() != descriptorProtos$MessageOptions.F() || ((F() && this.g != descriptorProtos$MessageOptions.g) || I() != descriptorProtos$MessageOptions.I() || ((I() && this.h != descriptorProtos$MessageOptions.h) || G() != descriptorProtos$MessageOptions.G() || ((G() && this.i != descriptorProtos$MessageOptions.i) || H() != descriptorProtos$MessageOptions.H() || ((H() && !E().equals(descriptorProtos$MessageOptions.E())) || !this.k.equals(descriptorProtos$MessageOptions.k) || !this.b.equals(descriptorProtos$MessageOptions.b) || !this.c.h().equals(descriptorProtos$MessageOptions.c.h())))))))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return m;
    }

    @Override // com.google.protobuf.X1
    public final int getSerializedSize() {
        int i = this.f2909a;
        if (i != -1) {
            return i;
        }
        int iJ = (this.d & 1) != 0 ? C0980q.J(1) : 0;
        if ((this.d & 2) != 0) {
            iJ += C0980q.J(2);
        }
        if ((this.d & 4) != 0) {
            iJ += C0980q.J(3);
        }
        if ((this.d & 8) != 0) {
            iJ += C0980q.J(7);
        }
        if ((this.d & 16) != 0) {
            iJ += C0980q.J(11);
        }
        if ((this.d & 32) != 0) {
            iJ += C0980q.P(12, E());
        }
        for (int i6 = 0; i6 < this.k.size(); i6++) {
            iJ += C0980q.P(999, (X1) this.k.get(i6));
        }
        int serializedSize = this.b.getSerializedSize() + this.c.k() + iJ;
        this.f2909a = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = AbstractC1000v0.f2947C.hashCode() + 779;
        if ((this.d & 1) != 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + AbstractC0989s1.b(this.e);
        }
        if (J()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53) + AbstractC0989s1.b(this.f);
        }
        if (F()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 3, 53) + AbstractC0989s1.b(this.g);
        }
        if (I()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 7, 53) + AbstractC0989s1.b(this.h);
        }
        if (G()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 11, 53) + AbstractC0989s1.b(this.i);
        }
        if (H()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 12, 53) + E().hashCode();
        }
        if (this.k.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 999, 53) + this.k.hashCode();
        }
        int iHashCode2 = this.b.hashCode() + (AbstractC0924c.p(iHashCode, this.c.h()) * 29);
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        byte b = this.l;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (H() && !E().isInitialized()) {
            this.l = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.k.size(); i++) {
            if (!((DescriptorProtos$UninterpretedOption) this.k.get(i)).isInitialized()) {
                this.l = (byte) 0;
                return false;
            }
        }
        if (this.c.m()) {
            this.l = (byte) 1;
            return true;
        }
        this.l = (byte) 0;
        return false;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: newBuilderForType */
    public final W1 q() {
        return m.toBuilder();
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a q() {
        return m.toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final C0868b y() {
        C0868b c0868b = AbstractC1000v0.f2948D;
        c0868b.g(DescriptorProtos$MessageOptions.class, C0917a0.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return m;
    }
}
