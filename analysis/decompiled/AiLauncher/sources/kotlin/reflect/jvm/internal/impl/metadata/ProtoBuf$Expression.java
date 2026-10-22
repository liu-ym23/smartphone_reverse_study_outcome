package kotlin.reflect.jvm.internal.impl.metadata;

import ia.AbstractC4182b;
import ia.InterfaceC4187g;
import ia.InterfaceC4188h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.c;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.f;

/* loaded from: classes5.dex */
public final class ProtoBuf$Expression extends GeneratedMessageLite implements InterfaceC4187g {

    /* renamed from: m, reason: collision with root package name */
    public static final ProtoBuf$Expression f35404m;

    /* renamed from: n, reason: collision with root package name */
    public static InterfaceC4188h<ProtoBuf$Expression> f35405n = new a();

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC4182b f35406b;

    /* renamed from: c, reason: collision with root package name */
    public int f35407c;

    /* renamed from: d, reason: collision with root package name */
    public int f35408d;

    /* renamed from: e, reason: collision with root package name */
    public int f35409e;

    /* renamed from: f, reason: collision with root package name */
    public ConstantValue f35410f;

    /* renamed from: g, reason: collision with root package name */
    public ProtoBuf$Type f35411g;

    /* renamed from: h, reason: collision with root package name */
    public int f35412h;

    /* renamed from: i, reason: collision with root package name */
    public List<ProtoBuf$Expression> f35413i;

    /* renamed from: j, reason: collision with root package name */
    public List<ProtoBuf$Expression> f35414j;

    /* renamed from: k, reason: collision with root package name */
    public byte f35415k;

    /* renamed from: l, reason: collision with root package name */
    public int f35416l;

    public enum ConstantValue implements f.a {
        TRUE(0, 0),
        FALSE(1, 1),
        NULL(2, 2);

        private static f.b<ConstantValue> internalValueMap = new a();
        private final int value;

        public static class a implements f.b<ConstantValue> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ConstantValue findValueByNumber(int i10) {
                return ConstantValue.valueOf(i10);
            }
        }

        ConstantValue(int i10, int i11) {
            this.value = i11;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.a
        public final int getNumber() {
            return this.value;
        }

        public static ConstantValue valueOf(int i10) {
            if (i10 == 0) {
                return TRUE;
            }
            if (i10 == 1) {
                return FALSE;
            }
            if (i10 != 2) {
                return null;
            }
            return NULL;
        }
    }

