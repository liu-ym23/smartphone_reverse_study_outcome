package B8;

import H8.AbstractC0241b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class c extends kotlin.reflect.jvm.internal.impl.protobuf.a {
    public int d;
    public int e;
    public List f;
    public List g;

    public static c f() {
        c cVar = new c();
        cVar.e = 6;
        List list = Collections.EMPTY_LIST;
        cVar.f = list;
        cVar.g = list;
        return cVar;
    }

    @Override // H8.j
    public final AbstractC0241b a() {
        ProtoBuf$Constructor protoBuf$ConstructorE = e();
        if (protoBuf$ConstructorE.isInitialized()) {
            return protoBuf$ConstructorE;
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
            B8.a r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor.f5038j     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor r1 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r2.h(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: B8.c.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        h((ProtoBuf$Constructor) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        c cVarF = f();
        cVarF.h(e());
        return cVarF;
    }

    public final ProtoBuf$Constructor e() {
        ProtoBuf$Constructor protoBuf$Constructor = new ProtoBuf$Constructor(this);
        int i = this.d;
        int i6 = (i & 1) != 1 ? 0 : 1;
        protoBuf$Constructor.d = this.e;
        if ((i & 2) == 2) {
            this.f = Collections.unmodifiableList(this.f);
            this.d &= -3;
        }
        protoBuf$Constructor.e = this.f;
        if ((this.d & 4) == 4) {
            this.g = Collections.unmodifiableList(this.g);
            this.d &= -5;
        }
        protoBuf$Constructor.f = this.g;
        protoBuf$Constructor.c = i6;
        return protoBuf$Constructor;
    }

    public final void h(ProtoBuf$Constructor protoBuf$Constructor) {
        if (protoBuf$Constructor == ProtoBuf$Constructor.i) {
            return;
        }
        if ((protoBuf$Constructor.c & 1) == 1) {
            int i = protoBuf$Constructor.d;
            this.d = 1 | this.d;
            this.e = i;
        }
        if (!protoBuf$Constructor.e.isEmpty()) {
            if (this.f.isEmpty()) {
                this.f = protoBuf$Constructor.e;
                this.d &= -3;
            } else {
                if ((this.d & 2) != 2) {
                    this.f = new ArrayList(this.f);
                    this.d |= 2;
                }
                this.f.addAll(protoBuf$Constructor.e);
            }
        }
        if (!protoBuf$Constructor.f.isEmpty()) {
            if (this.g.isEmpty()) {
                this.g = protoBuf$Constructor.f;
                this.d &= -5;
            } else {
                if ((this.d & 4) != 4) {
                    this.g = new ArrayList(this.g);
                    this.d |= 4;
                }
                this.g.addAll(protoBuf$Constructor.f);
            }
        }
        d(protoBuf$Constructor);
        this.f774a = this.f774a.c(protoBuf$Constructor.b);
    }
}
