package com.obric.oui.d;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.q;
import d.h.b.o;

/* JADX INFO: compiled from: StyleUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f35014a = null;

    static {
        f35014a = new e();
    }

    private e() {
    }

    public static final <T extends View> T a(Context r4, int r5, q<? super Context, ? super Integer, ? super Integer, ? extends T> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        q r8 = (q) ZeusTransformUtils.wrapperContextForParams(r6, q.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r8, "ofStyle");
        ContextThemeWrapper r0 = new ContextThemeWrapper(r7, r5);
        TypedArray r9 = r0.obtainStyledAttributes(null, new int[]{R.attr.layout_width, R.attr.layout_height}, 0, r5);
        o.c(r9, "contextThemeWrapper.obta…ll, attrs, 0, styleResId)");
        int r2 = r9.getLayoutDimension(0, -2);     // Catch: Throwable -> L6
        int r10 = r9.getLayoutDimension(1, -2);     // Catch: Throwable -> L6
        T r11 = (T) ZeusTransformUtils.preCheckCast(r8.invoke(r0, Integer.valueOf(r2), Integer.valueOf(r10)), View.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        r9.recycle();
        return r11;
    L6:
        th = move-exception;
        r9.recycle();
        throw th;
    }
}
