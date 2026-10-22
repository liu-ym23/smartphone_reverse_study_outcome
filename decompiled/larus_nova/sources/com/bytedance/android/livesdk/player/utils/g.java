package com.bytedance.android.livesdk.player.utils;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f156217a = null;

    static {
        f156217a = new Handler(Looper.getMainLooper());
    }

    public static final int a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginBottom");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.bottomMargin;
    }

    public static final int b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginLeft");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.leftMargin;
    }

    public static final int c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginRight");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.rightMargin;
    }

    public static final int d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginTop");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.topMargin;
    }

    public static void e(long r100, boolean r101, boolean r102, Function0 r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r102 = false;
    L11:
        Intrinsics.checkNotNullParameter(r103, "action");
        if (r100 <= 0) goto L14;
        f156217a.postDelayed(new e(r103), r100);
        return;
    L14:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L17;
        if (r102 == true) goto L17;
        r103.invoke();
        return;
    L17:
        if (r101 == false) goto L19;
        f156217a.postAtTime(new e(r103), 2);
        return;
    L19:
        f156217a.post(new e(r103));
    }
}
