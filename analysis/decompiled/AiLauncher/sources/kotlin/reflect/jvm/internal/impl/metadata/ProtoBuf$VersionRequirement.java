package kotlin.reflect.jvm.internal.impl.metadata;

import ia.AbstractC4182b;
import ia.InterfaceC4187g;
import ia.InterfaceC4188h;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.c;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.f;

/* loaded from: classes5.dex */
public final class ProtoBuf$VersionRequirement extends GeneratedMessageLite implements InterfaceC4187g {

    /* renamed from: l, reason: collision with root package name */
    public static final ProtoBuf$VersionRequirement f35711l;

    /* renamed from: m, reason: collision with root package name */
    public static InterfaceC4188h<ProtoBuf$VersionRequirement> f35712m = new a();

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC4182b f35713b;

    /* renamed from: c, reason: collision with root package name */
    public int f35714c;

    /* renamed from: d, reason: collision with root package name */
    public int f35715d;

    /* renamed from: e, reason: collision with root package name */
    public int f35716e;

    /* renamed from: f, reason: collision with root package name */
    public Level f35717f;

    /* renamed from: g, reason: collision with root package name */
    public int f35718g;

    /* renamed from: h, reason: collision with root package name */
    public int f35719h;

    /* renamed from: i, reason: collision with root package name */
    public VersionKind f35720i;

    /* renamed from: j, reason: collision with root package name */
    public byte f35721j;

    /* renamed from: k, reason: collision with root package name */
    public int f35722k;

    public enum Level implements f.a {
        WARNING(0, 0),
        ERROR(1, 1),
        HIDDEN(2, 2);

        private static f.b<Level> internalValueMap = new a();
        private final int value;

        public static class a implements f.b<Level> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Level findValueByNumber(int i10) {
                return Level.valueOf(i10);
            }
        }

        Level(int i10, int i11) {
            this.value = i11;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.a
        public final int getNumber() {
            return this.value;
        }

        public static Level valueOf(int i10) {
            if (i10 == 0) {
                return WARNING;
            }
            if (i10 == 1) {
                return ERROR;
            }
            if (i10 != 2) {
                return null;
            }
            return HIDDEN;
        }
    }

    public enum VersionKind implements f.a {
        LANGUAGE_VERSION(0, 0),
        COMPILER_VERSION(1, 1),
        API_VERSION(2, 2);

        private static f.b<VersionKind> internalValueMap = new a();
        private final int value;

        public static class a implements f.b<VersionKind> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public VersionKind findValueByNumber(int i10) {
                return VersionKind.valueOf(i10);
            }
        }

        VersionKind(int i10, int i11) {
            this.value = i11;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.a
        public final int getNumber() {
            return this.value;
        }

        public static VersionKind valueOf(int i10) {
            if (i10 == 0) {
                return LANGUAGE_VERSION;
            }
            if (i10 == 1) {
                return COMPILER_VERSION;
            }
            if (i10 != 2) {
                return null;
            }
            return API_VERSION;
        }
    }

