package com.google.android.material.f;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import androidx.core.graphics.i;
import com.google.android.material.g.b;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MotionUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static int a(Context r2, int r3, int r4) {
        return b.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4);
    }

    public static TimeInterpolator a(Context r2, int r3, TimeInterpolator r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        TimeInterpolator r6 = (TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r4, TimeInterpolator.class, "com.obric.aiagent.plugin");
        TypedValue r0 = new TypedValue();
        if (r5.getTheme().resolveAttribute(r3, r0, true) == true) goto L5;
        return r6;
    L5:
        if (r0.type != 3) goto L21;
        String r7 = String.valueOf(r0.string);
        if (a(r7, "cubic-bezier") == false) goto L15;
        String[] r8 = b(r7, "cubic-bezier").split(",");
        if (r8.length != 4) goto L13;
        return androidx.core.view.animation.a.a(a(r8, 0), a(r8, 1), a(r8, 2), a(r8, 3));
    L13:
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + r8.length);
    L15:
        if (a(r7, DownloadConstants.PATH_KEY) == false) goto L19;
        return androidx.core.view.animation.a.a(i.a(b(r7, DownloadConstants.PATH_KEY)));
    L19:
        throw new IllegalArgumentException("Invalid motion easing type: " + r7);
    L21:
        throw new IllegalArgumentException("Motion easing theme attribute must be a string");
    }

    private static boolean a(String r1, String r2) {
        if (r1.startsWith(r2 + "(") == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.endsWith(")") == false) goto L7;
        return true;
    }

    private static String b(String r1, String r2) {
        return r1.substring(r2.length() + 1, r1.length() - 1);
    }

    private static float a(String[] r2, int r3) {
        float r4 = Float.parseFloat(r2[r3]);
        if (r4 < 0.0f) goto L8;
        if (r4 > 1.0f) goto L8;
        return r4;
    L8:
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + r4);
    }
}
