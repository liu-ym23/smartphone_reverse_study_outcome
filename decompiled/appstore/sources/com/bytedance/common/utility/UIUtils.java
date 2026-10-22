package com.bytedance.common.utility;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes.dex */
public abstract class UIUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f6853a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f6854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f6855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f6856d;

    @Deprecated
    public interface ToastHook extends com.bytedance.android.standard.tools.ui.UIUtils$ToastHook {
        @Override // com.bytedance.android.standard.tools.ui.UIUtils$ToastHook
        boolean showToast(Context r10, int r11, CharSequence r12, long r13, int r14);
    }

    public static class a extends v0.a {
        public a() {
        }
    }

    static {
        f6853a = true;
        f6854b = "";
        f6855c = -1;
        f6856d = new a();
    }

    public static int a(Context r10) {
        if (f6855c != (-1)) goto L7;
        if (r10 == null) goto L7;
        f6855c = r10.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
    L7:
        return f6855c;
    }

    public static int b(Context r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r11 = r10.getResources().getDisplayMetrics();
        if (r11 != null) goto L9;
        return 0;
    L9:
        return r11.heightPixels;
    }

    public static String c(Context r10) {
        if (e.b(f6854b) == false) goto L10;
        if (r10 == null) goto L10;
        int r11 = d(r10);
        int r12 = b(r10);
        if (r11 <= 0) goto L10;
        if (r12 <= 0) goto L10;
        f6854b = r11 + "*" + r12;
    L10:
        return f6854b;
    }

    public static int d(Context r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r11 = r10.getResources().getDisplayMetrics();
        if (r11 != null) goto L9;
        return 0;
    L9:
        return r11.widthPixels;
    }
}
