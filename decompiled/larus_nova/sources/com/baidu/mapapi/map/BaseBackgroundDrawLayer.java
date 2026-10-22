package com.baidu.mapapi.map;

import android.content.Context;

/* JADX INFO: loaded from: classes39.dex */
abstract class BaseBackgroundDrawLayer implements IBackgroundDrawLayer {
    public static final int LIFE_CREATE = 1;
    public static final int LIFE_DESTROY = 2;
    public static final int LIFE_NONE = 0;
    protected Context mContext;
    protected int mHeight;
    private int mLife;
    protected int mOrder;
    protected int mWidth;

    @Override // com.baidu.mapapi.map.IBackgroundDrawLayer
    public void onCreate() {
        this.mLife = 1;
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawLayer
    public void onDestroy() {
        this.mLife = 2;
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawLayer
    public void onUpdated() {
    }

    public int getLife() {
        return this.mLife;
    }

    public BaseBackgroundDrawLayer(Context r100) {
        this(r100, 0);
    }

    public BaseBackgroundDrawLayer(Context r100, int r101) {
        this.mContext = r100;
        this.mLife = 0;
        this.mOrder = r101;
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawLayer
    public void onSizeChanged(int r100, int r101) {
        this.mWidth = r100;
        this.mHeight = r101;
    }
}
