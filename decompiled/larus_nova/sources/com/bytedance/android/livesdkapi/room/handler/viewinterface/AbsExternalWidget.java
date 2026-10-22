package com.bytedance.android.livesdkapi.room.handler.viewinterface;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0017J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0017J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/AbsExternalWidget;", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IExternalWidget;", "()V", "onHide", "", WidgetCostModule.TYPE_ON_LOAD, SendEventContainerMethodParamModel.EventKinds.onShow, "onUnload", "onViewAttached", "viewContainerLayoutParam", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/Rect;", "onViewDetached", "onViewWillAttach", "onViewWillDetach", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsExternalWidget implements IExternalWidget {
    public AbsExternalWidget() {
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    @Deprecated(message = "使用 onViewWillDetach 替代", replaceWith = @ReplaceWith(expression = "onViewWillDetach()", imports = {}))
    public void onHide() {
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public void onLoad() {
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    @Deprecated(message = "使用 onViewAttached 替代", replaceWith = @ReplaceWith(expression = "onViewAttached()", imports = {}))
    public void onShow() {
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public void onUnload() {
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public void onViewAttached(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public void onViewDetached() {
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public void onViewWillAttach(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public void onViewWillDetach() {
    }
}
