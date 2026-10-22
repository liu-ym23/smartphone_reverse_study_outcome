package com.google.protobuf;

import c0.C0868b;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Struct extends GeneratedMessageV3 {
    public static final Struct e = new Struct();
    public O1 c;
    public byte d = -1;

    private Struct() {
    }

    public static C1014y2 F(Struct struct) {
        C1014y2 builder = e.toBuilder();
        builder.P(struct);
        return builder;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        return new C1014y2(f12);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new Struct();
    }

    public final O1 E() {
        O1 o12 = this.c;
        return o12 == null ? new O1(AbstractC1018z2.f2989a, Collections.EMPTY_MAP) : o12;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public final C1014y2 toBuilder() {
        if (this == e) {
            return new C1014y2(null);
        }
        C1014y2 c1014y2 = new C1014y2(null);
        c1014y2.P(this);
        return c1014y2;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        O1 o1E = E();
        J1 j12 = AbstractC1018z2.f2989a;
        Map mapM = o1E.M();
        c0980q.getClass();
        for (Map.Entry entry : mapM.entrySet()) {
            G1 g1NewBuilderForType = j12.newBuilderForType();
            g1NewBuilderForType.b = entry.getKey();
            g1NewBuilderForType.d = true;
            g1NewBuilderForType.c = entry.getValue();
            g1NewBuilderForType.e = true;
            c0980q.f0(1, g1NewBuilderForType.build());
        }
        this.b.c(c0980q);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Struct)) {
            return super.equals(obj);
        }
        Struct struct = (Struct) obj;
        return E().equals(struct.E()) && this.b.equals(struct.b);
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
        int iS = 0;
        for (Map.Entry entry : E().M().entrySet()) {
            G1 g1NewBuilderForType = AbstractC1018z2.f2989a.newBuilderForType();
            g1NewBuilderForType.b = (String) entry.getKey();
            g1NewBuilderForType.d = true;
            g1NewBuilderForType.c = (Value) entry.getValue();
            g1NewBuilderForType.e = true;
            J1 j1Build = g1NewBuilderForType.build();
            int iR = C0980q.R(1);
            int serializedSize = j1Build.getSerializedSize();
            iS += C0980q.S(serializedSize) + serializedSize + iR;
        }
        int serializedSize2 = this.b.getSerializedSize() + iS;
        this.f2909a = serializedSize2;
        return serializedSize2;
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = A2.f2757a.hashCode() + 779;
        if (!E().M().isEmpty()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + E().hashCode();
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
        C0868b c0868b = A2.b;
        c0868b.g(Struct.class, C1014y2.class);
        return c0868b;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC1002v2 z(int i) {
        if (i == 1) {
            return E();
        }
        throw new RuntimeException(B7.a.h(i, "Invalid map field number: "));
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return e;
    }
}
