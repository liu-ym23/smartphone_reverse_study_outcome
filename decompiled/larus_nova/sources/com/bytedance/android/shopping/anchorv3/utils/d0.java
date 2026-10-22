package com.bytedance.android.shopping.anchorv3.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes12.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f165305a = null;

    public d0() {
    }

    static {
        f165305a = new d0();
    }

    public final Activity getActivity(View r100) {
        if (r100 == null) goto L5;
        Context r101 = r100.getContext();
    L6:
        if (r101 == null) goto L15;
        if ((r101 instanceof Activity) == true) goto L10;
        if ((r101 instanceof ContextWrapper) == false) goto L14;
        r101 = ((ContextWrapper) r101).getBaseContext();
        goto L6
    L14:
        Logger.w("ViewUtils", "find non-ContextWrapper in view: " + r101);
        goto L15
    L10:
        return (Activity) r101;
    L15:
        return null;
    L5:
        r101 = null;
        goto L6
    }

    public final Activity getActivity(Context r100) {
    L3:
        if (r100 == null) goto L12;
        if ((r100 instanceof Activity) == true) goto L7;
        if ((r100 instanceof ContextWrapper) == false) goto L11;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L11:
        Logger.w("ViewUtils", "find non-ContextWrapper in view: " + r100);
        goto L12
    L7:
        return (Activity) r100;
    L12:
        return null;
    }
}
