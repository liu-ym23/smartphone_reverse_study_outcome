package com.bytedance.android.livesdk.log.filter;

import android.text.TextUtils;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class h extends a<FollowLog> implements p {
    public h() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        FollowLog r102 = (FollowLog) r101;
        super.u(r100, r102);
        if (r102 == null) goto L31;
        int r103 = r102.f153385d;
        if (r103 == (-1)) goto L9;
        r100.put(IPerformanceManager.Params.is_anchor, String.valueOf(r103));
    L9:
        if (TextUtils.isEmpty(r102.f153382a) == true) goto L12;
        r100.put("request_page", r102.f153382a);
    L12:
        if (TextUtils.isEmpty(r102.f153383b) == true) goto L19;
        if (TextUtils.equals(r102.f153383b, "0") == true) goto L19;
        if (TextUtils.equals(r102.f153383b, "-1") == true) goto L19;
        r100.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r102.f153383b);
    L19:
        if (TextUtils.isEmpty(null) == true) goto L22;
        r100.put("type", null);
    L22:
        if (TextUtils.isEmpty(r102.f153384c) == true) goto L24;
        r100.put("preview_source", r102.f153384c);
    L24:
        String r104 = r102.f153387f;
        if (r104 != null) goto L29;
        FollowLog.Scene r105 = r102.f153386e;
        if (r105 == null) goto L29;
        r104 = r105.getFollowEntrancePage();
    L29:
        J(r100, r104, r102.f153388g, r102.f153389h);
        return;
    }

    public static void J(Map<String, String> r100, String r101, String r102, String r103) {
        p.f153330a.getClass();
        if (r100 == null) goto L21;
        if (r101 == null) goto L10;
        if (TextUtils.isEmpty(r101) == true) goto L10;
        r100.put("follow_entrance_page", r101);
    L10:
        if (TextUtils.isEmpty(r102) == true) goto L15;
        if (r102 != null) goto L13;
        r102 = "";
    L13:
        r100.put("follow_target", r102);
    L15:
        if (TextUtils.isEmpty(r103) == true) goto L20;
        if (r103 != null) goto L18;
        r103 = "";
    L18:
        r100.put("is_current_anchor", r103);
        return;
    L20:
        return;
    }
}
