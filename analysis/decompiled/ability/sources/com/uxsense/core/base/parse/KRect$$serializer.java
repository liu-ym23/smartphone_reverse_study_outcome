package com.uxsense.core.base.parse;

import A9.d;
import A9.e;
import A9.f;
import B9.A;
import B9.F;
import B9.T;
import B9.V;
import B9.d0;
import C7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.serialization.UnknownFieldException;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/uxsense/core/base/parse/KRect.$serializer", "LB9/A;", "Lcom/uxsense/core/base/parse/KRect;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/core/base/parse/KRect;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/core/base/parse/KRect;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class KRect$$serializer implements A {
    public static final KRect$$serializer INSTANCE;
    private static final g descriptor;

    static {
        KRect$$serializer kRect$$serializer = new KRect$$serializer();
        INSTANCE = kRect$$serializer;
        V v10 = new V("com.uxsense.core.base.parse.KRect", kRect$$serializer, 4);
        v10.j("left", true);
        v10.j("top", true);
        v10.j("right", true);
        v10.j("bottom", true);
        descriptor = v10;
    }

    private KRect$$serializer() {
    }

    @Override // B9.A
    public final b[] childSerializers() {
        F f = F.f218a;
        return new b[]{f, f, f, f};
    }

    @Override // x9.InterfaceC2123a
    public final KRect deserialize(e decoder) {
        int iDecodeIntElement;
        int iDecodeIntElement2;
        int i;
        int i6;
        int i10;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        if (cVarBeginStructure.decodeSequentially()) {
            iDecodeIntElement = cVarBeginStructure.decodeIntElement(gVar, 0);
            int iDecodeIntElement3 = cVarBeginStructure.decodeIntElement(gVar, 1);
            int iDecodeIntElement4 = cVarBeginStructure.decodeIntElement(gVar, 2);
            iDecodeIntElement2 = cVarBeginStructure.decodeIntElement(gVar, 3);
            i = iDecodeIntElement4;
            i6 = iDecodeIntElement3;
            i10 = 15;
        } else {
            boolean z10 = true;
            iDecodeIntElement = 0;
            int iDecodeIntElement5 = 0;
            int iDecodeIntElement6 = 0;
            int iDecodeIntElement7 = 0;
            int i11 = 0;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    iDecodeIntElement = cVarBeginStructure.decodeIntElement(gVar, 0);
                    i11 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    iDecodeIntElement7 = cVarBeginStructure.decodeIntElement(gVar, 1);
                    i11 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    iDecodeIntElement6 = cVarBeginStructure.decodeIntElement(gVar, 2);
                    i11 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    iDecodeIntElement5 = cVarBeginStructure.decodeIntElement(gVar, 3);
                    i11 |= 8;
                }
            }
            iDecodeIntElement2 = iDecodeIntElement5;
            i = iDecodeIntElement6;
            i6 = iDecodeIntElement7;
            i10 = i11;
        }
        int i12 = iDecodeIntElement;
        cVarBeginStructure.endStructure(gVar);
        return new KRect(i10, i12, i6, i, iDecodeIntElement2, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(f encoder, KRect value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        KRect.write$Self$uxsense_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public /* bridge */ /* synthetic */ b[] typeParametersSerializers() {
        return T.b;
    }
}
