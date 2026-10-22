package com.bytedanceos.common.toolbox;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$color;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;

/* JADX INFO: loaded from: classes2.dex */
public class StatusBarHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static StatusBarHelper f9981a;

    public interface OnStatusBarCallback {
        void changeBackground(int r10);

        void initStatusBar();
    }

    static {
        f9981a = new StatusBarHelper();
    }

    public StatusBarHelper() {
    }

    public static StatusBarHelper a() {
        return f9981a;
    }

    public int b() {
        return 1;
    }

    public int c() {
        int r10 = BaseApplication.c().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r10 > 0) goto L7;
        return 0;
    L7:
        return BaseApplication.c().getResources().getDimensionPixelSize(r10);
    }

    public int d(Context r10, Window r11, View r12, OnStatusBarCallback r13) {
        r11.addFlags(Integer.MIN_VALUE);
        int r14 = R$color.oui_bg_base_1;
        r11.setStatusBarColor(ContextCompat.b(r10, r14));
        r11.setNavigationBarColor(ContextCompat.b(r10, r14));
        r11.getDecorView().setSystemUiVisibility(8464);
        int r15 = b();
        f(r10, r11, r12, r15);
        if (r13 == null) goto L5;
        r13.initStatusBar();
    L5:
        return r15;
    }

    public int e(Context r10, Window r11, View r12, int r13, OnStatusBarCallback r14) {
        int r15 = b();
        if (r15 == r13) goto L7;
        f(r10, r11, r12, r15);
        if (r14 == null) goto L7;
        r14.changeBackground(r15);
    L7:
        return r15;
    }

    public void f(Context r10, Window r11, View r12, int r13) {
    }

    public void g(Context r10, Window r11, boolean r12) {
        ViewGroup r13 = (ViewGroup) r11.getDecorView();
        int r14 = R$id.decorview;
        View r15 = r13.findViewById(r14);
        if (r15 != null) goto L6;
        r15 = new View(r10);
        r15.setId(r14);
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(-1, c());
        r16.gravity = 48;
        r15.setLayoutParams(r16);
        r13.addView(r15);
    L6:
        if (b() != 0) goto L8;
        r15.setBackgroundColor(-16777216);
    L9:
        if (r12 == false) goto L11;
        int r17 = 0;
    L12:
        r15.setVisibility(r17);
        return;
    L11:
        r17 = 8;
        goto L12
    L8:
        r15.setBackgroundResource(R$drawable.status_bar_bg);
        goto L9
    }
}
