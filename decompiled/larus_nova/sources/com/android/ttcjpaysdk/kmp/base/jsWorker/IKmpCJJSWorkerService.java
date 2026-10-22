package com.android.ttcjpaysdk.kmp.base.jsWorker;

import com.android.ttcjpaysdk.kmp.base.jsWorker.code.IJSWorker;
import com.android.ttcjpaysdk.kmp.base.jsWorker.code.IJavaScriptBridge;
import kotlin.Metadata;
import pd6.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/jsWorker/IKmpCJJSWorkerService;", "Lcom/bytedance/kmp/spi/IKmpService;", "initJSWorker", "", "createJSWorker", "Lcom/android/ttcjpaysdk/kmp/base/jsWorker/code/IJSWorker;", "id", "", "bridge", "Lcom/android/ttcjpaysdk/kmp/base/jsWorker/code/IJavaScriptBridge;", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJJSWorkerService extends a {
    IJSWorker createJSWorker(int r100, IJavaScriptBridge r101);

    void initJSWorker();
}
