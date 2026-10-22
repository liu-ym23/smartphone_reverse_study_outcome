package com.android.ttcjpaysdk.kmp.base.appState;

import kotlin.Metadata;
import pd6.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/appState/IKmpCJAppStateService;", "Lcom/bytedance/kmp/spi/IKmpService;", "registerAppStateCallback", "", "callback", "Lcom/android/ttcjpaysdk/kmp/base/appState/IKmpCJAppStateServiceCallback;", "code", "", "unregisterAppStateCallback", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJAppStateService extends a {
    void registerAppStateCallback(IKmpCJAppStateServiceCallback r100, String r101);

    void unregisterAppStateCallback(IKmpCJAppStateServiceCallback r100, String r101);
}
