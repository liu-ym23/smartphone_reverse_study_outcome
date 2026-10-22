package com.bytedance.android.livesdk.log.filter;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class c extends a<am2.b> {
    public c() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        am2.b r102 = (am2.b) r101;
        super.u(r100, r102);
        if (r102 == null) goto L13;
        r100.put("channel_id", String.valueOf(r102.f4257c));
        long r103 = r102.f4258d;
        if (r103 <= 0) goto L8;
        r100.put("invitee_id", String.valueOf(r103));
    L8:
        r100.put("invitee_list", r102.f4259e);
        r100.put("connection_type", r102.f4255a);
        r100.put("is_oncemore", String.valueOf(r102.f4256b));
        r100.put("anchor_connect_status", String.valueOf(r102.f4260f));
        if (TextUtils.isEmpty(r102.f4261g) == true) goto L11;
        r100.put("request_id", r102.f4261g);
    L11:
        r100.put("inviter_id", String.valueOf(r102.f4262h));
        r100.put("linkmic_timestamp", String.valueOf(System.currentTimeMillis()));
        r100.put("right_user_id", String.valueOf(r102.f4258d));
        r100.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, String.valueOf(r102.f4258d));
        r100.put("is_rematch", String.valueOf(r102.f4263i));
        r100.put("match_time", String.valueOf(r102.f4264j));
        return;
    }
}
