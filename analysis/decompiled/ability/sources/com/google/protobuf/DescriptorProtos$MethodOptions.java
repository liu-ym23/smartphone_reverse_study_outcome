package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.GeneratedMessageV3;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos$MethodOptions extends GeneratedMessageV3.ExtendableMessage<DescriptorProtos$MethodOptions> {

    /* renamed from: j, reason: collision with root package name */
    public static final DescriptorProtos$MethodOptions f2817j = new DescriptorProtos$MethodOptions();
    public int d;
    public DescriptorProtos$FeatureSet g;
    public boolean e = false;
    public byte i = -1;
    public int f = 0;
    public List h = Collections.EMPTY_LIST;

    public enum IdempotencyLevel implements InterfaceC0974o1 {
        IDEMPOTENCY_UNKNOWN(0),
        NO_SIDE_EFFECTS(1),
        IDEMPOTENT(2);


        /* renamed from: a, reason: collision with root package name */
        public final int f2818a;

        static {
            values();
        }

        IdempotencyLevel(int i) {
            this.f2818a = i;
        }

        public static IdempotencyLevel a(int i) {
            if (i == 0) {
                return IDEMPOTENCY_UNKNOWN;
            }
            if (i == 1) {
                return NO_SIDE_EFFECTS;
            }
            if (i != 2) {
                return null;
            }
            return IDEMPOTENT;
        }

        @Override // com.google.protobuf.InterfaceC0974o1
        public final int getNumber() {
            return this.f2818a;
        }
    }

    private DescriptorProtos$MethodOptions() {
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        C0933e0 c0933e0 = new C0933e0(f12);
        c0933e0.h = 0;
        c0933e0.k = Collections.EMPTY_LIST;
        return c0933e0;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new DescriptorProtos$MethodOptions();
    }

    public final DescriptorProtos$FeatureSet E() {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet = this.g;
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
    public final C0933e0 toBuilder() {
        if (this == f2817j) {
            return new C0933e0();
        }
        C0933e0 c0933e0 = new C0933e0();
        c0933e0.U(this);
        return c0933e0;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        C0934e1 c0934e1 = new C0934e1(this);
        if ((this.d & 1) != 0) {
            c0980q.W(33, this.e);
        }
        if ((this.d & 2) != 0) {
            c0980q.d0(34, this.f);
        }
        if ((this.d & 4) != 0) {
            c0980q.f0(35, E());
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
            if (!(obj instanceof DescriptorProtos$MethodOptions)) {
                return super.equals(obj);
            }
            DescriptorProtos$MethodOptions descriptorProtos$MethodOptions = (DescriptorProtos$MethodOptions) obj;
            int i = this.d;
            if (((i & 1) != 0) != ((descriptorProtos$MethodOptions.d & 1) != 0) || (((i & 1) != 0 && this.e != descriptorProtos$MethodOptions.e) || G() != descriptorProtos$MethodOptions.G() || ((G() && this.f != descriptorProtos$MethodOptions.f) || F() != descriptorProtos$MethodOptions.F() || ((F() && !E().equals(descriptorProtos$MethodOptions.E())) || !this.h.equals(descriptorProtos$MethodOptions.h) || !this.b.equals(descriptorProtos$MethodOptions.b) || !this.c.h().equals(descriptorProtos$MethodOptions.c.h()))))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return f2817j;
    }

    @Override // com.google.protobuf.X1
    public final int getSerializedSize() {
        int i = this.f2909a;
        if (i != -1) {
            return i;
        }
        int iJ = (this.d & 1) != 0 ? C0980q.J(33) : 0;
        if ((this.d & 2) != 0) {
            iJ += C0980q.M(34, this.f);
        }
        if ((this.d & 4) != 0) {
            iJ += C0980q.P(35, E());
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
        int iHashCode = AbstractC1000v0.f2960Q.hashCode() + 779;
        if ((this.d & 1) != 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 33, 53) + AbstractC0989s1.b(this.e);
        }
        if (G()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 34, 53) + this.f;
        }
        if (F()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 35, 53) + E().hashCode();
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
        if (F() && !E().isInitialized()) {
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
        return f2817j.toBuilder();
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a q() {
        return f2817j.toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final C0868b y() {
        C0868b c0868b = AbstractC1000v0.f2961R;
        c0868b.g(DescriptorProtos$MethodOptions.class, C0933e0.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return f2817j;
    }
}
