package com.baidu.mapapi.map;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
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
import com.stepos.alphame.sleep.SleepModeData;
import com.stepos.alphame.utils.Property;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Track extends Overlay {

    /* renamed from: C, reason: collision with root package name */
    TraceAnimationListener f7052C;

    /* renamed from: D, reason: collision with root package name */
    private c f7053D;

    /* renamed from: g, reason: collision with root package name */
    private BmTrack f7054g;

    /* renamed from: h, reason: collision with root package name */
    private BmGeoElement f7055h;

    /* renamed from: i, reason: collision with root package name */
    private BmTrackStyle f7056i;

    /* renamed from: m, reason: collision with root package name */
    List<Integer> f7060m;

    /* renamed from: n, reason: collision with root package name */
    List<LatLng> f7061n;

    /* renamed from: o, reason: collision with root package name */
    int[] f7062o;

    /* renamed from: p, reason: collision with root package name */
    int[] f7063p;

    /* renamed from: q, reason: collision with root package name */
    int f7064q;

    /* renamed from: z, reason: collision with root package name */
    private boolean f7073z;

    /* renamed from: j, reason: collision with root package name */
    private BmTrackAnimation.a f7057j = new a();

    /* renamed from: k, reason: collision with root package name */
    private BmAnimation.a f7058k = new b();

    /* renamed from: l, reason: collision with root package name */
    BmTrackAnimation f7059l = new BmTrackAnimation();

    /* renamed from: r, reason: collision with root package name */
    int f7065r = UIMsg.MsgDefine.RENDER_STATE_FIRST_FRAME;

    /* renamed from: s, reason: collision with root package name */
    int f7066s = 0;

    /* renamed from: t, reason: collision with root package name */
    float f7067t = Property.DEFAULT_FLOAT_VALUE;

    /* renamed from: u, reason: collision with root package name */
    int f7068u = 5;

    /* renamed from: v, reason: collision with root package name */
    int f7069v = -1426128896;

    /* renamed from: w, reason: collision with root package name */
    float f7070w = Property.DEFAULT_FLOAT_VALUE;

    /* renamed from: x, reason: collision with root package name */
    float f7071x = Property.DEFAULT_FLOAT_VALUE;

    /* renamed from: y, reason: collision with root package name */
    boolean f7072y = false;

    /* renamed from: A, reason: collision with root package name */
    BitmapDescriptor f7050A = null;

    /* renamed from: B, reason: collision with root package name */
    BitmapDescriptor f7051B = null;

    public class a implements BmTrackAnimation.a {
        public a() {
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmTrackAnimation.a
        public void a(com.baidu.platform.comapi.bmsdk.b bVar, float f4, float f5) {
            if (Track.this.f7052C != null) {
                Track.this.f7052C.onTraceUpdatePosition(CoordUtil.mc2ll(new GeoPoint(bVar.f8680b, bVar.f8679a)));
                Track.this.f7052C.onTraceAnimationUpdate((float) (Math.round(f5 * 1000.0d) / 10.0d));
            }
        }
    }

    public class b implements BmAnimation.a {
        public b() {
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmAnimation.a
        public void a(BmAnimation bmAnimation) {
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmAnimation.a
        public void b(BmAnimation bmAnimation) {
            TraceAnimationListener traceAnimationListener = Track.this.f7052C;
            if (traceAnimationListener != null) {
                traceAnimationListener.onTraceAnimationFinish();
            }
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmAnimation.a
        public void c(BmAnimation bmAnimation) {
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class c extends i {
        public c() {
            super(Looper.getMainLooper());
        }

        @Override // com.baidu.platform.comapi.util.i
        public void a(Message message) {
            TraceAnimationListener traceAnimationListener;
            int i4 = message.what;
            if (i4 != 65302) {
                if (i4 != 65303 || Track.this.f7052C == null) {
                    return;
                }
                Track.this.f7052C.onTraceUpdatePosition(CoordUtil.mc2ll(new GeoPoint(message.arg2 / 100.0f, message.arg1 / 100.0f)));
                return;
            }
            int i5 = message.arg1;
            if (i5 >= 0 && i5 <= 1000) {
                Track track = Track.this;
                float f4 = i5;
                track.f7067t = f4 / 1000.0f;
                TraceAnimationListener traceAnimationListener2 = track.f7052C;
                if (traceAnimationListener2 != null) {
                    traceAnimationListener2.onTraceAnimationUpdate(f4 / 10.0f);
                }
            }
            if (message.arg2 != 1 || (traceAnimationListener = Track.this.f7052C) == null) {
                return;
            }
            traceAnimationListener.onTraceAnimationFinish();
        }
    }

    public Track() {
        c cVar = new c();
        this.f7053D = cVar;
        this.type = com.baidu.mapsdkplatform.comapi.map.d.track;
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_PROGRESS, cVar);
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_POSITION, this.f7053D);
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) throws NoSuchAlgorithmException {
        int i4;
        super.a(bundle);
        List<LatLng> list = this.f7061n;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("BDMapSDKException: when you add Track, you must at least supply 2 points");
        }
        Bundle bundle2 = new Bundle();
        BitmapDescriptor bitmapDescriptor = this.f7050A;
        if (bitmapDescriptor != null) {
            bundle2.putBundle(String.format("texture_%d", 0), bitmapDescriptor.a());
            i4 = 1;
        } else {
            i4 = 0;
        }
        BitmapDescriptor bitmapDescriptor2 = this.f7051B;
        if (bitmapDescriptor2 != null) {
            bundle2.putBundle(String.format("texture_%d", 1), bitmapDescriptor2.a());
            i4++;
        }
        bundle2.putInt("total", i4);
        bundle.putBundle("image_info_list", bundle2);
        bundle.putFloat("opacity", this.f7070w);
        bundle.putFloat("paletteOpacity", this.f7071x);
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f7061n.get(0));
        bundle.putDouble(SleepModeData.LOCATION_X, geoPointLl2mc.getLongitudeE6());
        bundle.putDouble(SleepModeData.LOCATION_Y, geoPointLl2mc.getLatitudeE6());
        bundle.putInt("track_type", this.f7064q);
        bundle.putFloat("animation_start_value", this.f7067t);
        bundle.putBoolean("onPause", this.f7072y);
        bundle.putInt("width", this.f7068u);
        Overlay.c(this.f7061n, bundle);
        if (this.f7064q == 1) {
            bundle.putIntArray("color_array", this.f7063p);
        }
        bundle.putIntArray("height_array", this.f7062o);
        bundle.putInt("animation_time", this.f7065r);
        bundle.putInt("animation_type", this.f7066s);
        return bundle;
    }

    public void addTraceAnimationListener(TraceAnimationListener traceAnimationListener) {
        this.f7052C = traceAnimationListener;
    }

    public void pause() {
        this.f7072y = true;
        this.listener.c(this);
        this.f7059l.pause();
        BmLayer bmLayer = this.f6723f;
        if (bmLayer != null) {
            bmLayer.b();
        }
    }

    public void resume() {
        if (this.f7072y) {
            this.f7072y = false;
            this.listener.c(this);
            this.f7059l.resume();
            BmLayer bmLayer = this.f6723f;
            if (bmLayer != null) {
                bmLayer.b();
            }
        }
    }

    public void setAnimationListener(BmAnimation.a aVar) {
        this.f7058k = aVar;
    }

    public void setTrackMove(boolean z4) {
        this.f7073z = z4;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmTrack bmTrack = new BmTrack();
        this.f7054g = bmTrack;
        bmTrack.a(this);
        setDrawItem(this.f7054g);
        super.toDrawItem();
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.f7061n.size(); i4++) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f7061n.get(i4));
            arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6(), this.f7062o[i4]));
        }
        BmGeoElement bmGeoElement = new BmGeoElement(0);
        this.f7055h = bmGeoElement;
        bmGeoElement.b(arrayList);
        BmTrackStyle bmTrackStyle = new BmTrackStyle();
        this.f7056i = bmTrackStyle;
        bmTrackStyle.b(this.f7064q);
        if (this.f7064q == 6) {
            this.f7055h.a(1, this.f7060m);
        }
        this.f7056i.c(this.f7068u);
        this.f7056i.a(this.f7069v);
        if (this.f7051B != null) {
            this.f7056i.a(new BmBitmapResource(this.f7051B.getBitmap()));
        }
        this.f7056i.a(this.f7070w);
        this.f7056i.b(this.f7071x);
        if (this.f7050A != null) {
            this.f7056i.b(new BmBitmapResource(this.f7050A.getBitmap()));
        }
        this.f7055h.a(this.f7056i);
        this.f7054g.a(this.f7055h);
        this.f7059l.setTrackPosRadio(Property.DEFAULT_FLOAT_VALUE, 1.0f);
        this.f7059l.setDuration(this.f7065r);
        this.f7059l.setStartDelay(0L);
        this.f7059l.setRepeatCount(0);
        this.f7059l.setRepeatMode(1);
        this.f7059l.setTrackUpdateListener(this.f7057j);
        this.f7059l.setAnimationListener(this.f7058k);
        this.f7059l.start();
        this.f7059l.setSdkTrack(this.f7054g);
        this.f7054g.a(this.f7059l);
        this.f7054g.c(this.f7073z);
        return this.f7054g;
    }

    public void updateTrackZIndex(int i4) {
        BmLayer bmLayer;
        this.f6720c = i4;
        BmTrack bmTrack = this.f7054g;
        if (bmTrack == null || (bmLayer = this.f6723f) == null || bmLayer.a(bmTrack.getName()) == null) {
            return;
        }
        this.f6723f.a((BmDrawItem) this.f7054g, (short) i4);
        this.f6723f.b();
    }
}
