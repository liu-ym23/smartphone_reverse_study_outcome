package com.amap.api.maps.model;

import android.graphics.Color;
import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes28.dex */
public class HeatMapLayerOptions extends BaseOptions {
    public static final Gradient DEFAULT_GRADIENT = null;
    private static final int[] DEFAULT_GRADIENT_COLORS = null;
    private static final float[] DEFAULT_GRADIENT_START_POINTS = null;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    public static final int TYPE_GRID = 1;
    public static final int TYPE_HEXAGON = 2;
    public static final int TYPE_NORMAL = 0;
    private boolean isPointsUpdated;
    private boolean isVisible;
    private int[] mColors;
    private Collection<WeightedLatLng> mData;
    private float mGap;
    private Gradient mGradient;
    private double mLatitude;
    private float mOpacity;
    private float mSize;
    private float[] mStartPoints;
    private int mType;
    private double maxIntensity;
    private float maxZoom;
    private float minZoom;
    private double[] pointList;
    private float zIndex;

    static {
        int[] r100 = {Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = r100;
        float[] r101 = {0.2f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = r101;
        DEFAULT_GRADIENT = new Gradient(r100, r101);
    }

    public HeatMapLayerOptions() {
        this.mGradient = DEFAULT_GRADIENT;
        this.mSize = 2000.0f;
        this.mOpacity = 1.0f;
        this.maxIntensity = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.maxZoom = 20.0f;
        this.minZoom = 3.0f;
        this.mGap = 0.0f;
        this.mType = 2;
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.isPointsUpdated = false;
        this.type = "HeatMapLayerOptions";
    }

    public Collection<WeightedLatLng> getData() {
        return this.mData;
    }

    public float getGap() {
        return this.mGap;
    }

    public Gradient getGradient() {
        return this.mGradient;
    }

    public double getMaxIntensity() {
        return this.maxIntensity;
    }

    public float getMaxZoom() {
        return this.maxZoom;
    }

    public float getMinZoom() {
        return this.minZoom;
    }

    public float getOpacity() {
        return this.mOpacity;
    }

    public float getSize() {
        return this.mSize;
    }

    public int getType() {
        return this.mType;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public HeatMapLayerOptions data(Collection<LatLng> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<LatLng> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.add(new WeightedLatLng(r102.next()));
        goto L4
    L7:
        return weightedData(r101);
    }

    public HeatMapLayerOptions gap(float r100) {
        this.mGap = r100;
        return this;
    }

    public HeatMapLayerOptions gradient(Gradient r100) {
        this.mGradient = r100;
        if (r100 == null) goto L5;
        this.mColors = r100.getColors();
        this.mStartPoints = this.mGradient.getStartPoints();
    L5:
        return this;
    }

    public HeatMapLayerOptions maxIntensity(double r100) {
        this.maxIntensity = r100;
        return this;
    }

    public HeatMapLayerOptions maxZoom(float r100) {
        this.maxZoom = r100;
        return this;
    }

    public HeatMapLayerOptions minZoom(float r100) {
        this.minZoom = r100;
        return this;
    }

    public HeatMapLayerOptions opacity(float r100) {
        this.mOpacity = Math.max(0.0f, Math.min(r100, 1.0f));
        return this;
    }

    public HeatMapLayerOptions size(float r100) {
        this.mSize = r100;
        return this;
    }

    public HeatMapLayerOptions type(int r100) {
        this.mType = r100;
        return this;
    }

    public HeatMapLayerOptions visible(boolean r100) {
        this.isVisible = r100;
        return this;
    }

    public HeatMapLayerOptions weightedData(Collection<WeightedLatLng> r110) {
        this.mData = r110;
        this.isPointsUpdated = true;
        Collection<WeightedLatLng> r111 = getData();
        if (r111 == null) goto L31;
        this.pointList = new double[r111.size() * 3];
        Iterator<WeightedLatLng> r112 = r111.iterator();
        double r100 = Double.NaN;
        double r101 = Double.NaN;
        int r102 = 0;
    L7:
        if (r112.hasNext() == false) goto L25;
        WeightedLatLng r103 = r112.next();
        if (r103 == null) goto L7;
        LatLng r104 = r103.latLng;
        if (r104 == null) goto L7;
        double[] r105 = this.pointList;
        int r106 = r102 * 3;
        double r107 = r104.latitude;
        r105[r106] = r107;
        r105[r106 + 1] = r104.longitude;
        r105[r106 + 2] = r103.intensity;
        r102 = r102 + 1;
        if (Double.isNaN(r100) == false) goto L16;
        r100 = r107;
    L16:
        if (Double.isNaN(r101) == false) goto L19;
        r101 = r107;
    L19:
        if (r107 <= r101) goto L22;
        r101 = r107;
    L22:
        if (r107 >= r100) goto L7;
        r100 = r107;
        goto L7
    L25:
        if (Double.isNaN(r100) == false) goto L27;
    L29:
        double r108 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L30:
        this.mLatitude = r108;
        goto L31
    L27:
        if (Double.isNaN(r101) == true) goto L29;
        r108 = (r100 + r101) / 2.0d;
    L31:
        return this;
    }

    public HeatMapLayerOptions zIndex(float r100) {
        this.zIndex = r100;
        return this;
    }
}
