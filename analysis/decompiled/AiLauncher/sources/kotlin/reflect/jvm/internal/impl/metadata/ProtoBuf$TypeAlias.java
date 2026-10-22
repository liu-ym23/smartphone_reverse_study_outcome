package kotlin.reflect.jvm.internal.impl.metadata;

import com.zyql.ai.selector.camera.CustomCameraView;
import ia.AbstractC4182b;
import ia.InterfaceC4187g;
import ia.InterfaceC4188h;
import java.io.IOException;
import java.io.InputStream;
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

/* loaded from: classes5.dex */
public final class ProtoBuf$TypeAlias extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$TypeAlias> implements InterfaceC4187g {

    /* renamed from: q, reason: collision with root package name */
    public static final ProtoBuf$TypeAlias f35630q;

    /* renamed from: r, reason: collision with root package name */
    public static InterfaceC4188h<ProtoBuf$TypeAlias> f35631r = new a();

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC4182b f35632c;

    /* renamed from: d, reason: collision with root package name */
    public int f35633d;

    /* renamed from: e, reason: collision with root package name */
    public int f35634e;

    /* renamed from: f, reason: collision with root package name */
    public int f35635f;

    /* renamed from: g, reason: collision with root package name */
    public List<ProtoBuf$TypeParameter> f35636g;

    /* renamed from: h, reason: collision with root package name */
    public ProtoBuf$Type f35637h;

    /* renamed from: i, reason: collision with root package name */
    public int f35638i;

    /* renamed from: j, reason: collision with root package name */
    public ProtoBuf$Type f35639j;

    /* renamed from: k, reason: collision with root package name */
    public int f35640k;

    /* renamed from: l, reason: collision with root package name */
    public List<ProtoBuf$Annotation> f35641l;

    /* renamed from: m, reason: collision with root package name */
    public List<Integer> f35642m;

    /* renamed from: n, reason: collision with root package name */
    public List<ProtoBuf$CompilerPluginData> f35643n;

    /* renamed from: o, reason: collision with root package name */
    public byte f35644o;

    /* renamed from: p, reason: collision with root package name */
    public int f35645p;

