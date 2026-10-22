package com.bytedance.android.shopping.mall.homepage.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/model/NativeMallApiException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "statusCode", "", "message", "", "(ILjava/lang/String;)V", "getStatusCode", "()I", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NativeMallApiException extends Exception {
    private final int statusCode;

    public final int getStatusCode() {
        return this.statusCode;
    }

    public NativeMallApiException(int r100, String r101) {
        super(r101);
        this.statusCode = r100;
    }
}
