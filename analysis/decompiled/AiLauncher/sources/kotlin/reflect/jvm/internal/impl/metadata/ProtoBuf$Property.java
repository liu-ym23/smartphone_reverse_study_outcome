package kotlin.reflect.jvm.internal.impl.metadata;

import com.autonavi.aps.amapapi.utils.ReportUtil;
import ia.AbstractC4182b;
import ia.InterfaceC4187g;
import ia.InterfaceC4188h;
import io.requery.android.database.sqlite.SQLiteDatabase;
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
public final class ProtoBuf$Property extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Property> implements InterfaceC4187g {

    /* renamed from: D, reason: collision with root package name */
    public static final ProtoBuf$Property f35501D;

    /* renamed from: E, reason: collision with root package name */
    public static InterfaceC4188h<ProtoBuf$Property> f35502E = new a();

    /* renamed from: A, reason: collision with root package name */
    public List<ProtoBuf$Annotation> f35503A;

    /* renamed from: B, reason: collision with root package name */
    public byte f35504B;

    /* renamed from: C, reason: collision with root package name */
    public int f35505C;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC4182b f35506c;

    /* renamed from: d, reason: collision with root package name */
    public int f35507d;

    /* renamed from: e, reason: collision with root package name */
    public int f35508e;

    /* renamed from: f, reason: collision with root package name */
    public int f35509f;

    /* renamed from: g, reason: collision with root package name */
    public int f35510g;

    /* renamed from: h, reason: collision with root package name */
    public ProtoBuf$Type f35511h;

    /* renamed from: i, reason: collision with root package name */
    public int f35512i;

    /* renamed from: j, reason: collision with root package name */
    public List<ProtoBuf$TypeParameter> f35513j;

    /* renamed from: k, reason: collision with root package name */
    public ProtoBuf$Type f35514k;

    /* renamed from: l, reason: collision with root package name */
    public int f35515l;

    /* renamed from: m, reason: collision with root package name */
    public List<ProtoBuf$Type> f35516m;

    /* renamed from: n, reason: collision with root package name */
    public List<Integer> f35517n;

    /* renamed from: o, reason: collision with root package name */
    public int f35518o;

    /* renamed from: p, reason: collision with root package name */
    public List<ProtoBuf$ValueParameter> f35519p;

    /* renamed from: q, reason: collision with root package name */
    public ProtoBuf$ValueParameter f35520q;

    /* renamed from: r, reason: collision with root package name */
    public int f35521r;

    /* renamed from: s, reason: collision with root package name */
    public int f35522s;

    /* renamed from: t, reason: collision with root package name */
    public List<Integer> f35523t;

    /* renamed from: u, reason: collision with root package name */
    public List<ProtoBuf$CompilerPluginData> f35524u;

    /* renamed from: v, reason: collision with root package name */
    public List<ProtoBuf$Annotation> f35525v;

    /* renamed from: w, reason: collision with root package name */
    public List<ProtoBuf$Annotation> f35526w;

    /* renamed from: x, reason: collision with root package name */
    public List<ProtoBuf$Annotation> f35527x;

    /* renamed from: y, reason: collision with root package name */
    public List<ProtoBuf$Annotation> f35528y;

    /* renamed from: z, reason: collision with root package name */
    public List<ProtoBuf$Annotation> f35529z;

