package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h1 extends bx7.c {
    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "x.removeStorageItem";
    }

    public h1() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        String r103 = r100.getString("key");
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        String r105 = r100.getString("biz");
        if (r105 == null) goto L9;
        r104 = r105;
    L9:
        d1.f192048a.getValue().getClass();
        Intrinsics.checkNotNullParameter(r104, "biz");
        d1.a(r104).erase(r103);
        r101.invoke(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1)}));
    }
}
