package com.bytedance.android.livesdk.room.placeholder.widget;

import android.view.View;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g extends AbsExternalWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IExternalWidget f157811a;

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final View getView() {
        return this.f157811a.getView();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onLoad() {
        this.f157811a.onLoad();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onUnload() {
        this.f157811a.onUnload();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewDetached() {
        this.f157811a.onViewDetached();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewWillDetach() {
        this.f157811a.onViewWillDetach();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewAttached(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
        this.f157811a.onViewAttached(r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewWillAttach(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
        this.f157811a.onViewWillAttach(r100);
    }

    public g(IExternalWidget r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f157811a = r100;
    }
}
