package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0241b;
import H8.s;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class o extends H8.j implements s {
    public int b;
    public int c;
    public int d;
    public ProtoBuf$VersionRequirement.Level e;
    public int f;
    public int g;
    public ProtoBuf$VersionRequirement.VersionKind h;

    public static o e() {
        o oVar = new o();
        oVar.e = ProtoBuf$VersionRequirement.Level.ERROR;
        oVar.h = ProtoBuf$VersionRequirement.VersionKind.LANGUAGE_VERSION;
        return oVar;
    }

    @Override // H8.j
    public final AbstractC0241b a() {
        ProtoBuf$VersionRequirement protoBuf$VersionRequirementD = d();
        if (protoBuf$VersionRequirementD.isInitialized()) {
            return protoBuf$VersionRequirementD;
        }
        throw new UninitializedMessageException();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    @Override // H8.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final H8.j b(H8.C0245f r2, H8.h r3) throws java.lang.Throwable {
        /*
            r1 = this;
            r3 = 0
            B8.a r0 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement.l     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r0.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement r0 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r0.<init>(r2)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.f(r0)
            return r1
        Lf:
            r2 = move-exception
            goto L19
        L11:
            r2 = move-exception
            H8.b r0 = r2.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement r0 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement) r0     // Catch: java.lang.Throwable -> Lf
            throw r2     // Catch: java.lang.Throwable -> L17
        L17:
            r2 = move-exception
            r3 = r0
        L19:
            if (r3 == 0) goto L1e
            r1.f(r3)
        L1e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.o.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        f((ProtoBuf$VersionRequirement) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        o oVarE = e();
        oVarE.f(d());
        return oVarE;
    }

    public final ProtoBuf$VersionRequirement d() {
        ProtoBuf$VersionRequirement protoBuf$VersionRequirement = new ProtoBuf$VersionRequirement(this);
        int i = this.b;
        int i6 = (i & 1) != 1 ? 0 : 1;
        protoBuf$VersionRequirement.c = this.c;
        if ((i & 2) == 2) {
            i6 |= 2;
        }
        protoBuf$VersionRequirement.d = this.d;
        if ((i & 4) == 4) {
            i6 |= 4;
        }
        protoBuf$VersionRequirement.e = this.e;
        if ((i & 8) == 8) {
            i6 |= 8;
        }
        protoBuf$VersionRequirement.f = this.f;
        if ((i & 16) == 16) {
            i6 |= 16;
        }
        protoBuf$VersionRequirement.g = this.g;
        if ((i & 32) == 32) {
            i6 |= 32;
        }
        protoBuf$VersionRequirement.h = this.h;
        protoBuf$VersionRequirement.b = i6;
        return protoBuf$VersionRequirement;
    }

    public final void f(ProtoBuf$VersionRequirement protoBuf$VersionRequirement) {
        if (protoBuf$VersionRequirement == ProtoBuf$VersionRequirement.k) {
            return;
        }
        int i = protoBuf$VersionRequirement.b;
        if ((i & 1) == 1) {
            int i6 = protoBuf$VersionRequirement.c;
            this.b = 1 | this.b;
            this.c = i6;
        }
        if ((i & 2) == 2) {
            int i10 = protoBuf$VersionRequirement.d;
            this.b = 2 | this.b;
            this.d = i10;
        }
        if ((i & 4) == 4) {
            ProtoBuf$VersionRequirement.Level level = protoBuf$VersionRequirement.e;
            level.getClass();
            this.b = 4 | this.b;
            this.e = level;
        }
        int i11 = protoBuf$VersionRequirement.b;
        if ((i11 & 8) == 8) {
            int i12 = protoBuf$VersionRequirement.f;
            this.b = 8 | this.b;
            this.f = i12;
        }
        if ((i11 & 16) == 16) {
            int i13 = protoBuf$VersionRequirement.g;
            this.b = 16 | this.b;
            this.g = i13;
        }
        if ((i11 & 32) == 32) {
            ProtoBuf$VersionRequirement.VersionKind versionKind = protoBuf$VersionRequirement.h;
            versionKind.getClass();
            this.b = 32 | this.b;
            this.h = versionKind;
        }
        this.f774a = this.f774a.c(protoBuf$VersionRequirement.f5079a);
    }
}
