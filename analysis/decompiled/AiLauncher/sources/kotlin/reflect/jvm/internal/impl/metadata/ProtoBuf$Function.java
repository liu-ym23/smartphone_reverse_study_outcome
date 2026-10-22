package kotlin.reflect.jvm.internal.impl.metadata;

import ia.AbstractC4182b;
import ia.InterfaceC4187g;
import ia.InterfaceC4188h;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.io.IOException;
import java.io.InputStream;
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
public final class ProtoBuf$Function extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Function> implements InterfaceC4187g {

    /* renamed from: A, reason: collision with root package name */
    public static InterfaceC4188h<ProtoBuf$Function> f35425A = new a();

    /* renamed from: z, reason: collision with root package name */
    public static final ProtoBuf$Function f35426z;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC4182b f35427c;

    /* renamed from: d, reason: collision with root package name */
    public int f35428d;

    /* renamed from: e, reason: collision with root package name */
    public int f35429e;

    /* renamed from: f, reason: collision with root package name */
    public int f35430f;

    /* renamed from: g, reason: collision with root package name */
    public int f35431g;

    /* renamed from: h, reason: collision with root package name */
    public ProtoBuf$Type f35432h;

    /* renamed from: i, reason: collision with root package name */
    public int f35433i;

    /* renamed from: j, reason: collision with root package name */
    public List<ProtoBuf$TypeParameter> f35434j;

    /* renamed from: k, reason: collision with root package name */
    public ProtoBuf$Type f35435k;

    /* renamed from: l, reason: collision with root package name */
    public int f35436l;

    /* renamed from: m, reason: collision with root package name */
    public List<ProtoBuf$Type> f35437m;

    /* renamed from: n, reason: collision with root package name */
    public List<Integer> f35438n;

    /* renamed from: o, reason: collision with root package name */
    public int f35439o;

    /* renamed from: p, reason: collision with root package name */
    public List<ProtoBuf$ValueParameter> f35440p;

    /* renamed from: q, reason: collision with root package name */
    public List<ProtoBuf$ValueParameter> f35441q;

    /* renamed from: r, reason: collision with root package name */
    public ProtoBuf$TypeTable f35442r;

    /* renamed from: s, reason: collision with root package name */
    public List<Integer> f35443s;

    /* renamed from: t, reason: collision with root package name */
    public ProtoBuf$Contract f35444t;

    /* renamed from: u, reason: collision with root package name */
    public List<ProtoBuf$CompilerPluginData> f35445u;

    /* renamed from: v, reason: collision with root package name */
    public List<ProtoBuf$Annotation> f35446v;

    /* renamed from: w, reason: collision with root package name */
    public List<ProtoBuf$Annotation> f35447w;

    /* renamed from: x, reason: collision with root package name */
    public byte f35448x;

    /* renamed from: y, reason: collision with root package name */
    public int f35449y;

