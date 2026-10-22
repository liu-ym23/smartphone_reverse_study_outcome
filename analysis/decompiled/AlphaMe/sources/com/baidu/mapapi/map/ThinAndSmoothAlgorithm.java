package com.baidu.mapapi.map;

/* loaded from: classes.dex */
public enum ThinAndSmoothAlgorithm {
    ALGORITHM_NONR(1),
    DOUGLAS_PEUCKER(2),
    BEZIER_SMOOTH(32);


    /* renamed from: b, reason: collision with root package name */
    private final int f7018b;

    ThinAndSmoothAlgorithm(int i4) {
        this.f7018b = i4;
    }

    public int getValue() {
        return this.f7018b;
    }
}
