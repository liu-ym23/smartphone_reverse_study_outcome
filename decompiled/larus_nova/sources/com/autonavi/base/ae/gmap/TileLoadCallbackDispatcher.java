package com.autonavi.base.ae.gmap;

import com.amap.api.maps.ITileLoadCallback;

/* JADX INFO: loaded from: classes39.dex */
final class TileLoadCallbackDispatcher implements ITileLoadCallback {
    private final TileRequestTraceController traceController;
    private volatile ITileLoadCallback userCallback;

    public TileLoadCallbackDispatcher(TileRequestTraceController r100) {
        this.traceController = r100;
    }

    public void setUserCallback(ITileLoadCallback r100) {
        this.userCallback = r100;
    }

    @Override // com.amap.api.maps.ITileLoadCallback
    public void onTileLoad(boolean r110, long r111, String r112) {
        ITileLoadCallback r100 = this.userCallback;
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        boolean r102 = false;
        if (r100 != null) goto L15;
    L13:
        this.traceController.onTileTerminal(r110, r111, r112, r101, r102);
        return;
    L15:
        r100.onTileLoad(r110, r111, r112);     // Catch: Throwable -> L10
        r102 = true;
    L10:
        th = move-exception;
        this.traceController.onTileTerminal(r110, r111, r112, r101, false);
        throw th;
    L5:
        r101 = false;
        goto L6
    }
}
