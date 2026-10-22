package com.bytedance.android.livesdk.room.placeholder.widget;

import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;

/* JADX INFO: loaded from: classes11.dex */
public interface d {
    void attachWidget(IExternalWidget r100);

    void detachWidget(IExternalWidget r100);

    void requestDismiss(IExternalWidget r100);

    void requestShow(IExternalWidget r100);

    void requestWidgetHeight(IExternalWidget r100, int r101);
}
