package com.bytedance.android.annie.bridge.method;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/IChooseMediaResultCallback;", "", "Lcom/bytedance/android/annie/bridge/method/h;", "result", "", "msg", "", "onSuccess", "onFailure", "annie_release"}, k = 1, mv = {1, 4, 3})
public interface IChooseMediaResultCallback {
    void onFailure(String r100);

    void onSuccess(h r100, String r101);
}
