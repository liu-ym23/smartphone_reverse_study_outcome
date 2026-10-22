package kotlin.reflect.jvm.internal.impl.metadata;

import ia.AbstractC4182b;
import ia.InterfaceC4187g;
import ia.InterfaceC4188h;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.c;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* loaded from: classes5.dex */
public final class ProtoBuf$PackageFragment extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$PackageFragment> implements InterfaceC4187g {

    /* renamed from: k, reason: collision with root package name */
    public static final ProtoBuf$PackageFragment f35486k;

    /* renamed from: l, reason: collision with root package name */
    public static InterfaceC4188h<ProtoBuf$PackageFragment> f35487l = new a();

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC4182b f35488c;

    /* renamed from: d, reason: collision with root package name */
    public int f35489d;

    /* renamed from: e, reason: collision with root package name */
    public ProtoBuf$StringTable f35490e;

    /* renamed from: f, reason: collision with root package name */
    public ProtoBuf$QualifiedNameTable f35491f;

    /* renamed from: g, reason: collision with root package name */
    public ProtoBuf$Package f35492g;

    /* renamed from: h, reason: collision with root package name */
    public List<ProtoBuf$Class> f35493h;

    /* renamed from: i, reason: collision with root package name */
    public byte f35494i;

    /* renamed from: j, reason: collision with root package name */
    public int f35495j;

