package com.uxsense.search;

import A9.d;
import A9.e;
import B9.A;
import B9.F;
import B9.L;
import B9.T;
import B9.V;
import B9.d0;
import B9.h0;
import C7.c;
import C7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.serialization.UnknownFieldException;
import x9.InterfaceC2123a;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/uxsense/search/SearchIndex.$serializer", "LB9/A;", "Lcom/uxsense/search/SearchIndex;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/search/SearchIndex;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/search/SearchIndex;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class SearchIndex$$serializer implements A {
    public static final SearchIndex$$serializer INSTANCE;
    private static final g descriptor;

    static {
        SearchIndex$$serializer searchIndex$$serializer = new SearchIndex$$serializer();
        INSTANCE = searchIndex$$serializer;
        V v10 = new V("com.uxsense.search.SearchIndex", searchIndex$$serializer, 5);
        v10.j("version", true);
        v10.j("appName", false);
        v10.j("entityType", false);
        v10.j("entities", false);
        v10.j("lastUpdatedAt", true);
        descriptor = v10;
    }

    private SearchIndex$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // B9.A
    public final b[] childSerializers() {
        f[] fVarArr = SearchIndex.$childSerializers;
        return new b[]{F.f218a, h0.f242a, fVarArr[2].getF4884a(), fVarArr[3].getF4884a(), L.f223a};
    }

    @Override // x9.InterfaceC2123a
    public final SearchIndex deserialize(e decoder) {
        int iDecodeIntElement;
        int i;
        long jDecodeLongElement;
        String str;
        EntityType entityType;
        List list;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        f[] fVarArr = SearchIndex.$childSerializers;
        if (cVarBeginStructure.decodeSequentially()) {
            iDecodeIntElement = cVarBeginStructure.decodeIntElement(gVar, 0);
            String strDecodeStringElement = cVarBeginStructure.decodeStringElement(gVar, 1);
            EntityType entityType2 = (EntityType) cVarBeginStructure.decodeSerializableElement(gVar, 2, (InterfaceC2123a) fVarArr[2].getF4884a(), null);
            list = (List) cVarBeginStructure.decodeSerializableElement(gVar, 3, (InterfaceC2123a) fVarArr[3].getF4884a(), null);
            jDecodeLongElement = cVarBeginStructure.decodeLongElement(gVar, 4);
            entityType = entityType2;
            str = strDecodeStringElement;
            i = 31;
        } else {
            long jDecodeLongElement2 = 0;
            boolean z10 = true;
            iDecodeIntElement = 0;
            String strDecodeStringElement2 = null;
            EntityType entityType3 = null;
            List list2 = null;
            int i6 = 0;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    iDecodeIntElement = cVarBeginStructure.decodeIntElement(gVar, 0);
                    i6 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(gVar, 1);
                    i6 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    entityType3 = (EntityType) cVarBeginStructure.decodeSerializableElement(gVar, 2, (InterfaceC2123a) fVarArr[2].getF4884a(), entityType3);
                    i6 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    list2 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 3, (InterfaceC2123a) fVarArr[3].getF4884a(), list2);
                    i6 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(gVar, 4);
                    i6 |= 16;
                }
            }
            i = i6;
            jDecodeLongElement = jDecodeLongElement2;
            str = strDecodeStringElement2;
            entityType = entityType3;
            list = list2;
        }
        int i10 = iDecodeIntElement;
        cVarBeginStructure.endStructure(gVar);
        return new SearchIndex(i, i10, str, entityType, list, jDecodeLongElement, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(A9.f encoder, SearchIndex value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        SearchIndex.write$Self$uxsense_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public /* bridge */ /* synthetic */ b[] typeParametersSerializers() {
        return T.b;
    }
}
