package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.mapapi.common.Logger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public final class TileOverlay {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7019a = "TileOverlay";

    /* renamed from: b, reason: collision with root package name */
    private static int f7020b;

    /* renamed from: c, reason: collision with root package name */
    BaiduMap f7021c;

    /* renamed from: g, reason: collision with root package name */
    private TileProvider f7025g;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, Tile> f7023e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private HashSet<String> f7024f = new HashSet<>();

    /* renamed from: d, reason: collision with root package name */
    private ExecutorService f7022d = Executors.newFixedThreadPool(1);

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7026a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f7027b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f7028c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f7029d;

        public a(int i4, int i5, int i6, String str) {
            this.f7026a = i4;
            this.f7027b = i5;
            this.f7028c = i6;
            this.f7029d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Tile tile = ((FileTileProvider) TileOverlay.this.f7025g).getTile(this.f7026a, this.f7027b, this.f7028c);
            if (tile == null) {
                Log.e(TileOverlay.f7019a, "FileTile pic is null");
            } else if (tile.width == 256 && tile.height == 256) {
                TileOverlay.this.a(this.f7026a + "_" + this.f7027b + "_" + this.f7028c, tile);
            } else {
                Log.e(TileOverlay.f7019a, "FileTile pic must be 256 * 256");
            }
            TileOverlay.this.f7024f.remove(this.f7029d);
        }
    }

    public TileOverlay(BaiduMap baiduMap, TileProvider tileProvider) {
        this.f7021c = baiduMap;
        this.f7025g = tileProvider;
    }

    private synchronized boolean c(String str) {
        return this.f7024f.contains(str);
    }

    public boolean clearTileCache() {
        BaiduMap baiduMap = this.f7021c;
        if (baiduMap == null) {
            return false;
        }
        return baiduMap.a();
    }

    public void removeTileOverlay() {
        BaiduMap baiduMap = this.f7021c;
        if (baiduMap == null) {
            return;
        }
        baiduMap.a(this);
    }

    private synchronized Tile b(String str) {
        if (!this.f7023e.containsKey(str)) {
            return null;
        }
        Tile tile = this.f7023e.get(str);
        this.f7023e.remove(str);
        return tile;
    }

    public void c() {
        this.f7022d.shutdownNow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, Tile tile) {
        this.f7023e.put(str, tile);
    }

    private synchronized void a(String str) {
        this.f7024f.add(str);
    }

    public synchronized void b() {
        Logger.logE(f7019a, "clearTaskSet");
        this.f7024f.clear();
        this.f7023e.clear();
    }

    public Tile a(int i4, int i5, int i6) {
        String str = i4 + "_" + i5 + "_" + i6;
        Tile tileB = b(str);
        if (tileB != null) {
            return tileB;
        }
        BaiduMap baiduMap = this.f7021c;
        if (baiduMap != null && f7020b == 0) {
            WinRound winRound = baiduMap.getMapStatus().f6517c.f8108j;
            f7020b = (((winRound.bottom - winRound.top) / 256) + 2) * (((winRound.right - winRound.left) / 256) + 2);
        }
        if (this.f7023e.size() > f7020b) {
            b();
        }
        if (c(str) || this.f7022d.isShutdown()) {
            return null;
        }
        try {
            a(str);
            this.f7022d.execute(new a(i4, i5, i6, str));
            return null;
        } catch (RejectedExecutionException unused) {
            Log.e(f7019a, "ThreadPool excepiton");
            return null;
        } catch (Exception unused2) {
            Log.e(f7019a, "fileDir is not legal");
            return null;
        }
    }
}
