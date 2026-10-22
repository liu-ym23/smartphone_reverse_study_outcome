package kotlin.reflect.jvm.internal.impl.metadata;

import ia.AbstractC4182b;
import ia.InterfaceC4187g;
import ia.InterfaceC4188h;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.c;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* loaded from: classes5.dex */
public final class ProtoBuf$Package extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Package> implements InterfaceC4187g {

    /* renamed from: l, reason: collision with root package name */
    public static final ProtoBuf$Package f35469l;

    /* renamed from: m, reason: collision with root package name */
    public static InterfaceC4188h<ProtoBuf$Package> f35470m = new a();

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC4182b f35471c;

    /* renamed from: d, reason: collision with root package name */
    public int f35472d;

    /* renamed from: e, reason: collision with root package name */
    public List<ProtoBuf$Function> f35473e;

    /* renamed from: f, reason: collision with root package name */
    public List<ProtoBuf$Property> f35474f;

    /* renamed from: g, reason: collision with root package name */
    public List<ProtoBuf$TypeAlias> f35475g;

    /* renamed from: h, reason: collision with root package name */
    public ProtoBuf$TypeTable f35476h;

    /* renamed from: i, reason: collision with root package name */
    public ProtoBuf$VersionRequirementTable f35477i;

    /* renamed from: j, reason: collision with root package name */
    public byte f35478j;

    /* renamed from: k, reason: collision with root package name */
    public int f35479k;

