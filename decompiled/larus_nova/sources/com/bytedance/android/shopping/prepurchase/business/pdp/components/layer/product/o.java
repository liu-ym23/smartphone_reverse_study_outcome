package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vg3.k0;

/* JADX INFO: loaded from: classes13.dex */
public final class o implements ti.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PdpPendantHandler f181786a;

    public o(PdpPendantHandler r100) {
        this.f181786a = r100;
    }

    @Override // ti.j
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        String r101 = r100.optString("containerID");
        this.f181786a.c("receive close event, id=" + r101 + " cachedId=" + this.f181786a.f181653a);
        if (Intrinsics.areEqual(r101, this.f181786a.f181653a) == false) goto L8;
        vg3.u r102 = (vg3.u) this.f181786a.f181657e.getService(vg3.u.class);
        if (r102 == null) goto L9;
        r102.v0(new k0(false, false, 7));
        return;
    L9:
        return;
    }
}
