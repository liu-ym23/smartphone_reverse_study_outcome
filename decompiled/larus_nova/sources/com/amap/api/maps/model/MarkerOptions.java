package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class MarkerOptions extends BaseOptions implements Parcelable, Cloneable {
    public static final MarkerOptionsCreator CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f28660a;
    private float alpha;
    private float altitude;
    private float anchorU;
    private float anchorV;
    private float angleOffset;
    private boolean autoOverturn;
    private List<BitmapDescriptor> bitmapDescriptors;
    private int dispLevel;
    private LatLng gpsLatLng;
    private View iconView;
    private boolean infoWindowEnabled;
    private boolean isBelowMaskLayer;
    private boolean isDraggable;
    private boolean isFlat;
    private boolean isGps;
    private boolean isOpenCollisionDetection;
    private boolean isRotatingMode;
    private boolean isViewMode;
    private boolean isVisible;
    private LatLng latLng;
    private int offsetX;
    private int offsetY;
    private int period;
    private boolean perspective;
    private float rotate;
    private int screenX;
    private int screenY;
    private String snippet;
    private String title;
    private MarkerUpdateFlags updateFlags;
    private float zIndex;

    public static class MarkerUpdateFlags extends BaseOptions.BaseUpdateFlags {
        public boolean anchorUpdate;
        public boolean bitmapDescriptorsUpdate;
        public boolean gpsLatLngUpdate;
        public boolean latlngUpdate;

        public MarkerUpdateFlags() {
            this.latlngUpdate = false;
            this.gpsLatLngUpdate = false;
            this.bitmapDescriptorsUpdate = false;
            this.anchorUpdate = false;
        }

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.latlngUpdate = false;
            this.gpsLatLngUpdate = false;
            this.bitmapDescriptorsUpdate = false;
            this.anchorUpdate = false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new MarkerOptionsCreator();
    }

    private void a() {
    L8:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (this.isGps == false) goto L13;
        LatLng r100 = this.latLng;     // Catch: Throwable -> L8
        if (r100 == null) goto L14;
        double[] r101 = com.autonavi.util.a.a(r100.longitude, r100.latitude);     // Catch: Throwable -> L8
        this.gpsLatLng = new LatLng(r101[1], r101[0]);     // Catch: Throwable -> L8
        this.updateFlags.gpsLatLngUpdate = true;     // Catch: Throwable -> L8
        return;
    L14:
        return;
    }

    public BitmapDescriptor getIcon() {
        List<BitmapDescriptor> r100 = this.bitmapDescriptors;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.size() != 0) goto L7;
        return null;
    L7:
        return (BitmapDescriptor) ListProtector.get(this.bitmapDescriptors, 0);
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return (ArrayList) this.bitmapDescriptors;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public MarkerOptions() {
        this.anchorU = 0.5f;
        this.anchorV = 1.0f;
        this.zIndex = 0.0f;
        this.isDraggable = false;
        this.isVisible = true;
        this.altitude = 0.0f;
        this.isOpenCollisionDetection = false;
        this.perspective = false;
        this.offsetX = 0;
        this.offsetY = 0;
        this.bitmapDescriptors = new ArrayList();
        this.period = 20;
        this.isGps = false;
        this.isFlat = false;
        this.isRotatingMode = false;
        this.angleOffset = 0.0f;
        this.isViewMode = false;
        this.iconView = null;
        this.alpha = 1.0f;
        this.autoOverturn = false;
        this.infoWindowEnabled = true;
        this.dispLevel = 5;
        this.updateFlags = new MarkerUpdateFlags();
        this.type = "MarkerOptions";
    }

    public MarkerOptions clone() {
        super.clone();     // Catch: CloneNotSupportedException -> L4
    L6:
        MarkerOptions r100 = new MarkerOptions();
        r100.latLng = this.latLng;
        r100.gpsLatLng = this.gpsLatLng;
        r100.title = this.title;
        r100.snippet = this.snippet;
        r100.anchorU = this.anchorU;
        r100.anchorV = this.anchorV;
        r100.zIndex = this.zIndex;
        r100.isDraggable = this.isDraggable;
        r100.isVisible = this.isVisible;
        r100.f28660a = this.f28660a;
        r100.perspective = this.perspective;
        r100.offsetX = this.offsetX;
        r100.offsetY = this.offsetY;
        r100.bitmapDescriptors = this.bitmapDescriptors;
        r100.period = this.period;
        r100.isGps = this.isGps;
        r100.isFlat = this.isFlat;
        r100.isRotatingMode = this.isRotatingMode;
        r100.angleOffset = this.angleOffset;
        r100.screenX = this.screenX;
        r100.screenY = this.screenY;
        r100.isViewMode = this.isViewMode;
        r100.alpha = this.alpha;
        r100.autoOverturn = this.autoOverturn;
        r100.infoWindowEnabled = this.infoWindowEnabled;
        r100.dispLevel = this.dispLevel;
        r100.rotate = this.rotate;
        r100.isBelowMaskLayer = this.isBelowMaskLayer;
        r100.updateFlags = this.updateFlags;
        r100.altitude = this.altitude;
        r100.isOpenCollisionDetection = this.isOpenCollisionDetection;
        r100.iconView = this.iconView;
        return r100;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public /* bridge */ /* synthetic */ BaseOptions.BaseUpdateFlags getUpdateFlags() {
        return getUpdateFlags();
    }

    public float getAlpha() {
        return this.alpha;
    }

    public float getAltitude() {
        return this.altitude;
    }

    public float getAnchorU() {
        return this.anchorU;
    }

    public float getAnchorV() {
        return this.anchorV;
    }

    public float getAngleOffset() {
        return this.angleOffset;
    }

    public int getDisplayLevel() {
        return this.dispLevel;
    }

    public View getIconView() {
        return this.iconView;
    }

    public int getInfoWindowOffsetX() {
        return this.offsetX;
    }

    public int getInfoWindowOffsetY() {
        return this.offsetY;
    }

    public int getPeriod() {
        return this.period;
    }

    public LatLng getPosition() {
        return this.latLng;
    }

    public float getRotateAngle() {
        return this.rotate;
    }

    public int getScreenX() {
        return this.screenX;
    }

    public int getScreenY() {
        return this.screenY;
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

    public boolean isBelowMaskLayer() {
        return this.isBelowMaskLayer;
    }

    public boolean isDraggable() {
        return this.isDraggable;
    }

    public boolean isFlat() {
        return this.isFlat;
    }

    public boolean isGps() {
        return this.isGps;
    }

    public boolean isInfoWindowAutoOverturn() {
        return this.autoOverturn;
    }

    public boolean isInfoWindowEnable() {
        return this.infoWindowEnabled;
    }

    public boolean isPerspective() {
        return this.perspective;
    }

    public boolean isRotatingMode() {
        return this.isRotatingMode;
    }

    public boolean isViewMode() {
        return this.isViewMode;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8027clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public MarkerUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public MarkerOptions alpha(float r100) {
        this.alpha = r100;
        return this;
    }

    public MarkerOptions altitude(float r100) {
        this.altitude = r100;
        return this;
    }

    public MarkerOptions angleOffset(float r100) {
        this.angleOffset = r100;
        return this;
    }

    public MarkerOptions autoOverturnInfoWindow(boolean r100) {
        this.autoOverturn = r100;
        return this;
    }

    public MarkerOptions belowMaskLayer(boolean r100) {
        this.isBelowMaskLayer = r100;
        return this;
    }

    public MarkerOptions displayLevel(int r100) {
        this.dispLevel = r100;
        return this;
    }

    public MarkerOptions draggable(boolean r100) {
        this.isDraggable = r100;
        return this;
    }

    public MarkerOptions icon(BitmapDescriptor r100) {
    L10:
        th = move-exception;
        th.printStackTrace();
    L12:
        return this;
    L3:
        if (this.bitmapDescriptors == null) goto L15;
    L8:
        this.bitmapDescriptors.clear();     // Catch: Throwable -> L10
        this.bitmapDescriptors.add(r100);     // Catch: Throwable -> L10
        this.isRotatingMode = false;     // Catch: Throwable -> L10
        this.updateFlags.bitmapDescriptorsUpdate = true;     // Catch: Throwable -> L10
        goto L12
    L15:
        this.bitmapDescriptors = new ArrayList();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L10
        goto L8
    }

    public MarkerOptions icons(ArrayList<BitmapDescriptor> r100) {
        if (r100 != null) goto L4;
    L6:
        return this;
    L4:
        if (r100.size() <= 0) goto L6;
        this.bitmapDescriptors = r100;
        this.isRotatingMode = false;
        this.updateFlags.bitmapDescriptorsUpdate = true;
        goto L6
    }

    public MarkerOptions infoWindowEnable(boolean r100) {
        this.infoWindowEnabled = r100;
        return this;
    }

    public MarkerOptions isOpenCollisionDetection(boolean r100) {
        this.isOpenCollisionDetection = r100;
        return this;
    }

    public MarkerOptions period(int r100) {
        if (r100 > 1) goto L5;
        this.period = 1;
    L6:
        return this;
    L5:
        this.period = r100;
        goto L6
    }

    public MarkerOptions perspective(boolean r100) {
        this.perspective = r100;
        return this;
    }

    public MarkerOptions position(LatLng r100) {
        this.latLng = r100;
        this.isViewMode = false;
        a();
        this.updateFlags.latlngUpdate = true;
        return this;
    }

    public MarkerOptions rotateAngle(float r100) {
        this.rotate = r100;
        return this;
    }

    public MarkerOptions setFlat(boolean r100) {
        this.isFlat = r100;
        return this;
    }

    public MarkerOptions setGps(boolean r100) {
        this.isGps = r100;
        a();
        return this;
    }

    public MarkerOptions setRotatingMode(boolean r100) {
        this.isRotatingMode = r100;
        return this;
    }

    public MarkerOptions snippet(String r100) {
        this.snippet = r100;
        return this;
    }

    public MarkerOptions title(String r100) {
        this.title = r100;
        return this;
    }

    public MarkerOptions visible(boolean r100) {
        this.isVisible = r100;
        return this;
    }

    public MarkerOptions zIndex(float r100) {
        if (this.zIndex == r100) goto L5;
        this.updateFlags.zIndexUpdate = true;
    L5:
        this.zIndex = r100;
        return this;
    }

    public MarkerOptions icon(View r100) {
        this.iconView = r100;     // Catch: Exception -> L4
    L6:
        return this;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    public MarkerOptions anchor(float r100, float r101) {
        this.anchorU = r100;
        this.anchorV = r101;
        this.updateFlags.anchorUpdate = true;
        return this;
    }

    public MarkerOptions rotatingIcons(ArrayList<BitmapDescriptor> r100, float r101) {
        if (r100 != null) goto L4;
    L10:
        return this;
    L4:
        if (r100.size() <= 0) goto L10;
        this.bitmapDescriptors = r100;
        if (r101 == 0.0f) goto L8;
        this.angleOffset = r101;
    L9:
        this.isRotatingMode = true;
        this.updateFlags.bitmapDescriptorsUpdate = true;
        goto L10
    L8:
        this.angleOffset = 360.0f / r100.size();
        goto L9
    }

    public MarkerOptions setInfoWindowOffset(int r100, int r101) {
        this.offsetX = r100;
        this.offsetY = r101;
        return this;
    }

    public void setScreenPosition(int r100, int r101) {
        this.screenX = r100;
        this.screenY = r101;
        this.isViewMode = true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.latLng, r101);
        r100.writeString(this.title);
        r100.writeString(this.snippet);
        r100.writeFloat(this.anchorU);
        r100.writeFloat(this.anchorV);
        r100.writeInt(this.offsetX);
        r100.writeInt(this.offsetY);
        r100.writeBooleanArray(new boolean[]{this.isVisible, this.isDraggable, this.isGps, this.isFlat, this.autoOverturn, this.infoWindowEnabled, this.isBelowMaskLayer, this.isRotatingMode, this.isOpenCollisionDetection});
        r100.writeString(this.f28660a);
        r100.writeInt(this.period);
        r100.writeList(this.bitmapDescriptors);
        r100.writeFloat(this.zIndex);
        r100.writeFloat(this.alpha);
        r100.writeInt(this.dispLevel);
        r100.writeFloat(this.rotate);
        r100.writeFloat(this.angleOffset);
        r100.writeInt(this.screenX);
        r100.writeInt(this.screenY);
        r100.writeFloat(this.altitude);
        List<BitmapDescriptor> r102 = this.bitmapDescriptors;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.size() == 0) goto L9;
        r100.writeParcelable((Parcelable) ListProtector.get(this.bitmapDescriptors, 0), r101);
        return;
    }
}
