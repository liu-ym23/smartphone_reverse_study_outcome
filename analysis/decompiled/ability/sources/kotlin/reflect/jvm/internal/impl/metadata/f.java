package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0241b;
import H8.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class f extends H8.j implements s {
    public int b;
    public ProtoBuf$Effect.EffectType c;
    public List d;
    public ProtoBuf$Expression e;
    public ProtoBuf$Effect.InvocationKind f;

    public static f e() {
        f fVar = new f();
        fVar.c = ProtoBuf$Effect.EffectType.RETURNS_CONSTANT;
        fVar.d = Collections.EMPTY_LIST;
        fVar.e = ProtoBuf$Expression.l;
        fVar.f = ProtoBuf$Effect.InvocationKind.AT_MOST_ONCE;
        return fVar;
    }

    @Override // H8.j
    public final AbstractC0241b a() {
        ProtoBuf$Effect protoBuf$EffectD = d();
        if (protoBuf$EffectD.isInitialized()) {
            return protoBuf$EffectD;
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
            B8.a r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect.f5040j     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect r1 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r2.f(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.f.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        f((ProtoBuf$Effect) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        f fVarE = e();
        fVarE.f(d());
        return fVarE;
    }

    public final ProtoBuf$Effect d() {
        ProtoBuf$Effect protoBuf$Effect = new ProtoBuf$Effect(this);
        int i = this.b;
        int i6 = (i & 1) != 1 ? 0 : 1;
        protoBuf$Effect.c = this.c;
        if ((i & 2) == 2) {
            this.d = Collections.unmodifiableList(this.d);
            this.b &= -3;
        }
        protoBuf$Effect.d = this.d;
        if ((i & 4) == 4) {
            i6 |= 2;
        }
        protoBuf$Effect.e = this.e;
        if ((i & 8) == 8) {
            i6 |= 4;
        }
        protoBuf$Effect.f = this.f;
        protoBuf$Effect.b = i6;
        return protoBuf$Effect;
    }

    public final void f(ProtoBuf$Effect protoBuf$Effect) {
        ProtoBuf$Expression protoBuf$Expression;
        if (protoBuf$Effect == ProtoBuf$Effect.i) {
            return;
        }
        if ((protoBuf$Effect.b & 1) == 1) {
            ProtoBuf$Effect.EffectType effectType = protoBuf$Effect.c;
            effectType.getClass();
            this.b = 1 | this.b;
            this.c = effectType;
        }
        if (!protoBuf$Effect.d.isEmpty()) {
            if (this.d.isEmpty()) {
                this.d = protoBuf$Effect.d;
                this.b &= -3;
            } else {
                if ((this.b & 2) != 2) {
                    this.d = new ArrayList(this.d);
                    this.b |= 2;
                }
                this.d.addAll(protoBuf$Effect.d);
            }
        }
        if ((protoBuf$Effect.b & 2) == 2) {
            ProtoBuf$Expression protoBuf$Expression2 = protoBuf$Effect.e;
            if ((this.b & 4) != 4 || (protoBuf$Expression = this.e) == ProtoBuf$Expression.l) {
                this.e = protoBuf$Expression2;
            } else {
                g gVarE = g.e();
                gVarE.f(protoBuf$Expression);
                gVarE.f(protoBuf$Expression2);
                this.e = gVarE.d();
            }
            this.b |= 4;
        }
        if ((protoBuf$Effect.b & 4) == 4) {
            ProtoBuf$Effect.InvocationKind invocationKind = protoBuf$Effect.f;
            invocationKind.getClass();
            this.b |= 8;
            this.f = invocationKind;
        }
        this.f774a = this.f774a.c(protoBuf$Effect.f5041a);
    }
}
