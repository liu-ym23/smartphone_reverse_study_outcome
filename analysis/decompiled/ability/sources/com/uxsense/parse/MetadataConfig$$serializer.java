package com.uxsense.parse;

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
import com.uxsense.base.metadata.CreationType;
import com.uxsense.search.MatchMode;
import g1.AbstractC1451a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.serialization.UnknownFieldException;
import x9.InterfaceC2123a;
import z9.g;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/uxsense/parse/MetadataConfig.$serializer", "LB9/A;", "Lcom/uxsense/parse/MetadataConfig;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/parse/MetadataConfig;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/parse/MetadataConfig;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class MetadataConfig$$serializer implements A {
    public static final MetadataConfig$$serializer INSTANCE;
    private static final g descriptor;

    static {
        MetadataConfig$$serializer metadataConfig$$serializer = new MetadataConfig$$serializer();
        INSTANCE = metadataConfig$$serializer;
        V v10 = new V("com.uxsense.parse.MetadataConfig", metadataConfig$$serializer, 9);
        v10.j("type", false);
        v10.j("fieldMapping", true);
        v10.j("idSource", true);
        v10.j("userIdSource", true);
        v10.j("customHandler", true);
        v10.j("creationType", true);
        v10.j("deduplicateStrategy", true);
        v10.j("matchMode", true);
        v10.j("contextExtractor", true);
        descriptor = v10;
    }

    private MetadataConfig$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // B9.A
    public final x9.b[] childSerializers() {
        f[] fVarArr = MetadataConfig.$childSerializers;
        return new x9.b[]{fVarArr[0].getF4884a(), fVarArr[1].getF4884a(), fVarArr[2].getF4884a(), fVarArr[3].getF4884a(), AbstractC1451a.G(h0.f242a), fVarArr[5].getF4884a(), fVarArr[6].getF4884a(), fVarArr[7].getF4884a(), AbstractC1451a.G(ContextExtractor$$serializer.INSTANCE)};
    }

    @Override // x9.InterfaceC2123a
    public final MetadataConfig deserialize(e decoder) {
        int i;
        MatchMode matchMode;
        ContextExtractor contextExtractor;
        DeduplicateStrategy deduplicateStrategy;
        CreationType creationType;
        String str;
        IdSource idSource;
        MetadataType metadataType;
        Map map;
        IdSource idSource2;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        f[] fVarArr = MetadataConfig.$childSerializers;
        int i6 = 8;
        int i10 = 6;
        MetadataType metadataType2 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            MetadataType metadataType3 = (MetadataType) cVarBeginStructure.decodeSerializableElement(gVar, 0, (InterfaceC2123a) fVarArr[0].getF4884a(), null);
            Map map2 = (Map) cVarBeginStructure.decodeSerializableElement(gVar, 1, (InterfaceC2123a) fVarArr[1].getF4884a(), null);
            IdSource idSource3 = (IdSource) cVarBeginStructure.decodeSerializableElement(gVar, 2, (InterfaceC2123a) fVarArr[2].getF4884a(), null);
            IdSource idSource4 = (IdSource) cVarBeginStructure.decodeSerializableElement(gVar, 3, (InterfaceC2123a) fVarArr[3].getF4884a(), null);
            String str2 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 4, h0.f242a, null);
            CreationType creationType2 = (CreationType) cVarBeginStructure.decodeSerializableElement(gVar, 5, (InterfaceC2123a) fVarArr[5].getF4884a(), null);
            DeduplicateStrategy deduplicateStrategy2 = (DeduplicateStrategy) cVarBeginStructure.decodeSerializableElement(gVar, 6, (InterfaceC2123a) fVarArr[6].getF4884a(), null);
            matchMode = (MatchMode) cVarBeginStructure.decodeSerializableElement(gVar, 7, (InterfaceC2123a) fVarArr[7].getF4884a(), null);
            metadataType = metadataType3;
            contextExtractor = (ContextExtractor) cVarBeginStructure.decodeNullableSerializableElement(gVar, 8, ContextExtractor$$serializer.INSTANCE, null);
            str = str2;
            i = 511;
            deduplicateStrategy = deduplicateStrategy2;
            creationType = creationType2;
            idSource = idSource4;
            idSource2 = idSource3;
            map = map2;
        } else {
            int i11 = 5;
            int i12 = 3;
            int i13 = 2;
            int i14 = 1;
            boolean z10 = true;
            int i15 = 0;
            MatchMode matchMode2 = null;
            ContextExtractor contextExtractor2 = null;
            DeduplicateStrategy deduplicateStrategy3 = null;
            CreationType creationType3 = null;
            String str3 = null;
            IdSource idSource5 = null;
            Map map3 = null;
            IdSource idSource6 = null;
            while (z10) {
                int i16 = i10;
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                switch (iDecodeElementIndex) {
                    case -1:
                        z10 = false;
                        i14 = 1;
                        i6 = 8;
                        i10 = 6;
                        i13 = 2;
                        i12 = 3;
                        i11 = 5;
                    case 0:
                        metadataType2 = (MetadataType) cVarBeginStructure.decodeSerializableElement(gVar, 0, (InterfaceC2123a) fVarArr[0].getF4884a(), metadataType2);
                        i15 |= 1;
                        i14 = 1;
                        i6 = 8;
                        i10 = 6;
                        i13 = 2;
                        i12 = 3;
                        i11 = 5;
                    case 1:
                        map3 = (Map) cVarBeginStructure.decodeSerializableElement(gVar, i14, (InterfaceC2123a) fVarArr[i14].getF4884a(), map3);
                        i15 |= 2;
                        i6 = 8;
                        i10 = 6;
                        i13 = 2;
                        i12 = 3;
                        i11 = 5;
                    case 2:
                        idSource6 = (IdSource) cVarBeginStructure.decodeSerializableElement(gVar, i13, (InterfaceC2123a) fVarArr[i13].getF4884a(), idSource6);
                        i15 |= 4;
                        i6 = 8;
                        i10 = 6;
                        i12 = 3;
                        i11 = 5;
                    case 3:
                        idSource5 = (IdSource) cVarBeginStructure.decodeSerializableElement(gVar, i12, (InterfaceC2123a) fVarArr[i12].getF4884a(), idSource5);
                        i15 |= 8;
                        i6 = 8;
                        i10 = 6;
                        i11 = 5;
                    case 4:
                        str3 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 4, h0.f242a, str3);
                        i15 |= 16;
                        i6 = 8;
                        i10 = 6;
                        i11 = 5;
                    case 5:
                        creationType3 = (CreationType) cVarBeginStructure.decodeSerializableElement(gVar, i11, (InterfaceC2123a) fVarArr[i11].getF4884a(), creationType3);
                        i15 |= 32;
                        i6 = 8;
                        i10 = 6;
                    case 6:
                        deduplicateStrategy3 = (DeduplicateStrategy) cVarBeginStructure.decodeSerializableElement(gVar, i16, (InterfaceC2123a) fVarArr[i16].getF4884a(), deduplicateStrategy3);
                        i15 |= 64;
                        i10 = i16;
                        i6 = 8;
                    case 7:
                        matchMode2 = (MatchMode) cVarBeginStructure.decodeSerializableElement(gVar, 7, (InterfaceC2123a) fVarArr[7].getF4884a(), matchMode2);
                        i15 |= 128;
                        i10 = i16;
                    case 8:
                        contextExtractor2 = (ContextExtractor) cVarBeginStructure.decodeNullableSerializableElement(gVar, i6, ContextExtractor$$serializer.INSTANCE, contextExtractor2);
                        i15 |= 256;
                        i10 = i16;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i15;
            matchMode = matchMode2;
            contextExtractor = contextExtractor2;
            deduplicateStrategy = deduplicateStrategy3;
            creationType = creationType3;
            str = str3;
            idSource = idSource5;
            metadataType = metadataType2;
            map = map3;
            idSource2 = idSource6;
        }
        cVarBeginStructure.endStructure(gVar);
        return new MetadataConfig(i, metadataType, map, idSource2, idSource, str, creationType, deduplicateStrategy, matchMode, contextExtractor, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(A9.f encoder, MetadataConfig value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        MetadataConfig.write$Self$uxsense_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public /* bridge */ /* synthetic */ x9.b[] typeParametersSerializers() {
        return T.b;
    }
}
