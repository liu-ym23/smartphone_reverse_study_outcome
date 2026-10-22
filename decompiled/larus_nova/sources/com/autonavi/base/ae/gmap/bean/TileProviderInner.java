package com.autonavi.base.ae.gmap.bean;

import android.text.TextUtils;
import com.amap.api.mapcore.util.a9;
import com.amap.api.mapcore.util.v3;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileOverlaySource;
import com.amap.api.maps.model.TileProvider;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class TileProviderInner {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private List<TileOverlaySource> mTileSource;
    private String overlayName;
    private final HashMap<String, a9> reqTaskHandleHashMap;
    private final TileProvider tileProvider;

    public int getTileHeight() {
        TileProvider r100 = this.tileProvider;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getTileHeight();
    }

    public int getTileWidth() {
        TileProvider r100 = this.tileProvider;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getTileWidth();
    }

    public TileProviderInner(TileProvider r100) {
        this.reqTaskHandleHashMap = new HashMap();
        this.tileProvider = r100;
    }

    public static /* synthetic */ HashMap access$000(TileProviderInner r100) {
        return r100.reqTaskHandleHashMap;
    }

    public static /* synthetic */ TileProvider access$100(TileProviderInner r100) {
        return r100.tileProvider;
    }

    public void setTileSource(List<TileOverlaySource> r100) {
        this.mTileSource = r100;
    }

    private Object callNativeFunction(String r100, Object[] r101) {
        IGlOverlayLayer r102 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(this.overlayName) == true) goto L13;
        if (r102 == null) goto L14;
        return r102.getNativeProperties(this.overlayName, r100, r101);
    L14:
        return null;
    L13:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void cancelTile(TileSourceReq r100, TileReqTaskHandle r101) {
        String r102 = createKey(r100.f30029x, r100.f30030y, r100.zoom, r101.nativeObj);
        HashMap<String, a9> r103 = this.reqTaskHandleHashMap;
        monitor-enter(r103);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.reqTaskHandleHashMap.containsKey(r102) == true) goto L8;
        monitor-exit(r103);     // Catch: Throwable -> L24
        return;
    L8:
        a9 r104 = this.reqTaskHandleHashMap.get(r102);     // Catch: Throwable -> L24
        monitor-exit(r103);     // Catch: Throwable -> L24
        if (r104 == null) goto L16;
        v3.b().getClass();
        r104.cancelTask();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.printStackTrace();
    L16:
        r101.status = 1;
        finishDownload(TileProvider.NO_TILE, r101, r102);
        TileProvider r105 = this.tileProvider;     // Catch: Throwable -> L21
        if ((r105 instanceof TileSourceProvider) == false) goto L32;
        ((TileSourceProvider) r105).cancel(r100);     // Catch: Throwable -> L21
        return;
    L32:
        return;
    L21:
        th = move-exception;
        th.printStackTrace();
    }

    public void getTile(final TileSourceReq r100, final TileReqTaskHandle r101) {
        final String r102 = createKey(r100.f30029x, r100.f30030y, r100.zoom, r101.nativeObj);
        a9 r103 = new AnonymousClass1(this, r102, r100, r101);
        HashMap<String, a9> r104 = this.reqTaskHandleHashMap;
        monitor-enter(r104);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.reqTaskHandleHashMap.containsKey(r102) == false) goto L8;
        monitor-exit(r104);     // Catch: Throwable -> L12
        return;
    L8:
        this.reqTaskHandleHashMap.put(r102, r103);     // Catch: Throwable -> L12
        monitor-exit(r104);     // Catch: Throwable -> L12
        v3.b().a(r103);
    }

    public void init(IGlOverlayLayer r100, String r101) {
        this.glOverlayLayerRef = new WeakReference(r100);
        this.overlayName = r101;
    }

    private void finishDownload(Tile r100, TileReqTaskHandle r101, String r102) {
        if (this.glOverlayLayerRef.get() != null) goto L5;
        return;
    L5:
        HashMap<String, a9> r103 = this.reqTaskHandleHashMap;
        monitor-enter(r103);
    L19:
        th = move-exception;
        throw th;
    L8:
        if (this.reqTaskHandleHashMap.containsKey(r102) == true) goto L12;
        monitor-exit(r103);     // Catch: Throwable -> L19
        return;
    L12:
        if (this.reqTaskHandleHashMap.containsKey(r102) == false) goto L14;
        this.reqTaskHandleHashMap.remove(r102);     // Catch: Throwable -> L19
        boolean r104 = true;
    L15:
        monitor-exit(r103);     // Catch: Throwable -> L19
        if (r104 == false) goto L23;
        r101.finish(r100);
        callNativeFunction("finishTileReqTask", new Object[]{r101});
        return;
    L23:
        return;
    L14:
        r104 = false;
        goto L15
    }

    public static /* synthetic */ void access$200(TileProviderInner r100, Tile r101, TileReqTaskHandle r102, String r103) {
        r100.finishDownload(r101, r102, r103);
    }

    private String createKey(int r100, int r101, int r102, long r103) {
        return r100 + " " + r101 + " " + r102 + "-" + r103;
    }
}
