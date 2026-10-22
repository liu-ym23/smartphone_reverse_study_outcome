package kotlin.reflect.jvm.internal.impl.metadata;

import ia.AbstractC4182b;
import ia.C4184d;
import ia.InterfaceC4185e;
import ia.InterfaceC4187g;
import ia.InterfaceC4188h;
import ia.InterfaceC4189i;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.c;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* loaded from: classes5.dex */
public final class ProtoBuf$StringTable extends GeneratedMessageLite implements InterfaceC4187g {

    /* renamed from: f, reason: collision with root package name */
    public static final ProtoBuf$StringTable f35574f;

    /* renamed from: g, reason: collision with root package name */
    public static InterfaceC4188h<ProtoBuf$StringTable> f35575g = new a();

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC4182b f35576b;

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC4185e f35577c;

    /* renamed from: d, reason: collision with root package name */
    public byte f35578d;

    /* renamed from: e, reason: collision with root package name */
    public int f35579e;

    public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ProtoBuf$StringTable> {
        @Override // ia.InterfaceC4188h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$StringTable c(c cVar, d dVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$StringTable(cVar, dVar);
        }
    }

    public static final class b extends GeneratedMessageLite.b<ProtoBuf$StringTable, b> implements InterfaceC4187g {

        /* renamed from: b, reason: collision with root package name */
        public int f35580b;

        /* renamed from: c, reason: collision with root package name */
        public InterfaceC4185e f35581c = C4184d.f33097b;

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
        public ProtoBuf$StringTable build() {
            ProtoBuf$StringTable protoBuf$StringTableO = o();
            if (protoBuf$StringTableO.isInitialized()) {
                return protoBuf$StringTableO;
            }
            throw a.AbstractC0449a.f(protoBuf$StringTableO);
        }

        public ProtoBuf$StringTable o() {
            ProtoBuf$StringTable protoBuf$StringTable = new ProtoBuf$StringTable(this);
            if ((this.f35580b & 1) == 1) {
                this.f35581c = this.f35581c.getUnmodifiableView();
                this.f35580b &= -2;
            }
            protoBuf$StringTable.f35577c = this.f35581c;
            return protoBuf$StringTable;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b g() {
            return q().i(o());
        }

        public final void r() {
            if ((this.f35580b & 1) != 1) {
                this.f35581c = new C4184d(this.f35581c);
                this.f35580b |= 1;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public b i(ProtoBuf$StringTable protoBuf$StringTable) {
            if (protoBuf$StringTable == ProtoBuf$StringTable.s()) {
                return this;
            }
            if (!protoBuf$StringTable.f35577c.isEmpty()) {
                if (this.f35581c.isEmpty()) {
                    this.f35581c = protoBuf$StringTable.f35577c;
                    this.f35580b &= -2;
                } else {
                    r();
                    this.f35581c.addAll(protoBuf$StringTable.f35577c);
                }
            }
            j(h().c(protoBuf$StringTable.f35576b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable.f35575g     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable$b");
        }
    }

    static {
        ProtoBuf$StringTable protoBuf$StringTable = new ProtoBuf$StringTable(true);
        f35574f = protoBuf$StringTable;
        protoBuf$StringTable.v();
    }

    public static ProtoBuf$StringTable s() {
        return f35574f;
    }

    private void v() {
        this.f35577c = C4184d.f33097b;
    }

    public static b w() {
        return b.q();
    }

    public static b x(ProtoBuf$StringTable protoBuf$StringTable) {
        return w().i(protoBuf$StringTable);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        for (int i10 = 0; i10 < this.f35577c.size(); i10++) {
            codedOutputStream.O(1, this.f35577c.getByteString(i10));
        }
        codedOutputStream.i0(this.f35576b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
    public InterfaceC4188h<ProtoBuf$StringTable> getParserForType() {
        return f35575g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i10 = this.f35579e;
        if (i10 != -1) {
            return i10;
        }
        int iE = 0;
        for (int i11 = 0; i11 < this.f35577c.size(); i11++) {
            iE += CodedOutputStream.e(this.f35577c.getByteString(i11));
        }
        int size = iE + u().size() + this.f35576b.size();
        this.f35579e = size;
        return size;
    }

    @Override // ia.InterfaceC4187g
    public final boolean isInitialized() {
        byte b10 = this.f35578d;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        this.f35578d = (byte) 1;
        return true;
    }

    public String t(int i10) {
        return this.f35577c.get(i10);
    }

    public InterfaceC4189i u() {
        return this.f35577c;
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

    public ProtoBuf$StringTable(GeneratedMessageLite.b bVar) {
        super(bVar);
        this.f35578d = (byte) -1;
        this.f35579e = -1;
        this.f35576b = bVar.h();
    }

    public ProtoBuf$StringTable(boolean z10) {
        this.f35578d = (byte) -1;
        this.f35579e = -1;
        this.f35576b = AbstractC4182b.f33086a;
    }

    public ProtoBuf$StringTable(c cVar, d dVar) throws InvalidProtocolBufferException {
        this.f35578d = (byte) -1;
        this.f35579e = -1;
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
                                AbstractC4182b abstractC4182bL = cVar.l();
                                if (!z11) {
                                    this.f35577c = new C4184d();
                                    z11 = true;
                                }
                                this.f35577c.q(abstractC4182bL);
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
                    this.f35577c = this.f35577c.getUnmodifiableView();
                }
                try {
                    codedOutputStreamJ.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f35576b = c0409bT.l();
                    throw th2;
                }
                this.f35576b = c0409bT.l();
                g();
                throw th;
            }
        }
        if (z11) {
            this.f35577c = this.f35577c.getUnmodifiableView();
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f35576b = c0409bT.l();
            throw th3;
        }
        this.f35576b = c0409bT.l();
        g();
    }
}
