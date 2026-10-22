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
public final class ProtoBuf$QualifiedNameTable extends GeneratedMessageLite implements InterfaceC4187g {

    /* renamed from: f, reason: collision with root package name */
    public static final ProtoBuf$QualifiedNameTable f35553f;

    /* renamed from: g, reason: collision with root package name */
    public static InterfaceC4188h<ProtoBuf$QualifiedNameTable> f35554g = new a();

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC4182b f35555b;

    /* renamed from: c, reason: collision with root package name */
    public List<QualifiedName> f35556c;

    /* renamed from: d, reason: collision with root package name */
    public byte f35557d;

    /* renamed from: e, reason: collision with root package name */
    public int f35558e;

    public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ProtoBuf$QualifiedNameTable> {
        @Override // ia.InterfaceC4188h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$QualifiedNameTable c(c cVar, d dVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$QualifiedNameTable(cVar, dVar);
        }
    }

    public static final class b extends GeneratedMessageLite.b<ProtoBuf$QualifiedNameTable, b> implements InterfaceC4187g {

        /* renamed from: b, reason: collision with root package name */
        public int f35572b;

        /* renamed from: c, reason: collision with root package name */
        public List<QualifiedName> f35573c = Collections.EMPTY_LIST;

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
        public ProtoBuf$QualifiedNameTable build() {
            ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTableO = o();
            if (protoBuf$QualifiedNameTableO.isInitialized()) {
                return protoBuf$QualifiedNameTableO;
            }
            throw a.AbstractC0449a.f(protoBuf$QualifiedNameTableO);
        }

        public ProtoBuf$QualifiedNameTable o() {
            ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable = new ProtoBuf$QualifiedNameTable(this);
            if ((this.f35572b & 1) == 1) {
                this.f35573c = Collections.unmodifiableList(this.f35573c);
                this.f35572b &= -2;
            }
            protoBuf$QualifiedNameTable.f35556c = this.f35573c;
            return protoBuf$QualifiedNameTable;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b g() {
            return q().i(o());
        }

        public final void r() {
            if ((this.f35572b & 1) != 1) {
                this.f35573c = new ArrayList(this.f35573c);
                this.f35572b |= 1;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public b i(ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable) {
            if (protoBuf$QualifiedNameTable == ProtoBuf$QualifiedNameTable.s()) {
                return this;
            }
            if (!protoBuf$QualifiedNameTable.f35556c.isEmpty()) {
                if (this.f35573c.isEmpty()) {
                    this.f35573c = protoBuf$QualifiedNameTable.f35556c;
                    this.f35572b &= -2;
                } else {
                    r();
                    this.f35573c.addAll(protoBuf$QualifiedNameTable.f35556c);
                }
            }
            j(h().c(protoBuf$QualifiedNameTable.f35555b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable.f35554g     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$b");
        }
    }

    static {
        ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable = new ProtoBuf$QualifiedNameTable(true);
        f35553f = protoBuf$QualifiedNameTable;
        protoBuf$QualifiedNameTable.v();
    }

    public static ProtoBuf$QualifiedNameTable s() {
        return f35553f;
    }

    private void v() {
        this.f35556c = Collections.EMPTY_LIST;
    }

    public static b w() {
        return b.q();
    }

    public static b x(ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable) {
        return w().i(protoBuf$QualifiedNameTable);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        for (int i10 = 0; i10 < this.f35556c.size(); i10++) {
            codedOutputStream.d0(1, this.f35556c.get(i10));
        }
        codedOutputStream.i0(this.f35555b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
    public InterfaceC4188h<ProtoBuf$QualifiedNameTable> getParserForType() {
        return f35554g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i10 = this.f35558e;
        if (i10 != -1) {
            return i10;
        }
        int iS = 0;
        for (int i11 = 0; i11 < this.f35556c.size(); i11++) {
            iS += CodedOutputStream.s(1, this.f35556c.get(i11));
        }
        int size = iS + this.f35555b.size();
        this.f35558e = size;
        return size;
    }

    @Override // ia.InterfaceC4187g
    public final boolean isInitialized() {
        byte b10 = this.f35557d;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i10 = 0; i10 < u(); i10++) {
            if (!t(i10).isInitialized()) {
                this.f35557d = (byte) 0;
                return false;
            }
        }
        this.f35557d = (byte) 1;
        return true;
    }

    public QualifiedName t(int i10) {
        return this.f35556c.get(i10);
    }

    public int u() {
        return this.f35556c.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return w();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return x(this);
    }

    public static final class QualifiedName extends GeneratedMessageLite implements InterfaceC4187g {

        /* renamed from: i, reason: collision with root package name */
        public static final QualifiedName f35559i;

        /* renamed from: j, reason: collision with root package name */
        public static InterfaceC4188h<QualifiedName> f35560j = new a();

        /* renamed from: b, reason: collision with root package name */
        public final AbstractC4182b f35561b;

        /* renamed from: c, reason: collision with root package name */
        public int f35562c;

        /* renamed from: d, reason: collision with root package name */
        public int f35563d;

        /* renamed from: e, reason: collision with root package name */
        public int f35564e;

        /* renamed from: f, reason: collision with root package name */
        public Kind f35565f;

        /* renamed from: g, reason: collision with root package name */
        public byte f35566g;

        /* renamed from: h, reason: collision with root package name */
        public int f35567h;

        public enum Kind implements f.a {
            CLASS(0, 0),
            PACKAGE(1, 1),
            LOCAL(2, 2);

            private static f.b<Kind> internalValueMap = new a();
            private final int value;

            public static class a implements f.b<Kind> {
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.b
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Kind findValueByNumber(int i10) {
                    return Kind.valueOf(i10);
                }
            }

            Kind(int i10, int i11) {
                this.value = i11;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.a
            public final int getNumber() {
                return this.value;
            }

            public static Kind valueOf(int i10) {
                if (i10 == 0) {
                    return CLASS;
                }
                if (i10 == 1) {
                    return PACKAGE;
                }
                if (i10 != 2) {
                    return null;
                }
                return LOCAL;
            }
        }

        public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<QualifiedName> {
            @Override // ia.InterfaceC4188h
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public QualifiedName c(c cVar, d dVar) throws InvalidProtocolBufferException {
                return new QualifiedName(cVar, dVar);
            }
        }

        public static final class b extends GeneratedMessageLite.b<QualifiedName, b> implements InterfaceC4187g {

            /* renamed from: b, reason: collision with root package name */
            public int f35568b;

            /* renamed from: d, reason: collision with root package name */
            public int f35570d;

            /* renamed from: c, reason: collision with root package name */
            public int f35569c = -1;

            /* renamed from: e, reason: collision with root package name */
            public Kind f35571e = Kind.PACKAGE;

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
            public QualifiedName build() {
                QualifiedName qualifiedNameO = o();
                if (qualifiedNameO.isInitialized()) {
                    return qualifiedNameO;
                }
                throw a.AbstractC0449a.f(qualifiedNameO);
            }

            public QualifiedName o() {
                QualifiedName qualifiedName = new QualifiedName(this);
                int i10 = this.f35568b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                qualifiedName.f35563d = this.f35569c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                qualifiedName.f35564e = this.f35570d;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                qualifiedName.f35565f = this.f35571e;
                qualifiedName.f35562c = i11;
                return qualifiedName;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public b g() {
                return q().i(o());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public b i(QualifiedName qualifiedName) {
                if (qualifiedName == QualifiedName.u()) {
                    return this;
                }
                if (qualifiedName.z()) {
                    v(qualifiedName.w());
                }
                if (qualifiedName.A()) {
                    w(qualifiedName.x());
                }
                if (qualifiedName.y()) {
                    u(qualifiedName.v());
                }
                j(h().c(qualifiedName.f35561b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedName> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable.QualifiedName.f35560j     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedName r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable.QualifiedName) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedName r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable.QualifiedName) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedName$b");
            }

            public b u(Kind kind) {
                kind.getClass();
                this.f35568b |= 4;
                this.f35571e = kind;
                return this;
            }

            public b v(int i10) {
                this.f35568b |= 1;
                this.f35569c = i10;
                return this;
            }

            public b w(int i10) {
                this.f35568b |= 2;
                this.f35570d = i10;
                return this;
            }
        }

        static {
            QualifiedName qualifiedName = new QualifiedName(true);
            f35559i = qualifiedName;
            qualifiedName.C();
        }

        private void C() {
            this.f35563d = -1;
            this.f35564e = 0;
            this.f35565f = Kind.PACKAGE;
        }

        public static b D() {
            return b.q();
        }

        public static b E(QualifiedName qualifiedName) {
            return D().i(qualifiedName);
        }

        public static QualifiedName u() {
            return f35559i;
        }

        public boolean A() {
            return (this.f35562c & 2) == 2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return D();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            return E(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f35562c & 1) == 1) {
                codedOutputStream.a0(1, this.f35563d);
            }
            if ((this.f35562c & 2) == 2) {
                codedOutputStream.a0(2, this.f35564e);
            }
            if ((this.f35562c & 4) == 4) {
                codedOutputStream.S(3, this.f35565f.getNumber());
            }
            codedOutputStream.i0(this.f35561b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
        public InterfaceC4188h<QualifiedName> getParserForType() {
            return f35560j;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int getSerializedSize() {
            int i10 = this.f35567h;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.f35562c & 1) == 1 ? CodedOutputStream.o(1, this.f35563d) : 0;
            if ((this.f35562c & 2) == 2) {
                iO += CodedOutputStream.o(2, this.f35564e);
            }
            if ((this.f35562c & 4) == 4) {
                iO += CodedOutputStream.h(3, this.f35565f.getNumber());
            }
            int size = iO + this.f35561b.size();
            this.f35567h = size;
            return size;
        }

        @Override // ia.InterfaceC4187g
        public final boolean isInitialized() {
            byte b10 = this.f35566g;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            if (A()) {
                this.f35566g = (byte) 1;
                return true;
            }
            this.f35566g = (byte) 0;
            return false;
        }

        public Kind v() {
            return this.f35565f;
        }

        public int w() {
            return this.f35563d;
        }

        public int x() {
            return this.f35564e;
        }

        public boolean y() {
            return (this.f35562c & 4) == 4;
        }

        public boolean z() {
            return (this.f35562c & 1) == 1;
        }

        public QualifiedName(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.f35566g = (byte) -1;
            this.f35567h = -1;
            this.f35561b = bVar.h();
        }

        public QualifiedName(boolean z10) {
            this.f35566g = (byte) -1;
            this.f35567h = -1;
            this.f35561b = AbstractC4182b.f33086a;
        }

        public QualifiedName(c cVar, d dVar) throws InvalidProtocolBufferException {
            this.f35566g = (byte) -1;
            this.f35567h = -1;
            C();
            AbstractC4182b.C0409b c0409bT = AbstractC4182b.t();
            CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(c0409bT, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int iK = cVar.K();
                            if (iK != 0) {
                                if (iK == 8) {
                                    this.f35562c |= 1;
                                    this.f35563d = cVar.s();
                                } else if (iK == 16) {
                                    this.f35562c |= 2;
                                    this.f35564e = cVar.s();
                                } else if (iK != 24) {
                                    if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                                    }
                                } else {
                                    int iN = cVar.n();
                                    Kind kindValueOf = Kind.valueOf(iN);
                                    if (kindValueOf == null) {
                                        codedOutputStreamJ.o0(iK);
                                        codedOutputStreamJ.o0(iN);
                                    } else {
                                        this.f35562c |= 4;
                                        this.f35565f = kindValueOf;
                                    }
                                }
                            }
                            z10 = true;
                        } catch (InvalidProtocolBufferException e10) {
                            throw e10.i(this);
                        }
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11.getMessage()).i(this);
                    }
                } catch (Throwable th) {
                    try {
                        codedOutputStreamJ.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f35561b = c0409bT.l();
                        throw th2;
                    }
                    this.f35561b = c0409bT.l();
                    g();
                    throw th;
                }
            }
            try {
                codedOutputStreamJ.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f35561b = c0409bT.l();
                throw th3;
            }
            this.f35561b = c0409bT.l();
            g();
        }
    }

    public ProtoBuf$QualifiedNameTable(GeneratedMessageLite.b bVar) {
        super(bVar);
        this.f35557d = (byte) -1;
        this.f35558e = -1;
        this.f35555b = bVar.h();
    }

    public ProtoBuf$QualifiedNameTable(boolean z10) {
        this.f35557d = (byte) -1;
        this.f35558e = -1;
        this.f35555b = AbstractC4182b.f33086a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBuf$QualifiedNameTable(c cVar, d dVar) throws InvalidProtocolBufferException {
        this.f35557d = (byte) -1;
        this.f35558e = -1;
        v();
        AbstractC4182b.C0409b c0409bT = AbstractC4182b.t();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(c0409bT, 1);
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            try {
                try {
                    try {
                        int iK = cVar.K();
                        if (iK != 0) {
                            if (iK != 10) {
                                if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                                }
                            } else {
                                if (!z11) {
                                    this.f35556c = new ArrayList();
                                    z11 = true;
                                }
                                this.f35556c.add(cVar.u(QualifiedName.f35560j, dVar));
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.i(this);
                    }
                } catch (IOException e11) {
                    throw new InvalidProtocolBufferException(e11.getMessage()).i(this);
                }
            } catch (Throwable th) {
                if (z11) {
                    this.f35556c = Collections.unmodifiableList(this.f35556c);
                }
                try {
                    codedOutputStreamJ.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f35555b = c0409bT.l();
                    throw th2;
                }
                this.f35555b = c0409bT.l();
                g();
                throw th;
            }
        }
        if (z11) {
            this.f35556c = Collections.unmodifiableList(this.f35556c);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f35555b = c0409bT.l();
            throw th3;
        }
        this.f35555b = c0409bT.l();
        g();
    }
}
