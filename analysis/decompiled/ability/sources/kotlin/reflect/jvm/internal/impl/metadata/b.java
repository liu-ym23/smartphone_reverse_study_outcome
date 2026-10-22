package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0241b;
import H8.s;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class b extends H8.j implements s {
    public int b;
    public int c;
    public ProtoBuf$Annotation.Argument.Value d;

    @Override // H8.j
    public final AbstractC0241b a() {
        ProtoBuf$Annotation.Argument argumentD = d();
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
            kotlin.reflect.jvm.internal.impl.metadata.a r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation.Argument.h     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument r1 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r2.e(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation.Argument) r4     // Catch: java.lang.Throwable -> Lf
            throw r3     // Catch: java.lang.Throwable -> L17
        L17:
            r3 = move-exception
            r0 = r4
        L19:
            if (r0 == 0) goto L1e
            r2.e(r0)
        L1e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.b.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        e((ProtoBuf$Annotation.Argument) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        b bVar = new b();
        bVar.d = ProtoBuf$Annotation.Argument.Value.p;
        bVar.e(d());
        return bVar;
    }

    public final ProtoBuf$Annotation.Argument d() {
        ProtoBuf$Annotation.Argument argument = new ProtoBuf$Annotation.Argument(this);
        int i = this.b;
        int i6 = (i & 1) != 1 ? 0 : 1;
        argument.c = this.c;
        if ((i & 2) == 2) {
            i6 |= 2;
        }
        argument.d = this.d;
        argument.b = i6;
        return argument;
    }

    public final void e(ProtoBuf$Annotation.Argument argument) {
        ProtoBuf$Annotation.Argument.Value value;
        if (argument == ProtoBuf$Annotation.Argument.g) {
            return;
        }
        int i = argument.b;
        if ((i & 1) == 1) {
            int i6 = argument.c;
            this.b = 1 | this.b;
            this.c = i6;
        }
        if ((i & 2) == 2) {
            ProtoBuf$Annotation.Argument.Value value2 = argument.d;
            if ((this.b & 2) != 2 || (value = this.d) == ProtoBuf$Annotation.Argument.Value.p) {
                this.d = value2;
            } else {
                d dVarE = d.e();
                dVarE.f(value);
                dVarE.f(value2);
                this.d = dVarE.d();
            }
            this.b |= 2;
        }
        this.f774a = this.f774a.c(argument.f5012a);
    }
}
