package B8;

import H8.AbstractC0241b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.m;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class j extends kotlin.reflect.jvm.internal.impl.protobuf.a {
    public int d;
    public int e;
    public int f;
    public List g;
    public ProtoBuf$Type h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public ProtoBuf$Type f214j;
    public int k;
    public List l;
    public List m;

    public static j f() {
        j jVar = new j();
        jVar.e = 6;
        List list = Collections.EMPTY_LIST;
        jVar.g = list;
        ProtoBuf$Type protoBuf$Type = ProtoBuf$Type.f5067t;
        jVar.h = protoBuf$Type;
        jVar.f214j = protoBuf$Type;
        jVar.l = list;
        jVar.m = list;
        return jVar;
    }

    @Override // H8.j
    public final AbstractC0241b a() {
        ProtoBuf$TypeAlias protoBuf$TypeAliasE = e();
        if (protoBuf$TypeAliasE.isInitialized()) {
            return protoBuf$TypeAliasE;
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
            B8.a r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias.p     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias r1 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r2.h(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: B8.j.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        h((ProtoBuf$TypeAlias) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        j jVarF = f();
        jVarF.h(e());
        return jVarF;
    }

    public final ProtoBuf$TypeAlias e() {
        ProtoBuf$TypeAlias protoBuf$TypeAlias = new ProtoBuf$TypeAlias(this);
        int i = this.d;
        int i6 = (i & 1) != 1 ? 0 : 1;
        protoBuf$TypeAlias.d = this.e;
        if ((i & 2) == 2) {
            i6 |= 2;
        }
        protoBuf$TypeAlias.e = this.f;
        if ((i & 4) == 4) {
            this.g = Collections.unmodifiableList(this.g);
            this.d &= -5;
        }
        protoBuf$TypeAlias.f = this.g;
        if ((i & 8) == 8) {
            i6 |= 4;
        }
        protoBuf$TypeAlias.g = this.h;
        if ((i & 16) == 16) {
            i6 |= 8;
        }
        protoBuf$TypeAlias.h = this.i;
        if ((i & 32) == 32) {
            i6 |= 16;
        }
        protoBuf$TypeAlias.i = this.f214j;
        if ((i & 64) == 64) {
            i6 |= 32;
        }
        protoBuf$TypeAlias.f5074j = this.k;
        if ((this.d & 128) == 128) {
            this.l = Collections.unmodifiableList(this.l);
            this.d &= -129;
        }
        protoBuf$TypeAlias.k = this.l;
        if ((this.d & 256) == 256) {
            this.m = Collections.unmodifiableList(this.m);
            this.d &= -257;
        }
        protoBuf$TypeAlias.l = this.m;
        protoBuf$TypeAlias.c = i6;
        return protoBuf$TypeAlias;
    }

    public final void h(ProtoBuf$TypeAlias protoBuf$TypeAlias) {
        ProtoBuf$Type protoBuf$Type;
        ProtoBuf$Type protoBuf$Type2;
        if (protoBuf$TypeAlias == ProtoBuf$TypeAlias.o) {
            return;
        }
        int i = protoBuf$TypeAlias.c;
        if ((i & 1) == 1) {
            int i6 = protoBuf$TypeAlias.d;
            this.d = 1 | this.d;
            this.e = i6;
        }
        if ((i & 2) == 2) {
            int i10 = protoBuf$TypeAlias.e;
            this.d = 2 | this.d;
            this.f = i10;
        }
        if (!protoBuf$TypeAlias.f.isEmpty()) {
            if (this.g.isEmpty()) {
                this.g = protoBuf$TypeAlias.f;
                this.d &= -5;
            } else {
                if ((this.d & 4) != 4) {
                    this.g = new ArrayList(this.g);
                    this.d |= 4;
                }
                this.g.addAll(protoBuf$TypeAlias.f);
            }
        }
        if ((protoBuf$TypeAlias.c & 4) == 4) {
            ProtoBuf$Type protoBuf$Type3 = protoBuf$TypeAlias.g;
            if ((this.d & 8) != 8 || (protoBuf$Type2 = this.h) == ProtoBuf$Type.f5067t) {
                this.h = protoBuf$Type3;
            } else {
                m mVarO = ProtoBuf$Type.o(protoBuf$Type2);
                mVarO.h(protoBuf$Type3);
                this.h = mVarO.e();
            }
            this.d |= 8;
        }
        int i11 = protoBuf$TypeAlias.c;
        if ((i11 & 8) == 8) {
            int i12 = protoBuf$TypeAlias.h;
            this.d |= 16;
            this.i = i12;
        }
        if ((i11 & 16) == 16) {
            ProtoBuf$Type protoBuf$Type4 = protoBuf$TypeAlias.i;
            if ((this.d & 32) != 32 || (protoBuf$Type = this.f214j) == ProtoBuf$Type.f5067t) {
                this.f214j = protoBuf$Type4;
            } else {
                m mVarO2 = ProtoBuf$Type.o(protoBuf$Type);
                mVarO2.h(protoBuf$Type4);
                this.f214j = mVarO2.e();
            }
            this.d |= 32;
        }
        if ((protoBuf$TypeAlias.c & 32) == 32) {
            int i13 = protoBuf$TypeAlias.f5074j;
            this.d |= 64;
            this.k = i13;
        }
        if (!protoBuf$TypeAlias.k.isEmpty()) {
            if (this.l.isEmpty()) {
                this.l = protoBuf$TypeAlias.k;
                this.d &= -129;
            } else {
                if ((this.d & 128) != 128) {
                    this.l = new ArrayList(this.l);
                    this.d |= 128;
                }
                this.l.addAll(protoBuf$TypeAlias.k);
            }
        }
        if (!protoBuf$TypeAlias.l.isEmpty()) {
            if (this.m.isEmpty()) {
                this.m = protoBuf$TypeAlias.l;
                this.d &= -257;
            } else {
                if ((this.d & 256) != 256) {
                    this.m = new ArrayList(this.m);
                    this.d |= 256;
                }
                this.m.addAll(protoBuf$TypeAlias.l);
            }
        }
        d(protoBuf$TypeAlias);
        this.f774a = this.f774a.c(protoBuf$TypeAlias.b);
    }
}
