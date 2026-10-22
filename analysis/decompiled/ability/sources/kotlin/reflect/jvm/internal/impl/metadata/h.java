package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0241b;
import H8.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class h extends H8.j implements s {
    public int b;
    public List c;

    @Override // H8.j
    public final AbstractC0241b a() {
        ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTableD = d();
        if (protoBuf$QualifiedNameTableD.isInitialized()) {
            return protoBuf$QualifiedNameTableD;
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
            B8.a r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable.f     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable r1 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r2.e(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.h.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        e((ProtoBuf$QualifiedNameTable) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        h hVar = new h();
        hVar.c = Collections.EMPTY_LIST;
        hVar.e(d());
        return hVar;
    }

    public final ProtoBuf$QualifiedNameTable d() {
        ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable = new ProtoBuf$QualifiedNameTable(this);
        if ((this.b & 1) == 1) {
            this.c = Collections.unmodifiableList(this.c);
            this.b &= -2;
        }
        protoBuf$QualifiedNameTable.b = this.c;
        return protoBuf$QualifiedNameTable;
    }

    public final void e(ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable) {
        if (protoBuf$QualifiedNameTable == ProtoBuf$QualifiedNameTable.e) {
            return;
        }
        if (!protoBuf$QualifiedNameTable.b.isEmpty()) {
            if (this.c.isEmpty()) {
                this.c = protoBuf$QualifiedNameTable.b;
                this.b &= -2;
            } else {
                if ((this.b & 1) != 1) {
                    this.c = new ArrayList(this.c);
                    this.b |= 1;
                }
                this.c.addAll(protoBuf$QualifiedNameTable.b);
            }
        }
        this.f774a = this.f774a.c(protoBuf$QualifiedNameTable.f5063a);
    }
}
