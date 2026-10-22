package com.amap.api.maps.model.amap3dmodeltile;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class AMap3DModelTileOverlayOptions extends BaseOptions implements Parcelable {
    public static final Parcelable.Creator<AMap3DModelTileOverlayOptions> CREATOR = null;
    private List<AMap3DTileBuildingColor> customBuildingColors;
    private List<AMap3DTileBuildingMaterialOptions> customBuildingMaterialOptions;
    private TileProvider tileProvider;
    private TileProviderInner tileProviderInner;
    private boolean visible;
    private float zIndex;

    public static class a implements Parcelable.Creator<AMap3DModelTileOverlayOptions> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public AMap3DModelTileOverlayOptions createFromParcel(Parcel r100) {
            TileProvider r101 = (TileProvider) r100.readValue(TileProvider.class.getClassLoader());
            ArrayList r102 = r100.readArrayList(AMap3DTileBuildingColor.class.getClassLoader());
            ArrayList r103 = r100.readArrayList(AMap3DTileBuildingMaterialOptions.class.getClassLoader());
            AMap3DModelTileOverlayOptions r104 = new AMap3DModelTileOverlayOptions();
            if (r101 == null) goto L5;
            r104.setTileProvider(r101);
        L5:
            boolean[] r105 = new boolean[1];
            r100.readBooleanArray(r105);
            r104.setVisible(r105[0]);
            r104.setZIndex(r100.readFloat());
            r104.setCustomBuildingColors(r102);
            r104.setCustomBuildingMaterialOptions(r103);
            return r104;
        }

        @Override // android.os.Parcelable.Creator
        public AMap3DModelTileOverlayOptions[] newArray(int r100) {
            return new AMap3DModelTileOverlayOptions[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public AMap3DModelTileOverlayOptions() {
        this.zIndex = 0.0f;
        this.visible = true;
        this.customBuildingColors = new ArrayList();
        this.customBuildingMaterialOptions = new ArrayList();
        this.type = "AMap3DModelTileOverlayOptions";
    }

    public List<AMap3DTileBuildingColor> getCustomBuildingColors() {
        return this.customBuildingColors;
    }

    public List<AMap3DTileBuildingMaterialOptions> getCustomBuildingMaterialOptions() {
        return this.customBuildingMaterialOptions;
    }

    public TileProviderInner getTileProviderInner() {
        return this.tileProviderInner;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean visible() {
        return this.visible;
    }

    public void setCustomBuildingColors(List<AMap3DTileBuildingColor> r100) {
        this.customBuildingColors = r100;
    }

    public void setCustomBuildingMaterialOptions(List<AMap3DTileBuildingMaterialOptions> r100) {
        this.customBuildingMaterialOptions = r100;
    }

    public void setTileProvider(TileProvider r100) {
        this.tileProvider = r100;
        this.tileProviderInner = new TileProviderInner(r100);
    }

    public void setVisible(boolean r100) {
        this.visible = r100;
    }

    public void setZIndex(float r100) {
        this.zIndex = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeValue(this.tileProviderInner);
        r100.writeBooleanArray(new boolean[]{this.visible});
        r100.writeFloat(this.zIndex);
        r100.writeList(this.customBuildingColors);
        r100.writeList(this.customBuildingMaterialOptions);
    }
}
