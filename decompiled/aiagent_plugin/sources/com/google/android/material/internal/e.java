package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.core.view.ai;
import androidx.core.view.am;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EdgeToEdgeUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static void a(Window r6, boolean r7, Integer r8, Integer r9) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return;
    L5:
        boolean r0 = false;
        if (r8 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r9 != null) goto L14;
    L15:
        r0 = true;
    L17:
        if (r2 == true) goto L19;
        if (r0 == true) goto L19;
    L24:
        ai.a(r6, !r7);
        int r1 = a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7);
        int r10 = b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7);
        r6.setStatusBarColor(r1);
        r6.setNavigationBarColor(r10);
        boolean r11 = a(r1, com.google.android.material.color.b.a(r8.intValue()));
        boolean r12 = a(r10, com.google.android.material.color.b.a(r9.intValue()));
        am r13 = ai.a(r6, r6.getDecorView());
        if (r13 == null) goto L28;
        r13.a(r11);
        r13.b(r12);
        return;
    L28:
        return;
    L19:
        int r3 = com.google.android.material.color.b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), R.attr.colorBackground, -16777216);
        if (r2 == false) goto L22;
        r8 = Integer.valueOf(r3);
    L22:
        if (r0 == false) goto L24;
        r9 = Integer.valueOf(r3);
        goto L24
    L14:
        if (r9.intValue() != 0) goto L17;
    L8:
        if (r8.intValue() == 0) goto L11;
        r2 = false;
        goto L12
    }

    private static int a(Context r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r5 == true) goto L5;
    L8:
        if (r5 == false) goto L12;
        return 0;
    L12:
        return com.google.android.material.color.b.a(r6, R.attr.statusBarColor, -16777216);
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L8;
        return androidx.core.graphics.e.b(com.google.android.material.color.b.a(r6, R.attr.statusBarColor, -16777216), 128);
    }

    private static int b(Context r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r5 == true) goto L5;
    L8:
        if (r5 == false) goto L12;
        return 0;
    L12:
        return com.google.android.material.color.b.a(r6, R.attr.navigationBarColor, -16777216);
    L5:
        if (Build.VERSION.SDK_INT >= 27) goto L8;
        return androidx.core.graphics.e.b(com.google.android.material.color.b.a(r6, R.attr.navigationBarColor, -16777216), 128);
    }

    private static boolean a(int r1, boolean r2) {
        if (com.google.android.material.color.b.a(r1) == true) goto L8;
        if (r1 != 0) goto L7;
        if (r2 == true) goto L8;
    L7:
        return false;
    L8:
        return true;
    }
}
