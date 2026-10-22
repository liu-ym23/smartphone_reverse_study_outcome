package com.bytedance.android.ec.adapter.impl.adapters.views;

import android.view.View;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements IExternalView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wd.e f42766a;

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final View getView() {
        return this.f42766a.getView();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onHide() {
        this.f42766a.onHide();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onLoad() {
        this.f42766a.onLoad();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onShow() {
        this.f42766a.onShow();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onUnload() {
        this.f42766a.onUnload();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewDetached() {
        this.f42766a.onViewDetached();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewWillDetach() {
        this.f42766a.onViewWillDetach();
    }

    public c(wd.e r100) {
        Intrinsics.checkNotNullParameter(r100, "realView");
        this.f42766a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewAttached(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
        this.f42766a.onViewAttached(new wd.c(r100.getLeft(), r100.getTop(), r100.getWidth(), r100.getHeight()));
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewWillAttach(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
        this.f42766a.onViewWillAttach(new wd.c(r100.getLeft(), r100.getTop(), r100.getWidth(), r100.getHeight()));
    }
}
