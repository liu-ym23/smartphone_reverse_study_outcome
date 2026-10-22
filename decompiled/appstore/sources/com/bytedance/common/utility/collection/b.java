package com.bytedance.common.utility.collection;

import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static boolean a(Collection r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (r10.isEmpty() == true) goto L7;
        return false;
    }
}
