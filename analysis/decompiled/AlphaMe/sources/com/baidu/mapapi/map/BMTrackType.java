package com.baidu.mapapi.map;

/* loaded from: classes.dex */
public enum BMTrackType {
    Surface(3),
    Default3D(4),
    Track(5),
    TrackGradient(6);


    /* renamed from: b, reason: collision with root package name */
    private int f6119b;

    BMTrackType(int i4) {
        this.f6119b = i4;
    }

    public int getType() {
        return this.f6119b;
    }
}
