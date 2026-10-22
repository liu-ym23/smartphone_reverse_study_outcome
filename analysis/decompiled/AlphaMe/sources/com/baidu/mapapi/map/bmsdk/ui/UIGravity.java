package com.baidu.mapapi.map.bmsdk.ui;

/* loaded from: classes.dex */
public enum UIGravity {
    LEFT(1),
    TOP(2),
    RIGHT(4),
    BOTTOM(8),
    CENTER_HORIZONTAL(16),
    CENTER_VERTICAL(32),
    CENTER(48);


    /* renamed from: b, reason: collision with root package name */
    private int f7148b;

    UIGravity(int i4) {
        this.f7148b = i4;
    }

    public int getNumber() {
        return this.f7148b;
    }
}
