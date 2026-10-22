package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0241b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class m extends kotlin.reflect.jvm.internal.impl.protobuf.a {
    public int d;
    public List e;
    public boolean f;
    public int g;
    public ProtoBuf$Type h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f5094j;
    public int k;
    public int l;
    public int m;
    public ProtoBuf$Type n;
    public int o;
    public ProtoBuf$Type p;

    /* renamed from: q, reason: collision with root package name */
    public int f5095q;

    /* renamed from: r, reason: collision with root package name */
    public int f5096r;

    public static m f() {
        m mVar = new m();
        mVar.e = Collections.EMPTY_LIST;
        ProtoBuf$Type protoBuf$Type = ProtoBuf$Type.f5067t;
        mVar.h = protoBuf$Type;
        mVar.n = protoBuf$Type;
        mVar.p = protoBuf$Type;
        return mVar;
    }

    @Override // H8.j
    public final AbstractC0241b a() {
        ProtoBuf$Type protoBuf$TypeE = e();
        if (protoBuf$TypeE.isInitialized()) {
            return protoBuf$TypeE;
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
            B8.a r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.u     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r1 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r2.h(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.m.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        h((ProtoBuf$Type) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        m mVarF = f();
        mVarF.h(e());
        return mVarF;
    }

    public final ProtoBuf$Type e() {
        ProtoBuf$Type protoBuf$Type = new ProtoBuf$Type(this);
        int i = this.d;
        if ((i & 1) == 1) {
            this.e = Collections.unmodifiableList(this.e);
            this.d &= -2;
        }
        protoBuf$Type.d = this.e;
        int i6 = (i & 2) != 2 ? 0 : 1;
        protoBuf$Type.e = this.f;
        if ((i & 4) == 4) {
            i6 |= 2;
        }
        protoBuf$Type.f = this.g;
        if ((i & 8) == 8) {
            i6 |= 4;
        }
        protoBuf$Type.g = this.h;
        if ((i & 16) == 16) {
            i6 |= 8;
        }
        protoBuf$Type.h = this.i;
        if ((i & 32) == 32) {
            i6 |= 16;
        }
        protoBuf$Type.i = this.f5094j;
        if ((i & 64) == 64) {
            i6 |= 32;
        }
        protoBuf$Type.f5068j = this.k;
        if ((i & 128) == 128) {
            i6 |= 64;
        }
        protoBuf$Type.k = this.l;
        if ((i & 256) == 256) {
            i6 |= 128;
        }
        protoBuf$Type.l = this.m;
        if ((i & 512) == 512) {
            i6 |= 256;
        }
        protoBuf$Type.m = this.n;
        if ((i & 1024) == 1024) {
            i6 |= 512;
        }
        protoBuf$Type.n = this.o;
        if ((i & 2048) == 2048) {
            i6 |= 1024;
        }
        protoBuf$Type.o = this.p;
        if ((i & 4096) == 4096) {
            i6 |= 2048;
        }
        protoBuf$Type.p = this.f5095q;
        if ((i & 8192) == 8192) {
            i6 |= 4096;
        }
        protoBuf$Type.f5069q = this.f5096r;
        protoBuf$Type.c = i6;
        return protoBuf$Type;
    }

    public final m h(ProtoBuf$Type protoBuf$Type) {
        ProtoBuf$Type protoBuf$Type2;
        ProtoBuf$Type protoBuf$Type3;
        ProtoBuf$Type protoBuf$Type4;
        ProtoBuf$Type protoBuf$Type5 = ProtoBuf$Type.f5067t;
        if (protoBuf$Type == protoBuf$Type5) {
            return this;
        }
        if (!protoBuf$Type.d.isEmpty()) {
            if (this.e.isEmpty()) {
                this.e = protoBuf$Type.d;
                this.d &= -2;
            } else {
                if ((this.d & 1) != 1) {
                    this.e = new ArrayList(this.e);
                    this.d |= 1;
                }
                this.e.addAll(protoBuf$Type.d);
            }
        }
        int i = protoBuf$Type.c;
        if ((i & 1) == 1) {
            boolean z10 = protoBuf$Type.e;
            this.d |= 2;
            this.f = z10;
        }
        if ((i & 2) == 2) {
            int i6 = protoBuf$Type.f;
            this.d |= 4;
            this.g = i6;
        }
        if ((i & 4) == 4) {
            ProtoBuf$Type protoBuf$Type6 = protoBuf$Type.g;
            if ((this.d & 8) != 8 || (protoBuf$Type4 = this.h) == protoBuf$Type5) {
                this.h = protoBuf$Type6;
            } else {
                m mVarO = ProtoBuf$Type.o(protoBuf$Type4);
                mVarO.h(protoBuf$Type6);
                this.h = mVarO.e();
            }
            this.d |= 8;
        }
        int i10 = protoBuf$Type.c;
        if ((i10 & 8) == 8) {
            int i11 = protoBuf$Type.h;
            this.d |= 16;
            this.i = i11;
        }
        if ((i10 & 16) == 16) {
            int i12 = protoBuf$Type.i;
            this.d |= 32;
            this.f5094j = i12;
        }
        if ((i10 & 32) == 32) {
            int i13 = protoBuf$Type.f5068j;
            this.d |= 64;
            this.k = i13;
        }
        if ((i10 & 64) == 64) {
            int i14 = protoBuf$Type.k;
            this.d |= 128;
            this.l = i14;
        }
        if ((i10 & 128) == 128) {
            int i15 = protoBuf$Type.l;
            this.d |= 256;
            this.m = i15;
        }
        if ((i10 & 256) == 256) {
            ProtoBuf$Type protoBuf$Type7 = protoBuf$Type.m;
            if ((this.d & 512) != 512 || (protoBuf$Type3 = this.n) == protoBuf$Type5) {
                this.n = protoBuf$Type7;
            } else {
                m mVarO2 = ProtoBuf$Type.o(protoBuf$Type3);
                mVarO2.h(protoBuf$Type7);
                this.n = mVarO2.e();
            }
            this.d |= 512;
        }
        int i16 = protoBuf$Type.c;
        if ((i16 & 512) == 512) {
            int i17 = protoBuf$Type.n;
            this.d |= 1024;
            this.o = i17;
        }
        if ((i16 & 1024) == 1024) {
            ProtoBuf$Type protoBuf$Type8 = protoBuf$Type.o;
            if ((this.d & 2048) != 2048 || (protoBuf$Type2 = this.p) == protoBuf$Type5) {
                this.p = protoBuf$Type8;
            } else {
                m mVarO3 = ProtoBuf$Type.o(protoBuf$Type2);
                mVarO3.h(protoBuf$Type8);
                this.p = mVarO3.e();
            }
            this.d |= 2048;
        }
        int i18 = protoBuf$Type.c;
        if ((i18 & 2048) == 2048) {
            int i19 = protoBuf$Type.p;
            this.d |= 4096;
            this.f5095q = i19;
        }
        if ((i18 & 4096) == 4096) {
            int i20 = protoBuf$Type.f5069q;
            this.d |= 8192;
            this.f5096r = i20;
        }
        d(protoBuf$Type);
        this.f774a = this.f774a.c(protoBuf$Type.b);
        return this;
    }
}
