package com.android.ttcjpaysdk.kmp.common.container.caijingbid;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/container/caijingbid/IKmpBizExtension;", "", "getBizName", "", "getContainerLifecycle", "Lcom/android/ttcjpaysdk/kmp/common/container/caijingbid/IContainerLifecycle;", "containerContext", "Lcom/android/ttcjpaysdk/kmp/common/container/caijingbid/IContainerContext;", "getWebviewLifecycle", "Lcom/android/ttcjpaysdk/kmp/common/container/caijingbid/IWebviewLifecycle;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpBizExtension {
    String getBizName();

    IContainerLifecycle getContainerLifecycle(IContainerContext r100);

    IWebviewLifecycle getWebviewLifecycle(IContainerContext r100);
}
