package com.zyql.common.utils.update.model;

import A9.d;
import A9.e;
import A9.f;
import B9.A;
import B9.L;
import B9.T;
import B9.V;
import B9.h0;
import C7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.serialization.UnknownFieldException;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/zyql/common/utils/update/model/UpdateCheckRequest.$serializer", "LB9/A;", "Lcom/zyql/common/utils/update/model/UpdateCheckRequest;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/zyql/common/utils/update/model/UpdateCheckRequest;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/zyql/common/utils/update/model/UpdateCheckRequest;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class UpdateCheckRequest$$serializer implements A {
    public static final UpdateCheckRequest$$serializer INSTANCE;
    private static final g descriptor;

    static {
        UpdateCheckRequest$$serializer updateCheckRequest$$serializer = new UpdateCheckRequest$$serializer();
        INSTANCE = updateCheckRequest$$serializer;
        V v10 = new V("com.zyql.common.utils.update.model.UpdateCheckRequest", updateCheckRequest$$serializer, 3);
        v10.j("versionCode", false);
        v10.j("versionName", false);
        v10.j("packageName", false);
        descriptor = v10;
    }

    private UpdateCheckRequest$$serializer() {
    }

    @Override // B9.A
    public final b[] childSerializers() {
        h0 h0Var = h0.f242a;
        return new b[]{L.f223a, h0Var, h0Var};
    }

    @Override // x9.InterfaceC2123a
    public final UpdateCheckRequest deserialize(e decoder) {
        String strDecodeStringElement;
        String strDecodeStringElement2;
        int i;
        long j5;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        if (cVarBeginStructure.decodeSequentially()) {
            long jDecodeLongElement = cVarBeginStructure.decodeLongElement(gVar, 0);
            strDecodeStringElement = cVarBeginStructure.decodeStringElement(gVar, 1);
            strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(gVar, 2);
            i = 7;
            j5 = jDecodeLongElement;
        } else {
            strDecodeStringElement = null;
            boolean z10 = true;
            long jDecodeLongElement2 = 0;
            String strDecodeStringElement3 = null;
            int i6 = 0;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(gVar, 0);
                    i6 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    strDecodeStringElement = cVarBeginStructure.decodeStringElement(gVar, 1);
                    i6 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(gVar, 2);
                    i6 |= 4;
                }
            }
            strDecodeStringElement2 = strDecodeStringElement3;
            i = i6;
            j5 = jDecodeLongElement2;
        }
        String str = strDecodeStringElement;
        cVarBeginStructure.endStructure(gVar);
        return new UpdateCheckRequest(i, j5, str, strDecodeStringElement2, null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(f encoder, UpdateCheckRequest value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        UpdateCheckRequest.write$Self$utils_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public b[] typeParametersSerializers() {
        return T.b;
    }
}
