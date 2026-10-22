package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class MarkerOptions extends OverlayOptions {

    /* renamed from: G, reason: collision with root package name */
    int f6648G;

    /* renamed from: I, reason: collision with root package name */
    Bundle f6650I;

    /* renamed from: a, reason: collision with root package name */
    private LatLng f6651a;

    /* renamed from: b, reason: collision with root package name */
    private BitmapDescriptor f6652b;

    /* renamed from: c, reason: collision with root package name */
    private BmBitmapResource f6653c;

    /* renamed from: i, reason: collision with root package name */
    private float f6659i;

    /* renamed from: j, reason: collision with root package name */
    private TitleOptions f6660j;

    /* renamed from: k, reason: collision with root package name */
    private String f6661k;

    /* renamed from: l, reason: collision with root package name */
    private int f6662l;

    /* renamed from: m, reason: collision with root package name */
    private int f6663m;

    /* renamed from: o, reason: collision with root package name */
    private ArrayList<BitmapDescriptor> f6665o;

    /* renamed from: x, reason: collision with root package name */
    private Point f6674x;

    /* renamed from: z, reason: collision with root package name */
    private InfoWindow f6676z;

    /* renamed from: d, reason: collision with root package name */
    private float f6654d = 0.5f;

    /* renamed from: e, reason: collision with root package name */
    private int f6655e = 2;

    /* renamed from: f, reason: collision with root package name */
    private float f6656f = 1.0f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f6657g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6658h = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f6664n = false;

    /* renamed from: p, reason: collision with root package name */
    private int f6666p = 20;

    /* renamed from: q, reason: collision with root package name */
    private int f6667q = 160;

    /* renamed from: r, reason: collision with root package name */
    private float f6668r = 1.0f;

    /* renamed from: s, reason: collision with root package name */
    private float f6669s = 1.0f;

    /* renamed from: t, reason: collision with root package name */
    private float f6670t = 1.0f;

    /* renamed from: u, reason: collision with root package name */
    private int f6671u = 0;

    /* renamed from: v, reason: collision with root package name */
    private int f6672v = MarkerAnimateType.none.ordinal();

    /* renamed from: w, reason: collision with root package name */
    private boolean f6673w = false;

    /* renamed from: y, reason: collision with root package name */
    private boolean f6675y = true;

    /* renamed from: A, reason: collision with root package name */
    private int f6642A = Integer.MAX_VALUE;

    /* renamed from: B, reason: collision with root package name */
    private boolean f6643B = false;

    /* renamed from: C, reason: collision with root package name */
    private int f6644C = 4;

    /* renamed from: D, reason: collision with root package name */
    private int f6645D = 22;

    /* renamed from: E, reason: collision with root package name */
    private boolean f6646E = false;

    /* renamed from: F, reason: collision with root package name */
    private boolean f6647F = false;

    /* renamed from: H, reason: collision with root package name */
    boolean f6649H = true;

    public enum MarkerAnimateType {
        none,
        drop,
        grow,
        jump
    }

    public MarkerOptions alpha(float f4) {
        if (f4 < Property.DEFAULT_FLOAT_VALUE || f4 > 1.0f) {
            this.f6670t = 1.0f;
            return this;
        }
        this.f6670t = f4;
        return this;
    }

    public MarkerOptions anchor(float f4, float f5) {
        if (f4 >= Property.DEFAULT_FLOAT_VALUE && f4 <= 1.0f && f5 >= Property.DEFAULT_FLOAT_VALUE && f5 <= 1.0f) {
            this.f6654d = f4;
            this.f6656f = f5;
        }
        return this;
    }

    public MarkerOptions animateType(MarkerAnimateType markerAnimateType) {
        if (markerAnimateType == null) {
            markerAnimateType = MarkerAnimateType.none;
        }
        this.f6672v = markerAnimateType.ordinal();
        return this;
    }

    public MarkerOptions bitmapResource(BmBitmapResource bmBitmapResource) {
        this.f6653c = bmBitmapResource;
        return this;
    }

    public MarkerOptions clickable(boolean z4) {
        this.f6675y = z4;
        return this;
    }

    public MarkerOptions draggable(boolean z4) {
        this.f6658h = z4;
        return this;
    }

    public MarkerOptions endLevel(int i4) {
        this.f6645D = i4;
        return this;
    }

    public MarkerOptions extraInfo(Bundle bundle) {
        this.f6650I = bundle;
        return this;
    }

    public MarkerOptions fixedScreenPosition(Point point) {
        this.f6674x = point;
        this.f6673w = true;
        return this;
    }

    public MarkerOptions flat(boolean z4) {
        this.f6664n = z4;
        return this;
    }

    public float getAlpha() {
        return this.f6670t;
    }

    public float getAnchorX() {
        return this.f6654d;
    }

    public float getAnchorY() {
        return this.f6656f;
    }

    public MarkerAnimateType getAnimateType() {
        int i4 = this.f6672v;
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? MarkerAnimateType.none : MarkerAnimateType.jump : MarkerAnimateType.grow : MarkerAnimateType.drop;
    }

    public BmBitmapResource getBmBitmapResource() {
        return this.f6653c;
    }

    public int getEndLevel() {
        return this.f6645D;
    }

    public Bundle getExtraInfo() {
        return this.f6650I;
    }

    public boolean getForceDisPlay() {
        return this.f6643B;
    }

    public int getHeight() {
        return this.f6671u;
    }

    public BitmapDescriptor getIcon() {
        return this.f6652b;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.f6665o;
    }

    public int getInterval() {
        return this.f6667q;
    }

    public boolean getIsClickable() {
        return this.f6675y;
    }

    public boolean getJoinCollision() {
        return this.f6646E;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Marker marker = new Marker();
        marker.f6721d = this.f6649H;
        marker.f6720c = this.f6648G;
        marker.f6722e = this.f6650I;
        LatLng latLng = this.f6651a;
        if (latLng == null) {
            throw new IllegalStateException("BDMapSDKException: when you add marker, you must set the position");
        }
        marker.f6622g = latLng;
        BitmapDescriptor bitmapDescriptor = this.f6652b;
        if (bitmapDescriptor == null && this.f6665o == null && this.f6653c == null) {
            throw new IllegalStateException("BDMapSDKException: when you add marker, you must set the icon or icons");
        }
        marker.f6623h = bitmapDescriptor;
        marker.f6624i = this.f6653c;
        marker.f6627l = this.f6654d;
        marker.f6628m = this.f6656f;
        marker.f6626k = this.f6655e;
        marker.f6629n = this.f6657g;
        marker.f6630o = this.f6658h;
        marker.f6631p = this.f6659i;
        marker.f6633r = this.f6660j;
        marker.f6635t = this.f6662l;
        marker.f6636u = this.f6663m;
        marker.f6637v = this.f6664n;
        marker.f6605G = this.f6665o;
        marker.f6608J = this.f6666p;
        marker.f6604F = this.f6667q;
        marker.f6639x = this.f6670t;
        marker.f6603E = this.f6671u;
        marker.f6610L = this.f6668r;
        marker.f6611M = this.f6669s;
        marker.f6640y = this.f6672v;
        marker.f6641z = this.f6673w;
        marker.f6614P = this.f6676z;
        marker.f6599A = this.f6675y;
        marker.f6617S = this.f6642A;
        marker.f6602D = this.f6643B;
        marker.f6618U = this.f6644C;
        marker.f6619V = this.f6645D;
        marker.f6600B = this.f6646E;
        marker.f6601C = this.f6647F;
        Point point = this.f6674x;
        if (point != null) {
            marker.f6613O = point;
        }
        return marker;
    }

    public int getPeriod() {
        return this.f6666p;
    }

    public LatLng getPosition() {
        return this.f6651a;
    }

    public int getPriority() {
        return this.f6642A;
    }

    public float getRotate() {
        return this.f6659i;
    }

    public int getStartLevel() {
        return this.f6644C;
    }

    @Deprecated
    public String getTitle() {
        return this.f6661k;
    }

    public TitleOptions getTitleOptions() {
        return this.f6660j;
    }

    public int getZIndex() {
        return this.f6648G;
    }

    public MarkerOptions height(int i4) {
        if (i4 < 0) {
            this.f6671u = 0;
            return this;
        }
        this.f6671u = i4;
        return this;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
        }
        this.f6652b = bitmapDescriptor;
        return this;
    }

    public MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's icons can not be null");
        }
        if (arrayList.isEmpty()) {
            return this;
        }
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            if (arrayList.get(i4) == null || arrayList.get(i4).f6261a == null) {
                return this;
            }
        }
        this.f6665o = arrayList;
        return this;
    }

    public MarkerOptions infoWindow(InfoWindow infoWindow) {
        this.f6676z = infoWindow;
        return this;
    }

    public MarkerOptions interval(int i4) {
        if (i4 <= 0) {
            throw new IllegalArgumentException("BDMapSDKException: marker's interval must be greater than zero ");
        }
        this.f6667q = i4;
        return this;
    }

    public boolean isDraggable() {
        return this.f6658h;
    }

    public boolean isFlat() {
        return this.f6664n;
    }

    public MarkerOptions isForceDisPlay(boolean z4) {
        this.f6643B = z4;
        return this;
    }

    public MarkerOptions isJoinCollision(boolean z4) {
        this.f6646E = z4;
        return this;
    }

    public boolean isPerspective() {
        return this.f6657g;
    }

    public boolean isPoiCollided() {
        return this.f6647F;
    }

    public boolean isVisible() {
        return this.f6649H;
    }

    public MarkerOptions period(int i4) {
        if (i4 <= 0) {
            throw new IllegalArgumentException("BDMapSDKException: marker's period must be greater than zero ");
        }
        this.f6666p = i4;
        return this;
    }

    public MarkerOptions perspective(boolean z4) {
        this.f6657g = z4;
        return this;
    }

    public MarkerOptions poiCollided(boolean z4) {
        this.f6647F = z4;
        return this;
    }

    public MarkerOptions position(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
        }
        this.f6651a = latLng;
        return this;
    }

    public MarkerOptions priority(int i4) {
        this.f6642A = i4;
        return this;
    }

    public MarkerOptions rotate(float f4) {
        while (f4 < Property.DEFAULT_FLOAT_VALUE) {
            f4 += 360.0f;
        }
        this.f6659i = f4 % 360.0f;
        return this;
    }

    public MarkerOptions scaleX(float f4) {
        if (f4 < Property.DEFAULT_FLOAT_VALUE) {
            return this;
        }
        this.f6668r = f4;
        return this;
    }

    public MarkerOptions scaleY(float f4) {
        if (f4 < Property.DEFAULT_FLOAT_VALUE) {
            return this;
        }
        this.f6669s = f4;
        return this;
    }

    public MarkerOptions startLevel(int i4) {
        this.f6644C = i4;
        return this;
    }

    public MarkerOptions title(String str) {
        this.f6661k = str;
        return this;
    }

    public MarkerOptions titleOptions(TitleOptions titleOptions) {
        this.f6660j = titleOptions;
        return this;
    }

    public MarkerOptions visible(boolean z4) {
        this.f6649H = z4;
        return this;
    }

    public MarkerOptions xOffset(int i4) {
        this.f6663m = i4;
        return this;
    }

    public MarkerOptions yOffset(int i4) {
        this.f6662l = i4;
        return this;
    }

    public MarkerOptions zIndex(int i4) {
        this.f6648G = i4;
        return this;
    }
}
