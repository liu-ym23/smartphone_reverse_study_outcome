package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: _Maps.kt */
/* JADX INFO: loaded from: classes4.dex */
class at extends as {
    public static final <K, V> List<d.m<K, V>> g(Map<? extends K, ? extends V> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        if (r6.size() == 0) goto L5;
        Iterator<Map.Entry<K, V>> r0 = r6.entrySet().iterator();
        if (r0.hasNext() == false) goto L9;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r0.hasNext() == false) goto L13;
        ArrayList r3 = new ArrayList(r6.size());
        r3.add(new d.m(r2.getKey(), r2.getValue()));
    L15:
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r3.add(new d.m(r7.getKey(), r7.getValue()));
        if (r0.hasNext() == true) goto L15;
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
    L13:
        return p.a(new d.m(r2.getKey(), r2.getValue()));
    L9:
        return p.b();
    L5:
        return p.b();
    }
}
