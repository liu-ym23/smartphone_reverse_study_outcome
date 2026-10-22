package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.LruCache;
import androidx.camera.video.AudioStats;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.color.ColorProtector;

/* JADX INFO: loaded from: classes39.dex */
class a extends com.baidu.mapapi.map.b<Bundle> implements IBackgroundDrawBaseRouteLayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f31560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Path f31561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Point f31562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint f31563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f31564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f31565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f31566g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final LruCache<String, b> f31567h;

    /* JADX INFO: renamed from: com.baidu.mapapi.map.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0630a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f31568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f31569b;

        public int hashCode() {
            return Float.floatToIntBits(this.f31568a) + Float.floatToIntBits(this.f31569b);
        }

        public static /* synthetic */ float a(b r100) {
            return r100.f31568a;
        }

        public static /* synthetic */ float b(b r100) {
            return r100.f31569b;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof b) == true) goto L5;
            return false;
        L5:
            b r101 = (b) r100;
            if (this.f31568a == r101.f31568a) goto L8;
            return false;
        L8:
            if (this.f31569b != r101.f31569b) goto L12;
            return true;
        L12:
            return false;
        }

        public b(float r100, float r101) {
            this.f31568a = r100;
            this.f31569b = r101;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Bundle f31570a;

        public void f() {
            this.f31570a = null;
        }

        public double a() {
            Bundle r100 = this.f31570a;
            if (r100 != null) goto L6;
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        L6:
            return r100.getDouble("ulWidth", AudioStats.AUDIO_AMPLITUDE_NONE);
        }

        public int[] b() {
            Bundle r100 = this.f31570a;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getIntArray("allPtX");
        }

        public int[] c() {
            Bundle r100 = this.f31570a;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getIntArray("allPtY");
        }

        public boolean d() {
            Bundle r100 = this.f31570a;
            if (r100 != null) goto L6;
            return false;
        L6:
            if (r100.getInt("bIsClosedRegion", 0) != 1) goto L9;
            return true;
        L9:
            return false;
        }

        public boolean e() {
            if (this.f31570a == null) goto L5;
            return true;
        L5:
            return false;
        }

        private c() {
        }

        public /* synthetic */ c(C0630a r100) {
            this();
        }

        public void a(Bundle r100) {
            this.f31570a = r100;
        }
    }

    @Override // com.baidu.mapapi.map.BaseBackgroundDrawLayer, com.baidu.mapapi.map.IBackgroundDrawLayer
    public void onCreate() {
        super.onCreate();
        this.f31560a = new c(null);
        this.f31562c = new Point(-1, -1);
        this.f31561b = new Path();
        this.f31563d = new Paint();
    }

    @Override // com.baidu.mapapi.map.BaseBackgroundDrawLayer, com.baidu.mapapi.map.IBackgroundDrawLayer
    public void onDestroy() {
        super.onDestroy();
    }

    public a(Context r100) {
        super(r100);
        this.f31564e = ColorProtector.parseColor("#EFEEE9");
        this.f31565f = ColorProtector.parseColor("#9B9B9B");
        this.f31566g = ColorProtector.parseColor("#9B9B9B");
        this.f31567h = new LruCache(2097152);
    }

    private void a(BackgroundDrawMapView.CanvasProxy r100) {
        r100.drawColor(this.f31564e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(BackgroundDrawMapView.CanvasProxy r110) {
        Bundle r100 = (Bundle) this.mEntity;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.size();
        if (r101 > 0) goto L8;
        return;
    L8:
        c r102 = this.f31560a;
        if (r102 != null) goto L11;
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
        this.f31567h.evictAll();
        char r105 = 0;
        int r106 = 0;
    L18:
        if (r106 >= r101) goto L53;
        if (getLife() == 2) goto L21;
        r102.a(r100.getBundle(String.valueOf(r106)));
        if (r102.e() == false) goto L52;
        float r107 = (float) r102.a();
        boolean r108 = r102.d();
        if (r108 == false) goto L28;
    L30:
        if (r108 == false) goto L32;
        r107 = 0.0f;
    L32:
        int[] r111 = r102.b();
        int[] r112 = r102.c();
        if (r111 == null) goto L52;
        if (r112 == null) goto L52;
        int r113 = r111.length;
        if (r113 < 2) goto L52;
        if (r113 != r112.length) goto L52;
        this.f31561b.reset();
        b r114 = a(r111[r105], r112[r105], r104);
        this.f31561b.moveTo(b.a(r114), b.b(r114));
        int r115 = 1;
    L43:
        if (r115 >= r113) goto L48;
        if (getLife() == 2) goto L46;
        b r116 = a(r111[r115], r112[r115], r104);
        this.f31561b.lineTo(b.a(r116), b.b(r116));
        r115 = r115 + 1;
        goto L43
    L46:
        return;
    L48:
        this.f31563d.setStrokeWidth(r107);
        this.f31563d.setColor(this.f31565f);
        this.f31563d.setStyle(Paint.Style.STROKE);
        if (r108 == false) goto L51;
        this.f31563d.setColor(this.f31566g);
        this.f31563d.setStyle(Paint.Style.FILL);
    L51:
        r110.drawPath(this.f31561b, this.f31563d);
        r102.f();
        goto L52
    L28:
        if (r107 > 0.0f) goto L30;
    L52:
        r106 = r106 + 1;
        r105 = 0;
        goto L18
    L21:
        return;
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
        a(r100);
        b(r100);
        r100.restore();
        return;
    L40:
        return;
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawBaseRouteLayer
    public void setBackgroundColor(int r100) {
        this.f31564e = this.mContext.getResources().getColor(r100);
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawBaseRouteLayer
    public void setRouteColor(int r100) {
        setRouteLineColor(r100);
        setRouteSurfaceColor(r100);
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawBaseRouteLayer
    public void setRouteLineColor(int r100) {
        this.f31565f = this.mContext.getResources().getColor(r100);
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawBaseRouteLayer
    public void setRouteSurfaceColor(int r100) {
        this.f31566g = this.mContext.getResources().getColor(r100);
    }

    private b a(int r100, int r101, com.baidu.platform.comapi.map.MapStatus r102) {
        String r103 = r100 + "," + r101;
        LruCache<String, b> r104 = this.f31567h;
        if (r104 == null) goto L5;
        b r105 = r104.get(r103);
    L6:
        if (r105 != null) goto L10;
        toScreenLocation(r100, r101, this.f31562c);
        Point r106 = this.f31562c;
        r105 = new b(r106.f32737x, r106.f32738y);
        if (r104 == null) goto L10;
        r104.put(r103, r105);
    L10:
        return r105;
    L5:
        r105 = null;
        goto L6
    }
}
