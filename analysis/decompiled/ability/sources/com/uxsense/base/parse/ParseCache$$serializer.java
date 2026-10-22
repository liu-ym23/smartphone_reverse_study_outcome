package com.uxsense.base.parse;

import A9.d;
import A9.e;
import A9.f;
import B9.A;
import B9.C0180g;
import B9.F;
import B9.L;
import B9.T;
import B9.V;
import B9.h0;
import C7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.core.base.parse.KViewNode;
import com.uxsense.core.base.parse.KViewNode$$serializer;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.serialization.UnknownFieldException;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/uxsense/base/parse/ParseCache.$serializer", "LB9/A;", "Lcom/uxsense/base/parse/ParseCache;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/base/parse/ParseCache;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/base/parse/ParseCache;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class ParseCache$$serializer implements A {
    public static final ParseCache$$serializer INSTANCE;
    private static final g descriptor;

    static {
        ParseCache$$serializer parseCache$$serializer = new ParseCache$$serializer();
        INSTANCE = parseCache$$serializer;
        V v10 = new V("com.uxsense.base.parse.ParseCache", parseCache$$serializer, 14);
        v10.j("packageName", false);
        v10.j("androidUserId", false);
        v10.j("nickname", true);
        v10.j("uuid", true);
        v10.j("userId", true);
        v10.j("activity", false);
        v10.j("windowTitle", false);
        v10.j("root", true);
        v10.j("autoSave", true);
        v10.j("screenshotPath", true);
        v10.j("creationId", true);
        v10.j("chatId", true);
        v10.j("senderId", true);
        v10.j("rootCommentId", true);
        descriptor = v10;
    }

    private ParseCache$$serializer() {
    }

    @Override // B9.A
    public final b[] childSerializers() {
        h0 h0Var = h0.f242a;
        b bVarG = AbstractC1451a.G(h0Var);
        b bVarG2 = AbstractC1451a.G(h0Var);
        L l = L.f223a;
        return new b[]{h0Var, F.f218a, bVarG, bVarG2, AbstractC1451a.G(l), h0Var, h0Var, AbstractC1451a.G(KViewNode$$serializer.INSTANCE), C0180g.f239a, AbstractC1451a.G(h0Var), AbstractC1451a.G(l), AbstractC1451a.G(l), AbstractC1451a.G(l), AbstractC1451a.G(l)};
    }

    @Override // x9.InterfaceC2123a
    public final ParseCache deserialize(e decoder) {
        int i;
        int i6;
        String str;
        String str2;
        String str3;
        Long l;
        Long l5;
        Long l9;
        String str4;
        Long l10;
        KViewNode kViewNode;
        Long l11;
        String str5;
        String str6;
        boolean z10;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        if (cVarBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = cVarBeginStructure.decodeStringElement(gVar, 0);
            int iDecodeIntElement = cVarBeginStructure.decodeIntElement(gVar, 1);
            h0 h0Var = h0.f242a;
            String str7 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 2, h0Var, null);
            String str8 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 3, h0Var, null);
            L l12 = L.f223a;
            Long l13 = (Long) cVarBeginStructure.decodeNullableSerializableElement(gVar, 4, l12, null);
            String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(gVar, 5);
            String strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(gVar, 6);
            KViewNode kViewNode2 = (KViewNode) cVarBeginStructure.decodeNullableSerializableElement(gVar, 7, KViewNode$$serializer.INSTANCE, null);
            boolean zDecodeBooleanElement = cVarBeginStructure.decodeBooleanElement(gVar, 8);
            String str9 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 9, h0Var, null);
            Long l14 = (Long) cVarBeginStructure.decodeNullableSerializableElement(gVar, 10, l12, null);
            Long l15 = (Long) cVarBeginStructure.decodeNullableSerializableElement(gVar, 11, l12, null);
            i = 16383;
            l5 = (Long) cVarBeginStructure.decodeNullableSerializableElement(gVar, 12, l12, null);
            l = (Long) cVarBeginStructure.decodeNullableSerializableElement(gVar, 13, l12, null);
            i6 = iDecodeIntElement;
            kViewNode = kViewNode2;
            str4 = str9;
            z10 = zDecodeBooleanElement;
            str6 = strDecodeStringElement3;
            str5 = strDecodeStringElement2;
            str = str8;
            l10 = l14;
            l11 = l13;
            str3 = str7;
            l9 = l15;
            str2 = strDecodeStringElement;
        } else {
            int iDecodeIntElement2 = 0;
            boolean zDecodeBooleanElement2 = false;
            String strDecodeStringElement4 = null;
            String str10 = null;
            Long l16 = null;
            Long l17 = null;
            Long l18 = null;
            String str11 = null;
            Long l19 = null;
            KViewNode kViewNode3 = null;
            String strDecodeStringElement5 = null;
            String strDecodeStringElement6 = null;
            boolean z11 = true;
            i = 0;
            String str12 = null;
            Long l20 = null;
            while (z11) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                switch (iDecodeElementIndex) {
                    case -1:
                        z11 = false;
                    case 0:
                        i |= 1;
                        strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(gVar, 0);
                    case 1:
                        iDecodeIntElement2 = cVarBeginStructure.decodeIntElement(gVar, 1);
                        i |= 2;
                    case 2:
                        str10 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 2, h0.f242a, str10);
                        i |= 4;
                    case 3:
                        str12 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 3, h0.f242a, str12);
                        i |= 8;
                    case 4:
                        l20 = (Long) cVarBeginStructure.decodeNullableSerializableElement(gVar, 4, L.f223a, l20);
                        i |= 16;
                    case 5:
                        strDecodeStringElement5 = cVarBeginStructure.decodeStringElement(gVar, 5);
                        i |= 32;
                    case 6:
                        strDecodeStringElement6 = cVarBeginStructure.decodeStringElement(gVar, 6);
                        i |= 64;
                    case 7:
                        kViewNode3 = (KViewNode) cVarBeginStructure.decodeNullableSerializableElement(gVar, 7, KViewNode$$serializer.INSTANCE, kViewNode3);
                        i |= 128;
                    case 8:
                        zDecodeBooleanElement2 = cVarBeginStructure.decodeBooleanElement(gVar, 8);
                        i |= 256;
                    case 9:
                        str11 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 9, h0.f242a, str11);
                        i |= 512;
                    case 10:
                        l19 = (Long) cVarBeginStructure.decodeNullableSerializableElement(gVar, 10, L.f223a, l19);
                        i |= 1024;
                    case 11:
                        l18 = (Long) cVarBeginStructure.decodeNullableSerializableElement(gVar, 11, L.f223a, l18);
                        i |= 2048;
                    case 12:
                        l17 = (Long) cVarBeginStructure.decodeNullableSerializableElement(gVar, 12, L.f223a, l17);
                        i |= 4096;
                    case 13:
                        l16 = (Long) cVarBeginStructure.decodeNullableSerializableElement(gVar, 13, L.f223a, l16);
                        i |= 8192;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i6 = iDecodeIntElement2;
            str = str12;
            str2 = strDecodeStringElement4;
            str3 = str10;
            l = l16;
            l5 = l17;
            l9 = l18;
            str4 = str11;
            l10 = l19;
            kViewNode = kViewNode3;
            l11 = l20;
            str5 = strDecodeStringElement5;
            str6 = strDecodeStringElement6;
            z10 = zDecodeBooleanElement2;
        }
        int i10 = i;
        cVarBeginStructure.endStructure(gVar);
        return new ParseCache(i10, str2, i6, str3, str, l11, str5, str6, kViewNode, z10, str4, l10, l9, l5, l, null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(f encoder, ParseCache value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        ParseCache.write$Self$uxsense_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public /* bridge */ /* synthetic */ b[] typeParametersSerializers() {
        return T.b;
    }
}
