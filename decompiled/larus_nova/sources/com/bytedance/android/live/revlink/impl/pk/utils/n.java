package com.bytedance.android.live.revlink.impl.pk.utils;

import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.revenue.common.b0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;

/* JADX INFO: loaded from: classes47.dex */
public final class n {
    public static boolean a() {
        if (e51.b.f471043d.a() == false) goto L26;
        int r100 = com.bytedance.android.live.revlink.impl.utils.c.f97647a;
        float r101 = ((Number) b0.f90823d.getValue(null, b0.f90820a[2])).floatValue();
        if (r101 <= 0) goto L8;
        d51.c r102 = d51.c.A0;
        r102.getClass();
        if (r101 >= ((Number) d51.c.f466927g.getValue(r102, d51.c.f466915a[5])).floatValue()) goto L8;
    L22:
        boolean r103 = false;
    L23:
        if (r103 == false) goto L27;
        return true;
    L27:
        return false;
    L8:
        d51.c r104 = d51.c.A0;
        r104.getClass();
        if (((Boolean) d51.c.f466931i.getValue(r104, d51.c.f466915a[7])).booleanValue() == false) goto L22;
        if (PadConfigUtils.c() == false) goto L13;
    L18:
        boolean r105 = true;
    L19:
        if (r105 == true) goto L22;
        r103 = true;
        goto L23
    L13:
        if (PadConfigUtils.c() == true) goto L18;
        if (FoldScreenUtils.f() == true) goto L18;
        r105 = false;
        goto L19
    L26:
        return false;
    }

    static {
    }
}
