package com.bytedance.android.gamecp.base.network.exception;

import android.text.TextUtils;
import tb2.c;

/* JADX INFO: loaded from: classes44.dex */
public class CustomApiServerException extends ApiServerException {
    private String url;
    private String xTtLogId;

    @Override // com.bytedance.android.gamecp.base.network.exception.ApiServerException, com.bytedance.android.gamecp.base.network.exception.ApiException, java.lang.Throwable
    public String getMessage() {
        return " TYPE = CustomApiServerException, url = " + this.url + ", xTtLogId = " + this.xTtLogId + c.DEFAULT_TEXT + super.getMessage();
    }

    public String getUrl() {
        return this.url;
    }

    public String getXTtLogId() {
        return this.xTtLogId;
    }

    public CustomApiServerException(int r100, String r101, String r102) {
        super(r100);
        if (TextUtils.isEmpty(r101) == false) goto L5;
        this.url = "";
    L7:
        if (TextUtils.isEmpty(r102) == false) goto L9;
        this.xTtLogId = "";
        return;
    L9:
        this.xTtLogId = r102;
        return;
    L5:
        this.url = r101;
        goto L7
    }
}
