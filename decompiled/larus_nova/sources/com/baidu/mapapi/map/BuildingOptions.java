package com.baidu.mapapi.map;

import com.baidu.mapapi.search.core.BuildingInfo;

/* JADX INFO: loaded from: classes39.dex */
public class BuildingOptions extends PrismOptions {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f30801i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f30802j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f30803k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private BitmapDescriptor f30804l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Prism.AnimateType f30805m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private BuildingInfo f30806n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f30807o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f30808p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f30809q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f30810r;

    @Override // com.baidu.mapapi.map.PrismOptions, com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Building r100 = new Building();
        r100.f31204c = getZIndex();
        r100.f31205d = this.f30808p;
        r100.f31318n = getCustomSideImage();
        r100.f31311g = getHeight();
        r100.f31317m = getSideFaceColor();
        r100.f31316l = getTopFaceColor();
        r100.f30798y = this.f30807o;
        r100.f30797x = this.f31328h;
        BuildingInfo r101 = this.f30806n;
        r100.f30789p = r101;
        if (r101 == null) goto L5;
        r100.f31312h = r101.getGeom();
        r100.f31313i = EncodePointType.BUILDINGINFO.ordinal();
    L5:
        r100.f30794u = this.f30802j;
        r100.f30790q = this.f30801i;
        r100.f30793t = this.f30803k;
        r100.f30795v = this.f30804l;
        r100.f30796w = this.f30805m;
        r100.f30799z = this.f30809q;
        r100.A = this.f30810r;
        return r100;
    }

    public BuildingOptions() {
        this.f30801i = 0.0f;
        this.f30802j = false;
        this.f30805m = Prism.AnimateType.AnimateNormal;
        this.f30807o = true;
        this.f30808p = true;
        this.f30809q = false;
        this.f30810r = 5.0f;
    }

    public Prism.AnimateType getBuildingFloorAnimateType() {
        return this.f30805m;
    }

    public BuildingInfo getBuildingInfo() {
        return this.f30806n;
    }

    public int getFloorColor() {
        return this.f30803k;
    }

    public float getFloorHeight() {
        return this.f30801i;
    }

    public BitmapDescriptor getFloorSideTextureImage() {
        return this.f30804l;
    }

    public float getRoundedCornerRadius() {
        return this.f30810r;
    }

    public boolean isAnimation() {
        return this.f30807o;
    }

    public boolean isRoundedCorner() {
        return this.f30809q;
    }

    public BuildingOptions setAnimation(boolean r100) {
        this.f30807o = r100;
        return this;
    }

    public BuildingOptions setBuildingFloorAnimateType(Prism.AnimateType r100) {
        this.f30805m = r100;
        return this;
    }

    public BuildingOptions setBuildingInfo(BuildingInfo r100) {
        this.f30806n = r100;
        return this;
    }

    public BuildingOptions setFloorColor(int r100) {
        this.f30802j = true;
        this.f30803k = r100;
        return this;
    }

    public BuildingOptions setFloorHeight(float r100) {
        BuildingInfo r101 = this.f30806n;
        if (r101 != null) goto L6;
        return this;
    L6:
        if (r100 >= 0.0f) goto L10;
        this.f30801i = 0.0f;
        return this;
    L10:
        if (r100 <= r101.getHeight()) goto L13;
        this.f30801i = this.f30806n.getHeight();
        return this;
    L13:
        this.f30801i = r100;
        return this;
    }

    public BuildingOptions setFloorSideTextureImage(BitmapDescriptor r100) {
        this.f30802j = true;
        this.f30804l = r100;
        return this;
    }

    public BuildingOptions setRoundedCornerEnable(boolean r100) {
        this.f30809q = r100;
        return this;
    }

    public BuildingOptions setRoundedCornerRadius(float r100) {
        if (r100 > 0.0f) goto L5;
        r100 = 0.0f;
    L5:
        this.f30810r = r100;
        return this;
    }
}
