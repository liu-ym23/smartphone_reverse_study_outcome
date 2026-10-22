package com.bytedance.android.live.api.exceptions.local;

import com.bytedance.android.live.network.response.BaseResponse;

/* JADX INFO: loaded from: classes45.dex */
public class ResponseNoDataException extends ApiLocalException {
    private BaseResponse mResponse;

    public ResponseNoDataException() {
        super(-2);
    }

    @Override // com.bytedance.android.live.api.exceptions.local.ApiLocalException, com.bytedance.android.live.base.exception.ApiException, java.lang.Throwable
    public String getMessage() {
        return " TYPE = ResponseNoDataException " + super.getMessage();
    }

    public BaseResponse getResponse() {
        return this.mResponse;
    }

    public ResponseNoDataException(BaseResponse r100) {
        super(-2);
        this.mResponse = r100;
    }
}
