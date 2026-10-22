package com.google.protobuf;

import c0.C0868b;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class ListValue extends GeneratedMessageV3 {
    public static final ListValue e = new ListValue();
    public byte d = -1;
    public List c = Collections.EMPTY_LIST;

    private ListValue() {
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        C1 c12 = new C1(f12);
        c12.f = Collections.EMPTY_LIST;
        return c12;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new ListValue();
    }

    @Override // com.google.protobuf.X1
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public final C1 toBuilder() {
        if (this == e) {
            return new C1();
        }
        C1 c12 = new C1();
        c12.O(this);
        return c12;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        for (int i = 0; i < this.c.size(); i++) {
            c0980q.f0(1, (X1) this.c.get(i));
        }
        this.b.c(c0980q);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListValue)) {
            return super.equals(obj);
        }
        ListValue listValue = (ListValue) obj;
        return this.c.equals(listValue.c) && this.b.equals(listValue.b);
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
        int iP = 0;
        for (int i6 = 0; i6 < this.c.size(); i6++) {
            iP += C0980q.P(1, (X1) this.c.get(i6));
        }
        int serializedSize = this.b.getSerializedSize() + iP;
        this.f2909a = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = A2.f.hashCode() + 779;
        if (this.c.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + this.c.hashCode();
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
        C0868b c0868b = A2.g;
        c0868b.g(ListValue.class, C1.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return e;
    }
}
