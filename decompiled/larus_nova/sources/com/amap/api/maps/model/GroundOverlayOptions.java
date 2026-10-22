package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public final class GroundOverlayOptions extends BaseOptions implements Parcelable, Cloneable {
    private static final String CLASSNAME = "GroundOverlayOptions";
    public static final GroundOverlayOptionsCreator CREATOR = null;
    public static final float NO_DIMENSION = -1.0f;
    private final double NF_PI;
    private final double R;
    private float anchorU;
    private float anchorV;
    private float bearing;
    private BitmapDescriptor bitmapDescriptor;
    private float height;
    private boolean isVisible;
    private LatLng latLng;
    private LatLngBounds latlngBounds;
    private final int mVersionCode;
    private LatLng northeast;
    private LatLng southwest;
    private float transparency;
    private float width;
    private float zIndex;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new GroundOverlayOptionsCreator();
    }

    private void a() {
        LatLng r100 = this.latLng;
        if (r100 != null) goto L5;
        return;
    L5:
        double r101 = ((double) this.width) / ((Math.cos(r100.latitude * 0.01745329251994329d) * 6371000.79d) * 0.01745329251994329d);
        double r102 = ((double) this.height) / 111194.94043265979d;
        LatLng r103 = this.latLng;     // Catch: Throwable -> L8
        LatLng r104 = new LatLng(r103.latitude - (((double) (1.0f - this.anchorV)) * r102), r103.longitude - (((double) this.anchorU) * r101));     // Catch: Throwable -> L8
        LatLng r105 = this.latLng;     // Catch: Throwable -> L8
        LatLngBounds r106 = new LatLngBounds(r104, new LatLng(r105.latitude + (((double) this.anchorV) * r102), r105.longitude + (((double) (1.0f - this.anchorU)) * r101)));     // Catch: Throwable -> L8
        this.latlngBounds = r106;     // Catch: Throwable -> L8
        this.southwest = r106.southwest;     // Catch: Throwable -> L8
        this.northeast = r106.northeast;     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
    }

    private void b() {
        if (this.southwest != null) goto L5;
        return;
    L5:
        if (this.northeast == null) goto L10;
        LatLng r100 = this.southwest;
        double r101 = r100.latitude;
        double r102 = 1.0f - this.anchorV;
        LatLng r103 = this.northeast;
        double r104 = r101 + (r102 * (r103.latitude - r101));
        double r105 = r100.longitude;
        LatLng r106 = new LatLng(r104, r105 + (((double) this.anchorU) * (r103.longitude - r105)));
        this.latLng = r106;
        double r107 = Math.cos(r106.latitude * 0.01745329251994329d) * 6371000.79d;
        LatLng r108 = this.northeast;
        double r109 = r108.longitude;
        LatLng r110 = this.southwest;
        this.width = (float) ((r107 * (r109 - r110.longitude)) * 0.01745329251994329d);
        this.height = (float) (((r108.latitude - r110.latitude) * 6371000.79d) * 0.01745329251994329d);
        return;
    }

    public GroundOverlayOptions() {
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.transparency = 0.0f;
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
        this.NF_PI = 0.01745329251994329d;
        this.R = 6371000.79d;
        this.mVersionCode = 1;
        this.type = CLASSNAME;
    }

    public GroundOverlayOptions clone() {
        super.clone();     // Catch: CloneNotSupportedException -> L4
    L6:
        GroundOverlayOptions r100 = new GroundOverlayOptions();
        r100.bitmapDescriptor = this.bitmapDescriptor;
        r100.latLng = this.latLng;
        r100.width = this.width;
        r100.height = this.height;
        r100.latlngBounds = this.latlngBounds;
        r100.bearing = this.bearing;
        r100.zIndex = this.zIndex;
        r100.isVisible = this.isVisible;
        r100.transparency = this.transparency;
        r100.anchorU = this.anchorU;
        r100.anchorV = this.anchorV;
        r100.southwest = this.southwest;
        r100.northeast = this.northeast;
        return r100;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    public float getAnchorU() {
        return this.anchorU;
    }

    public float getAnchorV() {
        return this.anchorV;
    }

    public float getBearing() {
        return this.bearing;
    }

    public LatLngBounds getBounds() {
        return this.latlngBounds;
    }

    public float getHeight() {
        return this.height;
    }

    public BitmapDescriptor getImage() {
        return this.bitmapDescriptor;
    }

    public LatLng getLocation() {
        return this.latLng;
    }

    public float getTransparency() {
        return this.transparency;
    }

    public float getWidth() {
        return this.width;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8025clone() throws CloneNotSupportedException {
        return clone();
    }

    public GroundOverlayOptions bearing(float r100) {
        this.bearing = r100;
        return this;
    }

    public GroundOverlayOptions image(BitmapDescriptor r100) {
        this.bitmapDescriptor = r100;
        return this;
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds r100) {
        this.latlngBounds = r100;
        this.southwest = r100.southwest;
        this.northeast = r100.northeast;
        b();
        return this;
    }

    public GroundOverlayOptions transparency(float r100) {
        if (r100 >= 0.0f) goto L5;
        r100 = 0.0f;
    L5:
        this.transparency = r100;
        return this;
    }

    public GroundOverlayOptions visible(boolean r100) {
        this.isVisible = r100;
        return this;
    }

    public GroundOverlayOptions zIndex(float r100) {
        this.zIndex = r100;
        return this;
    }

    public GroundOverlayOptions anchor(float r100, float r101) {
        this.anchorU = r100;
        this.anchorV = r101;
        if (this.latlngBounds == null) goto L6;
        b();
    L8:
        return this;
    L6:
        if (this.latLng == null) goto L8;
        a();
        goto L8
    }

    public GroundOverlayOptions position(LatLng r100, float r101) {
        this.latLng = r100;
        this.width = r101;
        this.height = r101;
        a();
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.mVersionCode);
        r100.writeParcelable(this.bitmapDescriptor, r101);
        r100.writeParcelable(this.latLng, r101);
        r100.writeFloat(this.width);
        r100.writeFloat(this.height);
        r100.writeParcelable(this.latlngBounds, r101);
        r100.writeFloat(this.bearing);
        r100.writeFloat(this.zIndex);
        r100.writeByte(this.isVisible ? 1 : 0);
        r100.writeFloat(this.transparency);
        r100.writeFloat(this.anchorU);
        r100.writeFloat(this.anchorV);
    }

    public GroundOverlayOptions position(LatLng r100, float r101, float r102) {
        if (r101 <= 0.0f) goto L5;
        int r103 = (r102 > 0.0f ? 1 : (r102 == 0.0f ? 0 : -1));
    L5:
        this.latLng = r100;
        this.width = r101;
        this.height = r102;
        a();
        return this;
    }

    public GroundOverlayOptions(int r100, LatLng r101, float r102, float r103, LatLngBounds r104, float r105, float r106, boolean r110, float r111, float r112, float r113) {
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.transparency = 0.0f;
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
        this.NF_PI = 0.01745329251994329d;
        this.R = 6371000.79d;
        this.mVersionCode = r100;
        this.bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(null);
        this.latLng = r101;
        this.width = r102;
        this.height = r103;
        this.latlngBounds = r104;
        this.bearing = r105;
        this.zIndex = r106;
        this.isVisible = r110;
        this.transparency = r111;
        this.anchorU = r112;
        this.anchorV = r113;
        this.southwest = r104.southwest;
        this.northeast = r104.northeast;
        this.type = CLASSNAME;
    }
}
