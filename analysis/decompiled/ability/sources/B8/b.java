package B8;

import H8.AbstractC0241b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.m;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class b extends kotlin.reflect.jvm.internal.impl.protobuf.a {

    /* renamed from: A, reason: collision with root package name */
    public List f197A;

    /* renamed from: B, reason: collision with root package name */
    public ProtoBuf$VersionRequirementTable f198B;
    public int d;
    public int e;
    public int f;
    public int g;
    public List h;
    public List i;

    /* renamed from: j, reason: collision with root package name */
    public List f199j;
    public List k;
    public List l;
    public List m;
    public List n;
    public List o;
    public List p;

    /* renamed from: q, reason: collision with root package name */
    public List f200q;

    /* renamed from: r, reason: collision with root package name */
    public List f201r;

    /* renamed from: s, reason: collision with root package name */
    public List f202s;

    /* renamed from: t, reason: collision with root package name */
    public int f203t;
    public ProtoBuf$Type u;

    /* renamed from: v, reason: collision with root package name */
    public int f204v;

    /* renamed from: w, reason: collision with root package name */
    public List f205w;

    /* renamed from: x, reason: collision with root package name */
    public List f206x;
    public List y;

    /* renamed from: z, reason: collision with root package name */
    public ProtoBuf$TypeTable f207z;

    public static b f() {
        b bVar = new b();
        bVar.e = 6;
        List list = Collections.EMPTY_LIST;
        bVar.h = list;
        bVar.i = list;
        bVar.f199j = list;
        bVar.k = list;
        bVar.l = list;
        bVar.m = list;
        bVar.n = list;
        bVar.o = list;
        bVar.p = list;
        bVar.f200q = list;
        bVar.f201r = list;
        bVar.f202s = list;
        bVar.u = ProtoBuf$Type.f5067t;
        bVar.f205w = list;
        bVar.f206x = list;
        bVar.y = list;
        bVar.f207z = ProtoBuf$TypeTable.g;
        bVar.f197A = list;
        bVar.f198B = ProtoBuf$VersionRequirementTable.e;
        return bVar;
    }

    @Override // H8.j
    public final AbstractC0241b a() {
        ProtoBuf$Class protoBuf$ClassE = e();
        if (protoBuf$ClassE.isInitialized()) {
            return protoBuf$ClassE;
        }
        throw new UninitializedMessageException();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    @Override // H8.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final H8.j b(H8.C0245f r3, H8.h r4) throws java.lang.Throwable {
        /*
            r2 = this;
            r0 = 0
            B8.a r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class.f5019O     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r1 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r2.h(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class) r4     // Catch: java.lang.Throwable -> Lf
            throw r3     // Catch: java.lang.Throwable -> L17
        L17:
            r3 = move-exception
            r0 = r4
        L19:
            if (r0 == 0) goto L1e
            r2.h(r0)
        L1e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: B8.b.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        h((ProtoBuf$Class) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        b bVarF = f();
        bVarF.h(e());
        return bVarF;
    }

    public final ProtoBuf$Class e() {
        ProtoBuf$Class protoBuf$Class = new ProtoBuf$Class(this);
        int i = this.d;
        int i6 = (i & 1) != 1 ? 0 : 1;
        protoBuf$Class.d = this.e;
        if ((i & 2) == 2) {
            i6 |= 2;
        }
        protoBuf$Class.e = this.f;
        if ((i & 4) == 4) {
            i6 |= 4;
        }
        protoBuf$Class.f = this.g;
        if ((i & 8) == 8) {
            this.h = Collections.unmodifiableList(this.h);
            this.d &= -9;
        }
        protoBuf$Class.g = this.h;
        if ((this.d & 16) == 16) {
            this.i = Collections.unmodifiableList(this.i);
            this.d &= -17;
        }
        protoBuf$Class.h = this.i;
        if ((this.d & 32) == 32) {
            this.f199j = Collections.unmodifiableList(this.f199j);
            this.d &= -33;
        }
        protoBuf$Class.i = this.f199j;
        if ((this.d & 64) == 64) {
            this.k = Collections.unmodifiableList(this.k);
            this.d &= -65;
        }
        protoBuf$Class.k = this.k;
        if ((this.d & 128) == 128) {
            this.l = Collections.unmodifiableList(this.l);
            this.d &= -129;
        }
        protoBuf$Class.m = this.l;
        if ((this.d & 256) == 256) {
            this.m = Collections.unmodifiableList(this.m);
            this.d &= -257;
        }
        protoBuf$Class.n = this.m;
        if ((this.d & 512) == 512) {
            this.n = Collections.unmodifiableList(this.n);
            this.d &= -513;
        }
        protoBuf$Class.p = this.n;
        if ((this.d & 1024) == 1024) {
            this.o = Collections.unmodifiableList(this.o);
            this.d &= -1025;
        }
        protoBuf$Class.f5029q = this.o;
        if ((this.d & 2048) == 2048) {
            this.p = Collections.unmodifiableList(this.p);
            this.d &= -2049;
        }
        protoBuf$Class.f5030r = this.p;
        if ((this.d & 4096) == 4096) {
            this.f200q = Collections.unmodifiableList(this.f200q);
            this.d &= -4097;
        }
        protoBuf$Class.f5031s = this.f200q;
        if ((this.d & 8192) == 8192) {
            this.f201r = Collections.unmodifiableList(this.f201r);
            this.d &= -8193;
        }
        protoBuf$Class.f5032t = this.f201r;
        if ((this.d & 16384) == 16384) {
            this.f202s = Collections.unmodifiableList(this.f202s);
            this.d &= -16385;
        }
        protoBuf$Class.u = this.f202s;
        if ((i & 32768) == 32768) {
            i6 |= 8;
        }
        protoBuf$Class.f5034w = this.f203t;
        if ((i & 65536) == 65536) {
            i6 |= 16;
        }
        protoBuf$Class.f5035x = this.u;
        if ((i & 131072) == 131072) {
            i6 |= 32;
        }
        protoBuf$Class.y = this.f204v;
        if ((this.d & 262144) == 262144) {
            this.f205w = Collections.unmodifiableList(this.f205w);
            this.d &= -262145;
        }
        protoBuf$Class.f5036z = this.f205w;
        if ((this.d & 524288) == 524288) {
            this.f206x = Collections.unmodifiableList(this.f206x);
            this.d &= -524289;
        }
        protoBuf$Class.f5021B = this.f206x;
        if ((this.d & 1048576) == 1048576) {
            this.y = Collections.unmodifiableList(this.y);
            this.d &= -1048577;
        }
        protoBuf$Class.f5022C = this.y;
        if ((i & 2097152) == 2097152) {
            i6 |= 64;
        }
        protoBuf$Class.E = this.f207z;
        if ((this.d & 4194304) == 4194304) {
            this.f197A = Collections.unmodifiableList(this.f197A);
            this.d &= -4194305;
        }
        protoBuf$Class.f5024F = this.f197A;
        if ((i & 8388608) == 8388608) {
            i6 |= 128;
        }
        protoBuf$Class.f5025G = this.f198B;
        protoBuf$Class.c = i6;
        return protoBuf$Class;
    }

    public final void h(ProtoBuf$Class protoBuf$Class) {
        ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable;
        ProtoBuf$TypeTable protoBuf$TypeTable;
        ProtoBuf$Type protoBuf$Type;
        if (protoBuf$Class == ProtoBuf$Class.f5018N) {
            return;
        }
        int i = protoBuf$Class.c;
        if ((i & 1) == 1) {
            int i6 = protoBuf$Class.d;
            this.d = 1 | this.d;
            this.e = i6;
        }
        if ((i & 2) == 2) {
            int i10 = protoBuf$Class.e;
            this.d = 2 | this.d;
            this.f = i10;
        }
        if ((i & 4) == 4) {
            int i11 = protoBuf$Class.f;
            this.d = 4 | this.d;
            this.g = i11;
        }
        if (!protoBuf$Class.g.isEmpty()) {
            if (this.h.isEmpty()) {
                this.h = protoBuf$Class.g;
                this.d &= -9;
            } else {
                if ((this.d & 8) != 8) {
                    this.h = new ArrayList(this.h);
                    this.d |= 8;
                }
                this.h.addAll(protoBuf$Class.g);
            }
        }
        if (!protoBuf$Class.h.isEmpty()) {
            if (this.i.isEmpty()) {
                this.i = protoBuf$Class.h;
                this.d &= -17;
            } else {
                if ((this.d & 16) != 16) {
                    this.i = new ArrayList(this.i);
                    this.d |= 16;
                }
                this.i.addAll(protoBuf$Class.h);
            }
        }
        if (!protoBuf$Class.i.isEmpty()) {
            if (this.f199j.isEmpty()) {
                this.f199j = protoBuf$Class.i;
                this.d &= -33;
            } else {
                if ((this.d & 32) != 32) {
                    this.f199j = new ArrayList(this.f199j);
                    this.d |= 32;
                }
                this.f199j.addAll(protoBuf$Class.i);
            }
        }
        if (!protoBuf$Class.k.isEmpty()) {
            if (this.k.isEmpty()) {
                this.k = protoBuf$Class.k;
                this.d &= -65;
            } else {
                if ((this.d & 64) != 64) {
                    this.k = new ArrayList(this.k);
                    this.d |= 64;
                }
                this.k.addAll(protoBuf$Class.k);
            }
        }
        if (!protoBuf$Class.m.isEmpty()) {
            if (this.l.isEmpty()) {
                this.l = protoBuf$Class.m;
                this.d &= -129;
            } else {
                if ((this.d & 128) != 128) {
                    this.l = new ArrayList(this.l);
                    this.d |= 128;
                }
                this.l.addAll(protoBuf$Class.m);
            }
        }
        if (!protoBuf$Class.n.isEmpty()) {
            if (this.m.isEmpty()) {
                this.m = protoBuf$Class.n;
                this.d &= -257;
            } else {
                if ((this.d & 256) != 256) {
                    this.m = new ArrayList(this.m);
                    this.d |= 256;
                }
                this.m.addAll(protoBuf$Class.n);
            }
        }
        if (!protoBuf$Class.p.isEmpty()) {
            if (this.n.isEmpty()) {
                this.n = protoBuf$Class.p;
                this.d &= -513;
            } else {
                if ((this.d & 512) != 512) {
                    this.n = new ArrayList(this.n);
                    this.d |= 512;
                }
                this.n.addAll(protoBuf$Class.p);
            }
        }
        if (!protoBuf$Class.f5029q.isEmpty()) {
            if (this.o.isEmpty()) {
                this.o = protoBuf$Class.f5029q;
                this.d &= -1025;
            } else {
                if ((this.d & 1024) != 1024) {
                    this.o = new ArrayList(this.o);
                    this.d |= 1024;
                }
                this.o.addAll(protoBuf$Class.f5029q);
            }
        }
        if (!protoBuf$Class.f5030r.isEmpty()) {
            if (this.p.isEmpty()) {
                this.p = protoBuf$Class.f5030r;
                this.d &= -2049;
            } else {
                if ((this.d & 2048) != 2048) {
                    this.p = new ArrayList(this.p);
                    this.d |= 2048;
                }
                this.p.addAll(protoBuf$Class.f5030r);
            }
        }
        if (!protoBuf$Class.f5031s.isEmpty()) {
            if (this.f200q.isEmpty()) {
                this.f200q = protoBuf$Class.f5031s;
                this.d &= -4097;
            } else {
                if ((this.d & 4096) != 4096) {
                    this.f200q = new ArrayList(this.f200q);
                    this.d |= 4096;
                }
                this.f200q.addAll(protoBuf$Class.f5031s);
            }
        }
        if (!protoBuf$Class.f5032t.isEmpty()) {
            if (this.f201r.isEmpty()) {
                this.f201r = protoBuf$Class.f5032t;
                this.d &= -8193;
            } else {
                if ((this.d & 8192) != 8192) {
                    this.f201r = new ArrayList(this.f201r);
                    this.d |= 8192;
                }
                this.f201r.addAll(protoBuf$Class.f5032t);
            }
        }
        if (!protoBuf$Class.u.isEmpty()) {
            if (this.f202s.isEmpty()) {
                this.f202s = protoBuf$Class.u;
                this.d &= -16385;
            } else {
                if ((this.d & 16384) != 16384) {
                    this.f202s = new ArrayList(this.f202s);
                    this.d |= 16384;
                }
                this.f202s.addAll(protoBuf$Class.u);
            }
        }
        int i12 = protoBuf$Class.c;
        if ((i12 & 8) == 8) {
            int i13 = protoBuf$Class.f5034w;
            this.d |= 32768;
            this.f203t = i13;
        }
        if ((i12 & 16) == 16) {
            ProtoBuf$Type protoBuf$Type2 = protoBuf$Class.f5035x;
            if ((this.d & 65536) != 65536 || (protoBuf$Type = this.u) == ProtoBuf$Type.f5067t) {
                this.u = protoBuf$Type2;
            } else {
                m mVarO = ProtoBuf$Type.o(protoBuf$Type);
                mVarO.h(protoBuf$Type2);
                this.u = mVarO.e();
            }
            this.d |= 65536;
        }
        if ((protoBuf$Class.c & 32) == 32) {
            int i14 = protoBuf$Class.y;
            this.d |= 131072;
            this.f204v = i14;
        }
        if (!protoBuf$Class.f5036z.isEmpty()) {
            if (this.f205w.isEmpty()) {
                this.f205w = protoBuf$Class.f5036z;
                this.d &= -262145;
            } else {
                if ((this.d & 262144) != 262144) {
                    this.f205w = new ArrayList(this.f205w);
                    this.d |= 262144;
                }
                this.f205w.addAll(protoBuf$Class.f5036z);
            }
        }
        if (!protoBuf$Class.f5021B.isEmpty()) {
            if (this.f206x.isEmpty()) {
                this.f206x = protoBuf$Class.f5021B;
                this.d &= -524289;
            } else {
                if ((this.d & 524288) != 524288) {
                    this.f206x = new ArrayList(this.f206x);
                    this.d |= 524288;
                }
                this.f206x.addAll(protoBuf$Class.f5021B);
            }
        }
        if (!protoBuf$Class.f5022C.isEmpty()) {
            if (this.y.isEmpty()) {
                this.y = protoBuf$Class.f5022C;
                this.d &= -1048577;
            } else {
                if ((this.d & 1048576) != 1048576) {
                    this.y = new ArrayList(this.y);
                    this.d |= 1048576;
                }
                this.y.addAll(protoBuf$Class.f5022C);
            }
        }
        if ((protoBuf$Class.c & 64) == 64) {
            ProtoBuf$TypeTable protoBuf$TypeTable2 = protoBuf$Class.E;
            if ((this.d & 2097152) != 2097152 || (protoBuf$TypeTable = this.f207z) == ProtoBuf$TypeTable.g) {
                this.f207z = protoBuf$TypeTable2;
            } else {
                k kVarG = ProtoBuf$TypeTable.g(protoBuf$TypeTable);
                kVarG.f(protoBuf$TypeTable2);
                this.f207z = kVarG.d();
            }
            this.d |= 2097152;
        }
        if (!protoBuf$Class.f5024F.isEmpty()) {
            if (this.f197A.isEmpty()) {
                this.f197A = protoBuf$Class.f5024F;
                this.d &= -4194305;
            } else {
                if ((this.d & 4194304) != 4194304) {
                    this.f197A = new ArrayList(this.f197A);
                    this.d |= 4194304;
                }
                this.f197A.addAll(protoBuf$Class.f5024F);
            }
        }
        if ((protoBuf$Class.c & 128) == 128) {
            ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable2 = protoBuf$Class.f5025G;
            if ((this.d & 8388608) != 8388608 || (protoBuf$VersionRequirementTable = this.f198B) == ProtoBuf$VersionRequirementTable.e) {
                this.f198B = protoBuf$VersionRequirementTable2;
            } else {
                d dVar = new d(1);
                dVar.d = Collections.EMPTY_LIST;
                dVar.k(protoBuf$VersionRequirementTable);
                dVar.k(protoBuf$VersionRequirementTable2);
                this.f198B = dVar.f();
            }
            this.d |= 8388608;
        }
        d(protoBuf$Class);
        this.f774a = this.f774a.c(protoBuf$Class.b);
    }
}
