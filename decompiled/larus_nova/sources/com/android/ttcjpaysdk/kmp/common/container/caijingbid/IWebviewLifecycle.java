package com.android.ttcjpaysdk.kmp.common.container.caijingbid;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0017J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0017J+\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0017¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/container/caijingbid/IWebviewLifecycle;", "", "onPageStarted", "", "url", "", "onPageFinished", "onReceivedError", "errorCode", "", "description", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IWebviewLifecycle {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onPageFinished(IWebviewLifecycle r100, String r101) {
        }

        public static void onPageStarted(IWebviewLifecycle r100, String r101) {
        }

        public static void onReceivedError(IWebviewLifecycle r100, String r101, Integer r102, String r103) {
        }
    }

    void onPageFinished(String r100);

    void onPageStarted(String r100);

    void onReceivedError(String r100, Integer r101, String r102);
}
