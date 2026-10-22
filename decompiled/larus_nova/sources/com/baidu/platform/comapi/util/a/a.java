package com.baidu.platform.comapi.util.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.vi.VIContext;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f33408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f33409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f33410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f33411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f33412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f33413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private double f33414g;

    public float a() {
        if (this.f33410c != (-1.0f)) goto L6;
        a(VIContext.getContext());
    L6:
        return this.f33410c;
    }

    public int b() {
        if (this.f33413f != (-1)) goto L6;
        a(VIContext.getContext());
    L6:
        return this.f33413f;
    }

    public int c() {
        if (this.f33409b != (-1)) goto L6;
        a(VIContext.getContext());
    L6:
        return this.f33409b;
    }

    public int d() {
        if (this.f33408a != (-1)) goto L6;
        a(VIContext.getContext());
    L6:
        return this.f33408a;
    }

    public a() {
        this.f33408a = -1;
        this.f33409b = -1;
        this.f33410c = -1.0f;
        this.f33411d = -1;
        this.f33412e = -1;
        this.f33413f = -1;
        this.f33414g = -1.0d;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_baidu_platform_comapi_util_a_a_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public void a(Context r100) {
        DisplayMetrics r101 = INVOKEVIRTUAL_com_baidu_platform_comapi_util_a_a_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources());
        int r102 = r101.widthPixels;
        this.f33408a = r102;
        int r103 = r101.heightPixels;
        this.f33409b = r103;
        if (r102 <= 0) goto L5;
        if (r103 <= 0) goto L5;
    L6:
        this.f33410c = r101.density;
        this.f33411d = (int) r101.xdpi;
        this.f33412e = (int) r101.ydpi;
        int r104 = r101.densityDpi;
        this.f33413f = r104;
        if (r104 >= 240) goto L10;
        this.f33413f = r104;
    L10:
        if (this.f33413f != 0) goto L12;
        this.f33413f = 160;
    L12:
        this.f33414g = ((double) this.f33413f) / 240.0d;
        return;
    L5:
        Display r105 = ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
        r101 = new DisplayMetrics();
        r105.getMetrics(r101);
        this.f33408a = r101.widthPixels;
        this.f33409b = r101.heightPixels;
        goto L6
    }
}
