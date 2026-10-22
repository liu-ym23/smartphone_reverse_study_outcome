package com.bytedance.android.live.liveinteract.api.utils;

import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;

/* JADX INFO: loaded from: classes46.dex */
public final class c {
    public static final boolean a() {
        if (vm2.d.q0().isOpenSmoothEnterRoom() == true) goto L5;
    L9:
        return false;
    L5:
        if (FoldScreenUtils.f() == true) goto L9;
        if (PadConfigUtils.a() == true) goto L9;
        return true;
    }
}
