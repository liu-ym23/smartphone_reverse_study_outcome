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
import kotlin.reflect.jvm.internal.impl.protobuf.f;

/* loaded from: classes5.dex */
public final class ProtoBuf$Class extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Class> implements InterfaceC4187g {

    /* renamed from: H, reason: collision with root package name */
    public static final ProtoBuf$Class f35283H;

    /* renamed from: I, reason: collision with root package name */
    public static InterfaceC4188h<ProtoBuf$Class> f35284I = new a();

    /* renamed from: A, reason: collision with root package name */
    public List<ProtoBuf$Annotation> f35285A;

    /* renamed from: B, reason: collision with root package name */
    public ProtoBuf$TypeTable f35286B;

    /* renamed from: C, reason: collision with root package name */
    public List<Integer> f35287C;

    /* renamed from: D, reason: collision with root package name */
    public ProtoBuf$VersionRequirementTable f35288D;

    /* renamed from: E, reason: collision with root package name */
    public List<ProtoBuf$CompilerPluginData> f35289E;

    /* renamed from: F, reason: collision with root package name */
    public byte f35290F;

    /* renamed from: G, reason: collision with root package name */
    public int f35291G;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC4182b f35292c;

    /* renamed from: d, reason: collision with root package name */
    public int f35293d;

    /* renamed from: e, reason: collision with root package name */
    public int f35294e;

    /* renamed from: f, reason: collision with root package name */
    public int f35295f;

    /* renamed from: g, reason: collision with root package name */
    public int f35296g;

    /* renamed from: h, reason: collision with root package name */
    public List<ProtoBuf$TypeParameter> f35297h;

    /* renamed from: i, reason: collision with root package name */
    public List<ProtoBuf$Type> f35298i;

    /* renamed from: j, reason: collision with root package name */
    public List<Integer> f35299j;

    /* renamed from: k, reason: collision with root package name */
    public int f35300k;

    /* renamed from: l, reason: collision with root package name */
    public List<Integer> f35301l;

    /* renamed from: m, reason: collision with root package name */
    public int f35302m;

    /* renamed from: n, reason: collision with root package name */
    public List<ProtoBuf$Type> f35303n;

    /* renamed from: o, reason: collision with root package name */
    public List<Integer> f35304o;

    /* renamed from: p, reason: collision with root package name */
    public int f35305p;

    /* renamed from: q, reason: collision with root package name */
    public List<ProtoBuf$Constructor> f35306q;

    /* renamed from: r, reason: collision with root package name */
    public List<ProtoBuf$Function> f35307r;

    /* renamed from: s, reason: collision with root package name */
    public List<ProtoBuf$Property> f35308s;

    /* renamed from: t, reason: collision with root package name */
    public List<ProtoBuf$TypeAlias> f35309t;

    /* renamed from: u, reason: collision with root package name */
    public List<ProtoBuf$EnumEntry> f35310u;

    /* renamed from: v, reason: collision with root package name */
    public List<Integer> f35311v;

    /* renamed from: w, reason: collision with root package name */
    public int f35312w;

    /* renamed from: x, reason: collision with root package name */
    public int f35313x;

    /* renamed from: y, reason: collision with root package name */
    public ProtoBuf$Type f35314y;

    /* renamed from: z, reason: collision with root package name */
    public int f35315z;

    public enum Kind implements f.a {
        CLASS(0, 0),
        INTERFACE(1, 1),
        ENUM_CLASS(2, 2),
        ENUM_ENTRY(3, 3),
        ANNOTATION_CLASS(4, 4),
        OBJECT(5, 5),
        COMPANION_OBJECT(6, 6);

        private static f.b<Kind> internalValueMap = new a();
        private final int value;

        public static class a implements f.b<Kind> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Kind findValueByNumber(int i10) {
                return Kind.valueOf(i10);
            }
        }

        Kind(int i10, int i11) {
            this.value = i11;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.a
        public final int getNumber() {
            return this.value;
        }

        public static Kind valueOf(int i10) {
            switch (i10) {
                case 0:
                    return CLASS;
                case 1:
                    return INTERFACE;
                case 2:
                    return ENUM_CLASS;
                case 3:
                    return ENUM_ENTRY;
                case 4:
                    return ANNOTATION_CLASS;
                case 5:
                    return OBJECT;
                case 6:
                    return COMPANION_OBJECT;
                default:
                    return null;
            }
        }
    }

