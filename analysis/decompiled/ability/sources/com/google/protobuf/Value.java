package com.google.protobuf;

import c0.C0868b;

/* loaded from: classes3.dex */
public final class Value extends GeneratedMessageV3 implements b3 {
    public static final Value f = new Value();
    public static final Z2 g = new Z2();
    public Object d;
    public int c = 0;
    public byte e = -1;

    public enum KindCase implements InterfaceC0974o1 {
        NULL_VALUE(1),
        NUMBER_VALUE(2),
        STRING_VALUE(3),
        BOOL_VALUE(4),
        STRUCT_VALUE(5),
        LIST_VALUE(6),
        KIND_NOT_SET(0);


        /* renamed from: a, reason: collision with root package name */
        public final int f2879a;

        KindCase(int i6) {
            this.f2879a = i6;
        }

        @Override // com.google.protobuf.InterfaceC0974o1
        public final int getNumber() {
            return this.f2879a;
        }
    }

    private Value() {
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        a3 a3Var = new a3(f12);
        a3Var.e = 0;
        return a3Var;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new Value();
    }

    public final boolean E() {
        if (this.c == 4) {
            return ((Boolean) this.d).booleanValue();
        }
        return false;
    }

    public final KindCase F() {
        switch (this.c) {
            case 0:
                return KindCase.KIND_NOT_SET;
            case 1:
                return KindCase.NULL_VALUE;
            case 2:
                return KindCase.NUMBER_VALUE;
            case 3:
                return KindCase.STRING_VALUE;
            case 4:
                return KindCase.BOOL_VALUE;
            case 5:
                return KindCase.STRUCT_VALUE;
            case 6:
                return KindCase.LIST_VALUE;
            default:
                return null;
        }
    }

    public final ListValue G() {
        return this.c == 6 ? (ListValue) this.d : ListValue.e;
    }

    public final int H() {
        if (this.c == 1) {
            return ((Integer) this.d).intValue();
        }
        return 0;
    }

    public final double I() {
        if (this.c == 2) {
            return ((Double) this.d).doubleValue();
        }
        return 0.0d;
    }

    public final String J() {
        String str = this.c == 3 ? this.d : "";
        if (str instanceof String) {
            return (String) str;
        }
        String strQ = ((ByteString) str).q();
        if (this.c == 3) {
            this.d = strQ;
        }
        return strQ;
    }

    public final Struct K() {
        return this.c == 5 ? (Struct) this.d : Struct.e;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public final a3 toBuilder() {
        if (this == f) {
            return new a3();
        }
        a3 a3Var = new a3();
        a3Var.Q(this);
        return a3Var;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        if (this.c == 1) {
            c0980q.d0(1, ((Integer) this.d).intValue());
        }
        if (this.c == 2) {
            double dDoubleValue = ((Double) this.d).doubleValue();
            c0980q.getClass();
            c0980q.a0(2, Double.doubleToRawLongBits(dDoubleValue));
        }
        if (this.c == 3) {
            GeneratedMessageV3.D(c0980q, 3, this.d);
        }
        if (this.c == 4) {
            c0980q.W(4, ((Boolean) this.d).booleanValue());
        }
        if (this.c == 5) {
            c0980q.f0(5, (Struct) this.d);
        }
        if (this.c == 6) {
            c0980q.f0(6, (ListValue) this.d);
        }
        this.b.c(c0980q);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value)) {
            return super.equals(obj);
        }
        Value value = (Value) obj;
        if (!F().equals(value.F())) {
            return false;
        }
        switch (this.c) {
            case 1:
                if (H() != value.H()) {
                    return false;
                }
                break;
            case 2:
                if (Double.doubleToLongBits(I()) != Double.doubleToLongBits(value.I())) {
                    return false;
                }
                break;
            case 3:
                if (!J().equals(value.J())) {
                    return false;
                }
                break;
            case 4:
                if (E() != value.E()) {
                    return false;
                }
                break;
            case 5:
                if (!K().equals(value.K())) {
                    return false;
                }
                break;
            case 6:
                if (!G().equals(value.G())) {
                    return false;
                }
                break;
        }
        return this.b.equals(value.b);
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return f;
    }

    @Override // com.google.protobuf.X1
    public final int getSerializedSize() {
        int i = this.f2909a;
        if (i != -1) {
            return i;
        }
        int iM = this.c == 1 ? C0980q.M(1, ((Integer) this.d).intValue()) : 0;
        if (this.c == 2) {
            ((Double) this.d).getClass();
            iM += C0980q.R(2) + 8;
        }
        if (this.c == 3) {
            iM += GeneratedMessageV3.v(3, this.d);
        }
        if (this.c == 4) {
            ((Boolean) this.d).getClass();
            iM += C0980q.J(4);
        }
        if (this.c == 5) {
            iM += C0980q.P(5, (Struct) this.d);
        }
        if (this.c == 6) {
            iM += C0980q.P(6, (ListValue) this.d);
        }
        int serializedSize = this.b.getSerializedSize() + iM;
        this.f2909a = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final int hashCode() {
        int iD;
        int iH;
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = A2.d.hashCode() + 779;
        switch (this.c) {
            case 1:
                iD = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53);
                iH = H();
                break;
            case 2:
                iD = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53);
                iH = AbstractC0989s1.c(Double.doubleToLongBits(I()));
                break;
            case 3:
                iD = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 3, 53);
                iH = J().hashCode();
                break;
            case 4:
                iD = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 4, 53);
                iH = AbstractC0989s1.b(E());
                break;
            case 5:
                iD = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 5, 53);
                iH = K().hashCode();
                break;
            case 6:
                iD = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 6, 53);
                iH = G().hashCode();
                break;
            default:
                int iHashCode2 = this.b.hashCode() + (iHashCode * 29);
                this.memoizedHashCode = iHashCode2;
                return iHashCode2;
        }
        iHashCode = iD + iH;
        int iHashCode22 = this.b.hashCode() + (iHashCode * 29);
        this.memoizedHashCode = iHashCode22;
        return iHashCode22;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        byte b = this.e;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: newBuilderForType */
    public final W1 q() {
        return f.toBuilder();
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a q() {
        return f.toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final C0868b y() {
        C0868b c0868b = A2.e;
        c0868b.g(Value.class, a3.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return f;
    }
}
