package com.obric.oui.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: OUnitExtension.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g {
    public static final float a(float r2, float r3) {
        if (r2 != 0.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return 0.0f;
    L9:
        return r2 * r3;
    L5:
        r1 = false;
        goto L6
    }

    public static final int a(int r1, float r2) {
        if (r1 != 0) goto L6;
        return 0;
    L6:
        return (int) ((r1 * r2) + 0.5f);
    }

    public static final int a(boolean r0) {
        return r0 ? 1 : 0;
    }

    public static final int b(float r2, float r3) {
        if (r2 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0;
    L9:
        return (int) ((r2 * r3) + 0.5f);
    L5:
        r0 = false;
        goto L6
    }

    public static final int a(Context r2, float r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        return d.i.a.a(r3 / ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin").getDisplayMetrics().density);
    }

    public static final float a(float r1) {
        return r1 * Resources.getSystem().getDisplayMetrics().density;
    }

    public static final float a(float r2, Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        return r2 * ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin").getDisplayMetrics().density;
    }

    public static final int a(int r1) {
        return (int) ((r1 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static final int a(View r1, int r2) {
        o.e(r1, "<this>");
        if (r2 != 0) goto L6;
        return 0;
    L6:
        return a(r1, r2);
    }

    public static final int a(View r2, double r3) {
        o.e(r2, "<this>");
        if (r3 != 0.0d) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0;
    L9:
        return a(r2, (float) r3);
    L5:
        r0 = false;
        goto L6
    }

    public static final int a(View r2, float r3) {
        o.e(r2, "<this>");
        if (r3 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0;
    L9:
        return d.i.a.a(r3 * ZeusTransformUtils.getResources(r2, "com.obric.aiagent.plugin").getDisplayMetrics().density);
    L5:
        r0 = false;
        goto L6
    }

    public static final float b(View r1, int r2) {
        o.e(r1, "<this>");
        if (r2 != 0) goto L6;
        return 0.0f;
    L6:
        return b(r1, r2);
    }

    public static final float b(View r2, double r3) {
        o.e(r2, "<this>");
        if (r3 != 0.0d) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0.0f;
    L9:
        return b(r2, (float) r3);
    L5:
        r0 = false;
        goto L6
    }

    public static final float b(View r3, float r4) {
        o.e(r3, "<this>");
        if (r4 != 0.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return 0.0f;
    L9:
        return TypedValue.applyDimension(1, r4, ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin").getDisplayMetrics());
    L5:
        r1 = false;
        goto L6
    }

    public static final float c(View r2, float r3) {
        o.e(r2, "<this>");
        if (r3 != 0.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return 0.0f;
    L9:
        return TypedValue.applyDimension(2, r3, ZeusTransformUtils.getResources(r2, "com.obric.aiagent.plugin").getDisplayMetrics());
    L5:
        r1 = false;
        goto L6
    }

    public static final int a(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        if (r3 != 0) goto L6;
        return 0;
    L6:
        return b(r4, r3);
    }

    public static final int b(Context r3, float r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "<this>");
        if (r4 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0;
    L9:
        return d.i.a.a(r4 * ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getDisplayMetrics().density);
    L5:
        r0 = false;
        goto L6
    }

    public static final float b(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        if (r3 != 0) goto L6;
        return 0.0f;
    L6:
        return c(r4, r3);
    }

    public static final float a(Context r2, double r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        if (r3 != 0.0d) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0.0f;
    L9:
        return c(r4, (float) r3);
    L5:
        r0 = false;
        goto L6
    }

    public static final float c(Context r4, float r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "<this>");
        if (r5 != 0.0f) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return 0.0f;
    L9:
        return TypedValue.applyDimension(1, r5, ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getDisplayMetrics());
    L5:
        r2 = false;
        goto L6
    }

    public static final float d(Context r3, float r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "<this>");
        if (r4 != 0.0f) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return 0.0f;
    L9:
        return TypedValue.applyDimension(2, r4, ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getDisplayMetrics());
    L5:
        r2 = false;
        goto L6
    }

    public static final int a(Resources r1, int r2) {
        o.e(r1, "<this>");
        if (r2 != 0) goto L6;
        return 0;
    L6:
        return a(r1, r2);
    }

    public static final int a(Resources r2, float r3) {
        o.e(r2, "<this>");
        if (r3 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0;
    L9:
        return d.i.a.a(r3 * r2.getDisplayMetrics().density);
    L5:
        r0 = false;
        goto L6
    }

    public static final int a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "<this>");
        DisplayMetrics r4 = ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin").getDisplayMetrics();
        if (r4 != null) goto L6;
        return 0;
    L6:
        return r4.widthPixels;
    }

    public static final int b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "<this>");
        DisplayMetrics r4 = ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin").getDisplayMetrics();
        if (r4 != null) goto L6;
        return 0;
    L6:
        return r4.heightPixels;
    }

    public static final int c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        if (Build.VERSION.SDK_INT < 30) goto L17;
        WindowManager r0 = (WindowManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(WindowManager.class), WindowManager.class, "com.obric.aiagent.plugin");
        Integer r1 = null;
        if (r0 == null) goto L14;
        WindowMetrics r2 = r0.getCurrentWindowMetrics();
        if (r2 == null) goto L14;
        Rect r5 = r2.getBounds();
        if (r5 == null) goto L14;
        r1 = Integer.valueOf(r5.width());
    L14:
        if (r1 != null) goto L20;
        return a(r4);
    L20:
        return r1.intValue();
    L17:
        Object r6 = r4.getSystemService("window");
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager r7 = (WindowManager) ZeusTransformUtils.preCheckCast(r6, WindowManager.class, "com.obric.aiagent.plugin");
        DisplayMetrics r8 = new DisplayMetrics();
        r7.getDefaultDisplay().getRealMetrics(r8);
        return r8.widthPixels;
    }

    public static final int d(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        if (Build.VERSION.SDK_INT < 30) goto L17;
        WindowManager r0 = (WindowManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(WindowManager.class), WindowManager.class, "com.obric.aiagent.plugin");
        Integer r1 = null;
        if (r0 == null) goto L14;
        WindowMetrics r2 = r0.getCurrentWindowMetrics();
        if (r2 == null) goto L14;
        Rect r5 = r2.getBounds();
        if (r5 == null) goto L14;
        r1 = Integer.valueOf(r5.height());
    L14:
        if (r1 != null) goto L20;
        return b(r4);
    L20:
        return r1.intValue();
    L17:
        Object r6 = r4.getSystemService("window");
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager r7 = (WindowManager) ZeusTransformUtils.preCheckCast(r6, WindowManager.class, "com.obric.aiagent.plugin");
        DisplayMetrics r8 = new DisplayMetrics();
        r7.getDefaultDisplay().getRealMetrics(r8);
        return r8.heightPixels;
    }

    public static final int e(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "<this>");
        if (Build.VERSION.SDK_INT < 30) goto L31;
        WindowManager r0 = (WindowManager) ZeusTransformUtils.preCheckCast(r5.getSystemService(WindowManager.class), WindowManager.class, "com.obric.aiagent.plugin");
        Integer r1 = null;
        if (r0 != null) goto L7;
        WindowMetrics r2 = null;
    L8:
        if (r2 != null) goto L10;
    L9:
        Insets r3 = null;
    L14:
        if (r2 == null) goto L20;
        Rect r6 = r2.getBounds();
        if (r6 == null) goto L20;
        r1 = Integer.valueOf(r6.height());
    L20:
        if (r1 != null) goto L22;
        int r7 = b(r5);
    L23:
        int r8 = 0;
        if (r3 != null) goto L26;
        int r9 = 0;
    L27:
        if (r3 == null) goto L33;
        r8 = r3.bottom;
    L33:
        return (r7 - r9) - r8;
    L26:
        r9 = r3.top;
        goto L27
    L22:
        r7 = r1.intValue();
        goto L23
    L10:
        WindowInsets r10 = r2.getWindowInsets();
        if (r10 == null) goto L9;
        r3 = r10.getInsets(WindowInsets.Type.systemBars());
        goto L14
    L7:
        r2 = r0.getCurrentWindowMetrics();
        goto L8
    L31:
        Object r11 = r5.getSystemService("window");
        Objects.requireNonNull(r11, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager r12 = (WindowManager) ZeusTransformUtils.preCheckCast(r11, WindowManager.class, "com.obric.aiagent.plugin");
        DisplayMetrics r13 = new DisplayMetrics();
        r12.getDefaultDisplay().getMetrics(r13);
        return r13.heightPixels;
    }

    public static final int a(String r1) {
        o.e(r1, "<this>");
        return Color.parseColor(r1);
    }
}
