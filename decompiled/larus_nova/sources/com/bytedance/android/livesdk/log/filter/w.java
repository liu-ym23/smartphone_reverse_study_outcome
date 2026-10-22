package com.bytedance.android.livesdk.log.filter;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.common.utility.StringUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class w extends a<am2.l> {
    public w() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        am2.l r102 = (am2.l) r101;
        if (r102 == null) goto L27;
        long r103 = r102.f4293a;
        if (r103 <= 0) goto L8;
        r100.put("channel_id", String.valueOf(r103));
    L8:
        String r104 = r102.f4294b;
        if (r104 != null) goto L11;
    L13:
        r100.put("is_oncemore", String.valueOf(r102.f4299g));
        int r105 = r102.f4295c;
        if (r105 <= 0) goto L21;
        r100.put("pk_time", String.valueOf(r105));
        r100.put("connection_type", r102.f4296d);
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE, null);
        long r106 = r102.f4297e;
        if (r106 <= 0) goto L19;
        r100.put("pk_id", String.valueOf(r106));
    L19:
        if (StringUtils.isEmpty(r102.f4298f) == false) goto L22;
        r100.put("title", r102.f4298f);
    L22:
        r100.put("request_page", null);
        r100.put("is_reinvite", String.valueOf(r102.f4300h));
        if (TextUtils.isEmpty(r102.f4301i) == true) goto L25;
        r100.put("request_id", r102.f4301i);
    L25:
        r100.put("linkmic_timestamp", String.valueOf(System.currentTimeMillis()));
        return;
    L21:
        r100.put("connection_type", r102.f4296d);
        goto L22
    L11:
        if (r104.isEmpty() == true) goto L13;
        r100.put("right_user_id", r102.f4294b);
        goto L13
    }
}
