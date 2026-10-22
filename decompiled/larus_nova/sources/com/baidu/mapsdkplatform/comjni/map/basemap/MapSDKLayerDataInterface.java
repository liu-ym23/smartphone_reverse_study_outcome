package com.baidu.mapsdkplatform.comjni.map.basemap;

import android.os.Bundle;
import com.baidu.platform.comjni.map.basemap.a;

/* JADX INFO: loaded from: classes39.dex */
public interface MapSDKLayerDataInterface extends a {
    @Override // com.baidu.platform.comjni.map.basemap.a
    boolean hasLayer(long r100);

    @Override // com.baidu.platform.comjni.map.basemap.a
    int mapLayerDataReq(Bundle r100, long r101, int r102);
}
