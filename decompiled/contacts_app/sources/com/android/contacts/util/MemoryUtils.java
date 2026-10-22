package com.android.contacts.util;

import com.android.internal.util.MemInfoReader;

/* JADX INFO: loaded from: classes2.dex */
public final class MemoryUtils {
    private static long sTotalMemorySize = -1;

    static {
    }

    private MemoryUtils() {
    }

    public static long getTotalMemorySize() {
        if (sTotalMemorySize >= 0) goto L6;
        MemInfoReader r0 = new MemInfoReader();
        r0.readMemInfo();
        sTotalMemorySize = r0.getTotalSize();
    L6:
        return sTotalMemorySize;
    }
}
