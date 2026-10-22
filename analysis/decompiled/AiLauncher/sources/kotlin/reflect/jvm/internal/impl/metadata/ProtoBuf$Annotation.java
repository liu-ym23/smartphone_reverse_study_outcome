package kotlin.reflect.jvm.internal.impl.metadata;

import ia.AbstractC4182b;
import ia.InterfaceC4187g;
import ia.InterfaceC4188h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.c;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.f;

/* loaded from: classes5.dex */
public final class ProtoBuf$Annotation extends GeneratedMessageLite implements InterfaceC4187g {

    /* renamed from: h, reason: collision with root package name */
    public static final ProtoBuf$Annotation f35232h;

    /* renamed from: i, reason: collision with root package name */
    public static InterfaceC4188h<ProtoBuf$Annotation> f35233i = new a();

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC4182b f35234b;

    /* renamed from: c, reason: collision with root package name */
    public int f35235c;

    /* renamed from: d, reason: collision with root package name */
    public int f35236d;

    /* renamed from: e, reason: collision with root package name */
    public List<Argument> f35237e;

    /* renamed from: f, reason: collision with root package name */
    public byte f35238f;

    /* renamed from: g, reason: collision with root package name */
    public int f35239g;

    public static final class Argument extends GeneratedMessageLite implements InterfaceC4187g {

        /* renamed from: h, reason: collision with root package name */
        public static final Argument f35240h;

        /* renamed from: i, reason: collision with root package name */
        public static InterfaceC4188h<Argument> f35241i = new a();

        /* renamed from: b, reason: collision with root package name */
        public final AbstractC4182b f35242b;

        /* renamed from: c, reason: collision with root package name */
        public int f35243c;

        /* renamed from: d, reason: collision with root package name */
        public int f35244d;

        /* renamed from: e, reason: collision with root package name */
        public Value f35245e;

        /* renamed from: f, reason: collision with root package name */
        public byte f35246f;

        /* renamed from: g, reason: collision with root package name */
        public int f35247g;

        public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Argument> {
            @Override // ia.InterfaceC4188h
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Argument c(c cVar, d dVar) throws InvalidProtocolBufferException {
                return new Argument(cVar, dVar);
            }
        }

        public static final class b extends GeneratedMessageLite.b<Argument, b> implements InterfaceC4187g {

            /* renamed from: b, reason: collision with root package name */
            public int f35277b;

            /* renamed from: c, reason: collision with root package name */
            public int f35278c;

            /* renamed from: d, reason: collision with root package name */
            public Value f35279d = Value.L();

            public b() {
                r();
            }

