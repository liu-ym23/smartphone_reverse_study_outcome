package com.bytedance.android.shopping.store.home.view;

import android.view.View;
import android.view.ViewParent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f184754a;

    public x(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f184754a = r100;
    }

    public static TopSheetLayout a(View r100) {
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        if ((r100 instanceof TopSheetLayout) == true) goto L7;
        ViewParent r102 = r100.getParent();
        if ((r102 instanceof View) == false) goto L13;
        r101 = r102;
    L13:
        return a((View) r101);
    L7:
        return (TopSheetLayout) r100;
    }
}
