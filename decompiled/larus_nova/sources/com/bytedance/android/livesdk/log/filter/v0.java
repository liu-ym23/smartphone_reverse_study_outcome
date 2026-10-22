package com.bytedance.android.livesdk.log.filter;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class v0 extends a<am2.e0> {
    public v0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        am2.e0 r102 = (am2.e0) r101;
        super.u(r100, r102);
        if (r102 == null) goto L7;
        r100.put("gift_type", null);
        r100.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, null);
        r100.put("money", String.valueOf(0));
        r100.put("combo_cnt", "1");
        r100.put("group_cnt", "1");
        return;
    }
}
