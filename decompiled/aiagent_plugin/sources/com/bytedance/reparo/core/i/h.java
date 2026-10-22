package com.bytedance.reparo.core.i;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PredicateUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class h {
    public static <T> T a(List<T> r2, g<T> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        T r0 = (T) r6.next();
        if (r5.a(r0) == false) goto L4;
        return r0;
    L8:
        return null;
    }
}
