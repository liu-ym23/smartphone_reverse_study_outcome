package com.bytedance.android.ec.hybrid.card.util;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zz6.IKitView;

/* JADX INFO: loaded from: classes44.dex */
public final class l implements com.bytedance.android.ec.hybrid.card.event.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IKitView f46613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f46614b;

    @Override // com.bytedance.android.ec.hybrid.card.event.e
    public final void a(com.bytedance.android.ec.hybrid.card.event.d r100) {
        Intrinsics.checkNotNullParameter(r100, "jsEvent");
        Map<String, Object> r101 = r100.f46490b;
        if (r101 == null) goto L16;
        int r102 = m.f46615a;
        LinkedHashMap r103 = new LinkedHashMap(MapsKt.mapCapacity(r101.size()));
        Iterator<T> r104 = r101.entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L12;
        Map.Entry r105 = (Map.Entry) r104.next();
        Object r106 = r105.getKey();
        if (r105.getValue() != null) goto L10;
        Object r107 = "";
    L11:
        r103.put(r106, r107);
        goto L6
    L10:
        r107 = r105.getValue();
        Intrinsics.checkNotNull(r107);
        goto L11
    L12:
        IKitView r108 = this.f46613a;
        Intrinsics.checkNotNullParameter(r103, "data");
        if (r108 == null) goto L15;
        r108.b();
    L15:
        Lazy r109 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.d.f47458b, "update global props by increment " + this.f46614b);
    L16:
        Lazy r110 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.d.a.f47465b, "receive js event " + r100.f46489a + ", schema : " + this.f46614b);
    }

    public l(IKitView r100, String r101) {
        this.f46613a = r100;
        this.f46614b = r101;
    }
}
