package com.baidu.mapapi.map;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.mapapi.map.track.TraceAnimationListener;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.bmsdk.BmTrack;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;
import com.baidu.platform.comapi.bmsdk.animation.BmTrackAnimation;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.style.BmTrackStyle;
import com.baidu.platform.comapi.util.i;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class Track extends Overlay {
    BitmapDescriptor A;
    BitmapDescriptor B;
    TraceAnimationListener C;
    private c D;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BmTrack f31496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BmGeoElement f31497h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private BmTrackStyle f31498i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private BmTrackAnimation.a f31499j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private BmAnimation.a f31500k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    BmTrackAnimation f31501l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    List<Integer> f31502m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    List<LatLng> f31503n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int[] f31504o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int[] f31505p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f31506q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f31507r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f31508s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    float f31509t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f31510u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f31511v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    float f31512w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    float f31513x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    boolean f31514y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f31515z;

    public class a implements BmTrackAnimation.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Track f31516a;

        public a(Track r100) {
            this.f31516a = r100;
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmTrackAnimation.a
        public void a(com.baidu.platform.comapi.bmsdk.b r100, float r101, float r102) {
            if (this.f31516a.C == null) goto L6;
            this.f31516a.C.onTraceUpdatePosition(CoordUtil.mc2ll(new GeoPoint(r100.f32818b, r100.f32817a)));
            this.f31516a.C.onTraceAnimationUpdate((float) (Math.round(((double) r102) * 1000.0d) / 10.0d));
            return;
        }
    }

    public class b implements BmAnimation.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Track f31517a;

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmAnimation.a
        public void a(BmAnimation r100) {
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmAnimation.a
        public void c(BmAnimation r100) {
        }

        public b(Track r100) {
            this.f31517a = r100;
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmAnimation.a
        public void b(BmAnimation r100) {
            TraceAnimationListener r101 = this.f31517a.C;
            if (r101 == null) goto L6;
            r101.onTraceAnimationFinish();
            return;
        }
    }

    public class c extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Track f31518a;

        public c(Track r100) {
            this.f31518a = r100;
            super(Looper.getMainLooper());
        }

        @Override // com.baidu.platform.comapi.util.i
        public void a(Message r100) {
            int r101 = r100.what;
            if (r101 != 65302) goto L17;
            int r102 = r100.arg1;
            if (r102 < 0) goto L12;
            if (r102 > 1000) goto L12;
            Track r103 = this.f31518a;
            float r104 = r102;
            r103.f31509t = r104 / 1000.0f;
            TraceAnimationListener r105 = r103.C;
            if (r105 == null) goto L12;
            r105.onTraceAnimationUpdate(r104 / 10.0f);
        L12:
            if (r100.arg2 != 1) goto L22;
            TraceAnimationListener r106 = this.f31518a.C;
            if (r106 == null) goto L23;
            r106.onTraceAnimationFinish();
            return;
        L23:
            return;
        L22:
            return;
        L17:
            if (r101 == 65303) goto L19;
            return;
        L19:
            if (this.f31518a.C == null) goto L26;
            this.f31518a.C.onTraceUpdatePosition(CoordUtil.mc2ll(new GeoPoint(r100.arg2 / 100.0f, r100.arg1 / 100.0f)));
            return;
        }
    }

    public void pause() {
        this.f31514y = true;
        this.listener.c(this);
        this.f31501l.pause();
        BmLayer r100 = this.f31207f;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    public void resume() {
        if (this.f31514y == false) goto L8;
        this.f31514y = false;
        this.listener.c(this);
        this.f31501l.resume();
        BmLayer r100 = this.f31207f;
        if (r100 == null) goto L9;
        r100.b();
        return;
    L9:
        return;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmTrack r100 = new BmTrack();
        this.f31496g = r100;
        r100.a(this);
        setDrawItem(this.f31496g);
        super.toDrawItem();
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L4:
        if (r102 >= this.f31503n.size()) goto L6;
        GeoPoint r103 = CoordUtil.ll2mc((LatLng) ListProtector.get(this.f31503n, r102));
        r101.add(new com.baidu.platform.comapi.bmsdk.b(r103.getLongitudeE6(), r103.getLatitudeE6(), this.f31504o[r102]));
        r102 = r102 + 1;
        goto L4
    L6:
        BmGeoElement r104 = new BmGeoElement(0);
        this.f31497h = r104;
        r104.b(r101);
        BmTrackStyle r105 = new BmTrackStyle();
        this.f31498i = r105;
        r105.b(this.f31506q);
        if (this.f31506q != 6) goto L9;
        this.f31497h.a(1, this.f31502m);
    L9:
        this.f31498i.c(this.f31510u);
        this.f31498i.a(this.f31511v);
        if (this.B == null) goto L12;
        this.f31498i.a(new BmBitmapResource(this.B.getBitmap()));
    L12:
        this.f31498i.a(this.f31512w);
        this.f31498i.b(this.f31513x);
        if (this.A == null) goto L15;
        this.f31498i.b(new BmBitmapResource(this.A.getBitmap()));
    L15:
        this.f31497h.a(this.f31498i);
        this.f31496g.a(this.f31497h);
        this.f31501l.setTrackPosRadio(0.0f, 1.0f);
        this.f31501l.setDuration(this.f31507r);
        this.f31501l.setStartDelay(0);
        this.f31501l.setRepeatCount(0);
        this.f31501l.setRepeatMode(1);
        this.f31501l.setTrackUpdateListener(this.f31499j);
        this.f31501l.setAnimationListener(this.f31500k);
        this.f31501l.start();
        this.f31501l.setSdkTrack(this.f31496g);
        this.f31496g.a(this.f31501l);
        this.f31496g.c(this.f31515z);
        return this.f31496g;
    }

    public Track() {
        this.f31499j = new a(this);
        this.f31500k = new b(this);
        this.f31501l = new BmTrackAnimation();
        this.f31507r = 300;
        this.f31508s = 0;
        this.f31509t = 0.0f;
        this.f31510u = 5;
        this.f31511v = -1426128896;
        this.f31512w = 0.0f;
        this.f31513x = 0.0f;
        this.f31514y = false;
        this.A = null;
        this.B = null;
        c r100 = new c(this);
        this.D = r100;
        this.type = com.baidu.mapsdkplatform.comapi.map.d.f32155o;
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_PROGRESS, r100);
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_POSITION, this.D);
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle r100) {
        super.a(r100);
        List<LatLng> r101 = this.f31503n;
        if (r101 == null) goto L19;
        if (r101.size() < 2) goto L19;
        Bundle r102 = new Bundle();
        BitmapDescriptor r103 = this.A;
        if (r103 == null) goto L9;
        r102.putBundle(String.format("texture_%d", new Object[]{0}), r103.a());
        int r104 = 1;
    L10:
        BitmapDescriptor r105 = this.B;
        if (r105 == null) goto L13;
        r102.putBundle(String.format("texture_%d", new Object[]{1}), r105.a());
        r104 = r104 + 1;
    L13:
        r102.putInt("total", r104);
        r100.putBundle("image_info_list", r102);
        r100.putFloat(GXTemplateKey.STYLE_OPACITY, this.f31512w);
        r100.putFloat("paletteOpacity", this.f31513x);
        GeoPoint r106 = CoordUtil.ll2mc((LatLng) ListProtector.get(this.f31503n, 0));
        r100.putDouble("location_x", r106.getLongitudeE6());
        r100.putDouble("location_y", r106.getLatitudeE6());
        r100.putInt("track_type", this.f31506q);
        r100.putFloat("animation_start_value", this.f31509t);
        r100.putBoolean("onPause", this.f31514y);
        r100.putInt("width", this.f31510u);
        Overlay.c(this.f31503n, r100);
        if (this.f31506q != 1) goto L16;
        r100.putIntArray("color_array", this.f31505p);
    L16:
        r100.putIntArray("height_array", this.f31504o);
        r100.putInt("animation_time", this.f31507r);
        r100.putInt("animation_type", this.f31508s);
        return r100;
    L9:
        r104 = 0;
    L19:
        throw new IllegalStateException("BDMapSDKException: when you add Track, you must at least supply 2 points");
    }

    public void addTraceAnimationListener(TraceAnimationListener r100) {
        this.C = r100;
    }

    public void setAnimationListener(BmAnimation.a r100) {
        this.f31500k = r100;
    }

    public void setTrackMove(boolean r100) {
        this.f31515z = r100;
    }

    public void updateTrackZIndex(int r100) {
        this.f31204c = r100;
        BmTrack r101 = this.f31496g;
        if (r101 == null) goto L10;
        BmLayer r102 = this.f31207f;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.a(r101.getName()) == null) goto L12;
        this.f31207f.a(this.f31496g, (short) r100);
        this.f31207f.b();
        return;
    L12:
        return;
    }
}
