package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;

/* JADX INFO: loaded from: classes28.dex */
public final class TileOverlayOptions extends BaseOptions implements Parcelable {
    public static final TileOverlayOptionsCreator CREATOR = null;
    private TileProvider _tileProvider;
    private String diskCacheDir;
    private boolean diskCacheEnabled;
    private long diskCacheSize;
    private TileProviderInner mTileProvider;
    private final int mVersionCode;
    private boolean mVisible;
    private float mZIndex;
    private int memCacheSize;
    private boolean memoryCacheEnabled;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new TileOverlayOptionsCreator();
    }

    public TileOverlayOptions() {
        this.mVisible = true;
        this.memCacheSize = 5242880;
        this.diskCacheSize = 20971520;
        this.diskCacheDir = null;
        this.memoryCacheEnabled = true;
        this.diskCacheEnabled = true;
        this.mVersionCode = 1;
        this.type = "TileOverlayOptions";
    }

    public String getDiskCacheDir() {
        return this.diskCacheDir;
    }

    public boolean getDiskCacheEnabled() {
        return this.diskCacheEnabled;
    }

    public long getDiskCacheSize() {
        return this.diskCacheSize;
    }

    public int getMemCacheSize() {
        return this.memCacheSize;
    }

    public boolean getMemoryCacheEnabled() {
        return this.memoryCacheEnabled;
    }

    public TileProvider getTileProvider() {
        return this._tileProvider;
    }

    public TileProviderInner getTileProviderInner() {
        return this.mTileProvider;
    }

    public float getZIndex() {
        return this.mZIndex;
    }

    public boolean isVisible() {
        return this.mVisible;
    }

    public TileOverlayOptions diskCacheDir(String r100) {
        this.diskCacheDir = r100;
        return this;
    }

    public TileOverlayOptions diskCacheEnabled(boolean r100) {
        this.diskCacheEnabled = r100;
        return this;
    }

    public TileOverlayOptions diskCacheSize(int r100) {
        this.diskCacheSize = r100 * 1024;
        return this;
    }

    public TileOverlayOptions memCacheSize(int r100) {
        this.memCacheSize = r100;
        return this;
    }

    public TileOverlayOptions memoryCacheEnabled(boolean r100) {
        this.memoryCacheEnabled = r100;
        return this;
    }

    public TileOverlayOptions tileProvider(TileProvider r100) {
        this._tileProvider = r100;
        this.mTileProvider = new TileProviderInner(r100);
        return this;
    }

    public TileOverlayOptions visible(boolean r100) {
        this.mVisible = r100;
        return this;
    }

    public TileOverlayOptions zIndex(float r100) {
        this.mZIndex = r100;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.mVersionCode);
        r100.writeValue(this.mTileProvider);
        r100.writeByte(this.mVisible ? 1 : 0);
        r100.writeFloat(this.mZIndex);
        r100.writeInt(this.memCacheSize);
        r100.writeLong(this.diskCacheSize);
        r100.writeString(this.diskCacheDir);
        r100.writeByte(this.memoryCacheEnabled ? 1 : 0);
        r100.writeByte(this.diskCacheEnabled ? 1 : 0);
    }

    public TileOverlayOptions(int r100, boolean r101, float r102) {
        this.memCacheSize = 5242880;
        this.diskCacheSize = 20971520;
        this.diskCacheDir = null;
        this.memoryCacheEnabled = true;
        this.diskCacheEnabled = true;
        this.mVersionCode = r100;
        this.mVisible = r101;
        this.mZIndex = r102;
        this.type = "TileOverlayOptions";
    }
}
