package com.bytedance.common.utility.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;

/* JADX INFO: compiled from: CollectionUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static <T> boolean a(Collection<T> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L8:
        return true;
    L5:
        if (r3.isEmpty() == true) goto L8;
        return false;
    }
}
