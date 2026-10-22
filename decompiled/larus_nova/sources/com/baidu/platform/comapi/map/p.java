package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes39.dex */
public final class p implements com.baidu.platform.comjni.map.basemap.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f33353a = "com.baidu.platform.comapi.map.p";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Map<Long, InnerOverlay> f33354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    AppBaseMap f33355c;

    public void a() {
        if (this.f33355c == null) goto L10;
        Iterator<Long> r100 = this.f33354b.keySet().iterator();
    L6:
        if (r100.hasNext() == false) goto L10;
        Long r101 = r100.next();
        if (r101.longValue() <= 0) goto L6;
        this.f33355c.ClearLayer(r101.longValue());
        this.f33355c.RemoveLayer(r101.longValue());
    L10:
        this.f33354b.clear();
    }

    public p(AppBaseMap r100) {
        this.f33354b = new ConcurrentHashMap();
        this.f33355c = r100;
    }

    public void a(InnerOverlay r100) {
        this.f33354b.put(Long.valueOf(r100.mLayerID), r100);
        r100.SetMapParam(r100.mLayerID, this.f33355c);
    }

    @Override // com.baidu.platform.comjni.map.basemap.a
    public boolean hasLayer(long r100) {
        return this.f33354b.containsKey(Long.valueOf(r100));
    }

    public void a(Overlay r100) {
        this.f33354b.remove(Long.valueOf(r100.mLayerID));
    }

    @Override // com.baidu.platform.comjni.map.basemap.a
    public int mapLayerDataReq(Bundle r100, long r101, int r102) {
        if (k.f33351a == false) goto L5;
        long r103 = System.currentTimeMillis();
    L6:
        InnerOverlay r104 = this.f33354b.get(Long.valueOf(r101));
        if (r104 != null) goto L9;
    L17:
        if (r104 == null) goto L29;
        String r105 = r104.getData();
        if (this.f33355c.LayersIsShow(r101) == false) goto L23;
        r100.putString("jsondata", r105);
        Bundle r106 = r104.getParam();
        if (r106 == null) goto L25;
        r100.putBundle("param", r106);
    L25:
        if (k.f33351a == false) goto L28;
        k.a(f33353a, "MapLayerDataReq:" + r101 + " tag:" + r104.getLayerTag() + " [" + (System.currentTimeMillis() - r103) + "ms] LayerData:" + r105);
    L28:
        return r104.getType();
    L23:
        r100.putString("jsondata", null);
        goto L25
    L29:
        return 0;
    L9:
        if ((r104 instanceof com.baidu.mapsdkplatform.comapi.map.z.a) == false) goto L17;
        com.baidu.mapsdkplatform.comapi.map.z.a r107 = (com.baidu.mapsdkplatform.comapi.map.z.a) r104;
        if (r107.c() == false) goto L17;
        r100.putString("statusupdate", r104.getData());
        if (r107.b() == true) goto L16;
        r107.c(false);
    L16:
        return r107.getType();
    L5:
        r103 = 0;
        goto L6
    }
}
