package com.android.ttcjpaysdk.kmp.common.container.caijingbid;

import com.android.ttcjpaysdk.kmp.common.container.PlatformObject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/container/caijingbid/IPlatformJSBCallback;", "", "onSuccess", "", "result", "Lcom/android/ttcjpaysdk/kmp/common/container/PlatformObject;", "onFailed", "errorCode", "", "errorMsg", "", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IPlatformJSBCallback {
    void onFailed(int r100, String r101, PlatformObject r102);

    void onSuccess(PlatformObject r100);
}