    public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ProtoBuf$VersionRequirement> {
        @Override // ia.InterfaceC4188h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$VersionRequirement c(c cVar, d dVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$VersionRequirement(cVar, dVar);
        }
    }

    public static final class b extends GeneratedMessageLite.b<ProtoBuf$VersionRequirement, b> implements InterfaceC4187g {

        /* renamed from: b, reason: collision with root package name */
        public int f35723b;

        /* renamed from: c, reason: collision with root package name */
        public int f35724c;

        /* renamed from: d, reason: collision with root package name */
        public int f35725d;

        /* renamed from: f, reason: collision with root package name */
        public int f35727f;

        /* renamed from: g, reason: collision with root package name */
        public int f35728g;

        /* renamed from: e, reason: collision with root package name */
        public Level f35726e = Level.ERROR;

        /* renamed from: h, reason: collision with root package name */
        public VersionKind f35729h = VersionKind.LANGUAGE_VERSION;

        public b() {
            r();
        }

        public static b q() {
            return new b();
        }

        private void r() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$VersionRequirement build() {
            ProtoBuf$VersionRequirement protoBuf$VersionRequirementO = o();
            if (protoBuf$VersionRequirementO.isInitialized()) {
                return protoBuf$VersionRequirementO;
            }
            throw a.AbstractC0449a.f(protoBuf$VersionRequirementO);
        }

        public ProtoBuf$VersionRequirement o() {
            ProtoBuf$VersionRequirement protoBuf$VersionRequirement = new ProtoBuf$VersionRequirement(this);
            int i10 = this.f35723b;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            protoBuf$VersionRequirement.f35715d = this.f35724c;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            protoBuf$VersionRequirement.f35716e = this.f35725d;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            protoBuf$VersionRequirement.f35717f = this.f35726e;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            protoBuf$VersionRequirement.f35718g = this.f35727f;
            if ((i10 & 16) == 16) {
                i11 |= 16;
            }
            protoBuf$VersionRequirement.f35719h = this.f35728g;
            if ((i10 & 32) == 32) {
                i11 |= 32;
            }
            protoBuf$VersionRequirement.f35720i = this.f35729h;
            protoBuf$VersionRequirement.f35714c = i11;
            return protoBuf$VersionRequirement;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b g() {
            return q().i(o());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public b i(ProtoBuf$VersionRequirement protoBuf$VersionRequirement) {
            if (protoBuf$VersionRequirement == ProtoBuf$VersionRequirement.x()) {
                return this;
            }
            if (protoBuf$VersionRequirement.J()) {
                x(protoBuf$VersionRequirement.C());
            }
            if (protoBuf$VersionRequirement.K()) {
                y(protoBuf$VersionRequirement.D());
            }
            if (protoBuf$VersionRequirement.G()) {
                v(protoBuf$VersionRequirement.z());
            }
            if (protoBuf$VersionRequirement.F()) {
                u(protoBuf$VersionRequirement.y());
            }
            if (protoBuf$VersionRequirement.H()) {
                w(protoBuf$VersionRequirement.A());
            }
            if (protoBuf$VersionRequirement.L()) {
                z(protoBuf$VersionRequirement.E());
            }
            j(h().c(protoBuf$VersionRequirement.f35713b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement.f35712m     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement$b");
        }

        public b u(int i10) {
            this.f35723b |= 8;
            this.f35727f = i10;
            return this;
        }

        public b v(Level level) {
            level.getClass();
            this.f35723b |= 4;
            this.f35726e = level;
            return this;
        }

        public b w(int i10) {
            this.f35723b |= 16;
            this.f35728g = i10;
            return this;
        }

        public b x(int i10) {
            this.f35723b |= 1;
            this.f35724c = i10;
            return this;
        }

        public b y(int i10) {
            this.f35723b |= 2;
            this.f35725d = i10;
            return this;
        }

        public b z(VersionKind versionKind) {
            versionKind.getClass();
            this.f35723b |= 32;
            this.f35729h = versionKind;
            return this;
        }
    }

    static {
        ProtoBuf$VersionRequirement protoBuf$VersionRequirement = new ProtoBuf$VersionRequirement(true);
        f35711l = protoBuf$VersionRequirement;
        protoBuf$VersionRequirement.M();
    }

    private void M() {
        this.f35715d = 0;
        this.f35716e = 0;
        this.f35717f = Level.ERROR;
        this.f35718g = 0;
        this.f35719h = 0;
        this.f35720i = VersionKind.LANGUAGE_VERSION;
    }

    public static b N() {
        return b.q();
    }

    public static b O(ProtoBuf$VersionRequirement protoBuf$VersionRequirement) {
        return N().i(protoBuf$VersionRequirement);
    }

    public static ProtoBuf$VersionRequirement x() {
        return f35711l;
    }

    public int A() {
        return this.f35719h;
    }

    public int C() {
        return this.f35715d;
    }

    public int D() {
        return this.f35716e;
    }

    public VersionKind E() {
        return this.f35720i;
    }

    public boolean F() {
        return (this.f35714c & 8) == 8;
    }

    public boolean G() {
        return (this.f35714c & 4) == 4;
    }

    public boolean H() {
        return (this.f35714c & 16) == 16;
    }

    public boolean J() {
        return (this.f35714c & 1) == 1;
    }

    public boolean K() {
        return (this.f35714c & 2) == 2;
    }

    public boolean L() {
        return (this.f35714c & 32) == 32;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return N();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return O(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f35714c & 1) == 1) {
            codedOutputStream.a0(1, this.f35715d);
        }
        if ((this.f35714c & 2) == 2) {
            codedOutputStream.a0(2, this.f35716e);
        }
        if ((this.f35714c & 4) == 4) {
            codedOutputStream.S(3, this.f35717f.getNumber());
        }
        if ((this.f35714c & 8) == 8) {
            codedOutputStream.a0(4, this.f35718g);
        }
        if ((this.f35714c & 16) == 16) {
            codedOutputStream.a0(5, this.f35719h);
        }
        if ((this.f35714c & 32) == 32) {
            codedOutputStream.S(6, this.f35720i.getNumber());
        }
        codedOutputStream.i0(this.f35713b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
    public InterfaceC4188h<ProtoBuf$VersionRequirement> getParserForType() {
        return f35712m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i10 = this.f35722k;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f35714c & 1) == 1 ? CodedOutputStream.o(1, this.f35715d) : 0;
        if ((this.f35714c & 2) == 2) {
            iO += CodedOutputStream.o(2, this.f35716e);
        }
        if ((this.f35714c & 4) == 4) {
            iO += CodedOutputStream.h(3, this.f35717f.getNumber());
        }
        if ((this.f35714c & 8) == 8) {
            iO += CodedOutputStream.o(4, this.f35718g);
        }
        if ((this.f35714c & 16) == 16) {
            iO += CodedOutputStream.o(5, this.f35719h);
        }
        if ((this.f35714c & 32) == 32) {
            iO += CodedOutputStream.h(6, this.f35720i.getNumber());
        }
        int size = iO + this.f35713b.size();
        this.f35722k = size;
        return size;
    }

    @Override // ia.InterfaceC4187g
    public final boolean isInitialized() {
        byte b10 = this.f35721j;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        this.f35721j = (byte) 1;
        return true;
    }

    public int y() {
        return this.f35718g;
    }

    public Level z() {
        return this.f35717f;
    }

    public ProtoBuf$VersionRequirement(GeneratedMessageLite.b bVar) {
        super(bVar);
        this.f35721j = (byte) -1;
        this.f35722k = -1;
        this.f35713b = bVar.h();
    }

    public ProtoBuf$VersionRequirement(boolean z10) {
        this.f35721j = (byte) -1;
        this.f35722k = -1;
        this.f35713b = AbstractC4182b.f33086a;
    }

    public ProtoBuf$VersionRequirement(c cVar, d dVar) throws InvalidProtocolBufferException {
        this.f35721j = (byte) -1;
        this.f35722k = -1;
        M();
        AbstractC4182b.C0409b c0409bT = AbstractC4182b.t();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(c0409bT, 1);
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int iK = cVar.K();
                    if (iK != 0) {
                        if (iK == 8) {
                            this.f35714c |= 1;
                            this.f35715d = cVar.s();
                        } else if (iK == 16) {
                            this.f35714c |= 2;
                            this.f35716e = cVar.s();
                        } else if (iK == 24) {
                            int iN = cVar.n();
                            Level levelValueOf = Level.valueOf(iN);
                            if (levelValueOf == null) {
                                codedOutputStreamJ.o0(iK);
                                codedOutputStreamJ.o0(iN);
                            } else {
                                this.f35714c |= 4;
                                this.f35717f = levelValueOf;
                            }
                        } else if (iK == 32) {
                            this.f35714c |= 8;
                            this.f35718g = cVar.s();
                        } else if (iK == 40) {
                            this.f35714c |= 16;
                            this.f35719h = cVar.s();
                        } else if (iK != 48) {
                            if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                            }
                        } else {
                            int iN2 = cVar.n();
                            VersionKind versionKindValueOf = VersionKind.valueOf(iN2);
                            if (versionKindValueOf == null) {
                                codedOutputStreamJ.o0(iK);
                                codedOutputStreamJ.o0(iN2);
                            } else {
                                this.f35714c |= 32;
                                this.f35720i = versionKindValueOf;
                            }
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    try {
                        codedOutputStreamJ.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f35713b = c0409bT.l();
                        throw th2;
                    }
                    this.f35713b = c0409bT.l();
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
            this.f35713b = c0409bT.l();
            throw th3;
        }
        this.f35713b = c0409bT.l();
        g();
    }
}
