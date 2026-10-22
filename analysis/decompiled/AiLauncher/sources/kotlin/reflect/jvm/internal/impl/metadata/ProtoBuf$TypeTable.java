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
public final class ProtoBuf$TypeTable extends GeneratedMessageLite implements InterfaceC4187g {

    /* renamed from: h, reason: collision with root package name */
    public static final ProtoBuf$TypeTable f35677h;

    /* renamed from: i, reason: collision with root package name */
    public static InterfaceC4188h<ProtoBuf$TypeTable> f35678i = new a();

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC4182b f35679b;

    /* renamed from: c, reason: collision with root package name */
    public int f35680c;

    /* renamed from: d, reason: collision with root package name */
    public List<ProtoBuf$Type> f35681d;

    /* renamed from: e, reason: collision with root package name */
    public int f35682e;

    /* renamed from: f, reason: collision with root package name */
    public byte f35683f;

    /* renamed from: g, reason: collision with root package name */
    public int f35684g;

    public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ProtoBuf$TypeTable> {
        @Override // ia.InterfaceC4188h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$TypeTable c(c cVar, d dVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$TypeTable(cVar, dVar);
        }
    }

    public static final class b extends GeneratedMessageLite.b<ProtoBuf$TypeTable, b> implements InterfaceC4187g {

        /* renamed from: b, reason: collision with root package name */
        public int f35685b;

        /* renamed from: c, reason: collision with root package name */
        public List<ProtoBuf$Type> f35686c = Collections.EMPTY_LIST;

        /* renamed from: d, reason: collision with root package name */
        public int f35687d = -1;

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
        public ProtoBuf$TypeTable build() {
            ProtoBuf$TypeTable protoBuf$TypeTableO = o();
            if (protoBuf$TypeTableO.isInitialized()) {
                return protoBuf$TypeTableO;
            }
            throw a.AbstractC0449a.f(protoBuf$TypeTableO);
        }

        public ProtoBuf$TypeTable o() {
            ProtoBuf$TypeTable protoBuf$TypeTable = new ProtoBuf$TypeTable(this);
            int i10 = this.f35685b;
            if ((i10 & 1) == 1) {
                this.f35686c = Collections.unmodifiableList(this.f35686c);
                this.f35685b &= -2;
            }
            protoBuf$TypeTable.f35681d = this.f35686c;
            int i11 = (i10 & 2) != 2 ? 0 : 1;
            protoBuf$TypeTable.f35682e = this.f35687d;
            protoBuf$TypeTable.f35680c = i11;
            return protoBuf$TypeTable;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b g() {
            return q().i(o());
        }

        public final void r() {
            if ((this.f35685b & 1) != 1) {
                this.f35686c = new ArrayList(this.f35686c);
                this.f35685b |= 1;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public b i(ProtoBuf$TypeTable protoBuf$TypeTable) {
            if (protoBuf$TypeTable == ProtoBuf$TypeTable.u()) {
                return this;
            }
            if (!protoBuf$TypeTable.f35681d.isEmpty()) {
                if (this.f35686c.isEmpty()) {
                    this.f35686c = protoBuf$TypeTable.f35681d;
                    this.f35685b &= -2;
                } else {
                    r();
                    this.f35686c.addAll(protoBuf$TypeTable.f35681d);
                }
            }
            if (protoBuf$TypeTable.z()) {
                v(protoBuf$TypeTable.v());
            }
            j(h().c(protoBuf$TypeTable.f35679b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable.f35678i     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$b");
        }

        public b v(int i10) {
            this.f35685b |= 2;
            this.f35687d = i10;
            return this;
        }
    }

    static {
        ProtoBuf$TypeTable protoBuf$TypeTable = new ProtoBuf$TypeTable(true);
        f35677h = protoBuf$TypeTable;
        protoBuf$TypeTable.A();
    }

    private void A() {
        this.f35681d = Collections.EMPTY_LIST;
        this.f35682e = -1;
    }

    public static b C() {
        return b.q();
    }

    public static b D(ProtoBuf$TypeTable protoBuf$TypeTable) {
        return C().i(protoBuf$TypeTable);
    }

    public static ProtoBuf$TypeTable u() {
        return f35677h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return C();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return D(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        for (int i10 = 0; i10 < this.f35681d.size(); i10++) {
            codedOutputStream.d0(1, this.f35681d.get(i10));
        }
        if ((this.f35680c & 1) == 1) {
            codedOutputStream.a0(2, this.f35682e);
        }
        codedOutputStream.i0(this.f35679b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
    public InterfaceC4188h<ProtoBuf$TypeTable> getParserForType() {
        return f35678i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i10 = this.f35684g;
        if (i10 != -1) {
            return i10;
        }
        int iO = 0;
        for (int i11 = 0; i11 < this.f35681d.size(); i11++) {
            iO += CodedOutputStream.s(1, this.f35681d.get(i11));
        }
        if ((this.f35680c & 1) == 1) {
            iO += CodedOutputStream.o(2, this.f35682e);
        }
        int size = iO + this.f35679b.size();
        this.f35684g = size;
        return size;
    }

    @Override // ia.InterfaceC4187g
    public final boolean isInitialized() {
        byte b10 = this.f35683f;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i10 = 0; i10 < x(); i10++) {
            if (!w(i10).isInitialized()) {
                this.f35683f = (byte) 0;
                return false;
            }
        }
        this.f35683f = (byte) 1;
        return true;
    }

    public int v() {
        return this.f35682e;
    }

    public ProtoBuf$Type w(int i10) {
        return this.f35681d.get(i10);
    }

    public int x() {
        return this.f35681d.size();
    }

    public List<ProtoBuf$Type> y() {
        return this.f35681d;
    }

    public boolean z() {
        return (this.f35680c & 1) == 1;
    }

    public ProtoBuf$TypeTable(GeneratedMessageLite.b bVar) {
        super(bVar);
        this.f35683f = (byte) -1;
        this.f35684g = -1;
        this.f35679b = bVar.h();
    }

    public ProtoBuf$TypeTable(boolean z10) {
        this.f35683f = (byte) -1;
        this.f35684g = -1;
        this.f35679b = AbstractC4182b.f33086a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBuf$TypeTable(c cVar, d dVar) throws InvalidProtocolBufferException {
        this.f35683f = (byte) -1;
        this.f35684g = -1;
        A();
        AbstractC4182b.C0409b c0409bT = AbstractC4182b.t();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(c0409bT, 1);
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            try {
                try {
                    int iK = cVar.K();
                    if (iK != 0) {
                        if (iK == 10) {
                            if (!z11) {
                                this.f35681d = new ArrayList();
                                z11 = true;
                            }
                            this.f35681d.add(cVar.u(ProtoBuf$Type.f35583v, dVar));
                        } else if (iK != 16) {
                            if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                            }
                        } else {
                            this.f35680c |= 1;
                            this.f35682e = cVar.s();
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if (z11) {
                        this.f35681d = Collections.unmodifiableList(this.f35681d);
                    }
                    try {
                        codedOutputStreamJ.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f35679b = c0409bT.l();
                        throw th2;
                    }
                    this.f35679b = c0409bT.l();
                    g();
                    throw th;
                }
            } catch (InvalidProtocolBufferException e10) {
                throw e10.i(this);
            } catch (IOException e11) {
                throw new InvalidProtocolBufferException(e11.getMessage()).i(this);
            }
        }
        if (z11) {
            this.f35681d = Collections.unmodifiableList(this.f35681d);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f35679b = c0409bT.l();
            throw th3;
        }
        this.f35679b = c0409bT.l();
        g();
    }
}