    public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ProtoBuf$Package> {
        @Override // ia.InterfaceC4188h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$Package c(c cVar, d dVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$Package(cVar, dVar);
        }
    }

    public static final class b extends GeneratedMessageLite.c<ProtoBuf$Package, b> implements InterfaceC4187g {

        /* renamed from: d, reason: collision with root package name */
        public int f35480d;

        /* renamed from: e, reason: collision with root package name */
        public List<ProtoBuf$Function> f35481e;

        /* renamed from: f, reason: collision with root package name */
        public List<ProtoBuf$Property> f35482f;

        /* renamed from: g, reason: collision with root package name */
        public List<ProtoBuf$TypeAlias> f35483g;

        /* renamed from: h, reason: collision with root package name */
        public ProtoBuf$TypeTable f35484h;

        /* renamed from: i, reason: collision with root package name */
        public ProtoBuf$VersionRequirementTable f35485i;

        public b() {
            List list = Collections.EMPTY_LIST;
            this.f35481e = list;
            this.f35482f = list;
            this.f35483g = list;
            this.f35484h = ProtoBuf$TypeTable.u();
            this.f35485i = ProtoBuf$VersionRequirementTable.s();
            y();
        }

        public static b u() {
            return new b();
        }

        private void v() {
            if ((this.f35480d & 1) != 1) {
                this.f35481e = new ArrayList(this.f35481e);
                this.f35480d |= 1;
            }
        }

        private void w() {
            if ((this.f35480d & 2) != 2) {
                this.f35482f = new ArrayList(this.f35482f);
                this.f35480d |= 2;
            }
        }

        private void x() {
            if ((this.f35480d & 4) != 4) {
                this.f35483g = new ArrayList(this.f35483g);
                this.f35480d |= 4;
            }
        }

        private void y() {
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package.f35470m     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package$b");
        }

        public b C(ProtoBuf$TypeTable protoBuf$TypeTable) {
            if ((this.f35480d & 8) != 8 || this.f35484h == ProtoBuf$TypeTable.u()) {
                this.f35484h = protoBuf$TypeTable;
            } else {
                this.f35484h = ProtoBuf$TypeTable.D(this.f35484h).i(protoBuf$TypeTable).o();
            }
            this.f35480d |= 8;
            return this;
        }

        public b D(ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable) {
            if ((this.f35480d & 16) != 16 || this.f35485i == ProtoBuf$VersionRequirementTable.s()) {
                this.f35485i = protoBuf$VersionRequirementTable;
            } else {
                this.f35485i = ProtoBuf$VersionRequirementTable.x(this.f35485i).i(protoBuf$VersionRequirementTable).o();
            }
            this.f35480d |= 16;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$Package build() {
            ProtoBuf$Package protoBuf$PackageS = s();
            if (protoBuf$PackageS.isInitialized()) {
                return protoBuf$PackageS;
            }
            throw a.AbstractC0449a.f(protoBuf$PackageS);
        }

        public ProtoBuf$Package s() {
            ProtoBuf$Package protoBuf$Package = new ProtoBuf$Package(this);
            int i10 = this.f35480d;
            if ((i10 & 1) == 1) {
                this.f35481e = Collections.unmodifiableList(this.f35481e);
                this.f35480d &= -2;
            }
            protoBuf$Package.f35473e = this.f35481e;
            if ((this.f35480d & 2) == 2) {
                this.f35482f = Collections.unmodifiableList(this.f35482f);
                this.f35480d &= -3;
            }
            protoBuf$Package.f35474f = this.f35482f;
            if ((this.f35480d & 4) == 4) {
                this.f35483g = Collections.unmodifiableList(this.f35483g);
                this.f35480d &= -5;
            }
            protoBuf$Package.f35475g = this.f35483g;
            int i11 = (i10 & 8) != 8 ? 0 : 1;
            protoBuf$Package.f35476h = this.f35484h;
            if ((i10 & 16) == 16) {
                i11 |= 2;
            }
            protoBuf$Package.f35477i = this.f35485i;
            protoBuf$Package.f35472d = i11;
            return protoBuf$Package;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public b g() {
            return u().i(s());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public b i(ProtoBuf$Package protoBuf$Package) {
            if (protoBuf$Package == ProtoBuf$Package.K()) {
                return this;
            }
            if (!protoBuf$Package.f35473e.isEmpty()) {
                if (this.f35481e.isEmpty()) {
                    this.f35481e = protoBuf$Package.f35473e;
                    this.f35480d &= -2;
                } else {
                    v();
                    this.f35481e.addAll(protoBuf$Package.f35473e);
                }
            }
            if (!protoBuf$Package.f35474f.isEmpty()) {
                if (this.f35482f.isEmpty()) {
                    this.f35482f = protoBuf$Package.f35474f;
                    this.f35480d &= -3;
                } else {
                    w();
                    this.f35482f.addAll(protoBuf$Package.f35474f);
                }
            }
            if (!protoBuf$Package.f35475g.isEmpty()) {
                if (this.f35483g.isEmpty()) {
                    this.f35483g = protoBuf$Package.f35475g;
                    this.f35480d &= -5;
                } else {
                    x();
                    this.f35483g.addAll(protoBuf$Package.f35475g);
                }
            }
            if (protoBuf$Package.X()) {
                C(protoBuf$Package.V());
            }
            if (protoBuf$Package.Y()) {
                D(protoBuf$Package.W());
            }
            p(protoBuf$Package);
            j(h().c(protoBuf$Package.f35471c));
            return this;
        }
    }

    static {
        ProtoBuf$Package protoBuf$Package = new ProtoBuf$Package(true);
        f35469l = protoBuf$Package;
        protoBuf$Package.Z();
    }

    public static ProtoBuf$Package K() {
        return f35469l;
    }

    private void Z() {
        List list = Collections.EMPTY_LIST;
        this.f35473e = list;
        this.f35474f = list;
        this.f35475g = list;
        this.f35476h = ProtoBuf$TypeTable.u();
        this.f35477i = ProtoBuf$VersionRequirementTable.s();
    }

    public static b a0() {
        return b.u();
    }

    public static b b0(ProtoBuf$Package protoBuf$Package) {
        return a0().i(protoBuf$Package);
    }

    public static ProtoBuf$Package d0(InputStream inputStream, d dVar) throws IOException {
        return f35470m.a(inputStream, dVar);
    }

    @Override // ia.InterfaceC4187g
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public ProtoBuf$Package getDefaultInstanceForType() {
        return f35469l;
    }

    public ProtoBuf$Function M(int i10) {
        return this.f35473e.get(i10);
    }

    public int N() {
        return this.f35473e.size();
    }

    public List<ProtoBuf$Function> O() {
        return this.f35473e;
    }

    public ProtoBuf$Property P(int i10) {
        return this.f35474f.get(i10);
    }

    public int Q() {
        return this.f35474f.size();
    }

    public List<ProtoBuf$Property> R() {
        return this.f35474f;
    }

    public ProtoBuf$TypeAlias S(int i10) {
        return this.f35475g.get(i10);
    }

    public int T() {
        return this.f35475g.size();
    }

    public List<ProtoBuf$TypeAlias> U() {
        return this.f35475g;
    }

    public ProtoBuf$TypeTable V() {
        return this.f35476h;
    }

    public ProtoBuf$VersionRequirementTable W() {
        return this.f35477i;
    }

    public boolean X() {
        return (this.f35472d & 1) == 1;
    }

    public boolean Y() {
        return (this.f35472d & 2) == 2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.a aVarW = w();
        for (int i10 = 0; i10 < this.f35473e.size(); i10++) {
            codedOutputStream.d0(3, this.f35473e.get(i10));
        }
        for (int i11 = 0; i11 < this.f35474f.size(); i11++) {
            codedOutputStream.d0(4, this.f35474f.get(i11));
        }
        for (int i12 = 0; i12 < this.f35475g.size(); i12++) {
            codedOutputStream.d0(5, this.f35475g.get(i12));
        }
        if ((this.f35472d & 1) == 1) {
            codedOutputStream.d0(30, this.f35476h);
        }
        if ((this.f35472d & 2) == 2) {
            codedOutputStream.d0(32, this.f35477i);
        }
        aVarW.a(200, codedOutputStream);
        codedOutputStream.i0(this.f35471c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return a0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return b0(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
    public InterfaceC4188h<ProtoBuf$Package> getParserForType() {
        return f35470m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i10 = this.f35479k;
        if (i10 != -1) {
            return i10;
        }
        int iS = 0;
        for (int i11 = 0; i11 < this.f35473e.size(); i11++) {
            iS += CodedOutputStream.s(3, this.f35473e.get(i11));
        }
        for (int i12 = 0; i12 < this.f35474f.size(); i12++) {
            iS += CodedOutputStream.s(4, this.f35474f.get(i12));
        }
        for (int i13 = 0; i13 < this.f35475g.size(); i13++) {
            iS += CodedOutputStream.s(5, this.f35475g.get(i13));
        }
        if ((this.f35472d & 1) == 1) {
            iS += CodedOutputStream.s(30, this.f35476h);
        }
        if ((this.f35472d & 2) == 2) {
            iS += CodedOutputStream.s(32, this.f35477i);
        }
        int iQ = iS + q() + this.f35471c.size();
        this.f35479k = iQ;
        return iQ;
    }

    @Override // ia.InterfaceC4187g
    public final boolean isInitialized() {
        byte b10 = this.f35478j;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i10 = 0; i10 < N(); i10++) {
            if (!M(i10).isInitialized()) {
                this.f35478j = (byte) 0;
                return false;
            }
        }
        for (int i11 = 0; i11 < Q(); i11++) {
            if (!P(i11).isInitialized()) {
                this.f35478j = (byte) 0;
                return false;
            }
        }
        for (int i12 = 0; i12 < T(); i12++) {
            if (!S(i12).isInitialized()) {
                this.f35478j = (byte) 0;
                return false;
            }
        }
        if (X() && !V().isInitialized()) {
            this.f35478j = (byte) 0;
            return false;
        }
        if (n()) {
            this.f35478j = (byte) 1;
            return true;
        }
        this.f35478j = (byte) 0;
        return false;
    }

    public ProtoBuf$Package(GeneratedMessageLite.c<ProtoBuf$Package, ?> cVar) {
        super(cVar);
        this.f35478j = (byte) -1;
        this.f35479k = -1;
        this.f35471c = cVar.h();
    }

    public ProtoBuf$Package(boolean z10) {
        this.f35478j = (byte) -1;
        this.f35479k = -1;
        this.f35471c = AbstractC4182b.f33086a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public ProtoBuf$Package(c cVar, d dVar) throws InvalidProtocolBufferException {
        this.f35478j = (byte) -1;
        this.f35479k = -1;
        Z();
        AbstractC4182b.C0409b c0409bT = AbstractC4182b.t();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(c0409bT, 1);
        boolean z10 = false;
        char c10 = 0;
        while (!z10) {
            try {
                try {
                    int iK = cVar.K();
                    if (iK != 0) {
                        if (iK == 26) {
                            int i10 = (c10 == true ? 1 : 0) & 1;
                            c10 = c10;
                            if (i10 != 1) {
                                this.f35473e = new ArrayList();
                                c10 = (c10 == true ? 1 : 0) | 1;
                            }
                            this.f35473e.add(cVar.u(ProtoBuf$Function.f35425A, dVar));
                        } else if (iK == 34) {
                            int i11 = (c10 == true ? 1 : 0) & 2;
                            c10 = c10;
                            if (i11 != 2) {
                                this.f35474f = new ArrayList();
                                c10 = (c10 == true ? 1 : 0) | 2;
                            }
                            this.f35474f.add(cVar.u(ProtoBuf$Property.f35502E, dVar));
                        } else if (iK != 42) {
                            if (iK == 242) {
                                ProtoBuf$TypeTable.b bVarF = (this.f35472d & 1) == 1 ? this.f35476h.toBuilder() : null;
                                ProtoBuf$TypeTable protoBuf$TypeTable = (ProtoBuf$TypeTable) cVar.u(ProtoBuf$TypeTable.f35678i, dVar);
                                this.f35476h = protoBuf$TypeTable;
                                if (bVarF != null) {
                                    bVarF.i(protoBuf$TypeTable);
                                    this.f35476h = bVarF.o();
                                }
                                this.f35472d |= 1;
                            } else if (iK != 258) {
                                if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                                }
                            } else {
                                ProtoBuf$VersionRequirementTable.b bVarZ = (this.f35472d & 2) == 2 ? this.f35477i.toBuilder() : null;
                                ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable = (ProtoBuf$VersionRequirementTable) cVar.u(ProtoBuf$VersionRequirementTable.f35731g, dVar);
                                this.f35477i = protoBuf$VersionRequirementTable;
                                if (bVarZ != null) {
                                    bVarZ.i(protoBuf$VersionRequirementTable);
                                    this.f35477i = bVarZ.o();
                                }
                                this.f35472d |= 2;
                            }
                        } else {
                            int i12 = (c10 == true ? 1 : 0) & 4;
                            c10 = c10;
                            if (i12 != 4) {
                                this.f35475g = new ArrayList();
                                c10 = (c10 == true ? 1 : 0) | 4;
                            }
                            this.f35475g.add(cVar.u(ProtoBuf$TypeAlias.f35631r, dVar));
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if (((c10 == true ? 1 : 0) & 1) == 1) {
                        this.f35473e = Collections.unmodifiableList(this.f35473e);
                    }
                    if (((c10 == true ? 1 : 0) & 2) == 2) {
                        this.f35474f = Collections.unmodifiableList(this.f35474f);
                    }
                    if (((c10 == true ? 1 : 0) & 4) == 4) {
                        this.f35475g = Collections.unmodifiableList(this.f35475g);
                    }
                    try {
                        codedOutputStreamJ.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f35471c = c0409bT.l();
                        throw th2;
                    }
                    this.f35471c = c0409bT.l();
                    g();
                    throw th;
                }
            } catch (InvalidProtocolBufferException e10) {
                throw e10.i(this);
            } catch (IOException e11) {
                throw new InvalidProtocolBufferException(e11.getMessage()).i(this);
            }
        }
        if (((c10 == true ? 1 : 0) & 1) == 1) {
            this.f35473e = Collections.unmodifiableList(this.f35473e);
        }
        if (((c10 == true ? 1 : 0) & 2) == 2) {
            this.f35474f = Collections.unmodifiableList(this.f35474f);
        }
        if (((c10 == true ? 1 : 0) & 4) == 4) {
            this.f35475g = Collections.unmodifiableList(this.f35475g);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f35471c = c0409bT.l();
            throw th3;
        }
        this.f35471c = c0409bT.l();
        g();
    }
}
