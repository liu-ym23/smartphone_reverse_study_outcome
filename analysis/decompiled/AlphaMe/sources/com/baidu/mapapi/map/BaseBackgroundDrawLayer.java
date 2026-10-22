package com.baidu.mapapi.map;

import android.content.Context;

/* loaded from: classes.dex */
abstract class BaseBackgroundDrawLayer implements IBackgroundDrawLayer {
    public static final int LIFE_CREATE = 1;
    public static final int LIFE_DESTROY = 2;
    public static final int LIFE_NONE = 0;
    protected Context mContext;
    protected int mHeight;
    private int mLife;
    protected int mOrder;
    protected int mWidth;

    public BaseBackgroundDrawLayer(Context context) {
        this(context, 0);
    }

    public int getLife() {
        return this.mLife;
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawLayer
    public void onCreate() {
        this.mLife = 1;
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawLayer
    public void onDestroy() {
        this.mLife = 2;
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawLayer
    public void onSizeChanged(int i4, int i5) {
        this.mWidth = i4;
        this.mHeight = i5;
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawLayer
    public void onUpdated() {
    }

    public BaseBackgroundDrawLayer(Context context, int i4) {
        this.mContext = context;
        this.mLife = 0;
        this.mOrder = i4;
    }
}
