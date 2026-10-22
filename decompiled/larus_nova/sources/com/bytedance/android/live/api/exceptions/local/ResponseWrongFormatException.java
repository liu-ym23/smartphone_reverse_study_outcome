package com.bytedance.android.live.api.exceptions.local;

/* JADX INFO: loaded from: classes45.dex */
public class ResponseWrongFormatException extends ApiLocalException {
    public ResponseWrongFormatException() {
        super(-3);
    }

    @Override // com.bytedance.android.live.api.exceptions.local.ApiLocalException, com.bytedance.android.live.base.exception.ApiException, java.lang.Throwable
    public String getMessage() {
        return " TYPE = ResponseWrongFormatException " + super.getMessage();
    }
}
