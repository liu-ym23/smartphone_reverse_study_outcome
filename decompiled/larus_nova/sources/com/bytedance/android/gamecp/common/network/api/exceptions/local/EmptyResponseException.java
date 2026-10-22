package com.bytedance.android.gamecp.common.network.api.exceptions.local;

/* JADX INFO: loaded from: classes44.dex */
public class EmptyResponseException extends ApiLocalException {
    public EmptyResponseException() {
        super(-1);
    }

    @Override // com.bytedance.android.gamecp.common.network.api.exceptions.local.ApiLocalException, com.bytedance.android.gamecp.base.network.exception.ApiException, java.lang.Throwable
    public String getMessage() {
        return " TYPE = EmptyResponseException " + super.getMessage();
    }
}
