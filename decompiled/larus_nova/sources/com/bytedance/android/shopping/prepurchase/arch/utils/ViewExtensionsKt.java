package com.bytedance.android.shopping.prepurchase.arch.utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ViewExtensionsKt {
    public static final void a(final View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$removeParent");
        Function1<ViewGroup, Unit> r101 = new ViewExtensionsKt$removeParent$1(r100);
        ViewParent r102 = r100.getParent();
        if (r102 != null) goto L5;
        return;
    L5:
        if ((r102 instanceof ViewGroup) == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L12;
        r101.invoke((ViewGroup) r102);
        return;
    }
}
