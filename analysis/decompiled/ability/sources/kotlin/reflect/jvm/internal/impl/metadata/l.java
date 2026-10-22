package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0241b;
import H8.s;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class l extends H8.j implements s {
    public int b;
    public ProtoBuf$Type.Argument.Projection c;
    public ProtoBuf$Type d;
    public int e;

    public static l e() {
        l lVar = new l();
        lVar.c = ProtoBuf$Type.Argument.Projection.INV;
        lVar.d = ProtoBuf$Type.f5067t;
        return lVar;
    }

    @Override // H8.j
    public final AbstractC0241b a() {
        ProtoBuf$Type.Argument argumentD = d();
        if (argumentD.isInitialized()) {
            return argumentD;
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
            kotlin.reflect.jvm.internal.impl.metadata.k r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.Argument.i     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument r1 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r2.f(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.Argument) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.l.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        f((ProtoBuf$Type.Argument) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        l lVarE = e();
        lVarE.f(d());
        return lVarE;
    }

    public final ProtoBuf$Type.Argument d() {
        ProtoBuf$Type.Argument argument = new ProtoBuf$Type.Argument(this);
        int i = this.b;
        int i6 = (i & 1) != 1 ? 0 : 1;
        argument.c = this.c;
        if ((i & 2) == 2) {
            i6 |= 2;
        }
        argument.d = this.d;
        if ((i & 4) == 4) {
            i6 |= 4;
        }
        argument.e = this.e;
        argument.b = i6;
        return argument;
    }

    public final void f(ProtoBuf$Type.Argument argument) {
        ProtoBuf$Type protoBuf$Type;
        if (argument == ProtoBuf$Type.Argument.h) {
            return;
        }
        if ((argument.b & 1) == 1) {
            ProtoBuf$Type.Argument.Projection projection = argument.c;
            projection.getClass();
            this.b = 1 | this.b;
            this.c = projection;
        }
        if ((argument.b & 2) == 2) {
            ProtoBuf$Type protoBuf$Type2 = argument.d;
            if ((this.b & 2) != 2 || (protoBuf$Type = this.d) == ProtoBuf$Type.f5067t) {
                this.d = protoBuf$Type2;
            } else {
                m mVarO = ProtoBuf$Type.o(protoBuf$Type);
                mVarO.h(protoBuf$Type2);
                this.d = mVarO.e();
            }
            this.b |= 2;
        }
        if ((argument.b & 4) == 4) {
            int i = argument.e;
            this.b = 4 | this.b;
            this.e = i;
        }
        this.f774a = this.f774a.c(argument.f5072a);
    }
}
