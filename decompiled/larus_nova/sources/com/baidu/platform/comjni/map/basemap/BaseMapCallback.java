package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import com.baidu.mapsdkplatform.comjni.map.basemap.MapSDKLayerDataInterface;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes39.dex */
public class BaseMapCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<Long, a> f33442a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Long, MapSDKLayerDataInterface> f33443b = null;

    static {
        f33442a = new ConcurrentHashMap(2);
        f33443b = new ConcurrentHashMap(2);
    }

    public BaseMapCallback() {
    }

    public static void release(long r100) {
        f33442a.remove(Long.valueOf(r100));
        f33443b.remove(Long.valueOf(r100));
    }

    public static boolean setMapCallback(long r100, a r101) {
        if (r101 != null) goto L4;
        return false;
    L4:
        if (r100 == 0) goto L10;
        f33442a.put(Long.valueOf(r100), r101);
        return true;
    L10:
        return false;
    }

    public static boolean setMapSDKCallback(long r100, MapSDKLayerDataInterface r101) {
        if (r101 != null) goto L4;
        return false;
    L4:
        if (r100 == 0) goto L10;
        f33443b.put(Long.valueOf(r100), r101);
        return true;
    L10:
        return false;
    }

    public static int reqLayerData(Bundle r100, long r101, int r102) {
        ConcurrentHashMap<Long, a> r103 = f33442a;
        if (r103.isEmpty() == false) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<Long, a>> r104 = r103.entrySet().iterator();
    L7:
        if (r104.hasNext() == false) goto L14;
        a r105 = r104.next().getValue();
        if (r105 == null) goto L7;
        if (r105.hasLayer(r101) == false) goto L7;
        return r105.mapLayerDataReq(r100, r101, r102);
    L14:
        Iterator<Map.Entry<Long, MapSDKLayerDataInterface>> r106 = f33443b.entrySet().iterator();
    L16:
        if (r106.hasNext() == false) goto L23;
        MapSDKLayerDataInterface r107 = r106.next().getValue();
        if (r107 == null) goto L16;
        if (r107.hasLayer(r101) == false) goto L16;
        return r107.mapLayerDataReq(r100, r101, r102);
    L23:
        return 0;
    }
}
