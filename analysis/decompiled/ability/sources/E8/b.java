package E8;

import H8.AbstractC0241b;
import H8.j;
import H8.s;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class b extends j implements s {
    public int b;
    public JvmProtoBuf$JvmFieldSignature c;
    public JvmProtoBuf$JvmMethodSignature d;
    public JvmProtoBuf$JvmMethodSignature e;
    public JvmProtoBuf$JvmMethodSignature f;
    public JvmProtoBuf$JvmMethodSignature g;

    public static b e() {
        b bVar = new b();
        bVar.c = JvmProtoBuf$JvmFieldSignature.g;
        JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature = JvmProtoBuf$JvmMethodSignature.g;
        bVar.d = jvmProtoBuf$JvmMethodSignature;
        bVar.e = jvmProtoBuf$JvmMethodSignature;
        bVar.f = jvmProtoBuf$JvmMethodSignature;
        bVar.g = jvmProtoBuf$JvmMethodSignature;
        return bVar;
    }

    @Override // H8.j
    public final AbstractC0241b a() {
        JvmProtoBuf$JvmPropertySignature jvmProtoBuf$JvmPropertySignatureD = d();
        if (jvmProtoBuf$JvmPropertySignatureD.isInitialized()) {
            return jvmProtoBuf$JvmPropertySignatureD;
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
            B8.a r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature.k     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature r1 = new kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r2.f(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: E8.b.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ j c(GeneratedMessageLite generatedMessageLite) {
        f((JvmProtoBuf$JvmPropertySignature) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        b bVarE = e();
        bVarE.f(d());
        return bVarE;
    }

    public final JvmProtoBuf$JvmPropertySignature d() {
        JvmProtoBuf$JvmPropertySignature jvmProtoBuf$JvmPropertySignature = new JvmProtoBuf$JvmPropertySignature(this);
        int i = this.b;
        int i6 = (i & 1) != 1 ? 0 : 1;
        jvmProtoBuf$JvmPropertySignature.c = this.c;
        if ((i & 2) == 2) {
            i6 |= 2;
        }
        jvmProtoBuf$JvmPropertySignature.d = this.d;
        if ((i & 4) == 4) {
            i6 |= 4;
        }
        jvmProtoBuf$JvmPropertySignature.e = this.e;
        if ((i & 8) == 8) {
            i6 |= 8;
        }
        jvmProtoBuf$JvmPropertySignature.f = this.f;
        if ((i & 16) == 16) {
            i6 |= 16;
        }
        jvmProtoBuf$JvmPropertySignature.g = this.g;
        jvmProtoBuf$JvmPropertySignature.b = i6;
        return jvmProtoBuf$JvmPropertySignature;
    }

    public final void f(JvmProtoBuf$JvmPropertySignature jvmProtoBuf$JvmPropertySignature) {
        JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature;
        JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature2;
        JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature3;
        JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature4;
        JvmProtoBuf$JvmFieldSignature jvmProtoBuf$JvmFieldSignature;
        if (jvmProtoBuf$JvmPropertySignature == JvmProtoBuf$JvmPropertySignature.f5088j) {
            return;
        }
        if ((jvmProtoBuf$JvmPropertySignature.b & 1) == 1) {
            JvmProtoBuf$JvmFieldSignature jvmProtoBuf$JvmFieldSignature2 = jvmProtoBuf$JvmPropertySignature.c;
            if ((this.b & 1) != 1 || (jvmProtoBuf$JvmFieldSignature = this.c) == JvmProtoBuf$JvmFieldSignature.g) {
                this.c = jvmProtoBuf$JvmFieldSignature2;
            } else {
                a aVar = new a(0);
                aVar.f(jvmProtoBuf$JvmFieldSignature);
                aVar.f(jvmProtoBuf$JvmFieldSignature2);
                this.c = aVar.d();
            }
            this.b |= 1;
        }
        if ((jvmProtoBuf$JvmPropertySignature.b & 2) == 2) {
            JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature5 = jvmProtoBuf$JvmPropertySignature.d;
            if ((this.b & 2) != 2 || (jvmProtoBuf$JvmMethodSignature4 = this.d) == JvmProtoBuf$JvmMethodSignature.g) {
                this.d = jvmProtoBuf$JvmMethodSignature5;
            } else {
                a aVarG = JvmProtoBuf$JvmMethodSignature.g(jvmProtoBuf$JvmMethodSignature4);
                aVarG.h(jvmProtoBuf$JvmMethodSignature5);
                this.d = aVarG.e();
            }
            this.b |= 2;
        }
        if ((jvmProtoBuf$JvmPropertySignature.b & 4) == 4) {
            JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature6 = jvmProtoBuf$JvmPropertySignature.e;
            if ((this.b & 4) != 4 || (jvmProtoBuf$JvmMethodSignature3 = this.e) == JvmProtoBuf$JvmMethodSignature.g) {
                this.e = jvmProtoBuf$JvmMethodSignature6;
            } else {
                a aVarG2 = JvmProtoBuf$JvmMethodSignature.g(jvmProtoBuf$JvmMethodSignature3);
                aVarG2.h(jvmProtoBuf$JvmMethodSignature6);
                this.e = aVarG2.e();
            }
            this.b |= 4;
        }
        if ((jvmProtoBuf$JvmPropertySignature.b & 8) == 8) {
            JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature7 = jvmProtoBuf$JvmPropertySignature.f;
            if ((this.b & 8) != 8 || (jvmProtoBuf$JvmMethodSignature2 = this.f) == JvmProtoBuf$JvmMethodSignature.g) {
                this.f = jvmProtoBuf$JvmMethodSignature7;
            } else {
                a aVarG3 = JvmProtoBuf$JvmMethodSignature.g(jvmProtoBuf$JvmMethodSignature2);
                aVarG3.h(jvmProtoBuf$JvmMethodSignature7);
                this.f = aVarG3.e();
            }
            this.b |= 8;
        }
        if ((jvmProtoBuf$JvmPropertySignature.b & 16) == 16) {
            JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature8 = jvmProtoBuf$JvmPropertySignature.g;
            if ((this.b & 16) != 16 || (jvmProtoBuf$JvmMethodSignature = this.g) == JvmProtoBuf$JvmMethodSignature.g) {
                this.g = jvmProtoBuf$JvmMethodSignature8;
            } else {
                a aVarG4 = JvmProtoBuf$JvmMethodSignature.g(jvmProtoBuf$JvmMethodSignature);
                aVarG4.h(jvmProtoBuf$JvmMethodSignature8);
                this.g = aVarG4.e();
            }
            this.b |= 16;
        }
        this.f774a = this.f774a.c(jvmProtoBuf$JvmPropertySignature.f5089a);
    }
}