    public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ProtoBuf$TypeAlias> {
        @Override // ia.InterfaceC4188h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$TypeAlias c(c cVar, d dVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$TypeAlias(cVar, dVar);
        }
    }

    public static final class b extends GeneratedMessageLite.c<ProtoBuf$TypeAlias, b> implements InterfaceC4187g {

        /* renamed from: d, reason: collision with root package name */
        public int f35646d;

        /* renamed from: e, reason: collision with root package name */
        public int f35647e = 6;

        /* renamed from: f, reason: collision with root package name */
        public int f35648f;

        /* renamed from: g, reason: collision with root package name */
        public List<ProtoBuf$TypeParameter> f35649g;

        /* renamed from: h, reason: collision with root package name */
        public ProtoBuf$Type f35650h;

        /* renamed from: i, reason: collision with root package name */
        public int f35651i;

        /* renamed from: j, reason: collision with root package name */
        public ProtoBuf$Type f35652j;

        /* renamed from: k, reason: collision with root package name */
        public int f35653k;

        /* renamed from: l, reason: collision with root package name */
        public List<ProtoBuf$Annotation> f35654l;

        /* renamed from: m, reason: collision with root package name */
        public List<Integer> f35655m;

        /* renamed from: n, reason: collision with root package name */
        public List<ProtoBuf$CompilerPluginData> f35656n;

        public b() {
            List list = Collections.EMPTY_LIST;
            this.f35649g = list;
            this.f35650h = ProtoBuf$Type.X();
            this.f35652j = ProtoBuf$Type.X();
            this.f35654l = list;
            this.f35655m = list;
            this.f35656n = list;
            z();
        }

        public static b u() {
            return new b();
        }

        private void v() {
            if ((this.f35646d & 128) != 128) {
                this.f35654l = new ArrayList(this.f35654l);
                this.f35646d |= 128;
            }
        }

        private void w() {
            if ((this.f35646d & 512) != 512) {
                this.f35656n = new ArrayList(this.f35656n);
                this.f35646d |= 512;
            }
        }

        private void x() {
            if ((this.f35646d & 4) != 4) {
                this.f35649g = new ArrayList(this.f35649g);
                this.f35646d |= 4;
            }
        }

        private void y() {
            if ((this.f35646d & 256) != 256) {
                this.f35655m = new ArrayList(this.f35655m);
                this.f35646d |= 256;
            }
        }

        private void z() {
        }

        public b B(ProtoBuf$Type protoBuf$Type) {
            if ((this.f35646d & 32) != 32 || this.f35652j == ProtoBuf$Type.X()) {
                this.f35652j = protoBuf$Type;
            } else {
                this.f35652j = ProtoBuf$Type.y0(this.f35652j).i(protoBuf$Type).s();
            }
            this.f35646d |= 32;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public b i(ProtoBuf$TypeAlias protoBuf$TypeAlias) {
            if (protoBuf$TypeAlias == ProtoBuf$TypeAlias.V()) {
                return this;
            }
            if (protoBuf$TypeAlias.j0()) {
                H(protoBuf$TypeAlias.Z());
            }
            if (protoBuf$TypeAlias.k0()) {
                I(protoBuf$TypeAlias.a0());
            }
            if (!protoBuf$TypeAlias.f35636g.isEmpty()) {
                if (this.f35649g.isEmpty()) {
                    this.f35649g = protoBuf$TypeAlias.f35636g;
                    this.f35646d &= -5;
                } else {
                    x();
                    this.f35649g.addAll(protoBuf$TypeAlias.f35636g);
                }
            }
            if (protoBuf$TypeAlias.l0()) {
                E(protoBuf$TypeAlias.e0());
            }
            if (protoBuf$TypeAlias.m0()) {
                K(protoBuf$TypeAlias.f0());
            }
            if (protoBuf$TypeAlias.h0()) {
                B(protoBuf$TypeAlias.X());
            }
            if (protoBuf$TypeAlias.i0()) {
                F(protoBuf$TypeAlias.Y());
            }
            if (!protoBuf$TypeAlias.f35641l.isEmpty()) {
                if (this.f35654l.isEmpty()) {
                    this.f35654l = protoBuf$TypeAlias.f35641l;
                    this.f35646d &= -129;
                } else {
                    v();
                    this.f35654l.addAll(protoBuf$TypeAlias.f35641l);
                }
            }
            if (!protoBuf$TypeAlias.f35642m.isEmpty()) {
                if (this.f35655m.isEmpty()) {
                    this.f35655m = protoBuf$TypeAlias.f35642m;
                    this.f35646d &= -257;
                } else {
                    y();
                    this.f35655m.addAll(protoBuf$TypeAlias.f35642m);
                }
            }
            if (!protoBuf$TypeAlias.f35643n.isEmpty()) {
                if (this.f35656n.isEmpty()) {
                    this.f35656n = protoBuf$TypeAlias.f35643n;
                    this.f35646d &= -513;
                } else {
                    w();
                    this.f35656n.addAll(protoBuf$TypeAlias.f35643n);
                }
            }
            p(protoBuf$TypeAlias);
            j(h().c(protoBuf$TypeAlias.f35632c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias.f35631r     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias$b");
        }

        public b E(ProtoBuf$Type protoBuf$Type) {
            if ((this.f35646d & 8) != 8 || this.f35650h == ProtoBuf$Type.X()) {
                this.f35650h = protoBuf$Type;
            } else {
                this.f35650h = ProtoBuf$Type.y0(this.f35650h).i(protoBuf$Type).s();
            }
            this.f35646d |= 8;
            return this;
        }

        public b F(int i10) {
            this.f35646d |= 64;
            this.f35653k = i10;
            return this;
        }

        public b H(int i10) {
            this.f35646d |= 1;
            this.f35647e = i10;
            return this;
        }

        public b I(int i10) {
            this.f35646d |= 2;
            this.f35648f = i10;
            return this;
        }

        public b K(int i10) {
            this.f35646d |= 16;
            this.f35651i = i10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$TypeAlias build() {
            ProtoBuf$TypeAlias protoBuf$TypeAliasS = s();
            if (protoBuf$TypeAliasS.isInitialized()) {
                return protoBuf$TypeAliasS;
            }
            throw a.AbstractC0449a.f(protoBuf$TypeAliasS);
        }

        public ProtoBuf$TypeAlias s() {
            ProtoBuf$TypeAlias protoBuf$TypeAlias = new ProtoBuf$TypeAlias(this);
            int i10 = this.f35646d;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            protoBuf$TypeAlias.f35634e = this.f35647e;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            protoBuf$TypeAlias.f35635f = this.f35648f;
            if ((this.f35646d & 4) == 4) {
                this.f35649g = Collections.unmodifiableList(this.f35649g);
                this.f35646d &= -5;
            }
            protoBuf$TypeAlias.f35636g = this.f35649g;
            if ((i10 & 8) == 8) {
                i11 |= 4;
            }
            protoBuf$TypeAlias.f35637h = this.f35650h;
            if ((i10 & 16) == 16) {
                i11 |= 8;
            }
            protoBuf$TypeAlias.f35638i = this.f35651i;
            if ((i10 & 32) == 32) {
                i11 |= 16;
            }
            protoBuf$TypeAlias.f35639j = this.f35652j;
            if ((i10 & 64) == 64) {
                i11 |= 32;
            }
            protoBuf$TypeAlias.f35640k = this.f35653k;
            if ((this.f35646d & 128) == 128) {
                this.f35654l = Collections.unmodifiableList(this.f35654l);
                this.f35646d &= -129;
            }
            protoBuf$TypeAlias.f35641l = this.f35654l;
            if ((this.f35646d & 256) == 256) {
                this.f35655m = Collections.unmodifiableList(this.f35655m);
                this.f35646d &= -257;
            }
            protoBuf$TypeAlias.f35642m = this.f35655m;
            if ((this.f35646d & 512) == 512) {
                this.f35656n = Collections.unmodifiableList(this.f35656n);
                this.f35646d &= -513;
            }
            protoBuf$TypeAlias.f35643n = this.f35656n;
            protoBuf$TypeAlias.f35633d = i11;
            return protoBuf$TypeAlias;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public b g() {
            return u().i(s());
        }
    }

    static {
        ProtoBuf$TypeAlias protoBuf$TypeAlias = new ProtoBuf$TypeAlias(true);
        f35630q = protoBuf$TypeAlias;
        protoBuf$TypeAlias.n0();
    }

    public static ProtoBuf$TypeAlias V() {
        return f35630q;
    }

    private void n0() {
        this.f35634e = 6;
        this.f35635f = 0;
        List list = Collections.EMPTY_LIST;
        this.f35636g = list;
        this.f35637h = ProtoBuf$Type.X();
        this.f35638i = 0;
        this.f35639j = ProtoBuf$Type.X();
        this.f35640k = 0;
        this.f35641l = list;
        this.f35642m = list;
        this.f35643n = list;
    }

    public static b o0() {
        return b.u();
    }

    public static b p0(ProtoBuf$TypeAlias protoBuf$TypeAlias) {
        return o0().i(protoBuf$TypeAlias);
    }

    public static ProtoBuf$TypeAlias r0(InputStream inputStream, d dVar) throws IOException {
        return f35631r.d(inputStream, dVar);
    }

    public ProtoBuf$Annotation Q(int i10) {
        return this.f35641l.get(i10);
    }

    public int R() {
        return this.f35641l.size();
    }

    public List<ProtoBuf$Annotation> S() {
        return this.f35641l;
    }

    public ProtoBuf$CompilerPluginData T(int i10) {
        return this.f35643n.get(i10);
    }

    public int U() {
        return this.f35643n.size();
    }

    @Override // ia.InterfaceC4187g
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public ProtoBuf$TypeAlias getDefaultInstanceForType() {
        return f35630q;
    }

    public ProtoBuf$Type X() {
        return this.f35639j;
    }

    public int Y() {
        return this.f35640k;
    }

    public int Z() {
        return this.f35634e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.a aVarW = w();
        if ((this.f35633d & 1) == 1) {
            codedOutputStream.a0(1, this.f35634e);
        }
        if ((this.f35633d & 2) == 2) {
            codedOutputStream.a0(2, this.f35635f);
        }
        for (int i10 = 0; i10 < this.f35636g.size(); i10++) {
            codedOutputStream.d0(3, this.f35636g.get(i10));
        }
        if ((this.f35633d & 4) == 4) {
            codedOutputStream.d0(4, this.f35637h);
        }
        if ((this.f35633d & 8) == 8) {
            codedOutputStream.a0(5, this.f35638i);
        }
        if ((this.f35633d & 16) == 16) {
            codedOutputStream.d0(6, this.f35639j);
        }
        if ((this.f35633d & 32) == 32) {
            codedOutputStream.a0(7, this.f35640k);
        }
        for (int i11 = 0; i11 < this.f35641l.size(); i11++) {
            codedOutputStream.d0(8, this.f35641l.get(i11));
        }
        for (int i12 = 0; i12 < this.f35642m.size(); i12++) {
            codedOutputStream.a0(31, this.f35642m.get(i12).intValue());
        }
        for (int i13 = 0; i13 < this.f35643n.size(); i13++) {
            codedOutputStream.d0(32, this.f35643n.get(i13));
        }
        aVarW.a(200, codedOutputStream);
        codedOutputStream.i0(this.f35632c);
    }

    public int a0() {
        return this.f35635f;
    }

    public ProtoBuf$TypeParameter b0(int i10) {
        return this.f35636g.get(i10);
    }

    public int c0() {
        return this.f35636g.size();
    }

    public List<ProtoBuf$TypeParameter> d0() {
        return this.f35636g;
    }

    public ProtoBuf$Type e0() {
        return this.f35637h;
    }

    public int f0() {
        return this.f35638i;
    }

    public List<Integer> g0() {
        return this.f35642m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
    public InterfaceC4188h<ProtoBuf$TypeAlias> getParserForType() {
        return f35631r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i10 = this.f35645p;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f35633d & 1) == 1 ? CodedOutputStream.o(1, this.f35634e) : 0;
        if ((this.f35633d & 2) == 2) {
            iO += CodedOutputStream.o(2, this.f35635f);
        }
        for (int i11 = 0; i11 < this.f35636g.size(); i11++) {
            iO += CodedOutputStream.s(3, this.f35636g.get(i11));
        }
        if ((this.f35633d & 4) == 4) {
            iO += CodedOutputStream.s(4, this.f35637h);
        }
        if ((this.f35633d & 8) == 8) {
            iO += CodedOutputStream.o(5, this.f35638i);
        }
        if ((this.f35633d & 16) == 16) {
            iO += CodedOutputStream.s(6, this.f35639j);
        }
        if ((this.f35633d & 32) == 32) {
            iO += CodedOutputStream.o(7, this.f35640k);
        }
        for (int i12 = 0; i12 < this.f35641l.size(); i12++) {
            iO += CodedOutputStream.s(8, this.f35641l.get(i12));
        }
        int iP = 0;
        for (int i13 = 0; i13 < this.f35642m.size(); i13++) {
            iP += CodedOutputStream.p(this.f35642m.get(i13).intValue());
        }
        int size = iO + iP + (g0().size() * 2);
        for (int i14 = 0; i14 < this.f35643n.size(); i14++) {
            size += CodedOutputStream.s(32, this.f35643n.get(i14));
        }
        int iQ = size + q() + this.f35632c.size();
        this.f35645p = iQ;
        return iQ;
    }

    public boolean h0() {
        return (this.f35633d & 16) == 16;
    }

    public boolean i0() {
        return (this.f35633d & 32) == 32;
    }

    @Override // ia.InterfaceC4187g
    public final boolean isInitialized() {
        byte b10 = this.f35644o;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!k0()) {
            this.f35644o = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < c0(); i10++) {
            if (!b0(i10).isInitialized()) {
                this.f35644o = (byte) 0;
                return false;
            }
        }
        if (l0() && !e0().isInitialized()) {
            this.f35644o = (byte) 0;
            return false;
        }
        if (h0() && !X().isInitialized()) {
            this.f35644o = (byte) 0;
            return false;
        }
        for (int i11 = 0; i11 < R(); i11++) {
            if (!Q(i11).isInitialized()) {
                this.f35644o = (byte) 0;
                return false;
            }
        }
        for (int i12 = 0; i12 < U(); i12++) {
            if (!T(i12).isInitialized()) {
                this.f35644o = (byte) 0;
                return false;
            }
        }
        if (n()) {
            this.f35644o = (byte) 1;
            return true;
        }
        this.f35644o = (byte) 0;
        return false;
    }

    public boolean j0() {
        return (this.f35633d & 1) == 1;
    }

    public boolean k0() {
        return (this.f35633d & 2) == 2;
    }

    public boolean l0() {
        return (this.f35633d & 4) == 4;
    }

    public boolean m0() {
        return (this.f35633d & 8) == 8;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return o0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return p0(this);
    }

    public ProtoBuf$TypeAlias(GeneratedMessageLite.c<ProtoBuf$TypeAlias, ?> cVar) {
        super(cVar);
        this.f35644o = (byte) -1;
        this.f35645p = -1;
        this.f35632c = cVar.h();
    }

    public ProtoBuf$TypeAlias(boolean z10) {
        this.f35644o = (byte) -1;
        this.f35645p = -1;
        this.f35632c = AbstractC4182b.f33086a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    public ProtoBuf$TypeAlias(c cVar, d dVar) throws InvalidProtocolBufferException {
        ProtoBuf$Type.b builder;
        this.f35644o = (byte) -1;
        this.f35645p = -1;
        n0();
        AbstractC4182b.C0409b c0409bT = AbstractC4182b.t();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(c0409bT, 1);
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            ?? J10 = 128;
            if (!z10) {
                try {
                    try {
                        int iK = cVar.K();
                        switch (iK) {
                            case 0:
                                z10 = true;
                            case 8:
                                this.f35633d |= 1;
                                this.f35634e = cVar.s();
                            case 16:
                                this.f35633d |= 2;
                                this.f35635f = cVar.s();
                            case 26:
                                if ((i10 & 4) != 4) {
                                    this.f35636g = new ArrayList();
                                    i10 |= 4;
                                }
                                this.f35636g.add(cVar.u(ProtoBuf$TypeParameter.f35658o, dVar));
                            case 34:
                                builder = (this.f35633d & 4) == 4 ? this.f35637h.toBuilder() : null;
                                ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) cVar.u(ProtoBuf$Type.f35583v, dVar);
                                this.f35637h = protoBuf$Type;
                                if (builder != null) {
                                    builder.i(protoBuf$Type);
                                    this.f35637h = builder.s();
                                }
                                this.f35633d |= 4;
                            case 40:
                                this.f35633d |= 8;
                                this.f35638i = cVar.s();
                            case 50:
                                builder = (this.f35633d & 16) == 16 ? this.f35639j.toBuilder() : null;
                                ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) cVar.u(ProtoBuf$Type.f35583v, dVar);
                                this.f35639j = protoBuf$Type2;
                                if (builder != null) {
                                    builder.i(protoBuf$Type2);
                                    this.f35639j = builder.s();
                                }
                                this.f35633d |= 16;
                            case 56:
                                this.f35633d |= 32;
                                this.f35640k = cVar.s();
                            case 66:
                                if ((i10 & 128) != 128) {
                                    this.f35641l = new ArrayList();
                                    i10 |= 128;
                                }
                                this.f35641l.add(cVar.u(ProtoBuf$Annotation.f35233i, dVar));
                            case 248:
                                if ((i10 & 256) != 256) {
                                    this.f35642m = new ArrayList();
                                    i10 |= 256;
                                }
                                this.f35642m.add(Integer.valueOf(cVar.s()));
                            case 250:
                                int iJ = cVar.j(cVar.A());
                                if ((i10 & 256) != 256 && cVar.e() > 0) {
                                    this.f35642m = new ArrayList();
                                    i10 |= 256;
                                }
                                while (cVar.e() > 0) {
                                    this.f35642m.add(Integer.valueOf(cVar.s()));
                                }
                                cVar.i(iJ);
                                break;
                            case CustomCameraView.BUTTON_STATE_ONLY_RECORDER /* 258 */:
                                if ((i10 & 512) != 512) {
                                    this.f35643n = new ArrayList();
                                    i10 |= 512;
                                }
                                this.f35643n.add(cVar.u(ProtoBuf$CompilerPluginData.f35341i, dVar));
                            default:
                                J10 = j(cVar, codedOutputStreamJ, dVar, iK);
                                if (J10 == 0) {
                                    z10 = true;
                                }
                        }
                    } catch (Throwable th) {
                        if ((i10 & 4) == 4) {
                            this.f35636g = Collections.unmodifiableList(this.f35636g);
                        }
                        if ((i10 & 128) == J10) {
                            this.f35641l = Collections.unmodifiableList(this.f35641l);
                        }
                        if ((i10 & 256) == 256) {
                            this.f35642m = Collections.unmodifiableList(this.f35642m);
                        }
                        if ((i10 & 512) == 512) {
                            this.f35643n = Collections.unmodifiableList(this.f35643n);
                        }
                        try {
                            codedOutputStreamJ.I();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.f35632c = c0409bT.l();
                            throw th2;
                        }
                        this.f35632c = c0409bT.l();
                        g();
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e10) {
                    throw e10.i(this);
                } catch (IOException e11) {
                    throw new InvalidProtocolBufferException(e11.getMessage()).i(this);
                }
            } else {
                if ((i10 & 4) == 4) {
                    this.f35636g = Collections.unmodifiableList(this.f35636g);
                }
                if ((i10 & 128) == 128) {
                    this.f35641l = Collections.unmodifiableList(this.f35641l);
                }
                if ((i10 & 256) == 256) {
                    this.f35642m = Collections.unmodifiableList(this.f35642m);
                }
                if ((i10 & 512) == 512) {
                    this.f35643n = Collections.unmodifiableList(this.f35643n);
                }
                try {
                    codedOutputStreamJ.I();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.f35632c = c0409bT.l();
                    throw th3;
                }
                this.f35632c = c0409bT.l();
                g();
                return;
            }
        }
    }
}
