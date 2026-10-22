package com.stepos.mcp.sdk.base;

import A9.d;
import A9.e;
import A9.f;
import B9.A;
import B9.C0180g;
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

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/stepos/mcp/sdk/base/AppUI.$serializer", "LB9/A;", "Lcom/stepos/mcp/sdk/base/AppUI;", AppAgent.CONSTRUCT, "()V", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/stepos/mcp/sdk/base/AppUI;", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/stepos/mcp/sdk/base/AppUI;)V", "Lz9/g;", "getDescriptor", "()Lz9/g;", "descriptor", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public final class AppUI$$serializer implements A {
    public static final AppUI$$serializer INSTANCE;
    private static final /* synthetic */ V descriptor;

    static {
        AppUI$$serializer appUI$$serializer = new AppUI$$serializer();
        INSTANCE = appUI$$serializer;
        V v10 = new V("com.stepos.mcp.sdk.base.AppUI", appUI$$serializer, 6);
        v10.j("type", false);
        v10.j("packageName", false);
        v10.j("appUIName", true);
        v10.j("widgetName", true);
        v10.j("widgetAction", true);
        v10.j("isFix", true);
        descriptor = v10;
    }

    private AppUI$$serializer() {
    }

    @Override // B9.A
    public b[] childSerializers() {
        h0 h0Var = h0.f242a;
        return new b[]{h0Var, h0Var, AbstractC1451a.G(h0Var), AbstractC1451a.G(h0Var), AbstractC1451a.G(h0Var), C0180g.f239a};
    }

    @Override // x9.InterfaceC2123a
    public AppUI deserialize(e decoder) {
        boolean zDecodeBooleanElement;
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        k.f(decoder, "decoder");
        g descriptor2 = getDescriptor();
        A9.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        if (cVarBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = cVarBeginStructure.decodeStringElement(descriptor2, 0);
            String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(descriptor2, 1);
            h0 h0Var = h0.f242a;
            String str6 = (String) cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, h0Var, null);
            String str7 = (String) cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, h0Var, null);
            String str8 = (String) cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, h0Var, null);
            str = strDecodeStringElement;
            zDecodeBooleanElement = cVarBeginStructure.decodeBooleanElement(descriptor2, 5);
            str4 = str7;
            str5 = str8;
            str3 = str6;
            str2 = strDecodeStringElement2;
            i = 63;
        } else {
            boolean z10 = true;
            boolean zDecodeBooleanElement2 = false;
            String strDecodeStringElement3 = null;
            String strDecodeStringElement4 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            int i6 = 0;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z10 = false;
                        continue;
                    case 0:
                        strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(descriptor2, 0);
                        i6 |= 1;
                        continue;
                    case 1:
                        strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(descriptor2, 1);
                        i6 |= 2;
                        break;
                    case 2:
                        str9 = (String) cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, h0.f242a, str9);
                        i6 |= 4;
                        break;
                    case 3:
                        str10 = (String) cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, h0.f242a, str10);
                        i6 |= 8;
                        break;
                    case 4:
                        str11 = (String) cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, h0.f242a, str11);
                        i6 |= 16;
                        break;
                    case 5:
                        zDecodeBooleanElement2 = cVarBeginStructure.decodeBooleanElement(descriptor2, 5);
                        i6 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            zDecodeBooleanElement = zDecodeBooleanElement2;
            i = i6;
            str = strDecodeStringElement3;
            str2 = strDecodeStringElement4;
            str3 = str9;
            str4 = str10;
            str5 = str11;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new AppUI(i, str, str2, str3, str4, str5, zDecodeBooleanElement, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public void serialize(f encoder, AppUI value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        AppUI.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // B9.A
    public b[] typeParametersSerializers() {
        return T.b;
    }
}
