package com.bytedance.android.shopping.anchorv3.utils;

import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes12.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f165303a = 0;

    static {
    }

    public static void a(Window r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Build.VERSION.SDK_INT < 28) goto L9;
        WindowManager.LayoutParams r101 = r100.getAttributes();
        r101.layoutInDisplayCutoutMode = 1;
        r100.setAttributes(r101);
        return;
    }
}
