package x9;

import A6.i;
import B9.AbstractC0175b;
import D7.q;
import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import z9.g;

/* loaded from: classes4.dex */
public final class e extends AbstractC0175b {

    /* renamed from: a, reason: collision with root package name */
    public final Z7.d f6885a;
    public final List b;
    public final Object c;
    public final Map d;
    public final LinkedHashMap e;

    public e(String str, Z7.d baseClass, Z7.d[] dVarArr, b[] bVarArr, Annotation[] annotationArr) {
        k.f(baseClass, "baseClass");
        this.f6885a = baseClass;
        this.b = EmptyList.f4893a;
        this.c = kotlin.a.b(LazyThreadSafetyMode.b, new i(21, str, this));
        if (dVarArr.length != bVarArr.length) {
            throw new IllegalArgumentException("All subclasses of sealed class " + baseClass.m() + " should be marked @Serializable");
        }
        Map mapX = kotlin.collections.a.X(q.L0(dVarArr, bVarArr));
        this.d = mapX;
        Set<Map.Entry> setEntrySet = mapX.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : setEntrySet) {
            String strH = ((b) entry.getValue()).getDescriptor().h();
            Object obj = linkedHashMap.get(strH);
            if (obj == null) {
                linkedHashMap.containsKey(strH);
            }
            Map.Entry entry2 = (Map.Entry) obj;
            if (entry2 != null) {
                throw new IllegalStateException(("Multiple sealed subclasses of '" + this.f6885a + "' have the same serial name '" + strH + "': '" + entry2.getKey() + "', '" + entry.getKey() + '\'').toString());
            }
            linkedHashMap.put(strH, entry);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(kotlin.collections.a.P(linkedHashMap.size()));
        for (Map.Entry entry3 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry3.getKey(), (b) ((Map.Entry) entry3.getValue()).getValue());
        }
        this.e = linkedHashMap2;
        this.b = q.L(annotationArr);
    }

    @Override // B9.AbstractC0175b
    public final InterfaceC2123a a(A9.c cVar, String str) {
        b bVar = (b) this.e.get(str);
        return bVar != null ? bVar : super.a(cVar, str);
    }

    @Override // B9.AbstractC0175b
    public final f b(A9.f fVar, Object value) {
        k.f(value, "value");
        b bVar = (b) this.d.get(m.f4928a.b(value.getClass()));
        b bVarB = bVar != null ? bVar : super.b(fVar, value);
        if (bVarB != null) {
            return bVarB;
        }
        return null;
    }

    @Override // B9.AbstractC0175b
    public final Z7.d c() {
        return this.f6885a;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return (g) this.c.getF4884a();
    }
}
