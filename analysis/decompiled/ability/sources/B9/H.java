package B9;

import g1.AbstractC1451a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class H extends AbstractC0174a {

    /* renamed from: a, reason: collision with root package name */
    public final x9.b f220a;
    public final x9.b b;
    public final G c;

    public H(x9.b kSerializer, x9.b vSerializer) {
        kotlin.jvm.internal.k.f(kSerializer, "kSerializer");
        kotlin.jvm.internal.k.f(vSerializer, "vSerializer");
        this.f220a = kSerializer;
        this.b = vSerializer;
        z9.g keyDesc = kSerializer.getDescriptor();
        z9.g valueDesc = vSerializer.getDescriptor();
        kotlin.jvm.internal.k.f(keyDesc, "keyDesc");
        kotlin.jvm.internal.k.f(valueDesc, "valueDesc");
        this.c = new G("kotlin.collections.LinkedHashMap", keyDesc, valueDesc);
    }

    @Override // B9.AbstractC0174a
    public final Object a() {
        return new LinkedHashMap();
    }

    @Override // B9.AbstractC0174a
    public final int b(Object obj) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) obj;
        kotlin.jvm.internal.k.f(linkedHashMap, "<this>");
        return linkedHashMap.size() * 2;
    }

    @Override // B9.AbstractC0174a
    public final void c(int i, Object obj) {
        kotlin.jvm.internal.k.f((LinkedHashMap) obj, "<this>");
    }

    @Override // B9.AbstractC0174a
    public final Iterator d(Object obj) {
        Map map = (Map) obj;
        kotlin.jvm.internal.k.f(map, "<this>");
        return map.entrySet().iterator();
    }

    @Override // B9.AbstractC0174a
    public final int e(Object obj) {
        Map map = (Map) obj;
        kotlin.jvm.internal.k.f(map, "<this>");
        return map.size();
    }

    @Override // B9.AbstractC0174a
    public final void g(A9.c cVar, Object obj, int i, int i6) {
        Map builder = (Map) obj;
        kotlin.jvm.internal.k.f(builder, "builder");
        if (i6 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
        Y7.d dVarU = AbstractC1451a.U(AbstractC1451a.X(0, i6 * 2), 2);
        int i10 = dVarU.f1569a;
        int i11 = dVarU.b;
        int i12 = dVarU.c;
        if ((i12 <= 0 || i10 > i11) && (i12 >= 0 || i11 > i10)) {
            return;
        }
        while (true) {
            k(cVar, i + i10, builder, false);
            if (i10 == i11) {
                return;
            } else {
                i10 += i12;
            }
        }
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return this.c;
    }

    @Override // B9.AbstractC0174a
    public final /* bridge */ /* synthetic */ void h(A9.c cVar, int i, Object obj) {
        k(cVar, i, (Map) obj, true);
    }

    @Override // B9.AbstractC0174a
    public final Object i(Object obj) {
        kotlin.jvm.internal.k.f(null, "<this>");
        return new LinkedHashMap((Map) null);
    }

    @Override // B9.AbstractC0174a
    public final Object j(Object obj) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) obj;
        kotlin.jvm.internal.k.f(linkedHashMap, "<this>");
        return linkedHashMap;
    }

    public final void k(A9.c cVar, int i, Map builder, boolean z10) {
        int iDecodeElementIndex;
        kotlin.jvm.internal.k.f(builder, "builder");
        Object objDecodeSerializableElement = cVar.decodeSerializableElement(getDescriptor(), i, this.f220a, null);
        if (z10) {
            iDecodeElementIndex = cVar.decodeElementIndex(getDescriptor());
            if (iDecodeElementIndex != i + 1) {
                throw new IllegalArgumentException(androidx.compose.foundation.b.n(i, iDecodeElementIndex, "Value must follow key in a map, index for key: ", ", returned index for value: ").toString());
            }
        } else {
            iDecodeElementIndex = i + 1;
        }
        boolean zContainsKey = builder.containsKey(objDecodeSerializableElement);
        x9.b bVar = this.b;
        builder.put(objDecodeSerializableElement, (!zContainsKey || (bVar.getDescriptor().getKind() instanceof z9.f)) ? cVar.decodeSerializableElement(getDescriptor(), iDecodeElementIndex, bVar, null) : cVar.decodeSerializableElement(getDescriptor(), iDecodeElementIndex, bVar, kotlin.collections.a.N(objDecodeSerializableElement, builder)));
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        int iE = e(obj);
        z9.g descriptor = getDescriptor();
        A9.d dVarBeginCollection = fVar.beginCollection(descriptor, iE);
        Iterator itD = d(obj);
        int i = 0;
        while (itD.hasNext()) {
            Map.Entry entry = (Map.Entry) itD.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i6 = i + 1;
            dVarBeginCollection.encodeSerializableElement(getDescriptor(), i, this.f220a, key);
            i += 2;
            dVarBeginCollection.encodeSerializableElement(getDescriptor(), i6, this.b, value);
        }
        dVarBeginCollection.endStructure(descriptor);
    }
}
