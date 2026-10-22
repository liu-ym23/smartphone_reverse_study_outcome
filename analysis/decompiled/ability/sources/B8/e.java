package B8;

import H8.AbstractC0241b;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class e extends kotlin.reflect.jvm.internal.impl.protobuf.a {
    public int d;
    public int e;

    @Override // H8.j
    public final AbstractC0241b a() {
        ProtoBuf$EnumEntry protoBuf$EnumEntry = new ProtoBuf$EnumEntry(this);
        int i = (this.d & 1) != 1 ? 0 : 1;
        protoBuf$EnumEntry.d = this.e;
        protoBuf$EnumEntry.c = i;
        if (protoBuf$EnumEntry.isInitialized()) {
            return protoBuf$EnumEntry;
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
            B8.a r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry.h     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry r1 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r2.e(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: B8.e.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        e((ProtoBuf$EnumEntry) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        e eVar = new e();
        ProtoBuf$EnumEntry protoBuf$EnumEntry = new ProtoBuf$EnumEntry(this);
        int i = (this.d & 1) != 1 ? 0 : 1;
        protoBuf$EnumEntry.d = this.e;
        protoBuf$EnumEntry.c = i;
        eVar.e(protoBuf$EnumEntry);
        return eVar;
    }

    public final void e(ProtoBuf$EnumEntry protoBuf$EnumEntry) {
        if (protoBuf$EnumEntry == ProtoBuf$EnumEntry.g) {
            return;
        }
        if ((protoBuf$EnumEntry.c & 1) == 1) {
            int i = protoBuf$EnumEntry.d;
            this.d = 1 | this.d;
            this.e = i;
        }
        d(protoBuf$EnumEntry);
        this.f774a = this.f774a.c(protoBuf$EnumEntry.b);
    }
}
