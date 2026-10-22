package com.bytedance.android.gamecp.common.network.api.exceptions.local;

import com.bytedance.android.gamecp.base.network.response.b;

/* JADX INFO: loaded from: classes44.dex */
public class ResponseNoDataException extends ApiLocalException {
    private b mResponse;

    public ResponseNoDataException() {
        super(-2);
    }

    @Override // com.bytedance.android.gamecp.common.network.api.exceptions.local.ApiLocalException, com.bytedance.android.gamecp.base.network.exception.ApiException, java.lang.Throwable
    public String getMessage() {
        return " TYPE = ResponseNoDataException " + super.getMessage();
    }

    public ResponseNoDataException(b r100) {
        super(-2);
        this.mResponse = r100;
    }
}
