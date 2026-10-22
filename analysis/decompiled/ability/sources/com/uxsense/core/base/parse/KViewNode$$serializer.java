package com.uxsense.core.base.parse;

import A9.d;
import A9.e;
import B9.A;
import B9.C0180g;
import B9.F;
import B9.L;
import B9.T;
import B9.V;
import B9.d0;
import B9.h0;
import C7.c;
import C7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.serialization.UnknownFieldException;
import x9.InterfaceC2123a;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/uxsense/core/base/parse/KViewNode.$serializer", "LB9/A;", "Lcom/uxsense/core/base/parse/KViewNode;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/core/base/parse/KViewNode;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/core/base/parse/KViewNode;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class KViewNode$$serializer implements A {
    public static final KViewNode$$serializer INSTANCE;
    private static final g descriptor;

    static {
        KViewNode$$serializer kViewNode$$serializer = new KViewNode$$serializer();
        INSTANCE = kViewNode$$serializer;
        V v10 = new V("com.uxsense.core.base.parse.KViewNode", kViewNode$$serializer, 19);
        v10.j("index", true);
        v10.j("nodeId", true);
        v10.j("className", true);
        v10.j("viewId", true);
        v10.j("bounds", true);
        v10.j("description", true);
        v10.j("text", true);
        v10.j("hint", true);
        v10.j("children", true);
        v10.j("clickable", true);
        v10.j("longClickable", true);
        v10.j("touchable", true);
        v10.j("horizontalScrollable", true);
        v10.j("verticalScrollable", true);
        v10.j("checkable", true);
        v10.j("checked", true);
        v10.j("progress", true);
        v10.j("progressMax", true);
        v10.j("progressMin", true);
        descriptor = v10;
    }

    private KViewNode$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // B9.A
    public final b[] childSerializers() {
        f[] fVarArr = KViewNode.$childSerializers;
        F f = F.f218a;
        h0 h0Var = h0.f242a;
        C0180g c0180g = C0180g.f239a;
        return new b[]{f, L.f223a, AbstractC1451a.G(h0Var), AbstractC1451a.G(h0Var), AbstractC1451a.G(KRect$$serializer.INSTANCE), AbstractC1451a.G(h0Var), AbstractC1451a.G(h0Var), AbstractC1451a.G(h0Var), fVarArr[8].getF4884a(), c0180g, c0180g, c0180g, c0180g, c0180g, c0180g, c0180g, f, f, f};
    }

    @Override // x9.InterfaceC2123a
    public final KViewNode deserialize(e decoder) {
        int i;
        KRect kRect;
        String str;
        String str2;
        String str3;
        boolean z10;
        boolean z11;
        boolean z12;
        List list;
        String str4;
        String str5;
        int i6;
        int iDecodeIntElement;
        int i10;
        boolean z13;
        long j5;
        int iDecodeIntElement2;
        boolean z14;
        boolean z15;
        boolean z16;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        f[] fVarArr = KViewNode.$childSerializers;
        int i11 = 8;
        if (cVarBeginStructure.decodeSequentially()) {
            int iDecodeIntElement3 = cVarBeginStructure.decodeIntElement(gVar, 0);
            long jDecodeLongElement = cVarBeginStructure.decodeLongElement(gVar, 1);
            h0 h0Var = h0.f242a;
            String str6 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 2, h0Var, null);
            String str7 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 3, h0Var, null);
            KRect kRect2 = (KRect) cVarBeginStructure.decodeNullableSerializableElement(gVar, 4, KRect$$serializer.INSTANCE, null);
            String str8 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 5, h0Var, null);
            String str9 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 6, h0Var, null);
            String str10 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 7, h0Var, null);
            List list2 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 8, (InterfaceC2123a) fVarArr[8].getF4884a(), null);
            boolean zDecodeBooleanElement = cVarBeginStructure.decodeBooleanElement(gVar, 9);
            boolean zDecodeBooleanElement2 = cVarBeginStructure.decodeBooleanElement(gVar, 10);
            boolean zDecodeBooleanElement3 = cVarBeginStructure.decodeBooleanElement(gVar, 11);
            boolean zDecodeBooleanElement4 = cVarBeginStructure.decodeBooleanElement(gVar, 12);
            boolean zDecodeBooleanElement5 = cVarBeginStructure.decodeBooleanElement(gVar, 13);
            boolean zDecodeBooleanElement6 = cVarBeginStructure.decodeBooleanElement(gVar, 14);
            boolean zDecodeBooleanElement7 = cVarBeginStructure.decodeBooleanElement(gVar, 15);
            int iDecodeIntElement4 = cVarBeginStructure.decodeIntElement(gVar, 16);
            iDecodeIntElement = cVarBeginStructure.decodeIntElement(gVar, 17);
            i10 = iDecodeIntElement3;
            str2 = str7;
            kRect = kRect2;
            str3 = str6;
            z13 = zDecodeBooleanElement;
            iDecodeIntElement2 = cVarBeginStructure.decodeIntElement(gVar, 18);
            i = 524287;
            z14 = zDecodeBooleanElement2;
            str4 = str10;
            str = str8;
            z15 = zDecodeBooleanElement3;
            str5 = str9;
            z16 = zDecodeBooleanElement4;
            i6 = iDecodeIntElement4;
            z12 = zDecodeBooleanElement7;
            z11 = zDecodeBooleanElement6;
            z10 = zDecodeBooleanElement5;
            list = list2;
            j5 = jDecodeLongElement;
        } else {
            int i12 = 0;
            int i13 = 18;
            int iDecodeIntElement5 = 0;
            int iDecodeIntElement6 = 0;
            int iDecodeIntElement7 = 0;
            boolean zDecodeBooleanElement8 = false;
            int iDecodeIntElement8 = 0;
            boolean zDecodeBooleanElement9 = false;
            boolean zDecodeBooleanElement10 = false;
            boolean zDecodeBooleanElement11 = false;
            boolean z17 = true;
            KRect kRect3 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            List list3 = null;
            String str14 = null;
            String str15 = null;
            long jDecodeLongElement2 = 0;
            boolean zDecodeBooleanElement12 = false;
            boolean zDecodeBooleanElement13 = false;
            boolean zDecodeBooleanElement14 = false;
            while (z17) {
                int i14 = i11;
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                switch (iDecodeElementIndex) {
                    case -1:
                        z17 = false;
                        i11 = 8;
                    case 0:
                        iDecodeIntElement7 = cVarBeginStructure.decodeIntElement(gVar, 0);
                        i12 |= 1;
                        i11 = 8;
                        i13 = 18;
                    case 1:
                        jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(gVar, 1);
                        i12 |= 2;
                        i11 = 8;
                        i13 = 18;
                    case 2:
                        str13 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 2, h0.f242a, str13);
                        i12 |= 4;
                        i11 = 8;
                        i13 = 18;
                    case 3:
                        str12 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 3, h0.f242a, str12);
                        i12 |= 8;
                        i11 = 8;
                        i13 = 18;
                    case 4:
                        kRect3 = (KRect) cVarBeginStructure.decodeNullableSerializableElement(gVar, 4, KRect$$serializer.INSTANCE, kRect3);
                        i12 |= 16;
                        i11 = 8;
                        i13 = 18;
                    case 5:
                        str11 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 5, h0.f242a, str11);
                        i12 |= 32;
                        i11 = 8;
                        i13 = 18;
                    case 6:
                        str15 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 6, h0.f242a, str15);
                        i12 |= 64;
                        i11 = 8;
                        i13 = 18;
                    case 7:
                        str14 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 7, h0.f242a, str14);
                        i12 |= 128;
                        i11 = 8;
                        i13 = 18;
                    case 8:
                        list3 = (List) cVarBeginStructure.decodeSerializableElement(gVar, i14, (InterfaceC2123a) fVarArr[i14].getF4884a(), list3);
                        i12 |= 256;
                        i11 = i14;
                        i13 = 18;
                    case 9:
                        zDecodeBooleanElement8 = cVarBeginStructure.decodeBooleanElement(gVar, 9);
                        i12 |= 512;
                        i11 = i14;
                    case 10:
                        zDecodeBooleanElement9 = cVarBeginStructure.decodeBooleanElement(gVar, 10);
                        i12 |= 1024;
                        i11 = i14;
                    case 11:
                        zDecodeBooleanElement10 = cVarBeginStructure.decodeBooleanElement(gVar, 11);
                        i12 |= 2048;
                        i11 = i14;
                    case 12:
                        zDecodeBooleanElement11 = cVarBeginStructure.decodeBooleanElement(gVar, 12);
                        i12 |= 4096;
                        i11 = i14;
                    case 13:
                        i12 |= 8192;
                        zDecodeBooleanElement12 = cVarBeginStructure.decodeBooleanElement(gVar, 13);
                        i11 = i14;
                    case 14:
                        i12 |= 16384;
                        zDecodeBooleanElement13 = cVarBeginStructure.decodeBooleanElement(gVar, 14);
                        i11 = i14;
                    case 15:
                        i12 |= 32768;
                        zDecodeBooleanElement14 = cVarBeginStructure.decodeBooleanElement(gVar, 15);
                        i11 = i14;
                    case 16:
                        iDecodeIntElement5 = cVarBeginStructure.decodeIntElement(gVar, 16);
                        i12 |= 65536;
                        i11 = i14;
                    case 17:
                        iDecodeIntElement6 = cVarBeginStructure.decodeIntElement(gVar, 17);
                        i12 |= 131072;
                        i11 = i14;
                    case 18:
                        iDecodeIntElement8 = cVarBeginStructure.decodeIntElement(gVar, i13);
                        i12 |= 262144;
                        i11 = i14;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i12;
            kRect = kRect3;
            str = str11;
            str2 = str12;
            str3 = str13;
            z10 = zDecodeBooleanElement12;
            z11 = zDecodeBooleanElement13;
            z12 = zDecodeBooleanElement14;
            list = list3;
            str4 = str14;
            str5 = str15;
            i6 = iDecodeIntElement5;
            iDecodeIntElement = iDecodeIntElement6;
            i10 = iDecodeIntElement7;
            z13 = zDecodeBooleanElement8;
            j5 = jDecodeLongElement2;
            iDecodeIntElement2 = iDecodeIntElement8;
            z14 = zDecodeBooleanElement9;
            z15 = zDecodeBooleanElement10;
            z16 = zDecodeBooleanElement11;
        }
        cVarBeginStructure.endStructure(gVar);
        return new KViewNode(i, i10, j5, str3, str2, kRect, str, str5, str4, list, z13, z14, z15, z16, z10, z11, z12, i6, iDecodeIntElement, iDecodeIntElement2, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(A9.f encoder, KViewNode value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        KViewNode.write$Self$uxsense_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public /* bridge */ /* synthetic */ b[] typeParametersSerializers() {
        return T.b;
    }
}
