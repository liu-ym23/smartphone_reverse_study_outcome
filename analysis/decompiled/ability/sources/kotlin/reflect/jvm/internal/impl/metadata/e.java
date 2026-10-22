package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0241b;
import H8.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class e extends H8.j implements s {
    public int b;
    public int c;
    public List d;

    @Override // H8.j
    public final AbstractC0241b a() {
        ProtoBuf$Annotation protoBuf$AnnotationD = d();
        if (protoBuf$AnnotationD.isInitialized()) {
            return protoBuf$AnnotationD;
        }
        throw new UninitializedMessageException();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0019  */
    @Override // H8.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final H8.j b(H8.C0245f r3, H8.h r4) throws java.lang.Throwable {
        /*
            r2 = this;
            r0 = 0
            B8.a r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation.h     // Catch: java.lang.Throwable -> Ld kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> Lf
            java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Ld kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation) r3     // Catch: java.lang.Throwable -> Ld kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> Lf
            r2.e(r3)
            return r2
        Ld:
            r3 = move-exception
            goto L17
        Lf:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> Ld
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation) r4     // Catch: java.lang.Throwable -> Ld
            throw r3     // Catch: java.lang.Throwable -> L15
        L15:
            r3 = move-exception
            r0 = r4
        L17:
            if (r0 == 0) goto L1c
            r2.e(r0)
        L1c:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.e.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        e((ProtoBuf$Annotation) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        e eVar = new e();
        eVar.d = Collections.EMPTY_LIST;
        eVar.e(d());
        return eVar;
    }

    public final ProtoBuf$Annotation d() {
        ProtoBuf$Annotation protoBuf$Annotation = new ProtoBuf$Annotation(this);
        int i = this.b;
        int i6 = (i & 1) != 1 ? 0 : 1;
        protoBuf$Annotation.c = this.c;
        if ((i & 2) == 2) {
            this.d = Collections.unmodifiableList(this.d);
            this.b &= -3;
        }
        protoBuf$Annotation.d = this.d;
        protoBuf$Annotation.b = i6;
        return protoBuf$Annotation;
    }

    public final void e(ProtoBuf$Annotation protoBuf$Annotation) {
        if (protoBuf$Annotation == ProtoBuf$Annotation.g) {
            return;
        }
        if ((protoBuf$Annotation.b & 1) == 1) {
            int i = protoBuf$Annotation.c;
            this.b = 1 | this.b;
            this.c = i;
        }
        if (!protoBuf$Annotation.d.isEmpty()) {
            if (this.d.isEmpty()) {
                this.d = protoBuf$Annotation.d;
                this.b &= -3;
            } else {
                if ((this.b & 2) != 2) {
                    this.d = new ArrayList(this.d);
                    this.b |= 2;
                }
                this.d.addAll(protoBuf$Annotation.d);
            }
        }
        this.f774a = this.f774a.c(protoBuf$Annotation.f5011a);
    }
}
