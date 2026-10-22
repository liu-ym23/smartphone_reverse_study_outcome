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
public final class ProtoBuf$TypeParameter extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$TypeParameter> implements InterfaceC4187g {

    /* renamed from: n, reason: collision with root package name */
    public static final ProtoBuf$TypeParameter f35657n;

    /* renamed from: o, reason: collision with root package name */
    public static InterfaceC4188h<ProtoBuf$TypeParameter> f35658o = new a();

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC4182b f35659c;

    /* renamed from: d, reason: collision with root package name */
    public int f35660d;

    /* renamed from: e, reason: collision with root package name */
    public int f35661e;

    /* renamed from: f, reason: collision with root package name */
    public int f35662f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f35663g;

    /* renamed from: h, reason: collision with root package name */
    public Variance f35664h;

    /* renamed from: i, reason: collision with root package name */
    public List<ProtoBuf$Type> f35665i;

    /* renamed from: j, reason: collision with root package name */
    public List<Integer> f35666j;

    /* renamed from: k, reason: collision with root package name */
    public int f35667k;

    /* renamed from: l, reason: collision with root package name */
    public byte f35668l;

    /* renamed from: m, reason: collision with root package name */
    public int f35669m;

    public enum Variance implements f.a {
        IN(0, 0),
        OUT(1, 1),
        INV(2, 2);

        private static f.b<Variance> internalValueMap = new a();
        private final int value;

        public static class a implements f.b<Variance> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Variance findValueByNumber(int i10) {
                return Variance.valueOf(i10);
            }
        }

        Variance(int i10, int i11) {
            this.value = i11;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.a
        public final int getNumber() {
            return this.value;
        }

        public static Variance valueOf(int i10) {
            if (i10 == 0) {
                return IN;
            }
            if (i10 == 1) {
                return OUT;
            }
            if (i10 != 2) {
                return null;
            }
            return INV;
        }
    }

