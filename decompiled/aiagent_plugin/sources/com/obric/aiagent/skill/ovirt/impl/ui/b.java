package com.obric.aiagent.skill.ovirt.impl.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.titlebar.floating.FloatingTransitionBridge;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: WrapperUiExt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static /* synthetic */ WindowInsets lambda$6bckY3CEFZWgLL5CJf2zYXkbTJQ(View r0, OFloatingTitleBar r1, View r2, WindowInsets r3) {
        return a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$I83qK-P1FalD3t6lId1uXzihyoA, reason: not valid java name */
    public static /* synthetic */ void m369lambda$I83qKP1FalD3t6lId1uXzihyoA(View r0, OFloatingTitleBar r1) {
        b(r0, r1);
    }

    public static final void a(AppCompatActivity r4) {
        AppCompatActivity r5 = (AppCompatActivity) ZeusTransformUtils.wrapperContextForParams(r4, AppCompatActivity.class, "com.obric.aiagent.plugin");
        o.e(r5, "<this>");
        int r0 = a(r5, ZeusTransformUtils.mapRes(R.color.oui_basic_bg_base_1, "color", "oui_basic_bg_base_1"));
        if (Build.VERSION.SDK_INT < 16) goto L11;
        int r1 = 1280;
        if (Build.VERSION.SDK_INT < 23) goto L8;
        r1 = 9472;
    L8:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        r1 = r1 | 16;
    L10:
        r5.getWindow().getDecorView().setSystemUiVisibility(r1);
    L11:
        r5.getWindow().getDecorView().setBackgroundColor(r0);
        if (Build.VERSION.SDK_INT < 21) goto L15;
        r5.getWindow().setStatusBarColor(0);
        r5.getWindow().setNavigationBarColor(r0);
    L15:
        if (Build.VERSION.SDK_INT < 29) goto L18;
        r5.getWindow().setStatusBarContrastEnforced(false);
        r5.getWindow().setNavigationBarContrastEnforced(false);
        return;
    }

    public static final void a(final View r4, final OFloatingTitleBar r5) {
        o.e(r4, "<this>");
        o.e(r5, "titleBar");
        int r0 = a(r5);
        r4.setPadding(r4.getPaddingLeft(), r0, r4.getPaddingRight(), r4.getPaddingBottom());
        r4.setOnApplyWindowInsetsListener(new $$Lambda$b$6bckY3CEFZWgLL5CJf2zYXkbTJQ(r4, r5));
    }

    private static final WindowInsets a(final View r1, final OFloatingTitleBar r2, View r3, WindowInsets r4) {
        o.e(r3, "<unused var>");
        o.e(r4, "insets");
        r1.post(new $$Lambda$b$I83qKP1FalD3t6lId1uXzihyoA(r1, r2));
        return r4;
    }

    private static final void b(View r3, OFloatingTitleBar r4) {
        int r5 = a(r4);
        r3.setPadding(r3.getPaddingLeft(), r5, r3.getPaddingRight(), r3.getPaddingBottom());
    }

    public static final void a(AppCompatActivity r8, OFloatingTitleBar r9, Intent r10) {
        AppCompatActivity r11 = (AppCompatActivity) ZeusTransformUtils.wrapperContextForParams(r8, AppCompatActivity.class, "com.obric.aiagent.plugin");
        o.e(r11, "<this>");
        o.e(r9, "titleBar");
        o.e(r10, MemorySourceLinkType.INTENT);
        ComponentName r0 = r10.getComponent();
        if (r0 == null) goto L5;
        String r1 = r0.getPackageName();
    L7:
        if (o.a(r1, r11.getPackageName()) == true) goto L9;
    L20:
        ZeusTransformUtils.startActivity(r11, r10, "com.obric.aiagent.plugin");
        return;
    L9:
        if ((r10.getFlags() & 268435456) != 0) goto L20;
        FloatingTransitionBridge.b.a(FloatingTransitionBridge.f36698a, (Activity) ZeusTransformUtils.preCheckCast(r11, Activity.class, "com.obric.aiagent.plugin"), r9, null, 4, null);
        ZeusTransformUtils.startActivity(r11, r10, "com.obric.aiagent.plugin");     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        FloatingTransitionBridge.f36698a.a();     // Catch: Exception -> L17
    L19:
        throw e;
    L17:
        e = move-exception;
        d.a.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L19
    L5:
        r1 = null;
        goto L7
    }

    private static final int a(OFloatingTitleBar r5) {
        View r0 = r5.findViewById(ZeusTransformUtils.mapRes(R.id.title_bar_container, DbHelper.COL_ID, "title_bar_container"));
        ViewGroup.MarginLayoutParams r1 = null;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
    L7:
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.MarginLayoutParams.class) == false) goto L9;
        r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L9:
        if (r1 == null) goto L11;
        int r3 = r1.topMargin;
    L12:
        if (r0 == null) goto L14;
        int r6 = r0.getMinimumHeight();
    L16:
        return r6 + r3;
    L14:
        r6 = ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_title_bar_mask_height, "dimen", "oui_title_bar_mask_height"));
        goto L16
    L11:
        r3 = 0;
        goto L12
    L5:
        r2 = null;
        goto L7
    }

    private static final int a(AppCompatActivity r3, int r4) {
        AppCompatActivity r5 = (AppCompatActivity) ZeusTransformUtils.wrapperContextForParams(r3, AppCompatActivity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L6;
        return ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getColor(r4, r5.getTheme());
    L6:
        return ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getColor(r4);
    }
}
