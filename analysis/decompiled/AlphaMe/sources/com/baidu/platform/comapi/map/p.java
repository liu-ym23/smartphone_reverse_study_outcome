package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public final class p implements com.baidu.platform.comjni.map.basemap.a {

    /* renamed from: a, reason: collision with root package name */
    static final String f9245a = "com.baidu.platform.comapi.map.p";

    /* renamed from: b, reason: collision with root package name */
    Map<Long, InnerOverlay> f9246b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    AppBaseMap f9247c;

    public p(AppBaseMap appBaseMap) {
        this.f9247c = appBaseMap;
    }

    public void a(InnerOverlay innerOverlay) {
        this.f9246b.put(Long.valueOf(innerOverlay.mLayerID), innerOverlay);
        innerOverlay.SetMapParam(innerOverlay.mLayerID, this.f9247c);
    }

    @Override // com.baidu.platform.comjni.map.basemap.a
    public boolean hasLayer(long j4) {
        return this.f9246b.containsKey(Long.valueOf(j4));
    }

    @Override // com.baidu.platform.comjni.map.basemap.a
    public int mapLayerDataReq(Bundle bundle, long j4, int i4) {
        long jCurrentTimeMillis = k.f9243a ? System.currentTimeMillis() : 0L;
        InnerOverlay innerOverlay = this.f9246b.get(Long.valueOf(j4));
        if (innerOverlay != null && (innerOverlay instanceof com.baidu.mapsdkplatform.comapi.map.z.a)) {
            com.baidu.mapsdkplatform.comapi.map.z.a aVar = (com.baidu.mapsdkplatform.comapi.map.z.a) innerOverlay;
            if (aVar.c()) {
                bundle.putString("statusupdate", innerOverlay.getData());
                if (!aVar.b()) {
                    aVar.c(false);
                }
                return aVar.getType();
            }
        }
        if (innerOverlay == null) {
            return 0;
        }
        String data = innerOverlay.getData();
        if (this.f9247c.LayersIsShow(j4)) {
            bundle.putString("jsondata", data);
            Bundle param = innerOverlay.getParam();
            if (param != null) {
                bundle.putBundle("param", param);
            }
        } else {
            bundle.putString("jsondata", null);
        }
        if (k.f9243a) {
            String str = f9245a;
            StringBuilder sbE = AbstractC0831a.e("MapLayerDataReq:", j4, " tag:");
            sbE.append(innerOverlay.getLayerTag());
            sbE.append(" [");
            sbE.append(System.currentTimeMillis() - jCurrentTimeMillis);
            sbE.append("ms] LayerData:");
            sbE.append(data);
            k.a(str, sbE.toString());
        }
        return innerOverlay.getType();
    }

    public void a(Overlay overlay) {
        this.f9246b.remove(Long.valueOf(overlay.mLayerID));
    }

    public void a() {
        if (this.f9247c != null) {
            for (Long l4 : this.f9246b.keySet()) {
                if (l4.longValue() > 0) {
                    this.f9247c.ClearLayer(l4.longValue());
                    this.f9247c.RemoveLayer(l4.longValue());
                }
            }
        }
        this.f9246b.clear();
    }
}
