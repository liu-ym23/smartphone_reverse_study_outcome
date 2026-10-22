package com.bytedance.android.shopping.mall.homepage.jsb;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ECMallReportALogListJsb extends qf3.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f178197c;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return "ec.mallReportAlogList";
    }

    public ECMallReportALogListJsb() {
        this.f178197c = LazyKt.lazy(ECMallReportALogListJsb$logService$2.INSTANCE);
    }

    @Override // qf3.b
    public final void c(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Object r103 = r101.get("logList");
        if ((r103 instanceof ArrayList) == true) goto L5;
        r103 = null;
    L5:
        ArrayList r104 = (ArrayList) r103;
        if (r104 == null) goto L26;
        Iterator r105 = r104.iterator();
    L9:
        if (r105.hasNext() == false) goto L26;
        Map r106 = (Map) r105.next();
        if (r106 == null) goto L12;
        String r107 = (String) r106.get("level");
        String r108 = (String) r106.get("tag");
        String r109 = (String) r106.get("message");
        if (r107 == null) goto L23;
        int r110 = r107.hashCode();
        if (r110 != 3641990) goto L19;
        r107.equals("warn");
        goto L23
    L19:
        if (r110 != 96784904) goto L23;
        r107.equals("error");
    L23:
        yj.h r111 = (yj.h) this.f178197c.getValue();
        if (r111 == null) goto L9;
        r111.log(r108, r109);
        goto L9
    L12:
        return;
    L26:
        LinkedHashMap r112 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r112, "result");
        r102.invoke(MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("data", r112)}));
    }
}
