package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.jmsl.C1589o2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class PolylineOptions extends BaseOptions implements Parcelable, Cloneable {
    public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();
    public static final int DOTTEDLINE_TYPE_SQUARE = 0;

    /* renamed from: a, reason: collision with root package name */
    String f17232a;
    private List<Integer> colorValues;
    private List<Integer> customIndexs;
    private BitmapDescriptor customTexture;
    private List<BitmapDescriptor> customTextureList;
    private float width = 10.0f;
    private int color = -16777216;
    private float zIndex = 50.0f;
    private boolean isVisible = true;
    private boolean isColorValuesUpdate = false;
    private boolean isUseTexture = true;
    private boolean isGeodesic = false;
    private boolean isDottedLine = false;
    private boolean isGradient = false;
    private float transparency = 1.0f;
    private boolean isAboveMaskLayer = false;
    private int dottedLineType = 0;
    private LineCapType lineCapType = LineCapType.LineCapRound;
    private LineJoinType lineJoinType = LineJoinType.LineJoinBevel;
    private int nLineCapType = 3;
    private int nLineJoinType = 0;
    private float shownRatio = -1.0f;
    private boolean isPointsUpdated = false;

    /* renamed from: b, reason: collision with root package name */
    List<Integer> f17233b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    List<Integer> f17234c = new ArrayList();
    private C1589o2 lineGradient = null;
    private final List<LatLng> points = new ArrayList();

    public enum LineCapType {
        LineCapButt(0),
        LineCapSquare(1),
        LineCapRound(3);

        private int type;

        LineCapType(int i10) {
            this.type = i10;
        }

        public int getTypeValue() {
            return this.type;
        }

        public static LineCapType valueOf(int i10) {
            return values()[Math.max(0, Math.min(i10, 3))];
        }
    }

    public enum LineJoinType {
        LineJoinBevel(0),
        LineJoinMiter(1),
        LineJoinRound(2);

        private int type;

        LineJoinType(int i10) {
            this.type = i10;
        }

        public int getTypeValue() {
            return this.type;
        }

        public static LineJoinType valueOf(int i10) {
            return values()[Math.max(0, Math.min(i10, 3))];
        }
    }

    public PolylineOptions() {
        this.type = "POLYLINE";
        this.f17233b.add(10);
        this.f17233b.add(2);
        this.f17233b.add(10);
        this.f17234c.add(10);
        this.f17234c.add(10);
    }

    public PolylineOptions add(LatLng latLng) {
        if (latLng != null) {
            try {
                this.points.add(latLng);
                this.isPointsUpdated = true;
                return this;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
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

    public PolylineOptions color(int i10) {
        this.color = i10;
        return this;
    }

    public PolylineOptions colorValues(List<Integer> list) {
        try {
            this.colorValues = list;
            this.isColorValuesUpdate = true;
        } catch (Throwable unused) {
        }
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PolylineOptions geodesic(boolean z10) {
        this.isGeodesic = z10;
        return this;
    }

    public int getColor() {
        return this.color;
    }

    public List<Integer> getColorValues() {
        return this.colorValues;
    }

    public int getDottedLineType() {
        return this.dottedLineType;
    }

    public LineCapType getLineCapType() {
        return this.lineCapType;
    }

    public LineJoinType getLineJoinType() {
        return this.lineJoinType;
    }

    public List<LatLng> getPoints() {
        return this.points;
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

    public boolean isDottedLine() {
        return this.isDottedLine;
    }

    public boolean isGeodesic() {
        return this.isGeodesic;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public PolylineOptions lineCapType(LineCapType lineCapType) {
        if (lineCapType != null) {
            this.lineCapType = lineCapType;
            this.nLineCapType = lineCapType.getTypeValue();
        }
        return this;
    }

    public PolylineOptions lineJoinType(LineJoinType lineJoinType) {
        if (lineJoinType != null) {
            this.lineJoinType = lineJoinType;
            this.nLineJoinType = lineJoinType.getTypeValue();
        }
        return this;
    }

    public PolylineOptions setDottedLine(boolean z10) {
        this.isDottedLine = z10;
        return this;
    }

    public PolylineOptions setDottedLineType(int i10) {
        this.dottedLineType = i10 == 0 ? 0 : 1;
        return this;
    }

    public void setPoints(List<LatLng> list) {
        List<LatLng> list2;
        if (list == null || (list2 = this.points) == list) {
            return;
        }
        try {
            list2.clear();
            this.points.addAll(list);
            this.isPointsUpdated = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0087  */
    @Override // com.amap.api.maps.model.BaseOptions
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toJson() {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.model.PolylineOptions.toJson():java.lang.String");
    }

    public PolylineOptions transparency(float f10) {
        this.transparency = f10;
        return this;
    }

    public PolylineOptions visible(boolean z10) {
        this.isVisible = z10;
        return this;
    }

    public PolylineOptions width(float f10) {
        this.width = f10;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.points);
        parcel.writeFloat(this.width);
        parcel.writeInt(this.color);
        parcel.writeInt(this.dottedLineType);
        parcel.writeFloat(this.zIndex);
        parcel.writeFloat(this.transparency);
        parcel.writeString(this.f17232a);
        parcel.writeInt(this.lineCapType.getTypeValue());
        parcel.writeInt(this.lineJoinType.getTypeValue());
        parcel.writeBooleanArray(new boolean[]{this.isVisible, this.isDottedLine, this.isGeodesic, this.isGradient, this.isAboveMaskLayer});
        BitmapDescriptor bitmapDescriptor = this.customTexture;
        if (bitmapDescriptor != null) {
            parcel.writeParcelable(bitmapDescriptor, i10);
        }
        List<BitmapDescriptor> list = this.customTextureList;
        if (list != null) {
            parcel.writeList(list);
        }
        List<Integer> list2 = this.customIndexs;
        if (list2 != null) {
            parcel.writeList(list2);
        }
        List<Integer> list3 = this.colorValues;
        if (list3 != null) {
            parcel.writeList(list3);
        }
        parcel.writeFloat(this.shownRatio);
    }

    public PolylineOptions zIndex(float f10) {
        this.zIndex = f10;
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public PolylineOptions m16clone() throws CloneNotSupportedException {
        try {
            super.clone();
        } catch (CloneNotSupportedException e10) {
            e10.printStackTrace();
        }
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.points.addAll(this.points);
        polylineOptions.width(this.width);
        polylineOptions.color(this.color);
        polylineOptions.zIndex(this.zIndex);
        polylineOptions.visible(this.isVisible);
        polylineOptions.colorValues(this.colorValues);
        polylineOptions.geodesic(this.isGeodesic);
        polylineOptions.setDottedLine(this.isDottedLine);
        polylineOptions.transparency(this.transparency);
        polylineOptions.setDottedLineType(this.dottedLineType);
        polylineOptions.lineCapType(this.lineCapType);
        polylineOptions.lineJoinType(this.lineJoinType);
        polylineOptions.lineGradient = this.lineGradient;
        polylineOptions.isPointsUpdated = this.isPointsUpdated;
        return polylineOptions;
    }

    public PolylineOptions add(LatLng... latLngArr) {
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
}
