package com.ttnet.org.chromium.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class CollectionUtil {
    private CollectionUtil() {
    }

    public static int[] a(List<Integer> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        int[] r0 = new int[r6.size()];
        int r2 = 0;
    L4:
        if (r2 >= r6.size()) goto L6;
        r0[r2] = ((Integer) ZeusTransformUtils.preCheckCast(r6.get(r2), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }
}
