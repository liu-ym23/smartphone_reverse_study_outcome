package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.k;
import r52.r3;

/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f136381a = 0;

    static {
        f136381a = s1.f(r3.f536251a.getValue().floatValue() * 1.0f);
    }

    public static k a(int r100) {
        int r101 = f136381a;
        if (r100 >= r101) goto L7;
        j.f133385c.a("right margin " + r100 + " too small, use min right margin");
        return new k(-1, r101, 2);
    L7:
        return new k(-1, r100, 2);
    }
}
