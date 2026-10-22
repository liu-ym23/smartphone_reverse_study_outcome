package com.bytedance.android.ec.adapter.impl.adapters.views;

import android.view.View;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements IExternalButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wd.d f42763a;

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IBaseExternalButton
    public final View getButtonViewInMore() {
        return this.f42763a.getButtonViewInMore();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IBaseExternalButton
    public final String getTargetButtonName() {
        return this.f42763a.getTargetButtonName();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final View getView() {
        return this.f42763a.getView();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onHide() {
        this.f42763a.onHide();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onLoad() {
        this.f42763a.onLoad();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onShow() {
        this.f42763a.onShow();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onUnload() {
        this.f42763a.onUnload();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewDetached() {
        this.f42763a.onViewDetached();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewWillDetach() {
        this.f42763a.onViewWillDetach();
    }

    public a(wd.d r100) {
        Intrinsics.checkNotNullParameter(r100, "realButton");
        this.f42763a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton
    public final void onBehaviorUpdate(String r100) {
        Intrinsics.checkNotNullParameter(r100, ControlRule.KEY_EXTRA_DATA);
        IExternalButton.DefaultImpls.onBehaviorUpdate(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton
    public final void onShow(ToolbarMatchInterface r100) {
        IExternalButton.DefaultImpls.onShow(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton
    public final boolean onTriggerAnimation(long r100) {
        return this.f42763a.onTriggerAnimation(r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewAttached(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
        this.f42763a.onViewAttached(new wd.c(r100.getLeft(), r100.getTop(), r100.getWidth(), r100.getHeight()));
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewWillAttach(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
        this.f42763a.onViewWillAttach(new wd.c(r100.getLeft(), r100.getTop(), r100.getWidth(), r100.getHeight()));
    }
}