    public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ProtoBuf$TypeParameter> {
        @Override // ia.InterfaceC4188h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$TypeParameter c(c cVar, d dVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$TypeParameter(cVar, dVar);
        }
    }

    public static final class b extends GeneratedMessageLite.c<ProtoBuf$TypeParameter, b> implements InterfaceC4187g {

        /* renamed from: d, reason: collision with root package name */
        public int f35670d;

        /* renamed from: e, reason: collision with root package name */
        public int f35671e;

        /* renamed from: f, reason: collision with root package name */
        public int f35672f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f35673g;

        /* renamed from: h, reason: collision with root package name */
        public Variance f35674h = Variance.INV;

        /* renamed from: i, reason: collision with root package name */
        public List<ProtoBuf$Type> f35675i;

        /* renamed from: j, reason: collision with root package name */
        public List<Integer> f35676j;

        public b() {
            List list = Collections.EMPTY_LIST;
            this.f35675i = list;
            this.f35676j = list;
            x();
        }

        public static b u() {
            return new b();
        }

        private void x() {
        }

        public b B(int i10) {
            this.f35670d |= 1;
            this.f35671e = i10;
            return this;
        }

        public b C(int i10) {
            this.f35670d |= 2;
            this.f35672f = i10;
            return this;
        }

        public b D(boolean z10) {
            this.f35670d |= 4;
            this.f35673g = z10;
            return this;
        }

        public b E(Variance variance) {
            variance.getClass();
            this.f35670d |= 8;
            this.f35674h = variance;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$TypeParameter build() {
            ProtoBuf$TypeParameter protoBuf$TypeParameterS = s();
            if (protoBuf$TypeParameterS.isInitialized()) {
                return protoBuf$TypeParameterS;
            }
            throw a.AbstractC0449a.f(protoBuf$TypeParameterS);
        }

        public ProtoBuf$TypeParameter s() {
            ProtoBuf$TypeParameter protoBuf$TypeParameter = new ProtoBuf$TypeParameter(this);
            int i10 = this.f35670d;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            protoBuf$TypeParameter.f35661e = this.f35671e;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            protoBuf$TypeParameter.f35662f = this.f35672f;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            protoBuf$TypeParameter.f35663g = this.f35673g;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            protoBuf$TypeParameter.f35664h = this.f35674h;
            if ((this.f35670d & 16) == 16) {
                this.f35675i = Collections.unmodifiableList(this.f35675i);
                this.f35670d &= -17;
            }
            protoBuf$TypeParameter.f35665i = this.f35675i;
            if ((this.f35670d & 32) == 32) {
                this.f35676j = Collections.unmodifiableList(this.f35676j);
                this.f35670d &= -33;
            }
            protoBuf$TypeParameter.f35666j = this.f35676j;
            protoBuf$TypeParameter.f35660d = i11;
            return protoBuf$TypeParameter;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public b g() {
            return u().i(s());
        }

        public final void v() {
            if ((this.f35670d & 32) != 32) {
                this.f35676j = new ArrayList(this.f35676j);
                this.f35670d |= 32;
            }
        }

        public final void w() {
            if ((this.f35670d & 16) != 16) {
                this.f35675i = new ArrayList(this.f35675i);
                this.f35670d |= 16;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public b i(ProtoBuf$TypeParameter protoBuf$TypeParameter) {
            if (protoBuf$TypeParameter == ProtoBuf$TypeParameter.K()) {
                return this;
            }
            if (protoBuf$TypeParameter.U()) {
                B(protoBuf$TypeParameter.M());
            }
            if (protoBuf$TypeParameter.V()) {
                C(protoBuf$TypeParameter.N());
            }
            if (protoBuf$TypeParameter.W()) {
                D(protoBuf$TypeParameter.O());
            }
            if (protoBuf$TypeParameter.X()) {
                E(protoBuf$TypeParameter.T());
            }
            if (!protoBuf$TypeParameter.f35665i.isEmpty()) {
                if (this.f35675i.isEmpty()) {
                    this.f35675i = protoBuf$TypeParameter.f35665i;
                    this.f35670d &= -17;
                } else {
                    w();
                    this.f35675i.addAll(protoBuf$TypeParameter.f35665i);
                }
            }
            if (!protoBuf$TypeParameter.f35666j.isEmpty()) {
                if (this.f35676j.isEmpty()) {
                    this.f35676j = protoBuf$TypeParameter.f35666j;
                    this.f35670d &= -33;
                } else {
                    v();
                    this.f35676j.addAll(protoBuf$TypeParameter.f35666j);
                }
            }
            p(protoBuf$TypeParameter);
            j(h().c(protoBuf$TypeParameter.f35659c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter.f35658o     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter$b");
        }
    }

    static {
        ProtoBuf$TypeParameter protoBuf$TypeParameter = new ProtoBuf$TypeParameter(true);
        f35657n = protoBuf$TypeParameter;
        protoBuf$TypeParameter.Y();
    }

    public static ProtoBuf$TypeParameter K() {
        return f35657n;
    }

    private void Y() {
        this.f35661e = 0;
        this.f35662f = 0;
        this.f35663g = false;
        this.f35664h = Variance.INV;
        List list = Collections.EMPTY_LIST;
        this.f35665i = list;
        this.f35666j = list;
    }

    public static b Z() {
        return b.u();
    }

    public static b a0(ProtoBuf$TypeParameter protoBuf$TypeParameter) {
        return Z().i(protoBuf$TypeParameter);
    }

    @Override // ia.InterfaceC4187g
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public ProtoBuf$TypeParameter getDefaultInstanceForType() {
        return f35657n;
    }

    public int M() {
        return this.f35661e;
    }

    public int N() {
        return this.f35662f;
    }

    public boolean O() {
        return this.f35663g;
    }

    public ProtoBuf$Type P(int i10) {
        return this.f35665i.get(i10);
    }

    public int Q() {
        return this.f35665i.size();
    }

    public List<Integer> R() {
        return this.f35666j;
    }

    public List<ProtoBuf$Type> S() {
        return this.f35665i;
    }

    public Variance T() {
        return this.f35664h;
    }

    public boolean U() {
        return (this.f35660d & 1) == 1;
    }

    public boolean V() {
        return (this.f35660d & 2) == 2;
    }

    public boolean W() {
        return (this.f35660d & 4) == 4;
    }

    public boolean X() {
        return (this.f35660d & 8) == 8;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.a aVarW = w();
        if ((this.f35660d & 1) == 1) {
            codedOutputStream.a0(1, this.f35661e);
        }
        if ((this.f35660d & 2) == 2) {
            codedOutputStream.a0(2, this.f35662f);
        }
        if ((this.f35660d & 4) == 4) {
            codedOutputStream.L(3, this.f35663g);
        }
        if ((this.f35660d & 8) == 8) {
            codedOutputStream.S(4, this.f35664h.getNumber());
        }
        for (int i10 = 0; i10 < this.f35665i.size(); i10++) {
            codedOutputStream.d0(5, this.f35665i.get(i10));
        }
        if (R().size() > 0) {
            codedOutputStream.o0(50);
            codedOutputStream.o0(this.f35667k);
        }
        for (int i11 = 0; i11 < this.f35666j.size(); i11++) {
            codedOutputStream.b0(this.f35666j.get(i11).intValue());
        }
        aVarW.a(1000, codedOutputStream);
        codedOutputStream.i0(this.f35659c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return Z();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return a0(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
    public InterfaceC4188h<ProtoBuf$TypeParameter> getParserForType() {
        return f35658o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i10 = this.f35669m;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f35660d & 1) == 1 ? CodedOutputStream.o(1, this.f35661e) : 0;
        if ((this.f35660d & 2) == 2) {
            iO += CodedOutputStream.o(2, this.f35662f);
        }
        if ((this.f35660d & 4) == 4) {
            iO += CodedOutputStream.a(3, this.f35663g);
        }
        if ((this.f35660d & 8) == 8) {
            iO += CodedOutputStream.h(4, this.f35664h.getNumber());
        }
        for (int i11 = 0; i11 < this.f35665i.size(); i11++) {
            iO += CodedOutputStream.s(5, this.f35665i.get(i11));
        }
        int iP = 0;
        for (int i12 = 0; i12 < this.f35666j.size(); i12++) {
            iP += CodedOutputStream.p(this.f35666j.get(i12).intValue());
        }
        int iP2 = iO + iP;
        if (!R().isEmpty()) {
            iP2 = iP2 + 1 + CodedOutputStream.p(iP);
        }
        this.f35667k = iP;
        int iQ = iP2 + q() + this.f35659c.size();
        this.f35669m = iQ;
        return iQ;
    }

    @Override // ia.InterfaceC4187g
    public final boolean isInitialized() {
        byte b10 = this.f35668l;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!U()) {
            this.f35668l = (byte) 0;
            return false;
        }
        if (!V()) {
            this.f35668l = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < Q(); i10++) {
            if (!P(i10).isInitialized()) {
                this.f35668l = (byte) 0;
                return false;
            }
        }
        if (n()) {
            this.f35668l = (byte) 1;
            return true;
        }
        this.f35668l = (byte) 0;
        return false;
    }

    public ProtoBuf$TypeParameter(GeneratedMessageLite.c<ProtoBuf$TypeParameter, ?> cVar) {
        super(cVar);
        this.f35667k = -1;
        this.f35668l = (byte) -1;
        this.f35669m = -1;
        this.f35659c = cVar.h();
    }

    public ProtoBuf$TypeParameter(boolean z10) {
        this.f35667k = -1;
        this.f35668l = (byte) -1;
        this.f35669m = -1;
        this.f35659c = AbstractC4182b.f33086a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBuf$TypeParameter(c cVar, d dVar) throws InvalidProtocolBufferException {
        this.f35667k = -1;
        this.f35668l = (byte) -1;
        this.f35669m = -1;
        Y();
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
                            this.f35660d |= 1;
                            this.f35661e = cVar.s();
                        } else if (iK == 16) {
                            this.f35660d |= 2;
                            this.f35662f = cVar.s();
                        } else if (iK == 24) {
                            this.f35660d |= 4;
                            this.f35663g = cVar.k();
                        } else if (iK == 32) {
                            int iN = cVar.n();
                            Variance varianceValueOf = Variance.valueOf(iN);
                            if (varianceValueOf == null) {
                                codedOutputStreamJ.o0(iK);
                                codedOutputStreamJ.o0(iN);
                            } else {
                                this.f35660d |= 8;
                                this.f35664h = varianceValueOf;
                            }
                        } else if (iK == 42) {
                            if ((i10 & 16) != 16) {
                                this.f35665i = new ArrayList();
                                i10 |= 16;
                            }
                            this.f35665i.add(cVar.u(ProtoBuf$Type.f35583v, dVar));
                        } else if (iK == 48) {
                            if ((i10 & 32) != 32) {
                                this.f35666j = new ArrayList();
                                i10 |= 32;
                            }
                            this.f35666j.add(Integer.valueOf(cVar.s()));
                        } else if (iK != 50) {
                            if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                            }
                        } else {
                            int iJ = cVar.j(cVar.A());
                            if ((i10 & 32) != 32 && cVar.e() > 0) {
                                this.f35666j = new ArrayList();
                                i10 |= 32;
                            }
                            while (cVar.e() > 0) {
                                this.f35666j.add(Integer.valueOf(cVar.s()));
                            }
                            cVar.i(iJ);
                        }
                    }
                    z10 = true;
                } catch (InvalidProtocolBufferException e10) {
                    throw e10.i(this);
                } catch (IOException e11) {
                    throw new InvalidProtocolBufferException(e11.getMessage()).i(this);
                }
            } catch (Throwable th) {
                if ((i10 & 16) == 16) {
                    this.f35665i = Collections.unmodifiableList(this.f35665i);
                }
                if ((i10 & 32) == 32) {
                    this.f35666j = Collections.unmodifiableList(this.f35666j);
                }
                try {
                    codedOutputStreamJ.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f35659c = c0409bT.l();
                    throw th2;
                }
                this.f35659c = c0409bT.l();
                g();
                throw th;
            }
        }
        if ((i10 & 16) == 16) {
            this.f35665i = Collections.unmodifiableList(this.f35665i);
        }
        if ((i10 & 32) == 32) {
            this.f35666j = Collections.unmodifiableList(this.f35666j);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f35659c = c0409bT.l();
            throw th3;
        }
        this.f35659c = c0409bT.l();
        g();
    }
}
