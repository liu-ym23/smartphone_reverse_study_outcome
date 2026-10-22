package com.bytedance.android.live.liveinteract.utils;

import android.view.Window;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.e5;

/* JADX INFO: loaded from: classes46.dex */
public final class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f78742a = 0;

    public c1() {
    }

    static {
    }

    public static boolean a(Integer r100, Integer r101) {
        if (((Boolean) vm2.e.B.getValue(null, vm2.e.f556037a[26])).booleanValue() == true) goto L5;
        return false;
    L5:
        if (r100 != null) goto L8;
    L9:
        if (r100 != null) goto L12;
    L13:
        if (r101 != null) goto L16;
    L17:
        if (r101 != null) goto L20;
        return false;
    L20:
        if (r101.intValue() != 13) goto L23;
    L21:
        return true;
    L23:
        return false;
    L16:
        if (r101.intValue() == 14) goto L21;
    L12:
        if (r100.intValue() == 23) goto L21;
    L8:
        if (r100.intValue() == 24) goto L21;
        goto L9
    }

    public static void b(Window r100, int r101, int r102) {
        int r103 = 0;
        if ((r102 & 2) == 0) goto L5;
        int r104 = 5;
    L7:
        if ((r102 & 4) == 0) goto L10;
        r103 = s1.f(375.0f);
    L10:
        if ((r102 & 8) == 0) goto L12;
        r101 = -1;
    L12:
        if (r100 != null) goto L15;
        return;
    L15:
        if (e5.n() == false) goto L18;
        r100.setGravity(r104);
        r100.setLayout(r103, r101);
        return;
    L18:
        return;
    L5:
        r104 = 0;
        goto L7
    }
}
