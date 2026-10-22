package com.bytedance.android.gamecp.common.network.api.exceptions.local;

import com.bytedance.android.gamecp.base.network.exception.ApiException;

/* JADX INFO: loaded from: classes44.dex */
public class ApiLocalException extends ApiException {
    @Override // com.bytedance.android.gamecp.base.network.exception.ApiException, java.lang.Throwable
    public String getMessage() {
        return " TYPE = ApiLocalException " + super.getMessage();
    }

    public ApiLocalException(int r100) {
        super(r100);
    }

    public ApiLocalException(int r100, Throwable r101) {
        super(r100, r101);
    }
}
