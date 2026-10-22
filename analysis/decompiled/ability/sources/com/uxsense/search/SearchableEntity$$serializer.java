package com.uxsense.search;

import A9.d;
import A9.e;
import B9.A;
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

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/uxsense/search/SearchableEntity.$serializer", "LB9/A;", "Lcom/uxsense/search/SearchableEntity;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/search/SearchableEntity;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/search/SearchableEntity;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class SearchableEntity$$serializer implements A {
    public static final SearchableEntity$$serializer INSTANCE;
    private static final g descriptor;

    static {
        SearchableEntity$$serializer searchableEntity$$serializer = new SearchableEntity$$serializer();
        INSTANCE = searchableEntity$$serializer;
        V v10 = new V("com.uxsense.search.SearchableEntity", searchableEntity$$serializer, 6);
        v10.j("entityType", false);
        v10.j("entityId", false);
        v10.j("parentId", true);
        v10.j("searchableText", false);
        v10.j("keywords", true);
        v10.j("updatedAt", true);
        descriptor = v10;
    }

    private SearchableEntity$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // B9.A
    public final b[] childSerializers() {
        f[] fVarArr = SearchableEntity.$childSerializers;
        L l = L.f223a;
        return new b[]{fVarArr[0].getF4884a(), l, l, h0.f242a, fVarArr[4].getF4884a(), l};
    }

    @Override // x9.InterfaceC2123a
    public final SearchableEntity deserialize(e decoder) {
        int i;
        List list;
        EntityType entityType;
        long jDecodeLongElement;
        long j5;
        String str;
        long j6;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        f[] fVarArr = SearchableEntity.$childSerializers;
        int i6 = 5;
        int i10 = 3;
        EntityType entityType2 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            EntityType entityType3 = (EntityType) cVarBeginStructure.decodeSerializableElement(gVar, 0, (InterfaceC2123a) fVarArr[0].getF4884a(), null);
            long jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(gVar, 1);
            long jDecodeLongElement3 = cVarBeginStructure.decodeLongElement(gVar, 2);
            String strDecodeStringElement = cVarBeginStructure.decodeStringElement(gVar, 3);
            list = (List) cVarBeginStructure.decodeSerializableElement(gVar, 4, (InterfaceC2123a) fVarArr[4].getF4884a(), null);
            entityType = entityType3;
            i = 63;
            str = strDecodeStringElement;
            jDecodeLongElement = cVarBeginStructure.decodeLongElement(gVar, 5);
            j5 = jDecodeLongElement2;
            j6 = jDecodeLongElement3;
        } else {
            long jDecodeLongElement4 = 0;
            boolean z10 = true;
            int i11 = 0;
            List list2 = null;
            String strDecodeStringElement2 = null;
            long jDecodeLongElement5 = 0;
            long jDecodeLongElement6 = 0;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                switch (iDecodeElementIndex) {
                    case -1:
                        z10 = false;
                        i10 = 3;
                    case 0:
                        entityType2 = (EntityType) cVarBeginStructure.decodeSerializableElement(gVar, 0, (InterfaceC2123a) fVarArr[0].getF4884a(), entityType2);
                        i11 |= 1;
                        i6 = 5;
                        i10 = 3;
                    case 1:
                        jDecodeLongElement5 = cVarBeginStructure.decodeLongElement(gVar, 1);
                        i11 |= 2;
                    case 2:
                        jDecodeLongElement6 = cVarBeginStructure.decodeLongElement(gVar, 2);
                        i11 |= 4;
                    case 3:
                        strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(gVar, i10);
                        i11 |= 8;
                    case 4:
                        list2 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 4, (InterfaceC2123a) fVarArr[4].getF4884a(), list2);
                        i11 |= 16;
                    case 5:
                        jDecodeLongElement4 = cVarBeginStructure.decodeLongElement(gVar, i6);
                        i11 |= 32;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i11;
            list = list2;
            entityType = entityType2;
            jDecodeLongElement = jDecodeLongElement4;
            j5 = jDecodeLongElement5;
            str = strDecodeStringElement2;
            j6 = jDecodeLongElement6;
        }
        cVarBeginStructure.endStructure(gVar);
        return new SearchableEntity(i, entityType, j5, j6, str, list, jDecodeLongElement, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(A9.f encoder, SearchableEntity value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        SearchableEntity.write$Self$uxsense_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public /* bridge */ /* synthetic */ b[] typeParametersSerializers() {
        return T.b;
    }
}
