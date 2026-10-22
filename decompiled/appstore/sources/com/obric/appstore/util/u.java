package com.obric.appstore.util;

import android.app.Activity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowInsetsControllerCompat f11101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WindowInsetsCompat f11102b;

    public u(Activity r10) {
        kotlin.jvm.internal.q.g(r10, "activity");
        WindowInsetsControllerCompat r11 = androidx.core.view.t.a(r10.getWindow(), r10.getWindow().getDecorView());
        kotlin.jvm.internal.q.f(r11, "getInsetsController(...)");
        this.f11101a = r11;
        this.f11102b = ViewCompat.H(r10.getWindow().getDecorView());
    }
}
