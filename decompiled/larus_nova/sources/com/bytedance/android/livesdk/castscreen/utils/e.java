package com.bytedance.android.livesdk.castscreen.utils;

import com.bytedance.android.livesdk.castscreen.views.CastScreenViewModel;
import com.bytedance.live.datacontext.m;

/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public static final boolean a() {
        CastScreenViewModel.Companion.getClass();
        CastScreenViewModel r100 = CastScreenViewModel.a.a();
        if (r100 == null) goto L9;
        m<Boolean> r101 = r100.getCastScreenMode();
        if (r101 == null) goto L9;
        if (r101.getValue().booleanValue() != true) goto L9;
        return true;
    L9:
        return false;
    }
}
