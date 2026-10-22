package com.bytedance.android.annie.param;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.util.t;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes43.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DisplayMetrics f39715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f39716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DisplayMetrics f39717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f39718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f39719e;

    public p(FragmentActivity r100) {
        com.bytedance.android.annie.util.p r101 = com.bytedance.android.annie.util.p.f40070a;
        if (r100 == null) goto L5;
        Resources r102 = r100.getResources();
        DisplayMetrics r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics());
    L6:
        if (r103 != null) goto L8;
        r103 = r101.b();
    L8:
        this.f39715a = r103;
        this.f39716b = -1;
        com.bytedance.android.annie.util.p.f();
        this.f39719e = r101.getResources().getConfiguration().orientation;
        if (r100 == null) goto L12;
        this.f39716b = r100.getRequestedOrientation();
        this.f39717c = com.bytedance.android.annie.util.p.c(r100);
        this.f39718d = t.f40076a.e(r100);
        return;
    L12:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
