package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.GeneratedMessageV3;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class DescriptorProtos$EnumOptions extends GeneratedMessageV3.ExtendableMessage<DescriptorProtos$EnumOptions> {
    public static final DescriptorProtos$EnumOptions k = new DescriptorProtos$EnumOptions();
    public int d;
    public DescriptorProtos$FeatureSet h;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;

    /* renamed from: j, reason: collision with root package name */
    public byte f2769j = -1;
    public List i = Collections.EMPTY_LIST;

    private DescriptorProtos$EnumOptions() {
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        D d = new D(f12);
        d.l = Collections.EMPTY_LIST;
        return d;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new DescriptorProtos$EnumOptions();
    }

    public final DescriptorProtos$FeatureSet E() {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet = this.h;
        return descriptorProtos$FeatureSet == null ? DescriptorProtos$FeatureSet.l : descriptorProtos$FeatureSet;
    }

    public final boolean F() {
        return (this.d & 2) != 0;
    }

    public final boolean G() {
        return (this.d & 4) != 0;
    }

    public final boolean H() {
        return (this.d & 8) != 0;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public final D toBuilder() {
        if (this == k) {
            return new D();
        }
        D d = new D();
        d.V(this);
        return d;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        Iterator itP = this.c.p();
        Map.Entry entry = itP.hasNext() ? (Map.Entry) itP.next() : null;
        if ((this.d & 1) != 0) {
            c0980q.W(2, this.e);
        }
        if ((this.d & 2) != 0) {
            c0980q.W(3, this.f);
        }
        if ((this.d & 4) != 0) {
            c0980q.W(6, this.g);
        }
        if ((this.d & 8) != 0) {
            c0980q.f0(7, E());
        }
        for (int i = 0; i < this.i.size(); i++) {
            c0980q.f0(999, (X1) this.i.get(i));
        }
        while (entry != null && ((D0) entry.getKey()).b.e < 536870912) {
            Y0.w((D0) entry.getKey(), entry.getValue(), c0980q);
            entry = itP.hasNext() ? (Map.Entry) itP.next() : null;
        }
        this.b.c(c0980q);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof DescriptorProtos$EnumOptions)) {
                return super.equals(obj);
            }
            DescriptorProtos$EnumOptions descriptorProtos$EnumOptions = (DescriptorProtos$EnumOptions) obj;
            int i = this.d;
            if (((i & 1) != 0) != ((descriptorProtos$EnumOptions.d & 1) != 0) || (((i & 1) != 0 && this.e != descriptorProtos$EnumOptions.e) || F() != descriptorProtos$EnumOptions.F() || ((F() && this.f != descriptorProtos$EnumOptions.f) || G() != descriptorProtos$EnumOptions.G() || ((G() && this.g != descriptorProtos$EnumOptions.g) || H() != descriptorProtos$EnumOptions.H() || ((H() && !E().equals(descriptorProtos$EnumOptions.E())) || !this.i.equals(descriptorProtos$EnumOptions.i) || !this.b.equals(descriptorProtos$EnumOptions.b) || !this.c.h().equals(descriptorProtos$EnumOptions.c.h())))))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return k;
    }

    @Override // com.google.protobuf.X1
    public final int getSerializedSize() {
        int i = this.f2909a;
        if (i != -1) {
            return i;
        }
        int iJ = (this.d & 1) != 0 ? C0980q.J(2) : 0;
        if ((2 & this.d) != 0) {
            iJ += C0980q.J(3);
        }
        if ((this.d & 4) != 0) {
            iJ += C0980q.J(6);
        }
        if ((this.d & 8) != 0) {
            iJ += C0980q.P(7, E());
        }
        for (int i6 = 0; i6 < this.i.size(); i6++) {
            iJ += C0980q.P(999, (X1) this.i.get(i6));
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
        int iHashCode = AbstractC1000v0.f2954K.hashCode() + 779;
        if ((this.d & 1) != 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53) + AbstractC0989s1.b(this.e);
        }
        if (F()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 3, 53) + AbstractC0989s1.b(this.f);
        }
        if (G()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 6, 53) + AbstractC0989s1.b(this.g);
        }
        if (H()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 7, 53) + E().hashCode();
        }
        if (this.i.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 999, 53) + this.i.hashCode();
        }
        int iHashCode2 = this.b.hashCode() + (AbstractC0924c.p(iHashCode, this.c.h()) * 29);
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        byte b = this.f2769j;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (H() && !E().isInitialized()) {
            this.f2769j = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.i.size(); i++) {
            if (!((DescriptorProtos$UninterpretedOption) this.i.get(i)).isInitialized()) {
                this.f2769j = (byte) 0;
                return false;
            }
        }
        if (this.c.m()) {
            this.f2769j = (byte) 1;
            return true;
        }
        this.f2769j = (byte) 0;
        return false;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: newBuilderForType */
    public final W1 q() {
        return k.toBuilder();
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a q() {
        return k.toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final C0868b y() {
        C0868b c0868b = AbstractC1000v0.f2955L;
        c0868b.g(DescriptorProtos$EnumOptions.class, D.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return k;
    }
}
