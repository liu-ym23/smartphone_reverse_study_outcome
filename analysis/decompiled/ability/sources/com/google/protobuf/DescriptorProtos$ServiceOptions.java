package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.GeneratedMessageV3;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos$ServiceOptions extends GeneratedMessageV3.ExtendableMessage<DescriptorProtos$ServiceOptions> {
    public static final DescriptorProtos$ServiceOptions i = new DescriptorProtos$ServiceOptions();
    public int d;
    public DescriptorProtos$FeatureSet e;
    public boolean f = false;
    public byte h = -1;
    public List g = Collections.EMPTY_LIST;

    private DescriptorProtos$ServiceOptions() {
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        C0965m0 c0965m0 = new C0965m0(f12);
        c0965m0.f2930j = Collections.EMPTY_LIST;
        return c0965m0;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new DescriptorProtos$ServiceOptions();
    }

    public final DescriptorProtos$FeatureSet E() {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet = this.e;
        return descriptorProtos$FeatureSet == null ? DescriptorProtos$FeatureSet.l : descriptorProtos$FeatureSet;
    }

    public final boolean F() {
        return (this.d & 2) != 0;
    }

    public final boolean G() {
        return (this.d & 1) != 0;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public final C0965m0 toBuilder() {
        if (this == i) {
            return new C0965m0();
        }
        C0965m0 c0965m0 = new C0965m0();
        c0965m0.U(this);
        return c0965m0;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        C0934e1 c0934e1 = new C0934e1(this);
        if ((this.d & 2) != 0) {
            c0980q.W(33, this.f);
        }
        if ((this.d & 1) != 0) {
            c0980q.f0(34, E());
        }
        for (int i6 = 0; i6 < this.g.size(); i6++) {
            c0980q.f0(999, (X1) this.g.get(i6));
        }
        c0934e1.a(536870912, c0980q);
        this.b.c(c0980q);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DescriptorProtos$ServiceOptions)) {
            return super.equals(obj);
        }
        DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions = (DescriptorProtos$ServiceOptions) obj;
        if (G() != descriptorProtos$ServiceOptions.G()) {
            return false;
        }
        if ((!G() || E().equals(descriptorProtos$ServiceOptions.E())) && F() == descriptorProtos$ServiceOptions.F()) {
            return (!F() || this.f == descriptorProtos$ServiceOptions.f) && this.g.equals(descriptorProtos$ServiceOptions.g) && this.b.equals(descriptorProtos$ServiceOptions.b) && this.c.h().equals(descriptorProtos$ServiceOptions.c.h());
        }
        return false;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return i;
    }

    @Override // com.google.protobuf.X1
    public final int getSerializedSize() {
        int i6 = this.f2909a;
        if (i6 != -1) {
            return i6;
        }
        int iJ = (this.d & 2) != 0 ? C0980q.J(33) : 0;
        if ((this.d & 1) != 0) {
            iJ += C0980q.P(34, E());
        }
        for (int i10 = 0; i10 < this.g.size(); i10++) {
            iJ += C0980q.P(999, (X1) this.g.get(i10));
        }
        int serializedSize = this.b.getSerializedSize() + this.c.k() + iJ;
        this.f2909a = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final int hashCode() {
        int i6 = this.memoizedHashCode;
        if (i6 != 0) {
            return i6;
        }
        int iHashCode = AbstractC1000v0.f2958O.hashCode() + 779;
        if (G()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 34, 53) + E().hashCode();
        }
        if (F()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 33, 53) + AbstractC0989s1.b(this.f);
        }
        if (this.g.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 999, 53) + this.g.hashCode();
        }
        int iHashCode2 = this.b.hashCode() + (AbstractC0924c.p(iHashCode, this.c.h()) * 29);
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        byte b = this.h;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (G() && !E().isInitialized()) {
            this.h = (byte) 0;
            return false;
        }
        for (int i6 = 0; i6 < this.g.size(); i6++) {
            if (!((DescriptorProtos$UninterpretedOption) this.g.get(i6)).isInitialized()) {
                this.h = (byte) 0;
                return false;
            }
        }
        if (this.c.m()) {
            this.h = (byte) 1;
            return true;
        }
        this.h = (byte) 0;
        return false;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: newBuilderForType */
    public final W1 q() {
        return i.toBuilder();
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a q() {
        return i.toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final C0868b y() {
        C0868b c0868b = AbstractC1000v0.f2959P;
        c0868b.g(DescriptorProtos$ServiceOptions.class, C0965m0.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return i;
    }
}
