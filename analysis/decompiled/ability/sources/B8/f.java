package B8;

import H8.AbstractC0241b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.m;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class f extends kotlin.reflect.jvm.internal.impl.protobuf.a {
    public int d;
    public int e;
    public int f;
    public int g;
    public ProtoBuf$Type h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public List f208j;
    public ProtoBuf$Type k;
    public int l;
    public List m;
    public List n;
    public List o;
    public ProtoBuf$TypeTable p;

    /* renamed from: q, reason: collision with root package name */
    public List f209q;

    /* renamed from: r, reason: collision with root package name */
    public ProtoBuf$Contract f210r;

    public static f f() {
        f fVar = new f();
        fVar.e = 6;
        fVar.f = 6;
        ProtoBuf$Type protoBuf$Type = ProtoBuf$Type.f5067t;
        fVar.h = protoBuf$Type;
        List list = Collections.EMPTY_LIST;
        fVar.f208j = list;
        fVar.k = protoBuf$Type;
        fVar.m = list;
        fVar.n = list;
        fVar.o = list;
        fVar.p = ProtoBuf$TypeTable.g;
        fVar.f209q = list;
        fVar.f210r = ProtoBuf$Contract.e;
        return fVar;
    }

    @Override // H8.j
    public final AbstractC0241b a() {
        ProtoBuf$Function protoBuf$FunctionE = e();
        if (protoBuf$FunctionE.isInitialized()) {
            return protoBuf$FunctionE;
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
            B8.a r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function.f5047v     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r1 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r2.h(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: B8.f.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        h((ProtoBuf$Function) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        f fVarF = f();
        fVarF.h(e());
        return fVarF;
    }

    public final ProtoBuf$Function e() {
        ProtoBuf$Function protoBuf$Function = new ProtoBuf$Function(this);
        int i = this.d;
        int i6 = (i & 1) != 1 ? 0 : 1;
        protoBuf$Function.d = this.e;
        if ((i & 2) == 2) {
            i6 |= 2;
        }
        protoBuf$Function.e = this.f;
        if ((i & 4) == 4) {
            i6 |= 4;
        }
        protoBuf$Function.f = this.g;
        if ((i & 8) == 8) {
            i6 |= 8;
        }
        protoBuf$Function.g = this.h;
        if ((i & 16) == 16) {
            i6 |= 16;
        }
        protoBuf$Function.h = this.i;
        if ((i & 32) == 32) {
            this.f208j = Collections.unmodifiableList(this.f208j);
            this.d &= -33;
        }
        protoBuf$Function.i = this.f208j;
        if ((i & 64) == 64) {
            i6 |= 32;
        }
        protoBuf$Function.f5048j = this.k;
        if ((i & 128) == 128) {
            i6 |= 64;
        }
        protoBuf$Function.k = this.l;
        if ((this.d & 256) == 256) {
            this.m = Collections.unmodifiableList(this.m);
            this.d &= -257;
        }
        protoBuf$Function.l = this.m;
        if ((this.d & 512) == 512) {
            this.n = Collections.unmodifiableList(this.n);
            this.d &= -513;
        }
        protoBuf$Function.m = this.n;
        if ((this.d & 1024) == 1024) {
            this.o = Collections.unmodifiableList(this.o);
            this.d &= -1025;
        }
        protoBuf$Function.o = this.o;
        if ((i & 2048) == 2048) {
            i6 |= 128;
        }
        protoBuf$Function.p = this.p;
        if ((this.d & 4096) == 4096) {
            this.f209q = Collections.unmodifiableList(this.f209q);
            this.d &= -4097;
        }
        protoBuf$Function.f5049q = this.f209q;
        if ((i & 8192) == 8192) {
            i6 |= 256;
        }
        protoBuf$Function.f5050r = this.f210r;
        protoBuf$Function.c = i6;
        return protoBuf$Function;
    }

    public final void h(ProtoBuf$Function protoBuf$Function) {
        ProtoBuf$Contract protoBuf$Contract;
        ProtoBuf$TypeTable protoBuf$TypeTable;
        ProtoBuf$Type protoBuf$Type;
        ProtoBuf$Type protoBuf$Type2;
        if (protoBuf$Function == ProtoBuf$Function.u) {
            return;
        }
        int i = protoBuf$Function.c;
        if ((i & 1) == 1) {
            int i6 = protoBuf$Function.d;
            this.d = 1 | this.d;
            this.e = i6;
        }
        if ((i & 2) == 2) {
            int i10 = protoBuf$Function.e;
            this.d = 2 | this.d;
            this.f = i10;
        }
        if ((i & 4) == 4) {
            int i11 = protoBuf$Function.f;
            this.d = 4 | this.d;
            this.g = i11;
        }
        if ((i & 8) == 8) {
            ProtoBuf$Type protoBuf$Type3 = protoBuf$Function.g;
            if ((this.d & 8) != 8 || (protoBuf$Type2 = this.h) == ProtoBuf$Type.f5067t) {
                this.h = protoBuf$Type3;
            } else {
                m mVarO = ProtoBuf$Type.o(protoBuf$Type2);
                mVarO.h(protoBuf$Type3);
                this.h = mVarO.e();
            }
            this.d |= 8;
        }
        if ((protoBuf$Function.c & 16) == 16) {
            int i12 = protoBuf$Function.h;
            this.d = 16 | this.d;
            this.i = i12;
        }
        if (!protoBuf$Function.i.isEmpty()) {
            if (this.f208j.isEmpty()) {
                this.f208j = protoBuf$Function.i;
                this.d &= -33;
            } else {
                if ((this.d & 32) != 32) {
                    this.f208j = new ArrayList(this.f208j);
                    this.d |= 32;
                }
                this.f208j.addAll(protoBuf$Function.i);
            }
        }
        if ((protoBuf$Function.c & 32) == 32) {
            ProtoBuf$Type protoBuf$Type4 = protoBuf$Function.f5048j;
            if ((this.d & 64) != 64 || (protoBuf$Type = this.k) == ProtoBuf$Type.f5067t) {
                this.k = protoBuf$Type4;
            } else {
                m mVarO2 = ProtoBuf$Type.o(protoBuf$Type);
                mVarO2.h(protoBuf$Type4);
                this.k = mVarO2.e();
            }
            this.d |= 64;
        }
        if ((protoBuf$Function.c & 64) == 64) {
            int i13 = protoBuf$Function.k;
            this.d |= 128;
            this.l = i13;
        }
        if (!protoBuf$Function.l.isEmpty()) {
            if (this.m.isEmpty()) {
                this.m = protoBuf$Function.l;
                this.d &= -257;
            } else {
                if ((this.d & 256) != 256) {
                    this.m = new ArrayList(this.m);
                    this.d |= 256;
                }
                this.m.addAll(protoBuf$Function.l);
            }
        }
        if (!protoBuf$Function.m.isEmpty()) {
            if (this.n.isEmpty()) {
                this.n = protoBuf$Function.m;
                this.d &= -513;
            } else {
                if ((this.d & 512) != 512) {
                    this.n = new ArrayList(this.n);
                    this.d |= 512;
                }
                this.n.addAll(protoBuf$Function.m);
            }
        }
        if (!protoBuf$Function.o.isEmpty()) {
            if (this.o.isEmpty()) {
                this.o = protoBuf$Function.o;
                this.d &= -1025;
            } else {
                if ((this.d & 1024) != 1024) {
                    this.o = new ArrayList(this.o);
                    this.d |= 1024;
                }
                this.o.addAll(protoBuf$Function.o);
            }
        }
        if ((protoBuf$Function.c & 128) == 128) {
            ProtoBuf$TypeTable protoBuf$TypeTable2 = protoBuf$Function.p;
            if ((this.d & 2048) != 2048 || (protoBuf$TypeTable = this.p) == ProtoBuf$TypeTable.g) {
                this.p = protoBuf$TypeTable2;
            } else {
                k kVarG = ProtoBuf$TypeTable.g(protoBuf$TypeTable);
                kVarG.f(protoBuf$TypeTable2);
                this.p = kVarG.d();
            }
            this.d |= 2048;
        }
        if (!protoBuf$Function.f5049q.isEmpty()) {
            if (this.f209q.isEmpty()) {
                this.f209q = protoBuf$Function.f5049q;
                this.d &= -4097;
            } else {
                if ((this.d & 4096) != 4096) {
                    this.f209q = new ArrayList(this.f209q);
                    this.d |= 4096;
                }
                this.f209q.addAll(protoBuf$Function.f5049q);
            }
        }
        if ((protoBuf$Function.c & 256) == 256) {
            ProtoBuf$Contract protoBuf$Contract2 = protoBuf$Function.f5050r;
            if ((this.d & 8192) != 8192 || (protoBuf$Contract = this.f210r) == ProtoBuf$Contract.e) {
                this.f210r = protoBuf$Contract2;
            } else {
                d dVar = new d(0);
                dVar.d = Collections.EMPTY_LIST;
                dVar.h(protoBuf$Contract);
                dVar.h(protoBuf$Contract2);
                this.f210r = dVar.d();
            }
            this.d |= 8192;
        }
        d(protoBuf$Function);
        this.f774a = this.f774a.c(protoBuf$Function.b);
    }
}
