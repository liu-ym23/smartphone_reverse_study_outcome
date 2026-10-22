package com.baidu.mapapi.map;

import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.bmsdk.ui.RichView;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.animation.BDAnimation;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmIconMarker;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.bmsdk.BmTextMarker;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.style.BmFrameResource;
import com.baidu.platform.comapi.bmsdk.style.BmTextStyle;
import com.baidu.platform.comapi.bmsdk.ui.BmLabelUI;
import com.baidu.platform.comapi.bmsdk.ui.BmRichView;
import com.baidu.platform.comjni.tools.ParcelItem;
import com.stepos.activeview.moveline.item.ViewTweenItem;
import com.stepos.alphame.sleep.SleepModeData;
import com.stepos.alphame.utils.Property;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.UByte;

/* loaded from: classes.dex */
public final class Marker extends Overlay {

    /* renamed from: E, reason: collision with root package name */
    int f6603E;

    /* renamed from: G, reason: collision with root package name */
    ArrayList<BitmapDescriptor> f6605G;

    /* renamed from: H, reason: collision with root package name */
    BmFrameResource f6606H;

    /* renamed from: I, reason: collision with root package name */
    int f6607I;

    /* renamed from: K, reason: collision with root package name */
    Animation f6609K;

    /* renamed from: O, reason: collision with root package name */
    Point f6613O;

    /* renamed from: P, reason: collision with root package name */
    InfoWindow f6614P;

    /* renamed from: Q, reason: collision with root package name */
    InfoWindow.a f6615Q;

    /* renamed from: X, reason: collision with root package name */
    InfoWindowAdapter f6621X;

    /* renamed from: g, reason: collision with root package name */
    LatLng f6622g;

    /* renamed from: h, reason: collision with root package name */
    BitmapDescriptor f6623h;

    /* renamed from: i, reason: collision with root package name */
    BmBitmapResource f6624i;

    /* renamed from: j, reason: collision with root package name */
    BmIconMarker f6625j;

    /* renamed from: k, reason: collision with root package name */
    int f6626k;

    /* renamed from: l, reason: collision with root package name */
    float f6627l;

    /* renamed from: m, reason: collision with root package name */
    float f6628m;

    /* renamed from: n, reason: collision with root package name */
    boolean f6629n;

    /* renamed from: o, reason: collision with root package name */
    boolean f6630o;

    /* renamed from: p, reason: collision with root package name */
    float f6631p;

    /* renamed from: q, reason: collision with root package name */
    String f6632q;

    /* renamed from: r, reason: collision with root package name */
    TitleOptions f6633r;

    /* renamed from: s, reason: collision with root package name */
    BmTextMarker f6634s;

    /* renamed from: t, reason: collision with root package name */
    int f6635t;

    /* renamed from: u, reason: collision with root package name */
    int f6636u;

    /* renamed from: x, reason: collision with root package name */
    float f6639x;

    /* renamed from: y, reason: collision with root package name */
    int f6640y;

    /* renamed from: v, reason: collision with root package name */
    boolean f6637v = false;

    /* renamed from: w, reason: collision with root package name */
    boolean f6638w = false;

    /* renamed from: z, reason: collision with root package name */
    boolean f6641z = false;

    /* renamed from: A, reason: collision with root package name */
    boolean f6599A = true;

    /* renamed from: B, reason: collision with root package name */
    boolean f6600B = false;

    /* renamed from: C, reason: collision with root package name */
    boolean f6601C = false;

    /* renamed from: D, reason: collision with root package name */
    boolean f6602D = false;

    /* renamed from: F, reason: collision with root package name */
    int f6604F = 160;

    /* renamed from: J, reason: collision with root package name */
    int f6608J = 20;

    /* renamed from: L, reason: collision with root package name */
    float f6610L = 1.0f;

    /* renamed from: M, reason: collision with root package name */
    float f6611M = 1.0f;

    /* renamed from: N, reason: collision with root package name */
    float f6612N = 1.0f;

    /* renamed from: R, reason: collision with root package name */
    boolean f6616R = false;

    /* renamed from: S, reason: collision with root package name */
    int f6617S = Integer.MAX_VALUE;
    int T = 0;

    /* renamed from: U, reason: collision with root package name */
    int f6618U = 4;

    /* renamed from: V, reason: collision with root package name */
    int f6619V = 22;

    /* renamed from: W, reason: collision with root package name */
    int f6620W = 0;

