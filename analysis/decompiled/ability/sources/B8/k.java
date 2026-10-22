package B8;

import H8.AbstractC0241b;
import H8.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class k extends H8.j implements s {
    public int b;
    public List c;
    public int d;

    public static k e() {
        k kVar = new k();
        kVar.c = Collections.EMPTY_LIST;
        kVar.d = -1;
        return kVar;
    }

    @Override // H8.j
    public final AbstractC0241b a() {
        ProtoBuf$TypeTable protoBuf$TypeTableD = d();
        if (protoBuf$TypeTableD.isInitialized()) {
            return protoBuf$TypeTableD;
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
            B8.a r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable.h     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r1 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r2.f(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: B8.k.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        f((ProtoBuf$TypeTable) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        k kVarE = e();
        kVarE.f(d());
        return kVarE;
    }

    public final ProtoBuf$TypeTable d() {
        ProtoBuf$TypeTable protoBuf$TypeTable = new ProtoBuf$TypeTable(this);
        int i = this.b;
        if ((i & 1) == 1) {
            this.c = Collections.unmodifiableList(this.c);
            this.b &= -2;
        }
        protoBuf$TypeTable.c = this.c;
        int i6 = (i & 2) != 2 ? 0 : 1;
        protoBuf$TypeTable.d = this.d;
        protoBuf$TypeTable.b = i6;
        return protoBuf$TypeTable;
    }

    public final void f(ProtoBuf$TypeTable protoBuf$TypeTable) {
        if (protoBuf$TypeTable == ProtoBuf$TypeTable.g) {
            return;
        }
        if (!protoBuf$TypeTable.c.isEmpty()) {
            if (this.c.isEmpty()) {
                this.c = protoBuf$TypeTable.c;
                this.b &= -2;
            } else {
                if ((this.b & 1) != 1) {
                    this.c = new ArrayList(this.c);
                    this.b |= 1;
                }
                this.c.addAll(protoBuf$TypeTable.c);
            }
        }
        if ((protoBuf$TypeTable.b & 1) == 1) {
            int i = protoBuf$TypeTable.d;
            this.b |= 2;
            this.d = i;
        }
        this.f774a = this.f774a.c(protoBuf$TypeTable.f5077a);
    }
}
