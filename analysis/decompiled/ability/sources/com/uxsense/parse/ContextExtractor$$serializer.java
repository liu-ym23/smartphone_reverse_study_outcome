package com.uxsense.parse;

import A9.d;
import A9.e;
import B9.A;
import B9.T;
import B9.V;
import B9.d0;
import C7.c;
import C7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.core.pattern.ViewPattern;
import g1.AbstractC1451a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.serialization.UnknownFieldException;
import x9.InterfaceC2123a;
import z9.g;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/uxsense/parse/ContextExtractor.$serializer", "LB9/A;", "Lcom/uxsense/parse/ContextExtractor;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/parse/ContextExtractor;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/parse/ContextExtractor;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class ContextExtractor$$serializer implements A {
    public static final ContextExtractor$$serializer INSTANCE;
    private static final g descriptor;

    static {
        ContextExtractor$$serializer contextExtractor$$serializer = new ContextExtractor$$serializer();
        INSTANCE = contextExtractor$$serializer;
        V v10 = new V("com.uxsense.parse.ContextExtractor", contextExtractor$$serializer, 7);
        v10.j("pattern", false);
        v10.j("creationIdSource", true);
        v10.j("userIdSource", true);
        v10.j("chatIdSource", true);
        v10.j("senderIdSource", true);
        v10.j("rootCommentIdSource", true);
        v10.j("fieldMapping", true);
        descriptor = v10;
    }

    private ContextExtractor$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // B9.A
    public final x9.b[] childSerializers() {
        f[] fVarArr = ContextExtractor.$childSerializers;
        return new x9.b[]{fVarArr[0].getF4884a(), AbstractC1451a.G((x9.b) fVarArr[1].getF4884a()), AbstractC1451a.G((x9.b) fVarArr[2].getF4884a()), AbstractC1451a.G((x9.b) fVarArr[3].getF4884a()), AbstractC1451a.G((x9.b) fVarArr[4].getF4884a()), AbstractC1451a.G((x9.b) fVarArr[5].getF4884a()), fVarArr[6].getF4884a()};
    }

    @Override // x9.InterfaceC2123a
    public final ContextExtractor deserialize(e decoder) {
        int i;
        Map map;
        IdSource idSource;
        ViewPattern viewPattern;
        IdSource idSource2;
        IdSource idSource3;
        IdSource idSource4;
        IdSource idSource5;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        f[] fVarArr = ContextExtractor.$childSerializers;
        int i6 = 6;
        int i10 = 2;
        ViewPattern viewPattern2 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            ViewPattern viewPattern3 = (ViewPattern) cVarBeginStructure.decodeSerializableElement(gVar, 0, (InterfaceC2123a) fVarArr[0].getF4884a(), null);
            IdSource idSource6 = (IdSource) cVarBeginStructure.decodeNullableSerializableElement(gVar, 1, (InterfaceC2123a) fVarArr[1].getF4884a(), null);
            IdSource idSource7 = (IdSource) cVarBeginStructure.decodeNullableSerializableElement(gVar, 2, (InterfaceC2123a) fVarArr[2].getF4884a(), null);
            IdSource idSource8 = (IdSource) cVarBeginStructure.decodeNullableSerializableElement(gVar, 3, (InterfaceC2123a) fVarArr[3].getF4884a(), null);
            IdSource idSource9 = (IdSource) cVarBeginStructure.decodeNullableSerializableElement(gVar, 4, (InterfaceC2123a) fVarArr[4].getF4884a(), null);
            IdSource idSource10 = (IdSource) cVarBeginStructure.decodeNullableSerializableElement(gVar, 5, (InterfaceC2123a) fVarArr[5].getF4884a(), null);
            map = (Map) cVarBeginStructure.decodeSerializableElement(gVar, 6, (InterfaceC2123a) fVarArr[6].getF4884a(), null);
            viewPattern = viewPattern3;
            i = 127;
            idSource = idSource10;
            idSource4 = idSource8;
            idSource5 = idSource9;
            idSource3 = idSource7;
            idSource2 = idSource6;
        } else {
            int i11 = 1;
            boolean z10 = true;
            int i12 = 0;
            Map map2 = null;
            IdSource idSource11 = null;
            IdSource idSource12 = null;
            IdSource idSource13 = null;
            IdSource idSource14 = null;
            IdSource idSource15 = null;
            while (z10) {
                int i13 = i10;
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                switch (iDecodeElementIndex) {
                    case -1:
                        z10 = false;
                        i11 = 1;
                        i6 = 6;
                        i10 = 2;
                    case 0:
                        viewPattern2 = (ViewPattern) cVarBeginStructure.decodeSerializableElement(gVar, 0, (InterfaceC2123a) fVarArr[0].getF4884a(), viewPattern2);
                        i12 |= 1;
                        i11 = 1;
                        i6 = 6;
                        i10 = 2;
                    case 1:
                        idSource12 = (IdSource) cVarBeginStructure.decodeNullableSerializableElement(gVar, i11, (InterfaceC2123a) fVarArr[i11].getF4884a(), idSource12);
                        i12 |= 2;
                        i6 = 6;
                        i10 = 2;
                    case 2:
                        idSource13 = (IdSource) cVarBeginStructure.decodeNullableSerializableElement(gVar, i13, (InterfaceC2123a) fVarArr[i13].getF4884a(), idSource13);
                        i12 |= 4;
                        i10 = i13;
                        i6 = 6;
                    case 3:
                        idSource14 = (IdSource) cVarBeginStructure.decodeNullableSerializableElement(gVar, 3, (InterfaceC2123a) fVarArr[3].getF4884a(), idSource14);
                        i12 |= 8;
                        i10 = i13;
                    case 4:
                        idSource15 = (IdSource) cVarBeginStructure.decodeNullableSerializableElement(gVar, 4, (InterfaceC2123a) fVarArr[4].getF4884a(), idSource15);
                        i12 |= 16;
                        i10 = i13;
                    case 5:
                        idSource11 = (IdSource) cVarBeginStructure.decodeNullableSerializableElement(gVar, 5, (InterfaceC2123a) fVarArr[5].getF4884a(), idSource11);
                        i12 |= 32;
                        i10 = i13;
                    case 6:
                        map2 = (Map) cVarBeginStructure.decodeSerializableElement(gVar, i6, (InterfaceC2123a) fVarArr[i6].getF4884a(), map2);
                        i12 |= 64;
                        i10 = i13;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i12;
            map = map2;
            idSource = idSource11;
            viewPattern = viewPattern2;
            idSource2 = idSource12;
            idSource3 = idSource13;
            idSource4 = idSource14;
            idSource5 = idSource15;
        }
        cVarBeginStructure.endStructure(gVar);
        return new ContextExtractor(i, viewPattern, idSource2, idSource3, idSource4, idSource5, idSource, map, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(A9.f encoder, ContextExtractor value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        ContextExtractor.write$Self$uxsense_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public /* bridge */ /* synthetic */ x9.b[] typeParametersSerializers() {
        return T.b;
    }
}
