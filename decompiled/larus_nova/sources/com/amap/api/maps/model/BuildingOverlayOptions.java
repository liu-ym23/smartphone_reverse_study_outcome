package com.amap.api.maps.model;

import android.graphics.Point;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class BuildingOverlayOptions extends BaseOptions {
    private int buildingHeight;
    private int buildingHeightScale;
    private List<LatLng> buildingLatlngs;
    private int[] buildingLatlngsPoints;
    private int buildingSideColor;
    private int buildingTopColor;
    private boolean isVisible;
    private float zindex;

    public synchronized int[] getPoints() {
        monitor-enter(this);
        List<LatLng> r100 = this.buildingLatlngs;     // Catch: Throwable -> L20
        int r101 = 0;
        if (r100 != null) goto L6;
    L17:
        int[] r102 = new int[0];     // Catch: Throwable -> L20
        monitor-exit(this);
        return r102;
    L6:
        if (r100.size() <= 0) goto L17;
        int[] r103 = new int[this.buildingLatlngs.size() * 2];     // Catch: Throwable -> L20
        int r104 = 0;
    L9:
        if (r101 >= this.buildingLatlngs.size()) goto L15;
        LatLng r105 = (LatLng) ListProtector.get(this.buildingLatlngs, r101);     // Catch: Throwable -> L20
        if (r105 == null) goto L14;
        Point r106 = VirtualEarthProjection.latLongToPixels(r105.latitude, r105.longitude, 20);     // Catch: Throwable -> L20
        int r107 = r104 + 1;     // Catch: Throwable -> L20
        r103[r104] = r106.x;     // Catch: Throwable -> L20
        r104 = r107 + 1;     // Catch: Throwable -> L20
        r103[r107] = r106.y;     // Catch: Throwable -> L20
    L14:
        r101 = r101 + 1;
        goto L9
    L15:
        monitor-exit(this);
        return r103;
    L20:
        th = move-exception;
        throw th;
    }

    public BuildingOverlayOptions() {
        this.buildingHeight = -1;
        this.buildingHeightScale = 1;
        this.buildingTopColor = FakePickerAvatarCreator.GRAY;
        this.buildingSideColor = FakePickerAvatarCreator.GRAY;
        this.isVisible = true;
        this.buildingLatlngs = new ArrayList();
    }

    public int getBuildingHeight() {
        return this.buildingHeight;
    }

    public int getBuildingHeightScale() {
        return this.buildingHeightScale;
    }

    public List<LatLng> getBuildingLatlngs() {
        return this.buildingLatlngs;
    }

    public int getBuildingSideColor() {
        return this.buildingSideColor;
    }

    public int getBuildingTopColor() {
        return this.buildingTopColor;
    }

    public float getZIndex() {
        return this.zindex;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public BuildingOverlayOptions setBuildingHeight(int r100) {
        this.buildingHeight = r100;
        return this;
    }

    public BuildingOverlayOptions setBuildingHeightScale(int r100) {
        this.buildingHeightScale = r100;
        return this;
    }

    public synchronized BuildingOverlayOptions setBuildingLatlngs(List<LatLng> r100) {
        monitor-enter(this);
        this.buildingLatlngs = r100;     // Catch: Throwable -> L14
        if (r100 != null) goto L6;
    L12:
        monitor-exit(this);
        return this;
    L6:
        if (r100.size() <= 0) goto L12;
        this.buildingLatlngsPoints = new int[r100.size() * 2];     // Catch: Throwable -> L14
        int r101 = 0;
        int r102 = 0;
    L9:
        if (r101 >= r100.size()) goto L12;
        LatLng r103 = (LatLng) ListProtector.get(r100, r101);     // Catch: Throwable -> L14
        Point r104 = VirtualEarthProjection.latLongToPixels(r103.latitude, r103.longitude, 20);     // Catch: Throwable -> L14
        int[] r105 = this.buildingLatlngsPoints;     // Catch: Throwable -> L14
        int r106 = r102 + 1;     // Catch: Throwable -> L14
        r105[r102] = r104.x;     // Catch: Throwable -> L14
        r102 = r106 + 1;     // Catch: Throwable -> L14
        r105[r106] = r104.y;     // Catch: Throwable -> L14
        r101 = r101 + 1;
    L14:
        th = move-exception;
        throw th;
    }

    public BuildingOverlayOptions setBuildingSideColor(int r100) {
        this.buildingSideColor = r100;
        return this;
    }

    public BuildingOverlayOptions setBuildingTopColor(int r100) {
        this.buildingTopColor = r100;
        return this;
    }

    public void setVisible(boolean r100) {
        this.isVisible = r100;
    }

    public void setZIndex(float r100) {
        this.zindex = r100;
    }
}
