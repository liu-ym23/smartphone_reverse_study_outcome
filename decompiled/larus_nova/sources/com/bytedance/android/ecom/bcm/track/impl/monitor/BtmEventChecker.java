package com.bytedance.android.ecom.bcm.track.impl.monitor;

import com.bytedance.android.ecom.bcm.track.impl.setting.Setting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class BtmEventChecker implements com.bytedance.android.btm.api.model.i {
    public BtmEventChecker() {
    }

    @Override // com.bytedance.android.btm.api.model.i
    public final com.bytedance.android.btm.api.model.g a(final com.bytedance.android.btm.api.model.h r100) {
        final JSONObject r101 = r100.f42056b;
        if (r101 == null) goto L21;
        final String r102 = r101.optString("btm");
        final String r103 = r101.optString("btm_show_id");
        boolean r104 = false;
        if (r102 != null) goto L7;
    L10:
        boolean r105 = true;
    L11:
        if (r105 == true) goto L20;
        if (r103 != null) goto L14;
    L15:
        r104 = true;
    L16:
        if (r104 == true) goto L20;
        return null;
    L14:
        if (r103.length() != 0) goto L16;
    L20:
        return new com.bytedance.android.btm.api.model.g(new BtmEventChecker$check$1(r100, r102, r103, r101), 2021, null, null);
    L7:
        if (r102.length() == 0) goto L10;
        r105 = false;
        goto L11
    L21:
        return null;
    }

    @Override // com.bytedance.android.btm.api.model.i
    public final boolean b(com.bytedance.android.btm.api.model.h r100) {
        return Setting.f51149a.a().b().contains(r100.f42055a);
    }
}
