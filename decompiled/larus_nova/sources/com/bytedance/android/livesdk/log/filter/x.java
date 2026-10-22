package com.bytedance.android.livesdk.log.filter;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.common.utility.StringUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class x extends a<am2.m> {
    public x() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        am2.m r102 = (am2.m) r101;
        super.u(r100, r102);
        if (r102 == null) goto L43;
        long r103 = r102.f4303b;
        if (r103 <= 0) goto L8;
        r100.put("invitee_id", String.valueOf(r103));
    L8:
        long r104 = r102.f4302a;
        if (r104 <= 0) goto L12;
        r100.put("inviter_id", String.valueOf(r104));
    L12:
        if (StringUtils.isEmpty(null) == true) goto L15;
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE, null);
    L15:
        if (StringUtils.isEmpty(r102.f4304c) == true) goto L18;
        r100.put("end_type", r102.f4304c);
    L18:
        if (StringUtils.isEmpty(r102.f4305d) == true) goto L21;
        r100.put("connection_time", r102.f4305d);
    L21:
        if (StringUtils.isEmpty(r102.f4306e) == true) goto L24;
        r100.put("invitee_list", r102.f4306e);
    L24:
        if (StringUtils.isEmpty(r102.f4307f) == true) goto L26;
        r100.put("is_rematch", r102.f4307f);
    L26:
        int r105 = r102.f4310i;
        if (r105 == 0) goto L30;
        r100.put("pk_time", String.valueOf(r105));
    L30:
        if (StringUtils.isEmpty(r102.getType()) == true) goto L40;
        r100.put("connection_type", r102.getType());
        if (r102.getType().equals(PbRequest.SwitchType.PK) == true) goto L34;
        return;
    L34:
        if (StringUtils.isEmpty(r102.f4309h) == true) goto L36;
        r100.put("title", r102.f4309h);
    L36:
        int r106 = r102.f4310i;
        if (r106 <= 0) goto L42;
        r100.put("pk_time", String.valueOf(r106));
        return;
    L42:
        return;
    L40:
        return;
    }
}
