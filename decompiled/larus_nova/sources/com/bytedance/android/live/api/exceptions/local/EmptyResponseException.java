package com.bytedance.android.live.api.exceptions.local;

/* JADX INFO: loaded from: classes45.dex */
public class EmptyResponseException extends ApiLocalException {
    public EmptyResponseException() {
        super(-1);
    }

    @Override // com.bytedance.android.live.api.exceptions.local.ApiLocalException, com.bytedance.android.live.base.exception.ApiException, java.lang.Throwable
    public String getMessage() {
        return " TYPE = EmptyResponseException " + super.getMessage();
    }
}
