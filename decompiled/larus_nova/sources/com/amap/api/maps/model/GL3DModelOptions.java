package com.amap.api.maps.model;

import android.util.Pair;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class GL3DModelOptions extends BaseOptions {
    private double altitude;
    private BitmapDescriptor bitmapDescriptor;
    private boolean fixedDisplaySizeEnabled;
    private double fixedDisplaySizeX;
    private double fixedDisplaySizeY;
    private int fixedLength;
    private boolean isModeltUpdate;
    private LatLng latLng;
    private String modelData;
    private float rotate;
    private String snippet;
    private List<Float> textrueList;
    private String title;
    private List<Float> vertextList;
    private boolean visibile;
    private int zIndex;

    public Pair<Double, Double> getFixDisplaySize() {
        return Pair.create(Double.valueOf(this.fixedDisplaySizeX), Double.valueOf(this.fixedDisplaySizeY));
    }

    public GL3DModelOptions() {
        this.vertextList = new ArrayList();
        this.textrueList = new ArrayList();
        this.isModeltUpdate = false;
        this.fixedLength = 50;
        this.altitude = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.fixedDisplaySizeEnabled = true;
        this.fixedDisplaySizeX = -1.0d;
        this.fixedDisplaySizeY = -1.0d;
        this.visibile = true;
        this.zIndex = 0;
        this.type = "GL3DModelOptions";
    }

    public double getAltitude() {
        return this.altitude;
    }

    public float getAngle() {
        return this.rotate;
    }

    public BitmapDescriptor getBitmapDescriptor() {
        return this.bitmapDescriptor;
    }

    public LatLng getLatLng() {
        return this.latLng;
    }

    public int getModelFixedLength() {
        return this.fixedLength;
    }

    public String getSnippet() {
        return this.snippet;
    }

    public List<Float> getTextrue() {
        return this.textrueList;
    }

    public String getTitle() {
        return this.title;
    }

    public List<Float> getVertext() {
        return this.vertextList;
    }

    public int getZIndex() {
        return this.zIndex;
    }

    public boolean isFixedDisplaySizeEnabled() {
        return this.fixedDisplaySizeEnabled;
    }

    public boolean isVisible() {
        return this.visibile;
    }

    public GL3DModelOptions angle(float r100) {
        this.rotate = r100;
        return this;
    }

    public GL3DModelOptions position(LatLng r100) {
        this.latLng = r100;
        return this;
    }

    public GL3DModelOptions setAltitude(double r100) {
        this.altitude = r100;
        return this;
    }

    public GL3DModelOptions setFixedDisplaySizeEnabled(boolean r100) {
        this.fixedDisplaySizeEnabled = r100;
        return this;
    }

    public GL3DModelOptions setModelFixedLength(int r100) {
        this.fixedLength = r100;
        return this;
    }

    public GL3DModelOptions setVisible(boolean r100) {
        this.visibile = r100;
        return this;
    }

    public GL3DModelOptions setzIndex(int r100) {
        this.zIndex = r100;
        return this;
    }

    public GL3DModelOptions snippet(String r100) {
        this.snippet = r100;
        return this;
    }

    public GL3DModelOptions textureDrawable(BitmapDescriptor r100) {
        this.bitmapDescriptor = r100;
        return this;
    }

    public GL3DModelOptions title(String r100) {
        this.title = r100;
        return this;
    }

    public GL3DModelOptions vertexData(String r100) {
        if (r100 != null) goto L4;
    L6:
        return this;
    L4:
        if (r100.length() <= 0) goto L6;
        this.modelData = r100;
        this.isModeltUpdate = true;
        goto L6
    }

    public GL3DModelOptions setFixDisplaySize(double r100, double r101) {
        this.fixedDisplaySizeX = r100;
        this.fixedDisplaySizeY = r101;
        return this;
    }

    public GL3DModelOptions vertexData(List<Float> r100, List<Float> r101) {
        this.vertextList = r100;
        this.textrueList = r101;
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
        if (this.vertextList == null) goto L9;
        int r104 = 0;
    L6:
        if (r104 >= (this.vertextList.size() - 3)) goto L9;
        r102.append("v ");
        r102.append(ListProtector.get(this.vertextList, r104));
        r102.append(" ");
        r102.append(ListProtector.get(this.vertextList, r104 + 1));
        r102.append(" ");
        r102.append(ListProtector.get(this.vertextList, r104 + 2));
        r102.append("\n");
        r104 = r104 + 3;
    L9:
        if (this.textrueList != null) goto L11;
    L13:
        vertexData(r102.toString());
        return this;
    L11:
        if (r103 >= (this.textrueList.size() - 2)) goto L13;
        r102.append("vt ");
        r102.append(ListProtector.get(this.textrueList, r103));
        r102.append(" ");
        r102.append(1.0f - ((Float) ListProtector.get(this.textrueList, r103 + 1)).floatValue());
        r102.append("\n");
        r103 = r103 + 2;
        goto L11
    }
}
