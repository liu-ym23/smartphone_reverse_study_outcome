package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class k {
    public static final void a(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutGravity");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof FrameLayout.LayoutParams) == false) goto L6;
        ((FrameLayout.LayoutParams) r102).gravity = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void b(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutHeight");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L6;
        r102.height = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void c(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginBottom");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r102).bottomMargin = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void d(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginLeft");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r102).leftMargin = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void e(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutMarginRight");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r102).rightMargin = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void f(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$layoutWidth");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L6;
        r102.width = r101;
        r100.setLayoutParams(r102);
        return;
    }
}
