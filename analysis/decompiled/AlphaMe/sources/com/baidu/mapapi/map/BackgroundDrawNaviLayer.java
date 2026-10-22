package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer;
import com.baidu.mapapi.map.BackgroundDrawMapView;
import com.baidu.mapapi.map.entity.BackgroundNaviEntity;
import com.baidu.mapapi.map.entity.BackgroundNaviLocEntity;
import com.baidu.mapapi.map.entity.BackgroundNaviRealTimeInfoEntity;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BackgroundDrawNaviLayer extends AbsBackgroundDrawNaviLayer {

    /* renamed from: a, reason: collision with root package name */
    private Paint f6126a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f6127b;

    /* renamed from: c, reason: collision with root package name */
    private Point f6128c;

    /* renamed from: d, reason: collision with root package name */
    private Path f6129d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f6130e;

    /* renamed from: f, reason: collision with root package name */
    private final Object f6131f;

    /* renamed from: g, reason: collision with root package name */
    private Bitmap f6132g;

    /* renamed from: h, reason: collision with root package name */
    private final Object f6133h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f6134i;

    /* renamed from: j, reason: collision with root package name */
    private final Object f6135j;

    /* renamed from: k, reason: collision with root package name */
    private volatile a f6136k;

    /* renamed from: l, reason: collision with root package name */
    private volatile a f6137l;

    /* renamed from: m, reason: collision with root package name */
    private volatile a f6138m;

    /* renamed from: n, reason: collision with root package name */
    private volatile double f6139n;

    /* renamed from: o, reason: collision with root package name */
    private volatile boolean f6140o;

    /* renamed from: p, reason: collision with root package name */
    private volatile int f6141p;

    /* renamed from: q, reason: collision with root package name */
    private volatile int f6142q;

    /* renamed from: r, reason: collision with root package name */
    private volatile boolean f6143r;

    /* renamed from: s, reason: collision with root package name */
    private volatile int f6144s;

    /* renamed from: t, reason: collision with root package name */
    private AbsBackgroundDrawNaviLayer.EraseEffect f6145t;

    public class a {

        /* renamed from: a, reason: collision with root package name */
        private final BackgroundNaviRealTimeInfoEntity f6146a;

        /* renamed from: b, reason: collision with root package name */
        private final BackgroundNaviLocEntity f6147b;

        /* renamed from: c, reason: collision with root package name */
        private final double f6148c;

        /* renamed from: d, reason: collision with root package name */
        private final double f6149d;

        /* renamed from: e, reason: collision with root package name */
        private int f6150e = -1;

        /* renamed from: f, reason: collision with root package name */
        private int f6151f = -1;

        /* renamed from: g, reason: collision with root package name */
        private final long f6152g;

        public a(BackgroundNaviRealTimeInfoEntity backgroundNaviRealTimeInfoEntity, BackgroundNaviLocEntity backgroundNaviLocEntity, BackgroundNaviEntity backgroundNaviEntity) {
            ArrayList<LatLng> routeShapePoints;
            this.f6146a = backgroundNaviRealTimeInfoEntity;
            this.f6147b = backgroundNaviLocEntity;
            LatLng latLng = (backgroundNaviEntity == null || (routeShapePoints = backgroundNaviEntity.getRouteShapePoints()) == null || routeShapePoints.isEmpty()) ? null : routeShapePoints.get(0);
            if (latLng != null) {
                this.f6148c = latLng.longitude;
                this.f6149d = latLng.latitude;
            } else {
                this.f6148c = 0.0d;
                this.f6149d = 0.0d;
            }
            this.f6152g = System.currentTimeMillis();
        }

        public void a() {
            if (this.f6146a.isbIsNearOrFarawayStatus()) {
                BackgroundDrawNaviLayer.this.toScreenLocation((int) this.f6146a.getStPosX(), (int) this.f6146a.getStPosY(), BackgroundDrawNaviLayer.this.f6128c);
            } else {
                BackgroundDrawNaviLayer.this.toScreenLocation((int) this.f6146a.getStCurStartPosX(), (int) this.f6146a.getStCurStartPosY(), BackgroundDrawNaviLayer.this.f6128c);
            }
            this.f6150e = BackgroundDrawNaviLayer.this.f6128c.f8600x;
            this.f6151f = BackgroundDrawNaviLayer.this.f6128c.f8601y;
        }

        public boolean a(BackgroundNaviEntity backgroundNaviEntity) {
            ArrayList<LatLng> routeShapePoints;
            if (backgroundNaviEntity == null || (routeShapePoints = backgroundNaviEntity.getRouteShapePoints()) == null || routeShapePoints.isEmpty()) {
                return false;
            }
            LatLng latLng = routeShapePoints.get(0);
            return latLng.latitude == this.f6149d && latLng.longitude == this.f6148c;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f6154a;

        /* renamed from: b, reason: collision with root package name */
        private final float f6155b;

        /* renamed from: c, reason: collision with root package name */
        private final float f6156c;

        public b(int i4, float f4, float f5) {
            this.f6154a = i4;
            this.f6155b = f4;
            this.f6156c = f5;
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final List<Float> f6157a;

        /* renamed from: b, reason: collision with root package name */
        private final a f6158b;

        public c(List<Float> list, a aVar) {
            this.f6157a = list;
            this.f6158b = aVar;
        }
    }

    public BackgroundDrawNaviLayer(Context context) {
        super(context, 1);
        this.f6131f = new Object();
        this.f6133h = new Object();
        this.f6135j = new Object();
        this.f6140o = true;
        this.f6143r = false;
        this.f6141p = Color.parseColor("#50D27D");
        this.f6144s = Color.parseColor("#E7F1F6");
        this.f6142q = 10;
        this.f6145t = AbsBackgroundDrawNaviLayer.EraseEffect.NONE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(BackgroundDrawMapView.CanvasProxy canvasProxy, c cVar) {
        ArrayList<LatLng> routeShapePoints;
        int size;
        int i4;
        BackgroundNaviEntity backgroundNaviEntity = (BackgroundNaviEntity) this.mEntity;
        if (backgroundNaviEntity == null || (routeShapePoints = backgroundNaviEntity.getRouteShapePoints()) == null || routeShapePoints.isEmpty() || (size = routeShapePoints.size()) < 2) {
            return;
        }
        this.f6126a.setStrokeWidth(this.f6142q);
        b bVarA = a(cVar);
        Point point = null;
        if (this.f6145t == AbsBackgroundDrawNaviLayer.EraseEffect.NONE) {
            bVarA = null;
        }
        if (bVarA != null) {
            i4 = bVarA.f6154a;
            point = new Point(bVarA.f6155b, bVarA.f6156c);
        } else {
            i4 = 0;
        }
        int iMin = Math.min(i4, size);
        if (iMin > 0 && this.f6145t == AbsBackgroundDrawNaviLayer.EraseEffect.ALREADY_PASSED_CHANGE_COLOR) {
            this.f6129d.reset();
            toScreenLocation(routeShapePoints.get(0), this.f6128c);
            Path path = this.f6129d;
            Point point2 = this.f6128c;
            path.moveTo(point2.f8600x, point2.f8601y);
            for (int i5 = 1; i5 < iMin; i5++) {
                toScreenLocation(routeShapePoints.get(i5), this.f6128c);
                Path path2 = this.f6129d;
                Point point3 = this.f6128c;
                path2.lineTo(point3.f8600x, point3.f8601y);
            }
            if (point != null) {
                this.f6129d.lineTo(point.f8600x, point.f8601y);
            }
            this.f6126a.setColor(this.f6144s);
            canvasProxy.drawPath(this.f6129d, this.f6126a);
        }
        int iMax = Math.max(0, iMin - 1);
        this.f6129d.reset();
        if (point != null) {
            this.f6129d.moveTo(point.f8600x, point.f8601y);
            iMax = Math.max(0, this.f6137l.f6146a.getnCurRouteShapeIdx() - 1);
        } else {
            toScreenLocation(routeShapePoints.get(iMax), this.f6128c);
            Path path3 = this.f6129d;
            Point point4 = this.f6128c;
            path3.moveTo(point4.f8600x, point4.f8601y);
        }
        for (int i6 = iMax + 1; i6 < size; i6++) {
            toScreenLocation(routeShapePoints.get(i6), this.f6128c);
            Path path4 = this.f6129d;
            Point point5 = this.f6128c;
            path4.lineTo(point5.f8600x, point5.f8601y);
        }
        this.f6126a.setColor(this.f6141p);
        canvasProxy.drawPath(this.f6129d, this.f6126a);
        if (this.f6140o) {
            synchronized (this.f6131f) {
                try {
                    Bitmap bitmap = this.f6130e;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        toScreenLocation(routeShapePoints.get(0), this.f6128c);
                        canvasProxy.drawBitmap(bitmap, this.f6128c.f8600x - (bitmap.getWidth() / 2.0f), this.f6128c.f8601y - bitmap.getHeight(), this.f6127b);
                    }
                } finally {
                }
            }
            synchronized (this.f6133h) {
                try {
                    Bitmap bitmap2 = this.f6132g;
                    if (bitmap2 != null && !bitmap2.isRecycled()) {
                        toScreenLocation(routeShapePoints.get(size - 1), this.f6128c);
                        canvasProxy.drawBitmap(bitmap2, this.f6128c.f8600x - (bitmap2.getWidth() / 2.0f), this.f6128c.f8601y - bitmap2.getHeight(), this.f6127b);
                    }
                } finally {
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0083 A[EXC_TOP_SPLITTER, PHI: r1
      0x0083: PHI (r1v7 java.io.InputStream) = (r1v6 java.io.InputStream), (r1v17 java.io.InputStream) binds: [B:19:0x0081, B:15:0x0079] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v9 */
    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer, com.baidu.mapapi.map.BaseBackgroundDrawLayer, com.baidu.mapapi.map.IBackgroundDrawLayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate() throws java.lang.Throwable {
        /*
            r4 = this;
            super.onCreate()
            android.graphics.Paint r0 = new android.graphics.Paint
            r0.<init>()
            r4.f6126a = r0
            int r1 = r4.f6141p
            r0.setColor(r1)
            android.graphics.Paint r0 = r4.f6126a
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.STROKE
            r0.setStyle(r1)
            android.graphics.Paint r0 = r4.f6126a
            int r1 = r4.f6142q
            float r1 = (float) r1
            r0.setStrokeWidth(r1)
            android.graphics.Paint r0 = r4.f6126a
            android.graphics.CornerPathEffect r1 = new android.graphics.CornerPathEffect
            r2 = 1075838976(0x40200000, float:2.5)
            r1.<init>(r2)
            r0.setPathEffect(r1)
            android.graphics.Paint r0 = new android.graphics.Paint
            r0.<init>()
            r4.f6127b = r0
            android.graphics.Path r0 = new android.graphics.Path
            r0.<init>()
            r4.f6129d = r0
            com.baidu.platform.comapi.basestruct.Point r0 = new com.baidu.platform.comapi.basestruct.Point
            r0.<init>()
            r4.f6128c = r0
            r0 = 0
            android.graphics.Bitmap r1 = r4.f6130e     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L7c
            if (r1 != 0) goto L5f
            android.content.Context r1 = r4.mContext     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L7c
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L7c
            java.lang.String r2 = "SDK_Default_Icon_Start.png"
            java.io.InputStream r1 = r1.open(r2)     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L7c
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L7d
            r4.f6130e = r2     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L7d
            r1.close()     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L7d
            goto L60
        L5a:
            r4 = move-exception
            r0 = r1
            goto Lb9
        L5d:
            r4 = move-exception
            goto Lb9
        L5f:
            r1 = r0
        L60:
            android.graphics.Bitmap r2 = r4.f6132g     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L7d
            if (r2 != 0) goto L79
            android.content.Context r2 = r4.mContext     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L7d
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L7d
            java.lang.String r3 = "SDK_Default_Icon_End.png"
            java.io.InputStream r1 = r2.open(r3)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L7d
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L7d
            r4.f6132g = r2     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L7d
            r1.close()     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L7d
        L79:
            if (r1 == 0) goto L86
            goto L83
        L7c:
            r1 = r0
        L7d:
            r4.f6130e = r0     // Catch: java.lang.Throwable -> L5a
            r4.f6132g = r0     // Catch: java.lang.Throwable -> L5a
            if (r1 == 0) goto L86
        L83:
            r1.close()     // Catch: java.io.IOException -> L86
        L86:
            java.lang.Object r0 = r4.f6135j
            monitor-enter(r0)
            android.graphics.Bitmap r1 = r4.f6134i     // Catch: java.lang.Throwable -> La5
            if (r1 != 0) goto Lb5
            android.content.Context r1 = r4.mContext     // Catch: java.lang.Throwable -> La5 java.io.IOException -> Lb5
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch: java.lang.Throwable -> La5 java.io.IOException -> Lb5
            java.lang.String r2 = "SDK_Default_Icon_Passenger.png"
            java.io.InputStream r1 = r1.open(r2)     // Catch: java.lang.Throwable -> La5 java.io.IOException -> Lb5
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch: java.lang.Throwable -> La7
            r4.f6134i = r2     // Catch: java.lang.Throwable -> La7
            if (r1 == 0) goto Lb5
            r1.close()     // Catch: java.lang.Throwable -> La5 java.io.IOException -> Lb5
            goto Lb5
        La5:
            r4 = move-exception
            goto Lb7
        La7:
            r4 = move-exception
            throw r4     // Catch: java.lang.Throwable -> La9
        La9:
            r2 = move-exception
            if (r1 == 0) goto Lb4
            r1.close()     // Catch: java.lang.Throwable -> Lb0
            goto Lb4
        Lb0:
            r1 = move-exception
            r4.addSuppressed(r1)     // Catch: java.lang.Throwable -> La5 java.io.IOException -> Lb5
        Lb4:
            throw r2     // Catch: java.lang.Throwable -> La5 java.io.IOException -> Lb5
        Lb5:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La5
            return
        Lb7:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La5
            throw r4
        Lb9:
            if (r0 == 0) goto Lbe
            r0.close()     // Catch: java.io.IOException -> Lbe
        Lbe:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.BackgroundDrawNaviLayer.onCreate():void");
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer, com.baidu.mapapi.map.BaseBackgroundDrawLayer, com.baidu.mapapi.map.IBackgroundDrawLayer
    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.f6130e;
        Bitmap bitmap2 = this.f6132g;
        Bitmap bitmap3 = this.f6134i;
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            bitmap2.recycle();
        }
        if (bitmap3 != null && !bitmap3.isRecycled()) {
            bitmap3.recycle();
        }
        this.f6130e = null;
        this.f6132g = null;
        this.f6134i = null;
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
        c cVarA = a();
        b(canvasProxy, cVarA);
        a(canvasProxy, cVarA);
        canvasProxy.restore();
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setEraseColor(int i4) {
        this.f6144s = this.mContext.getResources().getColor(i4);
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setEraseEffect(AbsBackgroundDrawNaviLayer.EraseEffect eraseEffect) {
        this.f6145t = eraseEffect;
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setIsLocationDirectionFollowPhone(boolean z4) {
        this.f6143r = z4;
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setIsNeedShowStartAndEndMark(boolean z4) {
        this.f6140o = z4;
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setNaviEndMark(Bitmap bitmap) {
        synchronized (this.f6133h) {
            try {
                Bitmap bitmap2 = this.f6132g;
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
                this.f6132g = bitmap;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setNaviLocationMark(Bitmap bitmap) {
        synchronized (this.f6135j) {
            try {
                Bitmap bitmap2 = this.f6134i;
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
                this.f6134i = bitmap;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setNaviRouteColor(int i4) {
        this.f6141p = this.mContext.getResources().getColor(i4);
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setNaviRouteWidth(int i4) {
        this.f6142q = Math.min(30, Math.max(1, i4));
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setNaviStartMark(Bitmap bitmap) {
        synchronized (this.f6131f) {
            try {
                Bitmap bitmap2 = this.f6130e;
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
                this.f6130e = bitmap;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void updateHeading(double d4) {
        this.f6139n = d4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateNaviRealTimeInfo(BackgroundNaviRealTimeInfoEntity backgroundNaviRealTimeInfoEntity, BackgroundNaviLocEntity backgroundNaviLocEntity) {
        if (backgroundNaviRealTimeInfoEntity == null || backgroundNaviLocEntity == null) {
            return;
        }
        a aVar = this.f6137l;
        if (aVar != null) {
            BackgroundNaviRealTimeInfoEntity backgroundNaviRealTimeInfoEntity2 = aVar.f6146a;
            BackgroundNaviLocEntity backgroundNaviLocEntity2 = aVar.f6147b;
            if (backgroundNaviLocEntity2.getGpsLatitude() == backgroundNaviLocEntity.getGpsLatitude() && backgroundNaviLocEntity2.getGpsLongitude() == backgroundNaviLocEntity.getPostLongitude()) {
                return;
            }
            if (backgroundNaviRealTimeInfoEntity2.getStPosY() == backgroundNaviRealTimeInfoEntity.getStPosY() && backgroundNaviRealTimeInfoEntity2.getStPosX() == backgroundNaviRealTimeInfoEntity.getStPosX()) {
                return;
            }
        }
        this.f6136k = aVar;
        this.f6137l = new a(backgroundNaviRealTimeInfoEntity, backgroundNaviLocEntity, (BackgroundNaviEntity) this.mEntity);
    }

    private void a(BackgroundDrawMapView.CanvasProxy canvasProxy, c cVar) {
        Bitmap bitmap;
        MapController mapController;
        com.baidu.platform.comapi.map.MapStatus mapStatus;
        List list;
        a aVar = this.f6137l;
        if (aVar == null || (bitmap = this.f6134i) == null || bitmap.isRecycled() || (mapController = this.mController) == null || (mapStatus = mapController.getMapStatus()) == null || cVar == null || (list = cVar.f6157a) == null || list.size() != 2) {
            return;
        }
        float fFloatValue = ((Float) list.get(0)).floatValue();
        float fFloatValue2 = ((Float) list.get(1)).floatValue();
        float gpsDirection = !this.f6143r ? aVar.f6147b.getGpsDirection() - mapStatus.rotation : (float) (this.f6139n - mapStatus.rotation);
        canvasProxy.save();
        canvasProxy.rotate(gpsDirection, fFloatValue, fFloatValue2);
        canvasProxy.drawBitmap(bitmap, fFloatValue - (bitmap.getWidth() / 2.0f), fFloatValue2 - (bitmap.getHeight() / 2.0f), this.f6127b);
        canvasProxy.restore();
    }

    private c a() {
        a aVar = this.f6137l;
        if (aVar == null) {
            return null;
        }
        aVar.a();
        ArrayList arrayList = new ArrayList(2);
        a aVar2 = this.f6136k;
        if (aVar2 == null) {
            arrayList.add(Float.valueOf(aVar.f6150e));
            arrayList.add(Float.valueOf(aVar.f6151f));
            return new c(arrayList, aVar);
        }
        long j4 = aVar.f6152g - aVar2.f6152g;
        if (j4 <= 0) {
            arrayList.add(Float.valueOf(aVar.f6150e));
            arrayList.add(Float.valueOf(aVar.f6151f));
            return new c(arrayList, aVar);
        }
        if (System.currentTimeMillis() - aVar.f6152g >= j4) {
            arrayList.add(Float.valueOf(aVar.f6150e));
            arrayList.add(Float.valueOf(aVar.f6151f));
            return new c(arrayList, aVar);
        }
        aVar2.a();
        float f4 = j4;
        arrayList.add(Float.valueOf((((aVar.f6150e - aVar2.f6150e) * r4) / f4) + aVar2.f6150e));
        arrayList.add(Float.valueOf((((aVar.f6151f - aVar2.f6151f) * r4) / f4) + aVar2.f6151f));
        return new c(arrayList, aVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.baidu.mapapi.map.BackgroundDrawNaviLayer.b a(com.baidu.mapapi.map.BackgroundDrawNaviLayer.c r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.util.List r1 = com.baidu.mapapi.map.BackgroundDrawNaviLayer.c.a(r4)
            com.baidu.mapapi.map.BackgroundDrawNaviLayer$a r4 = com.baidu.mapapi.map.BackgroundDrawNaviLayer.c.b(r4)
            if (r1 == 0) goto L84
            if (r4 != 0) goto L11
            goto L84
        L11:
            com.baidu.mapapi.map.entity.BackgroundNaviRealTimeInfoEntity r2 = com.baidu.mapapi.map.BackgroundDrawNaviLayer.a.a(r4)
            boolean r2 = r2.isbIsNearOrFarawayStatus()
            if (r2 != 0) goto L2b
            com.baidu.mapapi.map.BackgroundDrawNaviLayer$a r2 = r3.f6137l
            if (r2 == 0) goto L50
            com.baidu.mapapi.map.BackgroundDrawNaviLayer$a r2 = r3.f6137l
            com.baidu.mapapi.map.entity.BackgroundNaviRealTimeInfoEntity r2 = com.baidu.mapapi.map.BackgroundDrawNaviLayer.a.a(r2)
            boolean r2 = r2.isbIsNearOrFarawayStatus()
            if (r2 == 0) goto L50
        L2b:
            com.baidu.mapapi.map.BackgroundDrawNaviLayer$a r4 = r3.f6138m
            if (r4 == 0) goto L50
            r4.a()
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 2
            r1.<init>(r2)
            int r2 = com.baidu.mapapi.map.BackgroundDrawNaviLayer.a.c(r4)
            float r2 = (float) r2
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r1.add(r2)
            int r2 = com.baidu.mapapi.map.BackgroundDrawNaviLayer.a.d(r4)
            float r2 = (float) r2
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r1.add(r2)
        L50:
            if (r4 != 0) goto L53
            return r0
        L53:
            T r2 = r3.mEntity
            com.baidu.mapapi.map.entity.BackgroundNaviEntity r2 = (com.baidu.mapapi.map.entity.BackgroundNaviEntity) r2
            boolean r2 = r4.a(r2)
            if (r2 != 0) goto L5e
            return r0
        L5e:
            r3.f6138m = r4
            com.baidu.mapapi.map.BackgroundDrawNaviLayer$b r3 = new com.baidu.mapapi.map.BackgroundDrawNaviLayer$b
            com.baidu.mapapi.map.entity.BackgroundNaviRealTimeInfoEntity r4 = com.baidu.mapapi.map.BackgroundDrawNaviLayer.a.a(r4)
            int r4 = r4.getnCurRouteShapeIdx()
            r0 = 0
            java.lang.Object r0 = r1.get(r0)
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            r2 = 1
            java.lang.Object r1 = r1.get(r2)
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            r3.<init>(r4, r0, r1)
            return r3
        L84:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.BackgroundDrawNaviLayer.a(com.baidu.mapapi.map.BackgroundDrawNaviLayer$c):com.baidu.mapapi.map.BackgroundDrawNaviLayer$b");
    }
}
