package kotlin.reflect.jvm.internal.impl.metadata;

import ia.AbstractC4182b;
import ia.InterfaceC4187g;
import ia.InterfaceC4188h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.c;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* loaded from: classes5.dex */
public final class ProtoBuf$ValueParameter extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$ValueParameter> implements InterfaceC4187g {

    /* renamed from: o, reason: collision with root package name */
    public static final ProtoBuf$ValueParameter f35688o;

    /* renamed from: p, reason: collision with root package name */
    public static InterfaceC4188h<ProtoBuf$ValueParameter> f35689p = new a();

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC4182b f35690c;

    /* renamed from: d, reason: collision with root package name */
    public int f35691d;

    /* renamed from: e, reason: collision with root package name */
    public int f35692e;

    /* renamed from: f, reason: collision with root package name */
    public int f35693f;

    /* renamed from: g, reason: collision with root package name */
    public ProtoBuf$Type f35694g;

    /* renamed from: h, reason: collision with root package name */
    public int f35695h;

    /* renamed from: i, reason: collision with root package name */
    public ProtoBuf$Type f35696i;

    /* renamed from: j, reason: collision with root package name */
    public int f35697j;

    /* renamed from: k, reason: collision with root package name */
    public List<ProtoBuf$Annotation> f35698k;

    /* renamed from: l, reason: collision with root package name */
    public ProtoBuf$Annotation.Argument.Value f35699l;

    /* renamed from: m, reason: collision with root package name */
    public byte f35700m;

    /* renamed from: n, reason: collision with root package name */
    public int f35701n;

