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
import kotlin.reflect.jvm.internal.impl.protobuf.f;

/* loaded from: classes5.dex */
public final class ProtoBuf$Type extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Type> implements InterfaceC4187g {

    /* renamed from: u, reason: collision with root package name */
    public static final ProtoBuf$Type f35582u;

    /* renamed from: v, reason: collision with root package name */
    public static InterfaceC4188h<ProtoBuf$Type> f35583v = new a();

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC4182b f35584c;

    /* renamed from: d, reason: collision with root package name */
    public int f35585d;

    /* renamed from: e, reason: collision with root package name */
    public List<Argument> f35586e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f35587f;

    /* renamed from: g, reason: collision with root package name */
    public int f35588g;

    /* renamed from: h, reason: collision with root package name */
    public ProtoBuf$Type f35589h;

    /* renamed from: i, reason: collision with root package name */
    public int f35590i;

    /* renamed from: j, reason: collision with root package name */
    public int f35591j;

    /* renamed from: k, reason: collision with root package name */
    public int f35592k;

    /* renamed from: l, reason: collision with root package name */
    public int f35593l;

    /* renamed from: m, reason: collision with root package name */
    public int f35594m;

    /* renamed from: n, reason: collision with root package name */
    public ProtoBuf$Type f35595n;

    /* renamed from: o, reason: collision with root package name */
    public int f35596o;

    /* renamed from: p, reason: collision with root package name */
    public ProtoBuf$Type f35597p;

    /* renamed from: q, reason: collision with root package name */
    public int f35598q;

    /* renamed from: r, reason: collision with root package name */
    public int f35599r;

    /* renamed from: s, reason: collision with root package name */
    public byte f35600s;

    /* renamed from: t, reason: collision with root package name */
    public int f35601t;

