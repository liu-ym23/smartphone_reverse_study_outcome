package com.android.ttcjpaysdk.kmp.base.jsWorker.code;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H'J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0007H'¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/jsWorker/code/IJavaScriptBridgeCallback;", "", "callbackResult", "", "id", "", "result", "", "callbackError", "code", "message", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IJavaScriptBridgeCallback {
    void callbackError(int r100, int r101, String r102);

    void callbackResult(int r100, String r101);
}
