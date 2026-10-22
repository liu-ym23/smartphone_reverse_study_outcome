package com.bytedance.android.shopping.anchorv3.utils;

import android.text.TextUtils;
import com.bytedance.android.ec.core.utils.n0;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECBoltParam;

/* JADX INFO: loaded from: classes12.dex */
public final class k {
    public static final String a(String r100, ECAdLogExtra r101, ECBoltParam r102, String r103, Long r104, boolean r105) {
        if ((!TextUtils.isEmpty(r100)) == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L8;
        r100 = "";
    L8:
        n0 r106 = new n0(r100, false);
        if (r104 == null) goto L11;
        r106.a("spell_group_id", r104.longValue());
    L11:
        if (r102 == null) goto L20;
        String r107 = r102.getActivityId();
        if (r107 == null) goto L20;
        if ((!TextUtils.isEmpty(r107)) == true) goto L18;
        r107 = null;
    L18:
        if (r107 == null) goto L20;
        r106.b("activity_id", r107);
    L20:
        if (r102 == null) goto L29;
        String r108 = r102.getNewSourceId();
        if (r108 == null) goto L29;
        if ((!TextUtils.isEmpty(r108)) == true) goto L27;
        r108 = null;
    L27:
        if (r108 == null) goto L29;
        r106.b("new_source_id", r108);
    L29:
        if (r103 != null) goto L31;
    L36:
        r106.a("page_init_timestamp", System.currentTimeMillis());
        int r109 = b.f165302a;
        return b.a(r106.c(), r101, r105);
    L31:
        if ((!TextUtils.isEmpty(r103)) == true) goto L34;
        r103 = null;
    L34:
        if (r103 == null) goto L36;
        r106.b(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r103);
        goto L36
    }
}
