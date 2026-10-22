package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0241b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class n extends kotlin.reflect.jvm.internal.impl.protobuf.a {
    public int d;
    public int e;
    public int f;
    public boolean g;
    public ProtoBuf$TypeParameter.Variance h;
    public List i;

    /* renamed from: j, reason: collision with root package name */
    public List f5097j;

    public static n f() {
        n nVar = new n();
        nVar.h = ProtoBuf$TypeParameter.Variance.INV;
        List list = Collections.EMPTY_LIST;
        nVar.i = list;
        nVar.f5097j = list;
        return nVar;
    }

    @Override // H8.j
    public final AbstractC0241b a() {
        ProtoBuf$TypeParameter protoBuf$TypeParameterE = e();
        if (protoBuf$TypeParameterE.isInitialized()) {
            return protoBuf$TypeParameterE;
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
            B8.a r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter.n     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter r1 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r2.h(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter) r4     // Catch: java.lang.Throwable -> Lf
            throw r3     // Catch: java.lang.Throwable -> L17
        L17:
            r3 = move-exception
            r0 = r4
        L19:
            if (r0 == 0) goto L1e
            r2.h(r0)
        L1e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.n.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        h((ProtoBuf$TypeParameter) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        n nVarF = f();
        nVarF.h(e());
        return nVarF;
    }

    public final ProtoBuf$TypeParameter e() {
        ProtoBuf$TypeParameter protoBuf$TypeParameter = new ProtoBuf$TypeParameter(this);
        int i = this.d;
        int i6 = (i & 1) != 1 ? 0 : 1;
        protoBuf$TypeParameter.d = this.e;
        if ((i & 2) == 2) {
            i6 |= 2;
        }
        protoBuf$TypeParameter.e = this.f;
        if ((i & 4) == 4) {
            i6 |= 4;
        }
        protoBuf$TypeParameter.f = this.g;
        if ((i & 8) == 8) {
            i6 |= 8;
        }
        protoBuf$TypeParameter.g = this.h;
        if ((i & 16) == 16) {
            this.i = Collections.unmodifiableList(this.i);
            this.d &= -17;
        }
        protoBuf$TypeParameter.h = this.i;
        if ((this.d & 32) == 32) {
            this.f5097j = Collections.unmodifiableList(this.f5097j);
            this.d &= -33;
        }
        protoBuf$TypeParameter.i = this.f5097j;
        protoBuf$TypeParameter.c = i6;
        return protoBuf$TypeParameter;
    }

    public final void h(ProtoBuf$TypeParameter protoBuf$TypeParameter) {
        if (protoBuf$TypeParameter == ProtoBuf$TypeParameter.m) {
            return;
        }
        int i = protoBuf$TypeParameter.c;
        if ((i & 1) == 1) {
            int i6 = protoBuf$TypeParameter.d;
            this.d = 1 | this.d;
            this.e = i6;
        }
        if ((i & 2) == 2) {
            int i10 = protoBuf$TypeParameter.e;
            this.d = 2 | this.d;
            this.f = i10;
        }
        if ((i & 4) == 4) {
            boolean z10 = protoBuf$TypeParameter.f;
            this.d = 4 | this.d;
            this.g = z10;
        }
        if ((i & 8) == 8) {
            ProtoBuf$TypeParameter.Variance variance = protoBuf$TypeParameter.g;
            variance.getClass();
            this.d = 8 | this.d;
            this.h = variance;
        }
        if (!protoBuf$TypeParameter.h.isEmpty()) {
            if (this.i.isEmpty()) {
                this.i = protoBuf$TypeParameter.h;
                this.d &= -17;
            } else {
                if ((this.d & 16) != 16) {
                    this.i = new ArrayList(this.i);
                    this.d |= 16;
                }
                this.i.addAll(protoBuf$TypeParameter.h);
            }
        }
        if (!protoBuf$TypeParameter.i.isEmpty()) {
            if (this.f5097j.isEmpty()) {
                this.f5097j = protoBuf$TypeParameter.i;
                this.d &= -33;
            } else {
                if ((this.d & 32) != 32) {
                    this.f5097j = new ArrayList(this.f5097j);
                    this.d |= 32;
                }
                this.f5097j.addAll(protoBuf$TypeParameter.i);
            }
        }
        d(protoBuf$TypeParameter);
        this.f774a = this.f774a.c(protoBuf$TypeParameter.b);
    }
}
