package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0241b;
import H8.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class g extends H8.j implements s {
    public int b;
    public int c;
    public int d;
    public ProtoBuf$Expression.ConstantValue e;
    public ProtoBuf$Type f;
    public int g;
    public List h;
    public List i;

    public static g e() {
        g gVar = new g();
        gVar.e = ProtoBuf$Expression.ConstantValue.TRUE;
        gVar.f = ProtoBuf$Type.f5067t;
        List list = Collections.EMPTY_LIST;
        gVar.h = list;
        gVar.i = list;
        return gVar;
    }

    @Override // H8.j
    public final AbstractC0241b a() {
        ProtoBuf$Expression protoBuf$ExpressionD = d();
        if (protoBuf$ExpressionD.isInitialized()) {
            return protoBuf$ExpressionD;
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
            B8.a r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression.m     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression r1 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r2.f(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.g.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        f((ProtoBuf$Expression) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        g gVarE = e();
        gVarE.f(d());
        return gVarE;
    }

    public final ProtoBuf$Expression d() {
        ProtoBuf$Expression protoBuf$Expression = new ProtoBuf$Expression(this);
        int i = this.b;
        int i6 = (i & 1) != 1 ? 0 : 1;
        protoBuf$Expression.c = this.c;
        if ((i & 2) == 2) {
            i6 |= 2;
        }
        protoBuf$Expression.d = this.d;
        if ((i & 4) == 4) {
            i6 |= 4;
        }
        protoBuf$Expression.e = this.e;
        if ((i & 8) == 8) {
            i6 |= 8;
        }
        protoBuf$Expression.f = this.f;
        if ((i & 16) == 16) {
            i6 |= 16;
        }
        protoBuf$Expression.g = this.g;
        if ((i & 32) == 32) {
            this.h = Collections.unmodifiableList(this.h);
            this.b &= -33;
        }
        protoBuf$Expression.h = this.h;
        if ((this.b & 64) == 64) {
            this.i = Collections.unmodifiableList(this.i);
            this.b &= -65;
        }
        protoBuf$Expression.i = this.i;
        protoBuf$Expression.b = i6;
        return protoBuf$Expression;
    }

    public final void f(ProtoBuf$Expression protoBuf$Expression) {
        ProtoBuf$Type protoBuf$Type;
        if (protoBuf$Expression == ProtoBuf$Expression.l) {
            return;
        }
        int i = protoBuf$Expression.b;
        if ((i & 1) == 1) {
            int i6 = protoBuf$Expression.c;
            this.b = 1 | this.b;
            this.c = i6;
        }
        if ((i & 2) == 2) {
            int i10 = protoBuf$Expression.d;
            this.b = 2 | this.b;
            this.d = i10;
        }
        if ((i & 4) == 4) {
            ProtoBuf$Expression.ConstantValue constantValue = protoBuf$Expression.e;
            constantValue.getClass();
            this.b = 4 | this.b;
            this.e = constantValue;
        }
        if ((protoBuf$Expression.b & 8) == 8) {
            ProtoBuf$Type protoBuf$Type2 = protoBuf$Expression.f;
            if ((this.b & 8) != 8 || (protoBuf$Type = this.f) == ProtoBuf$Type.f5067t) {
                this.f = protoBuf$Type2;
            } else {
                m mVarO = ProtoBuf$Type.o(protoBuf$Type);
                mVarO.h(protoBuf$Type2);
                this.f = mVarO.e();
            }
            this.b |= 8;
        }
        if ((protoBuf$Expression.b & 16) == 16) {
            int i11 = protoBuf$Expression.g;
            this.b = 16 | this.b;
            this.g = i11;
        }
        if (!protoBuf$Expression.h.isEmpty()) {
            if (this.h.isEmpty()) {
                this.h = protoBuf$Expression.h;
                this.b &= -33;
            } else {
                if ((this.b & 32) != 32) {
                    this.h = new ArrayList(this.h);
                    this.b |= 32;
                }
                this.h.addAll(protoBuf$Expression.h);
            }
        }
        if (!protoBuf$Expression.i.isEmpty()) {
            if (this.i.isEmpty()) {
                this.i = protoBuf$Expression.i;
                this.b &= -65;
            } else {
                if ((this.b & 64) != 64) {
                    this.i = new ArrayList(this.i);
                    this.b |= 64;
                }
                this.i.addAll(protoBuf$Expression.i);
            }
        }
        this.f774a = this.f774a.c(protoBuf$Expression.f5044a);
    }
}
