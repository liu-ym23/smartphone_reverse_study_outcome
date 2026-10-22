package com.android.ttcjpaysdk.base.paymentbasis.common;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayException extends Exception {
    private static final long serialVersionUID = 2553530176596096710L;
    private int mErrResId;

    public int getErrResId() {
        return this.mErrResId;
    }

    public CJPayException(int r100) {
        this.mErrResId = r100;
    }
}
