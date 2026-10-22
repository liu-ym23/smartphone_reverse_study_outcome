package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.LruCache;
import com.baidu.mapapi.map.BackgroundDrawMapView;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;

/* loaded from: classes.dex */
class a extends com.baidu.mapapi.map.b<Bundle> implements IBackgroundDrawBaseRouteLayer {

    /* renamed from: a, reason: collision with root package name */
    private c f7125a;

    /* renamed from: b, reason: collision with root package name */
    private Path f7126b;

    /* renamed from: c, reason: collision with root package name */
    private Point f7127c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f7128d;

    /* renamed from: e, reason: collision with root package name */
    private int f7129e;

    /* renamed from: f, reason: collision with root package name */
    private int f7130f;

    /* renamed from: g, reason: collision with root package name */
    private int f7131g;

    /* renamed from: h, reason: collision with root package name */
    private final LruCache<String, b> f7132h;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final float f7133a;

        /* renamed from: b, reason: collision with root package name */
        private final float f7134b;

        public b(float f4, float f5) {
            this.f7133a = f4;
            this.f7134b = f5;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f7133a == bVar.f7133a && this.f7134b == bVar.f7134b;
        }

        public int hashCode() {
            return Float.hashCode(this.f7134b) + Float.hashCode(this.f7133a);
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private Bundle f7135a;

        private c() {
        }

        public void a(Bundle bundle) {
            this.f7135a = bundle;
        }

        public int[] b() {
            Bundle bundle = this.f7135a;
            if (bundle == null) {
                return null;
            }
            return bundle.getIntArray("allPtX");
        }

        public int[] c() {
            Bundle bundle = this.f7135a;
            if (bundle == null) {
                return null;
            }
            return bundle.getIntArray("allPtY");
        }

        public boolean d() {
            Bundle bundle = this.f7135a;
            return bundle != null && bundle.getInt("bIsClosedRegion", 0) == 1;
        }

        public boolean e() {
            return this.f7135a != null;
        }

        public void f() {
            this.f7135a = null;
        }

        public double a() {
            Bundle bundle = this.f7135a;
            if (bundle == null) {
                return 0.0d;
            }
            return bundle.getDouble("ulWidth", 0.0d);
        }
    }

    public a(Context context) {
        super(context);
        this.f7129e = Color.parseColor("#EFEEE9");
        this.f7130f = Color.parseColor("#9B9B9B");
        this.f7131g = Color.parseColor("#9B9B9B");
        this.f7132h = new LruCache<>(BmLocated.ALIGN_BOTTOM);
    }

    private void a(BackgroundDrawMapView.CanvasProxy canvasProxy) {
        canvasProxy.drawColor(this.f7129e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(com.baidu.mapapi.map.BackgroundDrawMapView.CanvasProxy r17) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.a.b(com.baidu.mapapi.map.BackgroundDrawMapView$CanvasProxy):void");
    }

    @Override // com.baidu.mapapi.map.BaseBackgroundDrawLayer, com.baidu.mapapi.map.IBackgroundDrawLayer
    public void onCreate() {
        super.onCreate();
        this.f7125a = new c();
        this.f7127c = new Point(-1, -1);
        this.f7126b = new Path();
        this.f7128d = new Paint();
    }

    @Override // com.baidu.mapapi.map.BaseBackgroundDrawLayer, com.baidu.mapapi.map.IBackgroundDrawLayer
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawLayer
    public void onDraw(BackgroundDrawMapView.CanvasProxy canvasProxy) {
        com.baidu.platform.comapi.map.MapStatus mapStatus;
        MapStatus.WinRound winRound;
        int i4;
        float f4;
        int iMin;
        MapController mapController = this.mController;
        if (mapController == null || (mapStatus = mapController.getMapStatus()) == null || (winRound = mapStatus.winRound) == null) {
            return;
        }
        int iAbs = Math.abs(winRound.right - winRound.left);
        int iAbs2 = Math.abs(winRound.bottom - winRound.top);
        if (iAbs2 <= 0 || iAbs <= 0 || this.mWidth <= 0 || this.mHeight <= 0) {
            return;
        }
        canvasProxy.save();
        canvasProxy.translate((this.mWidth - iAbs) / 2.0f, (this.mHeight - iAbs2) / 2.0f);
        int i5 = this.mWidth;
        if (i5 != iAbs && (i4 = this.mHeight) != iAbs2) {
            if (i5 >= iAbs && i4 >= iAbs2) {
                iMin = Math.min(i5 / iAbs, i4 / iAbs2);
            } else if (i5 > iAbs || i4 > iAbs2) {
                f4 = i5 <= iAbs ? i4 / iAbs2 : i5 / iAbs;
                canvasProxy.scale(f4, f4, this.mWidth / 2.0f, this.mHeight / 2.0f);
            } else {
                iMin = Math.min(iAbs / i5, iAbs2 / i4);
            }
            f4 = iMin;
            canvasProxy.scale(f4, f4, this.mWidth / 2.0f, this.mHeight / 2.0f);
        }
        a(canvasProxy);
        b(canvasProxy);
        canvasProxy.restore();
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawBaseRouteLayer
    public void setBackgroundColor(int i4) {
        this.f7129e = this.mContext.getResources().getColor(i4);
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawBaseRouteLayer
    public void setRouteColor(int i4) {
        setRouteLineColor(i4);
        setRouteSurfaceColor(i4);
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawBaseRouteLayer
    public void setRouteLineColor(int i4) {
        this.f7130f = this.mContext.getResources().getColor(i4);
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawBaseRouteLayer
    public void setRouteSurfaceColor(int i4) {
        this.f7131g = this.mContext.getResources().getColor(i4);
    }

    private b a(int i4, int i5, com.baidu.platform.comapi.map.MapStatus mapStatus) {
        String str = i4 + "," + i5;
        LruCache<String, b> lruCache = this.f7132h;
        b bVar = lruCache != null ? lruCache.get(str) : null;
        if (bVar == null) {
            toScreenLocation(i4, i5, this.f7127c);
            Point point = this.f7127c;
            bVar = new b(point.f8600x, point.f8601y);
            if (lruCache != null) {
                lruCache.put(str, bVar);
            }
        }
        return bVar;
    }
}