    public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ProtoBuf$Type> {
        @Override // ia.InterfaceC4188h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$Type c(c cVar, d dVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$Type(cVar, dVar);
        }
    }

    public static final class b extends GeneratedMessageLite.c<ProtoBuf$Type, b> implements InterfaceC4187g {

        /* renamed from: d, reason: collision with root package name */
        public int f35615d;

        /* renamed from: f, reason: collision with root package name */
        public boolean f35617f;

        /* renamed from: g, reason: collision with root package name */
        public int f35618g;

        /* renamed from: i, reason: collision with root package name */
        public int f35620i;

        /* renamed from: j, reason: collision with root package name */
        public int f35621j;

        /* renamed from: k, reason: collision with root package name */
        public int f35622k;

        /* renamed from: l, reason: collision with root package name */
        public int f35623l;

        /* renamed from: m, reason: collision with root package name */
        public int f35624m;

        /* renamed from: o, reason: collision with root package name */
        public int f35626o;

        /* renamed from: q, reason: collision with root package name */
        public int f35628q;

        /* renamed from: r, reason: collision with root package name */
        public int f35629r;

        /* renamed from: e, reason: collision with root package name */
        public List<Argument> f35616e = Collections.EMPTY_LIST;

        /* renamed from: h, reason: collision with root package name */
        public ProtoBuf$Type f35619h = ProtoBuf$Type.X();

        /* renamed from: n, reason: collision with root package name */
        public ProtoBuf$Type f35625n = ProtoBuf$Type.X();

        /* renamed from: p, reason: collision with root package name */
        public ProtoBuf$Type f35627p = ProtoBuf$Type.X();

        public b() {
            w();
        }

        public static b u() {
            return new b();
        }

        private void v() {
            if ((this.f35615d & 1) != 1) {
                this.f35616e = new ArrayList(this.f35616e);
                this.f35615d |= 1;
            }
        }

        private void w() {
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.f35583v     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$b");
        }

        public b C(ProtoBuf$Type protoBuf$Type) {
            if ((this.f35615d & 512) != 512 || this.f35625n == ProtoBuf$Type.X()) {
                this.f35625n = protoBuf$Type;
            } else {
                this.f35625n = ProtoBuf$Type.y0(this.f35625n).i(protoBuf$Type).s();
            }
            this.f35615d |= 512;
            return this;
        }

        public b D(int i10) {
            this.f35615d |= 4096;
            this.f35628q = i10;
            return this;
        }

        public b E(int i10) {
            this.f35615d |= 32;
            this.f35621j = i10;
            return this;
        }

        public b F(int i10) {
            this.f35615d |= com.stepos.agentframework.chatui.longtext.b.THRESHOLD;
            this.f35629r = i10;
            return this;
        }

        public b H(int i10) {
            this.f35615d |= 4;
            this.f35618g = i10;
            return this;
        }

        public b I(int i10) {
            this.f35615d |= 16;
            this.f35620i = i10;
            return this;
        }

        public b K(boolean z10) {
            this.f35615d |= 2;
            this.f35617f = z10;
            return this;
        }

        public b L(int i10) {
            this.f35615d |= 1024;
            this.f35626o = i10;
            return this;
        }

        public b M(int i10) {
            this.f35615d |= 256;
            this.f35624m = i10;
            return this;
        }

        public b N(int i10) {
            this.f35615d |= 64;
            this.f35622k = i10;
            return this;
        }

        public b O(int i10) {
            this.f35615d |= 128;
            this.f35623l = i10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$Type build() {
            ProtoBuf$Type protoBuf$TypeS = s();
            if (protoBuf$TypeS.isInitialized()) {
                return protoBuf$TypeS;
            }
            throw a.AbstractC0449a.f(protoBuf$TypeS);
        }

        public ProtoBuf$Type s() {
            ProtoBuf$Type protoBuf$Type = new ProtoBuf$Type(this);
            int i10 = this.f35615d;
            if ((i10 & 1) == 1) {
                this.f35616e = Collections.unmodifiableList(this.f35616e);
                this.f35615d &= -2;
            }
            protoBuf$Type.f35586e = this.f35616e;
            int i11 = (i10 & 2) != 2 ? 0 : 1;
            protoBuf$Type.f35587f = this.f35617f;
            if ((i10 & 4) == 4) {
                i11 |= 2;
            }
            protoBuf$Type.f35588g = this.f35618g;
            if ((i10 & 8) == 8) {
                i11 |= 4;
            }
            protoBuf$Type.f35589h = this.f35619h;
            if ((i10 & 16) == 16) {
                i11 |= 8;
            }
            protoBuf$Type.f35590i = this.f35620i;
            if ((i10 & 32) == 32) {
                i11 |= 16;
            }
            protoBuf$Type.f35591j = this.f35621j;
            if ((i10 & 64) == 64) {
                i11 |= 32;
            }
            protoBuf$Type.f35592k = this.f35622k;
            if ((i10 & 128) == 128) {
                i11 |= 64;
            }
            protoBuf$Type.f35593l = this.f35623l;
            if ((i10 & 256) == 256) {
                i11 |= 128;
            }
            protoBuf$Type.f35594m = this.f35624m;
            if ((i10 & 512) == 512) {
                i11 |= 256;
            }
            protoBuf$Type.f35595n = this.f35625n;
            if ((i10 & 1024) == 1024) {
                i11 |= 512;
            }
            protoBuf$Type.f35596o = this.f35626o;
            if ((i10 & 2048) == 2048) {
                i11 |= 1024;
            }
            protoBuf$Type.f35597p = this.f35627p;
            if ((i10 & 4096) == 4096) {
                i11 |= 2048;
            }
            protoBuf$Type.f35598q = this.f35628q;
            if ((i10 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) == 8192) {
                i11 |= 4096;
            }
            protoBuf$Type.f35599r = this.f35629r;
            protoBuf$Type.f35585d = i11;
            return protoBuf$Type;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public b g() {
            return u().i(s());
        }

        public b x(ProtoBuf$Type protoBuf$Type) {
            if ((this.f35615d & 2048) != 2048 || this.f35627p == ProtoBuf$Type.X()) {
                this.f35627p = protoBuf$Type;
            } else {
                this.f35627p = ProtoBuf$Type.y0(this.f35627p).i(protoBuf$Type).s();
            }
            this.f35615d |= 2048;
            return this;
        }

        public b y(ProtoBuf$Type protoBuf$Type) {
            if ((this.f35615d & 8) != 8 || this.f35619h == ProtoBuf$Type.X()) {
                this.f35619h = protoBuf$Type;
            } else {
                this.f35619h = ProtoBuf$Type.y0(this.f35619h).i(protoBuf$Type).s();
            }
            this.f35615d |= 8;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public b i(ProtoBuf$Type protoBuf$Type) {
            if (protoBuf$Type == ProtoBuf$Type.X()) {
                return this;
            }
            if (!protoBuf$Type.f35586e.isEmpty()) {
                if (this.f35616e.isEmpty()) {
                    this.f35616e = protoBuf$Type.f35586e;
                    this.f35615d &= -2;
                } else {
                    v();
                    this.f35616e.addAll(protoBuf$Type.f35586e);
                }
            }
            if (protoBuf$Type.q0()) {
                K(protoBuf$Type.d0());
            }
            if (protoBuf$Type.n0()) {
                H(protoBuf$Type.a0());
            }
            if (protoBuf$Type.o0()) {
                y(protoBuf$Type.b0());
            }
            if (protoBuf$Type.p0()) {
                I(protoBuf$Type.c0());
            }
            if (protoBuf$Type.l0()) {
                E(protoBuf$Type.W());
            }
            if (protoBuf$Type.u0()) {
                N(protoBuf$Type.h0());
            }
            if (protoBuf$Type.v0()) {
                O(protoBuf$Type.i0());
            }
            if (protoBuf$Type.t0()) {
                M(protoBuf$Type.g0());
            }
            if (protoBuf$Type.r0()) {
                C(protoBuf$Type.e0());
            }
            if (protoBuf$Type.s0()) {
                L(protoBuf$Type.f0());
            }
            if (protoBuf$Type.j0()) {
                x(protoBuf$Type.R());
            }
            if (protoBuf$Type.k0()) {
                D(protoBuf$Type.S());
            }
            if (protoBuf$Type.m0()) {
                F(protoBuf$Type.Z());
            }
            p(protoBuf$Type);
            j(h().c(protoBuf$Type.f35584c));
            return this;
        }
    }

    static {
        ProtoBuf$Type protoBuf$Type = new ProtoBuf$Type(true);
        f35582u = protoBuf$Type;
        protoBuf$Type.w0();
    }

    public static ProtoBuf$Type X() {
        return f35582u;
    }

    private void w0() {
        this.f35586e = Collections.EMPTY_LIST;
        this.f35587f = false;
        this.f35588g = 0;
        this.f35589h = X();
        this.f35590i = 0;
        this.f35591j = 0;
        this.f35592k = 0;
        this.f35593l = 0;
        this.f35594m = 0;
        this.f35595n = X();
        this.f35596o = 0;
        this.f35597p = X();
        this.f35598q = 0;
        this.f35599r = 0;
    }

    public static b x0() {
        return b.u();
    }

    public static b y0(ProtoBuf$Type protoBuf$Type) {
        return x0().i(protoBuf$Type);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return y0(this);
    }

    public ProtoBuf$Type R() {
        return this.f35597p;
    }

    public int S() {
        return this.f35598q;
    }

    public Argument T(int i10) {
        return this.f35586e.get(i10);
    }

    public int U() {
        return this.f35586e.size();
    }

    public List<Argument> V() {
        return this.f35586e;
    }

    public int W() {
        return this.f35591j;
    }

    @Override // ia.InterfaceC4187g
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public ProtoBuf$Type getDefaultInstanceForType() {
        return f35582u;
    }

    public int Z() {
        return this.f35599r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.a aVarW = w();
        if ((this.f35585d & 4096) == 4096) {
            codedOutputStream.a0(1, this.f35599r);
        }
        for (int i10 = 0; i10 < this.f35586e.size(); i10++) {
            codedOutputStream.d0(2, this.f35586e.get(i10));
        }
        if ((this.f35585d & 1) == 1) {
            codedOutputStream.L(3, this.f35587f);
        }
        if ((this.f35585d & 2) == 2) {
            codedOutputStream.a0(4, this.f35588g);
        }
        if ((this.f35585d & 4) == 4) {
            codedOutputStream.d0(5, this.f35589h);
        }
        if ((this.f35585d & 16) == 16) {
            codedOutputStream.a0(6, this.f35591j);
        }
        if ((this.f35585d & 32) == 32) {
            codedOutputStream.a0(7, this.f35592k);
        }
        if ((this.f35585d & 8) == 8) {
            codedOutputStream.a0(8, this.f35590i);
        }
        if ((this.f35585d & 64) == 64) {
            codedOutputStream.a0(9, this.f35593l);
        }
        if ((this.f35585d & 256) == 256) {
            codedOutputStream.d0(10, this.f35595n);
        }
        if ((this.f35585d & 512) == 512) {
            codedOutputStream.a0(11, this.f35596o);
        }
        if ((this.f35585d & 128) == 128) {
            codedOutputStream.a0(12, this.f35594m);
        }
        if ((this.f35585d & 1024) == 1024) {
            codedOutputStream.d0(13, this.f35597p);
        }
        if ((this.f35585d & 2048) == 2048) {
            codedOutputStream.a0(14, this.f35598q);
        }
        aVarW.a(200, codedOutputStream);
        codedOutputStream.i0(this.f35584c);
    }

    public int a0() {
        return this.f35588g;
    }

    public ProtoBuf$Type b0() {
        return this.f35589h;
    }

    public int c0() {
        return this.f35590i;
    }

    public boolean d0() {
        return this.f35587f;
    }

    public ProtoBuf$Type e0() {
        return this.f35595n;
    }

    public int f0() {
        return this.f35596o;
    }

    public int g0() {
        return this.f35594m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
    public InterfaceC4188h<ProtoBuf$Type> getParserForType() {
        return f35583v;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i10 = this.f35601t;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f35585d & 4096) == 4096 ? CodedOutputStream.o(1, this.f35599r) : 0;
        for (int i11 = 0; i11 < this.f35586e.size(); i11++) {
            iO += CodedOutputStream.s(2, this.f35586e.get(i11));
        }
        if ((this.f35585d & 1) == 1) {
            iO += CodedOutputStream.a(3, this.f35587f);
        }
        if ((this.f35585d & 2) == 2) {
            iO += CodedOutputStream.o(4, this.f35588g);
        }
        if ((this.f35585d & 4) == 4) {
            iO += CodedOutputStream.s(5, this.f35589h);
        }
        if ((this.f35585d & 16) == 16) {
            iO += CodedOutputStream.o(6, this.f35591j);
        }
        if ((this.f35585d & 32) == 32) {
            iO += CodedOutputStream.o(7, this.f35592k);
        }
        if ((this.f35585d & 8) == 8) {
            iO += CodedOutputStream.o(8, this.f35590i);
        }
        if ((this.f35585d & 64) == 64) {
            iO += CodedOutputStream.o(9, this.f35593l);
        }
        if ((this.f35585d & 256) == 256) {
            iO += CodedOutputStream.s(10, this.f35595n);
        }
        if ((this.f35585d & 512) == 512) {
            iO += CodedOutputStream.o(11, this.f35596o);
        }
        if ((this.f35585d & 128) == 128) {
            iO += CodedOutputStream.o(12, this.f35594m);
        }
        if ((this.f35585d & 1024) == 1024) {
            iO += CodedOutputStream.s(13, this.f35597p);
        }
        if ((this.f35585d & 2048) == 2048) {
            iO += CodedOutputStream.o(14, this.f35598q);
        }
        int iQ = iO + q() + this.f35584c.size();
        this.f35601t = iQ;
        return iQ;
    }

    public int h0() {
        return this.f35592k;
    }

    public int i0() {
        return this.f35593l;
    }

    @Override // ia.InterfaceC4187g
    public final boolean isInitialized() {
        byte b10 = this.f35600s;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i10 = 0; i10 < U(); i10++) {
            if (!T(i10).isInitialized()) {
                this.f35600s = (byte) 0;
                return false;
            }
        }
        if (o0() && !b0().isInitialized()) {
            this.f35600s = (byte) 0;
            return false;
        }
        if (r0() && !e0().isInitialized()) {
            this.f35600s = (byte) 0;
            return false;
        }
        if (j0() && !R().isInitialized()) {
            this.f35600s = (byte) 0;
            return false;
        }
        if (n()) {
            this.f35600s = (byte) 1;
            return true;
        }
        this.f35600s = (byte) 0;
        return false;
    }

    public boolean j0() {
        return (this.f35585d & 1024) == 1024;
    }

    public boolean k0() {
        return (this.f35585d & 2048) == 2048;
    }

    public boolean l0() {
        return (this.f35585d & 16) == 16;
    }

    public boolean m0() {
        return (this.f35585d & 4096) == 4096;
    }

    public boolean n0() {
        return (this.f35585d & 2) == 2;
    }

    public boolean o0() {
        return (this.f35585d & 4) == 4;
    }

    public boolean p0() {
        return (this.f35585d & 8) == 8;
    }

    public boolean q0() {
        return (this.f35585d & 1) == 1;
    }

    public boolean r0() {
        return (this.f35585d & 256) == 256;
    }

    public boolean s0() {
        return (this.f35585d & 512) == 512;
    }

    public boolean t0() {
        return (this.f35585d & 128) == 128;
    }

    public boolean u0() {
        return (this.f35585d & 32) == 32;
    }

    public boolean v0() {
        return (this.f35585d & 64) == 64;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return x0();
    }

    public static final class Argument extends GeneratedMessageLite implements InterfaceC4187g {

        /* renamed from: i, reason: collision with root package name */
        public static final Argument f35602i;

        /* renamed from: j, reason: collision with root package name */
        public static InterfaceC4188h<Argument> f35603j = new a();

        /* renamed from: b, reason: collision with root package name */
        public final AbstractC4182b f35604b;

        /* renamed from: c, reason: collision with root package name */
        public int f35605c;

        /* renamed from: d, reason: collision with root package name */
        public Projection f35606d;

        /* renamed from: e, reason: collision with root package name */
        public ProtoBuf$Type f35607e;

        /* renamed from: f, reason: collision with root package name */
        public int f35608f;

        /* renamed from: g, reason: collision with root package name */
        public byte f35609g;

        /* renamed from: h, reason: collision with root package name */
        public int f35610h;

        public enum Projection implements f.a {
            IN(0, 0),
            OUT(1, 1),
            INV(2, 2),
            STAR(3, 3);

            private static f.b<Projection> internalValueMap = new a();
            private final int value;

            public static class a implements f.b<Projection> {
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.b
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Projection findValueByNumber(int i10) {
                    return Projection.valueOf(i10);
                }
            }

            Projection(int i10, int i11) {
                this.value = i11;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.a
            public final int getNumber() {
                return this.value;
            }

            public static Projection valueOf(int i10) {
                if (i10 == 0) {
                    return IN;
                }
                if (i10 == 1) {
                    return OUT;
                }
                if (i10 == 2) {
                    return INV;
                }
                if (i10 != 3) {
                    return null;
                }
                return STAR;
            }
        }

        public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Argument> {
            @Override // ia.InterfaceC4188h
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Argument c(c cVar, d dVar) throws InvalidProtocolBufferException {
                return new Argument(cVar, dVar);
            }
        }

        public static final class b extends GeneratedMessageLite.b<Argument, b> implements InterfaceC4187g {

            /* renamed from: b, reason: collision with root package name */
            public int f35611b;

            /* renamed from: c, reason: collision with root package name */
            public Projection f35612c = Projection.INV;

            /* renamed from: d, reason: collision with root package name */
            public ProtoBuf$Type f35613d = ProtoBuf$Type.X();

            /* renamed from: e, reason: collision with root package name */
            public int f35614e;

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
            public Argument build() {
                Argument argumentO = o();
                if (argumentO.isInitialized()) {
                    return argumentO;
                }
                throw a.AbstractC0449a.f(argumentO);
            }

            public Argument o() {
                Argument argument = new Argument(this);
                int i10 = this.f35611b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                argument.f35606d = this.f35612c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                argument.f35607e = this.f35613d;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                argument.f35608f = this.f35614e;
                argument.f35605c = i11;
                return argument;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public b g() {
                return q().i(o());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public b i(Argument argument) {
                if (argument == Argument.u()) {
                    return this;
                }
                if (argument.y()) {
                    v(argument.v());
                }
                if (argument.z()) {
                    u(argument.w());
                }
                if (argument.A()) {
                    w(argument.x());
                }
                j(h().c(argument.f35604b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.Argument.f35603j     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.Argument) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.Argument) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument$b");
            }

            public b u(ProtoBuf$Type protoBuf$Type) {
                if ((this.f35611b & 2) != 2 || this.f35613d == ProtoBuf$Type.X()) {
                    this.f35613d = protoBuf$Type;
                } else {
                    this.f35613d = ProtoBuf$Type.y0(this.f35613d).i(protoBuf$Type).s();
                }
                this.f35611b |= 2;
                return this;
            }

            public b v(Projection projection) {
                projection.getClass();
                this.f35611b |= 1;
                this.f35612c = projection;
                return this;
            }

            public b w(int i10) {
                this.f35611b |= 4;
                this.f35614e = i10;
                return this;
            }
        }

        static {
            Argument argument = new Argument(true);
            f35602i = argument;
            argument.C();
        }

        private void C() {
            this.f35606d = Projection.INV;
            this.f35607e = ProtoBuf$Type.X();
            this.f35608f = 0;
        }

        public static b D() {
            return b.q();
        }

        public static b E(Argument argument) {
            return D().i(argument);
        }

        public static Argument u() {
            return f35602i;
        }

        public boolean A() {
            return (this.f35605c & 4) == 4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return D();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            return E(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f35605c & 1) == 1) {
                codedOutputStream.S(1, this.f35606d.getNumber());
            }
            if ((this.f35605c & 2) == 2) {
                codedOutputStream.d0(2, this.f35607e);
            }
            if ((this.f35605c & 4) == 4) {
                codedOutputStream.a0(3, this.f35608f);
            }
            codedOutputStream.i0(this.f35604b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
        public InterfaceC4188h<Argument> getParserForType() {
            return f35603j;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int getSerializedSize() {
            int i10 = this.f35610h;
            if (i10 != -1) {
                return i10;
            }
            int iH = (this.f35605c & 1) == 1 ? CodedOutputStream.h(1, this.f35606d.getNumber()) : 0;
            if ((this.f35605c & 2) == 2) {
                iH += CodedOutputStream.s(2, this.f35607e);
            }
            if ((this.f35605c & 4) == 4) {
                iH += CodedOutputStream.o(3, this.f35608f);
            }
            int size = iH + this.f35604b.size();
            this.f35610h = size;
            return size;
        }

        @Override // ia.InterfaceC4187g
        public final boolean isInitialized() {
            byte b10 = this.f35609g;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            if (!z() || w().isInitialized()) {
                this.f35609g = (byte) 1;
                return true;
            }
            this.f35609g = (byte) 0;
            return false;
        }

        public Projection v() {
            return this.f35606d;
        }

        public ProtoBuf$Type w() {
            return this.f35607e;
        }

        public int x() {
            return this.f35608f;
        }

        public boolean y() {
            return (this.f35605c & 1) == 1;
        }

        public boolean z() {
            return (this.f35605c & 2) == 2;
        }

        public Argument(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.f35609g = (byte) -1;
            this.f35610h = -1;
            this.f35604b = bVar.h();
        }

        public Argument(boolean z10) {
            this.f35609g = (byte) -1;
            this.f35610h = -1;
            this.f35604b = AbstractC4182b.f33086a;
        }

        public Argument(c cVar, d dVar) throws InvalidProtocolBufferException {
            this.f35609g = (byte) -1;
            this.f35610h = -1;
            C();
            AbstractC4182b.C0409b c0409bT = AbstractC4182b.t();
            CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(c0409bT, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int iK = cVar.K();
                            if (iK != 0) {
                                if (iK == 8) {
                                    int iN = cVar.n();
                                    Projection projectionValueOf = Projection.valueOf(iN);
                                    if (projectionValueOf == null) {
                                        codedOutputStreamJ.o0(iK);
                                        codedOutputStreamJ.o0(iN);
                                    } else {
                                        this.f35605c |= 1;
                                        this.f35606d = projectionValueOf;
                                    }
                                } else if (iK == 18) {
                                    b builder = (this.f35605c & 2) == 2 ? this.f35607e.toBuilder() : null;
                                    ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) cVar.u(ProtoBuf$Type.f35583v, dVar);
                                    this.f35607e = protoBuf$Type;
                                    if (builder != null) {
                                        builder.i(protoBuf$Type);
                                        this.f35607e = builder.s();
                                    }
                                    this.f35605c |= 2;
                                } else if (iK != 24) {
                                    if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                                    }
                                } else {
                                    this.f35605c |= 4;
                                    this.f35608f = cVar.s();
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
                    try {
                        codedOutputStreamJ.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f35604b = c0409bT.l();
                        throw th2;
                    }
                    this.f35604b = c0409bT.l();
                    g();
                    throw th;
                }
            }
            try {
                codedOutputStreamJ.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f35604b = c0409bT.l();
                throw th3;
            }
            this.f35604b = c0409bT.l();
            g();
        }
    }

    public ProtoBuf$Type(GeneratedMessageLite.c<ProtoBuf$Type, ?> cVar) {
        super(cVar);
        this.f35600s = (byte) -1;
        this.f35601t = -1;
        this.f35584c = cVar.h();
    }

    public ProtoBuf$Type(boolean z10) {
        this.f35600s = (byte) -1;
        this.f35601t = -1;
        this.f35584c = AbstractC4182b.f33086a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBuf$Type(c cVar, d dVar) throws InvalidProtocolBufferException {
        b builder;
        this.f35600s = (byte) -1;
        this.f35601t = -1;
        w0();
        AbstractC4182b.C0409b c0409bT = AbstractC4182b.t();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(c0409bT, 1);
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            try {
                try {
                    try {
                        int iK = cVar.K();
                        switch (iK) {
                            case 0:
                                z10 = true;
                            case 8:
                                this.f35585d |= 4096;
                                this.f35599r = cVar.s();
                            case 18:
                                if (!z11) {
                                    this.f35586e = new ArrayList();
                                    z11 = true;
                                }
                                this.f35586e.add(cVar.u(Argument.f35603j, dVar));
                            case 24:
                                this.f35585d |= 1;
                                this.f35587f = cVar.k();
                            case 32:
                                this.f35585d |= 2;
                                this.f35588g = cVar.s();
                            case 42:
                                builder = (this.f35585d & 4) == 4 ? this.f35589h.toBuilder() : null;
                                ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) cVar.u(f35583v, dVar);
                                this.f35589h = protoBuf$Type;
                                if (builder != null) {
                                    builder.i(protoBuf$Type);
                                    this.f35589h = builder.s();
                                }
                                this.f35585d |= 4;
                            case 48:
                                this.f35585d |= 16;
                                this.f35591j = cVar.s();
                            case 56:
                                this.f35585d |= 32;
                                this.f35592k = cVar.s();
                            case 64:
                                this.f35585d |= 8;
                                this.f35590i = cVar.s();
                            case 72:
                                this.f35585d |= 64;
                                this.f35593l = cVar.s();
                            case 82:
                                builder = (this.f35585d & 256) == 256 ? this.f35595n.toBuilder() : null;
                                ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) cVar.u(f35583v, dVar);
                                this.f35595n = protoBuf$Type2;
                                if (builder != null) {
                                    builder.i(protoBuf$Type2);
                                    this.f35595n = builder.s();
                                }
                                this.f35585d |= 256;
                            case 88:
                                this.f35585d |= 512;
                                this.f35596o = cVar.s();
                            case 96:
                                this.f35585d |= 128;
                                this.f35594m = cVar.s();
                            case 106:
                                builder = (this.f35585d & 1024) == 1024 ? this.f35597p.toBuilder() : null;
                                ProtoBuf$Type protoBuf$Type3 = (ProtoBuf$Type) cVar.u(f35583v, dVar);
                                this.f35597p = protoBuf$Type3;
                                if (builder != null) {
                                    builder.i(protoBuf$Type3);
                                    this.f35597p = builder.s();
                                }
                                this.f35585d |= 1024;
                            case 112:
                                this.f35585d |= 2048;
                                this.f35598q = cVar.s();
                            default:
                                if (!j(cVar, codedOutputStreamJ, dVar, iK)) {
                                    z10 = true;
                                }
                        }
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.i(this);
                    }
                } catch (IOException e11) {
                    throw new InvalidProtocolBufferException(e11.getMessage()).i(this);
                }
            } catch (Throwable th) {
                if (z11) {
                    this.f35586e = Collections.unmodifiableList(this.f35586e);
                }
                try {
                    codedOutputStreamJ.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f35584c = c0409bT.l();
                    throw th2;
                }
                this.f35584c = c0409bT.l();
                g();
                throw th;
            }
        }
        if (z11) {
            this.f35586e = Collections.unmodifiableList(this.f35586e);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f35584c = c0409bT.l();
            throw th3;
        }
        this.f35584c = c0409bT.l();
        g();
    }
}
