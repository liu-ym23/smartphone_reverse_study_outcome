package com.android.server.usb;

import android.util.ArraySet;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbDataSignalDisableRequesters {
    final ArraySet<Integer> mExternalUids;
    final ArraySet<Integer> mInternalReasons;

    public UsbDataSignalDisableRequesters() {
        this.mExternalUids = new ArraySet();
        this.mInternalReasons = new ArraySet();
    }

    public boolean isEmpty() {
        if (this.mExternalUids.isEmpty() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mInternalReasons.isEmpty() == false) goto L7;
        return true;
    }
}
