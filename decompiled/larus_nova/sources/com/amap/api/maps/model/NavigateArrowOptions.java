package com.amap.api.maps.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class NavigateArrowOptions extends BaseOptions implements Parcelable, Cloneable {
    public static final NavigateArrowOptionsCreator CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f28661a;
    private int arrowLineInnerResId;
    private int arrowLineOuterResId;
    private int arrowLineShadowResId;
    private boolean is3DModel;
    private boolean isVisible;
    private final List<LatLng> points;
    private int sideColor;
    private int topColor;
    private float width;
    private float zIndex;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new NavigateArrowOptionsCreator();
    }

    public NavigateArrowOptions() {
        this.width = 10.0f;
        this.topColor = Color.argb(221, 87, VideoRef.VALUE_VIDEO_REF_AI_BARRAGE_URL, 204);
        this.sideColor = Color.argb(170, 0, 172, 146);
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.is3DModel = false;
        this.arrowLineInnerResId = 111;
        this.arrowLineOuterResId = 222;
        this.arrowLineShadowResId = 333;
        this.points = new ArrayList();
        this.type = "NavigateArrowOptions";
    }

    public NavigateArrowOptions clone() {
        super.clone();     // Catch: CloneNotSupportedException -> L4
    L6:
        NavigateArrowOptions r100 = new NavigateArrowOptions();
        r100.points.addAll(this.points);
        r100.width = this.width;
        r100.topColor = this.topColor;
        r100.sideColor = this.sideColor;
        r100.zIndex = this.zIndex;
        r100.isVisible = this.isVisible;
        r100.is3DModel = this.is3DModel;
        r100.f28661a = this.f28661a;
        r100.arrowLineInnerResId = this.arrowLineInnerResId;
        r100.arrowLineOuterResId = this.arrowLineOuterResId;
        r100.arrowLineShadowResId = this.arrowLineShadowResId;
        return r100;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    public List<LatLng> getPoints() {
        return this.points;
    }

    public int getSideColor() {
        return this.sideColor;
    }

    public int getTopColor() {
        return this.topColor;
    }

    public float getWidth() {
        return this.width;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean is3DModel() {
        return this.is3DModel;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8029clone() throws CloneNotSupportedException {
        return clone();
    }

    public NavigateArrowOptions add(LatLng... r100) {
        this.points.addAll(Arrays.asList(r100));
        return this;
    }

    public NavigateArrowOptions addAll(Iterable<LatLng> r100) {
        Iterator<LatLng> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        LatLng r102 = r101.next();
        this.points.add(r102);
        goto L4
    L6:
        return this;
    }

    public NavigateArrowOptions set3DModel(boolean r100) {
        this.is3DModel = r100;
        return this;
    }

    public void setPoints(List<LatLng> r100) {
        if (r100 == null) goto L12;
        List<LatLng> r101 = this.points;
        if (r101 == r100) goto L13;
        r101.clear();     // Catch: Throwable -> L7
        this.points.addAll(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        return;
    L13:
        return;
    }

    public NavigateArrowOptions sideColor(int r100) {
        this.sideColor = r100;
        return this;
    }

    public NavigateArrowOptions topColor(int r100) {
        this.topColor = r100;
        return this;
    }

    public NavigateArrowOptions visible(boolean r100) {
        this.isVisible = r100;
        return this;
    }

    public NavigateArrowOptions width(float r100) {
        this.width = r100;
        return this;
    }

    public NavigateArrowOptions zIndex(float r100) {
        this.zIndex = r100;
        return this;
    }

    public NavigateArrowOptions add(LatLng r100) {
        this.points.add(r100);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeTypedList(this.points);
        r100.writeFloat(this.width);
        r100.writeInt(this.topColor);
        r100.writeInt(this.sideColor);
        r100.writeFloat(this.zIndex);
        r100.writeByte(this.isVisible ? 1 : 0);
        r100.writeString(this.f28661a);
        r100.writeByte(this.is3DModel ? 1 : 0);
    }
}
