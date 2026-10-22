package com.google.android.material.g;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.appcompat.widget.y;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MaterialResources.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static ColorStateList a(Context r2, TypedArray r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3.hasValue(r4) == false) goto L10;
        int r0 = r3.getResourceId(r4, 0);
        if (r0 == 0) goto L10;
        ColorStateList r6 = androidx.appcompat.a.a.a.a(r5, r0);
        if (r6 == null) goto L10;
        return r6;
    L10:
        if (Build.VERSION.SDK_INT > 15) goto L16;
        int r1 = r3.getColor(r4, -1);
        if (r1 == (-1)) goto L16;
        return ColorStateList.valueOf(r1);
    L16:
        return r3.getColorStateList(r4);
    }

    public static ColorStateList a(Context r2, y r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3.g(r4) == false) goto L10;
        int r0 = r3.g(r4, 0);
        if (r0 == 0) goto L10;
        ColorStateList r6 = androidx.appcompat.a.a.a.a(r5, r0);
        if (r6 == null) goto L10;
        return r6;
    L10:
        if (Build.VERSION.SDK_INT > 15) goto L16;
        int r1 = r3.b(r4, -1);
        if (r1 == (-1)) goto L16;
        return ColorStateList.valueOf(r1);
    L16:
        return r3.e(r4);
    }

    public static Drawable b(Context r2, TypedArray r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3.hasValue(r4) == false) goto L10;
        int r0 = r3.getResourceId(r4, 0);
        if (r0 == 0) goto L10;
        Drawable r6 = androidx.appcompat.a.a.a.b(r5, r0);
        if (r6 == null) goto L10;
        return r6;
    L10:
        return r3.getDrawable(r4);
    }

    public static d c(Context r2, TypedArray r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3.hasValue(r4) == false) goto L8;
        int r6 = r3.getResourceId(r4, 0);
        if (r6 != 0) goto L7;
        return null;
    L7:
        return new d(r5, r6);
    L8:
        return null;
    }

    public static int a(Context r3, TypedArray r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        TypedValue r0 = new TypedValue();
        if (r4.getValue(r5, r0) == false) goto L10;
        if (r0.type != 2) goto L10;
        TypedArray r8 = r7.getTheme().obtainStyledAttributes(new int[]{r0.data});
        int r9 = r8.getDimensionPixelSize(0, r6);
        r8.recycle();
        return r9;
    L10:
        return r4.getDimensionPixelSize(r5, r6);
    }

    public static boolean a(Context r2) {
        if (ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().fontScale < 1.3f) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean b(Context r2) {
        if (ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().fontScale < 2.0f) goto L5;
        return true;
    L5:
        return false;
    }

    public static int a(Context r5, int r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (r6 != 0) goto L5;
        return r7;
    L5:
        TypedArray r9 = r8.obtainStyledAttributes(r6, R.styleable.TextAppearance);
        TypedValue r0 = new TypedValue();
        boolean r2 = r9.getValue(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textSize, "styleable", "TextAppearance_android_textSize"), r0);
        r9.recycle();
        if (r2 == true) goto L9;
        return r7;
    L9:
        if (a(r0) != 2) goto L13;
        return Math.round(TypedValue.complexToFloat(r0.data) * ZeusTransformUtils.getResources(r8, "com.obric.aiagent.plugin").getDisplayMetrics().density);
    L13:
        return TypedValue.complexToDimensionPixelSize(r0.data, ZeusTransformUtils.getResources(r8, "com.obric.aiagent.plugin").getDisplayMetrics());
    }

    private static int a(TypedValue r2) {
        if (Build.VERSION.SDK_INT < 22) goto L7;
        return r2.getComplexUnit();
    L7:
        return (r2.data >> 0) & 15;
    }

    static int a(TypedArray r0, int r1, int r2) {
        if (r0.hasValue(r1) == false) goto L5;
        return r1;
    L5:
        return r2;
    }
}
