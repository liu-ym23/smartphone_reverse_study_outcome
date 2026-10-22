package com.android.ttcjpaysdk.base.network;

/* JADX INFO: loaded from: classes28.dex */
public class Canceler {
    private CancelAble mCancelAble;

    public void cancel() {
        CancelAble r100 = this.mCancelAble;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    public Canceler() {
        this.mCancelAble = null;
    }
}
