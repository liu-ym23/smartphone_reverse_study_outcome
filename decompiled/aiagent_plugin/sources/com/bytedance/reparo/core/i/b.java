package com.bytedance.reparo.core.i;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: CollectionUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static <E> String a(Collection<E> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return "[]";
    L5:
        if (r4.size() == 0) goto L24;
        StringBuilder r0 = new StringBuilder();
        r0.append("[\n");
        Iterator<E> r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L14;
        E r1 = r5.next();
        if (r5.hasNext() == true) goto L12;
        r0.append(r1.toString()).append("\n");
        goto L9
    L12:
        r0.append(r1.toString()).append(", \n");
        goto L9
    L14:
        r0.append("]");
        return r0.toString();
    L24:
        return "[]";
    }
}
