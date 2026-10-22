package com.bytedanceos.appstore.buss.utilities;

import android.content.res.Resources;
import android.util.TypedValue;
import com.bytedanceos.common.BaseApplication;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {
    public static final int a(int r10) {
        return BaseApplication.c().getResources().getDimensionPixelSize(r10);
    }

    public static final int b(int r10) {
        return (int) TypedValue.applyDimension(1, r10, Resources.getSystem().getDisplayMetrics());
    }
}
