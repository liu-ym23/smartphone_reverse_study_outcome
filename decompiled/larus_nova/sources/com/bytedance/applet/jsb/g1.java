package com.bytedance.applet.jsb;

import com.bytedance.keva.Keva;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g1 extends bx7.c {
    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "x.getStorageItem";
    }

    public g1() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        p56.b r103 = (p56.b) e(p56.b.class);
        if (r103 == null) goto L5;
        r103.provideContainerID();
    L5:
        String r104 = r100.getString("key");
        String r105 = "";
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        String r106 = r100.getString("biz");
        if (r106 == null) goto L12;
        r105 = r106;
    L12:
        d1.f192048a.getValue().getClass();
        Intrinsics.checkNotNullParameter(r105, "biz");
        Keva r107 = d1.a(r105);
        Object r108 = null;
        String r109 = r107.getString(r104, null);
        if (r109 == null) goto L16;
        r108 = d1.b(r109);
    L16:
        if (r108 == null) goto L18;
        r101.invoke(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("data", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("data", r108)}))}));
        return;
    L18:
        r101.invoke(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 0)}));
    }
}
