package com.bytedance.android.ec.store.api;

import android.view.WindowManager;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/store/api/ITabKitEventListener;", "", "Landroid/view/WindowManager;", "wm", "", SendEventContainerMethodParamModel.EventKinds.onShow, LiveCommonConstants.REASON_ON_DEDTROY, "onLoadFinish", "ec-biz-store-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ITabKitEventListener {
    void onDestroy();

    void onLoadFinish();

    void onShow(WindowManager r100);
}
