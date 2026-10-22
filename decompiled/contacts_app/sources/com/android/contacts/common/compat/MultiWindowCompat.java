package com.android.contacts.common.compat;

import android.app.Activity;

/* JADX INFO: loaded from: classes.dex */
public class MultiWindowCompat {
    public MultiWindowCompat() {
    }

    public static boolean isInMultiWindowMode(Activity r1) {
        if (CompatUtils.isNCompatible() == true) goto L7;
        return false;
    L7:
        return r1.isInMultiWindowMode();
    }
}
