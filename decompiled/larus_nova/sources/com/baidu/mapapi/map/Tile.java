package com.baidu.mapapi.map;

import android.os.Bundle;

/* JADX INFO: loaded from: classes39.dex */
public class Tile {
    public final byte[] data;
    public final int height;
    public final int width;

    public Bundle toBundle() {
        Bundle r100 = new Bundle();
        r100.putInt("image_width", this.width);
        r100.putInt("image_height", this.height);
        r100.putByteArray("image_data", this.data);
        return r100;
    }

    public Tile(int r100, int r101, byte[] r102) {
        this.width = r100;
        this.height = r101;
        this.data = r102;
    }
}
