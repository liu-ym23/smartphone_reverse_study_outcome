package com.bytedance.android.livesdk.widgetdescriptor.priority;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.ies.sdk.widgets.DataCenter;
import j70.h;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> f162433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> f162434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> f162435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> f162436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Double> f162437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f162438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DataCenter f162439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h70.b f162440h;

    @Override // com.bytedance.android.livesdk.widgetdescriptor.priority.d
    public final void e() {
        com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.c.a("calculate start");
        e r100 = this.f162438f;
        if (r100 == null) goto L16;
        LayerDescriptorList r101 = r100.f162443a;
        if (r101 == null) goto L16;
        Iterator<h<? extends h70.b>> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L16;
        h<h70.b> r103 = (h) r102.next();
        if (r103 == null) goto L14;
        f(r103, true);     // Catch: Exception -> L15
    L15:
        ALogger.e("descriptor", "LiveLayerContext cast failed");
        goto L8
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptor<com.bytedance.android.live.core.tetris.layer.LayerContext>");     // Catch: Exception -> L15
    L16:
        e r104 = this.f162438f;
        if (r104 == null) goto L30;
        LayerDescriptorList r105 = r104.f162444b;
        if (r105 == null) goto L30;
        Iterator<h<? extends h70.b>> r106 = r105.iterator();
    L22:
        if (r106.hasNext() == false) goto L30;
        h<h70.b> r107 = (h) r106.next();
        if (r107 == null) goto L28;
        f(r107, false);     // Catch: Exception -> L29
    L29:
        ALogger.e("descriptor", "LiveLayerContext cast failed");
        goto L22
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptor<com.bytedance.android.live.core.tetris.layer.LayerContext>");     // Catch: Exception -> L29
    L30:
        com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.c.a("calculate end");
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.priority.d
    public final void release() {
        this.f162433a.clear();
        this.f162434b.clear();
        this.f162435c.clear();
        this.f162436d.clear();
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.priority.d
    public final TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> a() {
        return this.f162434b;
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.priority.d
    public final TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> b() {
        return this.f162435c;
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.priority.d
    public final TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> c() {
        return this.f162436d;
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.priority.d
    public final TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> d() {
        return this.f162433a;
    }

    public final void f(h<h70.b> r100, boolean r110) {
        String r101 = r100.C(this.f162440h).f497559b;
        DataCenter r102 = this.f162439g;
        if (r102 == null) goto L7;
        Boolean r103 = (Boolean) r102.get("data_is_anchor", Boolean.FALSE);
        if (r103 == null) goto L7;
        boolean r104 = r103.booleanValue();
    L9:
        if (r104 == false) goto L11;
        double r105 = r100.F(this.f162440h);
    L29:
        Map<String, Double> r106 = this.f162437e;
        if (r106 == null) goto L34;
        Double r107 = r106.get(r101);
        if (r107 == null) goto L34;
        double r108 = r107.doubleValue();
    L35:
        double r109 = 0;
        if (r108 <= r109) goto L39;
        r105 = r108;
    L39:
        if (r105 <= r109) goto L44;
        if (r105 >= 1) goto L44;
        TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> r111 = this.f162433a;
    L54:
        com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a r112 = r111.get(Double.valueOf(r105));
        if (r112 != null) goto L57;
        r112 = new com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a(new LayerDescriptorList(), new LayerDescriptorList());
        r111.put(Double.valueOf(r105), r112);
    L57:
        r112.b(r110, r100);
        return;
    L44:
        if (r105 < 1) goto L49;
        if (r105 >= 2) goto L49;
        r111 = this.f162434b;
    L49:
        if (r105 >= 2) goto L51;
    L53:
        r111 = this.f162436d;
        goto L54
    L51:
        if (r105 >= 3) goto L53;
        r111 = this.f162435c;
    L34:
        r108 = -1.0d;
        goto L35
    L11:
        DataCenter r113 = this.f162439g;
        if (r113 == null) goto L16;
        Boolean r114 = (Boolean) r113.get("data_is_portrait", Boolean.TRUE);
        if (r114 == null) goto L16;
        boolean r115 = r114.booleanValue();
    L17:
        if (r115 == false) goto L19;
        r105 = r100.H(this.f162440h);
        goto L29
    L19:
        DataCenter r116 = this.f162439g;
        if (r116 == null) goto L24;
        Boolean r117 = (Boolean) r116.get("data_is_portrait", Boolean.TRUE);
        if (r117 == null) goto L24;
        boolean r118 = r117.booleanValue();
    L26:
        if ((!r118) == false) goto L28;
        r105 = r100.G(this.f162440h);
        goto L29
    L28:
        r105 = r100.H(this.f162440h);
    L24:
        r118 = true;
    L16:
        r115 = true;
    L7:
        r104 = false;
        goto L9
    }

    public a(Map<String, Double> r100, e r101, DataCenter r102, h70.b r103) {
        Intrinsics.checkNotNullParameter(r103, "layerContext");
        this.f162437e = r100;
        this.f162438f = r101;
        this.f162439g = r102;
        this.f162440h = r103;
        this.f162433a = new TreeMap();
        this.f162434b = new TreeMap();
        this.f162435c = new TreeMap();
        this.f162436d = new TreeMap();
    }
}
