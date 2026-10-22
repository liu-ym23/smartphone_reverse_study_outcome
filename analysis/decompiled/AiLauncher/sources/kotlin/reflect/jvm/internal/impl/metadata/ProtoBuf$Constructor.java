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

/* loaded from: classes5.dex */
public final class ProtoBuf$Constructor extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Constructor> implements InterfaceC4187g {

    /* renamed from: l, reason: collision with root package name */
    public static final ProtoBuf$Constructor f35351l;

    /* renamed from: m, reason: collision with root package name */
    public static InterfaceC4188h<ProtoBuf$Constructor> f35352m = new a();

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC4182b f35353c;

    /* renamed from: d, reason: collision with root package name */
    public int f35354d;

    /* renamed from: e, reason: collision with root package name */
    public int f35355e;

    /* renamed from: f, reason: collision with root package name */
    public List<ProtoBuf$ValueParameter> f35356f;

    /* renamed from: g, reason: collision with root package name */
    public List<Integer> f35357g;

    /* renamed from: h, reason: collision with root package name */
    public List<ProtoBuf$CompilerPluginData> f35358h;

    /* renamed from: i, reason: collision with root package name */
    public List<ProtoBuf$Annotation> f35359i;

    /* renamed from: j, reason: collision with root package name */
    public byte f35360j;

    /* renamed from: k, reason: collision with root package name */
    public int f35361k;

