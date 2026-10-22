package com.zyql.common.utils.update.model;

import A9.d;
import A9.e;
import A9.f;
import B9.A;
import B9.C0180g;
import B9.L;
import B9.T;
import B9.V;
import B9.d0;
import B9.h0;
import C7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.serialization.UnknownFieldException;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/zyql/common/utils/update/model/UpdateCheckResponse.$serializer", "LB9/A;", "Lcom/zyql/common/utils/update/model/UpdateCheckResponse;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/zyql/common/utils/update/model/UpdateCheckResponse;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/zyql/common/utils/update/model/UpdateCheckResponse;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class UpdateCheckResponse$$serializer implements A {
    public static final UpdateCheckResponse$$serializer INSTANCE;
    private static final g descriptor;

    static {
        UpdateCheckResponse$$serializer updateCheckResponse$$serializer = new UpdateCheckResponse$$serializer();
        INSTANCE = updateCheckResponse$$serializer;
        V v10 = new V("com.zyql.common.utils.update.model.UpdateCheckResponse", updateCheckResponse$$serializer, 8);
        v10.j("hasUpdate", false);
        v10.j("newVersionCode", true);
        v10.j("newVersionName", true);
        v10.j("updateDescription", true);
        v10.j("forceUpdate", true);
        v10.j("downloadUrl", true);
        v10.j("apkSize", true);
        v10.j("md5", true);
        descriptor = v10;
    }

    private UpdateCheckResponse$$serializer() {
    }

    @Override // B9.A
    public final b[] childSerializers() {
        L l = L.f223a;
        b bVarG = AbstractC1451a.G(l);
        h0 h0Var = h0.f242a;
        b bVarG2 = AbstractC1451a.G(h0Var);
        b bVarG3 = AbstractC1451a.G(h0Var);
        b bVarG4 = AbstractC1451a.G(h0Var);
        b bVarG5 = AbstractC1451a.G(l);
        b bVarG6 = AbstractC1451a.G(h0Var);
        C0180g c0180g = C0180g.f239a;
        return new b[]{c0180g, bVarG, bVarG2, bVarG3, c0180g, bVarG4, bVarG5, bVarG6};
    }

    @Override // x9.InterfaceC2123a
    public final UpdateCheckResponse deserialize(e decoder) {
        boolean zDecodeBooleanElement;
        String str;
        Long l;
        String str2;
        boolean z10;
        int i;
        Long l5;
        String str3;
        String str4;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        int i6 = 7;
        if (cVarBeginStructure.decodeSequentially()) {
            zDecodeBooleanElement = cVarBeginStructure.decodeBooleanElement(gVar, 0);
            L l9 = L.f223a;
            Long l10 = (Long) cVarBeginStructure.decodeNullableSerializableElement(gVar, 1, l9, null);
            h0 h0Var = h0.f242a;
            String str5 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 2, h0Var, null);
            String str6 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 3, h0Var, null);
            boolean zDecodeBooleanElement2 = cVarBeginStructure.decodeBooleanElement(gVar, 4);
            String str7 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 5, h0Var, null);
            Long l11 = (Long) cVarBeginStructure.decodeNullableSerializableElement(gVar, 6, l9, null);
            str = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 7, h0Var, null);
            l = l11;
            str2 = str7;
            str4 = str6;
            z10 = zDecodeBooleanElement2;
            str3 = str5;
            l5 = l10;
            i = 255;
        } else {
            boolean z11 = true;
            zDecodeBooleanElement = false;
            int i10 = 0;
            String str8 = null;
            Long l12 = null;
            Long l13 = null;
            String str9 = null;
            String str10 = null;
            boolean zDecodeBooleanElement3 = false;
            String str11 = null;
            while (z11) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                switch (iDecodeElementIndex) {
                    case -1:
                        z11 = false;
                    case 0:
                        zDecodeBooleanElement = cVarBeginStructure.decodeBooleanElement(gVar, 0);
                        i10 |= 1;
                        i6 = 7;
                    case 1:
                        l13 = (Long) cVarBeginStructure.decodeNullableSerializableElement(gVar, 1, L.f223a, l13);
                        i10 |= 2;
                        i6 = 7;
                    case 2:
                        str9 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 2, h0.f242a, str9);
                        i10 |= 4;
                        i6 = 7;
                    case 3:
                        str10 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 3, h0.f242a, str10);
                        i10 |= 8;
                        i6 = 7;
                    case 4:
                        zDecodeBooleanElement3 = cVarBeginStructure.decodeBooleanElement(gVar, 4);
                        i10 |= 16;
                    case 5:
                        str11 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 5, h0.f242a, str11);
                        i10 |= 32;
                    case 6:
                        l12 = (Long) cVarBeginStructure.decodeNullableSerializableElement(gVar, 6, L.f223a, l12);
                        i10 |= 64;
                    case 7:
                        str8 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, i6, h0.f242a, str8);
                        i10 |= 128;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            str = str8;
            l = l12;
            str2 = str11;
            z10 = zDecodeBooleanElement3;
            i = i10;
            l5 = l13;
            str3 = str9;
            str4 = str10;
        }
        boolean z12 = zDecodeBooleanElement;
        cVarBeginStructure.endStructure(gVar);
        return new UpdateCheckResponse(i, z12, l5, str3, str4, z10, str2, l, str, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(f encoder, UpdateCheckResponse value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        UpdateCheckResponse.write$Self$utils_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public b[] typeParametersSerializers() {
        return T.b;
    }
}
