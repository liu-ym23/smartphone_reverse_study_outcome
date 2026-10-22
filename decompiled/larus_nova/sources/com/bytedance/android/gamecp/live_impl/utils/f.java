package com.bytedance.android.gamecp.live_impl.utils;

import android.net.Uri;

/* JADX INFO: loaded from: classes44.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f58086a = 0;

    static {
    }

    public static void a(Uri.Builder r100, String r101, String r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        if (r102.length() <= 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 != true) goto L11;
        r100.appendQueryParameter(r101, r102);
        return;
    L11:
        return;
    L6:
        r103 = false;
        goto L7
    }
}
