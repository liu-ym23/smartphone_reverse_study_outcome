package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.config.lg;
import com.bytedance.android.livesdk.config.r11;

/* JADX INFO: loaded from: classes11.dex */
public final class k3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r11 f159041a = null;

    static {
        f159041a = lg.f120676a.getValue();
    }

    public static void a(boolean r100) {
        IHostAction r101 = (IHostAction) jc1.k.f(IHostAction.class);
        if (r101 == null) goto L6;
        r101.requestBlockJitCompile(r100);
        return;
    }
}
