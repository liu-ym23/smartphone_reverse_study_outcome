package com.bytedance.android.ec.store.api;

import android.view.WindowManager;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/store/api/IShopEventListener;", "", LiveCommonConstants.REASON_ON_DEDTROY, "", "onPause", "shopId", "", "onResume", SendEventContainerMethodParamModel.EventKinds.onShow, "wm", "Landroid/view/WindowManager;", "ec-biz-store-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IShopEventListener {
    void onDestroy();

    void onPause(String r100);

    void onResume(String r100);

    void onShow(WindowManager r100);
}
