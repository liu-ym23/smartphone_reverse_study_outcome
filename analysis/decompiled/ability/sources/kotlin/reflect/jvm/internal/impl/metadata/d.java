package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0241b;
import H8.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class d extends H8.j implements s {
    public int b;
    public ProtoBuf$Annotation.Argument.Value.Type c;
    public long d;
    public float e;
    public double f;
    public int g;
    public int h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public ProtoBuf$Annotation f5085j;
    public List k;
    public int l;
    public int m;

    public static d e() {
        d dVar = new d();
        dVar.c = ProtoBuf$Annotation.Argument.Value.Type.BYTE;
        dVar.f5085j = ProtoBuf$Annotation.g;
        dVar.k = Collections.EMPTY_LIST;
        return dVar;
    }

    @Override // H8.j
    public final AbstractC0241b a() {
        ProtoBuf$Annotation.Argument.Value valueD = d();
        if (valueD.isInitialized()) {
            return valueD;
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
            kotlin.reflect.jvm.internal.impl.metadata.c r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.f5013q     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value r1 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r2.f(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.d.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        f((ProtoBuf$Annotation.Argument.Value) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        d dVarE = e();
        dVarE.f(d());
        return dVarE;
    }

    public final ProtoBuf$Annotation.Argument.Value d() {
        ProtoBuf$Annotation.Argument.Value value = new ProtoBuf$Annotation.Argument.Value(this);
        int i = this.b;
        int i6 = (i & 1) != 1 ? 0 : 1;
        value.c = this.c;
        if ((i & 2) == 2) {
            i6 |= 2;
        }
        value.d = this.d;
        if ((i & 4) == 4) {
            i6 |= 4;
        }
        value.e = this.e;
        if ((i & 8) == 8) {
            i6 |= 8;
        }
        value.f = this.f;
        if ((i & 16) == 16) {
            i6 |= 16;
        }
        value.g = this.g;
        if ((i & 32) == 32) {
            i6 |= 32;
        }
        value.h = this.h;
        if ((i & 64) == 64) {
            i6 |= 64;
        }
        value.i = this.i;
        if ((i & 128) == 128) {
            i6 |= 128;
        }
        value.f5015j = this.f5085j;
        if ((i & 256) == 256) {
            this.k = Collections.unmodifiableList(this.k);
            this.b &= -257;
        }
        value.k = this.k;
        if ((i & 512) == 512) {
            i6 |= 256;
        }
        value.l = this.l;
        if ((i & 1024) == 1024) {
            i6 |= 512;
        }
        value.m = this.m;
        value.b = i6;
        return value;
    }

    public final void f(ProtoBuf$Annotation.Argument.Value value) {
        ProtoBuf$Annotation protoBuf$Annotation;
        if (value == ProtoBuf$Annotation.Argument.Value.p) {
            return;
        }
        if ((value.b & 1) == 1) {
            ProtoBuf$Annotation.Argument.Value.Type type = value.c;
            type.getClass();
            this.b = 1 | this.b;
            this.c = type;
        }
        int i = value.b;
        if ((i & 2) == 2) {
            long j5 = value.d;
            this.b |= 2;
            this.d = j5;
        }
        if ((i & 4) == 4) {
            float f = value.e;
            this.b = 4 | this.b;
            this.e = f;
        }
        if ((i & 8) == 8) {
            double d = value.f;
            this.b |= 8;
            this.f = d;
        }
        if ((i & 16) == 16) {
            int i6 = value.g;
            this.b = 16 | this.b;
            this.g = i6;
        }
        if ((i & 32) == 32) {
            int i10 = value.h;
            this.b = 32 | this.b;
            this.h = i10;
        }
        if ((i & 64) == 64) {
            int i11 = value.i;
            this.b = 64 | this.b;
            this.i = i11;
        }
        if ((i & 128) == 128) {
            ProtoBuf$Annotation protoBuf$Annotation2 = value.f5015j;
            if ((this.b & 128) != 128 || (protoBuf$Annotation = this.f5085j) == ProtoBuf$Annotation.g) {
                this.f5085j = protoBuf$Annotation2;
            } else {
                e eVar = new e();
                eVar.d = Collections.EMPTY_LIST;
                eVar.e(protoBuf$Annotation);
                eVar.e(protoBuf$Annotation2);
                this.f5085j = eVar.d();
            }
            this.b |= 128;
        }
        if (!value.k.isEmpty()) {
            if (this.k.isEmpty()) {
                this.k = value.k;
                this.b &= -257;
            } else {
                if ((this.b & 256) != 256) {
                    this.k = new ArrayList(this.k);
                    this.b |= 256;
                }
                this.k.addAll(value.k);
            }
        }
        int i12 = value.b;
        if ((i12 & 256) == 256) {
            int i13 = value.l;
            this.b |= 512;
            this.l = i13;
        }
        if ((i12 & 512) == 512) {
            int i14 = value.m;
            this.b |= 1024;
            this.m = i14;
        }
        this.f774a = this.f774a.c(value.f5014a);
    }
}
