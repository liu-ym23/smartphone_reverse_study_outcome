package com.bytedance.android.gamecp.base.gamedetail;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes44.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0 f51681a = null;

    public y0() {
    }

    static {
        f51681a = new y0();
    }

    public final Context getContext() {
        return com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext();
    }

    public final int a(int r100) {
        Context r101 = getContext();
        if (r101 == null) goto L5;
        Resources r102 = r101.getResources();
    L6:
        if (r102 != null) goto L9;
        return 0;
    L9:
        return r101.getResources().getColor(r100);
    L5:
        r102 = null;
        goto L6
    }

    public final Drawable b(int r100) {
        Context r101 = getContext();
        if (r101 == null) goto L5;
        Resources r102 = r101.getResources();
    L6:
        if (r102 != null) goto L9;
        return null;
    L9:
        return r101.getResources().getDrawable(r100);
    L5:
        r102 = null;
        goto L6
    }
}
