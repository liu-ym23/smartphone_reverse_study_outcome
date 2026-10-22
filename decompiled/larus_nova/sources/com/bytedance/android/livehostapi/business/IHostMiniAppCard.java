package com.bytedance.android.livehostapi.business;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.depend.openplatform.livecard.LiveCard;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\rJ0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IHostMiniAppCard;", "Lcom/bytedance/android/live/base/IService;", "getLiveCard", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "appId", "", "width", "", "height", "callback", "Lcom/bytedance/android/livehostapi/business/IHostMiniAppCard$CanvasSetupCallback;", "CanvasSetupCallback", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostMiniAppCard extends IService {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IHostMiniAppCard$CanvasSetupCallback;", "", "onFail", "", "message", "", "onSuccess", "canvasId", "", BrowserDependency.UrlClickType.CARD, "Lcom/bytedance/android/livehostapi/business/depend/openplatform/livecard/LiveCard;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface CanvasSetupCallback {
        void onFail(String r100);

        void onSuccess(long r100, LiveCard r101);
    }

    void getLiveCard(Context r100, String r101, int r102, int r103, CanvasSetupCallback r104);
}
