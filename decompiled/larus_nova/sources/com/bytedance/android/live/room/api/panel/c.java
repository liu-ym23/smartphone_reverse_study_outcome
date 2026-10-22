package com.bytedance.android.live.room.api.panel;

/* JADX INFO: loaded from: classes47.dex */
public interface c {
    void notifyPanelClose(PanelName r100, b r101);

    void notifyPanelOpen(PanelName r100, b r101);

    void registerPanelListener(a r100);

    void registerPanelListener(a r100, boolean r101);

    void unregisterPanelListener(a r100);
}
