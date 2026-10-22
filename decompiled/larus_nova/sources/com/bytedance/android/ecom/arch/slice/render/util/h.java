package com.bytedance.android.ecom.arch.slice.render.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f50743a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f50744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f50745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f50746d;

    static {
        f50743a = new Handler(Looper.getMainLooper());
    }

    @JvmStatic
    public static final boolean b() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    @JvmStatic
    public static final void a(Function0<Unit> r100) {
        if (b() == false) goto L5;
        r100.invoke();
        return;
    L5:
        Handler r101 = f50743a;
        Object r102 = r100;
        if (r100 == null) goto L8;
        r102 = new g(r100);
    L8:
        r101.post((Runnable) r102);
    }

    @JvmStatic
    public static final void c(Function0<Unit> r100) {
        Handler r101 = f50743a;
        Object r102 = r100;
        if (r100 == null) goto L5;
        r102 = new g(r100);
    L5:
        r101.post((Runnable) r102);
    }

    @JvmStatic
    public static final Activity getActivity(Context r100) {
    L3:
        if ((r100 instanceof ContextWrapper) == false) goto L9;
        if ((r100 instanceof Activity) == true) goto L7;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L7:
        return (Activity) r100;
    L9:
        return null;
    }
}
