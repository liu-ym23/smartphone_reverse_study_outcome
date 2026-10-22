package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0241b;
import H8.s;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class j extends H8.j implements s {
    public int b;
    public int c;
    public int d;
    public ProtoBuf$QualifiedNameTable.QualifiedName.Kind e;

    public static j e() {
        j jVar = new j();
        jVar.c = -1;
        jVar.e = ProtoBuf$QualifiedNameTable.QualifiedName.Kind.PACKAGE;
        return jVar;
    }

    @Override // H8.j
    public final AbstractC0241b a() {
        ProtoBuf$QualifiedNameTable.QualifiedName qualifiedNameD = d();
        if (qualifiedNameD.isInitialized()) {
            return qualifiedNameD;
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
            kotlin.reflect.jvm.internal.impl.metadata.i r0 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable.QualifiedName.i     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r0.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedName r0 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedName     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r0.<init>(r2)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.f(r0)
            return r1
        Lf:
            r2 = move-exception
            goto L19
        L11:
            r2 = move-exception
            H8.b r0 = r2.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedName r0 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable.QualifiedName) r0     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.j.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        f((ProtoBuf$QualifiedNameTable.QualifiedName) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        j jVarE = e();
        jVarE.f(d());
        return jVarE;
    }

    public final ProtoBuf$QualifiedNameTable.QualifiedName d() {
        ProtoBuf$QualifiedNameTable.QualifiedName qualifiedName = new ProtoBuf$QualifiedNameTable.QualifiedName(this);
        int i = this.b;
        int i6 = (i & 1) != 1 ? 0 : 1;
        qualifiedName.c = this.c;
        if ((i & 2) == 2) {
            i6 |= 2;
        }
        qualifiedName.d = this.d;
        if ((i & 4) == 4) {
            i6 |= 4;
        }
        qualifiedName.e = this.e;
        qualifiedName.b = i6;
        return qualifiedName;
    }

    public final void f(ProtoBuf$QualifiedNameTable.QualifiedName qualifiedName) {
        if (qualifiedName == ProtoBuf$QualifiedNameTable.QualifiedName.h) {
            return;
        }
        int i = qualifiedName.b;
        if ((i & 1) == 1) {
            int i6 = qualifiedName.c;
            this.b = 1 | this.b;
            this.c = i6;
        }
        if ((i & 2) == 2) {
            int i10 = qualifiedName.d;
            this.b = 2 | this.b;
            this.d = i10;
        }
        if ((i & 4) == 4) {
            ProtoBuf$QualifiedNameTable.QualifiedName.Kind kind = qualifiedName.e;
            kind.getClass();
            this.b = 4 | this.b;
            this.e = kind;
        }
        this.f774a = this.f774a.c(qualifiedName.f5064a);
    }
}
