package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: GroupingJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
class ag {
    public static final <T, K> Map<K, Integer> a(ae<T, ? extends K> r7) {
        ae r8 = (ae) ZeusTransformUtils.wrapperContextForParams(r7, ae.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "<this>");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator<T> r2 = r8.a();
    L4:
        if (r2.hasNext() == false) goto L14;
        Object r3 = r8.a(r2.next());
        Object r4 = r0.get(r3);
        if (r4 == null) goto L8;
    L10:
        boolean r6 = false;
    L11:
        if (r6 == false) goto L13;
        r4 = new d.h.b.z.d();
    L13:
        d.h.b.z.d r5 = (d.h.b.z.d) ZeusTransformUtils.preCheckCast(r4, d.h.b.z.d.class, "com.obric.aiagent.plugin");
        r5.f38502a++;
        r0.put(r3, r5);
        goto L4
    L8:
        if (r0.containsKey(r3) == true) goto L10;
        r6 = true;
        goto L11
    L14:
        Iterator<T> r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r0.entrySet(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L16:
        if (r9.hasNext() == false) goto L19;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r10, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace>");
        d.h.b.ae.l(r10).setValue(Integer.valueOf(((d.h.b.z.d) ZeusTransformUtils.preCheckCast(r10.getValue(), d.h.b.z.d.class, "com.obric.aiagent.plugin")).f38502a));
        goto L16
    L19:
        return d.h.b.ae.j(r0);
    }
}
