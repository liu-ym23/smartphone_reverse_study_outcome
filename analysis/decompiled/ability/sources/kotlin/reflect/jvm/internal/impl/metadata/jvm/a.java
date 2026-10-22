package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import H8.AbstractC0241b;
import H8.j;
import H8.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class a extends j implements s {
    public int b;
    public List c;
    public List d;

    @Override // H8.j
    public final AbstractC0241b a() {
        JvmProtoBuf$StringTableTypes jvmProtoBuf$StringTableTypesD = d();
        if (jvmProtoBuf$StringTableTypesD.isInitialized()) {
            return jvmProtoBuf$StringTableTypesD;
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
            B8.a r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes.h     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes r1 = new kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r2.e(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.a.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ j c(GeneratedMessageLite generatedMessageLite) {
        e((JvmProtoBuf$StringTableTypes) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        a aVar = new a();
        List list = Collections.EMPTY_LIST;
        aVar.c = list;
        aVar.d = list;
        aVar.e(d());
        return aVar;
    }

    public final JvmProtoBuf$StringTableTypes d() {
        JvmProtoBuf$StringTableTypes jvmProtoBuf$StringTableTypes = new JvmProtoBuf$StringTableTypes(this);
        if ((this.b & 1) == 1) {
            this.c = Collections.unmodifiableList(this.c);
            this.b &= -2;
        }
        jvmProtoBuf$StringTableTypes.b = this.c;
        if ((this.b & 2) == 2) {
            this.d = Collections.unmodifiableList(this.d);
            this.b &= -3;
        }
        jvmProtoBuf$StringTableTypes.c = this.d;
        return jvmProtoBuf$StringTableTypes;
    }

    public final void e(JvmProtoBuf$StringTableTypes jvmProtoBuf$StringTableTypes) {
        if (jvmProtoBuf$StringTableTypes == JvmProtoBuf$StringTableTypes.g) {
            return;
        }
        if (!jvmProtoBuf$StringTableTypes.b.isEmpty()) {
            if (this.c.isEmpty()) {
                this.c = jvmProtoBuf$StringTableTypes.b;
                this.b &= -2;
            } else {
                if ((this.b & 1) != 1) {
                    this.c = new ArrayList(this.c);
                    this.b |= 1;
                }
                this.c.addAll(jvmProtoBuf$StringTableTypes.b);
            }
        }
        if (!jvmProtoBuf$StringTableTypes.c.isEmpty()) {
            if (this.d.isEmpty()) {
                this.d = jvmProtoBuf$StringTableTypes.c;
                this.b &= -3;
            } else {
                if ((this.b & 2) != 2) {
                    this.d = new ArrayList(this.d);
                    this.b |= 2;
                }
                this.d.addAll(jvmProtoBuf$StringTableTypes.c);
            }
        }
        this.f774a = this.f774a.c(jvmProtoBuf$StringTableTypes.f5090a);
    }
}
