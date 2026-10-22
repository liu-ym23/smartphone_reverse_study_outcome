package com.google.android.material.internal;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ContextUtils {
    public ContextUtils() {
    }

    @Nullable
    public static Activity getActivity(Context r10) {
    L3:
        if ((r10 instanceof ContextWrapper) == false) goto L9;
        if ((r10 instanceof Activity) == true) goto L7;
        r10 = ((ContextWrapper) r10).getBaseContext();
        goto L3
    L7:
        return (Activity) r10;
    L9:
        return null;
    }
}