    public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ProtoBuf$PackageFragment> {
        @Override // ia.InterfaceC4188h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$PackageFragment c(c cVar, d dVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$PackageFragment(cVar, dVar);
        }
    }

    public static final class b extends GeneratedMessageLite.c<ProtoBuf$PackageFragment, b> implements InterfaceC4187g {

        /* renamed from: d, reason: collision with root package name */
        public int f35496d;

        /* renamed from: e, reason: collision with root package name */
        public ProtoBuf$StringTable f35497e = ProtoBuf$StringTable.s();

        /* renamed from: f, reason: collision with root package name */
        public ProtoBuf$QualifiedNameTable f35498f = ProtoBuf$QualifiedNameTable.s();

        /* renamed from: g, reason: collision with root package name */
        public ProtoBuf$Package f35499g = ProtoBuf$Package.K();

        /* renamed from: h, reason: collision with root package name */
        public List<ProtoBuf$Class> f35500h = Collections.EMPTY_LIST;

        public b() {
            w();
        }

        public static b u() {
            return new b();
        }

        private void w() {
        }

        public b B(ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable) {
            if ((this.f35496d & 2) != 2 || this.f35498f == ProtoBuf$QualifiedNameTable.s()) {
                this.f35498f = protoBuf$QualifiedNameTable;
            } else {
                this.f35498f = ProtoBuf$QualifiedNameTable.x(this.f35498f).i(protoBuf$QualifiedNameTable).o();
            }
            this.f35496d |= 2;
            return this;
        }

        public b C(ProtoBuf$StringTable protoBuf$StringTable) {
            if ((this.f35496d & 1) != 1 || this.f35497e == ProtoBuf$StringTable.s()) {
                this.f35497e = protoBuf$StringTable;
            } else {
                this.f35497e = ProtoBuf$StringTable.x(this.f35497e).i(protoBuf$StringTable).o();
            }
            this.f35496d |= 1;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$PackageFragment build() {
            ProtoBuf$PackageFragment protoBuf$PackageFragmentS = s();
            if (protoBuf$PackageFragmentS.isInitialized()) {
                return protoBuf$PackageFragmentS;
            }
            throw a.AbstractC0449a.f(protoBuf$PackageFragmentS);
        }

        public ProtoBuf$PackageFragment s() {
            ProtoBuf$PackageFragment protoBuf$PackageFragment = new ProtoBuf$PackageFragment(this);
            int i10 = this.f35496d;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            protoBuf$PackageFragment.f35490e = this.f35497e;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            protoBuf$PackageFragment.f35491f = this.f35498f;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            protoBuf$PackageFragment.f35492g = this.f35499g;
            if ((this.f35496d & 8) == 8) {
                this.f35500h = Collections.unmodifiableList(this.f35500h);
                this.f35496d &= -9;
            }
            protoBuf$PackageFragment.f35493h = this.f35500h;
            protoBuf$PackageFragment.f35489d = i11;
            return protoBuf$PackageFragment;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public b g() {
            return u().i(s());
        }

        public final void v() {
            if ((this.f35496d & 8) != 8) {
                this.f35500h = new ArrayList(this.f35500h);
                this.f35496d |= 8;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public b i(ProtoBuf$PackageFragment protoBuf$PackageFragment) {
            if (protoBuf$PackageFragment == ProtoBuf$PackageFragment.K()) {
                return this;
            }
            if (protoBuf$PackageFragment.R()) {
                C(protoBuf$PackageFragment.O());
            }
            if (protoBuf$PackageFragment.Q()) {
                B(protoBuf$PackageFragment.N());
            }
            if (protoBuf$PackageFragment.P()) {
                z(protoBuf$PackageFragment.M());
            }
            if (!protoBuf$PackageFragment.f35493h.isEmpty()) {
                if (this.f35500h.isEmpty()) {
                    this.f35500h = protoBuf$PackageFragment.f35493h;
                    this.f35496d &= -9;
                } else {
                    v();
                    this.f35500h.addAll(protoBuf$PackageFragment.f35493h);
                }
            }
            p(protoBuf$PackageFragment);
            j(h().c(protoBuf$PackageFragment.f35488c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment.f35487l     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment$b");
        }

        public b z(ProtoBuf$Package protoBuf$Package) {
            if ((this.f35496d & 4) != 4 || this.f35499g == ProtoBuf$Package.K()) {
                this.f35499g = protoBuf$Package;
            } else {
                this.f35499g = ProtoBuf$Package.b0(this.f35499g).i(protoBuf$Package).s();
            }
            this.f35496d |= 4;
            return this;
        }
    }

    static {
        ProtoBuf$PackageFragment protoBuf$PackageFragment = new ProtoBuf$PackageFragment(true);
        f35486k = protoBuf$PackageFragment;
        protoBuf$PackageFragment.S();
    }

    public static ProtoBuf$PackageFragment K() {
        return f35486k;
    }

    private void S() {
        this.f35490e = ProtoBuf$StringTable.s();
        this.f35491f = ProtoBuf$QualifiedNameTable.s();
        this.f35492g = ProtoBuf$Package.K();
        this.f35493h = Collections.EMPTY_LIST;
    }

    public static b T() {
        return b.u();
    }

    public static b U(ProtoBuf$PackageFragment protoBuf$PackageFragment) {
        return T().i(protoBuf$PackageFragment);
    }

    public static ProtoBuf$PackageFragment W(InputStream inputStream, d dVar) throws IOException {
        return f35487l.a(inputStream, dVar);
    }

    public ProtoBuf$Class G(int i10) {
        return this.f35493h.get(i10);
    }

    public int H() {
        return this.f35493h.size();
    }

    public List<ProtoBuf$Class> J() {
        return this.f35493h;
    }

    @Override // ia.InterfaceC4187g
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public ProtoBuf$PackageFragment getDefaultInstanceForType() {
        return f35486k;
    }

    public ProtoBuf$Package M() {
        return this.f35492g;
    }

    public ProtoBuf$QualifiedNameTable N() {
        return this.f35491f;
    }

    public ProtoBuf$StringTable O() {
        return this.f35490e;
    }

    public boolean P() {
        return (this.f35489d & 4) == 4;
    }

    public boolean Q() {
        return (this.f35489d & 2) == 2;
    }

    public boolean R() {
        return (this.f35489d & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return T();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return U(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.a aVarW = w();
        if ((this.f35489d & 1) == 1) {
            codedOutputStream.d0(1, this.f35490e);
        }
        if ((this.f35489d & 2) == 2) {
            codedOutputStream.d0(2, this.f35491f);
        }
        if ((this.f35489d & 4) == 4) {
            codedOutputStream.d0(3, this.f35492g);
        }
        for (int i10 = 0; i10 < this.f35493h.size(); i10++) {
            codedOutputStream.d0(4, this.f35493h.get(i10));
        }
        aVarW.a(200, codedOutputStream);
        codedOutputStream.i0(this.f35488c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
    public InterfaceC4188h<ProtoBuf$PackageFragment> getParserForType() {
        return f35487l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i10 = this.f35495j;
        if (i10 != -1) {
            return i10;
        }
        int iS = (this.f35489d & 1) == 1 ? CodedOutputStream.s(1, this.f35490e) : 0;
        if ((this.f35489d & 2) == 2) {
            iS += CodedOutputStream.s(2, this.f35491f);
        }
        if ((this.f35489d & 4) == 4) {
            iS += CodedOutputStream.s(3, this.f35492g);
        }
        for (int i11 = 0; i11 < this.f35493h.size(); i11++) {
            iS += CodedOutputStream.s(4, this.f35493h.get(i11));
        }
        int iQ = iS + q() + this.f35488c.size();
        this.f35495j = iQ;
        return iQ;
    }

    @Override // ia.InterfaceC4187g
    public final boolean isInitialized() {
        byte b10 = this.f35494i;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (Q() && !N().isInitialized()) {
            this.f35494i = (byte) 0;
            return false;
        }
        if (P() && !M().isInitialized()) {
            this.f35494i = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < H(); i10++) {
            if (!G(i10).isInitialized()) {
                this.f35494i = (byte) 0;
                return false;
            }
        }
        if (n()) {
            this.f35494i = (byte) 1;
            return true;
        }
        this.f35494i = (byte) 0;
        return false;
    }

    public ProtoBuf$PackageFragment(GeneratedMessageLite.c<ProtoBuf$PackageFragment, ?> cVar) {
        super(cVar);
        this.f35494i = (byte) -1;
        this.f35495j = -1;
        this.f35488c = cVar.h();
    }

    public ProtoBuf$PackageFragment(boolean z10) {
        this.f35494i = (byte) -1;
        this.f35495j = -1;
        this.f35488c = AbstractC4182b.f33086a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBuf$PackageFragment(c cVar, d dVar) throws InvalidProtocolBufferException {
        this.f35494i = (byte) -1;
        this.f35495j = -1;
        S();
        AbstractC4182b.C0409b c0409bT = AbstractC4182b.t();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(c0409bT, 1);
        boolean z10 = false;
        char c10 = 0;
        while (!z10) {
            try {
                try {
                    int iK = cVar.K();
                    if (iK != 0) {
                        if (iK == 10) {
                            ProtoBuf$StringTable.b bVarZ = (this.f35489d & 1) == 1 ? this.f35490e.toBuilder() : null;
                            ProtoBuf$StringTable protoBuf$StringTable = (ProtoBuf$StringTable) cVar.u(ProtoBuf$StringTable.f35575g, dVar);
                            this.f35490e = protoBuf$StringTable;
                            if (bVarZ != null) {
                                bVarZ.i(protoBuf$StringTable);
                                this.f35490e = bVarZ.o();
                            }
                            this.f35489d |= 1;
                        } else if (iK == 18) {
                            ProtoBuf$QualifiedNameTable.b bVarZ2 = (this.f35489d & 2) == 2 ? this.f35491f.toBuilder() : null;
                            ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable = (ProtoBuf$QualifiedNameTable) cVar.u(ProtoBuf$QualifiedNameTable.f35554g, dVar);
                            this.f35491f = protoBuf$QualifiedNameTable;
                            if (bVarZ2 != null) {
                                bVarZ2.i(protoBuf$QualifiedNameTable);
                                this.f35491f = bVarZ2.o();
                            }
                            this.f35489d |= 2;
                        } else if (iK == 26) {
                            ProtoBuf$Package.b builder = (this.f35489d & 4) == 4 ? this.f35492g.toBuilder() : null;
                            ProtoBuf$Package protoBuf$Package = (ProtoBuf$Package) cVar.u(ProtoBuf$Package.f35470m, dVar);
                            this.f35492g = protoBuf$Package;
                            if (builder != null) {
                                builder.i(protoBuf$Package);
                                this.f35492g = builder.s();
                            }
                            this.f35489d |= 4;
                        } else if (iK != 34) {
                            if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                            }
                        } else {
                            int i10 = (c10 == true ? 1 : 0) & '\b';
                            c10 = c10;
                            if (i10 != 8) {
                                this.f35493h = new ArrayList();
                                c10 = '\b';
                            }
                            this.f35493h.add(cVar.u(ProtoBuf$Class.f35284I, dVar));
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if (((c10 == true ? 1 : 0) & '\b') == 8) {
                        this.f35493h = Collections.unmodifiableList(this.f35493h);
                    }
                    try {
                        codedOutputStreamJ.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f35488c = c0409bT.l();
                        throw th2;
                    }
                    this.f35488c = c0409bT.l();
                    g();
                    throw th;
                }
            } catch (InvalidProtocolBufferException e10) {
                throw e10.i(this);
            } catch (IOException e11) {
                throw new InvalidProtocolBufferException(e11.getMessage()).i(this);
            }
        }
        if (((c10 == true ? 1 : 0) & '\b') == 8) {
            this.f35493h = Collections.unmodifiableList(this.f35493h);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f35488c = c0409bT.l();
            throw th3;
        }
        this.f35488c = c0409bT.l();
        g();
    }
}
