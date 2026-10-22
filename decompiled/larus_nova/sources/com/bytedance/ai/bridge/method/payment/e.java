package com.bytedance.ai.bridge.method.payment;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements k5.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f35784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f35785b;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.f("current_page", this.f35784a);
        Iterator<Map.Entry<String, Object>> r101 = this.f35785b.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        Map.Entry<String, Object> r102 = r101.next();
        String r103 = r102.getKey();
        Object r104 = r102.getValue();
        if ((r104 instanceof String) == false) goto L8;
        String r105 = (String) r104;
    L9:
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        r100.f(r103, r105);
        goto L4
    L8:
        r105 = null;
        goto L9
    }

    public e(String r100, Map<String, ? extends Object> r101) {
        this.f35784a = r100;
        this.f35785b = r101;
    }
}
