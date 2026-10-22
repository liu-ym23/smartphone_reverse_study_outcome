package B8;

import H8.AbstractC0241b;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.m;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class l extends kotlin.reflect.jvm.internal.impl.protobuf.a {
    public int d;
    public int e;
    public int f;
    public ProtoBuf$Type g;
    public int h;
    public ProtoBuf$Type i;

    /* renamed from: j, reason: collision with root package name */
    public int f215j;

    @Override // H8.j
    public final AbstractC0241b a() {
        ProtoBuf$ValueParameter protoBuf$ValueParameterE = e();
        if (protoBuf$ValueParameterE.isInitialized()) {
            return protoBuf$ValueParameterE;
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
            B8.a r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter.m     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r1 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r2.f(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter) r4     // Catch: java.lang.Throwable -> Lf
            throw r3     // Catch: java.lang.Throwable -> L17
        L17:
            r3 = move-exception
            r0 = r4
        L19:
            if (r0 == 0) goto L1e
            r2.f(r0)
        L1e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: B8.l.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        f((ProtoBuf$ValueParameter) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        l lVar = new l();
        ProtoBuf$Type protoBuf$Type = ProtoBuf$Type.f5067t;
        lVar.g = protoBuf$Type;
        lVar.i = protoBuf$Type;
        lVar.f(e());
        return lVar;
    }

    public final ProtoBuf$ValueParameter e() {
        ProtoBuf$ValueParameter protoBuf$ValueParameter = new ProtoBuf$ValueParameter(this);
        int i = this.d;
        int i6 = (i & 1) != 1 ? 0 : 1;
        protoBuf$ValueParameter.d = this.e;
        if ((i & 2) == 2) {
            i6 |= 2;
        }
        protoBuf$ValueParameter.e = this.f;
        if ((i & 4) == 4) {
            i6 |= 4;
        }
        protoBuf$ValueParameter.f = this.g;
        if ((i & 8) == 8) {
            i6 |= 8;
        }
        protoBuf$ValueParameter.g = this.h;
        if ((i & 16) == 16) {
            i6 |= 16;
        }
        protoBuf$ValueParameter.h = this.i;
        if ((i & 32) == 32) {
            i6 |= 32;
        }
        protoBuf$ValueParameter.i = this.f215j;
        protoBuf$ValueParameter.c = i6;
        return protoBuf$ValueParameter;
    }

    public final void f(ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        ProtoBuf$Type protoBuf$Type;
        ProtoBuf$Type protoBuf$Type2;
        if (protoBuf$ValueParameter == ProtoBuf$ValueParameter.l) {
            return;
        }
        int i = protoBuf$ValueParameter.c;
        if ((i & 1) == 1) {
            int i6 = protoBuf$ValueParameter.d;
            this.d = 1 | this.d;
            this.e = i6;
        }
        if ((i & 2) == 2) {
            int i10 = protoBuf$ValueParameter.e;
            this.d = 2 | this.d;
            this.f = i10;
        }
        if ((i & 4) == 4) {
            ProtoBuf$Type protoBuf$Type3 = protoBuf$ValueParameter.f;
            if ((this.d & 4) != 4 || (protoBuf$Type2 = this.g) == ProtoBuf$Type.f5067t) {
                this.g = protoBuf$Type3;
            } else {
                m mVarO = ProtoBuf$Type.o(protoBuf$Type2);
                mVarO.h(protoBuf$Type3);
                this.g = mVarO.e();
            }
            this.d |= 4;
        }
        int i11 = protoBuf$ValueParameter.c;
        if ((i11 & 8) == 8) {
            int i12 = protoBuf$ValueParameter.g;
            this.d = 8 | this.d;
            this.h = i12;
        }
        if ((i11 & 16) == 16) {
            ProtoBuf$Type protoBuf$Type4 = protoBuf$ValueParameter.h;
            if ((this.d & 16) != 16 || (protoBuf$Type = this.i) == ProtoBuf$Type.f5067t) {
                this.i = protoBuf$Type4;
            } else {
                m mVarO2 = ProtoBuf$Type.o(protoBuf$Type);
                mVarO2.h(protoBuf$Type4);
                this.i = mVarO2.e();
            }
            this.d |= 16;
        }
        if ((protoBuf$ValueParameter.c & 32) == 32) {
            int i13 = protoBuf$ValueParameter.i;
            this.d = 32 | this.d;
            this.f215j = i13;
        }
        d(protoBuf$ValueParameter);
        this.f774a = this.f774a.c(protoBuf$ValueParameter.b);
    }
}
