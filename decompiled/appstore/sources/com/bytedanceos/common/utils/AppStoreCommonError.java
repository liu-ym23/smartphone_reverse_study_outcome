package com.bytedanceos.common.utils;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class AppStoreCommonError implements Serializable {
    private static final long serialVersionUID = 10;
    private int errorCode;
    private String errorMsg;

    public AppStoreCommonError() {
        this.errorCode = 0;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorCode(int r10) {
        this.errorCode = r10;
    }

    public void setErrorMsg(String r10) {
        this.errorMsg = r10;
    }
}
