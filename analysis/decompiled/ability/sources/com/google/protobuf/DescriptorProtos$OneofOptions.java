package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.GeneratedMessageV3;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos$OneofOptions extends GeneratedMessageV3.ExtendableMessage<DescriptorProtos$OneofOptions> {
    public static final DescriptorProtos$OneofOptions h = new DescriptorProtos$OneofOptions();
    public int d;
    public DescriptorProtos$FeatureSet e;
    public byte g = -1;
    public List f = Collections.EMPTY_LIST;

    private DescriptorProtos$OneofOptions() {
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        C0949i0 c0949i0 = new C0949i0(f12);
        c0949i0.i = Collections.EMPTY_LIST;
        return c0949i0;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new DescriptorProtos$OneofOptions();
    }

    public final DescriptorProtos$FeatureSet E() {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet = this.e;
        return descriptorProtos$FeatureSet == null ? DescriptorProtos$FeatureSet.l : descriptorProtos$FeatureSet;
    }

    public final boolean F() {
        return (this.d & 1) != 0;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public final C0949i0 toBuilder() {
        if (this == h) {
            return new C0949i0();
        }
        C0949i0 c0949i0 = new C0949i0();
        c0949i0.U(this);
        return c0949i0;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        C0934e1 c0934e1 = new C0934e1(this);
        if ((this.d & 1) != 0) {
            c0980q.f0(1, E());
        }
        for (int i = 0; i < this.f.size(); i++) {
            c0980q.f0(999, (X1) this.f.get(i));
        }
        c0934e1.a(536870912, c0980q);
        this.b.c(c0980q);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DescriptorProtos$OneofOptions)) {
            return super.equals(obj);
        }
        DescriptorProtos$OneofOptions descriptorProtos$OneofOptions = (DescriptorProtos$OneofOptions) obj;
        if (F() != descriptorProtos$OneofOptions.F()) {
            return false;
        }
        return (!F() || E().equals(descriptorProtos$OneofOptions.E())) && this.f.equals(descriptorProtos$OneofOptions.f) && this.b.equals(descriptorProtos$OneofOptions.b) && this.c.h().equals(descriptorProtos$OneofOptions.c.h());
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return h;
    }

    @Override // com.google.protobuf.X1
    public final int getSerializedSize() {
        int i = this.f2909a;
        if (i != -1) {
            return i;
        }
        int iP = (this.d & 1) != 0 ? C0980q.P(1, E()) : 0;
        for (int i6 = 0; i6 < this.f.size(); i6++) {
            iP += C0980q.P(999, (X1) this.f.get(i6));
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
        int iHashCode = AbstractC1000v0.f2952I.hashCode() + 779;
        if (F()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + E().hashCode();
        }
        if (this.f.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 999, 53) + this.f.hashCode();
        }
        int iHashCode2 = this.b.hashCode() + (AbstractC0924c.p(iHashCode, this.c.h()) * 29);
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
        if (F() && !E().isInitialized()) {
            this.g = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.f.size(); i++) {
            if (!((DescriptorProtos$UninterpretedOption) this.f.get(i)).isInitialized()) {
                this.g = (byte) 0;
                return false;
            }
        }
        if (this.c.m()) {
            this.g = (byte) 1;
            return true;
        }
        this.g = (byte) 0;
        return false;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: newBuilderForType */
    public final W1 q() {
        return h.toBuilder();
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a q() {
        return h.toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final C0868b y() {
        C0868b c0868b = AbstractC1000v0.f2953J;
        c0868b.g(DescriptorProtos$OneofOptions.class, C0949i0.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return h;
    }
}
