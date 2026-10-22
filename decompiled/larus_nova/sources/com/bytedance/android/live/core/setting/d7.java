package com.bytedance.android.live.core.setting;

import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d7 {
    public static void a(String r100, Throwable r101) {
        if (r101 != null) goto L6;
        r101 = new Throwable(r100);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        int r102 = d6.f65283a;
        Intrinsics.checkNotNullParameter("ensureNotReachHereTest", "tag");
        Intrinsics.checkNotNullParameter(th, LynxError.LYNX_THROWABLE);
        wa1.a r103 = wa1.d.f558803a;
        Intrinsics.checkNotNullParameter("ensureNotReachHereTest", "tag");
        Intrinsics.checkNotNullParameter(th, LynxError.LYNX_THROWABLE);
        wa1.a r104 = wa1.d.f558803a;
        if (r104 == null) goto L23;
        r104.e("ensureNotReachHereTest", "error occur!", th);
        return;
    L23:
        return;
    L6:
        if (LiveSettingConfig.LIVE_ENABLE_SETTING_MONITOR.getValue().booleanValue() == false) goto L10;
        String r105 = "[SettingGuard]".concat(r100);     // Catch: Throwable -> L14
        int r106 = d6.f65283a;     // Catch: Throwable -> L14
        wa1.a r107 = wa1.d.f558803a;     // Catch: Throwable -> L14
        if (r107 == null) goto L20;
        r107.ensureNotReachHere(r101, r105);     // Catch: Throwable -> L14
        return;
    L20:
        return;
    L10:
        int r108 = d6.f65283a;     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter("SettingGuard", "tag");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);     // Catch: Throwable -> L14
        wa1.a r109 = wa1.d.f558803a;     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter("SettingGuard", "tag");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);     // Catch: Throwable -> L14
        wa1.a r110 = wa1.d.f558803a;     // Catch: Throwable -> L14
        if (r110 == null) goto L22;
        r110.e("SettingGuard", r100, r101);     // Catch: Throwable -> L14
        return;
    }
}
