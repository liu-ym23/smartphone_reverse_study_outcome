package com.android.contacts.common.util;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public class SchedulingUtils {
    public SchedulingUtils() {
    }

    public static void doAfterLayout(final View r1, final Runnable r2) {
        ViewTreeObserver.OnGlobalLayoutListener r0 = new AnonymousClass1(r1, r2);
        r1.getViewTreeObserver().addOnGlobalLayoutListener(r0);
    }

    public static void doOnPreDraw(final View r1, final boolean r2, final Runnable r3) {
        ViewTreeObserver.OnPreDrawListener r0 = new AnonymousClass2(r1, r3, r2);
        r1.getViewTreeObserver().addOnPreDrawListener(r0);
    }
}