            public static b q() {
                return new b();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public Argument build() {
                Argument argumentO = o();
                if (argumentO.isInitialized()) {
                    return argumentO;
                }
                throw a.AbstractC0449a.f(argumentO);
            }

            public Argument o() {
                Argument argument = new Argument(this);
                int i10 = this.f35277b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                argument.f35244d = this.f35278c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                argument.f35245e = this.f35279d;
                argument.f35243c = i11;
                return argument;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public b g() {
                return q().i(o());
            }

            public final void r() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public b i(Argument argument) {
                if (argument == Argument.t()) {
                    return this;
                }
                if (argument.w()) {
                    v(argument.u());
                }
                if (argument.x()) {
                    u(argument.v());
                }
                j(h().c(argument.f35242b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation.Argument.f35241i     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation.Argument) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.i(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.h r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation.Argument) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.i(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$b");
            }

            public b u(Value value) {
                if ((this.f35277b & 2) != 2 || this.f35279d == Value.L()) {
                    this.f35279d = value;
                } else {
                    this.f35279d = Value.f0(this.f35279d).i(value).o();
                }
                this.f35277b |= 2;
                return this;
            }

            public b v(int i10) {
                this.f35277b |= 1;
                this.f35278c = i10;
                return this;
            }
        }

        static {
            Argument argument = new Argument(true);
            f35240h = argument;
            argument.y();
        }

        public static b A(Argument argument) {
            return z().i(argument);
        }

        public static Argument t() {
            return f35240h;
        }

        private void y() {
            this.f35244d = 0;
            this.f35245e = Value.L();
        }

        public static b z() {
            return b.q();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return z();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            return A(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f35243c & 1) == 1) {
                codedOutputStream.a0(1, this.f35244d);
            }
            if ((this.f35243c & 2) == 2) {
                codedOutputStream.d0(2, this.f35245e);
            }
            codedOutputStream.i0(this.f35242b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
        public InterfaceC4188h<Argument> getParserForType() {
            return f35241i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int getSerializedSize() {
            int i10 = this.f35247g;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.f35243c & 1) == 1 ? CodedOutputStream.o(1, this.f35244d) : 0;
            if ((this.f35243c & 2) == 2) {
                iO += CodedOutputStream.s(2, this.f35245e);
            }
            int size = iO + this.f35242b.size();
            this.f35247g = size;
            return size;
        }

        @Override // ia.InterfaceC4187g
        public final boolean isInitialized() {
            byte b10 = this.f35246f;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            if (!w()) {
                this.f35246f = (byte) 0;
                return false;
            }
            if (!x()) {
                this.f35246f = (byte) 0;
                return false;
            }
            if (v().isInitialized()) {
                this.f35246f = (byte) 1;
                return true;
            }
            this.f35246f = (byte) 0;
            return false;
        }

        public int u() {
            return this.f35244d;
        }

        public Value v() {
            return this.f35245e;
        }

        public boolean w() {
            return (this.f35243c & 1) == 1;
        }

        public boolean x() {
            return (this.f35243c & 2) == 2;
        }

        public static final class Value extends GeneratedMessageLite implements InterfaceC4187g {

            /* renamed from: q, reason: collision with root package name */
            public static final Value f35248q;

            /* renamed from: r, reason: collision with root package name */
            public static InterfaceC4188h<Value> f35249r = new a();

            /* renamed from: b, reason: collision with root package name */
            public final AbstractC4182b f35250b;

            /* renamed from: c, reason: collision with root package name */
            public int f35251c;

            /* renamed from: d, reason: collision with root package name */
            public Type f35252d;

            /* renamed from: e, reason: collision with root package name */
            public long f35253e;

            /* renamed from: f, reason: collision with root package name */
            public float f35254f;

            /* renamed from: g, reason: collision with root package name */
            public double f35255g;

            /* renamed from: h, reason: collision with root package name */
            public int f35256h;

            /* renamed from: i, reason: collision with root package name */
            public int f35257i;

            /* renamed from: j, reason: collision with root package name */
            public int f35258j;

            /* renamed from: k, reason: collision with root package name */
            public ProtoBuf$Annotation f35259k;

            /* renamed from: l, reason: collision with root package name */
            public List<Value> f35260l;

            /* renamed from: m, reason: collision with root package name */
            public int f35261m;

            /* renamed from: n, reason: collision with root package name */
            public int f35262n;

            /* renamed from: o, reason: collision with root package name */
            public byte f35263o;

            /* renamed from: p, reason: collision with root package name */
            public int f35264p;

            public enum Type implements f.a {
                BYTE(0, 0),
                CHAR(1, 1),
                SHORT(2, 2),
                INT(3, 3),
                LONG(4, 4),
                FLOAT(5, 5),
                DOUBLE(6, 6),
                BOOLEAN(7, 7),
                STRING(8, 8),
                CLASS(9, 9),
                ENUM(10, 10),
                ANNOTATION(11, 11),
                ARRAY(12, 12);

                private static f.b<Type> internalValueMap = new a();
                private final int value;

                public static class a implements f.b<Type> {
                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.b
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Type findValueByNumber(int i10) {
                        return Type.valueOf(i10);
                    }
                }

                Type(int i10, int i11) {
                    this.value = i11;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.a
                public final int getNumber() {
                    return this.value;
                }

                public static Type valueOf(int i10) {
                    switch (i10) {
                        case 0:
                            return BYTE;
                        case 1:
                            return CHAR;
                        case 2:
                            return SHORT;
                        case 3:
                            return INT;
                        case 4:
                            return LONG;
                        case 5:
                            return FLOAT;
                        case 6:
                            return DOUBLE;
                        case 7:
                            return BOOLEAN;
                        case 8:
                            return STRING;
                        case 9:
                            return CLASS;
                        case 10:
                            return ENUM;
                        case 11:
                            return ANNOTATION;
                        case 12:
                            return ARRAY;
                        default:
                            return null;
                    }
                }
            }

            public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Value> {
                @Override // ia.InterfaceC4188h
                /* renamed from: m, reason: merged with bridge method [inline-methods] */
                public Value c(c cVar, d dVar) throws InvalidProtocolBufferException {
                    return new Value(cVar, dVar);
                }
            }

            public static final class b extends GeneratedMessageLite.b<Value, b> implements InterfaceC4187g {

                /* renamed from: b, reason: collision with root package name */
                public int f35265b;

                /* renamed from: d, reason: collision with root package name */
                public long f35267d;

                /* renamed from: e, reason: collision with root package name */
                public float f35268e;

                /* renamed from: f, reason: collision with root package name */
                public double f35269f;

                /* renamed from: g, reason: collision with root package name */
                public int f35270g;

                /* renamed from: h, reason: collision with root package name */
                public int f35271h;

                /* renamed from: i, reason: collision with root package name */
                public int f35272i;

                /* renamed from: l, reason: collision with root package name */
                public int f35275l;

                /* renamed from: m, reason: collision with root package name */
                public int f35276m;

                /* renamed from: c, reason: collision with root package name */
                public Type f35266c = Type.BYTE;

                /* renamed from: j, reason: collision with root package name */
                public ProtoBuf$Annotation f35273j = ProtoBuf$Annotation.x();

                /* renamed from: k, reason: collision with root package name */
                public List<Value> f35274k = Collections.EMPTY_LIST;

                public b() {
                    s();
                }

                public static b q() {
                    return new b();
                }

                private void s() {
                }

                public b B(int i10) {
                    this.f35265b |= 1024;
                    this.f35276m = i10;
                    return this;
                }

                public b C(float f10) {
                    this.f35265b |= 4;
                    this.f35268e = f10;
                    return this;
                }

                public b D(long j10) {
                    this.f35265b |= 2;
                    this.f35267d = j10;
                    return this;
                }

                public b E(int i10) {
                    this.f35265b |= 16;
                    this.f35270g = i10;
                    return this;
                }

                public b F(Type type) {
                    type.getClass();
                    this.f35265b |= 1;
                    this.f35266c = type;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public Value build() {
                    Value valueO = o();
                    if (valueO.isInitialized()) {
                        return valueO;
                    }
                    throw a.AbstractC0449a.f(valueO);
                }

                public Value o() {
                    Value value = new Value(this);
                    int i10 = this.f35265b;
                    int i11 = (i10 & 1) != 1 ? 0 : 1;
                    value.f35252d = this.f35266c;
                    if ((i10 & 2) == 2) {
                        i11 |= 2;
                    }
                    value.f35253e = this.f35267d;
                    if ((i10 & 4) == 4) {
                        i11 |= 4;
                    }
                    value.f35254f = this.f35268e;
                    if ((i10 & 8) == 8) {
                        i11 |= 8;
                    }
                    value.f35255g = this.f35269f;
                    if ((i10 & 16) == 16) {
                        i11 |= 16;
                    }
                    value.f35256h = this.f35270g;
                    if ((i10 & 32) == 32) {
                        i11 |= 32;
                    }
                    value.f35257i = this.f35271h;
                    if ((i10 & 64) == 64) {
                        i11 |= 64;
                    }
                    value.f35258j = this.f35272i;
                    if ((i10 & 128) == 128) {
                        i11 |= 128;
                    }
                    value.f35259k = this.f35273j;
                    if ((this.f35265b & 256) == 256) {
                        this.f35274k = Collections.unmodifiableList(this.f35274k);
                        this.f35265b &= -257;
                    }
                    value.f35260l = this.f35274k;
                    if ((i10 & 512) == 512) {
                        i11 |= 256;
                    }
                    value.f35261m = this.f35275l;
                    if ((i10 & 1024) == 1024) {
                        i11 |= 512;
                    }
                    value.f35262n = this.f35276m;
                    value.f35251c = i11;
                    return value;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: p, reason: merged with bridge method [inline-methods] */
                public b g() {
                    return q().i(o());
                }

                public final void r() {
                    if ((this.f35265b & 256) != 256) {
                        this.f35274k = new ArrayList(this.f35274k);
                        this.f35265b |= 256;
                    }
                }

                public b t(ProtoBuf$Annotation protoBuf$Annotation) {
                    if ((this.f35265b & 128) != 128 || this.f35273j == ProtoBuf$Annotation.x()) {
                        this.f35273j = protoBuf$Annotation;
                    } else {
                        this.f35273j = ProtoBuf$Annotation.D(this.f35273j).i(protoBuf$Annotation).o();
                    }
                    this.f35265b |= 128;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: u, reason: merged with bridge method [inline-methods] */
                public b i(Value value) {
                    if (value == Value.L()) {
                        return this;
                    }
                    if (value.c0()) {
                        F(value.S());
                    }
                    if (value.a0()) {
                        D(value.Q());
                    }
                    if (value.Z()) {
                        C(value.P());
                    }
                    if (value.W()) {
                        y(value.M());
                    }
                    if (value.b0()) {
                        E(value.R());
                    }
                    if (value.V()) {
                        x(value.K());
                    }
                    if (value.X()) {
                        z(value.N());
                    }
                    if (value.T()) {
                        t(value.E());
                    }
                    if (!value.f35260l.isEmpty()) {
                        if (this.f35274k.isEmpty()) {
                            this.f35274k = value.f35260l;
                            this.f35265b &= -257;
                        } else {
                            r();
                            this.f35274k.addAll(value.f35260l);
                        }
                    }
                    if (value.U()) {
                        w(value.F());
                    }
                    if (value.Y()) {
                        B(value.O());
                    }
                    j(h().c(value.f35250b));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
                /* renamed from: v, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
                    /*
                        r2 = this;
                        r0 = 0
                        ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.f35249r     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        if (r3 == 0) goto Le
                        r2.i(r3)
                    Le:
                        return r2
                    Lf:
                        r3 = move-exception
                        goto L1b
                    L11:
                        r3 = move-exception
                        kotlin.reflect.jvm.internal.impl.protobuf.h r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value) r4     // Catch: java.lang.Throwable -> Lf
                        throw r3     // Catch: java.lang.Throwable -> L19
                    L19:
                        r3 = move-exception
                        r0 = r4
                    L1b:
                        if (r0 == 0) goto L20
                        r2.i(r0)
                    L20:
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value$b");
                }

                public b w(int i10) {
                    this.f35265b |= 512;
                    this.f35275l = i10;
                    return this;
                }

                public b x(int i10) {
                    this.f35265b |= 32;
                    this.f35271h = i10;
                    return this;
                }

                public b y(double d10) {
                    this.f35265b |= 8;
                    this.f35269f = d10;
                    return this;
                }

                public b z(int i10) {
                    this.f35265b |= 64;
                    this.f35272i = i10;
                    return this;
                }
            }

            static {
                Value value = new Value(true);
                f35248q = value;
                value.d0();
            }

            public static Value L() {
                return f35248q;
            }

            public static b e0() {
                return b.q();
            }

            public static b f0(Value value) {
                return e0().i(value);
            }

            public ProtoBuf$Annotation E() {
                return this.f35259k;
            }

            public int F() {
                return this.f35261m;
            }

            public Value G(int i10) {
                return this.f35260l.get(i10);
            }

            public int H() {
                return this.f35260l.size();
            }

            public List<Value> J() {
                return this.f35260l;
            }

            public int K() {
                return this.f35257i;
            }

            public double M() {
                return this.f35255g;
            }

            public int N() {
                return this.f35258j;
            }

            public int O() {
                return this.f35262n;
            }

            public float P() {
                return this.f35254f;
            }

            public long Q() {
                return this.f35253e;
            }

            public int R() {
                return this.f35256h;
            }

            public Type S() {
                return this.f35252d;
            }

            public boolean T() {
                return (this.f35251c & 128) == 128;
            }

            public boolean U() {
                return (this.f35251c & 256) == 256;
            }

            public boolean V() {
                return (this.f35251c & 32) == 32;
            }

            public boolean W() {
                return (this.f35251c & 8) == 8;
            }

            public boolean X() {
                return (this.f35251c & 64) == 64;
            }

            public boolean Y() {
                return (this.f35251c & 512) == 512;
            }

            public boolean Z() {
                return (this.f35251c & 4) == 4;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
            public void a(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.f35251c & 1) == 1) {
                    codedOutputStream.S(1, this.f35252d.getNumber());
                }
                if ((this.f35251c & 2) == 2) {
                    codedOutputStream.t0(2, this.f35253e);
                }
                if ((this.f35251c & 4) == 4) {
                    codedOutputStream.W(3, this.f35254f);
                }
                if ((this.f35251c & 8) == 8) {
                    codedOutputStream.Q(4, this.f35255g);
                }
                if ((this.f35251c & 16) == 16) {
                    codedOutputStream.a0(5, this.f35256h);
                }
                if ((this.f35251c & 32) == 32) {
                    codedOutputStream.a0(6, this.f35257i);
                }
                if ((this.f35251c & 64) == 64) {
                    codedOutputStream.a0(7, this.f35258j);
                }
                if ((this.f35251c & 128) == 128) {
                    codedOutputStream.d0(8, this.f35259k);
                }
                for (int i10 = 0; i10 < this.f35260l.size(); i10++) {
                    codedOutputStream.d0(9, this.f35260l.get(i10));
                }
                if ((this.f35251c & 512) == 512) {
                    codedOutputStream.a0(10, this.f35262n);
                }
                if ((this.f35251c & 256) == 256) {
                    codedOutputStream.a0(11, this.f35261m);
                }
                codedOutputStream.i0(this.f35250b);
            }

            public boolean a0() {
                return (this.f35251c & 2) == 2;
            }

            public boolean b0() {
                return (this.f35251c & 16) == 16;
            }

            public boolean c0() {
                return (this.f35251c & 1) == 1;
            }

            public final void d0() {
                this.f35252d = Type.BYTE;
                this.f35253e = 0L;
                this.f35254f = 0.0f;
                this.f35255g = 0.0d;
                this.f35256h = 0;
                this.f35257i = 0;
                this.f35258j = 0;
                this.f35259k = ProtoBuf$Annotation.x();
                this.f35260l = Collections.EMPTY_LIST;
                this.f35261m = 0;
                this.f35262n = 0;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
            /* renamed from: g0, reason: merged with bridge method [inline-methods] */
            public b newBuilderForType() {
                return e0();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
            public InterfaceC4188h<Value> getParserForType() {
                return f35249r;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
            public int getSerializedSize() {
                int i10 = this.f35264p;
                if (i10 != -1) {
                    return i10;
                }
                int iH = (this.f35251c & 1) == 1 ? CodedOutputStream.h(1, this.f35252d.getNumber()) : 0;
                if ((this.f35251c & 2) == 2) {
                    iH += CodedOutputStream.A(2, this.f35253e);
                }
                if ((this.f35251c & 4) == 4) {
                    iH += CodedOutputStream.l(3, this.f35254f);
                }
                if ((this.f35251c & 8) == 8) {
                    iH += CodedOutputStream.f(4, this.f35255g);
                }
                if ((this.f35251c & 16) == 16) {
                    iH += CodedOutputStream.o(5, this.f35256h);
                }
                if ((this.f35251c & 32) == 32) {
                    iH += CodedOutputStream.o(6, this.f35257i);
                }
                if ((this.f35251c & 64) == 64) {
                    iH += CodedOutputStream.o(7, this.f35258j);
                }
                if ((this.f35251c & 128) == 128) {
                    iH += CodedOutputStream.s(8, this.f35259k);
                }
                for (int i11 = 0; i11 < this.f35260l.size(); i11++) {
                    iH += CodedOutputStream.s(9, this.f35260l.get(i11));
                }
                if ((this.f35251c & 512) == 512) {
                    iH += CodedOutputStream.o(10, this.f35262n);
                }
                if ((this.f35251c & 256) == 256) {
                    iH += CodedOutputStream.o(11, this.f35261m);
                }
                int size = iH + this.f35250b.size();
                this.f35264p = size;
                return size;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
            /* renamed from: h0, reason: merged with bridge method [inline-methods] */
            public b toBuilder() {
                return f0(this);
            }

            @Override // ia.InterfaceC4187g
            public final boolean isInitialized() {
                byte b10 = this.f35263o;
                if (b10 == 1) {
                    return true;
                }
                if (b10 == 0) {
                    return false;
                }
                if (T() && !E().isInitialized()) {
                    this.f35263o = (byte) 0;
                    return false;
                }
                for (int i10 = 0; i10 < H(); i10++) {
                    if (!G(i10).isInitialized()) {
                        this.f35263o = (byte) 0;
                        return false;
                    }
                }
                this.f35263o = (byte) 1;
                return true;
            }

            public Value(GeneratedMessageLite.b bVar) {
                super(bVar);
                this.f35263o = (byte) -1;
                this.f35264p = -1;
                this.f35250b = bVar.h();
            }

            public Value(boolean z10) {
                this.f35263o = (byte) -1;
                this.f35264p = -1;
                this.f35250b = AbstractC4182b.f33086a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v0 */
            /* JADX WARN: Type inference failed for: r5v1 */
            /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
            public Value(c cVar, d dVar) throws InvalidProtocolBufferException {
                this.f35263o = (byte) -1;
                this.f35264p = -1;
                d0();
                AbstractC4182b.C0409b c0409bT = AbstractC4182b.t();
                CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(c0409bT, 1);
                boolean z10 = false;
                char c10 = 0;
                while (true) {
                    ?? J10 = 256;
                    if (!z10) {
                        try {
                            try {
                                int iK = cVar.K();
                                switch (iK) {
                                    case 0:
                                        z10 = true;
                                    case 8:
                                        int iN = cVar.n();
                                        Type typeValueOf = Type.valueOf(iN);
                                        if (typeValueOf == null) {
                                            codedOutputStreamJ.o0(iK);
                                            codedOutputStreamJ.o0(iN);
                                        } else {
                                            this.f35251c |= 1;
                                            this.f35252d = typeValueOf;
                                        }
                                    case 16:
                                        this.f35251c |= 2;
                                        this.f35253e = cVar.H();
                                    case 29:
                                        this.f35251c |= 4;
                                        this.f35254f = cVar.q();
                                    case 33:
                                        this.f35251c |= 8;
                                        this.f35255g = cVar.m();
                                    case 40:
                                        this.f35251c |= 16;
                                        this.f35256h = cVar.s();
                                    case 48:
                                        this.f35251c |= 32;
                                        this.f35257i = cVar.s();
                                    case 56:
                                        this.f35251c |= 64;
                                        this.f35258j = cVar.s();
                                    case 66:
                                        b builder = (this.f35251c & 128) == 128 ? this.f35259k.toBuilder() : null;
                                        ProtoBuf$Annotation protoBuf$Annotation = (ProtoBuf$Annotation) cVar.u(ProtoBuf$Annotation.f35233i, dVar);
                                        this.f35259k = protoBuf$Annotation;
                                        if (builder != null) {
                                            builder.i(protoBuf$Annotation);
                                            this.f35259k = builder.o();
                                        }
                                        this.f35251c |= 128;
                                    case 74:
                                        if ((c10 & 256) != 256) {
                                            this.f35260l = new ArrayList();
                                            c10 = 256;
                                        }
                                        this.f35260l.add(cVar.u(f35249r, dVar));
                                    case 80:
                                        this.f35251c |= 512;
                                        this.f35262n = cVar.s();
                                    case 88:
                                        this.f35251c |= 256;
                                        this.f35261m = cVar.s();
                                    default:
                                        J10 = j(cVar, codedOutputStreamJ, dVar, iK);
                                        if (J10 == 0) {
                                            z10 = true;
                                        }
                                }
                            } catch (Throwable th) {
                                if ((c10 & 256) == J10) {
                                    this.f35260l = Collections.unmodifiableList(this.f35260l);
                                }
                                try {
                                    codedOutputStreamJ.I();
                                } catch (IOException unused) {
                                } catch (Throwable th2) {
                                    this.f35250b = c0409bT.l();
                                    throw th2;
                                }
                                this.f35250b = c0409bT.l();
                                g();
                                throw th;
                            }
                        } catch (InvalidProtocolBufferException e10) {
                            throw e10.i(this);
                        } catch (IOException e11) {
                            throw new InvalidProtocolBufferException(e11.getMessage()).i(this);
                        }
                    } else {
                        if ((c10 & 256) == 256) {
                            this.f35260l = Collections.unmodifiableList(this.f35260l);
                        }
                        try {
                            codedOutputStreamJ.I();
                        } catch (IOException unused2) {
                        } catch (Throwable th3) {
                            this.f35250b = c0409bT.l();
                            throw th3;
                        }
                        this.f35250b = c0409bT.l();
                        g();
                        return;
                    }
                }
            }
        }

        public Argument(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.f35246f = (byte) -1;
            this.f35247g = -1;
            this.f35242b = bVar.h();
        }

        public Argument(boolean z10) {
            this.f35246f = (byte) -1;
            this.f35247g = -1;
            this.f35242b = AbstractC4182b.f33086a;
        }

        public Argument(c cVar, d dVar) throws InvalidProtocolBufferException {
            this.f35246f = (byte) -1;
            this.f35247g = -1;
            y();
            AbstractC4182b.C0409b c0409bT = AbstractC4182b.t();
            CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(c0409bT, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int iK = cVar.K();
                        if (iK != 0) {
                            if (iK == 8) {
                                this.f35243c |= 1;
                                this.f35244d = cVar.s();
                            } else if (iK != 18) {
                                if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                                }
                            } else {
                                Value.b builder = (this.f35243c & 2) == 2 ? this.f35245e.toBuilder() : null;
                                Value value = (Value) cVar.u(Value.f35249r, dVar);
                                this.f35245e = value;
                                if (builder != null) {
                                    builder.i(value);
                                    this.f35245e = builder.o();
                                }
                                this.f35243c |= 2;
                            }
                        }
                        z10 = true;
                    } catch (Throwable th) {
                        try {
                            codedOutputStreamJ.I();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.f35242b = c0409bT.l();
                            throw th2;
                        }
                        this.f35242b = c0409bT.l();
                        g();
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e10) {
                    throw e10.i(this);
                } catch (IOException e11) {
                    throw new InvalidProtocolBufferException(e11.getMessage()).i(this);
                }
            }
            try {
                codedOutputStreamJ.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f35242b = c0409bT.l();
                throw th3;
            }
            this.f35242b = c0409bT.l();
            g();
        }
    }

    public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ProtoBuf$Annotation> {
        @Override // ia.InterfaceC4188h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$Annotation c(c cVar, d dVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$Annotation(cVar, dVar);
        }
    }

    public static final class b extends GeneratedMessageLite.b<ProtoBuf$Annotation, b> implements InterfaceC4187g {

        /* renamed from: b, reason: collision with root package name */
        public int f35280b;

        /* renamed from: c, reason: collision with root package name */
        public int f35281c;

        /* renamed from: d, reason: collision with root package name */
        public List<Argument> f35282d = Collections.EMPTY_LIST;

        public b() {
            s();
        }

        public static b q() {
            return new b();
        }

        private void s() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$Annotation build() {
            ProtoBuf$Annotation protoBuf$AnnotationO = o();
            if (protoBuf$AnnotationO.isInitialized()) {
                return protoBuf$AnnotationO;
            }
            throw a.AbstractC0449a.f(protoBuf$AnnotationO);
        }

        public ProtoBuf$Annotation o() {
            ProtoBuf$Annotation protoBuf$Annotation = new ProtoBuf$Annotation(this);
            int i10 = (this.f35280b & 1) != 1 ? 0 : 1;
            protoBuf$Annotation.f35236d = this.f35281c;
            if ((this.f35280b & 2) == 2) {
                this.f35282d = Collections.unmodifiableList(this.f35282d);
                this.f35280b &= -3;
            }
            protoBuf$Annotation.f35237e = this.f35282d;
            protoBuf$Annotation.f35235c = i10;
            return protoBuf$Annotation;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b g() {
            return q().i(o());
        }

        public final void r() {
            if ((this.f35280b & 2) != 2) {
                this.f35282d = new ArrayList(this.f35282d);
                this.f35280b |= 2;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public b i(ProtoBuf$Annotation protoBuf$Annotation) {
            if (protoBuf$Annotation == ProtoBuf$Annotation.x()) {
                return this;
            }
            if (protoBuf$Annotation.z()) {
                v(protoBuf$Annotation.y());
            }
            if (!protoBuf$Annotation.f35237e.isEmpty()) {
                if (this.f35282d.isEmpty()) {
                    this.f35282d = protoBuf$Annotation.f35237e;
                    this.f35280b &= -3;
                } else {
                    r();
                    this.f35282d.addAll(protoBuf$Annotation.f35237e);
                }
            }
            j(h().c(protoBuf$Annotation.f35234b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation.f35233i     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                if (r3 == 0) goto Le
                r2.i(r3)
            Le:
                return r2
            Lf:
                r3 = move-exception
                goto L1b
            L11:
                r3 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.h r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation) r4     // Catch: java.lang.Throwable -> Lf
                throw r3     // Catch: java.lang.Throwable -> L19
            L19:
                r3 = move-exception
                r0 = r4
            L1b:
                if (r0 == 0) goto L20
                r2.i(r0)
            L20:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$b");
        }

        public b v(int i10) {
            this.f35280b |= 1;
            this.f35281c = i10;
            return this;
        }
    }

    static {
        ProtoBuf$Annotation protoBuf$Annotation = new ProtoBuf$Annotation(true);
        f35232h = protoBuf$Annotation;
        protoBuf$Annotation.A();
    }

    private void A() {
        this.f35236d = 0;
        this.f35237e = Collections.EMPTY_LIST;
    }

    public static b C() {
        return b.q();
    }

    public static b D(ProtoBuf$Annotation protoBuf$Annotation) {
        return C().i(protoBuf$Annotation);
    }

    public static ProtoBuf$Annotation x() {
        return f35232h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return C();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return D(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f35235c & 1) == 1) {
            codedOutputStream.a0(1, this.f35236d);
        }
        for (int i10 = 0; i10 < this.f35237e.size(); i10++) {
            codedOutputStream.d0(2, this.f35237e.get(i10));
        }
        codedOutputStream.i0(this.f35234b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
    public InterfaceC4188h<ProtoBuf$Annotation> getParserForType() {
        return f35233i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i10 = this.f35239g;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f35235c & 1) == 1 ? CodedOutputStream.o(1, this.f35236d) : 0;
        for (int i11 = 0; i11 < this.f35237e.size(); i11++) {
            iO += CodedOutputStream.s(2, this.f35237e.get(i11));
        }
        int size = iO + this.f35234b.size();
        this.f35239g = size;
        return size;
    }

    @Override // ia.InterfaceC4187g
    public final boolean isInitialized() {
        byte b10 = this.f35238f;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!z()) {
            this.f35238f = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < v(); i10++) {
            if (!u(i10).isInitialized()) {
                this.f35238f = (byte) 0;
                return false;
            }
        }
        this.f35238f = (byte) 1;
        return true;
    }

    public Argument u(int i10) {
        return this.f35237e.get(i10);
    }

    public int v() {
        return this.f35237e.size();
    }

    public List<Argument> w() {
        return this.f35237e;
    }

    public int y() {
        return this.f35236d;
    }

    public boolean z() {
        return (this.f35235c & 1) == 1;
    }

    public ProtoBuf$Annotation(GeneratedMessageLite.b bVar) {
        super(bVar);
        this.f35238f = (byte) -1;
        this.f35239g = -1;
        this.f35234b = bVar.h();
    }

    public ProtoBuf$Annotation(boolean z10) {
        this.f35238f = (byte) -1;
        this.f35239g = -1;
        this.f35234b = AbstractC4182b.f33086a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBuf$Annotation(c cVar, d dVar) throws InvalidProtocolBufferException {
        this.f35238f = (byte) -1;
        this.f35239g = -1;
        A();
        AbstractC4182b.C0409b c0409bT = AbstractC4182b.t();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(c0409bT, 1);
        boolean z10 = false;
        char c10 = 0;
        while (!z10) {
            try {
                try {
                    int iK = cVar.K();
                    if (iK != 0) {
                        if (iK == 8) {
                            this.f35235c |= 1;
                            this.f35236d = cVar.s();
                        } else if (iK != 18) {
                            if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                            }
                        } else {
                            if ((c10 & 2) != 2) {
                                this.f35237e = new ArrayList();
                                c10 = 2;
                            }
                            this.f35237e.add(cVar.u(Argument.f35241i, dVar));
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if ((c10 & 2) == 2) {
                        this.f35237e = Collections.unmodifiableList(this.f35237e);
                    }
                    try {
                        codedOutputStreamJ.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f35234b = c0409bT.l();
                        throw th2;
                    }
                    this.f35234b = c0409bT.l();
                    g();
                    throw th;
                }
            } catch (InvalidProtocolBufferException e10) {
                throw e10.i(this);
            } catch (IOException e11) {
                throw new InvalidProtocolBufferException(e11.getMessage()).i(this);
            }
        }
        if ((c10 & 2) == 2) {
            this.f35237e = Collections.unmodifiableList(this.f35237e);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f35234b = c0409bT.l();
            throw th3;
        }
        this.f35234b = c0409bT.l();
        g();
    }
}
