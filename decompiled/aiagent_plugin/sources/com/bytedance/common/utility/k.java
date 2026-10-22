package com.bytedance.common.utility;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: UIUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f6740a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f6741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f6742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f6743d;

    /* JADX INFO: compiled from: UIUtils.java */
    public static class a {
        public a() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 19) goto L5;
        boolean r0 = true;
    L6:
        f6740a = r0;
        f6742c = "";
        f6743d = -1;
        f6741b = new a();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static float a(Context r2, float r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return 0.0f;
    L5:
        return (r3 * ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin").getDisplayMetrics().density) + 0.5f;
    }

    public static int a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r4 = ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin").getDisplayMetrics();
        if (r4 != null) goto L9;
        return 0;
    L9:
        return r4.widthPixels;
    }

    public static int b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r4 = ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin").getDisplayMetrics();
        if (r4 != null) goto L9;
        return 0;
    L9:
        return r4.heightPixels;
    }

    public static String c(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (j.a(f6742c) == false) goto L10;
        if (r3 == null) goto L10;
        int r0 = a(r3);
        int r4 = b(r3);
        if (r0 <= 0) goto L10;
        if (r4 <= 0) goto L10;
        f6742c = r0 + "*" + r4;
    L10:
        return f6742c;
    }

    public static int d(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (f6743d != (-1)) goto L7;
        if (r4 == null) goto L7;
        f6743d = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().densityDpi;
    L7:
        return f6743d;
    }
}
