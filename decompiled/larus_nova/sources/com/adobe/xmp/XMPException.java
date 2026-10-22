package com.adobe.xmp;

/* JADX INFO: loaded from: classes28.dex */
public class XMPException extends Exception {
    private int errorCode;

    public XMPException(String r100, int r101) {
        super(r100);
        this.errorCode = r101;
    }

    public XMPException(String r100, int r101, Throwable r102) {
        super(r100, r102);
        this.errorCode = r101;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
