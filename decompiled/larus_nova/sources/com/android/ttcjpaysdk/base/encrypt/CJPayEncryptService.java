package com.android.ttcjpaysdk.base.encrypt;

import com.android.ttcjpaysdk.base.BuildConfig;
import com.android.ttcjpaysdk.base.service.IJCPayEncryptService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/encrypt/CJPayEncryptService;", "Lcom/android/ttcjpaysdk/base/service/IJCPayEncryptService;", "()V", "createEncryptInstance", "", "getPackageName", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayEncryptService implements IJCPayEncryptService {
    @Override // com.android.ttcjpaysdk.base.service.ICJPayService
    public String getPackageName() {
        return BuildConfig.LIBRARY_PACKAGE_NAME;
    }

    @Override // com.android.ttcjpaysdk.base.service.IJCPayEncryptService
    public Object createEncryptInstance() {
        return new ISECEncrypt();
    }

    public CJPayEncryptService() {
    }
}
