package com.github.chrisbanes.photoview;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static void a(View r10, Runnable r11) {
        b(r10, r11);
    }

    public static void b(View r10, Runnable r11) {
        r10.postOnAnimation(r11);
    }
}