    public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ProtoBuf$Constructor> {
        @Override // ia.InterfaceC4188h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$Constructor c(c cVar, d dVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$Constructor(cVar, dVar);
        }
    }

    public static final class b extends GeneratedMessageLite.c<ProtoBuf$Constructor, b> implements InterfaceC4187g {

        /* renamed from: d, reason: collision with root package name */
        public int f35362d;

        /* renamed from: e, reason: collision with root package name */
        public int f35363e = 6;

        /* renamed from: f, reason: collision with root package name */
        public List<ProtoBuf$ValueParameter> f35364f;

        /* renamed from: g, reason: collision with root package name */
        public List<Integer> f35365g;

        /* renamed from: h, reason: collision with root package name */
        public List<ProtoBuf$CompilerPluginData> f35366h;

        /* renamed from: i, reason: collision with root package name */
        public List<ProtoBuf$Annotation> f35367i;

        public b() {
            List list = Collections.EMPTY_LIST;
            this.f35364f = list;
            this.f35365g = list;
            this.f35366h = list;
            this.f35367i = list;
            z();
        }

        public static b u() {
            return new b();
        }

        private void v() {
            if ((this.f35362d & 16) != 16) {
                this.f35367i = new ArrayList(this.f35367i);
                this.f35362d |= 16;
            }
        }

        private void w() {
            if ((this.f35362d & 8) != 8) {
                this.f35366h = new ArrayList(this.f35366h);
                this.f35362d |= 8;
            }
        }

        private void y() {
            if ((this.f35362d & 4) != 4) {
                this.f35365g = new ArrayList(this.f35365g);
                this.f35362d |= 4;
            }
        }

        private void z() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public b i(ProtoBuf$Constructor protoBuf$Constructor) {
            if (protoBuf$Constructor == ProtoBuf$Constructor.Q()) {
                return this;
            }
            if (protoBuf$Constructor.X()) {
                D(protoBuf$Constructor.S());
            }
            if (!protoBuf$Constructor.f35356f.isEmpty()) {
                if (this.f35364f.isEmpty()) {
                    this.f35364f = protoBuf$Constructor.f35356f;
                    this.f35362d &= -3;
                } else {
                    x();
                    this.f35364f.addAll(protoBuf$Constructor.f35356f);
                }
            }
            if (!protoBuf$Constructor.f35357g.isEmpty()) {
                if (this.f35365g.isEmpty()) {
                    this.f35365g = protoBuf$Constructor.f35357g;
                    this.f35362d &= -5;
                } else {
                    y();
                    this.f35365g.addAll(protoBuf$Constructor.f35357g);
                }
            }
            if (!protoBuf$Constructor.f35358h.isEmpty()) {
                if (this.f35366h.isEmpty()) {
                    this.f35366h = protoBuf$Constructor.f35358h;
                    this.f35362d &= -9;
                } else {
                    w();
                    this.f35366h.addAll(protoBuf$Constructor.f35358h);
                }
            }
            if (!protoBuf$Constructor.f35359i.isEmpty()) {
                if (this.f35367i.isEmpty()) {
                    this.f35367i = protoBuf$Constructor.f35359i;
                    this.f35362d &= -17;
                } else {
                    v();
                    this.f35367i.addAll(protoBuf$Constructor.f35359i);
                }
            }
            p(protoBuf$Constructor);
            j(h().c(protoBuf$Constructor.f35353c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor.f35352m     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor$b");
        }

        public b D(int i10) {
            this.f35362d |= 1;
            this.f35363e = i10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$Constructor build() {
            ProtoBuf$Constructor protoBuf$ConstructorS = s();
            if (protoBuf$ConstructorS.isInitialized()) {
                return protoBuf$ConstructorS;
            }
            throw a.AbstractC0449a.f(protoBuf$ConstructorS);
        }

        public ProtoBuf$Constructor s() {
            ProtoBuf$Constructor protoBuf$Constructor = new ProtoBuf$Constructor(this);
            int i10 = (this.f35362d & 1) != 1 ? 0 : 1;
            protoBuf$Constructor.f35355e = this.f35363e;
            if ((this.f35362d & 2) == 2) {
                this.f35364f = Collections.unmodifiableList(this.f35364f);
                this.f35362d &= -3;
            }
            protoBuf$Constructor.f35356f = this.f35364f;
            if ((this.f35362d & 4) == 4) {
                this.f35365g = Collections.unmodifiableList(this.f35365g);
                this.f35362d &= -5;
            }
            protoBuf$Constructor.f35357g = this.f35365g;
            if ((this.f35362d & 8) == 8) {
                this.f35366h = Collections.unmodifiableList(this.f35366h);
                this.f35362d &= -9;
            }
            protoBuf$Constructor.f35358h = this.f35366h;
            if ((this.f35362d & 16) == 16) {
                this.f35367i = Collections.unmodifiableList(this.f35367i);
                this.f35362d &= -17;
            }
            protoBuf$Constructor.f35359i = this.f35367i;
            protoBuf$Constructor.f35354d = i10;
            return protoBuf$Constructor;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public b g() {
            return u().i(s());
        }

        public final void x() {
            if ((this.f35362d & 2) != 2) {
                this.f35364f = new ArrayList(this.f35364f);
                this.f35362d |= 2;
            }
        }
    }

    static {
        ProtoBuf$Constructor protoBuf$Constructor = new ProtoBuf$Constructor(true);
        f35351l = protoBuf$Constructor;
        protoBuf$Constructor.Y();
    }

    public static ProtoBuf$Constructor Q() {
        return f35351l;
    }

    private void Y() {
        this.f35355e = 6;
        List list = Collections.EMPTY_LIST;
        this.f35356f = list;
        this.f35357g = list;
        this.f35358h = list;
        this.f35359i = list;
    }

    public static b Z() {
        return b.u();
    }

    public static b a0(ProtoBuf$Constructor protoBuf$Constructor) {
        return Z().i(protoBuf$Constructor);
    }

    public ProtoBuf$Annotation L(int i10) {
        return this.f35359i.get(i10);
    }

    public int M() {
        return this.f35359i.size();
    }

    public List<ProtoBuf$Annotation> N() {
        return this.f35359i;
    }

    public ProtoBuf$CompilerPluginData O(int i10) {
        return this.f35358h.get(i10);
    }

    public int P() {
        return this.f35358h.size();
    }

    @Override // ia.InterfaceC4187g
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public ProtoBuf$Constructor getDefaultInstanceForType() {
        return f35351l;
    }

    public int S() {
        return this.f35355e;
    }

    public ProtoBuf$ValueParameter T(int i10) {
        return this.f35356f.get(i10);
    }

    public int U() {
        return this.f35356f.size();
    }

    public List<ProtoBuf$ValueParameter> V() {
        return this.f35356f;
    }

    public List<Integer> W() {
        return this.f35357g;
    }

    public boolean X() {
        return (this.f35354d & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.a aVarW = w();
        if ((this.f35354d & 1) == 1) {
            codedOutputStream.a0(1, this.f35355e);
        }
        for (int i10 = 0; i10 < this.f35356f.size(); i10++) {
            codedOutputStream.d0(2, this.f35356f.get(i10));
        }
        for (int i11 = 0; i11 < this.f35359i.size(); i11++) {
            codedOutputStream.d0(3, this.f35359i.get(i11));
        }
        for (int i12 = 0; i12 < this.f35357g.size(); i12++) {
            codedOutputStream.a0(31, this.f35357g.get(i12).intValue());
        }
        for (int i13 = 0; i13 < this.f35358h.size(); i13++) {
            codedOutputStream.d0(32, this.f35358h.get(i13));
        }
        aVarW.a(19000, codedOutputStream);
        codedOutputStream.i0(this.f35353c);
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
    public InterfaceC4188h<ProtoBuf$Constructor> getParserForType() {
        return f35352m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i10 = this.f35361k;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f35354d & 1) == 1 ? CodedOutputStream.o(1, this.f35355e) : 0;
        for (int i11 = 0; i11 < this.f35356f.size(); i11++) {
            iO += CodedOutputStream.s(2, this.f35356f.get(i11));
        }
        for (int i12 = 0; i12 < this.f35359i.size(); i12++) {
            iO += CodedOutputStream.s(3, this.f35359i.get(i12));
        }
        int iP = 0;
        for (int i13 = 0; i13 < this.f35357g.size(); i13++) {
            iP += CodedOutputStream.p(this.f35357g.get(i13).intValue());
        }
        int size = iO + iP + (W().size() * 2);
        for (int i14 = 0; i14 < this.f35358h.size(); i14++) {
            size += CodedOutputStream.s(32, this.f35358h.get(i14));
        }
        int iQ = size + q() + this.f35353c.size();
        this.f35361k = iQ;
        return iQ;
    }

    @Override // ia.InterfaceC4187g
    public final boolean isInitialized() {
        byte b10 = this.f35360j;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i10 = 0; i10 < U(); i10++) {
            if (!T(i10).isInitialized()) {
                this.f35360j = (byte) 0;
                return false;
            }
        }
        for (int i11 = 0; i11 < P(); i11++) {
            if (!O(i11).isInitialized()) {
                this.f35360j = (byte) 0;
                return false;
            }
        }
        for (int i12 = 0; i12 < M(); i12++) {
            if (!L(i12).isInitialized()) {
                this.f35360j = (byte) 0;
                return false;
            }
        }
        if (n()) {
            this.f35360j = (byte) 1;
            return true;
        }
        this.f35360j = (byte) 0;
        return false;
    }

    public ProtoBuf$Constructor(GeneratedMessageLite.c<ProtoBuf$Constructor, ?> cVar) {
        super(cVar);
        this.f35360j = (byte) -1;
        this.f35361k = -1;
        this.f35353c = cVar.h();
    }

    public ProtoBuf$Constructor(boolean z10) {
        this.f35360j = (byte) -1;
        this.f35361k = -1;
        this.f35353c = AbstractC4182b.f33086a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBuf$Constructor(c cVar, d dVar) throws InvalidProtocolBufferException {
        this.f35360j = (byte) -1;
        this.f35361k = -1;
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
                            this.f35354d |= 1;
                            this.f35355e = cVar.s();
                        } else if (iK == 18) {
                            if ((i10 & 2) != 2) {
                                this.f35356f = new ArrayList();
                                i10 |= 2;
                            }
                            this.f35356f.add(cVar.u(ProtoBuf$ValueParameter.f35689p, dVar));
                        } else if (iK == 26) {
                            if ((i10 & 16) != 16) {
                                this.f35359i = new ArrayList();
                                i10 |= 16;
                            }
                            this.f35359i.add(cVar.u(ProtoBuf$Annotation.f35233i, dVar));
                        } else if (iK == 248) {
                            if ((i10 & 4) != 4) {
                                this.f35357g = new ArrayList();
                                i10 |= 4;
                            }
                            this.f35357g.add(Integer.valueOf(cVar.s()));
                        } else if (iK == 250) {
                            int iJ = cVar.j(cVar.A());
                            if ((i10 & 4) != 4 && cVar.e() > 0) {
                                this.f35357g = new ArrayList();
                                i10 |= 4;
                            }
                            while (cVar.e() > 0) {
                                this.f35357g.add(Integer.valueOf(cVar.s()));
                            }
                            cVar.i(iJ);
                        } else if (iK != 258) {
                            if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                            }
                        } else {
                            if ((i10 & 8) != 8) {
                                this.f35358h = new ArrayList();
                                i10 |= 8;
                            }
                            this.f35358h.add(cVar.u(ProtoBuf$CompilerPluginData.f35341i, dVar));
                        }
                    }
                    z10 = true;
                } catch (InvalidProtocolBufferException e10) {
                    throw e10.i(this);
                } catch (IOException e11) {
                    throw new InvalidProtocolBufferException(e11.getMessage()).i(this);
                }
            } catch (Throwable th) {
                if ((i10 & 2) == 2) {
                    this.f35356f = Collections.unmodifiableList(this.f35356f);
                }
                if ((i10 & 16) == 16) {
                    this.f35359i = Collections.unmodifiableList(this.f35359i);
                }
                if ((i10 & 4) == 4) {
                    this.f35357g = Collections.unmodifiableList(this.f35357g);
                }
                if ((i10 & 8) == 8) {
                    this.f35358h = Collections.unmodifiableList(this.f35358h);
                }
                try {
                    codedOutputStreamJ.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f35353c = c0409bT.l();
                    throw th2;
                }
                this.f35353c = c0409bT.l();
                g();
                throw th;
            }
        }
        if ((i10 & 2) == 2) {
            this.f35356f = Collections.unmodifiableList(this.f35356f);
        }
        if ((i10 & 16) == 16) {
            this.f35359i = Collections.unmodifiableList(this.f35359i);
        }
        if ((i10 & 4) == 4) {
            this.f35357g = Collections.unmodifiableList(this.f35357g);
        }
        if ((i10 & 8) == 8) {
            this.f35358h = Collections.unmodifiableList(this.f35358h);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f35353c = c0409bT.l();
            throw th3;
        }
        this.f35353c = c0409bT.l();
        g();
    }
}
