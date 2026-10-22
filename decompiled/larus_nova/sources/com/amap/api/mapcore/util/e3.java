package com.amap.api.mapcore.util;

import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;

/* JADX INFO: loaded from: classes28.dex */
public class e3 implements TileProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MapConfig f27200a;

    public class a extends f3 {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f27201o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f27202p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f27203q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private String f27204r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private String f27205s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        Random f27206t;

        private String c() {
            if (t3.a(this.f27201o, this.f27202p, this.f27203q) == false) goto L5;
        L13:
            int r100 = this.f27206t.nextInt(100000) % 4;
            return String.format(Locale.US, "http://" + p5.b(b0.f27047f).a(22) + "/appmaptile?", new Object[]{Integer.valueOf(r100 + 1)});
        L5:
            if (this.f27203q < 6) goto L13;
            if (MapsInitializer.isLoadWorldGridMap() == true) goto L10;
            return null;
        L10:
            return ("http://" + p5.b(b0.f27047f).a(27)) + "/v4/gridmap?";
        }

        @Override // com.amap.api.mapcore.util.y7
        public String getURL() {
            StringBuffer r100 = new StringBuffer("key=");
            r100.append(l5.e(b0.f27047f));
            r100.append("&channel=amapapi");
            if (t3.a(this.f27201o, this.f27202p, this.f27203q) == false) goto L5;
        L10:
            r100.append("&z=");
            r100.append(this.f27203q);
            r100.append("&x=");
            r100.append(this.f27201o);
            r100.append("&y=");
            r100.append(this.f27202p);
            r100.append("&lang=en&size=1&scale=1&style=7");
        L12:
            return this.f27205s + appendTsScode(r100.toString());
        L5:
            if (this.f27203q < 6) goto L10;
            if (MapsInitializer.isLoadWorldGridMap() == false) goto L12;
            r100.append("&x=");
            r100.append(this.f27201o);
            r100.append("&y=");
            r100.append(this.f27202p);
            r100.append("&z=");
            r100.append(this.f27203q);
            r100.append("&ds=0&dpitype=webrd&lang=");
            r100.append(this.f27204r);
            r100.append("&scale=2");
            goto L12
        }

        public a(e3 r100, int r101, int r102, int r103, String r104) {
            this.f27205s = "";
            this.f27206t = new Random();
            this.f27201o = r101;
            this.f27202p = r102;
            this.f27203q = r103;
            this.f27204r = r104;
            this.f27205s = c();
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return 256;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return 256;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int r100, int r101, int r110) {
        String r102 = "zh_cn";
        if (this.f27200a.getMapLanguage().equals("zh_cn") == false) goto L15;
        if (MapsInitializer.isLoadWorldGridMap() == false) goto L8;
        if (r110 < 6) goto L13;
        if (t3.a(r100, r101, r110) == true) goto L13;
    L21:
        MapConfig r103 = this.f27200a;     // Catch: IOException -> L33
        if (r103 == null) goto L36;
        r102 = r103.getMapLanguage();     // Catch: IOException -> L33
    L36:
        byte[] r104 = new a(this, r100, r101, r110, r102).makeHttpRequestWithInterrupted();     // Catch: Throwable -> L27
    L28:
        if (r104 != null) goto L38;
        return TileProvider.NO_TILE;
    L38:
        return Tile.obtain(256, 256, r104);
    L27:
        r104 = null;
    L13:
        return TileProvider.NO_TILE;
    L8:
        return TileProvider.NO_TILE;
    L15:
        if (MapsInitializer.isLoadWorldGridMap() == true) goto L21;
        if (r110 < 6) goto L21;
        if (t3.a(r100, r101, r110) == true) goto L21;
        return TileProvider.NO_TILE;
    L34:
        return TileProvider.NO_TILE;
    }

    public e3(int r100, int r101, MapConfig r102, boolean r103) {
        this.f27200a = r102;
    }
}
