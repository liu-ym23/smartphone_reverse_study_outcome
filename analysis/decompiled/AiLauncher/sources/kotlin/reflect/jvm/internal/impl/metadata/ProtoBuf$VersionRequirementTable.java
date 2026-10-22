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
public final class ProtoBuf$VersionRequirementTable extends GeneratedMessageLite implements InterfaceC4187g {

    /* renamed from: f, reason: collision with root package name */
    public static final ProtoBuf$VersionRequirementTable f35730f;

    /* renamed from: g, reason: collision with root package name */
    public static InterfaceC4188h<ProtoBuf$VersionRequirementTable> f35731g = new a();

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC4182b f35732b;

    /* renamed from: c, reason: collision with root package name */
    public List<ProtoBuf$VersionRequirement> f35733c;

    /* renamed from: d, reason: collision with root package name */
    public byte f35734d;

    /* renamed from: e, reason: collision with root package name */
    public int f35735e;

    public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ProtoBuf$VersionRequirementTable> {
        @Override // ia.InterfaceC4188h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$VersionRequirementTable c(c cVar, d dVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$VersionRequirementTable(cVar, dVar);
        }
    }

    public static final class b extends GeneratedMessageLite.b<ProtoBuf$VersionRequirementTable, b> implements InterfaceC4187g {

        /* renamed from: b, reason: collision with root package name */
        public int f35736b;

        /* renamed from: c, reason: collision with root package name */
        public List<ProtoBuf$VersionRequirement> f35737c = Collections.EMPTY_LIST;

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
        public ProtoBuf$VersionRequirementTable build() {
            ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTableO = o();
            if (protoBuf$VersionRequirementTableO.isInitialized()) {
                return protoBuf$VersionRequirementTableO;
            }
            throw a.AbstractC0449a.f(protoBuf$VersionRequirementTableO);
        }

        public ProtoBuf$VersionRequirementTable o() {
            ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable = new ProtoBuf$VersionRequirementTable(this);
            if ((this.f35736b & 1) == 1) {
                this.f35737c = Collections.unmodifiableList(this.f35737c);
                this.f35736b &= -2;
            }
            protoBuf$VersionRequirementTable.f35733c = this.f35737c;
            return protoBuf$VersionRequirementTable;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b g() {
            return q().i(o());
        }

        public final void r() {
            if ((this.f35736b & 1) != 1) {
                this.f35737c = new ArrayList(this.f35737c);
                this.f35736b |= 1;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public b i(ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable) {
            if (protoBuf$VersionRequirementTable == ProtoBuf$VersionRequirementTable.s()) {
                return this;
            }
            if (!protoBuf$VersionRequirementTable.f35733c.isEmpty()) {
                if (this.f35737c.isEmpty()) {
                    this.f35737c = protoBuf$VersionRequirementTable.f35733c;
                    this.f35736b &= -2;
                } else {
                    r();
                    this.f35737c.addAll(protoBuf$VersionRequirementTable.f35733c);
                }
            }
            j(h().c(protoBuf$VersionRequirementTable.f35732b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable.f35731g     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable$b");
        }
    }

    static {
        ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable = new ProtoBuf$VersionRequirementTable(true);
        f35730f = protoBuf$VersionRequirementTable;
        protoBuf$VersionRequirementTable.v();
    }

    public static ProtoBuf$VersionRequirementTable s() {
        return f35730f;
    }

    private void v() {
        this.f35733c = Collections.EMPTY_LIST;
    }

    public static b w() {
        return b.q();
    }

    public static b x(ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable) {
        return w().i(protoBuf$VersionRequirementTable);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        for (int i10 = 0; i10 < this.f35733c.size(); i10++) {
            codedOutputStream.d0(1, this.f35733c.get(i10));
        }
        codedOutputStream.i0(this.f35732b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
    public InterfaceC4188h<ProtoBuf$VersionRequirementTable> getParserForType() {
        return f35731g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i10 = this.f35735e;
        if (i10 != -1) {
            return i10;
        }
        int iS = 0;
        for (int i11 = 0; i11 < this.f35733c.size(); i11++) {
            iS += CodedOutputStream.s(1, this.f35733c.get(i11));
        }
        int size = iS + this.f35732b.size();
        this.f35735e = size;
        return size;
    }

    @Override // ia.InterfaceC4187g
    public final boolean isInitialized() {
        byte b10 = this.f35734d;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        this.f35734d = (byte) 1;
        return true;
    }

    public int t() {
        return this.f35733c.size();
    }

    public List<ProtoBuf$VersionRequirement> u() {
        return this.f35733c;
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

    public ProtoBuf$VersionRequirementTable(GeneratedMessageLite.b bVar) {
        super(bVar);
        this.f35734d = (byte) -1;
        this.f35735e = -1;
        this.f35732b = bVar.h();
    }

    public ProtoBuf$VersionRequirementTable(boolean z10) {
        this.f35734d = (byte) -1;
        this.f35735e = -1;
        this.f35732b = AbstractC4182b.f33086a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBuf$VersionRequirementTable(c cVar, d dVar) throws InvalidProtocolBufferException {
        this.f35734d = (byte) -1;
        this.f35735e = -1;
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
                                    this.f35733c = new ArrayList();
                                    z11 = true;
                                }
                                this.f35733c.add(cVar.u(ProtoBuf$VersionRequirement.f35712m, dVar));
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
                    this.f35733c = Collections.unmodifiableList(this.f35733c);
                }
                try {
                    codedOutputStreamJ.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f35732b = c0409bT.l();
                    throw th2;
                }
                this.f35732b = c0409bT.l();
                g();
                throw th;
            }
        }
        if (z11) {
            this.f35733c = Collections.unmodifiableList(this.f35733c);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f35732b = c0409bT.l();
            throw th3;
        }
        this.f35732b = c0409bT.l();
        g();
    }
}
