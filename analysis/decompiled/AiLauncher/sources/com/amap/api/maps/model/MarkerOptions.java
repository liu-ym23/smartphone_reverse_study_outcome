package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.jmsl.C1589o2;
import com.amap.api.col.jmsl.C1624x2;
import com.amap.api.col.jmsl.D2;
import com.amap.api.col.jmsl.G1;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public final class MarkerOptions extends BaseOptions implements Parcelable, Cloneable {
    public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();

    /* renamed from: a, reason: collision with root package name */
    String f17225a;

    /* renamed from: f, reason: collision with root package name */
    float f17230f;
    private LatLng gpsLatLng;
    private boolean isBelowMaskLayer;
    private LatLng latLng;
    private int screenX;
    private int screenY;
    private String snippet;
    private String title;
    private float anchorU = 0.5f;
    private float anchorV = 1.0f;
    private float zIndex = 100.0f;
    private boolean isDraggable = false;
    private boolean isVisible = true;
    private int offsetX = 0;
    private int offsetY = 0;
    private BitmapDescriptor bitmapDescriptor = null;
    private int period = 20;
    private boolean isGps = false;
    private boolean isFlat = false;
    private boolean isRotatingMode = false;
    private float angleOffset = 0.0f;
    private boolean isViewMode = false;
    private boolean clickable = true;

    /* renamed from: b, reason: collision with root package name */
    float f17226b = 1.0f;

    /* renamed from: c, reason: collision with root package name */
    boolean f17227c = false;

    /* renamed from: d, reason: collision with root package name */
    boolean f17228d = true;

    /* renamed from: e, reason: collision with root package name */
    int f17229e = 5;

    public MarkerOptions() {
        this.type = "MARKER";
    }

    private void a() {
        LatLng latLng;
        try {
            if (!this.isGps || (latLng = this.latLng) == null) {
                return;
            }
            double[] dArrB = D2.b(latLng.longitude, latLng.latitude);
            this.gpsLatLng = new LatLng(dArrB[1], dArrB[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public MarkerOptions anchor(float f10, float f11) {
        this.anchorU = f10;
        this.anchorV = f11;
        return this;
    }

    public void clickable(boolean z10) {
        this.clickable = z10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MarkerOptions draggable(boolean z10) {
        this.isDraggable = z10;
        return this;
    }

    public float getAnchorU() {
        return this.anchorU;
    }

    public float getAnchorV() {
        return this.anchorV;
    }

    public BitmapDescriptor getIcon() {
        return this.bitmapDescriptor;
    }

    public int getInfoWindowOffsetX() {
        return this.offsetX;
    }

    public int getInfoWindowOffsetY() {
        return this.offsetY;
    }

    public LatLng getPosition() {
        return this.latLng;
    }

    public float getRotateAngle() {
        return this.f17230f;
    }

    public String getSnippet() {
        return this.snippet;
    }

    public String getTitle() {
        return this.title;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        try {
            this.bitmapDescriptor = bitmapDescriptor;
            this.isRotatingMode = false;
            return this;
        } catch (Throwable th) {
            th.printStackTrace();
            return this;
        }
    }

    public MarkerOptions infoWindowEnable(boolean z10) {
        this.f17228d = z10;
        return this;
    }

    public boolean isClickable() {
        return this.clickable;
    }

    public boolean isDraggable() {
        return this.isDraggable;
    }

    public boolean isGps() {
        return this.isGps;
    }

    public boolean isInfoWindowEnable() {
        return this.f17228d;
    }

    public boolean isViewMode() {
        return this.isViewMode;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public MarkerOptions position(LatLng latLng) {
        this.latLng = latLng;
        this.isViewMode = false;
        a();
        return this;
    }

    public MarkerOptions rotateAngle(float f10) {
        this.f17230f = f10;
        return this;
    }

    public MarkerOptions setGps(boolean z10) {
        this.isGps = z10;
        a();
        return this;
    }

    public MarkerOptions setInfoWindowOffset(int i10, int i11) {
        this.offsetX = i10;
        this.offsetY = i11;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.snippet = str;
        return this;
    }

    public MarkerOptions title(String str) {
        this.title = str;
        return this;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public String toJson() {
        int width;
        int height;
        this.jsonMap.clear();
        addIfPresent("overlayType", this.type);
        addIfPresent("position", this.latLng);
        addIfPresent("visible", Boolean.valueOf(this.isVisible));
        addIfPresent("zIndex", Float.valueOf(this.zIndex));
        addIfPresent("title", this.title);
        addIfPresent("snippet", this.snippet);
        addIfPresent("draggable", Boolean.valueOf(this.isDraggable));
        addIfPresent("angle", Float.valueOf(((this.f17230f % 360.0f) + 360.0f) % 360.0f));
        addIfPresent("clickable", Boolean.valueOf(this.clickable));
        BitmapDescriptor bitmapDescriptor = this.bitmapDescriptor;
        if (bitmapDescriptor != null) {
            addIfPresent("icon", bitmapDescriptor);
            width = this.bitmapDescriptor.getWidth();
            height = this.bitmapDescriptor.getHeight();
        } else {
            addIfPresent("icon", new C1589o2(C1624x2.f("localhost_amap_bimap:default_marker", 57.0f / G1.a(), 74.0f / G1.a())));
            width = 57;
            height = 74;
        }
        addIfPresent("offset", new C1589o2("new AMap.Pixel(" + (((-this.anchorU) * width) / G1.a()) + Const.STR_MART_COMMA + (((-this.anchorV) * height) / G1.a()) + ")"));
        return C1624x2.g(this.jsonMap);
    }

    public MarkerOptions visible(boolean z10) {
        this.isVisible = z10;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.latLng, i10);
        parcel.writeString(this.title);
        parcel.writeString(this.snippet);
        parcel.writeFloat(this.anchorU);
        parcel.writeFloat(this.anchorV);
        parcel.writeInt(this.offsetX);
        parcel.writeInt(this.offsetY);
        parcel.writeBooleanArray(new boolean[]{this.isVisible, this.isDraggable, this.isGps, this.isFlat, this.f17227c, this.f17228d, this.isBelowMaskLayer, this.isRotatingMode, this.clickable});
        parcel.writeString(this.f17225a);
        parcel.writeFloat(this.zIndex);
        parcel.writeFloat(this.f17226b);
        parcel.writeInt(this.f17229e);
        parcel.writeFloat(this.f17230f);
        parcel.writeFloat(this.angleOffset);
        parcel.writeInt(this.screenX);
        parcel.writeInt(this.screenY);
        BitmapDescriptor bitmapDescriptor = this.bitmapDescriptor;
        if (bitmapDescriptor != null) {
            parcel.writeParcelable(bitmapDescriptor, i10);
        }
    }

    public MarkerOptions zIndex(float f10) {
        this.zIndex = f10;
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public MarkerOptions m14clone() throws CloneNotSupportedException {
        try {
            super.clone();
        } catch (CloneNotSupportedException e10) {
            e10.printStackTrace();
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.latLng = this.latLng;
        markerOptions.gpsLatLng = this.gpsLatLng;
        markerOptions.title = this.title;
        markerOptions.snippet = this.snippet;
        markerOptions.anchorU = this.anchorU;
        markerOptions.anchorV = this.anchorV;
        markerOptions.zIndex = this.zIndex;
        markerOptions.isDraggable = this.isDraggable;
        markerOptions.isVisible = this.isVisible;
        markerOptions.f17225a = this.f17225a;
        markerOptions.offsetX = this.offsetX;
        markerOptions.offsetY = this.offsetY;
        markerOptions.period = this.period;
        markerOptions.isGps = this.isGps;
        markerOptions.isFlat = this.isFlat;
        markerOptions.isRotatingMode = this.isRotatingMode;
        markerOptions.angleOffset = this.angleOffset;
        markerOptions.screenX = this.screenX;
        markerOptions.screenY = this.screenY;
        markerOptions.isViewMode = this.isViewMode;
        markerOptions.f17226b = this.f17226b;
        markerOptions.f17227c = this.f17227c;
        markerOptions.f17228d = this.f17228d;
        markerOptions.f17229e = this.f17229e;
        markerOptions.f17230f = this.f17230f;
        markerOptions.isBelowMaskLayer = this.isBelowMaskLayer;
        markerOptions.clickable = this.clickable;
        markerOptions.bitmapDescriptor = this.bitmapDescriptor;
        return markerOptions;
    }
}