    public Marker() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.marker;
    }

    private void a(InfoWindow infoWindow, InfoWindow infoWindow2) {
        infoWindow.f6477b = infoWindow2.getBitmapDescriptor();
        infoWindow.f6479d = infoWindow2.getPosition();
        infoWindow.f6476a = infoWindow2.getTag();
        infoWindow.f6478c = infoWindow2.getView();
        infoWindow.f6485j = infoWindow2.getYOffset();
        infoWindow.f6489n = infoWindow2.f6489n;
        infoWindow.f6483h = infoWindow2.f6483h;
    }

    public void addRichView(RichView richView) {
        BmIconMarker bmIconMarker;
        if (richView == null || !OverlayUtil.isOverlayUpgrade() || (bmIconMarker = this.f6625j) == null || this.f6723f == null) {
            return;
        }
        bmIconMarker.a(richView.getBmRichView());
        this.f6723f.b();
    }

    public void cancelAnimation() {
        if (this.f6609K != null) {
            if (!OverlayUtil.isOverlayUpgrade()) {
                this.f6609K.bdAnimation.cancelAnimation();
            } else {
                this.f6609K.bmAnimation.cancel();
                this.f6723f.b();
            }
        }
    }

    public void clearRichViews() {
        BmIconMarker bmIconMarker;
        if (!OverlayUtil.isOverlayUpgrade() || (bmIconMarker = this.f6625j) == null || this.f6723f == null) {
            return;
        }
        bmIconMarker.c();
        this.f6723f.b();
    }

    public float getAlpha() {
        return this.f6639x;
    }

    public float getAnchorX() {
        return this.f6627l;
    }

    public float getAnchorY() {
        return this.f6628m;
    }

    public BmBitmapResource getBmBitmapResource() {
        return this.f6624i;
    }

    public int getEndLevel() {
        return this.f6619V;
    }

    public Point getFixedPosition() {
        return this.f6613O;
    }

    public Point getFixedScreenPosition() {
        return this.f6613O;
    }

    public BitmapDescriptor getIcon() {
        return this.f6623h;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.f6605G;
    }

    public String getId() {
        return this.f6718a;
    }

    public InfoWindow getInfoWindow() {
        return this.f6614P;
    }

    @Deprecated
    public int getPeriod() {
        if (OverlayUtil.isOverlayUpgrade()) {
            return 0;
        }
        return this.f6608J;
    }

    public LatLng getPosition() {
        return this.f6622g;
    }

    public int getPriority() {
        return this.f6617S;
    }

    public float getRotate() {
        return this.f6631p;
    }

    public float getScale() {
        return this.f6612N;
    }

    public float getScaleX() {
        return this.f6610L;
    }

    public float getScaleY() {
        return this.f6611M;
    }

    public int getStartLevel() {
        return this.f6618U;
    }

    public String getTitle() {
        return this.f6632q;
    }

    public TitleOptions getTitleOptions() {
        return this.f6633r;
    }

    public int getXOffset() {
        return this.f6636u;
    }

    public int getYOffset() {
        return this.f6635t;
    }

    public void hideInfoWindow() {
        InfoWindow.a aVar = this.f6615Q;
        if (aVar != null) {
            aVar.a(this.f6614P);
            this.f6616R = false;
        }
        this.f6614P = null;
    }

    public boolean isClickable() {
        return this.f6599A;
    }

    public boolean isDraggable() {
        return this.f6630o;
    }

    public boolean isFixed() {
        return this.f6641z;
    }

    public boolean isFlat() {
        return this.f6637v;
    }

    public boolean isForceDisplay() {
        return this.f6602D;
    }

    public boolean isInfoWindowEnabled() {
        return this.f6616R;
    }

    public boolean isJoinCollision() {
        return this.f6600B;
    }

    public boolean isPerspective() {
        return this.f6629n;
    }

    public boolean isPoiCollided() {
        return this.f6601C;
    }

    public void pauseAnimation() {
        if (this.f6609K == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.f6609K.bmAnimation.pause();
        this.f6723f.b();
    }

    public void poiCollided(boolean z4) {
        this.f6601C = z4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (z4) {
            this.T |= CollisionBehavior.COLLIDE_WITH_BASEPOI.getNumber();
        } else {
            this.T = (~CollisionBehavior.COLLIDE_WITH_BASEPOI.getNumber()) & this.T;
        }
        this.f6625j.e(this.T);
        this.f6723f.b();
    }

    public void removeRichView(RichView richView) {
        BmIconMarker bmIconMarker;
        if (richView == null || !OverlayUtil.isOverlayUpgrade() || (bmIconMarker = this.f6625j) == null || this.f6723f == null) {
            return;
        }
        bmIconMarker.b(richView.getBmRichView());
        this.f6723f.b();
    }

    public void resumeAnimation() {
        if (this.f6609K == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.f6609K.bmAnimation.resume();
        this.f6723f.b();
    }

    public void setAlpha(float f4) {
        if (f4 < Property.DEFAULT_FLOAT_VALUE || f4 > 1.0d) {
            this.f6639x = 1.0f;
            return;
        }
        this.f6639x = f4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || this.f6723f == null) {
            return;
        }
        bmIconMarker.a(this.f6639x);
        this.f6723f.b();
    }

    public void setAnchor(float f4, float f5) {
        if (f4 < Property.DEFAULT_FLOAT_VALUE || f4 > 1.0f || f5 < Property.DEFAULT_FLOAT_VALUE || f5 > 1.0f) {
            return;
        }
        this.f6627l = f4;
        this.f6628m = f5;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || this.f6723f == null) {
            return;
        }
        bmIconMarker.b(f4);
        this.f6625j.c(f5);
        BmTextMarker bmTextMarker = this.f6634s;
        if (bmTextMarker != null) {
            bmTextMarker.b(f4);
            this.f6634s.c(f5);
        }
        this.f6723f.b();
    }

    public void setAnimateType(int i4) {
        this.f6640y = i4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || this.f6723f == null) {
            return;
        }
        bmIconMarker.o(i4);
        this.f6723f.b();
    }

    public void setAnimation(Animation animation) {
        if (animation == null) {
            return;
        }
        this.f6609K = animation;
        if (!OverlayUtil.isOverlayUpgrade()) {
            BDAnimation bDAnimation = this.f6609K.bdAnimation;
            if (bDAnimation != null) {
                bDAnimation.setAnimation(this, animation);
                return;
            }
            return;
        }
        BmAnimation bmAnimation = this.f6609K.bmAnimation;
        if (bmAnimation != null) {
            this.f6625j.a(bmAnimation);
            this.f6723f.b();
        }
    }

    public void setBmBitmapResource(BmBitmapResource bmBitmapResource) {
        BmIconMarker bmIconMarker;
        if (bmBitmapResource == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
        }
        this.f6624i = bmBitmapResource;
        if (!OverlayUtil.isOverlayUpgrade() || (bmIconMarker = this.f6625j) == null || this.f6723f == null) {
            return;
        }
        bmIconMarker.a(this.f6624i);
        this.f6723f.b();
    }

    public void setClickable(boolean z4) {
        this.f6599A = z4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || this.f6723f == null) {
            return;
        }
        bmIconMarker.a(z4);
        this.f6723f.b();
    }

    public void setDraggable(boolean z4) {
        this.f6630o = z4;
        if (OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.listener.c(this);
    }

    public void setEndLevel(int i4) {
        this.f6619V = i4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || this.f6723f == null) {
            return;
        }
        bmIconMarker.a(i4);
        this.f6723f.b();
    }

    public void setFixedScreenPosition(Point point) {
        if (point == null) {
            throw new IllegalArgumentException("BDMapSDKException: the screenPosition can not be null");
        }
        this.f6613O = point;
        this.f6641z = true;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || this.f6723f == null) {
            return;
        }
        bmIconMarker.j(this.f6641z ? 1 : 0);
        this.f6625j.g(this.f6613O.x);
        this.f6625j.h(this.f6613O.y);
        this.f6723f.b();
    }

    public void setFlat(boolean z4) {
        this.f6637v = z4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || this.f6723f == null) {
            return;
        }
        if (z4) {
            bmIconMarker.i(3);
        } else {
            bmIconMarker.i(0);
        }
        this.f6723f.b();
    }

    public void setForceDisplay(boolean z4) {
        this.f6602D = z4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (z4) {
            this.T |= CollisionBehavior.ALWAYS_SHOW.getNumber();
        } else {
            this.T = (~CollisionBehavior.ALWAYS_SHOW.getNumber()) & this.T;
        }
        this.f6625j.e(this.T);
        this.f6723f.b();
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
        }
        this.f6623h = bitmapDescriptor;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || this.f6723f == null) {
            return;
        }
        bmIconMarker.a(new BmBitmapResource(this.f6623h.getBitmap()));
        this.f6723f.b();
    }

    public void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's icons can not be null");
        }
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() == 1) {
            this.f6623h = arrayList.get(0);
        } else {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                if (arrayList.get(i4) == null || arrayList.get(i4).f6261a == null) {
                    return;
                }
            }
            this.f6605G = (ArrayList) arrayList.clone();
            this.f6623h = null;
        }
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || this.f6723f == null) {
            return;
        }
        if (this.f6605G != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<BitmapDescriptor> it = this.f6605G.iterator();
            while (it.hasNext()) {
                arrayList2.add(new BmBitmapResource(it.next().getBitmap()));
            }
            BmFrameResource bmFrameResource = new BmFrameResource(arrayList2, this.f6604F, Integer.MAX_VALUE);
            this.f6606H = bmFrameResource;
            this.f6625j.a(bmFrameResource);
        } else if (this.f6623h != null) {
            bmIconMarker.a(new BmBitmapResource(this.f6623h.getBitmap()));
        }
        this.f6723f.b();
    }

    public void setInterval(int i4) {
        BmFrameResource bmFrameResource;
        int i5;
        if (i4 > 0 && OverlayUtil.isOverlayUpgrade() && (bmFrameResource = this.f6606H) != null && (i5 = this.f6607I) > 0) {
            bmFrameResource.a(i5, this.f6604F);
            this.f6604F = i4;
            this.f6723f.b();
        }
    }

    public void setJoinCollision(boolean z4) {
        this.f6600B = z4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (z4) {
            this.T |= CollisionBehavior.COLLIDE_WITH_INNER.getNumber();
        } else {
            this.T = (~CollisionBehavior.COLLIDE_WITH_INNER.getNumber()) & this.T;
        }
        this.f6625j.e(this.T);
        this.f6723f.b();
    }

    @Deprecated
    public void setPeriod(int i4) {
        if (OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        if (i4 <= 0) {
            throw new IllegalArgumentException("BDMapSDKException: marker's period must be greater than zero ");
        }
        this.f6608J = i4;
        this.listener.c(this);
    }

    public void setPerspective(boolean z4) {
        this.f6629n = z4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || this.f6723f == null) {
            return;
        }
        bmIconMarker.n(this.f6629n ? 1 : 0);
        this.f6723f.b();
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
        }
        this.f6622g = latLng;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.f6625j == null || this.f6723f == null) {
            return;
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6622g);
        this.f6625j.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
        BmTextMarker bmTextMarker = this.f6634s;
        if (bmTextMarker != null) {
            bmTextMarker.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
        }
        this.f6723f.b();
    }

    public void setPositionWithInfoWindow(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
        }
        this.f6622g = latLng;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else if (this.f6625j != null && this.f6723f != null) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6622g);
            this.f6625j.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
            this.f6723f.b();
        }
        InfoWindow infoWindow = this.f6614P;
        if (infoWindow != null) {
            infoWindow.setPosition(latLng);
        }
    }

    public void setPriority(int i4) {
        this.f6617S = i4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || this.f6723f == null) {
            return;
        }
        bmIconMarker.f(i4);
        this.f6723f.b();
    }

    public void setRotate(float f4) {
        while (f4 < Property.DEFAULT_FLOAT_VALUE) {
            f4 += 360.0f;
        }
        float f5 = f4 % 360.0f;
        this.f6631p = f5;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || this.f6723f == null) {
            return;
        }
        bmIconMarker.d(f5);
        this.f6723f.b();
    }

    public void setScale(float f4) {
        if (f4 < Property.DEFAULT_FLOAT_VALUE) {
            f4 = 1.0f;
        }
        this.f6610L = f4;
        this.f6611M = f4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || this.f6723f == null) {
            return;
        }
        bmIconMarker.e(f4);
        if (this.f6634s != null) {
            int titleYOffset = this.f6633r.getTitleYOffset();
            if (this.f6623h != null) {
                titleYOffset -= (int) (r0.getBitmap().getHeight() * this.f6611M);
            }
            this.f6634s.m((titleYOffset * 310) / SysOSUtil.getDensityDpi());
        }
        this.f6723f.b();
    }

    public void setScaleX(float f4) {
        if (f4 < Property.DEFAULT_FLOAT_VALUE) {
            f4 = 1.0f;
        }
        this.f6610L = f4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || this.f6723f == null) {
            return;
        }
        bmIconMarker.f(f4);
        this.f6723f.b();
    }

    public void setScaleY(float f4) {
        if (f4 < Property.DEFAULT_FLOAT_VALUE) {
            f4 = 1.0f;
        }
        this.f6611M = f4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || this.f6723f == null) {
            return;
        }
        bmIconMarker.g(f4);
        if (this.f6634s != null) {
            int titleYOffset = this.f6633r.getTitleYOffset();
            if (this.f6623h != null) {
                titleYOffset -= (int) (r0.getBitmap().getHeight() * this.f6611M);
            }
            this.f6634s.m((titleYOffset * 310) / SysOSUtil.getDensityDpi());
        }
        this.f6723f.b();
    }

    public void setStartLevel(int i4) {
        this.f6618U = i4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || this.f6723f == null) {
            return;
        }
        bmIconMarker.b(i4);
        this.f6723f.b();
    }

    public void setTitle(String str) {
        this.f6632q = str;
        if (OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.listener.c(this);
    }

    public void setTitleOptions(TitleOptions titleOptions) {
        if (titleOptions == null) {
            return;
        }
        this.f6633r = titleOptions;
        this.f6620W = 1;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.f6625j == null || this.f6723f == null) {
            return;
        }
        BmLabelUI bmLabelUI = new BmLabelUI();
        bmLabelUI.setName("titleOption");
        bmLabelUI.b(this.f6633r.getText());
        bmLabelUI.b(this.f6633r.getTitleXOffset(), this.f6633r.getTitleYOffset(), 0, 0);
        bmLabelUI.b(this.f6633r.getTitleBgColor());
        BmTextStyle bmTextStyle = new BmTextStyle();
        bmTextStyle.d(this.f6633r.getTitleFontColor());
        bmTextStyle.e(this.f6633r.getTitleFontSize());
        bmLabelUI.a(bmTextStyle);
        BmRichView bmRichView = new BmRichView();
        bmRichView.a(bmLabelUI);
        this.f6625j.a(bmRichView);
        this.f6723f.b();
    }

    public void setToTop() {
        BmLayer bmLayer;
        this.f6638w = true;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || (bmLayer = this.f6723f) == null) {
            return;
        }
        BmDrawItem bmDrawItemA = bmLayer.a(bmIconMarker.getName());
        if (bmDrawItemA != null) {
            this.f6723f.a(bmDrawItemA);
        }
        this.f6723f.a(this.f6625j.getName(), this.f6625j);
        this.f6723f.b();
    }

    @Override // com.baidu.mapapi.map.Overlay
    public void setVisible(boolean z4) {
        this.f6721d = z4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || this.f6723f == null) {
            return;
        }
        bmIconMarker.c(z4 ? 1 : 0);
        this.f6723f.b();
    }

    public void setXOffset(int i4) {
        this.f6636u = i4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || this.f6723f == null) {
            return;
        }
        bmIconMarker.l(i4);
        this.f6723f.b();
    }

    public void setYOffset(int i4) {
        this.f6635t = i4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || this.f6723f == null) {
            return;
        }
        bmIconMarker.m(i4);
        this.f6723f.b();
    }

    @Override // com.baidu.mapapi.map.Overlay
    public void setZIndex(int i4) {
        BmLayer bmLayer;
        this.f6720c = i4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || (bmLayer = this.f6723f) == null) {
            return;
        }
        if (bmLayer.a(bmIconMarker.getName()) != null) {
            this.f6723f.a(this.f6625j);
        }
        this.f6723f.a(this.f6625j, i4);
        this.f6723f.b();
    }

    public void showInfoWindow(InfoWindow infoWindow) {
        if (infoWindow == null) {
            throw new IllegalArgumentException("BDMapSDKException: the InfoWindow can not be null");
        }
        InfoWindow infoWindow2 = this.f6614P;
        if (infoWindow2 == null) {
            this.f6614P = infoWindow;
        } else {
            InfoWindow.a aVar = this.f6615Q;
            if (aVar != null) {
                aVar.a(infoWindow2);
            }
            a(this.f6614P, infoWindow);
        }
        InfoWindow.a aVar2 = this.f6615Q;
        if (aVar2 != null) {
            aVar2.b(this.f6614P);
            this.f6616R = true;
        }
    }

    public void showSmoothMoveInfoWindow(InfoWindow infoWindow) {
        if (infoWindow == null) {
            return;
        }
        if (!infoWindow.f6489n) {
            throw new IllegalArgumentException("BDMapSDKException: the SmoothMoveInfoWindow must build with View");
        }
        if (infoWindow.f6478c == null) {
            throw new IllegalArgumentException("BDMapSDKException: the SmoothMoveInfoWindow's View can not be null");
        }
        InfoWindow infoWindow2 = this.f6614P;
        if (infoWindow2 == null) {
            this.f6614P = infoWindow;
        } else {
            a(infoWindow2, infoWindow);
        }
        InfoWindow infoWindow3 = this.f6614P;
        infoWindow3.f6488m = true;
        InfoWindow.a aVar = this.f6615Q;
        if (aVar != null) {
            aVar.b(infoWindow3);
            this.f6616R = true;
        }
    }

    public void startAnimation() {
        if (this.f6609K != null) {
            if (!OverlayUtil.isOverlayUpgrade()) {
                this.f6609K.bdAnimation.startAnimation();
            } else {
                this.f6609K.bmAnimation.start();
                this.f6723f.b();
            }
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmIconMarker bmIconMarker = new BmIconMarker();
        this.f6625j = bmIconMarker;
        bmIconMarker.a(this);
        setDrawItem(this.f6625j);
        super.toDrawItem();
        if (this.f6605G != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<BitmapDescriptor> it = this.f6605G.iterator();
            while (it.hasNext()) {
                arrayList.add(new BmBitmapResource(it.next().getBitmap()));
            }
            this.f6606H = new BmFrameResource(arrayList, this.f6604F, Integer.MAX_VALUE);
            this.f6607I = arrayList.size();
            this.f6625j.a(this.f6606H);
        } else {
            BmBitmapResource bmBitmapResource = this.f6624i;
            if (bmBitmapResource != null) {
                this.f6625j.a(bmBitmapResource);
            } else if (this.f6623h != null) {
                this.f6625j.a(new BmBitmapResource(this.f6623h.getBitmap()));
            }
        }
        LatLng latLng = this.f6622g;
        if (latLng != null) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLng);
            this.f6625j.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
        }
        this.f6625j.k(this.f6626k);
        this.f6625j.a(this.f6639x);
        this.f6625j.a(this.f6599A);
        this.f6625j.a(this.f6618U, this.f6619V);
        this.f6625j.d(this.f6720c);
        this.f6625j.e(this.f6612N);
        this.f6625j.f(this.f6610L);
        this.f6625j.g(this.f6611M);
        this.f6625j.l(this.f6636u);
        this.f6625j.m(this.f6635t);
        this.f6625j.d(this.f6631p);
        this.f6625j.o(this.f6640y);
        Animation animation = this.f6609K;
        if (animation != null) {
            this.f6625j.a(animation.bmAnimation);
        }
        this.f6625j.a(this.f6718a);
        this.f6625j.d(this.f6720c);
        this.f6625j.j(this.f6641z ? 1 : 0);
        this.f6625j.n(this.f6629n ? 1 : 0);
        if (this.f6600B) {
            this.T |= CollisionBehavior.COLLIDE_WITH_INNER.getNumber();
        }
        if (this.f6602D) {
            this.T |= CollisionBehavior.ALWAYS_SHOW.getNumber();
        }
        if (this.f6601C) {
            this.T |= CollisionBehavior.COLLIDE_WITH_BASEPOI.getNumber();
        }
        Point point = this.f6613O;
        if (point != null) {
            this.f6625j.g(point.x);
            this.f6625j.h(this.f6613O.y);
            this.T = CollisionBehavior.NOT_COLLIDE.getNumber();
        }
        this.f6625j.e(this.T);
        this.f6625j.f(this.f6617S);
        if (this.f6637v) {
            this.f6625j.i(3);
        } else {
            this.f6625j.i(0);
        }
        this.f6625j.b(this.f6627l);
        this.f6625j.c(this.f6628m);
        if (this.f6633r != null) {
            BmTextMarker bmTextMarker = this.f6634s;
            if (bmTextMarker != null) {
                this.f6723f.a(bmTextMarker);
                this.f6634s = null;
            }
            BmTextMarker bmTextMarker2 = new BmTextMarker();
            this.f6634s = bmTextMarker2;
            bmTextMarker2.setName("titleOption");
            this.f6634s.b(this.f6633r.getText());
            if (this.f6600B) {
                BmTextMarker bmTextMarker3 = this.f6634s;
                CollisionBehavior collisionBehavior = CollisionBehavior.ALWAYS_SHOW;
                bmTextMarker3.e(collisionBehavior.getNumber());
                this.f6625j.e(collisionBehavior.getNumber());
                if (this.f6601C) {
                    BmTextMarker bmTextMarker4 = this.f6634s;
                    int number = collisionBehavior.getNumber();
                    CollisionBehavior collisionBehavior2 = CollisionBehavior.COLLIDE_WITH_BASEPOI;
                    bmTextMarker4.e(number | collisionBehavior2.getNumber());
                    this.f6625j.e(collisionBehavior.getNumber() | collisionBehavior2.getNumber());
                }
            } else {
                this.f6634s.e(this.T);
                this.f6634s.f(this.f6617S);
            }
            BmTextStyle bmTextStyle = new BmTextStyle();
            bmTextStyle.e((this.f6633r.getTitleFontSize() * 310) / SysOSUtil.getDensityDpi());
            bmTextStyle.d(this.f6633r.getTitleFontColor());
            bmTextStyle.c(0);
            this.f6634s.d(this.f6633r.getTitleRotate());
            GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(this.f6622g);
            this.f6634s.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc2.getLongitudeE6(), geoPointLl2mc2.getLatitudeE6()));
            this.f6634s.b(this.f6633r.getTitleAnchorX());
            this.f6634s.c(this.f6633r.getTitleAnchorY());
            this.f6634s.l((this.f6633r.getTitleXOffset() * 310) / SysOSUtil.getDensityDpi());
            int titleYOffset = this.f6633r.getTitleYOffset();
            if (this.f6623h != null) {
                titleYOffset -= (int) (r2.getBitmap().getHeight() * this.f6611M);
            }
            this.f6634s.m((titleYOffset * 310) / SysOSUtil.getDensityDpi());
            this.f6634s.a(bmTextStyle);
            this.f6723f.a(this.f6634s, this.f6625j.b() + 1);
            this.f6723f.b();
        }
        return this.f6625j;
    }

    public void updateInfoWindowBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        InfoWindow infoWindow = this.f6614P;
        if (infoWindow == null || infoWindow.f6490o) {
            return;
        }
        infoWindow.setBitmapDescriptor(bitmapDescriptor);
    }

    public void updateInfoWindowPosition(LatLng latLng) {
        InfoWindow infoWindow = this.f6614P;
        if (infoWindow != null) {
            infoWindow.setPosition(latLng);
        }
    }

    public void updateInfoWindowView(View view) {
        InfoWindow infoWindow = this.f6614P;
        if (infoWindow == null || !infoWindow.f6489n) {
            return;
        }
        infoWindow.setView(view);
    }

    public void updateInfoWindowYOffset(int i4) {
        InfoWindow infoWindow = this.f6614P;
        if (infoWindow != null) {
            infoWindow.setYOffset(i4);
        }
    }

    public void updateRichView() {
        BmLayer bmLayer;
        if (!OverlayUtil.isOverlayUpgrade() || (bmLayer = this.f6723f) == null) {
            return;
        }
        bmLayer.b();
    }

    public void setAnimation(Animation animation, TypeEvaluator typeEvaluator) {
        if (animation != null) {
            this.f6609K = animation;
            animation.bdAnimation.setTypeEvaluator(typeEvaluator);
            this.f6609K.bdAnimation.setAnimation(this, animation);
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) throws NoSuchAlgorithmException {
        super.a(bundle);
        Bundle bundle2 = new Bundle();
        BitmapDescriptor bitmapDescriptor = this.f6623h;
        if (bitmapDescriptor != null) {
            bundle.putBundle("image_info", bitmapDescriptor.a());
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6622g);
        bundle.putInt("animatetype", this.f6640y);
        bundle.putDouble(SleepModeData.LOCATION_X, geoPointLl2mc.getLongitudeE6());
        bundle.putDouble(SleepModeData.LOCATION_Y, geoPointLl2mc.getLatitudeE6());
        bundle.putInt("perspective", this.f6629n ? 1 : 0);
        bundle.putFloat("anchor_x", this.f6627l);
        bundle.putFloat("anchor_y", this.f6628m);
        bundle.putFloat("rotate", this.f6631p);
        bundle.putInt("y_offset", this.f6635t);
        bundle.putInt("x_offset", this.f6636u);
        bundle.putInt("isflat", this.f6637v ? 1 : 0);
        bundle.putInt("istop", this.f6638w ? 1 : 0);
        bundle.putInt("period", this.f6608J);
        bundle.putFloat(ViewTweenItem.ALPHA, this.f6639x);
        bundle.putInt("m_height", this.f6603E);
        bundle.putFloat("scaleX", this.f6610L);
        bundle.putFloat("scaleY", this.f6611M);
        bundle.putInt("isClickable", this.f6599A ? 1 : 0);
        bundle.putInt("priority", this.f6617S);
        bundle.putInt("isJoinCollision", this.f6600B ? 1 : 0);
        bundle.putInt("isForceDisplay", this.f6602D ? 1 : 0);
        bundle.putInt("startLevel", this.f6618U);
        bundle.putInt("endLevel", this.f6619V);
        Point point = this.f6613O;
        if (point != null) {
            bundle.putInt("fix_x", point.x);
            bundle.putInt("fix_y", this.f6613O.y);
        }
        bundle.putInt("isfixed", this.f6641z ? 1 : 0);
        ArrayList<BitmapDescriptor> arrayList = this.f6605G;
        if (arrayList != null && arrayList.size() > 0) {
            a(this.f6605G, bundle);
        }
        bundle2.putBundle("param", bundle);
        TitleOptions titleOptions = this.f6633r;
        if (titleOptions != null) {
            bundle.putBundle("m_title", titleOptions.a());
            int titleYOffset = this.f6633r.getTitleYOffset();
            if (this.f6623h != null) {
                titleYOffset -= (int) (r2.getBitmap().getHeight() * this.f6611M);
            }
            Bundle bundle3 = bundle.getBundle("m_title");
            if (bundle3 != null) {
                bundle3.putInt("title_y_offset", titleYOffset);
            }
        }
        bundle.putInt("update", this.f6620W);
        bundle.putInt("poi_collied", this.f6601C ? 1 : 0);
        return bundle;
    }

    public void showInfoWindow() {
        LatLng latLng;
        InfoWindowAdapter infoWindowAdapter = this.f6621X;
        if (infoWindowAdapter == null) {
            Log.e("BDMapSDKException", "Marker showInfoWindow InfoWindowAdapter listener can not be null");
            return;
        }
        InfoWindow infoWindow = infoWindowAdapter.getInfoWindow(this);
        if (infoWindow == null) {
            View infoWindowView = this.f6621X.getInfoWindowView(this);
            int infoWindowViewYOffset = this.f6621X.getInfoWindowViewYOffset();
            if (infoWindowView != null && (latLng = this.f6622g) != null) {
                infoWindow = new InfoWindow(infoWindowView, latLng, infoWindowViewYOffset);
            }
        }
        if (infoWindow != null) {
            InfoWindow infoWindow2 = this.f6614P;
            if (infoWindow2 == null) {
                this.f6614P = infoWindow;
            } else {
                InfoWindow.a aVar = this.f6615Q;
                if (aVar != null) {
                    aVar.a(infoWindow2);
                }
                a(this.f6614P, infoWindow);
            }
            InfoWindow.a aVar2 = this.f6615Q;
            if (aVar2 != null) {
                aVar2.b(this.f6614P);
                this.f6616R = true;
            }
        }
    }

    public void setIcons(ArrayList<BitmapDescriptor> arrayList, int[] iArr, int i4) {
        if (!OverlayUtil.isOverlayUpgrade() || arrayList == null || arrayList.isEmpty() || arrayList.size() > iArr.length || i4 < 0) {
            return;
        }
        if (arrayList.size() == 1) {
            this.f6623h = arrayList.get(0);
        } else {
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                if (arrayList.get(i5) == null || arrayList.get(i5).f6261a == null) {
                    return;
                }
            }
            this.f6605G = (ArrayList) arrayList.clone();
            this.f6623h = null;
        }
        BmIconMarker bmIconMarker = this.f6625j;
        if (bmIconMarker == null || this.f6723f == null) {
            return;
        }
        if (this.f6605G != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<BitmapDescriptor> it = this.f6605G.iterator();
            while (it.hasNext()) {
                arrayList2.add(new BmBitmapResource(it.next().getBitmap()));
            }
            BmFrameResource bmFrameResource = new BmFrameResource(arrayList2, iArr, i4);
            this.f6606H = bmFrameResource;
            this.f6625j.a(bmFrameResource);
        } else if (this.f6623h != null) {
            bmIconMarker.a(new BmBitmapResource(this.f6623h.getBitmap()));
        }
        this.f6723f.b();
    }

    private void a(ArrayList<BitmapDescriptor> arrayList, Bundle bundle) throws NoSuchAlgorithmException {
        int i4;
        MessageDigest messageDigest;
        ArrayList arrayList2 = new ArrayList();
        Iterator<BitmapDescriptor> it = arrayList.iterator();
        while (true) {
            i4 = 0;
            if (!it.hasNext()) {
                break;
            }
            BitmapDescriptor next = it.next();
            ParcelItem parcelItem = new ParcelItem();
            Bundle bundle2 = new Bundle();
            Bitmap bitmap = next.f6261a;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bitmap.getHeight() * bitmap.getWidth() * 4);
            bitmap.copyPixelsToBuffer(byteBufferAllocate);
            byte[] bArrArray = byteBufferAllocate.array();
            bundle2.putByteArray("image_data", bArrArray);
            bundle2.putInt("image_width", bitmap.getWidth());
            bundle2.putInt("image_height", bitmap.getHeight());
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e4) {
                e4.printStackTrace();
                messageDigest = null;
            }
            if (messageDigest != null) {
                messageDigest.update(bArrArray, 0, bArrArray.length);
                byte[] bArrDigest = messageDigest.digest();
                StringBuilder sb = new StringBuilder("");
                while (i4 < bArrDigest.length) {
                    sb.append(Integer.toString((bArrDigest[i4] & UByte.MAX_VALUE) + 256, 16).substring(1));
                    i4++;
                }
                bundle2.putString("image_hashcode", sb.toString());
            }
            parcelItem.setBundle(bundle2);
            arrayList2.add(parcelItem);
        }
        if (arrayList2.size() > 0) {
            ParcelItem[] parcelItemArr = new ParcelItem[arrayList2.size()];
            while (i4 < arrayList2.size()) {
                parcelItemArr[i4] = (ParcelItem) arrayList2.get(i4);
                i4++;
            }
            bundle.putParcelableArray("icons", parcelItemArr);
        }
    }
}
