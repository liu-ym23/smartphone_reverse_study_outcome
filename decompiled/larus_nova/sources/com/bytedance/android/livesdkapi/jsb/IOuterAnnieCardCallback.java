package com.bytedance.android.livesdkapi.jsb;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/jsb/IOuterAnnieCardCallback;", "", "onLoadFail", "", "view", "Landroid/view/View;", "url", "", "reason", "onLoadSuccess", "onPrepareTemplateEnd", "isOffline", "", "resFrom", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IOuterAnnieCardCallback {
    void onLoadFail(View r100, String r101, String r102);

    void onLoadSuccess(View r100);

    void onPrepareTemplateEnd(boolean r100, String r101);
}
