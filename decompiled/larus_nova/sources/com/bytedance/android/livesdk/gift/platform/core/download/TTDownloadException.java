package com.bytedance.android.livesdk.gift.platform.core.download;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.e;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.BaseGetResourceException;
import dd6.a;

/* JADX INFO: loaded from: classes9.dex */
public class TTDownloadException extends BaseGetResourceException {
    private a mDownloadRequest;
    private int mErrorCode;

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.BaseGetResourceException, java.lang.Throwable
    public String getMessage() {
        return this.mDownloadRequest.toString() + "\n" + super.getMessage();
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public TTDownloadException(String r100, Throwable r101, e r102, int r103, a r104) {
        super(r100, r101, r102);
        this.mErrorCode = r103;
        this.mDownloadRequest = r104;
    }
}
