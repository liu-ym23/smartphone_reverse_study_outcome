package com.bytedance.android.ec.adapter.impl.adapters.views;

import android.view.View;
import com.bytedance.android.ec.adapter.api.handler.viewinterface.IECWidgetType;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IWidgetType;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import kotlin.jvm.internal.Intrinsics;
import wd.g;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements IExternalWidget, IWidgetType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f42767a;

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final View getView() {
        return this.f42767a.getView();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IWidgetType
    public final IWidgetType.ExternalWidgetType getWidgetType() {
        g r100 = this.f42767a;
        if ((r100 instanceof IECWidgetType) == false) goto L15;
        int r101 = ((IECWidgetType) r100).j().getValue();
        IWidgetType.ExternalWidgetType r102 = IWidgetType.ExternalWidgetType.ECOMMERCE_SIZE_COMPONENTS;
        if (r101 == r102.getValue()) goto L17;
        IWidgetType.ExternalWidgetType r103 = IWidgetType.ExternalWidgetType.ECOMMERCE_POP_CARD;
        if (r101 == r103.getValue()) goto L18;
        IWidgetType.ExternalWidgetType r104 = IWidgetType.ExternalWidgetType.ECOMMERCE_PROPERTY_COMPONENTS;
        if (r101 != r104.getValue()) goto L16;
        return r104;
    L16:
        return IWidgetType.ExternalWidgetType.UNKNOWN;
    L18:
        return r103;
    L17:
        return r102;
    L15:
        return IWidgetType.ExternalWidgetType.UNKNOWN;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onHide() {
        this.f42767a.onHide();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onLoad() {
        this.f42767a.onLoad();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onShow() {
        this.f42767a.onShow();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onUnload() {
        this.f42767a.onUnload();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewDetached() {
        this.f42767a.onViewDetached();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewWillDetach() {
        this.f42767a.onViewWillDetach();
    }

    public d(g r100) {
        Intrinsics.checkNotNullParameter(r100, "realWidget");
        this.f42767a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewAttached(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
        this.f42767a.onViewAttached(new wd.c(r100.getLeft(), r100.getTop(), r100.getWidth(), r100.getHeight()));
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewWillAttach(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
        this.f42767a.onViewWillAttach(new wd.c(r100.getLeft(), r100.getTop(), r100.getWidth(), r100.getHeight()));
    }
}
