package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.GeneratedMessageV3;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos$EnumValueOptions extends GeneratedMessageV3.ExtendableMessage<DescriptorProtos$EnumValueOptions> {

    /* renamed from: j, reason: collision with root package name */
    public static final DescriptorProtos$EnumValueOptions f2770j = new DescriptorProtos$EnumValueOptions();
    public int d;
    public DescriptorProtos$FeatureSet f;
    public boolean e = false;
    public boolean g = false;
    public byte i = -1;
    public List h = Collections.EMPTY_LIST;

    private DescriptorProtos$EnumValueOptions() {
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        H h = new H(f12);
        h.k = Collections.EMPTY_LIST;
        return h;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new DescriptorProtos$EnumValueOptions();
    }

    public final DescriptorProtos$FeatureSet E() {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet = this.f;
        return descriptorProtos$FeatureSet == null ? DescriptorProtos$FeatureSet.l : descriptorProtos$FeatureSet;
    }

    public final boolean F() {
        return (this.d & 4) != 0;
    }

    public final boolean G() {
        return (this.d & 2) != 0;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public final H toBuilder() {
        if (this == f2770j) {
            return new H();
        }
        H h = new H();
        h.V(this);
        return h;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        C0934e1 c0934e1 = new C0934e1(this);
        if ((this.d & 1) != 0) {
            c0980q.W(1, this.e);
        }
        if ((this.d & 2) != 0) {
            c0980q.f0(2, E());
        }
        if ((this.d & 4) != 0) {
            c0980q.W(3, this.g);
        }
        for (int i = 0; i < this.h.size(); i++) {
            c0980q.f0(999, (X1) this.h.get(i));
        }
        c0934e1.a(536870912, c0980q);
        this.b.c(c0980q);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof DescriptorProtos$EnumValueOptions)) {
                return super.equals(obj);
            }
            DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions = (DescriptorProtos$EnumValueOptions) obj;
            int i = this.d;
            if (((i & 1) != 0) != ((descriptorProtos$EnumValueOptions.d & 1) != 0) || (((i & 1) != 0 && this.e != descriptorProtos$EnumValueOptions.e) || G() != descriptorProtos$EnumValueOptions.G() || ((G() && !E().equals(descriptorProtos$EnumValueOptions.E())) || F() != descriptorProtos$EnumValueOptions.F() || ((F() && this.g != descriptorProtos$EnumValueOptions.g) || !this.h.equals(descriptorProtos$EnumValueOptions.h) || !this.b.equals(descriptorProtos$EnumValueOptions.b) || !this.c.h().equals(descriptorProtos$EnumValueOptions.c.h()))))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return f2770j;
    }

    @Override // com.google.protobuf.X1
    public final int getSerializedSize() {
        int i = this.f2909a;
        if (i != -1) {
            return i;
        }
        int iJ = (this.d & 1) != 0 ? C0980q.J(1) : 0;
        if ((this.d & 2) != 0) {
            iJ += C0980q.P(2, E());
        }
        if ((this.d & 4) != 0) {
            iJ += C0980q.J(3);
        }
        for (int i6 = 0; i6 < this.h.size(); i6++) {
            iJ += C0980q.P(999, (X1) this.h.get(i6));
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
        int iHashCode = AbstractC1000v0.f2956M.hashCode() + 779;
        if ((this.d & 1) != 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + AbstractC0989s1.b(this.e);
        }
        if (G()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53) + E().hashCode();
        }
        if (F()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 3, 53) + AbstractC0989s1.b(this.g);
        }
        if (this.h.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 999, 53) + this.h.hashCode();
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
        if (G() && !E().isInitialized()) {
            this.i = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.h.size(); i++) {
            if (!((DescriptorProtos$UninterpretedOption) this.h.get(i)).isInitialized()) {
                this.i = (byte) 0;
                return false;
            }
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
        return f2770j.toBuilder();
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a q() {
        return f2770j.toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final C0868b y() {
        C0868b c0868b = AbstractC1000v0.f2957N;
        c0868b.g(DescriptorProtos$EnumValueOptions.class, H.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return f2770j;
    }
}
