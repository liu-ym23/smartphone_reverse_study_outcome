package com.monitor.cloudmessage.utils;

import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public class CollectionUtils {
    public CollectionUtils() {
    }

    public static boolean isEmpty(Collection r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.isEmpty() == true) goto L7;
        return false;
    }
}
