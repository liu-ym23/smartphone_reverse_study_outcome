package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ThemeUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class w {
    private static final String TAG = "ThemeUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int[] f488a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int[] f489b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int[] f490c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int[] f491d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[] f492e = null;
    static final int[] f = null;
    static final int[] g = null;
    static final int[] h = null;
    private static final ThreadLocal<TypedValue> i = null;
    private static final int[] j = null;

    static {
        i = new ThreadLocal();
        f488a = new int[]{-16842910};
        f489b = new int[]{R.attr.state_focused};
        f490c = new int[]{R.attr.state_activated};
        f491d = new int[]{R.attr.state_pressed};
        f492e = new int[]{R.attr.state_checked};
        f = new int[]{R.attr.state_selected};
        g = new int[]{-16842919, -16842908};
        h = new int[0];
        j = new int[1];
    }

    public static int a(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        int[] r0 = j;
        r0[0] = r3;
        y r5 = y.a(r4, null, r0);
        int r6 = r5.b(0, 0);     // Catch: Throwable -> L6
        r5.b();
        return r6;
    L6:
        th = move-exception;
        r5.b();
        throw th;
    }

    public static ColorStateList b(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        int[] r0 = j;
        r0[0] = r3;
        y r5 = y.a(r4, null, r0);
        ColorStateList r6 = r5.e(0);     // Catch: Throwable -> L6
        r5.b();
        return r6;
    L6:
        th = move-exception;
        r5.b();
        throw th;
    }

    public static int c(Context r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        ColorStateList r0 = b(r6, r5);
        if (r0 != null) goto L5;
    L8:
        TypedValue r1 = a();
        r6.getTheme().resolveAttribute(R.attr.disabledAlpha, r1, true);
        return a(r6, r5, r1.getFloat());
    L5:
        if (r0.isStateful() == false) goto L8;
        return r0.getColorForState(f488a, r0.getDefaultColor());
    }

    private static TypedValue a() {
        ThreadLocal<TypedValue> r0 = i;
        TypedValue r1 = (TypedValue) ZeusTransformUtils.preCheckCast(r0.get(), TypedValue.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        TypedValue r2 = new TypedValue();
        r0.set(r2);
        return r2;
    L6:
        return r1;
    }

    static int a(Context r2, int r3, float r4) {
        int r5 = a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
        return androidx.core.graphics.e.b(r5, Math.round(Color.alpha(r5) * r4));
    }

    public static void a(View r3, Context r4) {
        TypedArray r5 = ((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(com.obric.aiagent.plugin.R.styleable.AppCompatTheme);
    L8:
        th = move-exception;
        r5.recycle();
        throw th;
    L4:
        if (r5.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.AppCompatTheme_windowActionBar, "styleable", "AppCompatTheme_windowActionBar")) == true) goto L6;
        a(TAG, "View " + r3.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");     // Catch: Throwable -> L8
    L6:
        r5.recycle();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
