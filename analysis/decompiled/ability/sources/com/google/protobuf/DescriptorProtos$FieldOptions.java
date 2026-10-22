package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.GeneratedMessageV3;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos$FieldOptions extends GeneratedMessageV3.ExtendableMessage<DescriptorProtos$FieldOptions> {

    /* renamed from: s, reason: collision with root package name */
    public static final DescriptorProtos$FieldOptions f2790s = new DescriptorProtos$FieldOptions();
    public int d;
    public List n;
    public List o;
    public DescriptorProtos$FeatureSet p;

    /* renamed from: q, reason: collision with root package name */
    public List f2792q;
    public boolean f = false;
    public boolean h = false;
    public boolean i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2791j = false;
    public boolean k = false;
    public boolean l = false;

    /* renamed from: r, reason: collision with root package name */
    public byte f2793r = -1;
    public int e = 0;
    public int g = 0;
    public int m = 0;

    public enum CType implements InterfaceC0974o1 {
        STRING(0),
        CORD(1),
        STRING_PIECE(2);


        /* renamed from: a, reason: collision with root package name */
        public final int f2794a;

        static {
            values();
        }

        CType(int i) {
            this.f2794a = i;
        }

        public static CType a(int i) {
            if (i == 0) {
                return STRING;
            }
            if (i == 1) {
                return CORD;
            }
            if (i != 2) {
                return null;
            }
            return STRING_PIECE;
        }

        @Override // com.google.protobuf.InterfaceC0974o1
        public final int getNumber() {
            return this.f2794a;
        }
    }

    public static final class EditionDefault extends GeneratedMessageV3 {
        public static final EditionDefault g = new EditionDefault();
        public static final T h = new T();
        public int c;
        public int d;
        public volatile Serializable e;
        public byte f = -1;

        private EditionDefault() {
            this.d = 0;
            this.e = "";
            this.d = 0;
            this.e = "";
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public final AbstractC0916a B(F1 f12) {
            U u = new U(f12);
            u.f = 0;
            u.g = "";
            return u;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public final Object C() {
            return new EditionDefault();
        }

        public final String E() {
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

        public final boolean F() {
            return (this.c & 2) != 0;
        }

        @Override // com.google.protobuf.X1
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public final U toBuilder() {
            if (this == g) {
                return new U();
            }
            U u = new U();
            u.O(this);
            return u;
        }

        @Override // com.google.protobuf.X1
        public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
            if ((this.c & 2) != 0) {
                GeneratedMessageV3.D(c0980q, 2, this.e);
            }
            if ((this.c & 1) != 0) {
                c0980q.d0(3, this.d);
            }
            this.b.c(c0980q);
        }

        @Override // com.google.protobuf.AbstractC0924c
        public final boolean equals(Object obj) {
            if (obj != this) {
                if (!(obj instanceof EditionDefault)) {
                    return super.equals(obj);
                }
                EditionDefault editionDefault = (EditionDefault) obj;
                int i = this.c;
                if (((i & 1) != 0) != ((editionDefault.c & 1) != 0) || (((i & 1) != 0 && this.d != editionDefault.d) || F() != editionDefault.F() || ((F() && !E().equals(editionDefault.E())) || !this.b.equals(editionDefault.b)))) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.protobuf.Y1
        public final AbstractC0924c getDefaultInstanceForType() {
            return g;
        }

        @Override // com.google.protobuf.X1
        public final int getSerializedSize() {
            int i = this.f2909a;
            if (i != -1) {
                return i;
            }
            int iV = (this.c & 2) != 0 ? GeneratedMessageV3.v(2, this.e) : 0;
            if ((this.c & 1) != 0) {
                iV += C0980q.M(3, this.d);
            }
            int serializedSize = this.b.getSerializedSize() + iV;
            this.f2909a = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractC0924c
        public final int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int iHashCode = AbstractC1000v0.f2950G.hashCode() + 779;
            if ((this.c & 1) != 0) {
                iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 3, 53) + this.d;
            }
            if (F()) {
                iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53) + E().hashCode();
            }
            int iHashCode2 = this.b.hashCode() + (iHashCode * 29);
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        @Override // com.google.protobuf.Y1
        public final boolean isInitialized() {
            byte b = this.f;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.f = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.X1
        /* renamed from: newBuilderForType */
        public final W1 q() {
            return g.toBuilder();
        }

        @Override // com.google.protobuf.AbstractC0924c
        public final AbstractC0916a q() {
            return g.toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public final C0868b y() {
            C0868b c0868b = AbstractC1000v0.f2951H;
            c0868b.g(EditionDefault.class, U.class);
            return c0868b;
        }

        @Override // com.google.protobuf.Y1
        public final X1 getDefaultInstanceForType() {
            return g;
        }
    }

    public enum JSType implements InterfaceC0974o1 {
        JS_NORMAL(0),
        JS_STRING(1),
        JS_NUMBER(2);


        /* renamed from: a, reason: collision with root package name */
        public final int f2795a;

        static {
            values();
        }

        JSType(int i) {
            this.f2795a = i;
        }

        public static JSType a(int i) {
            if (i == 0) {
                return JS_NORMAL;
            }
            if (i == 1) {
                return JS_STRING;
            }
            if (i != 2) {
                return null;
            }
            return JS_NUMBER;
        }

        @Override // com.google.protobuf.InterfaceC0974o1
        public final int getNumber() {
            return this.f2795a;
        }
    }

    public enum OptionRetention implements InterfaceC0974o1 {
        RETENTION_UNKNOWN(0),
        RETENTION_RUNTIME(1),
        RETENTION_SOURCE(2);


        /* renamed from: a, reason: collision with root package name */
        public final int f2796a;

        static {
            values();
        }

        OptionRetention(int i) {
            this.f2796a = i;
        }

        public static OptionRetention a(int i) {
            if (i == 0) {
                return RETENTION_UNKNOWN;
            }
            if (i == 1) {
                return RETENTION_RUNTIME;
            }
            if (i != 2) {
                return null;
            }
            return RETENTION_SOURCE;
        }

        @Override // com.google.protobuf.InterfaceC0974o1
        public final int getNumber() {
            return this.f2796a;
        }
    }

    public enum OptionTargetType implements InterfaceC0974o1 {
        TARGET_TYPE_UNKNOWN(0),
        TARGET_TYPE_FILE(1),
        TARGET_TYPE_EXTENSION_RANGE(2),
        TARGET_TYPE_MESSAGE(3),
        TARGET_TYPE_FIELD(4),
        TARGET_TYPE_ONEOF(5),
        TARGET_TYPE_ENUM(6),
        TARGET_TYPE_ENUM_ENTRY(7),
        TARGET_TYPE_SERVICE(8),
        TARGET_TYPE_METHOD(9);


        /* renamed from: a, reason: collision with root package name */
        public final int f2798a;

        static {
            values();
        }

        OptionTargetType(int i) {
            this.f2798a = i;
        }

        public static OptionTargetType a(int i) {
            switch (i) {
                case 0:
                    return TARGET_TYPE_UNKNOWN;
                case 1:
                    return TARGET_TYPE_FILE;
                case 2:
                    return TARGET_TYPE_EXTENSION_RANGE;
                case 3:
                    return TARGET_TYPE_MESSAGE;
                case 4:
                    return TARGET_TYPE_FIELD;
                case 5:
                    return TARGET_TYPE_ONEOF;
                case 6:
                    return TARGET_TYPE_ENUM;
                case 7:
                    return TARGET_TYPE_ENUM_ENTRY;
                case 8:
                    return TARGET_TYPE_SERVICE;
                case 9:
                    return TARGET_TYPE_METHOD;
                default:
                    return null;
            }
        }

        @Override // com.google.protobuf.InterfaceC0974o1
        public final int getNumber() {
            return this.f2798a;
        }
    }

    private DescriptorProtos$FieldOptions() {
        List list = Collections.EMPTY_LIST;
        this.n = list;
        this.o = list;
        this.f2792q = list;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final AbstractC0916a B(F1 f12) {
        S s5 = new S(f12);
        s5.g = 0;
        s5.i = 0;
        s5.o = 0;
        List list = Collections.EMPTY_LIST;
        s5.p = list;
        s5.f2871q = list;
        s5.f2874t = list;
        return s5;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object C() {
        return new DescriptorProtos$FieldOptions();
    }

    public final DescriptorProtos$FeatureSet E() {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet = this.p;
        return descriptorProtos$FeatureSet == null ? DescriptorProtos$FeatureSet.l : descriptorProtos$FeatureSet;
    }

    public final boolean F() {
        return (this.d & 128) != 0;
    }

    public final boolean G() {
        return (this.d & 32) != 0;
    }

    public final boolean H() {
        return (this.d & 512) != 0;
    }

    public final boolean I() {
        return (this.d & 4) != 0;
    }

    public final boolean J() {
        return (this.d & 8) != 0;
    }

    public final boolean K() {
        return (this.d & 2) != 0;
    }

    public final boolean L() {
        return (this.d & 256) != 0;
    }

    public final boolean M() {
        return (this.d & 16) != 0;
    }

    public final boolean N() {
        return (this.d & 64) != 0;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public final S toBuilder() {
        if (this == f2790s) {
            return new S();
        }
        S s5 = new S();
        s5.V(this);
        return s5;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        C0934e1 c0934e1 = new C0934e1(this);
        if ((this.d & 1) != 0) {
            c0980q.d0(1, this.e);
        }
        if ((this.d & 2) != 0) {
            c0980q.W(2, this.f);
        }
        if ((this.d & 32) != 0) {
            c0980q.W(3, this.f2791j);
        }
        if ((this.d & 8) != 0) {
            c0980q.W(5, this.h);
        }
        if ((this.d & 4) != 0) {
            c0980q.d0(6, this.g);
        }
        if ((this.d & 64) != 0) {
            c0980q.W(10, this.k);
        }
        if ((this.d & 16) != 0) {
            c0980q.W(15, this.i);
        }
        if ((this.d & 128) != 0) {
            c0980q.W(16, this.l);
        }
        if ((this.d & 256) != 0) {
            c0980q.d0(17, this.m);
        }
        for (int i = 0; i < this.n.size(); i++) {
            c0980q.d0(19, ((Integer) this.n.get(i)).intValue());
        }
        for (int i6 = 0; i6 < this.o.size(); i6++) {
            c0980q.f0(20, (X1) this.o.get(i6));
        }
        if ((this.d & 512) != 0) {
            c0980q.f0(21, E());
        }
        for (int i10 = 0; i10 < this.f2792q.size(); i10++) {
            c0980q.f0(999, (X1) this.f2792q.get(i10));
        }
        c0934e1.a(536870912, c0980q);
        this.b.c(c0980q);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof DescriptorProtos$FieldOptions)) {
                return super.equals(obj);
            }
            DescriptorProtos$FieldOptions descriptorProtos$FieldOptions = (DescriptorProtos$FieldOptions) obj;
            int i = this.d;
            if (((i & 1) != 0) != ((descriptorProtos$FieldOptions.d & 1) != 0) || (((i & 1) != 0 && this.e != descriptorProtos$FieldOptions.e) || K() != descriptorProtos$FieldOptions.K() || ((K() && this.f != descriptorProtos$FieldOptions.f) || I() != descriptorProtos$FieldOptions.I() || ((I() && this.g != descriptorProtos$FieldOptions.g) || J() != descriptorProtos$FieldOptions.J() || ((J() && this.h != descriptorProtos$FieldOptions.h) || M() != descriptorProtos$FieldOptions.M() || ((M() && this.i != descriptorProtos$FieldOptions.i) || G() != descriptorProtos$FieldOptions.G() || ((G() && this.f2791j != descriptorProtos$FieldOptions.f2791j) || N() != descriptorProtos$FieldOptions.N() || ((N() && this.k != descriptorProtos$FieldOptions.k) || F() != descriptorProtos$FieldOptions.F() || ((F() && this.l != descriptorProtos$FieldOptions.l) || L() != descriptorProtos$FieldOptions.L() || ((L() && this.m != descriptorProtos$FieldOptions.m) || !this.n.equals(descriptorProtos$FieldOptions.n) || !this.o.equals(descriptorProtos$FieldOptions.o) || H() != descriptorProtos$FieldOptions.H() || ((H() && !E().equals(descriptorProtos$FieldOptions.E())) || !this.f2792q.equals(descriptorProtos$FieldOptions.f2792q) || !this.b.equals(descriptorProtos$FieldOptions.b) || !this.c.h().equals(descriptorProtos$FieldOptions.c.h())))))))))))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return f2790s;
    }

    @Override // com.google.protobuf.X1
    public final int getSerializedSize() {
        int i = this.f2909a;
        if (i != -1) {
            return i;
        }
        int iM = (this.d & 1) != 0 ? C0980q.M(1, this.e) : 0;
        if ((this.d & 2) != 0) {
            iM += C0980q.J(2);
        }
        if ((this.d & 32) != 0) {
            iM += C0980q.J(3);
        }
        if ((this.d & 8) != 0) {
            iM += C0980q.J(5);
        }
        if ((this.d & 4) != 0) {
            iM += C0980q.M(6, this.g);
        }
        if ((this.d & 64) != 0) {
            iM += C0980q.J(10);
        }
        if ((this.d & 16) != 0) {
            iM += C0980q.J(15);
        }
        if ((this.d & 128) != 0) {
            iM += C0980q.J(16);
        }
        if ((this.d & 256) != 0) {
            iM += C0980q.M(17, this.m);
        }
        int iO = 0;
        for (int i6 = 0; i6 < this.n.size(); i6++) {
            iO += C0980q.O(((Integer) this.n.get(i6)).intValue());
        }
        int size = (this.n.size() * 2) + iM + iO;
        for (int i10 = 0; i10 < this.o.size(); i10++) {
            size += C0980q.P(20, (X1) this.o.get(i10));
        }
        if ((this.d & 512) != 0) {
            size += C0980q.P(21, E());
        }
        for (int i11 = 0; i11 < this.f2792q.size(); i11++) {
            size += C0980q.P(999, (X1) this.f2792q.get(i11));
        }
        int serializedSize = this.b.getSerializedSize() + this.c.k() + size;
        this.f2909a = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = AbstractC1000v0.E.hashCode() + 779;
        if ((this.d & 1) != 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 1, 53) + this.e;
        }
        if (K()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 2, 53) + AbstractC0989s1.b(this.f);
        }
        if (I()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 6, 53) + this.g;
        }
        if (J()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 5, 53) + AbstractC0989s1.b(this.h);
        }
        if (M()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 15, 53) + AbstractC0989s1.b(this.i);
        }
        if (G()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 3, 53) + AbstractC0989s1.b(this.f2791j);
        }
        if (N()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 10, 53) + AbstractC0989s1.b(this.k);
        }
        if (F()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 16, 53) + AbstractC0989s1.b(this.l);
        }
        if (L()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 17, 53) + this.m;
        }
        if (this.n.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 19, 53) + this.n.hashCode();
        }
        if (this.o.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 20, 53) + this.o.hashCode();
        }
        if (H()) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 21, 53) + E().hashCode();
        }
        if (this.f2792q.size() > 0) {
            iHashCode = androidx.constraintlayout.core.dsl.a.D(iHashCode, 37, 999, 53) + this.f2792q.hashCode();
        }
        int iHashCode2 = this.b.hashCode() + (AbstractC0924c.p(iHashCode, this.c.h()) * 29);
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        byte b = this.f2793r;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (H() && !E().isInitialized()) {
            this.f2793r = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.f2792q.size(); i++) {
            if (!((DescriptorProtos$UninterpretedOption) this.f2792q.get(i)).isInitialized()) {
                this.f2793r = (byte) 0;
                return false;
            }
        }
        if (this.c.m()) {
            this.f2793r = (byte) 1;
            return true;
        }
        this.f2793r = (byte) 0;
        return false;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: newBuilderForType */
    public final W1 q() {
        return f2790s.toBuilder();
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a q() {
        return f2790s.toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final C0868b y() {
        C0868b c0868b = AbstractC1000v0.f2949F;
        c0868b.g(DescriptorProtos$FieldOptions.class, S.class);
        return c0868b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return f2790s;
    }
}
