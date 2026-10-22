package com.android.ttcjpaysdk.kmp.common.container.caijingbid;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0003H'J\b\u0010\u0005\u001a\u00020\u0003H'J\b\u0010\u0006\u001a\u00020\u0003H'¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/container/caijingbid/IContainerLifecycle;", "", WidgetCostModule.TYPE_ON_CREATE, "", SendEventContainerMethodParamModel.EventKinds.onShow, "onHide", LiveCommonConstants.REASON_ON_DEDTROY, "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IContainerLifecycle {
    void onCreate();

    void onDestroy();

    void onHide();

    void onShow();
}
