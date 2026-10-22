package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore.util.t6;
import com.amap.api.mapcore.util.w3;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class PolygonOptions extends BaseOptions implements Parcelable, Cloneable {
    public static final PolygonOptionsCreator CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f28662a;
    private int dottedLineType;
    private int fillColor;
    private List<BaseHoleOptions> holeOptions;
    private boolean isUsePolylineStroke;
    private boolean isVisible;
    private AMapPara.LineJoinType lineJoinType;
    private int nLineCapType;
    private int nLineJoinType;
    private final List<LatLng> points;
    private int strokeColor;
    private float strokeWidth;
    private PolygonUpdateFlags updateFlags;
    private float zIndex;

    public static class PolygonUpdateFlags extends BaseOptions.BaseUpdateFlags {
        protected boolean isHoleOptionsUpdated;
        protected boolean isPointsUpdated;

        public PolygonUpdateFlags() {
            this.isPointsUpdated = false;
            this.isHoleOptionsUpdated = false;
        }

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.isPointsUpdated = false;
            this.isHoleOptionsUpdated = false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new PolygonOptionsCreator();
    }

    private void a() {
        if (this.holeOptions == null) goto L62;
        ArrayList r100 = new ArrayList();
        List<BaseHoleOptions> r101 = this.holeOptions;
        int r102 = 0;
    L5:
        boolean r103 = true;
        if (r102 >= r101.size()) goto L45;
        BaseHoleOptions r104 = (BaseHoleOptions) ListProtector.get(r101, r102);
        if ((r104 instanceof PolygonHoleOptions) == false) goto L15;
        PolygonHoleOptions r105 = (PolygonHoleOptions) r104;
        if (w3.a(getPoints(), r105) == false) goto L44;
        if (w3.b(r100, r105) == true) goto L44;
        r100.add(r105);
    L44:
        r102 = r102 + 1;
        goto L5
    L15:
        if ((r104 instanceof CircleHoleOptions) == false) goto L44;
        CircleHoleOptions r106 = (CircleHoleOptions) r104;
        List<LatLng> r107 = getPoints();
        if (w3.b(r107, r106) == true) goto L39;
        LatLng r108 = r106.getCenter();     // Catch: Throwable -> L37
        if (r108 != null) goto L49;
    L34:
        boolean r109 = false;
    L35:
        if (r109 == false) goto L39;
    L40:
        if (r103 == false) goto L44;
        if (w3.a(r100, r106) == true) goto L44;
        r100.add(r106);
        goto L44
    L49:
        if (r100.size() <= 0) goto L30;
        Iterator r110 = r100.iterator();     // Catch: Throwable -> L32
    L26:
        if (r110.hasNext() == false) goto L30;
        if (w3.a((BaseHoleOptions) r110.next(), r108) == false) goto L26;
    L30:
        r109 = w3.a(r108, r107);     // Catch: Throwable -> L32
        goto L35
    L32:
        th = move-exception;
        t6.a(th, "PolygonDelegateImp", "contains");     // Catch: Throwable -> L37
        th.printStackTrace();     // Catch: Throwable -> L37
    L39:
        r103 = false;
    L37:
        th = move-exception;
        t6.a(th, "PolygonDelegateImp", "isCircleInPolygon");
        th.printStackTrace();
        goto L39
    L45:
        this.holeOptions.clear();
        this.holeOptions.addAll(r100);
        this.updateFlags.isHoleOptionsUpdated = true;
        return;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public PolygonOptions() {
        this.strokeWidth = 10.0f;
        this.strokeColor = -16777216;
        this.fillColor = -16777216;
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.isUsePolylineStroke = true;
        this.lineJoinType = AMapPara.LineJoinType.LineJoinBevel;
        this.nLineCapType = 3;
        this.nLineJoinType = 0;
        this.dottedLineType = -1;
        this.updateFlags = new PolygonUpdateFlags();
        this.points = new ArrayList();
        this.holeOptions = new ArrayList();
        this.type = "PolygonOptions";
    }

    public PolygonOptions clone() {
        super.clone();     // Catch: CloneNotSupportedException -> L4
    L6:
        PolygonOptions r100 = new PolygonOptions();
        r100.points.addAll(this.points);
        r100.strokeWidth = this.strokeWidth;
        r100.strokeColor = this.strokeColor;
        r100.fillColor = this.fillColor;
        r100.zIndex = this.zIndex;
        r100.isVisible = this.isVisible;
        r100.holeOptions = this.holeOptions;
        r100.f28662a = this.f28662a;
        r100.isUsePolylineStroke = this.isUsePolylineStroke;
        r100.lineJoinType = this.lineJoinType;
        r100.nLineCapType = this.nLineCapType;
        r100.nLineJoinType = this.nLineJoinType;
        r100.dottedLineType = this.dottedLineType;
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

    public int getFillColor() {
        return this.fillColor;
    }

    public List<BaseHoleOptions> getHoleOptions() {
        return this.holeOptions;
    }

    public AMapPara.LineJoinType getLineJoinType() {
        return this.lineJoinType;
    }

    public List<LatLng> getPoints() {
        return this.points;
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
    public /* bridge */ /* synthetic */ Object m8030clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public PolygonUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public PolygonOptions add(LatLng... r100) {
        if (r100 != null) goto L8;
    L7:
        return this;
    L8:
        this.points.addAll(Arrays.asList(r100));     // Catch: Throwable -> L5
        this.updateFlags.isPointsUpdated = true;     // Catch: Throwable -> L5
        a();     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public PolygonOptions addAll(Iterable<LatLng> r100) {
        if (r100 != null) goto L12;
    L11:
        return this;
    L12:
        Iterator<LatLng> r101 = r100.iterator();     // Catch: Throwable -> L9
    L5:
        if (r101.hasNext() == false) goto L7;
        LatLng r102 = r101.next();     // Catch: Throwable -> L9
        this.points.add(r102);     // Catch: Throwable -> L9
        goto L5
    L7:
        a();     // Catch: Throwable -> L9
        this.updateFlags.isPointsUpdated = true;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    public PolygonOptions addHoles(Iterable<BaseHoleOptions> r100) {
        if (r100 != null) goto L13;
        return this;
    L13:
        Iterator<BaseHoleOptions> r101 = r100.iterator();     // Catch: Throwable -> L10
    L6:
        if (r101.hasNext() == false) goto L8;
        BaseHoleOptions r102 = r101.next();     // Catch: Throwable -> L10
        this.holeOptions.add(r102);     // Catch: Throwable -> L10
        goto L6
    L8:
        a();     // Catch: Throwable -> L10
    L12:
        return this;
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L12
    }

    public PolygonOptions fillColor(int r100) {
        this.fillColor = r100;
        return this;
    }

    public PolygonOptions lineJoinType(AMapPara.LineJoinType r100) {
        if (r100 == null) goto L4;
        this.lineJoinType = r100;
        this.nLineJoinType = r100.getTypeValue();
    L4:
        return this;
    }

    public void setHoleOptions(List<BaseHoleOptions> r100) {
        this.holeOptions.clear();     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        this.holeOptions.addAll(r100);     // Catch: Throwable -> L7
    L5:
        a();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public void setPoints(List<LatLng> r100) {
        this.points.clear();     // Catch: Throwable -> L7
        if (r100 != null) goto L5;
        return;
    L5:
        this.points.addAll(r100);     // Catch: Throwable -> L7
        a();     // Catch: Throwable -> L7
        this.updateFlags.isPointsUpdated = true;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public PolygonOptions setStrokeDottedLineType(int r100) {
        this.dottedLineType = r100;
        return this;
    }

    public PolygonOptions strokeColor(int r100) {
        this.strokeColor = r100;
        return this;
    }

    public PolygonOptions strokeWidth(float r100) {
        this.strokeWidth = r100;
        return this;
    }

    public PolygonOptions usePolylineStroke(boolean r100) {
        this.isUsePolylineStroke = r100;
        return this;
    }

    public PolygonOptions visible(boolean r100) {
        this.isVisible = r100;
        return this;
    }

    public PolygonOptions zIndex(float r100) {
        float r101 = this.zIndex;
        if (r101 == r101) goto L5;
        this.updateFlags.zIndexUpdate = true;
    L5:
        this.zIndex = r100;
        return this;
    }

    public PolygonOptions add(LatLng r100) {
        this.points.add(r100);     // Catch: Throwable -> L4
        this.updateFlags.isPointsUpdated = true;     // Catch: Throwable -> L4
        a();     // Catch: Throwable -> L4
    L6:
        return this;
    L4:
        th = move-exception;
        th.printStackTrace();
        goto L6
    }

    public PolygonOptions addHoles(BaseHoleOptions... r100) {
        if (r100 != null) goto L9;
        return this;
    L9:
        this.holeOptions.addAll(Arrays.asList(r100));     // Catch: Throwable -> L6
        a();     // Catch: Throwable -> L6
    L8:
        return this;
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L8
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeTypedList(this.points);
        r100.writeFloat(this.strokeWidth);
        r100.writeInt(this.strokeColor);
        r100.writeInt(this.fillColor);
        r100.writeFloat(this.zIndex);
        r100.writeByte(this.isVisible ? 1 : 0);
        r100.writeString(this.f28662a);
        r100.writeList(this.holeOptions);
        r100.writeInt(this.lineJoinType.getTypeValue());
        r100.writeInt(this.dottedLineType);
        r100.writeByte(this.isUsePolylineStroke ? 1 : 0);
    }
}
