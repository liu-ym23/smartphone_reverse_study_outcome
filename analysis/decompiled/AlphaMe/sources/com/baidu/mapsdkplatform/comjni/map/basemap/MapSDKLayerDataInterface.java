package com.baidu.mapsdkplatform.comjni.map.basemap;

import android.os.Bundle;
import com.baidu.platform.comjni.map.basemap.a;

/* loaded from: classes.dex */
public interface MapSDKLayerDataInterface extends a {
    @Override // com.baidu.platform.comjni.map.basemap.a
    boolean hasLayer(long j4);

    @Override // com.baidu.platform.comjni.map.basemap.a
    int mapLayerDataReq(Bundle bundle, long j4, int i4);
}
