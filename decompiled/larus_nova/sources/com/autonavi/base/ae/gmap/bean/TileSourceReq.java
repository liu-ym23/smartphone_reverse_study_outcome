package com.autonavi.base.ae.gmap.bean;

/* JADX INFO: loaded from: classes39.dex */
public class TileSourceReq {
    public int sourceType;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f30029x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f30030y;
    public int zoom;

    public String toString() {
        return "TileSourceReq{x=" + this.f30029x + ", y=" + this.f30030y + ", zoom=" + this.zoom + ", sourceId=" + this.sourceType + '}';
    }

    public TileSourceReq() {
    }
}
