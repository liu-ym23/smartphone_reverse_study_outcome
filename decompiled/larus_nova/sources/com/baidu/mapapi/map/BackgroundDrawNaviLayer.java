package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import androidx.camera.video.AudioStats;
import com.baidu.mapapi.map.entity.BackgroundNaviEntity;
import com.baidu.mapapi.map.entity.BackgroundNaviLocEntity;
import com.baidu.mapapi.map.entity.BackgroundNaviRealTimeInfoEntity;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class BackgroundDrawNaviLayer extends AbsBackgroundDrawNaviLayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f30668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f30669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Point f30670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Path f30671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Bitmap f30672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f30673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Bitmap f30674g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f30675h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Bitmap f30676i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Object f30677j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile a f30678k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile a f30679l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile a f30680m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile double f30681n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private volatile boolean f30682o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private volatile int f30683p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private volatile int f30684q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private volatile boolean f30685r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private volatile int f30686s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private AbsBackgroundDrawNaviLayer.EraseEffect f30687t;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BackgroundNaviRealTimeInfoEntity f30688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BackgroundNaviLocEntity f30689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final double f30690c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final double f30691d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f30692e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f30693f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f30694g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ BackgroundDrawNaviLayer f30695h;

        public void a() {
            if (this.f30688a.isbIsNearOrFarawayStatus() == false) goto L5;
            this.f30695h.toScreenLocation((int) this.f30688a.getStPosX(), (int) this.f30688a.getStPosY(), BackgroundDrawNaviLayer.a(this.f30695h));
        L6:
            this.f30692e = BackgroundDrawNaviLayer.a(this.f30695h).f32737x;
            this.f30693f = BackgroundDrawNaviLayer.a(this.f30695h).f32738y;
            return;
        L5:
            this.f30695h.toScreenLocation((int) this.f30688a.getStCurStartPosX(), (int) this.f30688a.getStCurStartPosY(), BackgroundDrawNaviLayer.a(this.f30695h));
            goto L6
        }

        public static /* synthetic */ BackgroundNaviLocEntity b(a r100) {
            return r100.f30689b;
        }

        public static /* synthetic */ int c(a r100) {
            return r100.f30692e;
        }

        public static /* synthetic */ int d(a r100) {
            return r100.f30693f;
        }

        public static /* synthetic */ long e(a r100) {
            return r100.f30694g;
        }

        public boolean a(BackgroundNaviEntity r100) {
            if (r100 != null) goto L5;
            return false;
        L5:
            ArrayList<LatLng> r101 = r100.getRouteShapePoints();
            if (r101 != null) goto L8;
            return false;
        L8:
            if (r101.isEmpty() == true) goto L19;
            LatLng r102 = (LatLng) ListProtector.get(r101, 0);
            if (r102.latitude == this.f30691d) goto L13;
            return false;
        L13:
            if (r102.longitude != this.f30690c) goto L18;
            return true;
        L18:
            return false;
        L19:
            return false;
        }

        public static /* synthetic */ BackgroundNaviRealTimeInfoEntity a(a r100) {
            return r100.f30688a;
        }

        public a(BackgroundDrawNaviLayer r100, BackgroundNaviRealTimeInfoEntity r101, BackgroundNaviLocEntity r102, BackgroundNaviEntity r103) {
            this.f30695h = r100;
            this.f30692e = -1;
            this.f30693f = -1;
            this.f30688a = r101;
            this.f30689b = r102;
            if (r103 == null) goto L9;
            ArrayList<LatLng> r104 = r103.getRouteShapePoints();
            if (r104 == null) goto L9;
            if (r104.isEmpty() == true) goto L9;
            LatLng r105 = (LatLng) ListProtector.get(r104, 0);
        L10:
            if (r105 == null) goto L12;
            this.f30690c = r105.longitude;
            this.f30691d = r105.latitude;
        L13:
            this.f30694g = System.currentTimeMillis();
            return;
        L12:
            this.f30690c = AudioStats.AUDIO_AMPLITUDE_NONE;
            this.f30691d = AudioStats.AUDIO_AMPLITUDE_NONE;
        L9:
            r105 = null;
            goto L10
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f30696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f30697b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f30698c;

        public static /* synthetic */ int a(b r100) {
            return r100.f30696a;
        }

        public static /* synthetic */ float b(b r100) {
            return r100.f30697b;
        }

        public static /* synthetic */ float c(b r100) {
            return r100.f30698c;
        }

        public b(int r100, float r101, float r102) {
            this.f30696a = r100;
            this.f30697b = r101;
            this.f30698c = r102;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<Float> f30699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f30700b;

        public static /* synthetic */ List a(c r100) {
            return r100.f30699a;
        }

        public static /* synthetic */ a b(c r100) {
            return r100.f30700b;
        }

        public c(List<Float> r100, a r101) {
            this.f30699a = r100;
            this.f30700b = r101;
        }
    }

    private c a() {
        a r100 = this.f30679l;
        if (r100 != null) goto L6;
        return null;
    L6:
        r100.a();
        ArrayList r101 = new ArrayList(2);
        a r102 = this.f30678k;
        if (r102 != null) goto L10;
        r101.add(Float.valueOf(a.c(r100)));
        r101.add(Float.valueOf(a.d(r100)));
        return new c(r101, r100);
    L10:
        long r103 = a.e(r100) - a.e(r102);
        if (r103 > 0) goto L14;
        r101.add(Float.valueOf(a.c(r100)));
        r101.add(Float.valueOf(a.d(r100)));
        return new c(r101, r100);
    L14:
        long r104 = System.currentTimeMillis() - a.e(r100);
        if (r104 < r103) goto L18;
        r101.add(Float.valueOf(a.c(r100)));
        r101.add(Float.valueOf(a.d(r100)));
        return new c(r101, r100);
    L18:
        r102.a();
        float r105 = r103;
        r101.add(Float.valueOf(a.c(r102) + ((((long) (a.c(r100) - a.c(r102))) * r104) / r105)));
        r101.add(Float.valueOf(a.d(r102) + ((((long) (a.d(r100) - a.d(r102))) * r104) / r105)));
        return new c(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.graphics.Paint] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.graphics.CornerPathEffect, android.graphics.PathEffect] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.InputStream] */
    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer, com.baidu.mapapi.map.BaseBackgroundDrawLayer, com.baidu.mapapi.map.IBackgroundDrawLayer
    public void onCreate() {
        super.onCreate();
        Paint r100 = new Paint();
        this.f30668a = r100;
        r100.setColor(this.f30683p);
        this.f30668a.setStyle(Paint.Style.STROKE);
        this.f30668a.setStrokeWidth(this.f30684q);
        ?? r101 = this.f30668a;
        ?? r102 = new CornerPathEffect(2.5f);
        r101.setPathEffect(r102);
        this.f30669b = new Paint();
        this.f30671d = new Path();
        this.f30670c = new Point();
    L13:
        Throwable th10 = th;
    L44:
        if (r102 != 0) goto L62;
    L46:
        throw th10;
    L62:
        r102.close();     // Catch: IOException -> L49
    L17:
        InputStream r103 = null;
    L18:
        this.f30672e = null;     // Catch: Throwable -> L13
        this.f30674g = null;     // Catch: Throwable -> L13
        if (r103 != null) goto L53;
    L21:
        Object r104 = this.f30677j;
        monitor-enter(r104);
    L41:
        th = move-exception;
        throw th;
    L24:
        if (this.f30676i == null) goto L55;
    L39:
        monitor-exit(r104);     // Catch: Throwable -> L41
        return;
    L55:
        InputStream r105 = this.mContext.getAssets().open("SDK_Default_Icon_Passenger.png");     // Catch: IOException -> L48 Throwable -> L41
        this.f30676i = BitmapFactory.decodeStream(r105);     // Catch: Throwable -> L30
        if (r105 == null) goto L39;
        r105.close();     // Catch: IOException -> L48 Throwable -> L41
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        if (r105 != null) goto L51;
    L38:
        throw th;     // Catch: IOException -> L48 Throwable -> L41
    L51:
        r105.close();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L48 Throwable -> L41
    L53:
        r103.close();     // Catch: IOException -> L47
    L15:
        th = move-exception;
        r102 = 0;
        th10 = th;
        goto L44
    L4:
        if (this.f30672e != null) goto L7;
        r103 = this.mContext.getAssets().open("SDK_Default_Icon_Start.png");     // Catch: Throwable -> L15 IOException -> L17
        this.f30672e = BitmapFactory.decodeStream(r103);     // Catch: Throwable -> L13 IOException -> L50
        r103.close();     // Catch: Throwable -> L13 IOException -> L50
    L9:
        if (this.f30674g != null) goto L11;
        r103 = this.mContext.getAssets().open("SDK_Default_Icon_End.png");     // Catch: Throwable -> L13 IOException -> L50
        this.f30674g = BitmapFactory.decodeStream(r103);     // Catch: Throwable -> L13 IOException -> L50
        r103.close();     // Catch: Throwable -> L13 IOException -> L50
    L11:
        if (r103 == null) goto L21;
    L7:
        r103 = null;
        goto L9
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer, com.baidu.mapapi.map.BaseBackgroundDrawLayer, com.baidu.mapapi.map.IBackgroundDrawLayer
    public void onDestroy() {
        super.onDestroy();
        Bitmap r100 = this.f30672e;
        Bitmap r101 = this.f30674g;
        Bitmap r102 = this.f30676i;
        if (r100 != null) goto L5;
    L7:
        if (r101 != null) goto L9;
    L11:
        if (r102 != null) goto L13;
    L15:
        this.f30672e = null;
        this.f30674g = null;
        this.f30676i = null;
        return;
    L13:
        if (r102.isRecycled() == true) goto L15;
        r102.recycle();
        goto L15
    L9:
        if (r101.isRecycled() == true) goto L11;
        r101.recycle();
        goto L11
    L5:
        if (r100.isRecycled() == true) goto L7;
        r100.recycle();
        goto L7
    }

    public BackgroundDrawNaviLayer(Context r100) {
        super(r100, 1);
        this.f30673f = new Object();
        this.f30675h = new Object();
        this.f30677j = new Object();
        this.f30682o = true;
        this.f30685r = false;
        this.f30683p = ColorProtector.parseColor("#50D27D");
        this.f30686s = ColorProtector.parseColor("#E7F1F6");
        this.f30684q = 10;
        this.f30687t = AbsBackgroundDrawNaviLayer.EraseEffect.NONE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private b a(c r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        List r101 = c.a(r100);
        a r102 = c.b(r100);
        if (r101 == null) goto L25;
        if (r102 != null) goto L10;
        return null;
    L10:
        if (a.a(r102).isbIsNearOrFarawayStatus() == true) goto L15;
        List r103 = r101;
        if (this.f30679l == null) goto L18;
        r103 = r101;
        if (a.a(this.f30679l).isbIsNearOrFarawayStatus() == true) goto L15;
    L18:
        if (r102 != null) goto L21;
        return null;
    L21:
        if (r102.a((BackgroundNaviEntity) this.mEntity) == true) goto L23;
        return null;
    L23:
        this.f30680m = r102;
        return new b(a.a(r102).getnCurRouteShapeIdx(), ((Float) ListProtector.get(r103, 0)).floatValue(), ((Float) ListProtector.get(r103, 1)).floatValue());
    L15:
        r102 = this.f30680m;
        r103 = r101;
        if (r102 == null) goto L18;
        r102.a();
        ArrayList r104 = new ArrayList(2);
        r104.add(Float.valueOf(a.c(r102)));
        r104.add(Float.valueOf(a.d(r102)));
        r103 = r104;
        goto L18
    L25:
        return null;
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawLayer
    public void onDraw(BackgroundDrawMapView.CanvasProxy r100) {
        MapController r101 = this.mController;
        if (r101 != null) goto L5;
        return;
    L5:
        com.baidu.platform.comapi.map.MapStatus r102 = r101.getMapStatus();
        if (r102 != null) goto L8;
        return;
    L8:
        com.baidu.platform.comapi.map.MapStatus.WinRound r103 = r102.winRound;
        if (r103 != null) goto L11;
        return;
    L11:
        int r104 = Math.abs(r103.right - r103.left);
        int r105 = Math.abs(r103.bottom - r103.top);
        if (r105 <= 0) goto L37;
        if (r104 > 0) goto L16;
        return;
    L16:
        if (this.mWidth > 0) goto L18;
        return;
    L18:
        if (this.mHeight <= 0) goto L40;
        r100.save();
        r100.translate((this.mWidth - r104) / 2.0f, (this.mHeight - r105) / 2.0f);
        int r106 = this.mWidth;
        if (r106 == r104) goto L35;
        int r107 = this.mHeight;
        if (r107 == r105) goto L35;
        if (r106 < r104) goto L28;
        if (r107 < r105) goto L28;
        int r108 = Math.min(r106 / r104, r107 / r105);
    L27:
        float r109 = r108;
    L34:
        r100.scale(r109, r109, this.mWidth / 2.0f, this.mHeight / 2.0f);
    L28:
        if (r106 > r104) goto L31;
        if (r107 > r105) goto L31;
        r108 = Math.min(r104 / r106, r105 / r107);
    L31:
        if (r106 > r104) goto L33;
        r109 = r107 / r105;
        goto L34
    L33:
        r109 = r106 / r104;
    L35:
        c r110 = a();
        b(r100, r110);
        a(r100, r110);
        r100.restore();
        return;
    L40:
        return;
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setEraseColor(int r100) {
        this.f30686s = this.mContext.getResources().getColor(r100);
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setEraseEffect(AbsBackgroundDrawNaviLayer.EraseEffect r100) {
        this.f30687t = r100;
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setIsLocationDirectionFollowPhone(boolean r100) {
        this.f30685r = r100;
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setIsNeedShowStartAndEndMark(boolean r100) {
        this.f30682o = r100;
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setNaviEndMark(Bitmap r100) {
        Object r101 = this.f30675h;
        monitor-enter(r101);
        Bitmap r102 = this.f30674g;     // Catch: Throwable -> L12
        if (r102 != null) goto L7;
    L9:
        this.f30674g = r100;     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L7:
        if (r102.isRecycled() == true) goto L9;
        r102.recycle();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setNaviLocationMark(Bitmap r100) {
        Object r101 = this.f30677j;
        monitor-enter(r101);
        Bitmap r102 = this.f30676i;     // Catch: Throwable -> L12
        if (r102 != null) goto L7;
    L9:
        this.f30676i = r100;     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L7:
        if (r102.isRecycled() == true) goto L9;
        r102.recycle();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setNaviRouteColor(int r100) {
        this.f30683p = this.mContext.getResources().getColor(r100);
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setNaviRouteWidth(int r100) {
        this.f30684q = Math.min(30, Math.max(1, r100));
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setNaviStartMark(Bitmap r100) {
        Object r101 = this.f30673f;
        monitor-enter(r101);
        Bitmap r102 = this.f30672e;     // Catch: Throwable -> L12
        if (r102 != null) goto L7;
    L9:
        this.f30672e = r100;     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L7:
        if (r102.isRecycled() == true) goto L9;
        r102.recycle();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public void updateHeading(double r100) {
        this.f30681n = r100;
    }

    public static /* synthetic */ Point a(BackgroundDrawNaviLayer r100) {
        return r100.f30670c;
    }

    private void a(BackgroundDrawMapView.CanvasProxy r100, c r110) {
        a r101 = this.f30679l;
        if (r101 != null) goto L5;
        return;
    L5:
        Bitmap r102 = this.f30676i;
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.isRecycled() == false) goto L11;
        return;
    L11:
        MapController r103 = this.mController;
        if (r103 != null) goto L14;
        return;
    L14:
        com.baidu.platform.comapi.map.MapStatus r104 = r103.getMapStatus();
        if (r104 != null) goto L17;
        return;
    L17:
        if (r110 != null) goto L19;
        return;
    L19:
        List r111 = c.a(r110);
        if (r111 != null) goto L23;
        return;
    L23:
        if (r111.size() == 2) goto L25;
        return;
    L25:
        float r105 = ((Float) ListProtector.get(r111, 0)).floatValue();
        float r112 = ((Float) ListProtector.get(r111, 1)).floatValue();
        if (this.f30685r == true) goto L28;
        float r106 = a.b(r101).getGpsDirection() - r104.rotation;
    L29:
        r100.save();
        r100.rotate(r106, r105, r112);
        r100.drawBitmap(r102, r105 - (r102.getWidth() / 2.0f), r112 - (r102.getHeight() / 2.0f), this.f30669b);
        r100.restore();
        return;
    L28:
        r106 = (float) (this.f30681n - ((double) r104.rotation));
        goto L29
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(BackgroundDrawMapView.CanvasProxy r110, c r111) {
        BackgroundNaviEntity r100 = (BackgroundNaviEntity) this.mEntity;
        if (r100 != null) goto L5;
        return;
    L5:
        ArrayList<LatLng> r101 = r100.getRouteShapePoints();
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.isEmpty() == true) goto L71;
        int r102 = r101.size();
        if (r102 >= 2) goto L13;
        return;
    L13:
        this.f30668a.setStrokeWidth(this.f30684q);
        b r112 = a(r111);
        Point r103 = null;
        if (this.f30687t != AbsBackgroundDrawNaviLayer.EraseEffect.NONE) goto L17;
        r112 = null;
    L17:
        if (r112 == null) goto L19;
        int r104 = b.a(r112);
        r103 = new Point(b.b(r112), b.c(r112));
    L20:
        int r113 = Math.min(r104, r102);
        if (r113 > 0) goto L23;
    L30:
        int r114 = Math.max(0, r113 - 1);
        this.f30671d.reset();
        if (r103 == null) goto L33;
        this.f30671d.moveTo(r103.f32737x, r103.f32738y);
        r114 = Math.max(0, a.a(this.f30679l).getnCurRouteShapeIdx() - 1);
    L34:
        int r115 = r114 + 1;
    L35:
        if (r115 >= r102) goto L37;
        toScreenLocation((LatLng) ListProtector.get(r101, r115), this.f30670c);
        Path r105 = this.f30671d;
        Point r106 = this.f30670c;
        r105.lineTo(r106.f32737x, r106.f32738y);
        r115 = r115 + 1;
        goto L35
    L37:
        this.f30668a.setColor(this.f30683p);
        r110.drawPath(this.f30671d, this.f30668a);
        if (this.f30682o == false) goto L69;
        Object r116 = this.f30673f;
        monitor-enter(r116);
        Bitmap r107 = this.f30672e;     // Catch: Throwable -> L59
        if (r107 != null) goto L44;
    L46:
        monitor-exit(r116);     // Catch: Throwable -> L59
        Object r108 = this.f30675h;
        monitor-enter(r108);
        Bitmap r117 = this.f30674g;     // Catch: Throwable -> L56
        if (r117 != null) goto L52;
    L54:
        monitor-exit(r108);     // Catch: Throwable -> L56
        return;
    L52:
        if (r117.isRecycled() == true) goto L54;
        toScreenLocation(r101.get(r102 - 1), this.f30670c);     // Catch: Throwable -> L56
        r110.drawBitmap(r117, this.f30670c.f32737x - (r117.getWidth() / 2.0f), this.f30670c.f32738y - r117.getHeight(), this.f30669b);     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        throw th;
    L44:
        if (r107.isRecycled() == true) goto L46;
        toScreenLocation(r101.get(0), this.f30670c);     // Catch: Throwable -> L59
        r110.drawBitmap(r107, this.f30670c.f32737x - (r107.getWidth() / 2.0f), this.f30670c.f32738y - r107.getHeight(), this.f30669b);     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        throw th;
    L69:
        return;
    L33:
        toScreenLocation((LatLng) ListProtector.get(r101, r114), this.f30670c);
        Path r109 = this.f30671d;
        Point r118 = this.f30670c;
        r109.moveTo(r118.f32737x, r118.f32738y);
        goto L34
    L23:
        if (this.f30687t != AbsBackgroundDrawNaviLayer.EraseEffect.ALREADY_PASSED_CHANGE_COLOR) goto L30;
        this.f30671d.reset();
        toScreenLocation((LatLng) ListProtector.get(r101, 0), this.f30670c);
        Path r119 = this.f30671d;
        Point r120 = this.f30670c;
        r119.moveTo(r120.f32737x, r120.f32738y);
        int r121 = 1;
    L25:
        if (r121 >= r113) goto L27;
        toScreenLocation((LatLng) ListProtector.get(r101, r121), this.f30670c);
        Path r122 = this.f30671d;
        Point r123 = this.f30670c;
        r122.lineTo(r123.f32737x, r123.f32738y);
        r121 = r121 + 1;
        goto L25
    L27:
        if (r103 == null) goto L29;
        this.f30671d.lineTo(r103.f32737x, r103.f32738y);
    L29:
        this.f30668a.setColor(this.f30686s);
        r110.drawPath(this.f30671d, this.f30668a);
        goto L30
    L19:
        r104 = 0;
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateNaviRealTimeInfo(BackgroundNaviRealTimeInfoEntity r100, BackgroundNaviLocEntity r110) {
        if (r100 == null) goto L19;
        if (r110 == null) goto L20;
        a r101 = this.f30679l;
        if (r101 == null) goto L17;
        BackgroundNaviRealTimeInfoEntity r102 = a.a(r101);
        BackgroundNaviLocEntity r103 = a.b(r101);
        if (r103.getGpsLatitude() != r110.getGpsLatitude()) goto L13;
        if (r103.getGpsLongitude() != r110.getPostLongitude()) goto L13;
        return;
    L13:
        if (r102.getStPosY() != r100.getStPosY()) goto L17;
        if (r102.getStPosX() != r100.getStPosX()) goto L17;
        return;
    L17:
        this.f30678k = r101;
        this.f30679l = new a(this, r100, r110, (BackgroundNaviEntity) this.mEntity);
        return;
    L20:
        return;
    }
}
