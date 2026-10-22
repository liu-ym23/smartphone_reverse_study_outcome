package com.uxsense.parse;

import A9.d;
import A9.e;
import A9.f;
import B9.A;
import B9.L;
import B9.T;
import B9.V;
import C7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.parse.IdSource;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.serialization.UnknownFieldException;
import z9.g;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/uxsense/parse/IdSource.Fixed.$serializer", "LB9/A;", "Lcom/uxsense/parse/IdSource$Fixed;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/parse/IdSource$Fixed;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/parse/IdSource$Fixed;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class IdSource$Fixed$$serializer implements A {
    public static final IdSource$Fixed$$serializer INSTANCE;
    private static final g descriptor;

    static {
        IdSource$Fixed$$serializer idSource$Fixed$$serializer = new IdSource$Fixed$$serializer();
        INSTANCE = idSource$Fixed$$serializer;
        V v10 = new V("com.uxsense.parse.IdSource.Fixed", idSource$Fixed$$serializer, 1);
        v10.j("value", false);
        descriptor = v10;
    }

    private IdSource$Fixed$$serializer() {
    }

    @Override // B9.A
    public final x9.b[] childSerializers() {
        return new x9.b[]{L.f223a};
    }

    @Override // x9.InterfaceC2123a
    public final IdSource.Fixed deserialize(e decoder) {
        long jDecodeLongElement;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        int i = 1;
        if (cVarBeginStructure.decodeSequentially()) {
            jDecodeLongElement = cVarBeginStructure.decodeLongElement(gVar, 0);
        } else {
            long jDecodeLongElement2 = 0;
            boolean z10 = true;
            int i6 = 0;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(gVar, 0);
                    i6 = 1;
                }
            }
            jDecodeLongElement = jDecodeLongElement2;
            i = i6;
        }
        cVarBeginStructure.endStructure(gVar);
        return new IdSource.Fixed(i, jDecodeLongElement, null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(f encoder, IdSource.Fixed value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        IdSource.Fixed.write$Self$uxsense_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public /* bridge */ /* synthetic */ x9.b[] typeParametersSerializers() {
        return T.b;
    }
}
