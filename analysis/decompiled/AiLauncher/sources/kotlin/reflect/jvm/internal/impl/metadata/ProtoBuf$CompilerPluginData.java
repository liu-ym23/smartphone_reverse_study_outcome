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

/* loaded from: classes5.dex */
public final class ProtoBuf$CompilerPluginData extends GeneratedMessageLite implements InterfaceC4187g {

    /* renamed from: h, reason: collision with root package name */
    public static final ProtoBuf$CompilerPluginData f35340h;

    /* renamed from: i, reason: collision with root package name */
    public static InterfaceC4188h<ProtoBuf$CompilerPluginData> f35341i = new a();

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC4182b f35342b;

    /* renamed from: c, reason: collision with root package name */
    public int f35343c;

    /* renamed from: d, reason: collision with root package name */
    public int f35344d;

    /* renamed from: e, reason: collision with root package name */
    public AbstractC4182b f35345e;

    /* renamed from: f, reason: collision with root package name */
    public byte f35346f;

    /* renamed from: g, reason: collision with root package name */
    public int f35347g;

    public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ProtoBuf$CompilerPluginData> {
        @Override // ia.InterfaceC4188h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$CompilerPluginData c(c cVar, d dVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$CompilerPluginData(cVar, dVar);
        }
    }

    public static final class b extends GeneratedMessageLite.b<ProtoBuf$CompilerPluginData, b> implements InterfaceC4187g {

        /* renamed from: b, reason: collision with root package name */
        public int f35348b;

        /* renamed from: c, reason: collision with root package name */
        public int f35349c;

        /* renamed from: d, reason: collision with root package name */
        public AbstractC4182b f35350d = AbstractC4182b.f33086a;

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
        public ProtoBuf$CompilerPluginData build() {
            ProtoBuf$CompilerPluginData protoBuf$CompilerPluginDataO = o();
            if (protoBuf$CompilerPluginDataO.isInitialized()) {
                return protoBuf$CompilerPluginDataO;
            }
            throw a.AbstractC0449a.f(protoBuf$CompilerPluginDataO);
        }

        public ProtoBuf$CompilerPluginData o() {
            ProtoBuf$CompilerPluginData protoBuf$CompilerPluginData = new ProtoBuf$CompilerPluginData(this);
            int i10 = this.f35348b;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            protoBuf$CompilerPluginData.f35344d = this.f35349c;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            protoBuf$CompilerPluginData.f35345e = this.f35350d;
            protoBuf$CompilerPluginData.f35343c = i11;
            return protoBuf$CompilerPluginData;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b g() {
            return q().i(o());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public b i(ProtoBuf$CompilerPluginData protoBuf$CompilerPluginData) {
            if (protoBuf$CompilerPluginData == ProtoBuf$CompilerPluginData.u()) {
                return this;
            }
            if (protoBuf$CompilerPluginData.x()) {
                v(protoBuf$CompilerPluginData.v());
            }
            if (protoBuf$CompilerPluginData.w()) {
                u(protoBuf$CompilerPluginData.t());
            }
            j(h().c(protoBuf$CompilerPluginData.f35342b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$CompilerPluginData.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$CompilerPluginData> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$CompilerPluginData.f35341i     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$CompilerPluginData r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$CompilerPluginData) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$CompilerPluginData r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$CompilerPluginData) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$CompilerPluginData.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$CompilerPluginData$b");
        }

        public b u(AbstractC4182b abstractC4182b) {
            abstractC4182b.getClass();
            this.f35348b |= 2;
            this.f35350d = abstractC4182b;
            return this;
        }

        public b v(int i10) {
            this.f35348b |= 1;
            this.f35349c = i10;
            return this;
        }
    }

    static {
        ProtoBuf$CompilerPluginData protoBuf$CompilerPluginData = new ProtoBuf$CompilerPluginData(true);
        f35340h = protoBuf$CompilerPluginData;
        protoBuf$CompilerPluginData.y();
    }

    public static b A(ProtoBuf$CompilerPluginData protoBuf$CompilerPluginData) {
        return z().i(protoBuf$CompilerPluginData);
    }

    public static ProtoBuf$CompilerPluginData u() {
        return f35340h;
    }

    private void y() {
        this.f35344d = 0;
        this.f35345e = AbstractC4182b.f33086a;
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
        if ((this.f35343c & 1) == 1) {
            codedOutputStream.a0(1, this.f35344d);
        }
        if ((this.f35343c & 2) == 2) {
            codedOutputStream.O(2, this.f35345e);
        }
        codedOutputStream.i0(this.f35342b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
    public InterfaceC4188h<ProtoBuf$CompilerPluginData> getParserForType() {
        return f35341i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i10 = this.f35347g;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f35343c & 1) == 1 ? CodedOutputStream.o(1, this.f35344d) : 0;
        if ((this.f35343c & 2) == 2) {
            iO += CodedOutputStream.d(2, this.f35345e);
        }
        int size = iO + this.f35342b.size();
        this.f35347g = size;
        return size;
    }

    @Override // ia.InterfaceC4187g
    public final boolean isInitialized() {
        byte b10 = this.f35346f;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!x()) {
            this.f35346f = (byte) 0;
            return false;
        }
        if (w()) {
            this.f35346f = (byte) 1;
            return true;
        }
        this.f35346f = (byte) 0;
        return false;
    }

    public AbstractC4182b t() {
        return this.f35345e;
    }

    public int v() {
        return this.f35344d;
    }

    public boolean w() {
        return (this.f35343c & 2) == 2;
    }

    public boolean x() {
        return (this.f35343c & 1) == 1;
    }

    public ProtoBuf$CompilerPluginData(GeneratedMessageLite.b bVar) {
        super(bVar);
        this.f35346f = (byte) -1;
        this.f35347g = -1;
        this.f35342b = bVar.h();
    }

    public ProtoBuf$CompilerPluginData(boolean z10) {
        this.f35346f = (byte) -1;
        this.f35347g = -1;
        this.f35342b = AbstractC4182b.f33086a;
    }

    public ProtoBuf$CompilerPluginData(c cVar, d dVar) throws InvalidProtocolBufferException {
        this.f35346f = (byte) -1;
        this.f35347g = -1;
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
                            this.f35343c |= 1;
                            this.f35344d = cVar.s();
                        } else if (iK != 18) {
                            if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                            }
                        } else {
                            this.f35343c |= 2;
                            this.f35345e = cVar.l();
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    try {
                        codedOutputStreamJ.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f35342b = c0409bT.l();
                        throw th2;
                    }
                    this.f35342b = c0409bT.l();
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
            this.f35342b = c0409bT.l();
            throw th3;
        }
        this.f35342b = c0409bT.l();
        g();
    }
}
