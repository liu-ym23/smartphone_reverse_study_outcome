package com.bytedance.android.ecom.bcm.track.impl.monitor;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements com.bytedance.android.btm.api.model.i {
    public h() {
    }

    @Override // com.bytedance.android.btm.api.model.i
    public final com.bytedance.android.btm.api.model.g a(com.bytedance.android.btm.api.model.h r100) {
        return e.a(r100);
    }

    @Override // com.bytedance.android.btm.api.model.i
    public final boolean b(com.bytedance.android.btm.api.model.h r100) {
        if (Intrinsics.areEqual(r100.f42055a, "page_view") == false) goto L12;
        int r101 = com.bytedance.android.ecom.bcm.track.impl.util.a.f51158a;
        int r102 = e.f51113a;
        JSONObject r103 = r100.f42056b;
        if (r103 == null) goto L7;
        String r104 = r103.optString("btm");
    L9:
        if (Intrinsics.areEqual(com.bytedance.android.ecom.bcm.track.impl.util.a.a(com.bytedance.android.ecom.bcm.track.impl.util.a.b(r104)), "a1.b7411") == true) goto L17;
    L16:
        return false;
    L17:
        return true;
    L7:
        r104 = "";
        goto L9
    L12:
        if (Intrinsics.areEqual(r100.f42055a, "order_submit") == true) goto L17;
        if (Intrinsics.areEqual(r100.f42055a, "order_submit_success") == false) goto L16;
        goto L16
    }
}