    public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ProtoBuf$Function> {
        @Override // ia.InterfaceC4188h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$Function c(c cVar, d dVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$Function(cVar, dVar);
        }
    }

    public static final class b extends GeneratedMessageLite.c<ProtoBuf$Function, b> implements InterfaceC4187g {

        /* renamed from: d, reason: collision with root package name */
        public int f35450d;

        /* renamed from: g, reason: collision with root package name */
        public int f35453g;

        /* renamed from: i, reason: collision with root package name */
        public int f35455i;

        /* renamed from: j, reason: collision with root package name */
        public List<ProtoBuf$TypeParameter> f35456j;

        /* renamed from: k, reason: collision with root package name */
        public ProtoBuf$Type f35457k;

        /* renamed from: l, reason: collision with root package name */
        public int f35458l;

        /* renamed from: m, reason: collision with root package name */
        public List<ProtoBuf$Type> f35459m;

        /* renamed from: n, reason: collision with root package name */
        public List<Integer> f35460n;

        /* renamed from: o, reason: collision with root package name */
        public List<ProtoBuf$ValueParameter> f35461o;

        /* renamed from: p, reason: collision with root package name */
        public List<ProtoBuf$ValueParameter> f35462p;

        /* renamed from: q, reason: collision with root package name */
        public ProtoBuf$TypeTable f35463q;

        /* renamed from: r, reason: collision with root package name */
        public List<Integer> f35464r;

        /* renamed from: s, reason: collision with root package name */
        public ProtoBuf$Contract f35465s;

        /* renamed from: t, reason: collision with root package name */
        public List<ProtoBuf$CompilerPluginData> f35466t;

        /* renamed from: u, reason: collision with root package name */
        public List<ProtoBuf$Annotation> f35467u;

        /* renamed from: v, reason: collision with root package name */
        public List<ProtoBuf$Annotation> f35468v;

        /* renamed from: e, reason: collision with root package name */
        public int f35451e = 6;

        /* renamed from: f, reason: collision with root package name */
        public int f35452f = 6;

        /* renamed from: h, reason: collision with root package name */
        public ProtoBuf$Type f35454h = ProtoBuf$Type.X();

        public b() {
            List list = Collections.EMPTY_LIST;
            this.f35456j = list;
            this.f35457k = ProtoBuf$Type.X();
            this.f35459m = list;
            this.f35460n = list;
            this.f35461o = list;
            this.f35462p = list;
            this.f35463q = ProtoBuf$TypeTable.u();
            this.f35464r = list;
            this.f35465s = ProtoBuf$Contract.s();
            this.f35466t = list;
            this.f35467u = list;
            this.f35468v = list;
            F();
        }

        private void C() {
            if ((this.f35450d & 32) != 32) {
                this.f35456j = new ArrayList(this.f35456j);
                this.f35450d |= 32;
            }
        }

        private void D() {
            if ((this.f35450d & 2048) != 2048) {
                this.f35462p = new ArrayList(this.f35462p);
                this.f35450d |= 2048;
            }
        }

        private void E() {
            if ((this.f35450d & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 8192) {
                this.f35464r = new ArrayList(this.f35464r);
                this.f35450d |= com.stepos.agentframework.chatui.longtext.b.THRESHOLD;
            }
        }

        private void F() {
        }

        public static b u() {
            return new b();
        }

        private void v() {
            if ((this.f35450d & 65536) != 65536) {
                this.f35467u = new ArrayList(this.f35467u);
                this.f35450d |= 65536;
            }
        }

        private void w() {
            if ((this.f35450d & 32768) != 32768) {
                this.f35466t = new ArrayList(this.f35466t);
                this.f35450d |= 32768;
            }
        }

        private void y() {
            if ((this.f35450d & 512) != 512) {
                this.f35460n = new ArrayList(this.f35460n);
                this.f35450d |= 512;
            }
        }

        private void z() {
            if ((this.f35450d & 256) != 256) {
                this.f35459m = new ArrayList(this.f35459m);
                this.f35450d |= 256;
            }
        }

        public final void B() {
            if ((this.f35450d & SQLiteDatabase.OPEN_SHAREDCACHE) != 131072) {
                this.f35468v = new ArrayList(this.f35468v);
                this.f35450d |= SQLiteDatabase.OPEN_SHAREDCACHE;
            }
        }

        public b H(ProtoBuf$Contract protoBuf$Contract) {
            if ((this.f35450d & 16384) != 16384 || this.f35465s == ProtoBuf$Contract.s()) {
                this.f35465s = protoBuf$Contract;
            } else {
                this.f35465s = ProtoBuf$Contract.y(this.f35465s).i(protoBuf$Contract).o();
            }
            this.f35450d |= 16384;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public b i(ProtoBuf$Function protoBuf$Function) {
            if (protoBuf$Function == ProtoBuf$Function.q0()) {
                return this;
            }
            if (protoBuf$Function.L0()) {
                O(protoBuf$Function.v0());
            }
            if (protoBuf$Function.N0()) {
                Q(protoBuf$Function.x0());
            }
            if (protoBuf$Function.M0()) {
                P(protoBuf$Function.w0());
            }
            if (protoBuf$Function.Q0()) {
                M(protoBuf$Function.A0());
            }
            if (protoBuf$Function.R0()) {
                S(protoBuf$Function.B0());
            }
            if (!protoBuf$Function.f35434j.isEmpty()) {
                if (this.f35456j.isEmpty()) {
                    this.f35456j = protoBuf$Function.f35434j;
                    this.f35450d &= -33;
                } else {
                    C();
                    this.f35456j.addAll(protoBuf$Function.f35434j);
                }
            }
            if (protoBuf$Function.O0()) {
                L(protoBuf$Function.y0());
            }
            if (protoBuf$Function.P0()) {
                R(protoBuf$Function.z0());
            }
            if (!protoBuf$Function.f35437m.isEmpty()) {
                if (this.f35459m.isEmpty()) {
                    this.f35459m = protoBuf$Function.f35437m;
                    this.f35450d &= -257;
                } else {
                    z();
                    this.f35459m.addAll(protoBuf$Function.f35437m);
                }
            }
            if (!protoBuf$Function.f35438n.isEmpty()) {
                if (this.f35460n.isEmpty()) {
                    this.f35460n = protoBuf$Function.f35438n;
                    this.f35450d &= -513;
                } else {
                    y();
                    this.f35460n.addAll(protoBuf$Function.f35438n);
                }
            }
            if (!protoBuf$Function.f35440p.isEmpty()) {
                if (this.f35461o.isEmpty()) {
                    this.f35461o = protoBuf$Function.f35440p;
                    this.f35450d &= -1025;
                } else {
                    x();
                    this.f35461o.addAll(protoBuf$Function.f35440p);
                }
            }
            if (!protoBuf$Function.f35441q.isEmpty()) {
                if (this.f35462p.isEmpty()) {
                    this.f35462p = protoBuf$Function.f35441q;
                    this.f35450d &= -2049;
                } else {
                    D();
                    this.f35462p.addAll(protoBuf$Function.f35441q);
                }
            }
            if (protoBuf$Function.S0()) {
                N(protoBuf$Function.F0());
            }
            if (!protoBuf$Function.f35443s.isEmpty()) {
                if (this.f35464r.isEmpty()) {
                    this.f35464r = protoBuf$Function.f35443s;
                    this.f35450d &= -8193;
                } else {
                    E();
                    this.f35464r.addAll(protoBuf$Function.f35443s);
                }
            }
            if (protoBuf$Function.K0()) {
                H(protoBuf$Function.p0());
            }
            if (!protoBuf$Function.f35445u.isEmpty()) {
                if (this.f35466t.isEmpty()) {
                    this.f35466t = protoBuf$Function.f35445u;
                    this.f35450d &= -32769;
                } else {
                    w();
                    this.f35466t.addAll(protoBuf$Function.f35445u);
                }
            }
            if (!protoBuf$Function.f35446v.isEmpty()) {
                if (this.f35467u.isEmpty()) {
                    this.f35467u = protoBuf$Function.f35446v;
                    this.f35450d &= -65537;
                } else {
                    v();
                    this.f35467u.addAll(protoBuf$Function.f35446v);
                }
            }
            if (!protoBuf$Function.f35447w.isEmpty()) {
                if (this.f35468v.isEmpty()) {
                    this.f35468v = protoBuf$Function.f35447w;
                    this.f35450d &= -131073;
                } else {
                    B();
                    this.f35468v.addAll(protoBuf$Function.f35447w);
                }
            }
            p(protoBuf$Function);
            j(h().c(protoBuf$Function.f35427c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function.f35425A     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function$b");
        }

        public b L(ProtoBuf$Type protoBuf$Type) {
            if ((this.f35450d & 64) != 64 || this.f35457k == ProtoBuf$Type.X()) {
                this.f35457k = protoBuf$Type;
            } else {
                this.f35457k = ProtoBuf$Type.y0(this.f35457k).i(protoBuf$Type).s();
            }
            this.f35450d |= 64;
            return this;
        }

        public b M(ProtoBuf$Type protoBuf$Type) {
            if ((this.f35450d & 8) != 8 || this.f35454h == ProtoBuf$Type.X()) {
                this.f35454h = protoBuf$Type;
            } else {
                this.f35454h = ProtoBuf$Type.y0(this.f35454h).i(protoBuf$Type).s();
            }
            this.f35450d |= 8;
            return this;
        }

        public b N(ProtoBuf$TypeTable protoBuf$TypeTable) {
            if ((this.f35450d & 4096) != 4096 || this.f35463q == ProtoBuf$TypeTable.u()) {
                this.f35463q = protoBuf$TypeTable;
            } else {
                this.f35463q = ProtoBuf$TypeTable.D(this.f35463q).i(protoBuf$TypeTable).o();
            }
            this.f35450d |= 4096;
            return this;
        }

        public b O(int i10) {
            this.f35450d |= 1;
            this.f35451e = i10;
            return this;
        }

        public b P(int i10) {
            this.f35450d |= 4;
            this.f35453g = i10;
            return this;
        }

        public b Q(int i10) {
            this.f35450d |= 2;
            this.f35452f = i10;
            return this;
        }

        public b R(int i10) {
            this.f35450d |= 128;
            this.f35458l = i10;
            return this;
        }

        public b S(int i10) {
            this.f35450d |= 16;
            this.f35455i = i10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$Function build() {
            ProtoBuf$Function protoBuf$FunctionS = s();
            if (protoBuf$FunctionS.isInitialized()) {
                return protoBuf$FunctionS;
            }
            throw a.AbstractC0449a.f(protoBuf$FunctionS);
        }

        public ProtoBuf$Function s() {
            ProtoBuf$Function protoBuf$Function = new ProtoBuf$Function(this);
            int i10 = this.f35450d;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            protoBuf$Function.f35429e = this.f35451e;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            protoBuf$Function.f35430f = this.f35452f;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            protoBuf$Function.f35431g = this.f35453g;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            protoBuf$Function.f35432h = this.f35454h;
            if ((i10 & 16) == 16) {
                i11 |= 16;
            }
            protoBuf$Function.f35433i = this.f35455i;
            if ((this.f35450d & 32) == 32) {
                this.f35456j = Collections.unmodifiableList(this.f35456j);
                this.f35450d &= -33;
            }
            protoBuf$Function.f35434j = this.f35456j;
            if ((i10 & 64) == 64) {
                i11 |= 32;
            }
            protoBuf$Function.f35435k = this.f35457k;
            if ((i10 & 128) == 128) {
                i11 |= 64;
            }
            protoBuf$Function.f35436l = this.f35458l;
            if ((this.f35450d & 256) == 256) {
                this.f35459m = Collections.unmodifiableList(this.f35459m);
                this.f35450d &= -257;
            }
            protoBuf$Function.f35437m = this.f35459m;
            if ((this.f35450d & 512) == 512) {
                this.f35460n = Collections.unmodifiableList(this.f35460n);
                this.f35450d &= -513;
            }
            protoBuf$Function.f35438n = this.f35460n;
            if ((this.f35450d & 1024) == 1024) {
                this.f35461o = Collections.unmodifiableList(this.f35461o);
                this.f35450d &= -1025;
            }
            protoBuf$Function.f35440p = this.f35461o;
            if ((this.f35450d & 2048) == 2048) {
                this.f35462p = Collections.unmodifiableList(this.f35462p);
                this.f35450d &= -2049;
            }
            protoBuf$Function.f35441q = this.f35462p;
            if ((i10 & 4096) == 4096) {
                i11 |= 128;
            }
            protoBuf$Function.f35442r = this.f35463q;
            if ((this.f35450d & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) == 8192) {
                this.f35464r = Collections.unmodifiableList(this.f35464r);
                this.f35450d &= -8193;
            }
            protoBuf$Function.f35443s = this.f35464r;
            if ((i10 & 16384) == 16384) {
                i11 |= 256;
            }
            protoBuf$Function.f35444t = this.f35465s;
            if ((this.f35450d & 32768) == 32768) {
                this.f35466t = Collections.unmodifiableList(this.f35466t);
                this.f35450d &= -32769;
            }
            protoBuf$Function.f35445u = this.f35466t;
            if ((this.f35450d & 65536) == 65536) {
                this.f35467u = Collections.unmodifiableList(this.f35467u);
                this.f35450d &= -65537;
            }
            protoBuf$Function.f35446v = this.f35467u;
            if ((this.f35450d & SQLiteDatabase.OPEN_SHAREDCACHE) == 131072) {
                this.f35468v = Collections.unmodifiableList(this.f35468v);
                this.f35450d &= -131073;
            }
            protoBuf$Function.f35447w = this.f35468v;
            protoBuf$Function.f35428d = i11;
            return protoBuf$Function;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public b g() {
            return u().i(s());
        }

        public final void x() {
            if ((this.f35450d & 1024) != 1024) {
                this.f35461o = new ArrayList(this.f35461o);
                this.f35450d |= 1024;
            }
        }
    }

    static {
        ProtoBuf$Function protoBuf$Function = new ProtoBuf$Function(true);
        f35426z = protoBuf$Function;
        protoBuf$Function.T0();
    }

    private void T0() {
        this.f35429e = 6;
        this.f35430f = 6;
        this.f35431g = 0;
        this.f35432h = ProtoBuf$Type.X();
        this.f35433i = 0;
        List list = Collections.EMPTY_LIST;
        this.f35434j = list;
        this.f35435k = ProtoBuf$Type.X();
        this.f35436l = 0;
        this.f35437m = list;
        this.f35438n = list;
        this.f35440p = list;
        this.f35441q = list;
        this.f35442r = ProtoBuf$TypeTable.u();
        this.f35443s = list;
        this.f35444t = ProtoBuf$Contract.s();
        this.f35445u = list;
        this.f35446v = list;
        this.f35447w = list;
    }

    public static b U0() {
        return b.u();
    }

    public static b V0(ProtoBuf$Function protoBuf$Function) {
        return U0().i(protoBuf$Function);
    }

    public static ProtoBuf$Function X0(InputStream inputStream, d dVar) throws IOException {
        return f35425A.a(inputStream, dVar);
    }

    public static ProtoBuf$Function q0() {
        return f35426z;
    }

    public ProtoBuf$Type A0() {
        return this.f35432h;
    }

    public int B0() {
        return this.f35433i;
    }

    public ProtoBuf$TypeParameter C0(int i10) {
        return this.f35434j.get(i10);
    }

    public int D0() {
        return this.f35434j.size();
    }

    public List<ProtoBuf$TypeParameter> E0() {
        return this.f35434j;
    }

    public ProtoBuf$TypeTable F0() {
        return this.f35442r;
    }

    public ProtoBuf$ValueParameter G0(int i10) {
        return this.f35441q.get(i10);
    }

    public int H0() {
        return this.f35441q.size();
    }

    public List<ProtoBuf$ValueParameter> I0() {
        return this.f35441q;
    }

    public List<Integer> J0() {
        return this.f35443s;
    }

    public boolean K0() {
        return (this.f35428d & 256) == 256;
    }

    public boolean L0() {
        return (this.f35428d & 1) == 1;
    }

    public boolean M0() {
        return (this.f35428d & 4) == 4;
    }

    public boolean N0() {
        return (this.f35428d & 2) == 2;
    }

    public boolean O0() {
        return (this.f35428d & 32) == 32;
    }

    public boolean P0() {
        return (this.f35428d & 64) == 64;
    }

    public boolean Q0() {
        return (this.f35428d & 8) == 8;
    }

    public boolean R0() {
        return (this.f35428d & 16) == 16;
    }

    public boolean S0() {
        return (this.f35428d & 128) == 128;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return U0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return V0(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.a aVarW = w();
        if ((this.f35428d & 2) == 2) {
            codedOutputStream.a0(1, this.f35430f);
        }
        if ((this.f35428d & 4) == 4) {
            codedOutputStream.a0(2, this.f35431g);
        }
        if ((this.f35428d & 8) == 8) {
            codedOutputStream.d0(3, this.f35432h);
        }
        for (int i10 = 0; i10 < this.f35434j.size(); i10++) {
            codedOutputStream.d0(4, this.f35434j.get(i10));
        }
        if ((this.f35428d & 32) == 32) {
            codedOutputStream.d0(5, this.f35435k);
        }
        for (int i11 = 0; i11 < this.f35441q.size(); i11++) {
            codedOutputStream.d0(6, this.f35441q.get(i11));
        }
        if ((this.f35428d & 16) == 16) {
            codedOutputStream.a0(7, this.f35433i);
        }
        if ((this.f35428d & 64) == 64) {
            codedOutputStream.a0(8, this.f35436l);
        }
        if ((this.f35428d & 1) == 1) {
            codedOutputStream.a0(9, this.f35429e);
        }
        for (int i12 = 0; i12 < this.f35437m.size(); i12++) {
            codedOutputStream.d0(10, this.f35437m.get(i12));
        }
        if (n0().size() > 0) {
            codedOutputStream.o0(90);
            codedOutputStream.o0(this.f35439o);
        }
        for (int i13 = 0; i13 < this.f35438n.size(); i13++) {
            codedOutputStream.b0(this.f35438n.get(i13).intValue());
        }
        for (int i14 = 0; i14 < this.f35446v.size(); i14++) {
            codedOutputStream.d0(12, this.f35446v.get(i14));
        }
        for (int i15 = 0; i15 < this.f35440p.size(); i15++) {
            codedOutputStream.d0(13, this.f35440p.get(i15));
        }
        if ((this.f35428d & 128) == 128) {
            codedOutputStream.d0(30, this.f35442r);
        }
        for (int i16 = 0; i16 < this.f35443s.size(); i16++) {
            codedOutputStream.a0(31, this.f35443s.get(i16).intValue());
        }
        if ((this.f35428d & 256) == 256) {
            codedOutputStream.d0(32, this.f35444t);
        }
        for (int i17 = 0; i17 < this.f35445u.size(); i17++) {
            codedOutputStream.d0(33, this.f35445u.get(i17));
        }
        for (int i18 = 0; i18 < this.f35447w.size(); i18++) {
            codedOutputStream.d0(34, this.f35447w.get(i18));
        }
        aVarW.a(19000, codedOutputStream);
        codedOutputStream.i0(this.f35427c);
    }

    public ProtoBuf$Annotation d0(int i10) {
        return this.f35446v.get(i10);
    }

    public int e0() {
        return this.f35446v.size();
    }

    public List<ProtoBuf$Annotation> f0() {
        return this.f35446v;
    }

    public ProtoBuf$CompilerPluginData g0(int i10) {
        return this.f35445u.get(i10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
    public InterfaceC4188h<ProtoBuf$Function> getParserForType() {
        return f35425A;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i10 = this.f35449y;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f35428d & 2) == 2 ? CodedOutputStream.o(1, this.f35430f) : 0;
        if ((this.f35428d & 4) == 4) {
            iO += CodedOutputStream.o(2, this.f35431g);
        }
        if ((this.f35428d & 8) == 8) {
            iO += CodedOutputStream.s(3, this.f35432h);
        }
        for (int i11 = 0; i11 < this.f35434j.size(); i11++) {
            iO += CodedOutputStream.s(4, this.f35434j.get(i11));
        }
        if ((this.f35428d & 32) == 32) {
            iO += CodedOutputStream.s(5, this.f35435k);
        }
        for (int i12 = 0; i12 < this.f35441q.size(); i12++) {
            iO += CodedOutputStream.s(6, this.f35441q.get(i12));
        }
        if ((this.f35428d & 16) == 16) {
            iO += CodedOutputStream.o(7, this.f35433i);
        }
        if ((this.f35428d & 64) == 64) {
            iO += CodedOutputStream.o(8, this.f35436l);
        }
        if ((this.f35428d & 1) == 1) {
            iO += CodedOutputStream.o(9, this.f35429e);
        }
        for (int i13 = 0; i13 < this.f35437m.size(); i13++) {
            iO += CodedOutputStream.s(10, this.f35437m.get(i13));
        }
        int iP = 0;
        for (int i14 = 0; i14 < this.f35438n.size(); i14++) {
            iP += CodedOutputStream.p(this.f35438n.get(i14).intValue());
        }
        int iS = iO + iP;
        if (!n0().isEmpty()) {
            iS = iS + 1 + CodedOutputStream.p(iP);
        }
        this.f35439o = iP;
        for (int i15 = 0; i15 < this.f35446v.size(); i15++) {
            iS += CodedOutputStream.s(12, this.f35446v.get(i15));
        }
        for (int i16 = 0; i16 < this.f35440p.size(); i16++) {
            iS += CodedOutputStream.s(13, this.f35440p.get(i16));
        }
        if ((this.f35428d & 128) == 128) {
            iS += CodedOutputStream.s(30, this.f35442r);
        }
        int iP2 = 0;
        for (int i17 = 0; i17 < this.f35443s.size(); i17++) {
            iP2 += CodedOutputStream.p(this.f35443s.get(i17).intValue());
        }
        int size = iS + iP2 + (J0().size() * 2);
        if ((this.f35428d & 256) == 256) {
            size += CodedOutputStream.s(32, this.f35444t);
        }
        for (int i18 = 0; i18 < this.f35445u.size(); i18++) {
            size += CodedOutputStream.s(33, this.f35445u.get(i18));
        }
        for (int i19 = 0; i19 < this.f35447w.size(); i19++) {
            size += CodedOutputStream.s(34, this.f35447w.get(i19));
        }
        int iQ = size + q() + this.f35427c.size();
        this.f35449y = iQ;
        return iQ;
    }

    public int h0() {
        return this.f35445u.size();
    }

    public ProtoBuf$ValueParameter i0(int i10) {
        return this.f35440p.get(i10);
    }

    @Override // ia.InterfaceC4187g
    public final boolean isInitialized() {
        byte b10 = this.f35448x;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!M0()) {
            this.f35448x = (byte) 0;
            return false;
        }
        if (Q0() && !A0().isInitialized()) {
            this.f35448x = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < D0(); i10++) {
            if (!C0(i10).isInitialized()) {
                this.f35448x = (byte) 0;
                return false;
            }
        }
        if (O0() && !y0().isInitialized()) {
            this.f35448x = (byte) 0;
            return false;
        }
        for (int i11 = 0; i11 < m0(); i11++) {
            if (!l0(i11).isInitialized()) {
                this.f35448x = (byte) 0;
                return false;
            }
        }
        for (int i12 = 0; i12 < j0(); i12++) {
            if (!i0(i12).isInitialized()) {
                this.f35448x = (byte) 0;
                return false;
            }
        }
        for (int i13 = 0; i13 < H0(); i13++) {
            if (!G0(i13).isInitialized()) {
                this.f35448x = (byte) 0;
                return false;
            }
        }
        if (S0() && !F0().isInitialized()) {
            this.f35448x = (byte) 0;
            return false;
        }
        if (K0() && !p0().isInitialized()) {
            this.f35448x = (byte) 0;
            return false;
        }
        for (int i14 = 0; i14 < h0(); i14++) {
            if (!g0(i14).isInitialized()) {
                this.f35448x = (byte) 0;
                return false;
            }
        }
        for (int i15 = 0; i15 < e0(); i15++) {
            if (!d0(i15).isInitialized()) {
                this.f35448x = (byte) 0;
                return false;
            }
        }
        for (int i16 = 0; i16 < t0(); i16++) {
            if (!s0(i16).isInitialized()) {
                this.f35448x = (byte) 0;
                return false;
            }
        }
        if (n()) {
            this.f35448x = (byte) 1;
            return true;
        }
        this.f35448x = (byte) 0;
        return false;
    }

    public int j0() {
        return this.f35440p.size();
    }

    public List<ProtoBuf$ValueParameter> k0() {
        return this.f35440p;
    }

    public ProtoBuf$Type l0(int i10) {
        return this.f35437m.get(i10);
    }

    public int m0() {
        return this.f35437m.size();
    }

    public List<Integer> n0() {
        return this.f35438n;
    }

    public List<ProtoBuf$Type> o0() {
        return this.f35437m;
    }

    public ProtoBuf$Contract p0() {
        return this.f35444t;
    }

    @Override // ia.InterfaceC4187g
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public ProtoBuf$Function getDefaultInstanceForType() {
        return f35426z;
    }

    public ProtoBuf$Annotation s0(int i10) {
        return this.f35447w.get(i10);
    }

    public int t0() {
        return this.f35447w.size();
    }

    public List<ProtoBuf$Annotation> u0() {
        return this.f35447w;
    }

    public int v0() {
        return this.f35429e;
    }

    public int w0() {
        return this.f35431g;
    }

    public int x0() {
        return this.f35430f;
    }

    public ProtoBuf$Type y0() {
        return this.f35435k;
    }

    public int z0() {
        return this.f35436l;
    }

    public ProtoBuf$Function(GeneratedMessageLite.c<ProtoBuf$Function, ?> cVar) {
        super(cVar);
        this.f35439o = -1;
        this.f35448x = (byte) -1;
        this.f35449y = -1;
        this.f35427c = cVar.h();
    }

    public ProtoBuf$Function(boolean z10) {
        this.f35439o = -1;
        this.f35448x = (byte) -1;
        this.f35449y = -1;
        this.f35427c = AbstractC4182b.f33086a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0394  */
    /* JADX WARN: Type inference failed for: r4v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ProtoBuf$Function(kotlin.reflect.jvm.internal.impl.protobuf.c r22, kotlin.reflect.jvm.internal.impl.protobuf.d r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1170
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function.<init>(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):void");
    }
}
