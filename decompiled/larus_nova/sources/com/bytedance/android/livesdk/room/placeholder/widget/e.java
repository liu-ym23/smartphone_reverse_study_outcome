package com.bytedance.android.livesdk.room.placeholder.widget;

import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f157807a;

    @Override // com.bytedance.android.livesdk.room.placeholder.widget.d
    public final void attachWidget(IExternalWidget r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
    }

    @Override // com.bytedance.android.livesdk.room.placeholder.widget.d
    public final void detachWidget(IExternalWidget r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
    }

    public e(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f157807a = r100;
    }

    @Override // com.bytedance.android.livesdk.room.placeholder.widget.d
    public final void requestDismiss(IExternalWidget r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f157807a.put("DATA_RANK_SHOP_SHOW", Boolean.FALSE);
    }

    @Override // com.bytedance.android.livesdk.room.placeholder.widget.d
    public final void requestShow(IExternalWidget r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f157807a.put("DATA_RANK_SHOP_SHOW", Boolean.TRUE);
    }

    @Override // com.bytedance.android.livesdk.room.placeholder.widget.d
    public final void requestWidgetHeight(IExternalWidget r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        Intrinsics.checkNotNullParameter(r100, "widget");
    }
}
