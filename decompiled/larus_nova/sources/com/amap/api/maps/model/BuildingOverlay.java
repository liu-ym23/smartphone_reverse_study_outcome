package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class BuildingOverlay extends BaseOverlay {
    private BuildingOverlayTotalOptions buildingOverlayTotalOptions;
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private BuildingOverlayOptions mDefaultOptions;
    private List<BuildingOverlayOptions> optionList;

    public class BuildingOverlayTotalOptions extends BaseOptions {
        public List<BuildingOverlayOptions> allOptionList;
        public boolean isVisible;
        private float zIndex;

        public BuildingOverlayTotalOptions(BuildingOverlay r100) {
            this.isVisible = true;
            this.zIndex = 0.0f;
            this.type = "BuildingOptions";
        }

        public static /* synthetic */ float a(BuildingOverlayTotalOptions r100) {
            return r100.zIndex;
        }

        public static /* synthetic */ float a(BuildingOverlayTotalOptions r100, float r101) {
            r100.zIndex = r101;
            return r101;
        }
    }

    private void updateOption() {
        IGlOverlayLayer r100 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(this.overlayName) == true) goto L10;
        if (r100 == null) goto L11;
        r100.updateOption(this.overlayName, this.buildingOverlayTotalOptions);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    L10:
        return;
    }

    public void destroy() {
        IGlOverlayLayer r100 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.removeOverlay(this.overlayName);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public float getZIndex() {
        BuildingOverlayTotalOptions r100 = this.buildingOverlayTotalOptions;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return BuildingOverlayTotalOptions.a(r100);
    }

    public boolean isVisible() {
        BuildingOverlayTotalOptions r100 = this.buildingOverlayTotalOptions;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isVisible;
    }

    public List<BuildingOverlayOptions> getCustomOptions() {
        return this.optionList;
    }

    public BuildingOverlayOptions getDefaultOptions() {
        return this.mDefaultOptions;
    }

    public String getId() {
        return this.overlayName;
    }

    private void a(boolean r100) {
        monitor-enter(this);     // Catch: Exception -> L15
        if (r100 == false) goto L6;
        this.buildingOverlayTotalOptions.allOptionList.set(0, this.mDefaultOptions);     // Catch: Throwable -> L12
    L7:
        IGlOverlayLayer r101 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L12
        if (r101 == null) goto L10;
        r101.updateOption(this.overlayName, this.buildingOverlayTotalOptions);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
    L21:
        return;
    L6:
        this.buildingOverlayTotalOptions.allOptionList.removeAll(this.optionList);     // Catch: Throwable -> L12
        this.buildingOverlayTotalOptions.allOptionList.set(0, this.mDefaultOptions);     // Catch: Throwable -> L12
        this.buildingOverlayTotalOptions.allOptionList.addAll(this.optionList);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
    }

    public void setCustomOptions(List<BuildingOverlayOptions> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() <= 0) goto L15;
        monitor-enter(this);
        this.optionList = r100;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        a(false);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void setDefaultOptions(BuildingOverlayOptions r100) {
        if (r100 == null) goto L10;
        monitor-enter(this);
        this.mDefaultOptions = r100;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        a(true);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setVisible(boolean r100) {
        BuildingOverlayTotalOptions r101 = this.buildingOverlayTotalOptions;
        if (r101 == null) goto L6;
        r101.isVisible = r100;
        updateOption();
        return;
    }

    public void setZIndex(float r100) {
        BuildingOverlayOptions r101 = this.mDefaultOptions;
        if (r101 == null) goto L5;
        r101.setZIndex(r100);
    L5:
        BuildingOverlayTotalOptions r102 = this.buildingOverlayTotalOptions;
        if (r102 == null) goto L9;
        BuildingOverlayTotalOptions.a(r102, r100);
        updateOption();
        return;
    }

    public BuildingOverlay(IGlOverlayLayer r100, String r101) {
        super(r101);
        this.buildingOverlayTotalOptions = new BuildingOverlayTotalOptions(this);
        this.glOverlayLayerRef = new WeakReference(r100);
        BuildingOverlayTotalOptions r102 = this.buildingOverlayTotalOptions;
        r102.allOptionList = new ArrayList();
        if (this.mDefaultOptions != null) goto L10;
        BuildingOverlayOptions r103 = new BuildingOverlayOptions();     // Catch: Throwable -> L7
        this.mDefaultOptions = r103;     // Catch: Throwable -> L7
        r103.setVisible(true);     // Catch: Throwable -> L7
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L7
        r104.add(new LatLng(84.9d, -179.9d));     // Catch: Throwable -> L7
        r104.add(new LatLng(84.9d, 179.9d));     // Catch: Throwable -> L7
        r104.add(new LatLng(-84.9d, 179.9d));     // Catch: Throwable -> L7
        r104.add(new LatLng(-84.9d, -179.9d));     // Catch: Throwable -> L7
        this.mDefaultOptions.setBuildingLatlngs(r104);     // Catch: Throwable -> L7
        this.mDefaultOptions.setBuildingTopColor(-65536);     // Catch: Throwable -> L7
        this.mDefaultOptions.setBuildingSideColor(FakePickerAvatarCreator.DKGRAY);     // Catch: Throwable -> L7
        this.mDefaultOptions.setVisible(true);     // Catch: Throwable -> L7
        this.mDefaultOptions.setZIndex(1.0f);     // Catch: Throwable -> L7
        this.buildingOverlayTotalOptions.allOptionList.add(this.mDefaultOptions);     // Catch: Throwable -> L7
        a(true);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    }
}
