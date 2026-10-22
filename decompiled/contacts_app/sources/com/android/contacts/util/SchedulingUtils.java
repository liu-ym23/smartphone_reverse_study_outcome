package com.android.contacts.util;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes2.dex */
public class SchedulingUtils {
    public SchedulingUtils() {
    }

    public static void doAfterLayout(final View r1, final Runnable r2) {
        ViewTreeObserver.OnGlobalLayoutListener r0 = new AnonymousClass1(r1, r2);
        r1.getViewTreeObserver().addOnGlobalLayoutListener(r0);
    }

    public static void doAfterDraw(final View r1, final Runnable r2) {
        ViewTreeObserver.OnDrawListener r0 = new AnonymousClass2(r1, r2);
        r1.getViewTreeObserver().addOnDrawListener(r0);
    }
}
