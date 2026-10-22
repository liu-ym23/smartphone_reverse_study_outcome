package com.bytedance.bdinstall.j;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: UIUtils.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f6353a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f6354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f6355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f6356d;

    /* JADX INFO: compiled from: UIUtils.java */
    public static class a {
        public a() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 19) goto L5;
        boolean r0 = true;
    L6:
        f6353a = r0;
        f6355c = "";
        f6356d = -1;
        f6354b = new a();
        return;
    L5:
        r0 = false;
        goto L6
    }

    private static int c(Context r2) {
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

    private static int d(Context r2) {
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

    public static String a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(f6355c) == false) goto L10;
        if (r3 == null) goto L10;
        int r0 = c(r3);
        int r4 = d(r3);
        if (r0 <= 0) goto L10;
        if (r4 <= 0) goto L10;
        f6355c = r0 + "*" + r4;
    L10:
        return f6355c;
    }

    public static int b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (f6356d != (-1)) goto L7;
        if (r4 == null) goto L7;
        f6356d = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().densityDpi;
    L7:
        return f6356d;
    }
}
