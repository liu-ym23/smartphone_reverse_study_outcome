package com.bytedance.android.livesdkapi.room.handler.viewinterface;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0017J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0017J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\bX¤\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/AbsExternalButton;", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IExternalButton;", "()V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "realView", "Landroid/view/View;", "getRealView", "()Landroid/view/View;", "setRealView", "(Landroid/view/View;)V", "onHide", "", WidgetCostModule.TYPE_ON_LOAD, SendEventContainerMethodParamModel.EventKinds.onShow, "onUnload", "onViewAttached", "viewContainerLayoutParam", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/Rect;", "onViewDetached", "onViewWillAttach", "onViewWillDetach", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsExternalButton implements IExternalButton {
    public AbsExternalButton() {
    }

    public abstract Context getContext();

    public abstract View getRealView();

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

    public abstract void setRealView(View r100);

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IBaseExternalButton
    public View getButtonViewInMore() {
        return IExternalButton.DefaultImpls.getButtonViewInMore(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton
    public void onBehaviorUpdate(String r100) {
        Intrinsics.checkNotNullParameter(r100, ControlRule.KEY_EXTRA_DATA);
        IExternalButton.DefaultImpls.onBehaviorUpdate(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton
    public void onShow(ToolbarMatchInterface r100) {
        IExternalButton.DefaultImpls.onShow(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton
    public boolean onTriggerAnimation(long r100) {
        return IExternalButton.DefaultImpls.onTriggerAnimation(this, r100);
    }
}
