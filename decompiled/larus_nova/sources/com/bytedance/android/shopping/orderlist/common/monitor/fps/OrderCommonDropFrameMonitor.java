package com.bytedance.android.shopping.orderlist.common.monitor.fps;

import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.q;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jh.b;
import jh.c;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderCommonDropFrameMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f179909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f179910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f179911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f179912d;

    public static final class a {
    }

    static {
    }

    public final void a() {
        if (this.f179909a == false) goto L5;
        return;
    L5:
        this.f179909a = true;
        this.f179911c.b();
    }

    public final void b() {
        if (this.f179909a == true) goto L5;
        return;
    L5:
        final int r100 = System.identityHashCode(this.f179911c);
        Lazy r101 = OrderCommonLog.f179948a;
        OrderCommonLog.a("OrderCommonFpsMonitor", new OrderCommonDropFrameMonitor$stopMonitor$1(r100));
        Iterator<Map.Entry<String, Object>> r102 = this.f179912d.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<String, Object> r103 = r102.next();
        this.f179911c.a(r103.getKey(), r103.getValue());
        goto L7
    L9:
        int r104 = this.f179910b;
        if (r104 >= 0) goto L12;
        this.f179911c.a("dScrollY", Integer.valueOf(-r104));
        this.f179911c.a("operator_type", 0);
    L13:
        this.f179911c.stop();
        this.f179910b = 0;
        this.f179909a = false;
        return;
    L12:
        this.f179911c.a("dScrollY", Integer.valueOf(r104));
        this.f179911c.a("operator_type", 1);
        goto L13
    }

    public /* synthetic */ OrderCommonDropFrameMonitor(MonitorScenes r100, String r101) {
        this(r100, r101, new LinkedHashMap());
    }

    public OrderCommonDropFrameMonitor(MonitorScenes r100, String r101, Map<String, Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f179912d = r102;
        b.a r103 = b.f499064c;
        q r104 = new q(r100, r101, null);
        r103.getClass();
        this.f179911c = b.a.c(r104);
    }
}
