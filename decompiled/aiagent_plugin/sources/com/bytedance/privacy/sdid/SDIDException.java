package com.bytedance.privacy.sdid;

/* JADX INFO: loaded from: classes.dex */
public class SDIDException extends Exception {
    private String errMsg;
    private int errorCode;

    public SDIDException(int r1, String r2) {
        super(r2);
        this.errorCode = r1;
        this.errMsg = r2;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "SDIDException{errCode=" + this.errorCode + ", errMsg=" + this.errMsg + "}";
    }
}
