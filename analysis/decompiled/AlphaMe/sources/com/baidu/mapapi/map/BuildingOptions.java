package com.baidu.mapapi.map;

import com.baidu.mapapi.map.Prism;
import com.baidu.mapapi.search.core.BuildingInfo;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public class BuildingOptions extends PrismOptions {

    /* renamed from: k, reason: collision with root package name */
    private int f6279k;

    /* renamed from: l, reason: collision with root package name */
    private BitmapDescriptor f6280l;

    /* renamed from: n, reason: collision with root package name */
    private BuildingInfo f6282n;

    /* renamed from: i, reason: collision with root package name */
    private float f6277i = Property.DEFAULT_FLOAT_VALUE;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6278j = false;

    /* renamed from: m, reason: collision with root package name */
    private Prism.AnimateType f6281m = Prism.AnimateType.AnimateNormal;

    /* renamed from: o, reason: collision with root package name */
    private boolean f6283o = true;

    /* renamed from: p, reason: collision with root package name */
    boolean f6284p = true;

    /* renamed from: q, reason: collision with root package name */
    private boolean f6285q = false;

    /* renamed from: r, reason: collision with root package name */
    private float f6286r = 5.0f;

    public Prism.AnimateType getBuildingFloorAnimateType() {
        return this.f6281m;
    }

    public BuildingInfo getBuildingInfo() {
        return this.f6282n;
    }

    public int getFloorColor() {
        return this.f6279k;
    }

    public float getFloorHeight() {
        return this.f6277i;
    }

    public BitmapDescriptor getFloorSideTextureImage() {
        return this.f6280l;
    }

    @Override // com.baidu.mapapi.map.PrismOptions, com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Building building = new Building();
        building.f6720c = getZIndex();
        building.f6721d = this.f6284p;
        building.f6864n = getCustomSideImage();
        building.f6857g = getHeight();
        building.f6863m = getSideFaceColor();
        building.f6862l = getTopFaceColor();
        building.f6274y = this.f6283o;
        building.f6273x = this.f6874h;
        BuildingInfo buildingInfo = this.f6282n;
        building.f6265p = buildingInfo;
        if (buildingInfo != null) {
            building.f6858h = buildingInfo.getGeom();
            building.f6859i = EncodePointType.BUILDINGINFO.ordinal();
        }
        building.f6270u = this.f6278j;
        building.f6266q = this.f6277i;
        building.f6269t = this.f6279k;
        building.f6271v = this.f6280l;
        building.f6272w = this.f6281m;
        building.f6275z = this.f6285q;
        building.f6264A = this.f6286r;
        return building;
    }

    public float getRoundedCornerRadius() {
        return this.f6286r;
    }

    public boolean isAnimation() {
        return this.f6283o;
    }

    public boolean isRoundedCorner() {
        return this.f6285q;
    }

    public BuildingOptions setAnimation(boolean z4) {
        this.f6283o = z4;
        return this;
    }

    public BuildingOptions setBuildingFloorAnimateType(Prism.AnimateType animateType) {
        this.f6281m = animateType;
        return this;
    }

    public BuildingOptions setBuildingInfo(BuildingInfo buildingInfo) {
        this.f6282n = buildingInfo;
        return this;
    }

    public BuildingOptions setFloorColor(int i4) {
        this.f6278j = true;
        this.f6279k = i4;
        return this;
    }

    public BuildingOptions setFloorHeight(float f4) {
        BuildingInfo buildingInfo = this.f6282n;
        if (buildingInfo == null) {
            return this;
        }
        if (f4 < Property.DEFAULT_FLOAT_VALUE) {
            this.f6277i = Property.DEFAULT_FLOAT_VALUE;
            return this;
        }
        if (f4 > buildingInfo.getHeight()) {
            this.f6277i = this.f6282n.getHeight();
            return this;
        }
        this.f6277i = f4;
        return this;
    }

    public BuildingOptions setFloorSideTextureImage(BitmapDescriptor bitmapDescriptor) {
        this.f6278j = true;
        this.f6280l = bitmapDescriptor;
        return this;
    }

    public BuildingOptions setRoundedCornerEnable(boolean z4) {
        this.f6285q = z4;
        return this;
    }

    public BuildingOptions setRoundedCornerRadius(float f4) {
        if (f4 <= Property.DEFAULT_FLOAT_VALUE) {
            f4 = 0.0f;
        }
        this.f6286r = f4;
        return this;
    }
}
