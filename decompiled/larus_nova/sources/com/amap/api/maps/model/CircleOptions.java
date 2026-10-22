package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import com.amap.api.mapcore.util.w3;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class CircleOptions extends BaseOptions implements Parcelable, Cloneable {
    public static final CircleOptionsCreator CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f28647a;
    private int dottedLineType;
    private int fillColor;
    private List<BaseHoleOptions> holeOptions;
    private boolean isUsePolylineStroke;
    private boolean isVisible;
    private LatLng point;
    private double radius;
    private int strokeColor;
    private float strokeWidth;
    private CircleUpdateFlags updateFlags;
    private float zIndex;

    public static class CircleUpdateFlags extends BaseOptions.BaseUpdateFlags {
        protected boolean isCenterUpdated;
        protected boolean isHoleOptionsUpdated;
        protected boolean isRadiusUpdated;

        public CircleUpdateFlags() {
            this.isCenterUpdated = false;
            this.isRadiusUpdated = false;
            this.isHoleOptionsUpdated = false;
        }

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.isCenterUpdated = false;
            this.isRadiusUpdated = false;
            this.isHoleOptionsUpdated = false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new CircleOptionsCreator();
    }

    private void a() {
        if (this.holeOptions == null) goto L32;
        ArrayList r100 = new ArrayList();
        List<BaseHoleOptions> r101 = this.holeOptions;
        int r102 = 0;
    L6:
        if (r102 >= r101.size()) goto L22;
        BaseHoleOptions r103 = (BaseHoleOptions) ListProtector.get(r101, r102);
        if ((r103 instanceof PolygonHoleOptions) == false) goto L15;
        PolygonHoleOptions r104 = (PolygonHoleOptions) r103;
        if (w3.a(getRadius(), getCenter(), r100, r104) == false) goto L21;
        if (w3.b(r100, r104) == true) goto L21;
        r100.add(r104);
    L21:
        r102 = r102 + 1;
        goto L6
    L15:
        if ((r103 instanceof CircleHoleOptions) == false) goto L21;
        CircleHoleOptions r105 = (CircleHoleOptions) r103;
        if (w3.a(getRadius(), getCenter(), r105) == false) goto L21;
        if (w3.a(r100, r105) == true) goto L21;
        r100.add(r105);
        goto L21
    L22:
        this.holeOptions.clear();
        this.holeOptions.addAll(r100);
        this.updateFlags.isHoleOptionsUpdated = true;
        return;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public CircleOptions() {
        this.point = null;
        this.radius = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.strokeWidth = 10.0f;
        this.strokeColor = -16777216;
        this.fillColor = 0;
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.dottedLineType = -1;
        this.isUsePolylineStroke = true;
        this.updateFlags = new CircleUpdateFlags();
        this.holeOptions = new ArrayList();
        this.type = "CircleOptions";
    }

    public CircleOptions clone() {
        super.clone();     // Catch: CloneNotSupportedException -> L4
    L6:
        CircleOptions r100 = new CircleOptions();
        r100.f28647a = this.f28647a;
        r100.point = this.point;
        r100.radius = this.radius;
        r100.strokeWidth = this.strokeWidth;
        r100.strokeColor = this.strokeColor;
        r100.fillColor = this.fillColor;
        r100.zIndex = this.zIndex;
        r100.isVisible = this.isVisible;
        r100.holeOptions = this.holeOptions;
        r100.dottedLineType = this.dottedLineType;
        r100.isUsePolylineStroke = this.isUsePolylineStroke;
        r100.updateFlags = this.updateFlags;
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

    public LatLng getCenter() {
        return this.point;
    }

    public int getFillColor() {
        return this.fillColor;
    }

    public List<BaseHoleOptions> getHoleOptions() {
        return this.holeOptions;
    }

    public double getRadius() {
        return this.radius;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public int getStrokeDottedLineType() {
        return this.dottedLineType;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean isUsePolylineStroke() {
        return this.isUsePolylineStroke;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8023clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public CircleUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public CircleOptions addHoles(Iterable<BaseHoleOptions> r100) {
        if (r100 != null) goto L12;
    L11:
        return this;
    L12:
        Iterator<BaseHoleOptions> r101 = r100.iterator();     // Catch: Throwable -> L9
    L5:
        if (r101.hasNext() == false) goto L7;
        BaseHoleOptions r102 = r101.next();     // Catch: Throwable -> L9
        this.holeOptions.add(r102);     // Catch: Throwable -> L9
        goto L5
    L7:
        a();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    public CircleOptions center(LatLng r100) {
        this.point = r100;
        this.updateFlags.isCenterUpdated = true;
        a();
        return this;
    }

    public CircleOptions fillColor(int r100) {
        this.fillColor = r100;
        return this;
    }

    public CircleOptions radius(double r100) {
        this.radius = r100;
        this.updateFlags.isRadiusUpdated = true;
        a();
        return this;
    }

    public CircleOptions setStrokeDottedLineType(int r100) {
        this.dottedLineType = r100;
        return this;
    }

    public CircleOptions strokeColor(int r100) {
        this.strokeColor = r100;
        return this;
    }

    public CircleOptions strokeWidth(float r100) {
        this.strokeWidth = r100;
        return this;
    }

    public CircleOptions usePolylineStroke(boolean r100) {
        this.isUsePolylineStroke = r100;
        return this;
    }

    public CircleOptions visible(boolean r100) {
        this.isVisible = r100;
        return this;
    }

    public CircleOptions zIndex(float r100) {
        if (this.zIndex == r100) goto L5;
        this.updateFlags.zIndexUpdate = true;
    L5:
        this.zIndex = r100;
        return this;
    }

    public CircleOptions addHoles(BaseHoleOptions... r100) {
        if (r100 != null) goto L8;
    L7:
        return this;
    L8:
        this.holeOptions.addAll(Arrays.asList(r100));     // Catch: Throwable -> L5
        a();     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Bundle r102 = new Bundle();
        LatLng r103 = this.point;
        if (r103 == null) goto L5;
        r102.putDouble("lat", r103.latitude);
        r102.putDouble("lng", this.point.longitude);
    L5:
        r100.writeBundle(r102);
        r100.writeDouble(this.radius);
        r100.writeFloat(this.strokeWidth);
        r100.writeInt(this.strokeColor);
        r100.writeInt(this.fillColor);
        r100.writeFloat(this.zIndex);
        r100.writeByte(this.isVisible ? 1 : 0);
        r100.writeString(this.f28647a);
        r100.writeList(this.holeOptions);
        r100.writeInt(this.dottedLineType);
        r100.writeByte(this.isUsePolylineStroke ? 1 : 0);
    }
}
