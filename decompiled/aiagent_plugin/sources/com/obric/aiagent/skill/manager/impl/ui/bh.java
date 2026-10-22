package com.obric.aiagent.skill.manager.impl.ui;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import com.obric.aiagent.plugin.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.sheet.v2.OSheet;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillGlassBars.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class bh {
    public static /* synthetic */ androidx.core.view.al lambda$jO6I7zx4_UjYlr3kytWdxlyMxIs(int r0, View r1, androidx.core.view.al r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ androidx.core.view.al lambda$x_6eGMEoPLM5WOyP4iLUm51KFWQ(int r0, int r1, int r2, int r3, int r4, View r5, androidx.core.view.al r6) {
        return a(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ androidx.core.view.al lambda$yU4oV4QskuO9l7QEKwqsXezRXpc(int r0, int r1, View r2, androidx.core.view.al r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void a(FragmentActivity r2, boolean r3, int r4, boolean r5, int r6, Object r7) {
        FragmentActivity r8 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r2, FragmentActivity.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r3 = true;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = ZeusTransformUtils.mapRes(R.color.oui_basic_bg_base_1, "color", "oui_basic_bg_base_1");
    L9:
        if ((r6 & 4) == 0) goto L11;
        r5 = true;
    L11:
        a(r8, r3, r4, r5);
    }

    public static final void a(FragmentActivity r6, boolean r7, int r8, boolean r9) {
        FragmentActivity r10 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r6, FragmentActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "<this>");
        int r11 = a(r10, r8);
        if ((ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r0 = true;
    L7:
        if (Build.VERSION.SDK_INT < 16) goto L14;
        int r3 = 1280;
        if (r0 == false) goto L11;
    L13:
        r10.getWindow().getDecorView().setSystemUiVisibility(r3);
        goto L14
    L11:
        if (Build.VERSION.SDK_INT < 23) goto L13;
        r3 = 9472;
    L14:
        r10.getWindow().getDecorView().setBackgroundColor(r11);
        if (Build.VERSION.SDK_INT < 21) goto L21;
        Window r4 = r10.getWindow();
        if (r9 == false) goto L19;
        r11 = 0;
    L19:
        r4.setStatusBarColor(r11);
    L21:
        if (Build.VERSION.SDK_INT < 29) goto L23;
        r10.getWindow().setStatusBarContrastEnforced(false);
        r10.getWindow().setNavigationBarContrastEnforced(r7);
    L23:
        androidx.core.view.ai.a(r10.getWindow(), false);
        androidx.core.view.ai.a(r10.getWindow(), r10.getWindow().getDecorView()).b(!r0);
        return;
    L5:
        r0 = false;
        goto L7
    }

    public static final void a(OSheet r5) {
        d.h.b.o.e(r5, "<this>");
        boolean r0 = !r5.isDarkTheme();
        r5.show();
        Window r6 = r5.getWindow();
        if (r6 == null) goto L25;
        int r3 = 0;
        if (Build.VERSION.SDK_INT < 28) goto L8;
        r6.setNavigationBarDividerColor(0);
    L8:
        if (Build.VERSION.SDK_INT < 29) goto L11;
        r6.setNavigationBarContrastEnforced(false);
    L11:
        if (Build.VERSION.SDK_INT < 30) goto L18;
        WindowInsetsController r7 = r6.getInsetsController();
        if (r7 == null) goto L26;
        if (r0 == false) goto L16;
        r3 = 16;
    L16:
        r7.setSystemBarsAppearance(r3, 16);
        return;
    L26:
        return;
    L18:
        if (Build.VERSION.SDK_INT < 26) goto L28;
        View r1 = r6.getDecorView();
        if (r0 == false) goto L22;
        int r8 = r6.getDecorView().getSystemUiVisibility() | 16;
    L23:
        r1.setSystemUiVisibility(r8);
        return;
    L22:
        r8 = r6.getDecorView().getSystemUiVisibility() & (-17);
        goto L23
    L28:
        return;
    }

    public static final void a(RecyclerView r9, final int r10) {
        d.h.b.o.e(r9, "<this>");
        if (Build.VERSION.SDK_INT >= 20) goto L5;
        return;
    L5:
        final int r3 = r9.getPaddingLeft();
        final int r4 = r9.getPaddingTop();
        final int r5 = r9.getPaddingRight();
        final int r6 = r9.getPaddingBottom();
        ViewCompat.a((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.aiagent.plugin"), new $$Lambda$bh$x_6eGMEoPLM5WOyP4iLUm51KFWQ(r3, r4, r5, r6, r10));
        ViewCompat.u((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.aiagent.plugin"));
    }

    private static final androidx.core.view.al a(int r1, int r2, int r3, int r4, int r5, View r6, androidx.core.view.al r7) {
        d.h.b.o.e(r6, "view");
        d.h.b.o.e(r7, "insets");
        r6.setPadding(r1, r2 + r7.a(androidx.core.view.al.m.a()).f1211c, r3, (r4 + a(r7)) + r5);
        return r7;
    }

    public static final void a(View r2) {
        d.h.b.o.e(r2, "<this>");
        final int r0 = r2.getPaddingBottom();
        ViewCompat.a(r2, new $$Lambda$bh$jO6I7zx4_UjYlr3kytWdxlyMxIs(r0));
        ViewCompat.u(r2);
    }

    private static final androidx.core.view.al a(int r4, View r5, androidx.core.view.al r6) {
        d.h.b.o.e(r5, "view");
        d.h.b.o.e(r6, "insets");
        r5.setPadding(r5.getPaddingLeft(), r5.getPaddingTop(), r5.getPaddingRight(), r4 + a(r6));
        return r6;
    }

    public static /* synthetic */ void a(View r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        a(r0, r1);
    }

    public static final void a(View r3, final int r4) {
        d.h.b.o.e(r3, "<this>");
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L9;
        final int r2 = r1.bottomMargin;
        ViewCompat.a(r3, new $$Lambda$bh$yU4oV4QskuO9l7QEKwqsXezRXpc(r2, r4));
        ViewCompat.u(r3);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private static final androidx.core.view.al a(int r3, int r4, View r5, androidx.core.view.al r6) {
        d.h.b.o.e(r5, "view");
        d.h.b.o.e(r6, "insets");
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != null) goto L8;
        return r6;
    L8:
        r1.bottomMargin = (r3 + a(r6)) + r4;
        r5.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return r6;
    L5:
        r1 = null;
        goto L6
    }

    public static final int a(androidx.core.view.al r2) {
        d.h.b.o.e(r2, "<this>");
        return Math.max(r2.a(androidx.core.view.al.m.b()).f1213e, r2.a(androidx.core.view.al.m.e()).f1213e);
    }

    private static final int a(FragmentActivity r3, int r4) {
        FragmentActivity r5 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L6;
        return ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getColor(r4, r5.getTheme());
    L6:
        return ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getColor(r4);
    }
}
