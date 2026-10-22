package com.bytedance.android.live.base.exception;

import yy.a;

/* JADX INFO: loaded from: classes45.dex */
public class ApiServerException extends ApiException implements a {
    private boolean blockNotice;
    private String mAlert;
    private String mErrorMsg;
    private String mExtra;
    private boolean mProcessed;
    private String mPrompt;

    @Override // com.bytedance.android.live.base.exception.ApiException, java.lang.Throwable
    public String getMessage() {
        return " TYPE = ApiServerException, errorMsg = " + this.mErrorMsg + " extra = " + this.mExtra + " " + super.getMessage();
    }

    public String getAlert() {
        return this.mAlert;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public boolean getProcessed() {
        return this.mProcessed;
    }

    public String getPrompt() {
        return this.mPrompt;
    }

    public boolean isBlockNotice() {
        return this.blockNotice;
    }

    public ApiServerException(int r100) {
        super(r100);
    }

    public void setAlert(String r100) {
        this.mAlert = r100;
    }

    public void setBlockNotice(boolean r100) {
        this.blockNotice = r100;
    }

    public void setErrorMsg(String r100) {
        this.mErrorMsg = r100;
    }

    public void setExtra(String r100) {
        this.mExtra = r100;
    }

    public void setHasProcess(boolean r100) {
        this.mProcessed = r100;
    }

    public ApiServerException setProcessAndReturn(boolean r100) {
        this.mProcessed = r100;
        return this;
    }

    public void setPrompt(String r100) {
        this.mPrompt = r100;
    }
}
