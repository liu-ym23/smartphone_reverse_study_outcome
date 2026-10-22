package com.android.ttcjpaysdk.base.service;

import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Deprecated(message = "加密基础能力未来统一收敛到CJEncrypt")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/IJCPayEncryptService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "createEncryptInstance", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IJCPayEncryptService extends ICJPayService {
    Object createEncryptInstance();
}
