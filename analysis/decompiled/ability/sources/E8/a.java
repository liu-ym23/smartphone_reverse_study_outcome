package E8;

import H8.AbstractC0241b;
import H8.j;
import H8.s;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class a extends j implements s {
    public final /* synthetic */ int b;
    public int c;
    public int d;
    public int e;

    public /* synthetic */ a(int i) {
        this.b = i;
    }

    @Override // H8.j
    public final AbstractC0241b a() {
        switch (this.b) {
            case 0:
                JvmProtoBuf$JvmFieldSignature jvmProtoBuf$JvmFieldSignatureD = d();
                if (jvmProtoBuf$JvmFieldSignatureD.isInitialized()) {
                    return jvmProtoBuf$JvmFieldSignatureD;
                }
                throw new UninitializedMessageException();
            default:
                JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignatureE = e();
                if (jvmProtoBuf$JvmMethodSignatureE.isInitialized()) {
                    return jvmProtoBuf$JvmMethodSignatureE;
                }
                throw new UninitializedMessageException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003f  */
    @Override // H8.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final H8.j b(H8.C0245f r2, H8.h r3) throws java.lang.Throwable {
        /*
            r1 = this;
            int r3 = r1.b
            switch(r3) {
                case 0: goto L24;
                default: goto L5;
            }
        L5:
            r3 = 0
            B8.a r0 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature.h     // Catch: java.lang.Throwable -> L14 kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L16
            r0.getClass()     // Catch: java.lang.Throwable -> L14 kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L16
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r0 = new kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature     // Catch: java.lang.Throwable -> L14 kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L16
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L14 kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L16
            r1.h(r0)
            return r1
        L14:
            r2 = move-exception
            goto L1e
        L16:
            r2 = move-exception
            H8.b r0 = r2.f5100a     // Catch: java.lang.Throwable -> L14
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r0 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature) r0     // Catch: java.lang.Throwable -> L14
            throw r2     // Catch: java.lang.Throwable -> L1c
        L1c:
            r2 = move-exception
            r3 = r0
        L1e:
            if (r3 == 0) goto L23
            r1.h(r3)
        L23:
            throw r2
        L24:
            r3 = 0
            B8.a r0 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature.h     // Catch: java.lang.Throwable -> L33 kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L35
            r0.getClass()     // Catch: java.lang.Throwable -> L33 kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L35
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature r0 = new kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature     // Catch: java.lang.Throwable -> L33 kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L35
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L33 kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L35
            r1.f(r0)
            return r1
        L33:
            r2 = move-exception
            goto L3d
        L35:
            r2 = move-exception
            H8.b r0 = r2.f5100a     // Catch: java.lang.Throwable -> L33
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature r0 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature) r0     // Catch: java.lang.Throwable -> L33
            throw r2     // Catch: java.lang.Throwable -> L3b
        L3b:
            r2 = move-exception
            r3 = r0
        L3d:
            if (r3 == 0) goto L42
            r1.f(r3)
        L42:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: E8.a.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ j c(GeneratedMessageLite generatedMessageLite) {
        switch (this.b) {
            case 0:
                f((JvmProtoBuf$JvmFieldSignature) generatedMessageLite);
                break;
            default:
                h((JvmProtoBuf$JvmMethodSignature) generatedMessageLite);
                break;
        }
        return this;
    }

    public final Object clone() {
        switch (this.b) {
            case 0:
                a aVar = new a(0);
                aVar.f(d());
                return aVar;
            default:
                a aVar2 = new a(1);
                aVar2.h(e());
                return aVar2;
        }
    }

    public JvmProtoBuf$JvmFieldSignature d() {
        JvmProtoBuf$JvmFieldSignature jvmProtoBuf$JvmFieldSignature = new JvmProtoBuf$JvmFieldSignature(this);
        int i = this.c;
        int i6 = (i & 1) != 1 ? 0 : 1;
        jvmProtoBuf$JvmFieldSignature.c = this.d;
        if ((i & 2) == 2) {
            i6 |= 2;
        }
        jvmProtoBuf$JvmFieldSignature.d = this.e;
        jvmProtoBuf$JvmFieldSignature.b = i6;
        return jvmProtoBuf$JvmFieldSignature;
    }

    public JvmProtoBuf$JvmMethodSignature e() {
        JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature = new JvmProtoBuf$JvmMethodSignature(this);
        int i = this.c;
        int i6 = (i & 1) != 1 ? 0 : 1;
        jvmProtoBuf$JvmMethodSignature.c = this.d;
        if ((i & 2) == 2) {
            i6 |= 2;
        }
        jvmProtoBuf$JvmMethodSignature.d = this.e;
        jvmProtoBuf$JvmMethodSignature.b = i6;
        return jvmProtoBuf$JvmMethodSignature;
    }

    public void f(JvmProtoBuf$JvmFieldSignature jvmProtoBuf$JvmFieldSignature) {
        if (jvmProtoBuf$JvmFieldSignature == JvmProtoBuf$JvmFieldSignature.g) {
            return;
        }
        int i = jvmProtoBuf$JvmFieldSignature.b;
        if ((i & 1) == 1) {
            int i6 = jvmProtoBuf$JvmFieldSignature.c;
            this.c = 1 | this.c;
            this.d = i6;
        }
        if ((i & 2) == 2) {
            int i10 = jvmProtoBuf$JvmFieldSignature.d;
            this.c = 2 | this.c;
            this.e = i10;
        }
        this.f774a = this.f774a.c(jvmProtoBuf$JvmFieldSignature.f5086a);
    }

    public void h(JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature) {
        if (jvmProtoBuf$JvmMethodSignature == JvmProtoBuf$JvmMethodSignature.g) {
            return;
        }
        int i = jvmProtoBuf$JvmMethodSignature.b;
        if ((i & 1) == 1) {
            int i6 = jvmProtoBuf$JvmMethodSignature.c;
            this.c = 1 | this.c;
            this.d = i6;
        }
        if ((i & 2) == 2) {
            int i10 = jvmProtoBuf$JvmMethodSignature.d;
            this.c = 2 | this.c;
            this.e = i10;
        }
        this.f774a = this.f774a.c(jvmProtoBuf$JvmMethodSignature.f5087a);
    }
}
