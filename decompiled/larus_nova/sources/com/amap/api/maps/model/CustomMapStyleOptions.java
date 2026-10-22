package com.amap.api.maps.model;

/* JADX INFO: loaded from: classes28.dex */
public class CustomMapStyleOptions {
    private boolean enable;
    private byte[] styleData;
    private byte[] styleDataOversea;
    private String styleDataOverseaPath;
    private String styleDataPath;
    private byte[] styleExtraData;
    private String styleExtraPath;
    private String styleId;
    private byte[] styleResData;
    private String styleResDataPath;
    private byte[] styleTextureData;
    private String styleTexturePath;

    public CustomMapStyleOptions setStyleResData(byte[] r100) {
        return this;
    }

    public CustomMapStyleOptions setStyleResDataPath(String r100) {
        return this;
    }

    public CustomMapStyleOptions() {
        this.styleDataPath = null;
        this.styleData = null;
        this.styleTexturePath = null;
        this.styleTextureData = null;
        this.styleId = null;
        this.enable = true;
        this.styleExtraData = null;
        this.styleExtraPath = null;
        this.styleDataOverseaPath = null;
        this.styleDataOversea = null;
        this.styleResDataPath = null;
        this.styleResData = null;
    }

    public byte[] getStyleData() {
        return this.styleData;
    }

    public byte[] getStyleDataOversea() {
        return this.styleDataOversea;
    }

    public String getStyleDataOverseaPath() {
        return this.styleDataOverseaPath;
    }

    public String getStyleDataPath() {
        return this.styleDataPath;
    }

    public byte[] getStyleExtraData() {
        return this.styleExtraData;
    }

    public String getStyleExtraPath() {
        return this.styleExtraPath;
    }

    public String getStyleId() {
        return this.styleId;
    }

    public byte[] getStyleResData() {
        return this.styleResData;
    }

    public String getStyleResDataPath() {
        return this.styleResDataPath;
    }

    public byte[] getStyleTextureData() {
        return this.styleTextureData;
    }

    public String getStyleTexturePath() {
        return this.styleTexturePath;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public CustomMapStyleOptions setEnable(boolean r100) {
        this.enable = r100;
        return this;
    }

    public CustomMapStyleOptions setStyleData(byte[] r100) {
        this.styleData = r100;
        return this;
    }

    public CustomMapStyleOptions setStyleDataOversea(byte[] r100) {
        this.styleDataOversea = r100;
        return this;
    }

    public CustomMapStyleOptions setStyleDataOverseaPath(String r100) {
        this.styleDataOverseaPath = r100;
        return this;
    }

    public CustomMapStyleOptions setStyleDataPath(String r100) {
        this.styleDataPath = r100;
        return this;
    }

    public CustomMapStyleOptions setStyleExtraData(byte[] r100) {
        this.styleExtraData = r100;
        return this;
    }

    public CustomMapStyleOptions setStyleExtraPath(String r100) {
        this.styleExtraPath = r100;
        return this;
    }

    public CustomMapStyleOptions setStyleId(String r100) {
        this.styleId = r100;
        return this;
    }

    public CustomMapStyleOptions setStyleTextureData(byte[] r100) {
        this.styleTextureData = r100;
        return this;
    }

    public CustomMapStyleOptions setStyleTexturePath(String r100) {
        this.styleTexturePath = r100;
        return this;
    }
}
