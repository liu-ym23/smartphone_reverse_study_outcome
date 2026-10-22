package com.bytedance.android.window.shop.lifecycle;

import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.window.shop.home.ECWindowParam;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f189234a;

    public d(ConcurrentHashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "commonParams");
        this.f189234a = r100;
    }

    public final void b(JSONObject r100) {
        Iterator<Map.Entry<String, String>> r101 = this.f189234a.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, String> r102 = r101.next();
        r100.put(r102.getKey(), r102.getValue());
        goto L4
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f189234a.put(r100, r101);
    }

    public static void c(d r100, String r101, ECWindowParam r102, JSONObject r103, JSONObject r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r103 = null;
    L6:
        if ((r105 & 8) == 0) goto L8;
        r104 = null;
    L8:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "eventName");
        int r106 = ECMonitorService.f45110b;
        if (r103 != null) goto L11;
        r103 = new JSONObject();
    L11:
        r100.b(r103);
        Unit r107 = Unit.INSTANCE;
        ECMonitorService.a.a(r101, r103, r104, null);
    }
}