    public static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ProtoBuf$Class> {
        @Override // ia.InterfaceC4188h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$Class c(c cVar, d dVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$Class(cVar, dVar);
        }
    }

    public static final class b extends GeneratedMessageLite.c<ProtoBuf$Class, b> implements InterfaceC4187g {

        /* renamed from: A, reason: collision with root package name */
        public List<ProtoBuf$CompilerPluginData> f35316A;

        /* renamed from: d, reason: collision with root package name */
        public int f35317d;

        /* renamed from: e, reason: collision with root package name */
        public int f35318e = 6;

        /* renamed from: f, reason: collision with root package name */
        public int f35319f;

        /* renamed from: g, reason: collision with root package name */
        public int f35320g;

        /* renamed from: h, reason: collision with root package name */
        public List<ProtoBuf$TypeParameter> f35321h;

        /* renamed from: i, reason: collision with root package name */
        public List<ProtoBuf$Type> f35322i;

        /* renamed from: j, reason: collision with root package name */
        public List<Integer> f35323j;

        /* renamed from: k, reason: collision with root package name */
        public List<Integer> f35324k;

        /* renamed from: l, reason: collision with root package name */
        public List<ProtoBuf$Type> f35325l;

        /* renamed from: m, reason: collision with root package name */
        public List<Integer> f35326m;

        /* renamed from: n, reason: collision with root package name */
        public List<ProtoBuf$Constructor> f35327n;

        /* renamed from: o, reason: collision with root package name */
        public List<ProtoBuf$Function> f35328o;

        /* renamed from: p, reason: collision with root package name */
        public List<ProtoBuf$Property> f35329p;

        /* renamed from: q, reason: collision with root package name */
        public List<ProtoBuf$TypeAlias> f35330q;

        /* renamed from: r, reason: collision with root package name */
        public List<ProtoBuf$EnumEntry> f35331r;

        /* renamed from: s, reason: collision with root package name */
        public List<Integer> f35332s;

        /* renamed from: t, reason: collision with root package name */
        public int f35333t;

        /* renamed from: u, reason: collision with root package name */
        public ProtoBuf$Type f35334u;

        /* renamed from: v, reason: collision with root package name */
        public int f35335v;

        /* renamed from: w, reason: collision with root package name */
        public List<ProtoBuf$Annotation> f35336w;

        /* renamed from: x, reason: collision with root package name */
        public ProtoBuf$TypeTable f35337x;

        /* renamed from: y, reason: collision with root package name */
        public List<Integer> f35338y;

        /* renamed from: z, reason: collision with root package name */
        public ProtoBuf$VersionRequirementTable f35339z;

        public b() {
            List list = Collections.EMPTY_LIST;
            this.f35321h = list;
            this.f35322i = list;
            this.f35323j = list;
            this.f35324k = list;
            this.f35325l = list;
            this.f35326m = list;
            this.f35327n = list;
            this.f35328o = list;
            this.f35329p = list;
            this.f35330q = list;
            this.f35331r = list;
            this.f35332s = list;
            this.f35334u = ProtoBuf$Type.X();
            this.f35336w = list;
            this.f35337x = ProtoBuf$TypeTable.u();
            this.f35338y = list;
            this.f35339z = ProtoBuf$VersionRequirementTable.s();
            this.f35316A = list;
            N();
        }

        private void N() {
        }

        public static b u() {
            return new b();
        }

        public final void B() {
            if ((this.f35317d & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 8192) {
                this.f35331r = new ArrayList(this.f35331r);
                this.f35317d |= com.stepos.agentframework.chatui.longtext.b.THRESHOLD;
            }
        }

        public final void C() {
            if ((this.f35317d & 1024) != 1024) {
                this.f35328o = new ArrayList(this.f35328o);
                this.f35317d |= 1024;
            }
        }

        public final void D() {
            if ((this.f35317d & 64) != 64) {
                this.f35324k = new ArrayList(this.f35324k);
                this.f35317d |= 64;
            }
        }

        public final void E() {
            if ((this.f35317d & 2048) != 2048) {
                this.f35329p = new ArrayList(this.f35329p);
                this.f35317d |= 2048;
            }
        }

        public final void F() {
            if ((this.f35317d & 16384) != 16384) {
                this.f35332s = new ArrayList(this.f35332s);
                this.f35317d |= 16384;
            }
        }

        public final void H() {
            if ((this.f35317d & 32) != 32) {
                this.f35323j = new ArrayList(this.f35323j);
                this.f35317d |= 32;
            }
        }

        public final void I() {
            if ((this.f35317d & 16) != 16) {
                this.f35322i = new ArrayList(this.f35322i);
                this.f35317d |= 16;
            }
        }

        public final void K() {
            if ((this.f35317d & 4096) != 4096) {
                this.f35330q = new ArrayList(this.f35330q);
                this.f35317d |= 4096;
            }
        }

        public final void L() {
            if ((this.f35317d & 8) != 8) {
                this.f35321h = new ArrayList(this.f35321h);
                this.f35317d |= 8;
            }
        }

        public final void M() {
            if ((this.f35317d & 1048576) != 1048576) {
                this.f35338y = new ArrayList(this.f35338y);
                this.f35317d |= 1048576;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: O, reason: merged with bridge method [inline-methods] */
        public b i(ProtoBuf$Class protoBuf$Class) {
            if (protoBuf$Class == ProtoBuf$Class.B0()) {
                return this;
            }
            if (protoBuf$Class.h1()) {
                U(protoBuf$Class.G0());
            }
            if (protoBuf$Class.i1()) {
                V(protoBuf$Class.H0());
            }
            if (protoBuf$Class.g1()) {
                T(protoBuf$Class.r0());
            }
            if (!protoBuf$Class.f35297h.isEmpty()) {
                if (this.f35321h.isEmpty()) {
                    this.f35321h = protoBuf$Class.f35297h;
                    this.f35317d &= -9;
                } else {
                    L();
                    this.f35321h.addAll(protoBuf$Class.f35297h);
                }
            }
            if (!protoBuf$Class.f35298i.isEmpty()) {
                if (this.f35322i.isEmpty()) {
                    this.f35322i = protoBuf$Class.f35298i;
                    this.f35317d &= -17;
                } else {
                    I();
                    this.f35322i.addAll(protoBuf$Class.f35298i);
                }
            }
            if (!protoBuf$Class.f35299j.isEmpty()) {
                if (this.f35323j.isEmpty()) {
                    this.f35323j = protoBuf$Class.f35299j;
                    this.f35317d &= -33;
                } else {
                    H();
                    this.f35323j.addAll(protoBuf$Class.f35299j);
                }
            }
            if (!protoBuf$Class.f35301l.isEmpty()) {
                if (this.f35324k.isEmpty()) {
                    this.f35324k = protoBuf$Class.f35301l;
                    this.f35317d &= -65;
                } else {
                    D();
                    this.f35324k.addAll(protoBuf$Class.f35301l);
                }
            }
            if (!protoBuf$Class.f35303n.isEmpty()) {
                if (this.f35325l.isEmpty()) {
                    this.f35325l = protoBuf$Class.f35303n;
                    this.f35317d &= -129;
                } else {
                    z();
                    this.f35325l.addAll(protoBuf$Class.f35303n);
                }
            }
            if (!protoBuf$Class.f35304o.isEmpty()) {
                if (this.f35326m.isEmpty()) {
                    this.f35326m = protoBuf$Class.f35304o;
                    this.f35317d &= -257;
                } else {
                    y();
                    this.f35326m.addAll(protoBuf$Class.f35304o);
                }
            }
            if (!protoBuf$Class.f35306q.isEmpty()) {
                if (this.f35327n.isEmpty()) {
                    this.f35327n = protoBuf$Class.f35306q;
                    this.f35317d &= -513;
                } else {
                    x();
                    this.f35327n.addAll(protoBuf$Class.f35306q);
                }
            }
            if (!protoBuf$Class.f35307r.isEmpty()) {
                if (this.f35328o.isEmpty()) {
                    this.f35328o = protoBuf$Class.f35307r;
                    this.f35317d &= -1025;
                } else {
                    C();
                    this.f35328o.addAll(protoBuf$Class.f35307r);
                }
            }
            if (!protoBuf$Class.f35308s.isEmpty()) {
                if (this.f35329p.isEmpty()) {
                    this.f35329p = protoBuf$Class.f35308s;
                    this.f35317d &= -2049;
                } else {
                    E();
                    this.f35329p.addAll(protoBuf$Class.f35308s);
                }
            }
            if (!protoBuf$Class.f35309t.isEmpty()) {
                if (this.f35330q.isEmpty()) {
                    this.f35330q = protoBuf$Class.f35309t;
                    this.f35317d &= -4097;
                } else {
                    K();
                    this.f35330q.addAll(protoBuf$Class.f35309t);
                }
            }
            if (!protoBuf$Class.f35310u.isEmpty()) {
                if (this.f35331r.isEmpty()) {
                    this.f35331r = protoBuf$Class.f35310u;
                    this.f35317d &= -8193;
                } else {
                    B();
                    this.f35331r.addAll(protoBuf$Class.f35310u);
                }
            }
            if (!protoBuf$Class.f35311v.isEmpty()) {
                if (this.f35332s.isEmpty()) {
                    this.f35332s = protoBuf$Class.f35311v;
                    this.f35317d &= -16385;
                } else {
                    F();
                    this.f35332s.addAll(protoBuf$Class.f35311v);
                }
            }
            if (protoBuf$Class.j1()) {
                W(protoBuf$Class.L0());
            }
            if (protoBuf$Class.k1()) {
                Q(protoBuf$Class.M0());
            }
            if (protoBuf$Class.l1()) {
                X(protoBuf$Class.N0());
            }
            if (!protoBuf$Class.f35285A.isEmpty()) {
                if (this.f35336w.isEmpty()) {
                    this.f35336w = protoBuf$Class.f35285A;
                    this.f35317d &= -262145;
                } else {
                    v();
                    this.f35336w.addAll(protoBuf$Class.f35285A);
                }
            }
            if (protoBuf$Class.m1()) {
                R(protoBuf$Class.d1());
            }
            if (!protoBuf$Class.f35287C.isEmpty()) {
                if (this.f35338y.isEmpty()) {
                    this.f35338y = protoBuf$Class.f35287C;
                    this.f35317d &= -1048577;
                } else {
                    M();
                    this.f35338y.addAll(protoBuf$Class.f35287C);
                }
            }
            if (protoBuf$Class.n1()) {
                S(protoBuf$Class.f1());
            }
            if (!protoBuf$Class.f35289E.isEmpty()) {
                if (this.f35316A.isEmpty()) {
                    this.f35316A = protoBuf$Class.f35289E;
                    this.f35317d &= -4194305;
                } else {
                    w();
                    this.f35316A.addAll(protoBuf$Class.f35289E);
                }
            }
            p(protoBuf$Class);
            j(h().c(protoBuf$Class.f35292c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0449a, kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: P, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class.b m(kotlin.reflect.jvm.internal.impl.protobuf.c r3, kotlin.reflect.jvm.internal.impl.protobuf.d r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class.f35284I     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class.b.d(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class$b");
        }

        public b Q(ProtoBuf$Type protoBuf$Type) {
            if ((this.f35317d & 65536) != 65536 || this.f35334u == ProtoBuf$Type.X()) {
                this.f35334u = protoBuf$Type;
            } else {
                this.f35334u = ProtoBuf$Type.y0(this.f35334u).i(protoBuf$Type).s();
            }
            this.f35317d |= 65536;
            return this;
        }

        public b R(ProtoBuf$TypeTable protoBuf$TypeTable) {
            if ((this.f35317d & 524288) != 524288 || this.f35337x == ProtoBuf$TypeTable.u()) {
                this.f35337x = protoBuf$TypeTable;
            } else {
                this.f35337x = ProtoBuf$TypeTable.D(this.f35337x).i(protoBuf$TypeTable).o();
            }
            this.f35317d |= 524288;
            return this;
        }

        public b S(ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable) {
            if ((this.f35317d & 2097152) != 2097152 || this.f35339z == ProtoBuf$VersionRequirementTable.s()) {
                this.f35339z = protoBuf$VersionRequirementTable;
            } else {
                this.f35339z = ProtoBuf$VersionRequirementTable.x(this.f35339z).i(protoBuf$VersionRequirementTable).o();
            }
            this.f35317d |= 2097152;
            return this;
        }

        public b T(int i10) {
            this.f35317d |= 4;
            this.f35320g = i10;
            return this;
        }

        public b U(int i10) {
            this.f35317d |= 1;
            this.f35318e = i10;
            return this;
        }

        public b V(int i10) {
            this.f35317d |= 2;
            this.f35319f = i10;
            return this;
        }

        public b W(int i10) {
            this.f35317d |= 32768;
            this.f35333t = i10;
            return this;
        }

        public b X(int i10) {
            this.f35317d |= SQLiteDatabase.OPEN_SHAREDCACHE;
            this.f35335v = i10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$Class build() {
            ProtoBuf$Class protoBuf$ClassS = s();
            if (protoBuf$ClassS.isInitialized()) {
                return protoBuf$ClassS;
            }
            throw a.AbstractC0449a.f(protoBuf$ClassS);
        }

        public ProtoBuf$Class s() {
            ProtoBuf$Class protoBuf$Class = new ProtoBuf$Class(this);
            int i10 = this.f35317d;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            protoBuf$Class.f35294e = this.f35318e;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            protoBuf$Class.f35295f = this.f35319f;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            protoBuf$Class.f35296g = this.f35320g;
            if ((this.f35317d & 8) == 8) {
                this.f35321h = Collections.unmodifiableList(this.f35321h);
                this.f35317d &= -9;
            }
            protoBuf$Class.f35297h = this.f35321h;
            if ((this.f35317d & 16) == 16) {
                this.f35322i = Collections.unmodifiableList(this.f35322i);
                this.f35317d &= -17;
            }
            protoBuf$Class.f35298i = this.f35322i;
            if ((this.f35317d & 32) == 32) {
                this.f35323j = Collections.unmodifiableList(this.f35323j);
                this.f35317d &= -33;
            }
            protoBuf$Class.f35299j = this.f35323j;
            if ((this.f35317d & 64) == 64) {
                this.f35324k = Collections.unmodifiableList(this.f35324k);
                this.f35317d &= -65;
            }
            protoBuf$Class.f35301l = this.f35324k;
            if ((this.f35317d & 128) == 128) {
                this.f35325l = Collections.unmodifiableList(this.f35325l);
                this.f35317d &= -129;
            }
            protoBuf$Class.f35303n = this.f35325l;
            if ((this.f35317d & 256) == 256) {
                this.f35326m = Collections.unmodifiableList(this.f35326m);
                this.f35317d &= -257;
            }
            protoBuf$Class.f35304o = this.f35326m;
            if ((this.f35317d & 512) == 512) {
                this.f35327n = Collections.unmodifiableList(this.f35327n);
                this.f35317d &= -513;
            }
            protoBuf$Class.f35306q = this.f35327n;
            if ((this.f35317d & 1024) == 1024) {
                this.f35328o = Collections.unmodifiableList(this.f35328o);
                this.f35317d &= -1025;
            }
            protoBuf$Class.f35307r = this.f35328o;
            if ((this.f35317d & 2048) == 2048) {
                this.f35329p = Collections.unmodifiableList(this.f35329p);
                this.f35317d &= -2049;
            }
            protoBuf$Class.f35308s = this.f35329p;
            if ((this.f35317d & 4096) == 4096) {
                this.f35330q = Collections.unmodifiableList(this.f35330q);
                this.f35317d &= -4097;
            }
            protoBuf$Class.f35309t = this.f35330q;
            if ((this.f35317d & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) == 8192) {
                this.f35331r = Collections.unmodifiableList(this.f35331r);
                this.f35317d &= -8193;
            }
            protoBuf$Class.f35310u = this.f35331r;
            if ((this.f35317d & 16384) == 16384) {
                this.f35332s = Collections.unmodifiableList(this.f35332s);
                this.f35317d &= -16385;
            }
            protoBuf$Class.f35311v = this.f35332s;
            if ((i10 & 32768) == 32768) {
                i11 |= 8;
            }
            protoBuf$Class.f35313x = this.f35333t;
            if ((i10 & 65536) == 65536) {
                i11 |= 16;
            }
            protoBuf$Class.f35314y = this.f35334u;
            if ((i10 & SQLiteDatabase.OPEN_SHAREDCACHE) == 131072) {
                i11 |= 32;
            }
            protoBuf$Class.f35315z = this.f35335v;
            if ((this.f35317d & SQLiteDatabase.OPEN_PRIVATECACHE) == 262144) {
                this.f35336w = Collections.unmodifiableList(this.f35336w);
                this.f35317d &= -262145;
            }
            protoBuf$Class.f35285A = this.f35336w;
            if ((i10 & 524288) == 524288) {
                i11 |= 64;
            }
            protoBuf$Class.f35286B = this.f35337x;
            if ((this.f35317d & 1048576) == 1048576) {
                this.f35338y = Collections.unmodifiableList(this.f35338y);
                this.f35317d &= -1048577;
            }
            protoBuf$Class.f35287C = this.f35338y;
            if ((i10 & 2097152) == 2097152) {
                i11 |= 128;
            }
            protoBuf$Class.f35288D = this.f35339z;
            if ((this.f35317d & 4194304) == 4194304) {
                this.f35316A = Collections.unmodifiableList(this.f35316A);
                this.f35317d &= -4194305;
            }
            protoBuf$Class.f35289E = this.f35316A;
            protoBuf$Class.f35293d = i11;
            return protoBuf$Class;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public b g() {
            return u().i(s());
        }

        public final void v() {
            if ((this.f35317d & SQLiteDatabase.OPEN_PRIVATECACHE) != 262144) {
                this.f35336w = new ArrayList(this.f35336w);
                this.f35317d |= SQLiteDatabase.OPEN_PRIVATECACHE;
            }
        }

        public final void w() {
            if ((this.f35317d & 4194304) != 4194304) {
                this.f35316A = new ArrayList(this.f35316A);
                this.f35317d |= 4194304;
            }
        }

        public final void x() {
            if ((this.f35317d & 512) != 512) {
                this.f35327n = new ArrayList(this.f35327n);
                this.f35317d |= 512;
            }
        }

        public final void y() {
            if ((this.f35317d & 256) != 256) {
                this.f35326m = new ArrayList(this.f35326m);
                this.f35317d |= 256;
            }
        }

        public final void z() {
            if ((this.f35317d & 128) != 128) {
                this.f35325l = new ArrayList(this.f35325l);
                this.f35317d |= 128;
            }
        }
    }

    static {
        ProtoBuf$Class protoBuf$Class = new ProtoBuf$Class(true);
        f35283H = protoBuf$Class;
        protoBuf$Class.o1();
    }

    public static ProtoBuf$Class B0() {
        return f35283H;
    }

    private void o1() {
        this.f35294e = 6;
        this.f35295f = 0;
        this.f35296g = 0;
        List list = Collections.EMPTY_LIST;
        this.f35297h = list;
        this.f35298i = list;
        this.f35299j = list;
        this.f35301l = list;
        this.f35303n = list;
        this.f35304o = list;
        this.f35306q = list;
        this.f35307r = list;
        this.f35308s = list;
        this.f35309t = list;
        this.f35310u = list;
        this.f35311v = list;
        this.f35313x = 0;
        this.f35314y = ProtoBuf$Type.X();
        this.f35315z = 0;
        this.f35285A = list;
        this.f35286B = ProtoBuf$TypeTable.u();
        this.f35287C = list;
        this.f35288D = ProtoBuf$VersionRequirementTable.s();
        this.f35289E = list;
    }

    public static b p1() {
        return b.u();
    }

    public static b q1(ProtoBuf$Class protoBuf$Class) {
        return p1().i(protoBuf$Class);
    }

    public static ProtoBuf$Class s1(InputStream inputStream, d dVar) throws IOException {
        return f35284I.a(inputStream, dVar);
    }

    public List<ProtoBuf$Type> A0() {
        return this.f35303n;
    }

    @Override // ia.InterfaceC4187g
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public ProtoBuf$Class getDefaultInstanceForType() {
        return f35283H;
    }

    public ProtoBuf$EnumEntry D0(int i10) {
        return this.f35310u.get(i10);
    }

    public int E0() {
        return this.f35310u.size();
    }

    public List<ProtoBuf$EnumEntry> F0() {
        return this.f35310u;
    }

    public int G0() {
        return this.f35294e;
    }

    public int H0() {
        return this.f35295f;
    }

    public ProtoBuf$Function I0(int i10) {
        return this.f35307r.get(i10);
    }

    public int J0() {
        return this.f35307r.size();
    }

    public List<ProtoBuf$Function> K0() {
        return this.f35307r;
    }

    public int L0() {
        return this.f35313x;
    }

    public ProtoBuf$Type M0() {
        return this.f35314y;
    }

    public int N0() {
        return this.f35315z;
    }

    public List<Integer> O0() {
        return this.f35301l;
    }

    public ProtoBuf$Property P0(int i10) {
        return this.f35308s.get(i10);
    }

    public int Q0() {
        return this.f35308s.size();
    }

    public List<ProtoBuf$Property> R0() {
        return this.f35308s;
    }

    public List<Integer> S0() {
        return this.f35311v;
    }

    public ProtoBuf$Type T0(int i10) {
        return this.f35298i.get(i10);
    }

    public int U0() {
        return this.f35298i.size();
    }

    public List<Integer> V0() {
        return this.f35299j;
    }

    public List<ProtoBuf$Type> W0() {
        return this.f35298i;
    }

    public ProtoBuf$TypeAlias X0(int i10) {
        return this.f35309t.get(i10);
    }

    public int Y0() {
        return this.f35309t.size();
    }

    public List<ProtoBuf$TypeAlias> Z0() {
        return this.f35309t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.a aVarW = w();
        if ((this.f35293d & 1) == 1) {
            codedOutputStream.a0(1, this.f35294e);
        }
        if (V0().size() > 0) {
            codedOutputStream.o0(18);
            codedOutputStream.o0(this.f35300k);
        }
        for (int i10 = 0; i10 < this.f35299j.size(); i10++) {
            codedOutputStream.b0(this.f35299j.get(i10).intValue());
        }
        if ((this.f35293d & 2) == 2) {
            codedOutputStream.a0(3, this.f35295f);
        }
        if ((this.f35293d & 4) == 4) {
            codedOutputStream.a0(4, this.f35296g);
        }
        for (int i11 = 0; i11 < this.f35297h.size(); i11++) {
            codedOutputStream.d0(5, this.f35297h.get(i11));
        }
        for (int i12 = 0; i12 < this.f35298i.size(); i12++) {
            codedOutputStream.d0(6, this.f35298i.get(i12));
        }
        if (O0().size() > 0) {
            codedOutputStream.o0(58);
            codedOutputStream.o0(this.f35302m);
        }
        for (int i13 = 0; i13 < this.f35301l.size(); i13++) {
            codedOutputStream.b0(this.f35301l.get(i13).intValue());
        }
        for (int i14 = 0; i14 < this.f35306q.size(); i14++) {
            codedOutputStream.d0(8, this.f35306q.get(i14));
        }
        for (int i15 = 0; i15 < this.f35307r.size(); i15++) {
            codedOutputStream.d0(9, this.f35307r.get(i15));
        }
        for (int i16 = 0; i16 < this.f35308s.size(); i16++) {
            codedOutputStream.d0(10, this.f35308s.get(i16));
        }
        for (int i17 = 0; i17 < this.f35309t.size(); i17++) {
            codedOutputStream.d0(11, this.f35309t.get(i17));
        }
        for (int i18 = 0; i18 < this.f35310u.size(); i18++) {
            codedOutputStream.d0(13, this.f35310u.get(i18));
        }
        if (S0().size() > 0) {
            codedOutputStream.o0(130);
            codedOutputStream.o0(this.f35312w);
        }
        for (int i19 = 0; i19 < this.f35311v.size(); i19++) {
            codedOutputStream.b0(this.f35311v.get(i19).intValue());
        }
        if ((this.f35293d & 8) == 8) {
            codedOutputStream.a0(17, this.f35313x);
        }
        if ((this.f35293d & 16) == 16) {
            codedOutputStream.d0(18, this.f35314y);
        }
        if ((this.f35293d & 32) == 32) {
            codedOutputStream.a0(19, this.f35315z);
        }
        for (int i20 = 0; i20 < this.f35303n.size(); i20++) {
            codedOutputStream.d0(20, this.f35303n.get(i20));
        }
        if (z0().size() > 0) {
            codedOutputStream.o0(170);
            codedOutputStream.o0(this.f35305p);
        }
        for (int i21 = 0; i21 < this.f35304o.size(); i21++) {
            codedOutputStream.b0(this.f35304o.get(i21).intValue());
        }
        for (int i22 = 0; i22 < this.f35285A.size(); i22++) {
            codedOutputStream.d0(25, this.f35285A.get(i22));
        }
        if ((this.f35293d & 64) == 64) {
            codedOutputStream.d0(30, this.f35286B);
        }
        for (int i23 = 0; i23 < this.f35287C.size(); i23++) {
            codedOutputStream.a0(31, this.f35287C.get(i23).intValue());
        }
        if ((this.f35293d & 128) == 128) {
            codedOutputStream.d0(32, this.f35288D);
        }
        for (int i24 = 0; i24 < this.f35289E.size(); i24++) {
            codedOutputStream.d0(33, this.f35289E.get(i24));
        }
        aVarW.a(19000, codedOutputStream);
        codedOutputStream.i0(this.f35292c);
    }

    public ProtoBuf$TypeParameter a1(int i10) {
        return this.f35297h.get(i10);
    }

    public int b1() {
        return this.f35297h.size();
    }

    public List<ProtoBuf$TypeParameter> c1() {
        return this.f35297h;
    }

    public ProtoBuf$TypeTable d1() {
        return this.f35286B;
    }

    public List<Integer> e1() {
        return this.f35287C;
    }

    public ProtoBuf$VersionRequirementTable f1() {
        return this.f35288D;
    }

    public boolean g1() {
        return (this.f35293d & 4) == 4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.h
    public InterfaceC4188h<ProtoBuf$Class> getParserForType() {
        return f35284I;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i10 = this.f35291G;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f35293d & 1) == 1 ? CodedOutputStream.o(1, this.f35294e) : 0;
        int iP = 0;
        for (int i11 = 0; i11 < this.f35299j.size(); i11++) {
            iP += CodedOutputStream.p(this.f35299j.get(i11).intValue());
        }
        int iS = iO + iP;
        if (!V0().isEmpty()) {
            iS = iS + 1 + CodedOutputStream.p(iP);
        }
        this.f35300k = iP;
        if ((this.f35293d & 2) == 2) {
            iS += CodedOutputStream.o(3, this.f35295f);
        }
        if ((this.f35293d & 4) == 4) {
            iS += CodedOutputStream.o(4, this.f35296g);
        }
        for (int i12 = 0; i12 < this.f35297h.size(); i12++) {
            iS += CodedOutputStream.s(5, this.f35297h.get(i12));
        }
        for (int i13 = 0; i13 < this.f35298i.size(); i13++) {
            iS += CodedOutputStream.s(6, this.f35298i.get(i13));
        }
        int iP2 = 0;
        for (int i14 = 0; i14 < this.f35301l.size(); i14++) {
            iP2 += CodedOutputStream.p(this.f35301l.get(i14).intValue());
        }
        int iS2 = iS + iP2;
        if (!O0().isEmpty()) {
            iS2 = iS2 + 1 + CodedOutputStream.p(iP2);
        }
        this.f35302m = iP2;
        for (int i15 = 0; i15 < this.f35306q.size(); i15++) {
            iS2 += CodedOutputStream.s(8, this.f35306q.get(i15));
        }
        for (int i16 = 0; i16 < this.f35307r.size(); i16++) {
            iS2 += CodedOutputStream.s(9, this.f35307r.get(i16));
        }
        for (int i17 = 0; i17 < this.f35308s.size(); i17++) {
            iS2 += CodedOutputStream.s(10, this.f35308s.get(i17));
        }
        for (int i18 = 0; i18 < this.f35309t.size(); i18++) {
            iS2 += CodedOutputStream.s(11, this.f35309t.get(i18));
        }
        for (int i19 = 0; i19 < this.f35310u.size(); i19++) {
            iS2 += CodedOutputStream.s(13, this.f35310u.get(i19));
        }
        int iP3 = 0;
        for (int i20 = 0; i20 < this.f35311v.size(); i20++) {
            iP3 += CodedOutputStream.p(this.f35311v.get(i20).intValue());
        }
        int iS3 = iS2 + iP3;
        if (!S0().isEmpty()) {
            iS3 = iS3 + 2 + CodedOutputStream.p(iP3);
        }
        this.f35312w = iP3;
        if ((this.f35293d & 8) == 8) {
            iS3 += CodedOutputStream.o(17, this.f35313x);
        }
        if ((this.f35293d & 16) == 16) {
            iS3 += CodedOutputStream.s(18, this.f35314y);
        }
        if ((this.f35293d & 32) == 32) {
            iS3 += CodedOutputStream.o(19, this.f35315z);
        }
        for (int i21 = 0; i21 < this.f35303n.size(); i21++) {
            iS3 += CodedOutputStream.s(20, this.f35303n.get(i21));
        }
        int iP4 = 0;
        for (int i22 = 0; i22 < this.f35304o.size(); i22++) {
            iP4 += CodedOutputStream.p(this.f35304o.get(i22).intValue());
        }
        int iS4 = iS3 + iP4;
        if (!z0().isEmpty()) {
            iS4 = iS4 + 2 + CodedOutputStream.p(iP4);
        }
        this.f35305p = iP4;
        for (int i23 = 0; i23 < this.f35285A.size(); i23++) {
            iS4 += CodedOutputStream.s(25, this.f35285A.get(i23));
        }
        if ((this.f35293d & 64) == 64) {
            iS4 += CodedOutputStream.s(30, this.f35286B);
        }
        int iP5 = 0;
        for (int i24 = 0; i24 < this.f35287C.size(); i24++) {
            iP5 += CodedOutputStream.p(this.f35287C.get(i24).intValue());
        }
        int size = iS4 + iP5 + (e1().size() * 2);
        if ((this.f35293d & 128) == 128) {
            size += CodedOutputStream.s(32, this.f35288D);
        }
        for (int i25 = 0; i25 < this.f35289E.size(); i25++) {
            size += CodedOutputStream.s(33, this.f35289E.get(i25));
        }
        int iQ = size + q() + this.f35292c.size();
        this.f35291G = iQ;
        return iQ;
    }

    public boolean h1() {
        return (this.f35293d & 1) == 1;
    }

    public boolean i1() {
        return (this.f35293d & 2) == 2;
    }

    @Override // ia.InterfaceC4187g
    public final boolean isInitialized() {
        byte b10 = this.f35290F;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!i1()) {
            this.f35290F = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < b1(); i10++) {
            if (!a1(i10).isInitialized()) {
                this.f35290F = (byte) 0;
                return false;
            }
        }
        for (int i11 = 0; i11 < U0(); i11++) {
            if (!T0(i11).isInitialized()) {
                this.f35290F = (byte) 0;
                return false;
            }
        }
        for (int i12 = 0; i12 < y0(); i12++) {
            if (!x0(i12).isInitialized()) {
                this.f35290F = (byte) 0;
                return false;
            }
        }
        for (int i13 = 0; i13 < v0(); i13++) {
            if (!u0(i13).isInitialized()) {
                this.f35290F = (byte) 0;
                return false;
            }
        }
        for (int i14 = 0; i14 < J0(); i14++) {
            if (!I0(i14).isInitialized()) {
                this.f35290F = (byte) 0;
                return false;
            }
        }
        for (int i15 = 0; i15 < Q0(); i15++) {
            if (!P0(i15).isInitialized()) {
                this.f35290F = (byte) 0;
                return false;
            }
        }
        for (int i16 = 0; i16 < Y0(); i16++) {
            if (!X0(i16).isInitialized()) {
                this.f35290F = (byte) 0;
                return false;
            }
        }
        for (int i17 = 0; i17 < E0(); i17++) {
            if (!D0(i17).isInitialized()) {
                this.f35290F = (byte) 0;
                return false;
            }
        }
        if (k1() && !M0().isInitialized()) {
            this.f35290F = (byte) 0;
            return false;
        }
        for (int i18 = 0; i18 < p0(); i18++) {
            if (!o0(i18).isInitialized()) {
                this.f35290F = (byte) 0;
                return false;
            }
        }
        if (m1() && !d1().isInitialized()) {
            this.f35290F = (byte) 0;
            return false;
        }
        for (int i19 = 0; i19 < t0(); i19++) {
            if (!s0(i19).isInitialized()) {
                this.f35290F = (byte) 0;
                return false;
            }
        }
        if (n()) {
            this.f35290F = (byte) 1;
            return true;
        }
        this.f35290F = (byte) 0;
        return false;
    }

    public boolean j1() {
        return (this.f35293d & 8) == 8;
    }

    public boolean k1() {
        return (this.f35293d & 16) == 16;
    }

    public boolean l1() {
        return (this.f35293d & 32) == 32;
    }

    public boolean m1() {
        return (this.f35293d & 64) == 64;
    }

    public boolean n1() {
        return (this.f35293d & 128) == 128;
    }

    public ProtoBuf$Annotation o0(int i10) {
        return this.f35285A.get(i10);
    }

    public int p0() {
        return this.f35285A.size();
    }

    public List<ProtoBuf$Annotation> q0() {
        return this.f35285A;
    }

    public int r0() {
        return this.f35296g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: r1, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return p1();
    }

    public ProtoBuf$CompilerPluginData s0(int i10) {
        return this.f35289E.get(i10);
    }

    public int t0() {
        return this.f35289E.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    /* renamed from: t1, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return q1(this);
    }

    public ProtoBuf$Constructor u0(int i10) {
        return this.f35306q.get(i10);
    }

    public int v0() {
        return this.f35306q.size();
    }

    public List<ProtoBuf$Constructor> w0() {
        return this.f35306q;
    }

    public ProtoBuf$Type x0(int i10) {
        return this.f35303n.get(i10);
    }

    public int y0() {
        return this.f35303n.size();
    }

    public List<Integer> z0() {
        return this.f35304o;
    }

    public ProtoBuf$Class(GeneratedMessageLite.c<ProtoBuf$Class, ?> cVar) {
        super(cVar);
        this.f35300k = -1;
        this.f35302m = -1;
        this.f35305p = -1;
        this.f35312w = -1;
        this.f35290F = (byte) -1;
        this.f35291G = -1;
        this.f35292c = cVar.h();
    }

    public ProtoBuf$Class(boolean z10) {
        this.f35300k = -1;
        this.f35302m = -1;
        this.f35305p = -1;
        this.f35312w = -1;
        this.f35290F = (byte) -1;
        this.f35291G = -1;
        this.f35292c = AbstractC4182b.f33086a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0049  */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v36 */
    /* JADX WARN: Type inference failed for: r7v38 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v40 */
    /* JADX WARN: Type inference failed for: r7v42 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ProtoBuf$Class(kotlin.reflect.jvm.internal.impl.protobuf.c r22, kotlin.reflect.jvm.internal.impl.protobuf.d r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class.<init>(kotlin.reflect.jvm.internal.impl.protobuf.c, kotlin.reflect.jvm.internal.impl.protobuf.d):void");
    }
}
