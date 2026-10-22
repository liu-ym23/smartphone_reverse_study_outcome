package B8;

import H8.AbstractC0241b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.m;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class i extends kotlin.reflect.jvm.internal.impl.protobuf.a {
    public int d;
    public int e;
    public int f;
    public int g;
    public ProtoBuf$Type h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public List f211j;
    public ProtoBuf$Type k;
    public int l;
    public List m;
    public List n;
    public ProtoBuf$ValueParameter o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public int f212q;

    /* renamed from: r, reason: collision with root package name */
    public List f213r;

    public static i f() {
        i iVar = new i();
        iVar.e = 518;
        iVar.f = 2054;
        ProtoBuf$Type protoBuf$Type = ProtoBuf$Type.f5067t;
        iVar.h = protoBuf$Type;
        List list = Collections.EMPTY_LIST;
        iVar.f211j = list;
        iVar.k = protoBuf$Type;
        iVar.m = list;
        iVar.n = list;
        iVar.o = ProtoBuf$ValueParameter.l;
        iVar.f213r = list;
        return iVar;
    }

    @Override // H8.j
    public final AbstractC0241b a() {
        ProtoBuf$Property protoBuf$PropertyE = e();
        if (protoBuf$PropertyE.isInitialized()) {
            return protoBuf$PropertyE;
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
            B8.a r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property.f5057v     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r1 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r2.h(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: B8.i.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        h((ProtoBuf$Property) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        i iVarF = f();
        iVarF.h(e());
        return iVarF;
    }

    public final ProtoBuf$Property e() {
        ProtoBuf$Property protoBuf$Property = new ProtoBuf$Property(this);
        int i = this.d;
        int i6 = (i & 1) != 1 ? 0 : 1;
        protoBuf$Property.d = this.e;
        if ((i & 2) == 2) {
            i6 |= 2;
        }
        protoBuf$Property.e = this.f;
        if ((i & 4) == 4) {
            i6 |= 4;
        }
        protoBuf$Property.f = this.g;
        if ((i & 8) == 8) {
            i6 |= 8;
        }
        protoBuf$Property.g = this.h;
        if ((i & 16) == 16) {
            i6 |= 16;
        }
        protoBuf$Property.h = this.i;
        if ((i & 32) == 32) {
            this.f211j = Collections.unmodifiableList(this.f211j);
            this.d &= -33;
        }
        protoBuf$Property.i = this.f211j;
        if ((i & 64) == 64) {
            i6 |= 32;
        }
        protoBuf$Property.f5058j = this.k;
        if ((i & 128) == 128) {
            i6 |= 64;
        }
        protoBuf$Property.k = this.l;
        if ((this.d & 256) == 256) {
            this.m = Collections.unmodifiableList(this.m);
            this.d &= -257;
        }
        protoBuf$Property.l = this.m;
        if ((this.d & 512) == 512) {
            this.n = Collections.unmodifiableList(this.n);
            this.d &= -513;
        }
        protoBuf$Property.m = this.n;
        if ((i & 1024) == 1024) {
            i6 |= 128;
        }
        protoBuf$Property.o = this.o;
        if ((i & 2048) == 2048) {
            i6 |= 256;
        }
        protoBuf$Property.p = this.p;
        if ((i & 4096) == 4096) {
            i6 |= 512;
        }
        protoBuf$Property.f5059q = this.f212q;
        if ((this.d & 8192) == 8192) {
            this.f213r = Collections.unmodifiableList(this.f213r);
            this.d &= -8193;
        }
        protoBuf$Property.f5060r = this.f213r;
        protoBuf$Property.c = i6;
        return protoBuf$Property;
    }

    public final void h(ProtoBuf$Property protoBuf$Property) {
        ProtoBuf$ValueParameter protoBuf$ValueParameter;
        ProtoBuf$Type protoBuf$Type;
        ProtoBuf$Type protoBuf$Type2;
        if (protoBuf$Property == ProtoBuf$Property.u) {
            return;
        }
        int i = protoBuf$Property.c;
        if ((i & 1) == 1) {
            int i6 = protoBuf$Property.d;
            this.d = 1 | this.d;
            this.e = i6;
        }
        if ((i & 2) == 2) {
            int i10 = protoBuf$Property.e;
            this.d = 2 | this.d;
            this.f = i10;
        }
        if ((i & 4) == 4) {
            int i11 = protoBuf$Property.f;
            this.d = 4 | this.d;
            this.g = i11;
        }
        if ((i & 8) == 8) {
            ProtoBuf$Type protoBuf$Type3 = protoBuf$Property.g;
            if ((this.d & 8) != 8 || (protoBuf$Type2 = this.h) == ProtoBuf$Type.f5067t) {
                this.h = protoBuf$Type3;
            } else {
                m mVarO = ProtoBuf$Type.o(protoBuf$Type2);
                mVarO.h(protoBuf$Type3);
                this.h = mVarO.e();
            }
            this.d |= 8;
        }
        if ((protoBuf$Property.c & 16) == 16) {
            int i12 = protoBuf$Property.h;
            this.d = 16 | this.d;
            this.i = i12;
        }
        if (!protoBuf$Property.i.isEmpty()) {
            if (this.f211j.isEmpty()) {
                this.f211j = protoBuf$Property.i;
                this.d &= -33;
            } else {
                if ((this.d & 32) != 32) {
                    this.f211j = new ArrayList(this.f211j);
                    this.d |= 32;
                }
                this.f211j.addAll(protoBuf$Property.i);
            }
        }
        if ((protoBuf$Property.c & 32) == 32) {
            ProtoBuf$Type protoBuf$Type4 = protoBuf$Property.f5058j;
            if ((this.d & 64) != 64 || (protoBuf$Type = this.k) == ProtoBuf$Type.f5067t) {
                this.k = protoBuf$Type4;
            } else {
                m mVarO2 = ProtoBuf$Type.o(protoBuf$Type);
                mVarO2.h(protoBuf$Type4);
                this.k = mVarO2.e();
            }
            this.d |= 64;
        }
        if ((protoBuf$Property.c & 64) == 64) {
            int i13 = protoBuf$Property.k;
            this.d |= 128;
            this.l = i13;
        }
        if (!protoBuf$Property.l.isEmpty()) {
            if (this.m.isEmpty()) {
                this.m = protoBuf$Property.l;
                this.d &= -257;
            } else {
                if ((this.d & 256) != 256) {
                    this.m = new ArrayList(this.m);
                    this.d |= 256;
                }
                this.m.addAll(protoBuf$Property.l);
            }
        }
        if (!protoBuf$Property.m.isEmpty()) {
            if (this.n.isEmpty()) {
                this.n = protoBuf$Property.m;
                this.d &= -513;
            } else {
                if ((this.d & 512) != 512) {
                    this.n = new ArrayList(this.n);
                    this.d |= 512;
                }
                this.n.addAll(protoBuf$Property.m);
            }
        }
        if ((protoBuf$Property.c & 128) == 128) {
            ProtoBuf$ValueParameter protoBuf$ValueParameter2 = protoBuf$Property.o;
            if ((this.d & 1024) != 1024 || (protoBuf$ValueParameter = this.o) == ProtoBuf$ValueParameter.l) {
                this.o = protoBuf$ValueParameter2;
            } else {
                l lVar = new l();
                ProtoBuf$Type protoBuf$Type5 = ProtoBuf$Type.f5067t;
                lVar.g = protoBuf$Type5;
                lVar.i = protoBuf$Type5;
                lVar.f(protoBuf$ValueParameter);
                lVar.f(protoBuf$ValueParameter2);
                this.o = lVar.e();
            }
            this.d |= 1024;
        }
        int i14 = protoBuf$Property.c;
        if ((i14 & 256) == 256) {
            int i15 = protoBuf$Property.p;
            this.d |= 2048;
            this.p = i15;
        }
        if ((i14 & 512) == 512) {
            int i16 = protoBuf$Property.f5059q;
            this.d |= 4096;
            this.f212q = i16;
        }
        if (!protoBuf$Property.f5060r.isEmpty()) {
            if (this.f213r.isEmpty()) {
                this.f213r = protoBuf$Property.f5060r;
                this.d &= -8193;
            } else {
                if ((this.d & 8192) != 8192) {
                    this.f213r = new ArrayList(this.f213r);
                    this.d |= 8192;
                }
                this.f213r.addAll(protoBuf$Property.f5060r);
            }
        }
        d(protoBuf$Property);
        this.f774a = this.f774a.c(protoBuf$Property.b);
    }
}
