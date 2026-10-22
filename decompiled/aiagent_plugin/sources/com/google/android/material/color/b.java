package com.google.android.material.color;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MaterialColors.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static int a(View r0, int r1) {
        return com.google.android.material.g.b.a(r0, r1);
    }

    public static int a(Context r2, int r3, String r4) {
        return com.google.android.material.g.b.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4);
    }

    public static int a(View r2, int r3, int r4) {
        return a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3, r4);
    }

    public static int a(Context r2, int r3, int r4) {
        TypedValue r5 = com.google.android.material.g.b.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
        if (r5 != null) goto L5;
        return r4;
    L5:
        return r5.data;
    }

    public static int a(View r0, int r1, int r2, float r3) {
        return a(a(r0, r1), a(r0, r2), r3);
    }

    public static int a(int r1, int r2, float r3) {
        return a(r1, e.b(r2, Math.round(Color.alpha(r2) * r3)));
    }

    public static int a(int r0, int r1) {
        return e.a(r1, r0);
    }

    public static int b(int r1, int r2) {
        return e.b(r1, (Color.alpha(r1) * r2) / 255);
    }

    public static boolean a(int r4) {
        if (r4 != 0) goto L4;
    L6:
        return false;
    L4:
        if (e.a(r4) <= 0.5d) goto L6;
        return true;
    }
}
