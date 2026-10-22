package com.uxsense.base.parse;

import A9.d;
import A9.e;
import B9.A;
import B9.T;
import B9.V;
import B9.d0;
import B9.h0;
import C7.c;
import C7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.core.pattern.ParentFilter;
import com.uxsense.core.pattern.ParentFilter$$serializer;
import com.uxsense.core.pattern.ViewPattern;
import com.uxsense.parse.MetadataConfig;
import com.uxsense.parse.MetadataConfig$$serializer;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.serialization.UnknownFieldException;
import x9.InterfaceC2123a;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/uxsense/base/parse/ParseRule.$serializer", "LB9/A;", "Lcom/uxsense/base/parse/ParseRule;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/base/parse/ParseRule;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/base/parse/ParseRule;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class ParseRule$$serializer implements A {
    public static final ParseRule$$serializer INSTANCE;
    private static final g descriptor;

    static {
        ParseRule$$serializer parseRule$$serializer = new ParseRule$$serializer();
        INSTANCE = parseRule$$serializer;
        V v10 = new V("com.uxsense.base.parse.ParseRule", parseRule$$serializer, 7);
        v10.j("packageName", false);
        v10.j("windowTitle", false);
        v10.j("activityClass", true);
        v10.j("appVersion", true);
        v10.j("viewPattern", false);
        v10.j("parentFilter", true);
        v10.j("metadataConfig", true);
        descriptor = v10;
    }

    private ParseRule$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // B9.A
    public final b[] childSerializers() {
        f[] fVarArr = ParseRule.$childSerializers;
        h0 h0Var = h0.f242a;
        return new b[]{h0Var, h0Var, AbstractC1451a.G(h0Var), AbstractC1451a.G(h0Var), fVarArr[4].getF4884a(), AbstractC1451a.G(ParentFilter$$serializer.INSTANCE), AbstractC1451a.G(MetadataConfig$$serializer.INSTANCE)};
    }

    @Override // x9.InterfaceC2123a
    public final ParseRule deserialize(e decoder) {
        int i;
        MetadataConfig metadataConfig;
        ParentFilter parentFilter;
        String str;
        String str2;
        String str3;
        String str4;
        ViewPattern viewPattern;
        char c;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        f[] fVarArr = ParseRule.$childSerializers;
        int i6 = 6;
        String strDecodeStringElement = null;
        if (cVarBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(gVar, 0);
            String strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(gVar, 1);
            h0 h0Var = h0.f242a;
            String str5 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 2, h0Var, null);
            String str6 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 3, h0Var, null);
            ViewPattern viewPattern2 = (ViewPattern) cVarBeginStructure.decodeSerializableElement(gVar, 4, (InterfaceC2123a) fVarArr[4].getF4884a(), null);
            ParentFilter parentFilter2 = (ParentFilter) cVarBeginStructure.decodeNullableSerializableElement(gVar, 5, ParentFilter$$serializer.INSTANCE, null);
            viewPattern = viewPattern2;
            str = strDecodeStringElement2;
            metadataConfig = (MetadataConfig) cVarBeginStructure.decodeNullableSerializableElement(gVar, 6, MetadataConfig$$serializer.INSTANCE, null);
            parentFilter = parentFilter2;
            str4 = str6;
            str3 = str5;
            i = 127;
            str2 = strDecodeStringElement3;
        } else {
            boolean z10 = true;
            int i10 = 0;
            MetadataConfig metadataConfig2 = null;
            ParentFilter parentFilter3 = null;
            String strDecodeStringElement4 = null;
            String str7 = null;
            String str8 = null;
            ViewPattern viewPattern3 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                switch (iDecodeElementIndex) {
                    case -1:
                        z10 = false;
                    case 0:
                        i10 |= 1;
                        strDecodeStringElement = cVarBeginStructure.decodeStringElement(gVar, 0);
                        i6 = 6;
                    case 1:
                        c = 2;
                        strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(gVar, 1);
                        i10 |= 2;
                        i6 = 6;
                    case 2:
                        c = 2;
                        str7 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 2, h0.f242a, str7);
                        i10 |= 4;
                        i6 = 6;
                    case 3:
                        str8 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 3, h0.f242a, str8);
                        i10 |= 8;
                    case 4:
                        viewPattern3 = (ViewPattern) cVarBeginStructure.decodeSerializableElement(gVar, 4, (InterfaceC2123a) fVarArr[4].getF4884a(), viewPattern3);
                        i10 |= 16;
                    case 5:
                        parentFilter3 = (ParentFilter) cVarBeginStructure.decodeNullableSerializableElement(gVar, 5, ParentFilter$$serializer.INSTANCE, parentFilter3);
                        i10 |= 32;
                    case 6:
                        metadataConfig2 = (MetadataConfig) cVarBeginStructure.decodeNullableSerializableElement(gVar, i6, MetadataConfig$$serializer.INSTANCE, metadataConfig2);
                        i10 |= 64;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i10;
            metadataConfig = metadataConfig2;
            parentFilter = parentFilter3;
            str = strDecodeStringElement;
            str2 = strDecodeStringElement4;
            str3 = str7;
            str4 = str8;
            viewPattern = viewPattern3;
        }
        cVarBeginStructure.endStructure(gVar);
        return new ParseRule(i, str, str2, str3, str4, viewPattern, parentFilter, metadataConfig, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(A9.f encoder, ParseRule value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        ParseRule.write$Self$uxsense_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public /* bridge */ /* synthetic */ b[] typeParametersSerializers() {
        return T.b;
    }
}
