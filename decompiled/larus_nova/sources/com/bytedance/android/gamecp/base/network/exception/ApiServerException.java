package com.bytedance.android.gamecp.base.network.exception;

/* JADX INFO: loaded from: classes44.dex */
public class ApiServerException extends ApiException {
    private boolean blockNotice;
    private String mAlert;
    private String mErrorMsg;
    private String mExtra;
    private String mPrompt;

    @Override // com.bytedance.android.gamecp.base.network.exception.ApiException, java.lang.Throwable
    public String getMessage() {
        return " TYPE = ApiServerException, errorMsg = " + this.mErrorMsg + " extra = " + this.mExtra + " " + super.getMessage();
    }

    public String getAlert() {
        return this.mAlert;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
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

    public ApiServerException setAlert(String r100) {
        this.mAlert = r100;
        return this;
    }

    public ApiServerException setBlockNotice(boolean r100) {
        this.blockNotice = r100;
        return this;
    }

    public ApiServerException setErrorMsg(String r100) {
        this.mErrorMsg = r100;
        return this;
    }

    public ApiServerException setExtra(String r100) {
        this.mExtra = r100;
        return this;
    }

    public ApiServerException setPrompt(String r100) {
        this.mPrompt = r100;
        return this;
    }
}
