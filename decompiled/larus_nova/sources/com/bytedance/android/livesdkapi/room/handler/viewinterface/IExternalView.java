package com.bytedance.android.livesdkapi.room.handler.viewinterface;

import android.view.View;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IExternalView;", "", "getView", "Landroid/view/View;", "onHide", "", WidgetCostModule.TYPE_ON_LOAD, SendEventContainerMethodParamModel.EventKinds.onShow, "onUnload", "onViewAttached", "viewContainerLayoutParam", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/Rect;", "onViewDetached", "onViewWillAttach", "onViewWillDetach", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IExternalView {
    View getView();

    void onHide();

    void onLoad();

    void onShow();

    void onUnload();

    void onViewAttached(Rect r100);

    void onViewDetached();

    void onViewWillAttach(Rect r100);

    void onViewWillDetach();
}
