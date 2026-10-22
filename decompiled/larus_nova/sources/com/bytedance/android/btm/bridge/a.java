package com.bytedance.android.btm.bridge;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    public static final Activity getActivity(View r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r100.getClass().getName(), "com.android.internal.policy.DecorView") == true) goto L8;
        Context r101 = r100.getContext();
    L10:
        if (r101 == null) goto L18;
        if ((r101 instanceof Activity) == true) goto L14;
        if ((r101 instanceof ContextWrapper) == false) goto L18;
        r101 = ((ContextWrapper) r101).getBaseContext();
        goto L10
    L14:
        return (Activity) r101;
    L18:
        return null;
    L8:
        return getActivity(r100.findViewById(R.id.content));
    }
}
