package com.bytedanceos.appstore.buss.utilities;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;
import com.bytedanceos.common.BaseApplication;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f8838a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f8839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f8840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f8841d;

    static {
        f8838a = new f();
    }

    public f() {
    }

    public final int a() {
        int r10 = f8840c;
        if (r10 != 0) goto L6;
        int r11 = BaseApplication.c().getResources().getDimensionPixelSize(R.dimen.tv_app_item_horizontal_width);
        f8840c = r11;
        return r11;
    L6:
        return r10;
    }

    public final int b() {
        int r10 = f8841d;
        if (r10 != 0) goto L6;
        int r11 = BaseApplication.c().getResources().getDimensionPixelSize(R.dimen.tv_app_item_padding_left);
        f8841d = r11;
        return r11;
    L6:
        return r10;
    }

    public final int c(Context r10) {
        return g(r10) - e();
    }

    public final int d(Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        Point r11 = new Point();
        Object r12 = r10.getSystemService("window");
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) r12).getDefaultDisplay().getSize(r11);
        return r11.y;
    }

    public final int e() {
        int r10 = f8839b;
        if (r10 != 0) goto L6;
        int r11 = BaseApplication.c().getResources().getDimensionPixelSize(R.dimen.tv_nav_width);
        f8839b = r11;
        return r11;
    L6:
        return r10;
    }

    public final int f(Context r10) {
        return c(r10) / a();
    }

    public final int g(Context r10) {
        Point r11 = new Point();
        if (r10 == null) goto L5;
        Object r12 = r10.getSystemService("window");
    L6:
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) r12).getDefaultDisplay().getSize(r11);
        return r11.x;
    L5:
        r12 = null;
        goto L6
    }
}
