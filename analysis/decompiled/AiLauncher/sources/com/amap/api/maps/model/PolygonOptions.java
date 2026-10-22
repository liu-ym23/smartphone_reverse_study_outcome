package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.jmsl.C1624x2;
import com.amap.api.col.jmsl.G1;
import com.amap.api.maps.model.AMapPara;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class PolygonOptions extends BaseOptions implements Parcelable, Cloneable {
    public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();

    /* renamed from: a, reason: collision with root package name */
    String f17231a;
    private double[] pointList;
    private float strokeWidth = 10.0f;
    private int strokeColor = -16777216;
    private int fillColor = -16777216;
    private float zIndex = 10.0f;
    private boolean isVisible = true;
    private boolean isPointsUpdated = false;
    private boolean isHoleOptionsUpdated = false;
    private boolean isUsePolylineStroke = true;
    private AMapPara.LineJoinType lineJoinType = AMapPara.LineJoinType.LineJoinBevel;
    private int nLineCapType = 3;
    private int nLineJoinType = 0;
    private final List<LatLng> points = new ArrayList();
    private List<BaseHoleOptions> holeOptions = new ArrayList();
    private final List<List<LatLng>> pointWithHoles = new ArrayList();

    public PolygonOptions() {
        this.type = "POLYGON";
    }

    private void a(List<LatLng> list) {
        if (this.pointWithHoles.size() == 0) {
            this.pointWithHoles.add(this.points);
        }
        this.pointWithHoles.add(list);
    }

    public PolygonOptions add(LatLng latLng) {
        try {
            this.points.add(latLng);
            this.isPointsUpdated = true;
            return this;
        } catch (Throwable th) {
            th.printStackTrace();
            return this;
        }
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        if (iterable != null) {
            try {
                Iterator<LatLng> it = iterable.iterator();
                while (it.hasNext()) {
                    this.points.add(it.next());
                }
                this.isPointsUpdated = true;
                return this;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public PolygonOptions addHoles(BaseHoleOptions... baseHoleOptionsArr) {
        if (baseHoleOptionsArr != null) {
            try {
                this.isHoleOptionsUpdated = true;
                this.holeOptions.addAll(Arrays.asList(baseHoleOptionsArr));
                for (BaseHoleOptions baseHoleOptions : baseHoleOptionsArr) {
                    if (baseHoleOptions != null) {
                        a(baseHoleOptions.getPoints());
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return this;
            }
        }
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int i10) {
        this.fillColor = i10;
        return this;
    }

    public int getFillColor() {
        return this.fillColor;
    }

    public List<BaseHoleOptions> getHoleOptions() {
        return this.holeOptions;
    }

    public List<LatLng> getPoints() {
        return this.points;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public void setHoleOptions(List<BaseHoleOptions> list) {
        try {
            this.holeOptions.clear();
            if (list != null) {
                this.holeOptions.addAll(list);
            }
            this.pointWithHoles.clear();
            for (BaseHoleOptions baseHoleOptions : list) {
                if (baseHoleOptions != null) {
                    a(baseHoleOptions.getPoints());
                }
            }
            this.isHoleOptionsUpdated = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            this.points.clear();
            this.points.addAll(list);
            this.isPointsUpdated = true;
            if (this.pointWithHoles.size() != 0) {
                this.pointWithHoles.set(0, this.points);
                this.isHoleOptionsUpdated = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public PolygonOptions strokeColor(int i10) {
        this.strokeColor = i10;
        return this;
    }

    public PolygonOptions strokeWidth(float f10) {
        this.strokeWidth = f10;
        return this;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public String toJson() {
        this.jsonMap.clear();
        addIfPresent("overlayType", this.type);
        if (this.isPointsUpdated || this.isHoleOptionsUpdated) {
            this.isPointsUpdated = false;
            this.isHoleOptionsUpdated = false;
            if (this.pointWithHoles.size() != 0) {
                addIfPresent("path", this.pointWithHoles, true);
            } else {
                addIfPresent("path", this.points, true);
            }
        }
        addIfPresent("strokeWeight", Float.valueOf(this.strokeWidth / G1.a()));
        addIfPresent("strokeColor", C1624x2.j(this.strokeColor));
        addIfPresent("strokeOpacity", Float.valueOf(C1624x2.a(this.strokeColor)));
        addIfPresent("fillColor", C1624x2.j(this.fillColor));
        addIfPresent("fillOpacity", Float.valueOf(C1624x2.a(this.fillColor)));
        addIfPresent("zIndex", Float.valueOf(this.zIndex));
        addIfPresent("visible", Boolean.valueOf(this.isVisible));
        return C1624x2.g(this.jsonMap);
    }

    public PolygonOptions visible(boolean z10) {
        this.isVisible = z10;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.points);
        parcel.writeFloat(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeInt(this.fillColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f17231a);
        parcel.writeList(this.holeOptions);
        parcel.writeList(this.pointWithHoles);
        parcel.writeInt(this.lineJoinType.getTypeValue());
        parcel.writeByte(this.isUsePolylineStroke ? (byte) 1 : (byte) 0);
    }

    public PolygonOptions zIndex(float f10) {
        this.zIndex = f10;
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public PolygonOptions m15clone() throws CloneNotSupportedException {
        try {
            super.clone();
        } catch (CloneNotSupportedException e10) {
            e10.printStackTrace();
        }
        PolygonOptions polygonOptions = new PolygonOptions();
        polygonOptions.points.addAll(this.points);
        polygonOptions.strokeWidth = this.strokeWidth;
        polygonOptions.strokeColor = this.strokeColor;
        polygonOptions.fillColor = this.fillColor;
        polygonOptions.zIndex = this.zIndex;
        polygonOptions.isVisible = this.isVisible;
        polygonOptions.holeOptions = this.holeOptions;
        polygonOptions.f17231a = this.f17231a;
        polygonOptions.isPointsUpdated = this.isPointsUpdated;
        polygonOptions.isHoleOptionsUpdated = this.isHoleOptionsUpdated;
        polygonOptions.pointList = this.pointList;
        polygonOptions.pointWithHoles.addAll(this.pointWithHoles);
        polygonOptions.isUsePolylineStroke = this.isUsePolylineStroke;
        return polygonOptions;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        if (latLngArr != null) {
            try {
                this.points.addAll(Arrays.asList(latLngArr));
                this.isPointsUpdated = true;
                return this;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public PolygonOptions addHoles(Iterable<BaseHoleOptions> iterable) {
        if (iterable == null) {
            return this;
        }
        try {
            for (BaseHoleOptions baseHoleOptions : iterable) {
                a(baseHoleOptions.getPoints());
                this.holeOptions.add(baseHoleOptions);
            }
            this.isHoleOptionsUpdated = true;
            return this;
        } catch (Throwable th) {
            th.printStackTrace();
            return this;
        }
    }
}
