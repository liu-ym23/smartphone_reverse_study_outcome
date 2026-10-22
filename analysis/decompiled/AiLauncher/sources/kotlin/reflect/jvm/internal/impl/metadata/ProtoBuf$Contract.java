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
public final class ProtoBuf$Contract extends GeneratedMessageLite implements InterfaceC4187g {

    /* renamed from: f, reason: collision with root package name */
    public static final ProtoBuf$Contract f35368f;

    /* renamed from: g, reason: collision with root package name */
    public static InterfaceC4188h<ProtoBuf$Contract> f35369g = new a();

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC4182b f35370b;

    /* renamed from: c, reason: collision with root package name */
    public List<ProtoBuf$Effect> f35371c;

    /* renamed from: d, reason: collision with root package name */
    public byte f35372d;

    /* renamed from: e, reason: collision with root package name */
    public int f35373e;

    public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ProtoBuf$Contract> {
        @Override // ia.InterfaceC4188h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$Contract c(c cVar, d dVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$Contract(cVar, dVar);
        }
    }

    public static final class b extends GeneratedMessageLite.b<ProtoBuf$Contract, b> implements InterfaceC4187g {

        /* renamed from: b, reason: collision with root package name */
        public int f35374b;

        /* renamed from: c, reason: collision with root package name */
        public List<ProtoBuf$Effect> f35375c = Collections.EMPTY_LIST;

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
        public ProtoBuf$Contract build() {
            ProtoBuf$Contract protoBuf$ContractO = o();
            if (protoBuf$ContractO.isInitialized()) {
                return protoBuf$ContractO;
            }
            throw a.AbstractC0449a.f(protoBuf$ContractO);
        }

        public ProtoBuf$Contract o() {
            ProtoBuf$Contract protoBuf$Contract = new ProtoBuf$Contract(this);
            if ((this.f35374b & 1) == 1) {
                this.f35375c = Collections.unmodifiableList(this.f35375c);
                this.f35374b &= -2;
            }
            protoBuf$Contract.f35371c = this.f35375c;
            return protoBuf$Contract;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b g() {
            return q().i(o());
        }

        public final void r() {
            if ((this.f35374b & 1) != 1) {
                this.f35375c = new ArrayList(this.f35375c);
                this.f35374b |= 1;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public b i(ProtoBuf$Contract protoBuf$Contract) {
            if (protoBuf$Contract == ProtoBuf$Contract.s()) {
                return this;
            }
            if (!protoBuf$Contract.f35371c.isEmpty()) {
                if (this.f35375c.isEmpty()) {
                    this.f35375c = protoBuf$Contract.f35371c;
                    this.f35374b &= -2;
                } else {
                    r();
                    this.f35375c.addAll(protoBuf$Contract.f35371c);
                }
            }
            j(h().c(protoBuf$Contract.f35370b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract.f35369g     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract$b");
        }
    }

    static {
        ProtoBuf$Contract protoBuf$Contract = new ProtoBuf$Contract(true);
        f35368f = protoBuf$Contract;
        protoBuf$Contract.w();
    }

    public static ProtoBuf$Contract s() {
        return f35368f;
    }

    private void w() {
        this.f35371c = Collections.EMPTY_LIST;
    }

    public static b x() {
        return b.q();
    }

    public static b y(ProtoBuf$Contract protoBuf$Contract) {
        return x().i(protoBuf$Contract);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return y(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        for (int i10 = 0; i10 < this.f35371c.size(); i10++) {
            codedOutputStream.d0(1, this.f35371c.get(i10));
        }
        codedOutputStream.i0(this.f35370b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
    public InterfaceC4188h<ProtoBuf$Contract> getParserForType() {
        return f35369g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i10 = this.f35373e;
        if (i10 != -1) {
            return i10;
        }
        int iS = 0;
        for (int i11 = 0; i11 < this.f35371c.size(); i11++) {
            iS += CodedOutputStream.s(1, this.f35371c.get(i11));
        }
        int size = iS + this.f35370b.size();
        this.f35373e = size;
        return size;
    }

    @Override // ia.InterfaceC4187g
    public final boolean isInitialized() {
        byte b10 = this.f35372d;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i10 = 0; i10 < u(); i10++) {
            if (!t(i10).isInitialized()) {
                this.f35372d = (byte) 0;
                return false;
            }
        }
        this.f35372d = (byte) 1;
        return true;
    }

    public ProtoBuf$Effect t(int i10) {
        return this.f35371c.get(i10);
    }

    public int u() {
        return this.f35371c.size();
    }

    public List<ProtoBuf$Effect> v() {
        return this.f35371c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return x();
    }

    public ProtoBuf$Contract(GeneratedMessageLite.b bVar) {
        super(bVar);
        this.f35372d = (byte) -1;
        this.f35373e = -1;
        this.f35370b = bVar.h();
    }

    public ProtoBuf$Contract(boolean z10) {
        this.f35372d = (byte) -1;
        this.f35373e = -1;
        this.f35370b = AbstractC4182b.f33086a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBuf$Contract(c cVar, d dVar) throws InvalidProtocolBufferException {
        this.f35372d = (byte) -1;
        this.f35373e = -1;
        w();
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
                                    this.f35371c = new ArrayList();
                                    z11 = true;
                                }
                                this.f35371c.add(cVar.u(ProtoBuf$Effect.f35377l, dVar));
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
                    this.f35371c = Collections.unmodifiableList(this.f35371c);
                }
                try {
                    codedOutputStreamJ.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f35370b = c0409bT.l();
                    throw th2;
                }
                this.f35370b = c0409bT.l();
                g();
                throw th;
            }
        }
        if (z11) {
            this.f35371c = Collections.unmodifiableList(this.f35371c);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f35370b = c0409bT.l();
            throw th3;
        }
        this.f35370b = c0409bT.l();
        g();
    }
}
