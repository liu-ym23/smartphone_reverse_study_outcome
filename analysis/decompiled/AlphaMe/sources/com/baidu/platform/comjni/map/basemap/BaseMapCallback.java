package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import com.baidu.mapsdkplatform.comjni.map.basemap.MapSDKLayerDataInterface;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class BaseMapCallback {

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<Long, a> f9321a = new ConcurrentHashMap<>(2);

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Long, MapSDKLayerDataInterface> f9322b = new ConcurrentHashMap<>(2);

    public static void release(long j4) {
        f9321a.remove(Long.valueOf(j4));
        f9322b.remove(Long.valueOf(j4));
    }

    public static int reqLayerData(Bundle bundle, long j4, int i4) {
        ConcurrentHashMap<Long, a> concurrentHashMap = f9321a;
        if (concurrentHashMap.isEmpty()) {
            return 0;
        }
        Iterator<Map.Entry<Long, a>> it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (value != null && value.hasLayer(j4)) {
                return value.mapLayerDataReq(bundle, j4, i4);
            }
        }
        Iterator<Map.Entry<Long, MapSDKLayerDataInterface>> it2 = f9322b.entrySet().iterator();
        while (it2.hasNext()) {
            MapSDKLayerDataInterface value2 = it2.next().getValue();
            if (value2 != null && value2.hasLayer(j4)) {
                return value2.mapLayerDataReq(bundle, j4, i4);
            }
        }
        return 0;
    }

    public static boolean setMapCallback(long j4, a aVar) {
        if (aVar == null || j4 == 0) {
            return false;
        }
        f9321a.put(Long.valueOf(j4), aVar);
        return true;
    }

    public static boolean setMapSDKCallback(long j4, MapSDKLayerDataInterface mapSDKLayerDataInterface) {
        if (mapSDKLayerDataInterface == null || j4 == 0) {
            return false;
        }
        f9322b.put(Long.valueOf(j4), mapSDKLayerDataInterface);
        return true;
    }
}
