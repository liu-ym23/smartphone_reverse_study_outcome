package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class PolylineOptions extends BaseOptions implements Parcelable {
    public static final PolylineOptionsCreator CREATOR = null;
    public static final int DOTTEDLINE_TYPE_CIRCLE = 1;
    public static final int DOTTEDLINE_TYPE_SQUARE = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f28663a;
    private int color;
    private List<Integer> colorValues;
    private List<Integer> customIndexs;
    private BitmapDescriptor customTexture;
    private List<BitmapDescriptor> customTextureList;
    private int dottedLineType;
    private int eraseColor;
    private BitmapDescriptor eraseTexture;
    private boolean eraseVisible;
    private float footPrintGap;
    private BitmapDescriptor footPrintTexture;
    private boolean isAboveMaskLayer;
    private boolean isDottedLine;
    private boolean isGeodesic;
    private boolean isGradient;
    private boolean isUseTexture;
    private boolean isVisible;
    private int[] jniColorValues;
    private int[] jniCustomIndexes;
    private LineCapType lineCapType;
    private LineJoinType lineJoinType;
    private int nLineCapType;
    private int nLineJoinType;
    private final List<LatLng> points;
    private boolean reducePoint;
    private boolean showPolylineRangeEnable;
    private float shownPolylineRangeBegin;
    private float shownPolylineRangeEnd;
    private float shownRangeBegin;
    private float shownRangeEnd;
    private float shownRatio;
    private float transparency;
    private PolylineUpdateFlags updateFlags;
    private boolean useEngine;
    private float width;
    private float zIndex;

    public static final enum LineCapType extends Enum<LineCapType> {
        private static final /* synthetic */ LineCapType[] $VALUES = null;
        public static final LineCapType LineCapArrow = null;
        public static final LineCapType LineCapButt = null;
        public static final LineCapType LineCapRound = null;
        public static final LineCapType LineCapSquare = null;
        private int type;

        static {
            LineCapType r100 = new LineCapType("LineCapButt", 0, 0);
            LineCapButt = r100;
            LineCapType r101 = new LineCapType("LineCapSquare", 1, 1);
            LineCapSquare = r101;
            LineCapType r102 = new LineCapType("LineCapArrow", 2, 2);
            LineCapArrow = r102;
            LineCapType r103 = new LineCapType("LineCapRound", 3, 3);
            LineCapRound = r103;
            $VALUES = new LineCapType[]{r100, r101, r102, r103};
        }

        public static LineCapType[] values() {
            return (LineCapType[]) $VALUES.clone();
        }

        public int getTypeValue() {
            return this.type;
        }

        public static LineCapType valueOf(int r100) {
            return values()[Math.max(0, Math.min(r100, 4))];
        }

        public static LineCapType valueOf(String r100) {
            return (LineCapType) r27.a.a(LineCapType.class, r100);
        }

        private LineCapType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public static final enum LineJoinType extends Enum<LineJoinType> {
        private static final /* synthetic */ LineJoinType[] $VALUES = null;
        public static final LineJoinType LineJoinBevel = null;
        public static final LineJoinType LineJoinMiter = null;
        public static final LineJoinType LineJoinRound = null;
        private int type;

        static {
            LineJoinType r100 = new LineJoinType("LineJoinBevel", 0, 0);
            LineJoinBevel = r100;
            LineJoinType r101 = new LineJoinType("LineJoinMiter", 1, 1);
            LineJoinMiter = r101;
            LineJoinType r102 = new LineJoinType("LineJoinRound", 2, 2);
            LineJoinRound = r102;
            $VALUES = new LineJoinType[]{r100, r101, r102};
        }

        public static LineJoinType[] values() {
            return (LineJoinType[]) $VALUES.clone();
        }

        public int getTypeValue() {
            return this.type;
        }

        public static LineJoinType valueOf(int r100) {
            return values()[Math.max(0, Math.min(r100, 3))];
        }

        public static LineJoinType valueOf(String r100) {
            return (LineJoinType) r27.a.a(LineJoinType.class, r100);
        }

        private LineJoinType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public static class PolylineUpdateFlags extends BaseOptions.BaseUpdateFlags {
        protected boolean eraseUpdate;
        protected boolean footPrintBDUpdate;
        protected boolean isColorValuesUpdated;
        protected boolean isCustomIndexesUpdated;
        protected boolean isCustomTextureListUpdated;
        protected boolean isPointsUpdated;

        public PolylineUpdateFlags() {
            this.isPointsUpdated = false;
            this.isCustomIndexesUpdated = false;
            this.isCustomTextureListUpdated = false;
            this.isColorValuesUpdated = false;
            this.footPrintBDUpdate = false;
            this.eraseUpdate = false;
        }

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.isPointsUpdated = false;
            this.isCustomIndexesUpdated = false;
            this.isCustomTextureListUpdated = false;
            this.isColorValuesUpdated = false;
            this.footPrintBDUpdate = false;
            this.eraseUpdate = false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new PolylineOptionsCreator();
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public PolylineOptions() {
        this.width = 10.0f;
        this.color = -16777216;
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.useEngine = false;
        this.reducePoint = true;
        this.isUseTexture = true;
        this.isGeodesic = false;
        this.isDottedLine = false;
        this.isGradient = false;
        this.transparency = 1.0f;
        this.isAboveMaskLayer = false;
        this.dottedLineType = 0;
        this.lineCapType = LineCapType.LineCapRound;
        this.lineJoinType = LineJoinType.LineJoinBevel;
        this.nLineCapType = 3;
        this.nLineJoinType = 0;
        this.shownRatio = -1.0f;
        this.shownRangeBegin = -1.0f;
        this.shownRangeEnd = -1.0f;
        this.footPrintGap = 100.0f;
        this.eraseVisible = false;
        this.eraseColor = FakePickerAvatarCreator.GRAY;
        this.shownPolylineRangeBegin = 0.0f;
        this.shownPolylineRangeEnd = 0.0f;
        this.showPolylineRangeEnable = false;
        this.updateFlags = new PolylineUpdateFlags();
        this.points = new ArrayList();
        this.type = "PolylineOptions";
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public /* bridge */ /* synthetic */ BaseOptions.BaseUpdateFlags getUpdateFlags() {
        return getUpdateFlags();
    }

    public int getColor() {
        return this.color;
    }

    public List<Integer> getColorValues() {
        return this.colorValues;
    }

    public BitmapDescriptor getCustomTexture() {
        return this.customTexture;
    }

    public List<Integer> getCustomTextureIndex() {
        return this.customIndexs;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        return this.customTextureList;
    }

    public int getDottedLineType() {
        return this.dottedLineType;
    }

    public int getEraseColor() {
        return this.eraseColor;
    }

    public BitmapDescriptor getEraseTexture() {
        return this.eraseTexture;
    }

    public boolean getEraseVisible() {
        return this.eraseVisible;
    }

    public float getFootPrintGap() {
        return this.footPrintGap;
    }

    public BitmapDescriptor getFootPrintTexture() {
        return this.footPrintTexture;
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

    public float getPolylineShownRangeBegin() {
        return this.shownPolylineRangeBegin;
    }

    public float getPolylineShownRangeEnd() {
        return this.shownPolylineRangeEnd;
    }

    public boolean getReducePoint() {
        return this.reducePoint;
    }

    public float getShownRangeBegin() {
        return this.shownRangeBegin;
    }

    public float getShownRangeEnd() {
        return this.shownRangeEnd;
    }

    public float getShownRatio() {
        return this.shownRatio;
    }

    public float getTransparency() {
        return this.transparency;
    }

    public boolean getUseEngine() {
        return this.useEngine;
    }

    public float getWidth() {
        return this.width;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean isAboveMaskLayer() {
        return this.isAboveMaskLayer;
    }

    public boolean isDottedLine() {
        return this.isDottedLine;
    }

    public boolean isGeodesic() {
        return this.isGeodesic;
    }

    public boolean isShowPolylineRangeEnable() {
        return this.showPolylineRangeEnable;
    }

    public boolean isUseGradient() {
        return this.isGradient;
    }

    public boolean isUseTexture() {
        return this.isUseTexture;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public PolylineUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public PolylineOptions aboveMaskLayer(boolean r100) {
        this.isAboveMaskLayer = r100;
        return this;
    }

    public PolylineOptions add(LatLng... r100) {
        if (r100 != null) goto L8;
    L7:
        return this;
    L8:
        this.points.addAll(Arrays.asList(r100));     // Catch: Throwable -> L5
        this.updateFlags.isPointsUpdated = true;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public PolylineOptions addAll(Iterable<LatLng> r100) {
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
        this.updateFlags.isPointsUpdated = true;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    public PolylineOptions color(int r100) {
        this.color = r100;
        return this;
    }

    public PolylineOptions colorValues(List<Integer> r100) {
        this.colorValues = r100;     // Catch: Throwable -> L8
        this.jniColorValues = new int[r100.size()];     // Catch: Throwable -> L8
        int r101 = 0;
    L3:
        int[] r102 = this.jniColorValues;     // Catch: Throwable -> L8
        if (r101 >= r102.length) goto L6;
        r102[r101] = r100.get(r101).intValue();     // Catch: Throwable -> L8
        r101 = r101 + 1;     // Catch: Throwable -> L8
        goto L3
    L6:
        this.updateFlags.isColorValuesUpdated = true;     // Catch: Throwable -> L8
    L7:
        return this;
    }

    public PolylineOptions geodesic(boolean r100) {
        this.isGeodesic = r100;
        return this;
    }

    public PolylineOptions lineCapType(LineCapType r100) {
        if (r100 == null) goto L4;
        this.lineCapType = r100;
        this.nLineCapType = r100.getTypeValue();
    L4:
        return this;
    }

    public PolylineOptions lineJoinType(LineJoinType r100) {
        if (r100 == null) goto L4;
        this.lineJoinType = r100;
        this.nLineJoinType = r100.getTypeValue();
    L4:
        return this;
    }

    public PolylineOptions setCustomTexture(BitmapDescriptor r100) {
        this.customTexture = r100;
        return this;
    }

    public PolylineOptions setCustomTextureIndex(List<Integer> r100) {
        this.customIndexs = r100;     // Catch: Throwable -> L8
        this.jniCustomIndexes = new int[r100.size()];     // Catch: Throwable -> L8
        int r101 = 0;
    L3:
        int[] r102 = this.jniCustomIndexes;     // Catch: Throwable -> L8
        if (r101 >= r102.length) goto L6;
        r102[r101] = r100.get(r101).intValue();     // Catch: Throwable -> L8
        r101 = r101 + 1;     // Catch: Throwable -> L8
        goto L3
    L6:
        PolylineUpdateFlags r103 = this.updateFlags;     // Catch: Throwable -> L8
        r103.isCustomIndexesUpdated = true;     // Catch: Throwable -> L8
        r103.isCustomTextureListUpdated = true;     // Catch: Throwable -> L8
    L7:
        return this;
    }

    public PolylineOptions setCustomTextureList(List<BitmapDescriptor> r100) {
        this.customTextureList = r100;
        PolylineUpdateFlags r101 = this.updateFlags;
        r101.isCustomTextureListUpdated = true;
        r101.isCustomIndexesUpdated = true;
        return this;
    }

    public PolylineOptions setDottedLine(boolean r100) {
        this.isDottedLine = r100;
        return this;
    }

    public PolylineOptions setDottedLineType(int r100) {
        if (r100 != 0) goto L4;
        int r101 = 0;
    L5:
        this.dottedLineType = r101;
        return this;
    L4:
        r101 = 1;
        goto L5
    }

    public PolylineOptions setFootPrintGap(float r100) {
        this.footPrintGap = r100;
        return this;
    }

    public PolylineOptions setFootPrintTexture(BitmapDescriptor r100) {
        this.footPrintTexture = r100;
        this.updateFlags.footPrintBDUpdate = true;
        return this;
    }

    public void setPoints(List<LatLng> r100) {
        if (r100 == null) goto L12;
        List<LatLng> r101 = this.points;
        if (r101 == r100) goto L13;
        r101.clear();     // Catch: Throwable -> L7
        this.points.addAll(r100);     // Catch: Throwable -> L7
        this.updateFlags.isPointsUpdated = true;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        return;
    L13:
        return;
    }

    public void setReducePoint(boolean r100) {
        this.reducePoint = r100;
    }

    public PolylineOptions setShownRatio(float r100) {
        this.shownRatio = r100;
        setPolylineShowRange(0.0f, r100);
        showPolylineRangeEnabled(true);
        return this;
    }

    public void setUseEngine(boolean r100) {
        this.useEngine = r100;
    }

    public PolylineOptions setUseTexture(boolean r100) {
        this.isUseTexture = r100;
        return this;
    }

    public PolylineOptions showPolylineRangeEnabled(boolean r100) {
        this.showPolylineRangeEnable = r100;
        return this;
    }

    public PolylineOptions transparency(float r100) {
        this.transparency = r100;
        return this;
    }

    public PolylineOptions useGradient(boolean r100) {
        this.isGradient = r100;
        return this;
    }

    public PolylineOptions visible(boolean r100) {
        this.isVisible = r100;
        return this;
    }

    public PolylineOptions width(float r100) {
        this.width = r100;
        return this;
    }

    public PolylineOptions zIndex(float r100) {
        if (this.zIndex == r100) goto L5;
        this.updateFlags.zIndexUpdate = true;
    L5:
        this.zIndex = r100;
        return this;
    }

    public PolylineOptions add(LatLng r100) {
        if (r100 != null) goto L8;
    L7:
        return this;
    L8:
        this.points.add(r100);     // Catch: Throwable -> L5
        this.updateFlags.isPointsUpdated = true;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public PolylineOptions setEraseColor(boolean r100, int r101) {
        this.eraseVisible = r100;
        this.eraseColor = r101;
        this.updateFlags.eraseUpdate = true;
        return this;
    }

    public PolylineOptions setEraseTexture(boolean r100, BitmapDescriptor r101) {
        this.eraseVisible = r100;
        this.eraseTexture = r101;
        this.updateFlags.eraseUpdate = true;
        return this;
    }

    public PolylineOptions setPolylineShowRange(float r100, float r101) {
        this.shownPolylineRangeBegin = r100;
        this.shownPolylineRangeEnd = r101;
        return this;
    }

    public PolylineOptions setShownRange(float r100, float r101) {
        this.shownRangeBegin = r100;
        this.shownRangeEnd = r101;
        showPolylineRangeEnabled(true);
        setPolylineShowRange(r100, r101);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeTypedList(this.points);
        r100.writeFloat(this.width);
        r100.writeInt(this.color);
        r100.writeInt(this.dottedLineType);
        r100.writeFloat(this.zIndex);
        r100.writeFloat(this.transparency);
        r100.writeString(this.f28663a);
        r100.writeInt(this.lineCapType.getTypeValue());
        r100.writeInt(this.lineJoinType.getTypeValue());
        r100.writeBooleanArray(new boolean[]{this.isVisible, this.isDottedLine, this.isGeodesic, this.isGradient, this.isAboveMaskLayer});
        BitmapDescriptor r102 = this.customTexture;
        if (r102 == null) goto L5;
        r100.writeParcelable(r102, r101);
    L5:
        List<BitmapDescriptor> r103 = this.customTextureList;
        if (r103 == null) goto L8;
        r100.writeList(r103);
    L8:
        List<Integer> r104 = this.customIndexs;
        if (r104 == null) goto L11;
        r100.writeList(r104);
    L11:
        List<Integer> r105 = this.colorValues;
        if (r105 == null) goto L14;
        r100.writeList(r105);
    L14:
        r100.writeFloat(this.shownRatio);
    }
}
