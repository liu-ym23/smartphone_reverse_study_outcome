package com.bytedance.android.live.liveinteract.revenue.common.vieweffect;

import kotlin.jvm.internal.Intrinsics;
import nh0.m;

/* JADX INFO: loaded from: classes46.dex */
public final class c {
    public static final boolean a(m r100) {
        if (r100 == null) goto L17;
        String r101 = r100.h();
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        return true;
    L13:
        if (Intrinsics.areEqual(r100.h(), "undefined") == true) goto L19;
        return false;
    L19:
        return true;
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
        goto L11
    L17:
        return true;
    }
}