    public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ProtoBuf$Property> {
        @Override // ia.InterfaceC4188h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$Property c(c cVar, d dVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$Property(cVar, dVar);
        }
    }

    public static final class b extends GeneratedMessageLite.c<ProtoBuf$Property, b> implements InterfaceC4187g {

        /* renamed from: d, reason: collision with root package name */
        public int f35530d;

        /* renamed from: g, reason: collision with root package name */
        public int f35533g;

        /* renamed from: i, reason: collision with root package name */
        public int f35535i;

        /* renamed from: j, reason: collision with root package name */
        public List<ProtoBuf$TypeParameter> f35536j;

        /* renamed from: k, reason: collision with root package name */
        public ProtoBuf$Type f35537k;

        /* renamed from: l, reason: collision with root package name */
        public int f35538l;

        /* renamed from: m, reason: collision with root package name */
        public List<ProtoBuf$Type> f35539m;

        /* renamed from: n, reason: collision with root package name */
        public List<Integer> f35540n;

        /* renamed from: o, reason: collision with root package name */
        public List<ProtoBuf$ValueParameter> f35541o;

        /* renamed from: p, reason: collision with root package name */
        public ProtoBuf$ValueParameter f35542p;

        /* renamed from: q, reason: collision with root package name */
        public int f35543q;

        /* renamed from: r, reason: collision with root package name */
        public int f35544r;

        /* renamed from: s, reason: collision with root package name */
        public List<Integer> f35545s;

        /* renamed from: t, reason: collision with root package name */
        public List<ProtoBuf$CompilerPluginData> f35546t;

        /* renamed from: u, reason: collision with root package name */
        public List<ProtoBuf$Annotation> f35547u;

        /* renamed from: v, reason: collision with root package name */
        public List<ProtoBuf$Annotation> f35548v;

        /* renamed from: w, reason: collision with root package name */
        public List<ProtoBuf$Annotation> f35549w;

        /* renamed from: x, reason: collision with root package name */
        public List<ProtoBuf$Annotation> f35550x;

        /* renamed from: y, reason: collision with root package name */
        public List<ProtoBuf$Annotation> f35551y;

        /* renamed from: z, reason: collision with root package name */
        public List<ProtoBuf$Annotation> f35552z;

        /* renamed from: e, reason: collision with root package name */
        public int f35531e = 518;

        /* renamed from: f, reason: collision with root package name */
        public int f35532f = ReportUtil.EXCEPTION_CODE_PARSERDATA;

        /* renamed from: h, reason: collision with root package name */
        public ProtoBuf$Type f35534h = ProtoBuf$Type.X();

        public b() {
            List list = Collections.EMPTY_LIST;
            this.f35536j = list;
            this.f35537k = ProtoBuf$Type.X();
            this.f35539m = list;
            this.f35540n = list;
            this.f35541o = list;
            this.f35542p = ProtoBuf$ValueParameter.P();
            this.f35545s = list;
            this.f35546t = list;
            this.f35547u = list;
            this.f35548v = list;
            this.f35549w = list;
            this.f35550x = list;
            this.f35551y = list;
            this.f35552z = list;
            K();
        }

        private void B() {
            if ((this.f35530d & 256) != 256) {
                this.f35539m = new ArrayList(this.f35539m);
                this.f35530d |= 256;
            }
        }

        private void D() {
            if ((this.f35530d & 524288) != 524288) {
                this.f35550x = new ArrayList(this.f35550x);
                this.f35530d |= 524288;
            }
        }

        private void H() {
            if ((this.f35530d & 32) != 32) {
                this.f35536j = new ArrayList(this.f35536j);
                this.f35530d |= 32;
            }
        }

        private void I() {
            if ((this.f35530d & 16384) != 16384) {
                this.f35545s = new ArrayList(this.f35545s);
                this.f35530d |= 16384;
            }
        }

        private void K() {
        }

        public static b u() {
            return new b();
        }

        private void v() {
            if ((this.f35530d & 65536) != 65536) {
                this.f35547u = new ArrayList(this.f35547u);
                this.f35530d |= 65536;
            }
        }

        private void x() {
            if ((this.f35530d & 32768) != 32768) {
                this.f35546t = new ArrayList(this.f35546t);
                this.f35530d |= 32768;
            }
        }

        private void y() {
            if ((this.f35530d & 1024) != 1024) {
                this.f35541o = new ArrayList(this.f35541o);
                this.f35530d |= 1024;
            }
        }

        private void z() {
            if ((this.f35530d & 512) != 512) {
                this.f35540n = new ArrayList(this.f35540n);
                this.f35530d |= 512;
            }
        }

        public final void C() {
            if ((this.f35530d & 2097152) != 2097152) {
                this.f35552z = new ArrayList(this.f35552z);
                this.f35530d |= 2097152;
            }
        }

        public final void E() {
            if ((this.f35530d & SQLiteDatabase.OPEN_SHAREDCACHE) != 131072) {
                this.f35548v = new ArrayList(this.f35548v);
                this.f35530d |= SQLiteDatabase.OPEN_SHAREDCACHE;
            }
        }

        public final void F() {
            if ((this.f35530d & SQLiteDatabase.OPEN_PRIVATECACHE) != 262144) {
                this.f35549w = new ArrayList(this.f35549w);
                this.f35530d |= SQLiteDatabase.OPEN_PRIVATECACHE;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public b i(ProtoBuf$Property protoBuf$Property) {
            if (protoBuf$Property == ProtoBuf$Property.z0()) {
                return this;
            }
            if (protoBuf$Property.b1()) {
                Q(protoBuf$Property.H0());
            }
            if (protoBuf$Property.e1()) {
                T(protoBuf$Property.N0());
            }
            if (protoBuf$Property.d1()) {
                S(protoBuf$Property.M0());
            }
            if (protoBuf$Property.h1()) {
                O(protoBuf$Property.Q0());
            }
            if (protoBuf$Property.i1()) {
                V(protoBuf$Property.R0());
            }
            if (!protoBuf$Property.f35513j.isEmpty()) {
                if (this.f35536j.isEmpty()) {
                    this.f35536j = protoBuf$Property.f35513j;
                    this.f35530d &= -33;
                } else {
                    H();
                    this.f35536j.addAll(protoBuf$Property.f35513j);
                }
            }
            if (protoBuf$Property.f1()) {
                N(protoBuf$Property.O0());
            }
            if (protoBuf$Property.g1()) {
                U(protoBuf$Property.P0());
            }
            if (!protoBuf$Property.f35516m.isEmpty()) {
                if (this.f35539m.isEmpty()) {
                    this.f35539m = protoBuf$Property.f35516m;
                    this.f35530d &= -257;
                } else {
                    B();
                    this.f35539m.addAll(protoBuf$Property.f35516m);
                }
            }
            if (!protoBuf$Property.f35517n.isEmpty()) {
                if (this.f35540n.isEmpty()) {
                    this.f35540n = protoBuf$Property.f35517n;
                    this.f35530d &= -513;
                } else {
                    z();
                    this.f35540n.addAll(protoBuf$Property.f35517n);
                }
            }
            if (!protoBuf$Property.f35519p.isEmpty()) {
                if (this.f35541o.isEmpty()) {
                    this.f35541o = protoBuf$Property.f35519p;
                    this.f35530d &= -1025;
                } else {
                    y();
                    this.f35541o.addAll(protoBuf$Property.f35519p);
                }
            }
            if (protoBuf$Property.k1()) {
                P(protoBuf$Property.W0());
            }
            if (protoBuf$Property.c1()) {
                R(protoBuf$Property.L0());
            }
            if (protoBuf$Property.j1()) {
                W(protoBuf$Property.V0());
            }
            if (!protoBuf$Property.f35523t.isEmpty()) {
                if (this.f35545s.isEmpty()) {
                    this.f35545s = protoBuf$Property.f35523t;
                    this.f35530d &= -16385;
                } else {
                    I();
                    this.f35545s.addAll(protoBuf$Property.f35523t);
                }
            }
            if (!protoBuf$Property.f35524u.isEmpty()) {
                if (this.f35546t.isEmpty()) {
                    this.f35546t = protoBuf$Property.f35524u;
                    this.f35530d &= -32769;
                } else {
                    x();
                    this.f35546t.addAll(protoBuf$Property.f35524u);
                }
            }
            if (!protoBuf$Property.f35525v.isEmpty()) {
                if (this.f35547u.isEmpty()) {
                    this.f35547u = protoBuf$Property.f35525v;
                    this.f35530d &= -65537;
                } else {
                    v();
                    this.f35547u.addAll(protoBuf$Property.f35525v);
                }
            }
            if (!protoBuf$Property.f35526w.isEmpty()) {
                if (this.f35548v.isEmpty()) {
                    this.f35548v = protoBuf$Property.f35526w;
                    this.f35530d &= -131073;
                } else {
                    E();
                    this.f35548v.addAll(protoBuf$Property.f35526w);
                }
            }
            if (!protoBuf$Property.f35527x.isEmpty()) {
                if (this.f35549w.isEmpty()) {
                    this.f35549w = protoBuf$Property.f35527x;
                    this.f35530d &= -262145;
                } else {
                    F();
                    this.f35549w.addAll(protoBuf$Property.f35527x);
                }
            }
            if (!protoBuf$Property.f35528y.isEmpty()) {
                if (this.f35550x.isEmpty()) {
                    this.f35550x = protoBuf$Property.f35528y;
                    this.f35530d &= -524289;
                } else {
                    D();
                    this.f35550x.addAll(protoBuf$Property.f35528y);
                }
            }
            if (!protoBuf$Property.f35529z.isEmpty()) {
                if (this.f35551y.isEmpty()) {
                    this.f35551y = protoBuf$Property.f35529z;
                    this.f35530d &= -1048577;
                } else {
                    w();
                    this.f35551y.addAll(protoBuf$Property.f35529z);
                }
            }
            if (!protoBuf$Property.f35503A.isEmpty()) {
                if (this.f35552z.isEmpty()) {
                    this.f35552z = protoBuf$Property.f35503A;
                    this.f35530d &= -2097153;
                } else {
                    C();
                    this.f35552z.addAll(protoBuf$Property.f35503A);
                }
            }
            p(protoBuf$Property);
            j(h().c(protoBuf$Property.f35506c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: M, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property.f35502E     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property.b.m(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property$b");
        }

        public b N(ProtoBuf$Type protoBuf$Type) {
            if ((this.f35530d & 64) != 64 || this.f35537k == ProtoBuf$Type.X()) {
                this.f35537k = protoBuf$Type;
            } else {
                this.f35537k = ProtoBuf$Type.y0(this.f35537k).i(protoBuf$Type).s();
            }
            this.f35530d |= 64;
            return this;
        }

        public b O(ProtoBuf$Type protoBuf$Type) {
            if ((this.f35530d & 8) != 8 || this.f35534h == ProtoBuf$Type.X()) {
                this.f35534h = protoBuf$Type;
            } else {
                this.f35534h = ProtoBuf$Type.y0(this.f35534h).i(protoBuf$Type).s();
            }
            this.f35530d |= 8;
            return this;
        }

        public b P(ProtoBuf$ValueParameter protoBuf$ValueParameter) {
            if ((this.f35530d & 2048) != 2048 || this.f35542p == ProtoBuf$ValueParameter.P()) {
                this.f35542p = protoBuf$ValueParameter;
            } else {
                this.f35542p = ProtoBuf$ValueParameter.g0(this.f35542p).i(protoBuf$ValueParameter).s();
            }
            this.f35530d |= 2048;
            return this;
        }

        public b Q(int i10) {
            this.f35530d |= 1;
            this.f35531e = i10;
            return this;
        }

        public b R(int i10) {
            this.f35530d |= 4096;
            this.f35543q = i10;
            return this;
        }

        public b S(int i10) {
            this.f35530d |= 4;
            this.f35533g = i10;
            return this;
        }

        public b T(int i10) {
            this.f35530d |= 2;
            this.f35532f = i10;
            return this;
        }

        public b U(int i10) {
            this.f35530d |= 128;
            this.f35538l = i10;
            return this;
        }

        public b V(int i10) {
            this.f35530d |= 16;
            this.f35535i = i10;
            return this;
        }

        public b W(int i10) {
            this.f35530d |= com.stepos.agentframework.chatui.longtext.b.THRESHOLD;
            this.f35544r = i10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$Property build() {
            ProtoBuf$Property protoBuf$PropertyS = s();
            if (protoBuf$PropertyS.isInitialized()) {
                return protoBuf$PropertyS;
            }
            throw a.AbstractC0449a.f(protoBuf$PropertyS);
        }

        public ProtoBuf$Property s() {
            ProtoBuf$Property protoBuf$Property = new ProtoBuf$Property(this);
            int i10 = this.f35530d;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            protoBuf$Property.f35508e = this.f35531e;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            protoBuf$Property.f35509f = this.f35532f;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            protoBuf$Property.f35510g = this.f35533g;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            protoBuf$Property.f35511h = this.f35534h;
            if ((i10 & 16) == 16) {
                i11 |= 16;
            }
            protoBuf$Property.f35512i = this.f35535i;
            if ((this.f35530d & 32) == 32) {
                this.f35536j = Collections.unmodifiableList(this.f35536j);
                this.f35530d &= -33;
            }
            protoBuf$Property.f35513j = this.f35536j;
            if ((i10 & 64) == 64) {
                i11 |= 32;
            }
            protoBuf$Property.f35514k = this.f35537k;
            if ((i10 & 128) == 128) {
                i11 |= 64;
            }
            protoBuf$Property.f35515l = this.f35538l;
            if ((this.f35530d & 256) == 256) {
                this.f35539m = Collections.unmodifiableList(this.f35539m);
                this.f35530d &= -257;
            }
            protoBuf$Property.f35516m = this.f35539m;
            if ((this.f35530d & 512) == 512) {
                this.f35540n = Collections.unmodifiableList(this.f35540n);
                this.f35530d &= -513;
            }
            protoBuf$Property.f35517n = this.f35540n;
            if ((this.f35530d & 1024) == 1024) {
                this.f35541o = Collections.unmodifiableList(this.f35541o);
                this.f35530d &= -1025;
            }
            protoBuf$Property.f35519p = this.f35541o;
            if ((i10 & 2048) == 2048) {
                i11 |= 128;
            }
            protoBuf$Property.f35520q = this.f35542p;
            if ((i10 & 4096) == 4096) {
                i11 |= 256;
            }
            protoBuf$Property.f35521r = this.f35543q;
            if ((i10 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) == 8192) {
                i11 |= 512;
            }
            protoBuf$Property.f35522s = this.f35544r;
            if ((this.f35530d & 16384) == 16384) {
                this.f35545s = Collections.unmodifiableList(this.f35545s);
                this.f35530d &= -16385;
            }
            protoBuf$Property.f35523t = this.f35545s;
            if ((this.f35530d & 32768) == 32768) {
                this.f35546t = Collections.unmodifiableList(this.f35546t);
                this.f35530d &= -32769;
            }
            protoBuf$Property.f35524u = this.f35546t;
            if ((this.f35530d & 65536) == 65536) {
                this.f35547u = Collections.unmodifiableList(this.f35547u);
                this.f35530d &= -65537;
            }
            protoBuf$Property.f35525v = this.f35547u;
            if ((this.f35530d & SQLiteDatabase.OPEN_SHAREDCACHE) == 131072) {
                this.f35548v = Collections.unmodifiableList(this.f35548v);
                this.f35530d &= -131073;
            }
            protoBuf$Property.f35526w = this.f35548v;
            if ((this.f35530d & SQLiteDatabase.OPEN_PRIVATECACHE) == 262144) {
                this.f35549w = Collections.unmodifiableList(this.f35549w);
                this.f35530d &= -262145;
            }
            protoBuf$Property.f35527x = this.f35549w;
            if ((this.f35530d & 524288) == 524288) {
                this.f35550x = Collections.unmodifiableList(this.f35550x);
                this.f35530d &= -524289;
            }
            protoBuf$Property.f35528y = this.f35550x;
            if ((this.f35530d & 1048576) == 1048576) {
                this.f35551y = Collections.unmodifiableList(this.f35551y);
                this.f35530d &= -1048577;
            }
            protoBuf$Property.f35529z = this.f35551y;
            if ((this.f35530d & 2097152) == 2097152) {
                this.f35552z = Collections.unmodifiableList(this.f35552z);
                this.f35530d &= -2097153;
            }
            protoBuf$Property.f35503A = this.f35552z;
            protoBuf$Property.f35507d = i11;
            return protoBuf$Property;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public b g() {
            return u().i(s());
        }

        public final void w() {
            if ((this.f35530d & 1048576) != 1048576) {
                this.f35551y = new ArrayList(this.f35551y);
                this.f35530d |= 1048576;
            }
        }
    }

    static {
        ProtoBuf$Property protoBuf$Property = new ProtoBuf$Property(true);
        f35501D = protoBuf$Property;
        protoBuf$Property.l1();
    }

    private void l1() {
        this.f35508e = 518;
        this.f35509f = ReportUtil.EXCEPTION_CODE_PARSERDATA;
        this.f35510g = 0;
        this.f35511h = ProtoBuf$Type.X();
        this.f35512i = 0;
        List list = Collections.EMPTY_LIST;
        this.f35513j = list;
        this.f35514k = ProtoBuf$Type.X();
        this.f35515l = 0;
        this.f35516m = list;
        this.f35517n = list;
        this.f35519p = list;
        this.f35520q = ProtoBuf$ValueParameter.P();
        this.f35521r = 0;
        this.f35522s = 0;
        this.f35523t = list;
        this.f35524u = list;
        this.f35525v = list;
        this.f35526w = list;
        this.f35527x = list;
        this.f35528y = list;
        this.f35529z = list;
        this.f35503A = list;
    }

    public static b m1() {
        return b.u();
    }

    public static b n1(ProtoBuf$Property protoBuf$Property) {
        return m1().i(protoBuf$Property);
    }

    public static ProtoBuf$Property z0() {
        return f35501D;
    }

    @Override // ia.InterfaceC4187g
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public ProtoBuf$Property getDefaultInstanceForType() {
        return f35501D;
    }

    public ProtoBuf$Annotation B0(int i10) {
        return this.f35503A.get(i10);
    }

    public int C0() {
        return this.f35503A.size();
    }

    public List<ProtoBuf$Annotation> D0() {
        return this.f35503A;
    }

    public ProtoBuf$Annotation E0(int i10) {
        return this.f35528y.get(i10);
    }

    public int F0() {
        return this.f35528y.size();
    }

    public List<ProtoBuf$Annotation> G0() {
        return this.f35528y;
    }

    public int H0() {
        return this.f35508e;
    }

    public ProtoBuf$Annotation I0(int i10) {
        return this.f35526w.get(i10);
    }

    public int J0() {
        return this.f35526w.size();
    }

    public List<ProtoBuf$Annotation> K0() {
        return this.f35526w;
    }

    public int L0() {
        return this.f35521r;
    }

    public int M0() {
        return this.f35510g;
    }

    public int N0() {
        return this.f35509f;
    }

    public ProtoBuf$Type O0() {
        return this.f35514k;
    }

    public int P0() {
        return this.f35515l;
    }

    public ProtoBuf$Type Q0() {
        return this.f35511h;
    }

    public int R0() {
        return this.f35512i;
    }

    public ProtoBuf$Annotation S0(int i10) {
        return this.f35527x.get(i10);
    }

    public int T0() {
        return this.f35527x.size();
    }

    public List<ProtoBuf$Annotation> U0() {
        return this.f35527x;
    }

    public int V0() {
        return this.f35522s;
    }

    public ProtoBuf$ValueParameter W0() {
        return this.f35520q;
    }

    public ProtoBuf$TypeParameter X0(int i10) {
        return this.f35513j.get(i10);
    }

    public int Y0() {
        return this.f35513j.size();
    }

    public List<ProtoBuf$TypeParameter> Z0() {
        return this.f35513j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.a aVarW = w();
        if ((this.f35507d & 2) == 2) {
            codedOutputStream.a0(1, this.f35509f);
        }
        if ((this.f35507d & 4) == 4) {
            codedOutputStream.a0(2, this.f35510g);
        }
        if ((this.f35507d & 8) == 8) {
            codedOutputStream.d0(3, this.f35511h);
        }
        for (int i10 = 0; i10 < this.f35513j.size(); i10++) {
            codedOutputStream.d0(4, this.f35513j.get(i10));
        }
        if ((this.f35507d & 32) == 32) {
            codedOutputStream.d0(5, this.f35514k);
        }
        if ((this.f35507d & 128) == 128) {
            codedOutputStream.d0(6, this.f35520q);
        }
        if ((this.f35507d & 256) == 256) {
            codedOutputStream.a0(7, this.f35521r);
        }
        if ((this.f35507d & 512) == 512) {
            codedOutputStream.a0(8, this.f35522s);
        }
        if ((this.f35507d & 16) == 16) {
            codedOutputStream.a0(9, this.f35512i);
        }
        if ((this.f35507d & 64) == 64) {
            codedOutputStream.a0(10, this.f35515l);
        }
        if ((this.f35507d & 1) == 1) {
            codedOutputStream.a0(11, this.f35508e);
        }
        for (int i11 = 0; i11 < this.f35516m.size(); i11++) {
            codedOutputStream.d0(12, this.f35516m.get(i11));
        }
        if (x0().size() > 0) {
            codedOutputStream.o0(106);
            codedOutputStream.o0(this.f35518o);
        }
        for (int i12 = 0; i12 < this.f35517n.size(); i12++) {
            codedOutputStream.b0(this.f35517n.get(i12).intValue());
        }
        for (int i13 = 0; i13 < this.f35525v.size(); i13++) {
            codedOutputStream.d0(14, this.f35525v.get(i13));
        }
        for (int i14 = 0; i14 < this.f35526w.size(); i14++) {
            codedOutputStream.d0(15, this.f35526w.get(i14));
        }
        for (int i15 = 0; i15 < this.f35527x.size(); i15++) {
            codedOutputStream.d0(16, this.f35527x.get(i15));
        }
        for (int i16 = 0; i16 < this.f35519p.size(); i16++) {
            codedOutputStream.d0(17, this.f35519p.get(i16));
        }
        for (int i17 = 0; i17 < this.f35523t.size(); i17++) {
            codedOutputStream.a0(31, this.f35523t.get(i17).intValue());
        }
        for (int i18 = 0; i18 < this.f35524u.size(); i18++) {
            codedOutputStream.d0(32, this.f35524u.get(i18));
        }
        for (int i19 = 0; i19 < this.f35528y.size(); i19++) {
            codedOutputStream.d0(33, this.f35528y.get(i19));
        }
        for (int i20 = 0; i20 < this.f35529z.size(); i20++) {
            codedOutputStream.d0(34, this.f35529z.get(i20));
        }
        for (int i21 = 0; i21 < this.f35503A.size(); i21++) {
            codedOutputStream.d0(35, this.f35503A.get(i21));
        }
        aVarW.a(19000, codedOutputStream);
        codedOutputStream.i0(this.f35506c);
    }

    public List<Integer> a1() {
        return this.f35523t;
    }

    public boolean b1() {
        return (this.f35507d & 1) == 1;
    }

    public boolean c1() {
        return (this.f35507d & 256) == 256;
    }

    public boolean d1() {
        return (this.f35507d & 4) == 4;
    }

    public boolean e1() {
        return (this.f35507d & 2) == 2;
    }

    public boolean f1() {
        return (this.f35507d & 32) == 32;
    }

    public boolean g1() {
        return (this.f35507d & 64) == 64;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
    public InterfaceC4188h<ProtoBuf$Property> getParserForType() {
        return f35502E;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i10 = this.f35505C;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f35507d & 2) == 2 ? CodedOutputStream.o(1, this.f35509f) : 0;
        if ((this.f35507d & 4) == 4) {
            iO += CodedOutputStream.o(2, this.f35510g);
        }
        if ((this.f35507d & 8) == 8) {
            iO += CodedOutputStream.s(3, this.f35511h);
        }
        for (int i11 = 0; i11 < this.f35513j.size(); i11++) {
            iO += CodedOutputStream.s(4, this.f35513j.get(i11));
        }
        if ((this.f35507d & 32) == 32) {
            iO += CodedOutputStream.s(5, this.f35514k);
        }
        if ((this.f35507d & 128) == 128) {
            iO += CodedOutputStream.s(6, this.f35520q);
        }
        if ((this.f35507d & 256) == 256) {
            iO += CodedOutputStream.o(7, this.f35521r);
        }
        if ((this.f35507d & 512) == 512) {
            iO += CodedOutputStream.o(8, this.f35522s);
        }
        if ((this.f35507d & 16) == 16) {
            iO += CodedOutputStream.o(9, this.f35512i);
        }
        if ((this.f35507d & 64) == 64) {
            iO += CodedOutputStream.o(10, this.f35515l);
        }
        if ((this.f35507d & 1) == 1) {
            iO += CodedOutputStream.o(11, this.f35508e);
        }
        for (int i12 = 0; i12 < this.f35516m.size(); i12++) {
            iO += CodedOutputStream.s(12, this.f35516m.get(i12));
        }
        int iP = 0;
        for (int i13 = 0; i13 < this.f35517n.size(); i13++) {
            iP += CodedOutputStream.p(this.f35517n.get(i13).intValue());
        }
        int iS = iO + iP;
        if (!x0().isEmpty()) {
            iS = iS + 1 + CodedOutputStream.p(iP);
        }
        this.f35518o = iP;
        for (int i14 = 0; i14 < this.f35525v.size(); i14++) {
            iS += CodedOutputStream.s(14, this.f35525v.get(i14));
        }
        for (int i15 = 0; i15 < this.f35526w.size(); i15++) {
            iS += CodedOutputStream.s(15, this.f35526w.get(i15));
        }
        for (int i16 = 0; i16 < this.f35527x.size(); i16++) {
            iS += CodedOutputStream.s(16, this.f35527x.get(i16));
        }
        for (int i17 = 0; i17 < this.f35519p.size(); i17++) {
            iS += CodedOutputStream.s(17, this.f35519p.get(i17));
        }
        int iP2 = 0;
        for (int i18 = 0; i18 < this.f35523t.size(); i18++) {
            iP2 += CodedOutputStream.p(this.f35523t.get(i18).intValue());
        }
        int size = iS + iP2 + (a1().size() * 2);
        for (int i19 = 0; i19 < this.f35524u.size(); i19++) {
            size += CodedOutputStream.s(32, this.f35524u.get(i19));
        }
        for (int i20 = 0; i20 < this.f35528y.size(); i20++) {
            size += CodedOutputStream.s(33, this.f35528y.get(i20));
        }
        for (int i21 = 0; i21 < this.f35529z.size(); i21++) {
            size += CodedOutputStream.s(34, this.f35529z.get(i21));
        }
        for (int i22 = 0; i22 < this.f35503A.size(); i22++) {
            size += CodedOutputStream.s(35, this.f35503A.get(i22));
        }
        int iQ = size + q() + this.f35506c.size();
        this.f35505C = iQ;
        return iQ;
    }

    public boolean h1() {
        return (this.f35507d & 8) == 8;
    }

    public boolean i1() {
        return (this.f35507d & 16) == 16;
    }

    @Override // ia.InterfaceC4187g
    public final boolean isInitialized() {
        byte b10 = this.f35504B;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!d1()) {
            this.f35504B = (byte) 0;
            return false;
        }
        if (h1() && !Q0().isInitialized()) {
            this.f35504B = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < Y0(); i10++) {
            if (!X0(i10).isInitialized()) {
                this.f35504B = (byte) 0;
                return false;
            }
        }
        if (f1() && !O0().isInitialized()) {
            this.f35504B = (byte) 0;
            return false;
        }
        for (int i11 = 0; i11 < w0(); i11++) {
            if (!v0(i11).isInitialized()) {
                this.f35504B = (byte) 0;
                return false;
            }
        }
        for (int i12 = 0; i12 < t0(); i12++) {
            if (!s0(i12).isInitialized()) {
                this.f35504B = (byte) 0;
                return false;
            }
        }
        if (k1() && !W0().isInitialized()) {
            this.f35504B = (byte) 0;
            return false;
        }
        for (int i13 = 0; i13 < r0(); i13++) {
            if (!q0(i13).isInitialized()) {
                this.f35504B = (byte) 0;
                return false;
            }
        }
        for (int i14 = 0; i14 < l0(); i14++) {
            if (!k0(i14).isInitialized()) {
                this.f35504B = (byte) 0;
                return false;
            }
        }
        for (int i15 = 0; i15 < J0(); i15++) {
            if (!I0(i15).isInitialized()) {
                this.f35504B = (byte) 0;
                return false;
            }
        }
        for (int i16 = 0; i16 < T0(); i16++) {
            if (!S0(i16).isInitialized()) {
                this.f35504B = (byte) 0;
                return false;
            }
        }
        for (int i17 = 0; i17 < F0(); i17++) {
            if (!E0(i17).isInitialized()) {
                this.f35504B = (byte) 0;
                return false;
            }
        }
        for (int i18 = 0; i18 < o0(); i18++) {
            if (!n0(i18).isInitialized()) {
                this.f35504B = (byte) 0;
                return false;
            }
        }
        for (int i19 = 0; i19 < C0(); i19++) {
            if (!B0(i19).isInitialized()) {
                this.f35504B = (byte) 0;
                return false;
            }
        }
        if (n()) {
            this.f35504B = (byte) 1;
            return true;
        }
        this.f35504B = (byte) 0;
        return false;
    }

    public boolean j1() {
        return (this.f35507d & 512) == 512;
    }

    public ProtoBuf$Annotation k0(int i10) {
        return this.f35525v.get(i10);
    }

    public boolean k1() {
        return (this.f35507d & 128) == 128;
    }

    public int l0() {
        return this.f35525v.size();
    }

    public List<ProtoBuf$Annotation> m0() {
        return this.f35525v;
    }

    public ProtoBuf$Annotation n0(int i10) {
        return this.f35529z.get(i10);
    }

    public int o0() {
        return this.f35529z.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return m1();
    }

    public List<ProtoBuf$Annotation> p0() {
        return this.f35529z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return n1(this);
    }

    public ProtoBuf$CompilerPluginData q0(int i10) {
        return this.f35524u.get(i10);
    }

    public int r0() {
        return this.f35524u.size();
    }

    public ProtoBuf$ValueParameter s0(int i10) {
        return this.f35519p.get(i10);
    }

    public int t0() {
        return this.f35519p.size();
    }

    public List<ProtoBuf$ValueParameter> u0() {
        return this.f35519p;
    }

    public ProtoBuf$Type v0(int i10) {
        return this.f35516m.get(i10);
    }

    public int w0() {
        return this.f35516m.size();
    }

    public List<Integer> x0() {
        return this.f35517n;
    }

    public List<ProtoBuf$Type> y0() {
        return this.f35516m;
    }

    public ProtoBuf$Property(GeneratedMessageLite.c<ProtoBuf$Property, ?> cVar) {
        super(cVar);
        this.f35518o = -1;
        this.f35504B = (byte) -1;
        this.f35505C = -1;
        this.f35506c = cVar.h();
    }

    public ProtoBuf$Property(boolean z10) {
        this.f35518o = -1;
        this.f35504B = (byte) -1;
        this.f35505C = -1;
        this.f35506c = AbstractC4182b.f33086a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0046  */
    /* JADX WARN: Type inference failed for: r4v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ProtoBuf$Property(kotlin.reflect.jvm.internal.impl.protobuf.c r23, kotlin.reflect.jvm.internal.impl.protobuf.d r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property.<init>(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):void");
    }
}