    public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ProtoBuf$ValueParameter> {
        @Override // ia.InterfaceC4188h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$ValueParameter c(c cVar, d dVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$ValueParameter(cVar, dVar);
        }
    }

    public static final class b extends GeneratedMessageLite.c<ProtoBuf$ValueParameter, b> implements InterfaceC4187g {

        /* renamed from: d, reason: collision with root package name */
        public int f35702d;

        /* renamed from: e, reason: collision with root package name */
        public int f35703e;

        /* renamed from: f, reason: collision with root package name */
        public int f35704f;

        /* renamed from: h, reason: collision with root package name */
        public int f35706h;

        /* renamed from: j, reason: collision with root package name */
        public int f35708j;

        /* renamed from: g, reason: collision with root package name */
        public ProtoBuf$Type f35705g = ProtoBuf$Type.X();

        /* renamed from: i, reason: collision with root package name */
        public ProtoBuf$Type f35707i = ProtoBuf$Type.X();

        /* renamed from: k, reason: collision with root package name */
        public List<ProtoBuf$Annotation> f35709k = Collections.EMPTY_LIST;

        /* renamed from: l, reason: collision with root package name */
        public ProtoBuf$Annotation.Argument.Value f35710l = ProtoBuf$Annotation.Argument.Value.L();

        public b() {
            w();
        }

        public static b u() {
            return new b();
        }

        private void v() {
            if ((this.f35702d & 64) != 64) {
                this.f35709k = new ArrayList(this.f35709k);
                this.f35702d |= 64;
            }
        }

        private void w() {
        }

        public b B(ProtoBuf$Type protoBuf$Type) {
            if ((this.f35702d & 4) != 4 || this.f35705g == ProtoBuf$Type.X()) {
                this.f35705g = protoBuf$Type;
            } else {
                this.f35705g = ProtoBuf$Type.y0(this.f35705g).i(protoBuf$Type).s();
            }
            this.f35702d |= 4;
            return this;
        }

        public b C(ProtoBuf$Type protoBuf$Type) {
            if ((this.f35702d & 16) != 16 || this.f35707i == ProtoBuf$Type.X()) {
                this.f35707i = protoBuf$Type;
            } else {
                this.f35707i = ProtoBuf$Type.y0(this.f35707i).i(protoBuf$Type).s();
            }
            this.f35702d |= 16;
            return this;
        }

        public b D(int i10) {
            this.f35702d |= 1;
            this.f35703e = i10;
            return this;
        }

        public b E(int i10) {
            this.f35702d |= 2;
            this.f35704f = i10;
            return this;
        }

        public b F(int i10) {
            this.f35702d |= 8;
            this.f35706h = i10;
            return this;
        }

        public b H(int i10) {
            this.f35702d |= 32;
            this.f35708j = i10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$ValueParameter build() {
            ProtoBuf$ValueParameter protoBuf$ValueParameterS = s();
            if (protoBuf$ValueParameterS.isInitialized()) {
                return protoBuf$ValueParameterS;
            }
            throw a.AbstractC0449a.f(protoBuf$ValueParameterS);
        }

        public ProtoBuf$ValueParameter s() {
            ProtoBuf$ValueParameter protoBuf$ValueParameter = new ProtoBuf$ValueParameter(this);
            int i10 = this.f35702d;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            protoBuf$ValueParameter.f35692e = this.f35703e;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            protoBuf$ValueParameter.f35693f = this.f35704f;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            protoBuf$ValueParameter.f35694g = this.f35705g;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            protoBuf$ValueParameter.f35695h = this.f35706h;
            if ((i10 & 16) == 16) {
                i11 |= 16;
            }
            protoBuf$ValueParameter.f35696i = this.f35707i;
            if ((i10 & 32) == 32) {
                i11 |= 32;
            }
            protoBuf$ValueParameter.f35697j = this.f35708j;
            if ((this.f35702d & 64) == 64) {
                this.f35709k = Collections.unmodifiableList(this.f35709k);
                this.f35702d &= -65;
            }
            protoBuf$ValueParameter.f35698k = this.f35709k;
            if ((i10 & 128) == 128) {
                i11 |= 64;
            }
            protoBuf$ValueParameter.f35699l = this.f35710l;
            protoBuf$ValueParameter.f35691d = i11;
            return protoBuf$ValueParameter;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public b g() {
            return u().i(s());
        }

        public b x(ProtoBuf$Annotation.Argument.Value value) {
            if ((this.f35702d & 128) != 128 || this.f35710l == ProtoBuf$Annotation.Argument.Value.L()) {
                this.f35710l = value;
            } else {
                this.f35710l = ProtoBuf$Annotation.Argument.Value.f0(this.f35710l).i(value).o();
            }
            this.f35702d |= 128;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public b i(ProtoBuf$ValueParameter protoBuf$ValueParameter) {
            if (protoBuf$ValueParameter == ProtoBuf$ValueParameter.P()) {
                return this;
            }
            if (protoBuf$ValueParameter.Y()) {
                D(protoBuf$ValueParameter.R());
            }
            if (protoBuf$ValueParameter.Z()) {
                E(protoBuf$ValueParameter.S());
            }
            if (protoBuf$ValueParameter.a0()) {
                B(protoBuf$ValueParameter.T());
            }
            if (protoBuf$ValueParameter.b0()) {
                F(protoBuf$ValueParameter.U());
            }
            if (protoBuf$ValueParameter.c0()) {
                C(protoBuf$ValueParameter.V());
            }
            if (protoBuf$ValueParameter.d0()) {
                H(protoBuf$ValueParameter.W());
            }
            if (!protoBuf$ValueParameter.f35698k.isEmpty()) {
                if (this.f35709k.isEmpty()) {
                    this.f35709k = protoBuf$ValueParameter.f35698k;
                    this.f35702d &= -65;
                } else {
                    v();
                    this.f35709k.addAll(protoBuf$ValueParameter.f35698k);
                }
            }
            if (protoBuf$ValueParameter.X()) {
                x(protoBuf$ValueParameter.O());
            }
            p(protoBuf$ValueParameter);
            j(h().c(protoBuf$ValueParameter.f35690c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter.f35689p     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter$b");
        }
    }

    static {
        ProtoBuf$ValueParameter protoBuf$ValueParameter = new ProtoBuf$ValueParameter(true);
        f35688o = protoBuf$ValueParameter;
        protoBuf$ValueParameter.e0();
    }

    public static ProtoBuf$ValueParameter P() {
        return f35688o;
    }

    private void e0() {
        this.f35692e = 0;
        this.f35693f = 0;
        this.f35694g = ProtoBuf$Type.X();
        this.f35695h = 0;
        this.f35696i = ProtoBuf$Type.X();
        this.f35697j = 0;
        this.f35698k = Collections.EMPTY_LIST;
        this.f35699l = ProtoBuf$Annotation.Argument.Value.L();
    }

    public static b f0() {
        return b.u();
    }

    public static b g0(ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        return f0().i(protoBuf$ValueParameter);
    }

    public ProtoBuf$Annotation L(int i10) {
        return this.f35698k.get(i10);
    }

    public int M() {
        return this.f35698k.size();
    }

    public List<ProtoBuf$Annotation> N() {
        return this.f35698k;
    }

    public ProtoBuf$Annotation.Argument.Value O() {
        return this.f35699l;
    }

    @Override // ia.InterfaceC4187g
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public ProtoBuf$ValueParameter getDefaultInstanceForType() {
        return f35688o;
    }

    public int R() {
        return this.f35692e;
    }

    public int S() {
        return this.f35693f;
    }

    public ProtoBuf$Type T() {
        return this.f35694g;
    }

    public int U() {
        return this.f35695h;
    }

    public ProtoBuf$Type V() {
        return this.f35696i;
    }

    public int W() {
        return this.f35697j;
    }

    public boolean X() {
        return (this.f35691d & 64) == 64;
    }

    public boolean Y() {
        return (this.f35691d & 1) == 1;
    }

    public boolean Z() {
        return (this.f35691d & 2) == 2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.a aVarW = w();
        if ((this.f35691d & 1) == 1) {
            codedOutputStream.a0(1, this.f35692e);
        }
        if ((this.f35691d & 2) == 2) {
            codedOutputStream.a0(2, this.f35693f);
        }
        if ((this.f35691d & 4) == 4) {
            codedOutputStream.d0(3, this.f35694g);
        }
        if ((this.f35691d & 16) == 16) {
            codedOutputStream.d0(4, this.f35696i);
        }
        if ((this.f35691d & 8) == 8) {
            codedOutputStream.a0(5, this.f35695h);
        }
        if ((this.f35691d & 32) == 32) {
            codedOutputStream.a0(6, this.f35697j);
        }
        for (int i10 = 0; i10 < this.f35698k.size(); i10++) {
            codedOutputStream.d0(7, this.f35698k.get(i10));
        }
        if ((this.f35691d & 64) == 64) {
            codedOutputStream.d0(8, this.f35699l);
        }
        aVarW.a(200, codedOutputStream);
        codedOutputStream.i0(this.f35690c);
    }

    public boolean a0() {
        return (this.f35691d & 4) == 4;
    }

    public boolean b0() {
        return (this.f35691d & 8) == 8;
    }

    public boolean c0() {
        return (this.f35691d & 16) == 16;
    }

    public boolean d0() {
        return (this.f35691d & 32) == 32;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
    public InterfaceC4188h<ProtoBuf$ValueParameter> getParserForType() {
        return f35689p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i10 = this.f35701n;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f35691d & 1) == 1 ? CodedOutputStream.o(1, this.f35692e) : 0;
        if ((this.f35691d & 2) == 2) {
            iO += CodedOutputStream.o(2, this.f35693f);
        }
        if ((this.f35691d & 4) == 4) {
            iO += CodedOutputStream.s(3, this.f35694g);
        }
        if ((this.f35691d & 16) == 16) {
            iO += CodedOutputStream.s(4, this.f35696i);
        }
        if ((this.f35691d & 8) == 8) {
            iO += CodedOutputStream.o(5, this.f35695h);
        }
        if ((this.f35691d & 32) == 32) {
            iO += CodedOutputStream.o(6, this.f35697j);
        }
        for (int i11 = 0; i11 < this.f35698k.size(); i11++) {
            iO += CodedOutputStream.s(7, this.f35698k.get(i11));
        }
        if ((this.f35691d & 64) == 64) {
            iO += CodedOutputStream.s(8, this.f35699l);
        }
        int iQ = iO + q() + this.f35690c.size();
        this.f35701n = iQ;
        return iQ;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return f0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return g0(this);
    }

    @Override // ia.InterfaceC4187g
    public final boolean isInitialized() {
        byte b10 = this.f35700m;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!Z()) {
            this.f35700m = (byte) 0;
            return false;
        }
        if (a0() && !T().isInitialized()) {
            this.f35700m = (byte) 0;
            return false;
        }
        if (c0() && !V().isInitialized()) {
            this.f35700m = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < M(); i10++) {
            if (!L(i10).isInitialized()) {
                this.f35700m = (byte) 0;
                return false;
            }
        }
        if (X() && !O().isInitialized()) {
            this.f35700m = (byte) 0;
            return false;
        }
        if (n()) {
            this.f35700m = (byte) 1;
            return true;
        }
        this.f35700m = (byte) 0;
        return false;
    }

    public ProtoBuf$ValueParameter(GeneratedMessageLite.c<ProtoBuf$ValueParameter, ?> cVar) {
        super(cVar);
        this.f35700m = (byte) -1;
        this.f35701n = -1;
        this.f35690c = cVar.h();
    }

    public ProtoBuf$ValueParameter(boolean z10) {
        this.f35700m = (byte) -1;
        this.f35701n = -1;
        this.f35690c = AbstractC4182b.f33086a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBuf$ValueParameter(c cVar, d dVar) throws InvalidProtocolBufferException {
        this.f35700m = (byte) -1;
        this.f35701n = -1;
        e0();
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
                            this.f35691d |= 1;
                            this.f35692e = cVar.s();
                        } else if (iK != 16) {
                            if (iK == 26) {
                                ProtoBuf$Type.b builder = (this.f35691d & 4) == 4 ? this.f35694g.toBuilder() : null;
                                ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) cVar.u(ProtoBuf$Type.f35583v, dVar);
                                this.f35694g = protoBuf$Type;
                                if (builder != null) {
                                    builder.i(protoBuf$Type);
                                    this.f35694g = builder.s();
                                }
                                this.f35691d |= 4;
                            } else if (iK == 34) {
                                ProtoBuf$Type.b builder2 = (this.f35691d & 16) == 16 ? this.f35696i.toBuilder() : null;
                                ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) cVar.u(ProtoBuf$Type.f35583v, dVar);
                                this.f35696i = protoBuf$Type2;
                                if (builder2 != null) {
                                    builder2.i(protoBuf$Type2);
                                    this.f35696i = builder2.s();
                                }
                                this.f35691d |= 16;
                            } else if (iK == 40) {
                                this.f35691d |= 8;
                                this.f35695h = cVar.s();
                            } else if (iK == 48) {
                                this.f35691d |= 32;
                                this.f35697j = cVar.s();
                            } else if (iK == 58) {
                                int i10 = (c10 == true ? 1 : 0) & '@';
                                c10 = c10;
                                if (i10 != 64) {
                                    this.f35698k = new ArrayList();
                                    c10 = '@';
                                }
                                this.f35698k.add(cVar.u(ProtoBuf$Annotation.f35233i, dVar));
                            } else if (iK != 66) {
                                if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                                }
                            } else {
                                ProtoBuf$Annotation.Argument.Value.b builder3 = (this.f35691d & 64) == 64 ? this.f35699l.toBuilder() : null;
                                ProtoBuf$Annotation.Argument.Value value = (ProtoBuf$Annotation.Argument.Value) cVar.u(ProtoBuf$Annotation.Argument.Value.f35249r, dVar);
                                this.f35699l = value;
                                if (builder3 != null) {
                                    builder3.i(value);
                                    this.f35699l = builder3.o();
                                }
                                this.f35691d |= 64;
                            }
                        } else {
                            this.f35691d |= 2;
                            this.f35693f = cVar.s();
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if (((c10 == true ? 1 : 0) & '@') == 64) {
                        this.f35698k = Collections.unmodifiableList(this.f35698k);
                    }
                    try {
                        codedOutputStreamJ.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f35690c = c0409bT.l();
                        throw th2;
                    }
                    this.f35690c = c0409bT.l();
                    g();
                    throw th;
                }
            } catch (InvalidProtocolBufferException e10) {
                throw e10.i(this);
            } catch (IOException e11) {
                throw new InvalidProtocolBufferException(e11.getMessage()).i(this);
            }
        }
        if (((c10 == true ? 1 : 0) & '@') == 64) {
            this.f35698k = Collections.unmodifiableList(this.f35698k);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f35690c = c0409bT.l();
            throw th3;
        }
        this.f35690c = c0409bT.l();
        g();
    }
}
