package com.android.server;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class BundleUtils {
    private BundleUtils() {
    }

    public static boolean isEmpty(Bundle in) {
        if (in != null) goto L4;
    L7:
        return true;
    L4:
        if (in.size() == 0) goto L7;
        return false;
    }

    public static Bundle clone(Bundle in) {
        if (in == null) goto L5;
        Bundle r0 = new Bundle(in);
    L6:
        return r0;
    L5:
        r0 = new Bundle();
        goto L6
    }
}
