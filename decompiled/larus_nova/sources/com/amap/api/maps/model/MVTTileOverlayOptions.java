package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;

/* JADX INFO: loaded from: classes28.dex */
public class MVTTileOverlayOptions extends BaseOptions implements Parcelable {
    public static final Parcelable.Creator<MVTTileOverlayOptions> CREATOR = null;
    private String layerId;
    private TileProvider tileProvider;
    private TileProviderInner tileProviderInner;
    private boolean visible;
    private float zIndex;

    public static class Builder {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f28653id;
        private String key;
        private String url;
        private boolean visible;
        private float zIndex;

        public MVTTileOverlayOptions build() {
            MVTTileOverlayOptions r100 = new MVTTileOverlayOptions(this.url, this.key, this.f28653id);
            r100.setZIndex(this.zIndex);
            r100.setVisible(this.visible);
            return r100;
        }

        public Builder() {
            this.zIndex = 0.0f;
            this.visible = true;
        }

        public Builder id(String r100) {
            this.f28653id = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }

        public Builder visible(boolean r100) {
            this.visible = r100;
            return this;
        }

        public Builder zIndex(float r100) {
            this.zIndex = r100;
            return this;
        }
    }

    public static class a implements Parcelable.Creator<MVTTileOverlayOptions> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public MVTTileOverlayOptions createFromParcel(Parcel r100) {
            TileProvider r101 = (TileProvider) r100.readValue(TileProvider.class.getClassLoader());
            MVTTileOverlayOptions r102 = new MVTTileOverlayOptions(r100.readString(), r100.readString(), r100.readString());
            if (r101 == null) goto L5;
            r102.setTileProvider(r101);
        L5:
            return r102;
        }

        @Override // android.os.Parcelable.Creator
        public MVTTileOverlayOptions[] newArray(int r100) {
            return new MVTTileOverlayOptions[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
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

    public void setTileProvider(TileProvider r100) {
        this.tileProvider = r100;
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
    }

    public MVTTileOverlayOptions(String r100, String r101, String r102) {
        this.type = "MVTTileOverlayOptions";
        MVTTileProvider r103 = new MVTTileProvider(r100, r101, r102);
        this.tileProvider = r103;
        this.tileProviderInner = new TileProviderInner(r103);
        this.layerId = r102;
    }
}