    public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ProtoBuf$Expression> {
        @Override // ia.InterfaceC4188h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$Expression c(c cVar, d dVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$Expression(cVar, dVar);
        }
    }

    public static final class b extends GeneratedMessageLite.b<ProtoBuf$Expression, b> implements InterfaceC4187g {

        /* renamed from: b, reason: collision with root package name */
        public int f35417b;

        /* renamed from: c, reason: collision with root package name */
        public int f35418c;

        /* renamed from: d, reason: collision with root package name */
        public int f35419d;

        /* renamed from: e, reason: collision with root package name */
        public ConstantValue f35420e = ConstantValue.TRUE;

        /* renamed from: f, reason: collision with root package name */
        public ProtoBuf$Type f35421f = ProtoBuf$Type.X();

        /* renamed from: g, reason: collision with root package name */
        public int f35422g;

        /* renamed from: h, reason: collision with root package name */
        public List<ProtoBuf$Expression> f35423h;

        /* renamed from: i, reason: collision with root package name */
        public List<ProtoBuf$Expression> f35424i;

        public b() {
            List<ProtoBuf$Expression> list = Collections.EMPTY_LIST;
            this.f35423h = list;
            this.f35424i = list;
            t();
        }

        public static b q() {
            return new b();
        }

        private void t() {
        }

        public b B(int i10) {
            this.f35417b |= 2;
            this.f35419d = i10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$Expression build() {
            ProtoBuf$Expression protoBuf$ExpressionO = o();
            if (protoBuf$ExpressionO.isInitialized()) {
                return protoBuf$ExpressionO;
            }
            throw a.AbstractC0449a.f(protoBuf$ExpressionO);
        }

        public ProtoBuf$Expression o() {
            ProtoBuf$Expression protoBuf$Expression = new ProtoBuf$Expression(this);
            int i10 = this.f35417b;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            protoBuf$Expression.f35408d = this.f35418c;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            protoBuf$Expression.f35409e = this.f35419d;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            protoBuf$Expression.f35410f = this.f35420e;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            protoBuf$Expression.f35411g = this.f35421f;
            if ((i10 & 16) == 16) {
                i11 |= 16;
            }
            protoBuf$Expression.f35412h = this.f35422g;
            if ((this.f35417b & 32) == 32) {
                this.f35423h = Collections.unmodifiableList(this.f35423h);
                this.f35417b &= -33;
            }
            protoBuf$Expression.f35413i = this.f35423h;
            if ((this.f35417b & 64) == 64) {
                this.f35424i = Collections.unmodifiableList(this.f35424i);
                this.f35417b &= -65;
            }
            protoBuf$Expression.f35414j = this.f35424i;
            protoBuf$Expression.f35407c = i11;
            return protoBuf$Expression;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b g() {
            return q().i(o());
        }

        public final void r() {
            if ((this.f35417b & 32) != 32) {
                this.f35423h = new ArrayList(this.f35423h);
                this.f35417b |= 32;
            }
        }

        public final void s() {
            if ((this.f35417b & 64) != 64) {
                this.f35424i = new ArrayList(this.f35424i);
                this.f35417b |= 64;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public b i(ProtoBuf$Expression protoBuf$Expression) {
            if (protoBuf$Expression == ProtoBuf$Expression.F()) {
                return this;
            }
            if (protoBuf$Expression.P()) {
                y(protoBuf$Expression.G());
            }
            if (protoBuf$Expression.S()) {
                B(protoBuf$Expression.N());
            }
            if (protoBuf$Expression.O()) {
                x(protoBuf$Expression.E());
            }
            if (protoBuf$Expression.Q()) {
                w(protoBuf$Expression.H());
            }
            if (protoBuf$Expression.R()) {
                z(protoBuf$Expression.J());
            }
            if (!protoBuf$Expression.f35413i.isEmpty()) {
                if (this.f35423h.isEmpty()) {
                    this.f35423h = protoBuf$Expression.f35413i;
                    this.f35417b &= -33;
                } else {
                    r();
                    this.f35423h.addAll(protoBuf$Expression.f35413i);
                }
            }
            if (!protoBuf$Expression.f35414j.isEmpty()) {
                if (this.f35424i.isEmpty()) {
                    this.f35424i = protoBuf$Expression.f35414j;
                    this.f35417b &= -65;
                } else {
                    s();
                    this.f35424i.addAll(protoBuf$Expression.f35414j);
                }
            }
            j(h().c(protoBuf$Expression.f35406b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression.f35405n     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression$b");
        }

        public b w(ProtoBuf$Type protoBuf$Type) {
            if ((this.f35417b & 8) != 8 || this.f35421f == ProtoBuf$Type.X()) {
                this.f35421f = protoBuf$Type;
            } else {
                this.f35421f = ProtoBuf$Type.y0(this.f35421f).i(protoBuf$Type).s();
            }
            this.f35417b |= 8;
            return this;
        }

        public b x(ConstantValue constantValue) {
            constantValue.getClass();
            this.f35417b |= 4;
            this.f35420e = constantValue;
            return this;
        }

        public b y(int i10) {
            this.f35417b |= 1;
            this.f35418c = i10;
            return this;
        }

        public b z(int i10) {
            this.f35417b |= 16;
            this.f35422g = i10;
            return this;
        }
    }

    static {
        ProtoBuf$Expression protoBuf$Expression = new ProtoBuf$Expression(true);
        f35404m = protoBuf$Expression;
        protoBuf$Expression.T();
    }

    public static ProtoBuf$Expression F() {
        return f35404m;
    }

    private void T() {
        this.f35408d = 0;
        this.f35409e = 0;
        this.f35410f = ConstantValue.TRUE;
        this.f35411g = ProtoBuf$Type.X();
        this.f35412h = 0;
        List<ProtoBuf$Expression> list = Collections.EMPTY_LIST;
        this.f35413i = list;
        this.f35414j = list;
    }

    public static b U() {
        return b.q();
    }

    public static b V(ProtoBuf$Expression protoBuf$Expression) {
        return U().i(protoBuf$Expression);
    }

    public ProtoBuf$Expression A(int i10) {
        return this.f35413i.get(i10);
    }

    public int C() {
        return this.f35413i.size();
    }

    public List<ProtoBuf$Expression> D() {
        return this.f35413i;
    }

    public ConstantValue E() {
        return this.f35410f;
    }

    public int G() {
        return this.f35408d;
    }

    public ProtoBuf$Type H() {
        return this.f35411g;
    }

    public int J() {
        return this.f35412h;
    }

    public ProtoBuf$Expression K(int i10) {
        return this.f35414j.get(i10);
    }

    public int L() {
        return this.f35414j.size();
    }

    public List<ProtoBuf$Expression> M() {
        return this.f35414j;
    }

    public int N() {
        return this.f35409e;
    }

    public boolean O() {
        return (this.f35407c & 4) == 4;
    }

    public boolean P() {
        return (this.f35407c & 1) == 1;
    }

    public boolean Q() {
        return (this.f35407c & 8) == 8;
    }

    public boolean R() {
        return (this.f35407c & 16) == 16;
    }

    public boolean S() {
        return (this.f35407c & 2) == 2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return U();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return V(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f35407c & 1) == 1) {
            codedOutputStream.a0(1, this.f35408d);
        }
        if ((this.f35407c & 2) == 2) {
            codedOutputStream.a0(2, this.f35409e);
        }
        if ((this.f35407c & 4) == 4) {
            codedOutputStream.S(3, this.f35410f.getNumber());
        }
        if ((this.f35407c & 8) == 8) {
            codedOutputStream.d0(4, this.f35411g);
        }
        if ((this.f35407c & 16) == 16) {
            codedOutputStream.a0(5, this.f35412h);
        }
        for (int i10 = 0; i10 < this.f35413i.size(); i10++) {
            codedOutputStream.d0(6, this.f35413i.get(i10));
        }
        for (int i11 = 0; i11 < this.f35414j.size(); i11++) {
            codedOutputStream.d0(7, this.f35414j.get(i11));
        }
        codedOutputStream.i0(this.f35406b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
    public InterfaceC4188h<ProtoBuf$Expression> getParserForType() {
        return f35405n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i10 = this.f35416l;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f35407c & 1) == 1 ? CodedOutputStream.o(1, this.f35408d) : 0;
        if ((this.f35407c & 2) == 2) {
            iO += CodedOutputStream.o(2, this.f35409e);
        }
        if ((this.f35407c & 4) == 4) {
            iO += CodedOutputStream.h(3, this.f35410f.getNumber());
        }
        if ((this.f35407c & 8) == 8) {
            iO += CodedOutputStream.s(4, this.f35411g);
        }
        if ((this.f35407c & 16) == 16) {
            iO += CodedOutputStream.o(5, this.f35412h);
        }
        for (int i11 = 0; i11 < this.f35413i.size(); i11++) {
            iO += CodedOutputStream.s(6, this.f35413i.get(i11));
        }
        for (int i12 = 0; i12 < this.f35414j.size(); i12++) {
            iO += CodedOutputStream.s(7, this.f35414j.get(i12));
        }
        int size = iO + this.f35406b.size();
        this.f35416l = size;
        return size;
    }

    @Override // ia.InterfaceC4187g
    public final boolean isInitialized() {
        byte b10 = this.f35415k;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (Q() && !H().isInitialized()) {
            this.f35415k = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < C(); i10++) {
            if (!A(i10).isInitialized()) {
                this.f35415k = (byte) 0;
                return false;
            }
        }
        for (int i11 = 0; i11 < L(); i11++) {
            if (!K(i11).isInitialized()) {
                this.f35415k = (byte) 0;
                return false;
            }
        }
        this.f35415k = (byte) 1;
        return true;
    }

    public ProtoBuf$Expression(GeneratedMessageLite.b bVar) {
        super(bVar);
        this.f35415k = (byte) -1;
        this.f35416l = -1;
        this.f35406b = bVar.h();
    }

    public ProtoBuf$Expression(boolean z10) {
        this.f35415k = (byte) -1;
        this.f35416l = -1;
        this.f35406b = AbstractC4182b.f33086a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBuf$Expression(c cVar, d dVar) throws InvalidProtocolBufferException {
        this.f35415k = (byte) -1;
        this.f35416l = -1;
        T();
        AbstractC4182b.C0409b c0409bT = AbstractC4182b.t();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(c0409bT, 1);
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            try {
                try {
                    int iK = cVar.K();
                    if (iK != 0) {
                        if (iK == 8) {
                            this.f35407c |= 1;
                            this.f35408d = cVar.s();
                        } else if (iK == 16) {
                            this.f35407c |= 2;
                            this.f35409e = cVar.s();
                        } else if (iK == 24) {
                            int iN = cVar.n();
                            ConstantValue constantValueValueOf = ConstantValue.valueOf(iN);
                            if (constantValueValueOf == null) {
                                codedOutputStreamJ.o0(iK);
                                codedOutputStreamJ.o0(iN);
                            } else {
                                this.f35407c |= 4;
                                this.f35410f = constantValueValueOf;
                            }
                        } else if (iK == 34) {
                            ProtoBuf$Type.b builder = (this.f35407c & 8) == 8 ? this.f35411g.toBuilder() : null;
                            ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) cVar.u(ProtoBuf$Type.f35583v, dVar);
                            this.f35411g = protoBuf$Type;
                            if (builder != null) {
                                builder.i(protoBuf$Type);
                                this.f35411g = builder.s();
                            }
                            this.f35407c |= 8;
                        } else if (iK == 40) {
                            this.f35407c |= 16;
                            this.f35412h = cVar.s();
                        } else if (iK == 50) {
                            if ((i10 & 32) != 32) {
                                this.f35413i = new ArrayList();
                                i10 |= 32;
                            }
                            this.f35413i.add(cVar.u(f35405n, dVar));
                        } else if (iK != 58) {
                            if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                            }
                        } else {
                            if ((i10 & 64) != 64) {
                                this.f35414j = new ArrayList();
                                i10 |= 64;
                            }
                            this.f35414j.add(cVar.u(f35405n, dVar));
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if ((i10 & 32) == 32) {
                        this.f35413i = Collections.unmodifiableList(this.f35413i);
                    }
                    if ((i10 & 64) == 64) {
                        this.f35414j = Collections.unmodifiableList(this.f35414j);
                    }
                    try {
                        codedOutputStreamJ.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f35406b = c0409bT.l();
                        throw th2;
                    }
                    this.f35406b = c0409bT.l();
                    g();
                    throw th;
                }
            } catch (InvalidProtocolBufferException e10) {
                throw e10.i(this);
            } catch (IOException e11) {
                throw new InvalidProtocolBufferException(e11.getMessage()).i(this);
            }
        }
        if ((i10 & 32) == 32) {
            this.f35413i = Collections.unmodifiableList(this.f35413i);
        }
        if ((i10 & 64) == 64) {
            this.f35414j = Collections.unmodifiableList(this.f35414j);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f35406b = c0409bT.l();
            throw th3;
        }
        this.f35406b = c0409bT.l();
        g();
    }
}
