package com.bytedance.android.live.pushstream;

import android.text.TextUtils;
import com.bytedance.android.live.performance.api.IPerfToolsService;
import com.bytedance.android.livesdk.s6;

/* JADX INFO: loaded from: classes47.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IPerfToolsService f89527a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static v f89528b;

    public v() {
    }

    static {
        f89527a = (IPerfToolsService) jc1.k.f(IPerfToolsService.class);
    }

    public static v b() {
        if (f89528b != null) goto L15;
        monitor-enter(v.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f89528b != null) goto L9;
        f89528b = new v();     // Catch: Throwable -> L11
    L9:
        monitor-exit(v.class);     // Catch: Throwable -> L11
    L15:
        return f89528b;
    }

    public static boolean a() {
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L5;
    L9:
        return false;
    L5:
        if (s6.f157860a.getValue().booleanValue() == false) goto L9;
        if (f89527a == null) goto L9;
        return true;
    }

    public final void c(String r100, String r101) {
        if (a() == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        f89527a.setData(r100, r101);
    }
}
